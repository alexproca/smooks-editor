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
package org.jboss.tools.smooks10.model.smooks.util;

/**
 * @author Dart Peng
 * @Date Aug 20, 2008
 */
public class SmooksModelConstants {
	public static final String GLOBAL_PARAMETERS = "global-parameters"; //$NON-NLS-1$
	public static final String STREAM_FILTER_TYPE = "stream.filter.type"; //$NON-NLS-1$
	public static final String SAX = "SAX"; //$NON-NLS-1$
	public static final String DOM = "DOM"; //$NON-NLS-1$
	public static final String BEAN_POPULATOR = "org.milyn.javabean.BeanPopulator"; //$NON-NLS-1$
	
	public static final String[] DECODER_CLASSES = new String[] {
		"org.milyn.javabean.decoders.DateDecoder", //$NON-NLS-1$
		"org.milyn.javabean.decoders.CalendarDecoder" }; //$NON-NLS-1$
	/**
	 * @deprecated
	 */
	public static final String DATE_DECODER = "org.milyn.javabean.decoders.DateDecoder"; //$NON-NLS-1$
	
	public static final String AT_DOCUMENT = "@document"; //$NON-NLS-1$
	
	public static final String BEAN_ID = "beanId"; //$NON-NLS-1$
	
	public static final String FORMATE = "format"; //$NON-NLS-1$
	
	public static final String LOCALE_LANGUAGE = "Locale-Language"; //$NON-NLS-1$
	
	public static final String LOCALE_CONTRY = "Locale-Country"; //$NON-NLS-1$
	
	public static final String BEAN_CLASS = "beanClass"; //$NON-NLS-1$
	
	public static final String BINDINGS = "bindings"; //$NON-NLS-1$
}
