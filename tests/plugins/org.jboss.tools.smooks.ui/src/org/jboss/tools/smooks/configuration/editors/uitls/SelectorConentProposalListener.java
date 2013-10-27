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

import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalListener;
import org.eclipse.jface.fieldassist.IContentProposalListener2;

/**
 * @author Dart (dpeng@redhat.com)
 *
 */
public class SelectorConentProposalListener implements IContentProposalListener, IContentProposalListener2 {

	/* (non-Javadoc)
	 * @see org.eclipse.jface.fieldassist.IContentProposalListener#proposalAccepted(org.eclipse.jface.fieldassist.IContentProposal)
	 */
	public void proposalAccepted(IContentProposal proposal) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.fieldassist.IContentProposalListener2#proposalPopupClosed(org.eclipse.jface.fieldassist.ContentProposalAdapter)
	 */
	public void proposalPopupClosed(ContentProposalAdapter adapter) {

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.fieldassist.IContentProposalListener2#proposalPopupOpened(org.eclipse.jface.fieldassist.ContentProposalAdapter)
	 */
	public void proposalPopupOpened(ContentProposalAdapter adapter) {

	}

}
