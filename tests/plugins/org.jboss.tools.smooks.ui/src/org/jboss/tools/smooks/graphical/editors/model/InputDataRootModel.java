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

import java.util.ArrayList;
import java.util.List;

import org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject;

/**
 * @author Dart
 *
 */
public class InputDataRootModel implements IXMLStructuredObject {
	
	private String type = null;
	
	private List<IXMLStructuredObject> children;
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject#getChildren()
	 */
	public List<IXMLStructuredObject> getChildren() {
		if(children == null){
			children = new ArrayList<IXMLStructuredObject>();
		}
		return children;
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject#getID()
	 */
	public Object getID() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject#getNodeName()
	 */
	public String getNodeName() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject#getParent()
	 */
	public IXMLStructuredObject getParent() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject#isAttribute()
	 */
	public boolean isAttribute() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject#isRootNode()
	 */
	public boolean isRootNode() {
		return false;
	}

}
