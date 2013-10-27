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

import java.util.Properties;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.milyn.xml.DomUtils;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Abstract message model builder.
 * 
 * @author <a href="mailto:tom.fennelly@jboss.com">tom.fennelly@jboss.com</a>
 */
public abstract class ModelBuilder {
    
    public static final String NAMESPACE = "http://www.jboss.org/xsd/tools/smooks"; // TODO: Make same as JBT eclipse extension namespace ?? //$NON-NLS-1$
    public static final String REQUIRED = "#required"; //$NON-NLS-1$
    public static final String OPTIONAL = "#optional"; //$NON-NLS-1$

    private static final String HIDDEN_ELEMENT = "hidden"; //$NON-NLS-1$

    public static enum ElementType {
    	simple,
    	complex
    }
    
    private Properties namespaces = new Properties();
    
    /**
     * Build the message model.
     * @return The message model.
     * @throws ModelBuilderException Error building model.
     */
    public abstract Document buildModel() throws ModelBuilderException;

    /**
     * Get the namespace prefix-to-URI mappings for this model.
     * @return The namespace prefix-to-URI mappings for this model.
     */
    public Properties getNamespaces() {
		return namespaces;
	}



	/**
     * Mark a fragment as being hidden.
     * <p/>
     * When hidden, it is illegal to attempt a mapping onto a fragment.
     *
     * @param fragment The fragment to be marked as hidden.
     */
    public static void hideFragment(Element fragment) {
        fragment.setAttributeNS(NAMESPACE, HIDDEN_ELEMENT, "true"); //$NON-NLS-1$
    }

    /**
     * Unmark a fragment as being hidden.
     * <p/>
     * When hidden, it is illegal to attempt a mapping onto a fragment.
     *
     * @param fragment The fragment to be unmarked as hidden.
     */
    public static void unhideFragment(Element fragment) {
        fragment.removeAttributeNS(NAMESPACE, HIDDEN_ELEMENT);
    }

    /**
     * Is the specified node marked as being hidden.
     * <p/>
     * When hidden, it is illegal to attempt a mapping onto a fragment.
     *
     * @return True if the node is hidden, otherwise false.
     */
    public static boolean isHidden(Node node) {
        if(node != null) {
            switch(node.getNodeType()) {
                case Node.ATTRIBUTE_NODE :
                    return isHidden(node.getParentNode());
                case Node.ELEMENT_NODE :
                    if(((Element)node).getAttributeNS(NAMESPACE, HIDDEN_ELEMENT).equals("true")) { //$NON-NLS-1$
                        return true;
                    }
                    return isHidden(node.getParentNode());
            }
        }
        
        return false;
    }

    /**
     * Is the specified node required.
     * <p/>
     * For an Element node, this means does it have a minOccurs > 0.  For an Attr node,
     * it means is its value set to "#REQUIRED".
     *
     * @return True if the node is hidden, otherwise false.
     */
    public static boolean isRequired(Node node) {
        if(node != null) {
            switch(node.getNodeType()) {
                case Node.ATTRIBUTE_NODE :
                    return (REQUIRED.equals(node.getTextContent()) || XMLConstants.XML_NS_URI.equals(node.getNamespaceURI()));
                case Node.ELEMENT_NODE :
                    if(getMinOccurs((Element) node) > 0) {
                        return true;
                    }
            }
        }
        
        return false;
    }

    /**
     * Is the specified node in the reserved namespace.
     *
     * @return True if the node is in the reserved namespace, otherwise false.
     */
    public static boolean isInReservedNamespace(Node node) {
        if(node != null) {
            return NAMESPACE.equals(node.getNamespaceURI());
        }
        
        return false;
    }

    protected Document createModelInstance() throws ModelBuilderException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;

        try {
            builder = builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new ModelBuilderException("Error constructing DOM DocumentBuilder.", e); //$NON-NLS-1$
        }

