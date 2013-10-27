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

import org.jboss.tools.smooks.model.javabean12.BeanType;
import org.jboss.tools.smooks.model.javabean12.DecodeParamType;
import org.jboss.tools.smooks.model.javabean12.ValueType;
import org.jboss.tools.smooks.model.smooks.AbstractResourceConfig;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;


/**
 * @author Dart (dpeng@redhat.com)
 *
 */
public class BindingConfigFileTestCase extends AbstractSmooks11ModelTestCase {

	@Override
	protected String getFilePath() {
		return "org/jboss/tools/smooks/test/model/configfiles/smooks112/bindings.xml";
	}

	@Override
	public void testModel() {
		
		SmooksResourceListType resourceConfig = getSmooksResourceList11();
		
		Assert.assertNotNull(resourceConfig);
		List<AbstractResourceConfig> resourceConfigList = resourceConfig.getAbstractResourceConfig();
		
		Assert.assertEquals(3, resourceConfigList.size());
		
		BeanType bindings1 = (BeanType) resourceConfigList.get(0);
		Assert.assertEquals("message", bindings1.getBeanId());
		Assert.assertEquals("java.util.HashMap", bindings1.getClass_());
		Assert.assertEquals("message-header", bindings1.getCreateOnElement());
		
		Assert.assertEquals(1, bindings1.getValue().size());
		ValueType jb1Value = (ValueType) bindings1.getValue().get(0);
		Assert.assertEquals("date", jb1Value.getProperty().trim());
		Assert.assertEquals("message-header/date", jb1Value.getData().trim());
		Assert.assertEquals("Date", jb1Value.getDecoder().trim());
		
		DecodeParamType decode = (DecodeParamType) jb1Value.getDecodeParam().get(0);
		Assert.assertEquals("format", decode.getName());
		
		
		BeanType bindings2 = (BeanType) resourceConfigList.get(1);
		Assert.assertEquals("order", bindings2.getBeanId().trim());
		Assert.assertEquals("java.util.HashMap", bindings2.getClass_().trim());
		Assert.assertEquals("order", bindings2.getCreateOnElement().trim());
		
		
		Assert.assertEquals(5, bindings2.getValue().size());
		
		ValueType jb2Value1 =(ValueType) bindings2.getValue().get(0);
		Assert.assertEquals("orderNum", jb2Value1.getProperty().trim());
		Assert.assertEquals("order/order-id", jb2Value1.getData().trim());
		Assert.assertEquals("Integer", jb2Value1.getDecoder().trim());
		
		ValueType jb2Value2 = (ValueType)bindings2.getValue().get(1);
		Assert.assertEquals("customerUname", jb2Value2.getProperty().trim());
		Assert.assertEquals("order/customer-details/username", jb2Value2.getData().trim());
		
		ValueType jb2Value3 =(ValueType) bindings2.getValue().get(2);
		Assert.assertEquals("status", jb2Value3.getProperty().trim());
		Assert.assertEquals("order/status-code", jb2Value3.getData().trim());
		Assert.assertEquals("Integer", jb2Value3.getDecoder().trim());
		
		
		ValueType jb2Value4 =(ValueType) bindings2.getValue().get(3);
		Assert.assertEquals("net", jb2Value4.getProperty().trim());
		Assert.assertEquals("order/net-amount", jb2Value4.getData().trim());
		Assert.assertEquals("BigDecimal", jb2Value4.getDecoder().trim());
		
		
		ValueType jb2Value5 =(ValueType) bindings2.getValue().get(4);
		Assert.assertEquals("total", jb2Value5.getProperty().trim());
		Assert.assertEquals("order/total-amount", jb2Value5.getData().trim());
		Assert.assertEquals("BigDecimal", jb2Value5.getDecoder().trim());
		
		BeanType bindings3 = (BeanType) resourceConfigList.get(2);
		Assert.assertEquals("orderItem", bindings3.getBeanId().trim());
		Assert.assertEquals("java.util.HashMap", bindings3.getClass_().trim());
		Assert.assertEquals("order-item", bindings3.getCreateOnElement().trim());
		
		
		Assert.assertEquals(1, bindings3.getValue().size());
		
		ValueType jb3Value1 =(ValueType) bindings3.getValue().get(0);
		Assert.assertEquals("order-item/*", jb3Value1.getData().trim());
		
	}

}
