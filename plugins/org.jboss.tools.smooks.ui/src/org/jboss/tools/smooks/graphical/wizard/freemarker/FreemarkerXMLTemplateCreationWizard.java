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
import org.jboss.tools.smooks.configuration.editors.xml.XMLTemplateCreationWizardPage;

/**
 * @author Dart
 * 
 */
public class FreemarkerXMLTemplateCreationWizard extends AbstractFreemarkerTemplateWizard {

	private XMLTemplateCreationWizardPage page;
	private String filePath;
	private String rootElementName;
	private String xmlInputFileType;

	public FreemarkerXMLTemplateCreationWizard() {
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
			page = new XMLTemplateCreationWizardPage("XML"); //$NON-NLS-1$
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
			filePath = page.getFilePath();
			addParamter(SmooksModelUtils.KEY_XML_FILE_PATH, filePath);
			rootElementName = page.getRootElementName();
			addParamter(SmooksModelUtils.KEY_XML_ROOT_NAME, rootElementName);
			xmlInputFileType = page.getInputType();
			addParamter(SmooksModelUtils.KEY_XML_FILE_TYPE, xmlInputFileType);
			return true;
		}
		return true;
	}

	public String getTemplateType() {
		return SmooksModelUtils.FREEMARKER_TEMPLATE_TYPE_XML;
	}
}
