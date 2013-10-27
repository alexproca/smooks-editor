package org.jboss.tools.smooks.configuration.editors.smooks;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.jboss.tools.smooks.configuration.editors.smooks.messages"; //$NON-NLS-1$
	public static String ConditionTypeUICreator_InlineConditionLabel;
	public static String ReaderTypeUICreator_FeaturesGroupLabel;
	public static String ReaderTypeUICreator_HandlersGroupLabel;
	public static String ReaderTypeUICreator_ParameterGroupLabel;
	public static String ResourceConfigTypeUICreator_SelectorLabel;
	public static String SmooksResourceListTypeUICreator_DefualtSelectorLabel;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
