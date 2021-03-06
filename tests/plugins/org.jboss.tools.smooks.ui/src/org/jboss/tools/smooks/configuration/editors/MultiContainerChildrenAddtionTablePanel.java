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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;

/**
 * @author Dart
 * 
 */
public class MultiContainerChildrenAddtionTablePanel extends ContainerChildrenTablePanelCreator {

	private Shell shell;

	private Collection<?> children;

	private AdapterFactoryEditingDomain editingDomain;

	private EStructuralFeature feature;

	private EObject newChild = null;
	
	private  ILabelProvider cutomeChildrenSelectionViewerLabelProvider;

	public MultiContainerChildrenAddtionTablePanel(Shell shell, Collection<?> children,
			AdapterFactoryEditingDomain editingDomain, ISmooksModelProvider smooksModelProvider, EObject rootModel,
			FormToolkit toolkit, IEditorPart editorPart , ILabelProvider cutomeChildrenSelectionViewerLabelProvider) {
		super(smooksModelProvider, rootModel, toolkit, editorPart);
		this.shell = shell;
		this.children = children;
		this.editingDomain = editingDomain;
		this.cutomeChildrenSelectionViewerLabelProvider = cutomeChildrenSelectionViewerLabelProvider;
	}
	
	public MultiContainerChildrenAddtionTablePanel(Shell shell, Collection<?> children,
			AdapterFactoryEditingDomain editingDomain, ISmooksModelProvider smooksModelProvider, EObject rootModel,
			FormToolkit toolkit, IEditorPart editorPart){
		this(shell, children, editingDomain, smooksModelProvider, rootModel, toolkit, editorPart, null);
	}

	@Override
	protected boolean performNewChild() {
		List<Object> cloneChildren = new ArrayList<Object>();
		cloneChildren.addAll(children);
		ChildrenSelectionWizard wizard = new ChildrenSelectionWizard(shell, cloneChildren, editingDomain , cutomeChildrenSelectionViewerLabelProvider);
		if (wizard.open() == Dialog.OK) {
			CommandParameter param = wizard.getChildDescriptor();
			if (param != null) {
				feature = getChildFeature(param);
				newChild = getNewChildInstance(param);

				if (feature != null && newChild != null) {
					return super.performNewChild();
				}

			}
		}
		return false;
	}

	protected EObject getNewChildInstance(CommandParameter parameter) {
		if(parameter == null) return null;
		return parameter.getEValue();
	}

	protected EStructuralFeature getChildFeature(CommandParameter parameter) {
		if(parameter == null) return null;
		return  parameter.getEStructuralFeature();
	}

	@Override
	protected EStructuralFeature getChildrenFeature() {
		return feature;
	}

	@Override
	protected EObject newChildModel() {
		return newChild;
	}
}
