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

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject;
import org.jboss.tools.smooks.configuration.editors.uitls.JavaPropertyUtils;

/**
 * @author Dart Peng
 * 
 */
public class JavaBeanModel implements IXMLStructuredObject, Cloneable {

	private boolean flat = false;
	
	private boolean expaned = false;

	private Properties extendProperties = new Properties();

	protected PropertyChangeSupport support = new PropertyChangeSupport(this);

	private String beanClassString = null;

	public void setBeanClassString(String beanClassString) {
		this.beanClassString = beanClassString;
	}

	private Object waring = null;

	private Object error = null;

	private String name = ""; //$NON-NLS-1$

	private Class typeRef = null;

	private boolean many = false;

	private boolean collection = false;

	private boolean isPrimitive = false;

	private boolean hasGenericType = false;

	private Class<? extends Object> beanClass = null;

	private JavaBeanModel parent = null;

	public Class getBeanClass() {
		return beanClass;
	}

	private Class parentClass = null;

	// private boolean isRoot = false;

	private boolean isRootClassModel = false;

	/**
	 * @return the isRootClassModel
	 */
	public boolean isRootClassModel() {
		return isRootClassModel || getParent() == null;
	}

	public boolean isFlat() {
		return flat;
	}

	public void setFlat(boolean flat) {
		this.flat = flat;
	}

	/**
	 * @param isRootClassModel
	 *            the isRootClassModel to set
	 */
	public void setRootClassModel(boolean isRootClassModel) {
		this.isRootClassModel = isRootClassModel;
	}

	public void addNodePropetyChangeListener(PropertyChangeListener listener) {
		PropertyChangeListener[] array = support.getPropertyChangeListeners();
		for (int i = 0; i < array.length; i++) {
			if (listener == array[i])
				return;
		}
		support.addPropertyChangeListener(listener);
	}

	public void removeNodePropetyChangeListener(PropertyChangeListener listener) {
		support.removePropertyChangeListener(listener);
	}

	public void cleanAllNodePropertyChangeListeners() {
		PropertyChangeListener[] ps = support.getPropertyChangeListeners();
		for (int i = 0; i < ps.length; i++) {
			PropertyChangeListener p = ps[i];
			support.removePropertyChangeListener(p);
		}
	}

	// /**
	// * @return the isRoot
	// */
	// public boolean isRoot() {
	// return isRoot;
	// }

	public String getBeanClassString() {
		if (beanClassString != null && beanClassString.length() != 0) {
			return this.beanClassString;
		}
		Class clazz = this.getBeanClass();
		if (clazz == null)
			return "<null>"; //$NON-NLS-1$

		if (clazz.isArray()) {
			String s = clazz.getComponentType().getName();
			return s + "[]"; //$NON-NLS-1$
		}
//		if(this.isList()){
//			String cs = "<"+System.currentTimeMillis()+">";
//			Class componentClazz = this.getComponentClass();
//			if(componentClazz != null){
//				cs = "<" + componentClazz.getName() +">";
//			}
//			return clazz.getName() + cs;
//		}

		return clazz.getName();
	}

	public String getBeanClassStringWithList() {
		String s = getBeanClassString();
		if (this.isList()) {
			Class genericType = getGenericType();
			if (genericType != null)
				s += "<" + genericType.getName() + ">"; //$NON-NLS-1$ //$NON-NLS-2$
		}
		return s;
	}

	/**
	 * @param isRoot
	 *            the isRoot to set
	 */
	// public void setRoot(boolean isRoot) {ois
	private boolean isList = false;

	private Class componentClass = null;

	private boolean lazyLoadProperties = true;

	public boolean isList() {
		if (beanClass == null)
			return false;
		if (Collection.class.isAssignableFrom(beanClass)) {
			if (this.propertyDescriptor != null) {
				Method rmethod = propertyDescriptor.getReadMethod();
				if (rmethod != null) {
					Type returnType = rmethod.getGenericReturnType();
					if (returnType instanceof ParameterizedType) {
						Type gtype = ((ParameterizedType) returnType).getActualTypeArguments()[0];
						if(gtype instanceof Class){
							Class beanType = (Class) gtype;
							componentClass = beanType;
							setGenericType(true);
						}
						if(gtype instanceof WildcardType){
							Type[] upperBounds = ((WildcardType)gtype).getUpperBounds();
							Type[] lowerBounds = ((WildcardType)gtype).getLowerBounds();
							if(upperBounds.length != 0){
								componentClass = (Class<?>) upperBounds[0];
								setGenericType(true);
							}
							if(lowerBounds.length != 0){
								componentClass = (Class<?>) lowerBounds[0];
								setGenericType(true);
							}
						}
					}
				}
			}
			setList(true);
		}
		return isList;
	}

	public void setList(boolean isList) {
		this.isList = isList;
	}

	private PropertyDescriptor propertyDescriptor;

	public PropertyDescriptor getPropertyDescriptor() {
		return propertyDescriptor;
	}

