/*******************************************************************************
 * Copyright (c) 2009 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.smooks.configuration.editors;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;

/**
 * @author Dart (dpeng@redhat.com)
 *         <p>
 *         Apr 7, 2009
 */
public interface IPropertyUICreator {
	public AttributeFieldEditPart createPropertyUI(FormToolkit toolkit, Composite parent,
			IItemPropertyDescriptor propertyDescriptor, Object model, EAttribute feature,
			ISmooksModelProvider formEditor,IEditorPart editorPart);

	public List<AttributeFieldEditPart> createExtendUIOnBottom(AdapterFactoryEditingDomain editingdomain, FormToolkit toolkit,
			Composite parent, Object model, ISmooksModelProvider formEditor,IEditorPart editorPart);
	
	public boolean ignoreProperty(EAttribute feature);

	public List<AttributeFieldEditPart> createExtendUIOnTop(AdapterFactoryEditingDomain editingDomain,
			FormToolkit formToolkit, Composite detailsComposite, Object model, ISmooksModelProvider formEditor,IEditorPart editorPart);
}
