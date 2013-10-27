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

import org.jboss.tools.smooks.configuration.editors.SmooksConfigFileHandle;
import org.jboss.tools.smooks.model.medi.MEdiPackage;

/**
 * @author Dart dpeng@redhat.com
 * 
 */
public class EDIMapFileHandle extends SmooksConfigFileHandle {

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.SmooksConfigFileHandle#
	 * createSupportURI()
	 */
	@Override
	protected String[] createSupportURI() {
		return new String[] { MEdiPackage.eNS_URI };
	}

}
