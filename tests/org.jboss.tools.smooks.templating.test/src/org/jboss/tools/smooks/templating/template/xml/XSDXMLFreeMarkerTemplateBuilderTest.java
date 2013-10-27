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
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.jboss.tools.smooks.templating.model.ModelBuilderException;
import org.jboss.tools.smooks.templating.model.xml.XSDModelBuilder;
import org.jboss.tools.smooks.templating.template.Mapping;
import org.jboss.tools.smooks.templating.template.TemplateBuilder;
import org.jboss.tools.smooks.templating.template.TestUtil;
import org.jboss.tools.smooks.templating.template.exception.TemplateBuilderException;
import org.jboss.tools.smooks.templating.template.exception.UnmappedCollectionNodeException;
import org.milyn.util.FreeMarkerTemplate;
import org.milyn.xml.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author <a href="mailto:tom.fennelly@jboss.com">tom.fennelly@jboss.com</a>
 */
public class XSDXMLFreeMarkerTemplateBuilderTest extends TestCase {
	
	public void testSimplePerson01() throws IOException, ParserConfigurationException, TemplateBuilderException,
			SAXException, ModelBuilderException {
		TemplateBuilder builder = TestUtil.createXSDFreeMarkerTemplateBuilder(new File(
				"src/org/jboss/tools/smooks/templating/template/xml/simple-person.xsd"), "person");
		String theTemplate = builder.buildTemplate();

		System.out.println(theTemplate);
		TestUtil.assertXMLEquals(theTemplate, "expected/simple-person-01.xml", getClass());

		// Now, test that we can parse the template ....
		XMLFreeMarkerTemplateBuilder builder2 = new XMLFreeMarkerTemplateBuilder(builder.getModelBuilder(), theTemplate);
		assertEquals(theTemplate, builder2.buildTemplate());
	}

	public void testSimplePerson02() throws IOException, ParserConfigurationException, TemplateBuilderException,
			SAXException, ModelBuilderException, XPathExpressionException {
		TemplateBuilder builder = TestUtil.createXSDFreeMarkerTemplateBuilder(new File(
				"src/org/jboss/tools/smooks/templating/template/xml/simple-person.xsd"), "person");

		builder.addValueMapping("male", builder.getModelNode("ns0:person/name/smk:compositor/male"));
		builder.addValueMapping("firstName", builder.getModelNode("ns0:person/name/@first"));
		builder.addValueMapping("lastName", builder.getModelNode("ns0:person/name/@last"));
		builder.addValueMapping("address", builder.getModelNode("ns0:person/address"));
		builder.addValueMapping("age", builder.getModelNode("ns0:person/age"));

		Map javaCtx = createPersonObj("Tom", "Fennelly", "Ireland", 21);
		String template = builder.buildTemplate();
		// System.out.println(template);
		FreeMarkerTemplate freemarker = new FreeMarkerTemplate(template);
		String templateRes = freemarker.apply(javaCtx);

		TestUtil.assertXMLEquals(templateRes, "expected/simple-person-02.xml", getClass());
		TestUtil.validate(builder, templateRes);

		// Now, test that we can parse the template and extract the mappings
		// from it....
		XMLFreeMarkerTemplateBuilder builder2 = new XMLFreeMarkerTemplateBuilder(builder.getModelBuilder(), template);
		assertEquals(5, builder2.getMappings().size());
		assertEquals(template, builder2.buildTemplate());
	}

	public void testPeople01() throws IOException, ParserConfigurationException, TemplateBuilderException,
			SAXException, ModelBuilderException, XPathExpressionException {
		TemplateBuilder builder = TestUtil.createXSDFreeMarkerTemplateBuilder(new File(
				"src/org/jboss/tools/smooks/templating/template/xml/people.xsd"), "people");

		// Try adding a value mapping before adding the collection mapping.
		// Should get an exception...
		try {
			builder.addValueMapping("personObj.firtName", builder.getModelNode("ns0:people/person/name/@first"));
			fail("Expected UnmappedCollectionNodeException");
		} catch (UnmappedCollectionNodeException e) {
			assertEquals("Unmapped collection node 'person'.", e.getMessage());
		}
	}

