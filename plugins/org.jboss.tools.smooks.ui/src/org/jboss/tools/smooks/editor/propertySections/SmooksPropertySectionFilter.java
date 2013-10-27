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

import org.eclipse.jface.viewers.IFilter;
import org.eclipse.ui.IEditorPart;
import org.jboss.tools.smooks.graphical.editors.IGraphicalEditorPart;
import org.jboss.tools.smooks.graphical.editors.editparts.AbstractResourceConfigChildNodeEditPart;
import org.jboss.tools.smooks.graphical.editors.editparts.AbstractResourceConfigEditPart;
import org.jboss.tools.smooks.graphical.editors.editparts.javamapping.JavaBeanChildNodeEditPart;
import org.jboss.tools.smooks.graphical.editors.editparts.javamapping.JavaBeanEditPart;
import org.jboss.tools.smooks.graphical.editors.template.SmooksFreemarkerTemplateGraphicalEditor;

/**
 * @author Dart
 *
 */
public class SmooksPropertySectionFilter implements IFilter{

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IFilter#select(java.lang.Object)
	 */
	public boolean select(Object toTest) {
		if(toTest == null) return false;
		if(toTest instanceof AbstractResourceConfigEditPart){
			IEditorPart editorPart = ((AbstractResourceConfigEditPart)toTest).getEditorPart();
			if(toTest instanceof JavaBeanEditPart && editorPart instanceof IGraphicalEditorPart){
				if(SmooksFreemarkerTemplateGraphicalEditor.ID.equals(((IGraphicalEditorPart)editorPart).getID())){
					return false;
				}
			}
			return true;
		}
		if(toTest instanceof AbstractResourceConfigChildNodeEditPart){
			IEditorPart editorPart = ((AbstractResourceConfigChildNodeEditPart)toTest).getEditorPart();
			if(toTest instanceof JavaBeanChildNodeEditPart && editorPart instanceof IGraphicalEditorPart){
				if(SmooksFreemarkerTemplateGraphicalEditor.ID.equals(((IGraphicalEditorPart)editorPart).getID())){
					return false;
				}
			}
			return true;
		}
		return false;
	}

}
