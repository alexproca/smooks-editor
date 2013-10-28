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
package org.jboss.tools.smooks.graphical.editors.editparts;

import java.util.Iterator;
import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart;
import org.jboss.tools.smooks.gef.tree.figures.TreeNodeFigure;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;
import org.jboss.tools.smooks.graphical.editors.SmooksGraphicalEditorPart;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;

/**
 * @author Dart
 * 
 */
public class InputDataTreeNodeEditPart extends TreeNodeEditPart {

	@Override
	protected boolean isDragLink() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart#refreshVisuals
	 * ()
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		TreeNodeModel node = (TreeNodeModel) getModel();
		Image image = node.getImage();
		if(image != null){
			((TreeNodeFigure) getFigure()).setLabelImage(image);
		}
		IEditorPart editorPart = this.getEditorPart();
		if (editorPart instanceof SmooksGraphicalEditorPart) {
			SmooksResourceListType listType = ((SmooksGraphicalEditorPart) editorPart).getSmooksResourceListType();
			List<?> list = listType.getAbstractResourceConfig();
			for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
				Object object = (Object) iterator.next();
				// TODO: Is this method required if we remove the code below?
//				if (object instanceof RuleType) {
//					Object graphicalModel = ((SmooksGraphicalEditorPart) editorPart)
//							.findRelatedInputGraphicalModel(object);
//					if (graphicalModel == getModel()) {
//						((TreeNodeFigure) getFigure()).setLabelImage(SmooksConfigurationActivator.getDefault()
//								.getImageRegistry().get(GraphicsConstants.IMAGE_VALIDATED_TAG));
//					}
//				}
			}
		}
		((TreeNodeFigure) getFigure()).repaint();
	}
}
