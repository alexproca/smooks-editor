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
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.fieldassist.ContentAssistCommandAdapter;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class FieldAssistDisposer {
	private ContentAssistCommandAdapter fAdapter;

	private IContentProposalListener fListener;

	private IContentProposalListener2 fListener2;

	/**
	 * 
	 */
	public FieldAssistDisposer(ContentAssistCommandAdapter adapter, IContentProposalListener listener,
			IContentProposalListener2 listener2) {
		fAdapter = adapter;
		fListener = listener;
		fListener2 = listener2;
	}

	/**
	 * 
	 */
	public void dispose() {
		if (fAdapter == null) {
			return;
		}
		// Dispose of the label provider
		ILabelProvider labelProvider = fAdapter.getLabelProvider();
		if ((labelProvider != null)) {
			fAdapter.setLabelProvider(null);
			labelProvider.dispose();
		}
		// Remove the listeners
		if (fListener != null) {
			fAdapter.removeContentProposalListener((IContentProposalListener) fListener);
			fAdapter.removeContentProposalListener((IContentProposalListener2) fListener2);
		}
	}

}
