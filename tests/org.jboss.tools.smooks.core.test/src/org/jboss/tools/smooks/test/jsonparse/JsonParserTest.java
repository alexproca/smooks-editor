package org.jboss.tools.smooks.test.jsonparse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.emf.ecore.resource.Resource;
import org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject;
import org.jboss.tools.smooks.configuration.editors.uitls.JsonInputDataParser;
import org.jboss.tools.smooks.model.json12.Json12Reader;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;
import org.jboss.tools.smooks.model.smooks.util.SmooksResourceFactoryImpl;
import org.jboss.tools.smooks.test.model11.BaseTestCase;

public class JsonParserTest extends BaseTestCase {
	public void testParser1() throws IOException, ParserConfigurationException, InvocationTargetException {
		Resource smooksResource = new SmooksResourceFactoryImpl().createResource(null);

		smooksResource.load(JsonParserTest.class.getResourceAsStream("smooks-config.xml"), null);

		SmooksResourceListType resourceList = ((org.jboss.tools.smooks.model.smooks.DocumentRoot) smooksResource
				.getContents().get(0)).getSmooksResourceList();
		assertNotNull(resourceList);

		JsonInputDataParser parser = new JsonInputDataParser();

		Json12Reader reader = null;
		List<?> list = resourceList.getAbstractReader();
		for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			if (object instanceof Json12Reader) {
				reader = (Json12Reader) object;
			}
		}
		try {
			IXMLStructuredObject model = parser.parseJsonFile(JsonParserTest.class
					.getResourceAsStream("input-message.jsn"), reader);

			List<IXMLStructuredObject> children = model.getChildren();
			assertEquals(children.size(), 1);
			IXMLStructuredObject rootModel = children.get(0);
			checkModel(rootModel);

			parser = new JsonInputDataParser();

			model = parser.parseJsonFile(JsonParserTest.class.getResourceAsStream("input-message.jsn"), resourceList);
			children = model.getChildren();
			assertEquals(children.size(), 1);
			rootModel = children.get(0);
			checkModel(rootModel);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	private void checkModel(IXMLStructuredObject model) {
		assertEquals("root", model.getNodeName());
		assertEquals(2, model.getChildren().size());
		for (Iterator<?> iterator = model.getChildren().iterator(); iterator.hasNext();) {
			IXMLStructuredObject child = (IXMLStructuredObject) iterator.next();
			if (child.getNodeName().equals("header")) {
				List<?> list = child.getChildren();
				boolean checked = false;
				for (Iterator<?> iterator2 = list.iterator(); iterator2.hasNext();) {
					Object object = (Object) iterator2.next();
					if (object instanceof IXMLStructuredObject) {
						if (((IXMLStructuredObject) object).getNodeName().equals("date-time")
								|| ((IXMLStructuredObject) object).getNodeName().equals("timeanddate")) {
							checked = true;
						}
					}
				}
				assertEquals(checked, true);
			}
		}
	}

}
