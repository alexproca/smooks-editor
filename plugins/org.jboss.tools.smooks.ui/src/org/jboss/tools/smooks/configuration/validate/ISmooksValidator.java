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
package org.jboss.tools.smooks.configuration.validate;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public interface ISmooksValidator {
	
	public void initValidator(Collection<?> selectedObjects, EditingDomain editingDomain);
	
	public List<Diagnostic> validate(Collection<?> selectedObjects, EditingDomain editingDomain);
}
