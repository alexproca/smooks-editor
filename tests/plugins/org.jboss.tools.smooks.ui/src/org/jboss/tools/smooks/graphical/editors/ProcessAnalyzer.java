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

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.configuration.editors.utils.SmooksUIUtils;
import org.jboss.tools.smooks.graphical.editors.process.ProcessFactory;
import org.jboss.tools.smooks.graphical.editors.process.ProcessType;
import org.jboss.tools.smooks.graphical.editors.process.TaskType;
import org.jboss.tools.smooks.model.freemarker.Freemarker;
import org.jboss.tools.smooks.model.javabean12.BeanType;
import org.jboss.tools.smooks.model.smooks.AbstractResourceConfig;
import org.jboss.tools.smooks.model.smooks.ParamType;
import org.jboss.tools.smooks.model.smooks.SmooksFactory;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;

/**
 * @author Dart
 * 
 */
public class ProcessAnalyzer {

	protected IEditingDomainProvider domainProvider;

	public ProcessAnalyzer(IEditingDomainProvider domainProvider) {
		this.domainProvider = domainProvider;
		Assert.isNotNull(this.domainProvider);
	}

	public List<TaskType> analyzeTaskID(SmooksResourceListType resourceList) {
		List<String> taskIDs = new ArrayList<String>();
		List<TaskType> tasks = new ArrayList<TaskType>();
		List<AbstractResourceConfig> resourceConfigList = resourceList.getAbstractResourceConfig();
		for (Iterator<?> iterator = resourceConfigList.iterator(); iterator.hasNext();) {
			AbstractResourceConfig abstractResourceConfig = (AbstractResourceConfig) iterator.next();

			// for java-mapping
			if (abstractResourceConfig instanceof BeanType) {
				if (taskIDs.contains(TaskTypeManager.TASK_ID_JAVA_MAPPING)) {
					continue;
				}
				taskIDs.add(TaskTypeManager.TASK_ID_JAVA_MAPPING);

				TaskType task = ProcessFactory.eINSTANCE.createTaskType();
				task.setId(TaskTypeManager.TASK_ID_JAVA_MAPPING);
				task.setName(TaskTypeManager.getTaskLabel(task));
				tasks.add(task);
			}
			// for freemarker template
			if (abstractResourceConfig instanceof Freemarker) {

				TaskType task = toTaskType((Freemarker) abstractResourceConfig);
				tasks.add(task);

				String refid = SmooksModelUtils.getParamValue(((Freemarker) abstractResourceConfig).getParam(),
						SmooksModelUtils.KEY_OBJECT_ID);
				if (refid == null) {
					refid = SmooksModelUtils.generateTaskID(resourceList, Freemarker.class, "freemarker"); //$NON-NLS-1$
					ParamType idParam = SmooksFactory.eINSTANCE.createParamType();
					idParam.setName(SmooksModelUtils.KEY_OBJECT_ID);
					idParam.setStringValue(refid);
					((Freemarker) abstractResourceConfig).getParam().add(idParam);
				}
				if (refid != null) {
					ParamType idParam = SmooksFactory.eINSTANCE.createParamType();
					idParam.setName(SmooksModelUtils.KEY_TASK_ID_REF);
					idParam.setStringValue(refid);
//					SmooksModelUtils.addParam(task, idParam);
				}

				taskIDs.add(task.getId());
			}
		}
		return tasks;
	}
	
