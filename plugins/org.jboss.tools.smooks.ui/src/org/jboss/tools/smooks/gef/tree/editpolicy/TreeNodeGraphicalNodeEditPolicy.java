/**
 * 
 */
package org.jboss.tools.smooks.gef.tree.editpolicy;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.swt.graphics.Color;
import org.jboss.tools.smooks.configuration.editors.GraphicsConstants;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.gef.tree.editparts.CreateConnectionCommand;
import org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart;

/**
 * @author DartPeng
 * 
 */
public class TreeNodeGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {

	private Color revertColor;
	private static Color highLightColor = GraphicsConstants.TB_BG_CORLOR;

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#
	 * getConnectionCompleteCommand
	 * (org.eclipse.gef.requests.CreateConnectionRequest)
	 */
	@Override
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
		try {
			Command command = request.getStartCommand();
			if (command != null && command instanceof CreateConnectionCommand) {
				Object targetModel = request.getTargetEditPart().getModel();
				if (targetModel instanceof AbstractSmooksGraphicalModel) {
					if (!((AbstractSmooksGraphicalModel) targetModel)
							.canLinkWithSource(((CreateConnectionCommand) command).getSource()))
						return null;
					Object source = ((CreateConnectionCommand) command).getSource();
					if (source instanceof AbstractSmooksGraphicalModel) {
						if (!((AbstractSmooksGraphicalModel) source).canLinkWithTarget(targetModel))
							return null;
					}
					((CreateConnectionCommand) command).setTarget((AbstractSmooksGraphicalModel) targetModel);
					return command;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#
	 * getConnectionCreateCommand
	 * (org.eclipse.gef.requests.CreateConnectionRequest)
	 */
	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		EditPart sourceEditpart = request.getSourceEditPart();
		Object model = null;
		if (sourceEditpart == null) {
			sourceEditpart = getHost();
		}
		model = sourceEditpart.getModel();
		Class<?> connectionType = null;
		try {
			connectionType = (Class<?>) request.getNewObjectType();
		} catch (Exception e) {

		}
		if (model != null && model instanceof AbstractSmooksGraphicalModel) {
			if (!((AbstractSmooksGraphicalModel) model).isLinkable(connectionType))
				return null;
			EditPart hostPart = getHost();
			CreateConnectionCommand command = null;
			if (hostPart instanceof TreeNodeEditPart) {
				command = ((TreeNodeEditPart) hostPart).createCreateConnectionCommand();
			}
			if (command == null) {
				command = new CreateConnectionCommand();
			}
			command.setSource((AbstractSmooksGraphicalModel) model);
			request.setStartCommand(command);
			return command;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#
	 * getReconnectSourceCommand(org.eclipse.gef.requests.ReconnectRequest)
	 */
	@Override
	protected Command getReconnectSourceCommand(ReconnectRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#
	 * getReconnectTargetCommand(org.eclipse.gef.requests.ReconnectRequest)
	 */
	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see org.eclipse.gef.EditPolicy#eraseTargetFeedback(org.eclipse.gef.Request)
	 */
	public void eraseTargetFeedback(Request request) {
		super.eraseTargetFeedback(request);
//		if (revertColor != null) {
//			unsetContainerBackgroud(revertColor);
//			revertColor = null;
//		}
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
		// if (true) {
		return super.getTargetEditPart(request);
		// }
		// return request.getType().equals(RequestConstants.REQ_SELECTION_HOVER)
		// ? getHost() : null;
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
			setContainerBackground(FigureUtilities.darker(revertColor));
		}
	}

	/**
	 * @see org.eclipse.gef.EditPolicy#showTargetFeedback(org.eclipse.gef.Request)
	 */
	public void showTargetFeedback(Request request) {
		super.showTargetFeedback(request);
//		if (REQ_CONNECTION_START.equals(request.getType()) || REQ_CONNECTION_END.equals(request.getType())
//				|| REQ_RECONNECT_SOURCE.equals(request.getType()) || REQ_RECONNECT_TARGET.equals(request.getType())) {
//			showHighlight();
//		}
	}

}
