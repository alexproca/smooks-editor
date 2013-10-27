/*******************************************************************************
 * Copyright (c) 2009 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.smooks.configuration.validate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.swt.widgets.Display;
import org.eclipse.wst.validation.AbstractValidator;
import org.eclipse.wst.validation.ValidationResult;
import org.eclipse.wst.validation.ValidationState;
import org.eclipse.wst.validation.internal.provisional.core.IReporter;
import org.eclipse.wst.validation.internal.provisional.core.IValidationContext;
import org.eclipse.wst.validation.internal.provisional.core.IValidator;
import org.jboss.tools.smooks.model.common.provider.CommonItemProviderAdapterFactory;
import org.jboss.tools.smooks.model.freemarker.provider.FreemarkerItemProviderAdapterFactory;
import org.jboss.tools.smooks.model.medi.provider.MEdiItemProviderAdapterFactory;
import org.jboss.tools.smooks.model.smooks.provider.SmooksItemProviderAdapterFactory;
import org.jboss.tools.smooks.model.smooks.util.SmooksResourceFactoryImpl;

/**
 * @author Dart (dpeng@redhat.com)
 *         <p>
 *         Apr 14, 2009
 */
public class SmooksModelValidator extends AbstractValidator implements IValidator, ISmooksValidator {

	Collection<?> selectedObjects;
	EditingDomain domain;
	private boolean starting = false;
	private boolean waiting = false;
	private Object lock = new Object();
	private AdapterFactoryEditingDomain innerEditingDomain;

	private SmooksMarkerHelper markerHelper = new SmooksMarkerHelper();

	private long watingTime = 300;

	private List<ISmooksModelValidateListener> listeners = new ArrayList<ISmooksModelValidateListener>();

	private List<ISmooksValidator> validatorList = new ArrayList<ISmooksValidator>();
	private ComposedAdapterFactory adapterFactory;

	public SmooksModelValidator(Collection<?> selectedObjects, EditingDomain domain) {
		this();
		this.selectedObjects = selectedObjects;
		this.domain = domain;
	}

	public SmooksModelValidator() {
		validatorList.add(new ClassFieldEditorValidator());
		validatorList.add(new DuplicatedBeanIDValidator());
		validatorList.add(new BeanIdRefValidator());
		validatorList.add(new SelectorValidator());
		validatorList.add(new PropertyValidator());
		validatorList.add(new SetterMethodValidator());
//		validatorList.add(new DecoderTypeValidator());
		innerEditingDomain = newEditingDomain();
	}

	public void addValidateListener(ISmooksModelValidateListener l) {
		if (!listeners.contains(l))
			listeners.add(l);
	}

	public void removeValidateListener(ISmooksModelValidateListener l) {
		listeners.remove(l);
	}

	public List<Diagnostic> validate(Collection<?> selectedObjects, EditingDomain editingDomain) {
		this.selectedObjects = selectedObjects;
		domain = editingDomain;
		return validate(new NullProgressMonitor());
	}

	public List<Diagnostic> validate(Collection<?> selectedObjects, EditingDomain editingDomain,
			IProgressMonitor monitor) {
		this.selectedObjects = selectedObjects;
		domain = editingDomain;
		return validate(monitor);
	}

	public List<Diagnostic> validate(final IProgressMonitor progressMonitor) {
		EObject eObject = (EObject) selectedObjects.iterator().next();
		int count = 0;
		for (Iterator<?> i = eObject.eAllContents(); i.hasNext(); i.next()) {
			++count;
		}

		progressMonitor.beginTask("", count); //$NON-NLS-1$

		final AdapterFactory adapterFactory = domain instanceof AdapterFactoryEditingDomain ? ((AdapterFactoryEditingDomain) domain)
				.getAdapterFactory()
				: null;

		Diagnostician diagnostician = new Diagnostician() {
			@Override
			public String getObjectLabel(EObject eObject) {
				if (adapterFactory != null && !eObject.eIsProxy()) {
					IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory.adapt(eObject,
							IItemLabelProvider.class);
					if (itemLabelProvider != null) {
						return itemLabelProvider.getText(eObject);
					}
				}

				return super.getObjectLabel(eObject);
			}

			@Override
			public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
					Map<Object, Object> context) {
				progressMonitor.worked(1);
				return super.validate(eClass, eObject, diagnostics, context);
			}
		};

		progressMonitor.setTaskName(Messages.SmooksModelValidator_Task_Validating);

		Diagnostic diagnostic = diagnostician.validate(eObject);

