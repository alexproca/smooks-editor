/**
 * 
 */
package org.jboss.tools.smooks.gef.tree.figures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ActionEvent;
import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.Clickable;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.jboss.tools.smooks.configuration.editors.GraphicsConstants;
import org.jboss.tools.smooks.gef.tree.editpolicy.IShowHighlighFigure;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;

/**
 * @author DartPeng
 * 
 */
public class TreeNodeFigure extends Figure implements ISelectableFigure, IShowHighlighFigure {
	private List<ITreeFigureListener> treeListener = new ArrayList<ITreeFigureListener>();

	private Color oldLabelColor = null;

	protected int SPACE_INT = 14;

	protected int CLICKNODE_HEIGHT = 18;

	protected int CLICKNODE_WIDTH = 18;

	private Figure contentFigure;

	private Figure labelContainer;

	private Figure clickNode;

	private Label label;

	private boolean mouseEnter = false;

	protected boolean expand = false;

	private TreeNodeModel model;

	private boolean focus;

	private boolean selected;

	private Image labelImage = null;

	private boolean showHighlight;

	public TreeNodeFigure(TreeNodeModel model) {
		super();
		this.model = model;
		this.setBorder(new MarginBorder(2, 2, 2, 2));
		this.setLayoutManager(createTreeNodeFigureLayout());
		createLabelContainer();
		createContentFigure();
		initFigure();
	}

	protected ToolbarLayout createTreeNodeFigureLayout() {
		return new ToolbarLayout();
	}

	protected void initFigure() {

	}

	public void addTreeListener(ITreeFigureListener listener) {
		treeListener.add(listener);
	}

	public void removeTreeListener(ITreeFigureListener listener) {
		treeListener.remove(listener);
	}

	public TreeNodeModel getModel() {
		return model;
	}

	public boolean isExpand() {
		return expand;
	}

	public void setModel(TreeNodeModel model) {
		this.model = model;
	}

	public Label getLabel() {
		return label;
	}

	/**
	 * @return the focus
	 */
	public boolean isFocus() {
		return focus;
	}

	/**
	 * @param focus
	 *            the focus to set
	 */
	public void setFocus(boolean focus) {
		this.focus = focus;
		repaint();
	}

	/**
	 * @return the selected
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * @param selected
	 *            the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
		repaint();
	}

	private void createContentFigure() {
		Figure panelFigure = new Figure();
		ToolbarLayout layout = new ToolbarLayout();
		layout.setVertical(false);
		panelFigure.setLayoutManager(layout);
		Figure spaceFigure = new Figure() {
			@Override
			public Dimension getPreferredSize(int hint, int hint2) {
				return new Dimension(SPACE_INT, 0);
			}
		};
		if (needSpaceFigure()) {
			panelFigure.add(spaceFigure);
		}
		contentFigure = new Figure() {

			@Override
			protected void paintFigure(Graphics graphics) {
				super.paintFigure(graphics);
				// graphics.drawRectangle(getBounds().x + 1, getBounds().y + 1,
				// getBounds().width - 2,
				// getBounds().height - 2);
			}

		};
		panelFigure.add(contentFigure);
		contentFigure.setLayoutManager(createContentFigureLayout());
		this.add(panelFigure);
	}

	protected boolean needSpaceFigure() {
		return true;
	}

	public Figure getContentFigure() {
		return contentFigure;
	}

	@Override
	public Dimension getPreferredSize(int hint, int hint2) {
		if (expand) {
			// contentFigure.setSize(-1, -1);
			// LayoutManager manager = contentFigure.getLayoutManager();
			// if(manager != null){
			// manager.invalidate();
			// }
			return super.getPreferredSize(hint, hint2);
		} else {
			LayoutManager layout = labelContainer.getLayoutManager();
			if (layout != null)
				layout.invalidate();
			labelContainer.invalidateTree();
			try {
				Dimension size = labelContainer.getPreferredSize(hint, hint2);
				Insets insets = getBorder().getInsets(null);
				return new Dimension(size.width + insets.left + insets.right, size.height + insets.bottom + insets.top);
			} catch (Throwable t) {
				return new Dimension(100, 100);
			}
			// return super.getPreferredSize(hint, hint2);
		}
	}
	
	

	/**
	 * @return the clickNode
	 */
	public Figure getClickNode() {
		return clickNode;
	}

