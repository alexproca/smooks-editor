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
package org.jboss.tools.smooks.configuration.editors;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.jboss.tools.smooks.model.freemarker.FreemarkerPackage;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Dart dpeng@redhat.com
 * 
 */
public class SmooksConfigFileHandle extends DefaultHandler {
	private boolean correctContentFile = false;

	//		private static final String SMOOKS_RESOURCE_LIST = "smooks-resource-list"; //$NON-NLS-1$

	private String[] smooksSpportURI = null;

	private SAXParserFactory fFactory;

	public SmooksConfigFileHandle() {
		super();
		smooksSpportURI = createSupportURI();
	}

	protected String[] createSupportURI() {
		return new String[] { org.jboss.tools.smooks.model.smooks.SmooksPackage.eNS_URI,
				"http://www.milyn.org/xsd/smooks-1.0.xsd", FreemarkerPackage.eNS_URI }; //$NON-NLS-1$
	}

	private final SAXParser createParser(SAXParserFactory parserFactory) throws ParserConfigurationException,
			SAXException, SAXNotRecognizedException, SAXNotSupportedException {
		// Initialize the parser.
		final SAXParser parser = parserFactory.newSAXParser();
		final XMLReader reader = parser.getXMLReader();
		// disable DTD validation
		try {
			reader.setFeature("http://xml.org/sax/features/validation", false); //$NON-NLS-1$
			reader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false); //$NON-NLS-1$
		} catch (SAXNotRecognizedException e) {
		} catch (SAXNotSupportedException e) {
		}
		return parser;
	}

	private SAXParserFactory getFactory() {
		synchronized (this) {
			if (fFactory != null) {
				return fFactory;
			}
			fFactory = SAXParserFactory.newInstance();
			fFactory.setNamespaceAware(true);
		}
		return fFactory;
	}

	public boolean parseContents(InputSource contents) throws ParserConfigurationException, IOException {
		try {
			fFactory = getFactory();
			if (fFactory == null) {
				return false;
			}
			final SAXParser parser = createParser(fFactory);
			contents.setSystemId("/"); //$NON-NLS-1$
			parser.parse(contents, this);
		} catch (SAXException e) {
			// stop parsing
		}
		return true;
	}

	/*
	 * Resolve external entity definitions to an empty string. This is to speed
	 * up processing of files with external DTDs. Not resolving the contents of
	 * the DTD is ok, as only the System ID of the DTD declaration is used.
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#resolveEntity(java.lang.String,
	 * java.lang.String)
	 */
	public InputSource resolveEntity(String publicId, String systemId) throws SAXException {
		return new InputSource(new StringReader("")); //$NON-NLS-1$
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		super.startPrefixMapping(prefix, uri);
		if (containtSmooksURI(uri)) {
			setCorrectContentFile(true);
			throw new SAXException(Messages.SmooksConfigFileHandle_exception);
		}
	}

	private boolean unSupportUIR(String uri) {
		// if (EdiPackage.eNS_URI.equals(uri)) {
		// return true;
		// }
		return false;
	}

	private boolean containtSmooksURI(String uri) {
		for (int i = 0; i < smooksSpportURI.length; i++) {
			if (uri != null) {
				if (uri.trim().equalsIgnoreCase(smooksSpportURI[i])) {
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ContentHandler#startElement(java.lang.String,
	 * java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	public final void startElement(final String uri, final String elementName, final String qualifiedName,
			final Attributes attributes) throws SAXException {
		if (isCorrectContentFile()) {
			throw new SAXException(Messages.SmooksConfigFileHandle_exception);
		}
		if (containtSmooksURI(uri)) {
			setCorrectContentFile(true);
			throw new SAXException(Messages.SmooksConfigFileHandle_exception);
		}
	}

	public boolean isCorrectContentFile() {
		return correctContentFile;
	}

	public void setCorrectContentFile(boolean correctContentFile) {
		this.correctContentFile = correctContentFile;
	}
}
