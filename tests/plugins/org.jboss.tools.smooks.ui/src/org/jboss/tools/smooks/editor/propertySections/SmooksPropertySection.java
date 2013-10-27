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
package org.jboss.tools.smooks.editor.propertySections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.jboss.tools.smooks.configuration.editors.ModelPanelCreator;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;

/**
 * @author Dart
 * 
 */
public class SmooksPropertySection extends AbstractSmooksPropertySection {

	private Composite controlComposite;
	
	private Object model;
	
	/* 
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#createControls
	 * (org.eclipse.swt.widgets.Composite,
	 * org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		TabbedPropertySheetWidgetFactory factory = aTabbedPropertySheetPage.getWidgetFactory();

		Section section = createRootSection(factory, parent);
		section.setText(Messages.SmooksPropertySection_Section_Title);
		controlComposite = factory.createComposite(section);
		section.setClient(controlComposite);
		GridLayout gl = new GridLayout();
		gl.numColumns = 2;

		controlComposite.setLayout(gl);

	}

	protected void createPropertiesGUIContents(Object model, ISmooksModelProvider provider, IEditorPart part,
			FormToolkit factory, Composite controlComposite) {
		ModelPanelCreator creator = new ModelPanelCreator();
		model = AdapterFactoryEditingDomain.unwrap(model);
		if (model != null && model instanceof EObject && provider != null && part != null) {
			AdapterFactoryEditingDomain domain = (AdapterFactoryEditingDomain) provider.getEditingDomain();
			IItemPropertySource itemPropertySource = (IItemPropertySource) domain.getAdapterFactory().adapt(model,
					IItemPropertySource.class);
			if (itemPropertySource != null) {
				creator
						.createModelPanel((EObject) model, factory, controlComposite, itemPropertySource, provider,
								part);
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.editor.propertySections.AbstractSmooksPropertySection#refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
		Object model = getPresentSelectedModel();
		if(this.model == model && controlComposite.getChildren().length > 0) {
			return;
		}
		diposeControlComposite();
		ISmooksModelProvider provider = getSmooksModelProvider();
		IEditorPart part = getEditorPart();
		createPropertiesGUIContents(model, provider, part, getWidgetFactory(), controlComposite);
		if(controlComposite != null){
			controlComposite.getParent().layout();
		}
		this.model = model;
	}
	
	protected void diposeControlComposite(){
		if(controlComposite != null){
			Control[] children = controlComposite.getChildren();
			for (int i = 0; i < children.length; i++) {
				Control c = children[i];
				c.dispose();
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#aboutToBeHidden()
	 */
	@Override
	public void aboutToBeHidden() {
		super.aboutToBeHidden();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#aboutToBeShown()
	 */
	@Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
	}
	
	

}