	protected void createLabelContainer() {
		labelContainer = new Figure() {
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
				// graphics.drawRectangle(getBounds().x + 1, getBounds().y + 1,
				// getBounds().width - 2,
				// getBounds().height - 2);
			}

		};
		clickNode = new Clickable() {

			public void paintBorder(Graphics graphics) {

			}

			public void paintFigure(Graphics graphics) {
				drawClickFigure(clickNode, graphics);
			}
		};
		((Clickable) clickNode).addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				boolean hasChildren = model.hasChildren();
				if (!hasChildren)
					return;
				changeTreeExpansionState();
			}

		});
		((Clickable) clickNode).addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent me) {
			}

			public void mouseEntered(MouseEvent me) {
				boolean hasChildren = model.hasChildren();
				if (!hasChildren)
					return;
				mouseEnter = true;
				clickNode.repaint();
			}

			public void mouseExited(MouseEvent me) {
				boolean hasChildren = model.hasChildren();
				if (!hasChildren)
					return;
				mouseEnter = false;
				clickNode.repaint();
			}

			public void mouseHover(MouseEvent me) {
			}

			public void mouseMoved(MouseEvent me) {
			}

		});
		clickNode.setSize(new Dimension(CLICKNODE_WIDTH, CLICKNODE_HEIGHT));

		Figure imageFigure = new Figure() {
			@Override
			protected void paintFigure(Graphics graphics) {
				super.paintFigure(graphics);
				if (labelImage != null) {
					graphics.drawImage(labelImage, getBounds().getTopLeft().x, getBounds().getTopLeft().y + 2);
				}
			}
		};
		imageFigure.setSize(new Dimension(18, 18));

		label = new Label();
		if (isFocus()) {
		}
		if (model != null) {
			label.setText(model.getText());
		} else {
			label.setText(""); //$NON-NLS-1$
		}
		if (needClickFigure()) {
			labelContainer.add(clickNode);
		}
		labelContainer.add(imageFigure);
		labelContainer.add(label);
		labelContainer.setLayoutManager(createLabelContainerLayout());
		this.add(labelContainer);
	}

	protected boolean needClickFigure() {
		return true;
	}

	protected LayoutManager createLabelContainerLayout() {
		ToolbarLayout tl = new ToolbarLayout();
		tl.setVertical(false);
		return tl;
	}

	public void updateLabel() {
		if (model != null) {
			label.setText(model.getText());
		} else {
			label.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * @param labelImage
	 *            the labelImage to set
	 */
	public void setLabelImage(Image labelImage) {
		this.labelImage = labelImage;
	}

	public void setLabelText(String text) {
		label.setText(text);
	}

	protected ToolbarLayout createContentFigureLayout() {
		ToolbarLayout layout = new ToolbarLayout();
		return layout;
	}

	public void paint(Graphics graphics) {
		if (oldLabelColor == null){
			oldLabelColor = label.getForegroundColor();
		}
		label.setOpaque(false);
		label.setForegroundColor(oldLabelColor);
		if (isFocus() || isSelected() || showHighlight) {
			label.setOpaque(true);
			label.setBackgroundColor(GraphicsConstants.FONT_COLOR);
			label.setForegroundColor(ColorConstants.white);
		}

		super.paint(graphics);
	}
	
	public void setNodeLabelForegroundColor(Color color){
		this.oldLabelColor = color;
	}

	protected void drawClickFigure(IFigure clickFigure, Graphics graphics) {
		Rectangle rect = clickFigure.getBounds();
		Point center = rect.getCenter();
		int width = 8;
		PointList pointList = new PointList();
		boolean hasChildren = model.hasChildren();
		if (hasChildren) {
			if (expand) {
				Point point1 = new Point(center.x - width / 2, center.y - width / 4);
				Point point2 = new Point(point1.x + width, point1.y);
				Point point3 = new Point(point1.x + width / 2, point1.y + width / 2);
				pointList.addPoint(point1);
				pointList.addPoint(point2);
				pointList.addPoint(point3);
			} else {
				Point point1 = new Point(center.x - width / 4, center.y - width / 2);
				Point point2 = new Point(point1.x, point1.y + width);
				Point point3 = new Point(point1.x + width / 2, point1.y + width / 2);
				pointList.addPoint(point1);
				pointList.addPoint(point2);
				pointList.addPoint(point3);
			}
			graphics.drawPolygon(pointList);
		}
		if (mouseEnter) {
			graphics.pushState();
			graphics.setBackgroundColor(ColorConstants.black);
			graphics.fillPolygon(pointList);
			graphics.popState();
		}
	}

	public void expandNode() {
		expand = false;
		changeTreeExpansionState();
	}

	public void collapsedNode() {
		expand = true;
		changeTreeExpansionState();
	}

	private void changeTreeExpansionState() {
		try {
			IFigure parent = contentFigure.getParent();
			while (parent != null) {
				if (parent instanceof TreeContainerFigure) {
					break;
				}
				parent = parent.getParent();
			}
			if (parent != null) {
				Rectangle oldRectangle = parent.getClientArea();
				expand = !expand;
				for (Iterator<ITreeFigureListener> iterator = this.treeListener.iterator(); iterator.hasNext();) {
					ITreeFigureListener listener = (ITreeFigureListener) iterator.next();
					TreeFigureExpansionEvent event = new TreeFigureExpansionEvent(this);
					if (!expand) {
						listener.treeCollapsed(event);
					} else {
						listener.treeExpanded(event);
					}
				}
				if (!expand) {
					contentFigure.setLayoutManager(null);
					contentFigure.setSize(new Dimension(0, 0));
				} else {
					contentFigure.setLayoutManager(createContentFigureLayout());
					contentFigure.setSize(contentFigure.getPreferredSize());
				}
				Rectangle newRectangle = parent.getClientArea();
				int w = Math.max(oldRectangle.width, newRectangle.width);
				int h = Math.max(oldRectangle.height, newRectangle.height);
				// IFigure currentParent = contentFigure.getParent();
				// currentParent.invalidateTree();
				// LayoutManager layout = currentParent.getLayoutManager();
				// if(layout != null){
				// layout.layout(currentParent);
				// }
				IFigure panel = parent.getParent();
				if (panel != null) {
					// panel.repaint();
					panel.repaint(oldRectangle.x, oldRectangle.y, w, h);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showHighlightBackgroudColor(Color color) {
		showHighlight = true;
		repaint();
	}

	public void showbackOldbackgroundColor(Color color) {
		showHighlight = false;
		repaint();
	}
}
