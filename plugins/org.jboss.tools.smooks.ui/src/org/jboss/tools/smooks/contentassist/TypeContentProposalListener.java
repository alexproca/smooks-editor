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
package org.jboss.tools.smooks.contentassist;

import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalListener;
import org.eclipse.jface.fieldassist.IContentProposalListener2;
import org.eclipse.jface.fieldassist.IContentProposalProvider;

/**
 * @author Dart
 *
 */
public class TypeContentProposalListener implements IContentProposalListener, IContentProposalListener2 {

	/**
	 * 
	 */
	public TypeContentProposalListener() {
		// NO-OP
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.fieldassist.IContentProposalListener#proposalAccepted(org.eclipse.jface.fieldassist.IContentProposal)
	 */
	public void proposalAccepted(IContentProposal proposal) {
		// NO-OP
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.fieldassist.IContentProposalListener2#proposalPopupClosed(org.eclipse.jface.fieldassist.ContentProposalAdapter)
	 */
	public void proposalPopupClosed(ContentProposalAdapter adapter) {
		IContentProposalProvider provider = adapter.getContentProposalProvider();
		if (provider instanceof TypeContentProposalProvider) {
			// Reset state related information used for filtering existing proposals
			((TypeContentProposalProvider) provider).reset();
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.fieldassist.IContentProposalListener2#proposalPopupOpened(org.eclipse.jface.fieldassist.ContentProposalAdapter)
	 */
	public void proposalPopupOpened(ContentProposalAdapter adapter) {
		// NO-OP
	}
}
