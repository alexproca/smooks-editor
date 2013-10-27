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
package org.jboss.tools.smooks.edimap.actions;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.jboss.tools.smooks.gef.tree.command.GEFAdapterCommand;
import org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart;

/**
 * @author Dart (dpeng@redhat.com)
 *
 */
public class EDIGEFAdpaterCommand extends GEFAdapterCommand {
	
	protected TreeNodeEditPart editPart;

	public EDIGEFAdpaterCommand(TreeNodeEditPart editPart , EditingDomain domain, Command emfCommand) {
		super(domain, emfCommand);
		this.editPart = editPart;
	}
	
	protected void refreshEditPart(){
		editPart.childrenModelChanged();
		editPart.getFigure().repaint();
	}
	
	
	/**
	 * @return the editPart
	 */
	public TreeNodeEditPart getEditPart() {
		return editPart;
	}

	/**
	 * @param editPart the editPart to set
	 */
	public void setEditPart(TreeNodeEditPart editPart) {
		this.editPart = editPart;
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.edimap.editor.GEFAdapterCommand#execute()
	 */
	@Override
	public void execute() {
		super.execute();
		refreshEditPart();
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.edimap.editor.GEFAdapterCommand#redo()
	 */
	@Override
	public void redo() {
		super.redo();
		refreshEditPart();
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.edimap.editor.GEFAdapterCommand#undo()
	 */
	@Override
	public void undo() {
		super.undo();
		refreshEditPart();
	}
}
