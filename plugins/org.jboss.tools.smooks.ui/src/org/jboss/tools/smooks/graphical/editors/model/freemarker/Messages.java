package org.jboss.tools.smooks.graphical.editors.model.freemarker;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.jboss.tools.smooks.graphical.editors.model.freemarker.messages"; //$NON-NLS-1$
	public static String AddFreemarkerCSVFieldAction_Action_Text;
	public static String AddFreemarkerCSVRecordAction_Action_Text;
	public static String FreemarkerTemplateGraphicalModel_CSV_Record_Name;
	public static String FreemarkerTemplateGraphicalModel_CSV_Template_Name;
	public static String FreemarkerTemplateGraphicalModel_XML_Template_Name;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