        return builder.newDocument();
    }

    public static void setMinMax(Element element, int minOccurs, int maxOccurs) {
        element.setAttributeNS(NAMESPACE, "smk:minOccurs", Integer.toString(minOccurs)); //$NON-NLS-1$
        element.setAttributeNS(NAMESPACE, "smk:maxOccurs", Integer.toString(maxOccurs)); //$NON-NLS-1$
    }

    public static Node getParentNode(Node node) {
		if(node.getNodeType() == Node.ATTRIBUTE_NODE) {
			return ((Attr)node).getOwnerElement();
		} else {
			return node.getParentNode();
		}
	}

	public static int getMinOccurs(Element element) {
        String minOccurs = element.getAttributeNS(NAMESPACE, "minOccurs"); //$NON-NLS-1$

        if(minOccurs.equals("")) { //$NON-NLS-1$
            return 1;
        }

        return Integer.parseInt(minOccurs);
    }

    public static int getMaxOccurs(Element element) {
        String maxOccurs = element.getAttributeNS(NAMESPACE, "maxOccurs"); //$NON-NLS-1$

        if(maxOccurs.equals("")) { //$NON-NLS-1$
            return 1;
        }

        return Integer.parseInt(maxOccurs);
    }

    public static boolean isCollection(Element element) {
    	if(element == null) {
    		return false;
    	}
    	
    	int maxOccurs = getMaxOccurs(element);

        return (maxOccurs > 1 || maxOccurs == -1);
    }
    
    public static void setElementType(Element element, ElementType type) {
        element.setAttributeNS(NAMESPACE, "smk:elementType", type.toString()); //$NON-NLS-1$    	
    }
    
    public static ElementType getElementType(Element element) {
        String elementType = element.getAttributeNS(NAMESPACE, "elementType"); //$NON-NLS-1$
        
        if(elementType == null || elementType.length() == 0) {
        	return null;
        }

        return ElementType.valueOf(elementType);
    }

	/**
	 * Create a compositor Element.
	 * @param document Owner Document node.
	 * @return The compositor Element.
	 */
	public static Element createCompositor(Document document) {
		return document.createElementNS(NAMESPACE, "smk:compositor"); //$NON-NLS-1$
	}

	/**
	 * Is the supplied DOM node the compositor Element.
	 * @param node The DOM node to test.
	 * @return True if the node is the compositor element, otherwise false.
	 */
	public static boolean isCompositor(Node node) {
		if(node.getNodeType() == Node.ELEMENT_NODE) {
			if(DomUtils.getName((Element)node).equals("compositor")) { //$NON-NLS-1$
				if(NAMESPACE.equals(node.getNamespaceURI())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Turn on/off enforcement of collection sub-mapping rules.
	 * <p/>
	 * If turned on, the collection mapping must be made on the model collection element (having maxOccurs > 1)
	 * before mappings can be made on sub elements.
	 * 
	 * @param element The model element.
	 * @param enforce True if enforcement is to be turned on, otherwise false.
	 */
	public static void setEnforceCollectionSubMappingRules(Element element, boolean enforce) {
        element.setAttributeNS(NAMESPACE, "smk:enforceCollectionSubMappingRules", Boolean.toString(enforce)); //$NON-NLS-1$    	
	}

	/**
	 * Is collection sub-mapping rules turned on for the supplied model element.
	 * @param element The model element.
	 * @return True if enforcement is turned on, otherwise false.
	 * @see #setEnforceCollectionSubMappingRules(Element, boolean)
	 */
	public static boolean getEnforceCollectionSubMappingRules(Element element) {
        String enforce = element.getAttributeNS(NAMESPACE, "enforceCollectionSubMappingRules"); //$NON-NLS-1$
        
        if(enforce == null || enforce.length() == 0) {
        	return true;
        }

        return !enforce.equals("false"); //$NON-NLS-1$
    }

	/**
	 * Does the model element contain child elements.
	 * @param element The element to test.
	 * @return true if the element contains child elements, otherwise false.
	 */
	public static boolean hasChildElements(Element element) {
		NodeList childNodes = element.getChildNodes();
		int numChildren = childNodes.getLength();
		
		for(int i = 0; i < numChildren; i++) {
			if(childNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Does the model element have child content of any kind.
	 * <p/>
	 * Does it have child elements or attributes.
	 * 
	 * @param element The element to test.
	 * @return true if the element contains child content of any kind, otherwise false.
	 */
	public static boolean hasChildContent(Element element) {
		return (element.hasAttributes() || hasChildElements(element));
	}
	
	/**
	 * Set the model as being strict, or not.
	 * <p/>
	 * A strict model should have cardinality info attached e.g. minOccurs/maxOccurs, required etc.
	 * @param model The model Document node.
	 * @param strict True if the model is strict, otherwise false.
	 */
	public static void setStrictModel(Document model, boolean strict) {
		Element documentElement = model.getDocumentElement();
		
		if(documentElement == null) {
			throw new IllegalStateException("Call to 'markStrictModel' before the model's root element has been added."); //$NON-NLS-1$   
		}
		
		documentElement.setAttributeNS(NAMESPACE, "smk:strict", Boolean.toString(strict)); //$NON-NLS-1$    	
	}
	
	/**
	 * Is the model strict, or not.
	 * <p/>
	 * A strict model should have cardinality info attached e.g. minOccurs/maxOccurs, required etc.
	 * @param model The model Document node.
	 * @return True if the model is strict, otherwise false.
	 */
	public static boolean isStrictModel(Document model) {
		Element documentElement = model.getDocumentElement();
		
		if(documentElement == null) {
			throw new IllegalStateException("Call to 'isStrictModel' before the model's root element has been added."); //$NON-NLS-1$   
		}
		
		String strict = documentElement.getAttributeNS(NAMESPACE, "strict"); //$NON-NLS-1$
		
		return Boolean.parseBoolean(strict);
	}
}
