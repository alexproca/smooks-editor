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
package org.jboss.tools.smooks.configuration.editors.uitls;

import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.configuration.editors.AttributeFieldEditPart;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class TextTypeSwicher {

	private Button textButton;
	private Button innerDataButton;

	public void hookSwicher(AttributeFieldEditPart textFieldEditPart, AttributeFieldEditPart cdataFieldEditPart,
			AdapterFactoryEditingDomain editingdomain, Object model, int type) {

		final int ftype = type;

		String innerData = null;

		if (ftype == SmooksUIUtils.VALUE_TYPE_CDATA) {
			innerData = SmooksModelUtils.getAnyTypeCDATA((AnyType) model);
		}
		if (ftype == SmooksUIUtils.VALUE_TYPE_COMMENT) {
			innerData = SmooksModelUtils.getAnyTypeComment((AnyType) model);
		}
		String text = SmooksModelUtils.getAnyTypeText((AnyType) model);

		textButton.setSelection(true);
		innerDataButton.setSelection(false);
		if ((innerData == null || innerData.length() == 0) && (text == null || text.length() == 0)) {
			textButton.setSelection(true);
			innerDataButton.setSelection(false);
		} else {
			if ((text == null || text.length() == 0)) {
				textButton.setSelection(false);
				innerDataButton.setSelection(true);
			}
		}
		final AttributeFieldEditPart tp = textFieldEditPart;
		final AttributeFieldEditPart cp = cdataFieldEditPart;
		tp.getContentControl().setEnabled(textButton.getSelection());
		cp.getContentControl().setEnabled(innerDataButton.getSelection());
		final AnyType fm = (AnyType) model;
		final AdapterFactoryEditingDomain fd = editingdomain;
		textButton.addSelectionListener(new SelectionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.SelectionListener#widgetDefaultSelected
			 * (org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetDefaultSelected(SelectionEvent e) {

			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse
			 * .swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				tp.getContentControl().setEnabled(textButton.getSelection());
				cp.getContentControl().setEnabled(innerDataButton.getSelection());
				if (ftype == SmooksUIUtils.VALUE_TYPE_CDATA) {
					SmooksModelUtils.setCDATAToSmooksType(fd, fm, null);
				}
				if (ftype == SmooksUIUtils.VALUE_TYPE_COMMENT) {
					SmooksModelUtils.setCommentToSmooksType(fd, fm, null);
				}
				Text t = (Text) tp.getContentControl();
				String text = t.getText();
				if (text != null) {
					text = text.replaceAll("\r", ""); //$NON-NLS-1$ //$NON-NLS-2$
				}
				if (text.length() == 0)
					text = null;
				SmooksModelUtils.setTextToSmooksType(fd, fm, text);
			}

		});

		innerDataButton.addSelectionListener(new SelectionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.SelectionListener#widgetDefaultSelected
			 * (org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetDefaultSelected(SelectionEvent e) {

			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse
			 * .swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				tp.getContentControl().setEnabled(textButton.getSelection());
				cp.getContentControl().setEnabled(innerDataButton.getSelection());
				SmooksModelUtils.setTextToSmooksType(fd, fm, null);
				Text t = (Text) cp.getContentControl();
				String text = t.getText();
				if (text != null) {
					text = text.replaceAll("\r", ""); //$NON-NLS-1$ //$NON-NLS-2$
				}
				if (text.length() == 0)
					text = null;
				if (ftype == SmooksUIUtils.VALUE_TYPE_CDATA) {
					SmooksModelUtils.setCDATAToSmooksType(fd, fm, text);
				}
				if (ftype == SmooksUIUtils.VALUE_TYPE_COMMENT) {
					SmooksModelUtils.setCommentToSmooksType(fd, fm, text);
				}
			}

		});
	}

	public void createSwicherGUI(String textString, String cdataString, Composite parent, FormToolkit toolkit) {
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		gd.heightHint = 15;

		toolkit.createSeparator(parent, SWT.HORIZONTAL).setLayoutData(gd);

		textButton = toolkit.createButton(parent, textString, SWT.RADIO);
		innerDataButton = toolkit.createButton(parent, cdataString, SWT.RADIO);
	}
}
