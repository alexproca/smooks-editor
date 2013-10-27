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
package org.jboss.tools.smooks.configuration.editors.csv12;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.configuration.editors.xml.AbstractFileSelectionWizardPage;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class CSV12DataPathWizardPage extends AbstractFileSelectionWizardPage {

	private CSV12DataConfigurationWizardPage configPage;
	
	public CSV12DataPathWizardPage(String pageName, boolean multiSelect, Object[] initSelections,
			List<ViewerFilter> filters,CSV12DataConfigurationWizardPage configPage) {
		super(pageName, multiSelect, initSelections, filters);
		this.configPage = configPage;
	}

	public CSV12DataPathWizardPage(String pageName, String[] fileExtensionNames,CSV12DataConfigurationWizardPage configPage) {
		super(pageName, fileExtensionNames);
		this.setTitle(Messages.CSV12DataPathWizardPage_WizardTitle);
		this.setDescription(Messages.CSV12DataPathWizardPage_WizardDes);
		this.configPage = configPage;
	}

	
	
	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.configuration.editors.xml.AbstractFileSelectionWizardPage#hookFileTextModifyListener()
	 */
	@Override
	protected void hookFileTextModifyListener() {
		super.hookFileTextModifyListener();
		this.fileText.addModifyListener(new ModifyListener(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if(configPage != null){
					configPage.setFilePath(fileText.getText());
				}
			}
			
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.xml.
	 * AbstractFileSelectionWizardPage#loadedTheObject(java.lang.String)
	 */
	@Override
	protected Object loadedTheObject(String path) throws Exception {
		return null;
	}

	@Override
	protected void changeWizardPageStatus() {
		super.changeWizardPageStatus();
		String text = this.fileText.getText();
		String error = null;
		String filePath;
		try {
			filePath = SmooksUIUtils.parseFilePath(text);
			if (!new File(filePath).exists()) {
				error = Messages.CSV12DataPathWizardPage_CantFindFileErrorMessage + filePath;
			}
		} catch (InvocationTargetException e) {
			error = Messages.CSV12DataPathWizardPage_ErrorFilePathErrorMessage;
		}
		
		this.setErrorMessage(error);
		this.setPageComplete(error == null);
	}

	@Override
	public boolean canFlipToNextPage() {
		return super.canFlipToNextPage();
		// String filePath = this.getFilePath();
		// try {
		// filePath = SmooksUIUtils.parseFilePath(filePath);
		// if(filePath == null) return false;
		// return new File(filePath).exists();
		// } catch (InvocationTargetException e) {
		// return false;
		// }
	}
}
