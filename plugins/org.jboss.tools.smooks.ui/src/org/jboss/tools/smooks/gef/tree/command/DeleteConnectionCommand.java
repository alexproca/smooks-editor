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
package org.jboss.tools.smooks.gef.tree.command;

import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.commands.Command;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class DeleteConnectionCommand extends Command {

	protected TreeNodeConnection connection;

	public DeleteConnectionCommand(TreeNodeConnection connection) {
		Assert.isNotNull(connection);
		this.connection = connection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		if (this.connection != null) {
			return true;
		}
		return super.canExecute();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canUndo()
	 */
	@Override
	public boolean canUndo() {
		if (this.connection != null) {
			if (connection.getSourceNode() != null && connection.getTargetNode() != null)
				return true;
		}
		return super.canUndo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		super.execute();
		this.connection.disconnect();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	@Override
	public void redo() {
		super.redo();
		this.connection.disconnect();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		super.undo();
		this.connection.connect();
	}

}
