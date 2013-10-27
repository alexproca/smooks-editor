/**
 * 
 */
package org.jboss.tools.smooks.gef.tree.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.jboss.tools.smooks.configuration.SmooksConfigurationActivator;
import org.jboss.tools.smooks.configuration.editors.GraphicsConstants;
import org.jboss.tools.smooks.gef.tree.editpolicy.IShowHighlighFigure;
import org.jboss.tools.smooks.gef.tree.model.TreeContainerModel;

/**
 * @author DartPeng
 * 
 */
public class TreeContainerFigure extends Figure implements ISelectableFigure,
		IShowHighlighFigure {

	private IFigure headerFigure;

	private IFigure contentFigure;

	private Label label;

	private TreeContainerModel model;

	private Color targetHeaderColor = GraphicsConstants.TB_BG_CORLOR;

	private Color sourceHeaderColor = ColorConstants.orange;

	protected Color targetHeaderSelectedColor = GraphicsConstants.BORDER_CORLOR;// FigureUtilities.lighter(targetHeaderColor);

	protected Color sourceHeaderSelectedColor = FigureUtilities
			.lighter(sourceHeaderColor);

	private boolean focus;

	private boolean selected;

	private Color highlightColor = null;

	private boolean showHightlight = false;

	private IFigure dragLinkFigure = null;

	private boolean showDragLink = false;

	private boolean isSource = true;

	private Font oldLabelFont;

	public TreeContainerFigure(TreeContainerModel model) {
		super();
		this.model = model;
		this.addChildrenFigures();
		hookFigure();
	}

	/**
	 * @return the isSource
	 */
	public boolean isSource() {
		return isSource;
	}

	/**
	 * @param isSource
	 *            the isSource to set
	 */
	public void setSource(boolean isSource) {
		this.isSource = isSource;
	}

	protected void hookFigure() {
		this.addMouseMotionListener(new MouseMotionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.draw2d.MouseMotionListener#mouseDragged(org.eclipse
			 * .draw2d.MouseEvent)
			 */
			public void mouseDragged(MouseEvent me) {

			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.draw2d.MouseMotionListener#mouseEntered(org.eclipse
			 * .draw2d.MouseEvent)
			 */
			public void mouseEntered(MouseEvent me) {
				showDragLink = true;
				dragLinkFigure.repaint();
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.draw2d.MouseMotionListener#mouseExited(org.eclipse
			 * .draw2d.MouseEvent)
			 */
			public void mouseExited(MouseEvent me) {
				showDragLink = false;
				dragLinkFigure.repaint();
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.draw2d.MouseMotionListener#mouseHover(org.eclipse
			 * .draw2d.MouseEvent)
			 */
			public void mouseHover(MouseEvent me) {

			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.draw2d.MouseMotionListener#mouseMoved(org.eclipse
			 * .draw2d.MouseEvent)
			 */
			public void mouseMoved(MouseEvent me) {

			}

		});
	}

	protected void addChildrenFigures() {

		IFigure headerContainerFigure = new Figure();

		GridLayout gl = new GridLayout();
		gl.numColumns = 2;
		headerContainerFigure.setLayoutManager(gl);

		headerFigure = new Figure() {

			@Override
			protected void paintFigure(Graphics graphics) {
				super.paintFigure(graphics);
				drawHeaderFigure(graphics);
			}

			@Override
			public Dimension getPreferredSize(int hint, int hint2) {
				Dimension size = super.getPreferredSize(hint, hint2);
				int width = Math.max(size.width, 100);
				return new Dimension(width, 25);
			}
		};
		headerFigure.add(headerContainerFigure);

		label = new Label();
		headerContainerFigure.add(label);
		ToolbarLayout layout = new ToolbarLayout();
		layout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gl.setConstraint(label, gd);

		dragLinkFigure = new DragLinkFigure() {

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
				if (showDragLink) {
					if (model instanceof TreeContainerModel) {
						if (!((TreeContainerModel) model).canDragLink()) {
							return;
						}
					}
					Image img = SmooksConfigurationActivator.getDefault()
							.getImageRegistry()
							.get(GraphicsConstants.IMAGE_DRAG_LINK);
					if (img != null) {
						graphics.drawImage(img, getLocation());
					}
				}
			}
		};
		dragLinkFigure.addMouseMotionListener(new MouseMotionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.draw2d.MouseMotionListener#mouseDragged(org.eclipse
			 * .draw2d.MouseEvent)
			 */
			public void mouseDragged(MouseEvent me) {

			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.draw2d.MouseMotionListener#mouseEntered(org.eclipse
			 * .draw2d.MouseEvent)
			 */
			public void mouseEntered(MouseEvent me) {
				showDragLink = true;
				dragLinkFigure.repaint();
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.draw2d.MouseMotionListener#mouseExited(org.eclipse
			 * .draw2d.MouseEvent)
			 */
			public void mouseExited(MouseEvent me) {
				showDragLink = false;
				dragLinkFigure.repaint();
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.draw2d.MouseMotionListener#mouseHover(org.eclipse
			 * .draw2d.MouseEvent)
			 */
			public void mouseHover(MouseEvent me) {

			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.draw2d.MouseMotionListener#mouseMoved(org.eclipse
			 * .draw2d.MouseEvent)
			 */
			public void mouseMoved(MouseEvent me) {

			}

		});
		dragLinkFigure.setSize(16, 16);
		gd = new GridData();
		gd.horizontalAlignment = GridData.END;
		gl.setConstraint(dragLinkFigure, gd);

		headerContainerFigure.add(dragLinkFigure);

		headerFigure.setLayoutManager(layout);
		headerFigure.setOpaque(true);

		contentFigure = new Figure();
		contentFigure.setLayoutManager(new ToolbarLayout());
		this.add(headerFigure);
		this.add(contentFigure);
		ToolbarLayout tl = new ToolbarLayout();
		tl.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
		this.setLayoutManager(tl);
	}

	protected void drawHeaderFigure(Graphics graphics) {
		try {
			graphics.pushState();
			Color currentColor = sourceHeaderColor;
//			label.getFont().getFontData()[0].setStyle(SWT.NORMAL);
			if (!isSource)
				currentColor = targetHeaderColor;
			if (isSelected() || isFocus() || showHightlight) {
//				label.getFont().getFontData()[0].setStyle(SWT.BOLD);
				currentColor = sourceHeaderSelectedColor;
				if (!isSource)
					currentColor = targetHeaderSelectedColor;
			}
			if (showHightlight && highlightColor != null) {
				currentColor = highlightColor;
			}
			graphics.setForegroundColor(currentColor);
			graphics.setBackgroundColor(ColorConstants.white);
			graphics.fillGradient(headerFigure.getBounds().expand(30, 0), true);
			graphics.setForegroundColor(currentColor);
			graphics.drawLine(getBounds().getBottomLeft().translate(0, -1),
					getBounds().getBottomRight().translate(0, -1));
			graphics.popState();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the label
	 */
	public Label getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(Label label) {
		this.label = label;
	}

	public IFigure getContentFigure() {
		return contentFigure;
	}

	public Color getHeaderColor() {
		return targetHeaderColor;
	}

	public void setHeaderColor(Color headerColor) {
		this.targetHeaderColor = headerColor;
	}

	public Rectangle getBounds() {
		Rectangle rect = super.getBounds();
		if (getLayoutManager() != null) {
			Dimension d = getLayoutManager().getPreferredSize(this, -1, -1);
			rect.setSize(d);
		}
		return rect;
	}

	@Override
	protected void paintBorder(Graphics graphics) {
//		if(true){
//			super.paintBorder(graphics);
//			return;
//		}
		try {
			graphics.setLineStyle(SWT.LINE_SOLID);
			graphics.setForegroundColor(ColorConstants.buttonDarkest);
			if (isSelected() || isFocus()) {
				graphics.setForegroundColor(ColorConstants.blue);
				graphics.setLineStyle(SWT.LINE_DOT);
			}

			if (showHightlight && highlightColor != null) {
				graphics.setForegroundColor(FigureUtilities
						.darker(highlightColor));
				graphics.setLineStyle(SWT.LINE_DOT);
			}
			Rectangle drawnRectangle = new Rectangle(getBounds().x,
					getBounds().y, getBounds().width - 1,
					getBounds().height - 1);
			graphics.drawRoundRectangle(drawnRectangle, 5, 5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setText(String text) {
		if (label != null) {
			label.setText(text);
		}
	}

	public TreeContainerModel getModel() {
		return model;
	}

	public void setModel(TreeContainerModel model) {
		this.model = model;
	}

	@Override
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		graphics.pushState();
		graphics.setAlpha(190);
		graphics.setBackgroundColor(ColorConstants.white);
		graphics.fillRectangle(getBounds());
		graphics.popState();
	}

	public void setIcon(Image i) {
		if (label != null) {
			label.setIcon(i);
		}
	}

	/**
	 * @return the headerFigure
	 */
	public IFigure getHeaderFigure() {
		return headerFigure;
	}

	/**
	 * @param headerFigure
	 *            the headerFigure to set
	 */
	public void setHeaderFigure(IFigure headerFigure) {
		this.headerFigure = headerFigure;
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

	/**
	 * @param contentFigure
	 *            the contentFigure to set
	 */
	public void setContentFigure(IFigure contentFigure) {
		this.contentFigure = contentFigure;
		// this.repaint(0,0,0,0);
		repaint();
	}

	public void showbackOldbackgroundColor(Color color) {
		showHightlight = false;
		highlightColor = null;
		repaint();
	}

	public void showHighlightBackgroudColor(Color color) {
		showHightlight = true;
		highlightColor = color;
		repaint();
	}

}
