/**
 * 
 */
package org.jboss.tools.smooks.gef.common;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.jboss.tools.smooks.gef.tree.editparts.RootEditPart;
import org.jboss.tools.smooks.gef.tree.editparts.TreeContainerEditPart;
import org.jboss.tools.smooks.gef.tree.editparts.TreeNodeConnectionEditPart;
import org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart;
import org.jboss.tools.smooks.gef.tree.model.TreeContainerModel;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;

/**
 * @author DartPeng
 *
 */
public class SmooksGEFEditFactory implements EditPartFactory {

	/* (non-Javadoc)
	 * @see org.eclipse.gef.EditPartFactory#createEditPart(org.eclipse.gef.EditPart, java.lang.Object)
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart editPart = null;
		if(model instanceof RootModel){
			editPart = new RootEditPart();
		}
		if(model.getClass() == TreeNodeModel.class){
			editPart = new TreeNodeEditPart();
		}if(model.getClass() == TreeContainerModel.class){
			editPart = new TreeContainerEditPart();
		}
		if(model.getClass() == TreeNodeConnection.class){
			editPart = new TreeNodeConnectionEditPart();
		}
		if(editPart != null){
			editPart.setModel(model);
		}
		return editPart;
	}

}
