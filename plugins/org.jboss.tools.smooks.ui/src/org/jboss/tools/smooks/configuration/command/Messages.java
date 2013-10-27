package org.jboss.tools.smooks.configuration.command;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.jboss.tools.smooks.configuration.command.messages"; //$NON-NLS-1$
	public static String UnSetFeatureCommand_commandlabel;
	public static String UnSetFeatureCommand_QuoteChar;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
