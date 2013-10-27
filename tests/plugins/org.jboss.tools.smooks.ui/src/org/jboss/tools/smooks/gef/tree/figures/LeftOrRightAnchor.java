package org.jboss.tools.smooks.gef.tree.figures;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;

public class LeftOrRightAnchor extends ChopboxAnchor {
	
	
	private boolean isLeft;

	public LeftOrRightAnchor(IFigure owner) {
		super(owner);
	}
	
	public Point getReferencePoint(){
		return super.getReferencePoint();
	}
	
	public Point getLocation(Point reference) {
		Point p;
		IFigure hostFigure = getOwner();
		IFigure parent = hostFigure.getParent();
		while(parent != null && !(parent instanceof TreeContainerFigure)){
			if(parent == null || parent instanceof TreeContainerFigure){
				break;
			}
			parent = parent.getParent();
		}
		p = getOwner().getBounds().getCenter();
		getOwner().translateToAbsolute(p);
		Point referencePoint = reference;
		isLeft = false;
		if(referencePoint.x > (p.x + getOwner().getBounds().width / 2)){
			isLeft = false;
		}else{
			isLeft = true;
		}
		if (isLeft){
			p = getOwner().getBounds().getLeft();
			p.x = parent.getBounds().getLeft().x - 2;
		}
		else{
			p = getOwner().getBounds().getRight();
			p.x = parent.getBounds().getRight().x + 2;
		}
		getOwner().translateToAbsolute(p);
		return p;
	}

	public boolean isLeft() {
		return isLeft;
	}
	
	
}

