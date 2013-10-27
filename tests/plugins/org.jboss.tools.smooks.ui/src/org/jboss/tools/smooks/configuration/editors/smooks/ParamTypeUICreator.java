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
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.jboss.tools.smooks.configuration.editors.AttributeFieldEditPart;
import org.jboss.tools.smooks.configuration.editors.PropertyUICreator;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.configuration.editors.uitls.TextTypeSwicher;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.model.smooks.SmooksPackage;

/**
 * @author Dart Peng (dpeng@redhat.com) Date Apr 10, 2009
 */
public class ParamTypeUICreator extends PropertyUICreator {

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
		if (feature == SmooksPackage.eINSTANCE.getParamType_Name()) {
		}
		if (feature == SmooksPackage.eINSTANCE.getParamType_Type()) {
		}
		return super.createPropertyUI(toolkit, parent, propertyDescriptor, model, feature, formEditor, part);
	}

	@Override
	public List<AttributeFieldEditPart> createExtendUIOnBottom(AdapterFactoryEditingDomain editingdomain,
			FormToolkit toolkit, Composite parent, Object model, ISmooksModelProvider formEditor, IEditorPart part) {
		List<AttributeFieldEditPart> list = new ArrayList<AttributeFieldEditPart>();
		TextTypeSwicher swicher = new TextTypeSwicher();
		swicher.createSwicherGUI("Text Value", "CDATA Value", parent, toolkit); //$NON-NLS-1$ //$NON-NLS-2$
		// GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		// gd.horizontalSpan = 2;
		// gd.heightHint = 2;
		// toolkit.createCompositeSeparator(parent).setLayoutData(gd);
		//
		// final Button textButton = toolkit.createButton(parent, "Text Value",
		// SWT.RADIO);
		// final Button cdataButton = toolkit.createButton(parent,
		// "CDATA Value", SWT.RADIO);
		// String cdata = SmooksModelUtils.getAnyTypeCDATA((AnyType) model);
		// String text = SmooksModelUtils.getAnyTypeText((AnyType) model);

		final AttributeFieldEditPart tp = SmooksUIUtils.createMixedTextFieldEditor("Text Value", editingdomain, //$NON-NLS-1$
				toolkit, parent, model, false, 500, false, false, null, null);
		final AttributeFieldEditPart cp = SmooksUIUtils.createCDATAFieldEditor("CDATA Value", editingdomain, toolkit, //$NON-NLS-1$
				parent, model, null);
		list.add(tp);
		list.add(cp);
		swicher.hookSwicher(tp, cp, editingdomain, model , SmooksUIUtils.VALUE_TYPE_CDATA);

		// textButton.setSelection(true);
		// cdataButton.setSelection(false);
		// if ((cdata == null || cdata.length() == 0) && (text == null ||
		// text.length() == 0)) {
		// textButton.setSelection(true);
		// cdataButton.setSelection(false);
		// } else {
		// if ((text == null || text.length() == 0)) {
		// textButton.setSelection(false);
		// cdataButton.setSelection(true);
		// }
		// }
		// tp.getContentControl().setEnabled(textButton.getSelection());
		// cp.getContentControl().setEnabled(cdataButton.getSelection());
		// final AnyType fm = (AnyType) model;
		// final AdapterFactoryEditingDomain fd = editingdomain;
		// textButton.addSelectionListener(new SelectionListener() {
		//
		// /*
		// * (non-Javadoc)
		// *
		// * @see
		// * org.eclipse.swt.events.SelectionListener#widgetDefaultSelected
		// * (org.eclipse.swt.events.SelectionEvent)
		// */
		// public void widgetDefaultSelected(SelectionEvent e) {
		//
		// }
		//
		// /*
		// * (non-Javadoc)
		// *
		// * @see
		// * org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse
		// * .swt.events.SelectionEvent)
		// */
		// public void widgetSelected(SelectionEvent e) {
		// tp.getContentControl().setEnabled(textButton.getSelection());
		// cp.getContentControl().setEnabled(cdataButton.getSelection());
		// SmooksModelUtils.setCDATAToSmooksType(fd, fm, null);
		// Text t = (Text) tp.getContentControl();
		// String text = t.getText();
		// if(text != null && text.length() == 0) text = null;
		// SmooksModelUtils.setTextToSmooksType(fd,fm, text);
		// }
		//
		// });
		//
		// cdataButton.addSelectionListener(new SelectionListener() {
		//
		// /*
		// * (non-Javadoc)
		// *
		// * @see
		// * org.eclipse.swt.events.SelectionListener#widgetDefaultSelected
		// * (org.eclipse.swt.events.SelectionEvent)
		// */
		// public void widgetDefaultSelected(SelectionEvent e) {
		//
		// }
		//
		// /*
		// * (non-Javadoc)
		// *
		// * @see
		// * org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse
		// * .swt.events.SelectionEvent)
		// */
		// public void widgetSelected(SelectionEvent e) {
		// tp.getContentControl().setEnabled(textButton.getSelection());
		// cp.getContentControl().setEnabled(cdataButton.getSelection());
		// SmooksModelUtils.setTextToSmooksType(fd,fm, null);
		// Text t = (Text) cp.getContentControl();
		// String text = t.getText();
		// if(text != null && text.length() == 0) text = null;
		// SmooksModelUtils.setCDATAToSmooksType(fd,fm, text);
		// }
		//
		// });

		return list;
	}
}