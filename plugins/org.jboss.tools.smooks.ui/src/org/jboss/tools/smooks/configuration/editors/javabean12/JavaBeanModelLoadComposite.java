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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.internal.corext.util.JavaModelUtil;
import org.eclipse.jdt.internal.ui.search.JavaSearchScopeFactory;
import org.eclipse.jdt.ui.IJavaElementSearchConstants;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.jboss.tools.smooks.configuration.SmooksConfigurationActivator;
import org.jboss.tools.smooks.configuration.editors.GraphicsConstants;
import org.jboss.tools.smooks.configuration.editors.uitls.ProjectClassLoader;

/**
 * @author Dart Peng
 * 
 * @CreateTime Jul 22, 2008
 */
public class JavaBeanModelLoadComposite extends Composite implements SelectionListener {

	private List<JavaBeanModel> javabeanList = new ArrayList<JavaBeanModel>();
	protected Text classText;
//	private Button classBrowseButton;
	protected String classFullName;
	protected boolean loadAtomic;
	protected IJavaProject javaProject;
	protected IRunnableContext runnableContext;
	protected JavaBeanModel currentRootJavaBeanModel = null;
	protected JavaBeanModel returnJavaBeanModel = null;

	private List<IJavaBeanSelectionListener> selectionListenerList = new ArrayList<IJavaBeanSelectionListener>();

	protected ProjectClassLoader loader = null;
	private TableViewer listViewer;

	public JavaBeanModelLoadComposite(Composite parent, int style, IRunnableContext runnableContext,
			IJavaProject project, boolean loadJavapropertiesAtomic) throws Exception {
		super(parent, style);
		loadAtomic = loadJavapropertiesAtomic;
		this.runnableContext = runnableContext;
		if (this.runnableContext == null) {
			this.runnableContext = SmooksConfigurationActivator.getDefault().getWorkbench()
					.getActiveWorkbenchWindow();
			// this.runnableContext = new
			// ProgressMonitorDialog(parent.getShell());
			if (this.runnableContext == null)
				throw new Exception("Init error"); //$NON-NLS-1$
		}

		if (project != null) {
			javaProject = project;
			loader = new ProjectClassLoader(javaProject);
		}

		createCompositeContent();
	}

	public JavaBeanModelLoadComposite(Composite parent, int style, IRunnableContext runnableContext,
			IJavaProject project) throws Exception {
		this(parent, style, runnableContext, project, true);
	}

	public List<JavaBeanModel> getJavabeanList() {
		return javabeanList;
	}

	public void addJavaBeanSelectionListener(IJavaBeanSelectionListener listener) {
		this.selectionListenerList.add(listener);
	}

	public void removeJavaBeanSelectionListener(IJavaBeanSelectionListener listener) {
		this.selectionListenerList.remove(listener);
	}

	public void setJavabeanList(List<JavaBeanModel> javabeanList) {
		this.javabeanList = javabeanList;
	}

	protected Control createCompositeContent() {
		Composite parent = this;
		parent.setLayout(new FillLayout());
		Composite com = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		com.setLayout(layout);

		Label classLabel = new Label(com, SWT.NULL);
		classLabel.setText("Class : "); //$NON-NLS-1$
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		classLabel.setLayoutData(gd);

		Composite listViewerComposite = new Composite(com, SWT.NONE);
		GridLayout listLayout = new GridLayout();
		listLayout.numColumns = 2;
		listViewerComposite.setLayout(listLayout);
		gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 2;
		listViewerComposite.setLayoutData(gd);

		listViewer = new TableViewer(listViewerComposite, SWT.BORDER |SWT.FULL_SELECTION);
		TableColumn nameColumn = new TableColumn(listViewer.getTable(), SWT.NONE);
		nameColumn.setText("Class"); //$NON-NLS-1$
		TableColumn isArrayColumn = new TableColumn(listViewer.getTable(), SWT.NONE);
		isArrayColumn.setText("Is Array"); //$NON-NLS-1$
//		TableColumn isListColumn = new TableColumn(listViewer.getTable(), SWT.NONE);
//		isListColumn.setText("List");

		nameColumn.setWidth(400);
		isArrayColumn.setWidth(60);
//		isListColumn.setWidth(60);

		listViewer.getTable().setHeaderVisible(true);

		gd = new GridData(GridData.FILL_BOTH);
		listViewer.getTable().addMouseListener(new ColumnSelectionListener());
		listViewer.getControl().setLayoutData(gd);
		listViewer.setContentProvider(new IStructuredContentProvider() {

			public Object[] getElements(Object inputElement) {
				if (inputElement instanceof List) {
					return ((List<?>) inputElement).toArray();
				}
				return new Object[] {};
			}

			public void dispose() {

			}

			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

			}

		});
		listViewer.setLabelProvider(new BeanViewerLabelProvider());
		listViewer.setInput(javabeanList);

