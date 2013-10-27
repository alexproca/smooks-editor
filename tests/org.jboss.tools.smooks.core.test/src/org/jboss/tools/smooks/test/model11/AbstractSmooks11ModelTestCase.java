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
package org.jboss.tools.smooks.test.model11;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.jboss.tools.smooks.model.common.provider.CommonItemProviderAdapterFactory;
import org.jboss.tools.smooks.model.freemarker.provider.FreemarkerItemProviderAdapterFactory;
import org.jboss.tools.smooks.model.medi.DocumentRoot;
import org.jboss.tools.smooks.model.medi.MappingNode;
import org.jboss.tools.smooks.model.medi.provider.MEdiItemProviderAdapterFactory;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;
import org.jboss.tools.smooks.model.smooks.provider.SmooksItemProviderAdapterFactory;
import org.jboss.tools.smooks.model.smooks.util.SmooksResourceFactoryImpl;

/**
 * 
 * @author Dart (dpeng@redhat.com)
 * 
 */
public abstract class AbstractSmooks11ModelTestCase extends BaseTestCase {

	protected ComposedAdapterFactory adapterFactory;
	protected AdapterFactoryEditingDomain editingDomain;
	protected EObject smooksModel;

	public void testModel() {
		// do nothing
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		// init emf editingdomain
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new FreemarkerItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new CommonItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new SmooksItemProviderAdapterFactory());


		adapterFactory.addAdapterFactory(new MEdiItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		BasicCommandStack commandStack = new BasicCommandStack();
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<Resource, Boolean>());

		loadConfigFile();
	}

	protected void loadConfigFile() throws IOException {
		Resource smooksResource = new SmooksResourceFactoryImpl().createResource(null);
		smooksResource.load(getConfigFileContents(), Collections.emptyMap());
		smooksModel = smooksResource.getContents().get(0);
		editingDomain.getResourceSet().getResources().add(smooksResource);
	}

	protected InputStream getConfigFileContents() {
		return this.getClass().getClassLoader().getResourceAsStream(getFilePath());
	}

	abstract protected String getFilePath();

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public ComposedAdapterFactory getAdapterFactory() {
		return adapterFactory;
	}

	public void setAdapterFactory(ComposedAdapterFactory adapterFactory) {
		this.adapterFactory = adapterFactory;
	}

	public AdapterFactoryEditingDomain getEditingDomain() {
		return editingDomain;
	}

	public void setEditingDomain(AdapterFactoryEditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	public EObject getSmooksModel() {
		return smooksModel;
	}

	public void setSmooksModel(EObject smooksModel) {
		this.smooksModel = smooksModel;
	}
	
	public MappingNode getMappingNode10(){
		EObject root = this.getSmooksModel();
		if (root instanceof DocumentRoot) {
			DocumentRoot documentRoot = (DocumentRoot) root;
			MappingNode mapping = (MappingNode) documentRoot.eContents().get(0);
			return mapping;
		}
		return null;
	}

	public SmooksResourceListType getSmooksResourceList11() {
		EObject root = this.getSmooksModel();
		if (root instanceof org.jboss.tools.smooks.model.smooks.DocumentRoot) {
			org.jboss.tools.smooks.model.smooks.DocumentRoot documentRoot = (org.jboss.tools.smooks.model.smooks.DocumentRoot) root;
			SmooksResourceListType resourceConfig = (SmooksResourceListType) documentRoot.eContents().get(0);
			return resourceConfig;
		}
		return null;
	}
	
//	public org.jboss.tools.smooks10.model.smooks.SmooksResourceListType getSmooksResourceList10() {
//		EObject root = this.getSmooksModel();
//		if (root instanceof org.jboss.tools.smooks10.model.smooks.DocumentRoot) {
//			org.jboss.tools.smooks10.model.smooks.DocumentRoot documentRoot = (org.jboss.tools.smooks10.model.smooks.DocumentRoot) root;
//			org.jboss.tools.smooks10.model.smooks.SmooksResourceListType resourceConfig = (org.jboss.tools.smooks10.model.smooks.SmooksResourceListType) documentRoot.eContents().get(0);
//			return resourceConfig;
//		}
//		return null;
//	}

}
