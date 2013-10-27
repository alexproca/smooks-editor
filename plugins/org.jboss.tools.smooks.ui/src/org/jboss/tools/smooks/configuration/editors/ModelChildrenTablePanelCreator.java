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
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.jboss.tools.smooks.configuration.SmooksConfigurationActivator;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.model.common.AbstractAnyType;

/**
 * @author Dart
 * 
 */
public class ModelChildrenTablePanelCreator {

	private ISmooksModelProvider smooksModelProvider;

	protected TableViewer childrenTableViewer;

	private Button newChildButton;

	private Button removeRemoveButton;

	private Button upChildButton;

	private Button downChildButton;

	private Button childPropertiesButton;

	private EObject parentModel;

	private FormToolkit toolkit;

	private IEditorPart editorPart;

	public ModelChildrenTablePanelCreator(ISmooksModelProvider smooksModelProvider, EObject parentModel,
			FormToolkit toolkit, IEditorPart editorPart) {
		this.parentModel = parentModel;
		this.smooksModelProvider = smooksModelProvider;
		this.toolkit = toolkit;
		this.editorPart = editorPart;
	}

	public Composite createChildrenTablePanel(Composite parent) {
		Composite mainComposite = toolkit.createComposite(parent);
		GridLayout gl = new GridLayout();
		gl.numColumns = 2;
		mainComposite.setLayout(gl);
		createChildrenTablePanel(mainComposite, toolkit);
		return mainComposite;
	}

	protected void createChildrenTablePanel(Composite mainComposite, FormToolkit toolkit) {
		if (smooksModelProvider != null) {
			AdapterFactoryEditingDomain editingDomain = (AdapterFactoryEditingDomain) smooksModelProvider
					.getEditingDomain();
			EObject parentModel = getParentModel();

			childrenTableViewer = new TableViewer(mainComposite);
			GridData gd = new GridData(GridData.FILL_BOTH);
			childrenTableViewer.getControl().setLayoutData(gd);
			toolkit.paintBordersFor(mainComposite);
			Composite buttonArea = toolkit.createComposite(mainComposite);
			gd = new GridData(GridData.FILL_VERTICAL);
			gd.widthHint = 30;
			GridLayout bgl = new GridLayout();
			buttonArea.setLayout(bgl);

			newChildButton = toolkit.createButton(buttonArea, Messages.ModelChildrenTablePanelCreator_NewButtonLabel, SWT.NONE);
			gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.verticalAlignment = GridData.BEGINNING;
			newChildButton.setLayoutData(gd);

			removeRemoveButton = toolkit.createButton(buttonArea, Messages.ModelChildrenTablePanelCreator_RemoveButtonLabel, SWT.NONE);
			gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.verticalAlignment = GridData.BEGINNING;
			removeRemoveButton.setLayoutData(gd);

			upChildButton = toolkit.createButton(buttonArea, Messages.ModelChildrenTablePanelCreator_UpButtonLabel, SWT.NONE);
			gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.verticalAlignment = GridData.BEGINNING;
			upChildButton.setLayoutData(gd);

			downChildButton = toolkit.createButton(buttonArea, Messages.ModelChildrenTablePanelCreator_DownButtonLable, SWT.NONE);
			gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.verticalAlignment = GridData.BEGINNING;
			downChildButton.setLayoutData(gd);

			childPropertiesButton = toolkit.createButton(buttonArea, Messages.ModelChildrenTablePanelCreator_PropertiesButtonLabel, SWT.NONE);
			gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.verticalAlignment = GridData.BEGINNING;
			childPropertiesButton.setLayoutData(gd);

			childrenTableViewer
					.setContentProvider(new AdapterFactoryContentProvider(editingDomain.getAdapterFactory()) {

						@Override
						public boolean hasChildren(Object object) {
							return false;
						}

					});

			childrenTableViewer.setLabelProvider(new DecoratingLabelProvider(new AdapterFactoryLabelProvider(
					editingDomain.getAdapterFactory()) {

				/*
				 * (non-Javadoc)
				 * 
				 * @see
				 * org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
				 * # getText(java.lang.Object)
				 */
				@Override
				public String getText(Object object) {
					Object obj = AdapterFactoryEditingDomain.unwrap(object);
					if (obj instanceof AbstractAnyType) {
						return super.getText(obj);
					}
					return super.getText(object);
				}

			}, SmooksConfigurationActivator.getDefault().getWorkbench().getDecoratorManager().getLabelDecorator()));

			if (parentModel != null) {
				childrenTableViewer.setInput(parentModel);
			}

			childrenTableViewer.addDoubleClickListener(new IDoubleClickListener() {

				public void doubleClick(DoubleClickEvent event) {
					openChildPropertiesModifyDialog();
				}
			});

			childrenTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

				public void selectionChanged(SelectionChangedEvent event) {
					updateButtons();
				}
			});

