package org.jboss.tools.smooks.gef.tree.figures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;

public class GraphAnimation {

	private int minsteplegth = 30;

	private int maxstep = 50;

	private Map<GraphicalEditPart, Rectangle> initMap = new HashMap<GraphicalEditPart, Rectangle>();

	private Map<GraphicalEditPart, Rectangle> finalMap = new HashMap<GraphicalEditPart, Rectangle>();

	public void recordInit(GraphicalEditPart editpart) {
		initMap.put(editpart, editpart.getFigure().getBounds());
	}

	public void recordFinal(GraphicalEditPart editpart, Rectangle rectangle) {
		finalMap.put(editpart, rectangle);
	}

	public void start(List<GraphicalEditPart> figureList) {
		// if(true) return;
		Map<IFigure, Integer> ystepmap = new HashMap<IFigure, Integer>();
		Map<IFigure, Integer> xstepmap = new HashMap<IFigure, Integer>();
		for (Iterator<?> iterator = figureList.iterator(); iterator.hasNext();) {
			GraphicalEditPart editPart = (GraphicalEditPart) iterator.next();
			IFigure figure = editPart.getFigure();
			Rectangle rect = initMap.get(editPart);
			int initx = rect.x;
			int inity = rect.y;
			Rectangle rect1 = finalMap.get(editPart);
			int finalx = rect1.x;
			int finaly = rect1.y;

			int chax = finalx - initx;
			// if(Math.abs(chax) < minsteplegth){
			// chax = minsteplegth;
			// }
			int xstep = minsteplegth;
			if (chax < 0)
				xstep = -xstep;
			if (Math.abs(chax / minsteplegth) > maxstep) {
				// xstep = chax / maxstep;
			}

			int chay = finaly - inity;
			int ystep = minsteplegth;
			if (chay < 0)
				ystep = -ystep;
			if (Math.abs(chay / minsteplegth) > maxstep) {
				// ystep = chay / maxstep;
			}

			ystepmap.put(figure, ystep);
			xstepmap.put(figure, xstep);
		}
		int allfigure = 0;
		List<GraphicalEditPart> processedParts = new ArrayList<GraphicalEditPart>();
		while (figureList.size() > allfigure) {
			for (Iterator<?> iterator = figureList.iterator(); iterator.hasNext();) {
				GraphicalEditPart editPart = (GraphicalEditPart) iterator.next();
				if (processedParts.contains(editPart)) {
					continue;
				}
				IFigure figure = editPart.getFigure();
				Rectangle rect = figure.getBounds();
				int initx = rect.x;
				int inity = rect.y;

				Rectangle rect1 = finalMap.get(editPart);
				int finalx = rect1.x;
				int finaly = rect1.y;

				int xstep = xstepmap.get(figure);
				int ystep = ystepmap.get(figure);

				int x = initx + xstep;
				int y = inity + ystep;
				if (initx != finalx) {
					if (Math.abs(x - finalx) <= minsteplegth) {
						initx = finalx;
					} else {
						initx = x;
					}
				}

				if (inity != finaly) {
					if (Math.abs(y - finaly) <= minsteplegth) {
						inity = finaly;
					} else {
						inity = y;
					}
				}

				if (initx == finalx && inity == finaly) {
					processedParts.add(editPart);
					allfigure++;
				}

				Point location = new Point(initx, inity);
				Dimension size = figure.getPreferredSize();
				figure.setLocation(new Point(initx, inity));
				figure.getUpdateManager().performUpdate();
				try {
					((GraphicalEditPart) editPart.getParent()).setLayoutConstraint(editPart, figure, new Rectangle(
							location, size));
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			try {
				Thread.sleep(20);
				Thread.yield();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
