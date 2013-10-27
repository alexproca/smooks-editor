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

import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;

/**
 * @author Dart
 * 
 */
public class FreemarkerXMLNodeGraphicalModel extends FreemarkerTemplateNodeGraphicalModel {

	public FreemarkerXMLNodeGraphicalModel(Object data, ITreeContentProvider contentProvider,
			ILabelProvider labelProvider, IEditingDomainProvider domainProvider) {
		super(data, contentProvider, labelProvider, domainProvider);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.graphical.editors.model.freemarker.
	 * FreemarkerTemplateNodeGraphicalModel
	 * #isMappingValueConnection(org.jboss.tools
	 * .smooks.gef.tree.model.TreeNodeConnection)
	 */
	@Override
	protected boolean isMappingValueConnection(TreeNodeConnection connection) {
		if (isCollectionConnection(connection)) {
			return false;
		}
		return true;
	}
}
