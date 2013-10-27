package org.jboss.tools.smooks.edimap.models;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;

public class EDIDataGraphModel extends TreeNodeModel {

	public EDIDataGraphModel(Object data, ITreeContentProvider contentProvider, ILabelProvider labelProvider) {
		super(data, contentProvider, labelProvider);
	}

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
		return new EDIDataGraphModel(model, contentProvider, labelProvider);
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.gef.tree.model.TreeNodeModel#canLinkWithSource(java.lang.Object)
	 */
	@Override
	public boolean canLinkWithSource(Object model) {
		// TODO Auto-generated method stub
		return super.canLinkWithSource(model);
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.gef.tree.model.TreeNodeModel#canLinkWithTarget(java.lang.Object)
	 */
	@Override
	public boolean canLinkWithTarget(Object model) {
		// TODO Auto-generated method stub
		return super.canLinkWithTarget(model);
	}

	
	
	

}
