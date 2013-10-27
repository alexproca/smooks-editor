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

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.jboss.tools.smooks.configuration.editors.xml.TagObject;
import org.jboss.tools.smooks.edimap.editparts.EDIDataContainerEditPart;
import org.jboss.tools.smooks.edimap.editparts.EDIDataEditPart;
import org.jboss.tools.smooks.edimap.editparts.EDIMappingNodeEditPart;
import org.jboss.tools.smooks.edimap.models.EDIDataContainerGraphModel;
import org.jboss.tools.smooks.edimap.models.EDIDataGraphModel;
import org.jboss.tools.smooks.edimap.models.EDIMappingNodeGraphModel;
import org.jboss.tools.smooks.edimap.models.EDIMappingNodeContainerGraphModel;
import org.jboss.tools.smooks.gef.common.RootModel;
import org.jboss.tools.smooks.gef.tree.editparts.RootEditPart;
import org.jboss.tools.smooks.gef.tree.editparts.TreeNodeConnectionEditPart;
import org.jboss.tools.smooks.gef.tree.model.TreeContainerModel;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;
import org.jboss.tools.smooks.model.medi.Segments;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class EDIEditPartFactory implements EditPartFactory {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.EditPartFactory#createEditPart(org.eclipse.gef.EditPart,
	 * java.lang.Object)
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart editPart = null;
		if (model instanceof RootModel) {
			editPart = new RootEditPart();
		}
		if (model instanceof EDIMappingNodeGraphModel) {
			editPart = new EDIMappingNodeEditPart();
		}
		if (model instanceof EDIDataGraphModel) {
			editPart = new EDIDataEditPart();
		}
		if(model instanceof EDIMappingNodeContainerGraphModel){
			editPart = new EDISegementsEditPart();
		}
		if(model instanceof EDIDataContainerGraphModel){
			editPart = new EDIDataContainerEditPart();
		}
		if (model.getClass() == TreeNodeConnection.class) {
			editPart = new TreeNodeConnectionEditPart();
		}
		if (editPart != null) {
			editPart.setModel(model);
		}
		return editPart;
	}

}
