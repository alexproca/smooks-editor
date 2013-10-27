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
package org.jboss.tools.smooks.configuration.wizards;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.jboss.tools.smooks.configuration.SmooksConstants;

/**
 * @author Dart (dpeng@redhat.com)
 *
 */
public class SmooksVersionSelectionPage extends WizardPage {

	protected String version = SmooksConstants.VERSION_1_2;

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		
		Composite buttonComposite = new Composite((Composite)parent, SWT.NONE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		buttonComposite.setLayoutData(gd);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		buttonComposite.setLayout(layout);

		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		Label label = new Label(buttonComposite, SWT.NONE);
		label.setText(Messages.SmooksVersionSelectionPage_Label_Smooks_Version);
		

		
		final Combo combo = new Combo(buttonComposite,SWT.BORDER | SWT.READ_ONLY);
		
		for(int i = 0 ; i < SmooksConstants.SMOOKS_VERSIONS.length ; i++){
			combo.add(SmooksConstants.SMOOKS_VERSIONS[i]);
		}
		
		int defaultIndex = 0 ;
		for(int i = 0 ; i < SmooksConstants.SMOOKS_VERSIONS.length ; i++){
			if(SmooksConstants.SMOOKS_VERSIONS[i].equals(version)){
				defaultIndex = i;
				break;
			}
		}
		combo.select(defaultIndex);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		combo.setLayoutData(gd);
		
		combo.addModifyListener(new ModifyListener(){

			public void modifyText(ModifyEvent e) {
				version = combo.getText();
			}
			
		});
		
		setControl(buttonComposite);
	}

	public SmooksVersionSelectionPage(String pageName, String title, ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
		this.setTitle(Messages.SmooksVersionSelectionPage_Page_Title);
		this.setDescription(Messages.SmooksVersionSelectionPage_Page_Description);
	}

	public SmooksVersionSelectionPage(String pageName) {
		super(pageName);
		this.setTitle(Messages.SmooksVersionSelectionPage_Page_Title);
		this.setDescription(Messages.SmooksVersionSelectionPage_Page_Description);
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

}
