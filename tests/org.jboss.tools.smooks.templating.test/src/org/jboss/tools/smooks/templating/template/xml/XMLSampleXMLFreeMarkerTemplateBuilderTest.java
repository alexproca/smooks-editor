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

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import junit.framework.TestCase;

import org.jboss.tools.smooks.templating.model.ModelBuilderException;
import org.jboss.tools.smooks.templating.template.CollectionMapping;
import org.jboss.tools.smooks.templating.template.TemplateBuilder;
import org.jboss.tools.smooks.templating.template.TestUtil;
import org.jboss.tools.smooks.templating.template.ValueMapping;
import org.jboss.tools.smooks.templating.template.exception.TemplateBuilderException;
import org.jboss.tools.smooks.templating.template.result.AddCollectionResult;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * @author <a href="mailto:tom.fennelly@jboss.com">tom.fennelly@jboss.com</a>
 */
public class XMLSampleXMLFreeMarkerTemplateBuilderTest extends TestCase {

	public void testXMLOrder01() throws IOException, ParserConfigurationException, TemplateBuilderException, SAXException, ModelBuilderException, XPathExpressionException {
		TemplateBuilder builder = TestUtil.createXMLSampleFreeMarkerTemplateBuilder(new File("src/org/jboss/tools/smooks/templating/template/xml/order-status-01.xml"));
		
		Node identNode = builder.getModelNode("ns0:OrderStatusResult/ns0:OrderStatusResultHeader/ns0:BuyerParty/ns1:PartyID/ns1:Ident");		
		builder.addValueMapping("order.status.id", identNode);

		String theTemplate = builder.buildTemplate();

//		System.out.println(theTemplate);
		TestUtil.assertXMLEquals(theTemplate, "expected/order-status-expected-01.xml", getClass());

		// Now, test that we can parse the template ....
		XMLFreeMarkerTemplateBuilder builder2 = new XMLFreeMarkerTemplateBuilder(builder.getModelBuilder(), theTemplate);
		assertEquals(theTemplate, builder2.buildTemplate());
	}

	public void testXMLOrder02() throws IOException, ParserConfigurationException, TemplateBuilderException, SAXException, ModelBuilderException, XPathExpressionException {
		TemplateBuilder builder = TestUtil.createXMLSampleFreeMarkerTemplateBuilder(new File("src/org/jboss/tools/smooks/templating/template/xml/order-status-01.xml"));
		
		Node identNode = builder.getModelNode("ns0:OrderStatusResult/ns0:OrderStatusResultHeader/ns0:BuyerParty/ns1:PartyID/ns1:Ident");		
		Element resultStatusCollectionNode = (Element) builder.getModelNode("ns0:OrderStatusResult/ns0:ListOfOrderStatusResultDetail/ns0:OrderStatusResultDetail");		
		Node buyerRefNumberNode = builder.getModelNode("ns0:OrderStatusResult/ns0:ListOfOrderStatusResultDetail/ns0:OrderStatusResultDetail/ns0:OrderStatusResultReference/ns0:BuyerReferenceNumber");		

		builder.addValueMapping("order.status.id", identNode);
		builder.addCollectionMapping("order.orderItemsStatusList", resultStatusCollectionNode, "itemStatus");
		builder.addValueMapping("itemStatus.buyerRefNumber", buyerRefNumberNode);

		String theTemplate = builder.buildTemplate();

//		System.out.println(theTemplate);
		TestUtil.assertEquals(theTemplate, "expected/order-status-expected-02.xml", getClass());

		// Now, test that we can parse the template ....
		XMLFreeMarkerTemplateBuilder builder2 = new XMLFreeMarkerTemplateBuilder(builder.getModelBuilder(), theTemplate);
		assertEquals(theTemplate, builder2.buildTemplate());
	}

	public void testXMLOrder03() throws IOException, ParserConfigurationException, TemplateBuilderException, SAXException, ModelBuilderException, XPathExpressionException {
		TemplateBuilder builder = TestUtil.createXMLSampleFreeMarkerTemplateBuilder(new File("src/org/jboss/tools/smooks/templating/template/xml/order-status-01.xml"));
		
		Node identNode = builder.getModelNode("ns0:OrderStatusResult/ns0:OrderStatusResultHeader/ns0:BuyerParty/ns1:PartyID/ns1:Ident");		
		Element resultStatusCollectionNode = (Element) builder.getModelNode("ns0:OrderStatusResult/ns0:ListOfOrderStatusResultDetail/ns0:OrderStatusResultDetail");		
		Node buyerRefNumberNode = builder.getModelNode("ns0:OrderStatusResult/ns0:ListOfOrderStatusResultDetail/ns0:OrderStatusResultDetail/ns0:OrderStatusResultReference/ns0:BuyerReferenceNumber");		

		builder.addValueMapping("order.status.id", identNode);
		ValueMapping refNumMapping = builder.addValueMapping("order.orderItemsStatusList.buyerRefNumber", buyerRefNumberNode);

		// Adding the collection mapping after the refNumMapping should result in an instruction (in the collectionMapping) 
		// to remove the refNumMapping...
		AddCollectionResult collectionMapping = builder.addCollectionMapping("order.orderItemsStatusList", resultStatusCollectionNode, "itemStatus");
		assertTrue(collectionMapping.getRemoveMappings().contains(refNumMapping));
	}
}
