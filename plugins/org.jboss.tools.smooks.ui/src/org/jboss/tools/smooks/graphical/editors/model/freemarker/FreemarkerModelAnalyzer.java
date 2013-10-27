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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.jboss.tools.smooks.configuration.editors.xml.AbstractXMLObject;
import org.jboss.tools.smooks.configuration.editors.xml.TagList;
import org.jboss.tools.smooks.configuration.editors.xml.TagObject;
import org.jboss.tools.smooks.configuration.editors.xml.TagPropertyObject;
import org.jboss.tools.smooks.configuration.editors.xml.XMLUtils;
import org.jboss.tools.smooks.templating.model.ModelBuilder;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author Dart
 * 
 */
public class FreemarkerModelAnalyzer {

	public TagList analyze(String xmlFilePath, String[] ignoreNodeNames,
			Class<? extends AbstractXMLObject> tagObjectClass) throws ParserConfigurationException, SAXException,
			IOException {
		FileInputStream stream = new FileInputStream(xmlFilePath);
		TagList list = this.analyze(stream, ignoreNodeNames, tagObjectClass);
		try {
			stream.close();
		} catch (IOException e) {
		}
		return list;
	}

	public TagList analyze(Document doc, String[] ignoreNodeNames, Class<? extends AbstractXMLObject> tagObjectClass) {
		if (doc == null)
			return null;
		Element rootElement = doc.getDocumentElement();
		TagList dco = new TagList();
		dco.setName("Docuement"); //$NON-NLS-1$
		dco.addRootTag(parseElement(rootElement, null, ignoreNodeNames, tagObjectClass));
		return dco;
	}

	public TagList analyze(InputStream stream, String[] ignoreNodeNames,
			Class<? extends AbstractXMLObject> tagObjectClass) throws ParserConfigurationException, SAXException,
			IOException {
		DocumentBuilder builder = createDocumentBuildingFactory();
		Document doc = builder.parse(stream);
		return analyze(doc, ignoreNodeNames, tagObjectClass);
	}

	public DocumentBuilder createDocumentBuildingFactory() throws ParserConfigurationException {
		return XMLUtils.getDOMBuilder();
	}

	public TagObject analyzeFregment(InputStream stream, String[] ignoreNodeNames,
			Class<? extends AbstractXMLObject> tagObjectClass) throws ParserConfigurationException, SAXException,
			IOException {
		DocumentBuilder builder = createDocumentBuildingFactory();
		org.w3c.dom.Document doc = builder.parse(stream);
		Element rootElement = doc.getDocumentElement();
		return parseElement(rootElement, null, ignoreNodeNames, tagObjectClass);
	}

	protected TagObject getChildTagByName(String name, TagObject tag, String[] ignoreNodeNames) {
		if (isIgnoreNode(name, ignoreNodeNames))
			return null;
		if (tag == null)
			return null;
		List<?> list = tag.getXMLNodeChildren();
		for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
			TagObject tagc = (TagObject) iterator.next();
			if (tagc.getName().equals(name))
				return tagc;
		}
		return null;
	}

	private boolean isIgnoreNode(Element element, String[] ignoreNodeNames) {
		return isIgnoreNode(element.getNodeName(), ignoreNodeNames);
	}

	// private boolean isIgnoreNode(TagObject element , String[]
	// ignoreNodeNames){
	// return isIgnoreNode(element.getName(), ignoreNodeNames);
	// }

	private boolean isIgnoreNode(String name, String[] ignoreNodeNames) {
		if (ignoreNodeNames == null)
			return false;
		for (int i = 0; i < ignoreNodeNames.length; i++) {
			String ignore = ignoreNodeNames[i];
			if (ignore.trim().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}

	public static boolean isChoiceElement(Element element) {
		if (element != null) {
			Node parentNode = element.getParentNode();
			if (parentNode instanceof Element) {
				if (ModelBuilder.isCompositor(parentNode)) {
					return true;
				}
			}
		}
		return false;
	}

	protected TagObject parseElement(Element element, TagObject parentTag, String[] ignoreNodeNames,
			Class<? extends AbstractXMLObject> tagObjectClass) {
		if (isIgnoreNode(element, ignoreNodeNames))
			return null;
		boolean canAdd = false;
		TagObject tag = null;
		if (ModelBuilder.isCompositor(element)) {
			tag = parentTag;
		} else {
			tag = getChildTagByName(element.getNodeName(), parentTag, ignoreNodeNames);
			if (tag == null) {
				if (tagObjectClass != null) {
					try {
						tag = (TagObject) tagObjectClass.newInstance();
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				} else {
					tag = new TagObject();
				}
				canAdd = true;
			}
			if (tag == null)
				return null;

			tag.setReferenceElement(element);
			String localName = element.getLocalName();
			String nodeName = element.getNodeName();
			if (localName == null) {
				localName = nodeName;
			}
			tag.setName(localName);
			fillProperties(element, tag, ignoreNodeNames);
			tag.setNamespaceURI(element.getNamespaceURI());
		}
		NodeList nodeList = element.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node instanceof Element) {
				Element childElement = (Element) node;
				TagObject t = parseElement(childElement, tag, ignoreNodeNames, tagObjectClass);
				if (t != null) {
					tag.addChildTag(t);
					// t.setReferenceElement(childElement);
				}
			}
		}
		if (canAdd)
			return tag;
		else
			return null;
	}

	protected boolean hasSameNameProperty(String proName, TagObject tag) {
		List<TagPropertyObject> pros = tag.getProperties();
		for (Iterator<TagPropertyObject> iterator = pros.iterator(); iterator.hasNext();) {
			TagPropertyObject tp = (TagPropertyObject) iterator.next();
			if (tp.getName().equals(proName))
				return true;
		}
		return false;
	}

	protected void fillProperties(Element element, TagObject tag, String[] ignoreNodeNames) {
		NamedNodeMap attrMap = element.getAttributes();

		for (int i = 0; i < attrMap.getLength(); i++) {
			Node node = attrMap.item(i);
			if (node instanceof Attr) {
				Attr attr = (Attr) node;

				String localName = attr.getLocalName();
				String name = attr.getNodeName();
				if (localName == null) {
					localName = name;
				}
				
				if(ModelBuilder.isInReservedNamespace(attr)) {
					continue;
				}
				
				String value = attr.getValue();

				if (isIgnoreNode(localName, ignoreNodeNames))
					continue;
				if (hasSameNameProperty(localName, tag)) {
					continue;
				}
				TagPropertyObject pro = new FreemarkerAttrModel();
				tag.addProperty(pro);
				
				pro.setName(localName);
				pro.setValue(value);
				pro.setNamespaceURI(attr.getNamespaceURI());
				pro.setReferenceAttibute(attr);
				
			}
		}
	}
}
