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
package org.jboss.tools.smooks.configuration.editors.wizard;

import java.util.Properties;

import org.eclipse.jface.wizard.IWizard;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.jboss.tools.smooks.configuration.editors.SmooksMultiFormEditor;

/**
 * @author Dart Peng
 * @Date Aug 5, 2008
 */
public interface IStructuredDataSelectionWizard extends IWizard {
	
	public Object getReturnData();
	
	public void init(IEditorSite site, IEditorInput input);
	
	public String getInputDataTypeID();
	
	public Properties getProperties();
	
	public String getStructuredDataSourcePath();

	/**
	 * @deprecated
	 * @param formEditor
	 */
	public void complate(SmooksMultiFormEditor formEditor);
	
}
