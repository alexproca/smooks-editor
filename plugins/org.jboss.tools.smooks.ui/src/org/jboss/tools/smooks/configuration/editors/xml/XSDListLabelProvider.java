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
import org.eclipse.xsd.XSDElementDeclaration;

/**
 * @author Dart
 *
 */
public class XSDListLabelProvider extends LabelProvider {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof XSDElementDeclaration) {
			return ((XSDElementDeclaration) element).getAliasName();
		}
		if(element instanceof String) return (String)element;
		return super.getText(element);
	}

}
