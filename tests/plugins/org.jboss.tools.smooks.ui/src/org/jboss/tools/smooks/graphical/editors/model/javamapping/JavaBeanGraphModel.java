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
package org.jboss.tools.smooks.graphical.editors.model.javamapping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;
import org.jboss.tools.smooks.graphical.editors.IGraphicalEditorPart;
import org.jboss.tools.smooks.graphical.editors.model.AbstractResourceConfigGraphModel;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerTemplateXMLModel;
import org.jboss.tools.smooks.graphical.editors.template.SmooksFreemarkerTemplateGraphicalEditor;
import org.jboss.tools.smooks.model.javabean12.BeanType;

/**
 * @author Dart
 * 
 */
public class JavaBeanGraphModel extends AbstractResourceConfigGraphModel {

	private IGraphicalEditorPart editorPart;

	public JavaBeanGraphModel(Object data, ITreeContentProvider contentProvider, ILabelProvider labelProvider,
			IEditingDomainProvider domainProvider, IGraphicalEditorPart editorPart) {
		super(data, contentProvider, labelProvider, domainProvider);
		this.editorPart = editorPart;
	}

	@Override
	protected TreeNodeModel createChildModel(Object model, ITreeContentProvider contentProvider,
			ILabelProvider labelProvider) {
		Object m = AdapterFactoryEditingDomain.unwrap(model);
		if (m instanceof String)
			return null;
		return new JavaBeanChildGraphModel(model, contentProvider, labelProvider, this.domainProvider, this.editorPart);
	}

	protected boolean inJavaMapping() {
		if (SmooksFreemarkerTemplateGraphicalEditor.ID.equals(editorPart.getID())) {
			return false;
		}
		return true;
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
		if (!inJavaMapping())
			return false;
		return super.canLinkWithSource(model);

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
		AbstractSmooksGraphicalModel gm = (AbstractSmooksGraphicalModel) model;
		Object m = gm.getData();
		if (data instanceof BeanType) {
			if (m instanceof FreemarkerTemplateXMLModel) {
				if (data instanceof EObject) {
					if (SmooksUIUtils.isCollectionJavaGraphModel((EObject) data)) {
						boolean flag = ((FreemarkerTemplateXMLModel) m).isManyOccurs()
								&& gm.getTargetConnections().isEmpty();
						Object p = SmooksFreemarkerTemplateGraphicalEditor.parentIsRequriedCollectionNode(gm);
						if(p != null) {
							return false;
						}else{
							return flag;
						}
					}
				}
			}
		}
		if (!inJavaMapping())
			return false;
		return super.canLinkWithTarget(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.model.TreeContainerModel#canDragLink()
	 */
	@Override
	public boolean canDragLink() {
		if (SmooksFreemarkerTemplateGraphicalEditor.ID.equals(editorPart.getID())) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel#isLinkable
	 * (java.lang.Class)
	 */
	@Override
	public boolean isLinkable(Class<?> connectionType) {
		return canDragLink();
	}
}
