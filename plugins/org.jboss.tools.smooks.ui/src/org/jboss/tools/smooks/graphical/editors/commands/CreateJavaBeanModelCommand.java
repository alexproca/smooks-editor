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
package org.jboss.tools.smooks.graphical.editors.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorPart;
import org.jboss.tools.smooks.configuration.editors.javabean12.JavaBeanModel;
import org.jboss.tools.smooks.configuration.editors.utils.SmooksUIUtils;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.gef.tree.command.GEFAdapterCommand;
import org.jboss.tools.smooks.graphical.editors.SmooksGraphicalEditorPart;
import org.jboss.tools.smooks.graphical.wizards.JavaBeanCreationWizard;
import org.jboss.tools.smooks.model.javabean12.BeanType;
import org.jboss.tools.smooks.model.javabean12.Javabean12Factory;
import org.jboss.tools.smooks.model.javabean12.ValueType;
import org.jboss.tools.smooks.model.javabean12.WiringType;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;

/**
 * @author Dart
 * 
 */
public class CreateJavaBeanModelCommand extends GEFAdapterCommand {

	private IEditorPart editorPart = null;

	public static final int BEAN_TYPE = 2;

	private ISmooksModelProvider provider = null;

	public CreateJavaBeanModelCommand(EditingDomain domain, Command emfCommand, IEditorPart editorPart,
			ISmooksModelProvider provider) {
		super(domain, emfCommand);
		this.editorPart = editorPart;
		this.provider = provider;
	}

	boolean firstTime = true;

	@Override
	public void execute() {
		if (firstTime) {
			JavaBeanCreationWizard wizard = new JavaBeanCreationWizard(provider, null);
			if (editorPart != null && collections != null && owner != null && feature != null) {
				final WizardDialog dialog = new WizardDialog(editorPart.getSite().getShell(), wizard);
				if (dialog.open() == Dialog.OK) {
					Object model = collections;
					if (collections instanceof FeatureMap.Entry) {
						model = ((FeatureMap.Entry) collections).getValue();
					}
					int type = BEAN_TYPE;
					SmooksResourceListType resourceListType = null;
					if (editorPart instanceof SmooksGraphicalEditorPart) {
						resourceListType = ((SmooksGraphicalEditorPart) editorPart).getSmooksResourceListType();
					}
					List<Object> models = createJavaBeanModel(type, wizard.getJavaBeanModel(), wizard.getBindings(),
							resourceListType, new ArrayList<String>());
					String figureID = null;
					int index = 0;

					List<Object> creationModels = new ArrayList<Object>();

					if (collections instanceof FeatureMap.Entry) {
						for (Iterator<?> iterator = models.iterator(); iterator.hasNext();) {
							Object object = (Object) iterator.next();
							creationModels.add(FeatureMapUtil.createEntry(((FeatureMap.Entry) collections)
									.getEStructuralFeature(), object));
						}
					}
					collections = creationModels;

					emfCommand = AddCommand.create(domain, owner, feature, creationModels);
				} else {
					throw new IgnoreException();
				}
			}
			firstTime = false;
		}
		super.execute();
	}

