/**
 * 
 */
package org.jboss.tools.smooks.gef.tree.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.jboss.tools.smooks.configuration.editors.IFieldMarker;
import org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.graphical.editors.model.IValidatableModel;
import org.jboss.tools.smooks.templating.template.CollectionMapping;
import org.jboss.tools.smooks.templating.template.result.RemoveResult;
import org.milyn.xml.DomUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author DartPeng
 * 
 */
public class TreeNodeConnection implements IValidatableModel{
	
	protected int severity = IFieldMarker.TYPE_NONE;
	
	protected Object data;

	protected AbstractSmooksGraphicalModel sourceNode;

	protected AbstractSmooksGraphicalModel targetNode;
	
	protected List<String> markerMessages = null;
	
	protected PropertyChangeSupport support = new PropertyChangeSupport(this);

	public TreeNodeConnection() {

	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}



	public TreeNodeConnection(AbstractSmooksGraphicalModel sourceNode, AbstractSmooksGraphicalModel targetNode) {
		this.sourceNode = sourceNode;
		this.targetNode = targetNode;
		Assert.isNotNull(sourceNode);
		Assert.isNotNull(targetNode);
	}

	public void connect() {
		connectSource();
		connectTarget();
	}

	public void disconnect() {
		disconnectSource();
		disconnectTarget();
	}

	public void connectSource() {
		sourceNode.addSourceConnection(this);
	}

	public void connectTarget() {
//		if(data instanceof RemoveResult) {
//			((TreeNodeModel)targetNode.getModelRootNode()).reAddMappingConnections(((RemoveResult)data).getRemoveMappings());
//		}
		targetNode.addTargetConnection(this, sourceNode);
		
	}

	public void disconnectSource() {
		sourceNode.removeSourceConnection(this);
	}

	public void disconnectTarget() {
		targetNode.removeTargetConnection(this);
//		if(data instanceof RemoveResult) {
//			((TreeNodeModel)targetNode.getModelRootNode()).removeMappingConnections(((RemoveResult)data).getRemoveMappings());
//		}
	}

	public AbstractSmooksGraphicalModel getSourceNode() {
		return sourceNode;
	}

	public void setSourceNode(AbstractSmooksGraphicalModel sourceNode) {
		this.sourceNode = sourceNode;
	}

	public AbstractSmooksGraphicalModel getTargetNode() {
		return targetNode;
	}

	public void setTargetNode(AbstractSmooksGraphicalModel targetNode) {
		this.targetNode = targetNode;
	}

	public void addMessage(String message) {
		this.getMessage().add(message);
	}

	public List<String> getMessage() {
		if(markerMessages == null){
			markerMessages = new ArrayList<String>();
		}
		return markerMessages;
	}

	/**
	 * @return the severity
	 */
	public int getSeverity() {
		return severity;
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener){
		support.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener){
		support.removePropertyChangeListener(listener);
	}

	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(int severity) {
		int old = this.severity;
		if (severity == this.severity){
			old = -1;
		}
		this.severity = severity;
		support.firePropertyChange(AbstractSmooksGraphicalModel.PRO_SEVERITY_CHANGED, old, this.severity);
	}	

	public String getTargetConnectionObjectRef() {
		TreeNodeModel sourceNodeModel = (TreeNodeModel) sourceNode;
		TreeNodeModel targetNodeModel = (TreeNodeModel) targetNode;
		Node sourceDOMNode = sourceNodeModel.getNode();
		
		// This will only work for sources that are modeled hierarchically with TagObjects etc i.e. not Java
		if(sourceDOMNode == null) {
			throw new IllegalStateException("Invalid call to getTargetConnectionObjectRef() for non AbstractXMLObject connection source."); //$NON-NLS-1$
		}

		StringBuilder builder = new StringBuilder();
		
		// We first need to determine whether or not there's a parent Collection connection
		// on target side of the mapping...
		TreeNodeConnection parentConnection = targetNodeModel.getParentCollectionConnection();
		if(parentConnection != null) {
			// If there's a parent Collection connection on the target side of the mapping,
			// we need to locate the other side of that connection on the source model
			// and then create an objectRef string based on the nodes between the source side of the parent
			// connection and the source side of the connection associated with this node connection.
			CollectionMapping collectionMapping = (CollectionMapping) parentConnection.getData();
			Node sourceCollectionDomNode = ((TreeNodeModel)parentConnection.getSourceNode()).getNode();
			
			// Work back to collection node...
			Node currentNode = sourceDOMNode;
			while(currentNode != null && currentNode != sourceCollectionDomNode) {
				if(currentNode.getNodeType() != Node.ATTRIBUTE_NODE && currentNode.getNodeType() != Node.ELEMENT_NODE) {
					currentNode = currentNode.getParentNode();
					continue;
				}
				
				if(builder.length() > 0) {
					builder.insert(0, '/');
				}
				if(currentNode.getNodeType() == Node.ATTRIBUTE_NODE) {
					builder.insert(0, "@" + ((Attr)currentNode).getNodeName());				
					currentNode = ((Attr)currentNode).getOwnerElement();
					continue;
				} else if(currentNode.getNodeType() == Node.ELEMENT_NODE) {
					builder.insert(0, DomUtils.getName((Element)currentNode));				
				}
				currentNode = currentNode.getParentNode();
			}

			if(currentNode == sourceCollectionDomNode) {
				builder.insert(0, collectionMapping.getCollectionItemName() + "/");
			}
		} else {
			// No parent connection... just use the connection source path...
			builder.append(SmooksUIUtils.generateFullPath((IXMLStructuredObject) sourceNodeModel.getData(), "/"));				
		}
		
		if(builder.length() > 1 && builder.charAt(0) == '.') {
			builder.deleteCharAt(0);
		}
		
		return builder.toString();
	}
}
