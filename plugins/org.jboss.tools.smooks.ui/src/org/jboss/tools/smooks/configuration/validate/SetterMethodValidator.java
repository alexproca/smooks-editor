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
package org.jboss.tools.smooks.configuration.validate;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.jboss.tools.smooks.configuration.editors.uitls.JavaPropertyUtils;
import org.jboss.tools.smooks.configuration.editors.uitls.ProjectClassLoader;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.model.javabean12.Javabean12Package;

/**
 * @author Dart
 * 
 */
public class SetterMethodValidator extends AbstractValidator {

	private ProjectClassLoader classLoader;

	private List<Object> validationTargetList = null;

	public SetterMethodValidator() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.configuration.validate.ISmooksValidator#initValidator
	 * (java.util.Collection, org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public void initValidator(Collection<?> selectedObjects, EditingDomain editingDomain) {

	}

	public ProjectClassLoader getClassLoader(EObject obj) {
		if (classLoader != null) {
			return classLoader;
		}
		IResource resource = SmooksUIUtils.getResource(obj);
		if (resource == null)
			return null;
		try {
			classLoader = new ProjectClassLoader(JavaCore.create(resource.getProject()));
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return classLoader;
	}

	public List<Object> getValidationTargetList() {
		if (validationTargetList == null) {
			validationTargetList = new ArrayList<Object>();
			initValidationTargetList();
		}
		return validationTargetList;
	}

	protected void initValidationTargetList() {
//		PropertySetterValidateTarget target = new PropertySetterValidateTarget();
//		target.setPropertyFeature(JavabeanPackage.Literals.VALUE_TYPE__PROPERTY);
//		target.setSetterMethodFeature(JavabeanPackage.Literals.VALUE_TYPE__SETTER_METHOD);
//		target.setTargetClass(ValueType.class);
//		validationTargetList.add(target);

		PropertySetterValidateTarget target2 = new PropertySetterValidateTarget();
		target2.setPropertyFeature(Javabean12Package.Literals.VALUE_TYPE__PROPERTY);
		target2.setSetterMethodFeature(Javabean12Package.Literals.VALUE_TYPE__SETTER_METHOD);
		target2.setTargetClass(org.jboss.tools.smooks.model.javabean12.ValueType.class);
		validationTargetList.add(target2);

//		PropertySetterValidateTarget target4 = new PropertySetterValidateTarget();
//		target4.setPropertyFeature(JavabeanPackage.Literals.WIRING_TYPE__PROPERTY);
//		target4.setSetterMethodFeature(JavabeanPackage.Literals.WIRING_TYPE__SETTER_METHOD);
//		target4.setTargetClass(WiringType.class);
//		validationTargetList.add(target4);

		PropertySetterValidateTarget target6 = new PropertySetterValidateTarget();
		target6.setPropertyFeature(Javabean12Package.Literals.WIRING_TYPE__PROPERTY);
		target6.setSetterMethodFeature(Javabean12Package.Literals.WIRING_TYPE__SETTER_METHOD);
		target6.setTargetClass(org.jboss.tools.smooks.model.javabean12.WiringType.class);
		validationTargetList.add(target6);

//		PropertySetterValidateTarget target8 = new PropertySetterValidateTarget();
//		target8.setPropertyFeature(JavabeanPackage.Literals.EXPRESSION_TYPE__PROPERTY);
//		target8.setSetterMethodFeature(JavabeanPackage.Literals.EXPRESSION_TYPE__SETTER_METHOD);
//		target8.setTargetClass(ExpressionType.class);
//		validationTargetList.add(target8);

		PropertySetterValidateTarget target10 = new PropertySetterValidateTarget();
		target10.setPropertyFeature(Javabean12Package.Literals.EXPRESSION_TYPE__PROPERTY);
		target10.setSetterMethodFeature(Javabean12Package.Literals.EXPRESSION_TYPE__SETTER_METHOD);
		target10.setTargetClass(org.jboss.tools.smooks.model.javabean12.ExpressionType.class);
		validationTargetList.add(target10);
	}

	public List<Diagnostic> validate(Collection<?> selectionObjects) {
		List<Diagnostic> list = new ArrayList<Diagnostic>();
		for (Iterator<?> iterator = selectionObjects.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			if ((object instanceof EObject)) {
				List<?> targetList = getValidationTargetList();
				for (Iterator<?> iterator2 = targetList.iterator(); iterator2.hasNext();) {
					PropertySetterValidateTarget target = (PropertySetterValidateTarget) iterator2.next();
					Class<?> targetClass = target.getTargetClass();
					EStructuralFeature sFeature = target.getSetterMethodFeature();
					boolean isSetterMethod = false;
					if (targetClass.isInstance(object) && sFeature != null) {
						Object sValue = ((EObject) object).eGet(sFeature);
						String setterMethodString = null;
						if (sValue != null) {
							setterMethodString = sValue.toString();
							isSetterMethod = true;
						}
						if (sValue == null) {
							break;
						}

						classLoader = getClassLoader((EObject) object);

						EStructuralFeature classFeature = SmooksUIUtils
								.getClassFeature(((EObject) object).eContainer());
						if (classFeature == null) {
							break;
						}
						Object classData = (((EObject) object).eContainer()).eGet(classFeature);
						if (classData == null) {
							break;
						}
						String classString = classData.toString();
						Class<?> clazz1 = null;
						if (classString != null && classLoader != null) {
							try {
								clazz1 = classLoader.loadClass(classString);
							} catch (ClassNotFoundException e) {
								// ignore
							}
						}
						if (clazz1 == null) {
							break;
						}

						if (setterMethodString != null) {
							setterMethodString = setterMethodString.trim();
						}
						
						if (isSetterMethod && setterMethodString.length() != 0 && setterMethodString != null) {
							boolean correct = false;
							Method[] ms = JavaPropertyUtils.getSetterMethods(clazz1);
							for (int i = 0; i < ms.length; i++) {
								Method method = ms[i];
								if (method.getName().equals(setterMethodString)) {
									correct = true;
									break;
								}
							}
							if (!correct) {
								String message = Messages.SetterMethodValidator_Warning_Setter_Method + setterMethodString + Messages.SetterMethodValidator_Warning_Cannot_Be_Found;
								list.add(newWaringDiagnostic(message, object, (EAttribute) sFeature));
							}
						}
					}
				}
			}

			if (object instanceof EObject) {
				List<Diagnostic> dd = validate(((EObject) object).eContents());
				if (dd != null) {
					list.addAll(dd);
				}
			}
		}
		return list;
	}

	public List<Diagnostic> validate(Collection<?> selectedObjects, EditingDomain editingDomain) {
		try {
			return validate(selectedObjects);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	private class PropertySetterValidateTarget {
		private Class<?> targetClass;

		private EStructuralFeature feature;

		private EStructuralFeature setterMethodFeature;

		/**
		 * @return the setterMethodFeature
		 */
		public EStructuralFeature getSetterMethodFeature() {
			return setterMethodFeature;
		}

		/**
		 * @param setterMethodFeature
		 *            the setterMethodFeature to set
		 */
		public void setSetterMethodFeature(EStructuralFeature setterMethodFeature) {
			this.setterMethodFeature = setterMethodFeature;
		}

		/**
		 * @return the targetClass
		 */
		public Class<?> getTargetClass() {
			return targetClass;
		}

		/**
		 * @param targetClass
		 *            the targetClass to set
		 */
		public void setTargetClass(Class<?> targetClass) {
			this.targetClass = targetClass;
		}

		/**
		 * @return the feature
		 */
		public EStructuralFeature getPropertyFeature() {
			return feature;
		}

		/**
		 * @param feature
		 *            the feature to set
		 */
		public void setPropertyFeature(EStructuralFeature feature) {
			this.feature = feature;
		}

	}

}