	public void setPropertyDescriptor(PropertyDescriptor propertyDescriptor) {
		this.propertyDescriptor = propertyDescriptor;
	}

	JavaBeanModel(Class beanClass, String beanName, PropertyDescriptor propertyDescriptor, Class parentClass,
			boolean lazyLoadProperties) {
		this.lazyLoadProperties = lazyLoadProperties;
		this.beanClass = toConcreteImpl(beanClass);
		this.name = beanName;
		if (beanClass == null)
			return;
		if (this.name == null) {
			this.name = beanClass.getSimpleName();
		}
		if (propertyDescriptor == null)
			setRootClassModel(true);
		this.propertyDescriptor = propertyDescriptor;
		Class beanType = beanClass;
		if (beanClass.isArray()) {
			beanType = beanClass.getComponentType();
			setMany(true);
			componentClass = beanType;
		}

		if (Collection.class.isAssignableFrom(beanClass)) {
			if (this.propertyDescriptor != null) {
				Method rmethod = propertyDescriptor.getReadMethod();
				if (rmethod != null) {
					Type returnType = rmethod.getGenericReturnType();
					if (returnType instanceof ParameterizedType) {
						Type gtype = ((ParameterizedType) returnType).getActualTypeArguments()[0];
						if (gtype instanceof Class) {
							beanType = (Class) gtype;
							componentClass = beanType;
						}
					}
				}
			}
			setList(true);
		}

		if (beanType.isPrimitive() || JavaBeanModelFactory.isPrimitiveObject(beanType)) {
			this.parentClass = parentClass;
			if (!isArray() && !isList())
				setPrimitive(true);
			return;
		}
		this.parentClass = parentClass;

		if (!lazyLoadProperties)
			this.getProperties();
	}

	JavaBeanModel(Class beanClass, String beanName, PropertyDescriptor propertyDescriptor) {
		this(beanClass, beanName, propertyDescriptor, null, true);
	}

	public JavaBeanModel(Class beanClass) {
		this(beanClass, null, null, null, true);
	}

	public JavaBeanModel(Class beanClass, String name) {
		this(beanClass, name, null, null, true);
	}

	JavaBeanModel(Class<?> beanClass, boolean lazyLoadProperties) {
		this(beanClass, null, null, null, lazyLoadProperties);
	}

	private Class<? extends Object> toConcreteImpl(Class declaredType) {		
		
		// Intentionally not doing an isAssignableFrom test... want to know is it the
		// the exact class...
		if(declaredType == List.class) {
			return ArrayList.class;
		} else if(declaredType == Set.class) {
			return LinkedHashSet.class;
		} else if(declaredType == Collection.class) {
			return ArrayList.class;
		} else if(declaredType == Map.class) {
			return LinkedHashMap.class;
		} 
		
		return declaredType;
	}

	public boolean isPrimitive() {
		Class<?> beanType = getBeanClass();
		if (beanType == null)
			return false;
		if (beanType.isPrimitive() || JavaBeanModelFactory.isPrimitiveObject(beanType)) {
			if (!isArray() && !isList())
				setPrimitive(true);
		}
		return isPrimitive;
	}

	public void setPrimitive(boolean isPrimitive) {
		this.isPrimitive = isPrimitive;
	}

	public boolean isArray() {
		if (beanClass == null)
			return false;
		if (beanClass.isArray()) {
			Class beanType = beanClass.getComponentType();
			setMany(true);
			componentClass = beanType;
			setGenericType(true);
		}
		return many;
	}

	public Class getGenericType() {
		return componentClass;
	}

	public void setMany(boolean many) {
		this.many = many;
	}

	// public boolean isCollection() {
	// return collection;
	// }
	//
	// public void setCollection(boolean collection) {
	// this.collection = collection;
	// }