		List<Diagnostic> list = new ArrayList<Diagnostic>();
		list.add(diagnostic);
		try {
			for (Iterator<?> iterator = this.validatorList.iterator(); iterator.hasNext();) {
				ISmooksValidator validator = (ISmooksValidator) iterator.next();
				validator.initValidator(selectedObjects, domain);
				List<Diagnostic> d = validator.validate(selectedObjects, domain);
				if (d != null) {
					for (Iterator<?> iterator2 = d.iterator(); iterator2.hasNext();) {
						Diagnostic diagnostic2 = (Diagnostic) iterator2.next();
						((BasicDiagnostic) diagnostic).add(diagnostic2);
					}
				}
			}
		} catch (Exception e) {

		}
		return list;
	}

	public void startValidate(final Collection<?> selectedObjects, final EditingDomain editingDomain) {
		if (starting) {
			synchronized (lock) {
				waiting = true;
			}
			return;
		}
		Thread thread = new Thread() {
			public void run() {
				synchronized (lock) {
					starting = true;
					waiting = true;
				}
				while (waiting) {
					try {
						waiting = false;
						Thread.sleep(watingTime);
						Thread.yield();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					for (Iterator<?> iterator = listeners.iterator(); iterator.hasNext();) {
						final ISmooksModelValidateListener l = (ISmooksModelValidateListener) iterator.next();
						Display.getDefault().syncExec(new Runnable() {

							/*
							 * (non-Javadoc)
							 * 
							 * @see java.lang.Runnable#run()
							 */
							public void run() {
								l.validateStart();
							}

						});

					}

					final List<Diagnostic> d = validate(selectedObjects, editingDomain);

					for (Iterator<?> iterator = listeners.iterator(); iterator.hasNext();) {
						final ISmooksModelValidateListener l = (ISmooksModelValidateListener) iterator.next();
						Display dis = Display.getDefault();
						if (dis != null && !dis.isDisposed()) {
							dis.syncExec(new Runnable() {

								/*
								 * (non-Javadoc)
								 * 
								 * @see java.lang.Runnable#run()
								 */
								public void run() {
									l.validateEnd(d);
								}

							});
						}
					}
				} finally {
					waiting = false;
					starting = false;
				}
			}
		};
		thread.setName(Messages.SmooksModelValidator_Task_Validating_Smooks_Model);
		thread.start();
	}

	private AdapterFactoryEditingDomain newEditingDomain() {
		BasicCommandStack commandStack = new BasicCommandStack();
		if (innerEditingDomain == null) {
			innerEditingDomain = new AdapterFactoryEditingDomain(getAdapterFactory(), commandStack,
					new HashMap<Resource, Boolean>());
		}
		return innerEditingDomain;
	}

	public ComposedAdapterFactory getAdapterFactory() {
		if (adapterFactory == null) {
			adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

			adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new FreemarkerItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new CommonItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new SmooksItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new MEdiItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		}
		return adapterFactory;
	}

	@Override
	public ValidationResult validate(IResource resource, int kind, ValidationState state, IProgressMonitor monitor) {
		AdapterFactoryEditingDomain editingDomain = newEditingDomain();
		if (editingDomain == null)
			return null;
		Object smooksModel = null;
		Resource smooksResource = new SmooksResourceFactoryImpl().createResource(URI.createPlatformResourceURI(resource
				.getFullPath().toPortableString(), false));
		editingDomain.getResourceSet().getResources().add(smooksResource);
		try {
			smooksResource.load(Collections.emptyMap());
			smooksModel = smooksResource.getContents().get(0);
		} catch (IOException e) {
			return null;
		}
		if (smooksModel == null) {
			return null;
		}
		List<Object> list = new ArrayList<Object>();
		list.add(smooksModel);

		final List<Diagnostic> d = this.validate(list, editingDomain, monitor);
		try {
			markerHelper.deleteMarkers(smooksResource);
			for (Iterator<?> iterator = d.iterator(); iterator.hasNext();) {
				Diagnostic diagnostic = (Diagnostic) iterator.next();
				if (resource != null && diagnostic.getSeverity() != Diagnostic.OK) {
					for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
						markerHelper.createMarkers(smooksResource, childDiagnostic);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void cleanup(IReporter reporter) {

	}

	public void validate(IValidationContext helper, IReporter reporter) {
	}

	public void initValidator(Collection<?> selectedObjects, EditingDomain editingDomain) {
		// TODO Auto-generated method stub

	}
}
