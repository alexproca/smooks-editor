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

import java.util.List;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.gef.tree.model.TreeContainerModel;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;

/**
 * @author Dart
 *
 */
public class InputDataContianerModel extends TreeContainerModel {
	
	private ISmooksModelProvider smooksModelProvider;

	public InputDataContianerModel(Object data, ITreeContentProvider contentProvider, ILabelProvider labelProvider, ISmooksModelProvider modelProvider) {
		super(data, contentProvider, labelProvider);
		this.smooksModelProvider = modelProvider;
	}

	@Override
	protected TreeNodeModel createChildModel(Object model, ITreeContentProvider contentProvider,
			ILabelProvider labelProvider ) {
		return new InputDataTreeNodeModel(model, contentProvider, labelProvider);
	}
	
	

	/**
	 * @return the smooksModelProvider
	 */
	public ISmooksModelProvider getSmooksModelProvider() {
		return smooksModelProvider;
	}

	/**
	 * @param smooksModelProvider the smooksModelProvider to set
	 */
	public void setSmooksModelProvider(ISmooksModelProvider smooksModelProvider) {
		this.smooksModelProvider = smooksModelProvider;
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel#isLinkable(java.lang.Class)
	 */
	@Override
	public boolean isLinkable(Class<?> connectionType) {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.gef.tree.model.TreeNodeModel#canLinkWithSource(java.lang.Object)
	 */
	@Override
	public boolean canLinkWithSource(Object model) {
		return super.canLinkWithSource(model);
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.gef.tree.model.TreeNodeModel#canLinkWithTarget(java.lang.Object)
	 */
	@Override
	public boolean canLinkWithTarget(Object model) {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel#getChildrenWithoutDynamic()
	 */
	@Override
	public List<AbstractSmooksGraphicalModel> getChildrenWithoutDynamic() {
		// TODO Auto-generated method stub
		return super.getChildrenWithoutDynamic();
	}
	
	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.gef.tree.model.TreeNodeModel#getChildren()
	 */
	@Override
	public List<AbstractSmooksGraphicalModel> getChildren() {
		// TODO Auto-generated method stub
		return super.getChildren();
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel#addChild(org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel)
	 */
	@Override
	public void addChild(AbstractSmooksGraphicalModel node) {
		// TODO Auto-generated method stub
		super.addChild(node);
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel#addChild(int, org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel)
	 */
	@Override
	public void addChild(int index, AbstractSmooksGraphicalModel node) {
		// TODO Auto-generated method stub
		super.addChild(index, node);
	}
}
