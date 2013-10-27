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

import org.eclipse.swt.widgets.Control;

/**
 * @author Dart (dpeng@redhat.com)
 *
 */
public class AttributeFieldEditPart {
	
	private Object attribute;
	
	private IFieldMarker fieldMarker;
	
	private Control contentControl;

	/**
	 * @return the fieldMarker
	 */
	public IFieldMarker getFieldMarker() {
		return fieldMarker;
	}

	/**
	 * @param fieldMarker the fieldMarker to set
	 */
	public void setFieldMarker(IFieldMarker fieldMarker) {
		this.fieldMarker = fieldMarker;
	}

	/**
	 * @return the contentControl
	 */
	public Control getContentControl() {
		return contentControl;
	}

	/**
	 * @param contentControl the contentControl to set
	 */
	public void setContentControl(Control contentControl) {
		this.contentControl = contentControl;
	}

	/**
	 * @return the attribute
	 */
	public Object getAttribute() {
		return attribute;
	}

	/**
	 * @param attribute the attribute to set
	 */
	public void setAttribute(Object attribute) {
		this.attribute = attribute;
	}
	
	
}
