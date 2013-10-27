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
package org.jboss.tools.smooks.edimap.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.jboss.tools.smooks.configuration.editors.xml.TagObject;

/**
 * @author Dart dpeng@redhat.com
 *
 */
public class EDIMappingModel {
	private TagObject tag;
	
	private EObject mappingModel;
	
	private List<EDIMappingModel> children;

	/**
	 * @return the tag
	 */
	public TagObject getTag() {
		return tag;
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTag(TagObject tag) {
		this.tag = tag;
	}

	/**
	 * @return the mappingModel
	 */
	public EObject getMappingModel() {
		return mappingModel;
	}

	/**
	 * @param mappingModel the mappingModel to set
	 */
	public void setMappingModel(EObject mappingModel) {
		this.mappingModel = mappingModel;
	}

	/**
	 * @return the children
	 */
	public List<EDIMappingModel> getChildren() {
		if(children == null){
			children = new ArrayList<EDIMappingModel>();
		}
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<EDIMappingModel> children) {
		this.children = children;
	}
	
	public void addChild(EDIMappingModel child){
		getChildren().add(child);
	}
	
	public void removeChild(EDIMappingModel child){
		getChildren().remove(child);
	}
	
}
