/*******************************************************************************
 * Copyright (c) 2008 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.smooks.gef.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.jboss.tools.smooks.configuration.editors.xml.TagList;
import org.jboss.tools.smooks.configuration.editors.xml.TagObject;
import org.jboss.tools.smooks.configuration.editors.xml.TagPropertyObject;
import org.jboss.tools.smooks.gef.common.RootModel;
import org.jboss.tools.smooks.gef.tree.model.IConnectableNode;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;
import org.jboss.tools.smooks.graphical.editors.model.IValidatableModel;
import org.jboss.tools.smooks.graphical.editors.model.InputDataTreeNodeModel;
import org.w3c.dom.Node;

/**
 * @author Dart
 * 
 */
public class AbstractSmooksGraphicalModel implements IConnectableNode, IValidatableModel {

	private int severity = NONE;
	
	private List<String> messages = null;

	public static final String PRO_ADD_CHILD = "_pro_add_child"; //$NON-NLS-1$

	public static final String PRO_MOVE_CHILD = "_pro_move_child"; //$NON-NLS-1$

	public static final String PRO_REMOVE_CHILD = "_pro_remove_child"; //$NON-NLS-1$

	public static final String PRO_ADD_SOURCE_CONNECTION = "_pro_add_source_connected"; //$NON-NLS-1$

	public static final String PRO_SEVERITY_CHANGED = "_pro_severity_changed"; //$NON-NLS-1$

	public static final String PRO_ADD_TARGET_CONNECTION = "_pro_add_target_connected"; //$NON-NLS-1$

	public static final String PRO_REMOVE_SOURCE_CONNECTION = "_pro_remove_source_connected"; //$NON-NLS-1$

	public static final String PRO_REMOVE_TARGET_CONNECTION = "_pro_remove_target_connected"; //$NON-NLS-1$

	public static final String PRO_TEXT_CHANGED = "_pro_text_changed"; //$NON-NLS-1$

	public static final String PRO_FORCE_VISUAL_CHANGED = "_pro_force_text_changed"; //$NON-NLS-1$

	public static final String PRO_FORCE_CHIDLREN_CHANGED = "_pro_force_children_changed"; //$NON-NLS-1$

	public static final String PRO_FORCE_CONNECTION_CHANGED = "_pro_force_connection_changed"; //$NON-NLS-1$

	protected Object data = null;

	private boolean linkable = true;

	private AbstractSmooksGraphicalModel parent = null;

	private HashMap<String, Object> userDataMap = new HashMap<String, Object>();

	protected PropertyChangeSupport support = new PropertyChangeSupport(this);

	protected List<AbstractSmooksGraphicalModel> children = null;

	protected List<TreeNodeConnection> sourceConnections = new ArrayList<TreeNodeConnection>();

	protected List<TreeNodeConnection> targetConnections = new ArrayList<TreeNodeConnection>();

	public AbstractSmooksGraphicalModel(Object data) {
		setData(data);
	}

	public boolean hasChildren() {
		return true;
	}

	public AbstractSmooksGraphicalModel getParent() {
		return parent;
	}

	public void setParent(AbstractSmooksGraphicalModel parent) {
		this.parent = parent;
	}

	public AbstractSmooksGraphicalModel getModelRootNode() {
		if(parent != null && !(parent instanceof RootModel)) {
			return parent.getModelRootNode();
		}
		
		return this;
	}

	//
	// protected AbstractSmooksGraphicalModel createChildModel(Object model,
	// ITreeContentProvider contentProvider,
	// ILabelProvider labelProvider) {
	// return new TreeNodeModel(model, contentProvider, labelProvider);
	// }

	/**
	 * @return the severity
	 */
	public int getSeverity() {
		return severity;
	}

	/**
	 * @param severity
	 *            the severity to set
	 */
	public void setSeverity(int severity) {
		int old = this.severity;
		if (severity == this.severity){
			old = -1;
		}
		this.severity = severity;
		support.firePropertyChange(PRO_SEVERITY_CHANGED, old, this.severity);
	}
	