	// public Class getTypeRef() {
	// return typeRef;
	// }
	//
	// public void setTypeRef(Class typeRef) {
	// this.typeRef = typeRef;
	// }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addProperty(JavaBeanModel property) {
		if (properties != null) {
			properties.add(property);
			property.setParent(this);
		}
	}

	protected void createArrayChildren(Class<Object> clazz, String name, PropertyDescriptor pd,
			Class<? extends Object> parentClass, boolean lazyLoad) {
		JavaBeanModel proxyModel = newChildJavaBean(clazz, name, pd, parentClass, lazyLoad);
		addProperty(proxyModel);
	}

	protected void createListChildren(Class<Object> clazz, String name, PropertyDescriptor pd,
			Class<? extends Object> parentClass, boolean lazyLoad) {
		JavaBeanModel proxyModel = newChildJavaBean(clazz, name, pd, parentClass, lazyLoad);
		addProperty(proxyModel);
	}

	private List properties;

	
	/**
	 * @return the expaned
	 */
	public boolean isExpaned() {
		return expaned;
	}

	public List getProperties() {
		expaned = true;
		JavaBeanModel parent = this.getParent();
		if (parent != null) {
			if (parent.isFlat())
				return Collections.emptyList();
		}
		if (properties == null) {
			properties = new ArrayList();
			if (isPrimitive())
				return properties;

			Class beanType = beanClass;
			if (isArray() || isList()) {
				if (componentClass != null) {
					createArrayChildren(componentClass, componentClass.getSimpleName(), null, beanClass,
							this.lazyLoadProperties);
					beanType = componentClass;
				} else {
					createListChildren(Object.class, "object", null, beanClass, this.lazyLoadProperties); //$NON-NLS-1$
					beanType = componentClass;
				}
				return properties;
			}
			if (beanType == null)
				return Collections.EMPTY_LIST;
			PropertyDescriptor[] pds = JavaPropertyUtils.getPropertyDescriptor(beanType);
			for (int i = 0; i < pds.length; i++) {
				PropertyDescriptor pd = pds[i];
				if ("class".equals(pd.getName())) //$NON-NLS-1$
					continue;
				if (pd.getPropertyType() == null)
					continue;
				if (Collection.class.isAssignableFrom(pd.getPropertyType())) {
					Method rmethod = pd.getReadMethod();
					if (rmethod != null) {
						Type returnType = rmethod.getGenericReturnType();
						if (returnType instanceof ParameterizedType) {
							Type[] types = ((ParameterizedType) returnType).getActualTypeArguments();
							if (types == null || types.length == 0) {
								continue;
							}
						} else {
							continue;
						}
					}
				}
				JavaBeanModel jbm = newChildJavaBean(pd.getPropertyType(), pd.getName(), pd, beanClass,
						this.lazyLoadProperties);
				addProperty(jbm);
			}
		}
		return properties;
	}

	protected JavaBeanModel newChildJavaBean(Class clazz, String name, PropertyDescriptor pd,
			Class parentClass, boolean lazyLoading) {
		return new JavaBeanModel(clazz, name, pd, parentClass, lazyLoading);
	}

	public void setProperties(List properties) {
		this.properties = properties;
	}

	public boolean propertiesHasBeenLoaded() {
		return properties != null;
	}

	/**
	 * @return the parent
	 */
	public JavaBeanModel getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(JavaBeanModel parent) {
		this.parent = parent;
	}

	public Object getWarning() {
		return waring;
	}

	public void setWarning(Object waring) {
		this.waring = waring;
	}

	public Object getError() {
		return error;
	}

	public void setError(Object error) {
		this.error = error;
	}

	public JavaBeanModel getRootParent() {
		JavaBeanModel parent = this.getParent();
		if (parent == null)
			return this;
		JavaBeanModel temp = parent;
		while (temp != null) {
			parent = temp;
			temp = temp.getParent();
		}
		return parent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer("JavaName : " + name); //$NON-NLS-1$
		if (beanClass != null)
			buffer.append("BeanClass : " + this.beanClass.getName()); //$NON-NLS-1$
		if (this.properties != null) {
			buffer.append("\n"); //$NON-NLS-1$
			for (Iterator<?> iterator = properties.iterator(); iterator.hasNext();) {
				JavaBeanModel child = (JavaBeanModel) iterator.next();
				buffer.append("\t"); //$NON-NLS-1$
				buffer.append(child.toString());
				buffer.append("\n"); //$NON-NLS-1$
			}
		}
		return buffer.toString();
	}

	public String getSelectorString() {
		if (parent == null) {
			return getBeanClassString();
		}
		if (parent.getClass() == JavaBeanList.class) {
			return getBeanClassString();
		}

		if (parent.isArray() || parent.isList()) {
			return getBeanClassString();
		}
		return getName();

	}

	public boolean hasGenericType() {
		return hasGenericType;
	}

	public void setGenericType(boolean hasGenericType) {
		this.hasGenericType = hasGenericType;
	}

	public boolean isAttribute() {
		return false;
	}

	public List<IXMLStructuredObject> getChildren() {
		List ps = getProperties();
		if (ps != null) {
			return ps;
		}
		return null;
	}

	public Object getID() {
		Class<?> clazz = getBeanClass();
		if(Collection.class.isAssignableFrom(clazz)){
			return getBeanClassString() + getName();
		}
		return getBeanClass();
	}

	public String getNodeName() {
		return getSelectorString();
	}

	public boolean isRootNode() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setComponentClass(Class clazz) {
		componentClass = clazz;
	}

	public Class getComponentClass() {
		return componentClass;
	}

	public void addExtendProperty(String name, String value) {
		extendProperties.setProperty(name, value);
	}

	public String getExtendProperty(String name) {
		return extendProperties.getProperty(name);
	}

	public Object clone() {
		if (isList()) {
			JavaBeanModel model = JavaBeanModelFactory.getJavaBeanModelWithLazyLoad(ArrayList.class);
			model.setComponentClass(componentClass);
			return model;
		}
		return JavaBeanModelFactory.getJavaBeanModelWithLazyLoad(this.getBeanClass());
	}

}
