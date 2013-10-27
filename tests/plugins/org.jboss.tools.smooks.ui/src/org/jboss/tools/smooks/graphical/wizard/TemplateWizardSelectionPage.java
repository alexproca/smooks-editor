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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardSelectionPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.jboss.tools.smooks.graphical.wizard.freemarker.FreemarkerCSVTemplateCreationWizard;
import org.jboss.tools.smooks.graphical.wizard.freemarker.FreemarkerXMLTemplateCreationWizard;

/**
 * @author Dart
 * 
 */
public class TemplateWizardSelectionPage extends WizardSelectionPage {
	List<TemplateMessageTypeWizardNode> registedWizard = new ArrayList<TemplateMessageTypeWizardNode>();
	private Label desLabel;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	public void createControl(Composite parent) {
		// parent.setLayout(new FillLayout());
		Composite main = new Composite(parent, SWT.NONE);

		GridLayout gridLayout = new GridLayout();
		main.setLayout(gridLayout);

		Label label = new Label(main, SWT.NONE);
		label.setText(Messages.TemplateWizardSelectionPage_Message_Type_Label);

		final Combo combo = new Combo(main, SWT.BORDER | SWT.READ_ONLY);
		combo.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse
			 * .swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				TemplateMessageTypeWizardNode node = registedWizard.get(combo.getSelectionIndex());
				setSelectedNode(node);
				updateDescriptionLabel(node);
			}

		});

		initInputTypeCombo(combo);

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		combo.setLayoutData(gd);

		Composite separatorComposite = new Composite(main, SWT.NONE);
		gd = new GridData();
		gd.heightHint = 12;
		separatorComposite.setLayoutData(gd);

		desLabel = new Label(main, SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		desLabel.setLayoutData(gd);

		// for (Iterator iterator = registedWizard.iterator();
		// iterator.hasNext();) {
		// IWizardNode node = (IWizardNode) iterator.next();
		// node.
		// }
		this.setControl(main);
		if (!registedWizard.isEmpty()) {
			combo.select(0);
			TemplateMessageTypeWizardNode node = registedWizard.get(combo.getSelectionIndex());
			setSelectedNode(node);
			updateDescriptionLabel(node);
		}
	}

	protected void updateDescriptionLabel(TemplateMessageTypeWizardNode node) {
		String des = null;
		if (node != null) {
			des = node.getDescription();
		}
		if (des == null) {
			des = ""; //$NON-NLS-1$
		}
		desLabel.setText(des);
	}

	private void initInputTypeCombo(Combo combo) {
		for(int i = 0; i < registedWizard.size(); i++) {
			TemplateMessageTypeWizardNode type = registedWizard.get(i);
			combo.add(type.getName());
		}
	}

	public IWizardPage getNextPage() {
		if (this.getSelectedNode() == null) {
			return null;
		}

		boolean isCreated = getSelectedNode().isContentCreated();

		IWizard wizard = getSelectedNode().getWizard();

		if (wizard == null) {
			setSelectedNode(null);
			return null;
		}
		if (!isCreated) {
			wizard.addPages();
		}
		return wizard.getStartingPage();
	}

	public TemplateWizardSelectionPage(String pageName) {
		super(pageName);
		setDescription("Choose \"Message Type\" ."); //$NON-NLS-1$
		setTitle("Message Type Selection"); //$NON-NLS-1$
		
		TemplateMessageTypeWizardNode csvTypeNode = new TemplateMessageTypeWizardNode();
		csvTypeNode.setName(Messages.TemplateWizardSelectionPage_CSV_Node);
		csvTypeNode.setWizard(new FreemarkerCSVTemplateCreationWizard());
		
		TemplateMessageTypeWizardNode xmlTypeNode = new TemplateMessageTypeWizardNode();
		xmlTypeNode.setName(Messages.TemplateWizardSelectionPage_XML_Node);
		xmlTypeNode.setWizard(new FreemarkerXMLTemplateCreationWizard());

		registedWizard.add(xmlTypeNode);
		registedWizard.add(csvTypeNode);
	}

	public void activeSelectionWizard() {

	}
}
