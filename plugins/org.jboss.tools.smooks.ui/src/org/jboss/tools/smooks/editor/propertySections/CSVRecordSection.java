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

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.graphical.editors.editparts.freemarker.FreemarkerCSVNodeEditPart;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerCSVNodeGraphicalModel;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerTemplateGraphicalModel;
import org.jboss.tools.smooks.model.freemarker.Freemarker;
import org.jboss.tools.smooks.model.smooks.ParamType;
import org.jboss.tools.smooks.model.smooks.SmooksFactory;

/**
 * @author Dart
 * 
 */
public class CSVRecordSection extends AbstractSmooksPropertySection {

	private Text speratorText;
	private Text quoteText;

	private boolean fireEvent = true;

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
		section.setText(Messages.CSVRecordSection_Section_Title);
		Composite mainComposite = factory.createComposite(section);
		section.setClient(mainComposite);

		GridLayout gl = new GridLayout();
		gl.numColumns = 2;
		mainComposite.setLayout(gl);

		factory.createLabel(mainComposite, Messages.CSVRecordSection_Label_Separator);
		speratorText = factory.createText(mainComposite, ""); //$NON-NLS-1$
		speratorText.setTextLimit(1);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		speratorText.setLayoutData(gd);

		factory.createLabel(mainComposite, Messages.CSVRecordSection_Label_Quote);
		quoteText = factory.createText(mainComposite, ""); //$NON-NLS-1$
		quoteText.setTextLimit(1);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		quoteText.setLayoutData(gd);
		hookTextControls();
	}

	private Freemarker getFreemarker() {
		Object graphModel = this.getPresentSelectedGraphModel();
		if (graphModel instanceof AbstractSmooksGraphicalModel) {
			AbstractSmooksGraphicalModel templateGModel = (AbstractSmooksGraphicalModel) graphModel;
			while (templateGModel != null && !(templateGModel instanceof FreemarkerTemplateGraphicalModel)) {
				templateGModel = templateGModel.getParent();
			}
			if (templateGModel != null) {
				Object freemarker = templateGModel.getData();
				freemarker = AdapterFactoryEditingDomain.unwrap(freemarker);
				if (freemarker instanceof Freemarker) {
					return ((Freemarker) freemarker);
				}
			}
		}
		return null;
	}

	private FreemarkerCSVNodeEditPart getRecordCSVEditPart() {
		GraphicalEditPart editPart = getPresentSelectedEditPart();
		List<?> children = editPart.getChildren();
		for (Iterator<?> iterator = children.iterator(); iterator.hasNext();) {
			Object childEditPart = (Object) iterator.next();
			if (childEditPart instanceof FreemarkerCSVNodeEditPart) {
				return ((FreemarkerCSVNodeEditPart) childEditPart);
			}
		}
		return null;
	}

	private void generateNewTemplateContent() {
		FreemarkerCSVNodeEditPart editPart = getRecordCSVEditPart();
		if (editPart != null) {
			Object data = editPart.getModel();
			if (data instanceof FreemarkerCSVNodeGraphicalModel) {
				((FreemarkerCSVNodeGraphicalModel) data).changeFreemarkerContents();
			}
		}
	}

	private void hookTextControls() {
		speratorText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (fireEvent) {
					Freemarker freemarker = getFreemarker();
					if (freemarker != null) {
						ParamType param = SmooksModelUtils.getParam(freemarker.getParam(),
								SmooksModelUtils.KEY_CSV_SEPERATOR);
						if (param == null){
							param = SmooksFactory.eINSTANCE.createParamType();
							param.setName(SmooksModelUtils.KEY_CSV_SEPERATOR);
							freemarker.getParam().add(param);
						}
						SmooksModelUtils.setTextToSmooksType(getSmooksModelProvider().getEditingDomain(), param,
								speratorText.getText());
						generateNewTemplateContent();
					}
				}
			}
		});

		quoteText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (fireEvent) {
					Freemarker freemarker = getFreemarker();
					if (freemarker != null) {
						ParamType param = SmooksModelUtils
								.getParam(freemarker.getParam(), SmooksModelUtils.KEY_CSV_QUOTE);
						if (param == null){
							param = SmooksFactory.eINSTANCE.createParamType();
							param.setName(SmooksModelUtils.KEY_CSV_QUOTE);
							freemarker.getParam().add(param);
						}
						SmooksModelUtils.setTextToSmooksType(getSmooksModelProvider().getEditingDomain(), param,
								quoteText.getText());
						generateNewTemplateContent();
					}
				}
			}
		});
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
		fireEvent = false;
		super.refresh();
		Freemarker freemarker = getFreemarker();
		if (freemarker != null) {
			String quote = SmooksModelUtils.getParamValue(freemarker.getParam(), SmooksModelUtils.KEY_CSV_QUOTE);
			String sperator = SmooksModelUtils.getParamValue(freemarker.getParam(), SmooksModelUtils.KEY_CSV_SEPERATOR);
			if(quote == null) quote = ""; //$NON-NLS-1$
			if(sperator == null) sperator = ""; //$NON-NLS-1$
			speratorText.setText(sperator);
			quoteText.setText(quote);
		}

		fireEvent = true;
	}

}
