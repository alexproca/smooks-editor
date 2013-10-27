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
package org.jboss.tools.smooks.graphical.editors.editparts.javamapping;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.forms.editor.FormPage;
import org.jboss.tools.smooks.gef.tree.editparts.TreeNodeConnectionEditPart;
import org.jboss.tools.smooks.gef.tree.figures.LeftOrRightAnchor;
import org.jboss.tools.smooks.graphical.editors.IGraphicalEditorPart;
import org.jboss.tools.smooks.graphical.editors.SmooksTaskDetailsEditorSite;
import org.jboss.tools.smooks.graphical.editors.template.SmooksFreemarkerTemplateGraphicalEditor;

/**
 * @author Dart
 * 
 */
public class BeanReferenceConnectionEditPart extends TreeNodeConnectionEditPart {

	public BeanReferenceConnectionEditPart() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.editparts.TreeNodeConnectionEditPart#
	 * createConnectionFigure()
	 */
	@Override
	protected Connection createConnectionFigure() {
		PolylineConnection connection = new PolylineConnection() {

			@Override
			public void paintFigure(Graphics graphics) {
				graphics.setAlpha(alpha);
				super.paintFigure(graphics);
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
		DefaultEditDomain domain = (DefaultEditDomain) getViewer().getEditDomain();
		IEditorPart editorPart = domain.getEditorPart();
		IEditorSite site = editorPart.getEditorSite();
		if (site instanceof SmooksTaskDetailsEditorSite) {
			FormPage page = ((SmooksTaskDetailsEditorSite) site).getParentEditor();
			connection.setForegroundColor(page.getManagedForm().getToolkit().getColors().getBorderColor());

		}
		connection.setLineStyle(Graphics.LINE_CUSTOM);
		connection.setLineDash(new float[] { 10, 5 });
		connection.setLineCap(SWT.CAP_ROUND);
		// connection.set
		// connection.setConnectionRouter(new ManhattanConnectionRouter());
		return connection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.editparts.TreeNodeConnectionEditPart#
	 * isCanDelete()
	 */
	@Override
	public boolean isCanDelete() {
		IEditorPart editorpart = getEditorPart();
		if (editorpart instanceof IGraphicalEditorPart) {
			if (SmooksFreemarkerTemplateGraphicalEditor.ID.equals(((IGraphicalEditorPart) editorpart).getID())) {
				return false;
			}
		}
		return super.isCanDelete();
	}
}
