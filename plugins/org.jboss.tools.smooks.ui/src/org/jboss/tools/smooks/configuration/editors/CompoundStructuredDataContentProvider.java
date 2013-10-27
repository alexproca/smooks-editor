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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.jboss.tools.smooks.configuration.editors.wizard.IViewerInitor;
import org.jboss.tools.smooks.configuration.editors.wizard.ViewerInitorStore;

/**
 * @author Dart (dpeng@redhat.com)
 *         <p>
 *         Apr 12, 2009
 */
public class CompoundStructuredDataContentProvider implements ITreeContentProvider {

	private List<ITreeContentProvider> contentProviderList = new ArrayList<ITreeContentProvider>();

	public CompoundStructuredDataContentProvider() {
		Collection<IViewerInitor> lists = ViewerInitorStore.getInstance().getViewerInitorCollection();
		for (Iterator<IViewerInitor> iterator = lists.iterator(); iterator.hasNext();) {
			IViewerInitor viewerInitor = (IViewerInitor) iterator.next();
			contentProviderList.add(viewerInitor.getTreeContentProvider());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.
	 * Object)
	 */
	public Object[] getChildren(Object parentElement) {
		for (Iterator<?> iterator = contentProviderList.iterator(); iterator.hasNext();) {
			ITreeContentProvider provider = (ITreeContentProvider) iterator.next();
			Object[] objs = provider.getChildren(parentElement);
			if (objs == null || objs.length == 0) {
				continue;
			}
			return objs;
		}
		return new Object[] {};
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object
	 * )
	 */
	public Object getParent(Object element) {
		for (Iterator<?> iterator = contentProviderList.iterator(); iterator.hasNext();) {
			ITreeContentProvider provider = (ITreeContentProvider) iterator.next();
			Object parent = provider.getParent(element);
			if (parent == null) {
				continue;
			}
			return parent;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.
	 * Object)
	 */
	public boolean hasChildren(Object element) {
		for (Iterator<?> iterator = contentProviderList.iterator(); iterator.hasNext();) {
			ITreeContentProvider provider = (ITreeContentProvider) iterator.next();
			boolean parent = provider.hasChildren(element);
			if (!parent) {
				continue;
			}
			return parent;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java
	 * .lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		if(inputElement instanceof List<?>){
			return ((List<?>)inputElement).toArray();
		}
		for (Iterator<?> iterator = contentProviderList.iterator(); iterator.hasNext();) {
			ITreeContentProvider provider = (ITreeContentProvider) iterator.next();
			Object[] objs = provider.getElements(inputElement);
			if (objs == null || objs.length == 0) {
				continue;
			}
			return objs;
		}
		return new Object[] {};
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
		for (Iterator<?> iterator = contentProviderList.iterator(); iterator.hasNext();) {
			ITreeContentProvider provider = (ITreeContentProvider) iterator.next();
			provider.dispose();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface
	 * .viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

}
