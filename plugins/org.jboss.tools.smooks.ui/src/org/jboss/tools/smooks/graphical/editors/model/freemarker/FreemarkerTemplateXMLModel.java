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

import java.util.Iterator;
import java.util.List;

import org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject;
import org.jboss.tools.smooks.configuration.editors.xml.AbstractXMLObject;
import org.jboss.tools.smooks.configuration.editors.xml.TagObject;
import org.jboss.tools.smooks.configuration.editors.xml.TagPropertyObject;
import org.jboss.tools.smooks.templating.model.ModelBuilder;
import org.jboss.tools.smooks.templating.template.Mapping;
import org.jboss.tools.smooks.templating.template.TemplateBuilder;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author Dart
 * 
 */
public class FreemarkerTemplateXMLModel extends TagObject implements IFreemarkerTemplateModel {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.configuration.editors.xml.TagObject#addChildTag
	 * (org.jboss.tools.smooks.configuration.editors.xml.TagObject)
	 */
	@Override
	public void addChildTag(TagObject tag) {
		if (FreemarkerModelAnalyzer.isChoiceElement(tag.getReferenceElement())) {
			this.getXMLNodeChildren().add(tag);
			if (tag != null)
				tag.setParent(this);
			return;
		}
		super.addChildTag(tag);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.configuration.editors.xml.TagObject#removeChildTag
	 * (org.jboss.tools.smooks.configuration.editors.xml.TagObject)
	 */
	@Override
	public void removeChildTag(TagObject tag) {
		// TODO Auto-generated method stub
		super.removeChildTag(tag);
	}

	public boolean isRequired() {
		Element element = this.getReferenceElement();
		if (!this.getXMLNodeChildren().isEmpty()) {
			return false;
		}
		if (element != null) {
			return ModelBuilder.isRequired(element);
		}
		return false;
	}

	public boolean isManyOccurs() {
		Element refElement = this.getReferenceElement();
		if (refElement != null) {
			return ModelBuilder.isCollection(refElement);
		}
		return false;
	}

	public boolean isHidden(TemplateBuilder builder) {
		AbstractXMLObject parent = this.getParent();
		if (parent instanceof FreemarkerTemplateXMLModel) {
			if (((FreemarkerTemplateXMLModel) parent).isHidden(builder)) {
				return true;
			}
		}
		List<Mapping> mappings = builder.getMappings();
		for (Iterator<?> iterator = mappings.iterator(); iterator.hasNext();) {
			Mapping mapping = (Mapping) iterator.next();
			List<Node> hiddenNodes = mapping.getHideNodes();
			if (hiddenNodes != null) {
				for (Iterator<?> iterator2 = hiddenNodes.iterator(); iterator2.hasNext();) {
					Node node = (Node) iterator2.next();
					if (node == this.getReferenceElement()) {
						return true;
					}
				}
			}
		}
		return false;
		// Element refElement = this.getReferenceElement();
		// if (refElement != null) {
		// NamedNodeMap nodeMap = refElement.getAttributes();
		// for (int i = 0; i < nodeMap.getLength(); i++) {
		// Attr attr = (Attr) nodeMap.item(i);
		// if (attr != null) {
		// if
		// (FreemarkerModelAnalyzer.SPECIAL_ELEMENT_UIR.equals(attr.getNamespaceURI()))
		// {
		// String name = attr.getLocalName();
		// if (name == null) {
		// name = attr.getNodeName();
		// }
		// if (FreemarkerModelAnalyzer.HIDDEN.equals(name)) {
		// String value = attr.getValue();
		// try {
		// boolean booleanValue = Boolean.parseBoolean(value);
		// return booleanValue;
		// } catch (Exception e) {
		// return false;
		// }
		// }
		// }
		// }
		// }
		//
		// if (graphRoot != null &&
		// FreemarkerModelAnalyzer.isChoiceElement(refElement)) {
		// Node parent = refElement.getParentNode();
		// NodeList nodeList = parent.getChildNodes();
		// for (int i = 0; i < nodeList.getLength(); i++) {
		// Node child = nodeList.item(i);
		// if (child == refElement)
		// continue;
		// FreemarkerTemplateXMLModel model = localBrotherModel(child);
		// if (model != null) {
		// AbstractSmooksGraphicalModel cgm =
		// SmooksGraphUtil.findSmooksGraphModel(graphRoot, model);
		// if (!cgm.getTargetConnections().isEmpty()) {
		// return true;
		// }
		// }
		// }
		// }
		// }
		// return false;
	}
	
	public Node getModelNode() {
		return getReferenceElement();
	}

	private FreemarkerTemplateXMLModel localBrotherModel(Node refNode) {
		AbstractXMLObject parent = this.getParent();
		List<IXMLStructuredObject> children = parent.getChildren();
		for (Iterator<?> iterator = children.iterator(); iterator.hasNext();) {
			IXMLStructuredObject ixmlStructuredObject = (IXMLStructuredObject) iterator.next();
			if (ixmlStructuredObject instanceof TagObject) {
				if (((TagObject) ixmlStructuredObject).getReferenceElement() == refNode) {
					return (FreemarkerTemplateXMLModel) ixmlStructuredObject;
				}
			}
			if (ixmlStructuredObject instanceof TagPropertyObject) {
				if (((TagPropertyObject) ixmlStructuredObject).getReferenceAttibute() == refNode) {
					return (FreemarkerTemplateXMLModel) ixmlStructuredObject;
				}
			}
		}
		return null;
	}

}
