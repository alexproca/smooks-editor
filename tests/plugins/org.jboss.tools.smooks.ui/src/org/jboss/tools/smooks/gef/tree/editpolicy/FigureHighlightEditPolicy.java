package org.jboss.tools.smooks.gef.tree.editpolicy;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.swt.graphics.Color;
import org.jboss.tools.smooks.configuration.editors.GraphicsConstants;

public class FigureHighlightEditPolicy extends GraphicalEditPolicy {

	private Color revertColor;

	public static Color highLightColor = FigureUtilities.darker(GraphicsConstants.TB_BG_CORLOR);

	public FigureHighlightEditPolicy() {
		super();
	}

	/**
	 * @see org.eclipse.gef.EditPolicy#eraseTargetFeedback(org.eclipse.gef.Request)
	 */
	public void eraseTargetFeedback(Request request) {
		if (revertColor != null) {
			unsetContainerBackgroud(revertColor);
			revertColor = null;
		}

	}

	private void unsetContainerBackgroud(Color c) {
		IFigure figure = getContainerFigure();
		if (figure instanceof IShowHighlighFigure) {
			((IShowHighlighFigure) figure).showbackOldbackgroundColor(c);
		}
		getContainerFigure().setBackgroundColor(c);
	}

	private Color getContainerBackground() {
		return getContainerFigure().getBackgroundColor();
	}

	private IFigure getContainerFigure() {
		return ((GraphicalEditPart) getHost()).getFigure();
	}

	/**
	 * @see org.eclipse.gef.EditPolicy#getTargetEditPart(org.eclipse.gef.Request)
	 */
	public EditPart getTargetEditPart(Request request) {
		return request.getType().equals(RequestConstants.REQ_SELECTION_HOVER) ? getHost() : null;
	}

	private void setContainerBackground(Color c) {
		IFigure figure = getContainerFigure();
		if (figure instanceof IShowHighlighFigure) {
			((IShowHighlighFigure) figure).showHighlightBackgroudColor(c);
		}
		getContainerFigure().setBackgroundColor(c);
	}

	/**
	 * Changes the background color of the container to the highlight color
	 */
	protected void showHighlight() {
		if (revertColor == null) {
			revertColor = getContainerBackground();
			setContainerBackground(highLightColor);
		}
	}

	/**
	 * @see org.eclipse.gef.EditPolicy#showTargetFeedback(org.eclipse.gef.Request)
	 */
	public void showTargetFeedback(Request request) {
		if (request.getType().equals(RequestConstants.REQ_CONNECTION_END) || request.getType().equals(RequestConstants.REQ_ADD))
			showHighlight();
	}

}