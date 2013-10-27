/**
 * 
 */
package org.jboss.tools.smooks.configuration.editors;

import java.util.List;

/**
 * @author Dart
 *
 */
public interface IXMLStructuredObject {
	
	public String getNodeName();
	
	public List<IXMLStructuredObject> getChildren();
	
	public IXMLStructuredObject getParent();
	
	public Object getID();
	
	public boolean isRootNode();
	
	public boolean isAttribute();
}
