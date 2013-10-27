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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.jboss.tools.smooks.configuration.editors.AttributeFieldEditPart;
import org.jboss.tools.smooks.configuration.editors.PropertyUICreator;
import org.jboss.tools.smooks.configuration.editors.uitls.FieldAssistDisposer;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.model.smooks.SmooksPackage;

/**
 * @author Dart Peng (dpeng@redhat.com) Date Apr 10, 2009
 */
public class ConditionTypeUICreator extends PropertyUICreator {

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
			ISmooksModelProvider modelProvider,IEditorPart part) {
		if (feature == SmooksPackage.eINSTANCE.getConditionType_Value()) {
		}
		if (feature == SmooksPackage.eINSTANCE.getConditionType_Evaluator()) {
			return SmooksUIUtils.createJavaTypeSearchFieldEditor(parent, toolkit, propertyDescriptor, (EObject) model , modelProvider);
		}
		if (feature == SmooksPackage.eINSTANCE.getConditionType_Id()) {
		}
		if (feature == SmooksPackage.eINSTANCE.getConditionType_IdRef()) {
		}

		return super.createPropertyUI(toolkit, parent, propertyDescriptor, model, feature, modelProvider,part);
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
			FormToolkit toolkit, Composite parent, Object model, ISmooksModelProvider formEditor,IEditorPart part) {
		List<AttributeFieldEditPart> list = new ArrayList<AttributeFieldEditPart>();
		AttributeFieldEditPart cdatatext = SmooksUIUtils.createCDATAFieldEditor(Messages.ConditionTypeUICreator_InlineConditionLabel, editingdomain,
				toolkit, parent, model, null,true);
		Control c = cdatatext.getContentControl();
		
		if(c instanceof Text){
			final FieldAssistDisposer disposer = SmooksUIUtils.addBindingsContextAssistToText((Text)c, SmooksUIUtils.getSmooks11ResourceListType((EObject)model));
			c.addDisposeListener(new DisposeListener(){

				/* (non-Javadoc)
				 * @see org.eclipse.swt.events.DisposeListener#widgetDisposed(org.eclipse.swt.events.DisposeEvent)
				 */
				public void widgetDisposed(DisposeEvent e) {
					disposer.dispose();
				}
				
			});
		}
		list.add(cdatatext);
		return list;
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
		if (feature == SmooksPackage.eINSTANCE.getConditionType_Value()) {
			return true;
		}
		if (feature == SmooksPackage.eINSTANCE.getConditionType_Evaluator()) {
			return true;
		}
		if (feature == SmooksPackage.eINSTANCE.getConditionType_Id()) {
			return true;
		}
		return super.ignoreProperty(feature);
	}

}