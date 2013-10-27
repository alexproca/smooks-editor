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
package org.jboss.tools.smooks.configuration.editors.javabean12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.jboss.tools.smooks.configuration.editors.AttributeFieldEditPart;
import org.jboss.tools.smooks.configuration.editors.PropertyUICreator;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.model.javabean12.BeanType;
import org.jboss.tools.smooks.model.javabean12.Javabean12Factory;
import org.jboss.tools.smooks.model.javabean12.Javabean12Package;
import org.jboss.tools.smooks.model.javabean12.ValueType;
import org.jboss.tools.smooks.model.javabean12.WiringType;

/**
 * @author Dart (dpeng@redhat.com)
 *         <p>
 *         Apr 8, 2009
 */
public class JavaBean12PropertyUICreator extends PropertyUICreator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.configuration.editors.IPropertyUICreator#canCreate
	 * (org.eclipse.emf.edit.provider.IItemPropertyDescriptor, java.lang.Object,
	 * org.eclipse.emf.ecore.EAttribute)
	 */
	public boolean canCreate(IItemPropertyDescriptor itemPropertyDescriptor, Object model, EAttribute feature) {
		if (feature == Javabean12Package.eINSTANCE.getBeanType_Class()) {
			return true;
		}
		return false;
	}
	
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.configuration.editors.PropertyUICreator#ignoreProperty
	 * (org.eclipse.emf.ecore.EAttribute)
	 */
	@Override
	public boolean ignoreProperty(EAttribute feature) {
		if (feature == Javabean12Package.eINSTANCE.getBeanType_CreateOnElement()) {
			return true;
		}
		if (feature == Javabean12Package.eINSTANCE.getBeanType_CreateOnElementNS()) {
			return true;
		}
		return super.ignoreProperty(feature);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.IPropertyUICreator#
	 * createPropertyUI(org.eclipse.ui.forms.widgets.FormToolkit,
	 * org.eclipse.swt.widgets.Composite,
	 * org.eclipse.emf.edit.provider.IItemPropertyDescriptor, java.lang.Object,
	 * org.eclipse.emf.ecore.EAttribute)
	 */
	public AttributeFieldEditPart createPropertyUI(FormToolkit toolkit, Composite parent,
			IItemPropertyDescriptor propertyDescriptor, Object model, EAttribute feature,
			ISmooksModelProvider formEditor, IEditorPart part) {
		if (feature == Javabean12Package.eINSTANCE.getBeanType_Class()) {
			return createBeanClassTextWithButton(parent, toolkit, propertyDescriptor, model , formEditor);
		}
		return super.createPropertyUI(toolkit, parent, propertyDescriptor, model, feature, formEditor, part);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.configuration.editors.PropertyUICreator#createExtendUI
	 * (org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain,
	 * org.eclipse.ui.forms.widgets.FormToolkit,
	 * org.eclipse.swt.widgets.Composite, java.lang.Object,
	 * org.jboss.tools.smooks.configuration.editors.SmooksMultiFormEditor)
	 */
	@Override
	public List<AttributeFieldEditPart> createExtendUIOnTop(AdapterFactoryEditingDomain editingdomain,
			FormToolkit toolkit, Composite parent, Object model, ISmooksModelProvider formEditor, IEditorPart part) {
		return super.createExtendUIOnTop(editingdomain, toolkit, parent, model, formEditor, part);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.PropertyUICreator#
	 * createExtendUIOnBottom
	 * (org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain,
	 * org.eclipse.ui.forms.widgets.FormToolkit,
	 * org.eclipse.swt.widgets.Composite, java.lang.Object,
	 * org.jboss.tools.smooks.configuration.editors.SmooksMultiFormEditor)
	 */
	@Override
	public List<AttributeFieldEditPart> createExtendUIOnBottom(AdapterFactoryEditingDomain editingdomain,
			FormToolkit toolkit, Composite parent, Object model, ISmooksModelProvider formEditor, IEditorPart part) {
		List<AttributeFieldEditPart> lists = super.createExtendUIOnBottom(editingdomain, toolkit, parent, model,
				formEditor, part);

		Composite separator = toolkit.createCompositeSeparator(parent);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.heightHint = 1;
		gd.horizontalSpan = 2;
		separator.setLayoutData(gd);

		Hyperlink link = toolkit.createHyperlink(parent, "Add Binding", SWT.NONE); //$NON-NLS-1$
		link.setEnabled(false);
		link.setVisible(false);
		final Composite fp = parent;
		final BeanType fb = (BeanType) model;
		final IEditorPart ff = part;
		link.addHyperlinkListener(new IHyperlinkListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.ui.forms.events.IHyperlinkListener#linkActivated(
			 * org.eclipse.ui.forms.events.HyperlinkEvent)
			 */
			public void linkActivated(HyperlinkEvent e) {
				addValueWiringAuto(fp, fb, ff);
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.ui.forms.events.IHyperlinkListener#linkEntered(org
			 * .eclipse.ui.forms.events.HyperlinkEvent)
			 */
			public void linkEntered(HyperlinkEvent e) {
				// TODO Auto-generated method stub

			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.ui.forms.events.IHyperlinkListener#linkExited(org
			 * .eclipse.ui.forms.events.HyperlinkEvent)
			 */
			public void linkExited(HyperlinkEvent e) {
				// TODO Auto-generated method stub

			}

		});
		gd = new GridData();
		gd.horizontalSpan = 2;
		link.setLayoutData(gd);

		return lists;
	}

	private void addValueWiringAuto(Composite parent, BeanType bindings, IEditorPart formEditor) {
		boolean haveClassValue = false;
		if (bindings.eIsSet(Javabean12Package.Literals.BEAN_TYPE__CLASS)) {
			haveClassValue = true;
		}
		if (!haveClassValue) {
			MessageDialog.openError(parent.getShell(), Messages.JavaBean12PropertyUICreator_ErrorDialogTitle, Messages.JavaBean12PropertyUICreator_CantGetClassValueErrorMessage);
			return;
		}
		String className = bindings.getClass_();
		if (className == null || className.length() == 0) {
			MessageDialog.openError(parent.getShell(), Messages.JavaBean12PropertyUICreator_ErrorDialogTitle, Messages.JavaBean12PropertyUICreator_ClassValueEmptyErrorMessage);
			return;
		}
		try {
			Class<?> clazz = SmooksUIUtils.loadClass(className, ((IFileEditorInput) formEditor.getEditorInput())
					.getFile());
			JavaBeanModel beanModel = JavaBeanModelFactory.getJavaBeanModelWithLazyLoad(clazz);
			if (beanModel != null) {
				String[] ignores = findoutIgnoreProperty(bindings);
				ValueWiringBindingSelectionDialog dialog = new ValueWiringBindingSelectionDialog(parent.getShell(),
						beanModel, ignores);
				if (dialog.open() == Dialog.OK) {
					Object[] checkedModels = dialog.getCheckedObject();
					if (checkedModels == null)
						return;
					if (formEditor instanceof IEditingDomainProvider) {
						generateValueWiringModel(checkedModels, (IEditingDomainProvider)formEditor, bindings);
					}
				}
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void generateValueWiringModel(Object[] models, IEditingDomainProvider editor, BeanType owner) {
		EditingDomain domain = editor.getEditingDomain();
		CompoundCommand command = new CompoundCommand();
		command.setDescription("Add Binding"); //$NON-NLS-1$
		command.setLabel("Auto add binding"); //$NON-NLS-1$
		for (int i = 0; i < models.length; i++) {
			Object model = models[i];
			if (model instanceof JavaBeanModel) {
				Command c = generateAddCommand((JavaBeanModel) model, domain, owner);
				command.append(c);
			}
		}
		domain.getCommandStack().execute(command);
	}

	private Command generateAddCommand(JavaBeanModel beanModel, EditingDomain domain, BeanType owner) {
		if (beanModel.isPrimitive()) {
			ValueType valueType = Javabean12Factory.eINSTANCE.createValueType();
			valueType.setProperty(beanModel.getName());
			return AddCommand.create(domain, owner, Javabean12Package.Literals.BEAN_TYPE__VALUE, valueType);
		} else {
			WiringType wiring = Javabean12Factory.eINSTANCE.createWiringType();
			wiring.setProperty(beanModel.getName());
			return AddCommand.create(domain, owner, Javabean12Package.Literals.BEAN_TYPE__WIRING, wiring);
		}
	}

	private String[] findoutIgnoreProperty(BeanType bindings) {
		List<String> ignores = new ArrayList<String>();
		List<ValueType> valueList = bindings.getValue();

		for (Iterator<?> iterator = valueList.iterator(); iterator.hasNext();) {
			ValueType valueType = (ValueType) iterator.next();
			// boolean unset =
			// valueType.eIsSet(JavabeanPackage.Literals.VALUE_TYPE__PROPERTY);
			// if(unset) continue;
			String pro = valueType.getProperty();
			if (pro != null && pro.length() != 0) {
				ignores.add(pro);
			}
		}
		List<WiringType> wiringList = bindings.getWiring();
		for (Iterator<?> iterator = wiringList.iterator(); iterator.hasNext();) {
			WiringType wiringType = (WiringType) iterator.next();
			// boolean unset =
			// wiringType.eIsSet(JavabeanPackage.Literals.WIRING_TYPE__PROPERTY);
			// if(unset) continue;
			String pro = wiringType.getProperty();
			if (pro != null && pro.length() != 0) {
				ignores.add(pro);
			}
		}
		if (ignores.isEmpty())
			return null;
		return ignores.toArray(new String[] {});

	}

	@Override
	public boolean isSelectorFeature(EAttribute attribute) {
		return super.isSelectorFeature(attribute);
	}

	protected AttributeFieldEditPart createBeanClassTextWithButton(Composite composite, FormToolkit toolkit,
			final IItemPropertyDescriptor propertyDescriptor, final Object model , ISmooksModelProvider provider) {
		return SmooksUIUtils.createJavaTypeSearchFieldEditor(composite, toolkit, propertyDescriptor, (EObject) model , provider);
	}
}
