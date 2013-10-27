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
package org.jboss.tools.smooks.graphical.editors.editparts;

import java.beans.PropertyChangeEvent;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.configuration.SmooksConfigurationActivator;
import org.jboss.tools.smooks.configuration.editors.GraphicsConstants;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.gef.tree.editparts.TreeContainerEditPart;
import org.jboss.tools.smooks.gef.tree.figures.TreeContainerFigure;
import org.jboss.tools.smooks.gef.tree.model.TreeContainerModel;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;
import org.jboss.tools.smooks.graphical.editors.model.InputDataContianerModel;

/**
 * @author Dart
 * 
 */
public class InputDataContainerEditPart extends TreeContainerEditPart {

	private String inputType = null;

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		super.propertyChange(evt);
	}

	@Override
	protected String generateFigureID() {
		return SmooksGraphUtil.generateFigureID((TreeNodeModel) getModel());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.editparts.TreeContainerEditPart#createFigure
	 * ()
	 */
	@Override
	protected IFigure createFigure() {

		final int zwidth = 20;

		IFigure figure = new TreeContainerFigure((TreeContainerModel) getModel()) {

			/*
			 * (non-Javadoc)
			 * 
			 * @seeorg.jboss.tools.smooks.gef.tree.figures.TreeContainerFigure#
			 * addChildrenFigures()
			 */
			@Override
			protected void addChildrenFigures() {
				IFigure headerFigure1 = new Figure() {

					@Override
					protected void paintFigure(Graphics graphics) {
						super.paintFigure(graphics);
					}

					@Override
					public Dimension getPreferredSize(int hint, int hint2) {
						Dimension size = super.getPreferredSize(hint, hint2);
						int width = Math.max(size.width, 100);
						return new Dimension(width, 25);
					}
				};
				this.add(headerFigure1);
				super.addChildrenFigures();
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @seeorg.jboss.tools.smooks.gef.tree.figures.TreeContainerFigure#
			 * drawHeaderFigure(org.eclipse.draw2d.Graphics)
			 */
			@Override
			protected void drawHeaderFigure(Graphics graphics) {
				// TODO Auto-generated method stub
				// super.drawHeaderFigure(graphics);
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @seeorg.jboss.tools.smooks.gef.tree.figures.TreeContainerFigure#
			 * paintBorder(org.eclipse.draw2d.Graphics)
			 */
			@Override
			protected void paintBorder(Graphics graphics) {
				// super.paintBorder(graphics);
				if (isSelected() || isFocus()) {
					graphics.setForegroundColor(ColorConstants.blue);
					graphics.setLineStyle(SWT.LINE_DOT);
				} else {
					graphics.setForegroundColor(FigureUtilities.darker(ColorConstants.orange));
					graphics.setLineStyle(SWT.LINE_SOLID);
				}

				Point p2 = new Point();
				p2.setLocation(getBounds().getTopLeft().x, getBounds().getTopLeft().y);

				Point p1 = new Point();
				p1.setLocation(getBounds().getTopRight().x - zwidth, getBounds().getTopRight().y);

				graphics.drawLine(p1, p2);

				Point p3 = new Point();
				p3.setLocation(getBounds().getBottomLeft().x, getBounds().getBottomLeft().y - 1);
				graphics.drawLine(p2, p3);

				Point p4 = new Point();
				p4.setLocation(getBounds().getBottomRight().x - 1, getBounds().getBottomRight().y - 1);
				graphics.drawLine(p4, p3);

				Point p5 = new Point();
				p5.setLocation(getBounds().getTopRight().x - 1, getBounds().getTopRight().y + zwidth - 1);
				graphics.drawLine(p4, p5);

				graphics.drawLine(p1, p5);

				Point p6 = new Point();
				p6.setLocation(p1.x, p5.y);
				graphics.drawLine(p5, p6);
				graphics.drawLine(p1, p6);
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @seeorg.jboss.tools.smooks.gef.tree.figures.TreeContainerFigure#
			 * paintFigure(org.eclipse.draw2d.Graphics)
			 */
			@Override
			protected void paintFigure(Graphics graphics) {

				super.paintFigure(graphics);

			}

		};
		return figure;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.gef.tree.editparts.TreeContainerEditPart#
	 * refreshVisuals()
	 */
	@Override
	protected void refreshVisuals() {
		InputDataContianerModel model = (InputDataContianerModel) getModel();
		ISmooksModelProvider provider = model.getSmooksModelProvider();
		if (provider != null) {

			Image image = SmooksConfigurationActivator.getDefault().getImageRegistry().get(
					GraphicsConstants.IMAGE_INPUT_DATA_HEADER);

			String text = Messages.InputDataContainerEditPart_Input_Model;

			if (inputType != null) {
				if (inputType.equals(provider.getInputType())) {
					super.refreshVisuals();
					return;
				}
			}
			inputType = provider.getInputType();
			if (inputType.equals(SmooksModelUtils.INPUT_TYPE_JAVA)) {
				image = SmooksConfigurationActivator.getDefault().getImageRegistry().get(
						GraphicsConstants.IMAGE_JAVA_FILE);

				text = Messages.InputDataContainerEditPart_Java_Input_Model;
			}

			if (inputType.equals(SmooksModelUtils.INPUT_TYPE_XML)) {
				image = SmooksConfigurationActivator.getDefault().getImageRegistry().get(
						GraphicsConstants.IMAGE_XML_FILE);

				text = Messages.InputDataContainerEditPart_XML_Input_Model;
			}

			if (inputType.equals(SmooksModelUtils.INPUT_TYPE_XSD)) {
				image = SmooksConfigurationActivator.getDefault().getImageRegistry().get(
						GraphicsConstants.IMAGE_XSD_FILE);

				text = Messages.InputDataContainerEditPart_XSD_Input_Model;
			}

			if (inputType.equals(SmooksModelUtils.INPUT_TYPE_CSV)) {

				text = Messages.InputDataContainerEditPart_CSV_Input_Model;
			}

			if (inputType.equals(SmooksModelUtils.INPUT_TYPE_EDI_1_1)) {

				text = Messages.InputDataContainerEditPart_EDI_Input_Model;
			}

			if (inputType.equals(SmooksModelUtils.INPUT_TYPE_JSON_1_1)) {

				text = Messages.InputDataContainerEditPart_JSON_Input_Model;
			}

			TreeContainerFigure figure = (TreeContainerFigure) getFigure();
			figure.getLabel().setTextAlignment(Label.LEFT);
			figure.setText(text);
			figure.setIcon(image);
		}

		super.refreshVisuals();
	}

}
