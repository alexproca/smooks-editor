package org.jboss.tools.smooks.gef.common;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.jboss.tools.smooks.gef.common.messages"; //$NON-NLS-1$
	public static String SmooksGraphicalMenuContextProvider_Action_Properties;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
