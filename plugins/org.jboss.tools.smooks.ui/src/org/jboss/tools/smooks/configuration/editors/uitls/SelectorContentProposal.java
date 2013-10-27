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

import org.eclipse.jface.fieldassist.IContentProposal;
import org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject;

/**
 * @author Dart (dpeng@redhat.com)
 *
 */
public class SelectorContentProposal implements IContentProposal {

	private String content = null;
	private IXMLStructuredObject node;
	
	
	
	public SelectorContentProposal(IXMLStructuredObject node){
		this.node = node;
		this.content = SmooksUIUtils.generateFullPath(node, "/"); //$NON-NLS-1$
	}
	
	
	/**
	 * @return the node
	 */
	public IXMLStructuredObject getNode() {
		return node;
	}


	/**
	 * @param node the node to set
	 */
	public void setNode(IXMLStructuredObject node) {
		this.node = node;
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
		String content = this.getContent();
//		if(content != null){
//			String[] s = content.split("/");
//			if(s != null && s.length > 4){
//				String newContent = "";
//				for(int i = s.length - 1; i > 4 ; i --){
//					newContent = newContent + "/" + s[i];
//				}
//				newContent = "..." + newContent; 
//				
//				return newContent;
//			}
//		}
		return content;
	}

}
