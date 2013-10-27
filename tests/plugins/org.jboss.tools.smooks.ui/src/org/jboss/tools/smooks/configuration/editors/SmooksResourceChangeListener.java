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
package org.jboss.tools.smooks.configuration.editors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchWindow;
import org.jboss.tools.smooks.configuration.SmooksConfigurationActivator;
import org.jboss.tools.smooks.editor.AbstractSmooksFormEditor;

/**
 * @author Dart (dpeng@redhat.com)
 *         <p>
 *         Apr 12, 2009
 */
public class SmooksResourceChangeListener implements IResourceChangeListener {
	public static final String SMOOKS_CONTENTTYPE_ID = "org.jboss.tools.smooks.ui.smooks.contentType"; //$NON-NLS-1$

	private IEditorPart currentEditPart = null;

	public SmooksResourceChangeListener(IEditorPart editorPart) {
		this.currentEditPart = editorPart;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.resources.IResourceChangeListener#resourceChanged(org
	 * .eclipse.core.resources.IResourceChangeEvent)
	 */
	public void resourceChanged(IResourceChangeEvent event) {
		try {
			switch (event.getType()) {
			case IResourceChangeEvent.POST_CHANGE:
				event.getDelta().accept(new ChangePartNameVisitor());
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	class ChangePartNameVisitor implements IResourceDeltaVisitor {

		// int count = 0;

		public boolean visit(IResourceDelta delta) {
			if (delta == null
					|| !delta.getResource().equals(((IFileEditorInput) currentEditPart.getEditorInput()).getFile()))
				return true;
			IResource res = delta.getResource();
			if (res instanceof IFile) {
				IFile file = (IFile) res;
				IContentDescription contentDescription;
				IContentType contentType = null;
				try {
					contentDescription = file.getContentDescription();
					if (contentDescription == null) {
						return true;
					}
					contentType = contentDescription.getContentType();

				} catch (CoreException e) {
					if (e.getStatus().getCode() == IResourceStatus.OUT_OF_SYNC_LOCAL) {
						// Determine the content type from the file name.
						contentType = Platform.getContentTypeManager().findContentTypeFor(file.getName());
					}
				}
				if (contentType == null || !SMOOKS_CONTENTTYPE_ID.equals(contentType.getId())) {
					return true;
				}
				int flags = delta.getFlags();
				switch (delta.getKind()) {
				case IResourceDelta.ADDED:
					if (flags == IResourceDelta.MOVED_FROM) {
						IPath path = delta.getMovedFromPath();
						String fileName = ""; //$NON-NLS-1$
						if (path != null) {
							fileName = path.lastSegment();
						}

						IPath newPath = res.getFullPath();
						String newfileName = newPath.lastSegment();
						if (fileName.equals(newfileName)) {
							return true;
						}
						final String newPartName = newfileName;
						final IPath fOldPath = path;
						Display.getDefault().syncExec(new Runnable() {

							public void run() {
								IWorkbenchWindow window = SmooksConfigurationActivator.getDefault().getWorkbench()
										.getActiveWorkbenchWindow();
								if (window != null) {
									IEditorReference[] editorReferences = window.getActivePage().getEditorReferences();
									for (int i = 0; i < editorReferences.length; i++) {
										IEditorReference iEditorReference = editorReferences[i];
										IEditorPart editorPart = iEditorReference.getEditor(false);
										if (editorPart != currentEditPart)
											continue;

										IEditorInput editorInput = editorPart.getEditorInput();
										if (editorInput instanceof IFileEditorInput) {
											IFile relatedFile = ((IFileEditorInput) editorInput).getFile();
											if (relatedFile != null && relatedFile.getFullPath().equals(fOldPath)) {
												if (editorPart instanceof AbstractSmooksFormEditor) {
//													((AbstractSmooksFormEditor) editorPart).setPartName(newPartName);
													break;
												}
											}
										}
									}
								}
							}
						});
					}
					break;
				case IResourceDelta.REMOVED:
					// if (flags == IResourceDelta.MOVED_TO) {
					// break;
					// }
					// IProject project = res.getProject();
					// try {
					// if (project.isOpen()) {
					// IProjectNature nature =
					// project.getNature(JavaCore.NATURE_ID);
					// if (nature != null) {
					// IJavaProject javaProject = JavaCore.create(project);
					// IPath outPut = javaProject.getOutputLocation();
					// IPath removeRes = res.getFullPath();
					// if (outPut.isPrefixOf(removeRes)) {
					// break;
					// }
					// }
					// }
					// } catch (CoreException e) {
					// e.printStackTrace();
					// }
					// IPath path = res.getFullPath();
					// String fileName = path.lastSegment();
					//					fileName += SmooksConstants.SMOOKS_GRAPHICSEXT_EXTENTION_NAME_WITHDOT; //$NON-NLS-1$
					// path = path.removeLastSegments(1).append(fileName);
					// deleteFile(path);
					break;
				}
			}
			return true; // visit the children
		}
	}

}
