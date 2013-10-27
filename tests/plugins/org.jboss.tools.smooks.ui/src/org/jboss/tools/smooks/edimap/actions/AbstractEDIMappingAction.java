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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.gef.tree.command.GEFAdapterCommand;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class AbstractEDIMappingAction extends SelectionAction {

	private ISmooksModelProvider modelProvider = null;

	private EClass feature = null;

	public AbstractEDIMappingAction(IWorkbenchPart editor, ISmooksModelProvider provider, EClass feature) {
		super(editor);
		this.modelProvider = provider;
		this.feature = feature;
	}

	protected Object createAddModel() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#calculateEnabled()
	 */
	@Override
	protected boolean calculateEnabled() {
		if (getSelectedObjects().size() != 1) {
			return false;
		}
		Object obj = getSelectedObjects().get(0);
		if (obj instanceof AbstractGraphicalEditPart) {
			Object model = ((AbstractGraphicalEditPart) obj).getModel();
			if (model instanceof TreeNodeModel) {
				Command command = AddCommand.create(modelProvider.getEditingDomain(),
						((TreeNodeModel) model).getData(), feature, createAddModel());
				return command.canExecute();
			}
		}
		return false;
	}

	@Override
	protected void init() {
		super.init();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#refresh()
	 */
	@Override
	protected void refresh() {
		super.refresh();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		super.run();
		Object obj = getSelectedObjects().get(0);
		if (obj instanceof AbstractGraphicalEditPart) {
			Object model = ((AbstractGraphicalEditPart) obj).getModel();
			if (model instanceof TreeNodeModel) {
				Command command = AddCommand.create(modelProvider.getEditingDomain(),
						((TreeNodeModel) model).getData(), feature, createAddModel());
				getCommandStack().execute(createGEFAdapterCommand(modelProvider.getEditingDomain(), command));
			}
		}
	}
	
	protected GEFAdapterCommand createGEFAdapterCommand(EditingDomain domain,Command command){
		return null;
	}

	protected CommandStack getCommandStack() {
		return (CommandStack) getWorkbenchPart().getAdapter(CommandStack.class);
	}
}
