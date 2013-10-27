package org.jboss.tools.smooks.templating.template;

import org.jboss.tools.smooks.templating.template.csv.CSVFreeMarkerTemplateBuilderTest;
import org.jboss.tools.smooks.templating.template.xml.XMLSampleXMLFreeMarkerTemplateBuilderTest;
import org.jboss.tools.smooks.templating.template.xml.XSDXMLFreeMarkerTemplateBuilderTest;

import junit.framework.Test;
import junit.framework.TestSuite;

public class SmooksTemplatingTestSuite {
	public static Test suite() {
		TestSuite suite = new TestSuite("Smooks Templating Tests");

		suite.addTestSuite(CSVFreeMarkerTemplateBuilderTest.class);
		suite.addTestSuite(XMLSampleXMLFreeMarkerTemplateBuilderTest.class);
		suite.addTestSuite(XSDXMLFreeMarkerTemplateBuilderTest.class);

		return suite;
	}
}
