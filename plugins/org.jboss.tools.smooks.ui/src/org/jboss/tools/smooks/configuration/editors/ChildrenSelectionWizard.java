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
package org.jboss.tools.smooks.configuration.editors;

import java.util.Collection;

import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Dart
 * 
 */
public class ChildrenSelectionWizard extends Wizard {

	private ChildrenSelectionWizardPage page;

	private PrivateWizardDialog dialog;

	public ChildrenSelectionWizard(Shell shell, Collection<?> childrenDescriptor,
			AdapterFactoryEditingDomain editingDomain , ILabelProvider customeLabelProvider) {
		super();
		dialog = new PrivateWizardDialog(shell, this){
			
		};
		page = new ChildrenSelectionWizardPage(childrenDescriptor, editingDomain, "children selection", //$NON-NLS-1$
				"Select children", null); //$NON-NLS-1$
		page.setWizardDialog(dialog);
		page.setCustomeLabelProvider(customeLabelProvider);
	}
	
	public CommandParameter getChildDescriptor(){
		return (CommandParameter)page.getChild();
	}

	public int open() {
		return dialog.open();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		return true;
	}

	@Override
	public void addPages() {
		this.addPage(page);
	}
	
	class PrivateWizardDialog extends WizardDialog{

		public PrivateWizardDialog(Shell parentShell, IWizard newWizard) {
			super(parentShell, newWizard);
		}
		public void pressOK(){
			this.okPressed();
		}
	}

}
