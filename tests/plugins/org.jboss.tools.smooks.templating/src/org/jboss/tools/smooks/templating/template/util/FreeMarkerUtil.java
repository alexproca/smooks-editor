/*
 * JBoss, Home of Professional Open Source
 * Copyright 2006, JBoss Inc., and others contributors as indicated
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
 * (C) 2005-2006, JBoss Inc.
 */
package org.jboss.tools.smooks.templating.template.util;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jboss.tools.smooks.templating.template.ValueMapping;
import org.jboss.tools.smooks.templating.template.exception.TemplateBuilderException;
import org.milyn.javabean.decoders.DateDecoder;

/**
 * FreeMarker utility methods.
 * 
 * @author <a href="mailto:tom.fennelly@jboss.com">tom.fennelly@jboss.com</a>
 */
public class FreeMarkerUtil {

	public static String extractJavaPath(String dollarVariable) throws TemplateBuilderException {
		return splitDollarVariable(dollarVariable)[0];
	}

	public static String extractRawFormatting(String dollarVariable) throws TemplateBuilderException {
		return splitDollarVariable(dollarVariable)[1];
	}

	public static String[] splitDollarVariable(String dollarVariable) throws TemplateBuilderException {
		String[] splitTokens = new String[2];
		
		dollarVariable = dollarVariable.trim();
		
		if(isDollarVariable(dollarVariable)) {
			String withoutDollarBrace = dollarVariable.substring(2, dollarVariable.length() - 1);
			int questionMarkIdx = withoutDollarBrace.indexOf('?'); //$NON-NLS-1$
			
			if(questionMarkIdx != -1) {
				splitTokens[0] = withoutDollarBrace.substring(0, questionMarkIdx);
				splitTokens[1] = withoutDollarBrace.substring(questionMarkIdx + 1); // the raw formatting
			} else {				
				splitTokens[0] = withoutDollarBrace;
				splitTokens[1] = null; // no formatting
			}
			
			if(splitTokens[0].endsWith("!")) { //$NON-NLS-1$
				splitTokens[0] = splitTokens[0].substring(0, splitTokens[0].length() - 1);
			}
		} else {
			throw new TemplateBuilderException("Unsupported FreeMarker variable syntax '" + dollarVariable + "'."); //$NON-NLS-1$ //$NON-NLS-2$
		}
		
		return splitTokens;
	}

	public static boolean isDollarVariable(String variable) {
		return (variable.startsWith("${") && variable.endsWith("}")); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	public static String toFreeMarkerVariable(ValueMapping mapping, boolean isNodeModelSource) {
		if(isNodeModelSource) {
			return "${" + FreeMarkerUtil.toPath(mapping.getSrcPath(), true) + "}";
		} else {
			StringBuilder builder = new StringBuilder();
			Properties encodeProperties = mapping.getEncodeProperties();
			String rawFormatting;
			
			if(encodeProperties == null) {
				encodeProperties = new Properties();
			}
					
			builder.append("${" + mapping.getSrcPath() + "!?"); //$NON-NLS-1$ //$NON-NLS-2$
			
			rawFormatting = encodeProperties.getProperty(ValueMapping.RAW_FORMATING_KEY);
			if(rawFormatting != null) {
				builder.append(rawFormatting);			
				builder.append("}");			 //$NON-NLS-1$
			} else {
				Class<?> valueType = mapping.getValueType();
				if(valueType != null) {
					
					if(valueType == java.util.Date.class) {
						String format = encodeProperties.getProperty(DateDecoder.FORMAT);
						if(format != null) {					
							builder.append("string('" + format + "')}");								 //$NON-NLS-1$ //$NON-NLS-2$
						} else {
							builder.append("string.medium}");								 //$NON-NLS-1$
						}
					} else if(Number.class.isAssignableFrom(valueType)) {
						builder.append("c}");								 //$NON-NLS-1$
					} else if(valueType == Double.TYPE || valueType == Float.TYPE || valueType == Integer.TYPE || valueType == Long.TYPE || valueType == Short.TYPE) {
						builder.append("c}");								 //$NON-NLS-1$
					} else {
						builder.append("string}");			 //$NON-NLS-1$
					}
				} else {
					builder.append("string}");			 //$NON-NLS-1$
				}
			}
			
			return builder.toString();
		}
	}

	public static String toPath(String srcPath, boolean nodeModelSource) {
		if(nodeModelSource) {
			StringBuilder builder = new StringBuilder();
			
			if(srcPath.startsWith("/") && srcPath.length() > 0) {
				srcPath = srcPath.substring(1);
			}
			
			String[] tokens = srcPath.split("/");
			builder.append(".vars[\"").append(tokens[0]).append("\"]");
			if(tokens.length > 1) {
				builder.append("[\"");
				for(int i = 1; i < tokens.length; i++) {
					if(i > 1) {
						builder.append("/");
					}
					builder.append(tokens[i]);
				}
				builder.append("\"]");
			}
			
			return builder.toString();
		} else {
			return srcPath;
		}
	}
	
	private static Pattern varsSinglePattern = Pattern.compile(".vars\\[\"(.*)\"\\]");
	private static Pattern varsDoublePattern = Pattern.compile(".vars\\[\"(.*)\"\\]\\[\"(.*)\"\\]");
	public static String normalizePath(String srcPath) {
		Matcher doubleMatcher = varsDoublePattern.matcher(srcPath);
		if(doubleMatcher.matches()) {
			return doubleMatcher.group(1) + "/" + doubleMatcher.group(2);
		} else {
			Matcher singleMatcher = varsSinglePattern.matcher(srcPath);
			if(singleMatcher.matches()) {
				return singleMatcher.group(1);
			} else {
				return srcPath;
			}
		}
	}

	public static String[] toPathTokens(String srcPath) {
		Matcher matcher = varsDoublePattern.matcher(srcPath);
		if(matcher.matches()) {
			return (matcher.group(1) + "/" + matcher.group(2)).split("/");
		} else if(srcPath.indexOf("/") != -1) {
			if(srcPath.startsWith("/")) {
				return srcPath.substring(1).split("/");
			} else {
				return srcPath.split("/");
			}
		} else {
			// TODO: Old style used a dot... need to standardize all templating code to use forward slash.
			return srcPath.split(".");
		}
	}

	public static boolean isVarsFormat(String srcPath) {
		Matcher matcher = varsDoublePattern.matcher(srcPath);
		return matcher.matches();
	}
}