		Composite buttonArea = new Composite(listViewerComposite, SWT.NONE);
		gd = new GridData(GridData.FILL_VERTICAL);
		buttonArea.setLayoutData(gd);

		GridLayout buttonAreaLayout = new GridLayout();
		buttonArea.setLayout(buttonAreaLayout);

		Button addButton = new Button(buttonArea, SWT.NONE);
		addButton.setText("Add"); //$NON-NLS-1$
		gd = new GridData(GridData.FILL_HORIZONTAL);
		addButton.setLayoutData(gd);
		addButton.addSelectionListener(this);

		Button removeButton = new Button(buttonArea, SWT.NONE);
		removeButton.setText("Remove"); //$NON-NLS-1$
		gd = new GridData(GridData.FILL_HORIZONTAL);
		removeButton.setLayoutData(gd);
		removeButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection selection = (IStructuredSelection) listViewer.getSelection();
				if (selection.isEmpty())
					return;
				javabeanList.removeAll(selection.toList());
				listViewer.refresh();
			}

		});
		return com;
	}

	public ProjectClassLoader getProjectClassLoader() {
		if (loader == null) {
			try {
				loader = new ProjectClassLoader(javaProject);
			} catch (Exception e) {
			}
		}
		return loader;
	}

	public void widgetDefaultSelected(SelectionEvent arg0) {
		this.widgetSelected(arg0);

	}

	public void widgetSelected(SelectionEvent arg0) {

		IJavaSearchScope scope = null;
		if (javaProject == null) {
			scope = JavaSearchScopeFactory.getInstance().createWorkspaceScope(true);
		} else {
			String[] requiredProjects = null;
			try {
				requiredProjects = javaProject.getRequiredProjectNames();
			} catch (Exception e) {
			}
			if (requiredProjects == null) {
				requiredProjects = new String[] { javaProject.getElementName() };
			} else {
				String[] temp = new String[requiredProjects.length + 1];
				temp[0] = javaProject.getElementName();
				System.arraycopy(requiredProjects, 0, temp, 1, requiredProjects.length);
				requiredProjects = temp;
			}
			scope = JavaSearchScopeFactory.getInstance().createJavaProjectSearchScope(requiredProjects, true);
		}
		SelectionDialog dialog;
		Throwable exception = null;
		try {
			dialog = JavaUI.createTypeDialog(this.getShell(), runnableContext, scope,
					IJavaElementSearchConstants.CONSIDER_CLASSES_AND_INTERFACES, false);
			dialog.setMessage("Search Java Class"); //$NON-NLS-1$
			dialog.setTitle("Search"); //$NON-NLS-1$

			if (dialog.open() == Window.OK) {
				Object[] results = dialog.getResult();
				if (results.length > 0) {
					Object result = results[0];
					String packageFullName = JavaModelUtil.getTypeContainerName((IType) result);
					String className = null;
					if (packageFullName == null || packageFullName.length() <= 0) {
						className = ((IType) result).getElementName();
					} else {
						className = packageFullName + "." //$NON-NLS-1$
								+ ((IType) result).getElementName();
					}
					if (className != null) {
						ClassLoader l = this.getProjectClassLoader();
						if (l != null) {
							Class clazz = l.loadClass(className);
							if (clazz != null) {
								JavaBeanModel model = JavaBeanModelFactory
										.getJavaBeanModelWithLazyLoad(clazz);
								javabeanList.add(model);
								listViewer.refresh();
							}
						}

					}
				}
			}
		} catch (Throwable e) {
			exception = e;
		}

		for (Iterator<IJavaBeanSelectionListener> iterator = this.selectionListenerList.iterator(); iterator
				.hasNext();) {
			IJavaBeanSelectionListener l = (IJavaBeanSelectionListener) iterator.next();
			if (exception != null) {
				l.exceptionOccur(new Exception(exception));
			} else {
				l.exceptionOccur(null);
			}
		}

	}

	private class BeanViewerCellModifyer implements ICellModifier {

		public boolean canModify(Object element, String property) {
			if (property.equals("name")) //$NON-NLS-1$
				return false;
			return true;
		}

		public Object getValue(Object element, String property) {
			if (element instanceof JavaBeanModel) {
				if (property.equals("array")) { //$NON-NLS-1$
					return ((JavaBeanModel) element).isArray();
				}
				if (property.equals("list")) { //$NON-NLS-1$
					return ((JavaBeanModel) element).isList();
				}
			}
			return Boolean.TRUE;
		}

		public void modify(Object element, String property, Object value) {

		}

	}

	private class BeanViewerLabelProvider extends LabelProvider implements ITableLabelProvider {

		public Image getColumnImage(Object element, int columnIndex) {

			if (element instanceof JavaBeanModel) {
				boolean isArray = "array".equals(((JavaBeanModel) element).getExtendProperty("many")); //$NON-NLS-1$ //$NON-NLS-2$
				boolean isList = "list".equals(((JavaBeanModel) element).getExtendProperty("many")); //$NON-NLS-1$ //$NON-NLS-2$
				switch (columnIndex) {
				case 0:
					if (isArray) {
						return SmooksConfigurationActivator.getDefault().getImageRegistry().get(
								GraphicsConstants.IMAGE_JAVA_ARRAY);
					}
					if (isList) {
						return SmooksConfigurationActivator.getDefault().getImageRegistry().get(
								GraphicsConstants.IMAGE_JAVA_COLLECTION);
					}
					return SmooksConfigurationActivator.getDefault().getImageRegistry().get(
							GraphicsConstants.IMAGE_JAVA_OBJECT);
				case 1:
					if (isArray) {
						return SmooksConfigurationActivator.getDefault().getImageRegistry().get(
								GraphicsConstants.IMAGE_CHECKBOX_CHECK);
					} else {
						return SmooksConfigurationActivator.getDefault().getImageRegistry().get(
								GraphicsConstants.IMAGE_CHECKBOX_UNCHECK);
					}
				case 2:
					if (isList) {
						return SmooksConfigurationActivator.getDefault().getImageRegistry().get(
								GraphicsConstants.IMAGE_CHECKBOX_CHECK);
					} else {
						return SmooksConfigurationActivator.getDefault().getImageRegistry().get(
								GraphicsConstants.IMAGE_CHECKBOX_UNCHECK);
					}
				}
			}
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof JavaBeanModel) {
				switch (columnIndex) {
				case 0:
					return ((JavaBeanModel) element).getBeanClassString();
				case 1:
					return null;
				case 2:
					return null;
				}
			}
			return null;
		}

	}

	public class ColumnSelectionListener implements MouseListener {

		public void widgetSelected(SelectionEvent e) {
		}

		public void widgetDefaultSelected(SelectionEvent e) {

		}

		public void mouseDoubleClick(MouseEvent e) {

		}

		public void mouseDown(MouseEvent e) {
			if (!(e.button == 1))
				return;
			ViewerCell cell = listViewer.getCell(new Point(e.x, e.y));
			if (cell != null) {
				Object element = cell.getElement();
				if (element instanceof JavaBeanModel) {
					if (cell.getColumnIndex() == 1) {
						String many = ((JavaBeanModel) element).getExtendProperty("many"); //$NON-NLS-1$
						if ("array".equals(many)) { //$NON-NLS-1$
							((JavaBeanModel) element).addExtendProperty("many", ""); //$NON-NLS-1$ //$NON-NLS-2$
						} else {
							((JavaBeanModel) element).addExtendProperty("many", "array"); //$NON-NLS-1$ //$NON-NLS-2$
						}
					}
					if (cell.getColumnIndex() == 2) {
						String many = ((JavaBeanModel) element).getExtendProperty("many"); //$NON-NLS-1$
						if ("list".equals(many)) { //$NON-NLS-1$
							((JavaBeanModel) element).addExtendProperty("many", ""); //$NON-NLS-1$ //$NON-NLS-2$
						} else {
							((JavaBeanModel) element).addExtendProperty("many", "list"); //$NON-NLS-1$ //$NON-NLS-2$
						}
					}
					try {
						listViewer.refresh(element);
					} catch (Exception e1) {
					}
				}
			}
		}

		public void mouseUp(MouseEvent e) {

		}
	}

}