    public Node getNode() {
		if (data instanceof TagObject) {
			return ((TagObject) data).getReferenceElement();
		}		
		if (data instanceof TagPropertyObject) {
			return ((TagPropertyObject) data).getReferenceAttibute();
		}		
    	return null;
    }

	public List<AbstractSmooksGraphicalModel> getChildren() {
		if (children == null) {
			children = new ArrayList<AbstractSmooksGraphicalModel>();
		}
		return children;
	}

	public List<AbstractSmooksGraphicalModel> getChildrenWithoutDynamic() {
		if (children == null) {
			children = new ArrayList<AbstractSmooksGraphicalModel>();
		}
		return children;
	}

	public static void disconnectAllConnections(AbstractSmooksGraphicalModel node) {
		disconnectAllConnections(node, null);
	}

	public static void disconnectAllConnections(AbstractSmooksGraphicalModel node,
			List<TreeNodeConnection> deletedConnections) {
		List<TreeNodeConnection> sourceConnections = node.getSourceConnections();
		List<TreeNodeConnection> targetConnections = node.getTargetConnections();
		List<TreeNodeConnection> tempSourceConnections = new ArrayList<TreeNodeConnection>(sourceConnections);
		List<TreeNodeConnection> tempTargetConnections = new ArrayList<TreeNodeConnection>(targetConnections);

		for (Iterator<?> iterator2 = tempTargetConnections.iterator(); iterator2.hasNext();) {
			TreeNodeConnection treeNodeConnection = (TreeNodeConnection) iterator2.next();
			AbstractSmooksGraphicalModel sourceNode = treeNodeConnection.getSourceNode();
			sourceNode.getSourceConnections().remove(treeNodeConnection);
			sourceNode.fireConnectionChanged();
			if (deletedConnections != null) {
				deletedConnections.add(treeNodeConnection);
			}
		}

		for (Iterator<?> iterator2 = tempSourceConnections.iterator(); iterator2.hasNext();) {
			TreeNodeConnection treeNodeConnection = (TreeNodeConnection) iterator2.next();
			// treeNodeConnection.disconnectTarget();
			AbstractSmooksGraphicalModel targetNode = treeNodeConnection.getTargetNode();
			targetNode.getTargetConnections().remove(treeNodeConnection);
			targetNode.fireConnectionChanged();
			if (deletedConnections != null) {
				deletedConnections.add(treeNodeConnection);
			}
		}

		tempSourceConnections.clear();
		tempTargetConnections.clear();
		tempSourceConnections = null;
		tempTargetConnections = null;

		List<AbstractSmooksGraphicalModel> children = node.getChildren();
		for (Iterator<?> iterator = children.iterator(); iterator.hasNext();) {
			TreeNodeModel treeNodeModel = (TreeNodeModel) iterator.next();
			disconnectAllConnections(treeNodeModel, deletedConnections);
		}
	}
	
	public static void disconnectAllConnectionsWithEvent(AbstractSmooksGraphicalModel node,
			List<TreeNodeConnection> deletedConnections) {
		List<TreeNodeConnection> sourceConnections = node.getSourceConnections();
		List<TreeNodeConnection> targetConnections = node.getTargetConnections();
		List<TreeNodeConnection> tempSourceConnections = new ArrayList<TreeNodeConnection>(sourceConnections);
		List<TreeNodeConnection> tempTargetConnections = new ArrayList<TreeNodeConnection>(targetConnections);

		for (Iterator<?> iterator2 = tempTargetConnections.iterator(); iterator2.hasNext();) {
			TreeNodeConnection treeNodeConnection = (TreeNodeConnection) iterator2.next();
//			AbstractSmooksGraphicalModel sourceNode = treeNodeConnection.getSourceNode();
			treeNodeConnection.disconnect();
//			sourceNode.getSourceConnections().remove(treeNodeConnection);
//			sourceNode.fireConnectionChanged();
			if (deletedConnections != null) {
				deletedConnections.add(treeNodeConnection);
			}
		}

		for (Iterator<?> iterator2 = tempSourceConnections.iterator(); iterator2.hasNext();) {
			TreeNodeConnection treeNodeConnection = (TreeNodeConnection) iterator2.next();
			 treeNodeConnection.disconnect();
//			AbstractSmooksGraphicalModel targetNode = treeNodeConnection.getTargetNode();
//			targetNode.getTargetConnections().remove(treeNodeConnection);
//			targetNode.fireConnectionChanged();
			if (deletedConnections != null) {
				deletedConnections.add(treeNodeConnection);
			}
		}

		tempSourceConnections.clear();
		tempTargetConnections.clear();
		tempSourceConnections = null;
		tempTargetConnections = null;

		List<AbstractSmooksGraphicalModel> children = node.getChildren();
		for (Iterator<?> iterator = children.iterator(); iterator.hasNext();) {
			TreeNodeModel treeNodeModel = (TreeNodeModel) iterator.next();
			disconnectAllConnectionsWithEvent(treeNodeModel, deletedConnections);
		}
	}

