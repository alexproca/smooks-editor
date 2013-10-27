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
package org.jboss.tools.smooks.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.jboss.tools.smooks.model.smooks.AbstractResourceConfig;
import org.jboss.tools.smooks.model.smooks.ParamType;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;

/**
 * Model resource filter.
 * @author <a href="mailto:tom.fennelly@gmail.com">tom.fennelly@gmail.com</a>
 */
public abstract class ResourceFilter<T extends AbstractResourceConfig> {

	private Class<T> filterResourceType;
	
	public ResourceFilter(Class<T> filterResourceType) {
		if(filterResourceType == null) {
			throw new IllegalArgumentException("arg 'filterResourceType' is null.");
		}
		this.filterResourceType = filterResourceType;
	}

	/**
	 * Add the supplied resource to the result set returned by the
	 * {@link #execute(SmooksResourceListType)} method.
	 * 
	 * @param resource The resource.
	 * @return True if the resource is to be added, otherwise false.
	 */
	public abstract boolean accept(T resource);
	
	/**
	 * Execute the filter.
	 * @param resourceList The resource list.
	 * @return The filtered resource result set.
	 */
	public List<T> execute(SmooksResourceListType resourceList) {
		List<T> resultSet = new ArrayList<T>();
		
		for(AbstractResourceConfig abstractResourceConfig : resourceList.getAbstractResourceConfig()) {
			if(filterResourceType.isInstance(abstractResourceConfig)) {
				T resourceInstance = filterResourceType.cast(abstractResourceConfig);
				if(accept(resourceInstance)) {
					resultSet.add(resourceInstance);
				}
			}
		}
		
		return resultSet;		
	}

	protected boolean hasParams(EList<ParamType> paramList, Map<String, String> requiredParams) {
		Set<Entry<String, String>> paramsEntries = requiredParams.entrySet();
		
		for(Entry<String, String> param : paramsEntries) {
			if(!hasParam(paramList, param.getKey(), param.getValue())) {
				return false;
			}
		}
		
		return true;
	}

	protected boolean hasParam(EList<ParamType> paramList, String name, String value) {
		for(ParamType param : paramList) {
			if(param.getName().equals(name) && param.getStringValue().equals(value)) {
				return true;
			}
		}
		
		return false;
	}
}
