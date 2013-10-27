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
package org.jboss.tools.smooks.graphical.editors.model.freemarker;

import java.util.List;

import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IEditorPart;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;

/**
 * @author Dart
 * 
 */
public class FreemarkerActionCreator {
	public void registActions(ActionRegistry actionRegistry, List selectionActions, IEditorPart editorPart,
			ISmooksModelProvider provider) {
		// add xsl actions

//		IAction addFreemarkerNodeAction = new AddFreemarkerAction(editorPart, provider);
//		actionRegistry.registerAction(addFreemarkerNodeAction);
//		selectionActions.add(addFreemarkerNodeAction.getId());

//		IAction addXSLNodeAction = new AddFreemarkerCSVRecordAction(editorPart);
//		actionRegistry.registerAction(addXSLNodeAction);
//		selectionActions.add(addXSLNodeAction.getId());

		IAction addFieldNodeAction = new AddFreemarkerCSVFieldAction(editorPart);
		actionRegistry.registerAction(addFieldNodeAction);
		selectionActions.add(addFieldNodeAction.getId());
	}
}
