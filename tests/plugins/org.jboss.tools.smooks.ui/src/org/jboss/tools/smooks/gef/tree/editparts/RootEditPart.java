/**
 * 
 */
package org.jboss.tools.smooks.gef.tree.editparts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.jboss.tools.smooks.gef.common.RootModel;
import org.jboss.tools.smooks.gef.tree.editpolicy.RootPanelXYLayoutEditPolicy;

/**
 * @author DartPeng
 *
 */
public class RootEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener{

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {
		FreeformLayer layer =  new FreeformLayer();
		layer.setLayoutManager(new FreeformLayout());
		return layer;
	}
	
	

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#activate()
	 */
	@Override
	public void activate() {
		((RootModel)getModel()).addPropertyChangeListener(this);
		super.activate();
	}



	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#deactivate()
	 */
	@Override
	public void deactivate() {
		super.deactivate();
		((RootModel)getModel()).removePropertyChangeListener(this);
	}



	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		this.installEditPolicy(EditPolicy.LAYOUT_ROLE, new RootPanelXYLayoutEditPolicy());
	}
	
	protected List<?> getModelChildren(){
		RootModel list = (RootModel) getModel();
		return list.getChildren();
	}



	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals(RootModel.ADD_CHILDREN) || evt.getPropertyName().equals(RootModel.REMOVE_CHILDREN)){
			this.refreshChildren();
		}
	}
}
