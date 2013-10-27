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
package org.jboss.tools.smooks.graphical.wizards;

import org.eclipse.jface.wizard.Wizard;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;

/**
 * @author Dart
 *
 */
public abstract class SmooksCreationModelConfigureWizard extends Wizard {
	
	protected Object model;
	
	protected ISmooksModelProvider modelProvider;

	public SmooksCreationModelConfigureWizard(ISmooksModelProvider modelProvider , Object model){
		super();
		this.model = model;
		this.modelProvider = modelProvider;
	}

}
