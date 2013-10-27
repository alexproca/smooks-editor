/*
 * JBoss, Home of Professional Open Source
 * Copyright 2006, JBoss Inc., and others contributors as indicated
 * by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 *
 * (C) 2005-2006, JBoss Inc.
 */
package org.jboss.tools.smooks.templating.model;

import java.util.HashMap;
import java.util.Map;

import org.milyn.xml.DomUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Model Node resolver.
 * <p/>
 * Handles hiding of elements from the reserved namespace.
 * 
 * @author <a href="mailto:tom.fennelly@jboss.com">tom.fennelly@jboss.com</a>
 */
public class ModelNodeResolver {

	private Map<String, Node> modelNodeMap = new HashMap<String, Node>();
	private Map<String, String> prefixMap = new HashMap<String, String>();

	public ModelNodeResolver(Document model) {
		buildModelNodeMap(model.getDocumentElement(), ""); //$NON-NLS-1$
	}
	
	public Node resolveNodeMapping(Node node) {
		return modelNodeMap.get(buildNodePath(node));
	}

	private Object buildNodePath(Node node) {
		StringBuilder pathBuilder = new StringBuilder();
		
		while(node != null && node.getNodeType() != Node.DOCUMENT_NODE) {
			if(!ModelBuilder.isInReservedNamespace(node)) {
				if(pathBuilder.length() > 0) {
					pathBuilder.insert(0, '/'); //$NON-NLS-1$
				}
	
				String nodeNS = node.getNamespaceURI();
				if(nodeNS != null && nodeNS.length() > 0) {
					if(node.getNodeType() == Node.ATTRIBUTE_NODE) {
						pathBuilder.insert(0, "@" + getPrefix(nodeNS) + ":" + ((Attr)node).getName()); //$NON-NLS-1$ //$NON-NLS-2$
					} else {
						pathBuilder.insert(0, getPrefix(nodeNS) + ":" + DomUtils.getName((Element) node)); //$NON-NLS-1$
					}				
				} else {
					if(node.getNodeType() == Node.ATTRIBUTE_NODE) {
						pathBuilder.insert(0, "@" + ((Attr)node).getName()); //$NON-NLS-1$
					} else {
						pathBuilder.insert(0, DomUtils.getName((Element) node));
					}				
					
				}
			}
			
			node = ModelBuilder.getParentNode(node);
		}
		
		return pathBuilder.toString();
	}

	private void buildModelNodeMap(Element element, String parentPath) {
		String elementPath = parentPath;
		
		if(!ModelBuilder.isInReservedNamespace(element)) {
			String elNS = element.getNamespaceURI();
			
			if(parentPath.length() > 0) {
				parentPath += "/"; //$NON-NLS-1$
			}
			
			if(elNS != null && elNS.length() > 0) {
				elementPath = parentPath + getPrefix(elNS) + ":" + DomUtils.getName(element); //$NON-NLS-1$
				modelNodeMap.put(elementPath, element);
			} else {
				elementPath = parentPath + DomUtils.getName(element);
				modelNodeMap.put(elementPath, element);
			}
			
			NamedNodeMap attributes = element.getAttributes();
			int attrCount = attributes.getLength();
			for(int i = 0; i < attrCount; i++) {
				Attr attribute = (Attr) attributes.item(i);
				if(!ModelBuilder.isInReservedNamespace(attribute)) {
					String attrNS = attribute.getNamespaceURI();
					if(attrNS != null && attrNS.length() > 0) {
						modelNodeMap.put(elementPath + "/@" + getPrefix(attrNS) + ":" + attribute.getName(), attribute); //$NON-NLS-1$ //$NON-NLS-2$					
					} else {
						modelNodeMap.put(elementPath + "/@" + attribute.getName(), attribute); //$NON-NLS-1$				
					}
				}
			}
		}
		
		NodeList children = element.getChildNodes();
		int childCount = children.getLength();
		for(int i = 0; i < childCount; i++) {
			Node child = children.item(i);
			if(child.getNodeType() == Node.ELEMENT_NODE) {
				buildModelNodeMap((Element) child, elementPath);
			}
		}
	}
	
	private String getPrefix(String nsURI) {
		String prefix = prefixMap.get(nsURI);
		if(prefix == null) {
			prefix = "ns" + prefixMap.size(); //$NON-NLS-1$
			prefixMap.put(nsURI, prefix);
		}
		return prefix;
	}
}
