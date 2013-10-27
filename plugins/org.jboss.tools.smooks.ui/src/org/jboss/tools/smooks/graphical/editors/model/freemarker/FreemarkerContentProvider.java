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
package org.jboss.tools.smooks.graphical.editors.model.freemarker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.configuration.editors.xml.XMLStructuredDataContentProvider;
import org.jboss.tools.smooks.model.freemarker.Freemarker;
import org.jboss.tools.smooks.model.freemarker.Template;
import org.jboss.tools.smooks.model.smooks.ParamType;
import org.jboss.tools.smooks.model.smooks.SmooksFactory;

/**
 * @author Dart
 *
 */
public class FreemarkerContentProvider implements ITreeContentProvider {

	private ITreeContentProvider parentProvider = null;

	private ITreeContentProvider xmlObjectContentProvider = new XMLStructuredDataContentProvider();

	private Map<Object, Object> buffer = new HashMap<Object, Object>();

	public FreemarkerContentProvider(ITreeContentProvider parentProvider) {
		this.parentProvider = parentProvider;
	}
	
	public void cleanBuffer(){
		if(buffer != null){
			buffer.clear();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.
	 * Object)
	 */
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof Freemarker) {
			Template template = ((Freemarker) parentElement).getTemplate();
			if (template != null) {
				Object obj = buffer.get(template);
				String comments = SmooksModelUtils.getAnyTypeComment(template);
				
				List<ParamType> params = SmooksModelUtils.getParams(template);
				
				ParamType param = SmooksFactory.eINSTANCE.createParamType();
				param.setName("name"); //$NON-NLS-1$
				param.setStringValue("value"); //$NON-NLS-1$
				
			}
			return new Object[] {};
		}
		return xmlObjectContentProvider.getChildren(parentElement);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object
	 * )
	 */
	public Object getParent(Object element) {
		return xmlObjectContentProvider.getParent(element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.
	 * Object)
	 */
	public boolean hasChildren(Object element) {
		if (element instanceof Freemarker) {
			return true;
		}
//		if(element instanceof AbstractXMLObject && XSLModelAnalyzer.isXSLTagObject((AbstractXMLObject)element)){
//			return !((AbstractXMLObject)element).getXMLNodeChildren().isEmpty();
//		}
		return xmlObjectContentProvider.hasChildren(element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java
	 * .lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		return parentProvider.getElements(inputElement);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
		parentProvider.dispose();
		xmlObjectContentProvider.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface
	 * .viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		parentProvider.inputChanged(viewer, oldInput, newInput);
	}

}
