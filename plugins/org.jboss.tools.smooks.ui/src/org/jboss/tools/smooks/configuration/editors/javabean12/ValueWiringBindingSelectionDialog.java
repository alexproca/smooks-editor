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
package org.jboss.tools.smooks.configuration.editors.javabean12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.jboss.tools.smooks.configuration.editors.javabean12.Messages;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class ValueWiringBindingSelectionDialog extends Dialog {

	private JavaBeanModel beanModel;

	private String[] ignoreProperties = null;

	private CheckboxTableViewer viewer = null;
	
	private Object[] checkedObject = null;

	private FormToolkit toolkit;

	public ValueWiringBindingSelectionDialog(IShellProvider parentShell, JavaBeanModel beanModel,
			String[] ignoreProperties) {
		super(parentShell);
		this.beanModel = beanModel;
		this.ignoreProperties = ignoreProperties;
	}

	public ValueWiringBindingSelectionDialog(Shell parentShell, JavaBeanModel beanModel, String[] ignoreProperties) {
		super(parentShell);
		this.beanModel = beanModel;
		this.ignoreProperties = ignoreProperties;
	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		
		

		GridData gd = new GridData(GridData.FILL_BOTH);

		Label label = new Label(composite, SWT.NONE);
		label.setLayoutData(gd);
		label.setText(Messages.ValueWiringBindingSelectionDialog_SelectJavaLabel);

		viewer = CheckboxTableViewer.newCheckList(composite, SWT.BORDER);

		gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = 300;
		gd.widthHint = 300;

		viewer.getControl().setLayoutData(gd);
		// TableColumn nameColumn = new TableColumn(viewer.getTable(),SWT.NONE);
		// viewer.getTable().setHeaderVisible(true);
		// viewer.getTable().setLinesVisible(true);
		// nameColumn.setWidth(150);
		// nameColumn.setText("Name");
		// TableColumn typeColumn = new TableColumn(viewer.getTable(),SWT.NONE);
		// typeColumn.setWidth(150);
		// typeColumn.setText("Type");
		// TableColumn nameColumn = new TableColumn(viewer.getTable(),SWT.NONE);
		viewer.setContentProvider(new JavabeanContentProvider());
		viewer.setLabelProvider(new JavaBeanTableLabelProvider());
		List<JavaBeanModel> list = new ArrayList<JavaBeanModel>();
		for (Iterator<?> iterator = beanModel.getChildren().iterator(); iterator.hasNext();) {
			Object child = (Object) iterator.next();
			if (child instanceof JavaBeanModel && !ignoreProperty((JavaBeanModel) child)) {
				list.add((JavaBeanModel) child);
			}
		}
		viewer.setInput(list);
		viewer.setSorter(new ViewerSorter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.jface.viewers.ViewerComparator#category(java.lang
			 * .Object)
			 */
			@Override
			public int category(Object element) {
				if (element instanceof JavaBeanModel) {
					if (((JavaBeanModel) element).isPrimitive()) {
						return 1;
					} else {
						return 2;
					}
				}
				return super.category(element);
			}

		});

		Composite linkComposite = new Composite(composite,SWT.NONE);
		GridLayout gl = new GridLayout();
		gl.numColumns = 2;
		gd = new GridData(GridData.FILL_HORIZONTAL);
		linkComposite.setLayoutData(gd);
		
		linkComposite.setLayout(gl);
		
		toolkit = new FormToolkit(parent.getDisplay());
		Hyperlink allselectlink = toolkit.createHyperlink(linkComposite, Messages.ValueWiringBindingSelectionDialog_SelectAllLink, SWT.NONE);
		allselectlink.setBackground(linkComposite.getBackground());
		allselectlink.addHyperlinkListener(new IHyperlinkListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.ui.forms.events.IHyperlinkListener#linkActivated(
			 * org.eclipse.ui.forms.events.HyperlinkEvent)
			 */
			public void linkActivated(HyperlinkEvent e) {
				viewer.setAllChecked(true);
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.ui.forms.events.IHyperlinkListener#linkEntered(org
			 * .eclipse.ui.forms.events.HyperlinkEvent)
			 */
			public void linkEntered(HyperlinkEvent e) {
				// TODO Auto-generated method stub

			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.ui.forms.events.IHyperlinkListener#linkExited(org
			 * .eclipse.ui.forms.events.HyperlinkEvent)
			 */
			public void linkExited(HyperlinkEvent e) {
				// TODO Auto-generated method stub

			}

		});

		Hyperlink allunselectlink = toolkit.createHyperlink(linkComposite, Messages.ValueWiringBindingSelectionDialog_DeselectAllLink, SWT.NONE);
		allunselectlink.setBackground(linkComposite.getBackground());
		allunselectlink.addHyperlinkListener(new IHyperlinkListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.ui.forms.events.IHyperlinkListener#linkActivated(
			 * org.eclipse.ui.forms.events.HyperlinkEvent)
			 */
			public void linkActivated(HyperlinkEvent e) {
				viewer.setAllChecked(false);
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.ui.forms.events.IHyperlinkListener#linkEntered(org
			 * .eclipse.ui.forms.events.HyperlinkEvent)
			 */
			public void linkEntered(HyperlinkEvent e) {
				// TODO Auto-generated method stub

			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.ui.forms.events.IHyperlinkListener#linkExited(org
			 * .eclipse.ui.forms.events.HyperlinkEvent)
			 */
			public void linkExited(HyperlinkEvent e) {
				// TODO Auto-generated method stub

			}

		});
		getShell().setText(Messages.ValueWiringBindingSelectionDialog_AddBindingLabel);
		return composite;
	}
	
	

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#close()
	 */
	@Override
	public boolean close() {
		checkedObject = viewer.getCheckedElements();
		if(toolkit != null){
			toolkit.dispose();
		}
		return super.close();
	}

	
	
	/**
	 * @return the checkedObject
	 */
	public Object[] getCheckedObject() {
		return checkedObject;
	}

	private boolean ignoreProperty(JavaBeanModel model) {
		if (ignoreProperties == null) {
			return false;
		}
		for (int i = 0; i < ignoreProperties.length; i++) {
			if (model.getName().equals(ignoreProperties[i])) {
				return true;
			}
		}
		return false;
	}
}
