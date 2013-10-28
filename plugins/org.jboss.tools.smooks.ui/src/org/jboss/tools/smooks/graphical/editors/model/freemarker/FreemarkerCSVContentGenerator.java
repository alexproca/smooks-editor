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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;
import org.jboss.tools.smooks.graphical.editors.model.javamapping.JavaBeanChildGraphModel;
import org.jboss.tools.smooks.graphical.editors.model.javamapping.JavaBeanGraphModel;
import org.jboss.tools.smooks.model.freemarker.Freemarker;
import org.jboss.tools.smooks.model.javabean12.BeanType;
import org.jboss.tools.smooks.templating.model.ModelBuilderException;
import org.jboss.tools.smooks.templating.model.csv.CSVModelBuilder;
import org.jboss.tools.smooks.templating.template.csv.CSVFreeMarkerTemplateBuilder;
import org.jboss.tools.smooks.templating.template.exception.InvalidMappingException;
import org.jboss.tools.smooks.templating.template.exception.TemplateBuilderException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author Dart
 * 
 */
public class FreemarkerCSVContentGenerator {
	
	public FreemarkerCSVContentGenerator() {
		//empty constructor
	}

	public String generateCSVContents(FreemarkerCSVNodeGraphicalModel csvRecordGraphicalModel)
			throws TemplateBuilderException, ModelBuilderException {

		// CSVNodeModel csvRecordModel = (CSVNodeModel)
		// csvRecordGraphicalModel.getData();

		String collectionName = null;

		List<TreeNodeConnection> recordConnections = csvRecordGraphicalModel.getTargetConnections();
		if (recordConnections.size() > 1 || recordConnections.isEmpty()) {
			return null;
		}

		TreeNodeConnection recordRootConnection = recordConnections.get(0);
		AbstractSmooksGraphicalModel javabeanModel = recordRootConnection.getSourceNode();
		List<AbstractSmooksGraphicalModel> javabeanChildren = javabeanModel.getChildrenWithoutDynamic();
		for (Iterator<?> iterator = javabeanChildren.iterator(); iterator.hasNext();) {
			AbstractSmooksGraphicalModel abstractSmooksGraphicalModel = (AbstractSmooksGraphicalModel) iterator.next();
			Object javabean = abstractSmooksGraphicalModel.getData();
			javabean = AdapterFactoryEditingDomain.unwrap(javabean);
			if (javabean instanceof org.jboss.tools.smooks.model.javabean12.WiringType) {
				collectionName = ((org.jboss.tools.smooks.model.javabean12.WiringType) javabean).getBeanIdRef();
			}
		}

		if (collectionName == null)
			return null;
		AbstractSmooksGraphicalModel freemarkerTemplateGraphmodel = csvRecordGraphicalModel.getParent();
		if (!(freemarkerTemplateGraphmodel instanceof FreemarkerTemplateGraphicalModel)) {
			return null;
		}
		Object freemarker = ((FreemarkerTemplateGraphicalModel) freemarkerTemplateGraphmodel).getData();
		freemarker = AdapterFactoryEditingDomain.unwrap(freemarker);
		if (!(freemarker instanceof Freemarker)) {
			return null;
		}

		char sperator = SmooksModelUtils.getFreemarkerCSVSeperator((Freemarker) freemarker);
		char quote = SmooksModelUtils.getFreemarkerCSVQuote((Freemarker) freemarker);
		boolean includeFieldNames = SmooksModelUtils.getFreemarkerCSVIncludeFieldNames((Freemarker) freemarker);

		List<AbstractSmooksGraphicalModel> childrenGraphModel = csvRecordGraphicalModel.getChildren();
		List<String> fieldsName = new ArrayList<String>();
		for (Iterator<?> iterator = childrenGraphModel.iterator(); iterator.hasNext();) {
			AbstractSmooksGraphicalModel abstractSmooksGraphicalModel = (AbstractSmooksGraphicalModel) iterator.next();
			Object cd = abstractSmooksGraphicalModel.getData();
			cd = AdapterFactoryEditingDomain.unwrap(cd);
			if (cd instanceof IXMLStructuredObject) {
				fieldsName.add(((IXMLStructuredObject) cd).getNodeName());
			}
		}

		CSVModelBuilder modelBuilder = new CSVModelBuilder(fieldsName.toArray(new String[] {}));
		CSVFreeMarkerTemplateBuilder builder;
		Document model;

		builder = new CSVFreeMarkerTemplateBuilder(modelBuilder, sperator, quote, includeFieldNames);
		model = builder.getModel();

		List<TreeNodeConnection> connections = csvRecordGraphicalModel.getTargetConnections();
		if (!connections.isEmpty() && connections.size() == 1) {
			TreeNodeConnection recordConnection = connections.get(0);
			AbstractSmooksGraphicalModel sourceGraphModel = recordConnection.getSourceNode();
			if (sourceGraphModel instanceof JavaBeanGraphModel) {
				Object data = ((JavaBeanGraphModel) sourceGraphModel).getData();
				data = AdapterFactoryEditingDomain.unwrap(data);
				String beanName = null;
				if (data instanceof BeanType) {
					beanName = ((BeanType) data).getBeanId();
				}
				if (beanName != null)
					builder.addCollectionMapping(beanName, getRecordElement(model), collectionName);

				List<AbstractSmooksGraphicalModel> graphChildren = csvRecordGraphicalModel.getChildren();
				for (Iterator<?> iterator = graphChildren.iterator(); iterator.hasNext();) {
					AbstractSmooksGraphicalModel abstractSmooksGraphicalModel = (AbstractSmooksGraphicalModel) iterator
							.next();
					addValueMapping(builder, (FreemarkerCSVNodeGraphicalModel) abstractSmooksGraphicalModel, model,
							collectionName, (JavaBeanGraphModel) sourceGraphModel);
				}
			}
		}

		return builder.buildTemplate();
	}

