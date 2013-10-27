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
package org.jboss.tools.smooks.graphical.editors.editparts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;

/**
 * @author Dart
 * 
 */
public class AbstractSmooksElementEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener {

	@Override
	public void activate() {
		super.activate();
		Object model = getModel();
		if (model instanceof AbstractSmooksGraphicalModel) {
			((AbstractSmooksGraphicalModel) model).addPropertyChangeListener(this);
		}
	}

	@Override
	public void deactivate() {
		Object model = getModel();
		if (model instanceof AbstractSmooksGraphicalModel) {
			((AbstractSmooksGraphicalModel) model).removePropertyChangeListener(this);
		}
		super.deactivate();
	}
	
	

	@Override
	protected List<?> getModelChildren() {
		Object model = getModel();
		if (model instanceof AbstractSmooksGraphicalModel) {
			return ((AbstractSmooksGraphicalModel)model).getChildren();
		}
		return super.getModelChildren();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {

	}

	public void propertyChange(PropertyChangeEvent evt) {
		String proName = evt.getPropertyName();
		if (AbstractSmooksGraphicalModel.PRO_FORCE_VISUAL_CHANGED.equals(proName)) {
			refreshVisuals();
		}
		if (AbstractSmooksGraphicalModel.PRO_ADD_CHILD.equals(proName)
				|| AbstractSmooksGraphicalModel.PRO_REMOVE_CHILD.equals(proName)
				|| AbstractSmooksGraphicalModel.PRO_FORCE_CHIDLREN_CHANGED.equals(proName)) {
			refreshChildren();

		}
		if (AbstractSmooksGraphicalModel.PRO_ADD_SOURCE_CONNECTION.equals(proName)
				|| AbstractSmooksGraphicalModel.PRO_REMOVE_SOURCE_CONNECTION.equals(proName)) {
			refreshSourceConnections();
		}
		if (AbstractSmooksGraphicalModel.PRO_ADD_TARGET_CONNECTION.equals(proName)
				|| AbstractSmooksGraphicalModel.PRO_REMOVE_TARGET_CONNECTION.equals(proName)) {
			refreshTargetConnections();
		}

		if (AbstractSmooksGraphicalModel.PRO_FORCE_CONNECTION_CHANGED.equals(proName)) {
			refreshSourceConnections();
			refreshTargetConnections();
		}
	}

}
