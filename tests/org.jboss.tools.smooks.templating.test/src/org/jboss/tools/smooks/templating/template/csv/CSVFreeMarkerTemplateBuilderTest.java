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

import junit.framework.TestCase;

import org.jboss.tools.smooks.templating.model.ModelBuilderException;
import org.jboss.tools.smooks.templating.model.csv.CSVModelBuilder;
import org.jboss.tools.smooks.templating.template.exception.TemplateBuilderException;
import org.jboss.tools.smooks.templating.template.exception.UnmappedCollectionNodeException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author <a href="mailto:tom.fennelly@jboss.com">tom.fennelly@jboss.com</a>
 */
public class CSVFreeMarkerTemplateBuilderTest extends TestCase {

    public void testAllFieldsMapped01() throws TemplateBuilderException, IOException, ModelBuilderException {
        CSVModelBuilder modelBuilder = new CSVModelBuilder("firstname", "lastname", "country");
        CSVFreeMarkerTemplateBuilder builder1 = new CSVFreeMarkerTemplateBuilder(modelBuilder, ',', '\"', false);

        //System.out.println(XmlUtil.serialize(model, true));
        
        builder1.addCollectionMapping("people", getRecordElement(builder1.getModel()), "person");
        builder1.addValueMapping("person.fname", getFieldElement(builder1.getModel(), "firstname"));
        builder1.addValueMapping("person.lname", getFieldElement(builder1.getModel(), "lastname"));
        builder1.addValueMapping("person.address.country", getFieldElement(builder1.getModel(), "country"));

        String template = builder1.buildTemplate();
        System.out.println(template);
        assertEquals("<#list people as person>\n" +
                "\"${person.fname!?string}\",\"${person.lname!?string}\",\"${person.address.country!?string}\"\n" +
                "</#list>",
                template);

        CSVFreeMarkerTemplateBuilder builder2 = new CSVFreeMarkerTemplateBuilder(modelBuilder, ',', '\"', false, template);
        template = builder2.buildTemplate();
        System.out.println(template);
        assertEquals("<#list people as person>\n" +
                "\"${person.fname!?string}\",\"${person.lname!?string}\",\"${person.address.country!?string}\"\n" +
                "</#list>",
                template);
    }

    public void testAllFieldsMapped01IncludingFieldNames() throws TemplateBuilderException, IOException, ModelBuilderException {
        CSVModelBuilder modelBuilder = new CSVModelBuilder("firstname", "lastname", "country");
        CSVFreeMarkerTemplateBuilder builder1 = new CSVFreeMarkerTemplateBuilder(modelBuilder, ',', '\"', true);

        //System.out.println(XmlUtil.serialize(model, true));
        
        builder1.addCollectionMapping("people", getRecordElement(builder1.getModel()), "person");
        builder1.addValueMapping("person.fname", getFieldElement(builder1.getModel(), "firstname"));
        builder1.addValueMapping("person.lname", getFieldElement(builder1.getModel(), "lastname"));
        builder1.addValueMapping("person.address.country", getFieldElement(builder1.getModel(), "country"));

        String template = builder1.buildTemplate();
        //System.out.println(template);
        assertEquals("\"firstname\",\"lastname\",\"country\"\n" +
        		"<#list people as person>\n" +
                "\"${person.fname!?string}\",\"${person.lname!?string}\",\"${person.address.country!?string}\"\n" +
                "</#list>",
                template);

        CSVFreeMarkerTemplateBuilder builder2 = new CSVFreeMarkerTemplateBuilder(modelBuilder, ',', '\"', true, template);
        template = builder2.buildTemplate();
        //System.out.println(template);
        assertEquals("\"firstname\",\"lastname\",\"country\"\n" +
        		"<#list people as person>\n" +
                "\"${person.fname!?string}\",\"${person.lname!?string}\",\"${person.address.country!?string}\"\n" +
                "</#list>",
                template);
    }

