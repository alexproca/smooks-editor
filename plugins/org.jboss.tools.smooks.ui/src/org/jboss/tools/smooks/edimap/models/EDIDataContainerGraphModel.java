package org.jboss.tools.smooks.edimap.models;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.jboss.tools.smooks.gef.tree.model.TreeContainerModel;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;

public class EDIDataContainerGraphModel extends TreeContainerModel {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.model.TreeNodeModel#createChildModel(
	 * java.lang.Object, org.eclipse.jface.viewers.ITreeContentProvider,
	 * org.eclipse.jface.viewers.ILabelProvider)
	 */
	@Override
	protected TreeNodeModel createChildModel(Object model, ITreeContentProvider contentProvider,
			ILabelProvider labelProvider) {
		// TODO Auto-generated method stub
		return new EDIDataGraphModel(model, contentProvider, labelProvider);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.model.TreeNodeModel#canLinkWithSource
	 * (java.lang.Object)
	 */
	@Override
	public boolean canLinkWithSource(Object model) {
		if(model instanceof EDIMappingNodeGraphModel){
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.model.TreeNodeModel#canLinkWithTarget
	 * (java.lang.Object)
	 */
	@Override
	public boolean canLinkWithTarget(Object model) {
		return false;
	}

	public EDIDataContainerGraphModel(Object data, ITreeContentProvider contentProvider, ILabelProvider labelProvider) {
		super(data, contentProvider, labelProvider);
	}
}
