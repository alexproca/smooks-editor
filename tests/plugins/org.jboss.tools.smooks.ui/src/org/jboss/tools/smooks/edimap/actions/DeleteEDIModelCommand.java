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

import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.ui.IEditorPart;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.edimap.editor.EDIMapFormPage;
import org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class DeleteEDIModelCommand extends EDIGEFAdpaterCommand {

	private EditPart parentPart;

	public DeleteEDIModelCommand(TreeNodeEditPart editPart, EditingDomain domain, Command emfCommand) {
		super(editPart, domain, emfCommand);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.edimap.actions.AddOrDeleteEDIMappingModelCommand
	 * #refreshEditPart()
	 */
	@Override
	protected void refreshEditPart() {

		if (parentPart != null && parentPart instanceof TreeNodeEditPart) {
			((TreeNodeEditPart) parentPart).childrenModelChanged();
			((TreeNodeEditPart) parentPart).getFigure().repaint();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.edimap.actions.AddOrDeleteEDIMappingModelCommand
	 * #execute()
	 */
	@Override
	public void execute() {
		if (parentPart == null) {
			parentPart = this.editPart.getParent();
		}
		super.execute();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.tools.smooks.edimap.actions.EDIGEFAdpaterCommand#undo()
	 */
	@Override
	public void undo() {
		super.undo();
		if (parentPart != null && parentPart instanceof TreeNodeEditPart) {
			DefaultEditDomain editDomain = (DefaultEditDomain) parentPart.getViewer().getEditDomain();
			IEditorPart editorPart = editDomain.getEditorPart();
			if (editorPart instanceof EDIMapFormPage) {
				List<TreeNodeModel> linkedNodes = ((EDIMapFormPage) editorPart).createLinkModel();
				try{
				SmooksUIUtils.expandGraphTree(linkedNodes, (TreeNodeEditPart) parentPart);
				}catch(Throwable t){
					t.printStackTrace();
				}
			}
		}
	}

}
