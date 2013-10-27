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
package org.jboss.tools.smooks.configuration.editors.json12;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.jboss.tools.smooks.configuration.editors.AttributeFieldEditPart;
import org.jboss.tools.smooks.configuration.editors.ModelChildrenTablePanelCreator;
import org.jboss.tools.smooks.configuration.editors.PropertyUICreator;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.model.json12.Json12Factory;
import org.jboss.tools.smooks.model.json12.Json12Package;
import org.jboss.tools.smooks.model.json12.Json12Reader;

/**
 * @author Dart Peng (dpeng@redhat.com) Date Apr 10, 2009
 */
public class Json12ReaderUICreator extends PropertyUICreator {

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.IPropertyUICreator#
	 * createPropertyUI(org.eclipse.ui.forms.widgets.FormToolkit,
	 * org.eclipse.swt.widgets.Composite,
	 * org.eclipse.emf.edit.provider.IItemPropertyDescriptor, java.lang.Object,
	 * org.eclipse.emf.ecore.EAttribute)
	 */
	public AttributeFieldEditPart createPropertyUI(FormToolkit toolkit, Composite parent,
			IItemPropertyDescriptor propertyDescriptor, Object model, EAttribute feature,
			ISmooksModelProvider formEditor, IEditorPart part) {
		return super.createPropertyUI(toolkit, parent, propertyDescriptor, model, feature, formEditor, part);
	}

	@Override
	public List<AttributeFieldEditPart> createExtendUIOnBottom(AdapterFactoryEditingDomain editingdomain,
			FormToolkit toolkit, Composite parent, Object model, ISmooksModelProvider formEditor, IEditorPart editorPart) {
		if (model instanceof Json12Reader) {
			EObject keyMap = ((Json12Reader) model).getKeyMap();
			if (keyMap != null) {
				Group group = new Group(parent, SWT.NONE);
				group.setText(Messages.Json12ReaderUICreator_KeyMapsLabel);
				group.setBackground(ColorConstants.white);
				FillLayout fl = new FillLayout();
				group.setLayout(fl);

				ModelChildrenTablePanelCreator creator = new ModelChildrenTablePanelCreator(formEditor, keyMap,
						toolkit, editorPart) {

					@Override
					protected EStructuralFeature getChildrenFeature() {
						return Json12Package.Literals.KEY_MAP__KEY;
					}

					@Override
					protected EObject newChildModel() {
						return Json12Factory.eINSTANCE.createKey();
					}
				};
				creator.createChildrenTablePanel(group);
				GridData gd = new GridData(GridData.FILL_HORIZONTAL);
				gd.heightHint = 200;
				gd.horizontalSpan = 2;
				group.setLayoutData(gd);
			}
		}

		return super.createExtendUIOnBottom(editingdomain, toolkit, parent, model, formEditor, editorPart);
	}

}