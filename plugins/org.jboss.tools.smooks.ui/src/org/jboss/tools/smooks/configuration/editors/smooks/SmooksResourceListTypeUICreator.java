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
package org.jboss.tools.smooks.configuration.editors.smooks;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.jboss.tools.smooks.configuration.editors.AttributeFieldEditPart;
import org.jboss.tools.smooks.configuration.editors.PropertyUICreator;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.model.smooks.SmooksPackage;

/**
 * @author Dart Peng (dpeng@redhat.com) Date Apr 10, 2009
 */
public class SmooksResourceListTypeUICreator extends PropertyUICreator {

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
			ISmooksModelProvider formEditor,IEditorPart part) {
		if (feature == SmooksPackage.eINSTANCE.getSmooksResourceListType_AbstractReaderGroup()) {
		}
		if (feature == SmooksPackage.eINSTANCE.getSmooksResourceListType_AbstractResourceConfigGroup()) {
		}

		if (feature == SmooksPackage.eINSTANCE.getSmooksResourceListType_DefaultSelectorNamespace()) {
		}
		if (feature == SmooksPackage.eINSTANCE.getSmooksResourceListType_DefaultTargetProfile()) {
		}

		return super.createPropertyUI(toolkit, parent, propertyDescriptor, model, feature, formEditor,part);
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
	public List<AttributeFieldEditPart> createExtendUIOnTop(AdapterFactoryEditingDomain editingdomain, FormToolkit toolkit,
			Composite parent, Object model, ISmooksModelProvider formEditor,IEditorPart part) {

		return createElementSelectionSection(Messages.SmooksResourceListTypeUICreator_DefualtSelectorLabel, editingdomain, toolkit, parent, model, formEditor,part,
				SmooksPackage.eINSTANCE.getSmooksResourceListType_DefaultSelector(), SmooksPackage.eINSTANCE
						.getSmooksResourceListType_DefaultSelectorNamespace());
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
		if (feature == SmooksPackage.eINSTANCE.getSmooksResourceListType_DefaultSelector()) {
			return true;
		}
		if (feature == SmooksPackage.eINSTANCE.getSmooksResourceListType_DefaultSelectorNamespace()) {
			return true;
		}
		return super.ignoreProperty(feature);
	}

	@Override
	public boolean isSelectorFeature(EAttribute attribute) {
		return super.isSelectorFeature(attribute);
	}

	@Override
	protected boolean isConditionSelectionFeature(EAttribute feature) {
		if (feature == SmooksPackage.eINSTANCE.getSmooksResourceListType_DefaultConditionRef()) {
			return true;
		}
		return super.isConditionSelectionFeature(feature);
	}

}