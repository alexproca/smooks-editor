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

import java.util.List;

import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.ui.IEditorPart;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.gef.tree.command.GEFAdapterCommand;
import org.jboss.tools.smooks.model.freemarker.Freemarker;
import org.jboss.tools.smooks.model.javabean12.BeanType;

/**
 * @author Dart
 * 
 */
public class DefaultSmooksCommandProvider implements ISmooksCommandProvider {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.graphical.editors.commands.ISmooksCommandProvider
	 * #createSmooksCommand()
	 */
	public Command createSmooksCommand(EditingDomain domain, org.eclipse.emf.common.command.Command emfCommand,
			final ISmooksModelProvider provider, Object collections, Object owner, Object feature,
			IEditorPart editorPart) {
		Object model = collections;

		Command command = null;

		if (collections instanceof FeatureMap.Entry) {
			model = ((FeatureMap.Entry) collections).getValue();
		}
		if (collections instanceof List<?>) {
			if (!((List<?>) collections).isEmpty()) {
				model = ((List<?>) collections).get(0);
			}
		}

		model = AdapterFactoryEditingDomain.unwrap(model);

		if (model == null)
			return null;

		if (model instanceof BeanType ) {
			command = new CreateJavaBeanModelCommand(domain, emfCommand, editorPart, provider);
		}

		if (model instanceof Freemarker) {
			command = new CreateFreemarkerTemplateModelCommand(domain, emfCommand, editorPart, provider);
		}

		if (command == null) {
			command = new GEFAdapterCommand(domain, emfCommand);
		}

		return command;
	}

}
