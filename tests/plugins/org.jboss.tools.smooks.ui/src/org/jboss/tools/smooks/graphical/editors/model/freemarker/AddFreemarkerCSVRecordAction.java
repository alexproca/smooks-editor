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
package org.jboss.tools.smooks.graphical.editors.model.freemarker;

import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;
import org.jboss.tools.smooks.graphical.actions.AddSmooksModelAction;

/**
 * @author Dart
 *
 */
public class AddFreemarkerCSVRecordAction extends AddSmooksModelAction {

	public AddFreemarkerCSVRecordAction(IWorkbenchPart part, int style) {
		super(part, style);
		// TODO Auto-generated constructor stub
	}

	public AddFreemarkerCSVRecordAction(IWorkbenchPart part) {
		super(part);
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.graphical.actions.AddSmooksModelAction#getActionImageDescriptor()
	 */
	@Override
	public ImageDescriptor getActionImageDescriptor() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.graphical.actions.AddSmooksModelAction#getActionText()
	 */
	@Override
	public String getActionText() {
		return Messages.AddFreemarkerCSVRecordAction_Action_Text;
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.graphical.actions.AddSmooksModelAction#getCreationFactory()
	 */
	@Override
	protected CreationFactory getCreationFactory() {
		return  FreemarkerCreationFactory.newCSVRecordFactory();
	}
}
