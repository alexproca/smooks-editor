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
package org.jboss.tools.smooks.configuration.editors;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;

/**
 * @author Dart
 * 
 */
public class ContainerChildrenTablePanelCreator extends ModelChildrenTablePanelCreator {

	private EStructuralFeature containerFeature = null;

	private EObject rootModel;

	public ContainerChildrenTablePanelCreator(ISmooksModelProvider smooksModelProvider, EObject rootModel,
			FormToolkit toolkit, IEditorPart editorPart) {
		super(smooksModelProvider, null, toolkit, editorPart);
		this.rootModel = rootModel;
	}

	public EStructuralFeature getContainerFeature() {
		return containerFeature;
	}

	public void setContainerFeature(EStructuralFeature containerFeature) {
		this.containerFeature = containerFeature;
	}

	public EObject getRootModel() {
		return rootModel;
	}

	public void setRootModel(EObject rootModel) {
		this.rootModel = rootModel;
	}

	@Override
	protected boolean performNewChild() {
		if (getRootModel() != null) {
			EObject rootModel = getRootModel();
			EStructuralFeature feature = getContainerFeature();
			if (feature != null) {
				Object container = rootModel.eGet(feature);
				if (container == null) {
					container = newContainerModel();
					if (container != null){
						rootModel.eSet(containerFeature, container);
						this.setParentModel((EObject) container);
						if(getChildrenTableViewer() != null){
							getChildrenTableViewer().setInput(getParentModel());
						}
					}
				}else{
					this.setParentModel((EObject) container);
					if(getChildrenTableViewer() != null){
						getChildrenTableViewer().setInput(getParentModel());
					}
				}
				
				return true;
			}
		}
		return false;
	}

	protected EObject newContainerModel() {
		return null;
	}

	@Override
	protected void performRunRemoveCommand(CompoundCommand compoundCommand, EditingDomain editingDomain) {
		if (this.getParentModel() != null) {
			EObject h = getParentModel();
			if (h.eContents().size() == 1) {
				Command command1 = RemoveCommand.create(editingDomain, h);
				compoundCommand.append(command1);
				this.setParentModel(null);
			}
		}
		super.performRunRemoveCommand(compoundCommand, editingDomain);
	}

	@Override
	protected void endRemoveChild() {
		super.endRemoveChild();
	}
}
