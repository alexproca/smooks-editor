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
package org.jboss.tools.smooks.edimap.editor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.ui.IEditorPart;
import org.jboss.tools.smooks.edimap.actions.DeleteEDIModelCommand;
import org.jboss.tools.smooks.edimap.editparts.AbstractEDIMappingEditPart;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;
import org.jboss.tools.smooks.model.medi.MappingNode;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class EDITreeNodeEditPart extends AbstractEDIMappingEditPart {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.edimap.editor.AbstractEDIMappingEditPart#canDirectEdit
	 * ()
	 */
	@Override
	protected boolean canDirectEdit() {
		TreeNodeModel model = (TreeNodeModel) getModel();
		if (model.getData() instanceof MappingNode) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart#isDragLink()
	 */
	protected boolean isDragLink() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart#createEditPolicies
	 * ()
	 */
	@Override
	protected void createEditPolicies() {

		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.gef.editpolicies.ComponentEditPolicy#createDeleteCommand
			 * (org.eclipse.gef.requests.GroupRequest)
			 */
			@Override
			protected Command createDeleteCommand(GroupRequest deleteRequest) {
				TreeNodeModel node = (TreeNodeModel) getHost().getModel();
				if(!(node.getData() instanceof EObject)){
					return null;
				}
				GraphicalViewer viewer = (GraphicalViewer) ((AbstractGraphicalEditPart) getHost()).getViewer();
				DefaultEditDomain domain = (DefaultEditDomain) viewer.getEditDomain();
				IEditorPart part = domain.getEditorPart();
				if (part instanceof EDIMapFormPage) {
					part = ((EDIMapFormPage) part).getEditor();
				}
				if (part instanceof ISmooksModelProvider) {
					EditingDomain ed = ((ISmooksModelProvider) part).getEditingDomain();
					org.eclipse.emf.common.command.Command command = DeleteCommand.create(ed, node.getData());
					if (command != null) {
						return new DeleteEDIModelCommand((TreeNodeEditPart) getHost(), ed, command);
					}
				}

				return super.createDeleteCommand(deleteRequest);
			}

		});
		super.createEditPolicies();
	}

}