	public static TaskType toTaskType(Freemarker freeMarker) {
		String messageType = SmooksModelUtils.getParamValue(freeMarker.getParam(), SmooksModelUtils.KEY_TEMPLATE_TYPE);
		TaskType task = ProcessFactory.eINSTANCE.createTaskType();
			
		task.setType(messageType);
		if(SmooksModelUtils.FREEMARKER_TEMPLATE_TYPE_XML.equals(messageType)) {
			task.setId(TaskTypeManager.TASK_ID_FREEMARKER_XML_TEMPLATE);
		} else if(SmooksModelUtils.FREEMARKER_TEMPLATE_TYPE_CSV.equals(messageType)) {
			task.setId(TaskTypeManager.TASK_ID_FREEMARKER_CSV_TEMPLATE);
		}
		task.setName(TaskTypeManager.getTaskLabel(task));
		task.addTaskResource(freeMarker);
		
		return task; 
	}

//	private SmooksGraphicsExtType getSmooksGraphicsType(SmooksResourceListType resouceList) {
//		List<AbstractResourceConfig> resourceConfigList = resouceList.getAbstractResourceConfig();
//		for (Iterator<?> iterator = resourceConfigList.iterator(); iterator.hasNext();) {
//			AbstractResourceConfig abstractResourceConfig = (AbstractResourceConfig) iterator.next();
//			if (abstractResourceConfig instanceof SmooksGraphicsExtType) {
//				return (SmooksGraphicsExtType) abstractResourceConfig;
//			}
//		}
//		return null;
//	}

	private void fillAllTask(TaskType task, List<TaskType> taskList) {
		SmooksUIUtils.fillAllTask(task, taskList);
	}
	
	public boolean analyzeSmooksModels(ProcessType process , SmooksResourceListType resourceList) {
		boolean modelWasChanged = false;
//		CompoundCommand compoundCommand = new CompoundCommand();
//		SmooksGraphicsExtType ext = this.getSmooksGraphicsType(resourceList);
//		if (ext == null)
//			throw new RuntimeException("Can't find the smooks-graph-ext element");
//
//		ProcessesType processes = ext.getProcesses();
//		if (processes == null) {
//			processes = GraphFactory.eINSTANCE.createProcessesType();
//			Command c = SetCommand.create(domainProvider.getEditingDomain(), ext,
//					GraphPackage.Literals.SMOOKS_GRAPHICS_EXT_TYPE__PROCESSES, processes);
//			compoundCommand.append(c);
//			// ext.setProcesses(processes);
//			modelWasChanged = true;
//		}
//		ProcessType process = null;
//		if (processes != null) {
//			process = processes.getProcess();
//		}

//		if (process == null) {
//			process = GraphFactory.eINSTANCE.createProcessType();
//			Command c = SetCommand.create(domainProvider.getEditingDomain(), processes,
//					GraphPackage.Literals.PROCESSES_TYPE__PROCESS, process);
//			compoundCommand.append(c);
//			modelWasChanged = true;
//		}

		List<TaskType> currentList = process.getTask();
		List<TaskType> taskList = new ArrayList<TaskType>();
		for (Iterator<?> iterator = currentList.iterator(); iterator.hasNext();) {
			TaskType taskType = (TaskType) iterator.next();
			this.fillAllTask(taskType, taskList);
		}

		if (taskList.isEmpty()) {
//			TaskType inputTask = GraphFactory.eINSTANCE.createTaskType();
//			inputTask.setId(TaskTypeManager.TASK_ID_INPUT);
//			inputTask.setName(TaskTypeManager.getTaskLabel(TaskTypeManager.TASK_ID_INPUT));
//
//			Command command = AddCommand.create(domainProvider.getEditingDomain(), process,
//					GraphPackage.Literals.PROCESS_TYPE__TASK, inputTask);
//			compoundCommand.append(command);

//			taskList.add(inputTask);
			modelWasChanged = true;
		}

		List<TaskType> tasks = analyzeTaskID(resourceList);
		for (Iterator<?> iterator = tasks.iterator(); iterator.hasNext();) {
			TaskType taskType = (TaskType) iterator.next();
			if (canAdd(taskList, taskType)) {
				taskList.add(taskType);
			}
		}
		// for (Iterator<String> iterator = taskIDs.iterator();
		// iterator.hasNext();) {
		// String taskId = (String) iterator.next();
		// if (!taskIDIsExist(taskId, taskList)) {
		// TaskType task = GraphFactory.eINSTANCE.createTaskType();
		// task.setId(taskId);
		// task.setName(TaskTypeManager.getTaskLabel(taskId));
		// taskList.add(task);
		// }
		// }
		List<TaskType> dummyTasks = new ArrayList<TaskType>();
//		modelWasChanged = linkTask(taskList, dummyTasks, compoundCommand);
//		compoundCommand.execute();
		return modelWasChanged;
	}

