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
package org.jboss.tools.smooks.configuration.editors.xml;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.jboss.tools.smooks.configuration.SmooksConfigurationActivator;
import org.jboss.tools.smooks.configuration.editors.GraphicsConstants;

/**
 * @author Dart Peng
 * @Date Aug 18, 2008
 */
public class XMLStructuredDataLabelProvider extends LabelProvider {

	public Image getXmlElementImage() {
		return SmooksConfigurationActivator.getDefault().getImageRegistry().get(
				GraphicsConstants.IMAGE_XML_ELEMENT);

	}

	public Image getXmlAttributeImage() {
		return SmooksConfigurationActivator.getDefault().getImageRegistry().get(
				GraphicsConstants.IMAGE_XML_ATTRIBUTE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof TagObject) {
			return getXmlElementImage();
		}
		if (element instanceof TagPropertyObject) {
			return getXmlAttributeImage();
		}
		return super.getImage(element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof TagList) {
			return "Root"; //$NON-NLS-1$
		}
		if (element instanceof AbstractXMLObject) {
			return ((AbstractXMLObject) element).getName();
		}
		return ""; //$NON-NLS-1$
	}

}
