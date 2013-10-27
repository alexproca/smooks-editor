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
package org.jboss.tools.smooks.editor.propertySections;

import org.eclipse.jface.viewers.IFilter;

/**
 * @author Dart
 *
 */
public class RuleBaseSectionFilter implements IFilter{

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IFilter#select(java.lang.Object)
	 */
	public boolean select(Object toTest) {
		return false;
//		if(toTest == null) return false;
//		if(toTest instanceof InputDataTreeNodeEditPart){
//			return true;
//		}
//		if(toTest instanceof InputDataContainerEditPart){
//			return true;
//		}
//		if(toTest instanceof SmooksRootEditPart){
//			return true;
//		}
//		return false;
	}

}
