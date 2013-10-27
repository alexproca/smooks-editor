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
import org.jboss.tools.smooks.configuration.editors.xml.AbstractXMLObject;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerCSVNodeGraphicalModel;

/**
 * @author Dart
 * 
 */
public class ChangeCSVNodeNameCommand extends Command {

	private FreemarkerCSVNodeGraphicalModel graphModel;

	private Object value;

	private String oldName;

	public ChangeCSVNodeNameCommand(FreemarkerCSVNodeGraphicalModel model, Object value) {
		this.graphModel = model;
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		if (graphModel != null && value != null && value instanceof String) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return super.canUndo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		AbstractXMLObject data = (AbstractXMLObject) graphModel.getData();
		oldName = data.getName();
		graphModel.setName((String) value);
		super.execute();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	@Override
	public void redo() {
		// TODO Auto-generated method stub
		super.redo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		graphModel.setName((String) oldName);
	}

}
