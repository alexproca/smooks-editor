package org.jboss.tools.smooks.configuration.editors.freemarker;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.jboss.tools.smooks.configuration.editors.freemarker.messages"; //$NON-NLS-1$
	public static String FreemarkerUICreator_Apply_On_Element;
	public static String TemplateUICreator_External_Template_File;
	public static String TemplateUICreator_Inline_Template;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
