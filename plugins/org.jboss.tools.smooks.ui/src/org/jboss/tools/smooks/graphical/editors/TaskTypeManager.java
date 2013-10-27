/*******************************************************************************
 * Copyright (c) 2008 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.smooks.graphical.editors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.configuration.editors.GraphicsConstants;
import org.jboss.tools.smooks.graphical.editors.process.TaskType;
import org.jboss.tools.smooks.model.ModelFilter;
import org.jboss.tools.smooks.model.filters.FreemarkerFilter;
import org.jboss.tools.smooks.model.freemarker.Freemarker;
import org.jboss.tools.smooks.model.javabean12.BeanType;
import org.jboss.tools.smooks.model.smooks.AbstractResourceConfig;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;

/**
 * @author Dart
 * 
 */
public class TaskTypeManager {

	public static final String TASK_ID_INPUT = "input"; //$NON-NLS-1$

	public static final String TASK_ID_JAVA_MAPPING = "java_mapping"; //$NON-NLS-1$

	public static final String TASK_ID_XSL_TEMPLATE = "xsl_template"; //$NON-NLS-1$

	public static final String TASK_ID_FREEMARKER_CSV_TEMPLATE = "freemarker_csv_template"; //$NON-NLS-1$

	public static final String TASK_ID_FREEMARKER_XML_TEMPLATE = "freemarker_xml_template"; //$NON-NLS-1$

	private static List<TaskTypeDescriptor> allTaskList = null;

	public static String[] getChildTaskIDs(String parentId) {
		if (parentId == null)
			return null;
		if (parentId.equals(TaskTypeManager.TASK_ID_INPUT)) {
			return new String[] { TaskTypeManager.TASK_ID_JAVA_MAPPING, TaskTypeManager.TASK_ID_FREEMARKER_XML_TEMPLATE, TaskTypeManager.TASK_ID_FREEMARKER_CSV_TEMPLATE};
		}
		if (parentId.equals(TaskTypeManager.TASK_ID_JAVA_MAPPING)) {
			return new String[] { TaskTypeManager.TASK_ID_FREEMARKER_XML_TEMPLATE, TaskTypeManager.TASK_ID_FREEMARKER_CSV_TEMPLATE };
		}
		return null;
	}

	/**
	 * @return the allTaskList
	 */
	public static List<TaskTypeDescriptor> getAllTaskList() {
		if (allTaskList == null) {
			allTaskList = new ArrayList<TaskTypeDescriptor>();

			// init
			allTaskList.add(new TaskTypeDescriptor(TASK_ID_INPUT, Messages.TaskTypeManager_Input,
					GraphicsConstants.IMAGE_INPUT_TASK));
			allTaskList.add(new TaskTypeDescriptor(TASK_ID_JAVA_MAPPING, Messages.TaskTypeManager_JavaMappingTaskLabel,
					GraphicsConstants.IMAGE_JAVA_AMPPING_TASK));
			allTaskList.add(new TaskTypeDescriptor(TASK_ID_FREEMARKER_XML_TEMPLATE,
					Messages.TaskTypeManager_ApplyTemplateTaskLabel, GraphicsConstants.IMAGE_APPLY_FREEMARKER_TASK));
			allTaskList.add(new TaskTypeDescriptor(TASK_ID_FREEMARKER_CSV_TEMPLATE,
					Messages.TaskTypeManager_ApplyTemplateTaskLabel, GraphicsConstants.IMAGE_APPLY_FREEMARKER_TASK));
		}
		return allTaskList;
	}

	public static List<Object> getAssociatedSmooksElementsType(TaskType taskType) {
		return null;
	}

	public static List<Object> getAssociatedSmooksElementsType(String taskID) {
		List<Object> elementsType = new ArrayList<Object>();
		if (taskID == null)
			return null;
		if (TASK_ID_JAVA_MAPPING.equals(taskID)) {
			elementsType.add(BeanType.class);
		}
		if (TASK_ID_FREEMARKER_XML_TEMPLATE.equals(taskID) || TASK_ID_FREEMARKER_CSV_TEMPLATE.equals(taskID)) {
			elementsType.add(Freemarker.class);
		}
		return elementsType;
	}

