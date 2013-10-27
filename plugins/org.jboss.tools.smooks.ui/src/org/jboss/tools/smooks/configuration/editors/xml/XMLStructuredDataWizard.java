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
package org.jboss.tools.smooks.configuration.editors.xml;

import java.util.Properties;

import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.configuration.editors.SmooksMultiFormEditor;

/**
 * @author Dart Peng
 * @Date Aug 18, 2008
 */
public class XMLStructuredDataWizard extends AbstractStructuredDdataWizard {
	
	
	Properties properties = new Properties();
	String filePath = null;

	public static final String XML_FILE = "xmlFile"; //$NON-NLS-1$
	
	

	public XMLStructuredDataWizard() {
		super();
		setWindowTitle(Messages.XMLStructuredDataWizard_Window_Title);
	}

	@Override
	protected AbstractFileSelectionWizardPage createAbstractFileSelectionWizardPage() {
		return new XMLStructuredDataWizardPage("XML"); //$NON-NLS-1$
	}

	public boolean performFinish() {
		filePath = page.getFilePath();
//		properties.put(XML_FILE, filePath);
		return super.performFinish();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.tools.smooks.ui.IStrucutredDataCreationWizard#getInputDataTypeID()
	 */
	public String getInputDataTypeID() {
		return SmooksModelUtils.INPUT_TYPE_XML;
	}

	public Properties getProperties() {
		return properties;
	}

	public void complate(SmooksMultiFormEditor formEditor) {
		// TODO Auto-generated method stub
		
	}
}
