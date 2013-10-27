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

import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.DataHolder;
import com.thoughtworks.xstream.core.ReferenceByXPathMarshallingStrategy;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;

/**
 * 
 * @author <a href="mailto:tom.fennelly@jboss.com">tom.fennelly@jboss.com</a>
 */
public class MarshallingStrategy extends ReferenceByXPathMarshallingStrategy {

	private ObjectSerializer objectSerializer;

	/**
	 * @param objectSerializer
	 */
	public MarshallingStrategy(ObjectSerializer objectSerializer) {
		this.objectSerializer = objectSerializer;
	}

	/* (non-Javadoc)
	 * @see com.thoughtworks.xstream.core.ReferenceByXPathMarshallingStrategy#marshal(com.thoughtworks.xstream.io.HierarchicalStreamWriter, java.lang.Object, com.thoughtworks.xstream.converters.ConverterLookup, com.thoughtworks.xstream.mapper.Mapper, com.thoughtworks.xstream.converters.DataHolder)
	 */
	@Override
	public void marshal(HierarchicalStreamWriter writer, Object obj, ConverterLookup converterLookup, Mapper mapper, DataHolder dataHolder) {
		XPathMarshaller marshaller = new XPathMarshaller(writer, converterLookup, mapper, ReferenceByXPathMarshallingStrategy.RELATIVE, objectSerializer);
        marshaller.start(obj, dataHolder);
	}
}
