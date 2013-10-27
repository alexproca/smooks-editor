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
package org.jboss.tools.smooks.graphical.editors.template;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.gef.EditPartFactory;
import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;
import org.jboss.tools.smooks.graphical.editors.Messages;
import org.jboss.tools.smooks.graphical.editors.autolayout.IAutoLayout;
import org.jboss.tools.smooks.graphical.editors.editparts.freemarker.FreemarkerAutoLayout;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerActionCreator;
import org.jboss.tools.smooks.graphical.editors.process.TaskType;
import org.jboss.tools.smooks.model.freemarker.Freemarker;
import org.jboss.tools.smooks.model.smooks.ParamType;

/**
 * @author Dart
 * 
 */
public class SmooksFreemarkerCSVTemplateGraphicalEditor extends SmooksFreemarkerTemplateGraphicalEditor {

	public static final String ID = "__smooks_freemarker_csv_template_graphical_editpart"; //$NON-NLS-1$

	private IAutoLayout autoLayout = null;

	public SmooksFreemarkerCSVTemplateGraphicalEditor(ISmooksModelProvider provider) {
		super(provider);
		// TODO Auto-generated constructor stub
	}

	protected void autoLayoutWhenCommandChange(Command command) {
		Collection<?> affectedObjects = command.getAffectedObjects();
		for (Iterator<?> iterator2 = affectedObjects.iterator(); iterator2.hasNext();) {
			Object object = (Object) iterator2.next();
			if (object instanceof ParamType) {
				Object parent = ((ParamType) object).eContainer();
				if (SmooksModelUtils.KEY_CSV_FIELDS.equals(((ParamType) object).getName())) {
					if (parent instanceof Freemarker) {
						TaskType task = this.getTaskType();
						if (task != null && task.inTheTask((Freemarker)parent)) {
							autoLayout(true);
							break;
						}
					}
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.graphical.editors.SmooksGraphicalEditorPart#
	 * createEdtiPartFactory()
	 */
	@Override
	protected EditPartFactory createEdtiPartFactory() {
		return super.createEdtiPartFactory();
	}


	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.graphical.editors.SmooksFreemarkerTemplateGraphicalEditor#validateTemplate(java.lang.String, org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel)
	 */
	@Override
	protected void validateTemplate(String type, AbstractSmooksGraphicalModel templateGraphModel) {
		if (SmooksModelUtils.FREEMARKER_TEMPLATE_TYPE_CSV.equals(type)) {
			validateCSVTemplate(templateGraphModel);
		}
//		super.validateTemplate(type, templateGraphModel);
	}

	protected void validateCSVTemplate(AbstractSmooksGraphicalModel templateGraphModel) {
		int s = AbstractSmooksGraphicalModel.NONE;
		Object data = templateGraphModel.getData();
		data = AdapterFactoryEditingDomain.unwrap(data);

		char seperator = SmooksModelUtils.getFreemarkerCSVSeperator((Freemarker) data);

		if (seperator == 0) {
			templateGraphModel.getMessage().add(Messages.SmooksFreemarkerTemplateGraphicalEditor_Warning_Separator_Empty);
			s = AbstractSmooksGraphicalModel.WARNING;
		}

		char quote = SmooksModelUtils.getFreemarkerCSVQuote((Freemarker) data);
		if (quote == 0) {
			templateGraphModel.getMessage().add(Messages.SmooksFreemarkerTemplateGraphicalEditor_Warning_Quote_Empty);
			s = AbstractSmooksGraphicalModel.WARNING;
		}

		String[] fields = SmooksModelUtils.getFreemarkerCSVFileds((Freemarker) data);
		boolean missFields = false;
		if (fields == null) {
			missFields = true;
		}

		if (s != AbstractSmooksGraphicalModel.NONE) {
			templateGraphModel.setSeverity(s);
		}

		List<AbstractSmooksGraphicalModel> csvRecordNode = templateGraphModel.getChildren();
		for (Iterator<?> iterator = csvRecordNode.iterator(); iterator.hasNext();) {
			AbstractSmooksGraphicalModel csvRecordGraphModel = (AbstractSmooksGraphicalModel) iterator.next();
			if (missFields) {
				csvRecordGraphModel.getMessage().add(Messages.SmooksFreemarkerTemplateGraphicalEditor_Warning_CSV_Fields_Empty);
				csvRecordGraphModel.setSeverity(AbstractSmooksGraphicalModel.WARNING);
			}
			List<TreeNodeConnection> collectionConnections = csvRecordGraphModel.getTargetConnections();
			if (collectionConnections.isEmpty()) {
				csvRecordGraphModel.addMessage(Messages.SmooksFreemarkerTemplateGraphicalEditor_Warning_Must_Link_to_Collection);
				csvRecordGraphModel.setSeverity(AbstractSmooksGraphicalModel.WARNING);
				List<AbstractSmooksGraphicalModel> csvFields = csvRecordGraphModel.getChildren();
				for (Iterator<?> iterator2 = csvFields.iterator(); iterator2.hasNext();) {
					AbstractSmooksGraphicalModel csvFieldsGModel = (AbstractSmooksGraphicalModel) iterator2.next();
					csvFieldsGModel
							.addMessage(Messages.SmooksFreemarkerTemplateGraphicalEditor_Warning_Must_Link_CSV_Record);
					csvFieldsGModel.setSeverity(AbstractSmooksGraphicalModel.ERROR);
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.graphical.editors.SmooksGraphicalEditorPart#
	 * getAutoLayout()
	 */
	@Override
	public IAutoLayout getAutoLayout() {
		if (autoLayout == null) {
			autoLayout = new FreemarkerAutoLayout();
		}
		return autoLayout;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.graphical.editors.SmooksGraphicalEditorPart#
	 * createActions()
	 */
	@Override
	protected void createActions() {
		super.createActions();
		FreemarkerActionCreator creator = new FreemarkerActionCreator();
		creator.registActions(getActionRegistry(), getSelectionActions(), this, this.smooksModelProvider);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.graphical.editors.SmooksGraphicalEditorPart#getID
	 * ()
	 */
	@Override
	public String getID() {
		return SmooksFreemarkerTemplateGraphicalEditor.ID;
	}
}
