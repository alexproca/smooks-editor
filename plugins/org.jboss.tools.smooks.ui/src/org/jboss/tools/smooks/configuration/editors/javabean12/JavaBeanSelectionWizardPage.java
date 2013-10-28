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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.jboss.tools.smooks.configuration.editors.utils.JavaTypeFieldDialog;
import org.jboss.tools.smooks.configuration.editors.utils.ProjectClassLoader;

/**
 * @author Dart
 * 
 */
public class JavaBeanSelectionWizardPage extends WizardPage {

	private String beanID = null;

	private String beanClass = null;

	private IJavaProject project;

	private String collectionClass = null;

	private boolean isArray = false;

	private boolean isCollection = false;

	private JavaBeanModel javaBeanModel = null;

	private Button arrayButton;

	private Button collectionClassBrowseButton;

	private Text colllectionClassText;

	public JavaBeanSelectionWizardPage(String pageName, String title, ImageDescriptor titleImage, IJavaProject project) {
		super(pageName, title, titleImage);
		this.project = project;
		this.setTitle(Messages.JavaBeanSelectionWizardPage_WizardTitle);
		this.setDescription(Messages.JavaBeanSelectionWizardPage_WizardDes);
	}

	public JavaBeanSelectionWizardPage(String pageName, IJavaProject project) {
		super(pageName);
		this.project = project;
		this.setTitle(Messages.JavaBeanSelectionWizardPage_WizardTitle);
		this.setDescription(Messages.JavaBeanSelectionWizardPage_WizardDes);
	}

	public List<JavaBeanModel> getJavaBeanModelList() {
		if (getJavaBeanModel() != null) {
			List<JavaBeanModel> list = new ArrayList<JavaBeanModel>();
			list.add(javaBeanModel);
			return list;
		}
		return Collections.emptyList();
	}

	/**
	 * @return the javaBeanModel
	 */
	public JavaBeanModel getJavaBeanModel() {
		return javaBeanModel;
	}

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

		GridLayout gl = new GridLayout();
		gl.numColumns = 2;
		mainComposite.setLayout(gl);
		mainComposite.setLayoutData(gd);

		// createBeanIDControls(mainComposite);

		createBeanClassControls(mainComposite);

		createBeanTypeControls(mainComposite);

		Label seperator = new Label(mainComposite, SWT.HORIZONTAL | SWT.SEPARATOR);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		gd.heightHint = 18;
		seperator.setLayoutData(gd);

		setControl(mainComposite);

