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

import java.lang.reflect.Method;

import org.eclipse.jdt.core.IJavaProject;
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
import org.jboss.tools.smooks.configuration.editors.uitls.JavaPropertyUtils;

/**
 * @author Dart (dpeng@redhat.com)
 *         <p>
 *         Apr 9, 2009
 */
public class JavaMethodsSelectionDialog implements IFieldDialog {

	private IJavaProject resource;

	private Class<?> clazz;

	public JavaMethodsSelectionDialog(IJavaProject resource, Class<?> clazz) {
		super();
		this.resource = resource;
		this.clazz = clazz;
	}

	public Object open(Shell shell) {
		if (resource != null && clazz != null) {
			MethodSelectionDialog dialog = new MethodSelectionDialog(shell, resource, clazz);
			if (dialog.open() == Dialog.OK) {
				Method pd = (Method) dialog.getCurrentSelection();
				if(pd == null){
					return null;
				}
				return pd.getName();
			}else{
				return null;
			}
		}
		MessageDialog.openInformation(shell, Messages.JavaMethodsSelectionDialog_ErrorDialogTitle,
				Messages.JavaMethodsSelectionDialog_ErrorMessage);
		return null;
	}

	private class MethodSelectionDialog extends Dialog {

		private TableViewer viewer;

		private Class<?> clazz;

		private Object currentSelection;

		
		
		public MethodSelectionDialog(IShellProvider parentShell) {
			super(parentShell);
		}

		public MethodSelectionDialog(Shell parentShell, IJavaProject project, Class<?> clazz) {
			super(parentShell);
			this.clazz = clazz;
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
			viewer = new TableViewer(composite, SWT.BORDER|SWT.FULL_SELECTION);
			Table table = viewer.getTable();
			TableColumn nameColumn = new TableColumn(table, SWT.NONE);
			nameColumn.setWidth(100);
			nameColumn.setText(Messages.JavaMethodsSelectionDialog_MethodNameColumnText);
			TableColumn typeColumn = new TableColumn(table, SWT.NONE);
			typeColumn.setWidth(200);
			typeColumn.setText(Messages.JavaMethodsSelectionDialog_MethodParamsColumnText);
			table.setHeaderVisible(true);
			viewer.setContentProvider(new MethodContentProvider());
			viewer.setLabelProvider(new MethodLabelProvider());
			Method[] settMethods = JavaPropertyUtils.getSetterMethods(clazz);
			viewer.setInput(settMethods);
			viewer.addDoubleClickListener(new IDoubleClickListener(){

				public void doubleClick(DoubleClickEvent event) {
					okPressed();
				}
				
			});
			viewer.addSelectionChangedListener(new ISelectionChangedListener() {

				public void selectionChanged(SelectionChangedEvent event) {
					currentSelection = ((IStructuredSelection) event.getSelection()).getFirstElement();
				}

			});
			getShell().setText(clazz.getSimpleName() + Messages.JavaMethodsSelectionDialog_SetterDialogTitle);
			return composite;
		}

		public Object getCurrentSelection() {
			return currentSelection;
		}

		public void setCurrentSelection(Object currentSelection) {
			this.currentSelection = currentSelection;
		}
	}

	private class MethodContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
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

	private class MethodLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			if (columnIndex == 0) {
				return SmooksConfigurationActivator.getDefault().getImageRegistry().get(
						GraphicsConstants.JAVA_PROPERTY_ICON);
			}
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof Method) {
				Method p = (Method) element;
				switch (columnIndex) {
				case 0:
					return p.getName();
				case 1:
					Class<?>[] pts = p.getParameterTypes();
					String paramtersName = ""; //$NON-NLS-1$
					for (int i = 0; i < pts.length; i++,paramtersName+=",") { //$NON-NLS-1$
						String name = pts[i].getName();
						if(pts[i].isArray()){
							name = pts[i].getComponentType().getName() + "[]"; //$NON-NLS-1$
						}
						paramtersName += name;
					}
					if(paramtersName.endsWith(",")){ //$NON-NLS-1$
						paramtersName = paramtersName.substring(0,paramtersName.length() - 1);
					}
					return paramtersName;
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
