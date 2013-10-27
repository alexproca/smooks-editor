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

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.jboss.tools.smooks.configuration.SmooksConfigurationActivator;
import org.jboss.tools.smooks.configuration.editors.GraphicsConstants;
import org.jboss.tools.smooks.model.freemarker.Freemarker;

/**
 * @author Dart
 *
 */
public class FreemarkerLabelProvider extends LabelProvider {

	private ILabelProvider parentLabelProvider = null;

	public FreemarkerLabelProvider(ILabelProvider parentLabelProvider) {
		this.parentLabelProvider = parentLabelProvider;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof Freemarker) {
			return parentLabelProvider.getText(element);
		}
		if(element instanceof CSVNodeModel){
			return ((CSVNodeModel)element).getName();
		}
		
		return super.getText(element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {
		ImageRegistry iregistry = SmooksConfigurationActivator.getDefault().getImageRegistry();
		if (element instanceof Freemarker) {
			return parentLabelProvider.getImage(element);
		}
		if(element instanceof CSVNodeModel){
			if(((CSVNodeModel)element).isRecord()){
				return iregistry.get(GraphicsConstants.IMAGE_XSL_FOREACH);
			}
			return iregistry.get(GraphicsConstants.IMAGE_JAVA_ARRAY);
		}

		return super.getImage(element);
	}

}
