/*******************************************************************************
 * Copyright (c) 2009 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.smooks.configuration.editors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.ITextContentDescriber;
import org.xml.sax.InputSource;

/**
 * @author Dart (dpeng@redhat.com) note : Many codes comes from
 *         org.eclipse.core.internal.content.XMLConentDescriber
 */
public class SmooksConfigfileContentDescriber implements ITextContentDescriber, IExecutableExtension {

	private static final QualifiedName[] SUPPORTED_OPTIONS = new QualifiedName[] { IContentDescription.CHARSET,
			IContentDescription.BYTE_ORDER_MARK };

	private static final String ENCODING = "encoding="; //$NON-NLS-1$

	private static final String XML_PREFIX = "<?xml "; //$NON-NLS-1$

	/**
	 * 
	 */
	public SmooksConfigfileContentDescriber() {
		// TODO Auto-generated constructor stub
	}

	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {

	}

	public int describeXMLFile(InputStream input, IContentDescription description) throws IOException {
		byte[] bom = getByteOrderMark(input);
		String xmlDeclEncoding = "UTF-8"; //$NON-NLS-1$
		input.reset();
		if (bom != null) {
			if (bom == IContentDescription.BOM_UTF_16BE)
				xmlDeclEncoding = "UTF-16BE"; //$NON-NLS-1$
			else if (bom == IContentDescription.BOM_UTF_16LE)
				xmlDeclEncoding = "UTF-16LE"; //$NON-NLS-1$
			// skip BOM to make comparison simpler
			input.skip(bom.length);
			// set the BOM in the description if requested
			if (description != null && description.isRequested(IContentDescription.BYTE_ORDER_MARK))
				description.setProperty(IContentDescription.BYTE_ORDER_MARK, bom);
		}
		byte[] xmlPrefixBytes = XML_PREFIX.getBytes(xmlDeclEncoding);
		byte[] prefix = new byte[xmlPrefixBytes.length];
		if (input.read(prefix) < prefix.length)
			// there is not enough info to say anything
			return INDETERMINATE;
		for (int i = 0; i < prefix.length; i++)
			if (prefix[i] != xmlPrefixBytes[i])
				// we don't have a XMLDecl... there is not enough info to say
				// anything
				return INDETERMINATE;
		if (description == null)
			return VALID;
		// describe charset if requested
		if (description.isRequested(IContentDescription.CHARSET)) {
			String fullXMLDecl = readFullXMLDecl(input, xmlDeclEncoding);
			if (fullXMLDecl != null) {
				String charset = getCharset(fullXMLDecl);
				if (charset != null && !"UTF-8".equalsIgnoreCase(charset)) //$NON-NLS-1$
					// only set property if value is not default (avoid using a
					// non-default content description)
					description.setProperty(IContentDescription.CHARSET, getCharset(fullXMLDecl));
			}
		}
		return VALID;
	}

	public int describeXMLType(Reader input, IContentDescription description) throws IOException {
		BufferedReader reader = new BufferedReader(input);
		String line = reader.readLine();
		// end of stream
		if (line == null)
			return INDETERMINATE;
		// XMLDecl should be the first string (no blanks allowed)
		if (!line.startsWith(XML_PREFIX))
			return INDETERMINATE;
		if (description == null)
			return VALID;
		// describe charset if requested
		if ((description.isRequested(IContentDescription.CHARSET)))
			description.setProperty(IContentDescription.CHARSET, getCharset(line));
		return VALID;
	}

	public int describe(InputStream input, IContentDescription description) throws IOException {
		if (this.describeXMLFile(input, description) == INVALID) {
			return INVALID;
		}
		input.reset();
		return checkCriteria(new InputSource(input));
	}

	private String readFullXMLDecl(InputStream input, String unicodeEncoding) throws IOException {
		byte[] xmlDecl = new byte[100];
		int c = 0;
		// looks for XMLDecl ending char (?)
		int read = 0;
		while (read < xmlDecl.length && (c = input.read()) != -1 && c != '?')
			xmlDecl[read++] = (byte) c;
		return c == '?' ? new String(xmlDecl, 0, read, unicodeEncoding) : null;
	}

	public int describe(Reader input, IContentDescription description) throws IOException {
		if (this.describeXMLType(input, description) == INVALID) {
			return INVALID;
		}
		input.reset();
		return checkCriteria(new InputSource(input));
	}
	
	protected SmooksConfigFileHandle createHandle(){
		return new SmooksConfigFileHandle();
	}

	/**
	 * To check the namespaces of the file
	 * 
	 * @param contents
	 * @return
	 * @throws IOException
	 */
	private int checkCriteria(InputSource contents) throws IOException {
		SmooksConfigFileHandle handle = createHandle();
		try {
			if (!handle.parseContents(contents)) {
				return INDETERMINATE;
			}
		} catch (ParserConfigurationException e) {
			return INDETERMINATE;
		}
		if (handle.isCorrectContentFile()) {
			return VALID;
		}
		return INDETERMINATE;
	}

	private String getCharset(String firstLine) {
		int encodingPos = firstLine.indexOf(ENCODING);
		if (encodingPos == -1)
			return null;
		char quoteChar = '"';
		int firstQuote = firstLine.indexOf(quoteChar, encodingPos);
		if (firstQuote == -1) {
			quoteChar = '\'';
			firstQuote = firstLine.indexOf(quoteChar, encodingPos);
		}
		if (firstQuote == -1 || firstLine.length() == firstQuote - 1)
			return null;
		int secondQuote = firstLine.indexOf(quoteChar, firstQuote + 1);
		if (secondQuote == -1)
			return null;
		return firstLine.substring(firstQuote + 1, secondQuote);
	}

	public QualifiedName[] getSupportedOptions() {
		return SUPPORTED_OPTIONS;
	}

	byte[] getByteOrderMark(InputStream input) throws IOException {
		int first = input.read();
		if (first == 0xEF) {
			// look for the UTF-8 Byte Order Mark (BOM)
			int second = input.read();
			int third = input.read();
			if (second == 0xBB && third == 0xBF)
				return IContentDescription.BOM_UTF_8;
		} else if (first == 0xFE) {
			// look for the UTF-16 BOM
			if (input.read() == 0xFF)
				return IContentDescription.BOM_UTF_16BE;
		} else if (first == 0xFF) {
			if (input.read() == 0xFE)
				return IContentDescription.BOM_UTF_16LE;
		}
		return null;
	}
}
