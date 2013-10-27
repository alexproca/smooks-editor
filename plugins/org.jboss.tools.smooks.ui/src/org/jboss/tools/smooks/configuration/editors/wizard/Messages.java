package org.jboss.tools.smooks.configuration.editors.wizard;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.jboss.tools.smooks.configuration.editors.wizard.messages"; //$NON-NLS-1$
	public static String StructuredDataSelectionWizard_WizardTitle;
	public static String TransformDataWizardSelectionPage_InputTypeLabel;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
