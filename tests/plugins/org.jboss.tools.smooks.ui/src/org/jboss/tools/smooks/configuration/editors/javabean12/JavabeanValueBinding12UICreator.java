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
 * @author Dart (dpeng@redhat.com)
 *         <p>
 *         Apr 9, 2009
 */
public class JavabeanValueBinding12UICreator extends PropertiesAndSetterMethodSearchFieldEditorCreator {

	@Override
	protected boolean canCreatePropertiesSearchFieldEditor(EAttribute feature) {
		if (feature == Javabean12Package.eINSTANCE.getValueType_Property()) {
			return true;
		}
		return false;
	}

	@Override
	protected boolean canCreateMethodsSearchFieldEditor(EAttribute feature) {
		if (feature == Javabean12Package.eINSTANCE.getValueType_SetterMethod()) {
			return true;
		}
		return super.canCreateMethodsSearchFieldEditor(feature);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.javabean.
	 * PropertiesAndSetterMethodSearchFieldEditorCreator
	 * #createPropertyUI(org.eclipse.ui.forms.widgets.FormToolkit,
	 * org.eclipse.swt.widgets.Composite,
	 * org.eclipse.emf.edit.provider.IItemPropertyDescriptor, java.lang.Object,
	 * org.eclipse.emf.ecore.EAttribute,
	 * org.jboss.tools.smooks.configuration.editors.SmooksMultiFormEditor)
	 */
	@Override
	public AttributeFieldEditPart createPropertyUI(FormToolkit toolkit, Composite parent,
			IItemPropertyDescriptor propertyDescriptor, Object model, EAttribute feature,
			ISmooksModelProvider formEditor, IEditorPart part) {
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
	public List<AttributeFieldEditPart> createExtendUIOnBottom(AdapterFactoryEditingDomain editingdomain,
			FormToolkit toolkit, Composite parent, Object model, ISmooksModelProvider formEditor, IEditorPart part) {
//		List<AttributeFieldEditPart> list = createElementSelectionSection(Messages.JavabeanValueBinding12UICreator_DataGroupText, editingdomain, toolkit, parent,
//				model, formEditor, part, Javabean12Package.eINSTANCE.getValueType_Data(), Javabean12Package.eINSTANCE
//						.getValueType_DataNS());
//		Composite groupParent = parent;
//		for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
//			AttributeFieldEditPart attributeFieldEditPart = (AttributeFieldEditPart) iterator.next();
//			if (attributeFieldEditPart.getAttribute() == null) {
//				groupParent = (Composite) attributeFieldEditPart.getContentControl();
//				break;
//			}
//		}
//		list.add(SmooksUIUtils.createStringFieldEditor(groupParent, toolkit, getPropertyDescriptor(editingdomain,
//				Javabean12Package.Literals.VALUE_TYPE__DEFAULT, model), model, false, false, null));
//
////		list.add(SmooksUIUtils.createStringFieldEditor(groupParent, toolkit, getPropertyDescriptor(editingdomain,
////				Javabean12Package.Literals.VALUE_TYPE__DECODER, model), model, false, false, null));
//		return list;
		return super.createExtendUIOnBottom(editingdomain, toolkit, parent, model, formEditor, part);
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
		if (feature == Javabean12Package.eINSTANCE.getValueType_Data()) {
			return true;
		}
		if (feature == Javabean12Package.eINSTANCE.getValueType_DataNS()) {
			return true;
		}
		if (feature == Javabean12Package.eINSTANCE.getValueType_Decoder()) {
			return true;
		}
		if (feature == Javabean12Package.eINSTANCE.getValueType_Default()) {
			return true;
		}
		return super.ignoreProperty(feature);
	}

	@Override
	public boolean isSelectorFeature(EAttribute attribute) {
		return super.isSelectorFeature(attribute);
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
}
