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
package org.jboss.tools.smooks.templating.template.result;

import java.util.List;

import org.jboss.tools.smooks.templating.template.CollectionMapping;
import org.jboss.tools.smooks.templating.template.Mapping;
import org.w3c.dom.Node;

/**
 * Add collection {@link Mapping} result.
 * 
 * @author <a href="mailto:tom.fennelly@gmail.com">tom.fennelly@gmail.com</a>
 */
public class AddCollectionResult {

	private CollectionMapping mapping;
	private List<Mapping> removeMappings;
	
	public AddCollectionResult(CollectionMapping mapping, List<Mapping> removeMappings) {
		this.mapping = mapping;
		this.removeMappings = removeMappings;
	}

	public CollectionMapping getMapping() {
		return mapping;
	}

	public List<Node> getHideNodes() {
	    return mapping.getHideNodes();
	}

	public List<Mapping> getRemoveMappings() {
		return removeMappings;
	}
}
