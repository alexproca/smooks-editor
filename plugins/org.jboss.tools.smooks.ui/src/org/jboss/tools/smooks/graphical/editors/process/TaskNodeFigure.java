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
package org.jboss.tools.smooks.graphical.editors.process;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ActionEvent;
import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.Clickable;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.zest.core.widgets.CGraphNode;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphItem;
import org.jboss.tools.smooks.configuration.SmooksConfigurationActivator;
import org.jboss.tools.smooks.configuration.editors.GraphicsConstants;
import org.jboss.tools.smooks.graphical.actions.DeleteTaskNodeAction;
import org.jboss.tools.smooks.graphical.editors.SmooksProcessGraphicalEditor;
import org.jboss.tools.smooks.graphical.editors.TaskTypeManager;

/**
 * @author Dart
 * 
 */
public class TaskNodeFigure extends Figure {

	private TaskType task;

	private Label problemTooltip;

	private IFigure mainFigure;

	private IFigure addTaskFigure;

	private Image image;

	private String labelText;

	private SmooksProcessGraphicalEditor processGraphicalViewerEditor;

	private Label label;

	private IFigure imageFigure;

	private Color oldLabelColor = null;

	private boolean showAddFigure = false;

	private Rectangle imageSourceRectangle = null;

	private boolean showRectangle = false;

	public TaskNodeFigure(TaskType task, SmooksProcessGraphicalEditor graph,
			Image image, String text) {
		super();
		this.task = task;
		this.processGraphicalViewerEditor = graph;
		this.image = image;
		this.labelText = text;
		this.problemTooltip = new Label();

		initFigure();
		hookTaskNodeFigure();
	}

	public TaskType getTask() {
		return task;
	}

	public void setProblemMessage(String message) {
		if (message == null) {
			this.setToolTip(null);
		} else {
			this.problemTooltip.setText(message);
			this.setToolTip(problemTooltip);
		}
	}

	public Label getLabel() {
		return label;
	}

	private void hookTaskNodeFigure() {
		addTaskFigure.addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent me) {
			}

			public void mouseEntered(MouseEvent me) {
				showAddFigure = true;
				imageSourceRectangle = null;
				addTaskFigure.repaint();
			}

			public void mouseExited(MouseEvent me) {
				showAddFigure = false;
				addTaskFigure.repaint();
			}

			public void mouseHover(MouseEvent me) {
			}

