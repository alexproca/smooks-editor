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

import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.ui.IEditorPart;
import org.jboss.tools.smooks.gef.tree.editparts.RootEditPart;
import org.jboss.tools.smooks.gef.tree.editpolicy.SmooksRootEditPartLayoutEditPolicy;

/**
 * @author Dart
 * 
 */
public class SmooksRootEditPart extends RootEditPart {

	public static final int BEAN_TYPE = 2;

	public static final int BINDINGS_TYPE = 1;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		this.installEditPolicy(EditPolicy.LAYOUT_ROLE, new SmooksRootEditPartLayoutEditPolicy());
	}

	protected IEditorPart getEditorPart() {
		GraphicalViewer viewer = (GraphicalViewer) this.getViewer();
		DefaultEditDomain editDomain = (DefaultEditDomain) viewer.getEditDomain();
		return editDomain.getEditorPart();
	}
}
