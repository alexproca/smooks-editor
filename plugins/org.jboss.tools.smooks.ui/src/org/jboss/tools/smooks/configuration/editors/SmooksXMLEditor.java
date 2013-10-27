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
package org.jboss.tools.smooks.configuration.editors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.wst.sse.ui.StructuredTextEditor;
import org.jboss.tools.smooks.editor.AbstractSmooksFormEditor;

/**
 * @author Dart Peng (dpeng@redhat.com) Date Apr 1, 2009
 */
public class SmooksXMLEditor extends StructuredTextEditor {

	private IEditorPart parentEditorPart;

	public IEditorPart getParentEditorPart() {
		return parentEditorPart;
	}

	public void setParentEditorPart(IEditorPart parentEditorPart) {
		this.parentEditorPart = parentEditorPart;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.wst.sse.ui.StructuredTextEditor#doSetInput(org.eclipse.ui
	 * .IEditorInput)
	 */
	@Override
	public void doSetInput(IEditorInput input) throws CoreException {

		System.out.println(((IFileEditorInput) input).getFile()
				.getFileExtension());

		final IFile newFile = ((IFileEditorInput) input).getFile();
		if ("xml".equals(newFile.getFileExtension())) {
			// try {
			// ((SmooksXMLEditor) textEditor).doSetInput(new
			// FileEditorInput(newFile));
			// } catch (CoreException e) {
			// e.printStackTrace();
			// }

		} else {
			boolean yes = MessageDialog
					.openQuestion(
							getSite().getShell(),
							"Warning",
							"The extension of the open Smooks configuration file is no longer correct and will cause exceptions in the editor if you continue. Do you want to close this editor and reopen the file?");
			if (yes) {
				if (parentEditorPart != null) {
					 ((AbstractSmooksFormEditor)
					 parentEditorPart).close(true);
				}
				Display.getDefault().asyncExec(new Runnable() {

					public void run() {
						try {
							IWorkbenchPage page = PlatformUI.getWorkbench()
									.getActiveWorkbenchWindow().getActivePage();
							FileEditorInput editorInput = new FileEditorInput(newFile);
							page.openEditor(editorInput, "org.eclipse.ui.DefaultTextEditor", true);
						} catch (Throwable t) {
							t.printStackTrace();
						}
					}

				});
				return;
			} else {
//				setInput(new FileEditorInput(newFile));
			}
		}

		super.doSetInput(input);
	}

}
