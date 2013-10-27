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

import org.jboss.tools.smooks.edimap.models.EDIDataContainerModel;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;

/**
 * @author Dart (dpeng@redhat.com)
 *
 */
public class EDIDataContainerEditPart extends EDITreeContainerEditPart {

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.gef.tree.editparts.TreeContainerEditPart#getLabelText()
	 */
	@Override
	protected String getLabelText() {
		String labelText = super.getLabelText();
		TreeNodeModel obj = (TreeNodeModel) getModel();
		if(obj.getData() instanceof EDIDataContainerModel){
			if(((EDIDataContainerModel)obj.getData()).isMultipe()){
				labelText += " *"; //$NON-NLS-1$
			}
		}
		return labelText;
	}

	
}