		this.setPageComplete(false);

	}

	private void createBeanTypeControls(Composite mainComposite) {

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);

		Label beanTypeLabel = new Label(mainComposite, SWT.NONE);
		beanTypeLabel.setText(Messages.JavaBeanSelectionWizardPage_BeanTypeLabel);

		Composite composite = new Composite(mainComposite, SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		composite.setLayoutData(gd);

		GridLayout gl = new GridLayout();
		gl.numColumns = 2;
		gl.marginHeight = 0;
		gl.marginWidth = 0;
		gl.makeColumnsEqualWidth = false;
		composite.setLayout(gl);

		arrayButton = new Button(composite, SWT.CHECK);
		arrayButton.setText(Messages.JavaBeanSelectionWizardPage_ArrayCheckBoxLabel);

		final Button collectionButton = new Button(composite, SWT.CHECK);
		collectionButton.setText(Messages.JavaBeanSelectionWizardPage_CollectionLabel);

		Label beanClassLabel = new Label(mainComposite, SWT.NONE);
		beanClassLabel.setText(Messages.JavaBeanSelectionWizardPage_CollectionClassLabel);

		Composite beanClassComposite = new Composite(mainComposite, SWT.NONE);
		GridLayout gl1 = new GridLayout();
		gl1.numColumns = 2;
		gl1.marginHeight = 0;
		gl1.marginWidth = 0;

		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		beanClassComposite.setLayoutData(gd);

		beanClassComposite.setLayout(gl);

		colllectionClassText = new Text(beanClassComposite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		colllectionClassText.setLayoutData(gd);
		colllectionClassText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				Text t = (Text) e.getSource();
				collectionClass = t.getText();
				refreshJavaBeanModel();
				updateWizardPageStatus();
			}

		});
		colllectionClassText.setEnabled(false);

		beanClassComposite.setLayoutData(gd);

		collectionClassBrowseButton = new Button(beanClassComposite, SWT.NONE);
		collectionClassBrowseButton.setText(Messages.JavaBeanSelectionWizardPage_BrowseButtonLabel);
		collectionClassBrowseButton.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse
			 * .swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				String classString = JavaTypeFieldDialog.openJavaTypeDialog(getShell(), project);
				colllectionClassText.setText(classString);
			}

		});
		collectionClassBrowseButton.setEnabled(false);

		arrayButton.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse
			 * .swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button button = (Button) e.getSource();
				if (button.getSelection()) {
					isArray = true;
					collectionButton.setSelection(false);
					isCollection = false;
					collectionClassBrowseButton.setEnabled(false);
					colllectionClassText.setEnabled(false);
				} else {
					isArray = false;
				}
				refreshJavaBeanModel();
				updateWizardPageStatus();
			}
		});

		collectionButton.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse
			 * .swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button button = (Button) e.getSource();
				if (button.getSelection()) {
					isCollection = true;
					arrayButton.setSelection(false);
					isArray = false;
					collectionClassBrowseButton.setEnabled(true);
					colllectionClassText.setEnabled(true);
				} else {
					isCollection = false;
					collectionClassBrowseButton.setEnabled(false);
					colllectionClassText.setEnabled(false);
				}
				updateWizardPageStatus();
			}

		});
		collectionButton.setVisible(false);
		beanClassComposite.setVisible(false);
		beanClassLabel.setVisible(false);
	}

	protected void refreshJavaBeanModel() {
		if (beanClass == null || "".equals(beanClass.trim())) { //$NON-NLS-1$
		} else {
			try {
				ProjectClassLoader loader = new ProjectClassLoader(project);
				javaBeanModel = null;
				isCollection = isCollectionClass(beanClass);
				isCollection = false;
				if (isCollection) {
					if (collectionClass != null) {
						Class<?> clazz = loader.loadClass(beanClass);
						Class<?> cclazz = loader.loadClass(collectionClass);
						javaBeanModel = JavaBeanModelFactory.getJavaBeanModelWithLazyLoad(clazz);
						javaBeanModel.setComponentClass(cclazz);
					} else {
					}
				} else {
					Class<?> clazz = loader.loadClass(beanClass);
					if (isArray) {
						Object arrayInstance = Array.newInstance(clazz, 0);
						clazz = arrayInstance.getClass();
					}
					javaBeanModel = JavaBeanModelFactory.getJavaBeanModelWithLazyLoad(clazz);
				}
				if (javaBeanModel != null) {
					if (beanID != null) {
						javaBeanModel.setName(beanID);
					}
				} else {
				}
			} catch (JavaModelException e1) {
			} catch (ClassNotFoundException e1) {
			}
		}
	}

	private void createBeanClassControls(Composite mainComposite) {
		Label beanClassLabel = new Label(mainComposite, SWT.NONE);
		beanClassLabel.setText(Messages.JavaBeanSelectionWizardPage_BeanClassLabel);

		Composite beanClassComposite = new Composite(mainComposite, SWT.NONE);
		GridLayout gl = new GridLayout();
		gl.numColumns = 2;
		gl.marginHeight = 0;
		gl.marginWidth = 0;

		beanClassComposite.setLayout(gl);

		final Text beanClassText = new Text(beanClassComposite, SWT.BORDER);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		beanClassText.setLayoutData(gd);
		beanClassText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				Text t = (Text) e.getSource();
				arrayButton.setEnabled(true);
				beanClass = t.getText();
				if (beanClass != null) {
					beanClass = beanClass.trim();
				}
				isCollection = isCollectionClass(beanClass);
//				if (isCollection) {
//					isArray = false;
//					arrayButton.setSelection(false);
//					arrayButton.setEnabled(false);
//					collectionClassBrowseButton.setEnabled(true);
//					colllectionClassText.setEnabled(true);
//				} else {
//					collectionClassBrowseButton.setEnabled(false);
//					colllectionClassText.setEnabled(false);
//					colllectionClassText.setText("");
//				}
				refreshJavaBeanModel();
				updateWizardPageStatus();
			}
		});

		beanClassComposite.setLayoutData(gd);

		Button javaTypeBrowseButton = new Button(beanClassComposite, SWT.NONE);
		javaTypeBrowseButton.setText(Messages.JavaBeanSelectionWizardPage_BrowseButtonLabel);
		javaTypeBrowseButton.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse
			 * .swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				String classString = JavaTypeFieldDialog.openJavaTypeDialog(getShell(), project);
				beanClassText.setText(classString);
			}

		});
	}

	private boolean isCollectionClass(String classString) {
		if (project != null) {
			try {
				ProjectClassLoader loader = new ProjectClassLoader(project);
				Class<?> clazz = loader.loadClass(classString);
				if (Collection.class.isAssignableFrom(clazz)) {
					return true;
				}
			} catch (Throwable t) {

			}
		}
		return false;
	}

	// private void createBeanIDControls(Composite mainComposite) {
	// Label beanIDLabel = new Label(mainComposite, SWT.NONE);
	// beanIDLabel.setText("Bean ID :");
	//
	// Text beanIDText = new Text(mainComposite, SWT.BORDER);
	// GridData gd = new GridData(GridData.FILL_HORIZONTAL);
	// beanIDText.setLayoutData(gd);
	// beanIDText.addModifyListener(new ModifyListener() {
	//
	// public void modifyText(ModifyEvent e) {
	// Text t = (Text) e.getSource();
	// beanID = t.getText();
	// updateWizardPageStatus();
	// }
	//
	// });
	// }

	protected void updateWizardPageStatus() {
		String error = null;
		if (beanClass == null || "".equals(beanClass.trim())) { //$NON-NLS-1$
			error = Messages.JavaBeanSelectionWizardPage_BeanClassEmptyErrorMessage;
		} else {
			try {
				beanClass = beanClass.trim();
				ProjectClassLoader loader = new ProjectClassLoader(project);
				loader.loadClass(beanClass);
			} catch (JavaModelException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				error = Messages.JavaBeanSelectionWizardPage_CantFindClass1 + beanClass + Messages.JavaBeanSelectionWizardPage_QuoteChar; //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-1$ //$NON-NLS-1$ //$NON-NLS-1$ //$NON-NLS-1$
			}
		}

		if (isCollection) {
			if (collectionClass == null || "".equals(collectionClass.trim())) { //$NON-NLS-1$
				error = Messages.JavaBeanSelectionWizardPage_CollectionComponentClassEmptyErrorMessage;
			} else {
				try {
					ProjectClassLoader loader = new ProjectClassLoader(project);
					loader.loadClass(collectionClass);
				} catch (JavaModelException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					error = Messages.JavaBeanSelectionWizardPage_CantFindClass1 + beanClass;
				}
			}
		}

		this.setErrorMessage(error);
		this.setPageComplete(error == null);
	}

}
