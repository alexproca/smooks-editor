package org.jboss.tools.smooks.model.common.impl;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.jboss.tools.smooks.model.common.impl.messages"; //$NON-NLS-1$
	public static String CommonFactoryImpl_Error_Invalid_Classifier;
	public static String CommonFactoryImpl_Error_Invalid_Classifier2;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
