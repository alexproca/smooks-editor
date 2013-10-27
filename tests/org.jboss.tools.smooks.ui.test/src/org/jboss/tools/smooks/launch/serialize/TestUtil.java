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
package org.jboss.tools.smooks.launch.serialize;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;

import junit.framework.TestCase;

import org.custommonkey.xmlunit.XMLAssert;
import org.custommonkey.xmlunit.XMLUnit;
import org.milyn.io.StreamUtils;
import org.milyn.xml.XmlUtil;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * @author <a href="mailto:tom.fennelly@jboss.com">tom.fennelly@jboss.com</a>
 */
public abstract class TestUtil {

	public static void assertXMLEquals(String xmlText, String xmlFileOnCP, Class refClass) throws IOException, SAXException {
    	//System.out.println(xmlText);
        XMLUnit.setIgnoreWhitespace( true );
        XMLAssert.assertXMLEqual(new InputStreamReader(refClass.getResourceAsStream(xmlFileOnCP)), new StringReader(xmlText));		
	}

	public static void assertEquals(String text, String fileOnCP, Class refClass) throws IOException, SAXException {
    	//System.out.println(text);
    	String fileContents = readFileContents(fileOnCP, refClass);
    	TestCase.assertEquals(normalizeCRLF(fileContents.trim()), normalizeCRLF(text.trim()));
	}

	public static String readFileContents(String fileOnCP, Class refClass) throws IOException {
		return StreamUtils.readStreamAsString(refClass.getResourceAsStream(fileOnCP));
	}

	public static String normalizeCRLF(String text) {
		text = text.replace("\r\n", "\n");
		text = text.replace("\n\r", "\n");
		text = text.replace("\r", "\n");
		return text;
	}

	public static Document toDOM(String theTemplate) throws ParserConfigurationException, IOException, SAXException {
		return XmlUtil.parseStream(new ByteArrayInputStream(theTemplate.getBytes()));
	}
}
