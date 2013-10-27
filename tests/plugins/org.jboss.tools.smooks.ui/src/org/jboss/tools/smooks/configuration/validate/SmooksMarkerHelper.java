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

import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.util.EditUIMarkerHelper;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.actions.WorkspaceModifyDelegatingOperation;
import org.jboss.tools.smooks.configuration.SmooksConfigurationActivator;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class SmooksMarkerHelper extends EditUIMarkerHelper {

	public static final String MARKER_ID = "org.jboss.tools.smooks.ui.problem"; //$NON-NLS-1$
	
	public IRunnableWithProgress getWorkspaceModifyOperation(IRunnableWithProgress runnableWithProgress) {
		return new WorkspaceModifyDelegatingOperation(runnableWithProgress);
	}

	@Override
	protected String getMarkerID() {
		return MARKER_ID;
	}

	public void createMarkers(Resource resource, Diagnostic diagnostic) {
		try {
			createMarkers(getFile(resource), diagnostic, null);
		} catch (CoreException e) {
			SmooksConfigurationActivator.getDefault().log(e);
		}
	}

	@Override
	protected String composeMessage(Diagnostic diagnostic, Diagnostic parentDiagnostic) {
		String message = diagnostic.getMessage();
		if (parentDiagnostic != null) {
			String parentMessage = parentDiagnostic.getMessage();
			if (parentMessage != null) {
				message = message != null ? parentMessage + ". " + message : parentMessage; //$NON-NLS-1$
			}
		}
		return message;
	}

	@Override
	protected void adjustMarker(IMarker marker, Diagnostic diagnostic, Diagnostic parentDiagnostic)
			throws CoreException {
		List<?> data = diagnostic.getData();
		StringBuilder relatedURIs = new StringBuilder();
		boolean first = true;
		for (Object object : data) {
			if (object instanceof EObject) {
				EObject eObject = (EObject) object;
				if (first) {
					first = false;
					marker.setAttribute(EValidator.URI_ATTRIBUTE, EcoreUtil.getURI(eObject).toString());
				} else {
					if (relatedURIs.length() != 0) {
						relatedURIs.append(' ');
					}
					relatedURIs.append(URI.encodeFragment(EcoreUtil.getURI(eObject).toString(), false));
				}
			}
		}

		if (relatedURIs.length() > 0) {
			marker.setAttribute(EValidator.RELATED_URIS_ATTRIBUTE, relatedURIs.toString());
		}
		super.adjustMarker(marker, diagnostic, parentDiagnostic);
	}
}