	public static String getTaskLabel(TaskType task) {
		if (task != null) {
			String taskId = task.getId();
			if (taskId != null) {
				if (taskId.equals(TASK_ID_FREEMARKER_XML_TEMPLATE) || taskId.equals(TASK_ID_FREEMARKER_CSV_TEMPLATE)) {
					String messageType = task.getType();
					if (messageType == null)
						messageType = ""; //$NON-NLS-1$
					if (messageType.length() > 0){
						return Messages.TaskTypeManager_ApplyTemplateTaskLabel + " (" + messageType +")"; //$NON-NLS-1$ //$NON-NLS-2$
					}else{
						return  Messages.TaskTypeManager_ApplyTemplateTaskLabel;
					}
				}
				if (taskId.equals(TASK_ID_INPUT)) {
					return Messages.TaskTypeManager_InputTaskLabel;
				}
				if (taskId.equals(TASK_ID_JAVA_MAPPING)) {
					return Messages.TaskTypeManager_JavaMappingTaskLabel;
				}
				if (taskId.equals(TASK_ID_XSL_TEMPLATE)) {
					return Messages.TaskTypeManager_ApplyXSLTemplateTaskLabel;
				}
			}
		}
		return ""; //$NON-NLS-1$
	}

	/**
	 * 
	 * @param taskID
	 * @param smooksResourceList
	 * @return
	 */
	public static List<Object> getAssociatedResourceDeletes(TaskType taskType, SmooksResourceListType smooksResourceList) {
		List<Object> elementTypes = getAssociatedSmooksElementsType(taskType.getId());
		List<AbstractResourceConfig> resourceConfigList = smooksResourceList.getAbstractResourceConfig();
		List<Object> associatedElements = new ArrayList<Object>();
		
		for (AbstractResourceConfig abstractResourceConfig : resourceConfigList) {
			if (isSameType(abstractResourceConfig, elementTypes) && canRemove(abstractResourceConfig, taskType)) {
				associatedElements.add(abstractResourceConfig);
			}
		}
		
		if(TASK_ID_FREEMARKER_XML_TEMPLATE.equals(taskType.getId()) || TASK_ID_FREEMARKER_CSV_TEMPLATE.equals(taskType.getId())) {
			Freemarker resource = (Freemarker) taskType.getTaskResources().get(0);
			FreemarkerFilter ftlFilter = new FreemarkerFilter().addExclude(resource);
			
			if(ftlFilter.execute(smooksResourceList).isEmpty()) {
				// If there's no other Freemarker resources... remove any DomModelCreator resources too...
				associatedElements.addAll(ModelFilter.DomModelCreator.execute(smooksResourceList));
			}
		}
		
		return associatedElements;
	}

	private static boolean canRemove(AbstractResourceConfig abstractResourceConfig, TaskType taskType) {
		if (abstractResourceConfig instanceof Freemarker) {
			return taskType.inTheTask(abstractResourceConfig);
		}
		return true;
	}

	private static boolean isSameType(Object element, List<Object> elementTypes) {
		for (Iterator<?> iterator = elementTypes.iterator(); iterator.hasNext();) {
			Class<?> object = (Class<?>) iterator.next();
			if (object.isInstance(element)) {
				return true;
			}
		}
		return false;
	}

	public static final class TaskTypeDescriptor {

		private String id;

		private String label;

		private String imagePath;

		public TaskTypeDescriptor(String id, String label, String imagePath) {
			this.id = id;
			this.label = label;
			this.imagePath = imagePath;
		}

		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}

		/**
		 * @param id
		 *            the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}

		/**
		 * @return the label
		 */
		public String getLabel() {
			return label;
		}

		/**
		 * @param label
		 *            the label to set
		 */
		public void setLabel(String label) {
			this.label = label;
		}

		/**
		 * @return the imagePath
		 */
		public String getImagePath() {
			return imagePath;
		}

		/**
		 * @param imagePath
		 *            the imagePath to set
		 */
		public void setImagePath(String imagePath) {
			this.imagePath = imagePath;
		}

	}

}
