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
package org.jboss.tools.smooks.graphical.editors.template;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.ui.IEditorPart;
import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.configuration.editors.xml.AbstractXMLObject;
import org.jboss.tools.smooks.configuration.editors.xml.TagObject;
import org.jboss.tools.smooks.configuration.editors.xml.TagPropertyObject;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.gef.common.RootModel;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;
import org.jboss.tools.smooks.graphical.editors.ConnectionModelFactoryImpl;
import org.jboss.tools.smooks.graphical.editors.editparts.SmooksGraphUtil;
import org.jboss.tools.smooks.graphical.editors.model.AbstractResourceConfigChildNodeGraphModel;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerTemplateConnection;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerTemplateGraphicalModel;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerTemplateNodeGraphicalModel;
import org.jboss.tools.smooks.model.freemarker.Freemarker;
import org.jboss.tools.smooks.model.freemarker.Template;
import org.jboss.tools.smooks.model.javabean12.BeanType;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;
import org.jboss.tools.smooks.templating.template.Mapping;
import org.jboss.tools.smooks.templating.template.ValueMapping;
import org.jboss.tools.smooks.templating.template.TemplateBuilder;
import org.w3c.dom.Node;

/**
 * @author Dart
 * 
 */
public class FreemarkerTemplateConnectionModelFactory extends ConnectionModelFactoryImpl {

	private List<Mapping> mappingList = null;

	private ISmooksModelProvider smooksModelProvider;
	private IEditorPart editorPart;

	public FreemarkerTemplateConnectionModelFactory(ISmooksModelProvider smooksModelProvider, IEditorPart editorPart) {
		super();
		this.smooksModelProvider = smooksModelProvider;
		this.editorPart = editorPart;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.tools.smooks.graphical.editors.ConnectionModelFactoryImpl
	 * #hasBeanIDConnection
	 * (org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel)
	 */
	@Override
	public boolean hasBeanIDConnection(AbstractSmooksGraphicalModel model) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.tools.smooks.graphical.editors.ConnectionModelFactoryImpl
	 * #hasSelectorConnection
	 * (org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel)
	 */
	@Override
	public boolean hasSelectorConnection(AbstractSmooksGraphicalModel model) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.tools.smooks.graphical.editors.ConnectionModelFactoryImpl
	 * #createConnection(java.util.List, org.eclipse.emf.ecore.EObject,
	 * org.jboss.tools.smooks.gef.common.RootModel,
	 * org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel)
	 */
	@Override
	public Collection<TreeNodeConnection> createConnection(List<Object> inputDataList, EObject rootModel,
			RootModel root, AbstractSmooksGraphicalModel model) {
		List<TreeNodeConnection> collections = new ArrayList<TreeNodeConnection>();

		if (model instanceof FreemarkerTemplateNodeGraphicalModel) {
			AbstractXMLObject data = (AbstractXMLObject) model.getData();
			Node mynode = null;

			if (data instanceof TagPropertyObject) {
				mynode = ((TagPropertyObject) data).getReferenceAttibute();
			}

			if (data instanceof TagObject) {
				mynode = ((TagObject) data).getReferenceElement();
			}

			AbstractSmooksGraphicalModel freemarkerGraphModel = model.getParent();
			if (!(freemarkerGraphModel instanceof FreemarkerTemplateGraphicalModel)) {
				freemarkerGraphModel = freemarkerGraphModel.getParent();
			}

			if (mappingList == null && freemarkerGraphModel instanceof FreemarkerTemplateGraphicalModel) {
				fillMapping((FreemarkerTemplateGraphicalModel) freemarkerGraphModel);
			}
			AbstractSmooksGraphicalModel sourceNode = null;
			AbstractSmooksGraphicalModel targetNode = model;
			SmooksResourceListType listType = SmooksUIUtils.getSmooks11ResourceListType(smooksModelProvider
					.getSmooksModel());
			List<EObject> beanidModels = new ArrayList<EObject>();
			if (listType != null) {
				SmooksUIUtils.fillBeanIdModelList(listType, beanidModels);
			}
			for (Iterator<?> iterator = mappingList.iterator(); iterator.hasNext();) {
				Mapping mapping = (Mapping) iterator.next();
				String path = mapping.getSrcPath();
				Node node = mapping.getMappingNode();
				if (node != mynode)
					continue;
				for (Iterator<?> iterator2 = beanidModels.iterator(); iterator2.hasNext();) {
					EObject eObject = (EObject) iterator2.next();
					EStructuralFeature feature = SmooksUIUtils.getBeanIDFeature(eObject);
					if (feature != null) {
						String beanid = (String) eObject.eGet(feature);
						if (path.equals(beanid)) {
							sourceNode = SmooksGraphUtil.findSmooksGraphModel((RootModel) root, eObject);

						} else {
							String[] subpath = path.split("\\."); //$NON-NLS-1$
							if (subpath.length >= 2) {
								String[] temppath = new String[2];
								System.arraycopy(subpath, subpath.length - 2, temppath, 0, 2);
								Object beanModel = findJavaBeanModel(temppath[0], beanidModels);
								if (beanModel != null) {
									Object targetModel = findJavaGraphModel(temppath[1], beanModel);
									sourceNode = SmooksGraphUtil.findSmooksGraphModel((RootModel) root, targetModel);
								}
							}
						}

						if (sourceNode != null && targetNode != null) {
							TreeNodeConnection connection = new FreemarkerTemplateConnection();
							connection.setSourceNode(sourceNode);
							connection.setTargetNode(targetNode);
							connection.connectSource();
							targetNode.getTargetConnections().add(connection);
							targetNode.fireConnectionChanged();
							collections.add(connection);
							connection.setData(mapping);
							
							if(sourceNode instanceof AbstractResourceConfigChildNodeGraphModel && mapping instanceof ValueMapping) {
								((AbstractResourceConfigChildNodeGraphModel)sourceNode).addMappingTypeInfo((ValueMapping) mapping);
							}
							
							break;
						}
					}
				}
			}
		}

		Collection<TreeNodeConnection> cs = super.createConnection(inputDataList, rootModel, root, model);
		if (cs != null) {
			collections.addAll(cs);
		}
		return collections;
	}

