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
package org.jboss.tools.smooks.edimap.editor;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.jboss.tools.smooks.edimap.actions.EDIMappingActionConstants;
import org.jboss.tools.smooks.gef.common.SmooksGraphicalMenuContextProvider;

/**
 * @author Dart (dpeng@redhat.com)
 *
 */
public class EDIMappingMenuContextProvider extends SmooksGraphicalMenuContextProvider {

	public EDIMappingMenuContextProvider(EditPartViewer viewer, ActionRegistry actionRegistry) {
		super(viewer, actionRegistry);
		// TODO Auto-generated constructor stub
	}
	
	public void buildContextMenu(IMenuManager menu) {
		super.buildContextMenu(menu);
		IAction action;
		action = getActionRegistry().getAction(EDIMappingActionConstants.ID_ADD_SEGEMENT_ACTION);
		if(action != null){
			menu.appendToGroup(GROUP_CUSTOME, action);
		}
		action = getActionRegistry().getAction(EDIMappingActionConstants.ID_ADD_FIELD_ACTION);
		if(action != null){
			menu.appendToGroup(GROUP_CUSTOME, action);
		}
		action = getActionRegistry().getAction(EDIMappingActionConstants.ID_ADD_COMPONENT_ACTION);
		if(action != null){
			menu.appendToGroup(GROUP_CUSTOME, action);
		}
		action = getActionRegistry().getAction(EDIMappingActionConstants.ID_ADD_SUBCOMPONENT_ACTION);
		if(action != null){
			menu.appendToGroup(GROUP_CUSTOME, action);
		}
	}

}
