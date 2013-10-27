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
package org.jboss.tools.smooks.configuration.editors.wizard;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;

/**
 * @author Dart Peng
 * @Date Aug 6, 2008
 */
public class BaseViewerInitor implements IViewerInitor {
	protected String typeID = null;
	protected String name = "nonamed"; //$NON-NLS-1$
	protected String wizardIconPath = null;
	protected String description;
	protected ITreeContentProvider treeContentProvider;
	protected IStructuredDataSelectionWizard structuredDataLoadWizard;
	protected ILabelProvider labelProvider;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the typeID
	 */
	public String getTypeID() {
		return typeID;
	}

	/**
	 * @param typeID
	 *            the typeID to set
	 */
	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}


	/**
	 * @return the wizardIconPath
	 */
	public String getWizardIconPath() {
		return wizardIconPath;
	}

	/**
	 * @param wizardIconPath
	 *            the wizardIconPath to set
	 */
	public void setWizardIconPath(String wizardIconPath) {
		this.wizardIconPath = wizardIconPath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the treeContentProvider
	 */
	public ITreeContentProvider getTreeContentProvider() {
		return treeContentProvider;
	}

	/**
	 * @param treeContentProvider the treeContentProvider to set
	 */
	public void setTreeContentProvider(ITreeContentProvider treeContentProvider) {
		this.treeContentProvider = treeContentProvider;
	}

	/**
	 * @return the structuredDataLoadWizard
	 */
	public IStructuredDataSelectionWizard getStructuredDataLoadWizard() {
		return structuredDataLoadWizard;
	}

	/**
	 * @param structuredDataLoadWizard the structuredDataLoadWizard to set
	 */
	public void setStructuredDataLoadWizard(IStructuredDataSelectionWizard structuredDataLoadWizard) {
		this.structuredDataLoadWizard = structuredDataLoadWizard;
	}

	/**
	 * @return the labelProvider
	 */
	public ILabelProvider getLabelProvider() {
		return labelProvider;
	}

	/**
	 * @param labelProvider the labelProvider to set
	 */
	public void setLabelProvider(ILabelProvider labelProvider) {
		this.labelProvider = labelProvider;
	}
	
	
}
