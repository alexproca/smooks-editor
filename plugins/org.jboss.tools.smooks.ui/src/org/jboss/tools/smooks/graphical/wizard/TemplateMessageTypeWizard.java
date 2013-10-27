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
package org.jboss.tools.smooks.graphical.wizard;

import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardNode;
import org.eclipse.jface.wizard.Wizard;

/**
 * @author Dart
 * 
 */
public class TemplateMessageTypeWizard extends Wizard {

	private TemplateWizardSelectionPage page = null;
	
	private IWizard wizard;

	public TemplateMessageTypeWizard() {
		super();
		this.setForcePreviousAndNextButtons(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		page = new TemplateWizardSelectionPage(Messages.TemplateMessageTypeWizard_Page_Name);
		this.addPage(page);
		super.addPages();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		IWizardNode node = page.getSelectedNode();
		if(node instanceof TemplateMessageTypeWizardNode){
			wizard = ((TemplateMessageTypeWizardNode)node).getWizard();
		}
		return true;
	}

	/**
	 * @return the wizard
	 */
	public IWizard getWizard() {
		return wizard;
	}
	
	

}
