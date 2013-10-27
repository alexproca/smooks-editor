/*******************************************************************************
 * Copyright (c) 2009 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.smooks.templating.template.freemarker;

import org.jboss.tools.smooks.templating.model.ModelBuilder;
import org.jboss.tools.smooks.templating.model.ModelBuilderException;
import org.jboss.tools.smooks.templating.template.CollectionMapping;
import org.jboss.tools.smooks.templating.template.Mapping;
import org.jboss.tools.smooks.templating.template.TemplateBuilder;
import org.jboss.tools.smooks.templating.template.ValueMapping;
import org.jboss.tools.smooks.templating.template.exception.InvalidMappingException;
import org.jboss.tools.smooks.templating.template.result.AddCollectionResult;
import org.jboss.tools.smooks.templating.template.util.FreeMarkerUtil;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Abstract FreeMarker template builder.
 * @author <a href="mailto:tom.fennelly@gmail.com">tom.fennelly@gmail.com</a>
 */
public abstract class FreeMarkerTemplateBuilder extends TemplateBuilder {

	private boolean nodeModelSource = false;
	
	public FreeMarkerTemplateBuilder(ModelBuilder modelBuilder) throws ModelBuilderException {
		super(modelBuilder);
	}

	public boolean isNodeModelSource() {
		return nodeModelSource;
	}

	public void setNodeModelSource(boolean nodeModelSource) {
		this.nodeModelSource = nodeModelSource;
	}

	@Override
	public ValueMapping addValueMapping(String srcPath, Node modelPath) throws InvalidMappingException {
		return super.addValueMapping(FreeMarkerUtil.normalizePath(srcPath), modelPath);
	}

	@Override
	public AddCollectionResult addCollectionMapping(String srcCollectionPath, Element modelCollectionPath, String collectionItemName) throws InvalidMappingException {
		return super.addCollectionMapping(FreeMarkerUtil.normalizePath(srcCollectionPath), modelCollectionPath, collectionItemName);
	}
	
	protected String[] parseSourcePath(Mapping mapping) {
		return FreeMarkerUtil.toPathTokens(mapping.getSrcPath());
	}	
}
