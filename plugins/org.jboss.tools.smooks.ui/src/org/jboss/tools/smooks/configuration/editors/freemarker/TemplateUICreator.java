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
package org.jboss.tools.smooks.configuration.editors.freemarker;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.jboss.tools.smooks.configuration.SmooksConstants;
import org.jboss.tools.smooks.configuration.actions.OpenEditorEditInnerContentsAction;
import org.jboss.tools.smooks.configuration.editors.AttributeFieldEditPart;
import org.jboss.tools.smooks.configuration.editors.PropertyUICreator;
import org.jboss.tools.smooks.configuration.editors.uitls.FieldAssistDisposer;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.configuration.editors.uitls.TextTypeSwicher;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.model.freemarker.FreemarkerPackage;

/**
 * @author Dart Peng (dpeng@redhat.com) Date Apr 10, 2009
 */
public class TemplateUICreator extends PropertyUICreator {
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
		if (feature == FreemarkerPackage.eINSTANCE.getTemplate_Value()) {
		}
		return super.createPropertyUI(toolkit, parent, propertyDescriptor, model, feature, formEditor, part);
	}

	@Override
	public List<AttributeFieldEditPart> createExtendUIOnBottom(AdapterFactoryEditingDomain editingdomain,
			FormToolkit toolkit, Composite parent, Object model, ISmooksModelProvider formEditor, IEditorPart part) {
		List<AttributeFieldEditPart> list = new ArrayList<AttributeFieldEditPart>();

		String version = formEditor.getPlatformVersion();

		OpenEditorEditInnerContentsAction openCDATAEditorAction = new OpenEditorEditInnerContentsAction(editingdomain,
				(AnyType) model, SmooksUIUtils.VALUE_TYPE_CDATA, "flt"); //$NON-NLS-1$
		// OpenEditorEditInnerContentsAction openCommentEditorAction = new
		// OpenEditorEditInnerContentsAction(editingdomain,(AnyType) model,
		// SmooksUIUtils.VALUE_TYPE_COMMENT, "flt");

		TextTypeSwicher swicher = new TextTypeSwicher();
		swicher.createSwicherGUI(Messages.TemplateUICreator_External_Template_File, Messages.TemplateUICreator_Inline_Template, parent, toolkit);

//		if (SmooksConstants.VERSION_1_1.equals(version)) {
//
//			AttributeFieldEditPart cdatatext = SmooksUIUtils.createCDATAFieldEditor("Inline Template", editingdomain,
//					toolkit, parent, model, openCDATAEditorAction, true);
//			Control c = cdatatext.getContentControl();
//
//			if (c instanceof Text) {
//				final FieldAssistDisposer disposer = SmooksUIUtils.addBindingsContextAssistToText((Text) c,
//						SmooksUIUtils.getSmooks11ResourceListType((EObject) model));
//				c.addDisposeListener(new DisposeListener() {
//
//					/*
//					 * (non-Javadoc)
//					 * 
//					 * @see
//					 * org.eclipse.swt.events.DisposeListener#widgetDisposed(org
//					 * .eclipse.swt.events.DisposeEvent)
//					 */
//					public void widgetDisposed(DisposeEvent e) {
//						disposer.dispose();
//					}
//
//				});
//			}
//			list.add(cdatatext);
//			openCDATAEditorAction.setRelateText((Text) cdatatext.getContentControl());
//			
//			AttributeFieldEditPart textFieldEditPart = SmooksUIUtils.createFileSelectionTextFieldEditor(
//					"External Template File", parent, editingdomain, toolkit, null, model, SmooksUIUtils.VALUE_TYPE_TEXT,
//					null, null);
//			
//			swicher.hookSwicher(textFieldEditPart, cdatatext, editingdomain, model , SmooksUIUtils.VALUE_TYPE_CDATA);
//			
//			list.add(textFieldEditPart);
//		}
		if (SmooksConstants.VERSION_1_2.equals(version)) {

			AttributeFieldEditPart cdatatext = SmooksUIUtils.createCommentFieldEditor(Messages.TemplateUICreator_Inline_Template, editingdomain,
					toolkit, parent, model, openCDATAEditorAction, true);
			Control c = cdatatext.getContentControl();

			if (c instanceof Text) {
				final FieldAssistDisposer disposer = SmooksUIUtils.addBindingsContextAssistToText((Text) c,
						SmooksUIUtils.getSmooks11ResourceListType((EObject) model));
				c.addDisposeListener(new DisposeListener() {

					/*
					 * (non-Javadoc)
					 * 
					 * @see
					 * org.eclipse.swt.events.DisposeListener#widgetDisposed(org
					 * .eclipse.swt.events.DisposeEvent)
					 */
					public void widgetDisposed(DisposeEvent e) {
						disposer.dispose();
					}

				});
			}
			list.add(cdatatext);
			openCDATAEditorAction.setRelateText((Text) cdatatext.getContentControl());
			
			AttributeFieldEditPart textFieldEditPart = SmooksUIUtils.createFileSelectionTextFieldEditor(
					Messages.TemplateUICreator_External_Template_File, parent, editingdomain, toolkit, null, model, SmooksUIUtils.VALUE_TYPE_TEXT,
					null, null);
			
			swicher.hookSwicher(textFieldEditPart, cdatatext, editingdomain, model , SmooksUIUtils.VALUE_TYPE_COMMENT);
			
			list.add(textFieldEditPart);
		}		

		list.add(SmooksUIUtils.createStringFieldEditor(parent, toolkit, getPropertyDescriptor(editingdomain,
				FreemarkerPackage.eINSTANCE.getTemplate_Encoding(), model), model, false, false, null));
		return list;
	}

	@Override
	public boolean ignoreProperty(EAttribute feature) {
		if (feature == FreemarkerPackage.eINSTANCE.getTemplate_Value()) {
			return true;
		}
		if (feature == FreemarkerPackage.eINSTANCE.getTemplate_Encoding()) {
			return true;
		}

		return super.ignoreProperty(feature);
	}

	public Text getText() {
		// TODO Auto-generated method stub
		return null;
	}

}