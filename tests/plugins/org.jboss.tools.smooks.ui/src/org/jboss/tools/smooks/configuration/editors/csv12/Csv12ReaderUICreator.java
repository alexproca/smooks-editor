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
package org.jboss.tools.smooks.configuration.editors.csv12;

import java.util.Collection;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.jboss.tools.smooks.configuration.editors.AttributeFieldEditPart;
import org.jboss.tools.smooks.configuration.editors.IFieldMarker;
import org.jboss.tools.smooks.configuration.editors.ModelMultiChildrenTabelPanelCreator;
import org.jboss.tools.smooks.configuration.editors.PropertyUICreator;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.graphical.wizard.freemarker.Messages;
import org.jboss.tools.smooks.model.csv12.Binding;
import org.jboss.tools.smooks.model.csv12.CSV12Reader;
import org.jboss.tools.smooks.model.csv12.Csv12Package;
import org.jboss.tools.smooks.model.csv12.MapBinding;
import org.jboss.tools.smooks.model.smooks.SmooksPackage;

/**
 * @author Dart Peng (dpeng@redhat.com) Date Apr 10, 2009
 */
public class Csv12ReaderUICreator extends PropertyUICreator {

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
	public List<AttributeFieldEditPart> createExtendUIOnTop(AdapterFactoryEditingDomain editingDomain,
			FormToolkit formToolkit, Composite detailsComposite, Object model, ISmooksModelProvider formEditor,
			IEditorPart editorPart) {
		createFiledsComposite(editingDomain, formToolkit, detailsComposite, model, formEditor);
		return super.createExtendUIOnTop(editingDomain, formToolkit, detailsComposite, model, formEditor, editorPart);
	}

	@Override
	public List<AttributeFieldEditPart> createExtendUIOnBottom(AdapterFactoryEditingDomain editingdomain,
			FormToolkit toolkit, Composite parent, Object model, ISmooksModelProvider formEditor, IEditorPart editorPart) {
		// createFiledsComposite(editingdomain, toolkit, parent, model,
		// formEditor);
		// createParametersGroup(parent, (CSV12Reader) model, toolkit,
		// formEditor, editorPart);
		return super.createExtendUIOnBottom(editingdomain, toolkit, parent, model, formEditor, editorPart);
	}

	@Override
	public boolean ignoreProperty(EAttribute feature) {
		if (feature.equals(Csv12Package.Literals.CSV12_READER__ENCODING)) {
			return true;
		}
		if (feature.equals(SmooksPackage.Literals.ABSTRACT_READER__TARGET_PROFILE)) {
			return true;
		}
		if (feature.equals(Csv12Package.Literals.CSV12_READER__FIELDS)) {
			return true;
		}
		if (feature.equals(Csv12Package.Literals.CSV12_READER__QUOTE)) {
			return true;
		}
		if (feature.equals(Csv12Package.Literals.CSV12_READER__SEPARATOR)) {
			return true;
		}
		if (feature.equals(Csv12Package.Literals.CSV12_READER__RECORD_ELEMENT_NAME)) {
			return true;
		}
		if (feature.equals(Csv12Package.Literals.CSV12_READER__ROOT_ELEMENT_NAME)) {
			return true;
		}
		return super.ignoreProperty(feature);
	}

	private void createParametersGroup(Composite parent, CSV12Reader reader, FormToolkit toolkit,
			ISmooksModelProvider modelProvider, IEditorPart editorPart) {
		Group group = new Group(parent, SWT.NONE);
		group.setText(org.jboss.tools.smooks.configuration.editors.csv12.Messages.Csv12ReaderUICreator_0);
		group.setBackground(ColorConstants.white);
		FillLayout fl = new FillLayout();
		group.setLayout(fl);
		final AdapterFactoryEditingDomain editingDomain = (AdapterFactoryEditingDomain) modelProvider
				.getEditingDomain();
		final Shell shell = parent.getShell();
		IEditingDomainItemProvider p = (IEditingDomainItemProvider) editingDomain.getAdapterFactory().adapt(reader,
				IEditingDomainItemProvider.class);
		final Collection<?> children = p.getNewChildDescriptors(reader, editingDomain, null);

		ModelMultiChildrenTabelPanelCreator creator = new ModelMultiChildrenTabelPanelCreator(shell, children,
				editingDomain, modelProvider, reader, toolkit, editorPart, new ReaderBindingLabelProvider());

		creator.createChildrenTablePanel(group);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.heightHint = 180;
		gd.horizontalSpan = 2;
		group.setLayoutData(gd);
	}

