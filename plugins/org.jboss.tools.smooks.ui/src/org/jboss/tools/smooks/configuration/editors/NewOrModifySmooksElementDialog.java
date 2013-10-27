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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;

/**
 * @author Dart
 * 
 */
public class NewOrModifySmooksElementDialog extends Dialog {

	private EObject model;

	private FormToolkit toolkit;

	private ISmooksModelProvider modelProvider = null;

	private boolean modify = false;

	private EObject parentModel;

	private EStructuralFeature feature;

	private IEditorPart editorPart;

	public NewOrModifySmooksElementDialog(IShellProvider parentShell, EStructuralFeature feature, EObject model,
			EObject parentModel, FormToolkit toolkit, ISmooksModelProvider modelProvider, IEditorPart editorPart,
			boolean modify) {
		super(parentShell);
		this.feature = feature;
		this.model = model;
		this.toolkit = toolkit;
		this.modelProvider = modelProvider;
		this.modify = modify;
		this.editorPart = editorPart;
		this.parentModel = parentModel;
	}

	public NewOrModifySmooksElementDialog(Shell parentShell, EStructuralFeature feature, EObject model,
			EObject parentModel, FormToolkit toolkit, ISmooksModelProvider modelProvider, IEditorPart editorPart,
			boolean modify) {
		super(parentShell);
		this.feature = feature;
		this.model = model;
		this.toolkit = toolkit;
		this.modelProvider = modelProvider;
		this.modify = modify;
		this.editorPart = editorPart;
		this.parentModel = parentModel;
	}

	protected void createButtonsForButtonBar(Composite parent) {
		// create OK and Cancel buttons by default
		String okLabel = IDialogConstants.OK_LABEL;
		if (modify) {
			okLabel = Messages.NewOrModifySmooksElementDialog_CloseButtonLabel;
		}
		createButton(parent, IDialogConstants.OK_ID, okLabel, true);
		if (!modify) {
			createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		}
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite mainComposite = (Composite) super.createDialogArea(parent);
		// parent.setBackground(toolkit.getColors().getBackground());
		mainComposite.setBackground(toolkit.getColors().getBackground());
		Composite mc = new Composite(mainComposite, SWT.NONE);
		mc.setBackground(toolkit.getColors().getBackground());
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = 500;
		gd.widthHint = 400;
		mc.setLayoutData(gd);
		GridLayout gl = new GridLayout();
		gl.numColumns = 2;
		gl.verticalSpacing = 1;
		mc.setLayout(gl);

		ModelPanelCreator creator = new ModelPanelCreator();

		if (modelProvider != null && model instanceof EObject) {
			AdapterFactoryEditingDomain editDomain = (AdapterFactoryEditingDomain) modelProvider.getEditingDomain();
			IItemPropertySource propertySource = (IItemPropertySource) editDomain.getAdapterFactory().adapt(model,
					IItemPropertySource.class);
			creator.createModelPanel((EObject) model, toolkit, mc, propertySource, modelProvider, editorPart);
		}
		return mainComposite;
	}

	@Override
	protected void okPressed() {
		try {
			if (!modify && parentModel != null && modelProvider != null && feature != null) {
				EditingDomain editingDomain = modelProvider.getEditingDomain();
				Command command = null;

				if (feature instanceof EReference) {
					if (((EReference) feature).isMany()) {
						command = AddCommand.create(editingDomain, parentModel, feature, model);
					} else {
						command = SetCommand.create(editingDomain, parentModel, feature, model);
					}
				}
				if (command != null)
					editingDomain.getCommandStack().execute(command);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.okPressed();
	}
}
