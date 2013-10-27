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

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.ui.IEditorPart;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;

/**
 * @author Dart
 *
 */
public interface ISmooksCommandProvider {
	public Command createSmooksCommand(EditingDomain domain, org.eclipse.emf.common.command.Command emfCommand,
			final ISmooksModelProvider provider, Object collections, Object owner, Object feature,
			IEditorPart editorPart);
}
