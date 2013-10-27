/*******************************************************************************
 * Copyright (c) 2009 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.smooks.model.filters;

import java.util.LinkedHashMap;
import java.util.Map;

import org.jboss.tools.smooks.model.ResourceFilter;
import org.jboss.tools.smooks.model.smooks.ResourceConfigType;
import org.jboss.tools.smooks.model.smooks.ResourceType;

/**
 * Filter for {@link ResourceConfigType} resources.
 * @author <a href="mailto:tom.fennelly@gmail.com">tom.fennelly@gmail.com</a>
 */
public class ResourceConfigFilter extends ResourceFilter<ResourceConfigType> {

	private String selector;
	private String resource;
	private Map<String, String> params;
	
	public ResourceConfigFilter() {
		super(ResourceConfigType.class);
	}

	public ResourceConfigFilter selector(String selector) {
		this.selector = selector;
		return this;
	}

	public ResourceConfigFilter resource(String resource) {
		this.resource = resource;
		return this;
	}

	public ResourceConfigFilter resource(Class<?> resource) {
		this.resource = resource.getName();
		return this;
	}

	public ResourceConfigFilter param(String name, String value) {
		if(params == null) {
			params = new LinkedHashMap<String, String>();
		}
		params.put(name, value);
		return this;
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks10.model.smooks.util.ResourceFilter#accept(org.jboss.tools.smooks.model.smooks.AbstractResourceConfig)
	 */
	@Override
	public boolean accept(ResourceConfigType resourceType) {
		if(selector != null && !selector.equals(resourceType.getSelector())) {
			return false;
		} 
		if(resource != null) {
			ResourceType resourceObj = resourceType.getResource();
			if(resourceObj == null || !resourceObj.getValue().equals(resource)) {
				return false;
			}
		}
		if(params != null) {
			if(!hasParams(resourceType.getParam(), params)) {
				return false;
			}
		}
		
		return true;
	}
}
