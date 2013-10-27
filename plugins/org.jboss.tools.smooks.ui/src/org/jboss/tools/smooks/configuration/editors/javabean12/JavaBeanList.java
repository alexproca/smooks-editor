/**
 * 
 */
package org.jboss.tools.smooks.configuration.editors.javabean12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject;


/**
 * @author Dart
 *
 */
public class JavaBeanList extends JavaBeanModel implements IXMLStructuredObject{
	

	private List<IXMLStructuredObject> children = null;
	
	public List<IXMLStructuredObject> getChildren() {
		if(children == null){
			children = new ArrayList<IXMLStructuredObject>();
		}
		return children;
	}
	
	public JavaBeanList(){
		super(null);
	}

	@Override
	public boolean isPrimitive() {
		return false;
	}
	
	public String getJavaBeanName(JavaBeanModel javaBean){
		List<?> children = getChildren();
		int sameNameBean = 0;
		for (Iterator<?> iterator = children.iterator(); iterator.hasNext();) {
			JavaBeanModel child = (JavaBeanModel) iterator.next();
			if(child.getBeanClass().getName().equals(javaBean.getBeanClass().getName())){
				sameNameBean++;
			}
		}
		if(sameNameBean > 0){
			String name = javaBean.getName() + String.valueOf(sameNameBean);
			while(hasSameNameBean(name,javaBean.getBeanClass())){
				sameNameBean++;
				name = javaBean.getName() + String.valueOf(sameNameBean);
			}
			return name;
		}
		return javaBean.getName();
	}
	
	private boolean hasSameNameBean(String name , Class<?> clazz){
		for (Iterator<?> iterator = children.iterator(); iterator.hasNext();) {
			JavaBeanModel child = (JavaBeanModel) iterator.next();
			if(child.getBeanClass().getName().equals(clazz.getName())){
				if(name.equals(child.getName())){
					return true;
				}
			}
		}
		return false;
	}
	

	public void addJavaBean(JavaBeanModel javaBean){
		if(javaBean == null) return;
		String name = javaBean.getName();
		String n1 = getJavaBeanName(javaBean);
		if(!name.equals(n1)){
			javaBean.setName(n1);
		}
		javaBean.setParent(this);
		this.getChildren().add(javaBean);
	}
	
	public void removeJavaBean(JavaBeanModel javaBean){
		this.getChildren().remove(javaBean);
		javaBean.setParent(null);
	}

	@Override
	public List<?> getProperties() {
		return Collections.EMPTY_LIST;
	}

	public Object getID() {
		return this;
	}

	public String getNodeName() {
		return null;
	}

	public JavaBeanModel getParent() {
		return null;
	}

	public boolean isAttribute() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRootNode() {
		return true;
	}
	
	
	
}
