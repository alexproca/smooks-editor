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
package org.jboss.tools.smooks.graphical.wizards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.ui.IJavaElementSearchConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ITreeViewerListener;
import org.eclipse.jface.viewers.TreeExpansionEvent;
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
import org.eclipse.swt.widgets.TreeItem;
import org.jboss.tools.smooks.configuration.editors.javabean12.JavaBeanModel;
import org.jboss.tools.smooks.configuration.editors.javabean12.JavaBeanModelFactory;
import org.jboss.tools.smooks.configuration.editors.javabean12.JavabeanContentProvider;
import org.jboss.tools.smooks.configuration.editors.javabean12.JavabeanlabelProvider;
import org.jboss.tools.smooks.configuration.editors.utils.JavaTypeFieldDialog;
import org.jboss.tools.smooks.configuration.editors.utils.ProjectClassLoader;

/**
 * @author Dart
 * 
 */
public class JavaBeanCreationWizardPage extends WizardPage {

	private String beanID = null;

	private String beanClass = null;

	private IJavaProject project;

	private String collectionClass = null;

	private boolean isArray = false;

	private boolean isCollection = false;

	private List<String> exsitingBeanIDs = null;

	private JavaBeanModel javaBeanModel = null;

	private CheckboxTreeViewer viewer;

	private Button arrayButton;

	private Button collectionClassBrowseButton;

	private Text colllectionClassText;
	
	private ICheckStateListener checkStateListener = null;

	public JavaBeanCreationWizardPage(String pageName, String title,
			ImageDescriptor titleImage, IJavaProject project,
			List<String> exsitingBeanIDs) {
		super(pageName, title, titleImage);
		this.project = project;
		this.exsitingBeanIDs = exsitingBeanIDs;
		this.setTitle(Messages.JavaBeanCreationWizardPage_WizardTitle);
		this.setDescription(Messages.JavaBeanCreationWizardPage_WizardDes);
	}

	public JavaBeanCreationWizardPage(String pageName, IJavaProject project,
			List<String> exsitingBeanIDs) {
		super(pageName);
		this.project = project;
		this.exsitingBeanIDs = exsitingBeanIDs;
		this.setTitle(Messages.JavaBeanCreationWizardPage_WizardTitle);
		this.setDescription(Messages.JavaBeanCreationWizardPage_WizardDes);
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

		createBeanIDControls(mainComposite);

		createBeanClassControls(mainComposite);

		// createBeanTypeControls(mainComposite);

		Label seperator = new Label(mainComposite, SWT.HORIZONTAL
				| SWT.SEPARATOR);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		gd.heightHint = 18;
		seperator.setLayoutData(gd);

		createBindingPropertyViewer(mainComposite);

		setControl(mainComposite);

		this.setPageComplete(false);

	}

