/**
 * JBoss, Home of Professional Open Source
 * Copyright 2009, JBoss Inc., and others contributors as indicated
 * by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 *
 * (C) 2009, JBoss Inc.
 */
package org.jboss.tools.smooks.launch.serialize;

import java.io.StringWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.milyn.payload.JavaResult;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.AbstractXmlWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Object Graph Serializer.
 *
 * @author <a href="mailto:tom.fennelly@jboss.com">tom.fennelly@jboss.com</a>
 */
public class ObjectSerializer extends AbstractXmlWriter {

	private Object rootObject;
	private String rootBeanId;
	private List<Object> items = new ArrayList<Object>();
	private Set<String> referencedBeans = new LinkedHashSet<String>();
	private Map<String, Object> beanContext;
	private int indent = 0;
	private boolean writeNL = false;
	private String serializedForm;
	private StringWriter writer;
	
	public ObjectSerializer(Object object, String beanId, Map<String, Object> beanMap) {
		assertNotNull(object, "object"); //$NON-NLS-1$
		assertNotNull(beanId, "beanId"); //$NON-NLS-1$
		assertNotNull(beanMap, "beanMap"); //$NON-NLS-1$
		this.rootObject = object;
		this.rootBeanId = beanId;
		this.beanContext = beanMap;
		this.serializedForm = writeObject();
	}

	public static String serialize(Object object, Map<String, Object> beanMap) {
		ObjectSerializer serializer = new ObjectSerializer(object, object.getClass().getSimpleName(), beanMap);
		return serializer.getSerializedForm();
	}

	public static Collection<ObjectSerializer> serialize(JavaResult javaResult) {
		StringBuilder stringBuilder = new StringBuilder();
		Map<String, Object> beanMap = javaResult.getResultMap();
		Set<Entry<String, Object>> beanMapEntries = beanMap.entrySet();
		Map<String, ObjectSerializer> serializedObjectMap = new HashMap<String, ObjectSerializer>();
		Set<String> beanNames = beanMap.keySet();
		
		// Create all the ObjectSerializer instances...
		for(Entry<String, Object> beanMapEntry : beanMapEntries) {
			serializedObjectMap.put(beanMapEntry.getKey(), new ObjectSerializer(beanMapEntry.getValue(), beanMapEntry.getKey(), beanMap));
		}
		
		// Now try to work out which can be eliminated by analysing the beans used in each
		// ObjectSerializer instance...
		Set<Entry<String, ObjectSerializer>> serializedObjectMapEntries = serializedObjectMap.entrySet();
		for(Entry<String, ObjectSerializer> serializedObjectMapEntry : serializedObjectMapEntries) {
			beanNames.removeAll(serializedObjectMapEntry.getValue().getReferencedBeans());
		}
				
		if(!beanNames.isEmpty()) {
			// If the beanNames Set is not empty, only return those ObjectSerializer instances...
			List<ObjectSerializer> rootBeans = new ArrayList<ObjectSerializer>();
			
			for(String beanName : beanNames) {
				rootBeans.add(serializedObjectMap.get(beanName));
			}
			
			return rootBeans;
		} else {
			// If the beanNames Set is empty, return all ObjectSerializer instances i.e.
			// we're not able to work out the "root" bean(s)...
			return serializedObjectMap.values();
		}
	}
	
	public Set<String> getReferencedBeans() {
		return referencedBeans;
	}
	
	public String getSerializedForm() {
		return serializedForm;
	}

	private synchronized String writeObject() {
		XStream xstream = new XStream(new DomDriver());
		MarshallingStrategy marshallingStrategy = new MarshallingStrategy(this);
		
		writer = new StringWriter();
		items.clear();
		referencedBeans.clear();
		xstream.setMarshallingStrategy(marshallingStrategy);
		xstream.marshal(rootObject, this);
		
		return writer.toString();
	}

	/* (non-Javadoc)
	 * @see com.thoughtworks.xstream.io.xml.AbstractXmlWriter#startNode(java.lang.String, java.lang.Class)
	 */
	@Override
	public void startNode(String name, Class clazz) {		
		if(writeNL) {
			writer.write("\n");			 //$NON-NLS-1$
		}

		if(indent == 0) {
			// Root object...
			writer.write("> " + rootBeanId);			 //$NON-NLS-1$
		} else {
			writeIndent(indent);
			writer.write("> " + name);			 //$NON-NLS-1$
		}
		
		writeNL = true;
		indent++;
	}
	
