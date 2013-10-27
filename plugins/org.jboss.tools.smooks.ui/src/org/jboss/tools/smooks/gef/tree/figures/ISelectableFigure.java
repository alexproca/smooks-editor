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
package org.jboss.tools.smooks.gef.tree.figures;

/**
 * @author Dart
 * 
 */
public interface ISelectableFigure {
	void setSelected(boolean selected);

	boolean isSelected();

	void setFocus(boolean focus);

	boolean isFocus();
}
