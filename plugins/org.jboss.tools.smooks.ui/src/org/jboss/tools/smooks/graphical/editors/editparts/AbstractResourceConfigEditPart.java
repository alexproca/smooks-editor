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

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.gef.tree.command.GEFAdapterCommand;
import org.jboss.tools.smooks.gef.tree.editparts.TreeContainerEditPart;
import org.jboss.tools.smooks.gef.tree.figures.TreeContainerFigure;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;
import org.jboss.tools.smooks.graphical.editors.model.AbstractResourceConfigGraphModel;
import org.jboss.tools.smooks.model.smooks.SmooksPackage;

/**
 * @author Dart
 * 
 */
public class AbstractResourceConfigEditPart extends TreeContainerEditPart {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.editparts.TreeContainerEditPart#createFigure
	 * ()
	 */
	@Override
	protected IFigure createFigure() {
		IFigure figure = super.createFigure();
		if (figure instanceof TreeContainerFigure) {
			((TreeContainerFigure) figure).setSource(isSource());
		}
		return figure;
	}

	protected boolean isSource() {
		return true;
	}

	@Override
	protected String generateFigureID() {
		return SmooksGraphUtil.generateFigureID((TreeNodeModel) getModel());
	}

	protected org.eclipse.emf.common.command.Command getDeleteEMFCommand(EditingDomain domain, Object data,
			EStructuralFeature feature) {
		return RemoveCommand.create(domain, ((EObject) data).eContainer(),
				SmooksPackage.Literals.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_RESOURCE_CONFIG_GROUP, FeatureMapUtil
						.createEntry(feature, data));
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
					if (data instanceof EObject && graphModel instanceof AbstractResourceConfigGraphModel) {
						IEditingDomainProvider provider = ((AbstractResourceConfigGraphModel) graphModel)
								.getDomainProvider();
						if (provider != null) {
							EditingDomain domain = provider.getEditingDomain();

							EStructuralFeature feature = getHostFeature((EObject) data);
							if (feature != null) {
								org.eclipse.emf.common.command.Command c = getDeleteEMFCommand(domain, data, feature);
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

		this.installEditPolicy(EditPolicy.CONTAINER_ROLE, new FlowLayoutEditPolicy() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.gef.editpolicies.FlowLayoutEditPolicy#isHorizontal()
			 */
			@Override
			protected boolean isHorizontal() {
				return false;
			}

			@Override
			protected Command getCreateCommand(CreateRequest request) {
				return AbstractResourceConfigEditPart.this.getCreateCommand(getHost(), request);
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.gef.editpolicies.OrderedLayoutEditPolicy#createAddCommand
			 * (org.eclipse.gef.EditPart, org.eclipse.gef.EditPart)
			 */
			@Override
			protected Command createAddCommand(EditPart child, EditPart after) {
				return null;
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @seeorg.eclipse.gef.editpolicies.OrderedLayoutEditPolicy#
			 * createMoveChildCommand(org.eclipse.gef.EditPart,
			 * org.eclipse.gef.EditPart)
			 */
			@Override
			protected Command createMoveChildCommand(EditPart child, EditPart after) {
				// TODO Auto-generated method stub
				return null;
			}

		});

		this.installEditPolicy(EditPolicy.LAYOUT_ROLE, new LayoutEditPolicy() {

			@Override
			protected Command getMoveChildrenCommand(Request request) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			protected Command getCreateCommand(CreateRequest request) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			protected EditPolicy createChildEditPolicy(EditPart child) {
				// TODO Auto-generated method stub
				return null;
			}
		});

	}

	protected Command getCreateCommand(EditPart host, CreateRequest request) {
		Object model = request.getNewObject();
		Object type = request.getNewObjectType();
		Object graphModel = host.getModel();
		if (graphModel instanceof AbstractResourceConfigGraphModel) {
			IEditingDomainProvider provider = ((AbstractResourceConfigGraphModel) graphModel).getDomainProvider();
			EditingDomain domain = provider.getEditingDomain();
			if (model instanceof FeatureMap.Entry) {
				EStructuralFeature type1 = ((FeatureMap.Entry) model).getEStructuralFeature();
				model = ((FeatureMap.Entry) model).getValue();
				model = EcoreUtil.copy((EObject) model);
				model = FeatureMapUtil.createEntry(type1, model);
			} else {
			}
			org.eclipse.emf.common.command.Command emfCommand = createModelCreationEMFCommand(domain,
					((AbstractResourceConfigGraphModel) graphModel).getData(), type, model);
			if (emfCommand == null || !emfCommand.canExecute())
				return null;
			return createModelCreationCommand(domain, emfCommand);
		}
		return null;
	}

	protected org.eclipse.emf.common.command.Command createModelCreationEMFCommand(EditingDomain domain, Object owner,
			Object type, Object collections) {
		return AddCommand.create(domain, owner, type, collections);
	}

	protected Command createModelCreationCommand(EditingDomain domain, org.eclipse.emf.common.command.Command emfCommand) {
		if (emfCommand.canExecute()) {
			GEFAdapterCommand command = new GEFAdapterCommand(domain, emfCommand);
			return command;
		}
		return null;
	}

	protected EStructuralFeature getHostFeature(EObject model) {
		return null;
	}

}
