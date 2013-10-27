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
package org.jboss.tools.smooks.configuration.editors;

import org.eclipse.jface.window.DefaultToolTip;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.IFormColors;
import org.jboss.tools.smooks.configuration.SmooksConfigurationActivator;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class FieldMarkerComposite extends Canvas implements IFieldMarker, PaintListener {

	private Image errorImage = null;

	private Image waringImage = null;

	// private Image informationImage = null;

	private int type = TYPE_NONE;

	private DefaultToolTip toolTip = null;

	public FieldMarkerComposite(Composite parent, int style) {
		super(parent, style);
		this.setBackground(new Color(null,255,255,255));
		errorImage = SmooksConfigurationActivator.getDefault().getImageRegistry()
				.get(GraphicsConstants.IMAGE_OVR_ERROR);
		waringImage = SmooksConfigurationActivator.getDefault().getImageRegistry().get(
				GraphicsConstants.IMAGE_OVR_WARING);
		this.addPaintListener(this);
		toolTip = new DefaultToolTip(this) {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.jface.window.DefaultToolTip#createToolTipContentArea
			 * (org.eclipse.swt.widgets.Event,
			 * org.eclipse.swt.widgets.Composite)
			 */
			@Override
			protected Composite createToolTipContentArea(Event event, Composite parent) {
				return super.createToolTipContentArea(event, parent);
			}

			public Point getLocation(Point tipSize, Event event) {
				Point point = super.getLocation(tipSize, event);
				point.y = ((Control) getToolTipArea(null)).toDisplay(0, 0).y - 24;
				point.x = ((Control) getToolTipArea(null)).toDisplay(0, 0).x;
				return point;
			}

		};
		((DefaultToolTip) toolTip).setBackgroundColor(new Color(null, 255, 255, 255));
		FormColors colors = new FormColors(getDisplay());
		((DefaultToolTip) toolTip).setForegroundColor(colors.getColor(IFormColors.TITLE));
		toolTip.setStyle(SWT.NONE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.configuration.editors.IFieldMarker#setMarkerType()
	 */
	public void setMarkerType(int type) {
		this.type = type;
		if (this.isDisposed())
			return;
		this.redraw();
	}

	public int getMarkerType() {
		return type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.configuration.editors.IFieldMarker#setMessage()
	 */
	public void setMessage(String message) {
		toolTip.setText(message);
	}

	public String getMessage() {
		return getToolTipText();
	}

	public void clean() {
		setMarkerType(TYPE_NONE);
		if(isDisposed()) return;
		this.setToolTipText(null);
		this.redraw();
	}

	public void paintControl(PaintEvent e) {
		GC gc = e.gc;
		gc.fillRectangle(getBounds());
		if (type == IFieldMarker.TYPE_ERROR) {
			gc.drawImage(errorImage, 0, 0);
		}
		if (type == IFieldMarker.TYPE_WARINING) {
			gc.drawImage(waringImage, 0, 0);
		}
	}

}
