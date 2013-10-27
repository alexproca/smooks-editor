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
package org.jboss.tools.smooks.edimap.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * @author Dart (dpeng@redhat.com)
 *
 */
public class EDIMappingConfigFileContainerSelectionPage extends WizardNewFileCreationPage {

	public EDIMappingConfigFileContainerSelectionPage(String pageName, IStructuredSelection selection) {
		super(pageName, selection);
		setTitle(Messages.EDIMappingConfigFileContainerSelectionPage_page_title);
		setDescription(Messages.EDIMappingConfigFileContainerSelectionPage_page_description);
		setFileExtension("xml"); //$NON-NLS-1$
		setFileName("edi-to-xml-mapping.xml"); //$NON-NLS-1$
	}
	
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		validatePage();
	}
}
