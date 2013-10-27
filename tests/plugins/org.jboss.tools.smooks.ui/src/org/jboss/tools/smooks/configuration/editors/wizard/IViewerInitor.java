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
 * @Date Aug 5, 2008
 */
public interface IViewerInitor {
	
	ILabelProvider getLabelProvider();

	ITreeContentProvider getTreeContentProvider();
	
	String getTypeID();
	
	IStructuredDataSelectionWizard getStructuredDataLoadWizard();
	
	String getName();
	
	String getWizardIconPath();
	
	String getDescription();
}
