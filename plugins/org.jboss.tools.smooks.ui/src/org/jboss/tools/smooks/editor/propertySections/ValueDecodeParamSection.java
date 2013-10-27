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
package org.jboss.tools.smooks.editor.propertySections;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;
import org.jboss.tools.smooks.graphical.editors.model.javamapping.JavaBeanChildGraphModel;
import org.jboss.tools.smooks.model.javabean12.DecodeParamType;
import org.jboss.tools.smooks.model.javabean12.Javabean12Package;
import org.jboss.tools.smooks.model.javabean12.ValueType;
import org.milyn.javabean.DataDecoder;
import org.milyn.javabean.decoders.EnumDecoder;
import org.milyn.javabean.decoders.IntegerDecoder;

/**
 * @author Dart
 * 
 */
public class ValueDecodeParamSection extends AbstractSmooksPropertySection {

	private Composite controlComposite;
	private TableViewer paramterViewer;
	private CCombo decoderCombo;
	boolean isEnumTarget;
	private TableColumn nameColumn;
	private TableColumn valueColumn;

	private static List<String> DECODERS = new ArrayList<String>();

	static {
		Map<Class, Class<? extends DataDecoder>> map = DataDecoder.Factory.getInstalledDecoders();
		Collection<Class<? extends DataDecoder>> decoders = map.values();
		DECODERS.add(""); //$NON-NLS-1$
		for (Iterator<Class<? extends DataDecoder>> iterator = decoders.iterator(); iterator.hasNext();) {
			Class<? extends DataDecoder> dataDecoderClass = iterator.next();
			if (dataDecoderClass != null) {
				String name = dataDecoderClass.getSimpleName();
				if (name.endsWith("Decoder")) { //$NON-NLS-1$
					name = name.substring(0, name.length() - "Decoder".length()); //$NON-NLS-1$
				}
				if (!DECODERS.contains(name)) {
					DECODERS.add(name);
				}
			}
		}
		Collections.sort(DECODERS);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#createControls
	 * (org.eclipse.swt.widgets.Composite,
	 * org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		TabbedPropertySheetWidgetFactory factory = aTabbedPropertySheetPage.getWidgetFactory();

		Section section = createRootSection(factory, parent);
		section.setText(Messages.ValueDecodeParamSection_SectionTitle);

		controlComposite = factory.createComposite(section, SWT.NONE);

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.horizontalSpacing = 13;
		gridLayout.verticalSpacing = 20;

		controlComposite.setLayout(gridLayout);

		section.setClient(controlComposite);

		createDecoderCombo(factory, controlComposite);

		createDecodeParamViewer(factory, controlComposite);
	}

	private void createDecoderCombo(TabbedPropertySheetWidgetFactory factory, Composite parent) {
		factory.createLabel(controlComposite, Messages.ValueDecodeParamSection_DecoderLabel).setForeground(factory.getColors().getColor(IFormColors.TITLE));
		decoderCombo = factory.createCCombo(parent, SWT.READ_ONLY);
		// decoderCombo.setEditable(false);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		decoderCombo.setLayoutData(gd);

		for (Iterator<?> iterator = DECODERS.iterator(); iterator.hasNext();) {
			String decoderName = (String) iterator.next();
			decoderCombo.add(decoderName);
		}

		decoderCombo.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				changeDecoder();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}

	private void changeDecoder() {
		ISmooksModelProvider provider = getSmooksModelProvider();
		if (provider != null) {
			AdapterFactoryEditingDomain editingDomain = (AdapterFactoryEditingDomain) provider.getEditingDomain();
			String newDecoder = decoderCombo.getText();
			TreeNodeConnection lineModel = (TreeNodeConnection) getPresentSelectedGraphModel();
			Object model = lineModel.getTargetNode().getData();
			model = AdapterFactoryEditingDomain.unwrap(model);
			if (model != null && model instanceof ValueType) {
				String decoder = ((ValueType) model).getDecoder();
				if (newDecoder.equals(decoder)) {
					// same decoder
					return;
				}
				CompoundCommand command = new CompoundCommand();

				Command setCommand = SetCommand.create(editingDomain, model,
						Javabean12Package.Literals.VALUE_TYPE__DECODER, newDecoder);
				if (((ValueType) model).getDecodeParam().isEmpty()) {

				} else {
					Command removeCommand = RemoveCommand.create(editingDomain, ((ValueType) model).getDecodeParam());
					command.append(setCommand);
					command.append(removeCommand);
				}

				if (command.isEmpty()) {
					editingDomain.getCommandStack().execute(setCommand);
				} else {
					editingDomain.getCommandStack().execute(command);
				}

				initDecodeParamViewer();
			}
		}
	}

	private void createDecodeParamViewer(TabbedPropertySheetWidgetFactory factory, Composite sashForm) {
		GridData gd = new GridData(GridData.FILL_BOTH);

		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		Label label = factory.createLabel(sashForm, Messages.ValueDecodeParamSection_DecoderParamLabel);
		label.setLayoutData(gd);
		label.setForeground(factory.getColors().getColor(IFormColors.TITLE));

		Composite viewerComposite = factory.createComposite(sashForm, SWT.NONE);
		gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 2;
		gd.heightHint = 150;
		viewerComposite.setLayoutData(gd);
		viewerComposite.setBackground(factory.getColors().getBorderColor());
//		Composite viewerContianer = factory.createComposite(viewerComposite, SWT.NONE);
//		gd = new GridData(GridData.FILL_BOTH);
//		gd.heightHint = 150;
//		viewerContianer.setLayoutData(gd);
		

		FillLayout layout = new FillLayout();
		
		layout.marginHeight = 1;
		layout.marginWidth = 1;
		viewerComposite.setLayout(layout);

		paramterViewer = new TableViewer(viewerComposite, SWT.FULL_SELECTION);
		paramterViewer.setContentProvider(new DecodeParamViewerContentProvider());
		paramterViewer.setLabelProvider(new DecodeParamTypeLabelProvider());

		paramterViewer.setFilters(new ViewerFilter[] { new DecodeParamTypeFilter() });

		nameColumn = new TableColumn(paramterViewer.getTable(), SWT.NONE);
		valueColumn = new TableColumn(paramterViewer.getTable(), SWT.NONE);
		nameColumn.setText(Messages.ValueDecodeParamSection_ParamNameColumnText);
		valueColumn.setText(Messages.ValueDecodeParamSection_ParamValueColumnText);
		nameColumn.setWidth(150);
		valueColumn.setWidth(150);

		paramterViewer.setCellEditors(new CellEditor[] { new TextCellEditor(paramterViewer.getTable()), new TextCellEditor(paramterViewer.getTable()) });
		paramterViewer.setColumnProperties(new String[] { "name", "value" }); //$NON-NLS-1$ //$NON-NLS-2$

		paramterViewer.setCellModifier(new DecodeParamCellModifier());

		paramterViewer.getTable().setHeaderVisible(true);
		paramterViewer.getTable().setLinesVisible(true);

	}

	private void initDecoderCombo() {
		decoderCombo.select(-1);
		TreeNodeConnection lineModel = (TreeNodeConnection) getPresentSelectedGraphModel();
		AbstractSmooksGraphicalModel targetNode = lineModel.getTargetNode();
		
		if(targetNode instanceof JavaBeanChildGraphModel) {
			JavaBeanChildGraphModel javaBeanChildGraphModel = (JavaBeanChildGraphModel)targetNode;
			Object bindingTypeObj = javaBeanChildGraphModel.getBindingTypeObj();
			
			if (bindingTypeObj != null && bindingTypeObj instanceof ValueType) {
				Class<?> targetPropertyType = javaBeanChildGraphModel.getJavaType();
				String decoderAlias = ((ValueType) bindingTypeObj).getDecoder();
				
				if(decoderAlias != null) {
					// The decoder is configured...
					int index = DECODERS.indexOf(decoderAlias.trim());
					decoderCombo.select(index);
				} else {
					// Try work out the decoder based on the target property type...
					DataDecoder decoder = DataDecoder.Factory.create(targetPropertyType);
					if(decoder.getClass().getPackage() == IntegerDecoder.class.getPackage()) {
						String decoderName = decoder.getClass().getSimpleName();
						if(decoderName.endsWith("Decoder")) { //$NON-NLS-1$
							decoderAlias = decoderName.substring(0, decoderName.length() - "Decoder".length()); //$NON-NLS-1$
							int index = DECODERS.indexOf(decoderAlias);
							decoderCombo.select(index);
						}
					}
				}
			}
		}
	}

	private void initDecodeParamViewer() {
		paramterViewer.setInput("NULL"); //$NON-NLS-1$
		TreeNodeConnection lineModel = (TreeNodeConnection) getPresentSelectedGraphModel();
		AbstractSmooksGraphicalModel targetNode = lineModel.getTargetNode();
		
		if(targetNode instanceof JavaBeanChildGraphModel) {
			JavaBeanChildGraphModel javaBeanChildGraphModel = (JavaBeanChildGraphModel)targetNode;
			Object bindingTypeObj = javaBeanChildGraphModel.getBindingTypeObj();
			
			if (bindingTypeObj != null && bindingTypeObj instanceof ValueType) {
				Class<?> targetPropertyType = javaBeanChildGraphModel.getJavaType();
				String decoderAlias = ((ValueType) bindingTypeObj).getDecoder();
				DataDecoder decoder;
				DecodeParamMetaData[] decodeParamMetaData;
				
				if(decoderAlias != null) {
					// The decoder is configured...
					decoder = DataDecoder.Factory.create(decoderAlias);
				} else {
					// Try work out the decoder based on the target property type...
					decoder = DataDecoder.Factory.create(targetPropertyType);
				}
				
				if(decoder instanceof EnumDecoder) {
					// Get the enum values based on the targetPropertyType enum etc...
					isEnumTarget = true;
					paramterViewer.setInput(newEnumDecodeParamSet(targetPropertyType, (ValueType) bindingTypeObj, javaBeanChildGraphModel));
					nameColumn.setText(Messages.ValueDecodeParamSection_EnumParamNameColumnText);
					valueColumn.setText(Messages.ValueDecodeParamSection_EnumParamValueColumnText);
				} else {
					isEnumTarget = false;
					nameColumn.setText(Messages.ValueDecodeParamSection_ParamNameColumnText);
					valueColumn.setText(Messages.ValueDecodeParamSection_ParamValueColumnText);
					decodeParamMetaData = DecodeParamMetaDataFactory.getDecodeParamMetaData(decoder.getClass());					
					if(decodeParamMetaData != null) {
						paramterViewer.setInput(newDecodeParam(decodeParamMetaData, ((ValueType) bindingTypeObj)));
					}
				}
			}
		}
	}

	private List<DecodeParam> newDecodeParam(DecodeParamMetaData[] decodeParamMetaData, ValueType valueType) {
		List<DecodeParam> list = new ArrayList<DecodeParam>();
		for (int i = 0; i < decodeParamMetaData.length; i++) {
			DecodeParamMetaData decodeParamMD = decodeParamMetaData[i];
			DecodeParam p = new DecodeParam();
			DecodeParamType dp = findDecodeParamType(decodeParamMD.getName(), valueType);

			p.setName(decodeParamMD.getName());
			if (dp != null) {
				String dpv = dp.getValue();
				if (dpv != null) {
					dpv = dpv.trim();
				}
				p.setValue(dpv);				
			} else if(decodeParamMD.getDefaultVal() != null) {
				p.setValue(decodeParamMD.getDefaultVal());
			} else if(decodeParamMD.isRequiresConfiguration()) {
				// TODO: We need to raise a warning...
			}
			
			list.add(p);
		}
		return list;
	}

	private List<DecodeParam> newEnumDecodeParamSet(Class<?> enumType, ValueType valueType, JavaBeanChildGraphModel enumValueModelNode) {
		List<DecodeParam> list = new ArrayList<DecodeParam>();
		Properties configuredParams = JavaBeanChildGraphModel.getDecoderParams(valueType);

		if(!configuredParams.isEmpty()) {
			// Already configured...
			Set<Entry<Object, Object>> paramSet = configuredParams.entrySet();
			for(Entry<Object, Object> param : paramSet) {
				String paramName = param.getKey().toString();
				
				if(!paramName.equals("enumType")) { //$NON-NLS-1$
					DecodeParam p = new DecodeParam();
					p.setName(paramName);
					p.setValue(param.getValue().toString());
					list.add(p);
				}
			}			
		} else {
			Field[] enumFields = enumType.getDeclaredFields();

			for(Field enumField : enumFields) {
				if(enumField.isEnumConstant()) {
					DecodeParam p = new DecodeParam();
					p.setName(enumField.getName());
					p.setValue(enumField.getName());
					list.add(p);
				}
			}

			// And add them to the model...
			enumValueModelNode.newEnumDecodeParamSet(enumType, valueType);
		}

		return list;
	}

	private DecodeParamType findDecodeParamType(String name, ValueType valueType) {
		List<?> ps = valueType.getDecodeParam();
		for (Iterator<?> iterator = ps.iterator(); iterator.hasNext();) {
			DecodeParamType dp = (DecodeParamType) iterator.next();
			String dpn = dp.getName();
			if (dpn != null)
				dpn = dpn.trim();

			if (name.equals(dpn)) {
				return dp;
			}
		}
		return null;
	}

	protected void createDecodeParamGUIContents(Object model, ISmooksModelProvider provider, IEditorPart part,
			FormToolkit factory, Composite controlComposite) {
//		ModelPanelCreator creator = new ModelPanelCreator();
//		model = AdapterFactoryEditingDomain.unwrap(model);
//		if (model != null && model instanceof EObject && provider != null && part != null) {
//			AdapterFactoryEditingDomain domain = (AdapterFactoryEditingDomain) provider.getEditingDomain();
//			IItemPropertySource itemPropertySource = (IItemPropertySource) domain.getAdapterFactory().adapt(model,
//					IItemPropertySource.class);
//			if (itemPropertySource != null) {
//				creator
//						.createModelPanel((EObject) model, factory, controlComposite, itemPropertySource, provider,
//								part);
//			}
//		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.editor.propertySections.AbstractSmooksPropertySection
	 * #refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
		initDecoderCombo();
		initDecodeParamViewer();
	}

	private class DecodeParamViewerContentProvider implements IStructuredContentProvider {

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub

		}

		public void dispose() {
			// TODO Auto-generated method stub

		}

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Collection<?>) {
				return ((Collection<?>) inputElement).toArray();
			}
			return new Object[] {};
		}
	}

	private class DecodeParam {
		String name;
		String value;

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name
		 *            the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}

		/**
		 * @param value
		 *            the value to set
		 */
		public void setValue(String value) {
			this.value = value;
		}

	}

	private class DecodeParamTypeLabelProvider extends LabelProvider implements ITableLabelProvider {

		public DecodeParamTypeLabelProvider() {
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java
		 * .lang.Object, int)
		 */
		public Image getColumnImage(Object element, int columnIndex) {
			// if (labelProvider != null && columnIndex == 0) {
			// return labelProvider.getImage(element);
			// }
			return null;
		}

		public String getColumnText(Object object, int columnIndex) {
			Object obj = AdapterFactoryEditingDomain.unwrap(object);
			if (columnIndex == 0) {
				// if (obj instanceof DecodeParamType) {
				// String name = ((DecodeParamType) obj).getName();
				// if (name == null)
				//						name = ""; //$NON-NLS-1$
				// return name;
				// }
				if (obj instanceof DecodeParam) {
					String name = ((DecodeParam) obj).getName();
					if (name == null)
						name = ""; //$NON-NLS-1$
					return name;
				}
			}

			if (columnIndex == 1) {
				// if (obj instanceof DecodeParamType) {
				// String value = ((DecodeParamType) obj).getValue();
				// if (value == null)
				//						value = ""; //$NON-NLS-1$
				// return value;
				// }
				if (obj instanceof DecodeParam) {
					String value = ((DecodeParam) obj).getValue();
					if (value == null)
						value = ""; //$NON-NLS-1$
					return value;
				}
			}
			return ""; //$NON-NLS-1$
		}

	}

	private class DecodeParamTypeFilter extends ViewerFilter {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers
		 * .Viewer, java.lang.Object, java.lang.Object)
		 */
		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			element = AdapterFactoryEditingDomain.unwrap(element);
			if (element instanceof DecodeParam) {
				return true;
			}
			return false;
		}
	}

	
	private class DecodeParamCellModifier implements ICellModifier {

		public void modify(Object element, String property, Object value) {
			if (element instanceof TableItem) {
				Object currentElement = ((TableItem) element).getData();
				TreeNodeConnection lineModel = (TreeNodeConnection) getPresentSelectedGraphModel();
				EditingDomain editingDomain = getSmooksModelProvider().getEditingDomain();
				Object model = lineModel.getTargetNode().getData();

				model = AdapterFactoryEditingDomain.unwrap(model);
				if (model != null && model instanceof ValueType && currentElement instanceof DecodeParam) {
					String pname = ((DecodeParam) currentElement).getName();
					DecodeParamType paramType = findDecodeParamType(pname, (ValueType) model);
					Command command = null;
					if (!isEnumTarget && property.equals("value")) { //$NON-NLS-1$
						if (value != null) {
							String svalue = ((String) value).trim();
							if ("".equals(svalue)) { //$NON-NLS-1$
								if (paramType != null) {
									command = RemoveCommand.create(editingDomain, paramType);
								}
							} else {
								// if param is empty , add it
								if (paramType == null) {
									AbstractSmooksGraphicalModel targetNode = lineModel.getTargetNode();										
									if(targetNode instanceof JavaBeanChildGraphModel) {
										command = ((JavaBeanChildGraphModel)targetNode).addDecodeParam(pname, (String) value, (ValueType) model);
									}
								} else {
									command = SetCommand.create(editingDomain, paramType,
											Javabean12Package.Literals.DECODE_PARAM_TYPE__VALUE, value);
								}
							}
						}
						if (command != null) {
							editingDomain.getCommandStack().execute(command);
							((DecodeParam) currentElement).setValue((String) value);
							paramterViewer.update(currentElement, new String[] { property });
						}
					} else if (isEnumTarget && property.equals("name")) { //$NON-NLS-1$
						if (value != null) {
							String svalue = ((String) value).trim();
							if ("".equals(svalue)) { //$NON-NLS-1$
								// Can't blank it for an enum... ignore...
							} else {
								command = SetCommand.create(editingDomain, paramType,
										Javabean12Package.Literals.DECODE_PARAM_TYPE__NAME, value);
								editingDomain.getCommandStack().execute(command);
								((DecodeParam) currentElement).setName((String) value);
								paramterViewer.update(currentElement, new String[] { property });
							}
						}
					}
				}
			}
		}

		public Object getValue(Object element, String property) {
			element = AdapterFactoryEditingDomain.unwrap(element);
			if (!isEnumTarget && property.equals("value")) { //$NON-NLS-1$
				if (element instanceof DecodeParam) {
					String name = ((DecodeParam) element).getValue();
					if (name == null)
						name = ""; //$NON-NLS-1$
					return name;
				}
			} else if (isEnumTarget && property.equals("name")) { //$NON-NLS-1$
				if (element instanceof DecodeParam) {
					String name = ((DecodeParam) element).getName();
					if (name == null)
						name = ""; //$NON-NLS-1$
					return name;
				}
			}
			return null;
		}

		public boolean canModify(Object element, String property) {
			if (property.equals(isEnumTarget?"name":"value")) { //$NON-NLS-1$ //$NON-NLS-2$
				if (element instanceof DecodeParam) {
					return true;
				}
			}
			return false;
		}
	}	
}
