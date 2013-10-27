package org.jboss.tools.smooks.edimap.actions;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.jboss.tools.smooks.edimap.actions.messages"; //$NON-NLS-1$
	public static String AddComponentAction_Action_Text;
	public static String AddComponentAction_Action_Tooltip;
	public static String AddFieldAction_Action_Text;
	public static String AddFieldAction_Action_Tooltip;
	public static String AddSegmentAction_Action_Text;
	public static String AddSegmentAction_Action_Tooltip;
	public static String AddSubComponentAction_Action_Text;
	public static String AddSubComponentAction_Action_Tooltip;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
