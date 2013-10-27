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
package org.jboss.tools.smooks.graphical.editors.model.freemarker;

import java.util.List;

import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;
import org.jboss.tools.smooks.templating.template.Mapping;

/**
 * @author Dart
 *
 */
public class FreemarkerTemplateConnection extends TreeNodeConnection {
	protected List<Mapping> removeMappings;

	
	
	
	public FreemarkerTemplateConnection() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FreemarkerTemplateConnection(
			AbstractSmooksGraphicalModel sourceNode,
			AbstractSmooksGraphicalModel targetNode) {
		super(sourceNode, targetNode);
		// TODO Auto-generated constructor stub
	}

	public void setRemoveMappingConnections(List<Mapping> removeMappings) {
		this.removeMappings = removeMappings;
	}

	public List<Mapping> getRemoveMappings() {
		return removeMappings;
	}
}
