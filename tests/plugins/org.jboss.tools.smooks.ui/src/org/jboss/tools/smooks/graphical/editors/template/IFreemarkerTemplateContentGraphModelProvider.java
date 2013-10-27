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
import java.util.List;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerTemplateGraphicalModel;
import org.jboss.tools.smooks.templating.model.ModelBuilderException;
import org.jboss.tools.smooks.templating.template.TemplateBuilder;
import org.jboss.tools.smooks.templating.template.exception.TemplateBuilderException;

/**
 * @author Dart
 * 
 */
public interface IFreemarkerTemplateContentGraphModelProvider {

	public List<AbstractSmooksGraphicalModel> getFreemarkerTemplateContentGraphModel(
			FreemarkerTemplateGraphicalModel freemarkerGraphModel, ITreeContentProvider contentProvider,
			ILabelProvider labelProvider, ISmooksModelProvider domainProvider);

	public AbstractSmooksGraphicalModel createFreemarkerTemplateGraphModel(String type, Object data,
			ITreeContentProvider contentProvider, ILabelProvider labelProvider, ISmooksModelProvider domainProvider);

	public TemplateBuilder getTemplateBuilder(FreemarkerTemplateGraphicalModel freemarkerGraphModel)
			throws InvocationTargetException, IOException, ModelBuilderException , TemplateBuilderException;

}
