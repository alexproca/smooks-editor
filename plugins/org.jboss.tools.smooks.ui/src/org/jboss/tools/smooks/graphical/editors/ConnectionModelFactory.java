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
package org.jboss.tools.smooks.graphical.editors;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.jboss.tools.smooks.gef.common.RootModel;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;

/**
 * @author Dart
 * 
 */
public interface ConnectionModelFactory {

	public boolean hasConnection(AbstractSmooksGraphicalModel model);

	public Collection<TreeNodeConnection> createConnection(List<Object> inputDataList, EObject rootModel,
			RootModel root, AbstractSmooksGraphicalModel model);

	// public boolean hasBeanIDConnection(AbstractSmooksGraphicalModel model);
	//
	// public Collection<TreeNodeConnection>
	// createBeanIDReferenceConnection(EObject rootModel, RootModel root,
	// AbstractSmooksGraphicalModel model);
	//
	// public Collection<TreeNodeConnection>
	// createSelectorConnection(List<Object> inputDataList, RootModel root,
	// AbstractSmooksGraphicalModel model);
	//
	// public boolean hasSelectorConnection(AbstractSmooksGraphicalModel model);
	//	
	// public boolean hasXSLConnection(AbstractSmooksGraphicalModel model);
	//	
	// public Collection<TreeNodeConnection> createXSLConnection(List<Object>
	// inputDataList, RootModel root,
	// AbstractSmooksGraphicalModel model);
}
