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
package org.jboss.tools.smooks.graphical.editors.process;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.graphical.editors.ProcessAnalyzer;
import org.jboss.tools.smooks.graphical.editors.TaskTypeManager;
import org.jboss.tools.smooks.model.freemarker.Freemarker;
import org.jboss.tools.smooks.model.javabean12.BeanType;
import org.jboss.tools.smooks.model.smooks.AbstractResourceConfig;
import org.jboss.tools.smooks.model.smooks.ElementVisitor;
import org.jboss.tools.smooks.model.smooks.ParamType;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;

/**
 * @author Dart
 * 
 */
public class ProcessTaskAnalyzer {

	public void analyzeTaskNode(ProcessType process, SmooksResourceListType resourceList) {
		process.getTask().clear();
		
		if (resourceList == null) {
			return;
		}
		
		// Input task node must be in process:
		TaskType inputTask = ProcessFactory.eINSTANCE.createTaskType();
		inputTask.setId(TaskTypeManager.TASK_ID_INPUT);
		inputTask.setName(TaskTypeManager.getTaskLabel(inputTask));

		process.addTask(inputTask);

		List<AbstractResourceConfig> resourceConfigList = resourceList.getAbstractResourceConfig();
		TaskType javaMappingTask = getJavaMappingTask(resourceConfigList);
		List<TaskType> templatingTasks = getTemplatingTasks(resourceConfigList);

		// Connect the Java Mappings task to the input task...
		if (javaMappingTask != null) {
			inputTask.addTask(javaMappingTask);
		}

		// Connect the Templating tasks to the Input and Java Mappings task as appropriate...
		for(TaskType templatingTask : templatingTasks) {
			AbstractResourceConfig templatingResource = templatingTask.getTaskResources().get(0);
			
			if(templatingResource instanceof Freemarker) {
				Freemarker freemarkerResource = (Freemarker) templatingResource;
				EList<ParamType> params = freemarkerResource.getParam();
				
				if(SmooksModelUtils.getParam(params, SmooksModelUtils.KEY_TEMPLATE_TYPE) != null) {
					ParamType templateDataProvider = SmooksModelUtils.getParam(params, SmooksModelUtils.TEMPLATE_DATA_PROVIDER_PARAM_NAME);
					
					if(templateDataProvider == null || TaskTypeManager.TASK_ID_JAVA_MAPPING.equals(templateDataProvider.getStringValue())) {
						if(javaMappingTask != null) {
							javaMappingTask.addTask(templatingTask);
						}
					} else if(templateDataProvider != null && TaskTypeManager.TASK_ID_INPUT.equals(templateDataProvider.getStringValue())) {
						inputTask.addTask(templatingTask);
					}
				}
			}
		}		
	}

	private TaskType getJavaMappingTask(List<AbstractResourceConfig> resourceConfigList) {
		return getTask(BeanType.class, TaskTypeManager.TASK_ID_JAVA_MAPPING, resourceConfigList);
	}

	private List<TaskType> getTemplatingTasks(List<AbstractResourceConfig> resourceConfigList) {
		List<TaskType> taskList = new ArrayList<TaskType>();
		
		addFreeMarkerTasks(resourceConfigList, taskList);
		
		return taskList;
	}

	private TaskType getTask(Class<? extends ElementVisitor> resourceType, String taskId, List<AbstractResourceConfig> resourceConfigList) {
		TaskType task = null;

		for (AbstractResourceConfig abstractResourceConfig : resourceConfigList) {
			if (resourceType.isInstance(abstractResourceConfig)) {
				if(task == null) {
					task = ProcessFactory.eINSTANCE.createTaskType();
					task.setId(taskId);
					task.setName(TaskTypeManager.getTaskLabel(task));
				}
				task.addTaskResource(abstractResourceConfig);
			}
		}
		
		return task;
	}

	private void addFreeMarkerTasks(List<AbstractResourceConfig> resourceConfigList, List<TaskType> taskList) {
		for (AbstractResourceConfig resourceConfig : resourceConfigList) {
			if (resourceConfig instanceof Freemarker) {
				taskList.add(ProcessAnalyzer.toTaskType((Freemarker) resourceConfig));
			}
		}
	}
}
