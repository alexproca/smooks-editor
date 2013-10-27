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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;
import org.jboss.tools.smooks.model.javabean12.Javabean12Package;
import org.jboss.tools.smooks.model.javabean12.ValueType;

/**
 * @author Dart
 * 
 */
public class JavaMappingPathSection extends AbstractSmooksPropertySection {

	private Composite controlComposite;
	private Text pathText;
	private Text namespaceText;
	private Text defaultValueText;

	protected boolean lock = false;
	private Label defaultValueLabel;

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
		section.setText(Messages.JavaMappingPathSection_MappingPath);

		controlComposite = factory.createComposite(section, SWT.NONE);

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.horizontalSpacing = 13;
		gridLayout.verticalSpacing = 20;

		controlComposite.setLayout(gridLayout);

		section.setClient(controlComposite);

		createTextContorls(factory);

		hookTextContorls();

	}

	protected void createTextContorls(TabbedPropertySheetWidgetFactory factory) {
		Label pathLabel = factory.createLabel(controlComposite, Messages.JavaMappingPathSection_PathLabel);
		pathLabel.setForeground(factory.getColors().getColor(IFormColors.TITLE));
		pathText = factory.createText(controlComposite, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		pathText.setLayoutData(gd);

		Label namespaceLabel = factory.createLabel(controlComposite, Messages.JavaMappingPathSection_NamespaceLabel);
		namespaceLabel.setForeground(factory.getColors().getColor(IFormColors.TITLE));
		namespaceText = factory.createText(controlComposite, ""); //$NON-NLS-1$
		namespaceText.setLayoutData(gd);

		defaultValueLabel = factory.createLabel(controlComposite, Messages.JavaMappingPathSection_DefaultLabel);
		defaultValueLabel.setForeground(factory.getColors().getColor(IFormColors.TITLE));
		defaultValueText = factory.createText(controlComposite, ""); //$NON-NLS-1$
		defaultValueText.setLayoutData(gd);
	}

	protected void hookTextContorls() {

		namespaceText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (lock)
					return;
				Object obj = getTargetModel();
				EditingDomain domain = getSmooksModelProvider().getEditingDomain();
				if (obj instanceof EObject && domain != null) {
					EObject model = (EObject) obj;
					EStructuralFeature feature = SmooksUIUtils.getSelectorNamespaceFeature(model);
					if (feature != null) {
						Object v = model.eGet(feature);
						String newV = ((Text) e.getSource()).getText().trim();
						if (v != null) {
							String oldV = v.toString().trim();
							if (oldV.equals(newV))
								return;
						}
						Command setCommand = SetCommand.create(domain, model, feature, newV);
						domain.getCommandStack().execute(setCommand);
					}
				}
			}
		});

		defaultValueText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (lock)
					return;
				Object obj = getTargetModel();
				EditingDomain domain = getSmooksModelProvider().getEditingDomain();
				if (obj instanceof ValueType && domain != null) {
					ValueType model = (ValueType) obj;
					Object v = model.getDefault();
					String newV = ((Text) e.getSource()).getText().trim();
					if (v != null) {
						String oldV = v.toString().trim();
						if (oldV.equals(newV))
							return;
					}
					Command setCommand = SetCommand.create(domain, model, Javabean12Package.Literals.VALUE_TYPE__DEFAULT, newV);
					domain.getCommandStack().execute(setCommand);
				}
			}
		});
	}

	protected void refreshTextControls() {
		lock = true;
		pathText.setText(""); //$NON-NLS-1$
		namespaceText.setText(""); //$NON-NLS-1$
		defaultValueText.setText(""); //$NON-NLS-1$
		
		defaultValueLabel.setVisible(false);
		defaultValueText.setVisible(false);
		Object obj = getTargetModel();
		if (obj instanceof EObject) {
			EObject model = (EObject) obj;
			EStructuralFeature feature = SmooksUIUtils.getSelectorFeature(model);
			if (feature != null) {
				Object v = model.eGet(feature);
				if (v != null) {
					pathText.setText(v.toString().trim());
				}
			}
			feature = SmooksUIUtils.getSelectorNamespaceFeature(model);
			if (feature != null) {
				Object v = model.eGet(feature);
				if (v != null) {
					namespaceText.setText(v.toString().trim());
				}
			}
			if (model instanceof ValueType) {
				defaultValueLabel.setVisible(true);
				defaultValueText.setVisible(true);
				Object v = ((ValueType) model).getDefault();// .eGet(feature);
				if (v != null) {
					defaultValueText.setText(v.toString().trim());
				}
			}
		}
		lock = false;

	}

	protected Object getTargetModel() {
		TreeNodeConnection lineModel = (TreeNodeConnection) getPresentSelectedGraphModel();
		Object model = lineModel.getTargetNode().getData();
		model = AdapterFactoryEditingDomain.unwrap(model);
		return model;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.editor.propertySections.AbstractSmooksPropertySection
	 * #refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
		refreshTextControls();
	}
}
