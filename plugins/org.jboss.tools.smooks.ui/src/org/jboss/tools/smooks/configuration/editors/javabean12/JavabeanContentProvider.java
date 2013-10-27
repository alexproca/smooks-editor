package org.jboss.tools.smooks.configuration.editors.javabean12;

import java.util.Collection;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject;
/**
 * 
 * @author Dart Peng
 *
 */
public class JavabeanContentProvider implements ITreeContentProvider,
		IStructuredContentProvider {

	public Object[] getChildren(Object arg0) {
		if (arg0 instanceof IXMLStructuredObject) {
			return ((IXMLStructuredObject) arg0).getChildren().toArray();
		}
		return new Object[] {};
	}

	public Object getParent(Object arg0) {
		if(arg0 instanceof JavaBeanModel){
			return ((JavaBeanModel)arg0).getParent();
		}
		return null;
	}

	public boolean hasChildren(Object bean) {
		if (bean instanceof JavaBeanModel) {
			return !((JavaBeanModel) bean).isPrimitive();
		}
		return false;
	}

	public Object[] getElements(Object arg0) {
		if (arg0 instanceof JavaBeanList) {
			return ((JavaBeanList) arg0).getChildren().toArray();
		}
		
		if (arg0 instanceof Collection<?>) {
			return ((Collection<?>) arg0).toArray();
		}
		return new Object[]{};
	}

	public void dispose() {

	}

	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {

	}

}