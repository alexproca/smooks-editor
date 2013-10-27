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
package org.jboss.tools.smooks.edimap.editor;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.jboss.tools.smooks.model.medi.MappingNode;
import org.jboss.tools.smooks.model.medi.Segment;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class EDIGraphicalTreeLabelProvider extends AdapterFactoryLabelProvider {

	public EDIGraphicalTreeLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider#getText(
	 * java.lang.Object)
	 */
	@Override
	public String getText(Object object) {
		if (object instanceof MappingNode) {
			String tagName = ((MappingNode) object).getXmltag();
			if (object instanceof Segment) {
				int min = ((Segment) object).getMinOccurs();
				int max = ((Segment) object).getMaxOccurs();
				String minString = String.valueOf(min);
				if (min < 0) {
					minString = "*"; //$NON-NLS-1$
				}

				String maxString = String.valueOf(max);
				if (max < 0) {
					maxString = "*"; //$NON-NLS-1$
				}

				return tagName + " [" + minString + ".." + maxString + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
			return tagName;
		}
		return super.getText(object);
	}

}
