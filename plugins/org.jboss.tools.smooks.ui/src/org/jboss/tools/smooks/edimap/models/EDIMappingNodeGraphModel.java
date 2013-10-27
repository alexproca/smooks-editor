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
package org.jboss.tools.smooks.edimap.models;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;
import org.jboss.tools.smooks.model.medi.MEdiPackage;
import org.jboss.tools.smooks.model.medi.Segment;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class EDIMappingNodeGraphModel extends TreeNodeModel {

	IEditingDomainProvider domainProvider = null;

	public EDIMappingNodeGraphModel(Object data, ITreeContentProvider contentProvider, ILabelProvider labelProvider,
			IEditingDomainProvider domainProvider) {
		super(data, contentProvider, labelProvider);
		this.domainProvider = domainProvider;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.model.TreeNodeModel#createChildModel(
	 * java.lang.Object, org.eclipse.jface.viewers.ITreeContentProvider,
	 * org.eclipse.jface.viewers.ILabelProvider)
	 */
	@Override
	protected TreeNodeModel createChildModel(Object model, ITreeContentProvider contentProvider,
			ILabelProvider labelProvider) {
		return new EDIMappingNodeGraphModel(model, contentProvider, labelProvider, domainProvider);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.model.TreeNodeModel#canLinkWithSource
	 * (java.lang.Object)
	 */
	@Override
	public boolean canLinkWithSource(Object model) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.model.TreeNodeModel#addSourceConnection
	 * (org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection)
	 */
	@Override
	public void addSourceConnection(TreeNodeConnection connection) {
		super.addSourceConnection(connection);
		if (getData() instanceof Segment) {
			AbstractSmooksGraphicalModel targetNode = connection.getTargetNode();
			if (targetNode != null && targetNode.getData() instanceof EDIDataContainerModel) {
				if (domainProvider != null) {
					String segCode = ((EDIDataContainerModel) targetNode.getData()).getSegCode();
					String sc = ((Segment) getData()).getSegcode();
					if (sc != null && sc.equals(segCode)) {
						return;
					}
					EditingDomain domain = domainProvider.getEditingDomain();
					if (domain != null) {
						Command command = SetCommand.create(domain, getData(), MEdiPackage.Literals.SEGMENT__SEGCODE,
								segCode);
						domain.getCommandStack().execute(command);
					}
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.model.TreeNodeModel#removeSourceConnection
	 * (org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection)
	 */
	@Override
	public void removeSourceConnection(TreeNodeConnection connection) {
		super.removeSourceConnection(connection);
		if (getData() instanceof Segment) {
			String sc = ((Segment) getData()).getSegcode();
			if (sc == null) {
				return;
			}
			if (domainProvider != null) {
				EditingDomain domain = domainProvider.getEditingDomain();
				if (domain != null) {
					Command command = SetCommand.create(domain, getData(), MEdiPackage.Literals.SEGMENT__SEGCODE, null);
					domain.getCommandStack().execute(command);
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.model.TreeNodeModel#removeTargetConnection
	 * (org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection)
	 */
	@Override
	public void removeTargetConnection(TreeNodeConnection connection) {
		// TODO Auto-generated method stub
		super.removeTargetConnection(connection);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.model.TreeNodeModel#addTargetConnection
	 * (org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection)
	 */
	@Override
	public void addTargetConnection(TreeNodeConnection connection, AbstractSmooksGraphicalModel sourceNode) {
		super.addTargetConnection(connection, sourceNode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.tools.smooks.gef.tree.model.TreeNodeModel#isLinkable()
	 */
	@Override
	public boolean isLinkable(Class<?> type) {
		Object nodeModel = getData();
		if (!(nodeModel instanceof Segment)) {
			return false;
		}else{
			if(!this.getSourceConnections().isEmpty()){
				return false;
			}
		}
		return super.isLinkable(type);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.model.TreeNodeModel#canLinkWithTarget
	 * (java.lang.Object)
	 */
	@Override
	public boolean canLinkWithTarget(Object model) {
		Object nodeModel = getData();
		if (!(nodeModel instanceof Segment)) {
			return false;
		}
		if (model instanceof EDIDataContainerGraphModel) {
			return true;
		}
		return false;
	}
}
