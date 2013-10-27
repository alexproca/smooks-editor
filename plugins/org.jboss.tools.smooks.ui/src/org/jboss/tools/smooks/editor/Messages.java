package org.jboss.tools.smooks.editor;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.jboss.tools.smooks.editor.messages"; //$NON-NLS-1$
	public static String AbstractSmooksFormEditor_Error_Unknown;
	public static String AbstractSmooksFormEditor_Error_Unsupported;
	public static String AbstractSmooksFormEditor_Error_Unsupported2;
	public static String AbstractSmooksFormEditor_Error_Update_Namespace;
	public static String AbstractSmooksFormEditor_Error_Update_Namespace2;
	public static String AbstractSmooksFormEditor_Exception_Cannot_Get_Input_File;
	public static String AbstractSmooksFormEditor_Exception_Transform_URL;
	public static String AbstractSmooksFormEditor_Source_Page_Title;
	public static String AbstractSmooksFormEditor_Task_Saving_File;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
