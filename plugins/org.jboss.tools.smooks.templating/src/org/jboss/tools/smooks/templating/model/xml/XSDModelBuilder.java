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
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Stack;

import javax.xml.XMLConstants;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xsd.XSDAttributeDeclaration;
import org.eclipse.xsd.XSDAttributeUse;
import org.eclipse.xsd.XSDAttributeUseCategory;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDCompositor;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDParticleContent;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.util.XSDResourceFactoryImpl;
import org.eclipse.xsd.util.XSDResourceImpl;
import org.jboss.tools.smooks.templating.model.ModelBuilder;
import org.jboss.tools.smooks.templating.model.ModelBuilderException;
import org.jboss.tools.smooks.templating.template.xml.XMLFreeMarkerTemplateBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * XML Model Builder from an XML Schema (XSD).
 * <p/>
 * The generated model can then be used by the {@link XMLFreeMarkerTemplateBuilder}.
 * <p/>
 * Uses the Eclipse Schema Infoset Model API.
 *
 * @author <a href="mailto:tom.fennelly@jboss.com">tom.fennelly@jboss.com</a>
 */
public class XSDModelBuilder extends ModelBuilder {

    private Map<String, XSDElementDeclaration> elements = new LinkedHashMap<String, XSDElementDeclaration>();
    private Map<String, XSDTypeDefinition> types = new LinkedHashMap<String, XSDTypeDefinition>();
    private Set<String> loadedSchemas = new HashSet<String>();
    private Stack<XSDTypeDefinition> elementExpandStack = new Stack<XSDTypeDefinition>();
    private String rootElementName;
    private Properties nsPrefixes = new Properties();

    public XSDModelBuilder(URI schemaURI) throws IOException, ModelBuilderException {
        loadSchema(schemaURI);
    }

    public Set<String> getRootElementNames() {
        return Collections.unmodifiableSet(elements.keySet());
    }

    public void setRootElementName(String rootElementName) {
        this.rootElementName = rootElementName;
    }

    public Document buildModel() throws ModelBuilderException {
        if(rootElementName == null) {
            throw new IllegalStateException("The 'rootElementName' property has not been set."); //$NON-NLS-1$
        }

        XSDElementDeclaration rootElement = elements.get(rootElementName);

        if(rootElement == null) {
            throw new IllegalArgumentException("Unknown root element '" + rootElementName + "'."); //$NON-NLS-1$ //$NON-NLS-2$
        }

        Document model = createModelInstance();
        expand(rootElement, 1, 1, model, model);

        // The model has detailed metadata attached, so mark it as a strict model...
        ModelBuilder.setStrictModel(model, true);

        return model;
    }

    /**
     * Validate the supplied message against this XSD ModelBuilder instance.
     * @throws SAXException Validation error.
     * @throws IOException Error reading the XSD Sources.
     */
    public void validate(Document message) throws SAXException, IOException {
        StreamSource[] xsdSources = new StreamSource[loadedSchemas.size()];
        int i = 0;

        try {
	        for(String schemaPath : loadedSchemas) {
	        	File schemaFile = new File(schemaPath);
	        	
	        	if(!schemaFile.exists()) {
	        		throw new IOException("XSD '" + schemaFile.getAbsolutePath() + "' not found."); //$NON-NLS-1$ //$NON-NLS-2$
	        	}
	        	xsdSources[i] = new StreamSource(new FileInputStream(schemaFile));
	        	i++;
	        }
	
	        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	        Schema schema = schemaFactory.newSchema(xsdSources);
	        Validator validator = schema.newValidator();

	        validator.validate(new DOMSource(message));
        } finally {
	        for(StreamSource schemaStream : xsdSources) {
	        	try {
	        		schemaStream.getInputStream().close();
	        	} catch(Exception e) {
	        		// Nothing we can do...
	        	}
	        }        	
        }
    }    

