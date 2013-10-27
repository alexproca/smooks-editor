/**
 * 
 */
package org.jboss.tools.smooks.gef.tree.editpolicy;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.jboss.tools.smooks.gef.tree.editparts.ChangeConstraintCommand;
import org.jboss.tools.smooks.gef.tree.figures.IMoveableModel;

/**
 * @author DartPeng
 * 
 */
public class RootPanelXYLayoutEditPolicy extends LayoutEditPolicy {

//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @seeorg.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#
//	 * createChangeConstraintCommand(org.eclipse.gef.EditPart, java.lang.Object)
//	 */
//	@Override
//	protected Command createChangeConstraintCommand(EditPart child,
//			Object constraint) {
//		
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.editpolicies.LayoutEditPolicy#getCreateCommand(org.eclipse
	 * .gef.requests.CreateRequest)
	 */
	@Override
	protected Command getCreateCommand(CreateRequest request) {
		return null;
	}

	@Override
	protected EditPolicy createChildEditPolicy(EditPart child) {
		
		return  new NonResizableEditPolicy(){

			@Override
			protected Command getMoveCommand(ChangeBoundsRequest request) {
				Object model = getHost().getModel();
				if (request instanceof ChangeBoundsRequest && model instanceof IMoveableModel) {
					Point delta = ((ChangeBoundsRequest)request).getMoveDelta();
					Rectangle rect = ((IMoveableModel) model).getBounds();
					rect.setLocation(rect.x+delta.x, rect.y + delta.y);
					ChangeConstraintCommand command = new ChangeConstraintCommand(
							(Rectangle) rect, (IMoveableModel) model);
					return command;
				}
				return null;
			}
			
		};
	}

	@Override
	protected Command getMoveChildrenCommand(Request request) {
		return null;
	}

}
