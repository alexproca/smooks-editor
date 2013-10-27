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
package org.jboss.tools.smooks.configuration.editors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.jboss.tools.smooks.configuration.editors.uitls.FieldAssistDisposer;
import org.jboss.tools.smooks.configuration.editors.uitls.FieldMarkerWrapper;
import org.jboss.tools.smooks.configuration.editors.uitls.IFieldDialog;
import org.jboss.tools.smooks.configuration.editors.uitls.IModelProcsser;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.model.smooks.SmooksPackage;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;

/**
 * @author Dart (dpeng@redhat.com)
 *         <p>
 *         Apr 9, 2009
 */
public class PropertyUICreator implements IPropertyUICreator {

	protected IModelProcsser fileFiledEditorModelProcess;

	protected IHyperlinkListener fileFiledEditorLinkListener;

	protected List<ViewerFilter> viewerFilters = null;

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
			ISmooksModelProvider formEditor, IEditorPart editorPart) {
		if (isBeanIDRefFieldFeature(feature)) {
			return createBeanIDRefFieldEditor(toolkit, parent, propertyDescriptor, model, feature, formEditor);
		}
		if (isSelectorFeature(feature)) {
			return createSelectorFieldEditor(toolkit, parent, propertyDescriptor, model, feature, formEditor,
					editorPart);
		}
		if (isJavaTypeFeature(feature)) {
			return createJavaTypeSearchEditor(toolkit, parent, propertyDescriptor, model, feature, formEditor);
		}
		if (isFileSelectionFeature(feature)) {
			return createFileSelectionFieldEditor(toolkit, parent, propertyDescriptor, model, feature, formEditor);
		}
		if (isConditionSelectionFeature(feature)) {
			return SmooksUIUtils.createConditionsChoiceFieldEditor(parent, toolkit, propertyDescriptor, model);
			// return parent;
		}
		if (feature == SmooksPackage.eINSTANCE.getAbstractReader_TargetProfile()) {

		}
//		EClassifier typeClazz = feature.getEType();
//		if (typeClazz instanceof EEnum) {
//			return createEnumFieldEditor(detailsComposite, feature, (EEnum) typeClazz, formToolkit,
//					itemPropertyDescriptor);
//		}
//		if (typeClazz.getInstanceClass() == String.class) {
//			return createStringFieldEditor(detailsComposite, feature, formToolkit, itemPropertyDescriptor);
//		}
//		if (typeClazz.getInstanceClass() == Boolean.class || typeClazz.getInstanceClass() == boolean.class) {
//			return createBooleanFieldEditor(detailsComposite, feature, formToolkit, itemPropertyDescriptor);
//		}
//		if (typeClazz.getInstanceClass() == Integer.class || typeClazz.getInstanceClass() == int.class) {
//			return createIntegerFieldEditor(detailsComposite, feature, formToolkit, itemPropertyDescriptor);
//		}
		return null;
	}

	protected boolean isConditionSelectionFeature(EAttribute feature) {
		return false;
	}

	public IHyperlinkListener getFileFiledEditorLinkListener() {
		return fileFiledEditorLinkListener;
	}

	public void setFileFiledEditorLinkListener(IHyperlinkListener fileFiledEditorLinkListener) {
		this.fileFiledEditorLinkListener = fileFiledEditorLinkListener;
	}

	public IModelProcsser getFileFiledEditorModelProcess() {
		return fileFiledEditorModelProcess;
	}

	public void setFileFiledEditorModelProcess(IModelProcsser fileFiledEditorModelProcess) {
		this.fileFiledEditorModelProcess = fileFiledEditorModelProcess;
	}

	public List<ViewerFilter> getFileDialogViewerFilters() {
		return viewerFilters;
	}

	public void setDialogViewerFilters(List<ViewerFilter> viewerFilters) {
		this.viewerFilters = viewerFilters;
	}

	public IResource getResource(EObject model) {
		return SmooksUIUtils.getResource(model);
	}

	public IJavaProject getJavaProject(EObject model) {
		return SmooksUIUtils.getJavaProject(model);
	}

	public List<AttributeFieldEditPart> createExtendUIOnBottom(AdapterFactoryEditingDomain editingdomain,
			FormToolkit toolkit, Composite parent, Object model, ISmooksModelProvider formEditor, IEditorPart editorPart) {
		return Collections.emptyList();
	}

	protected boolean isFileSelectionFeature(EAttribute attribute) {
		return false;
	}

	public AttributeFieldEditPart createFileSelectionFieldEditor(FormToolkit toolkit, Composite parent,
			IItemPropertyDescriptor propertyDescriptor, Object model, EAttribute feature,
			ISmooksModelProvider formEditor) {
		final ISmooksModelProvider provider = formEditor;
		IFieldDialog dialog = new IFieldDialog() {
			public Object open(Shell shell) {
				FileSelectionWizard wizard = new FileSelectionWizard();
				EObject model = provider.getSmooksModel();
				if (model != null) {
					URI uri = model.eResource().getURI();
					if (uri.isPlatformResource()) {
						String path = uri.toPlatformString(true);
						IResource workspaceResource = ResourcesPlugin.getWorkspace().getRoot().findMember(
								new Path(path));
						if (workspaceResource instanceof IFile) {
							workspaceResource = ((IFile) workspaceResource).getParent();
						}
						wizard.setInitSelections(new Object[] { workspaceResource });
					}
				}
				wizard.setViewerFilters(getFileDialogViewerFilters());
				WizardDialog dialog = new WizardDialog(shell, wizard);
				if (dialog.open() == Dialog.OK) {
					IModelProcsser p = getModelProcesser();
					String path = wizard.getFilePath();
					if (p != null) {
						path = p.unwrapValue(path).toString();
					}
					return path;
				}
				return null;
			}

			public IModelProcsser getModelProcesser() {
				return getFileFiledEditorModelProcess();
			}

			public void setModelProcesser(IModelProcsser processer) {

			}

		};
		return SmooksUIUtils.createDialogFieldEditor(parent, toolkit, propertyDescriptor, Messages.PropertyUICreator_browsebutton, dialog,
				(EObject) model, true, getFileFiledEditorLinkListener());
	}

	protected boolean isSelectorFeature(EAttribute attribute) {
		return false;
	}

	public AttributeFieldEditPart createSelectorFieldEditor(FormToolkit toolkit, Composite parent,
			IItemPropertyDescriptor propertyDescriptor, Object model, EAttribute feature,
			ISmooksModelProvider formEditor, IEditorPart editorPart) {
		// SmooksGraphicsExtType ext = formEditor.getSmooksGraphicsExt();
		return SmooksUIUtils.createSelectorFieldEditor(toolkit, parent, propertyDescriptor, model, editorPart);
	}

	public boolean isJavaTypeFeature(EAttribute attribute) {
		return false;
	}

	public AttributeFieldEditPart createJavaTypeSearchEditor(FormToolkit toolkit, Composite parent,
			IItemPropertyDescriptor propertyDescriptor, Object model, EAttribute feature,
			ISmooksModelProvider formEditor) {
		if (model instanceof EObject)
			return SmooksUIUtils.createJavaTypeSearchFieldEditor(parent, toolkit, propertyDescriptor, (EObject) model,
					formEditor);
		return null;
	}

	protected boolean isBeanIDRefFieldFeature(EAttribute attribute) {
		return false;
	}

	public AttributeFieldEditPart createBeanIDRefFieldEditor(FormToolkit toolkit, Composite parent,
			IItemPropertyDescriptor propertyDescriptor, Object model, EAttribute feature,
			ISmooksModelProvider formEditor) {
		if (model instanceof EObject) {
			AttributeFieldEditPart editPart = new AttributeFieldEditPart();
			SmooksResourceListType smooksResourceList = getSmooksResourceList((EObject) model);
			if (smooksResourceList != null) {
				FieldMarkerWrapper wrapper = SmooksUIUtils.createFieldEditorLabel(null, parent, toolkit,
						propertyDescriptor, model, false);
				editPart.setFieldMarker(wrapper.getMarker());

				Composite tcom = toolkit.createComposite(parent);
				GridLayout layout = new GridLayout();
				layout.numColumns = 2;
				layout.marginLeft = 0;
				layout.marginRight = 0;
				layout.horizontalSpacing = 0;
				tcom.setLayout(layout);

				FieldMarkerComposite notificationComposite = new FieldMarkerComposite(tcom, SWT.NONE);
				GridData gd = new GridData();
				gd.heightHint = 8;
				gd.widthHint = 8;
				gd.horizontalAlignment = GridData.BEGINNING;
				gd.verticalAlignment = GridData.BEGINNING;
				notificationComposite.setLayoutData(gd);
				editPart.setFieldMarker(notificationComposite);

				final Combo combo = new Combo(tcom, SWT.BORDER);
				editPart.setContentControl(combo);
				gd = new GridData(GridData.FILL_HORIZONTAL);
				combo.setLayoutData(gd);
				tcom.setLayoutData(gd);

				Object editValue = SmooksUIUtils.getEditValue(propertyDescriptor, model);
				if (editValue != null) {
					combo.setText(editValue.toString());
				}
				List<String> list = SmooksUIUtils.getBeanIdStringList(smooksResourceList);
				for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
					String beanId = (String) iterator.next();
					combo.add(beanId);
				}
				int selectIndex = list.indexOf(editValue);
				if (selectIndex != -1) {
					combo.select(selectIndex);
				}
				final IItemPropertyDescriptor ip = propertyDescriptor;
				final Object cmodel = model;
				combo.addModifyListener(new ModifyListener() {
					public void modifyText(ModifyEvent e) {
						if (combo.getText() == null || combo.getText().length() == 0) {
							ip.setPropertyValue(cmodel, null);
							return;
						}
						Object editValue = SmooksUIUtils.getEditValue(ip, cmodel);
						if (combo.getText().equals(editValue)) {
							return;
						}
						ip.setPropertyValue(cmodel, combo.getText());
					}
				});

				final FieldAssistDisposer disposer = SmooksUIUtils.addBeanIdRefAssistToCombo(combo, (EObject) model);

				combo.addDisposeListener(new DisposeListener() {

					/*
					 * (non-Javadoc)
					 * 
					 * @see
					 * org.eclipse.swt.events.DisposeListener#widgetDisposed
					 * (org.eclipse.swt.events.DisposeEvent)
					 */
					public void widgetDisposed(DisposeEvent e) {
						disposer.dispose();
					}

				});

				return editPart;
			}
		}
		return null;
	}

	protected SmooksResourceListType getSmooksResourceList(EObject model) {
		EObject parent = model.eContainer();
		while (parent != null && !(parent instanceof SmooksResourceListType)) {
			parent = parent.eContainer();
		}
		if (parent instanceof SmooksResourceListType) {
			return (SmooksResourceListType) parent;
		}
		return null;
	}

	public boolean ignoreProperty(EAttribute feature) {
		return false;
	}

	public IItemPropertyDescriptor getPropertyDescriptor(AdapterFactoryEditingDomain editingDomain,
			EAttribute attribute, Object model) {
		IItemPropertySource itemPropertySource = (IItemPropertySource) editingDomain.getAdapterFactory().adapt(model,
				IItemPropertySource.class);
		List<IItemPropertyDescriptor> list = itemPropertySource.getPropertyDescriptors(model);
		for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
			IItemPropertyDescriptor itemPropertyDescriptor = (IItemPropertyDescriptor) iterator.next();
			if (itemPropertyDescriptor.getFeature(model) == attribute) {
				return itemPropertyDescriptor;
			}
		}
		return null;
	}

	protected List<AttributeFieldEditPart> createElementSelectionSection(String sectionTitle,
			AdapterFactoryEditingDomain editingdomain, FormToolkit toolkit, Composite parent, Object model,
			ISmooksModelProvider formEditor, IEditorPart editorPart, EAttribute nameAttribute,
			EAttribute namespaceAttribute) {
		IItemPropertySource itemPropertySource = (IItemPropertySource) editingdomain.getAdapterFactory().adapt(model,
				IItemPropertySource.class);
		List<IItemPropertyDescriptor> propertyDes = itemPropertySource.getPropertyDescriptors(model);
		IItemPropertyDescriptor createOnElementFeature = null;
		IItemPropertyDescriptor createOnElementFeatureNS = null;
		for (Iterator<?> iterator = propertyDes.iterator(); iterator.hasNext();) {
			IItemPropertyDescriptor itemPropertyDescriptor = (IItemPropertyDescriptor) iterator.next();
			if (itemPropertyDescriptor.getFeature(model) == nameAttribute) {
				createOnElementFeature = itemPropertyDescriptor;
			}
			if (itemPropertyDescriptor.getFeature(model) == namespaceAttribute) {
				createOnElementFeatureNS = itemPropertyDescriptor;
			}
		}
		if (createOnElementFeature == null || createOnElementFeatureNS == null) {
			return Collections.emptyList();
		}

		return createElementSelectionSection(sectionTitle, editingdomain, toolkit, parent, model, formEditor,
				editorPart, createOnElementFeature, createOnElementFeatureNS);
	}

	protected List<AttributeFieldEditPart> createElementSelectionSection(String sectionTitle,
			AdapterFactoryEditingDomain editingdomain, FormToolkit toolkit, Composite parent, Object model,
			ISmooksModelProvider formEditor, IEditorPart editorPart, IItemPropertyDescriptor createOnElementFeature,
			IItemPropertyDescriptor createOnElementFeatureNS) {
		Group group = new Group(parent, SWT.NONE);
		// Section section = toolkit.createSection(parent, Section.TITLE_BAR);
		// section.setText(sectionTitle);
		if (sectionTitle != null) {
			sectionTitle = " " + sectionTitle + " "; //$NON-NLS-1$ //$NON-NLS-2$
		}
		group.setText(sectionTitle);
		// FontData fd = new FontData();
		// fd.setStyle(SWT.BOLD);
		// group.setForeground(toolkit.getColors().getForeground());

		FillLayout layout = new FillLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;

		// section.setLayout(layout);
		group.setLayout(layout);

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		// gd.heightHint = 100;
		gd.horizontalSpan = 2;
		// section.setLayoutData(gd);
		group.setLayoutData(gd);
		group.setForeground(toolkit.getColors().getColor(IFormColors.TITLE));
		// Composite backComposite = toolkit.createComposite(section);
		// section.setClient(backComposite);
		// GridLayout gl = new GridLayout();
		// gl.marginHeight = 0;
		// gl.marginWidth = 0;
		// gl.marginLeft = 1;
		// gl.marginRight = 1;
		// gl.marginBottom = 1;
		// backComposite.setLayout(gl);
		// backComposite.setBackground(toolkit.getColors().getColor(IFormColors.BORDER));

		Composite container = toolkit.createComposite(group);
		group.setBackground(container.getBackground());

		Font f = container.getFont();
		if (f != null) {
			FontData fd = f.getFontData()[0];
			if (fd != null)
				group.setFont(new Font(null, new FontData(fd.getName(), fd.getHeight(), SWT.BOLD)));
		}
		GridLayout glayout = new GridLayout();
		glayout.numColumns = 2;
		container.setLayout(glayout);
		String name = Messages.PropertyUICreator_namelabel;
		if (((EAttribute) createOnElementFeature.getFeature(model)).isRequired()) {
			name += "*"; //$NON-NLS-1$
		}
		AttributeFieldEditPart editPart1 = SmooksUIUtils.createSelectorFieldEditor(name, toolkit, container,
				createOnElementFeature, model, editorPart);
		editPart1.setAttribute(createOnElementFeature.getFeature(model));

		String namespace = Messages.PropertyUICreator_nslabel;
		if (((EAttribute) createOnElementFeatureNS.getFeature(model)).isRequired()) {
			namespace += "*"; //$NON-NLS-1$
		}
		AttributeFieldEditPart editPart2 = SmooksUIUtils.createStringFieldEditor(namespace, container, editingdomain,
				toolkit, createOnElementFeatureNS, model, false, false, false, 0, null, SmooksUIUtils.VALUE_TYPE_VALUE,
				null);
		editPart2.setAttribute(createOnElementFeatureNS.getFeature(model));

		// gd = new GridData(GridData.FILL_HORIZONTAL);
		// gd.horizontalSpan = 2;
		//		
		// toolkit.createSeparator(parent, SWT.HORIZONTAL).setLayoutData(gd);

		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		gd.heightHint = 8;

		Composite ccc = toolkit.createComposite(parent);
		ccc.setLayoutData(gd);
		// ccc.setBackground(new Color(null,128,128,128));

		List<AttributeFieldEditPart> list = new ArrayList<AttributeFieldEditPart>();
		list.add(editPart1);
		list.add(editPart2);
		AttributeFieldEditPart dummyEditPart = new AttributeFieldEditPart();
		dummyEditPart.setAttribute(null);
		dummyEditPart.setContentControl(container);
		list.add(dummyEditPart);
		return list;
	}

	public List<AttributeFieldEditPart> createExtendUIOnTop(AdapterFactoryEditingDomain editingDomain,
			FormToolkit formToolkit, Composite detailsComposite, Object model, ISmooksModelProvider formEditor,
			IEditorPart editorPart) {
		return null;
	}
}
