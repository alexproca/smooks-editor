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
package org.jboss.tools.smooks.graphical.wizard.freemarker;

import org.jboss.tools.smooks.SmooksModelUtils;

/**
 * @author Dart
 * 
 */
public class FreemarkerCSVTemplateCreationWizard extends AbstractFreemarkerTemplateWizard {

	private FreemarkerCSVCreationWizardPage page;
	private String seprator;
	private String quote;

	private String fieldsString;

	public FreemarkerCSVTemplateCreationWizard() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		if (page == null) {
			page = new FreemarkerCSVCreationWizardPage("CSV"); //$NON-NLS-1$
		}
		this.addPage(page);
		super.addPages();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		if (page != null) {
			seprator = page.getSeperatorText().getText();
			quote = page.getQuoteText().getText();
			fieldsString = page.getFieldsText().getText();
			this.addParamter(SmooksModelUtils.KEY_CSV_QUOTE, quote);
			this.addParamter(SmooksModelUtils.KEY_CSV_SEPERATOR, seprator);
			this.addParamter(SmooksModelUtils.KEY_CSV_FIELDS, fieldsString);
			this.addParamter(SmooksModelUtils.KEY_INCLUDE_FIELD_NAMES, Boolean.toString(page.getIncludeFieldNames().getSelection()));
//			List<FieldText> fieldList = page.getFieldsList();
//			for (Iterator<?> iterator = fieldList.iterator(); iterator.hasNext();) {
//				FieldText fieldText = (FieldText) iterator.next();
//				fields.add(fieldText.getText());
//			}
			return true;
		}
		return true;
	}

	public String getTemplateType() {
		return SmooksModelUtils.FREEMARKER_TEMPLATE_TYPE_CSV;
	}

}