	protected boolean graphicalChildExist(Object model, Object[] models) {
		for (int i = 0; i < models.length; i++) {
			if (model == models[i]) {
				return true;
			}
		}
		return false;
	}

	protected boolean childExsit(Object model) {
		if (children != null) {
			for (Iterator<?> iterator = children.iterator(); iterator.hasNext();) {
				TreeNodeModel node = (TreeNodeModel) iterator.next();
				if (node.getData() == model) {
					return true;
				}
			}
		}
		return false;
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		support.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		support.removePropertyChangeListener(listener);
	}

	public void addSourceConnection(TreeNodeConnection connection) {
		if (this.sourceConnections.indexOf(connection) == -1) {
			this.sourceConnections.add(connection);
			support.firePropertyChange(PRO_ADD_SOURCE_CONNECTION, null, connection);
		}
	}

	public void removeSourceConnection(TreeNodeConnection connection) {
		if (this.sourceConnections.indexOf(connection) != -1) {
			this.sourceConnections.remove(connection);
			support.firePropertyChange(PRO_REMOVE_SOURCE_CONNECTION, connection, null);
		}
	}

	public void addTargetConnection(TreeNodeConnection connection, AbstractSmooksGraphicalModel sourceNode) {
		if (this.targetConnections.indexOf(connection) == -1) {
			this.targetConnections.add(connection);
			support.firePropertyChange(PRO_ADD_TARGET_CONNECTION, null, connection);
		}
	}

	public void removeTargetConnection(TreeNodeConnection connection) {
		if (this.targetConnections.indexOf(connection) != -1) {
			this.targetConnections.remove(connection);
			support.firePropertyChange(PRO_REMOVE_TARGET_CONNECTION, connection, null);
		}
	}

	public void addChild(AbstractSmooksGraphicalModel node) {
		if (getChildrenWithoutDynamic().indexOf(node) == -1) {
			getChildrenWithoutDynamic().add(node);
			node.setParent(this);
			support.firePropertyChange(PRO_ADD_CHILD, null, node);
		}
	}

	public void addChild(int index, AbstractSmooksGraphicalModel node) {
		this.addChild(node);
		this.moveChild(index, node);
	}

	public void moveChild(int index, AbstractSmooksGraphicalModel node) {
		int oldIndex = getChildrenWithoutDynamic().indexOf(node);
		if (index >= 0 && index <= getChildrenWithoutDynamic().size() - 1) {
			if (oldIndex != -1 && index != oldIndex) {
				getChildrenWithoutDynamic().remove(node);
				getChildrenWithoutDynamic().add(index, node);
				support.firePropertyChange(PRO_MOVE_CHILD, oldIndex, index);
			}
		}
	}

