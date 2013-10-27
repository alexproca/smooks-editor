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
package org.jboss.tools.smooks.graphical.editors.model;

import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;

/**
 * @author Dart dpeng@redhat.com
 *
 */
public class ResourceConfigGraphModelImpl extends AbstractResourceConfigGraphModel {

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.graphical.editors.model.AbstractResourceConfigGraphModel#createChildModel(java.lang.Object, org.eclipse.jface.viewers.ITreeContentProvider, org.eclipse.jface.viewers.ILabelProvider)
	 */
	@Override
	protected TreeNodeModel createChildModel(Object model, ITreeContentProvider contentProvider,
			ILabelProvider labelProvider) {
		return null;
	}

	public ResourceConfigGraphModelImpl(Object data, ITreeContentProvider contentProvider,
			ILabelProvider labelProvider, IEditingDomainProvider domainProvider) {
		super(data, contentProvider, labelProvider, domainProvider);
		// TODO Auto-generated constructor stub
	}
	
	

}
