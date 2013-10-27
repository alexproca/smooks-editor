package org.jboss.tools.smooks.graphical.editors;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.jboss.tools.smooks.graphical.editors.messages"; //$NON-NLS-1$
	public static String SmooksFreemarkerTemplateGraphicalEditor_Warning_CSV_Fields_Empty;
	public static String SmooksFreemarkerTemplateGraphicalEditor_Warning_Must_Link_CSV_Record;
	public static String SmooksFreemarkerTemplateGraphicalEditor_Warning_Must_Link_to_Collection;
	public static String SmooksFreemarkerTemplateGraphicalEditor_Warning_Quote_Empty;
	public static String SmooksFreemarkerTemplateGraphicalEditor_Warning_Separator_Empty;
	public static String SmooksGraphicalEditorMenuContextProvider_Add_Menu_Text;
	public static String SmooksGraphicalEditorPaletteRootCreator_General_Palette_Drawer;
	public static String SmooksGraphicalEditorPaletteRootCreator_Link_Tool_Text;
	public static String SmooksGraphicalEditorPaletteRootCreator_Link_Tool_Tooltip;
	public static String SmooksJavaMappingGraphicalEditor_BeanIdEmptyErrormessage;
	public static String SmooksJavaMappingGraphicalEditor_NodeMustLinkWithJavaBean;
	public static String SmooksJavaMappingGraphicalEditor_NodeMustLinkWithSource;
	public static String SmooksJavaMappingGraphicalEditor_NullLabel;
	public static String SmooksJavaMappingGraphicalEditor_WarningMessage1;
	public static String SmooksProcessGraphicalEditor_Validation_No_Java_Mapping;
	public static String SmooksProcessGraphicalEditor_Validation_No_DomModelCreator;
	public static String SmooksProcessGraphicalEditor_AddTaskActionText;
	public static String SmooksProcessGraphicalEditor_FormText;
	public static String SmooksProcessGraphicalEditor_TaskConfigurationSectionTitle;
	public static String SmooksProcessGraphicalEditor_TasksMapSectionTitle;
	public static String SmooksXSLTemplateGraphicalEditor_Group_Name;
	public static String TaskTypeManager_ApplyTemplateTaskLabel;
	public static String TaskTypeManager_ApplyXSLTemplateTaskLabel;
	public static String TaskTypeManager_Input;
	public static String TaskTypeManager_InputTaskLabel;
	public static String TaskTypeManager_JavaMappingTaskLabel;
	public static String XSLLabelProvider_Text_Null_Value;
	public static String SmooksProcessGraphicalEditor_Empty_Input_File;
	public static String SmooksProcessGraphicalEditor_Java_Mapping_Not_Found;
	public static String SmooksProcessGraphicalEditor_No_Input_File_Active;
	public static String SmooksProcessGraphicalEditor_No_Input_Specified;
	public static String SmooksProcessGraphicalEditor_No_Input_Task_Found;
	public static String SmooksProcessGraphicalEditor_ValidationError_MultipleTemplate;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
