/**
 * 
 */
package org.jboss.tools.smooks.gef.tree.editparts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.BendpointConnectionRouter;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.ManhattanConnectionRouter;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.jboss.tools.smooks.configuration.SmooksConfigurationActivator;
import org.jboss.tools.smooks.configuration.editors.GraphicsConstants;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.gef.tree.editpolicy.TreeNodeConnectionEditPolicy;
import org.jboss.tools.smooks.gef.tree.editpolicy.TreeNodeEndpointEditPolicy;
import org.jboss.tools.smooks.gef.tree.figures.LeftOrRightAnchor;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;
import org.jboss.tools.smooks.graphical.editors.model.IValidatableModel;

/**
 * @author DartPeng
 * 
 */
public class TreeNodeConnectionEditPart extends AbstractConnectionEditPart implements PropertyChangeListener {
	protected int alpha = 255;

	protected boolean canDelete = true;

	private Image markerImage = null;

	protected Label errorLabel = new Label();

	protected Label warningLabel = new Label();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#activate()
	 */
	@Override
	public void activate() {
		super.activate();
		TreeNodeConnection connection = (TreeNodeConnection) getModel();
		connection.addPropertyChangeListener(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#deactivate()
	 */
	@Override
	public void deactivate() {
		TreeNodeConnection connection = (TreeNodeConnection) getModel();
		connection.removePropertyChangeListener(this);
		super.deactivate();
	}

	@Override
	protected void createEditPolicies() {
		this.installEditPolicy(EditPolicy.CONNECTION_ROLE, new TreeNodeConnectionEditPolicy());
		this.installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new TreeNodeEndpointEditPolicy());
	}

	public void changeLineAlpha(int alpha) {
		this.alpha = alpha;
	}

	/**
	 * @return the markerImage
	 */
	public Image getMarkerImage() {
		return markerImage;
	}

	/**
	 * @param markerImage
	 *            the markerImage to set
	 */
	public void setMarkerImage(Image markerImage) {
		this.markerImage = markerImage;
	}

	/**
	 * @return the canDelete
	 */
	public boolean isCanDelete() {
		return canDelete;
	}

	/**
	 * @param canDelete
	 *            the canDelete to set
	 */
	public void setCanDelete(boolean canDelete) {
		this.canDelete = canDelete;
	}

	protected IEditorPart getEditorPart() {
		GraphicalViewer viewer = (GraphicalViewer) this.getViewer();
		DefaultEditDomain domain = (DefaultEditDomain) viewer.getEditDomain();
		return domain.getEditorPart();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#refreshVisuals()
	 */
	@Override
	protected void refreshVisuals() {

		Label tooltip = null;
		this.setMarkerImage(null);
		Object connection = getModel();

		if (connection instanceof IValidatableModel) {
			int serverity = ((IValidatableModel) connection).getSeverity();
			String message = getSeverityMessage((IValidatableModel) connection);
			Image image = null;
			if (serverity == IValidatableModel.NONE) {
				image = null;
			}
			if (serverity == IValidatableModel.ERROR) {
				image = SmooksConfigurationActivator.getDefault().getImageRegistry().get(GraphicsConstants.IMAGE_ERROR);
				tooltip = errorLabel;
				tooltip.setText(message);
			}
			if (serverity == IValidatableModel.WARNING) {
				image = SmooksConfigurationActivator.getDefault().getImageRegistry().get(
						GraphicsConstants.IMAGE_WARNING);
				tooltip = warningLabel;
				tooltip.setText(message);
			}
			if (image != null) {
				this.setMarkerImage(image);
				getFigure().repaint();
				// ((TreeNodeFigure) getFigure()).setLabelImage(image);
			}
			getFigure().setToolTip(tooltip);
		}
	}

	protected String getSeverityMessage(IValidatableModel model) {
		List<String> messages = model.getMessage();
		String message = null;
		for (Iterator<?> iterator = messages.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			if (message == null) {
				message = " - " + string; //$NON-NLS-1$
			} else {
				message = message + "\n" + " - " + string; //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return message;
	}

	protected IFigure createSourceFlagFigure() {
		Figure sourceFlagFigure = new Figure() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.draw2d.Figure#paint(org.eclipse.draw2d.Graphics)
			 */
			@Override
			public void paint(Graphics graphics) {
				graphics.pushState();
				ConnectionAnchor sourceAnchor = getSourceConnectionAnchor();
				ConnectionAnchor targetAnchor = getTargetConnectionAnchor();
				boolean startLeft = false;
				if (sourceAnchor instanceof LeftOrRightAnchor) {
					((LeftOrRightAnchor) sourceAnchor).getLocation(targetAnchor.getReferencePoint());
					startLeft = ((LeftOrRightAnchor) sourceAnchor).isLeft();
				}
				graphics.setForegroundColor(ColorConstants.black);
				graphics.setBackgroundColor(ColorConstants.listBackground);
				if (!startLeft) {
					Point p = this.getBounds().getTopLeft();
					Point p2 = this.getBounds().getBottomLeft();
					Point p3 = this.getBounds().getTopRight();
					p3 = new Point(p3.x, p3.y + this.getSize().height / 2);
					PointList pointList = new PointList();
					pointList.addPoint(p);
					pointList.addPoint(p2.x, p2.y - 1);
					pointList.addPoint(p3);
					graphics.fillPolygon(pointList);
					graphics.drawPolygon(pointList);
				} else {
					Point p = this.getBounds().getTopRight();
					Point p2 = this.getBounds().getBottomRight();
					Point p3 = this.getBounds().getTopLeft();
					p3 = new Point(p3.x, p3.y + this.getSize().height / 2);
					PointList pointList = new PointList();
					pointList.addPoint(p.x - 1, p.y);
					pointList.addPoint(p2.x - 1, p2.y - 1);
					pointList.addPoint(p3);
					graphics.fillPolygon(pointList);
					graphics.drawPolygon(pointList);
				}
				graphics.popState();
				super.paint(graphics);
			}

		};
		return sourceFlagFigure;
	}

	protected IFigure createTargetFlagFigure() {
		Figure targetFlagFigure = new Figure() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.draw2d.Figure#paint(org.eclipse.draw2d.Graphics)
			 */
			@Override
			public void paint(Graphics graphics) {

				ConnectionAnchor sourceAnchor = getSourceConnectionAnchor();
				ConnectionAnchor targetAnchor = getTargetConnectionAnchor();
				// boolean startLeft = false;
				// if(sourceAnchor instanceof LeftOrRightAnchor){
				// ((LeftOrRightAnchor)sourceAnchor).getLocation(targetAnchor.getReferencePoint());
				// startLeft = ((LeftOrRightAnchor)sourceAnchor).isLeft();
				// }
				boolean targetLeft = false;
				if (targetAnchor instanceof LeftOrRightAnchor) {
					((LeftOrRightAnchor) targetAnchor).getLocation(sourceAnchor.getReferencePoint());
					targetLeft = ((LeftOrRightAnchor) targetAnchor).isLeft();
				}

				graphics.pushState();
				graphics.setBackgroundColor(ColorConstants.button);
				if (targetLeft) {
					Point p = this.getBounds().getTopLeft();
					Point p2 = this.getBounds().getBottomLeft();
					Point p3 = this.getBounds().getTopRight();
					p3 = new Point(p3.x, p3.y + this.getSize().height / 2);
					PointList pointList = new PointList();
					pointList.addPoint(p);
					pointList.addPoint(p2.x, p2.y - 1);
					pointList.addPoint(p3);
					graphics.fillPolygon(pointList);
					graphics.drawPolygon(pointList);
				} else {
					Point p = this.getBounds().getTopRight();
					Point p2 = this.getBounds().getBottomRight();
					Point p3 = this.getBounds().getTopLeft();
					p3 = new Point(p3.x, p3.y + this.getSize().height / 2);
					PointList pointList = new PointList();
					pointList.addPoint(p.x - 1, p.y);
					pointList.addPoint(p2.x - 1, p2.y - 1);
					pointList.addPoint(p3);
					graphics.fillPolygon(pointList);
					graphics.drawPolygon(pointList);
				}
				graphics.popState();
			}

		};
		return targetFlagFigure;
	}

	protected void drawLineMarkerImage(Graphics graphics) {
		if (getMarkerImage() != null) {
			graphics.drawImage(getMarkerImage(), this.getFigure().getBounds().getCenter().getTranslated(
					-getMarkerImage().getBounds().width / 2, -getMarkerImage().getBounds().height / 2));
		} 
	}

	protected Connection createConnectionFigure() {
		PolylineConnection connection = new PolylineConnection() {

			@Override
			public void paintFigure(Graphics graphics) {
				graphics.setAlpha(alpha);
				graphics.setLineWidth(3);
//				if (getMarkerImage() == null) {
//					Point p = getBounds().getCenter().getTranslated(-8, -8);
//					graphics.fillRectangle(p.x, p.y, 16, 16);
//				} 
				super.paintFigure(graphics);
				drawLineMarkerImage(graphics);
			}

			public PointList getPoints() {
				ConnectionAnchor sourceAnchor = getSourceConnectionAnchor();
				ConnectionAnchor targetAnchor = getTargetConnectionAnchor();
				boolean startLeft = false;
				if (sourceAnchor instanceof LeftOrRightAnchor) {
					((LeftOrRightAnchor) sourceAnchor).getLocation(targetAnchor.getReferencePoint());
					startLeft = ((LeftOrRightAnchor) sourceAnchor).isLeft();
				}

				boolean targetLeft = false;
				if (targetAnchor instanceof LeftOrRightAnchor) {
					((LeftOrRightAnchor) targetAnchor).getLocation(sourceAnchor.getReferencePoint());
					targetLeft = ((LeftOrRightAnchor) targetAnchor).isLeft();
				}

				PointList list = super.getPoints();
				if (list.size() == 0)
					return list;
				Point start = getStart();
				int slength = 20;
				int tlength = 20;
				if (startLeft) {
					slength = (-slength);
				}
				if (targetLeft) {
					tlength = (-tlength);
				}

				Point start2 = new Point(start.x + slength, start.y);
				Point end = getEnd();
				Point end2 = new Point(end.x + tlength, end.y);
				list.removeAllPoints();
				list.addPoint(start);
				list.addPoint(start2);
				list.addPoint(end2);
				list.addPoint(end);
				return list;
			}
		};
		connection.setConnectionRouter(new ManhattanConnectionRouter());
		return connection;
	}

	public IFigure createFigure() {
		Connection connection = createConnectionFigure();
		IFigure targetFlagFigure = createTargetFlagFigure();
		IFigure sourceFlagFigure = createSourceFlagFigure();
		targetFlagFigure.setSize(7, 7);
		sourceFlagFigure.setSize(7, 7);
		ConnectionLocator targetLocator = new ConnectionLocator(connection, ConnectionLocator.TARGET);
		connection.add(targetFlagFigure, targetLocator);
		ConnectionLocator sourceLocator = new ConnectionLocator(connection, ConnectionLocator.SOURCE);
		connection.add(sourceFlagFigure, sourceLocator);
		connection.setConnectionRouter(new BendpointConnectionRouter());
		return connection;
	}

	public void propertyChange(PropertyChangeEvent evt) {
		String event = evt.getPropertyName();
		if (AbstractSmooksGraphicalModel.PRO_SEVERITY_CHANGED.equals(event)) {
			refreshVisuals();
		}
	}
}
