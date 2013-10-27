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
package org.jboss.tools.smooks.graphical.editors;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.jboss.tools.smooks.gef.common.RootModel;
import org.jboss.tools.smooks.gef.common.SmooksGEFEditFactory;
import org.jboss.tools.smooks.gef.tree.editparts.TreeContainerEditPart;
import org.jboss.tools.smooks.gef.tree.editparts.TreeNodeConnectionEditPart;
import org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart;
import org.jboss.tools.smooks.gef.tree.model.BeanReferenceConnection;
import org.jboss.tools.smooks.gef.tree.model.TreeContainerModel;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;
import org.jboss.tools.smooks.gef.tree.model.TriggerConnection;
import org.jboss.tools.smooks.gef.tree.model.ValueBindingConnection;
import org.jboss.tools.smooks.graphical.editors.editparts.InputDataContainerEditPart;
import org.jboss.tools.smooks.graphical.editors.editparts.InputDataTreeNodeEditPart;
import org.jboss.tools.smooks.graphical.editors.editparts.ResourceConfigEditFactory;
import org.jboss.tools.smooks.graphical.editors.editparts.SmooksRootEditPart;
import org.jboss.tools.smooks.graphical.editors.editparts.TriggerConnectionEditPart;
import org.jboss.tools.smooks.graphical.editors.editparts.javamapping.BeanReferenceConnectionEditPart;
import org.jboss.tools.smooks.graphical.editors.editparts.javamapping.ValueBindingConnectionEditPart;
import org.jboss.tools.smooks.graphical.editors.model.AbstractResourceConfigChildNodeGraphModel;
import org.jboss.tools.smooks.graphical.editors.model.AbstractResourceConfigGraphModel;
import org.jboss.tools.smooks.graphical.editors.model.InputDataContianerModel;
import org.jboss.tools.smooks.graphical.editors.model.InputDataTreeNodeModel;

/**
 * @author Dart
 * 
 */
public class SmooksEditFactory extends SmooksGEFEditFactory implements EditPartFactory {
	private ResourceConfigEditFactory resourceConfigFactory;
	
	private boolean displayInput = true;

	public SmooksEditFactory() {
		super();
		resourceConfigFactory = new ResourceConfigEditFactory();
	}
	

	/**
	 * @return the displayInput
	 */
	public boolean isDisplayInput() {
		return displayInput;
	}



	/**
	 * @param displayInput the displayInput to set
	 */
	public void setDisplayInput(boolean displayInput) {
		this.displayInput = displayInput;
	}



	public EditPart createEditPart(EditPart context, Object model) {
		EditPart editPart = null;
		if (model instanceof RootModel) {
			editPart = new SmooksRootEditPart();
		}
		if (model.getClass() == TreeNodeModel.class) {
			editPart = new TreeNodeEditPart();
		}
		if (model.getClass() == TreeContainerModel.class) {
			editPart = new TreeContainerEditPart();
		}
		if (model.getClass() == InputDataTreeNodeModel.class && displayInput) {
			editPart = new InputDataTreeNodeEditPart();
		}
		if (model.getClass() == InputDataContianerModel.class && displayInput) {
			editPart = new InputDataContainerEditPart();
		}

		if (model instanceof AbstractResourceConfigGraphModel
				|| model instanceof AbstractResourceConfigChildNodeGraphModel) {
			editPart = resourceConfigFactory.createEditPart(model);
		}
		if (model.getClass() == TreeNodeConnection.class) {
			editPart = new TreeNodeConnectionEditPart();
		}
		if(model.getClass() == TriggerConnection.class){
			editPart = new TriggerConnectionEditPart();
		}
		if(model.getClass() == ValueBindingConnection.class){
			editPart = new ValueBindingConnectionEditPart();
		}
		if(model.getClass() == BeanReferenceConnection.class){
			editPart = new BeanReferenceConnectionEditPart();
		}
		if (editPart != null) {
			editPart.setModel(model);
		}
		return editPart;
	}

}
