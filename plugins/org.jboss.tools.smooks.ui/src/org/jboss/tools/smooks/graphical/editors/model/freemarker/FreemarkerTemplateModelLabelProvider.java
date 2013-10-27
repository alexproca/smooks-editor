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

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.jboss.tools.smooks.configuration.SmooksConfigurationActivator;
import org.jboss.tools.smooks.configuration.editors.GraphicsConstants;
import org.jboss.tools.smooks.configuration.editors.xml.XMLStructuredDataLabelProvider;
import org.jboss.tools.smooks.templating.model.ModelBuilder;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author Dart
 * 
 */
public class FreemarkerTemplateModelLabelProvider extends XMLStructuredDataLabelProvider {

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.xml.
	 * XMLStructuredDataLabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {
		ImageRegistry imageRegistry = SmooksConfigurationActivator.getDefault().getImageRegistry();
		if (element instanceof FreemarkerTemplateXMLModel) {
			Element e = ((FreemarkerTemplateXMLModel) element).getReferenceElement();
			if (FreemarkerModelAnalyzer.isChoiceElement(e)) {
				return imageRegistry.get(GraphicsConstants.IMAGE_XSL_SORT);
			}
			Node modelNode = ((FreemarkerTemplateXMLModel) element).getModelNode();
			if (((FreemarkerTemplateXMLModel) element).isManyOccurs()) {
				if(modelNode instanceof Element && ModelBuilder.getEnforceCollectionSubMappingRules((Element) modelNode)) {
					return imageRegistry.get(GraphicsConstants.IMAGE_XSL_FOREACH);
				}
			}
		}
		return super.getImage(element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.xml.
	 * XMLStructuredDataLabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		return super.getText(element);
	}

}
