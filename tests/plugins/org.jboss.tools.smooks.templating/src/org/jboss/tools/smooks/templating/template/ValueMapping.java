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
package org.jboss.tools.smooks.templating.template;

import java.util.Properties;

import org.w3c.dom.Node;

/**
 * Model template value mapping.
 *
 * @author <a href="mailto:tom.fennelly@jboss.com">tom.fennelly@jboss.com</a>
 */
public class ValueMapping extends Mapping {
	
	public static final String RAW_FORMATING_KEY = ValueMapping.class.getName() + "#RAW_FORMATING_KEY"; //$NON-NLS-1$
	
	private Class<?> valueType;
	private Properties encodeProperties;

	/**
     * Public constructor.
     * @param srcPath Source path.
     * @param mappingNode The mapping node.
     */
    public ValueMapping(String srcPath, Node mappingNode) {
    	super(srcPath, mappingNode);
    }

    /**
     * Get the data type associated with the mapping value.
	 * @return The mapping value type, or null if not defined.
	 */
	public Class<?> getValueType() {
		return valueType;
	}

	/**
     * Set the data type associated with the mapping value.
	 * @param valueType The mapping value type.
	 */
	public void setValueType(Class<?> valueType) {
		this.valueType = valueType;
	}

	/**
	 * Get the data value templating encoding properties.
	 * @return The data value templating encoding properties, or null if not defined.
	 */
	public Properties getEncodeProperties() {
		return encodeProperties;
	}

	/**
	 * Set the data value templating encoding properties.
	 * @param encodeProperties The data value templating encoding properties.
	 */
	public void setEncodeProperties(Properties encodeProperties) {
		this.encodeProperties = encodeProperties;
	}
}