			hookButtons();
			updateButtons();
		}
	}

	protected TableViewer getChildrenTableViewer() {
		return childrenTableViewer;
	}

	protected EObject newChildModel() {
		return null;
	}

	protected EStructuralFeature getChildrenFeature() {
		return null;
	}

	protected boolean performNewChild() {
		return true;
	}

	protected void endNewChild() {

	}

	protected void performRemoveChild() {

	}

	protected void endRemoveChild() {

	}

	protected void hookButtons() {
		newChildButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (getSmooksVersion() == null) {
					return;
				}
				if (performNewChild()) {
					EObject childModel = newChildModel();
					EObject parent = getParentModel();
					if (parent == null || childModel == null) {
						return;
					}
					EStructuralFeature profileFeature = getChildrenFeature();
					try {
						NewOrModifySmooksElementDialog dialog = new NewOrModifySmooksElementDialog(editorPart
								.getEditorSite().getShell(), profileFeature, childModel, parent, toolkit,
								smooksModelProvider, editorPart, false);

						if (dialog.open() == Dialog.OK) {
							endNewChild();
						}
					} catch (Throwable e1) {
						e1.printStackTrace();
					}
				}
				super.widgetSelected(e);
			}

		});
		removeRemoveButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection selection = (IStructuredSelection) childrenTableViewer.getSelection();
				if (selection == null)
					return;
				Object obj = selection.getFirstElement();
				if (obj instanceof EObject) {
					performRemoveChild();
					EObject profile = (EObject) obj;
					EObject parent = getParentModel();
					if (parent == null)
						return;
					CompoundCommand compoundCommand = new CompoundCommand();
					Command command = RemoveCommand.create(smooksModelProvider.getEditingDomain(), profile);
					compoundCommand.append(command);
					performRunRemoveCommand(compoundCommand, smooksModelProvider.getEditingDomain());
					smooksModelProvider.getEditingDomain().getCommandStack().execute(compoundCommand);
					endRemoveChild();
				}
			}

		});
		upChildButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection selection = (IStructuredSelection) childrenTableViewer.getSelection();
				if (selection == null)
					return;
				Object obj = selection.getFirstElement();
				if (obj instanceof EObject) {
					EObject profilesType = getParentModel();
					if (profilesType == null)
						return;
					EObject v = (EObject) AdapterFactoryEditingDomain.unwrap(obj);
					EObject parent = v.eContainer();
					int index = parent.eContents().indexOf(v);
					Command command = MoveCommand.create(smooksModelProvider.getEditingDomain(), parent, null, obj,
							index - 1);
					smooksModelProvider.getEditingDomain().getCommandStack().execute(command);
				}
			}

		});
		downChildButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection selection = (IStructuredSelection) childrenTableViewer.getSelection();
				if (selection == null)
					return;
				Object obj = selection.getFirstElement();
				if (obj instanceof EObject) {
					EObject profilesType = getParentModel();
					if (profilesType == null)
						return;
					EObject v = (EObject) AdapterFactoryEditingDomain.unwrap(obj);
					EObject parent = v.eContainer();
					int index = parent.eContents().indexOf(v);
					Command command = MoveCommand.create(smooksModelProvider.getEditingDomain(), parent, null, obj,
							index + 1);
					smooksModelProvider.getEditingDomain().getCommandStack().execute(command);
				}
			}

		});
		childPropertiesButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				openChildPropertiesModifyDialog();
				super.widgetSelected(e);
			}

		});

	}

	protected void performRunRemoveCommand(CompoundCommand compoundCommand, EditingDomain editDomain) {

	}

	protected void updateButtons() {
		if (getSmooksVersion() == null) {
			childPropertiesButton.setEnabled(false);
			newChildButton.setEnabled(false);
			removeRemoveButton.setEnabled(false);
			upChildButton.setEnabled(false);
			downChildButton.setEnabled(false);
			return;
		}
		childPropertiesButton.setEnabled(true);
		removeRemoveButton.setEnabled(true);
		IStructuredSelection selection = (IStructuredSelection) childrenTableViewer.getSelection();
		if (selection == null) {
			childPropertiesButton.setEnabled(false);
			removeRemoveButton.setEnabled(false);
			upChildButton.setEnabled(false);
			downChildButton.setEnabled(false);
		} else {
			if (selection.getFirstElement() == null) {
				childPropertiesButton.setEnabled(false);
				removeRemoveButton.setEnabled(false);
				upChildButton.setEnabled(false);
				downChildButton.setEnabled(false);
				return;
			}

			Object obj = selection.getFirstElement();
			if (obj instanceof EObject) {
				EObject profilesType = getParentModel();
				if (profilesType == null)
					return;
				EObject v = (EObject) AdapterFactoryEditingDomain.unwrap(obj);
				EObject parent = v.eContainer();
				int index = parent.eContents().indexOf(v);
				Command command = MoveCommand.create(smooksModelProvider.getEditingDomain(), parent, null, obj,
						index - 1);
				upChildButton.setEnabled(command.canExecute());

				Command command1 = MoveCommand.create(smooksModelProvider.getEditingDomain(), parent, null, obj,
						index + 1);
				downChildButton.setEnabled(command1.canExecute());
			}

			if (selection.size() > 1) {
				childPropertiesButton.setEnabled(false);
				removeRemoveButton.setEnabled(false);
			}
		}

	}

	protected void openChildPropertiesModifyDialog() {
		IStructuredSelection selection = (IStructuredSelection) childrenTableViewer.getSelection();
		if (selection == null)
			return;
		Object obj = selection.getFirstElement();
		if (obj instanceof EObject) {
			EObject child = (EObject) obj;
			EObject parent = getParentModel();
			EStructuralFeature childFeature = getChildrenFeature();

			NewOrModifySmooksElementDialog dialog = new NewOrModifySmooksElementDialog(editorPart.getEditorSite()
					.getShell(), childFeature, child, parent, toolkit, smooksModelProvider, editorPart, true);
			dialog.open();
		}
	}

	public EObject getParentModel() {
		return parentModel;
	}

	public void setParentModel(EObject parentModel) {
		this.parentModel = parentModel;
	}

	public String getSmooksVersion() {
		if (this.smooksModelProvider != null) {
			return this.smooksModelProvider.getPlatformVersion();
		}
		return null;
	}

}
