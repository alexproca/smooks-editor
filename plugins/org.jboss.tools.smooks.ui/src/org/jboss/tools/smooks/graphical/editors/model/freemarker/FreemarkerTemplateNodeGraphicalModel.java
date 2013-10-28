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
package org.jboss.tools.smooks.graphical.editors.model.freemarker;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.configuration.editors.utils.SmooksUIUtils;
import org.jboss.tools.smooks.configuration.editors.xml.TagObject;
import org.jboss.tools.smooks.configuration.editors.xml.TagPropertyObject;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;
import org.jboss.tools.smooks.graphical.editors.model.AbstractResourceConfigChildNodeGraphModel;
import org.jboss.tools.smooks.graphical.editors.model.InputDataTreeNodeModel;
import org.jboss.tools.smooks.graphical.editors.model.javamapping.JavaBeanGraphModel;
import org.jboss.tools.smooks.model.freemarker.Freemarker;
import org.jboss.tools.smooks.model.freemarker.Template;
import org.jboss.tools.smooks.model.javabean12.BeanType;
import org.jboss.tools.smooks.model.javabean12.ValueType;
import org.jboss.tools.smooks.templating.template.Mapping;
import org.jboss.tools.smooks.templating.template.TemplateBuilder;
import org.jboss.tools.smooks.templating.template.ValueMapping;
import org.jboss.tools.smooks.templating.template.exception.InvalidMappingException;
import org.jboss.tools.smooks.templating.template.result.AddCollectionResult;
import org.jboss.tools.smooks.templating.template.result.RemoveResult;
import org.milyn.xml.DomUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author Dart
 * 
 */
public class FreemarkerTemplateNodeGraphicalModel extends TreeNodeModel {
	protected IEditingDomainProvider domainProvider = null;

	public FreemarkerTemplateNodeGraphicalModel(Object data,
			ITreeContentProvider contentProvider, ILabelProvider labelProvider,
			IEditingDomainProvider domainProvider) {
		super(data, contentProvider, labelProvider);
		this.domainProvider = domainProvider;
	}