	private void createBindingPropertyViewer(Composite mainComposite) {
		GridData gd = new GridData(GridData.FILL_BOTH);
		viewer = new CheckboxTreeViewer(mainComposite, SWT.BORDER);
		gd.horizontalSpan = 2;
		gd.heightHint = 250;
		viewer.getControl().setLayoutData(gd);

		viewer.setContentProvider(new JavabeanContentProvider() {

			/*
			 * (non-Javadoc)
			 * 
			 * @seeorg.jboss.tools.smooks.configuration.editors.javabean.
			 * JavabeanContentProvider#hasChildren(java.lang.Object)
			 */
			@Override
			public boolean hasChildren(Object bean) {
				return super.hasChildren(bean);
			}

		});
		viewer.setLabelProvider(new JavabeanlabelProvider());

		viewer.addTreeListener(new ITreeViewerListener() {

			private Map<String, Object> expandRecord = new HashMap<String, Object>();

			public void treeExpanded(TreeExpansionEvent event) {
				Object element = event.getElement();
				if (element instanceof TreeItem) {
					element = ((TreeItem) element).getData();
				}
				if (element instanceof JavaBeanModel) {
					Object key = expandRecord.get(((JavaBeanModel) element)
							.getID().toString());
					if (key == null) {
						expandRecord.put(((JavaBeanModel) element).getID()
								.toString(), new Object());
						if (viewer.getChecked(element)) {
							for (Iterator<?> iterator = ((JavaBeanModel) element)
									.getChildren().iterator(); iterator
									.hasNext();) {
								Object child = (Object) iterator.next();
								viewer.setChecked(child, true);
							}
						}
					}
				}
			}

			public void treeCollapsed(TreeExpansionEvent event) {

			}
		});

		checkStateListener = new ICheckStateListener() {

			public void checkStateChanged(CheckStateChangedEvent event) {
				modelClassStringList.clear();
				Object element = event.getElement();
				CheckboxTreeViewer viewer = (CheckboxTreeViewer) event
						.getSource();
				boolean checked = event.getChecked();
				if (checked) {
					checkParents(element, viewer);
					checkChildren((JavaBeanModel) element, true);
				} else {
					unCheckChildren(element, viewer);
				}
			}

			private void unCheckChildren(Object element,
					CheckboxTreeViewer viewer) {
				ITreeContentProvider provider = (ITreeContentProvider) viewer
						.getContentProvider();
				if (element instanceof JavaBeanModel) {
					if (provider.hasChildren(element)
							&& ((JavaBeanModel) element).isExpaned()) {
						Object[] children = provider.getChildren(element);
						for (int i = 0; i < children.length; i++) {
							Object child = children[i];
							viewer.setChecked(child, false);
							unCheckChildren(child, viewer);
						}
					}
				}
			}

			private void checkChildren(JavaBeanModel model, boolean flag) {
				((JavaBeanModel) model).getChildren();
				if (((JavaBeanModel) model).isExpaned()) {
					for (Iterator<?> iterator = ((JavaBeanModel) model)
							.getChildren().iterator(); iterator.hasNext();) {
						JavaBeanModel child = (JavaBeanModel) iterator.next();
						if (containts(child)) {
							continue;
						} else {
							record(child);
						}
						viewer.setChecked(child, flag);
						checkChildren(child, flag);
					}
				}
			}

			private void checkParents(Object element,
					final CheckboxTreeViewer viewer) {
				ITreeContentProvider provider = (ITreeContentProvider) viewer
						.getContentProvider();
				Object parent = provider.getParent(element);
				if (containts(parent)) {
					return;
				} else {
					record(parent);
				}
				if (parent != null && !viewer.getChecked(parent)) {
					viewer.setChecked(parent, true);
					checkParents(parent, viewer);
				}
			}

			private List<Class> modelClassStringList = new ArrayList<Class>();

			private boolean containts(Object model) {
				if (model instanceof JavaBeanModel) {
					Class clazz = ((JavaBeanModel) model).getBeanClass();
					if(JavaBeanModelFactory.isPrimitiveObject(clazz)){
						return false;
					}
					return modelClassStringList.contains(clazz);
				}
				return false;
			}

			private void record(Object model) {
				if (model instanceof JavaBeanModel) {
					Class clazz = ((JavaBeanModel) model).getBeanClass();
					modelClassStringList.add(clazz);
				}
			}
		}; 
		
		viewer.addCheckStateListener(checkStateListener);
	}

	public Object[] getSelectionProperties() {
		if (viewer != null)
			return viewer.getCheckedElements();
		return null;
	}

	private void createBeanTypeControls(Composite mainComposite) {

		GridData gd;

		Label beanTypeLabel = new Label(mainComposite, SWT.NONE);
		beanTypeLabel
				.setText(Messages.JavaBeanCreationWizardPage_BeanTypeLabel);

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
		arrayButton
				.setText(Messages.JavaBeanCreationWizardPage_ArrayButtonText);

		final Button collectionButton = new Button(composite, SWT.CHECK);
		collectionButton
				.setText(Messages.JavaBeanCreationWizardPage_CollectionButtonLabel);

		Label beanClassLabel = new Label(mainComposite, SWT.NONE);
		beanClassLabel
				.setText(Messages.JavaBeanCreationWizardPage_CollectionClassLabel);

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
		collectionClassBrowseButton
				.setText(Messages.JavaBeanCreationWizardPage_BrowseButtonLabel);
		collectionClassBrowseButton
				.addSelectionListener(new SelectionAdapter() {

					/*
					 * (non-Javadoc)
					 * 
					 * @see
					 * org.eclipse.swt.events.SelectionAdapter#widgetSelected
					 * (org.eclipse .swt.events.SelectionEvent)
					 */
					@Override
					public void widgetSelected(SelectionEvent e) {
						String classString = JavaTypeFieldDialog
								.openJavaTypeDialog(getShell(), project);
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
				viewer.setInput(""); //$NON-NLS-1$
			}

		});
		collectionButton.setVisible(false);
		// beanClassComposite.setVisible(false);
		// beanClassLabel.setVisible(false);
	}

