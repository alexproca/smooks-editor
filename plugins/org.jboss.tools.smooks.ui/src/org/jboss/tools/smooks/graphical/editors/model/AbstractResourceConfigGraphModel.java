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
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.gef.tree.model.TreeContainerModel;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;
import org.jboss.tools.smooks.templating.template.ValueMapping;

/**
 * @author Dart
 * 
 */
public abstract class AbstractResourceConfigGraphModel extends TreeContainerModel {

	protected IEditingDomainProvider domainProvider = null;

	public AbstractResourceConfigGraphModel(Object data, ITreeContentProvider contentProvider,
			ILabelProvider labelProvider, IEditingDomainProvider domainProvider) {
		super(data, contentProvider, labelProvider);
		this.domainProvider = domainProvider;
	}
	
	

	public IEditingDomainProvider getDomainProvider() {
		return domainProvider;
	}



	public void setDomainProvider(IEditingDomainProvider domainProvider) {
		this.domainProvider = domainProvider;
	}



	@Override
	protected abstract TreeNodeModel createChildModel(Object model, ITreeContentProvider contentProvider,
			ILabelProvider labelProvider);

	@Override
	public void addTargetConnection(TreeNodeConnection connection, AbstractSmooksGraphicalModel sourceNode) {
		super.addTargetConnection(connection, sourceNode);
		Object model = getData();
		if (model instanceof EObject) {
			EStructuralFeature feature = null;
			// judge the source model's type:
			AbstractSmooksGraphicalModel sourceGraphModel = connection.getSourceNode();
			if (sourceGraphModel instanceof InputDataTreeNodeModel
					|| sourceGraphModel instanceof InputDataContianerModel) {
				// it's "Selector" connection
				feature = SmooksUIUtils.getSelectorFeature((EObject) model);
				if (feature != null) {
					EObject owner = (EObject) model;
					AbstractSmooksGraphicalModel targetGraphModel = connection.getSourceNode();
					Object tm = targetGraphModel.getData();
					if (tm instanceof IXMLStructuredObject) {
						String selector = SmooksUIUtils.generateFullPath((IXMLStructuredObject) tm, "/"); //$NON-NLS-1$
						Command command = SetCommand
								.create(domainProvider.getEditingDomain(), owner, feature, selector);
						domainProvider.getEditingDomain().getCommandStack().execute(command);
						return;
					}
				}
			}

			// Object sourceModel = sourceGraphModel.getData();
			// sourceModel = AdapterFactoryEditingDomain.unwrap(sourceModel);
			// if (sourceModel instanceof EObject) {
			// feature = SmooksUIUtils.getBeanIDRefFeature((EObject)
			// sourceModel);
			// if (feature != null) {
			// // it's bean id connection
			// EStructuralFeature idFeature =
			// SmooksUIUtils.getBeanIDFeature((EObject) model);
			// Object iddata = ((EObject) model).eGet(idFeature);
			// if (iddata != null) {
			// Command command =
			// SetCommand.create(domainProvider.getEditingDomain(), (EObject)
			// sourceModel,
			// feature, iddata);
			// domainProvider.getEditingDomain().getCommandStack().execute(command);
			// return;
			// }
			// }
			// }
		}
	}

	@Override
	public void removeTargetConnection(TreeNodeConnection connection) {
		super.removeTargetConnection(connection);
		Object model = getData();
		if (model instanceof EObject) {
			EStructuralFeature feature = null;
			AbstractSmooksGraphicalModel sourceGraphModel = connection.getSourceNode();
			if (sourceGraphModel instanceof InputDataTreeNodeModel
					|| sourceGraphModel instanceof InputDataContianerModel) {
				// it's "Selector" connection
				feature = SmooksUIUtils.getSelectorFeature((EObject) model);
				if (feature != null) {
					EObject owner = (EObject) model;
					Command command = SetCommand.create(domainProvider.getEditingDomain(), owner, feature, null);
					domainProvider.getEditingDomain().getCommandStack().execute(command);
					return;
				}
			}

			// Object sourceModel = sourceGraphModel.getData();
			// sourceModel = AdapterFactoryEditingDomain.unwrap(sourceModel);
			// if (sourceModel instanceof EObject) {
			// feature = SmooksUIUtils.getBeanIDRefFeature((EObject)
			// sourceModel);
			// if (feature != null) {
			// // it's bean id connection
			// Command command =
			// SetCommand.create(domainProvider.getEditingDomain(), (EObject)
			// sourceModel,
			// feature, null);
			// domainProvider.getEditingDomain().getCommandStack().execute(command);
			// return;
			// }
			// }
		}
	}
}
