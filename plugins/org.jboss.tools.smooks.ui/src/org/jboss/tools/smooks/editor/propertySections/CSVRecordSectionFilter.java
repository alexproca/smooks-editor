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
package org.jboss.tools.smooks.editor.propertySections;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.viewers.IFilter;
import org.jboss.tools.smooks.graphical.editors.editparts.freemarker.FreemarkerCSVNodeEditPart;
import org.jboss.tools.smooks.graphical.editors.editparts.freemarker.FreemarkerTemplateEditPart;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.CSVNodeModel;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerCSVNodeGraphicalModel;

/**
 * @author Dart
 * 
 */
public class CSVRecordSectionFilter implements IFilter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IFilter#select(java.lang.Object)
	 */
	public boolean select(Object toTest) {
		if (toTest instanceof FreemarkerTemplateEditPart) {
			List<?> children = ((FreemarkerTemplateEditPart) toTest).getChildren();
			for (Iterator<?> iterator = children.iterator(); iterator.hasNext();) {
				Object childEditPart = (Object) iterator.next();
				try{
				if (childEditPart instanceof FreemarkerCSVNodeEditPart) {
					FreemarkerCSVNodeGraphicalModel gmodel = (FreemarkerCSVNodeGraphicalModel) ((FreemarkerCSVNodeEditPart) childEditPart)
							.getModel();
					CSVNodeModel model = (CSVNodeModel) gmodel.getData();
					if (model.isRecord()) {
						return true;
					}
				}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return false;
	}
}
