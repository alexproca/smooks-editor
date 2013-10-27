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
package org.jboss.tools.smooks.edimap.editparts;

import org.jboss.tools.smooks.edimap.editor.EDITreeNodeEditPart;

/**
 * @author Dart (dpeng@redhat.com)
 *
 */
public class EDIDataEditPart extends EDITreeNodeEditPart{

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.edimap.editor.EDITreeNodeEditPart#canDirectEdit()
	 */
	@Override
	protected boolean canDirectEdit() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.edimap.editor.EDITreeNodeEditPart#isDragLink()
	 */
	@Override
	protected boolean isDragLink() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.edimap.editor.EDITreeNodeEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
	}
	
}
