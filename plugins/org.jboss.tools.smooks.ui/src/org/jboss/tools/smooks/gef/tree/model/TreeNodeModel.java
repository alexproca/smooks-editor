package org.jboss.tools.smooks.gef.tree.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.swt.graphics.Image;
import org.jboss.tools.smooks.configuration.editors.xml.TagObject;
import org.jboss.tools.smooks.configuration.editors.xml.TagPropertyObject;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.templating.template.CollectionMapping;
import org.jboss.tools.smooks.templating.template.Mapping;

public class TreeNodeModel extends AbstractSmooksGraphicalModel {

	protected ITreeContentProvider contentProvider;

	protected ILabelProvider labelProvider;
	
	protected List<TreeNodeConnection> connections;

	public TreeNodeModel(Object data, ITreeContentProvider contentProvider, ILabelProvider labelProvider) {
		super(data);
		setContentProvider(contentProvider);
		setLabelProvider(labelProvider);
		setData(data);
	}

	public boolean hasChildren() {
		if (contentProvider != null && data != null) {
			return contentProvider.hasChildren(data);
		}
		return true;
	}

	public ITreeContentProvider getContentProvider() {
		return contentProvider;
	}

	public void setContentProvider(ITreeContentProvider contentProvider) {
		this.contentProvider = contentProvider;
	}

	public ILabelProvider getLabelProvider() {
		return labelProvider;
	}

	public void setLabelProvider(ILabelProvider labelProvider) {
		this.labelProvider = labelProvider;
	}

	protected TreeNodeModel createChildModel(Object model, ITreeContentProvider contentProvider,
			ILabelProvider labelProvider) {
		return new TreeNodeModel(model, contentProvider, labelProvider);
	}

	public List<AbstractSmooksGraphicalModel> getChildren() {
		if (children == null) {
			if (this.contentProvider != null && data != null) {
				Object[] models = contentProvider.getChildren(data);
				if (models != null) {
					children = new ArrayList<AbstractSmooksGraphicalModel>();
					for (int i = 0; i < models.length; i++) {
						Object model = models[i];
						TreeNodeModel n = createChildModel(model, contentProvider, labelProvider);
						if (n != null) {
							children.add(n);
							n.setParent(this);
						}
					}
					return children;
				}
			}
			return Collections.emptyList();
		} else {
			if (this.contentProvider != null && data != null) {
				Object[] models = contentProvider.getChildren(data);
				if (models != null) {
					for (int i = 0; i < models.length; i++) {
						Object model = models[i];
						// model = AdapterFactoryEditingDomain.unwrap(model);
						if (!childExsit(model)) {
							TreeNodeModel n = createChildModel(model, contentProvider, labelProvider);
							if (n != null) {
								children.add(n);
								n.setParent(this);
							}
						}
					}
					List<AbstractSmooksGraphicalModel> temp = new ArrayList<AbstractSmooksGraphicalModel>(children);
					for (Iterator<?> iterator = temp.iterator(); iterator.hasNext();) {
						AbstractSmooksGraphicalModel node = (AbstractSmooksGraphicalModel) iterator.next();
						Object data = node.getData();
						if (!graphicalChildExist(data, models)) {
							disconnectAllConnections(node);
							children.remove(node);
							node.setParent(null);
						}
					}
					temp.clear();
					temp = null;
				}
			}
		}
		return children;
	}

	public String getText() {
		if (data != null && labelProvider != null) {
			return labelProvider.getText(data);
		}
		return ""; //$NON-NLS-1$
	}

	public Image getImage() {
		if (data != null && labelProvider != null) {
			return labelProvider.getImage(data);
		}
		return null;
	}

	// public boolean isLinkable() {
	// return linkable;
	// }
	//
	// public void setLinkable(boolean linkable) {
	// this.linkable = linkable;
	// }

	public boolean canLinkWithSource(Object model) {
		return true;
	}

	public boolean canLinkWithTarget(Object model) {
		return true;
	}
	
	public boolean isValidValueNode() {
		Object unwrappedData = AdapterFactoryEditingDomain.unwrap(data);

		if (unwrappedData instanceof TagPropertyObject) {
			return true;
		} else if(unwrappedData instanceof TagObject) {
			TagObject tagObject = (TagObject) unwrappedData;
			return tagObject.getChildren().isEmpty();
		}
		
		return false;
	}
	
