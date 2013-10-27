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

import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.jboss.tools.smooks.configuration.editors.uitls.IModelProcsser;
import org.jboss.tools.smooks.configuration.editors.uitls.INumberParser;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.model.common.AbstractAnyType;

/**
 * @author Dart dpeng@redhat.com
 * 
 */
public class ModelPanelCreator {

	private Map<Object, Object> currentPropertyUIMap = new HashMap<Object, Object>();

	private EObject model;

	/**
	 * @return the propertySource
	 */
	public IItemPropertySource getPropertySource() {
		return propertySource;
	}

	/**
	 * @param propertySource
	 *            the propertySource to set
	 */
	public void setPropertySource(IItemPropertySource propertySource) {
		this.propertySource = propertySource;
	}

	/**
	 * @return the model
	 */
	public EObject getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(EObject model) {
		this.model = model;
	}

	private IItemPropertySource propertySource;

	public ModelPanelCreator() {

	}

	public ModelPanelCreator(EObject model, IItemPropertySource propertySource) {
		this.model = model;
		this.propertySource = propertySource;
	}

	protected void cleanCurrentPropertyUIMap() {
		currentPropertyUIMap.clear();
	}

	public Map<Object, Object> createModelPanel(FormToolkit formToolkit, Composite detailsComposite,
			ISmooksModelProvider provider, IEditorPart part) {
		return this.createModelPanel(model, formToolkit, detailsComposite, propertySource, provider, part);
	}

	public Map<Object, Object> createModelPanel(final EObject model, FormToolkit formToolkit,
			Composite detailsComposite, IItemPropertySource itemPropertySource, ISmooksModelProvider provider,
			IEditorPart part) {
		cleanCurrentPropertyUIMap();
		IPropertyUICreator creator = PropertyUICreatorManager.getInstance().getPropertyUICreator(model);
		List<IItemPropertyDescriptor> propertyDes = itemPropertySource.getPropertyDescriptors(model);
		if (creator != null) {
			List<AttributeFieldEditPart> list = creator.createExtendUIOnTop((AdapterFactoryEditingDomain) provider
					.getEditingDomain(), formToolkit, detailsComposite, model, provider, part);
			if (list != null) {
				for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
					AttributeFieldEditPart attributeFieldEditPart = (AttributeFieldEditPart) iterator.next();
					if (attributeFieldEditPart == null)
						continue;
					Object attribute = attributeFieldEditPart.getAttribute();
					if (attribute != null && attributeFieldEditPart != null) {
						currentPropertyUIMap.put(attribute, attributeFieldEditPart);
					}
				}
			}
		}

