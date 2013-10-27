package org.jboss.tools.smooks.configuration.editors.xml;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.jboss.tools.smooks.configuration.editors.xml.messages"; //$NON-NLS-1$
	public static String AbstractFileSelectionWizardPage_WizardTitle;
	public static String XMLStructuredDataWizard_Window_Title;
	public static String XSDStructuredDataWizard_WizardTitle;
	public static String XMLTemplateCreationWizardPage_Button_Load;
	public static String XMLTemplateCreationWizardPage_Error_Must_Click_Load;
	public static String XMLTemplateCreationWizardPage_Error_Must_Select_Root;
	public static String XMLTemplateCreationWizardPage_FileLabel;
	public static String XMLTemplateCreationWizardPage_Label_Select_Root;
	public static String XMLTemplateCreationWizardPage_page_description;
	public static String XMLTemplateCreationWizardPage_Page_Title;
	public static String XMLTemplateCreationWizardPage_XMLSampleType;
	public static String XMLTemplateCreationWizardPage_XMLTemplateLoadError;
	public static String XMLTemplateCreationWizardPage_XSDParsingError1;
	public static String XMLTemplateCreationWizardPage_XSDType;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
