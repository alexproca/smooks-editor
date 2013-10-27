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

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension3;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension5;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

/**
 * @author Dart
 *
 */
public class TypeCompletionProposal implements ICompletionProposal, ICompletionProposalExtension3, ICompletionProposalExtension5 {

	protected String fReplacementString;
	protected Image fImage;
	protected String fDisplayString;
	protected int fBeginInsertPoint;
	protected int fLength;
	protected String fAdditionalInfo;
//	private IInformationControlCreator fCreator;

	public TypeCompletionProposal(String replacementString, Image image, String displayString) {
		this(replacementString, image, displayString, 0, 0);
	}

	public TypeCompletionProposal(String replacementString, Image image, String displayString, int startOffset, int length) {
		Assert.isNotNull(replacementString);

		fReplacementString = replacementString;
		fImage = image;
		fDisplayString = displayString;
		fBeginInsertPoint = startOffset;
		fLength = length;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#apply(org.eclipse.jface.text.IDocument)
	 */
	public void apply(IDocument document) {
		if (fLength == -1) {
			fLength = document.getLength();
		}
		try {
			document.replace(fBeginInsertPoint, fLength, fReplacementString);
		} catch (BadLocationException e) {
			// DEBUG
			// e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getAdditionalProposalInfo()
	 */
	public String getAdditionalProposalInfo() {
		// No additional proposal information
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getContextInformation()
	 */
	public IContextInformation getContextInformation() {
		// No context information
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getDisplayString()
	 */
	public String getDisplayString() {
		return fDisplayString;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getImage()
	 */
	public Image getImage() {
		return fImage;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getSelection(org.eclipse.jface.text.IDocument)
	 */
	public Point getSelection(IDocument document) {
		if (fReplacementString.equals("\"\"")) //$NON-NLS-1$
			return new Point(fBeginInsertPoint + 1, 0);
		return new Point(fBeginInsertPoint + fReplacementString.length(), 0);
	}

	public String getReplacementString() {
		return fReplacementString;
	}

	public Object getAdditionalProposalInfo(IProgressMonitor monitor) {
		return fAdditionalInfo;
	}

	public void setAdditionalProposalInfo(String info) {
		fAdditionalInfo = info;
	}

	public IInformationControlCreator getInformationControlCreator() {
//		if (!BrowserInformationControl.isAvailable(null))
//			return null;
//
//		if (fCreator == null) {
//			fCreator = new AbstractReusableInformationControlCreator() {
//
//				/*
//				 * @see org.eclipse.jdt.internal.ui.text.java.hover.AbstractReusableInformationControlCreator#doCreateInformationControl(org.eclipse.swt.widgets.Shell)
//				 */
//				public IInformationControl doCreateInformationControl(Shell parent) {
//					return new BrowserInformationControl(parent, SWT.NO_TRIM | SWT.TOOL, SWT.NONE, EditorsUI.getTooltipAffordanceString());
//				}
//			};
//		}
//		return fCreator;
		return null;
	}

	public int getPrefixCompletionStart(IDocument document, int completionOffset) {
		return fBeginInsertPoint;
	}

	public CharSequence getPrefixCompletionText(IDocument document, int completionOffset) {
		return fReplacementString;
	}

}