	public void testPeople02() throws IOException, ParserConfigurationException, TemplateBuilderException,
			SAXException, ModelBuilderException, XPathExpressionException {
		TemplateBuilder builder = TestUtil.createXSDFreeMarkerTemplateBuilder(new File(
				"src/org/jboss/tools/smooks/templating/template/xml/people.xsd"), "people");

		builder.addCollectionMapping("people", (Element) builder.getModelNode("ns0:people/person"), "personObj");
		builder.addValueMapping("personObj.male", builder.getModelNode("ns0:people/person/name/smk:compositor/male"));
		builder.addValueMapping("personObj.firstName", builder.getModelNode("ns0:people/person/name/@first"));
		builder.addValueMapping("personObj.lastName", builder.getModelNode("ns0:people/person/name/@last"));
		builder.addValueMapping("personObj.address", builder.getModelNode("ns0:people/person/address"));
		builder.addValueMapping("personObj.age", builder.getModelNode("ns0:people/person/age"));

		assertEquals(6, builder.getMappings().size());

		Map javaCtx = new HashMap();
		List people = new ArrayList();
		people.add(createPersonObj("Tom", "Fennelly", "Ireland", 6));
		people.add(createPersonObj("Mike", "Fennelly", "Ireland", 5));
		javaCtx.put("people", people);

		String template = builder.buildTemplate();

		FreeMarkerTemplate freemarker = new FreeMarkerTemplate(template);
		String templateRes = freemarker.apply(javaCtx);

		TestUtil.assertXMLEquals(templateRes, "expected/people-01.xml", getClass());

		// Now, test that we can parse the template and extract the mappings
		// from it....
		XMLFreeMarkerTemplateBuilder builder2 = new XMLFreeMarkerTemplateBuilder(builder.getModelBuilder(), template);
		assertEquals(6, builder2.getMappings().size());
		assertEquals(template, builder2.buildTemplate());
	}

	public void testElementName() throws IOException, ModelBuilderException {
		File xsdFile = new File("src/org/jboss/tools/smooks/templating/template/xml/smooks1_0.xsd");
		URI uri = URI.createFileURI(xsdFile.getCanonicalFile().toString());
		XSDModelBuilder builder = new XSDModelBuilder(uri);
		builder.setRootElementName("smooks-resource-list");
		XMLFreeMarkerTemplateBuilder templateBuilder = new XMLFreeMarkerTemplateBuilder(builder);
		Document document = templateBuilder.getModel();
		
		StringWriter writer = new StringWriter();
		XmlUtil.serialize(document, true, writer);
		System.out.println(writer);
		//checkNodeName(document.getDocumentElement());
	}

