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
package org.jboss.tools.smooks.configuration.editors.uitls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * @author Dart (dpeng@redhat.com)
 *         <p>
 *         Apr 8, 2009
 */
public class SearchComposite extends Composite {

	protected Text text;
	protected Button searchButton;

	public SearchComposite(Composite parent, FormToolkit toolkit, String searchName,IFieldDialog dialog, int style) {
		super(parent, style);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		GridLayout gl = new GridLayout();
		gl.marginWidth = 0;
		gl.numColumns = 2;
		gl.makeColumnsEqualWidth = false;
		gl.marginHeight = 0;
		this.setLayout(gl);
		int textStyle = SWT.NONE;
		if(SmooksUIUtils.isLinuxOS()){
			textStyle = SWT.BORDER;
		}
		if (toolkit != null) {
			text = toolkit.createText(this, "" , textStyle); //$NON-NLS-1$
		} else {
			text = new Text(this, SWT.BORDER);
		}
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.grabExcessHorizontalSpace = true;
		text.setLayoutData(gd);
		if (toolkit != null) {
			searchButton = toolkit.createButton(this, searchName, SWT.NONE);
		} else {
			searchButton = new Button(this, SWT.BORDER);
			searchButton.setText(searchName);
		}
		final IFieldDialog fieldDialog = dialog;
		searchButton.addSelectionListener(new SelectionAdapter(){

			public void widgetSelected(SelectionEvent e) {
				Object value = fieldDialog.open(getShell());
				if(value != null){
					text.setText(getDialogResultText(value));
				}
			}
			
		});
		gd = new GridData(GridData.END);
		searchButton.setLayoutData(gd);
		if (toolkit != null) {
			toolkit.paintBordersFor(this);
		}
	}
	
	public String getDialogResultText(Object value){
		return value.toString();
	}

	public void addModifyListener(ModifyListener listener) {
		if (text != null) {
			text.addModifyListener(listener);
		}
	}

	public void addSelectionListener(SelectionListener listener) {
		if (searchButton != null) {
			searchButton.addSelectionListener(listener);
		}
	}

	public Text getText() {
		return text;
	}

	public Button getSearchButton() {
		return searchButton;
	}

}
