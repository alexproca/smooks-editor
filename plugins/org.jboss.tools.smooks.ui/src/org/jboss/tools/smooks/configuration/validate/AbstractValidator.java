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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public abstract class AbstractValidator implements ISmooksValidator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.configuration.validate.ISmooksValidator#validate
	 * (java.util.Collection, org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public List<Diagnostic> validate(Collection<?> selectedObjects, EditingDomain editingDomain) {
		preStartValidation();
		List<Diagnostic> list = new ArrayList<Diagnostic>();
		try {
			for (Iterator<?> iterator = selectedObjects.iterator(); iterator.hasNext();) {
				Object object = (Object) iterator.next();
				Diagnostic d = validateModel(object, editingDomain);
				if (d != null) {
					list.add(d);
				}
				if (object instanceof EObject) {
					List<Diagnostic> dd = validate(((EObject) object).eContents(), editingDomain);
					if (dd != null) {
						list.addAll(dd);
					}
				}
			}
		} catch (Throwable t) {

		}
		return list;
	}

	protected void preStartValidation() {

	}

	protected Diagnostic newDiagnostic(int severity, String message, Object model, EAttribute property) {
		return new BasicDiagnostic(severity, "org.jboss.tools", 0, message, new Object[] { model, property }); //$NON-NLS-1$
	}

	protected Diagnostic newWaringDiagnostic(String message, Object model, EAttribute property) {
		return newDiagnostic(Diagnostic.WARNING, message, model, property);
	}

	protected Diagnostic newErrorDiagnostic(String message, Object model, EAttribute property) {
		return newDiagnostic(Diagnostic.ERROR, message, model, property);
	}

	protected Diagnostic validateModel(Object model, EditingDomain editingDomain) {
		return null;
	}

}
