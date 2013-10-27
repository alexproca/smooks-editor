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
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.configuration.editors.SmooksMultiFormEditor;
import org.jboss.tools.smooks.configuration.editors.javabean12.Messages;
import org.jboss.tools.smooks.configuration.editors.wizard.IStructuredDataSelectionWizard;

/**
 * @author Dart Peng
 * @Date Aug 5, 2008
 */
public class JavabeanStrucutredDataWizard extends Wizard implements
		IStructuredDataSelectionWizard, INewWizard {
	JavaBeanSelectionWizardPage page = null;
	IJavaProject project = null;
	
	
	public JavabeanStrucutredDataWizard() {
		super();
		this.setWindowTitle(Messages.JavabeanStrucutredDataWizard_WizardTitle);
	}

	public IJavaProject getProject() {
		return project;
	}

	public void setProject(IJavaProject project) {
		this.project = project;
	}

	Object result = null;
	Properties properties = new Properties();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		super.addPages();
		if (page == null) {
			page = new JavaBeanSelectionWizardPage("javaclass",project); //$NON-NLS-1$
			this.addPage(page);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		result = page.getJavaBeanModelList();
		return true;
	}

	public JavaBeanList getJavaBeanList() {
		JavaBeanList list = new JavaBeanList();
		if (result != null && result instanceof List<?>) {
			for (Iterator<?> iterator = ((List<?>) result).iterator(); iterator
					.hasNext();) {
				JavaBeanModel javabean = (JavaBeanModel) iterator.next();
				boolean isArray = "array".equals(javabean //$NON-NLS-1$
						.getExtendProperty("many")); //$NON-NLS-1$
				boolean isList = "list".equals(javabean //$NON-NLS-1$
						.getExtendProperty("many")); //$NON-NLS-1$
				if (isArray) {
					Object arrayInstance = Array.newInstance(javabean
							.getBeanClass(), 0);
					JavaBeanModel model = JavaBeanModelFactory
							.getJavaBeanModelWithLazyLoad(arrayInstance
									.getClass());
					list.addJavaBean(model);
					continue;
				}
				if(isList){
					JavaBeanModel model = JavaBeanModelFactory
							.getJavaBeanModelWithLazyLoad(ArrayList.class);
					model.setComponentClass(javabean.getBeanClass());
					list.addJavaBean(model);
					continue;
				}
				list.addJavaBean(javabean);
			}
		}
		if (list.getChildren().size() <= 0) {
			return null;
		}
		return list;
	}

	public Object getResult() {
		return result;
	}

	public Object getReturnData() {
		return getJavaBeanList();
	}

	public void init(IEditorSite site, IEditorInput input) {
		if (input != null && input instanceof IFileEditorInput) {
			IFileEditorInput fi = (IFileEditorInput) input;
			IProject project = fi.getFile().getProject();
			if (project instanceof IJavaProject) {
				this.project = (IJavaProject) project;
			} else {
				this.project = JavaCore.create(project);
			}
		}
	}

	public String getInputDataTypeID() {
		return SmooksModelUtils.INPUT_TYPE_JAVA;
	}

	public Properties getProperties() {
		return this.properties;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		if (selection != null) {
			Object obj = selection.getFirstElement();
			if (obj instanceof IJavaProject) {
				this.project = (IJavaProject) obj;
			}
			if (obj instanceof IResource) {
				IProject project = ((IResource) obj).getProject();
				this.project = JavaCore.create(project);
			}

			if (project == null) {
				if (obj instanceof IAdaptable) {
					IResource relateResource = (IResource) ((IAdaptable) obj)
							.getAdapter(IResource.class);
					IProject project = relateResource.getProject();
					this.project = JavaCore.create(project);
				}
			}
		}
	}

	public String getStructuredDataSourcePath() {
		List<JavaBeanModel> list = page.getJavaBeanModelList();
		StringBuffer buffer = new StringBuffer();
		for (Iterator<JavaBeanModel> iterator = list.iterator(); iterator
				.hasNext(); buffer.append(";")) { //$NON-NLS-1$
			JavaBeanModel javaBeanModel = (JavaBeanModel) iterator.next();
			Class<?> clazz = javaBeanModel.getBeanClass();
			if (clazz != null) {
				boolean isArray = clazz.isArray();
//				boolean isList = "list".equals(javaBeanModel
//						.getExtendProperty("many"));
				String cname = clazz.getName();
				if(isArray){
					cname = clazz.getComponentType().getName();
					cname = cname+ "[]"; //$NON-NLS-1$
				}
				buffer.append(cname);
			}
		}
		if(buffer.toString().endsWith(";")){ //$NON-NLS-1$
			return buffer.substring(0, buffer.length() - 1);
		}
		return buffer.toString();
	}

	public void complate(SmooksMultiFormEditor formEditor) {
		// TODO Auto-generated method stub
		
	}
}