	/**
	 * @deprecated
	 * @param resourceList
	 * @return If the smooks-resource-list was changed in this method return
	 *         <code>true</code>
	 */
	public boolean analyzeSmooksModels(SmooksResourceListType resourceList) {
		boolean modelWasChanged = false;
//		CompoundCommand compoundCommand = new CompoundCommand();
//		SmooksGraphicsExtType ext = this.getSmooksGraphicsType(resourceList);
//		if (ext == null)
//			throw new RuntimeException("Can't find the smooks-graph-ext element");
//
//		ProcessesType processes = ext.getProcesses();
//		if (processes == null) {
//			processes = GraphFactory.eINSTANCE.createProcessesType();
//			Command c = SetCommand.create(domainProvider.getEditingDomain(), ext,
//					GraphPackage.Literals.SMOOKS_GRAPHICS_EXT_TYPE__PROCESSES, processes);
//			compoundCommand.append(c);
//			// ext.setProcesses(processes);
//			modelWasChanged = true;
//		}
//		ProcessType process = null;
//		if (processes != null) {
//			process = processes.getProcess();
//		}
//
//		if (process == null) {
//			process = GraphFactory.eINSTANCE.createProcessType();
//			Command c = SetCommand.create(domainProvider.getEditingDomain(), processes,
//					GraphPackage.Literals.PROCESSES_TYPE__PROCESS, process);
//			compoundCommand.append(c);
//			modelWasChanged = true;
//		}
//
//		List<TaskType> currentList = process.getTask();
//		List<TaskType> taskList = new ArrayList<TaskType>();
//		for (Iterator<?> iterator = currentList.iterator(); iterator.hasNext();) {
//			TaskType taskType = (TaskType) iterator.next();
//			this.fillAllTask(taskType, taskList);
//		}
//
//		if (taskList.isEmpty()) {
//			TaskType inputTask = GraphFactory.eINSTANCE.createTaskType();
//			inputTask.setId(TaskTypeManager.TASK_ID_INPUT);
//			inputTask.setName(TaskTypeManager.getTaskLabel(TaskTypeManager.TASK_ID_INPUT));
//
//			Command command = AddCommand.create(domainProvider.getEditingDomain(), process,
//					GraphPackage.Literals.PROCESS_TYPE__TASK, inputTask);
//			compoundCommand.append(command);
//
//			taskList.add(inputTask);
//			modelWasChanged = true;
//		}
//
//		List<TaskType> tasks = analyzeTaskID(resourceList);
//		for (Iterator<?> iterator = tasks.iterator(); iterator.hasNext();) {
//			TaskType taskType = (TaskType) iterator.next();
//			if (canAdd(taskList, taskType)) {
//				taskList.add(taskType);
//			}
//		}
//		// for (Iterator<String> iterator = taskIDs.iterator();
//		// iterator.hasNext();) {
//		// String taskId = (String) iterator.next();
//		// if (!taskIDIsExist(taskId, taskList)) {
//		// TaskType task = GraphFactory.eINSTANCE.createTaskType();
//		// task.setId(taskId);
//		// task.setName(TaskTypeManager.getTaskLabel(taskId));
//		// taskList.add(task);
//		// }
//		// }
//		List<TaskType> dummyTasks = new ArrayList<TaskType>();
//		modelWasChanged = linkTask(taskList, dummyTasks, compoundCommand);
//		compoundCommand.execute();
		return modelWasChanged;
	}
	
	public static void main(String[] args){
//		Properties pros = System.getProperties();
//		Enumeration eee = pros.keys();
//		while(eee.hasMoreElements()){
//			Object key = eee.nextElement();
//			System.out.println(key + " : " + pros.getProperty(key.toString()));
//		}
	}

