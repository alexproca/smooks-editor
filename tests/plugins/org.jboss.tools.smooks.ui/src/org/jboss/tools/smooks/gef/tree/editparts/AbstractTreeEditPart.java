/**
 * 
 */
package org.jboss.tools.smooks.gef.tree.editparts;


import java.beans.PropertyChangeListener;

import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.ui.IEditorPart;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;

/**
 * @author DartPeng
 *
 */
public abstract class AbstractTreeEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener{

	@Override
	public void activate() {
		super.activate();
		Object model = getModel();
		if(model instanceof TreeNodeModel){
			((TreeNodeModel)model).addPropertyChangeListener(this);
		}
	}

	@Override
	public void deactivate() {
		Object model = getModel();
		if(model instanceof TreeNodeModel){
			((TreeNodeModel)model).removePropertyChangeListener(this);
		}
		super.deactivate();
	}
	
	public IEditorPart getEditorPart(){
		GraphicalViewer viewer = (GraphicalViewer)getViewer();
		if(viewer != null){
			DefaultEditDomain domain = (DefaultEditDomain) viewer.getEditDomain();
			if(domain != null){
				return domain.getEditorPart();
			}
		}
		
		return null;
	}
}
