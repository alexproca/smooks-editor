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
package org.jboss.tools.smooks.configuration.editors.uitls;

import org.eclipse.jface.fieldassist.IContentProposalListener;
import org.eclipse.jface.fieldassist.IContentProposalListener2;
import org.eclipse.ui.fieldassist.ContentAssistCommandAdapter;
import org.jboss.tools.smooks.contentassist.TypeContentProposalListener;

/**
 * @author Dart (dpeng@redhat.com)
 *
 */
public class TypeFieldAssistDisposer extends FieldAssistDisposer{

	
	public TypeFieldAssistDisposer(ContentAssistCommandAdapter adapter, IContentProposalListener listener,
			IContentProposalListener2 listener2) {
		super(adapter, listener, listener2);
	}

	/**
	 * 
	 */
	public TypeFieldAssistDisposer(ContentAssistCommandAdapter adapter, TypeContentProposalListener listener) {
		super(adapter,listener,listener);
	}
}
