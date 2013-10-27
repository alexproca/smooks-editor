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
package org.jboss.tools.smooks.graphical.wizard.freemarker;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.wizard.Wizard;

/**
 * @author Dart
 *
 */
public abstract class AbstractFreemarkerTemplateWizard extends Wizard implements FreemarkerTemplateParametersProvider {
	
	protected Map<String , String> parametersMap = null ;

	public Map<String, String> getParameters() {
		if(parametersMap == null){
			parametersMap =  new HashMap<String, String>();
		}
		return parametersMap;
	}
	
	protected void addParamter(String key , String value){
		if(key == null || value == null){
			return;
		}
		getParameters().put(key, value);
	}

}
