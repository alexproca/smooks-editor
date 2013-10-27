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
package org.jboss.tools.smooks.configuration.editors;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IDetailsPageProvider;

/**
 * @author Dart (dpeng@redhat.com)
 *         <p>
 *         Apr 7, 2009
 */
public class SmooksStuffDetailsPageProvider implements IDetailsPageProvider {
	private Map<Object, IDetailsPage> pages = new HashMap<Object, IDetailsPage>();

	public void registePage(Object key , IDetailsPage page){
		pages.put(key, page);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.IDetailsPageProvider#getPage(java.lang.Object)
	 */
	public IDetailsPage getPage(Object key) {
		return pages.get(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.forms.IDetailsPageProvider#getPageKey(java.lang.Object)
	 */
	public Object getPageKey(Object object) {
		if(object instanceof EObject){
			return EObject.class;
		}
		return object.getClass();
	}

}
