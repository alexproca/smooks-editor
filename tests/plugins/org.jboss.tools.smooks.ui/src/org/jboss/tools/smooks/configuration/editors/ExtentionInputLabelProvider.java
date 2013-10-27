/*******************************************************************************
 * Copyright (c) 2009 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.smooks.configuration.editors;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.configuration.SmooksConfigurationActivator;
import org.jboss.tools.smooks.configuration.editors.input.InputParameter;
import org.jboss.tools.smooks.configuration.editors.input.InputType;

/**
 * @author Dart (dpeng@redhat.com)
 *         <p>
 *         Apr 12, 2009
 */
public class ExtentionInputLabelProvider extends LabelProvider implements ITableLabelProvider {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang
	 * .Object, int)
	 */
	public Image getColumnImage(Object element, int columnIndex) {
		if (element instanceof InputType) {
			String type = ((InputType) element).getType();
			switch (columnIndex) {
			case 0:
				if (SmooksModelUtils.INPUT_TYPE_JAVA.equals(type)) {
					return SmooksConfigurationActivator.getDefault().getImageRegistry().get(
							GraphicsConstants.IMAGE_JAVA_FILE);
				}
				if (SmooksModelUtils.INPUT_TYPE_XML.equals(type)) {
					return SmooksConfigurationActivator.getDefault().getImageRegistry().get(
							GraphicsConstants.IMAGE_XML_FILE);
				}
				if (SmooksModelUtils.INPUT_TYPE_XSD.equals(type)) {
					return SmooksConfigurationActivator.getDefault().getImageRegistry().get(
							GraphicsConstants.IMAGE_XSD_FILE);
				}
				return SmooksConfigurationActivator.getDefault().getImageRegistry().get(
						GraphicsConstants.IMAGE_UNKNOWN_OBJ);
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang
	 * .Object, int)
	 */
	public String getColumnText(Object element, int columnIndex) {
		if (element instanceof InputType) {
			String value = ((InputType) element).getPath();
			if (value == null)
				value = ""; //$NON-NLS-1$
			String extValue = ""; //$NON-NLS-1$
			List<InputParameter> paramers = ((InputType) element).getParameters();
			for (Iterator<?> iterator = paramers.iterator(); iterator.hasNext();) {
				InputParameter paramType = (InputParameter) iterator.next();
//				if ("path".equalsIgnoreCase(paramType.getName())) {
//					continue;
//				}
				extValue += paramType.getName() + "=" + paramType.getValue() + ","; //$NON-NLS-1$ //$NON-NLS-2$
			}
			if (extValue.length() != 0) {
				extValue = extValue.substring(0, extValue.length() - 1);
			}
			switch (columnIndex) {
			case 0:
				return ((InputType) element).getType();
			case 1:
				return value;
			case 2:
				return extValue;
			}
		}
		return ""; //$NON-NLS-1$
	}
}
