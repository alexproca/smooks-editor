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

import java.util.Iterator;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.jboss.tools.smooks.gef.common.SmooksGraphicalMenuContextProvider;
import org.jboss.tools.smooks.graphical.actions.AddSmooksModelAction;
import org.jboss.tools.smooks.graphical.actions.AutoLayoutAction;

/**
 * @author Dart
 * 
 */
public class SmooksGraphicalEditorMenuContextProvider extends SmooksGraphicalMenuContextProvider {

	public SmooksGraphicalEditorMenuContextProvider(EditPartViewer viewer, ActionRegistry actionRegistry) {
		super(viewer, actionRegistry);
		// TODO Auto-generated constructor stub
	}

	public void buildContextMenu(IMenuManager menu) {
		super.buildContextMenu(menu);
		MenuManager addChildActionMenu = new MenuManager(Messages.SmooksGraphicalEditorMenuContextProvider_Add_Menu_Text);
		menu.appendToGroup(GROUP_CUSTOME, addChildActionMenu);

		Iterator<?> iterator = getActionRegistry().getActions();
//		while (iterator.hasNext()) {
//			Object obj = iterator.next();
//			if (obj instanceof AddSmooksModelAction) {
//				if (((IAction) obj).isEnabled()
//						&& (obj instanceof AddElementAction || obj instanceof AddAttributeAction)) {
//					addChildActionMenu.add((IAction) obj);
//				}
//			}
//		}
//		iterator = getActionRegistry().getActions();
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			if (obj instanceof AddSmooksModelAction) {
				if (((IAction) obj).isEnabled()){//						&& !(obj instanceof AddElementAction || obj instanceof AddAttributeAction)) {
					addChildActionMenu.add((IAction) obj);
				}
			}
		}
		IAction action = getActionRegistry().getAction(AutoLayoutAction.ID);
		if (action != null) {
			menu.appendToGroup(GEFActionConstants.GROUP_VIEW, action);
		}
	}

}