	protected void refreshJavaBeanModel() {
		if (beanClass == null || "".equals(beanClass.trim())) { //$NON-NLS-1$
			viewer.setInput(""); //$NON-NLS-1$
		} else {
			try {
				ProjectClassLoader loader = new ProjectClassLoader(project);
				javaBeanModel = null;
				isCollection = isCollectionClass(beanClass);
				Class<?> clazz = loader.loadClass(beanClass);

				javaBeanModel = JavaBeanModelFactory
						.getJavaBeanModelWithLazyLoad(clazz);
				if (javaBeanModel != null) {
					if (beanID != null) {
						javaBeanModel.setName(beanID);
					}
					if (!isCollection) {
						viewer.setInput(javaBeanModel.getChildren());
					}
					Object[] nodes = javaBeanModel.getChildren().toArray();
					for (int i = 0; i < nodes.length; i++) {
						Object node = nodes[i];
						viewer.setChecked(node, true);
						checkStateListener.checkStateChanged(new CheckStateChangedEvent(viewer, node, true));
					}
//					viewer.setCheckedElements(javaBeanModel.getChildren().toArray());
				} else {
					viewer.setInput(""); //$NON-NLS-1$
				}
			} catch (JavaModelException e1) {
				viewer.setInput(""); //$NON-NLS-1$
			} catch (ClassNotFoundException e1) {
				viewer.setInput(""); //$NON-NLS-1$
			}
		}
	}

	private void createBeanClassControls(Composite mainComposite) {
		Label beanClassLabel = new Label(mainComposite, SWT.NONE);
		beanClassLabel
				.setText(Messages.JavaBeanCreationWizardPage_BeanClassLabel);

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
				beanClass = t.getText();
				if (beanClass != null) {
					beanClass = beanClass.trim();
				}
				isCollection = isCollectionClass(beanClass);
				refreshJavaBeanModel();
				updateWizardPageStatus();
			}
		});

		beanClassComposite.setLayoutData(gd);

		Button javaTypeBrowseButton = new Button(beanClassComposite, SWT.NONE);
		javaTypeBrowseButton
				.setText(Messages.JavaBeanCreationWizardPage_BrowseButtonLabel);
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
				String classString = JavaTypeFieldDialog.openJavaTypeDialog(
						getShell(), project,
						IJavaElementSearchConstants.CONSIDER_CLASSES);
				if (classString != null)
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

	private void createBeanIDControls(Composite mainComposite) {
		Label beanIDLabel = new Label(mainComposite, SWT.NONE);
		beanIDLabel.setText(Messages.JavaBeanCreationWizardPage_BeanIDLabel);

		Text beanIDText = new Text(mainComposite, SWT.BORDER);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		beanIDText.setLayoutData(gd);
		beanIDText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				Text t = (Text) e.getSource();
				beanID = t.getText();
				updateWizardPageStatus();
				if (javaBeanModel != null) {
					javaBeanModel.setName(beanID);
				}
			}

		});
	}

	protected void updateWizardPageStatus() {
		String error = null;
		if (beanID == null || "".equals(beanID.trim())) { //$NON-NLS-1$
			error = Messages.JavaBeanCreationWizardPage_BeanIDEmptyErrorMessage;
		} else {
			if (exsitingBeanIDs != null) {
				beanID = beanID.trim();
				for (Iterator<?> iterator = exsitingBeanIDs.iterator(); iterator
						.hasNext();) {
					String id = (String) iterator.next();
					if (id.equals(beanID)) {
						error = Messages.JavaBeanCreationWizardPage_BeanIDDuplicateErrorMessage1
								+ beanID
								+ Messages.JavaBeanCreationWizardPage_BeanIDDuplicateErrorMessage2;
					}
				}
			}
		}
		if (beanClass == null || "".equals(beanClass.trim())) { //$NON-NLS-1$
			error = Messages.JavaBeanCreationWizardPage_BeanClassEmptyErrorMessage;
		} else {
			try {
				beanClass = beanClass.trim();
				ProjectClassLoader loader = new ProjectClassLoader(project);
				Class<?> clazz = loader.loadClass(beanClass);
				if (Modifier.isAbstract(clazz.getModifiers())) {
					error = Messages.JavaBeanCreationWizardPage_Error_Abstract;
				} else {
					try {
						clazz.getConstructor(null);
					} catch (SecurityException e) {
						error = Messages.JavaBeanCreationWizardPage_Error_Cannot_Be_Instantiated;
					} catch (NoSuchMethodException e) {
						error = Messages.JavaBeanCreationWizardPage_Error_Class_Needs_Public_Default_Const;
					}
				}
			} catch (JavaModelException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				error = Messages.JavaBeanCreationWizardPage_CatFindClassErrorMessage1
						+ beanClass + Messages.JavaBeanCreationWizardPage_27;
			}
		}

		this.setErrorMessage(error);
		this.setPageComplete(error == null);
	}

}
