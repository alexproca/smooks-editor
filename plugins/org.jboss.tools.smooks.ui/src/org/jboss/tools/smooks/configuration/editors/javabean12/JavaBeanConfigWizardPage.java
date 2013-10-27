/*******************************************************************************
 * Copyright (c) 2007 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.smooks.configuration.editors.javabean12;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * @author Dart Peng
 * @deprecated
 * @CreateTime Jul 21, 2008
 */
public class JavaBeanConfigWizardPage extends WizardPage implements
		SelectionListener ,IJavaBeanSelectionListener {
	
	TreeViewer treeViewer;

	Text classText = null;

	Button classBrowseButton = null;

	IJavaProject project = null;

	private JavaBeanModelLoadComposite javaPropertySelectComposite;
	

	public List<JavaBeanModel> getJavaBeanModelList() {
		if(javaPropertySelectComposite == null) return Collections.emptyList();
		return javaPropertySelectComposite.getJavabeanList();
	}

	public JavaBeanConfigWizardPage(IJavaProject selection) {
		super("beansearchwizardpage"); //$NON-NLS-1$
		this.project = selection;
		setPageComplete(true);
		setTitle("Select Javabean"); //$NON-NLS-1$
		setDescription("Select Javabean model"); //$NON-NLS-1$
	}
	
	protected void initilize() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.ecSclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt
	 * .widgets.Composite)
	 */
	public void createControl(Composite parent) {
		initilize();
		try {
			javaPropertySelectComposite = new JavaBeanModelLoadComposite(
					parent, SWT.NONE, getContainer(), project);
			javaPropertySelectComposite.addJavaBeanSelectionListener(this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		this.setControl(javaPropertySelectComposite);
		this.updatePage();
	}

	protected void updatePage() {
		String error = null;
		if (project == null) {
			error = "Must select java project"; //$NON-NLS-1$
		}
		setPageComplete(error == null);
		this.setErrorMessage(error);
	}

//	public JavaBeanConfigWizardPage(String pageName, String title,
//			ImageDescriptor titleImage) {
//		super(pageName, title, titleImage);
//	}

	public JavaBeanConfigWizardPage(String pageName) {
		super(pageName);
	}

	public void widgetDefaultSelected(SelectionEvent arg0) {
		widgetSelected(arg0);
	}

	public void widgetSelected(SelectionEvent arg0) {

	}

	public void exceptionOccur(Exception e) {
		String error = null;
		if(e != null) error = e.toString();
		this.setErrorMessage(error);
	}

}
