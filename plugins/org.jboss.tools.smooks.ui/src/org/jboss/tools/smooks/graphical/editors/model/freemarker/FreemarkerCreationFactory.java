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
package org.jboss.tools.smooks.graphical.editors.model.freemarker;

import org.eclipse.gef.requests.CreationFactory;

/**
 * @author Dart
 *
 */
public class FreemarkerCreationFactory implements CreationFactory{
	private Object type;
	
	private Object model;
	
	public static final String CSV_RECORD = "record"; //$NON-NLS-1$
	
	public static final String CSV_FIELD = "field"; //$NON-NLS-1$
	
	public FreemarkerCreationFactory(Object type , Object model){
		this.setType(type);
		this.setModel(model);
	}
	
	public static FreemarkerCreationFactory newCSVRecordFactory(){
		CSVNodeModel recordModel = new CSVNodeModel();
		recordModel.setName("record"); //$NON-NLS-1$
		recordModel.setSperator(',');
		recordModel.setQuto('\"');
		return new FreemarkerCreationFactory(CSV_RECORD, recordModel);
	}
	
	public static FreemarkerCreationFactory newCSVFieldFactory(){
		CSVNodeModel fieldModel = new CSVNodeModel();
		fieldModel.setName("field"); //$NON-NLS-1$
		return new FreemarkerCreationFactory(CSV_FIELD, fieldModel);
	}

	/**
	 * @return the type
	 */
	public Object getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Object type) {
		this.type = type;
	}

	/**
	 * @return the model
	 */
	public Object getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(Object model) {
		this.model = model;
	}

	public Object getNewObject() {
		return model;
	}

	public Object getObjectType() {
		return type;
	}
	
	
}
