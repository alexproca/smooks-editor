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
package org.jboss.tools.smooks.configuration.editors.xml;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.ExtensibilityElement;
import org.eclipse.wst.wsdl.Types;
import org.eclipse.wst.wsdl.WSDLFactory;
import org.eclipse.wst.wsdl.XSDSchemaExtensibilityElement;
import org.eclipse.wst.wsdl.util.WSDLParser;
import org.eclipse.wst.wsdl.util.WSDLResourceImpl;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDSchema;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class WSDLObjectAnalyzer {
	private XSDObjectAnalyzer xsdAnalyzer = new XSDObjectAnalyzer();

	public static List<XSDElementDeclaration> loadAllElement(String filePath) throws InvocationTargetException,
			IOException, ParserConfigurationException, SAXException {

		List<XSDElementDeclaration> nl = new ArrayList<XSDElementDeclaration>();
		String file = SmooksUIUtils.parseFilePath(filePath);
		WSDLParser parser = new WSDLParser();
		parser.parse(new FileInputStream(file));
		final Document document = parser.getDocument();
		final Definition definition = WSDLFactory.eINSTANCE.createDefinition();
		definition.setDocumentBaseURI(URI.createFileURI(file).toString());
		definition.setDocument(document);
		final ResourceSet resourceSet = new ResourceSetImpl();
		final Resource resource = new WSDLResourceImpl(URI.createFileURI(file));
		resourceSet.getResources().add(resource);
		resource.getContents().add(definition);

		resource.setModified(false);

		IRunnableWithProgress setElementOperation = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				monitor.beginTask("", IProgressMonitor.UNKNOWN); //$NON-NLS-1$
				definition.setElement(document.getDocumentElement());
			}
		};

		IProgressService progressService = PlatformUI.getWorkbench().getProgressService();
		try {
			progressService.busyCursorWhile(setElementOperation);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Resource resource = new WSDLResourceImpl(URI.createFileURI(file));
		// List<XSDElementDeclaration> list = schema.getElementDeclarations();
		// for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
		// XSDElementDeclaration elementDeclaration = (XSDElementDeclaration)
		// iterator.next();
		// if (elementDeclaration.isAbstract())
		// continue;
		// nl.add(elementDeclaration);
		// }
		Types types = definition.getETypes();
		if (types != null) {
			XSDSchemaExtensibilityElement el = null;
			for (Iterator<?> j = types.getEExtensibilityElements().iterator(); j.hasNext();) {
				ExtensibilityElement extensibilityElement = (ExtensibilityElement) j.next();
				if (!(extensibilityElement instanceof XSDSchemaExtensibilityElement)) {
					continue;
				}

				el = (XSDSchemaExtensibilityElement) extensibilityElement;
				XSDSchema schema = el.getSchema();
				if (schema != null) {
					List<XSDElementDeclaration> list = schema.getElementDeclarations();
					for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
						XSDElementDeclaration elementDeclaration = (XSDElementDeclaration) iterator.next();
						if (elementDeclaration.isAbstract())
							continue;
						nl.add(elementDeclaration);
					}
					break;
				}
			}
		}
		return nl;
	}

	public TagObject loadElement(String path, String rootElementName) throws IOException {
		WSDLResourceImpl resource = new WSDLResourceImpl(URI.createFileURI(path));
		resource.load(Collections.emptyMap());
		if (resource.getContents().isEmpty()) {
			return null;
		}
		Object obj = resource.getContents().get(0);
		// xsdAnalyzer.loadElement(schema, rootElementName);
		return null;
	}

}
