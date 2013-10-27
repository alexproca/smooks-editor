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

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class Test {
	public static void main(String[] args) {
		int i = 97;
		for (i = 97; i < 122; i++) {
			char c = (char) i;
			String s = new String(new char[]{c});
			System.out.print("'"+s+"'," + "'" + s.toUpperCase() +"',"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		}
	}
}
