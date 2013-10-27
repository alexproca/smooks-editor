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

/**
 * @author Dart (dpeng@redhat.com)
 *
 */
public class BindingsContextContentProposal implements IContentProposal {
	
	private int startIndex = 0;
	
	private String content = null;
	
	public static final int BINDINGS = 1;
	
	public static final int PROPERTIES = 2;
	
	public static final int WIRTINGS = 3;

	public static final int EXPRESSIONS = 4;
	
	private int type = BINDINGS;

	public BindingsContextContentProposal(int type , String content,int startIndex){
		this.startIndex = startIndex;
		this.content = content;
		this.type = type;
	}
	
	
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}



	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}



	/* (non-Javadoc)
	 * @see org.eclipse.jface.fieldassist.IContentProposal#getContent()
	 */
	public String getContent() {
		// TODO Auto-generated method stub
		return content;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.fieldassist.IContentProposal#getCursorPosition()
	 */
	public int getCursorPosition() {
		if(content != null){
			return getContent().length() + startIndex ;
		}
		return startIndex;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.fieldassist.IContentProposal#getDescription()
	 */
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.fieldassist.IContentProposal#getLabel()
	 */
	public String getLabel() {
		String name = ""; //$NON-NLS-1$
		if(type == BINDINGS){
			name = "Bean"; //$NON-NLS-1$
		}
		if(type == PROPERTIES){
			name = "Value Binding"; //$NON-NLS-1$
		}
		if(type == WIRTINGS){
			name = "Bean Binding"; //$NON-NLS-1$
		}
		if(type == EXPRESSIONS){
			name = "Expression Binding"; //$NON-NLS-1$
		}
		if(name.length() != 0 && content != null){
			return content + " - ( " + name + " )"; //$NON-NLS-1$ //$NON-NLS-2$
		}
		return  content;
	}

}