	private List<Object> createJavaBeanModel(int type, JavaBeanModel parentBeanModel, Object[] properties,
			SmooksResourceListType resourceListType, List<String> ids) {
		List<Object> creationObject = new ArrayList<Object>();
		Object parent = null;
		if (type == BEAN_TYPE) {
			parent = Javabean12Factory.eINSTANCE.createBeanType();
		}
		creationObject.add(parent);
		String beanID = generateBeanID(parentBeanModel, resourceListType, ids);
		ids.add(beanID);
		if (parent instanceof BeanType) {
			((BeanType) parent).setBeanId(beanID);
			((BeanType) parent).setClass(parentBeanModel.getBeanClassString());
			if (properties != null && properties.length > 0) {
				for (int i = 0; i < properties.length; i++) {
					Object beanPropertyObj = properties[i];
					if (beanPropertyObj instanceof JavaBeanModel && belongsToMe(parentBeanModel, (JavaBeanModel) beanPropertyObj)) {
						JavaBeanModel beanProperty = (JavaBeanModel) beanPropertyObj;
						if (beanProperty.isPrimitive()) {
							ValueType value = Javabean12Factory.eINSTANCE.createValueType();
							value.setProperty(beanProperty.getName());
							((BeanType) parent).getValue().add(value);
						} else {
							WiringType value = Javabean12Factory.eINSTANCE.createWiringType();
							if (!parentBeanModel.isArray() && !parentBeanModel.isList()) {
								value.setProperty(beanProperty.getName());
							}
							String refID = generateBeanID(beanProperty, resourceListType, ids);
							value.setBeanIdRef(refID);
							((BeanType) parent).getWiring().add(value);
							creationObject.addAll(createJavaBeanModel(type, beanProperty, properties,
									resourceListType, ids));
						}
					}
				}
			} else if(parentBeanModel.isList()) {
				WiringType value = Javabean12Factory.eINSTANCE.createWiringType();
				((BeanType) parent).getWiring().add(value);				
			}
		}
//		if (parent instanceof BindingsType) {
//			((BindingsType) parent).setBeanId(beanID);
//			((BindingsType) parent).setClass(parentBeanModel.getBeanClassString());
//			if (properties != null) {
//				for (int i = 0; i < properties.length; i++) {
//					Object pro = properties[i];
//					if (pro instanceof JavaBeanModel && belongsToMe(parentBeanModel, (JavaBeanModel) pro)) {
//						if (((JavaBeanModel) pro).isPrimitive()) {
//							org.jboss.tools.smooks.model.javabean.ValueType value = JavabeanFactory.eINSTANCE
//									.createValueType();
//							value.setProperty(((JavaBeanModel) pro).getName());
//							((BindingsType) parent).getValue().add(value);
//						} else {
//							org.jboss.tools.smooks.model.javabean.WiringType value = JavabeanFactory.eINSTANCE
//									.createWiringType();
//							if (((JavaBeanModel) parentBeanModel).isArray()
//									|| ((JavaBeanModel) parentBeanModel).isList()) {
//
//							} else {
//								value.setProperty(((JavaBeanModel) pro).getName());
//							}
//							String refID = generateBeanID((JavaBeanModel) pro, resourceListType, ids);
//							value.setBeanIdRef(refID);
//							((BindingsType) parent).getWiring().add(value);
//							creationObject.addAll(createJavaBeanModel(type, (JavaBeanModel) pro, properties,
//									resourceListType, ids));
//						}
//					}
//				}
//			}
//		}
		return creationObject;
	}

	private String generateBeanID(JavaBeanModel parentBeanModel, SmooksResourceListType listType, List<String> ids) {
		String pn = parentBeanModel.getName();
		int index = 1;
		while (idExsit(pn, listType, ids)) {
			pn = pn + String.valueOf(index);
			index = index + 1;
		}
		return pn;
	}

	private boolean idExsit(String id, SmooksResourceListType listType, List<String> ids) {
		Collection<EObject> models = SmooksUIUtils.getBeanIdModelList(listType);
		for (Iterator<?> iterator = models.iterator(); iterator.hasNext();) {
			EObject eObject = (EObject) iterator.next();
			if (eObject == null)
				continue;
			EStructuralFeature feature = SmooksUIUtils.getBeanIDFeature(eObject);
			if (feature == null)
				continue;
			Object obj = eObject.eGet(feature);
			if (obj == null)
				continue;
			String id1 = obj.toString();
			if (id != null && id1 != null) {
				if (id.equals(id1)) {
					return true;
				}
			}
		}
		for (Iterator<String> iterator = ids.iterator(); iterator.hasNext();) {
			String i = (String) iterator.next();
			if (id != null && i != null) {
				if (id.equals(i)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean belongsToMe(JavaBeanModel parent, JavaBeanModel child) {
		if (parent != null && parent.isExpaned()) {
			return (parent.getChildren().indexOf(child) != -1);
		}
		return false;
	}

}
