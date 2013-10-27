/**
 * 
 */
package org.jboss.tools.smooks.gef.tree.editparts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.jboss.tools.smooks.gef.tree.figures.IMoveableModel;
import org.jboss.tools.smooks.gef.tree.figures.TestFigure;
import org.jboss.tools.smooks.gef.tree.figures.TreeContainerFigure;
import org.jboss.tools.smooks.gef.tree.model.TreeContainerModel;

/**
 * @author DartPeng
 *
 */
public class TestEditpart extends AbstractGraphicalEditPart implements PropertyChangeListener{

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {
		// TODO Auto-generated method stub
		return new TestFigure();
	}
	
	

	@Override
	public void activate() {
		((TreeContainerModel)getModel()).addPropertyChangeListener(this);
		super.activate();
	}



	@Override
	public void deactivate() {
		((TreeContainerModel)getModel()).addPropertyChangeListener(this);
		super.deactivate();
	}



	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {

	}
	

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		TreeContainerModel model = (TreeContainerModel) getModel();
		String text = model.getText();
		if (text != null && getFigure() instanceof TreeContainerFigure) {
			TreeContainerFigure figure = (TreeContainerFigure) getFigure();
			figure.setText(text);
		}
		Point location = model.getLocation();
		Dimension size = getFigure().getPreferredSize();
		try {
			((GraphicalEditPart) this.getParent()).setLayoutConstraint(this, this
	                .getFigure(),new Rectangle(location,size));
//			((AbstractGraphicalEditPart) getParent()).setLayoutConstraint(this,
//					this.getFigure(), rect);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals(IMoveableModel.PRO_BOUNDS_CHANGED)){
			refreshVisuals();
		}
	}

}
