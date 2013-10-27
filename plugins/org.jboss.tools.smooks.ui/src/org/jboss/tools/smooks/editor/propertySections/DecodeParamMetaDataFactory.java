/**
 * JBoss, Home of Professional Open Source
 * Copyright 2009, JBoss Inc., and others contributors as indicated
 * by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 *
 * (C) 2009, JBoss Inc.
 */
package org.jboss.tools.smooks.editor.propertySections;

import java.util.HashMap;
import java.util.Map;

import org.milyn.javabean.DataDecoder;
import org.milyn.javabean.decoders.CalendarDecoder;
import org.milyn.javabean.decoders.DateDecoder;
import org.milyn.javabean.decoders.LocaleAwareDateDecoder;
import org.milyn.javabean.decoders.SqlDateDecoder;
import org.milyn.javabean.decoders.SqlTimeDecoder;

/**
 * Factory class for storing decode parameter metadata..
 *
 * @author <a href="mailto:tom.fennelly@jboss.com">tom.fennelly@jboss.com</a>
 */
public class DecodeParamMetaDataFactory {

	private static Map<Class<? extends DataDecoder>, DecodeParamMetaData[]> configMap = new HashMap<Class<? extends DataDecoder>, DecodeParamMetaData[]>();
	
	static {
		DecodeParamMetaData[] dateDecodeMD = new DecodeParamMetaData[] {
				new DecodeParamMetaData(LocaleAwareDateDecoder.FORMAT, LocaleAwareDateDecoder.DEFAULT_DATE_FORMAT),
				new DecodeParamMetaData(LocaleAwareDateDecoder.LOCALE_COUNTRY_CODE, null),
				new DecodeParamMetaData(LocaleAwareDateDecoder.LOCALE_LANGUAGE_CODE, null)
				};

		// The date decoders all have the same basic configuration...
		configMap.put(DateDecoder.class, dateDecodeMD);
		configMap.put(CalendarDecoder.class, dateDecodeMD);
		configMap.put(SqlDateDecoder.class, dateDecodeMD);
		configMap.put(SqlTimeDecoder.class, dateDecodeMD);
	}
	
	public static DecodeParamMetaData[] getDecodeParamMetaData(Class<? extends DataDecoder> decoder) {
		return configMap.get(decoder);
	}
}
