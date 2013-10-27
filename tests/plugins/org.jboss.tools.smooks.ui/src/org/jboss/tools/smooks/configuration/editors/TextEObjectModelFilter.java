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

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.BasicFeatureMapEntry;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

/**
 * @author Dart
 *
 */
public class TextEObjectModelFilter  extends ViewerFilter {
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		Object obj = element;
		obj = AdapterFactoryEditingDomain.unwrap(obj);
		if (obj instanceof BasicFeatureMapEntry) {
			EStructuralFeature sf = ((BasicFeatureMapEntry) obj).getEStructuralFeature();
			if (sf.equals(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT)
					|| sf.equals(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__CDATA)) {
				return false;
			}
		} else {
			if (obj.getClass() == String.class) {
				return false;
			}
		}
		return true;
	}

}
