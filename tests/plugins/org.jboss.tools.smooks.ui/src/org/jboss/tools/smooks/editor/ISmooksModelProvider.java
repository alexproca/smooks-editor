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
package org.jboss.tools.smooks.editor;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;

/**
 * @author Dart dpeng@redhat.com
 * 
 */
public interface ISmooksModelProvider extends IEditingDomainProvider {

	public EObject getSmooksModel();

	public void setSmooksModel(EObject smooksModel);

//	public SmooksGraphicsExtType getSmooksGraphicsExt();
//
//	public void setSmooksGraphicsExt(SmooksGraphicsExtType smooksGraphicsExt);
	
	public String getPlatformVersion();

	public List<Diagnostic> getDiagnosticList();

	public void setDiagnosticList(List<Diagnostic> list);
	
	public String getInputType();

}
