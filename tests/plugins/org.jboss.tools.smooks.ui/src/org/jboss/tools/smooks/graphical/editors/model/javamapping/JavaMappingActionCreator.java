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
package org.jboss.tools.smooks.graphical.editors.model.javamapping;

import java.util.List;

import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IEditorPart;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;

/**
 * @author Dart
 * 
 */
public class JavaMappingActionCreator {
	public void registXSLActions(ActionRegistry actionRegistry, List selectionActions, IEditorPart editorPart,
			ISmooksModelProvider smooksModelProvider) {
		IAction addBeanAction = new AddJavaBeanAction(editorPart, smooksModelProvider);
		actionRegistry.registerAction(addBeanAction);
		selectionActions.add(addBeanAction.getId());

		IAction addValueAction = new AddValueAction(editorPart, smooksModelProvider);
		actionRegistry.registerAction(addValueAction);
		selectionActions.add(addValueAction.getId());

		IAction addWiringAction = new AddWiringAction(editorPart, smooksModelProvider);
		actionRegistry.registerAction(addWiringAction);
		selectionActions.add(addWiringAction.getId());

		IAction addExpression = new AddExpressionAction(editorPart, smooksModelProvider);
		actionRegistry.registerAction(addExpression);
		selectionActions.add(addExpression.getId());
	}
}