	public void testCreature01() throws IOException, ParserConfigurationException, TemplateBuilderException,
			SAXException, ModelBuilderException, XPathExpressionException {
		TemplateBuilder builder = TestUtil.createXSDFreeMarkerTemplateBuilder(new File(
				"src/org/jboss/tools/smooks/templating/template/xml/creature.xsd"), "creature");

		Mapping mapping = builder.addValueMapping("dog", builder.getModelNode("ns0:creature/smk:compositor/dog/@name"));

		// The mapping onto the <dog> node should result in the <person> and
		// <cat> nodes being hidden...
		assertEquals(2, mapping.getHideNodes().size());
		assertEquals(builder.getModelNode("ns0:creature/smk:compositor/person"), mapping.getHideNodes().get(0));
		assertEquals(builder.getModelNode("ns0:creature/smk:compositor/cat"), mapping.getHideNodes().get(1));

		String theTemplate = builder.buildTemplate();
		TestUtil.assertXMLEquals(theTemplate, "expected/creature-01.xml", getClass());
		TestUtil.validate(builder, theTemplate);

		// Now, test that we can parse the template and extract the mappings
		// from it....
		XMLFreeMarkerTemplateBuilder builder2 = new XMLFreeMarkerTemplateBuilder(builder.getModelBuilder(), theTemplate);
		assertEquals(theTemplate, builder2.buildTemplate());

		// ========================================================

		// Remove the <dog> mapping... should reshow the <person> and <cat>
		// nodes...
		List<Node> showNodes = builder.removeMapping(mapping).getShowNodes();
		assertEquals(2, showNodes.size());
		assertEquals(builder.getModelNode("ns0:creature/smk:compositor/person"), showNodes.get(0));
		assertEquals(builder.getModelNode("ns0:creature/smk:compositor/cat"), showNodes.get(1));

		mapping = builder.addValueMapping("cat", builder.getModelNode("ns0:creature/smk:compositor/cat"));

		// The mapping onto the <cat> node should result in the <person> and
		// <dog> nodes being hidden...
		assertEquals(2, mapping.getHideNodes().size());
		assertEquals(builder.getModelNode("ns0:creature/smk:compositor/dog"), mapping.getHideNodes().get(0));
		assertEquals(builder.getModelNode("ns0:creature/smk:compositor/person"), mapping.getHideNodes().get(1));

		theTemplate = builder.buildTemplate();
		TestUtil.assertXMLEquals(theTemplate, "expected/creature-02.xml", getClass());
		TestUtil.validate(builder, theTemplate);

		// Now, test that we can parse the template and extract the mappings
		// from it....
		builder2 = new XMLFreeMarkerTemplateBuilder(builder.getModelBuilder(), theTemplate);
		assertEquals(theTemplate, builder2.buildTemplate());

		// ========================================================

		// Remove the <cat> mapping... should reshow the <person> and <dog>
		// nodes...
		showNodes = builder.removeMapping(mapping).getShowNodes();
		assertEquals(2, showNodes.size());
		assertEquals(builder.getModelNode("ns0:creature/smk:compositor/dog"), showNodes.get(0));
		assertEquals(builder.getModelNode("ns0:creature/smk:compositor/person"), showNodes.get(1));

		// Map the person... there are nested choice compositors on this one...
		mapping = builder.addValueMapping("male", builder
				.getModelNode("ns0:creature/smk:compositor/person/name/smk:compositor/male"));
		builder.addValueMapping("firstName", builder.getModelNode("ns0:creature/smk:compositor/person/name/@first"));
		builder.addValueMapping("lastName", builder.getModelNode("ns0:creature/smk:compositor/person/name/@last"));
		builder.addValueMapping("address", builder.getModelNode("ns0:creature/smk:compositor/person/address"));
		builder.addValueMapping("age", builder.getModelNode("ns0:creature/smk:compositor/person/age"));

		// The mapping onto the <person> node should result in the <female>,
		// <dog> and <cat> nodes being hidden...
		assertEquals(3, mapping.getHideNodes().size());
		assertEquals(builder.getModelNode("ns0:creature/smk:compositor/person/name/smk:compositor/female"), mapping
				.getHideNodes().get(0));
		assertEquals(builder.getModelNode("ns0:creature/smk:compositor/dog"), mapping.getHideNodes().get(1));
		assertEquals(builder.getModelNode("ns0:creature/smk:compositor/cat"), mapping.getHideNodes().get(2));

		theTemplate = builder.buildTemplate();
		TestUtil.assertXMLEquals(theTemplate, "expected/creature-03.xml", getClass());

		// Now, test that we can parse the template and extract the mappings
		// from it....
		builder2 = new XMLFreeMarkerTemplateBuilder(builder.getModelBuilder(), theTemplate);
		assertEquals(theTemplate, builder2.buildTemplate());
	}

	 public void testOrderStatusRequest() throws IOException, ParserConfigurationException, ModelBuilderException, SAXException, TemplateBuilderException {
		 TemplateBuilder builder = TestUtil.createXSDFreeMarkerTemplateBuilder(new
		 File("resources/xcbl40/schema/org/xcbl/path_delim/schemas/xcbl/v4_0/ordermanagement/v1_0/ordermanagement.xsd"), "OrderStatusResult");
		 String theTemplate = builder.buildTemplate();
		
		 System.out.println(theTemplate);
		 TestUtil.assertXMLEquals(theTemplate, "expected/order-status-01.xml", getClass());
	 }

	private Map createPersonObj(String first, String last, String address, int age) {
		Map javaCtx = new HashMap();
		javaCtx.put("male", true);
		javaCtx.put("firstName", first);
		javaCtx.put("lastName", last);
		javaCtx.put("address", address);
		javaCtx.put("age", age);
		return javaCtx;
	}

	private void printModel(TemplateBuilder builder) {
		System.out.println(XmlUtil.serialize(builder.getModel(), true));
	}
}
