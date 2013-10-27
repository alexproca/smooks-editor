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
package org.jboss.tools.smooks.gef.common;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory;
import org.jboss.tools.smooks.configuration.SmooksConfigurationActivator;
import org.jboss.tools.smooks.configuration.editors.GraphicsConstants;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class SmooksGraphicalMenuContextProvider extends ContextMenuProvider {

	public static final String GROUP_CUSTOME = "custom_group"; //$NON-NLS-1$

	protected ActionRegistry actionRegistry;

	/**
	 * @return the actionRegistry
	 */
	public ActionRegistry getActionRegistry() {
		return actionRegistry;
	}

	/**
	 * @param actionRegistry
	 *            the actionRegistry to set
	 */
	public void setActionRegistry(ActionRegistry actionRegistry) {
		this.actionRegistry = actionRegistry;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.ContextMenuProvider#buildContextMenu(org.eclipse.jface
	 * .action.IMenuManager)
	 */
	@Override
	public void buildContextMenu(IMenuManager menu) {
		menu.add(new Separator(GROUP_CUSTOME));
		GEFActionConstants.addStandardActionGroups(menu);
		IAction action;
		action = getActionRegistry().getAction(ActionFactory.UNDO.getId());
		menu.appendToGroup(GEFActionConstants.GROUP_UNDO, action);
		action = getActionRegistry().getAction(ActionFactory.REDO.getId());
		menu.appendToGroup(GEFActionConstants.GROUP_UNDO, action);

		action = getActionRegistry().getAction(ActionFactory.DELETE.getId());
		if (action.isEnabled())
			menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);

		action = new Action() {
			public void run() {
				DefaultEditDomain domain = (DefaultEditDomain) getViewer().getEditDomain();
				IWorkbenchWindow window = domain.getEditorPart().getSite().getWorkbenchWindow();
				try {
					window.getActivePage().showView("org.eclipse.ui.views.PropertySheet"); //$NON-NLS-1$
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		};
		action.setText(Messages.SmooksGraphicalMenuContextProvider_Action_Properties);
		action.setImageDescriptor(SmooksConfigurationActivator
				.getImageDescriptor(GraphicsConstants.IMAGE_PROPERTY_SHEET_PAGE));
		menu.add(action);
	}

	public SmooksGraphicalMenuContextProvider(EditPartViewer viewer, ActionRegistry actionRegistry) {
		super(viewer);
		this.actionRegistry = actionRegistry;
	}
}
