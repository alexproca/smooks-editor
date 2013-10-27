package org.jboss.tools.smooks.gef.tree.model;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.jboss.tools.smooks.gef.tree.figures.IMoveableModel;

public class TreeContainerModel extends TreeNodeModel implements IMoveableModel {

	private boolean sourceLinkNode = false;
	
	private boolean headerVisable = false;
	
	private Point location = new Point(0, 0);
	

	public TreeContainerModel(Object data,
			ITreeContentProvider contentProvider, ILabelProvider labelProvider) {
		super(data, contentProvider, labelProvider);
	}

	public boolean isSourceLinkNode() {
		return sourceLinkNode;
	}

	public void setSourceLinkNode(boolean sourceLinkNode) {
		this.sourceLinkNode = sourceLinkNode;
	}
	
	public boolean canDragLink(){
		return false;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		if (!this.location.equals(location)) {
			Point oldLocation = this.location;
			this.location = location;
			support.firePropertyChange(IMoveableModel.PRO_BOUNDS_CHANGED, oldLocation, this.location);
		}
	}
	

	public Rectangle getBounds() {
		return new Rectangle(getLocation(),new Dimension(0,0));
	}

	public Dimension getSize() {
		return null;
	}

	public void setBounds(Rectangle rect) {
		setLocation(rect.getLocation());
	}

	public void setSize(Dimension size) {
		
	}

	public void setHeaderVisable(boolean headerVisable) {
		this.headerVisable = headerVisable;
	}
	
	public boolean isHeaderVisable() {
		return headerVisable;
	}

}
