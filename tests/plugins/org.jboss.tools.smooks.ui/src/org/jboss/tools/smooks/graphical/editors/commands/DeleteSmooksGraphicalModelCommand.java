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
package org.jboss.tools.smooks.graphical.editors.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;

/**
 * @author Dart
 *
 */
public class DeleteSmooksGraphicalModelCommand extends Command {
	
	private AbstractSmooksGraphicalModel graphModel;
	
	private AbstractSmooksGraphicalModel parentModel;
	
	private List<TreeNodeConnection> deletedConnections = new ArrayList<TreeNodeConnection>();
	
	private int oldIndex = -1;
	
	public DeleteSmooksGraphicalModelCommand(AbstractSmooksGraphicalModel graphModel){
		this.graphModel = graphModel;
		this.parentModel = graphModel.getParent();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		if(graphModel != null && parentModel != null){
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		if (deletedConnections != null) {
			deletedConnections.clear();
		} else {
			deletedConnections = new ArrayList<TreeNodeConnection>();
		}
		oldIndex = parentModel.getChildrenWithoutDynamic().indexOf(graphModel);
		AbstractSmooksGraphicalModel.disconnectAllConnectionsWithEvent(graphModel, deletedConnections);
		parentModel.removeChild(graphModel);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	@Override
	public void redo() {
		super.redo();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		if(oldIndex != -1 && parentModel != null){
			parentModel.addChild(oldIndex, graphModel);
			reconnectAllConnections();
		}
		super.undo();
	}
	
	private void reconnectAllConnections() {
		if (deletedConnections != null) {
			for (Iterator<?> iterator = deletedConnections.iterator(); iterator.hasNext();) {
				TreeNodeConnection connection = (TreeNodeConnection) iterator.next();
				connection.connect();
			}
		}
	}

}
