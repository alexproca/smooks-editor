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
package org.jboss.tools.smooks.graphical.actions;

import java.io.File;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.graphical.editors.SmooksGraphicalEditorPart;
import org.jboss.tools.smooks.graphical.editors.autolayout.IAutoLayout;

/**
 * @author Dart
 * 
 */
public class AutoLayoutAction extends SelectionAction {

	public static final String ID = "_smooks_auto_layout"; //$NON-NLS-1$

	public AutoLayoutAction(IWorkbenchPart part, int style) {
		super(part, style);
	}

	public AutoLayoutAction(IWorkbenchPart part) {
		super(part);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.setText(Messages.AutoLayoutAction_Action_Text);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#calculateEnabled()
	 */
	@Override
	protected boolean calculateEnabled() {
		IWorkbenchPart part = this.getWorkbenchPart();
		if (part instanceof SmooksGraphicalEditorPart) {
			IAutoLayout layout = ((SmooksGraphicalEditorPart) part).getAutoLayout();
			return (layout != null);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
//		if (false) {
//			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
//			File file = project.getLocation().toFile();
//			File[] children = file.listFiles();
//			for (int i = 0; i < children.length; i++) {
//				File child = children[i];
//				copySmooksFile(child, project);
//			}
//		}
		IWorkbenchPart part = this.getWorkbenchPart();
		if (part instanceof SmooksGraphicalEditorPart) {
			((SmooksGraphicalEditorPart) part).autoLayout(true);
		}
	}

	/**
	 * @deprecated
	 * @param file
	 * @param parent
	 */
	private void copySmooksFile(File file, IContainer parent) {
		if (file.exists()) {
			if (file.isFile()) {
				IFile ifile = parent.getFile(new Path(file.getName()));
				if (ifile.exists() && SmooksUIUtils.isSmooksFile(ifile)) {
					IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("validation-test"); //$NON-NLS-1$
					IFolder folder = project.getFolder("src"); //$NON-NLS-1$
					IFile newFile = folder.getFile(parent.getName()+ "_" + ifile.getName()); //$NON-NLS-1$
					try {
						if (newFile.exists()) {
							newFile.setContents(ifile.getContents(), true, false, null);
						} else {
							newFile.create(ifile.getContents(), true, null);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			if (file.isDirectory()) {
				IContainer container = parent.getFolder(new Path(file.getName()));
				if (container.exists()) {
					File[] files = file.listFiles();
					for (int i = 0; i < files.length; i++) {
						File file2 = files[i];
						copySmooksFile(file2, container);
					}
				}
			}
		}
	}

}
