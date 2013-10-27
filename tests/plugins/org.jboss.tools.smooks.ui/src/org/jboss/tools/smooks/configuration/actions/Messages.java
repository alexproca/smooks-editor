package org.jboss.tools.smooks.configuration.actions;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.jboss.tools.smooks.configuration.actions.messages"; //$NON-NLS-1$
	public static String OpenEditorEditInnerContentsAction_OpenEditor_Des;
	public static String OpenEditorEditInnerContentsAction_OpenEditor_Label;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
