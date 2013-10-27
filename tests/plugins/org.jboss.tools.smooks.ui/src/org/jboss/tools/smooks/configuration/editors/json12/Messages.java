package org.jboss.tools.smooks.configuration.editors.json12;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.jboss.tools.smooks.configuration.editors.json12.messages"; //$NON-NLS-1$
	public static String Json12DataPathWizardPage_WizardDes;
	public static String Json12DataPathWizardPage_WizardTitle;
	public static String Json12DataWizard_WizardDes;
	public static String Json12DataWizard_WizardTitle;
	public static String Json12ReaderUICreator_KeyMapsLabel;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
