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
package org.jboss.tools.smooks.configuration.editors.javabean12;

import java.lang.reflect.Array;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.jboss.tools.smooks.configuration.SmooksConfigurationActivator;
import org.jboss.tools.smooks.configuration.editors.GraphicsConstants;
import org.jboss.tools.smooks.configuration.editors.javabean12.Messages;
import org.jboss.tools.smooks.configuration.editors.uitls.IFieldDialog;
import org.jboss.tools.smooks.configuration.editors.uitls.IModelProcsser;
import org.jboss.tools.smooks.configuration.editors.uitls.ProjectClassLoader;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;

/**
 * @author Dart (dpeng@redhat.com)
 *         <p>
 *         Apr 9, 2009
 */
public class JavaPropertiesSelectionDialog implements IFieldDialog {

	private IJavaProject project;

	private String className;

	public JavaPropertiesSelectionDialog(IJavaProject resource, String className) {
		super();
		this.project = resource;
		this.className = className;
	}

	public Object open(Shell shell) {
		String errorMessage = ""; //$NON-NLS-1$
		if (project == null) {
			errorMessage = Messages.JavaPropertiesSelectionDialog_ProjectisJavaProjectErrorMessage;
		}
		try {
			if (project != null && className != null) {
				Class<?> clazz = SmooksUIUtils.loadClass(className, project);
				if (clazz != null) {
					JavaBeanModel beanModel = JavaBeanModelFactory.getJavaBeanModelWithLazyLoad(clazz);
					PropertySelectionDialog dialog = new PropertySelectionDialog(shell, project, beanModel);
					if (dialog.open() == Dialog.OK) {
						JavaBeanModel pd = (JavaBeanModel) dialog.getCurrentSelection();
						if (pd == null) {
							return null;
						}
						return pd.getName();
					} else {
						return null;
					}
				}
			}
		} catch (JavaModelException e) {
			errorMessage = ""; //$NON-NLS-1$
		} catch (ClassNotFoundException e) {
			errorMessage = "'" + className + "' can't be found."; //$NON-NLS-1$ //$NON-NLS-2$
		}
		MessageDialog.openInformation(shell, Messages.JavaPropertiesSelectionDialog_CantOpenDialogTitle,
				Messages.JavaPropertiesSelectionDialog_CantOpenDialogErrorMessage1 + className + "'.\n" + errorMessage); //$NON-NLS-1$
		return null;
	}

	private class PropertySelectionDialog extends Dialog {

		private TableViewer viewer;

		private Object currentSelection;

		private JavaBeanModel beanModel = null;

		public PropertySelectionDialog(IShellProvider parentShell) {
			super(parentShell);
		}

		public PropertySelectionDialog(Shell parentShell, IJavaProject project, JavaBeanModel beanModel) {
			super(parentShell);
			this.beanModel = beanModel;
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			Composite composite = (Composite) super.createDialogArea(parent);
			GridData gd = new GridData(GridData.FILL_BOTH);
			gd.heightHint = 400;
			gd.widthHint = 400;
			composite.setLayoutData(gd);
			FillLayout fl = new FillLayout();
			fl.marginHeight = 10;
			fl.marginWidth = 10;
			composite.setLayout(fl);
			viewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
			Table table = viewer.getTable();
			TableColumn nameColumn = new TableColumn(table, SWT.NONE);
			nameColumn.setWidth(100);
			nameColumn.setText(Messages.JavaPropertiesSelectionDialog_NameColumnText);
			TableColumn typeColumn = new TableColumn(table, SWT.NONE);
			typeColumn.setWidth(200);
			typeColumn.setText(Messages.JavaPropertiesSelectionDialog_TypeColumnText);
			table.setHeaderVisible(true);
			viewer.setContentProvider(new PropertyDescriptorContentProvider());
			viewer.setLabelProvider(new PropertyDescriptorLabelProvider());
			viewer.setInput(beanModel);
			viewer.addDoubleClickListener(new IDoubleClickListener() {
				public void doubleClick(DoubleClickEvent event) {
					okPressed();
				}
			});
			viewer.addSelectionChangedListener(new ISelectionChangedListener() {
				public void selectionChanged(SelectionChangedEvent event) {
					currentSelection = ((IStructuredSelection) event.getSelection()).getFirstElement();
				}
			});
			getShell().setText(beanModel.getName() + Messages.JavaPropertiesSelectionDialog_DialogTitle);
			return composite;
		}

		public Object getCurrentSelection() {
			return currentSelection;
		}

		public void setCurrentSelection(Object currentSelection) {
			this.currentSelection = currentSelection;
		}
	}

	private class PropertyDescriptorContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof JavaBeanModel) {
				return ((JavaBeanModel) inputElement).getChildren().toArray();
			}
			if (inputElement.getClass().isArray()) {
				return (Object[]) inputElement;
			}
			return new Object[] {};
		}

		public void dispose() {

		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		}

	}

	private class PropertyDescriptorLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			if (columnIndex == 0) {
				return SmooksConfigurationActivator.getDefault().getImageRegistry().get(
						GraphicsConstants.JAVA_PROPERTY_ICON);
			}
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof JavaBeanModel) {
				JavaBeanModel p = (JavaBeanModel) element;
				switch (columnIndex) {
				case 0:
					return p.getName();
				case 1:
					return p.getBeanClassString();
				}
			}
			return getText(element);
		}
	}

	public IModelProcsser getModelProcesser() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setModelProcesser(IModelProcsser processer) {
		// TODO Auto-generated method stub

	}
}
