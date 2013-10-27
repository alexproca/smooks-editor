package org.jboss.tools.smooks.graphical.editors.model.javamapping;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.jboss.tools.smooks.graphical.editors.model.javamapping.messages"; //$NON-NLS-1$
	public static String JavaBeanChildGraphModel_Array_Entry;
	public static String JavaBeanChildGraphModel_Collection_Entry;
	public static String JavaBeanChildGraphModel_Error;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
