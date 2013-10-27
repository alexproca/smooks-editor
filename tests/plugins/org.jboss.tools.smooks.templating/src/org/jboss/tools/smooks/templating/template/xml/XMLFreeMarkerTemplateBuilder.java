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
package org.jboss.tools.smooks.templating.template.xml;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Enumeration;

import javax.xml.XMLConstants;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.jboss.tools.smooks.templating.model.ModelBuilder;
import org.jboss.tools.smooks.templating.model.ModelBuilderException;
import org.jboss.tools.smooks.templating.model.ModelNodeResolver;
import org.jboss.tools.smooks.templating.model.ModelBuilder.ElementType;
import org.jboss.tools.smooks.templating.model.xml.XSDModelBuilder;
import org.jboss.tools.smooks.templating.template.*;
import org.jboss.tools.smooks.templating.template.exception.TemplateBuilderException;
import org.jboss.tools.smooks.templating.template.freemarker.FreeMarkerTemplateBuilder;
import org.jboss.tools.smooks.templating.template.util.FreeMarkerUtil;
import org.milyn.xml.DomUtils;
import org.milyn.xml.XmlUtil;

import freemarker.core.TemplateElement;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * Freemarker Template Builder for an XML messages.
 * 
 * @author <a href="mailto:tom.fennelly@jboss.com">tom.fennelly@jboss.com</a>
 */
public class XMLFreeMarkerTemplateBuilder extends FreeMarkerTemplateBuilder {
	
	private boolean omitXMLDeclaration = false;

	/**
	 * Public constructor.
	 * <p/>
	 * This constructor is used when an existing template doesn't exist i.e. for creating new
	 * templates with a new set of mappings.  When creating an {@link XMLFreeMarkerTemplateBuilder} instance to incorporate
	 * mappings from an existing template, use the {@link #XMLFreeMarkerTemplateBuilder(ModelBuilder, String)}
	 * constructor.
	 * 
	 * @param modelBuilder The {@link ModelBuilder} instance that describes the XML model (e.g. {@link XSDModelBuilder}).
	 * @throws ModelBuilderException Invalid {@link ModelBuilder} instance. 
	 */
    public XMLFreeMarkerTemplateBuilder(ModelBuilder modelBuilder) throws ModelBuilderException {
        super(modelBuilder);
    }

	/**
	 * Public constructor.
	 * <p/>
	 * Used to construct an {@link XMLFreeMarkerTemplateBuilder} instance to incorporate mappings from an
	 * existing FreeMarker template.
	 * 
	 * @param modelBuilder The {@link ModelBuilder} instance that describes the XML model (e.g. {@link XSDModelBuilder}).
	 * @param ftlTemplate FreeMarker template from which to extract existing {@link ValueMapping mappings}.
	 * @throws ModelBuilderException Invalid {@link ModelBuilder} instance. 
	 * @throws TemplateBuilderException Error processing FreeMarker template.
	 */
    public XMLFreeMarkerTemplateBuilder(ModelBuilder modelBuilder, String ftlTemplate) throws ModelBuilderException, TemplateBuilderException {
        super(modelBuilder);
        addMappings(ftlTemplate);
    }

	/**
     * Omit the XML declaration at the start of the XML document.
     * <p/>
     * The XML declaration is added by default.
     * 
     * @param omitXMLDeclaration True if the XML declaration is to be omitted, otherwise false. 
     * @return This Template Builder instance.
     */
    public TemplateBuilder setOmitXMLDeclaration(boolean omitXMLDeclaration) {
		this.omitXMLDeclaration = omitXMLDeclaration;
		return this;
	}

	public String buildTemplate() throws TemplateBuilderException {
    	Writer templateWriter = new StringWriter();
    	
    	if(!omitXMLDeclaration) {
    		try {
				templateWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"); //$NON-NLS-1$
			} catch (IOException e) {
				throw new IllegalStateException("Unexpected IOException when writing the XML Template.", e); //$NON-NLS-1$
			}
    	}
    	writeElement(getModel().getDocumentElement(), 0, false, templateWriter);
    	
        return templateWriter.toString();
    }

