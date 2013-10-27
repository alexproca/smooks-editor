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
package org.jboss.tools.smooks.gef.tree.editpolicy;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.jboss.tools.smooks.gef.tree.command.DeleteConnectionCommand;
import org.jboss.tools.smooks.gef.tree.editparts.TreeNodeConnectionEditPart;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class TreeNodeConnectionEditPolicy extends ConnectionEditPolicy {

	public TreeNodeConnectionEditPolicy() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.editpolicies.ConnectionEditPolicy#getDeleteCommand(org
	 * .eclipse.gef.requests.GroupRequest)
	 */
	@Override
	protected Command getDeleteCommand(GroupRequest request) {
		Object connection = getHost().getModel();
		EditPart host = getHost();
		if (connection != null && connection instanceof TreeNodeConnection) {
			if(host instanceof TreeNodeConnectionEditPart){
				if(!((TreeNodeConnectionEditPart)host).isCanDelete()){
					return null;
				}
			}
			DeleteConnectionCommand command = new DeleteConnectionCommand((TreeNodeConnection) connection);
			return command;
		}
		return null;
	}

}
