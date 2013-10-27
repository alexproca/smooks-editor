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
package org.jboss.tools.smooks.core;

import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.emf.ecore.xmi.XMLDefaultHandler;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.XMLParserPool;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.xml.sax.SAXException;

/**
 * @author Dart
 * 
 */
public class SmooksXMLParserPool implements XMLParserPool {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.xmi.XMLParserPool#get(java.util.Map,
	 * java.util.Map, boolean)
	 */
	public SAXParser get(Map<String, Boolean> features, Map<String, ?> properties, boolean useLexicalHandler)
			throws ParserConfigurationException, SAXException {
		SAXParserFactory f = SAXParserFactory.newInstance();
		return f.newSAXParser();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.ecore.xmi.XMLParserPool#getDefaultHandler(org.eclipse
	 * .emf.ecore.xmi.XMLResource, org.eclipse.emf.ecore.xmi.XMLLoad,
	 * org.eclipse.emf.ecore.xmi.XMLHelper, java.util.Map)
	 */
	public XMLDefaultHandler getDefaultHandler(XMLResource resource, XMLLoad xmlLoad, XMLHelper helper,
			Map<?, ?> options) {
		return new SmooksSAXXMLHandler(resource, helper, options);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.ecore.xmi.XMLParserPool#release(javax.xml.parsers.SAXParser
	 * , java.util.Map, java.util.Map, boolean)
	 */
	public void release(SAXParser parser, Map<String, Boolean> features, Map<String, ?> properties,
			boolean useLexicalHandler) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.ecore.xmi.XMLParserPool#releaseDefaultHandler(org.eclipse
	 * .emf.ecore.xmi.XMLDefaultHandler, java.util.Map)
	 */
	public void releaseDefaultHandler(XMLDefaultHandler handler, Map<?, ?> options) {

	}

}
