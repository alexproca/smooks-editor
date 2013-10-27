package org.jboss.tools.smooks.graphical.editors.editparts;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.jboss.tools.smooks.graphical.editors.editparts.messages"; //$NON-NLS-1$
	public static String InputDataContainerEditPart_CSV_Input_Model;
	public static String InputDataContainerEditPart_EDI_Input_Model;
	public static String InputDataContainerEditPart_Input_Model;
	public static String InputDataContainerEditPart_Java_Input_Model;
	public static String InputDataContainerEditPart_JSON_Input_Model;
	public static String InputDataContainerEditPart_XML_Input_Model;
	public static String InputDataContainerEditPart_XSD_Input_Model;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
