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

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.jboss.tools.smooks.configuration.editors.input.InputParameter;
import org.jboss.tools.smooks.configuration.editors.input.InputType;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.model.smooks.AbstractReader;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;

/**
 * @author Dart
 * 
 */
public class SmooksConfigurationReaderPage extends SmooksConfigurationFormPage {

	private CheckboxTableViewer inputDataViewer;

	boolean lockCheck = false;

	public SmooksConfigurationReaderPage(FormEditor editor, String id, String title) {
		super(editor, id, title);
	}

	public SmooksConfigurationReaderPage(String id, String title) {
		super(id, title);
	}

	@Override
	protected ViewerFilter[] createViewerFilters() {
		return new ViewerFilter[] { new OnlyReaderViewerFilter() };
	}

	@Override
	protected SmooksMasterDetailBlock createSmooksMasterDetailsBlock() {
		SmooksMasterDetailBlock detailBlock = new SmooksMasterDetailBlock(getEditor(),
				(AdapterFactoryEditingDomain) ((SmooksMultiFormEditor) getEditor()).getEditingDomain()) {
			@Override
			protected Object getEmptyDefaultSelection(EObject smooksTreeViewerInput) {
				List<EObject> contents = smooksTreeViewerInput.eContents();
				for (Iterator<?> iterator = contents.iterator(); iterator.hasNext();) {
					EObject eObject = (EObject) iterator.next();
					if (smooksTreeViewerInput instanceof SmooksResourceListType && eObject instanceof AbstractReader) {
						return eObject;
					}
				}
				return super.getEmptyDefaultSelection(smooksTreeViewerInput);
			}
		};
		return detailBlock;
	}

	@Override
	protected String getNewSmooksElementDescription() {
		return Messages.SmooksConfigurationReaderPage_NewReaderDes;
	}

	@Override
	protected String getNewSmooksElementTitle() {
		return Messages.SmooksConfigurationReaderPage_NewReaderTitle;
	}

	@Override
	protected String getMainSectionDescription() {
		return Messages.SmooksConfigurationReaderPage_EditReaderDes;
	}

	@Override
	protected String getMainSectionTitle() {
		return Messages.SmooksConfigurationReaderPage_ReaderSectionTitle;
	}

	@Override
	protected void setPageTitle(ScrolledForm form) {
		form.setText(Messages.SmooksConfigurationReaderPage_PageTitle);
	}

	protected void createFormContent(IManagedForm managedForm) {
		super.createFormContent(managedForm);
		// create extention UI for add/remove extention data
		createExtentionArea(managedForm);
	}

