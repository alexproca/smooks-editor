/**
 * 
 */
package org.jboss.tools.smooks.gef.tree.editparts;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.jboss.tools.smooks.gef.tree.figures.IMoveableModel;

/**
 * @author DartPeng
 *
 */
public class ChangeConstraintCommand extends Command {

	protected Rectangle oldBounds = null;
	
	protected Rectangle constraint = null;
	
	protected IMoveableModel model = null;
	
	public ChangeConstraintCommand(Rectangle constraint, IMoveableModel model){
		this.constraint = constraint;
		this.model = model;
	}

	@Override
	public void execute() {
		oldBounds = model.getBounds();
		model.setBounds(constraint);
	}

	@Override
	public void redo() {
		execute();
	}

	@Override
	public void undo() {
		model.setBounds(oldBounds);
	}
}
