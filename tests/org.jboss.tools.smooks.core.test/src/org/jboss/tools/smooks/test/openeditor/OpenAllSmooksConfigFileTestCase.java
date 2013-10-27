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
package org.jboss.tools.smooks.test.openeditor;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;

import junit.framework.Assert;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.editor.AbstractSmooksFormEditor;

/**
 * @author Dart
 * 
 */
public class OpenAllSmooksConfigFileTestCase extends AbstractSmooksEditorTestcase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.test.openeditor.AbstractSmooksEditorTestcase#setUp
	 * ()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		for (Iterator<?> iterator = editorList.iterator(); iterator.hasNext();) {
			IEditorPart editor = (IEditorPart) iterator.next();
			editor.dispose();
		}
		editorList.clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.test.openeditor.AbstractSmooksEditorTestcase#tearDown
	 * ()
	 */
	@Override
	protected void tearDown() throws Exception {
		for (Iterator<?> iterator = editorList.iterator(); iterator.hasNext();) {
			IEditorPart editor = (IEditorPart) iterator.next();
			editor.dispose();
		}
		editorList.clear();
		super.tearDown();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.test.openeditor.AbstractSmooksEditorTestcase#
	 * getTestProjectName()
	 */
	@Override
	protected String getTestProjectName() {
		return "smooks-all-config-files";
	}

	public void testOpenAllFiles() throws URISyntaxException, PartInitException, IOException {
		if (this.testProject != null) {
			IFolder folder = testProject.getFolder("smooks-config-files");
			if (folder.exists()) {
				File file = folder.getLocation().toFile();
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					File childFile = files[i];
					IFile cf = folder.getFile(childFile.getName());
					if (SmooksUIUtils.isSmooksFile(cf)) {
						IWorkbenchWindow window = WorkBench.getActiveWorkbenchWindow();
						IEditorPart part = IDE.openEditor(window.getActivePage(), cf);
						Assert.assertNotNull(part);
						Assert.assertTrue(
								"Editor isn't Smooks editor , there are some errors occur when create Smooks Editor for file : '"
										+ cf.getName() + "'", (part instanceof AbstractSmooksFormEditor));
						System.out.println("successful to open file : '" + cf.getName() + "'");
					}
				}
			}
		}
	}
}
