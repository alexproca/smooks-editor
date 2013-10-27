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

import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.eclipse.swt.widgets.Text;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class BindingsContextProposalProvider implements IContentProposalProvider {

//	private Text textControl;
//
//	private List<BindingsType> bindingsList = null;
//
//	private List<String> bindingsIDList = new ArrayList<String>();

	public BindingsContextProposalProvider(SmooksResourceListType listType, Text textControl) {
//		this.textControl = textControl;
//		bindingsList = SmooksUIUtils.getBindingsTypeList(listType);
//		if(bindingsList != null){
//			for (Iterator<?> iterator = bindingsList.iterator(); iterator.hasNext();) {
//				BindingsType bindings = (BindingsType) iterator.next();
//				String beanId = bindings.getBeanId();
//				if(beanId != null){
//					bindingsIDList.add(beanId);
//				}
//			}
//		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.fieldassist.IContentProposalProvider#getProposals(java
	 * .lang.String, int)
	 */
	public IContentProposal[] getProposals(String contents, int position) {
//		if (bindingsList == null || bindingsList.isEmpty()) {
//			return new IContentProposal[] {};
//		}
//		String content = textControl.getText(0, textControl.getCaretPosition() - 1);
//
//		ContextString currentContextString = loadContextString(content);
//
//		char dotChar = currentContextString.getEndChar();
//		int endIndex = currentContextString.getEndIndex();
//		String replaceContent = currentContextString.getContent();
//		List<IContentProposal> plist = new ArrayList<IContentProposal>();
//		if (dotChar == '.') {
//
//			BindingsType bindings = loadContextBindings(textControl.getText(0, endIndex - 1));
//			if (bindings != null) {
//				List<ValueType> valueList = bindings.getValue();
//				for (Iterator<?> iterator = valueList.iterator(); iterator.hasNext();) {
//					ValueType valueType = (ValueType) iterator.next();
//					String property = valueType.getProperty();
//					if (property != null) {
//						if (property.toLowerCase().startsWith(replaceContent.toLowerCase())) {
//							plist.add(new BindingsContextContentProposal(BindingsContextContentProposal.PROPERTIES,
//									property, position - replaceContent.length()));
//						}
//					}
//				}
//				List<WiringType> wiringList = bindings.getWiring();
//				for (Iterator<?> iterator = wiringList.iterator(); iterator.hasNext();) {
//					WiringType wiringType = (WiringType) iterator.next();
//					String property = wiringType.getProperty();
//					if (property != null) {
//						if (property.toLowerCase().startsWith(replaceContent.toLowerCase())) {
//							plist.add(new BindingsContextContentProposal(BindingsContextContentProposal.WIRTINGS,
//									property, position - replaceContent.length()));
//						}
//					}
//				}
//				
//				List<ExpressionType> expressionList = bindings.getExpression();
//				for (Iterator<?> iterator = expressionList.iterator(); iterator.hasNext();) {
//					ExpressionType wiringType = (ExpressionType) iterator.next();
//					String property = wiringType.getProperty();
//					if (property != null) {
//						if (property.toLowerCase().startsWith(replaceContent.toLowerCase())) {
//							plist.add(new BindingsContextContentProposal(BindingsContextContentProposal.EXPRESSIONS,
//									property, position - replaceContent.length()));
//						}
//					}
//				}
//			}
//		} else {
//			for (Iterator<String> iterator = bindingsIDList.iterator(); iterator.hasNext();) {
//				String id = (String) iterator.next();
//				if (id.toLowerCase().startsWith(replaceContent.toLowerCase())) {
//					plist.add(new BindingsContextContentProposal(BindingsContextContentProposal.BINDINGS, id, position
//							- replaceContent.length()));
//				}
//			}
//		}
//		return plist.toArray(new IContentProposal[] {});
		return new IContentProposal[] {};
	}

//	private BindingsType loadContextBindings(String content) {
//		ContextString cs = loadContextString(content);
//		// if (cs.endChar != '.') {
//		String name = cs.getContent();
//
//		for (Iterator<?> iterator = bindingsList.iterator(); iterator.hasNext();) {
//			BindingsType bindings = (BindingsType) iterator.next();
//			String id = bindings.getBeanId();
//			if (id != null) {
//				if (id.equalsIgnoreCase(name)) {
//					return bindings;
//				}
//			}
//		}
//		// }
//		return null;
//	}
//
//	private ContextString loadContextString(String content) {
//		char[] chars = content.toCharArray();
//		char dotChar = ' ';
//		int endIndex = 0;
//		for (int i = chars.length - 1; i > 0; i--) {
//			char c = chars[i];
//			if (c != ' ' && c != '\r' && c != '\n' && c != '\t' && Character.isLetterOrDigit(c)) {
//				continue;
//			}
//			dotChar = c;
//			endIndex = i;
//			break;
//		}
//		ContextString cs = new ContextString();
//		cs.setEndChar(dotChar);
//		if (content.length() == 0) {
//			cs.setContent(content);
//		} else {
//			cs.setContent(content.substring(endIndex + 1, content.length()));
//		}
//		if (endIndex == 0) {
//			cs.setContent(content.substring(endIndex, content.length()));
//		}
//		cs.setEndIndex(endIndex);
//		return cs;
//	}
//
//	private class ContextString {
//		char endChar = ' ';
//		String content = null;
//		int endIndex = 0;
//
//		/**
//		 * @return the endIndex
//		 */
//		public int getEndIndex() {
//			return endIndex;
//		}
//
//		/**
//		 * @param endIndex
//		 *            the endIndex to set
//		 */
//		public void setEndIndex(int endIndex) {
//			this.endIndex = endIndex;
//		}
//
//		/**
//		 * @return the endChar
//		 */
//		public char getEndChar() {
//			return endChar;
//		}
//
//		/**
//		 * @param endChar
//		 *            the endChar to set
//		 */
//		public void setEndChar(char endChar) {
//			this.endChar = endChar;
//		}
//
//		/**
//		 * @return the content
//		 */
//		public String getContent() {
//			return content;
//		}
//
//		/**
//		 * @param content
//		 *            the content to set
//		 */
//		public void setContent(String content) {
//			this.content = content;
//		}
//
//	}

}
