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

import org.jboss.tools.smooks.templating.template.TemplateBuilder;
import org.w3c.dom.Node;

/**
 * @author Dart
 *
 */
public interface IFreemarkerTemplateModel {
	public boolean isRequired();
	public boolean isManyOccurs();
	public Node getModelNode();
	public boolean isHidden(TemplateBuilder builder);
}
