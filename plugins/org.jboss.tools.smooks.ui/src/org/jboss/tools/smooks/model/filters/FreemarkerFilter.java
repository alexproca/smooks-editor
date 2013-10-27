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

import java.util.ArrayList;
import java.util.List;

import org.jboss.tools.smooks.model.ResourceFilter;
import org.jboss.tools.smooks.model.freemarker.Freemarker;

/**
 * Filter for {@link Freemarker} resources.
 * @author <a href="mailto:tom.fennelly@gmail.com">tom.fennelly@gmail.com</a>
 */
public class FreemarkerFilter extends ResourceFilter<Freemarker> {

	private List<Freemarker> excludes;
	
	public FreemarkerFilter() {
		super(Freemarker.class);
	}
	
	public FreemarkerFilter addExclude(Freemarker exclude) {
		if(excludes == null) {
			excludes = new ArrayList<Freemarker>();
		}
		excludes.add(exclude);
		return this;
	}

	@Override
	public boolean accept(Freemarker resource) {
		if(excludes != null) {
			for(Freemarker exclude : excludes) {
				if(resource == exclude) { 
					return false;
				}
			}
		}
		return true;
	}
}
