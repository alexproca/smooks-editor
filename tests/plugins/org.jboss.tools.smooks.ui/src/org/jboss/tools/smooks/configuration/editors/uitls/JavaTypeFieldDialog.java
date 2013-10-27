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
package org.jboss.tools.smooks.configuration.editors.uitls;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.internal.corext.util.JavaModelUtil;
import org.eclipse.jdt.internal.ui.search.JavaSearchScopeFactory;
import org.eclipse.jdt.ui.IJavaElementSearchConstants;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.jboss.tools.smooks.configuration.SmooksConfigurationActivator;

/**
 * @author Dart (dpeng@redhat.com)<p>
 * Apr 8, 2009
 */
public class JavaTypeFieldDialog implements IFieldDialog {
	
	IResource workspaceResource = null;
	
	public JavaTypeFieldDialog(IResource resource) {
		super();
		workspaceResource = resource;
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.configuration.editors.uitls.IFieldDialog#open()
	 */
	public Object open(Shell shell) {
		if (workspaceResource != null && workspaceResource instanceof IFile) {
			IProject project = ((IFile) workspaceResource).getProject();
			IJavaProject jp = JavaCore.create(project);
			if (jp != null) {
				return openJavaTypeDialog(shell, jp);
			}
		}
		MessageDialog.openInformation(shell, Messages.JavaTypeFieldDialog_CantOpenErrorTitle,
				Messages.JavaTypeFieldDialog_CantOpenErrorMessage);
		return null;
	}
	
	public static String openJavaTypeDialog(Shell shell, IJavaProject javaProject ) {
		return openJavaTypeDialog(shell, javaProject, IJavaElementSearchConstants.CONSIDER_CLASSES);
	}
	
	public static String openJavaTypeDialog(Shell shell, IJavaProject javaProject , int javaType) {
		IJavaSearchScope scope = null;
		String className = null;
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
		try {
			dialog = JavaUI.createTypeDialog(shell, SmooksConfigurationActivator.getDefault().getWorkbench()
					.getActiveWorkbenchWindow(), scope,javaType, false);
			dialog.setMessage(Messages.JavaTypeFieldDialog_SearchDialogTitle);
			dialog.setTitle(Messages.JavaTypeFieldDialog_SearchDialogTitle);
			if (dialog.open() == Window.OK) {
				Object[] results = dialog.getResult();
				if (results.length > 0) {
					Object result = results[0];
					String packageFullName = JavaModelUtil.getTypeContainerName((IType) result);
					if (packageFullName == null || packageFullName.length() <= 0) {
						className = ((IType) result).getElementName();
					} else {
						className = packageFullName + "." //$NON-NLS-1$
								+ ((IType) result).getElementName();
					}
					return className;
				}
			}
		} catch (Throwable t) {
			SmooksConfigurationActivator.getDefault().log(t);
		}
		return className;
	}

	public IModelProcsser getModelProcesser() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setModelProcesser(IModelProcsser processer) {
		// TODO Auto-generated method stub
		
	}


}
