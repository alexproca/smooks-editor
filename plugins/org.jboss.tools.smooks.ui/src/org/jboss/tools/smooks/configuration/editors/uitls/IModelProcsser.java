/**
 * 
 */
package org.jboss.tools.smooks.configuration.editors.uitls;

/**
 * @author DartPeng
 *
 */
public interface IModelProcsser {
	Object unwrapValue(Object model);
	Object wrapValue(Object model);
}
