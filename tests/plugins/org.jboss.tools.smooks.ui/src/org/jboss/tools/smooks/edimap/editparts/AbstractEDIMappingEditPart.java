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
package org.jboss.tools.smooks.edimap.editparts;

import org.eclipse.draw2d.Label;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.ui.IEditorPart;
import org.jboss.tools.smooks.edimap.actions.RenameXmlTagNameCommand;
import org.jboss.tools.smooks.edimap.editor.EDIEdiPartDirectEditManager;
import org.jboss.tools.smooks.edimap.editor.EDILabelCellEditorLocator;
import org.jboss.tools.smooks.edimap.editor.EDIMapFormPage;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart;
import org.jboss.tools.smooks.gef.tree.figures.TreeNodeFigure;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;
import org.jboss.tools.smooks.model.medi.MEdiPackage;
import org.jboss.tools.smooks.model.medi.MappingNode;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class AbstractEDIMappingEditPart extends TreeNodeEditPart {
	private DirectEditManager manager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart#performDirectEdit
	 * ()
	 */
	@Override
	protected void performDirectEdit() {
		if (canDirectEdit()) {
			if (manager == null) {
				Label l = ((TreeNodeFigure) getFigure()).getLabel();
				manager = new EDIEdiPartDirectEditManager(this, TextCellEditor.class, new EDILabelCellEditorLocator(l),
						l);
			}
			manager.show();
		}
	}

	protected boolean canDirectEdit() {
		return false;
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

		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new DirectEditPolicy() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.gef.editpolicies.DirectEditPolicy#getDirectEditCommand
			 * (org.eclipse.gef.requests.DirectEditRequest)
			 */
			@Override
			protected Command getDirectEditCommand(DirectEditRequest request) {
				TreeNodeModel node = (TreeNodeModel) getHost().getModel();
				GraphicalViewer viewer = (GraphicalViewer) ((AbstractGraphicalEditPart) getHost()).getViewer();
				DefaultEditDomain domain = (DefaultEditDomain) viewer.getEditDomain();
				IEditorPart part = domain.getEditorPart();
				if (part instanceof EDIMapFormPage) {
					part = ((EDIMapFormPage) part).getEditor();
				}
				if (part instanceof ISmooksModelProvider) {
					EditingDomain ed = ((ISmooksModelProvider) part).getEditingDomain();
					Object feature = null;
					Object owner = node.getData();
					if (owner instanceof MappingNode) {
						feature = MEdiPackage.Literals.MAPPING_NODE__XMLTAG;
					}
					org.eclipse.emf.common.command.Command command = SetCommand.create(ed, node.getData(), feature,
							request.getCellEditor().getValue());
					if (command != null) {
						return new RenameXmlTagNameCommand((TreeNodeEditPart) getHost(), ed, command);
					}
				}
				return null;
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.gef.editpolicies.DirectEditPolicy#showCurrentEditValue
			 * (org.eclipse.gef.requests.DirectEditRequest)
			 */
			@Override
			protected void showCurrentEditValue(DirectEditRequest request) {

			}

		});

		super.createEditPolicies();
	}
}
