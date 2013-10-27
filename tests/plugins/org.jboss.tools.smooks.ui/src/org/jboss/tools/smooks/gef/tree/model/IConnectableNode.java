/**
 * 
 */
package org.jboss.tools.smooks.gef.tree.model;

import java.util.List;

/**
 * @author DartPeng
 *
 */
public interface IConnectableNode {
	
	public List<TreeNodeConnection> getSourceConnections();
	
	public List<TreeNodeConnection> getTargetConnections();

	
}
