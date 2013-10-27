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
package org.jboss.tools.smooks.graphical.editors.editparts.javamapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.IEditorPart;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.graphical.editors.IGraphicalEditorPart;
import org.jboss.tools.smooks.graphical.editors.editparts.AbstractResourceConfigEditPart;
import org.jboss.tools.smooks.graphical.editors.template.SmooksFreemarkerTemplateGraphicalEditor;
import org.jboss.tools.smooks.model.javabean12.BeanType;
import org.jboss.tools.smooks.model.javabean12.Javabean12Package;
import org.jboss.tools.smooks.model.javabean12.WiringType;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;

/**
 * @author Dart
 * 
 */
public class JavaBeanEditPart extends AbstractResourceConfigEditPart {
	private List<Object> supportTypes = new ArrayList<Object>();

	public JavaBeanEditPart() {
		super();
		supportTypes.add(BeanType.class);
	}

	@Override
	protected EStructuralFeature getHostFeature(EObject model) {
		IEditorPart editorPart = this.getEditorPart();
		if (editorPart instanceof IGraphicalEditorPart) {
			if (SmooksFreemarkerTemplateGraphicalEditor.ID.equals(((IGraphicalEditorPart) editorPart).getID())) {
				return null;
			}
		}
		
		if (model instanceof BeanType) {
			return Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__BEAN;
		}
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.graphical.editors.editparts.
	 * AbstractResourceConfigEditPart
	 * #getDeleteCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 * java.lang.Object, org.eclipse.emf.ecore.EStructuralFeature)
	 */
	@Override
	protected Command getDeleteEMFCommand(EditingDomain domain, Object data, EStructuralFeature feature) {
		CompoundCommand compoundCommand = new CompoundCommand();
		Command deleteCommand = super.getDeleteEMFCommand(domain, data, feature);
		if (data instanceof BeanType) {
			String beanId = ((BeanType) data).getBeanId();
			Object container = ((BeanType) data).eContainer();
			if (beanId != null && container != null && container instanceof SmooksResourceListType) {
				List<?> children = ((SmooksResourceListType) container).getAbstractResourceConfig();
				for (Iterator<?> iterator = children.iterator(); iterator.hasNext();) {
					Object child = (Object) iterator.next();
					child = AdapterFactoryEditingDomain.unwrap(child);
					if (child instanceof BeanType && child != data) {
						List<?> wirings = ((BeanType) child).getWiring();
						for (Iterator<?> iterator2 = wirings.iterator(); iterator2.hasNext();) {
							WiringType wiring = (WiringType) iterator2.next();
							String refId = wiring.getBeanIdRef();
							if (refId != null)
								refId = refId.trim();
							if (beanId.equals(refId)) {
								Command setCommand = SetCommand.create(domain, wiring,
										Javabean12Package.Literals.WIRING_TYPE__BEAN_ID_REF, null);
								compoundCommand.append(setCommand);
							}
						}
					}
				}
			}
		}
		
		if(compoundCommand.isEmpty()){
			return deleteCommand;
		}else{
			compoundCommand.append(deleteCommand);
			return compoundCommand;
		}
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.editparts.TreeContainerEditPart#createFigure
	 * ()
	 */
	@Override
	protected IFigure createFigure() {
		return super.createFigure();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.graphical.editors.editparts.
	 * AbstractResourceConfigEditPart#isSource()
	 */
	@Override
	protected boolean isSource() {
		IEditorPart part = this.getEditorPart();
		if (part instanceof IGraphicalEditorPart) {
			if (SmooksFreemarkerTemplateGraphicalEditor.ID.equals(((IGraphicalEditorPart) part).getID())) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.graphical.editors.editparts.
	 * AbstractResourceConfigEditPart
	 * #createModelCreationEMFCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 * java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	protected Command createModelCreationEMFCommand(EditingDomain domain, Object owner, Object type, Object collections) {
		Object model = ((AbstractSmooksGraphicalModel) getModel()).getData();
		model = AdapterFactoryEditingDomain.unwrap(model);
		if (model instanceof EObject) {
			boolean isArray = SmooksUIUtils.isArrayJavaGraphModel((EObject) model);
			boolean isCollection = SmooksUIUtils.isCollectionJavaGraphModel((EObject) model);
			if (isArray || isCollection) {
				return null;
			}
		}
		return super.createModelCreationEMFCommand(domain, owner, type, collections);
	}

}
