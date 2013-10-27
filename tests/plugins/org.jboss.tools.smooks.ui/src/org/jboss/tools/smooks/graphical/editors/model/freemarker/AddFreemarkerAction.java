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

import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.ui.IWorkbenchPart;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.graphical.actions.AddSmooksObjectAction;
import org.jboss.tools.smooks.model.freemarker.FreemarkerFactory;
import org.jboss.tools.smooks.model.freemarker.FreemarkerPackage;
import org.jboss.tools.smooks.model.smooks.SmooksPackage;

/**
 * @author Dart
 * 
 */
public class AddFreemarkerAction extends AddSmooksObjectAction {

	public AddFreemarkerAction(IWorkbenchPart part, int style, ISmooksModelProvider provider) {
		super(part, style, provider);
		// TODO Auto-generated constructor stub
	}

	public AddFreemarkerAction(IWorkbenchPart part, ISmooksModelProvider provider) {
		super(part, provider);
		// TODO Auto-generated constructor stub
	}

	protected Object getSmooks11Object() {
		return FeatureMapUtil.createEntry(FreemarkerPackage.Literals.DOCUMENT_ROOT__FREEMARKER,
				FreemarkerFactory.eINSTANCE.createFreemarker());
	}

	protected Object getSmooks11Type() {
		return SmooksPackage.Literals.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_RESOURCE_CONFIG_GROUP;
	}

	@Override
	protected Object getSmooks12Object() {
		return getSmooks11Object();
	}

	@Override
	protected Object getSmooks12Type() {
		return getSmooks11Type();
	}

}
