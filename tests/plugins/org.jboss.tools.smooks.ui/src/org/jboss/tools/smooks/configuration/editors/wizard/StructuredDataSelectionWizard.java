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
package org.jboss.tools.smooks.configuration.editors.wizard;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;

/**
 * @author Dart Peng
 * @Date Jul 29, 2008
 */
public class StructuredDataSelectionWizard extends Wizard {

	TransformDataWizardSelectionPage selectTypePage;
	
	String activeTransformID= null;
	
	IEditorSite site;
	
	IEditorInput input;
	
	
	
	public StructuredDataSelectionWizard() {
		super();
		setWindowTitle(Messages.StructuredDataSelectionWizard_WizardTitle);
	}

	/**
	 * @return the site
	 */
	public IEditorSite getSite() {
		return site;
	}



	/**
	 * @param site the site to set
	 */
	public void setSite(IEditorSite site) {
		this.site = site;
	}



	/**
	 * @return the input
	 */
	public IEditorInput getInput() {
		return input;
	}



	/**
	 * @param input the input to set
	 */
	public void setInput(IEditorInput input) {
		this.input = input;
	}



	@Override
	public void addPages() {
//		super.addPages();
		selectTypePage = new TransformDataWizardSelectionPage("Select type"); //$NON-NLS-1$
		this.addPage(selectTypePage);
	}



	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		return false;
	}

	public Object getResultObject(){
		return null;
	}


	public String getActiveTransformID() {
		return activeTransformID;
	}



	public void setActiveTransformID(String activeTransformID) {
		this.activeTransformID = activeTransformID;
	}


}