	public boolean isValidCollectionNode() {
		Object unwrappedData = AdapterFactoryEditingDomain.unwrap(data);

		if(unwrappedData instanceof TagObject) {
			TagObject tagObject = (TagObject) unwrappedData;
			return !tagObject.getChildren().isEmpty();
		}
		
		return false;
	}
	
	public List<TreeNodeConnection> getConnections() {
		if(connections == null) {
			connections = new ArrayList<TreeNodeConnection>();
		}
		return connections;
	}

	public void setConnections(List<TreeNodeConnection> connections) {
		this.connections = connections;
	}

	protected TreeNodeConnection getConnection() {
		if(connections == null || connections.isEmpty()) {
			return null;
		} else if(connections.size() > 1) {
			throw new IllegalStateException("Invalid call to getConnection() for node that has multiple connections.  May be a source node?  Use getConnections()."); //$NON-NLS-1$	
		}
		
		return connections.get(0);
	}

	protected TreeNodeConnection getParentCollectionConnection() {
		AbstractSmooksGraphicalModel parentObj = getParent();
		
		if(parentObj == null || !(parentObj instanceof TreeNodeModel)) {
			return null;
		}
		
		TreeNodeModel parentNode = (TreeNodeModel) parentObj;
		TreeNodeConnection parentConnection = parentNode.getConnection();
		
		if(parentConnection != null && parentConnection.getData() instanceof CollectionMapping) {
			return parentConnection;
		}
		
		return parentNode.getParentCollectionConnection();
	}
	
//	public void reAddMappingConnections(List<Mapping> removeMappings){
//		if(removeMappings == null || removeMappings.isEmpty()) {
//			return;
//		}
//		
//		// Remove from all the children first...
//		for(AbstractSmooksGraphicalModel child : children) {
//			if(child instanceof TreeNodeModel) {
//				((TreeNodeModel)child).reAddMappingConnections(removeMappings);
//			}
//		}
//		for (Mapping mapping : removeMappings) {
//			Object mappingObj = mapping.getMappingNode();
//			if(this.data == mappingObj){
//				
//			}
//		}
//		// Now remove from this node...		
//		if(targetConnections != null && !targetConnections.isEmpty()) {
//			List<TreeNodeConnection> connectionsToAdd =  new ArrayList<TreeNodeConnection>();
//			for(TreeNodeConnection connection : targetConnections) {
//				Object connectionData = connection.getData();
//				if(connectionData instanceof Mapping) {
//					if(removeMappings.contains(connectionData)) {
//						connectionsToAdd.add(connection);
//					}
//				}
//			}
//			for(TreeNodeConnection connection : connectionsToAdd) {
//				connection.connect();
//			}
//		}
//	}

//	public void removeMappingConnections(List<Mapping> removeMappings) {
//		if(removeMappings == null || removeMappings.isEmpty()) {
//			return;
//		}
//		
//		// Remove from all the children first...
//		for(AbstractSmooksGraphicalModel child : children) {
//			if(child instanceof TreeNodeModel) {
//				((TreeNodeModel)child).removeMappingConnections(removeMappings);
//			}
//		}
//		
//		// Now remove from this node...		
//		if(targetConnections != null && !targetConnections.isEmpty()) {
//			List<TreeNodeConnection> connectionsToRemove =  new ArrayList<TreeNodeConnection>();
//			for(TreeNodeConnection connection : targetConnections) {
//				Object connectionData = connection.getData();
//				if(connectionData instanceof Mapping) {
//					if(removeMappings.contains(connectionData)) {
//						connectionsToRemove.add(connection);
//					}
//				}
//			}
//			for(TreeNodeConnection connection : connectionsToRemove) {
//				connection.disconnect();
//			}
//		}
//	}

	public void setText(String text) {
		// if (text != null && !text.equals(this.text)) {
		// String oldtext = this.text;
		// this.text = text;
		// support.firePropertyChange(PRO_TEXT_CHANGED, oldtext, this.text);
		// }
	}
}