    /**
     * Same as test above accept it uses different delimiters.
     * @throws ModelBuilderException 
     */
    public void testAllFieldsMapped02() throws TemplateBuilderException, IOException, ModelBuilderException {
        CSVModelBuilder modelBuilder = new CSVModelBuilder("firstname", "lastname", "country");
        CSVFreeMarkerTemplateBuilder builder1 = new CSVFreeMarkerTemplateBuilder(modelBuilder, '|', '\'', false);

        builder1.addCollectionMapping("people", getRecordElement(builder1.getModel()), "person");
        builder1.addValueMapping("person.fname", getFieldElement(builder1.getModel(), "firstname"));
        builder1.addValueMapping("person.lname", getFieldElement(builder1.getModel(), "lastname"));
        builder1.addValueMapping("person.address.country", getFieldElement(builder1.getModel(), "country"));

        String template = builder1.buildTemplate();
        //System.out.println(template);
        assertEquals("<#list people as person>\n" +
                "'${person.fname!?string}'|'${person.lname!?string}'|'${person.address.country!?string}'\n" +
                "</#list>",
                template);

        CSVFreeMarkerTemplateBuilder builder2 = new CSVFreeMarkerTemplateBuilder(modelBuilder, '|', '\'', false, template);
        template = builder2.buildTemplate();
        //System.out.println(template);
        assertEquals("<#list people as person>\n" +
                "'${person.fname!?string}'|'${person.lname!?string}'|'${person.address.country!?string}'\n" +
                "</#list>",
                template);
    }

    public void testAllFieldsNotMapped() throws TemplateBuilderException, ModelBuilderException {
        CSVModelBuilder modelBuilder = new CSVModelBuilder("firstname", "lastname", "country");
        CSVFreeMarkerTemplateBuilder builder;

        builder = new CSVFreeMarkerTemplateBuilder(modelBuilder, ',', '\"', false);
        
        builder.addCollectionMapping("people", getRecordElement(builder.getModel()), "person");
        builder.addValueMapping("person.fname", getFieldElement(builder.getModel(), "firstname"));
        builder.addValueMapping("person.address.country", getFieldElement(builder.getModel(), "country"));

        String template = builder.buildTemplate();
        //System.out.println(template);
        assertEquals("<#list people as person>\n" +
                "\"${person.fname!?string}\",,\"${person.address.country!?string}\"\n" +
                "</#list>",
                template);

        CSVFreeMarkerTemplateBuilder builder2 = new CSVFreeMarkerTemplateBuilder(modelBuilder, ',', '\"', false, template);
        template = builder2.buildTemplate();
        //System.out.println(template);
        assertEquals("<#list people as person>\n" +
                "\"${person.fname!?string}\",,\"${person.address.country!?string}\"\n" +
                "</#list>",
                template);

        try {
        	new CSVFreeMarkerTemplateBuilder(modelBuilder, ';', '\"', false, template);
        	fail("Expected TemplateBuilderException");
        } catch(TemplateBuilderException e) {
        	assertEquals("CSV Template fieldset size does not match that of the specified message model.  Check the supplied fieldset.  Check the specified 'separator' and 'quote' characters match those used in the template.", e.getMessage());
        }
    }

    public void testCollectionNotMapped01() throws TemplateBuilderException, ModelBuilderException {
        CSVModelBuilder modelBuilder = new CSVModelBuilder("firstname", "lastname", "country");
        CSVFreeMarkerTemplateBuilder builder;

        builder = new CSVFreeMarkerTemplateBuilder(modelBuilder, ',', '\"', false);

        try {
            // Shouldn't be able to add a value binding where the model target is inside
            // an unmapped collection...
            builder.addValueMapping("person.fname", getFieldElement(builder.getModel(), "firstname"));
            fail("Expected UnmappedCollectionNodeException");
        } catch(UnmappedCollectionNodeException e) {
            assertEquals("Unmapped collection node 'csv-record'.", e.getMessage());
        }
    }

    public void testCollectionNotMapped02() throws TemplateBuilderException, ModelBuilderException {
        CSVModelBuilder modelBuilder = new CSVModelBuilder("firstname", "lastname", "country");
        CSVFreeMarkerTemplateBuilder builder;

        builder = new CSVFreeMarkerTemplateBuilder(modelBuilder, ',', '\"', false);

        try {
            // For CSV, you need to have at least mapped the collection...
            builder.buildTemplate();
            fail("Expected UnmappedCollectionNodeException");
        } catch(UnmappedCollectionNodeException e) {
            assertEquals("Unmapped collection node 'csv-record'.", e.getMessage());
        }
    }

    private Element getRecordElement(Document model) {
        return model.getDocumentElement();
    }

    private Element getFieldElement(Document model, String fieldName) {
         return (Element) model.getElementsByTagName(fieldName).item(0);
    }
}