	protected void addValueMapping(CSVFreeMarkerTemplateBuilder builder, FreemarkerCSVNodeGraphicalModel filedNode,
			Document model, String recordName, JavaBeanGraphModel recordRootNode) throws InvalidMappingException {
		CSVNodeModel csvFieldNode = (CSVNodeModel) filedNode.getData();
		String elementName = csvFieldNode.getName();
		List<TreeNodeConnection> connections = filedNode.getTargetConnections();
		if (!connections.isEmpty() && connections.size() == 1) {
			TreeNodeConnection recordConnection = connections.get(0);
			AbstractSmooksGraphicalModel sourceGraphModel = recordConnection.getSourceNode();
			String mappingString = generateJavaSourcePathWithoutRootNode(sourceGraphModel, recordRootNode);
			// if (mappingString != null) {
			// mappingString = recordName + "." + mappingString;
			// }
			if (mappingString == null || mappingString.length() == 0) {
				return;
			}
			builder.addValueMapping(mappingString, getFieldElement(model, elementName));
		}
	}
	
	public static String generateFullJavaSourcePathString(AbstractSmooksGraphicalModel sourceGraphModel,JavaBeanGraphModel recordRootNode) {
		AbstractSmooksGraphicalModel parentModel = sourceGraphModel;
		Object sourceModel = sourceGraphModel.getData();
		sourceModel = AdapterFactoryEditingDomain.unwrap(sourceModel);
		String s = null;
		if (sourceModel instanceof org.jboss.tools.smooks.model.javabean12.ValueType) {
			s = ((org.jboss.tools.smooks.model.javabean12.ValueType) sourceModel).getProperty();
		}

		List<Object> nodesList = new ArrayList<Object>();
		fillParentList(nodesList, parentModel, recordRootNode);
		String mappingString = ""; //$NON-NLS-1$
		for (int i = 0; i < nodesList.size(); i++) {
			Object node = nodesList.get(i);
			String beanName = null;
			if (node instanceof BeanType) {
				beanName = ((BeanType) node).getBeanId();
			}
			if (beanName != null) {
				mappingString += (beanName + "."); //$NON-NLS-1$
			}
		}
		if (s != null) {
			mappingString += s;
		}
		return mappingString;
	}
			

	public static String generateJavaSourcePathWithoutRootNode(AbstractSmooksGraphicalModel sourceGraphModel,
			JavaBeanGraphModel recordRootNode) {
		AbstractSmooksGraphicalModel parentModel = sourceGraphModel;
		Object sourceModel = sourceGraphModel.getData();
		sourceModel = AdapterFactoryEditingDomain.unwrap(sourceModel);
		String s = null;
		if (sourceModel instanceof org.jboss.tools.smooks.model.javabean12.ValueType) {
			s = ((org.jboss.tools.smooks.model.javabean12.ValueType) sourceModel).getProperty();
		}

		List<Object> nodesList = new ArrayList<Object>();
		fillParentList(nodesList, parentModel, recordRootNode);
		if(!nodesList.isEmpty()){
			nodesList.remove(0);
		}
		String mappingString = ""; //$NON-NLS-1$
		for (int i = 0; i < nodesList.size(); i++) {
			Object node = nodesList.get(i);
			String beanName = null;
			if (node instanceof BeanType) {
				beanName = ((BeanType) node).getBeanId();
			}
			if (beanName != null) {
				mappingString += (beanName + "."); //$NON-NLS-1$
			}
		}
		if (s != null) {
			mappingString += s;
		}
		return mappingString;
	}

	private static boolean fillParentList(List<Object> list, AbstractSmooksGraphicalModel node,
			JavaBeanGraphModel recordRootNode) {
		if (node instanceof JavaBeanChildGraphModel) {
			node = node.getParent();
		}
		if(node == recordRootNode){
			list.add(recordRootNode.getData());
			return true;
		}else{
			if (node instanceof JavaBeanGraphModel) {
				Object parent = node.getData();
				List<TreeNodeConnection> connections = ((JavaBeanGraphModel) node).getTargetConnections();
				for (Iterator<?> iterator = connections.iterator(); iterator.hasNext();) {
					TreeNodeConnection connection = (TreeNodeConnection) iterator.next();
					AbstractSmooksGraphicalModel sourcenode = connection.getSourceNode();
					if (fillParentList(list, sourcenode, recordRootNode)) {
						parent = AdapterFactoryEditingDomain.unwrap(parent);
						list.add(parent);
						return true;
					}
				}
			}
		}
		return false;
	}

	private Element getRecordElement(Document model) {
		return model.getDocumentElement();
	}

	private Element getFieldElement(Document model, String fieldName) {
		return (Element) model.getElementsByTagName(fieldName).item(0);
	}

}
