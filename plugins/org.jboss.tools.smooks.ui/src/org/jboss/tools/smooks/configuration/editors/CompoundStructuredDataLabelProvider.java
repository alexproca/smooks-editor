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

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.jboss.tools.smooks.configuration.editors.wizard.IViewerInitor;
import org.jboss.tools.smooks.configuration.editors.wizard.ViewerInitorStore;

/**
 * @author Dart (dpeng@redhat.com)<p>
 * Apr 12, 2009
 */
public class CompoundStructuredDataLabelProvider extends LabelProvider {
	private List<ILabelProvider> labelProviderList = new ArrayList<ILabelProvider>();
	
	public CompoundStructuredDataLabelProvider() {
		Collection<IViewerInitor> lists = ViewerInitorStore.getInstance().getViewerInitorCollection();
		for (Iterator<IViewerInitor> iterator = lists.iterator(); iterator.hasNext();) {
			IViewerInitor viewerInitor = (IViewerInitor) iterator.next();
			labelProviderList.add(viewerInitor.getLabelProvider());
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {
		for (Iterator<?> iterator = labelProviderList.iterator(); iterator.hasNext();) {
			ILabelProvider provider = (ILabelProvider) iterator.next();
			Image img = provider.getImage(element);
			if (img == null) {
				continue;
			}
			return img;
		}
		return super.getImage(element);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		for (Iterator<?> iterator = labelProviderList.iterator(); iterator.hasNext();) {
			ILabelProvider provider = (ILabelProvider) iterator.next();
			String text = provider.getText(element);
			if (text == null || text.length() == 0) {
				continue;
			}
			return text;
		}
		return super.getText(element);
	}
	
	
}
