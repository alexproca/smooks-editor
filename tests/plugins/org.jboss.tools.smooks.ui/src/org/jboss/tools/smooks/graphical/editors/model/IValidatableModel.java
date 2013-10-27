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
package org.jboss.tools.smooks.graphical.editors.model;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;

/**
 * @author Dart
 *
 */
public interface IValidatableModel {
	
	public static final int NONE = -1;
	
	public static final int ERROR = Diagnostic.ERROR;
	
	public static final int WARNING = Diagnostic.WARNING;
	
	public int getSeverity();
	
	public void setSeverity(int severity);
	
	public List<String> getMessage();
	
	public void addMessage(String message);
}