			public void mouseMoved(MouseEvent me) {
			}

		});
	}

	@Override
	protected void paintBorder(Graphics graphics) {
//		super.paintBorder(graphics);
		if (showRectangle) {
			graphics.setLineWidth(2);
//			graphics.setForegroundColor(ColorConstants.blue);
//			graphics.setLineStyle(SWT.LINE_DOT);
			graphics.drawRectangle(getBounds().x+1,getBounds().y+1,getBounds().width - 2 , getBounds().height - 2);
		}
	}

	protected void initFigure() {
		initMainFigure();
		initAddTaskFigure();
		GridLayout girdlLayout = new GridLayout();
		girdlLayout.numColumns = 2;
		this.setLayoutManager(girdlLayout);
		GridData d = new GridData(GridData.FILL_VERTICAL);
		// ToolbarLayout layout = new ToolbarLayout(true);
		// layout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
		this.add(mainFigure);
		this.add(addTaskFigure);
		girdlLayout.setConstraint(addTaskFigure, d);
		// this.setLayoutManager(layout);
	}

	private void initAddTaskFigure() {
		addTaskFigure = new Clickable() {
			@Override
			protected void paintBorder(Graphics graphics) {
			}

			@Override
			protected void paintFigure(Graphics graphics) {
				super.paintFigure(graphics);
				Rectangle rect = getBounds();
				Point center = rect.getCenter();
				String taskId = task.getId();
				if (!showAddFigure
						|| TaskTypeManager.TASK_ID_FREEMARKER_CSV_TEMPLATE
								.equals(taskId)
						|| TaskTypeManager.TASK_ID_FREEMARKER_XML_TEMPLATE
								.equals(taskId)) {
					// int feet = 4;
					graphics.fillRectangle(rect);
					return;
					// imageSourceRectangle = new Rectangle(rect.x + feet,
					// rect.y + feet, rect.width - feet * 2,
					// rect.height - feet * 2);
				} else {
					Graph g = processGraphicalViewerEditor
							.getProcessGraphViewer().getGraphControl();
//					processGraphicalViewerEditor.setNeedupdatewhenshow(false);
					List<?> nodes = g.getNodes();
					for (Iterator<?> iterator = nodes.iterator(); iterator
							.hasNext();) {
						GraphItem item = (GraphItem) iterator.next();
						if (item instanceof CGraphNode) {
							if (TaskNodeFigure.this == ((CGraphNode) item)
									.getFigure()) {
								processGraphicalViewerEditor
										.updateProcessActions(new StructuredSelection(
												item.getData()));
								break;
							}
						}
					}
					List<IAction> actionsList = processGraphicalViewerEditor
							.getProcessPanelActionList();
					boolean hideAddIcon = true;
					for (IAction iAction : actionsList) {
						if (iAction.isEnabled()
								&& !(iAction instanceof DeleteTaskNodeAction)) {
							hideAddIcon = false;
							break;
						}
					}
					if (hideAddIcon) {
						graphics.fillRectangle(rect);
						return;
					}
				}
				Image image = SmooksConfigurationActivator.getDefault()
						.getImageRegistry()
						.get(GraphicsConstants.IMAGE_ADD_TASK_BUTTON);
				if (image != null) {
					// System.out.println(center.x - image.getBounds().width /
					// 2);
					Point location = new Point(center.x
							- image.getBounds().width / 2, center.y
							- image.getBounds().height / 2);
					graphics.drawImage(image, location);
					if (imageSourceRectangle == null) {
						// graphics.drawImage(image, getLocation());
					} else {
						// graphics.drawImage(image, sourceRectangle,
						// imageSourceRectangle);
					}
				}
			}

		};
		((Clickable) addTaskFigure).addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				if (!showAddFigure) {
					return;
				}

				processGraphicalViewerEditor.showTaskControl(task);

				Graph g = processGraphicalViewerEditor.getProcessGraphViewer()
						.getGraphControl();
				processGraphicalViewerEditor.setNeedupdatewhenshow(false);
				List<?> nodes = g.getNodes();
				for (Iterator<?> iterator = nodes.iterator(); iterator
						.hasNext();) {
					GraphItem item = (GraphItem) iterator.next();
					if (item instanceof CGraphNode) {
						if (TaskNodeFigure.this == ((CGraphNode) item)
								.getFigure()) {
							processGraphicalViewerEditor
									.updateProcessActions(new StructuredSelection(
											item.getData()));
							break;
						}
					}
				}
				Menu menu = processGraphicalViewerEditor
						.getProcessGraphViewer().getGraphControl().getMenu();
				menu.setVisible(true);
				// processGraphicalViewerEditor.setNeedupdatewhenshow(true);
			}
		});
		addTaskFigure.setSize(16, 16);
	}

	private void initMainFigure() {
		mainFigure = new Figure();
		imageFigure = new Figure() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics
			 * )
			 */
			@Override
			protected void paintFigure(Graphics graphics) {
				super.paintFigure(graphics);
				if (image != null) {
					graphics.drawImage(image, getLocation());
				} else {
					graphics.drawRectangle(0, 0, 24, 24);
				}
			}

		};
		if (image != null) {
			imageFigure.setSize(new Dimension(image.getBounds().width, image
					.getBounds().height));
		} else {
			imageFigure.setSize(24, 24);
		}

		mainFigure.add(imageFigure);

		label = new Label();
//		label.setForegroundColor(GraphicsConstants.BORDER_CORLOR);
		label.setText(labelText);

		oldLabelColor = label.getForegroundColor();

		mainFigure.add(label);

		ToolbarLayout layout = new ToolbarLayout(false);
		layout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
		mainFigure.setLayoutManager(layout);
	}

	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * @return the labelText
	 */
	public String getLabelText() {
		return labelText;
	}

	/**
	 * @param labelText
	 *            the labelText to set
	 */
	public void setLabelText(String labelText) {
		this.labelText = labelText;
	}

	public void highlightLabel(Color highlightColor) {
		oldLabelColor = label.getForegroundColor();
//		label.setForegroundColor(highlightColor);
		showRectangle = true;
		this.repaint();
	}

	public void unhighlightLabel() {
		if (oldLabelColor != null) {
			label.setForegroundColor(oldLabelColor);
			showRectangle = false;
			this.repaint();
		}
	}

}
