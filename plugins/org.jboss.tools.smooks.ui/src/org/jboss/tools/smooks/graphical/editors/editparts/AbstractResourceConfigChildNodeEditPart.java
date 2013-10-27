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
package org.jboss.tools.smooks.graphical.editors.editparts;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.gef.tree.command.GEFAdapterCommand;
import org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart;
import org.jboss.tools.smooks.graphical.editors.model.AbstractResourceConfigChildNodeGraphModel;

/**
 * @author Dart
 * 
 */
public class AbstractResourceConfigChildNodeEditPart extends TreeNodeEditPart {

	@Override
	protected boolean isDragLink() {
		AbstractSmooksGraphicalModel model = (AbstractSmooksGraphicalModel) getModel();
		if (model != null) {
			Object data = model.getData();
			data = AdapterFactoryEditingDomain.unwrap(data);
			if (data != null && data instanceof EObject) {
				EStructuralFeature idRefFeature = SmooksUIUtils.getBeanIDRefFeature((EObject) data);
				if (idRefFeature != null) {
					if (((EObject) data).eGet(idRefFeature) == null || !((EObject) data).eIsSet(idRefFeature)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
		this.installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy() {

			@Override
			protected Command getDeleteCommand(GroupRequest request) {
				List<?> editParts = request.getEditParts();
				CompoundCommand command = new CompoundCommand();
				for (Iterator<?> iterator = editParts.iterator(); iterator.hasNext();) {
					EditPart editPart = (EditPart) iterator.next();
					AbstractSmooksGraphicalModel graphModel = (AbstractSmooksGraphicalModel) editPart.getModel();
					Object data = graphModel.getData();
					data = AdapterFactoryEditingDomain.unwrap(data);
					if (data instanceof EObject && graphModel instanceof AbstractResourceConfigChildNodeGraphModel) {
						IEditingDomainProvider provider = ((AbstractResourceConfigChildNodeGraphModel) graphModel)
								.getDomainProvider();
						if (provider != null) {
							EStructuralFeature feature = getFeature((EObject) data);
							if (feature != null) {
								EditingDomain domain = provider.getEditingDomain();
								org.eclipse.emf.common.command.Command c = RemoveCommand.create(domain,
										((EObject) data).eContainer(), feature, data);
								if (c != null && c.canExecute()) {
									GEFAdapterCommand rc = new GEFAdapterCommand(domain, c);
									command.add(rc);
								}
							}
						}
					}
				}
				if (command.isEmpty())
					return null;
				return command;
			}
		});
	}

	protected EStructuralFeature getFeature(EObject model) {
		return null;
	}

}
