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
package org.jboss.tools.smooks.configuration.editors.javabean12;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class JavaBeanTableLabelProvider extends JavabeanlabelProvider implements ITableLabelProvider {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang
	 * .Object, int)
	 */
	public Image getColumnImage(Object element, int columnIndex) {
		if (element instanceof JavaBeanModel) {
			switch (columnIndex) {
			case 0:
				return getImage(element);
			}
		}
		return  getImage(element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang
	 * .Object, int)
	 */
	public String getColumnText(Object element, int columnIndex) {
		if (element instanceof JavaBeanModel) {
			JavaBeanModel beanModel = (JavaBeanModel) element;
			switch (columnIndex) {
			case 0:
				return beanModel.getName();
			case 1:
				return beanModel.getBeanClassString();
			}
		}
		return getText(element);
	}

}