	protected void createExtentionArea(IManagedForm managedForm) {
		FormToolkit toolkit = managedForm.getToolkit();
		final ScrolledForm form = managedForm.getForm();
		Section section = toolkit.createSection(form.getBody(), Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		section.setLayoutData(gd);
		section.setText(Messages.SmooksConfigurationReaderPage_InputSectionTitle);
		FillLayout flayout = new FillLayout();
		section.setLayout(flayout);

		Composite mainComposite = toolkit.createComposite(section, SWT.NONE);
		GridLayout gl = new GridLayout();
		gl.numColumns = 2;
		mainComposite.setLayout(gl);
		section.setClient(mainComposite);

		Composite tableComposite = toolkit.createComposite(mainComposite, SWT.NONE);
		FillLayout fillLayout = new FillLayout();
		fillLayout.marginHeight = 1;
		fillLayout.marginWidth = 1;
		gd = new GridData(GridData.FILL_BOTH);
		tableComposite.setLayoutData(gd);
		tableComposite.setBackground(GraphicsConstants.BORDER_CORLOR);
		tableComposite.setLayout(fillLayout);

		inputDataViewer = CheckboxTableViewer.newCheckList(tableComposite, SWT.MULTI | SWT.FULL_SELECTION);
		inputDataViewer.setCheckStateProvider(new ICheckStateProvider() {

			public boolean isGrayed(Object element) {
				return false;
			}

			public boolean isChecked(Object element) {
				if (element instanceof InputType) {
					return ((InputType) element).isActived();
					// List<ParamType> params = ((InputType)
					// element).getParam();
					// for (Iterator<?> iterator = params.iterator();
					// iterator.hasNext();) {
					// ParamType paramType = (ParamType) iterator.next();
					// if
					// (SmooksModelUtils.PARAM_NAME_ACTIVED.equals(paramType.getName()))
					// {
					// String value = paramType.getValue();
					// if (value == null)
					// return false;
					// value = value.trim();
					// return "true".equalsIgnoreCase(value);
					// }
					// }
				}
				return false;
			}
		});
		inputDataViewer.addCheckStateListener(new ICheckStateListener() {

			public void checkStateChanged(CheckStateChangedEvent event) {
				if (lockCheck)
					return;
				boolean checked = event.getChecked();
				InputType inputType = (InputType) event.getElement();
				List<InputParameter> params = inputType.getParameters();

				if (checked) {
					boolean newOne = true;
					inputType.setActived(checked);
					// for (Iterator<?> iterator = params.iterator();
					// iterator.hasNext();) {
					// InputParameter paramType = (InputParameter)
					// iterator.next();
					// if
					// (SmooksModelUtils.PARAM_NAME_ACTIVED.equals(paramType.getName()))
					// {
					// paramType.setValue(String.valueOf(checked));
					// newOne = false;
					// break;
					// }
					// }
					// if (newOne) {
					// ParamType p = GraphFactory.eINSTANCE.createParamType();
					// p.setName(SmooksModelUtils.PARAM_NAME_ACTIVED);
					// p.setValue(String.valueOf(checked));
					// inputType.getParam().add(p);
					// }

					Object[] checkedObjects = inputDataViewer.getCheckedElements();
					for (int i = 0; i < checkedObjects.length; i++) {
						InputType type = (InputType) checkedObjects[i];
						type.setActived(!checked);
						// if (type == event.getElement())
						// continue;
						// List<ParamType> params1 = type.getParam();
						// for (Iterator<?> iterator = params1.iterator();
						// iterator.hasNext();) {
						// ParamType paramType = (ParamType) iterator.next();
						// if
						// (SmooksModelUtils.PARAM_NAME_ACTIVED.equals(paramType.getName()))
						// {
						// paramType.setValue(String.valueOf(!checked));
						// break;
						// }
						// }
						lockCheck = true;
						inputDataViewer.setChecked(type, false);
						lockCheck = false;
					}

				} else {
					inputType.setActived(checked);
					// for (Iterator<?> iterator = params.iterator();
					// iterator.hasNext();) {
					// ParamType paramType = (ParamType) iterator.next();
					// if
					// (SmooksModelUtils.PARAM_NAME_ACTIVED.equals(paramType.getName()))
					// {
					// paramType.setValue(String.valueOf(checked));
					// break;
					// }
					// }
				}

				// EObject ext = inputType;
				// while (ext != null && !(ext instanceof
				// SmooksGraphicsExtType)) {
				// ext = ext.eContainer();
				// }
				//
				// if (ext != null && ext instanceof SmooksGraphicsExtType) {
				// List<ISmooksGraphChangeListener> listeners =
				// ((SmooksGraphicsExtType) ext).getChangeListeners();
				// for (Iterator<?> iterator = listeners.iterator();
				// iterator.hasNext();) {
				// ISmooksGraphChangeListener smooksGraphChangeListener =
				// (ISmooksGraphChangeListener) iterator
				// .next();
				// smooksGraphChangeListener.inputTypeChanged((SmooksGraphicsExtType)
				// ext);
				// }
				// }

			}
		});
		TableColumn header = new TableColumn(inputDataViewer.getTable(), SWT.NONE);
		header.setText(Messages.SmooksConfigurationReaderPage_InputTableTypeColumnText);
		header.setWidth(100);
		TableColumn pathColumn = new TableColumn(inputDataViewer.getTable(), SWT.NONE);
		pathColumn.setText(Messages.SmooksConfigurationReaderPage_InputTablePathColumnLabel);
		pathColumn.setWidth(300);

		TableColumn extColumn = new TableColumn(inputDataViewer.getTable(), SWT.NONE);
		extColumn.setText(Messages.SmooksConfigurationReaderPage_InputTableExtensionLabel);
		extColumn.setWidth(400);

		inputDataViewer.setContentProvider(new ExtentionInputContentProvider());
		inputDataViewer.setLabelProvider(new ExtentionInputLabelProvider());
		inputDataViewer.getTable().setHeaderVisible(true);
		inputDataViewer.getTable().setLinesVisible(true);

		ISmooksModelProvider smooksModelProvider = (ISmooksModelProvider) getAdapter(ISmooksModelProvider.class);
		if (smooksModelProvider != null) {
			inputDataViewer.setInput(SmooksUIUtils.getSmooks11ResourceListType(smooksModelProvider.getSmooksModel()));
		}
		Composite buttonComposite = toolkit.createComposite(mainComposite, SWT.NONE);
		gd = new GridData(GridData.FILL_VERTICAL);
		buttonComposite.setLayoutData(gd);
		GridLayout l = new GridLayout();
		buttonComposite.setLayout(l);

		Button addButton = toolkit.createButton(buttonComposite, Messages.SmooksConfigurationReaderPage_AddInputButtonLabel, SWT.FLAT);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		addButton.setLayoutData(gd);
		addButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				showInputDataWizard();
			}

		});

		Button removeButton = toolkit.createButton(buttonComposite, Messages.SmooksConfigurationReaderPage_DeleteInputButtonLabel, SWT.FLAT);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		removeButton.setLayoutData(gd);
		removeButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection selection = (IStructuredSelection) inputDataViewer.getSelection();
				if (selection != null) {
					ISmooksModelProvider modelProvider = (ISmooksModelProvider) getAdapter(ISmooksModelProvider.class);
					if(modelProvider == null){
						return;
					}
					Object[] objs = selection.toArray();
					for (int i = 0; i < objs.length; i++) {
						Object obj = objs[i];
						if (obj instanceof InputType) {
							InputType input = (InputType)obj;
							SmooksUIUtils.removeInputType(input,modelProvider);
						}
					}


					// List<ISmooksGraphChangeListener> listeners =
					// extType.getChangeListeners();
					// for (Iterator<?> iterator = listeners.iterator();
					// iterator.hasNext();) {
					// ISmooksGraphChangeListener smooksGraphChangeListener =
					// (ISmooksGraphChangeListener) iterator
					// .next();
					// smooksGraphChangeListener.inputTypeChanged(extType);
					// }
				}
			}
		});
	}

	// public void inputTypeChanged(SmooksGraphicsExtType extType) {
	// if (inputDataViewer != null)
	// inputDataViewer.refresh();
	// }

}
