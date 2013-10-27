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

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalProvider;

/**
 * @author Dart (dpeng@redhat.com)
 *
 */
public class SetterMethodProposalProvider implements IContentProposalProvider {

	
	private Method[] settMethods = null;
	
	public SetterMethodProposalProvider(Class<?> clazz){
		settMethods = JavaPropertyUtils.getSetterMethods(clazz);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jface.fieldassist.IContentProposalProvider#getProposals(java.lang.String, int)
	 */
	public IContentProposal[] getProposals(String contents, int position) {
		if(settMethods == null || settMethods.length == 0){
			return new IContentProposal[]{};
		}

		List<IContentProposal> list = new ArrayList<IContentProposal>();
		for (int i = 0; i < settMethods.length; i++) {
			Method m = settMethods[i];
			String n = m.getName();
			if(n != null){
				if(n.toLowerCase().startsWith(contents)){
					list.add(new SetterMethodContentProposal(m));
				}
			}
		}
		return  list.toArray(new IContentProposal[]{});
	}

}
