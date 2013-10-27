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
package org.jboss.tools.smooks.graphical.editors;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.part.MultiPageEditorSite;

/**
 * @author Dart
 * 
 */
public class SmooksTaskDetailsEditorSite extends MultiPageEditorSite {

	private FormPage parentEditor = null;

	public SmooksTaskDetailsEditorSite(MultiPageEditorPart multiPageEditor, IEditorPart editor,
			FormPage parentEditor) {
		super(multiPageEditor, editor);
		this.parentEditor = parentEditor;
	}

	/**
	 * @return the parentEditor
	 */
	public FormPage getParentEditor() {
		return parentEditor;
	}

	/**
	 * @param parentEditor the parentEditor to set
	 */
	public void setParentEditor(FormPage parentEditor) {
		this.parentEditor = parentEditor;
	}
	
	

}
