package org.jboss.tools.smooks.core.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.runtime.Platform;
import org.jboss.tools.smooks.test.csvparser.CsvParserTest;
import org.jboss.tools.smooks.test.ediparser.EDIParserTest;
import org.jboss.tools.smooks.test.jsonparse.JsonParserTest;
import org.jboss.tools.smooks.test.model11.BindingConfigFileTestCase;
import org.jboss.tools.smooks.test.model11.Csv2XMLConfigFileTestCase;
import org.jboss.tools.smooks.test.model11.EDI2JavaConfigFileTestCase;
import org.jboss.tools.smooks.test.model11.EdiOrderparserConfigFileTestCase;
import org.jboss.tools.smooks.test.model11.ParseConfigFileTestCase;
import org.jboss.tools.tests.AbstractPluginsLoadTest;

public class SmooksCoreAllTests extends TestCase {
	public static Test suite () {
		TestSuite suite = new TestSuite(SmooksCoreAllTests.class.getName());
		suite.addTestSuite(SmooksPluginsLoadTest.class);
		suite.addTestSuite(CsvParserTest.class);
		suite.addTestSuite(EDIParserTest.class);
		suite.addTestSuite(JsonParserTest.class);
		suite.addTestSuite(BindingConfigFileTestCase.class);
		suite.addTestSuite(Csv2XMLConfigFileTestCase.class);
		suite.addTestSuite(EDI2JavaConfigFileTestCase.class);
		suite.addTestSuite(EdiOrderparserConfigFileTestCase.class);
		suite.addTestSuite(ParseConfigFileTestCase.class);
		return suite;
	}
	
	static public class SmooksPluginsLoadTest extends AbstractPluginsLoadTest {
		
		public SmooksPluginsLoadTest() {}
		
		public void testOrgJbossToolsSmooksCorePluginIsResolvedAndActivated() {
			assertPluginResolved(Platform.getBundle("org.jboss.tools.smooks.core"));
		}
	}
}
