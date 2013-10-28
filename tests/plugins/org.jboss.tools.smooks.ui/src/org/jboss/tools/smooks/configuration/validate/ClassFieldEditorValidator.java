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

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
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
import org.eclipse.jdt.core.dom.Modifier;
import org.jboss.tools.smooks.configuration.editors.utils.ProjectClassLoader;
import org.jboss.tools.smooks.configuration.editors.utils.SmooksUIUtils;
import org.jboss.tools.smooks.model.csv12.Binding;
import org.jboss.tools.smooks.model.csv12.Csv12Package;
import org.jboss.tools.smooks.model.javabean12.BeanType;
import org.jboss.tools.smooks.model.javabean12.Javabean12Package;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class ClassFieldEditorValidator extends AbstractValidator {

	private ProjectClassLoader classLoader;

	private List<Object> validationTargetList = null;

	/**
	 * @return the classLoader
	 */
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

	protected void initValidationTargetList() {

		ClassValidationTarget target1 = new ClassValidationTarget();
		target1.setFeature(Javabean12Package.Literals.BEAN_TYPE__CLASS);
		target1.setSupportArrayClass(true);
		target1.setTarget(BeanType.class);
		validationTargetList.add(target1);

		ClassValidationTarget target2 = new ClassValidationTarget();
		target2.setFeature(Csv12Package.Literals.BINDING__CLASS);
		target2.setTarget(Binding.class);
		validationTargetList.add(target2);

		ClassValidationTarget target3 = new ClassValidationTarget();
		validationTargetList.add(target3);
	}

	public List<Object> getValidationTargetList() {
		if (validationTargetList == null) {
			validationTargetList = new ArrayList<Object>();
			initValidationTargetList();
		}
		return validationTargetList;
	}

	public List<Diagnostic> validate(Collection<?> selectionObjects) {
		List<Diagnostic> list = new ArrayList<Diagnostic>();
		for (Iterator<?> iterator = selectionObjects.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			if ((object instanceof EObject)) {
				List<?> targetList = getValidationTargetList();
				for (Iterator<?> iterator2 = targetList.iterator(); iterator2.hasNext();) {
					ClassValidationTarget target = (ClassValidationTarget) iterator2.next();
					Class<?> targetClass = target.getTarget();
					EStructuralFeature feature = target.getFeature();
					if (targetClass.isAssignableFrom(object.getClass()) && feature != null) {
						Object value = ((EObject) object).eGet(feature);
						if (value == null)
							break;
						String classString = value.toString();
						classLoader = getClassLoader((EObject) object);
						if (classString != null) {
							classString = classString.trim();
						} else {
							continue;
						}
						if (target.isSupportArrayClass()) {
							if (classString.endsWith("[]")) { //$NON-NLS-1$
								classString = classString.substring(0, classString.length() - 2);
							}
						}
						Class<?> clazz1 = null;
						if (classString != null && classLoader != null) {
							try {
								clazz1 = classLoader.loadClass(classString);
							} catch (ClassNotFoundException e) {
								// ignore
							}
						}
						String message = null;
						if (clazz1 == null) {
							message = Messages.ClassFieldEditorValidator_Warning_Cannot_Find_Class + classString + "\""; //$NON-NLS-1$
						} else {
							if (Modifier.isAbstract(clazz1.getModifiers())) {
								message = Messages.ClassFieldEditorValidator_Warning_Abstract_Class;
							} else {
								try {
									Constructor<?> constructor = clazz1.getConstructor(null);
								} catch (SecurityException e) {
									message = Messages.ClassFieldEditorValidator_Warning_Class_Cannot_Be_Instanced
											+ classString
											+ Messages.ClassFieldEditorValidator_Warning_Class_Cannot_Be_Instanced2;
								} catch (NoSuchMethodException e) {
									message = Messages.ClassFieldEditorValidator_Warning_Class_Cannot_Be_Instanced
											+ classString
											+ Messages.ClassFieldEditorValidator_Warning_Class_Cannot_Be_Instanced2;
								}
							}

						}
						if (message != null) {
							list.add(newWaringDiagnostic(message, object, (EAttribute) feature));
						}
						break;
					}
				}
			}

			// if (object instanceof Binding) {
			// String classString = ((Binding) object).getClass_();
			// classLoader = getClassLoader((EObject) object);
			// Class<?> clazz1 = null;
			// if (classString != null && classLoader != null) {
			// try {
			// clazz1 = classLoader.loadClass(classString);
			// } catch (ClassNotFoundException e) {
			// // ignore
			// }
			// }
			// String message = "Can't find class : \"" + classString + "\"";
			// if (clazz1 == null) {
			// list.add(newWaringDiagnostic(message, object,
			// JavabeanPackage.Literals.BINDINGS_TYPE__CLASS));
			// }
			// }
			// if (object instanceof BindingsType) {
			// BindingsType bindings = (BindingsType) object;
			// classLoader = getClassLoader(bindings);
			// String clazz = bindings.getClass_();
			// if (clazz != null) {
			// clazz = clazz.trim();
			// if (clazz.endsWith("[]")) {
			// clazz = clazz.substring(0, clazz.length() - 2);
			// }
			// }
			// Class<?> clazz1 = null;
			// if (clazz != null && classLoader != null) {
			// try {
			// clazz1 = classLoader.loadClass(clazz);
			// } catch (ClassNotFoundException e) {
			// // ignore
			// }
			// }
			// String message = "Can't find class : \"" + clazz + "\"";
			// if (clazz1 == null) {
			// list.add(newWaringDiagnostic(message, bindings,
			// JavabeanPackage.Literals.BINDINGS_TYPE__CLASS));
			// }
			// }

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
		return validate(selectedObjects);
	}

	public void initValidator(Collection<?> selectedObjects, EditingDomain editingDomain) {
		// TODO Auto-generated method stub

	}

	private class ClassValidationTarget {
		private boolean supportArrayClass = false;
		private EStructuralFeature feature;
		private Class<?> target;

		public EStructuralFeature getFeature() {
			return feature;
		}

		public void setFeature(EStructuralFeature feature) {
			this.feature = feature;
		}

		public Class<?> getTarget() {
			return target;
		}

		public void setTarget(Class<?> target) {
			this.target = target;
		}

		public boolean isSupportArrayClass() {
			return supportArrayClass;
		}

		public void setSupportArrayClass(boolean supportArrayClass) {
			this.supportArrayClass = supportArrayClass;
		}

	}
}
