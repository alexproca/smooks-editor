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
package org.jboss.tools.smooks.graphical.actions;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorPart;
import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.graphical.editors.TaskTypeManager;
import org.jboss.tools.smooks.graphical.editors.process.ProcessFactory;
import org.jboss.tools.smooks.graphical.editors.process.TaskType;
import org.jboss.tools.smooks.graphical.wizard.TemplateMessageTypeWizard;
import org.jboss.tools.smooks.graphical.wizard.freemarker.FreemarkerTemplateParametersProvider;
import org.jboss.tools.smooks.model.ModelFilter;
import org.jboss.tools.smooks.model.freemarker.Freemarker;
import org.jboss.tools.smooks.model.freemarker.FreemarkerFactory;
import org.jboss.tools.smooks.model.freemarker.FreemarkerPackage;
import org.jboss.tools.smooks.model.smooks.ParamType;
import org.jboss.tools.smooks.model.smooks.ResourceConfigType;
import org.jboss.tools.smooks.model.smooks.ResourceType;
import org.jboss.tools.smooks.model.smooks.SmooksFactory;
import org.jboss.tools.smooks.model.smooks.SmooksPackage;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;
import org.milyn.delivery.DomModelCreator;

/**
 * @author Dart
 * 
 */
public class AddNextTaskNodeAction extends AddTaskNodeAction {

	public AddNextTaskNodeAction(String taskID, String text, ISmooksModelProvider provider, IEditorPart editor) {
		super(taskID, text, provider, editor);
	}

	@Override
	protected void init() {
		super.init();
	}

	protected void addFreemarkerTemplateTask(IWizard currentWizard, SmooksResourceListType resourceList) {
		if (currentWizard instanceof FreemarkerTemplateParametersProvider) {
			List<TaskType> selectedTask = getCurrentSelectedTask();
			
			if(selectedTask == null || selectedTask.isEmpty()) {
				// No node properly selected in the Task Detail panel...
				return;
			}

			TaskType parentTask = selectedTask.get(0);
			Freemarker freemarker = FreemarkerFactory.eINSTANCE.createFreemarker();

			Map<String, String> parameters = ((FreemarkerTemplateParametersProvider) currentWizard).getParameters();
			Iterator<String> keys = parameters.keySet().iterator();
			while (keys.hasNext()) {
				String key = keys.next();
				String value = parameters.get(key);

				ParamType param = SmooksFactory.eINSTANCE.createParamType();
				param.setName(key);
				param.setStringValue(value);

				freemarker.getParam().add(param);
			}
			
			String type = ((FreemarkerTemplateParametersProvider) currentWizard).getTemplateType();
			if (type != null) {
				ParamType param = SmooksFactory.eINSTANCE.createParamType();
				param.setName(SmooksModelUtils.KEY_TEMPLATE_TYPE);
				param.setStringValue(type);
				freemarker.getParam().add(param);
			}

			// Add the templateDataProvider param...
			ParamType param = SmooksFactory.eINSTANCE.createParamType();
			param.setName(SmooksModelUtils.TEMPLATE_DATA_PROVIDER_PARAM_NAME);
			param.setStringValue(parentTask.getId());
			freemarker.getParam().add(param);

			CompoundCommand compoundCommand = new CompoundCommand();
			compoundCommand.append(AddCommand.create(this.provider.getEditingDomain(), resourceList,
					SmooksPackage.Literals.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_RESOURCE_CONFIG_GROUP, FeatureMapUtil
							.createEntry(FreemarkerPackage.Literals.DOCUMENT_ROOT__FREEMARKER, freemarker)));
			
			// If the template is connected from the input, create a 
			// DomNodeModel configuration, if one doesn't already exist...
			if(TaskTypeManager.TASK_ID_INPUT.equals(parentTask.getId().trim())) {
				if(ModelFilter.DomModelCreator.execute(resourceList).isEmpty()) {
					compoundCommand.append(createDomNodeModelConfig(resourceList));
				}
			}

			if (compoundCommand.canExecute()) {
				provider.getEditingDomain().getCommandStack().execute(compoundCommand);
				TaskType childTask = ProcessFactory.eINSTANCE.createTaskType();
				
				childTask.setId(getTaskID());
				childTask.addTaskResource(freemarker);
				childTask.setType(type);
				parentTask.addTask(childTask);
			}
		}
	}

	private Command createDomNodeModelConfig(SmooksResourceListType resourceList) {
		ResourceConfigType resourceConfig = SmooksFactory.eINSTANCE.createResourceConfigType();
		ResourceType resource = SmooksFactory.eINSTANCE.createResourceType();
		
		resourceConfig.setSelector("#document");
		resource.setValue(DomModelCreator.class.getName());
		resourceConfig.setResource(resource);

		return AddCommand.create(this.provider.getEditingDomain(), resourceList,
				SmooksPackage.Literals.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_RESOURCE_CONFIG_GROUP, FeatureMapUtil
						.createEntry(SmooksPackage.Literals.DOCUMENT_ROOT__RESOURCE_CONFIG, resourceConfig));
	}

	@Override
	public void run() {
		super.run();
		if (this.provider != null) {
			SmooksResourceListType resourceList = SmooksUIUtils.getSmooks11ResourceListType(provider.getSmooksModel());
			if (taskID.equals(TaskTypeManager.TASK_ID_FREEMARKER_XML_TEMPLATE) || taskID.equals(TaskTypeManager.TASK_ID_FREEMARKER_CSV_TEMPLATE)) {
				// open wizard
				TemplateMessageTypeWizard wizard = new TemplateMessageTypeWizard();
				WizardDialog dialog = new WizardDialog(editorPart.getSite().getShell(), wizard);
				if (dialog.open() == Dialog.OK) {
					// init freemarker model
					IWizard currentWizard = wizard.getWizard();
					addFreemarkerTemplateTask(currentWizard, resourceList);
				} else {
					return;
				}
			} else {
				TaskType parentTask = this.getCurrentSelectedTask().get(0);
				TaskType childTask = ProcessFactory.eINSTANCE.createTaskType();
				childTask.setId(taskID);
				childTask.setName(TaskTypeManager.getTaskLabel(childTask));
				parentTask.addTask(childTask);
			}
		}
	}

	protected TaskType createTaskType() {
		return ProcessFactory.eINSTANCE.createTaskType();
	}

	@Override
	public void update() {
		super.update();
		if (this.isEnabled()) {
			TaskType testTaskType = ProcessFactory.eINSTANCE.createTaskType();
			testTaskType.setId(taskID);
			setEnabled(rules.isNextTask(this.getCurrentSelectedTask().get(0), testTaskType));
		}
	}

}