	private Object findJavaGraphModel(String propertyName, Object bean) {
		if (bean instanceof BeanType) {
			List<?> values = ((BeanType) bean).getValue();
			for (Iterator<?> iterator = values.iterator(); iterator.hasNext();) {
				org.jboss.tools.smooks.model.javabean12.ValueType value = (org.jboss.tools.smooks.model.javabean12.ValueType) iterator
						.next();
				if (propertyName.equals(value.getProperty())) {
					return value;
				}
			}
		}
		// if (bean instanceof BindingsType) {
		// List<?> values = ((BindingsType) bean).getValue();
		// for (Iterator<?> iterator = values.iterator();
		// iterator.hasNext();) {
		// ValueType value = (ValueType) iterator.next();
		// if (propertyName.equals(value.getProperty())) {
		// return value;
		// }
		// }
		// }
		return null;
	}

	private Object findJavaBeanModel(String beanid, List<EObject> beans) {
		for (Iterator<?> iterator = beans.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			if (object instanceof BeanType) {
				if (beanid.equals(((BeanType) object).getBeanId())) {
					return object;
				}
			}
		}
		return null;
	}

	private void fillMapping(FreemarkerTemplateGraphicalModel freemarkerGraph) {

		if (mappingList == null) {
			mappingList = new ArrayList<Mapping>();
		} else {
			mappingList.clear();
		}

		Object data = freemarkerGraph.getData();
		data = AdapterFactoryEditingDomain.unwrap(data);

		Freemarker freemarker = null;

		if (data instanceof Freemarker) {
			freemarker = (Freemarker) data;
		}

		Template template = freemarker.getTemplate();
		String contents = SmooksModelUtils.getAnyTypeCDATA(template);
		try {
			if (contents != null) {
				TemplateBuilder builder = freemarkerGraph.getTemplateBuilder();
				if (builder != null) {
					List<Mapping> mappings = builder.getMappings();
					mappingList.addAll(mappings);
				}
			}
		} catch (Exception e) {
			// ignore exception
			// e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.tools.smooks.graphical.editors.ConnectionModelFactoryImpl
	 * #hasConnection
	 * (org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel)
	 */
	@Override
	public boolean hasConnection(AbstractSmooksGraphicalModel model) {
		if (model instanceof FreemarkerTemplateNodeGraphicalModel) {
			return true;
		}
		return super.hasConnection(model);
	}

}