	public void startNode(Object item) {
		//write(" (@" + Integer.toHexString(System.identityHashCode(item)) + ")");
		items.add(item);

		String beanId = getBeanId(item, true);
		if(beanId != null) {
			writer.write(" (beanId = \"" + beanId + "\")"); //$NON-NLS-1$ //$NON-NLS-2$
			if(!beanId.equals(rootBeanId)) {
				referencedBeans.add(beanId);
			}
		}
	}
	
	private String getBeanId(Object item, boolean checkCollections) {
		// First see it it one of the root beans...
		Set<Entry<String, Object>> beans = beanContext.entrySet();
		for(Entry<String, Object> bean : beans) {
			if(bean.getValue() == item) {
				return bean.getKey();
			}
		}

		if(checkCollections) {
			// Then, see is it in a Collection bean in one of the root beans...
			for(Entry<String, Object> bean : beans) {
				Object beanObj = bean.getValue();
				
				if(beanObj instanceof Collection) {
					Collection collectionBean = (Collection)beanObj;
					if(collectionContains(collectionBean, item)) {
						// Get the beanId of the first object in the collection
						// that also exists in the root of the beanContext...
						for (Object collectionItem : collectionBean) {
							String beanId = getBeanId(collectionItem, false);
							if(beanId != null) {
								return beanId;
							}
						}
					}
				}
			}
		}
		
		return null;
	}

	private boolean collectionContains(Collection collection, Object item) {
		// Intentionally not using Collection.contains() because it uses
		// Object.equals(), which is not what we want... we need an exact object ref match...
		for(Object object : collection) {
			if(object == item) {
				return true;
			}
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.thoughtworks.xstream.io.HierarchicalStreamWriter#setValue(java.lang.String)
	 */
	public void setValue(String text) {
		Object currentItem = items.get(items.size() - 1);
		
		if((currentItem instanceof String || containsNonNumeric(text)) && !(currentItem instanceof Number)) {
			writer.write(" = \"" + text + "\""); //$NON-NLS-1$ //$NON-NLS-2$
		} else if(currentItem instanceof Number) {
			Class<? extends Object> itemClass = currentItem.getClass();
			if(itemClass.getPackage() == Integer.class.getPackage()) {				
				writer.write(" = " + text + itemClass.getSimpleName().charAt(0)); //$NON-NLS-1$
			} else {
				writer.write(" = " + text); //$NON-NLS-1$
			}
		} else {
			writer.write(" = " + text); //$NON-NLS-1$
		}
		
		writer.write("\n");			 //$NON-NLS-1$
		writeNL = false;
	}

	/* (non-Javadoc)
	 * @see com.thoughtworks.xstream.io.HierarchicalStreamWriter#endNode()
	 */
	public void endNode() {
		indent--;
	}

	/* (non-Javadoc)
	 * @see com.thoughtworks.xstream.io.HierarchicalStreamWriter#startNode(java.lang.String)
	 */
	public void startNode(String name) {
	}

	/* (non-Javadoc)
	 * @see com.thoughtworks.xstream.io.HierarchicalStreamWriter#flush()
	 */
	public void flush() {
		writer.flush();
	}

	private void writeIndent(int count) {
		for(int i = 0; i < count; i++) {
			writer.write("    "); //$NON-NLS-1$
		}
	}

	/* (non-Javadoc)
	 * @see com.thoughtworks.xstream.io.HierarchicalStreamWriter#addAttribute(java.lang.String, java.lang.String)
	 */
	public void addAttribute(String name, String value) {
	}

	/* (non-Javadoc)
	 * @see com.thoughtworks.xstream.io.HierarchicalStreamWriter#close()
	 */
	public void close() {
	}

	private boolean containsNonNumeric(String text) {
		for(int i = 0; i < text.length(); i++) {
			if(!Character.isDigit(text.charAt(i))) {
				return true;
			}
		}
		
		return false;
	}
	
	private void assertNotNull(Object object, String name) {
		if(object == null) {
			throw new IllegalArgumentException("ObjectSerializer argument '" + name + "' is null."); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
}
