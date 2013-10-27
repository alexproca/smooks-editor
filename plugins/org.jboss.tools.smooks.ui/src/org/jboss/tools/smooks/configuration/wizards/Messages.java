package org.jboss.tools.smooks.configuration.wizards;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.jboss.tools.smooks.configuration.wizards.messages"; //$NON-NLS-1$
	public static String NewSmooksElementWizard_Smooks_Elements;
	public static String NewSmooksElementWizardPage_Page_Description;
	public static String NewSmooksElementWizardPage_Page_Title;
	public static String SmooksConfigurationFileNewWizard_0;
	public static String SmooksConfigurationFileNewWizard_ErrorDialogTitle;
	public static String SmooksConfigurationFileNewWizard_PageName;
/*	public static String SmooksConfigurationFileNewWizard_VersionPageName; */
	public static String SmooksFileContainerSelectionPage_Page_Description;
	public static String SmooksFileContainerSelectionPage_Page_Title;
	public static String SmooksVersionSelectionPage_Label_Smooks_Version;
	public static String SmooksVersionSelectionPage_Page_Description;
	public static String SmooksVersionSelectionPage_Page_Title;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
