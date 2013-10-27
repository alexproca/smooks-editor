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
package org.jboss.tools.smooks.graphical.editors.model;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.configuration.editors.xml.AbstractXMLObject;
import org.jboss.tools.smooks.configuration.editors.xml.TagObject;
import org.jboss.tools.smooks.configuration.editors.xml.TagPropertyObject;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerTemplateGraphicalModel;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerTemplateNodeGraphicalModel;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerTemplateXMLModel;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.IFreemarkerTemplateModel;
import org.jboss.tools.smooks.templating.model.ModelBuilder;
import org.jboss.tools.smooks.templating.template.TemplateBuilder;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author Dart
 * 
 */
public class InputDataTreeNodeModel extends TreeNodeModel {

	public InputDataTreeNodeModel(Object data,
			ITreeContentProvider contentProvider, ILabelProvider labelProvider) {
		super(data, contentProvider, labelProvider);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected TreeNodeModel createChildModel(Object model,
			ITreeContentProvider contentProvider, ILabelProvider labelProvider) {
		return new InputDataTreeNodeModel(model, contentProvider, labelProvider);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel#isLinkable
	 * (java.lang.Class)
	 */
	@Override
	public boolean isLinkable(Class<?> connectionType) {
		return true;
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
		return super.canLinkWithSource(model);
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
		TreeNodeModel targetNode = (TreeNodeModel) model;
		if (targetNode == this
				|| targetNode.getModelRootNode() == getModelRootNode()) {
			return false;
		}

		Object targetData = AdapterFactoryEditingDomain.unwrap(targetNode.getData());
		AbstractSmooksGraphicalModel targetModel = targetNode;
		while (targetModel != null && !(targetModel instanceof FreemarkerTemplateGraphicalModel)) {
			targetModel = targetModel.getParent();
		}
		if (targetData instanceof IFreemarkerTemplateModel && targetModel instanceof FreemarkerTemplateGraphicalModel) {
			TemplateBuilder builder = ((FreemarkerTemplateGraphicalModel) targetModel).getTemplateBuilder();
			if (((IFreemarkerTemplateModel) targetData).isHidden(builder)) {
				return false;
			}
			List<TreeNodeConnection> exsitingConnection = targetNode.getTargetConnections();
			if (!exsitingConnection.isEmpty()){
				return false;
			}
			if (targetData instanceof FreemarkerTemplateXMLModel) {
				FreemarkerTemplateXMLModel targetDataModel = (FreemarkerTemplateXMLModel) targetData;
				if (!targetDataModel.getXMLNodeChildren().isEmpty()) {
					// The target node has child nodes.  The only thing it can connect to on the source is
					// a collection node.
					Object sourceData = AdapterFactoryEditingDomain.unwrap(this.getData());
					if(sourceData instanceof AbstractXMLObject) {
						Element sourceElement = ((AbstractXMLObject)sourceData).getReferenceElement();
						if(sourceElement != null) {
							if(ModelBuilder.isCollection(sourceElement) || (!ModelBuilder.isStrictModel(sourceElement.getOwnerDocument()) && ModelBuilder.hasChildContent(sourceElement))) { 
								return true;
							}
						}
					}
					return false;
				}
			}
			
			
			for (Iterator<?> iterator = exsitingConnection.iterator(); iterator.hasNext();) {
				TreeNodeConnection treeNodeConnection = (TreeNodeConnection) iterator.next();
				if (treeNodeConnection.getSourceNode() == this) {
					return false;
				}
			}

			AbstractSmooksGraphicalModel pgm = targetNode;
			while (pgm != null && pgm instanceof FreemarkerTemplateNodeGraphicalModel) {
				Object pd = ((FreemarkerTemplateNodeGraphicalModel) pgm).getData();
				if (pd instanceof IFreemarkerTemplateModel) {
					IFreemarkerTemplateModel iFreemarkerTemplateModel = (IFreemarkerTemplateModel) pd;
					if (iFreemarkerTemplateModel.isManyOccurs() && pgm.getTargetConnections().isEmpty()) {
						Node modelNode = iFreemarkerTemplateModel.getModelNode();
						if (modelNode instanceof Element) {
							return !ModelBuilder.getEnforceCollectionSubMappingRules((Element) modelNode);
						} else {
							return false;
						}
					}
				}
				pgm = pgm.getParent();
			}
		}
		if (targetData instanceof TagPropertyObject) {
			// Only OK to link to an attribute from a valid Value node...
			return isValidValueNode();
		} else if (targetData instanceof TagObject) {
			if (targetNode.isValidValueNode()) {
				return isValidValueNode();
			} else if (targetNode.isValidCollectionNode()) {
				return isValidCollectionNode();
			}
		} else if (targetData instanceof EObject) {
			if (SmooksUIUtils.getSelectorFeature((EObject) targetData) != null) {
				return true;
			}
		}

		return false;
	}

}
