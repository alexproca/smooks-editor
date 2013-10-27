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

import org.jboss.tools.smooks.model.filters.FreemarkerFilter;
import org.jboss.tools.smooks.model.filters.ResourceConfigFilter;
import org.milyn.delivery.DomModelCreator;

/**
 * Model Filters.
 * @author <a href="mailto:tom.fennelly@gmail.com">tom.fennelly@gmail.com</a>
 */
public class ModelFilter {

	public static final ResourceConfigFilter DomModelCreator = new ResourceConfigFilter().selector("#document").resource(DomModelCreator.class);
	public static final FreemarkerFilter Freemarker = new FreemarkerFilter();
		
}
