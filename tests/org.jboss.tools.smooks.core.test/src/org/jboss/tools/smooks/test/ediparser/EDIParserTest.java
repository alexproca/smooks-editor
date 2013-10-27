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
package org.jboss.tools.smooks.test.ediparser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.emf.ecore.resource.Resource;
import org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject;
import org.jboss.tools.smooks.configuration.editors.edireader12.EDIDataParser;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.configuration.editors.xml.TagList;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;
import org.jboss.tools.smooks.model.smooks.util.SmooksResourceFactoryImpl;
import org.jboss.tools.smooks.test.model11.BaseTestCase;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class EDIParserTest extends BaseTestCase {

	public void testEDIParser() throws IOException,  ParserConfigurationException {

		Resource smooksResource = new SmooksResourceFactoryImpl().createResource(null);

		smooksResource.load(EDIParserTest.class.getResourceAsStream("smooks-config.xml"), null);

		SmooksResourceListType resourceList = ((org.jboss.tools.smooks.model.smooks.DocumentRoot) smooksResource
				.getContents().get(0)).getSmooksResourceList();
		assertNotNull(resourceList);

		EDIDataParser parser = new EDIDataParser();
		TagList tagList = parser.parseEDIFile(EDIParserTest.class.getResourceAsStream("input-message.edi"),
				resourceList);
		assertNotNull(tagList);
		List<String> namesList = new ArrayList<String>();
		namesList.add("Orderaaa");
		checkTagList1(tagList.getChildren(), namesList, new String[] { "header", "customer-details", "order-item" });
	}

	private void checkChildrenNode(String requiredSelector, String nodeName, IXMLStructuredObject tag) {
		IXMLStructuredObject node1 = SmooksUIUtils.localXMLNodeWithNodeName(nodeName, tag);
		assertNotNull(node1);
		String selector = SmooksUIUtils.generateFullPath(node1, "/");
		assertEquals(requiredSelector, selector);
	}

	private void checkTagList1(List<?> tagList, List<String> requiredRootTagName, String[] childrenNodesNames) {
		for (Iterator<?> iterator = tagList.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			if (object instanceof IXMLStructuredObject) {
				IXMLStructuredObject tag = (IXMLStructuredObject) object;
				assertEquals(requiredRootTagName.get(tagList.indexOf(tag)), tag.getNodeName());
				String n = SmooksUIUtils.generateFullPath(tag, "/");
				for (int i = 0; i < childrenNodesNames.length; i++) {
					checkChildrenNode("/" + n + "/" + childrenNodesNames[i], childrenNodesNames[i], tag);
				}
			}
		}
	}
}
