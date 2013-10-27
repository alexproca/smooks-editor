/*******************************************************************************
 * Copyright (c) 2009 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.smooks.configuration.editors.smooks;

import java.util.Collection;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.jboss.tools.smooks.configuration.editors.AttributeFieldEditPart;
import org.jboss.tools.smooks.configuration.editors.ContainerChildrenTablePanelCreator;
import org.jboss.tools.smooks.configuration.editors.MultiContainerChildrenAddtionTablePanel;
import org.jboss.tools.smooks.configuration.editors.PropertyUICreator;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.model.smooks.ReaderType;
import org.jboss.tools.smooks.model.smooks.SmooksFactory;
import org.jboss.tools.smooks.model.smooks.SmooksPackage;

/**
 * @author Dart Peng (dpeng@redhat.com) Date Apr 10, 2009
 */
public class ReaderTypeUICreator extends PropertyUICreator {

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.IPropertyUICreator#
	 * createPropertyUI(org.eclipse.ui.forms.widgets.FormToolkit,
	 * org.eclipse.swt.widgets.Composite,
	 * org.eclipse.emf.edit.provider.IItemPropertyDescriptor, java.lang.Object,
	 * org.eclipse.emf.ecore.EAttribute)
	 */
	public AttributeFieldEditPart createPropertyUI(FormToolkit toolkit, Composite parent,
			IItemPropertyDescriptor propertyDescriptor, Object model, EAttribute feature,
			ISmooksModelProvider formEditor, IEditorPart part) {
		return super.createPropertyUI(toolkit, parent, propertyDescriptor, model, feature, formEditor, part);
	}

	@Override
	public boolean isJavaTypeFeature(EAttribute attribute) {
		if (attribute == SmooksPackage.eINSTANCE.getReaderType_Class()) {
			return true;
		}
		return super.isJavaTypeFeature(attribute);
	}

	@Override
	public List<AttributeFieldEditPart> createExtendUIOnBottom(AdapterFactoryEditingDomain editingdomain,
			FormToolkit toolkit, Composite parent, Object model, ISmooksModelProvider formEditor, IEditorPart editorPart) {
		if (model instanceof ReaderType) {
			createHandlerGroup(parent, (ReaderType) model, toolkit, formEditor, editorPart);
			createFeaturesGroup(parent, (ReaderType) model, toolkit, formEditor, editorPart);
			createParametersGroup(parent, (ReaderType) model, toolkit, formEditor, editorPart);
		}

		return super.createExtendUIOnBottom(editingdomain, toolkit, parent, model, formEditor, editorPart);
	}

	private void createParametersGroup(Composite parent, ReaderType reader, FormToolkit toolkit,
			ISmooksModelProvider modelProvider, IEditorPart editorPart) {
		Group group = new Group(parent, SWT.NONE);
		group.setText(Messages.ReaderTypeUICreator_ParameterGroupLabel);
		group.setBackground(ColorConstants.white);
		FillLayout fl = new FillLayout();
		group.setLayout(fl);

		ContainerChildrenTablePanelCreator creator = new ContainerChildrenTablePanelCreator(modelProvider, reader,
				toolkit, editorPart) {

			@Override
			protected EObject newContainerModel() {
				return SmooksFactory.eINSTANCE.createParamsType();
			}

			@Override
			protected EStructuralFeature getChildrenFeature() {
				return SmooksPackage.Literals.PARAMS_TYPE__PARAM;
			}

			@Override
			protected EObject newChildModel() {
				return SmooksFactory.eINSTANCE.createParamType();
			}
		};
		creator.setParentModel(reader.getParams());
		creator.setContainerFeature(SmooksPackage.Literals.READER_TYPE__PARAMS);
		creator.createChildrenTablePanel(group);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.heightHint = 180;
		gd.horizontalSpan = 2;
		group.setLayoutData(gd);
	}

	private void createFeaturesGroup(Composite parent, ReaderType reader, FormToolkit toolkit,
			ISmooksModelProvider modelProvider, IEditorPart editorPart) {
		Group group = new Group(parent, SWT.NONE);
		group.setText(Messages.ReaderTypeUICreator_FeaturesGroupLabel);
		group.setBackground(ColorConstants.white);
		FillLayout fl = new FillLayout();
		group.setLayout(fl);
		final AdapterFactoryEditingDomain editingDomain = (AdapterFactoryEditingDomain) modelProvider
				.getEditingDomain();
		final Shell shell = parent.getShell();
		Object temp = SmooksFactory.eINSTANCE.createFeaturesType();
		IEditingDomainItemProvider p = (IEditingDomainItemProvider) editingDomain.getAdapterFactory().adapt(temp,
				IEditingDomainItemProvider.class);
		final Collection<?> children = p.getNewChildDescriptors(temp, editingDomain, null);

		MultiContainerChildrenAddtionTablePanel creator = new MultiContainerChildrenAddtionTablePanel(shell, children,
				editingDomain, modelProvider, reader, toolkit, editorPart) {

			@Override
			protected EStructuralFeature getChildFeature(CommandParameter cp) {
				return cp.getEStructuralFeature();
			}

			@Override
			protected EObject getNewChildInstance(CommandParameter cp) {
				Object feature = cp.getEStructuralFeature();
				if (feature.equals(SmooksPackage.Literals.FEATURES_TYPE__SET_ON))
					return SmooksFactory.eINSTANCE.createSetOnType();
				if (feature.equals(SmooksPackage.Literals.FEATURES_TYPE__SET_OFF))
					return SmooksFactory.eINSTANCE.createSetOffType();
				return null;
			}

			@Override
			protected EObject newContainerModel() {
				return SmooksFactory.eINSTANCE.createFeaturesType();
			}

		};
		creator.setParentModel(reader.getFeatures());
		creator.setContainerFeature(SmooksPackage.Literals.READER_TYPE__FEATURES);
		creator.createChildrenTablePanel(group);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.heightHint = 180;
		gd.horizontalSpan = 2;
		group.setLayoutData(gd);
	}

	private void createHandlerGroup(Composite parent, ReaderType reader, FormToolkit toolkit,
			ISmooksModelProvider modelProvider, IEditorPart editorPart) {
		Group group = new Group(parent, SWT.NONE);
		group.setText(Messages.ReaderTypeUICreator_HandlersGroupLabel);
		group.setBackground(ColorConstants.white);
		FillLayout fl = new FillLayout();
		group.setLayout(fl);

		ContainerChildrenTablePanelCreator creator = new ContainerChildrenTablePanelCreator(modelProvider, reader,
				toolkit, editorPart) {

			@Override
			protected EObject newContainerModel() {
				return SmooksFactory.eINSTANCE.createHandlersType();
			}

			@Override
			protected EStructuralFeature getChildrenFeature() {
				return SmooksPackage.Literals.HANDLERS_TYPE__HANDLER;
			}

			@Override
			protected EObject newChildModel() {
				return SmooksFactory.eINSTANCE.createHandlerType();
			}
		};
		creator.setParentModel(reader.getHandlers());
		creator.setContainerFeature(SmooksPackage.Literals.READER_TYPE__HANDLERS);
		creator.createChildrenTablePanel(group);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.heightHint = 180;
		gd.horizontalSpan = 2;
		group.setLayoutData(gd);
	}

}