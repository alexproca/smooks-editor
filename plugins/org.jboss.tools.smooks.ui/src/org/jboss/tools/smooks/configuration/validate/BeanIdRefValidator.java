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
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.model.smooks.DocumentRoot;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class BeanIdRefValidator extends AbstractValidator {

	private List<String> idList = new ArrayList<String>();

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.validate.AbstractValidator#
	 * preStartValidation()
	 */
	@Override
	protected void preStartValidation() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.configuration.validate.AbstractValidator#validate
	 * (java.util.Collection, org.eclipse.emf.edit.domain.EditingDomain)
	 */
	@Override
	public List<Diagnostic> validate(Collection<?> selectedObjects, EditingDomain editingDomain) {
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
		String idRef = null;
		EStructuralFeature beanIDRefFeature = null;
		if (model instanceof EObject) {
			beanIDRefFeature = SmooksUIUtils.getBeanIDRefFeature((EObject) model);
			if (beanIDRefFeature != null) {
				Object data = ((EObject) model).eGet(beanIDRefFeature);
				if (data != null) {
					idRef = data.toString();
				}
			}
		}

		if (idRef != null) {
			if (!idList.contains(idRef) && beanIDRefFeature != null && beanIDRefFeature instanceof EAttribute) {
				return newWaringDiagnostic(Messages.BeanIdRefValidator_Warning_Java_Bean + idRef + Messages.BeanIdRefValidator_Warning_Does_Not_Exist, model,
						(EAttribute) beanIDRefFeature);
			}
		}

//		if (model instanceof WiringType) {
//			String idRef = ((WiringType) model).getBeanIdRef();
//			if (!idList.contains(idRef)) {
//				return newWaringDiagnostic("Reference BeanId '" + idRef + "' dosen't exist.", model,
//						JavabeanPackage.Literals.WIRING_TYPE__BEAN_ID_REF);
//			}
//		}
//
//		if (model instanceof JmsRouter) {
//			String idRef = ((JmsRouter) model).getBeanId();
//			if (!idList.contains(idRef)) {
//				return newWaringDiagnostic("Reference BeanId '" + idRef + "' dosen't exist.", model,
//						JmsroutingPackage.Literals.JMS_ROUTER__BEAN_ID);
//			}
//		}
		return super.validateModel(model, editingDomain);
	}

	public void initValidator(Collection<?> selectedObjects, EditingDomain editingDomain) {
		idList.clear();
		Resource resource = editingDomain.getResourceSet().getResources().get(0);
		Object obj = resource.getContents().get(0);
		if (obj instanceof DocumentRoot) {
			SmooksResourceListType listType = ((DocumentRoot) obj).getSmooksResourceList();
			List<String> ids = SmooksUIUtils.getBeanIdStringList(listType);
			if (ids != null) {
				idList.addAll(ids);
			}
		}
		if (idList.isEmpty()) {
			// return
		}
	}

}
