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
package org.jboss.tools.smooks.graphical.editors;

import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.IMessage;

/**
 * @author Dart
 *
 */
public class SmooksMessage implements IMessage {

	private int messageType;
	
	private Control control;
	
	private Object data;
	
	private Object key;
	
	private String prefix = "-"; //$NON-NLS-1$
	
	private String message;
	
	public SmooksMessage(int messageType , String message){
		this.setMessage(message);
		this.setMessageType(messageType);
	}

	/**
	 * @return the messageType
	 */
	public int getMessageType() {
		return messageType;
	}

	/**
	 * @param messageType the messageType to set
	 */
	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}

	/**
	 * @return the control
	 */
	public Control getControl() {
		return control;
	}

	/**
	 * @param control the control to set
	 */
	public void setControl(Control control) {
		this.control = control;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @return the key
	 */
	public Object getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(Object key) {
		this.key = key;
	}

	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
