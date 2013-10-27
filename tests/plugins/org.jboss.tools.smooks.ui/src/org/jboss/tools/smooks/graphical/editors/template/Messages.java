package org.jboss.tools.smooks.graphical.editors.template;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.jboss.tools.smooks.graphical.editors.template.messages"; //$NON-NLS-1$
	public static String FreemarkerTemplateContentGraphModelProviderImpl_IOExceptionMessage;
	public static String SmooksFreemarkerTemplateGraphicalEditor_WarningMessage1;
	public static String SmooksFreemarkerTemplateGraphicalEditor_WarningMessage2;
	public static String SmooksFreemarkerTemplateGraphicalEditor_WarningMessage3;
	public static String SmooksFreemarkerTemplateGraphicalEditor_WarningMessage4;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
