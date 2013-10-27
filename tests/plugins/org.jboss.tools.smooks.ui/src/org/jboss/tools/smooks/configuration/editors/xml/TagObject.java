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
import java.util.Iterator;
import java.util.List;

import org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;

/**
 * @author Dart Peng
 * @Date Jul 25, 2008
 */
public class TagObject extends AbstractXMLObject {
	protected List<TagPropertyObject> properties = new ArrayList<TagPropertyObject>();

	public List<TagPropertyObject> getProperties() {
		return properties;
	}

	public void setProperties(List<TagPropertyObject> properties) {
		this.properties = properties;
	}

	public void addProperty(TagPropertyObject pro) {
		this.getProperties().add(pro);
		if (pro != null)
			pro.setParent(this);
		Attr attribute = pro.getReferenceAttibute();
		Element parentElement = getReferenceElement();
		if (attribute != null && parentElement != null) {
			if (attribute.getParentNode() == parentElement) {
				return;
			}
			parentElement.setAttributeNode(attribute);
		}
	}

	public void removeProperty(TagPropertyObject pro) {
		this.getProperties().remove(pro);
		if (pro != null)
			pro.setParent(null);

		Attr attribute = pro.getReferenceAttibute();
		Element parentElement = getReferenceElement();
		if (attribute != null && parentElement != null) {
			parentElement.removeAttributeNode(attribute);
		}
	}

	public void addChildTag(TagObject tag) {
		this.getXMLNodeChildren().add(tag);
		if (tag != null)
			tag.setParent(this);
		Element childElement = tag.getReferenceElement();
		Element parentElement = getReferenceElement();
		if (childElement != null && parentElement != null) {
			if (childElement.getParentNode() == parentElement) {
				return;
			}
			parentElement.appendChild(childElement);
		}
	}

	public void removeChildTag(TagObject tag) {
		this.getXMLNodeChildren().remove(tag);
		if (tag != null)
			tag.setParent(null);

		Element childElement = tag.getReferenceElement();
		Element parentElement = getReferenceElement();
		if (childElement != null && parentElement != null) {
			parentElement.removeChild(childElement);
		}

	}

	@Override
	public List<IXMLStructuredObject> getChildren() {
		List<IXMLStructuredObject> all = new ArrayList<IXMLStructuredObject>();
		List<AbstractXMLObject> tags = this.getXMLNodeChildren();
		List<TagPropertyObject> properties = this.getProperties();
		all.addAll(properties);
		all.addAll(tags);
		return all;
	}

	public String toString() {
		String blankString = ""; //$NON-NLS-1$
		int deep = -1;
		AbstractXMLObject parent = this;
		while (parent != null && !(parent instanceof TagList)) {
			deep++;
			parent = parent.getParent();
		}

		for (int i = 0; i < deep; i++) {
			blankString = blankString + "\t"; //$NON-NLS-1$
		}

		StringBuffer propertyesBuffer = new StringBuffer();
		for (Iterator<?> iterator = properties.iterator(); iterator.hasNext();) {
			TagPropertyObject pro = (TagPropertyObject) iterator.next();
			propertyesBuffer.append(" " + pro.getName() + "=\"\""); //$NON-NLS-1$ //$NON-NLS-2$
		}
		StringBuffer buffer = null;
		if (propertyesBuffer.length() == 0) {
			buffer = new StringBuffer(blankString + "<" + getName() + ">"); //$NON-NLS-1$ //$NON-NLS-2$
		} else {
			buffer = new StringBuffer(blankString + "<" + getName() + propertyesBuffer.toString() + ">"); //$NON-NLS-1$ //$NON-NLS-2$
		}

		List<?> l = getXMLNodeChildren();
		if (!l.isEmpty()) {
			buffer.append("\n"); //$NON-NLS-1$
		}
		for (Iterator<?> iterator = l.iterator(); iterator.hasNext();) {
			TagObject tag = (TagObject) iterator.next();
			buffer.append(tag.toString());
			if (iterator.hasNext())
				buffer.append("\n"); //$NON-NLS-1$
		}

		if (l.isEmpty()) {
			buffer.append("</" + getName() + ">"); //$NON-NLS-1$ //$NON-NLS-2$
		} else {
			buffer.append("\n" + blankString + "</" + getName() + ">"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}

		return buffer.toString();
	}

}
