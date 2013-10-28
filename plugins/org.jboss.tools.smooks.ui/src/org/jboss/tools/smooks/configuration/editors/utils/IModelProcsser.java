/**
 * 
 */
package org.jboss.tools.smooks.configuration.editors.utils;

/**
 * @author DartPeng
 *
 */
public interface IModelProcsser {
	Object unwrapValue(Object model);
	Object wrapValue(Object model);
}
