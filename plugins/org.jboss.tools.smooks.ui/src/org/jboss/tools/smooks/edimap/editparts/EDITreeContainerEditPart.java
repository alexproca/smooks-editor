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

import java.beans.PropertyChangeEvent;

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
import org.jboss.tools.smooks.configuration.editors.xml.TagObject;
import org.jboss.tools.smooks.edimap.actions.RenameXmlTagNameCommand;
import org.jboss.tools.smooks.edimap.editor.EDIEdiPartDirectEditManager;
import org.jboss.tools.smooks.edimap.editor.EDILabelCellEditorLocator;
import org.jboss.tools.smooks.edimap.editor.EDIMapFormPage;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.gef.tree.editparts.TreeContainerEditPart;
import org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart;
import org.jboss.tools.smooks.gef.tree.figures.TreeContainerFigure;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;
import org.jboss.tools.smooks.model.medi.MEdiPackage;
import org.jboss.tools.smooks.model.medi.MappingNode;
import org.jboss.tools.smooks.model.medi.Segments;

/**
 * @author Dart (dpeng@redhat.com)
 *
 */
public class EDITreeContainerEditPart extends TreeContainerEditPart {
	
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
				Label l = ((TreeContainerFigure) getFigure()).getLabel();
				manager = new EDIEdiPartDirectEditManager(this, TextCellEditor.class, new EDILabelCellEditorLocator(l),
						l);
			}
			manager.show();
		}
	}

	protected boolean canDirectEdit() {
		TreeNodeModel model = (TreeNodeModel) getModel();
		if (model.getData() instanceof MappingNode) {
			return true;
		}
		return false;
	}

	
	public void propertyChange(PropertyChangeEvent evt) {
		super.propertyChange(evt);
//		if (IMoveableModel.PRO_BOUNDS_CHANGED.equals(evt.getPropertyName())) {
//			DefaultEditDomain domain = (DefaultEditDomain) getViewer().getEditDomain();
//			IEditorPart editor = domain.getEditorPart();
//			if((editor instanceof FormPage)){
//				editor = ((FormPage)editor).getEditor();
//			}
//			
//			if(editor instanceof ISmooksModelProvider && getModel() instanceof IMoveableModel){
//				SmooksGraphicsExtType graph = ((ISmooksModelProvider)editor).getSmooksGraphicsExt();
//				Rectangle rect = ((IMoveableModel)getModel()).getBounds();
//				recordBounds(graph,rect);
//			}
//		}
	}
	
	
//	/* (non-Javadoc)
//	 * @see org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart#recordFigureBounds(org.jboss.tools.smooks.model.graphics.ext.FigureType, org.eclipse.draw2d.geometry.Rectangle)
//	 */
//	@Override
//	protected void recordFigureBounds(FigureType figureType, Rectangle bounds) {
//		figureType.setX(String.valueOf(bounds.getLocation().x));
//		figureType.setY(String.valueOf(bounds.getLocation().y));
//	}
	
	public static String generateFigureId(Object data){
		if(data instanceof Segments){
//			String xml = ((MappingNode)data).getXmltag();
//			return "segments_" + xml;
			return "segments"; //$NON-NLS-1$
		}
		if(data instanceof TagObject){
			return "edi_" + ((TagObject)data).getName(); //$NON-NLS-1$
		}
		return null;
	}

	

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.gef.tree.editparts.TreeContainerEditPart#createEditPolicies()
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
				// RenameActivityCommand cmd = new RenameActivityCommand();
				// cmd.setSource((Activity)getHost().getModel());
				// cmd.setOldName(((Activity)getHost().getModel()).getName());
				// cmd.setName((String)request.getCellEditor().getValue());
				// return cmd;
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

	protected String generateFigureID(){
		TreeNodeModel model = (TreeNodeModel) getModel();
		Object data = model.getData();
		return generateFigureId(data);
	}
}
