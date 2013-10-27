package org.jboss.tools.smooks.configuration.validate;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.jboss.tools.smooks.configuration.validate.messages"; //$NON-NLS-1$
	public static String BeanIdRefValidator_Warning_Does_Not_Exist;
	public static String BeanIdRefValidator_Warning_Java_Bean;
	public static String ClassFieldEditorValidator_Warning_Abstract_Class;
	public static String ClassFieldEditorValidator_Warning_Cannot_Find_Class;
	public static String ClassFieldEditorValidator_Warning_Class_Cannot_Be_Instanced;
	public static String ClassFieldEditorValidator_Warning_Class_Cannot_Be_Instanced2;
	public static String DuplicatedBeanIDValidator_Warning_Duplicate_Bean_ID;
	public static String PropertyValidator_Warning_Property_Cannot_Be_Found;
	public static String PropertyValidator_Warning_Property_Cannot_Be_Found2;
	public static String SelectorValidator_Warning_Cannot_Find_Input_Source;
	public static String SelectorValidator_Warning_Is_Not_Available;
	public static String SelectorValidator_Warning_Must_Be_Linked_to_Source;
	public static String SelectorValidator_Warning_Selector;
	public static String SetterMethodValidator_Warning_Cannot_Be_Found;
	public static String SetterMethodValidator_Warning_Setter_Method;
	public static String SmooksModelValidator_Task_Validating;
	public static String SmooksModelValidator_Task_Validating_Smooks_Model;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
