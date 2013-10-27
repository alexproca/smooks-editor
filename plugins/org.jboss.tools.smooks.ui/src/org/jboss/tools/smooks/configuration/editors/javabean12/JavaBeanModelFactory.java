/*******************************************************************************
 * Copyright (c) 2007 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.smooks.configuration.editors.javabean12;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dart Peng
 * 
 */
public class JavaBeanModelFactory {

	private static final List<Object> PRIMITIVE_CLASSES = new ArrayList<Object>();
	static {
		PRIMITIVE_CLASSES.add(Integer.class);
		PRIMITIVE_CLASSES.add(Double.class);
		PRIMITIVE_CLASSES.add(Float.class);
		PRIMITIVE_CLASSES.add(String.class);
		PRIMITIVE_CLASSES.add(Long.class);
		PRIMITIVE_CLASSES.add(java.util.Date.class);
		PRIMITIVE_CLASSES.add(Character.class);
		PRIMITIVE_CLASSES.add(BigInteger.class);
		PRIMITIVE_CLASSES.add(BigDecimal.class);
		PRIMITIVE_CLASSES.add(Boolean.class);
		PRIMITIVE_CLASSES.add(Byte.class);
		PRIMITIVE_CLASSES.add(java.util.Calendar.class);
	}

	/**
	 * @param beanClass
	 * @param modelName
	 * @return
	 */
	public synchronized static JavaBeanModel getJavaBeanModelWithLazyLoad(Class<?> beanClass) {
		JavaBeanModel m = new JavaBeanModel(beanClass, true);
		m.setRootClassModel(true);
		return m;
	}

	/**
	 * @deprecated
	 * @param beanClass
	 * @return
	 */
	public synchronized static JavaBeanModel getJavaBeanModel(Class<?> beanClass) {
		JavaBeanModel m = new JavaBeanModel(beanClass, false);
		m.setRootClassModel(true);
		return m;
	}

	public static boolean isPrimitiveObject(Class<?> clazz) {
		if(clazz.isEnum()) return true;
		return (PRIMITIVE_CLASSES.indexOf(clazz) != -1);
	}
}
