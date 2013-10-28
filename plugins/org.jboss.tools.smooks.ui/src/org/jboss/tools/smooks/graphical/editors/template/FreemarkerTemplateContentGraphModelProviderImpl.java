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

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject;
import org.jboss.tools.smooks.configuration.editors.utils.SmooksUIUtils;
import org.jboss.tools.smooks.configuration.editors.xml.TagList;
import org.jboss.tools.smooks.configuration.editors.xml.TagObject;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.graphical.editors.TaskTypeManager;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.CSVNodeModel;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerCSVNodeGraphicalModel;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerModelAnalyzer;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerTemplateGraphicalModel;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerTemplateXMLModel;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerXMLNodeGraphicalModel;
import org.jboss.tools.smooks.model.freemarker.Freemarker;
import org.jboss.tools.smooks.templating.model.ModelBuilder;
import org.jboss.tools.smooks.templating.model.ModelBuilderException;
import org.jboss.tools.smooks.templating.model.csv.CSVModelBuilder;
import org.jboss.tools.smooks.templating.model.xml.XMLSampleModelBuilder;
import org.jboss.tools.smooks.templating.model.xml.XSDModelBuilder;
import org.jboss.tools.smooks.templating.template.TemplateBuilder;
import org.jboss.tools.smooks.templating.template.csv.CSVFreeMarkerTemplateBuilder;
import org.jboss.tools.smooks.templating.template.exception.TemplateBuilderException;
import org.jboss.tools.smooks.templating.template.freemarker.FreeMarkerTemplateBuilder;
import org.jboss.tools.smooks.templating.template.xml.XMLFreeMarkerTemplateBuilder;
import org.w3c.dom.Document;

/**
 * @author Dart
 * 
 */
public class FreemarkerTemplateContentGraphModelProviderImpl implements IFreemarkerTemplateContentGraphModelProvider {

