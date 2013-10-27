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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject;
import org.jboss.tools.smooks.configuration.editors.SelectorCreationDialog;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class SelectorContentProposalProvider implements IContentProposalProvider {

	// private SmooksGraphicsExtType extType;

	private SmooksResourceListType resourceList;

	public SelectorContentProposalProvider(SmooksResourceListType resourceList) {
		this.resourceList = resourceList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.fieldassist.IContentProposalProvider#getProposals(java
	 * .lang.String, int)
	 */
	public IContentProposal[] getProposals(String contents, int position) {
		List<Object> list = SelectorCreationDialog.generateInputData(resourceList);
		if (list == null || list.isEmpty()) {
			return new IContentProposal[] {};
		}
		List<IContentProposal> contentList = new ArrayList<IContentProposal>();
		List<IXMLStructuredObject> models = new ArrayList<IXMLStructuredObject>();

		IXMLStructuredObject currentNode = null;
		int index = contents.lastIndexOf('/');
		String path = contents;

		for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			if (object instanceof IXMLStructuredObject) {
				try {
					IXMLStructuredObject result = SmooksUIUtils.localXMLNodeWithPath(path,
							(IXMLStructuredObject) object);
					if (result != null) {
						currentNode = result;
						break;
					}
				} catch (Throwable t) {
					continue;
				}
			}
		}
		if (currentNode == null && index != -1) {
			if (index != -1) {
				path = contents.substring(0, index);
			}

			for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
				Object object = (Object) iterator.next();
				if (object instanceof IXMLStructuredObject) {
					try {
						IXMLStructuredObject result = SmooksUIUtils.localXMLNodeWithPath(path,
								(IXMLStructuredObject) object);
						if (result != null) {
							currentNode = result;
							break;
						}
					} catch (Throwable t) {
						continue;
					}
				}
			}
		}

		if (currentNode == null) {
			// SmooksUIUtils.g
			for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
				Object object = (Object) iterator.next();
				if (object instanceof IXMLStructuredObject) {
					models.add((IXMLStructuredObject) object);
				}
			}
		} else {
			models.add(currentNode);
		}

		List<IXMLStructuredObject> loadedModels = SmooksUIUtils.loadSelectorObject(models);
		for (Iterator<?> iterator = loadedModels.iterator(); iterator.hasNext();) {
			IXMLStructuredObject structuredObject = (IXMLStructuredObject) iterator.next();
			String fp = SmooksUIUtils.generateFullPath(structuredObject, "/"); //$NON-NLS-1$
			if (fp == null)
				continue;
			fp = fp.trim();
			if (fp.length() == 0)
				continue;
			if (currentNode != null) {
				String p = SmooksUIUtils.generatePath(structuredObject, currentNode, "/", true); //$NON-NLS-1$
				if (p.startsWith(contents) || p.startsWith("/" + contents) || fp.startsWith(contents) //$NON-NLS-1$
						|| fp.startsWith(Messages.SelectorContentProposalProvider_3 + contents)) {
					SelectorContentProposal p1 = new SelectorContentProposal(structuredObject);
					contentList.add(p1);
				}
			} else {
				if (fp.startsWith(contents) || fp.startsWith("/" + contents)) { //$NON-NLS-1$
					SelectorContentProposal p1 = new SelectorContentProposal(structuredObject);
					contentList.add(p1);
				}
			}
		}
		return contentList.toArray(new IContentProposal[] {});
	}
}
