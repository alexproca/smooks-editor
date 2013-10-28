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

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.swt.graphics.Image;
import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.configuration.SmooksConfigurationActivator;
import org.jboss.tools.smooks.configuration.editors.GraphicsConstants;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;
import org.jboss.tools.smooks.graphical.editors.model.AbstractResourceConfigGraphModel;
import org.jboss.tools.smooks.graphical.editors.template.FreemarkerTemplateContentGraphModelProviderImpl;
import org.jboss.tools.smooks.graphical.editors.template.IFreemarkerTemplateContentGraphModelProvider;
import org.jboss.tools.smooks.model.freemarker.Freemarker;
import org.jboss.tools.smooks.model.freemarker.Template;
import org.jboss.tools.smooks.templating.model.ModelBuilderException;
import org.jboss.tools.smooks.templating.template.TemplateBuilder;
import org.jboss.tools.smooks.templating.template.exception.TemplateBuilderException;

/**
 * @author Dart
 * 
 */
public class FreemarkerTemplateGraphicalModel extends AbstractResourceConfigGraphModel {

	public static final int TYPE_CSV = 1;

	public static final int TYPE_EDI = 2;

	public static final int TYPE_XML = 3;

	public static final int TYPE_XSD = 4;
	
	public static final int TYPE_UNKNOWN = -1;

	private ISmooksModelProvider smooksModelProvider;

	private boolean firstLoadChildren = true;

	private IFreemarkerTemplateContentGraphModelProvider graphModelProvider = null;

	private TemplateBuilder templateBuilder = null;

	public FreemarkerTemplateGraphicalModel(Object data, ITreeContentProvider contentProvider,
			ILabelProvider labelProvider, ISmooksModelProvider domainProvider) {
		super(data, contentProvider, labelProvider, domainProvider);
		this.smooksModelProvider = domainProvider;
		graphModelProvider = createFreemarkerTemplateContentGraphModelProvider();
		try {
			templateBuilder = graphModelProvider.getTemplateBuilder(this);
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ModelBuilderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateBuilderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the templateBuilder
	 */
	public TemplateBuilder getTemplateBuilder() {
		return templateBuilder;
	}

	public void changeFreemarkerContents() {
		Template template = null;
		
		if (data instanceof Freemarker) {
			template = ((Freemarker) data).getTemplate();
		}
		
		if (template == null) {
			return;
		}
		
		if (templateBuilder != null) {
			String content = null;
			try {
				content = templateBuilder.buildTemplate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			SmooksModelUtils.setCDATAToSmooksType(domainProvider.getEditingDomain(), template, content);
		}
	}
	
	protected IFreemarkerTemplateContentGraphModelProvider createFreemarkerTemplateContentGraphModelProvider() {
		return new FreemarkerTemplateContentGraphModelProviderImpl();
	}

	protected void initChildrenNodes() {
		Object data = getData();
		data = AdapterFactoryEditingDomain.unwrap(data);
		Freemarker freemarker = (Freemarker) data;
		if (freemarker != null) {
			List<AbstractSmooksGraphicalModel> graphModels = graphModelProvider.getFreemarkerTemplateContentGraphModel(
					this, getContentProvider(), getLabelProvider(), smooksModelProvider);
			for (Iterator<?> iterator = graphModels.iterator(); iterator.hasNext();) {
				AbstractSmooksGraphicalModel abstractSmooksGraphicalModel = (AbstractSmooksGraphicalModel) iterator
						.next();
				this.getChildrenWithoutDynamic().add(abstractSmooksGraphicalModel);
				abstractSmooksGraphicalModel.setParent(this);
			}
		}
		
		Template template = freemarker.getTemplate();
		String templateData = template.getCDATA();
		if(templateData == null) {
			SmooksModelUtils.setCDATAToSmooksType(domainProvider.getEditingDomain(), template, "<noMappings/>"); //$NON-NLS-1$
		}
	}

	@Override
	protected TreeNodeModel createChildModel(Object model, ITreeContentProvider contentProvider,
			ILabelProvider labelProvider) {
		if (getTemplateType() == TYPE_CSV) {
			return new FreemarkerCSVNodeGraphicalModel(model, contentProvider, labelProvider, domainProvider);
		}
		return null;
	}

	@Override
	public Image getImage() {
		ImageRegistry registry = SmooksConfigurationActivator.getDefault().getImageRegistry();
		if (getTemplateType() == TYPE_CSV) {
			return registry.get(GraphicsConstants.IMAGE_CSV_FILE);
		}
		if (getTemplateType() == TYPE_XML) {
			return registry.get(GraphicsConstants.IMAGE_XML_FILE);
		}
		return registry.get(GraphicsConstants.IMAGE_UNKNOWN_OBJ);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.tools.smooks.gef.tree.model.TreeNodeModel#getText()
	 */
	@Override
	public String getText() {
		if (getTemplateType() == TYPE_CSV) {
			return Messages.FreemarkerTemplateGraphicalModel_CSV_Template_Name;
		}
		if (getTemplateType() == TYPE_XML) {
			return Messages.FreemarkerTemplateGraphicalModel_XML_Template_Name;
		}
		return super.getText();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.tools.smooks.gef.tree.model.TreeNodeModel#getChildren()
	 */
	@Override
	public List<AbstractSmooksGraphicalModel> getChildren() {
		if (firstLoadChildren) {
			try {
				initChildrenNodes();
			} catch (Exception e) {
				e.printStackTrace();
			}
			firstLoadChildren = false;
		}
		return this.getChildrenWithoutDynamic();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel#addChild
	 * (org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel)
	 */
	@Override
	public void addChild(AbstractSmooksGraphicalModel node) {
		super.addChild(node);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel#addChild
	 * (int, org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel)
	 */
	@Override
	public void addChild(int index, AbstractSmooksGraphicalModel node) {
		super.addChild(index, node);
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
		// return super.canLinkWithSource(model);
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
		// return super.canLinkWithTarget(model);
	}

	/**
	 * @return the templateType
	 */
	public int getTemplateType() {
		Object data = getData();
		data = AdapterFactoryEditingDomain.unwrap(data);
		Freemarker freemarker = (Freemarker) data;
		if (freemarker != null) {
			String type = SmooksModelUtils.getTemplateType(freemarker);
			if(SmooksModelUtils.FREEMARKER_TEMPLATE_TYPE_CSV.equals(type)){
				return TYPE_CSV;
			}
			if(SmooksModelUtils.FREEMARKER_TEMPLATE_TYPE_XML.equals(type)){
				return TYPE_XML;
			}
		}
		return TYPE_UNKNOWN;
	}
}