	public TemplateBuilder getTemplateBuilder() {
		AbstractSmooksGraphicalModel parent = this;
		while (parent != null
				&& !(parent instanceof FreemarkerTemplateGraphicalModel)) {
			parent = parent.getParent();
		}
		if (parent instanceof FreemarkerTemplateGraphicalModel) {
			return ((FreemarkerTemplateGraphicalModel) parent)
					.getTemplateBuilder();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.tools.smooks.gef.tree.model.TreeNodeModel#getChildren()
	 */
	@Override
	public List<AbstractSmooksGraphicalModel> getChildren() {
		return getChildrenWithoutDynamic();
	}

	/**
	 * @return the domainProvider
	 */
	public IEditingDomainProvider getDomainProvider() {
		return domainProvider;
	}

	public void changeFreemarkerContents() {
		TemplateBuilder builder = getTemplateBuilder();
		Template template = null;
		AbstractSmooksGraphicalModel templateGraph = this;
		while (templateGraph != null
				&& !(templateGraph instanceof FreemarkerTemplateGraphicalModel)) {
			templateGraph = templateGraph.getParent();
		}
		Object data = templateGraph.getData();
		if (data instanceof Freemarker) {
			template = ((Freemarker) data).getTemplate();
		}
		if (template == null)
			return;
		if (builder != null) {
			String content = null;
			try {
				content = builder.buildTemplate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			SmooksModelUtils.setCDATAToSmooksType(
					domainProvider.getEditingDomain(), template, content);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel#
	 * addTargetConnection
	 * (org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection)
	 */
	@Override
	public void addTargetConnection(TreeNodeConnection connection, AbstractSmooksGraphicalModel source) {
		if(!getConnections().isEmpty()) {
			return;
		}		
		
		TemplateBuilder builder = getTemplateBuilder();
		Object obj = this.getData();
		Node targetNode = null;
		Node sourceNode = source.getNode();
		TreeNodeModel mappingSourceNode = (TreeNodeModel) source;		
		
		if (obj instanceof TagObject) {
			targetNode = ((TagObject) obj).getReferenceElement();
		}		
		if (obj instanceof TagPropertyObject) {
			targetNode = ((TagPropertyObject) obj).getReferenceAttibute();
		}		
		if (builder == null || targetNode == null) {
			return;
		}		
		if (connection.getData() != null) {
			// ignore
		}
		
		try {
			if (isCollectionConnection(connection)) {
				AddCollectionResult mappingResult = null;

				// if it's a directly mapping
				if (mappingSourceNode instanceof InputDataTreeNodeModel) {
					if(sourceNode == null) {
						return;
					}
					
					Object data = mappingSourceNode.getData();
					String mappingString = connection.getTargetConnectionObjectRef();
					String collectionItemName = normalizeFreemarkerVariable(DomUtils.getName((Element) sourceNode));
					mappingResult = builder.addCollectionMapping(mappingString, (Element) targetNode, collectionItemName);
				} else {
					AbstractSmooksGraphicalModel beanGraph = connection.getSourceNode();
	
					Object jobj = (Object) beanGraph.getData();
					jobj = AdapterFactoryEditingDomain.unwrap(jobj);
	
					String collectionName = null;
					List<AbstractSmooksGraphicalModel> javabeanChildren = beanGraph.getChildrenWithoutDynamic();
					for (AbstractSmooksGraphicalModel abstractSmooksGraphicalModel : javabeanChildren) {
						Object javabean = abstractSmooksGraphicalModel.getData();
	
						javabean = AdapterFactoryEditingDomain.unwrap(javabean);
						if (javabean instanceof org.jboss.tools.smooks.model.javabean12.WiringType) {
							collectionName = ((org.jboss.tools.smooks.model.javabean12.WiringType) javabean).getBeanIdRef();
						}
					}
					BeanType javabeanModel = (BeanType) jobj;
					mappingResult = builder.addCollectionMapping(javabeanModel.getBeanId(), (Element) targetNode, collectionName);
				}
				
				connection.setData(mappingResult.getMapping());
				if(connection instanceof FreemarkerTemplateConnection){
					((FreemarkerTemplateConnection)connection).setRemoveMappingConnections(mappingResult.getRemoveMappings());
				}
//				((TreeNodeModel)getModelRootNode()).removeMappingConnections(mappingResult.getRemoveMappings());
			} else if (isMappingValueConnection(connection)) {
				String mappingString = null;
				
				// if it's a directly mapping
				if (mappingSourceNode instanceof InputDataTreeNodeModel) {
					Object data = mappingSourceNode.getData();
					mappingString = connection.getTargetConnectionObjectRef();
				} else {
					JavaBeanGraphModel collectionJavaBean = getCollectionRootBeanModel(mappingSourceNode);

					if (collectionJavaBean == null) {
						// if there isn't collection bean , get the node's
						// parent as
						// the top level bean
						AbstractSmooksGraphicalModel parentSourceNode = mappingSourceNode;
						
						while (parentSourceNode != null && !(parentSourceNode instanceof JavaBeanGraphModel)) {
							parentSourceNode = parentSourceNode.getParent();
						}
						
						collectionJavaBean = (JavaBeanGraphModel) parentSourceNode;
						mappingString = FreemarkerCSVContentGenerator.generateFullJavaSourcePathString(mappingSourceNode, collectionJavaBean);
					} else {
						mappingString = FreemarkerCSVContentGenerator
								.generateJavaSourcePathWithoutRootNode(
										mappingSourceNode, collectionJavaBean);
					}
				}

				ValueMapping mapping = builder.addValueMapping(mappingString, targetNode);
				if (source instanceof AbstractResourceConfigChildNodeGraphModel) {
					((AbstractResourceConfigChildNodeGraphModel) source)
							.addMappingTypeInfo(mapping);
				}

				connection.setData(mapping);
			}

			getConnections().add(connection);
			mappingSourceNode.getConnections().add(connection);
			
			changeFreemarkerContents();
			super.addTargetConnection(connection, source);
		} catch (InvalidMappingException e) {
			e.printStackTrace();
		}
	}

	private String normalizeFreemarkerVariable(String variableName) {
		StringBuilder builder = new StringBuilder();
		int len = variableName.length();
		
		for(int i = 0; i < len; i++) {
			char theChar = variableName.charAt(i);
			
			if(Character.isLetterOrDigit(theChar)) {
				builder.append(theChar);
			} else {
				builder.append('_');
			}
		}
		
		return builder.toString();
	}

	protected JavaBeanGraphModel getCollectionRootBeanModel(
			AbstractSmooksGraphicalModel sourceNode) {
		AbstractSmooksGraphicalModel parentNodeBean = sourceNode;
		while (parentNodeBean != null
				&& !(parentNodeBean instanceof JavaBeanGraphModel)) {
			parentNodeBean = parentNodeBean.getParent();
		}
		if (parentNodeBean != null
				&& parentNodeBean instanceof JavaBeanGraphModel) {
			// get the bean reference links
			List<TreeNodeConnection> connections = parentNodeBean
					.getTargetConnections();
			for (Iterator<?> iterator = connections.iterator(); iterator
					.hasNext();) {
				TreeNodeConnection treeNodeConnection = (TreeNodeConnection) iterator
						.next();
				// check if the node is "collection bean" node , if is not ,
				// check its parent node.
				AbstractSmooksGraphicalModel collectionJavaBean = treeNodeConnection
						.getSourceNode();
				collectionJavaBean = collectionJavaBean.getParent();
				if (collectionJavaBean instanceof JavaBeanGraphModel) {
					Object data = collectionJavaBean.getData();
					data = AdapterFactoryEditingDomain.unwrap(data);
					if (data != null && data instanceof EObject) {
						if (SmooksUIUtils
								.isCollectionJavaGraphModel((EObject) data)) {
							return (JavaBeanGraphModel) collectionJavaBean;
							// check if it was linked with the "many" template
							// node
							// List<TreeNodeConnection> collectionLinks =
							// collectionJavaBean.getSourceConnections();
							// for (Iterator<?> iterator2 =
							// collectionLinks.iterator(); iterator2.hasNext();)
							// {
							// TreeNodeConnection treeNodeConnection2 =
							// (TreeNodeConnection) iterator2.next();
							// AbstractSmooksGraphicalModel templateNode =
							// treeNodeConnection2.getTargetNode();
							// if(templateNode instanceof
							// FreemarkerTemplateNodeGraphicalModel){
							// Object templateData =
							// ((FreemarkerTemplateNodeGraphicalModel)templateNode).getData();
							// if(templateData instanceof
							// IFreemarkerTemplateModel){
							// if(((IFreemarkerTemplateModel)templateData).isManyOccurs()){
							// return (JavaBeanGraphModel) collectionJavaBean;
							// }
							// }
							// }
							// }

						}
					}
				}
				JavaBeanGraphModel result = getCollectionRootBeanModel(collectionJavaBean);
				if (result != null)
					return result;
			}
		}
		return null;
	}

	protected boolean isCollectionConnection(TreeNodeConnection connection) {
		TreeNodeModel sourceNode = (TreeNodeModel) connection.getSourceNode();
		TreeNodeModel targetNode = (TreeNodeModel) connection.getTargetNode();
		Object targetData = targetNode.getData();
		Object data = sourceNode.getData();
		
		if(targetData instanceof IFreemarkerTemplateModel && !((IFreemarkerTemplateModel) targetData).isManyOccurs()) {
			return false;
		}
		
		if (data instanceof EObject && SmooksUIUtils.isCollectionJavaGraphModel((EObject) data)) {
			return true;
		} else if(sourceNode.isValidCollectionNode() && targetNode.isValidCollectionNode()) {
			return true;
		}
		
		return false;
	}

	protected boolean isMappingValueConnection(TreeNodeConnection connection) {
		AbstractSmooksGraphicalModel sourceNode = connection.getSourceNode();
		Object data = sourceNode.getData();
		if (data instanceof ValueType) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel#
	 * removeTargetConnection
	 * (org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection)
	 */
	@Override
	public void removeTargetConnection(TreeNodeConnection connection) {
		((TreeNodeModel)connection.getSourceNode()).getConnections().remove(connection);
		getConnections().remove(connection);
//		changeFreemarkerContents();
//		super.removeTargetConnection(connection);
		RemoveResult removeResult;
		try {
			TemplateBuilder builder = getTemplateBuilder();
			Object mapping = connection.getData();
			if (builder == null || mapping == null)
				return;
			if (mapping instanceof Mapping) {
				removeResult = builder.removeMapping((Mapping) mapping);
				
				connection.setData(removeResult);
			}
			changeFreemarkerContents();
			super.removeTargetConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	protected TreeNodeModel createChildModel(Object model,
			ITreeContentProvider contentProvider, ILabelProvider labelProvider) {
		return new FreemarkerTemplateNodeGraphicalModel(model, contentProvider,
				labelProvider, this.domainProvider);
	}

}