	private FreeMarkerTemplateBuilder templateBuilder = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.graphical.editors.template.
	 * IFreemarkerTemplateContentGraphModelProvider
	 * #getFreemarkerTemplateContentGraphModel
	 * (org.jboss.tools.smooks.graphical.editors
	 * .model.freemarker.FreemarkerTemplateGraphicalModel)
	 */
	public List<AbstractSmooksGraphicalModel> getFreemarkerTemplateContentGraphModel(
			FreemarkerTemplateGraphicalModel freemarkerGraphModel, ITreeContentProvider contentProvider,
			ILabelProvider labelProvider, ISmooksModelProvider smooksModelProvider) {
		Freemarker freemarker = (Freemarker) freemarkerGraphModel.getData();
		if (freemarker != null) {
			String type = SmooksModelUtils.getTemplateType(freemarker);
			try {
				TemplateBuilder builder = getModelBuilder(freemarker);
				if(builder == null) return null;
				Document rootDocument = builder.getModel();
				Class<? extends TagObject> tagModelClass = null;
				if(SmooksModelUtils.FREEMARKER_TEMPLATE_TYPE_CSV.equals(type)){
					tagModelClass = CSVNodeModel.class;
				}
				if(SmooksModelUtils.FREEMARKER_TEMPLATE_TYPE_XML.equals(type)){
					tagModelClass = FreemarkerTemplateXMLModel.class;
				}
				TagList tagList = new FreemarkerModelAnalyzer().analyze(rootDocument, null,tagModelClass);
				return createGraphModel(type, tagList.getChildren(), contentProvider, labelProvider,
						smooksModelProvider, null);
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ModelBuilderException e) {
				e.printStackTrace();
			} catch (TemplateBuilderException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	protected List<AbstractSmooksGraphicalModel> createGraphModel(String type, List<IXMLStructuredObject> datas,
			ITreeContentProvider contentProvider, ILabelProvider labelProvider,
			ISmooksModelProvider smooksModelProvider, AbstractSmooksGraphicalModel parentModel) {
		List<AbstractSmooksGraphicalModel> graphList = new ArrayList<AbstractSmooksGraphicalModel>();
		if (datas != null) {
			for (Iterator<?> iterator = datas.iterator(); iterator.hasNext();) {
				Object data = (Object) iterator.next();
				AbstractSmooksGraphicalModel graphModel = createFreemarkerTemplateGraphModel(type, data,
						contentProvider, labelProvider, smooksModelProvider);
				if (graphModel == null)
					continue;
				if (parentModel != null) {
					parentModel.getChildrenWithoutDynamic().add(graphModel);
					graphModel.setParent(parentModel);
				} else {
					graphList.add(graphModel);
				}
				if (data instanceof TagObject) {
					createGraphModel(type, ((TagObject) data).getChildren(), contentProvider, labelProvider,
							smooksModelProvider, graphModel);
				}
			}
		}
		return graphList;
	}

	public TemplateBuilder getModelBuilder(Freemarker freemarker) throws InvocationTargetException, IOException,
			ModelBuilderException, TemplateBuilderException {
		if (templateBuilder == null) {
			String contents = SmooksModelUtils.getAnyTypeCDATA(freemarker.getTemplate());
			String type = SmooksModelUtils.getTemplateType(freemarker);
			if (SmooksModelUtils.FREEMARKER_TEMPLATE_TYPE_CSV.equals(type)) {
				String[] fields = SmooksModelUtils.getFreemarkerCSVFileds(freemarker);
				CSVModelBuilder modelBuilder = new CSVModelBuilder(fields);
				CSVFreeMarkerTemplateBuilder builder1 = null;
				try {
					builder1 = new CSVFreeMarkerTemplateBuilder(modelBuilder, SmooksModelUtils
							.getFreemarkerCSVSeperator(freemarker), SmooksModelUtils.getFreemarkerCSVQuote(freemarker),
							SmooksModelUtils.getFreemarkerCSVIncludeFieldNames(freemarker),							
							contents);
				} catch (Exception e) {
					builder1 = new CSVFreeMarkerTemplateBuilder(modelBuilder, SmooksModelUtils
							.getFreemarkerCSVSeperator(freemarker), SmooksModelUtils.getFreemarkerCSVQuote(freemarker),
							SmooksModelUtils.getFreemarkerCSVIncludeFieldNames(freemarker));
				}
				templateBuilder = builder1;
			}
			if (SmooksModelUtils.FREEMARKER_TEMPLATE_TYPE_XML.equals(type)) {
				String fileType = SmooksModelUtils.getFreemarkerXMLFileType(freemarker);
				String filePath = SmooksModelUtils.getFreemarkerXMLFilePath(freemarker);
				String rootName = SmooksModelUtils.getFreemarkerXMLRootName(freemarker);
				String newFilePath = SmooksUIUtils.parseFilePath(filePath);
				ModelBuilder builder;
				
				if (SmooksModelUtils.KEY_XML_FILE_TYPE_XSD.equals(fileType)) {
					builder = new XSDModelBuilder(URI.createFileURI(newFilePath));
					((XSDModelBuilder)builder).setRootElementName(rootName);
				} else if (SmooksModelUtils.KEY_XML_FILE_TYPE_XML.equals(fileType)) {
					builder = new XMLSampleModelBuilder(URI.createFileURI(newFilePath));
				} else {
					throw new IOException(Messages.FreemarkerTemplateContentGraphModelProviderImpl_IOExceptionMessage + fileType + "'."); //$NON-NLS-1$
				}

				try {
					templateBuilder = new XMLFreeMarkerTemplateBuilder(builder, contents);
				} catch (Exception e) {
					templateBuilder = new XMLFreeMarkerTemplateBuilder(builder);
				}
			}
			String templateProvider = SmooksModelUtils.getParamValue(freemarker.getParam(), SmooksModelUtils.TEMPLATE_DATA_PROVIDER_PARAM_NAME);
			if(templateProvider != null) {
				templateBuilder.setNodeModelSource(templateProvider.trim().equals(TaskTypeManager.TASK_ID_INPUT));
			} else {
				templateBuilder.setNodeModelSource(false);
			}
		}
		return templateBuilder;
	}

	public AbstractSmooksGraphicalModel createFreemarkerTemplateGraphModel(String type, Object data,
			ITreeContentProvider contentProvider, ILabelProvider labelProvider, ISmooksModelProvider smooksModelProvider) {
		if (SmooksModelUtils.FREEMARKER_TEMPLATE_TYPE_CSV.equals(type) && data instanceof TagObject) {
			return new FreemarkerCSVNodeGraphicalModel(data, contentProvider, labelProvider, smooksModelProvider);
		}
		if (SmooksModelUtils.FREEMARKER_TEMPLATE_TYPE_XML.equals(type)) {
			return new FreemarkerXMLNodeGraphicalModel(data, contentProvider, labelProvider,smooksModelProvider);
		}
		return null;
	}

	public TemplateBuilder getTemplateBuilder(FreemarkerTemplateGraphicalModel freemarkerGraphModel)
			throws InvocationTargetException, IOException, ModelBuilderException, TemplateBuilderException {
		Object data = freemarkerGraphModel.getData();
		data = AdapterFactoryEditingDomain.unwrap(data);
		Freemarker freemarker = (Freemarker) data;
		return getModelBuilder(freemarker);
	}

}
