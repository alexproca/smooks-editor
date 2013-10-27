package org.jboss.tools.smooks.graphical.actions;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.jboss.tools.smooks.graphical.actions.messages"; //$NON-NLS-1$
	public static String AutoLayoutAction_Action_Text;
	public static String DeleteTaskNodeAction_Action_Delete;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
