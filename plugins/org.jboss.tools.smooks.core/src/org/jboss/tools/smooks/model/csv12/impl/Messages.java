package org.jboss.tools.smooks.model.csv12.impl;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.jboss.tools.smooks.model.csv12.impl.messages"; //$NON-NLS-1$
	public static String Csv12FactoryImpl_Error_Invalid_Class;
	public static String Csv12FactoryImpl_Error_Invalid_Datatype;
	public static String Csv12FactoryImpl_Error_Not_Valid_Classifier;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
