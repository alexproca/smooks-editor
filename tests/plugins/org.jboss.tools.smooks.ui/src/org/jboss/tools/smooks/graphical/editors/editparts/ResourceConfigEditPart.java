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
package org.jboss.tools.smooks.graphical.editors.editparts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.jboss.tools.smooks.model.javabean12.BeanType;
import org.jboss.tools.smooks.model.javabean12.Javabean12Package;

/**
 * @author Dart
 * 
 */
public class ResourceConfigEditPart extends AbstractResourceConfigEditPart {

	public ResourceConfigEditPart() {
		super();
	}

	@Override
	protected EStructuralFeature getHostFeature(EObject model) {
		
		if(model instanceof BeanType){
			return Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__BEAN;
		}
		return null;
	}

}
