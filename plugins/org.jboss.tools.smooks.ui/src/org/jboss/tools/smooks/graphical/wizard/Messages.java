package org.jboss.tools.smooks.graphical.wizard;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.jboss.tools.smooks.graphical.wizard.messages"; //$NON-NLS-1$
	public static String TemplateMessageTypeWizard_Page_Name;
	public static String TemplateWizardSelectionPage_CSV_Node;
	public static String TemplateWizardSelectionPage_XML_Node;
	public static String TemplateWizardSelectionPage_Message_Type_Label;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
