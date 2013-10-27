/*******************************************************************************
 * Copyright (c) 2008 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.smooks.configuration.validate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.jboss.tools.smooks.configuration.SmooksConfigurationActivator;
import org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject;
import org.jboss.tools.smooks.configuration.editors.SelectorCreationDialog;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.model.javabean12.BeanType;
import org.jboss.tools.smooks.model.smooks.DocumentRoot;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class SelectorValidator extends AbstractValidator {

	private List<Object> list = new ArrayList<Object>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.configuration.validate.AbstractValidator#validate
	 * (java.util.Collection, org.eclipse.emf.edit.domain.EditingDomain)
	 */
	@Override
	public List<Diagnostic> validate(Collection<?> selectedObjects,
			EditingDomain editingDomain) {
		return super.validate(selectedObjects, editingDomain);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.configuration.validate.AbstractValidator#validateModel
	 * (java.lang.Object, org.eclipse.emf.edit.domain.EditingDomain)
	 */
	@Override
	protected Diagnostic validateModel(Object model, EditingDomain editingDomain) {
		if (model instanceof EObject) {
			EStructuralFeature feature = getAttribute(model);
			if (feature == null)
				return null;
			Object data = ((EObject) model).eGet(feature);
			if (data == null) {
				if (feature instanceof EAttribute) {
					if (model instanceof BeanType) {
						return newWaringDiagnostic(
								Messages.SelectorValidator_Warning_Must_Be_Linked_to_Source, model,
								(EAttribute) feature);
					}
				}
				return null;
			}
			String path = data.toString();
			if (path != null)
				path = path.trim();
			// if (path == null) {
			// return null;
			// }
			// if(feature != null && path == null){
			// return newWaringDiagnostic("Selector '" +path+
			// "' isn't available",
			// model, feature);
			// }
			String sperator = "/"; //$NON-NLS-1$
			if (path.indexOf('/') == -1) {
				sperator = " "; //$NON-NLS-1$
			}
			if (path == null || path.length() == 0) {
				if (feature instanceof EAttribute) {
					if (model instanceof BeanType) {
						return newWaringDiagnostic(
								Messages.SelectorValidator_Warning_Must_Be_Linked_to_Source, model,
								(EAttribute) feature);
					}
				}
			}
			if (feature != null && path != null) {
				if ("#document".equals(path)) { //$NON-NLS-1$
					return null;
				}
				Object node = null;
				for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
					Object obj = (Object) iterator.next();
					if (obj instanceof IXMLStructuredObject) {
						if (node == null) {
							try {
								node = SmooksUIUtils.localXMLNodeWithPath(path,
										(IXMLStructuredObject) obj, sperator,
										false);
							} catch (Throwable e) {
								SmooksConfigurationActivator.getDefault()
										.log(e);
							}
						}
						if (node != null) {
							return null;
						}
					}
				}
				if (node == null && feature instanceof EAttribute) {
					if (model instanceof BeanType
							|| model instanceof org.jboss.tools.smooks.model.javabean12.ValueType
							|| model instanceof org.jboss.tools.smooks.model.javabean12.WiringType
							|| model instanceof org.jboss.tools.smooks.model.javabean12.ExpressionType) {
						return newWaringDiagnostic(
								Messages.SelectorValidator_Warning_Cannot_Find_Input_Source + path
										+ "'", model, (EAttribute) feature); //$NON-NLS-1$
					}
					return newWaringDiagnostic(Messages.SelectorValidator_Warning_Selector + path
							+ Messages.SelectorValidator_Warning_Is_Not_Available, model, (EAttribute) feature);
				}
			}
		}
		return super.validateModel(model, editingDomain);
	}

	private EStructuralFeature getAttribute(Object model) {
		return SmooksUIUtils.getSelectorFeature((EObject) model);
	}

	public void initValidator(Collection<?> selectedObjects,
			EditingDomain editingDomain) {
		list.clear();
		Resource resource = editingDomain.getResourceSet().getResources()
				.get(0);
		if (resource.getContents().isEmpty()) {
			return;
		}
		Object obj = resource.getContents().get(0);
		SmooksResourceListType listType = null;
		if (obj instanceof DocumentRoot) {
			listType = ((DocumentRoot) obj).getSmooksResourceList();
			IResource r = SmooksUIUtils.getResource(listType);
			IFile file = null;
			if (r instanceof IFile) {
				file = (IFile) r;
			}
			if (file == null)
				return;
			IContentType contentType = null;
			try {
				IContentDescription contentDescription = file
						.getContentDescription();
				if (contentDescription != null) {
					contentType = contentDescription.getContentType();
				}

			} catch (Throwable t) {

			}
			IContentType smooksContentType = Platform.getContentTypeManager()
					.getContentType(
							"org.jboss.tools.smooks.ui.smooks.contentType"); //$NON-NLS-1$
			IContentType ediMappingContentType = Platform
					.getContentTypeManager().getContentType(
							"org.jboss.tools.smooks.ui.edimap.contentType"); //$NON-NLS-1$

			if (!(smooksContentType.equals(contentType) || ediMappingContentType
					.equals(contentType))) {
				return;
			}

			// final FileEditorInput input = new FileEditorInput(file);
			final SmooksResourceListType finalList = listType;
			Display dis = SmooksConfigurationActivator.getDefault()
					.getWorkbench().getDisplay();
			if (dis != null && !dis.isDisposed()) {
				dis.syncExec(new Runnable() {

					/*
					 * (non-Javadoc)
					 * 
					 * @see java.lang.Runnable#run()
					 */
					public void run() {
						IWorkbenchWindow window = SmooksConfigurationActivator
								.getDefault().getWorkbench()
								.getActiveWorkbenchWindow();
						IWorkbenchPage activePage = window.getActivePage();
						if (activePage != null) {
							try {
								// IEditorPart part =
								// activePage.findEditor(input);
								// if (part != null && part instanceof
								// AbstractSmooksFormEditor) {
								List<Object> l = SelectorCreationDialog
										.generateInputData(finalList);
								if (l != null) {
									list.addAll(l);
								}
								// }
							} catch (Throwable t) {
								t.printStackTrace();
							}
						}
					}

				});
			}

		}
	}

}
