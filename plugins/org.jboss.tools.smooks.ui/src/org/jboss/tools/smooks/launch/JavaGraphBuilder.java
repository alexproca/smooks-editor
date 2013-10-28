package org.jboss.tools.smooks.launch;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public  class JavaGraphBuilder {

    public <T> T buildGraph(Class<T> messageType) {
        try {
            return buildObject(messageType);
        } catch (Exception e) {
        	e.printStackTrace();
            throw new IllegalArgumentException("Unable to construct an instance of '" + messageType.getName() + "'", e);
        }
    }

    @SuppressWarnings("unchecked")
	private <T> T buildObject(Class<T> objectType) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {

        if(String.class.isAssignableFrom(objectType)) {
            return objectType.cast("x");
        } else if(Number.class.isAssignableFrom(objectType)) {
            return objectType.getConstructor(String.class).newInstance("1");
        } else if(objectType.isPrimitive()) {
            return (T) primitiveToObjectMap.get(objectType);
        } else if(objectType == Object.class) {
            // don't construct raw Object types... leave them and just return null...
            return null;
        } else if(objectType.isEnum()) {
        	return (T) EnumSet.allOf((Class<Enum>)objectType).iterator().next();
        }

        T messageInstance = objectType.newInstance();

        // populate all the fields...
        Method[] methods = objectType.getMethods();
        for(Method method : methods) {
            if(method.getName().startsWith("set") && method.getParameterTypes().length == 1) {
                Class<?> propertyType = method.getParameterTypes()[0];
                Object propertyInstance = null;

                if(Collection.class.isAssignableFrom(propertyType)) {
                    propertyInstance = buildCollection(method, propertyType);
                } else if(propertyType.isArray()) {
	                propertyInstance = buildArray(method, propertyType);
                } else {
                    propertyInstance = buildObject(propertyType);
                }

                if(propertyInstance != null) {
                    method.invoke(messageInstance, propertyInstance);
                }
            }
        }

        return messageInstance;
    }

	private Object buildArray(Method method, Class<?> propertyType) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
		Class<?> arrayType = propertyType.getComponentType();
        Object[] arrayObj = (Object[]) Array.newInstance(arrayType, 1);
        
        Array.set(arrayObj, 0, buildObject(arrayType));
		
		return arrayObj;
	}

	private Object buildCollection(Method method, Class<?> propertyType) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
		Type genericType = method.getGenericParameterTypes()[0];

		if(genericType instanceof ParameterizedType) {
		    ParameterizedType genericTypeClass = (ParameterizedType) genericType;
		    Collection collection = null;

		    if(!propertyType.isInterface()) {
		    	// It's a concrete Collection type... just create an instance...
		    	collection = (Collection) propertyType.newInstance();
			}else if(List.class.isAssignableFrom(propertyType)) {
				collection = new ArrayList();
		    } else if(Set.class.isAssignableFrom(propertyType)) {
				collection = new LinkedHashSet();
			}
			
			if(collection != null) {
				collection.add(buildObject((Class<Object>) genericTypeClass.getActualTypeArguments()[0]));
			    return collection;
			}
		}
		
		return null;
	}
    
    private static final Map<Class, Object> primitiveToObjectMap;

    static {
        primitiveToObjectMap = new HashMap<Class, Object>();
        primitiveToObjectMap.put(int.class, 1);
        primitiveToObjectMap.put(long.class, 1L);
        primitiveToObjectMap.put(boolean.class, true);
        primitiveToObjectMap.put(float.class, 1f);
        primitiveToObjectMap.put(double.class, 1d);
        primitiveToObjectMap.put(char.class, '1');
        primitiveToObjectMap.put(byte.class, Byte.parseByte("1"));
        primitiveToObjectMap.put(short.class, 1);
    }

}

