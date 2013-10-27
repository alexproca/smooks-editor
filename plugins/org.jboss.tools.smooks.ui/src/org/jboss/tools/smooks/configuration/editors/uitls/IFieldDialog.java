/*******************************************************************************
 * Copyright (c) 2009 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.smooks.configuration.editors.uitls;

import org.eclipse.swt.widgets.Shell;

/**
 * @author Dart (dpeng@redhat.com)<p>
 * Apr 8, 2009
 */
public interface IFieldDialog {
	Object open(Shell shell);
	IModelProcsser getModelProcesser();
	void setModelProcesser(IModelProcsser processer);
}
