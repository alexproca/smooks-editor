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

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.ui.IEditorPart;
import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.gef.tree.model.TreeContainerModel;
import org.jboss.tools.smooks.graphical.editors.GraphicalModelFactoryImpl;
import org.jboss.tools.smooks.graphical.editors.IGraphicalEditorPart;
import org.jboss.tools.smooks.graphical.editors.ITaskNodeProvider;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerContentProvider;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerLabelProvider;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerTemplateGraphicalModel;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerTemplateModelLabelProvider;
import org.jboss.tools.smooks.graphical.editors.model.javamapping.JavaBeanGraphModel;
import org.jboss.tools.smooks.graphical.editors.process.TaskType;
import org.jboss.tools.smooks.model.freemarker.Freemarker;
import org.jboss.tools.smooks.model.javabean12.BeanType;

/**
 * @author Dart
 * 
 */
public class FreemarkerTemplateGraphicalModelFactory extends GraphicalModelFactoryImpl {
	// private ISmooksModelProvider smooksModelProvider;
	private IEditorPart editorPart;

	public FreemarkerTemplateGraphicalModelFactory(ISmooksModelProvider smooksModelProvider, IEditorPart editorPart) {
		super();
		// this.smooksModelProvider = smooksModelProvider;
		this.editorPart = editorPart;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.tools.smooks.graphical.editors.GraphicalModelFactoryImpl
	 * #createGraphicalModel(java.lang.Object,
	 * org.jboss.tools.smooks.editor.ISmooksModelProvider)
	 */
	@Override
	public Object createGraphicalModel(Object model, ISmooksModelProvider provider) {
		if (canCreateGraphicalModel(model, provider)) {
			AbstractSmooksGraphicalModel graphModel = null;
			AdapterFactoryEditingDomain editingDomain = (AdapterFactoryEditingDomain) provider.getEditingDomain();
			ITreeContentProvider contentProvider = new AdapterFactoryContentProvider(editingDomain.getAdapterFactory());
			ILabelProvider labelProvider = createLabelProvider(editingDomain.getAdapterFactory());

			if (model instanceof Freemarker && editorPart instanceof ITaskNodeProvider) {
				// Template template = ((Freemarker) model).getTemplate();
				String messageType = SmooksModelUtils.getTemplateType((Freemarker) model);
				if (messageType != null) {
					TaskType taskType = ((ITaskNodeProvider) editorPart).getTaskType();
					ILabelProvider templateLP = new FreemarkerLabelProvider(labelProvider);
					if (SmooksModelUtils.FREEMARKER_TEMPLATE_TYPE_XML.equals(messageType)) {
						templateLP = new FreemarkerTemplateModelLabelProvider();
					}
					if (taskType.inTheTask((Freemarker)model)) {
						graphModel = new FreemarkerTemplateGraphicalModel(model, new FreemarkerContentProvider(
								contentProvider), templateLP, provider);
						((TreeContainerModel) graphModel).setHeaderVisable(true);
					}
				}
			}
			if (model instanceof BeanType && editorPart instanceof IGraphicalEditorPart) {
				graphModel = new JavaBeanGraphModel(model, contentProvider, labelProvider, provider,
						(IGraphicalEditorPart) editorPart);
				((JavaBeanGraphModel) graphModel).setHeaderVisable(true);
			}
			if (graphModel != null) {
				return graphModel;
			}
			return super.createGraphicalModel(graphModel, provider);
		}
		return null;
	}

}
