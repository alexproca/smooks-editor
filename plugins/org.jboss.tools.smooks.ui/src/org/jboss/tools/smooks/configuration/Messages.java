package org.jboss.tools.smooks.configuration;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.jboss.tools.smooks.configuration.messages"; //$NON-NLS-1$
	public static String RuntimeMetadata_Error_Input_Task_Input_File_Cannot_Be_Read;
	public static String RuntimeMetadata_Error_Input_Task_Input_File_Not_Found;
	public static String RuntimeMetadata_Error_Input_Task_No_Input_File;
	public static String RuntimeMetadata_Error_Invalid_GetErrorMessage_Call;
	public static String RuntimeMetadata_Error_SmooksFile_Does_Not_Exist;
	public static String RuntimeMetadata_Error_SmooksFile_Not_Found;
	public static String RuntimeMetadata_Error_SmooksFile_Not_Readable;
	public static String RuntimeMetadata_Error_SmooksFile_Not_Valid;
	public static String SmooksConfigurationActivator_Smooks_ErrorDialog_Title;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
