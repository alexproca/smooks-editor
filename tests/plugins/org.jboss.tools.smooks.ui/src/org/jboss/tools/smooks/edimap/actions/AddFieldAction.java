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
import org.eclipse.ui.IWorkbenchPart;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.gef.tree.command.GEFAdapterCommand;
import org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart;
import org.jboss.tools.smooks.model.medi.Field;
import org.jboss.tools.smooks.model.medi.MEdiFactory;
import org.jboss.tools.smooks.model.medi.MEdiPackage;

/**
 * @author Dart (dpeng@redhat.com)
 *
 */
public class AddFieldAction extends AbstractEDIMappingAction {
	
	public AddFieldAction(IWorkbenchPart editor, ISmooksModelProvider provider) {
		super(editor, provider, MEdiPackage.Literals.FIELD);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.action.Action#getId()
	 */
	@Override
	public String getId() {
		return EDIMappingActionConstants.ID_ADD_FIELD_ACTION;
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.edimap.actions.AbstractEDIMappingAction#init()
	 */
	@Override
	protected void init() {
		super.init();
		setText(Messages.AddFieldAction_Action_Text);
		setToolTipText(Messages.AddFieldAction_Action_Tooltip);
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.edimap.actions.AbstractEDIMappingAction#createAddModel()
	 */
	@Override
	protected Object createAddModel() {
		Field field = MEdiFactory.eINSTANCE.createField();
		field.setXmltag("field"); //$NON-NLS-1$
		return field;
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.edimap.actions.AbstractEDIMappingAction#createGEFAdapterCommand(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.common.command.Command)
	 */
	@Override
	protected GEFAdapterCommand createGEFAdapterCommand(EditingDomain domain, Command command) {
		Object obj = getSelectedObjects().get(0);
		if (obj instanceof TreeNodeEditPart) {
			GEFAdapterCommand gefcommand = new EDIGEFAdpaterCommand((TreeNodeEditPart)obj,domain,command);
			return gefcommand;
		}
		return new GEFAdapterCommand(domain,command);
	}
}