	private void createFiledsComposite(AdapterFactoryEditingDomain editingdomain, FormToolkit toolkit,
			Composite parent, Object model, ISmooksModelProvider formEditor) {

		IItemPropertySource propertySource = (IItemPropertySource) editingdomain.getAdapterFactory().adapt(model,
				IItemPropertySource.class);

		final IItemPropertyDescriptor fieldsDescriptor = propertySource.getPropertyDescriptor(model,
				Csv12Package.Literals.CSV12_READER__FIELDS);

		String fields = (String) SmooksUIUtils.getEditValue(fieldsDescriptor, model);

		final AttributeFieldEditPart fieldsEditPart = SmooksUIUtils.createStringFieldEditor(
				org.jboss.tools.smooks.configuration.editors.csv12.Messages.Csv12ReaderUICreator_Fields, parent,
				editingdomain, toolkit, fieldsDescriptor, model, false, false, false, null, 0, null,
				SmooksUIUtils.VALUE_TYPE_VALUE, null, false);
		Text text = (Text) fieldsEditPart.getContentControl();
		text.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent arg0) {
				updateFieldsMessage(((Text) arg0.getSource()).getText(), fieldsEditPart);
			}
		});
		updateFieldsMessage(fields, fieldsEditPart);

		final IItemPropertyDescriptor descriptor = propertySource.getPropertyDescriptor(model,
				Csv12Package.Literals.CSV12_READER__SEPARATOR);

		final AttributeFieldEditPart separatorEditPart = SmooksUIUtils.createStringFieldEditor(
				org.jboss.tools.smooks.configuration.editors.csv12.Messages.Csv12ReaderUICreator_Separator_Char,
				parent, editingdomain, toolkit, descriptor, model, false, false, false, null, 0, null,
				SmooksUIUtils.VALUE_TYPE_VALUE, null, false);
		Text separateText = (Text) separatorEditPart.getContentControl();
		separateText.setTextLimit(1);

		final IItemPropertyDescriptor quotedescriptor = propertySource.getPropertyDescriptor(model,
				Csv12Package.Literals.CSV12_READER__QUOTE);

		final AttributeFieldEditPart quoteEditPart = SmooksUIUtils.createStringFieldEditor(
				org.jboss.tools.smooks.configuration.editors.csv12.Messages.Csv12ReaderUICreator_Quote_Char, parent,
				editingdomain, toolkit, quotedescriptor, model, false, false, false, null, 0, null,
				SmooksUIUtils.VALUE_TYPE_VALUE, null, false);
		Text quoteText = (Text) quoteEditPart.getContentControl();
		quoteText.setTextLimit(1);

		final IItemPropertyDescriptor recorddescriptor = propertySource.getPropertyDescriptor(model,
				Csv12Package.Literals.CSV12_READER__RECORD_ELEMENT_NAME);

		final AttributeFieldEditPart recordEditPart = SmooksUIUtils.createStringFieldEditor(
				org.jboss.tools.smooks.configuration.editors.csv12.Messages.Csv12ReaderUICreator_Record_Name, parent,
				editingdomain, toolkit, recorddescriptor, model, false, false, false, null, 0, null,
				SmooksUIUtils.VALUE_TYPE_VALUE, null, false);

		final IItemPropertyDescriptor rootdescriptor = propertySource.getPropertyDescriptor(model,
				Csv12Package.Literals.CSV12_READER__ROOT_ELEMENT_NAME);

		final AttributeFieldEditPart rootEditPart = SmooksUIUtils.createStringFieldEditor(
				org.jboss.tools.smooks.configuration.editors.csv12.Messages.Csv12ReaderUICreator_Root_Name, parent,
				editingdomain, toolkit, rootdescriptor, model, false, false, false, null, 0, null,
				SmooksUIUtils.VALUE_TYPE_VALUE, null, false);
	}

	protected void updateFieldsMessage(String fields, AttributeFieldEditPart editPart) {
		editPart.getFieldMarker().clean();
		String error = null;
		if (fields == null) {
			error = ""; //$NON-NLS-1$
		} else {
			fields = fields.trim();
			if ("".equals(fields)) { //$NON-NLS-1$
				error = ""; //$NON-NLS-1$
			} else {
				char[] chars = fields.toCharArray();
				for (int i = 0; i < chars.length; i++) {
					char c = chars[i];
					if (c == ',') {
						continue;
					}
					if (Character.isLetterOrDigit(c)) {

					} else {
						error = "" + c //$NON-NLS-1$
								+ ""; //$NON-NLS-1$
						break;
					}
				}

				String[] fieldsArray = fields.split(","); //$NON-NLS-1$
				if (fieldsArray.length == 0) {
					error = ""; //$NON-NLS-1$
				}
				for (int i = 0; i < fieldsArray.length; i++) {
					String f = fieldsArray[i];
					if (f == null || "".equals(f.trim())) { //$NON-NLS-1$
						error = ""; //$NON-NLS-1$
						break;
					}
				}
			}
		}
		if (error != null) {
			editPart.getFieldMarker().setMarkerType(IFieldMarker.TYPE_ERROR);
			editPart.getFieldMarker().setMessage(error);
		}
	}

	/**
	 * newChildDescriptors.add (createChildParameter
	 * (Csv12Package.Literals.CSV12_READER__SINGLE_BINDING,
	 * Csv12Factory.eINSTANCE.createBinding()));
	 * 
	 * newChildDescriptors.add (createChildParameter
	 * (Csv12Package.Literals.CSV12_READER__SINGLE_BINDING,
	 * Csv12Factory.eINSTANCE.createMapBinding()));
	 * 
	 * newChildDescriptors.add (createChildParameter
	 * (Csv12Package.Literals.CSV12_READER__LIST_BINDING,
	 * Csv12Factory.eINSTANCE.createBinding()));
	 * 
	 * newChildDescriptors.add (createChildParameter
	 * (Csv12Package.Literals.CSV12_READER__LIST_BINDING,
	 * Csv12Factory.eINSTANCE.createMapBinding()));
	 * 
	 * newChildDescriptors.add (createChildParameter
	 * (Csv12Package.Literals.CSV12_READER__MAP_BINDING,
	 * Csv12Factory.eINSTANCE.createMapBinding()));
	 * 
	 * @author Dart
	 * 
	 */

	private class ReaderBindingLabelProvider extends LabelProvider {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
		 */
		@Override
		public String getText(Object element) {
			if (element instanceof CommandParameter) {
				Object v = ((CommandParameter) element).getValue();
				v = AdapterFactoryEditingDomain.unwrap(v);
				EStructuralFeature feature = ((CommandParameter) element).getEStructuralFeature();
				if (v instanceof MapBinding) {
					if (feature == Csv12Package.Literals.CSV12_READER__MAP_BINDING) {
						return org.jboss.tools.smooks.configuration.editors.csv12.Messages.Csv12ReaderUICreator_MapBinding;
					}
					if (feature == Csv12Package.Literals.CSV12_READER__SINGLE_BINDING) {
						return org.jboss.tools.smooks.configuration.editors.csv12.Messages.Csv12ReaderUICreator_SingleMapBinding;
					}
					if (feature == Csv12Package.Literals.CSV12_READER__LIST_BINDING) {
						return org.jboss.tools.smooks.configuration.editors.csv12.Messages.Csv12ReaderUICreator_ListMapBinding;
					}
				}
				if (v instanceof Binding) {
					if (feature == Csv12Package.Literals.CSV12_READER__SINGLE_BINDING) {
						return org.jboss.tools.smooks.configuration.editors.csv12.Messages.Csv12ReaderUICreator_SingleBinding;
					}
					if (feature == Csv12Package.Literals.CSV12_READER__LIST_BINDING) {
						return org.jboss.tools.smooks.configuration.editors.csv12.Messages.Csv12ReaderUICreator_ListBinding;
					}
				}
			}
			return super.getText(element);
		}

	}
}