	/**
	 * Recursively write the XML template elements to the supplied template writer.
	 * @param element The element to write.
	 * @param indent Indentation level.
	 * @param templateWriter The writer.
	 */
	private void writeElement(Element element, int indent, boolean addNewline, Writer templateWriter) {
		try {
			if(ModelBuilder.isInReservedNamespace(element)) {
				writeElementChildren(element, indent, templateWriter);
			} else if(assertAddNodeToTemplate(element)) {
				if(addNewline) {
					templateWriter.write('\n');
				}
				
				Mapping mapping = getMapping(element);
				CollectionMapping collectionMapping = null;

				if(mapping instanceof CollectionMapping) {
					collectionMapping = (CollectionMapping) mapping;
					TemplateBuilder.writeIndent(indent, templateWriter);			
					templateWriter.write("<#list " + FreeMarkerUtil.toPath(collectionMapping.getSrcPath(), isNodeModelSource()) + " as " + collectionMapping.getCollectionItemName() + ">\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				}
				
				TemplateBuilder.writeIndent(indent, templateWriter);			
				writeElementStart(element, templateWriter);
				
				ChildWriteHistory writeChildHistory = writeElementChildren(element, indent + 1, templateWriter);
				if(writeChildHistory.numElementsWritten > 0) {
					TemplateBuilder.writeIndent(indent, templateWriter);
				}
				writeElementEnd(element, writeChildHistory.startClosed, templateWriter);

				if(collectionMapping != null) {
					templateWriter.write("\n"); //$NON-NLS-1$
					TemplateBuilder.writeIndent(indent, templateWriter);			
					templateWriter.write("</#list>"); //$NON-NLS-1$
				}
				
				TemplateBuilder.writeIndent(indent, templateWriter);			
			}
		} catch(IOException e) {
			throw new IllegalStateException("Unexpected IOException when writing the XML Template.", e); //$NON-NLS-1$
		}
	}

	private void writeElementStart(Element element, Writer templateWriter) throws IOException {
		templateWriter.write("<"); //$NON-NLS-1$
		templateWriter.write(element.getNodeName());
		
		NamedNodeMap attributes = element.getAttributes();
		for(int i = 0; i < attributes.getLength(); i++) {
			Attr attribute = (Attr) attributes.item(i);
			
			if(!ModelBuilder.isInReservedNamespace(attribute)) {
				Mapping mapping = getMapping(attribute);
				
				if(mapping != null) {
					writeAttribute(attribute.getNodeName(), FreeMarkerUtil.toFreeMarkerVariable((ValueMapping)mapping, isNodeModelSource()), templateWriter); //$NON-NLS-1$
				} else if(ModelBuilder.isRequired(attribute)) {
					writeAttribute(attribute.getNodeName(), attribute.getValue(), templateWriter);
				}
			}				
		}
		
		String nsURI = element.getNamespaceURI();
		if(nsURI != null && !nsURI.equals(XMLConstants.NULL_NS_URI)) {
			String prefix = element.getPrefix();
			
			if(!assertNamespaceDeclOnStack(prefix, nsURI, element)) {
				if(prefix != null) {
					writeAttribute(XMLConstants.XMLNS_ATTRIBUTE + ":" + prefix, nsURI, templateWriter); //$NON-NLS-1$	
				} else {
					writeAttribute(XMLConstants.XMLNS_ATTRIBUTE, nsURI, templateWriter);				
				}
			}
		}		
	}

	private void writeAttribute(String name, String value, Writer templateWriter) throws IOException {
		char quoteChar = (value.indexOf('\"') != -1) ? '\'' : '\"';
		
		templateWriter.write(' '); //$NON-NLS-1$
		templateWriter.write(name);
		templateWriter.write("=" + quoteChar); //$NON-NLS-1$
		templateWriter.write(value);
		templateWriter.write(quoteChar); //$NON-NLS-1$
	}

	private ChildWriteHistory writeElementChildren(Element element, int indent, Writer templateWriter) throws IOException {
		NodeList children = element.getChildNodes();
		ChildWriteHistory writeHistory = new ChildWriteHistory();
		
		if(children.getLength() == 0) {
			Mapping mapping = getMapping(element);
			
			if(ModelBuilder.getElementType(element) == ElementType.simple) {
				templateWriter.write(">"); //$NON-NLS-1$
				writeHistory.startClosed = true;
				if(mapping != null) {
					templateWriter.write(FreeMarkerUtil.toFreeMarkerVariable((ValueMapping)mapping, isNodeModelSource()));
				} else {
					templateWriter.write(ModelBuilder.REQUIRED);
				}
			}
		} else {
			if(!ModelBuilder.isInReservedNamespace(element) && !writeHistory.startClosed) {
				templateWriter.write(">"); //$NON-NLS-1$
			}
			writeHistory.startClosed = true;
			for(int i = 0; i < children.getLength(); i++) {
				Node child = children.item(i);
				if(child.getNodeType() == Node.ELEMENT_NODE) {
					writeElement((Element)child, indent, true, templateWriter);
					writeHistory.numElementsWritten++;
				}
			}
			if(!ModelBuilder.isInReservedNamespace(element)) {
				templateWriter.write('\n'); //$NON-NLS-1$
			}
		}
		
		return writeHistory;
	}
	
	private class ChildWriteHistory {
		private int numElementsWritten = 0;
		private boolean startClosed = false;
	}

	private void writeElementEnd(Element element, boolean startClosed, Writer templateWriter) throws IOException {
		if(startClosed) {
			templateWriter.write("</"); //$NON-NLS-1$
			templateWriter.write(element.getNodeName());
			templateWriter.write(">"); //$NON-NLS-1$
		} else {
			templateWriter.write(" />"); //$NON-NLS-1$
		}
	}

	private boolean assertNamespaceDeclOnStack(String prefix, String nsURI, Element element) {
		Node parent = element.getParentNode();
		
		while (parent != null) {
			if(prefix == null) {
				if(parent.getPrefix() == null && nsURI.equals(parent.getNamespaceURI())) {
					return true;
				}
			} else if(prefix.equals(parent.getPrefix()) && nsURI.equals(parent.getNamespaceURI())) {
				return true;
			}
			
			parent = parent.getParentNode();
		}
		
		return false;
	}
    
	private void addMappings(String ftlTemplate) throws TemplateBuilderException {
    	Template template;
    	
    	try {
			template = new Template("ftlTemplate", new StringReader(ftlTemplate), new Configuration()); //$NON-NLS-1$
		} catch (IOException e) {
			throw new TemplateBuilderException ("Failed to parse the Supplied FreeMarker template.", e); //$NON-NLS-1$
		}

		TemplateElement rootElement = template.getRootTreeNode();
		StringWriter templateRewriteBuffer = new StringWriter();
		
		rewriteTemplateElement(rootElement, templateRewriteBuffer);
		
		Document templateDOM;
		try {
			templateDOM = XmlUtil.parseStream(new StringReader(templateRewriteBuffer.toString()));
		} catch (Exception e) {
			throw new TemplateBuilderException("Error parsing rewritten FreeMarker template.", e); //$NON-NLS-1$
		}
		
		addMappings(templateDOM.getDocumentElement(), new ModelNodeResolver(getModel()));
	}

	private void addMappings(Element element, ModelNodeResolver modelNodeResolver) throws TemplateBuilderException {
		if(TemplateBuilder.isListElement(element)) {
			addCollectionMapping(element, modelNodeResolver);
		} else if(!ModelBuilder.isInReservedNamespace(element)) {
			String elementText = DomUtils.getAllText(element, false);
			
			// Handle the element itself...		
			if(FreeMarkerUtil.isDollarVariable(elementText)) {
				addValueMapping(element, modelNodeResolver, elementText);
			}
			
			// Add mappings for the attributes...
			NamedNodeMap attributes = element.getAttributes();
			int attribCount = attributes.getLength();		
			for(int i = 0; i < attribCount; i++) {
				Attr attribute = (Attr) attributes.item(i);
				
				if(!ModelBuilder.isInReservedNamespace(attribute)) {
					String attrValue = attribute.getValue();
					
					if(FreeMarkerUtil.isDollarVariable(attrValue)) {
						addValueMapping(attribute, modelNodeResolver, attrValue);
					}
				}
			}
		}
		
		// Iterate down into the child elements...
		NodeList children = element.getChildNodes();
		int childCount = children.getLength();
		for(int i = 0; i < childCount; i++) {
			Node child = children.item(i);
			if(child.getNodeType() == Node.ELEMENT_NODE) {
				addMappings((Element) child, modelNodeResolver);
			}
		}
	}

	private void rewriteTemplateElement(TemplateElement element, StringWriter templateRewriteBuffer) throws TemplateBuilderException {
		// We need to rewrite the FreeMarker template so as to get rid of the FreeMarker constructs,
		// such as <#list> etc.  We convert these to XML elements in the ModelBuilder.NAMESPACE namespace.
		
		if(element.getNodeName().equals("IteratorBlock")) { //$NON-NLS-1$
			String description = element.getDescription();

			if(!description.startsWith("list")) { //$NON-NLS-1$
				throw new TemplateBuilderException ("Unsupported XML template IteratorBlock type '" + description + "'.  Currently only support 'list' IteratorBlock nodes."); //$NON-NLS-1$ //$NON-NLS-2$
			}

			String[] tokens = description.split(" +?"); //$NON-NLS-1$
			TemplateBuilder.writeListStart(templateRewriteBuffer, FreeMarkerUtil.toPath(tokens[1], isNodeModelSource()), tokens[3]);

			Enumeration<TemplateElement> children = element.children();			
			while(children != null && children.hasMoreElements()) {
				rewriteTemplateElement(children.nextElement(), templateRewriteBuffer);
			}

			TemplateBuilder.writeListEnd(templateRewriteBuffer);
		} else {
			Enumeration<TemplateElement> children = element.children();
			
			if(children != null && children.hasMoreElements()) {
				while(children.hasMoreElements()) {
					rewriteTemplateElement(children.nextElement(), templateRewriteBuffer);
				}				
			} else {
				if(element.getClass().getSimpleName().equals("DollarVariable")) { //$NON-NLS-1$
					templateRewriteBuffer.append(element.toString());
				} else {
					templateRewriteBuffer.append(element.getCanonicalForm());
				}
			}
		}
	}
}
