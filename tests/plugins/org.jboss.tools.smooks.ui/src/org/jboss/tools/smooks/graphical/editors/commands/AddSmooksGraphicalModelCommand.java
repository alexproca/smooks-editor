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

import org.eclipse.gef.commands.Command;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;

/**
 * @author Dart
 *
 */
public class AddSmooksGraphicalModelCommand extends Command {
	private int index = -1;
	
	private AbstractSmooksGraphicalModel parentModel;
	
	private AbstractSmooksGraphicalModel childModel;
	
	public AddSmooksGraphicalModelCommand(AbstractSmooksGraphicalModel parentModel , AbstractSmooksGraphicalModel childModel){
		this.parentModel = parentModel;
		this.childModel = childModel;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		if(parentModel != null && childModel != null){
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#canUndo()
	 */
	@Override
	public boolean canUndo() {
		if(parentModel != null && childModel != null){
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		parentModel.addChild(childModel);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	@Override
	public void redo() {
		parentModel.addChild(index,childModel);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		index = parentModel.getChildren().indexOf(childModel);
		parentModel.removeChild(childModel);
	}
	
}