    private void loadSchema(URI schemaURI) throws IOException, ModelBuilderException {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource;
		
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xsd", new XSDResourceFactoryImpl()); //$NON-NLS-1$
		resource = resourceSet.getResource(schemaURI, true);

        Map<String, Object> options = new HashMap<String, Object>();
        options.put(XSDResourceImpl.XSD_TRACK_LOCATION, true);

        resource.load(options);

        if(resource.getContents().isEmpty()) {
            throw new ModelBuilderException("Failed to load schema '" + schemaURI + "'."); //$NON-NLS-1$ //$NON-NLS-2$
        }

        XSDSchema schema = (XSDSchema) resource.getContents().get(0);

        List<XSDElementDeclaration> elementDeclarations = schema.getElementDeclarations();
        for(XSDElementDeclaration elementDeclaration : elementDeclarations) {
            if(!elementDeclaration.isAbstract()) {
                elements.put(elementDeclaration.getName(), elementDeclaration);
            }
        }

        EList typeDefs = schema.getTypeDefinitions();
        for(int i = 0; i < typeDefs.size(); i++) {
            XSDTypeDefinition type = (XSDTypeDefinition) typeDefs.get(i);
            types.put(type.getName(), type);
        }
        
        EList<Resource> schemaResources = resourceSet.getResources();
        for(Resource schemaRes : schemaResources) {
        	loadedSchemas.add(schemaRes.getURI().toFileString());
        }
    }

    private void expand(XSDElementDeclaration elementDeclaration, int minOccurs, int maxOccurs, Node parent, Document document) {
        XSDTypeDefinition typeDef;

        if(elementDeclaration.isElementDeclarationReference()) {
            elementDeclaration = elementDeclaration.getResolvedElementDeclaration();
            typeDef = elementDeclaration.getTypeDefinition();
        } else {
            typeDef = elementDeclaration.getTypeDefinition();
        }

        String elementName = elementDeclaration.getName();
        if(elementDeclaration.isAbstract()) {
            if(typeDef != null) {
                addTypeImpls(typeDef, minOccurs, maxOccurs, parent, document);
            }
            return;
        }

        if(elementExpandStack.contains(typeDef)) {
            return;
        }

        elementExpandStack.push(typeDef);
        try {
            String elementNS = elementDeclaration.getTargetNamespace();
            Element element;
            
            if(elementNS == null || elementNS.equals(XMLConstants.W3C_XML_SCHEMA_NS_URI)) {
                element = document.createElement(elementName);
            } else {            	
            	String nsPrefix = getPrefix(elementNS);
            	
            	element = document.createElementNS(elementNS, nsPrefix + ":" + elementName); //$NON-NLS-1$
            	getNamespaces().setProperty(nsPrefix, elementNS);
            }
            
            setMinMax(element, minOccurs, maxOccurs);
            parent.appendChild(element);

            if(typeDef instanceof XSDComplexTypeDefinition) {
            	ModelBuilder.setElementType(element, ElementType.complex);
                processComplexType(document, element, (XSDComplexTypeDefinition) typeDef);
            } else if(typeDef instanceof XSDSimpleTypeDefinition) {
                XSDSimpleTypeDefinition simpleTypeDef = (XSDSimpleTypeDefinition) typeDef;
                XSDTypeDefinition loadedType = types.get(simpleTypeDef.getName());

                if(loadedType instanceof XSDComplexTypeDefinition) {
                	ModelBuilder.setElementType(element, ElementType.complex);
                    processComplexType(document, element, (XSDComplexTypeDefinition) loadedType);
                } else {
                	ModelBuilder.setElementType(element, ElementType.simple);                	
                }
            } else if(typeDef != null) {
                System.out.println("?? " + typeDef); //$NON-NLS-1$
            }
        } finally {
            elementExpandStack.pop();
        }
    }

	private String getPrefix(String elementNS) {
		String nsPrefix = nsPrefixes.getProperty(elementNS);
		if(nsPrefix == null) {
			nsPrefix = "ns" + nsPrefixes.size(); //$NON-NLS-1$
			nsPrefixes.setProperty(elementNS, nsPrefix);
		}
		return nsPrefix;
	}

