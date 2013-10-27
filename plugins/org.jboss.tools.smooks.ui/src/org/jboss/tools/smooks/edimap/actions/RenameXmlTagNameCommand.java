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
import org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart;

/**
 * @author Dart (dpeng@redhat.com)
 *
 */
public class RenameXmlTagNameCommand extends EDIGEFAdpaterCommand {

	public RenameXmlTagNameCommand(TreeNodeEditPart editPart, EditingDomain domain, Command emfCommand) {
		super(editPart, domain, emfCommand);
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.edimap.actions.EDIGEFAdpaterCommand#refreshEditPart()
	 */
	@Override
	protected void refreshEditPart() {
//		editPart.refresh();
	}


}
