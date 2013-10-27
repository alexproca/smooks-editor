/**
 * JBoss, Home of Professional Open Source
 * Copyright 2009, JBoss Inc., and others contributors as indicated
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
 * (C) 2009, JBoss Inc.
 */
package org.jboss.tools.smooks.launch.serialize;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.milyn.payload.JavaResult;
import org.xml.sax.SAXException;

import junit.framework.TestCase;

/**
 * 
 *
 * @author <a href="mailto:tom.fennelly@jboss.com">tom.fennelly@jboss.com</a>
 */
public class ObjectSerializerTest extends TestCase {
	
	public void test() throws IOException, SAXException {
		Map<String, Object> beanContext = new HashMap<String, Object>();
		Order order = new Order();
		List<OrderItem> items = order.getOrderItems();
		
		beanContext.put("order", order);
		beanContext.put("header", order.getHeader());
		beanContext.put("orderItems", items);
		
		items.add(new OrderItem().setProductId(55126).setQuantity(6).setPrice(65.98));
		items.add(new OrderItem().setProductId(23423).setQuantity(3).setPrice(8.42));
		items.add(new OrderItem().setProductId(45645).setQuantity(7).setPrice(999.00));
		
		beanContext.put("orderItem", items.get(items.size() - 1));
		
		JavaResult javaResult = new JavaResult(beanContext);
		
		Collection<ObjectSerializer> rootBeans = ObjectSerializer.serialize(javaResult);
		
		// ObjectSerializer should work out that there's just 1 root 
		// bean i.e. the "order" bean...
		assertEquals(1, rootBeans.size());
		for(ObjectSerializer serializer : rootBeans) {
			//System.out.println(serializer.getSerializedForm());
			TestUtil.assertEquals(serializer.getSerializedForm(), "expected-01.txt", getClass());
			assertEquals("[header, orderItems, orderItem]", serializer.getReferencedBeans().toString());
		}
	}
}
