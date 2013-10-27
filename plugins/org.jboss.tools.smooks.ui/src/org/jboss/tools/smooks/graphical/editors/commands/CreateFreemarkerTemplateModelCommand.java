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
package org.jboss.tools.smooks.graphical.editors.commands;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.IEditorPart;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.gef.tree.command.GEFAdapterCommand;

/**
 * @author Dart
 *
 */
public class CreateFreemarkerTemplateModelCommand extends GEFAdapterCommand {
	
	private IEditorPart editorPart = null;
	
	private ISmooksModelProvider provider = null;
	
	public CreateFreemarkerTemplateModelCommand(EditingDomain domain, Command emfCommand , IEditorPart editorPart,ISmooksModelProvider provider) {
		super(domain, emfCommand);
		this.editorPart = editorPart;
		this.provider = provider;
	}

	boolean firstTime = true;

	@Override
	public void execute() {
		super.execute();
	}

}
