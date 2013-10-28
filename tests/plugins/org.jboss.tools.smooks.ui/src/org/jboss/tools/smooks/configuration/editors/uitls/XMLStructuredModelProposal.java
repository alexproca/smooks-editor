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
package org.jboss.tools.smooks.configuration.editors.utils;

import org.eclipse.jface.fieldassist.IContentProposal;
import org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject;
import org.jboss.tools.smooks.configuration.editors.javabean12.JavaBeanModel;

/**
 * @author Dart (dpeng@redhat.com)
 *
 */
public class XMLStructuredModelProposal implements IContentProposal {

	private IXMLStructuredObject xmlStructuredObject;
	
	private String content = null;
	
	public XMLStructuredModelProposal(IXMLStructuredObject xmlStructuredObject){
		this.xmlStructuredObject = xmlStructuredObject;
		content = this.xmlStructuredObject.getNodeName();
		if(xmlStructuredObject instanceof JavaBeanModel){
			content = ((JavaBeanModel)this.xmlStructuredObject).getName();
		}
	}
	
	
	/**
	 * @return the xmlStructuredObject
	 */
	public IXMLStructuredObject getXmlStructuredObject() {
		return xmlStructuredObject;
	}


	/**
	 * @param xmlStructuredObject the xmlStructuredObject to set
	 */
	public void setXmlStructuredObject(IXMLStructuredObject xmlStructuredObject) {
		this.xmlStructuredObject = xmlStructuredObject;
	}


	/* (non-Javadoc)
	 * @see org.eclipse.jface.fieldassist.IContentProposal#getContent()
	 */
	public String getContent() {
		return content;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.fieldassist.IContentProposal#getCursorPosition()
	 */
	public int getCursorPosition() {
		if(content != null){
			return content.length();
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.fieldassist.IContentProposal#getDescription()
	 */
	public String getDescription() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.fieldassist.IContentProposal#getLabel()
	 */
	public String getLabel() {
		return content;
	}

}
