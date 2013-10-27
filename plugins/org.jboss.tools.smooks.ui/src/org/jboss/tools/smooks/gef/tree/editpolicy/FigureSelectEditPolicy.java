/*******************************************************************************
 * Copyright (c) 2008 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.smooks.gef.tree.editpolicy;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.jboss.tools.smooks.gef.tree.figures.ISelectableFigure;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class FigureSelectEditPolicy extends NonResizableEditPolicy {

	private ISelectableFigure getSelectableFigure() {
		AbstractGraphicalEditPart host = (AbstractGraphicalEditPart) getHost();
		IFigure figure = host.getFigure();
		if (figure instanceof ISelectableFigure) {
			return (ISelectableFigure) figure;
		}
		return null;
	}

	protected Rectangle getInitialFeedbackBounds() {
//		try {
//			if (((GraphicalEditPart) getHost()).getFigure() instanceof HandleBounds)
//				return ((HandleBounds) ((GraphicalEditPart) getHost()).getFigure()).getHandleBounds();
//			Rectangle rect = ((GraphicalEditPart) getHost()).getFigure().getBounds();
//			if (getTreeNodeFigure() != null) {
//				rect.height = getTreeNodeFigure().getLabel().getBounds().height;
//			}
//			return rect;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return super.getInitialFeedbackBounds();
	}

	/**
	 * @see org.eclipse.gef.editpolicies.NonResizableEditPolicy#hideFocus()
	 */
	protected void hideFocus() {
		if(true){
			super.hideFocus();
			return;
		}
		if (getSelectableFigure() != null) {
			getSelectableFigure().setFocus(false);
		}
	}

	/**
	 * @see org.eclipse.gef.editpolicies.SelectionHandlesEditPolicy#hideSelection()
	 */
	protected void hideSelection() {
		if(true){
			super.hideSelection();
			return;
		}
		if (getSelectableFigure() != null) {
			getSelectableFigure().setSelected(false);
			getSelectableFigure().setFocus(false);
		}
	}

	/**
	 * @see org.eclipse.gef.editpolicies.NonResizableEditPolicy#showFocus()
	 */
	protected void showFocus() {
		if(true){
			super.showFocus();
			return;
		}
		if (getSelectableFigure() != null) {
			getSelectableFigure().setFocus(true);
		}
	}

	/**
	 * @see org.eclipse.gef.editpolicies.SelectionHandlesEditPolicy#showSelection()
	 */
	protected void showPrimarySelection() {
		if(true){
			super.showPrimarySelection();
			return;
		}
		if (getSelectableFigure() != null) {
			getSelectableFigure().setSelected(true);
			getSelectableFigure().setFocus(true);
		}
	}

	/**
	 * @see org.eclipse.gef.editpolicies.SelectionHandlesEditPolicy#showSelection()
	 */
	protected void showSelection() {
		if(true){
			super.showSelection();
			return;
		}
		if (getSelectableFigure() != null) {
			getSelectableFigure().setSelected(true);
			getSelectableFigure().setFocus(false);
		}
	}

}
