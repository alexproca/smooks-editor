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

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.ui.IEditorPart;
import org.jboss.tools.smooks.gef.tree.editparts.TreeNodeConnectionEditPart;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;
import org.jboss.tools.smooks.graphical.editors.IGraphicalEditorPart;
import org.jboss.tools.smooks.graphical.editors.editparts.javamapping.JavaBeanChildNodeEditPart;
import org.jboss.tools.smooks.graphical.editors.template.SmooksFreemarkerTemplateGraphicalEditor;
import org.jboss.tools.smooks.model.javabean12.ValueType;

/**
 * @author Dart
 * 
 */
public class ValueDecodeParamSectionFilter implements IFilter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IFilter#select(java.lang.Object)
	 */
	public boolean select(Object toTest) {
		if (toTest == null)
			return false;
		if (toTest instanceof TreeNodeConnectionEditPart) {
			GraphicalViewer viewer = (GraphicalViewer) ((TreeNodeConnectionEditPart) toTest).getViewer();
			((DefaultEditDomain) viewer.getEditDomain()).getEditorPart();
			IEditorPart editorPart = ((DefaultEditDomain) viewer.getEditDomain()).getEditorPart();
			if (toTest instanceof JavaBeanChildNodeEditPart && editorPart instanceof IGraphicalEditorPart) {
				if (SmooksFreemarkerTemplateGraphicalEditor.ID.equals(((IGraphicalEditorPart) editorPart).getID())) {
					return false;
				}
			}
			TreeNodeConnection connection = (TreeNodeConnection) ((TreeNodeConnectionEditPart) toTest).getModel();
			Object data = connection.getTargetNode().getData();
			data = AdapterFactoryEditingDomain.unwrap(data);
			if (data instanceof ValueType) {
				return true;
			}
		}
		return false;
	}

}
