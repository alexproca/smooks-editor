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

import org.eclipse.gef.EditPart;
import org.jboss.tools.smooks.graphical.editors.SmooksEditFactory;
import org.jboss.tools.smooks.graphical.editors.editparts.freemarker.FreemarkerTemplateConnectionEditPart;
import org.jboss.tools.smooks.graphical.editors.editparts.freemarker.FreemarkerCSVNodeEditPart;
import org.jboss.tools.smooks.graphical.editors.editparts.freemarker.FreemarkerXMLNodeEditPart;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerTemplateConnection;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerCSVNodeGraphicalModel;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerXMLNodeGraphicalModel;

/**
 * @author Dart
 * 
 */
public class FreemarkerTemplateEditFactory extends SmooksEditFactory {
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart editPart = null;
		if (model.getClass() == FreemarkerCSVNodeGraphicalModel.class) {
			editPart = new FreemarkerCSVNodeEditPart();
		}
		if (model.getClass() == FreemarkerXMLNodeGraphicalModel.class) {
			editPart = new FreemarkerXMLNodeEditPart();
		}

		if (model instanceof FreemarkerTemplateConnection) {
			editPart = new FreemarkerTemplateConnectionEditPart();
		}

		if (editPart == null) {
			return super.createEditPart(context, model);
		} else {
			editPart.setModel(model);
		}
		return editPart;
	}
}
