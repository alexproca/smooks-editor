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

import org.jboss.tools.smooks.templating.template.Mapping;
import org.w3c.dom.Node;

/**
 * Remove {@link Mapping} result.
 * 
 * @author <a href="mailto:tom.fennelly@gmail.com">tom.fennelly@gmail.com</a>
 */
public class RemoveResult {

	private List<Mapping> removeMappings;
	private List<Node> showNodes;

	public RemoveResult(List<Mapping> removeMappings, List<Node> showNodes) {
		this.removeMappings = removeMappings;
		this.showNodes = showNodes;
	}

	public List<Mapping> getRemoveMappings() {
		return removeMappings;
	}

	public List<Node> getShowNodes() {
		return showNodes;
	}	
}
