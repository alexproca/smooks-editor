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
package org.jboss.tools.smooks.configuration.command;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class UnSetFeatureCommand extends AbstractCommand implements Command {

	private EObject model;

	private EStructuralFeature attribute;

	private Object oldValue;

	public UnSetFeatureCommand(EObject model, EStructuralFeature attribute) {
		super();
		this.model = model;
		this.attribute = attribute;
		this.setLabel(Messages.UnSetFeatureCommand_commandlabel + this.attribute.getName() + Messages.UnSetFeatureCommand_QuoteChar); 
	}

	public UnSetFeatureCommand(String label, String description) {
		super(label, description);
	}

	public UnSetFeatureCommand(String label) {
		super(label);
	}

	public UnSetFeatureCommand(IItemPropertyDescriptor pd, Object model) {
		this((EObject) model, (EStructuralFeature) pd.getFeature(model));
	}

	public void execute() {
		if (model != null && attribute != null) {
			oldValue = model.eGet(attribute);
			model.eUnset(attribute);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.AbstractCommand#prepare()
	 */
	@Override
	protected boolean prepare() {
		if (model != null && attribute != null)
			return true;
		return false;
	}
	
	

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.command.AbstractCommand#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return prepare() && (oldValue != null);
	}

	public void redo() {
		execute();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.AbstractCommand#undo()
	 */
	@Override
	public void undo() {
		if (model != null && attribute != null) {
			if (oldValue != null) {
				model.eSet(attribute, oldValue);
			}
		}
	}
}
