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
package org.jboss.tools.smooks.edimap.models;

import org.jboss.tools.smooks.configuration.editors.xml.TagObject;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class EDIDataContainerModel extends TagObject {
	
	private boolean multipe = false;
	
	/**
	 * @return the multipe
	 */
	public boolean isMultipe() {
		return multipe;
	}

	/**
	 * @param multipe the multipe to set
	 */
	public void setMultipe(boolean multipe) {
		this.multipe = multipe;
	}

	public String getSegCode() {
		return getName();
	}
}
