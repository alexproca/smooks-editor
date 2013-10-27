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
package org.jboss.tools.smooks.configuration.editors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.Viewer;
import org.jboss.tools.smooks.model.smooks.AbstractReader;

/**
 * @author Dart
 * 
 */
public class OnlyReaderViewerFilter extends TextEObjectModelFilter {

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		Object obj = element;
		obj = AdapterFactoryEditingDomain.unwrap(obj);
		if (obj instanceof AbstractReader) {
			return true;
		} else {
			if (obj instanceof EObject) {
				EObject parent = (EObject) obj;
				while (parent != null && !(parent instanceof AbstractReader)) {
					parent = parent.eContainer();
					if (parent instanceof AbstractReader) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
