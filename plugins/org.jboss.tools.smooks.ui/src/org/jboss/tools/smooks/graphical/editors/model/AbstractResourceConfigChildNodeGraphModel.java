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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;
import org.jboss.tools.smooks.templating.template.ValueMapping;

/**
 * @author Dart
 * 
 */
public class AbstractResourceConfigChildNodeGraphModel extends TreeNodeModel {
	protected IEditingDomainProvider domainProvider = null;

	public AbstractResourceConfigChildNodeGraphModel(Object data, ITreeContentProvider contentProvider,
			ILabelProvider labelProvider, IEditingDomainProvider domainProvider) {
		super(data, contentProvider, labelProvider);
		this.domainProvider = domainProvider;
	}

	@Override
	public boolean hasChildren() {
		return false;
	}

	public IEditingDomainProvider getDomainProvider() {
		return domainProvider;
	}

	@Override
	public boolean canLinkWithSource(Object model) {
		if (model instanceof AbstractSmooksGraphicalModel) {
			Object sourceModel = ((AbstractSmooksGraphicalModel) model).getData();
			sourceModel = AdapterFactoryEditingDomain.unwrap(sourceModel);
			Object targetModel = getData();
			targetModel = AdapterFactoryEditingDomain.unwrap(targetModel);
			if (sourceModel instanceof EObject && targetModel instanceof EObject) {
				EStructuralFeature idFeature = SmooksUIUtils.getBeanIDFeature((EObject) targetModel);
				EStructuralFeature idRefFeature = SmooksUIUtils.getBeanIDRefFeature((EObject) sourceModel);
				if (idFeature != null && idRefFeature != null) {
					return true;
				}
			}

			if (sourceModel instanceof IXMLStructuredObject && targetModel instanceof EObject) {
				EStructuralFeature selectorFeature = SmooksUIUtils.getSelectorFeature((EObject) targetModel);
				if (selectorFeature != null) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean canLinkWithTarget(Object model) {
		if (model instanceof AbstractSmooksGraphicalModel) {
			Object targetModel = ((AbstractSmooksGraphicalModel) model).getData();
			targetModel = AdapterFactoryEditingDomain.unwrap(targetModel);
			Object sourceModel = getData();
			sourceModel = AdapterFactoryEditingDomain.unwrap(sourceModel);
			if (sourceModel instanceof EObject && targetModel instanceof EObject) {
				EStructuralFeature idFeature = SmooksUIUtils.getBeanIDFeature((EObject) targetModel);
				EStructuralFeature idRefFeature = SmooksUIUtils.getBeanIDRefFeature((EObject) sourceModel);
				if (idFeature != null && idRefFeature != null) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void addSourceConnection(TreeNodeConnection connection) {
		super.addSourceConnection(connection);
		Object sourceModel = getData();
		sourceModel = AdapterFactoryEditingDomain.unwrap(sourceModel);
		if (sourceModel instanceof EObject) {
			EStructuralFeature feature = SmooksUIUtils.getBeanIDRefFeature((EObject) sourceModel);
			Object model = connection.getTargetNode().getData();
			if (feature != null) {
				EStructuralFeature idFeature = SmooksUIUtils.getBeanIDFeature((EObject) model);
				if (idFeature == null)
					return;
				// it's bean id connection
				Object iddata = ((EObject) model).eGet(idFeature);
				if (iddata != null) {
					Command command = SetCommand.create(domainProvider.getEditingDomain(), (EObject) sourceModel,
							feature, iddata);
					domainProvider.getEditingDomain().getCommandStack().execute(command);
					return;
				}
			}
		}
	}

	@Override
	public void removeSourceConnection(TreeNodeConnection connection) {
		super.removeSourceConnection(connection);
		Object sourceModel = getData();
		sourceModel = AdapterFactoryEditingDomain.unwrap(sourceModel);
		if (sourceModel instanceof EObject) {
			EStructuralFeature feature = SmooksUIUtils.getBeanIDRefFeature((EObject) sourceModel);
			Object model = connection.getTargetNode().getData();
			if (feature != null) {
				EStructuralFeature idFeature = SmooksUIUtils.getBeanIDFeature((EObject) model);
				if (idFeature == null)
					return;
				// it's bean id connection
				if (idFeature != null) {
					try {
						Command command = SetCommand.create(domainProvider.getEditingDomain(), (EObject) sourceModel,
								feature, null);
						domainProvider.getEditingDomain().getCommandStack().execute(command);
					} catch (Exception e) {
						e.printStackTrace();
					}
					return;
				}
			}
		}
	}

	@Override
	public void addTargetConnection(TreeNodeConnection connection, AbstractSmooksGraphicalModel sourceNode) {
		super.addTargetConnection(connection, sourceNode);
		Object model = getData();
		model = AdapterFactoryEditingDomain.unwrap(model);
		if (model instanceof EObject) {
			// for the javabean children , there is only "Selector" target
			// connection;
			EStructuralFeature feature = SmooksUIUtils.getSelectorFeature((EObject) model);
			if (feature == null)
				return;
			EObject owner = (EObject) model;
			AbstractSmooksGraphicalModel targetGraphModel = connection.getSourceNode();
			Object tm = targetGraphModel.getData();
			if (tm instanceof IXMLStructuredObject) {
				String selector = SmooksUIUtils.generateFullPath((IXMLStructuredObject) tm, "/"); //$NON-NLS-1$
				Command command = SetCommand.create(domainProvider.getEditingDomain(), owner, feature, selector);
				domainProvider.getEditingDomain().getCommandStack().execute(command);
			}
		}
	}

	@Override
	public void removeTargetConnection(TreeNodeConnection connection) {
		super.removeTargetConnection(connection);
		Object model = getData();
		model = AdapterFactoryEditingDomain.unwrap(model);
		if (model instanceof EObject) {
			EStructuralFeature feature = SmooksUIUtils.getSelectorFeature((EObject) model);
			if (feature == null)
				return;
			EObject owner = (EObject) model;
			Command command = SetCommand.create(domainProvider.getEditingDomain(), owner, feature, null);
			domainProvider.getEditingDomain().getCommandStack().execute(command);
		}
	}

	/**
	 * Add the resource type info to Value Mapping instance.
	 * @param mapping The Value Mapping instance.
	 */
	public void addMappingTypeInfo(ValueMapping mapping) {
		// Override in implementation to add typing info associated with implementation type.
	}
}
