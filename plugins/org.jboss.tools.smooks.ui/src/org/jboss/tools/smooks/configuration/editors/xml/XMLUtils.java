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

import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

/**
 * @author Dart
 * 
 */
public class XMLUtils {

	public static DocumentBuilder getDOMBuilder() throws ParserConfigurationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		dbf.setValidating(false);
		DocumentBuilder builder = dbf.newDocumentBuilder();
		return builder;
	}

	public static Transformer getTransformer() throws TransformerConfigurationException {
		TransformerFactory tf = TransformerFactory.newInstance();
		return tf.newTransformer();
	}

	public static Document createDocument() throws ParserConfigurationException {
		return XMLUtils.getDOMBuilder().newDocument();
	}

	public static Element firstChildElement(Node node) {
		for (Node tempNode = node.getFirstChild(); tempNode != null; tempNode = tempNode.getNextSibling()) {
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
				return (Element) tempNode;
			}
		}
		return null;
	}

	public static Element nextSiblingElement(Node node) {
		for (Node tempNode = node.getNextSibling(); tempNode != null; tempNode = tempNode.getNextSibling()) {
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
				return (Element) tempNode;
			}
		}
		return null;
	}

	public static Element lastChildElement(Node node) {
		for (Node tempNode = node.getLastChild(); tempNode != null; tempNode = tempNode.getPreviousSibling()) {
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
				return (Element) tempNode;
			}
		}
		return null;
	}

	public static Element previousSiblingElement(Node node) {
		for (Node tempNode = node.getPreviousSibling(); tempNode != null; tempNode = tempNode.getPreviousSibling()) {
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
				return (Element) tempNode;
			}
		}
		return null;
	}

	public static List<Element> getAllChildElements(Node node) {
		List<Element> v = new ArrayList<Element>();
		Node child = XMLUtils.firstChildElement(node);
		while (child != null) {
			v.add((Element) child);
			child = XMLUtils.nextSiblingElement(child);
		}
		return v;
	}

	public static List<Element> getChildElementsByNS(Node node, String uri, String localName) {
		List<Element> childElements = XMLUtils.getAllChildElements(node);
		List<Element> v = new ArrayList<Element>();
		for (int i = 0; i < childElements.size(); i++) {
			Element child = (Element) childElements.get(i);
			String ln = child.getLocalName();
			String u = child.getNamespaceURI();
			if (uri == null) {
				if (ln.equals(localName)) {
					v.add(child);
				}
			} else {
				if (ln.equals(localName) && u.equals(uri)) {
					v.add(child);
				}
			}
		}
		return v;
	}

	public static String getLocalName(String nodeName) {
		int index = nodeName.lastIndexOf(58);
		if (index == -1) {
			return nodeName;
		} else {
			return nodeName.substring(index + 1, nodeName.length());
		}
	}

	public static String getPrefix(String nodeName) {
		int index = nodeName.lastIndexOf(58);
		if (index == -1) {
			return null;
		} else {
			return nodeName.substring(0, index);
		}
	}

	public static void outDOMNode(Node node, Writer writer) throws TransformerConfigurationException,
			TransformerException {
		Transformer transformer = XMLUtils.getTransformer();
		Source source = new DOMSource(node);
		Result result = new StreamResult(writer);
		transformer.transform(source, result);
	}

	public static void outDOMNode(Node node, OutputStream os) throws TransformerConfigurationException,
			TransformerException {

		Document document = null;
		if (node instanceof Document) {
			document = (Document) node;
		} else {
			document = node.getOwnerDocument();
		}
		Object ls = null;
		if (document != null) {
			ls = document.getImplementation().getFeature("LS", "3.0"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		if (ls != null && ls instanceof DOMImplementationLS) {
			LSSerializer lss = ((DOMImplementationLS) ls).createLSSerializer();
			DOMConfiguration domConfiguration = lss.getDomConfig();
			if (domConfiguration.canSetParameter("format-pretty-print", Boolean.TRUE)) { //$NON-NLS-1$
				lss.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE); //$NON-NLS-1$
			}
			LSOutput lsoutput = ((DOMImplementationLS) ls).createLSOutput();
			lsoutput.setByteStream(os);
			lss.write(node, lsoutput);
		} else {
			Transformer transformer = XMLUtils.getTransformer();
			Source source = new DOMSource(node);
			Result result = new StreamResult(os);
			transformer.transform(source, result);
		}

	}
}