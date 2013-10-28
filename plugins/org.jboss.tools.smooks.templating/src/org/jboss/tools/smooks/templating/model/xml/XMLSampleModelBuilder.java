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
package org.jboss.tools.smooks.templating.model.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.URI;
import org.jboss.tools.smooks.templating.model.ModelBuilder;
import org.jboss.tools.smooks.templating.model.ModelBuilderException;
import org.jboss.tools.smooks.templating.template.xml.XMLFreeMarkerTemplateBuilder;
import org.milyn.xml.DomUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * XML Model Builder from an XML Sample.
 * <p/>
 * The generated model can then be used by the {@link XMLFreeMarkerTemplateBuilder}.
 *
 * @author <a href="mailto:tom.fennelly@jboss.com">tom.fennelly@jboss.com</a>
 */
public class XMLSampleModelBuilder extends ModelBuilder {
		
	private static DocumentBuilder docBuilder;
	private Document model;

	static {
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		docBuilderFactory.setNamespaceAware(true);
		try {
			docBuilder = docBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(Messages.XMLSampleModelBuilder_UnexpectedXMLException, e);
		}
	}

    public XMLSampleModelBuilder(URI xmlSampleURI) throws IOException, ModelBuilderException {
    	Assert.isNotNull(xmlSampleURI, "Null 'xmlSampleURI' arg in method call."); //$NON-NLS-1$
    	
    	File xmlSampleFile =  new File(xmlSampleURI.toFileString());
    	
    	if(!xmlSampleFile.exists()) {
    		throw new IOException("XML Sample '" + xmlSampleFile.getAbsolutePath() + "' not found."); //$NON-NLS-1$ //$NON-NLS-2$    		
    	} else if(!xmlSampleFile.isFile()) {
    		throw new IOException("XML Sample '" + xmlSampleFile.getAbsolutePath() + "' is not a normal file.  Might be a directory etc."); //$NON-NLS-1$ //$NON-NLS-2$    		
    	}
    	
    	try {
			model = docBuilder.parse(xmlSampleFile);
		} catch (SAXException e) {
			throw new ModelBuilderException("Error parsing XML Sample file.", e); //$NON-NLS-1$ 
		}
		
		Element documentElement = model.getDocumentElement();
		
        // The model has no metadata attached since it is based on only a sample, 
		// so mark it as not being a strict model...
        ModelBuilder.setStrictModel(model, false);
		
		trimNonModelNodes(documentElement);
		configureModelElementTypes(documentElement);
		configureModelElementCardinality(documentElement);
		registerNamepsaces(documentElement);
    }

	public static void trimNonModelNodes(Element element) {
		NodeList children = element.getChildNodes();
		List<Node> removeableChildren = new ArrayList<Node>();
		Set<QName> childElementSet = new HashSet<QName>();

		for(int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
		
			if(child.getNodeType() == Node.ELEMENT_NODE) {
				Element childElement = (Element) child;
				QName childElementQName;

				if(childElement.getPrefix() != null) {
					childElementQName = new QName(childElement.getNamespaceURI(), childElement.getLocalName(), childElement.getPrefix());
				} else {
					childElementQName = new QName(childElement.getNamespaceURI(), childElement.getTagName());
				}
				
				if(!childElementSet.contains(childElementQName)) {
					childElementSet.add(childElementQName);
					trimNonModelNodes((Element) child);				
				} else {
					removeableChildren.add(child);
				}
			} else {
				removeableChildren.add(child);
			}
		}
		
		for(Node child : removeableChildren) {
			element.removeChild(child);
		}
	}

	private void configureModelElementTypes(Element element) {
		NodeList children = element.getChildNodes();
		int childCount = children.getLength();

		if(childCount > 0) {
			// Has child elements, therefore it's a "complex" element type...
			ModelBuilder.setElementType(element, ElementType.complex);
			
			for(int i = 0; i < childCount; i++) {
				Node child = children.item(i);			
	
				if(child.getNodeType() == Node.ELEMENT_NODE) {
					configureModelElementTypes((Element) child);
				} else {
					throw new IllegalStateException("The configureModelElementTypes method can only be called after the model has been trimed of non-model Nodes.  Call trimNonModelNodes() before calling configureModelElementTypes()."); //$NON-NLS-1$
				}
			}
		} else {
			// Has no child elements, therefore it's a "simple" element type...
			ModelBuilder.setElementType(element, ElementType.simple);
		}
	}

	private void configureModelElementCardinality(Element element) {
		NodeList children = element.getChildNodes();
		List<Node> removeableChildren = new ArrayList<Node>();
		int childCount = children.getLength();

		Map<String, Element> childElementByNames = new HashMap<String, Element>();
		for(int i = 0; i < childCount; i++) {
			Node child = children.item(i);			

			if(child.getNodeType() == Node.ELEMENT_NODE) {
				Element childElement = (Element) child;
				String elementName = DomUtils.getName(childElement) + ":" + childElement.getNamespaceURI(); // Yes, namespace can be null, but that's OK. //$NON-NLS-1$
				Element earlierOccurance = childElementByNames.get(elementName);

				// Mark every element as being optional and possibly being multiple...
				ModelBuilder.setMinMax(childElement, 0, -1);
				
				if(earlierOccurance != null) {
					// According to the sample XML, this element is definitely a 
					// collection item because it exists more than once, so lets mark it 
					// such that sub mappings on this element require this collection to be mapped beforehand...
					ModelBuilder.setEnforceCollectionSubMappingRules(earlierOccurance, true);
					// And remove the duplicates...
					removeableChildren.add(childElement);
				} else {
					// We've no way of knowing whether or not this element is a collection
					// item or not, so lets not enforce the collection sub mapping rules...
					ModelBuilder.setEnforceCollectionSubMappingRules(childElement, false);
				}
				
				configureModelElementCardinality(childElement);
			} else {
				throw new IllegalStateException("The configureModelElementTypes method can only be called after the model has been trimed of non-model Nodes.  Call trimNonModelNodes() before calling configureModelElementTypes()."); //$NON-NLS-1$
			}
		}
		
		for(Node child : removeableChildren) {
			element.removeChild(child);
		}
	}

	private void registerNamepsaces(Element element) {
		NamedNodeMap attributes = element.getAttributes();
		
		for(int i = 0; i < attributes.getLength(); i++) {
			registerNamespace(attributes.item(i));
		}
		
		NodeList children = element.getChildNodes();
		for(int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);			
			if(child.getNodeType() == Node.ELEMENT_NODE) {
				registerNamespace(child);
				registerNamepsaces((Element) child);
			}
		}
	}

	private void registerNamespace(Node node) {
		String nsPrefix = node.getPrefix();
		String nsURI = node.getNamespaceURI();
		
		if(nsPrefix != null && nsURI != null) {
			getNamespaces().setProperty(nsPrefix, nsURI);
		}
	}

	public Document buildModel() throws ModelBuilderException {
        return model;
    }
}