	private void processComplexType(Document document, Element element, XSDComplexTypeDefinition complexTypeDef) {
        XSDParticle particle = complexTypeDef.getComplexType();
        EList attributes = complexTypeDef.getAttributeContents();

        addAttributes(element, attributes);

        if(particle != null) {
            XSDParticleContent particleContent = particle.getContent();
            if (particleContent instanceof XSDModelGroup) {
                processModelGroup((XSDModelGroup) particleContent, particle.getMinOccurs(), particle.getMaxOccurs(), element, document);
            }
        }
    }

    private void processModelGroup(XSDModelGroup modelGroup, int minOccurs, int maxOccurs, Element element, Document document) {
        List<XSDParticle> particles = modelGroup.getParticles();
        XSDCompositor compositor = modelGroup.getCompositor();
        String compositorType = compositor.getName();

        if(particles.size() > 1 && compositorType.equals("choice")) { //$NON-NLS-1$
            Element compositorEl = ModelBuilder.createCompositor(document);

            compositorEl.setAttribute("type", compositorType); //$NON-NLS-1$
            setMinMax(compositorEl, minOccurs, maxOccurs);
            element.appendChild(compositorEl);
            element = compositorEl;
        }

        for (XSDParticle particle : particles) {
            XSDParticleContent content = particle.getContent();

            if (content instanceof XSDElementDeclaration) {
                expand((XSDElementDeclaration) content, particle.getMinOccurs(), particle.getMaxOccurs(), element, document);
            } else if (content instanceof XSDModelGroup) {
                processModelGroup((XSDModelGroup) content, particle.getMinOccurs(), particle.getMaxOccurs(), element, document);
            }
        }
    }

    private void addTypeImpls(XSDTypeDefinition baseType, int minOccurs, int maxOccurs, Node parent, Document document) {
        Set<Map.Entry<String, XSDElementDeclaration>> elementEntrySet = elements.entrySet();

        for(Map.Entry<String, XSDElementDeclaration> elementEntry : elementEntrySet) {
            XSDElementDeclaration elementDecl = elementEntry.getValue();

            if(isInstanceOf(baseType, elementDecl.getType())) {
                expand(elementDecl, minOccurs, maxOccurs, parent, document);
            }
        }
    }

    private void addAttributes(Element element, EList attributes) {
        // Add the attributes...
        if(attributes != null) {
            for(int i = 0; i < attributes.size(); i++) {
                XSDAttributeUse attributeUse = (XSDAttributeUse) attributes.get(i);
                XSDAttributeDeclaration attributeDecl = attributeUse.getAttributeDeclaration();
                XSDSimpleTypeDefinition typeDef = attributeDecl.getTypeDefinition();
                String name = attributeDecl.getName();
                String attributeNS = attributeDecl.getTargetNamespace();
                String value = ""; //$NON-NLS-1$
                XSDAttributeUseCategory use = attributeUse.getUse();

                if(use == XSDAttributeUseCategory.REQUIRED_LITERAL) {
                    value = REQUIRED;
                } else if(attributeUse.getValue() != null) {
                    value = OPTIONAL + "=" + attributeUse.getValue().toString(); //$NON-NLS-1$
                } else {
                    value = OPTIONAL;
                }

                if(attributeNS == null || attributeNS.equals(XMLConstants.W3C_XML_SCHEMA_NS_URI)) {
                	element.setAttribute(name, value);
                } else {
                	String nsPrefix = getPrefix(attributeNS);
                	
                	element.setAttributeNS(attributeNS, nsPrefix + ":" + name, value); //$NON-NLS-1$
                	getNamespaces().setProperty(nsPrefix, attributeNS);
                }
            }
        }
    }

    private boolean isInstanceOf(XSDTypeDefinition baseType, XSDTypeDefinition type) {
        if(type == null) {
            return false;
        } else if(type.equals(baseType)) {
            return true;
        } else if(type.equals(type.getBaseType())) {
            // The base type is equal to the type itself when we've reached the root of the inheritance hierarchy...
            return false;
        } else {
            return isInstanceOf(baseType, type.getBaseType());
        }
    }
}