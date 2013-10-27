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
package org.jboss.tools.smooks.configuration.editors.xml;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject;

/**
 * @author Dart Peng
 * @Date Aug 18, 2008
 */
public class XMLStructuredDataContentProvider implements ITreeContentProvider {

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	public Object[] getChildren(Object obj) {
		// for AbstractXMLObject (come from xml file fragment)
		if(obj instanceof TagList){
			return ((TagList)obj).getRootTagList().toArray();
		}
		
		if(obj instanceof TagObject){
			List c = new ArrayList();
			List pros = ((TagObject)obj).getProperties();
			c.addAll(pros);
			c.addAll(((TagObject)obj).getXMLNodeChildren());
			return c.toArray();
		}
		
		if(obj instanceof IXMLStructuredObject){
			return ((IXMLStructuredObject)obj).getChildren().toArray();
		}
		return new Object[] {};
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object )
	 */
	public Object getParent(Object arg0) {
		 if(arg0 instanceof IXMLStructuredObject){
			 return ((IXMLStructuredObject)arg0).getParent();
		 }
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.
	 *      Object)
	 */
	public boolean hasChildren(Object obj) {
		
		// for AbstractXMLObject (come from xml file fragment)
		if(obj instanceof TagList){
			return true;
		}
		if(obj instanceof TagObject){
			List<?> pros = ((TagObject)obj).getProperties();
			List<?> c = (((TagObject)obj).getXMLNodeChildren());
			return !pros.isEmpty() || !c.isEmpty();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java
	 *      .lang.Object)
	 */
	public Object[] getElements(Object arg0) {
		if(arg0 instanceof TagList){
			return ((TagList)arg0).getRootTagList().toArray();
		}
		if(arg0 instanceof IXMLStructuredObject){
			return ((IXMLStructuredObject)arg0).getChildren().toArray();
		}
		return new Object[] {};
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface
	 *      .viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {

	}


}
