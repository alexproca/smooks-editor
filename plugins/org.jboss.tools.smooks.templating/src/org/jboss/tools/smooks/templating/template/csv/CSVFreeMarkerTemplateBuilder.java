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
package org.jboss.tools.smooks.templating.template.csv;

import java.io.IOException;
import java.io.StringReader;
import java.util.Enumeration;

import org.jboss.tools.smooks.templating.model.ModelBuilder;
import org.jboss.tools.smooks.templating.model.ModelBuilderException;
import org.jboss.tools.smooks.templating.template.CollectionMapping;
import org.jboss.tools.smooks.templating.template.Mapping;
import org.jboss.tools.smooks.templating.template.ValueMapping;
import org.jboss.tools.smooks.templating.template.exception.TemplateBuilderException;
import org.jboss.tools.smooks.templating.template.exception.UnmappedCollectionNodeException;
import org.jboss.tools.smooks.templating.template.freemarker.FreeMarkerTemplateBuilder;
import org.jboss.tools.smooks.templating.template.util.FreeMarkerUtil;
import org.milyn.xml.DomUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import au.com.bytecode.opencsv.CSVReader;
import freemarker.core.TemplateElement;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * Freemarker Template Builder for a CSV messages.
 *
 * @author <a href="mailto:tom.fennelly@jboss.com">tom.fennelly@jboss.com</a>
 */
public class CSVFreeMarkerTemplateBuilder extends FreeMarkerTemplateBuilder {

    private char separatorChar;
    private char quoteChar;
	private boolean includeFieldNames;    

    /**
     * Construct a new FreeMarker Template Builder with no mappings.
     * @param model The model.
     * @param separatorChar The CSV field separator character.
     * @param quoteChar The CSV field quote character.
     * @param includeFieldNames True if field names are to be added at the start of the generated message, otherwise false.
     * @throws ModelBuilderException Error building model.
     */
    public CSVFreeMarkerTemplateBuilder(ModelBuilder modelBuilder, char separatorChar, char quoteChar, boolean includeFieldNames) throws ModelBuilderException {
        super(modelBuilder);
        this.separatorChar = separatorChar;
        this.quoteChar = quoteChar;
        this.includeFieldNames = includeFieldNames;
    }

    /**
     * Construct a new FreeMarker Template Builder, extracting the mappings from the
     * supplied FreeMarker template String.
     * @param model The model.
     * @param separatorChar The CSV field separator character.
     * @param quoteChar The CSV field quote character.
     * @param includeFieldNames True if field names are to be added at the start of the generated message, otherwise false.
     * @param ftlTemplate The FreeMarker Template from which the mappings are to be extracted.
     * @throws ModelBuilderException Error building model.
     * @throws TemplateBuilderException Error adding mappings extracted from template. 
     */
    public CSVFreeMarkerTemplateBuilder(ModelBuilder modelBuilder, char separatorChar, char quoteChar, boolean includeFieldNames, String ftlTemplate) throws ModelBuilderException, TemplateBuilderException {
        this(modelBuilder, separatorChar, quoteChar, includeFieldNames);
        addMappings(ftlTemplate);
    }

    private void addMappings(String ftlTemplate) throws TemplateBuilderException {
    	Template template;
    	
    	try {
			template = new Template("csvTemplate", new StringReader(ftlTemplate), new Configuration()); //$NON-NLS-1$
		} catch (IOException e) {
			throw new TemplateBuilderException ("Failed to parse the Supplied FreeMarker template.", e); //$NON-NLS-1$
		}

		TemplateElement listNode = findListNode(template.getRootTreeNode());
		if(listNode == null) { //$NON-NLS-1$
			throw new TemplateBuilderException ("Unable to recognize template as being a CSV template"); //$NON-NLS-1$
		}
		
		// Add the mapping for the list itself...
		addCSVListMapping(listNode.getDescription());
		
		// Add the mappings for the individual fields...
		addCSVFieldMappings(listNode);
    }