	private boolean canAdd(List<TaskType> list, TaskType taskType) {
		if (TaskTypeManager.TASK_ID_JAVA_MAPPING.equals(taskType.getId())) {
			for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
				TaskType taskType1 = (TaskType) iterator.next();
				if (TaskTypeManager.TASK_ID_JAVA_MAPPING.equals(taskType1.getId())) {
					return false;
				}
			}
		}
		return true;
	}

	private List<TaskType> getTaskTypes(String id, List<TaskType> taskList) {
		List<TaskType> tasks = new ArrayList<TaskType>();
		for (Iterator<?> iterator = taskList.iterator(); iterator.hasNext();) {
			TaskType taskType = (TaskType) iterator.next();
			if (id.equals(taskType.getId())) {
				tasks.add(taskType);
			}
		}
		return tasks;
	}

	private TaskType getTaskType(String id, List<TaskType> taskList) {
		for (Iterator<?> iterator = taskList.iterator(); iterator.hasNext();) {
			TaskType taskType = (TaskType) iterator.next();
			if (id.equals(taskType.getId())) {
				return taskType;
			}
		}
		return null;
	}

	private boolean linkTask(List<TaskType> taskList, List<TaskType> dummyTasks, CompoundCommand compoundCommand) {
		TaskType first = getTaskType(TaskTypeManager.TASK_ID_INPUT, taskList);
		if (first != null) {
			taskList.remove(first);
			return linkTask(first, taskList, dummyTasks, compoundCommand);
		}
		return false;
	}

	private boolean linkTask(TaskType taskType, List<TaskType> taskList, List<TaskType> dummyTasks,
			CompoundCommand compoundCommand) {
		String id = taskType.getId();
		String[] childrenIds = TaskTypeManager.getChildTaskIDs(id);
		boolean changed = false;
//		if (childrenIds != null) {
//			for (int i = 0; i < childrenIds.length; i++) {
//				String childId = childrenIds[i];
//				List<TaskType> tasks = getTaskTypes(childId, taskList);
//				for (Iterator<?> iterator = tasks.iterator(); iterator.hasNext();) {
//					TaskType childTask = (TaskType) iterator.next();
//					if (childTask != null) {
//						EList<TaskType> exsitedTasks = taskType.getTask();
//						boolean duplited = false;
//						boolean canAdd = true;
//						for (Iterator<?> iterator2 = exsitedTasks.iterator(); iterator2.hasNext();) {
//							TaskType taskType2 = (TaskType) iterator2.next();
//							String refid = SmooksModelUtils.getParamValue(taskType2, SmooksModelUtils.KEY_TASK_ID_REF);
//							String refid2 = SmooksModelUtils.getParamValue(childTask, SmooksModelUtils.KEY_TASK_ID_REF);
//							if (refid != null && refid2 != null && refid.equals(refid2)) {
//								canAdd = false;
//								duplited = true;
//								break;
//							}
//							if (refid == null && refid2 == null) {
//								canAdd = false;
//								duplited = true;
//								break;
//							}
//						}
//						if (canAdd
//								&& !taskType.getTask().contains(childTask)
//								&& ((childTask.eContainer() == null) || (childTask.eContainer() instanceof ProcessType))) {
//							Command c = AddCommand.create(domainProvider.getEditingDomain(), taskType,
//									GraphPackage.Literals.TASK_TYPE__TASK, childTask);
//							compoundCommand.append(c);
//							// taskType.getTask().add(childTask);
//							changed = true;
//						}
//						if (!duplited) {
//							dummyTasks.add(childTask);
//						}
//						taskList.remove(childTask);
//						boolean cchange = linkTask(childTask, taskList, dummyTasks, compoundCommand);
//						changed = (changed || cchange);
//					}
//				}
//
//			}
//		}
		return changed;
	}

	// private boolean taskIDIsExist(String taskId, List<TaskType> taskList) {
	// for (Iterator<?> iterator = taskList.iterator(); iterator.hasNext();) {
	// TaskType task = (TaskType) iterator.next();
	// if (task.getId().equals(taskId)) {
	// return true;
	// }
	// }
	// return false;
	// }
	//
	// private boolean taskIsExist(TaskType task , List<String> taskIDs){
	// for (Iterator<?> iterator = taskIDs.iterator(); iterator.hasNext();) {
	// String id = (String) iterator.next();
	// if(task.getId().equals(id)){
	// return true;
	// }
	// }
	// return false;
	// }
}
