/**
 * 
 */
package org.jboss.tools.smooks.gef.tree.figures;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author DartPeng
 * 
 */
public interface IMoveableModel {
	
	public static final String PRO_BOUNDS_CHANGED = "__pro_bounds_changed"; //$NON-NLS-1$
	
	public Point getLocation();

	public void setLocation(Point location);
	
	public Dimension getSize();
	
	public void setSize(Dimension size);
	
	public Rectangle getBounds();
	
	public void setBounds(Rectangle rect);
}