	public void removeChild(AbstractSmooksGraphicalModel node) {
		if (getChildrenWithoutDynamic().indexOf(node) != -1) {
			getChildrenWithoutDynamic().remove(node);
			node.setParent(null);
			support.firePropertyChange(PRO_REMOVE_CHILD, node, null);
		}
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setUserData(String key, Object data) {
		userDataMap.put(key, data);
	}

	public Object getUserData(String key) {
		return userDataMap.get(key);
	}

	public String getText() {
		// if (data != null && labelProvider != null) {
		// return labelProvider.getText(data);
		// }
		return null;
	}

	public Image getImage() {
		// if (data != null && labelProvider != null) {
		// return labelProvider.getImage(data);
		// }
		return null;
	}

	public boolean isLinkable(Class<?> connectionType) {
		return linkable;
	}

	public void setLinkable(boolean linkable) {
		this.linkable = linkable;
	}

	public boolean canLinkWithSource(Object model) {
		return true;
	}

	public boolean canLinkWithTarget(Object model) {
		return true;
	}

	public void setText(String text) {
	}

	public List<TreeNodeConnection> getSourceConnections() {
		return sourceConnections;
	}

	public List<TreeNodeConnection> getTargetConnections() {
		return targetConnections;
	}

	public void fireChildrenChanged() {
		support.firePropertyChange(PRO_FORCE_CHIDLREN_CHANGED, new Object(), null);
	}

	public void fireConnectionChanged() {
		support.firePropertyChange(PRO_FORCE_CONNECTION_CHANGED, new Object(), null);
	}

	public void fireVisualChanged() {
		support.firePropertyChange(PRO_FORCE_VISUAL_CHANGED, new Object(), null);
	}

	public void addMessage(String message) {
		getMessage().add(message);
	}

	public List<String> getMessage() {
		if(messages == null){
			messages = new ArrayList<String>();
		}
		return messages;
	}

	public TreeNodeModel getModelNode(String srcPath) {
		String[] pathTokens = srcPath.split("/");
		
		if(pathTokens.length > 0) {
			return getModeNode(pathTokens, 0);
		}
		
		return null;
	}	

	public TreeNodeModel getModelNode(Node queryNode) {
		List<AbstractSmooksGraphicalModel> thisNodeChildren = getChildren();
		
		if(thisNodeChildren != null) {
			for(AbstractSmooksGraphicalModel childNode : thisNodeChildren) {
				if(!(childNode instanceof TreeNodeModel)) {
					continue;
				}
							
				Object childData = childNode.getData();
				
				if(queryNode.getNodeType() == Node.ELEMENT_NODE) {
					if(childData instanceof TagObject && ((TagObject)childData).getReferenceElement() == queryNode) {
						return (TreeNodeModel) childNode;
					}
				} else if(queryNode.getNodeType() == Node.ATTRIBUTE_NODE) {
					if(childData instanceof TagPropertyObject && ((TagPropertyObject)childData).getReferenceAttibute() == queryNode) {
						return (TreeNodeModel) childNode;						
					}
				}

				if(childData instanceof TagObject || childData instanceof TagList) {
					TreeNodeModel matchedNode = childNode.getModelNode(queryNode);
					if(matchedNode != null) {
						return matchedNode;
					}
				}
			}
		}
		
		return null;
	}

	public TreeNodeModel getModeNode(String[] pathTokens, int checkNodeIndex) {
		String nodeName = pathTokens[checkNodeIndex];
		boolean isAttribute = (nodeName.charAt(0) == '@');
		
		if(isAttribute) {
			nodeName = nodeName.substring(1);
		}
		
		List<AbstractSmooksGraphicalModel> thisNodeChildren = getChildren();
		if(thisNodeChildren != null) {
			for(AbstractSmooksGraphicalModel childNode : thisNodeChildren) {
				if(!(childNode instanceof TreeNodeModel)) {
					continue;
				}
				
				Object childData = childNode.getData();
				boolean isMatch = false;
				
				if(isAttribute) {
					if(childData instanceof TagPropertyObject) {
						TagPropertyObject tagProp = (TagPropertyObject) childData;
						if(tagProp.getName().equals(nodeName)) {
							isMatch = true;
						}
					}
				} else {
					if(childData instanceof TagObject) {
						TagObject tagObj = (TagObject) childData;
						if(tagObj.getName().equals(nodeName)) {
							isMatch = true;
						}						
					}
				}
				
				if(isMatch) {
					if(checkNodeIndex == pathTokens.length - 1) {
						// This is the node... return it...
						return (TreeNodeModel) childNode;
					} else {
						// Drill into this child node and continue searching...
						return childNode.getModeNode(pathTokens, checkNodeIndex + 1);
					}
				}
			}
		}

		return null;
	}
}
