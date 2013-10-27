package org.jboss.tools.smooks.configuration.editors.uitls;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Dart Peng<br>
 *         Date : Sep 10, 2008
 */
public class JavaPropertyUtils {

	private static JavaPropertyUtils instace = null;

	public static PropertyDescriptor[] getPropertyDescriptor(Class clazz) {
		try {
			return getInstace().getPropertyDescriptorArray(clazz);
		} catch (Exception e) {
			// ignore
			return new PropertyDescriptor[]{};
		}
	}
	
	public static Method[] getSetterMethods(Class<?> clazz){
		if(clazz == null){
			return new Method[]{};
		}
		Method[] methods = clazz.getMethods();
		List<Method> mlist = new ArrayList<Method>();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			String methodName = method.getName();
			if(methodName.startsWith("set")){ //$NON-NLS-1$
				mlist.add(method);
			}
		}
		return mlist.toArray(new Method[]{});
	}

	/**
	 * 
	 * @param clazz
	 * @return
	 * @throws IntrospectionException
	 */
	public PropertyDescriptor[] getPropertyDescriptorArray(Class clazz)
			throws IntrospectionException {
		// TODO should improve (use some catch to store the BeanInfo , right?)
		return Introspector
				.getBeanInfo(clazz, Introspector.IGNORE_ALL_BEANINFO)
				.getPropertyDescriptors();
	}

	public static JavaPropertyUtils getInstace() {
		if (instace == null) {
			instace = new JavaPropertyUtils();
		}
		return instace;
	}
}