	private TemplateElement findListNode(TemplateElement templateNode) throws TemplateBuilderException {
		if(templateNode.getNodeName().equals("IteratorBlock")) { //$NON-NLS-1$
			String description = templateNode.getDescription();
			if(!description.startsWith("list")) { //$NON-NLS-1$
				throw new TemplateBuilderException ("Unsupported CSV template IteratorBlock type '" + description + "'.  Currently only support 'list' IteratorBlock nodes."); //$NON-NLS-1$ //$NON-NLS-2$
			}
			return templateNode;
		} else {
			Enumeration<TemplateElement> children = templateNode.children();
			
			if(children != null && children.hasMoreElements()) {
				while(children.hasMoreElements()) {
					TemplateElement listNode = findListNode(children.nextElement());
					if(listNode != null) {
						return listNode;
					}
				}				
			}
		}
		
		return null;
	}

	private void addCSVListMapping(String description) throws TemplateBuilderException {
		String[] tokens = description.split(" +?"); //$NON-NLS-1$
		Element csvRecordElement = getModel().getDocumentElement();
		
		// 2nd and 4th tokens contain the info we're looking for e.g. "list message.people as person"
		addCollectionMapping(tokens[1], csvRecordElement, tokens[3]);
	}

	private void addCSVFieldMappings(TemplateElement listElement) throws TemplateBuilderException {
		StringBuilder parseBuffer = new StringBuilder();
		Enumeration children = listElement.children();
		
		while(children != null && children.hasMoreElements()) {
			TemplateElement child = (TemplateElement) children.nextElement();
			parseBuffer.append(child.getCanonicalForm());
		}
		
		Element csvRecordElement = getModel().getDocumentElement();
		CSVReader csvReader = new CSVReader(new StringReader(parseBuffer.toString()), separatorChar, quoteChar);
		try {
			String[] fields = csvReader.readNext();
			int fieldIndex = 0;
			NodeList csvFieldModelNodes = csvRecordElement.getChildNodes();
			
			for(int i = 0; i < csvFieldModelNodes.getLength(); i++) {
				Node node = csvFieldModelNodes.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					if(fieldIndex >= fields.length) {
						throw new TemplateBuilderException("CSV Template fieldset size does not match that of the specified message model.  Check the supplied fieldset.  Check the specified 'separator' and 'quote' characters match those used in the template."); //$NON-NLS-1$
					}
					
					if(FreeMarkerUtil.isDollarVariable(fields[fieldIndex])) {
						addValueMapping(node, fields[fieldIndex]);
					}					
					fieldIndex++;
				}
			}
		} catch (IOException e) {
			throw new TemplateBuilderException("Failed to parse CSV fields in CSV template.", e); //$NON-NLS-1$
		}
	}

	public String buildTemplate() throws TemplateBuilderException {
        Element recordElement = getModel().getDocumentElement();
        CollectionMapping collectionMapping = getCollectionMapping(recordElement);

        if(collectionMapping == null) {
            throw new UnmappedCollectionNodeException(recordElement);
        } else {
            StringBuilder template = new StringBuilder();
            NodeList nodeList = recordElement.getChildNodes();
            
            if(includeFieldNames) {
                int fieldIndex = 0;
                for(int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if(node.getNodeType() == Node.ELEMENT_NODE) {
                        if(fieldIndex > 0) {
                            template.append(separatorChar);
                        }
                        template.append(quoteChar);
                        template.append(DomUtils.getName((Element) node));
                        template.append(quoteChar);

                        fieldIndex++;
                    }
                }
                template.append('\n');
            }

            template.append("<#list " + FreeMarkerUtil.toPath(collectionMapping.getSrcPath(), isNodeModelSource()) + " as " + collectionMapping.getCollectionItemName() + ">\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            int fieldIndex = 0;
            for(int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Mapping fieldMapping = getMapping(node);

                    if(fieldIndex > 0) {
                        template.append(separatorChar);
                    }

                    if(fieldMapping != null) {
                        template.append(quoteChar);
                        template.append(FreeMarkerUtil.toFreeMarkerVariable((ValueMapping) fieldMapping, isNodeModelSource())); //$NON-NLS-1$
                        template.append(quoteChar);
                    }

                    fieldIndex++;
                }
            }
            template.append("\n</#list>"); //$NON-NLS-1$

            return template.toString();
        }
    }
}