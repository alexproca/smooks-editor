package org.jboss.tools.smooks.configuration.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * 
 * @author Dart Peng (dpeng@redhat.com) Date Apr 1, 2009
 */
public class SmooksFileContainerSelectionPage extends WizardNewFileCreationPage {

	public SmooksFileContainerSelectionPage(String pageName, IStructuredSelection selection) {
		super(pageName, selection);
		setTitle(Messages.SmooksFileContainerSelectionPage_Page_Title);
		setDescription(Messages.SmooksFileContainerSelectionPage_Page_Description);
		setFileExtension("xml"); //$NON-NLS-1$
		setFileName("smooks-config.xml"); //$NON-NLS-1$
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		validatePage();
	}
}