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
package org.jboss.tools.smooks.configuration.editors;

import java.util.Properties;

import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.jboss.tools.smooks.configuration.editors.wizard.IStructuredDataSelectionWizard;

/**
 * @author Dart Peng
 * @Date Aug 6, 2008
 */
public class StructuredDataSelectionWizardDailog extends WizardDialog {

	private String type = null;

	private String path = null;

	private Properties properties = null;

	public StructuredDataSelectionWizardDailog(Shell parentShell, IWizard newWizard) {
		super(parentShell, newWizard);
	}

	public IStructuredDataSelectionWizard getCurrentCreationWizard() {
		IWizard w = getWizard();
		if (w != null && w instanceof IStructuredDataSelectionWizard) {
			return (IStructuredDataSelectionWizard) w;
		}
		return null;
	}

	// public SmooksMultiFormEditor getFormEditor() {
	// return formEditor;
	// }
	//
	// public void setFormEditor(SmooksMultiFormEditor formEditor) {
	// this.formEditor = formEditor;
	// }

	public int show() {
		int openResult = this.open();
		if (openResult == WizardDialog.OK) {
			IStructuredDataSelectionWizard wizard1 = this.getCurrentCreationWizard();
			type = wizard1.getInputDataTypeID();
			path = wizard1.getStructuredDataSourcePath();
			properties = wizard1.getProperties();
		}
		return openResult;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
}