		for (int i = 0; i < propertyDes.size(); i++) {
			IItemPropertyDescriptor pd = propertyDes.get(i);
			EAttribute attribute = (EAttribute) pd.getFeature(model);
			if (attribute.isRequired()) {
				AttributeFieldEditPart editPart = createAttributeUI(model, formToolkit, provider, part,
						detailsComposite, pd, creator);
				if (editPart != null && attribute != null) {
					currentPropertyUIMap.put(attribute, editPart);
				}
			}
		}
		for (int i = 0; i < propertyDes.size(); i++) {
			IItemPropertyDescriptor pd = propertyDes.get(i);
			EAttribute attribute = (EAttribute) pd.getFeature(model);
			if (!attribute.isRequired()) {
				AttributeFieldEditPart editPart = createAttributeUI(model, formToolkit, provider, part,
						detailsComposite, pd, creator);
				if (editPart != null && attribute != null) {
					currentPropertyUIMap.put(attribute, editPart);
				}
			}
		}
		if (creator != null) {
			List<AttributeFieldEditPart> list = creator.createExtendUIOnBottom((AdapterFactoryEditingDomain) provider
					.getEditingDomain(), formToolkit, detailsComposite, model, provider, part);
			if (list != null) {
				for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
					AttributeFieldEditPart attributeFieldEditPart = (AttributeFieldEditPart) iterator.next();
					if (attributeFieldEditPart == null)
						continue;
					Object attribute = attributeFieldEditPart.getAttribute();
					if (attribute != null && attributeFieldEditPart != null) {
						currentPropertyUIMap.put(attribute, attributeFieldEditPart);
					}
				}
			}
		}
		formToolkit.paintBordersFor(detailsComposite);
		detailsComposite.pack();
		// propertyMainComposite.layout();

		markPropertyUI(provider.getDiagnosticList(), model);

		Map<Object, Object> map = new HashMap<Object, Object>();
		// map.putAll(currentPropertyUIMap);

		return map;
	}

	public void markPropertyUI(List<Diagnostic> diagnosticList) {
		markPropertyUI(diagnosticList, model);
	}

	public void markPropertyUI(List<Diagnostic> diagnosticList, final EObject model) {
		for (Iterator<?> iterator = currentPropertyUIMap.values().iterator(); iterator.hasNext();) {
			AttributeFieldEditPart editPart = (AttributeFieldEditPart) iterator.next();
			if (editPart.getFieldMarker() != null) {
				editPart.getFieldMarker().clean();
			}
		}
		for (Iterator<?> iterator = diagnosticList.iterator(); iterator.hasNext();) {
			Diagnostic diagnostic = (Diagnostic) iterator.next();
			markErrorWarningPropertyUI(diagnostic, model);
		}
	}

	protected AttributeFieldEditPart createAttributeUI(final EObject model, FormToolkit formToolkit,
			ISmooksModelProvider provider, IEditorPart part, Composite detailsComposite,
			IItemPropertyDescriptor propertyDescriptor, IPropertyUICreator creator) {
		final IItemPropertyDescriptor itemPropertyDescriptor = propertyDescriptor;
		EAttribute feature = (EAttribute) itemPropertyDescriptor.getFeature(model);
		AttributeFieldEditPart editPart = null;
		boolean createDefault = true;
		if (creator != null) {
			if (creator.ignoreProperty(feature)) {
				return null;
			}
			editPart = creator.createPropertyUI(formToolkit, detailsComposite, itemPropertyDescriptor, model, feature,
					provider, part);
			if (editPart != null) {
				createDefault = false;
			}
		}
		if (createDefault) {
			EClassifier typeClazz = feature.getEType();
			boolean hasCreated = false;
			Class<?> instanceClass = typeClazz.getInstanceClass();
			if (typeClazz instanceof EEnum) {
				editPart = createEnumFieldEditor(formToolkit, model, detailsComposite, feature, (EEnum) typeClazz,
						formToolkit, itemPropertyDescriptor);
				hasCreated = true;
			}
			if (instanceClass == String.class) {
				editPart = createStringFieldEditor(model, detailsComposite, feature, formToolkit,
						itemPropertyDescriptor);
				hasCreated = true;
			}
			if (instanceClass == Boolean.class || instanceClass == boolean.class) {
				editPart = createBooleanFieldEditor(model, detailsComposite, feature, formToolkit,
						itemPropertyDescriptor);
				hasCreated = true;
			}
			if (instanceClass == Integer.class || instanceClass == int.class) {
				editPart = createIntegerFieldEditor(model, detailsComposite, feature, formToolkit,
						itemPropertyDescriptor);
				hasCreated = true;
			}
			if(Number.class.isAssignableFrom(instanceClass)){
				editPart = createBigIntegerFieldEditor(model, detailsComposite, feature, formToolkit,
						itemPropertyDescriptor);
				hasCreated = true;
			}
			if (!hasCreated) {
				// createStringFieldEditor(detailsComposite, feature,
				// formToolkit,
				// itemPropertyDescriptor);
			}
		}

		return editPart;
	}

	protected AttributeFieldEditPart createBigIntegerFieldEditor(Object model, final Composite propertyComposite,
			EAttribute feature, FormToolkit formToolKit, final IItemPropertyDescriptor itemPropertyDescriptor) {
		return SmooksUIUtils.createNumberFieldEditor(null, propertyComposite, formToolKit, itemPropertyDescriptor,
				model , new INumberParser() {
					
					public Object transformText(String text) {
						return BigInteger.valueOf(Long.parseLong(text));
					}
				});
	}

	protected AttributeFieldEditPart createIntegerFieldEditor(Object model, final Composite propertyComposite,
			EAttribute feature, FormToolkit formToolKit, final IItemPropertyDescriptor itemPropertyDescriptor) {
		return SmooksUIUtils.createNumberFieldEditor(null, propertyComposite, formToolKit, itemPropertyDescriptor,
				model , new INumberParser() {
					
					public Object transformText(String text) {
						
						return Integer.parseInt(text);
					}
				});
	}

	protected AttributeFieldEditPart createEnumFieldEditor(FormToolkit formToolkit, final EObject model,
			Composite propertyComposite, EAttribute feature, final EEnum typeClass, FormToolkit formToolKit,
			final IItemPropertyDescriptor itemPropertyDescriptor) {
		List<EEnumLiteral> literalList = typeClass.getELiterals();
		String[] items = new String[literalList.size()];
		for (int i = 0; i < literalList.size(); i++) {
			EEnumLiteral enumLiteral = (EEnumLiteral) literalList.get(i);
			items[i] = (enumLiteral.getName());
		}
		final IItemPropertyDescriptor fip = itemPropertyDescriptor;
		IModelProcsser processer = new IModelProcsser() {

			public Object unwrapValue(Object model) {
				if (model instanceof Enumerator) {
					return ((Enumerator) model).getName();
				} else {
					Object editValue = SmooksUIUtils.getEditValue(fip, model);
					if (editValue instanceof Enumerator) {
						return ((Enumerator) editValue).getName();
					}
				}
				return null;
			}

			public Object wrapValue(Object model) {
				String name = model.toString();
				Object v = null;
				try {
					Method method = typeClass.getInstanceClass().getMethod("get", new Class<?>[] { String.class }); //$NON-NLS-1$
					// it's static method
					if (method != null) {
						v = method.invoke(null, name);
					}
				} catch (Throwable t) {
				}
				return v;
			}

		};
		return SmooksUIUtils.createChoiceFieldEditor(propertyComposite, formToolkit, itemPropertyDescriptor, model,
				items, processer, true);
	}

	protected AttributeFieldEditPart createBooleanFieldEditor(final EObject model, final Composite propertyComposite,
			EAttribute feature, FormToolkit formToolkit, final IItemPropertyDescriptor itemPropertyDescriptor) {
		IModelProcsser processer = new IModelProcsser() {

			public Object unwrapValue(Object model) {
				if (model instanceof Boolean) {
					if ((Boolean) model) {
						return "TRUE"; //$NON-NLS-1$
					} else {
						return "FALSE"; //$NON-NLS-1$
					}
				}
				return "FALSE"; //$NON-NLS-1$
			}

			public Object wrapValue(Object model) {
				try {
					return Boolean.parseBoolean(model.toString());
				} catch (Throwable t) {
				}
				return Boolean.FALSE;
			}

		};
		return SmooksUIUtils.createChoiceFieldEditor(propertyComposite, formToolkit, itemPropertyDescriptor, model,
				new String[] { "TRUE", "FALSE" }, processer, true); //$NON-NLS-1$ //$NON-NLS-2$
	}

	protected AttributeFieldEditPart createStringFieldEditor(final EObject model, final Composite propertyComposite,
			EAttribute feature, FormToolkit formToolKit, final IItemPropertyDescriptor itemPropertyDescriptor) {
		return SmooksUIUtils.createStringFieldEditor(propertyComposite, formToolKit, itemPropertyDescriptor, model,
				false, false, null);
	}

	protected void markErrorWarningPropertyUI(Diagnostic diagnostic, final EObject currentModel) {
		if (diagnostic == null || diagnostic.getSeverity() == Diagnostic.OK) {
			return;
		}
		List<?> data = diagnostic.getData();
		for (Object object : data) {
			if (object instanceof EObject) {
				EObject eObject = (EObject) object;
				if (eObject instanceof AbstractAnyType) {
					if (eObject != currentModel) {
						return;
					}
				}
				if (eObject instanceof EAttribute) {
					AttributeFieldEditPart editPart = (AttributeFieldEditPart) currentPropertyUIMap.get(eObject);
					if (editPart == null) {
						return;
					}
					IFieldMarker marker = editPart.getFieldMarker();
					if (marker == null)
						return;

					if (diagnostic.getSeverity() == Diagnostic.ERROR) {
						if (marker.getMarkerType() != IFieldMarker.TYPE_ERROR) {
							marker.setMarkerType(IFieldMarker.TYPE_ERROR);
							marker.setMessage(diagnostic.getMessage());
						}
					}
					if (diagnostic.getSeverity() == Diagnostic.WARNING) {
						// if there is error already , don't mark warning
						if (marker.getMarkerType() != IFieldMarker.TYPE_WARINING
								&& marker.getMarkerType() != IFieldMarker.TYPE_ERROR) {
							marker.setMarkerType(IFieldMarker.TYPE_WARINING);
							marker.setMessage(diagnostic.getMessage());
						}
					}
				}
			}
		}

		List<Diagnostic> children = diagnostic.getChildren();
		for (Iterator<?> iterator = children.iterator(); iterator.hasNext();) {
			Diagnostic diagnostic2 = (Diagnostic) iterator.next();
			markErrorWarningPropertyUI(diagnostic2, currentModel);
		}

	}

}
