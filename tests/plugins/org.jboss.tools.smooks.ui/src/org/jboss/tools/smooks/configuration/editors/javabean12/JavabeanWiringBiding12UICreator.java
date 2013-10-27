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
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.jboss.tools.smooks.configuration.editors.AttributeFieldEditPart;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.model.javabean12.BeanType;
import org.jboss.tools.smooks.model.javabean12.Javabean12Package;

/**
 * @author Dart Peng (dpeng@redhat.com) Date Apr 9, 2009
 */
public class JavabeanWiringBiding12UICreator extends PropertiesAndSetterMethodSearchFieldEditorCreator {

	@Override
	protected boolean canCreatePropertiesSearchFieldEditor(EAttribute feature) {
		// if (feature == JavabeanPackage.eINSTANCE.getWiringType_Property()) {
		// return true;
		// }
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.javabean.
	 * PropertiesAndSetterMethodSearchFieldEditorCreator
	 * #getClassString(java.lang.Object)
	 */
	protected String getClassString(Object model) {
		if (model instanceof EObject) {
			EObject container = ((EObject) model).eContainer();
			if (container instanceof BeanType) {
				return ((BeanType) container).getClass_();
			}
		}
		return super.getClassString(model);
	}

	@Override
	protected boolean canCreateMethodsSearchFieldEditor(EAttribute feature) {
		// if (feature ==
		// JavabeanPackage.eINSTANCE.getWiringType_SetterMethod()) {
		// return true;
		// }
		return super.canCreateMethodsSearchFieldEditor(feature);
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
		if (feature == Javabean12Package.eINSTANCE.getWiringType_WireOnElement()) {
			return true;
		}
		if (feature == Javabean12Package.eINSTANCE.getWiringType_WireOnElementNS()) {
			return true;
		}
		if (feature == Javabean12Package.eINSTANCE.getWiringType_Property()) {
			return true;
		}
		if (feature == Javabean12Package.eINSTANCE.getWiringType_SetterMethod()) {
			return true;
		}
		return super.ignoreProperty(feature);
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

		List<AttributeFieldEditPart> list = new ArrayList<AttributeFieldEditPart>();

		AttributeFieldEditPart pEditPart = createPropertiesSearchFieldEditor(toolkit, parent, getPropertyDescriptor(
				editingdomain, Javabean12Package.eINSTANCE.getWiringType_Property(), model), model);
		AttributeFieldEditPart mEditPart = createMethodsSearchFieldEditor(toolkit, parent, getPropertyDescriptor(
				editingdomain, Javabean12Package.eINSTANCE.getWiringType_SetterMethod(), model), model);
		list.add(pEditPart);
		list.add(mEditPart);
//		list.addAll(createElementSelectionSection(Messages.JavabeanWiringBiding12UICreator_WiringOnGroupText, editingdomain, toolkit, parent, model, formEditor,
//				part, Javabean12Package.eINSTANCE.getWiringType_WireOnElement(),
//				Javabean12Package.Literals.WIRING_TYPE__WIRE_ON_ELEMENT_NS));
		return list;
	}

	@Override
	public boolean isBeanIDRefFieldFeature(EAttribute attribute) {
		if (attribute == Javabean12Package.eINSTANCE.getWiringType_BeanIdRef()) {
			return true;
		}
		return super.isBeanIDRefFieldFeature(attribute);
	}

	@Override
	public boolean isSelectorFeature(EAttribute attribute) {
		return super.isSelectorFeature(attribute);
	}

	@Override
	public AttributeFieldEditPart createPropertyUI(FormToolkit toolkit, Composite parent,
			IItemPropertyDescriptor propertyDescriptor, Object model, EAttribute feature,
			ISmooksModelProvider formEditor, IEditorPart part) {
		return super.createPropertyUI(toolkit, parent, propertyDescriptor, model, feature, formEditor, part);
	}
}
