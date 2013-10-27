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

import org.jboss.tools.smooks.configuration.editors.xml.AbstractXMLObject;
import org.jboss.tools.smooks.configuration.editors.xml.TagPropertyObject;
import org.jboss.tools.smooks.templating.model.ModelBuilder;
import org.jboss.tools.smooks.templating.template.Mapping;
import org.jboss.tools.smooks.templating.template.ValueMapping;
import org.jboss.tools.smooks.templating.template.TemplateBuilder;
import org.w3c.dom.Attr;
import org.w3c.dom.Node;

/**
 * @author Dart
 * 
 */
public class FreemarkerAttrModel extends TagPropertyObject implements IFreemarkerTemplateModel {

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.graphical.editors.model.freemarker.
	 * IFreemarkerTemplateModel#isManyOccurs()
	 */
	public boolean isManyOccurs() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.graphical.editors.model.freemarker.
	 * IFreemarkerTemplateModel#isRequired()
	 */
	public boolean isRequired() {
		Attr element = this.getReferenceAttibute();
		if (element != null) {
			return ModelBuilder.isRequired(element);
		}
		return false;
	}

	public boolean isHidden(TemplateBuilder builder) {
		AbstractXMLObject parent = this.getParent();
		if (parent instanceof FreemarkerTemplateXMLModel) {
			if (((FreemarkerTemplateXMLModel) parent).isHidden(builder)) {
				return true;
			}
		}
		List<Mapping> mappings = builder.getMappings();
		for (Iterator<?> iterator = mappings.iterator(); iterator.hasNext();) {
			Mapping mapping = (Mapping) iterator.next();
			List<Node> hiddenNodes = mapping.getHideNodes();
			if (hiddenNodes != null) {
				for (Iterator<?> iterator2 = hiddenNodes.iterator(); iterator2.hasNext();) {
					Node node = (Node) iterator2.next();
					if (node == this.getReferenceElement()) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public Node getModelNode() {
		return getReferenceAttibute();
	}
}
