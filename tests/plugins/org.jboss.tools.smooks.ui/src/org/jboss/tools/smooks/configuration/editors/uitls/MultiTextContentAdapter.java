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

import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class MultiTextContentAdapter extends TextContentAdapter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.fieldassist.TextContentAdapter#getControlContents(org
	 * .eclipse.swt.widgets.Control)
	 */
	@Override
	public String getControlContents(Control control) {
		// TODO Auto-generated method stub
		return super.getControlContents(control);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.fieldassist.TextContentAdapter#getCursorPosition(org
	 * .eclipse.swt.widgets.Control)
	 */
	@Override
	public int getCursorPosition(Control control) {
		// TODO Auto-generated method stub
		return super.getCursorPosition(control);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.fieldassist.TextContentAdapter#getInsertionBounds(org
	 * .eclipse.swt.widgets.Control)
	 */
	@Override
	public Rectangle getInsertionBounds(Control control) {
		// TODO Auto-generated method stub
		Rectangle re = super.getInsertionBounds(control);
		return re;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.fieldassist.TextContentAdapter#getSelection(org.eclipse
	 * .swt.widgets.Control)
	 */
	@Override
	public Point getSelection(Control control) {
		// TODO Auto-generated method stub
		return super.getSelection(control);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.fieldassist.TextContentAdapter#insertControlContents
	 * (org.eclipse.swt.widgets.Control, java.lang.String, int)
	 */
	@Override
	public void insertControlContents(Control control, String text, int cursorPosition) {
		Text te = (Text) control;
		int caretPosition = te.getCaretPosition() - 1;
		if (caretPosition < 0) {
			caretPosition = 0;
		}
		String content = te.getText(0, caretPosition);
		char[] chars = content.toCharArray();
		int endIndex = 0;
		for (int i = chars.length - 1; i > 0; i--) {
			char c = chars[i];
			if (c != ' ' && c != '\r' && c != '\n' && c != '\t' && Character.isLetterOrDigit(c)) {
				continue;
			}
			endIndex = i;
			break;
		}
		if (content.length() == 0) {
		} else {
			content = content.substring(endIndex + 1, content.length());
		}
		String all = te.getText();
		String first=""; //$NON-NLS-1$
		if(all.length() != 0){
			first = all.substring(0, endIndex + 1);
		}
		if (endIndex == 0) {
			first = ""; //$NON-NLS-1$
		}
		String second  = ""; //$NON-NLS-1$
		if(all.length() != 0){
			second = all.substring(endIndex + 1 + content.length(), all.length());
		}
		if (all.length() == 1) {
			second = ""; //$NON-NLS-1$
		}
		all = first + text + second;
		te.setText(all);
		((Text) control).setSelection(cursorPosition, cursorPosition);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.fieldassist.TextContentAdapter#setControlContents(org
	 * .eclipse.swt.widgets.Control, java.lang.String, int)
	 */
	@Override
	public void setControlContents(Control control, String text, int cursorPosition) {
		super.setControlContents(control, text, cursorPosition);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.fieldassist.TextContentAdapter#setCursorPosition(org
	 * .eclipse.swt.widgets.Control, int)
	 */
	@Override
	public void setCursorPosition(Control control, int position) {
		// TODO Auto-generated method stub
		super.setCursorPosition(control, position);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.fieldassist.TextContentAdapter#setSelection(org.eclipse
	 * .swt.widgets.Control, org.eclipse.swt.graphics.Point)
	 */
	@Override
	public void setSelection(Control control, Point range) {
		// TODO Auto-generated method stub
		super.setSelection(control, range);
	}
}
