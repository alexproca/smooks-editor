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
import org.jboss.tools.smooks.configuration.SmooksConfigurationActivator;
import org.jboss.tools.smooks.configuration.editors.GraphicsConstants;
import org.jboss.tools.smooks.graphical.actions.AddSmooksModelAction;

/**
 * @author Dart
 *
 */
public class AddFreemarkerCSVFieldAction extends AddSmooksModelAction {

	public AddFreemarkerCSVFieldAction(IWorkbenchPart part, int style) {
		super(part, style);
	}

	public AddFreemarkerCSVFieldAction(IWorkbenchPart part) {
		super(part);
	}

	@Override
	public ImageDescriptor getActionImageDescriptor() {
		return SmooksConfigurationActivator.getImageDescriptor(GraphicsConstants.IMAGE_JAVA_ARRAY);
	}

	@Override
	public String getActionText() {
		return Messages.AddFreemarkerCSVFieldAction_Action_Text;
	}

	@Override
	protected CreationFactory getCreationFactory() {
		return FreemarkerCreationFactory.newCSVFieldFactory();
	}
}
