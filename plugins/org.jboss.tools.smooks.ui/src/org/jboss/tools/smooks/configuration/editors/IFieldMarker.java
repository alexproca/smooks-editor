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

/**
 * @author Dart (dpeng@redhat.com)
 *
 */
public interface IFieldMarker {
	
	int TYPE_ERROR = 1;
	
	int TYPE_WARINING = 2;
	
	int TYPE_NONE = 0;
	
	void setMessage(String message);
	
	void setMarkerType(int type);
	
	int getMarkerType();
	
	String getMessage();
	
	void clean();
}
