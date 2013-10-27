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
package org.jboss.tools.smooks.graphical.editors.editparts.freemarker;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.jboss.tools.smooks.graphical.editors.editparts.AbstractResourceConfigEditPart;

/**
 * @author Dart
 * 
 */
public class FreemarkerTemplateEditPart extends AbstractResourceConfigEditPart {

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.graphical.editors.editparts.
	 * AbstractResourceConfigEditPart
	 * #getHostFeature(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected EStructuralFeature getHostFeature(EObject model) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.graphical.editors.editparts.
	 * AbstractResourceConfigEditPart#isSource()
	 */
	@Override
	protected boolean isSource() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.graphical.editors.editparts.
	 * AbstractResourceConfigEditPart#getCreateCommand(org.eclipse.gef.EditPart,
	 * org.eclipse.gef.requests.CreateRequest)
	 */
	@Override
	protected Command getCreateCommand(EditPart host, CreateRequest request) {
		// Object type = request.getNewObjectType();
		// Object model = request.getNewObject();
		// if (FreemarkerCreationFactory.CSV_RECORD.equals(type)) {
		// Object parent = host.getModel();
		// ILabelProvider provider = ((AbstractResourceConfigGraphModel)
		// parent).getLabelProvider();
		// ITreeContentProvider provider1 = ((AbstractResourceConfigGraphModel)
		// parent).getContentProvider();
		// IEditingDomainProvider provider2 =
		// ((AbstractResourceConfigGraphModel) parent).getDomainProvider();
		// AbstractSmooksGraphicalModel childModel = new
		// FreemarkerCSVNodeGraphicalModel(model, provider1, provider,
		// provider2);
		// if (model != null && childModel instanceof
		// AbstractSmooksGraphicalModel
		// && parent instanceof AbstractSmooksGraphicalModel) {
		// return new
		// AddSmooksGraphicalModelCommand((AbstractSmooksGraphicalModel) parent,
		// (AbstractSmooksGraphicalModel) childModel);
		// }
		// }
		return null;
	}
}
