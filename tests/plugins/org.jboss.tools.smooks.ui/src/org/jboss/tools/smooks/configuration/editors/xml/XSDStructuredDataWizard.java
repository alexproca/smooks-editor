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
 * @author Dart (dpeng@redhat.com)
 *
 */
public class XSDStructuredDataWizard extends AbstractStructuredDdataWizard {
	
	
	public XSDStructuredDataWizard() {
		super();
		setWindowTitle(Messages.XSDStructuredDataWizard_WizardTitle);
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.configuration.editors.xml.AbstractStructuredDdataWizard#createAbstractFileSelectionWizardPage()
	 */
	@Override
	protected AbstractFileSelectionWizardPage createAbstractFileSelectionWizardPage() {
		// TODO Auto-generated method stub
		return new XMLTemplateCreationWizardPage("XSD"); //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.configuration.editors.wizard.IStructuredDataSelectionWizard#getInputDataTypeID()
	 */
	public String getInputDataTypeID() {
		return SmooksModelUtils.INPUT_TYPE_XSD;
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.configuration.editors.wizard.IStructuredDataSelectionWizard#getProperties()
	 */
	public Properties getProperties() {
		Properties pro = new Properties();
		pro.setProperty("rootElement", ((XMLTemplateCreationWizardPage)page).getRootElementName()); //$NON-NLS-1$
		return pro;
	}

	public void complate(SmooksMultiFormEditor formEditor) {
		// TODO Auto-generated method stub
		
	}

}
