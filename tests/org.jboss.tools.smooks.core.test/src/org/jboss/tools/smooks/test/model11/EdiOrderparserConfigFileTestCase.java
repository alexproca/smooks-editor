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
package org.jboss.tools.smooks.test.model11;

import java.util.List;

import junit.framework.Assert;

import org.jboss.tools.smooks.model.edi12.EDI12Reader;
import org.jboss.tools.smooks.model.smooks.AbstractReader;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;


/**
 * @author Dart (dpeng@redhat.com)
 *
 */
public class EdiOrderparserConfigFileTestCase extends AbstractSmooks11ModelTestCase {

	@Override
	protected String getFilePath() {
		return "org/jboss/tools/smooks/test/model/configfiles/smooks112/edi-orders-parser.xml";
	}

	@Override
	public void testModel() {
		SmooksResourceListType resourceConfig = getSmooksResourceList11();
		
		Assert.assertNotNull(resourceConfig);
		List<AbstractReader> readerList = resourceConfig.getAbstractReader();
		Assert.assertEquals(readerList.size(), 1);
		
		EDI12Reader reader = (EDI12Reader) readerList.get(0);
		
		Assert.assertEquals("/edi-to-sax-order-mapping.xml", reader.getMappingModel());
	}

}
