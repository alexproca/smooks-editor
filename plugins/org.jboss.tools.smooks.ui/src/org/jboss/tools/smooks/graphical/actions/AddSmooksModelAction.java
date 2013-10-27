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
package org.jboss.tools.smooks.graphical.actions;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;
import org.jboss.tools.smooks.graphical.editors.SmooksGraphicalEditorPart;

/**
 * @author Dart
 * 
 */
public abstract class AddSmooksModelAction extends SelectionAction {

	public AddSmooksModelAction(IWorkbenchPart part, int style) {
		super(part, style);
		// TODO Auto-generated constructor stub
	}

	public AddSmooksModelAction(IWorkbenchPart part) {
		super(part);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#calculateEnabled()
	 */
	@Override
	protected boolean calculateEnabled() {
		Command cmd = createAddChildNodeCommand(getSelectedObjects());
		if (cmd == null)
			return false;
		return cmd.canExecute();
	}

	protected Command createAddChildNodeCommand(List<?> objects) {
		if (objects.isEmpty())
			return null;
		if (!(objects.get(0) instanceof EditPart))
			return null;

		CreateRequest addReq = new CreateRequest();
		Point location = new Point(0, 0);
		if (this.getWorkbenchPart() != null) {
			IWorkbenchPart part = this.getWorkbenchPart();
			org.eclipse.swt.graphics.Point mouseLocation = part.getSite().getShell().getDisplay().getCursorLocation();
			if (part instanceof SmooksGraphicalEditorPart) {
				GraphicalViewer viewer = ((SmooksGraphicalEditorPart) part).getGraphicalViewer();
				mouseLocation = viewer.getControl().toControl(mouseLocation);
			}
			location = new Point(mouseLocation.x, mouseLocation.y);
		}
		addReq.setLocation(location);
		addReq.setFactory(getCreationFactory());

		CompoundCommand compoundCmd = new CompoundCommand("Add " + getActionText()); //$NON-NLS-1$
		for (int i = 0; i < objects.size(); i++) {
			EditPart object = (EditPart) objects.get(i);
			Command cmd = object.getCommand(addReq);
			if (cmd != null)
				compoundCmd.add(cmd);
		}

		return compoundCmd;
	}

	public abstract String getActionText();

	// public abstract Imag

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		try {
			execute(createAddChildNodeCommand(getSelectedObjects()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.setText(getActionText());
		this.setImageDescriptor(getActionImageDescriptor());
	}

	protected abstract CreationFactory getCreationFactory();

	public abstract ImageDescriptor getActionImageDescriptor();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#getId()
	 */
	@Override
	public String getId() {
		return "add_chlid_" + getText(); //$NON-NLS-1$
	}

}
