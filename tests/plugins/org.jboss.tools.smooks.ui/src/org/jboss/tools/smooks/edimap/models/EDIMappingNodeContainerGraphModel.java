package org.jboss.tools.smooks.edimap.models;

import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.jboss.tools.smooks.gef.tree.model.TreeContainerModel;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;

public class EDIMappingNodeContainerGraphModel extends TreeContainerModel {

	private IEditingDomainProvider domainProvider;

	public EDIMappingNodeContainerGraphModel(Object data, ITreeContentProvider contentProvider,
			ILabelProvider labelProvider, IEditingDomainProvider domainProvider) {
		super(data, contentProvider, labelProvider);
		this.domainProvider = domainProvider;
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
		// TODO Auto-generated method stub
		return new EDIMappingNodeGraphModel(model, contentProvider, labelProvider,domainProvider);
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

}
