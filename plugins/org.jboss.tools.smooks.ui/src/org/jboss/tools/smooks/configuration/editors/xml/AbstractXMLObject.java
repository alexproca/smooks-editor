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

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject;
import org.w3c.dom.Element;

/**
 * @author Dart Peng
 * @Date Jul 25, 2008
 */
public class AbstractXMLObject implements IXMLStructuredObject {

	protected PropertyChangeSupport support = new PropertyChangeSupport(this);

	protected Element referenceElement = null;

	protected boolean canEdit = false;

	private String namespaceURI = null;

	private String namespacePrefix = null;

	public boolean isCanEdit() {
		return canEdit;
	}

	public boolean isAttribute() {
		return false;
	}

	public void setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
	}

	protected AbstractXMLObject parent;

	protected String name;

	public String getNamespaceURI() {
		Element element = this.getReferenceElement();
		if (element != null) {
			return element.getNamespaceURI();
		}
		return namespaceURI;
	}

	public void setNamespaceURI(String namespaceURL) {
		Element element = this.getReferenceElement();
		if (element != null) {
			// Namespace ns = element.getNamespace();
			// Namespace nns = new Namespace(ns.getPrefix(), namespaceURL);
			// element.setQName(new QName(name, nns));
		}
		this.namespaceURI = namespaceURL;
	}

	/**
	 * @return the nameSpacePrefix
	 */
	public String getNameSpacePrefix() {
		Element element = this.getReferenceElement();
		if (element != null) {
			return element.getPrefix();
		}
		return namespacePrefix;
	}

	/**
	 * @param nameSpacePrefix
	 *            the nameSpacePrefix to set
	 */
	public void setNameSpacePrefix(String nameSpacePrefix) {
		Element element = this.getReferenceElement();
		if (element != null) {
			// Namespace ns = element.getNamespace();
			// Namespace nns = new Namespace(nameSpacePrefix, ns.getURI());
			// element.setQName(new QName(name, nns));
		}
		this.namespacePrefix = nameSpacePrefix;
	}

	protected List<AbstractXMLObject> children = new ArrayList<AbstractXMLObject>();

	public String getName() {
		return name;
	}

	public PropertyChangeListener[] getPropertyChangeListeners() {
		return support.getPropertyChangeListeners();
	}

	public void setName(String name) {
		this.name = name;
		Element element = this.getReferenceElement();
		if (element != null) {
			// element.setQName(new QName(name, element.getNamespace()));
		}
	}

	// public void setQName(QName name) {
	// this.name = name.getName();
	// Element element = this.getReferenceElement();
	// if (element != null) {
	// element.setQName(name);
	// }
	// }

	public List<AbstractXMLObject> getXMLNodeChildren() {
		return children;
	}

	public void setChildren(List<AbstractXMLObject> children) {
		this.children = children;
	}

	public Element getReferenceElement() {
		return referenceElement;
	}

	public void setReferenceElement(Element referenceElement) {
		this.referenceElement = referenceElement;
	}

	/**
	 * @return the parent
	 */
	public AbstractXMLObject getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(AbstractXMLObject parent) {
		this.parent = parent;
	}

	public void addNodePropetyChangeListener(PropertyChangeListener listener) {
		support.addPropertyChangeListener(listener);
	}

	public void removeNodePropetyChangeListener(PropertyChangeListener listener) {
		support.removePropertyChangeListener(listener);
	}

	public void cleanAllNodePropertyChangeListeners() {
		PropertyChangeListener[] ps = support.getPropertyChangeListeners();
		for (int i = 0; i < ps.length; i++) {
			PropertyChangeListener p = ps[i];
			support.removePropertyChangeListener(p);
		}
	}

	public List<IXMLStructuredObject> getChildren() {
		List children = getXMLNodeChildren();
		return children;
	}

	public Object getID() {
		return getName();
	}

	public String getNodeName() {
		return getName();
	}

	public boolean isRootNode() {
		return false;
	}

}
