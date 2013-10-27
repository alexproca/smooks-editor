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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.jboss.tools.smooks.configuration.editors.ChildrenSelectionWizard.PrivateWizardDialog;

/**
 * @author Dart
 * 
 */
public class ChildrenSelectionWizardPage extends WizardPage {
	
	private ILabelProvider customeLabelProvider = null;

	private Collection<?> childrenDescriptor = new ArrayList<CommandParameter>();

	private AdapterFactoryEditingDomain editingDomain = null;

	protected Object child;

	private PrivateWizardDialog dialog;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	public void createControl(Composite parent) {
		Composite mainComposite = new Composite(parent, SWT.NONE);

		GridData gd = new GridData(GridData.FILL_BOTH);
		mainComposite.setLayoutData(gd);

		mainComposite.setLayout(new FillLayout());

		final TableViewer tableViewer = new TableViewer(mainComposite, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer.setContentProvider(new ChildrenDescriptorContentProvider());
		tableViewer.setLabelProvider(new ChildrenDescriptorLabelProvider());
		tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				child = null;
				if (!((IStructuredSelection) tableViewer.getSelection()).isEmpty()) {
					child = ((IStructuredSelection) tableViewer.getSelection()).getFirstElement();
					updatePage();
				}
			}
		});
		tableViewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				dialog.close();
			}
		});
		if (childrenDescriptor != null) {
			tableViewer.setInput(childrenDescriptor);
		}
		updatePage();
		setControl(mainComposite);
	}

	public Object getChild() {
		return child;
	}
	

	/**
	 * @param customeLabelProvider the customeLabelProvider to set
	 */
	public void setCustomeLabelProvider(ILabelProvider customeLabelProvider) {
		this.customeLabelProvider = customeLabelProvider;
	}

	protected void updatePage() {
		String error = null;
		if (child == null) {
			error = Messages.ChildrenSelectionWizardPage_selectchilderror;
		}

		this.setErrorMessage(error);
		this.setPageComplete(error == null);
	}

	public ChildrenSelectionWizardPage(Collection<?> childrenDescriptor, AdapterFactoryEditingDomain editingDomain,
			String pageName, String title, ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
		this.childrenDescriptor = childrenDescriptor;
		this.editingDomain = editingDomain;
		this.setTitle(Messages.ChildrenSelectionWizardPage_wizardtitle);
		this.setDescription(Messages.ChildrenSelectionWizardPage_wizardtitle);
	}

	public ChildrenSelectionWizardPage(Collection<?> childrenDescriptor, AdapterFactoryEditingDomain editingDomain,
			String pageName) {
		super(pageName);
		this.childrenDescriptor = childrenDescriptor;
		this.editingDomain = editingDomain;
		this.setTitle(Messages.ChildrenSelectionWizardPage_wizardtitle);
		this.setDescription(Messages.ChildrenSelectionWizardPage_wizardtitle);
	}

	private Object getValue(Object element) {
		if (element instanceof CommandParameter) {
			Object v = ((CommandParameter) element).getValue();
			v = AdapterFactoryEditingDomain.unwrap(v);
			return v;
		}
		return element;
	}

	private class ChildrenDescriptorContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Collection<?>) {
				return ((Collection<?>) inputElement).toArray();
			}
			return new Object[] {};
		}

		public void dispose() {
			// TODO Auto-generated method stub

		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub

		}

	}

	private class ChildrenDescriptorLabelProvider extends LabelProvider {

		@Override
		public Image getImage(Object element) {
			Image image = null;
			if(customeLabelProvider != null){
				image = customeLabelProvider.getImage(element);
			}
			if(image != null){
				return image;
			}
			element = getValue(element);
			IItemLabelProvider provider = (IItemLabelProvider) editingDomain.getAdapterFactory().adapt(element,
					IItemLabelProvider.class);
			Object img = provider.getImage(element);
			image = ExtendedImageRegistry.getInstance().getImage(img);
			return image;

		}

		@Override
		public String getText(Object element) {
			String label = null;
			if(customeLabelProvider != null){
				label = customeLabelProvider.getText(element);
			}
			if(label != null){
				return label;
			}
			element = getValue(element);
			IItemLabelProvider provider = (IItemLabelProvider) editingDomain.getAdapterFactory().adapt(element,
					IItemLabelProvider.class);
			return provider.getText(element);
		}

	}

	public void setWizardDialog(PrivateWizardDialog dialog) {
		this.dialog = dialog;
	}

}
