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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;

/**
 * @author Dart (dpeng@redhat.com)
 *
 */
public class BeanIdRefProposalProvider implements IContentProposalProvider {

	private EObject model;
	
	public BeanIdRefProposalProvider(EObject model){
		this.model = model;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jface.fieldassist.IContentProposalProvider#getProposals(java.lang.String, int)
	 */
	public IContentProposal[] getProposals(String contents, int position) {
		List<IContentProposal> proposalList = new ArrayList<IContentProposal>();
		SmooksResourceListType listType = getSmooksResourceList(model);
		if(listType != null){
			List<String> idList = SmooksUIUtils.getBeanIdStringList(listType);
			
			for (Iterator<String> iterator = idList.iterator(); iterator.hasNext();) {
				String id = (String) iterator.next();
				if(id.toLowerCase().startsWith(contents.toLowerCase())){
					proposalList.add(new BeanIDRefContentProposal(id));
				}
			}
			
			return proposalList.toArray(new IContentProposal[]{});
		}
		
		return new IContentProposal[]{};
	}
	
	protected SmooksResourceListType getSmooksResourceList(EObject model) {
		EObject parent = model.eContainer();
		while (parent != null && !(parent instanceof SmooksResourceListType)) {
			parent = parent.eContainer();
		}
		if (parent instanceof SmooksResourceListType) {
			return (SmooksResourceListType) parent;
		}
		return null;
	}
	
	private class BeanIDRefContentProposal implements IContentProposal{

		private String id;
		
		public BeanIDRefContentProposal(String id){
			this.id = id;
		}
		/* (non-Javadoc)
		 * @see org.eclipse.jface.fieldassist.IContentProposal#getContent()
		 */
		public String getContent() {
			// TODO Auto-generated method stub
			return id;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.fieldassist.IContentProposal#getCursorPosition()
		 */
		public int getCursorPosition() {
			if(id != null){
				return id.length();
			}
			return 0;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.fieldassist.IContentProposal#getDescription()
		 */
		public String getDescription() {
			return null;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.fieldassist.IContentProposal#getLabel()
		 */
		public String getLabel() {
			return id;
		}
		
	}

}
