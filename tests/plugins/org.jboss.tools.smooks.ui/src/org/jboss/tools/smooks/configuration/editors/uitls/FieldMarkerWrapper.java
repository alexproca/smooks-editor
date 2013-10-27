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
package org.jboss.tools.smooks.configuration.editors.uitls;

import org.eclipse.swt.widgets.Control;
import org.jboss.tools.smooks.configuration.editors.IFieldMarker;

/**
 * @author Dart (dpeng@redhat.com)
 *
 */
public class FieldMarkerWrapper {
	private IFieldMarker marker;
	
	private Control labelControl;

	/**
	 * @return the marker
	 */
	public IFieldMarker getMarker() {
		return marker;
	}

	/**
	 * @param marker the marker to set
	 */
	public void setMarker(IFieldMarker marker) {
		this.marker = marker;
	}

	/**
	 * @return the labelControl
	 */
	public Control getLabelControl() {
		return labelControl;
	}

	/**
	 * @param labelControl the labelControl to set
	 */
	public void setLabelControl(Control labelControl) {
		this.labelControl = labelControl;
	}
	
	
}
