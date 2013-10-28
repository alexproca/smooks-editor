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

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xsd.XSDAttributeDeclaration;
import org.eclipse.xsd.XSDAttributeUse;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDParticleContent;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.util.XSDResourceFactoryImpl;
import org.jboss.tools.smooks.configuration.editors.utils.SmooksUIUtils;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class XSDObjectAnalyzer {
	// private static List<XSDElementDeclaration> findChildrenElement(XSDSchema
	// schema, XSDElementDeclaration baseElement) {
	// return findChildrenElement(schema, baseElement.getTypeDefinition());
	// }

	private HashMap<Object, Object> tagObjectBuffer = new HashMap<Object, Object>();

	public static List<XSDElementDeclaration> loadAllElement(String filePath) throws InvocationTargetException,
			IOException {
		List<XSDElementDeclaration> nl = new ArrayList<XSDElementDeclaration>();
		String file = null;
		try {
			 file = SmooksUIUtils.parseFilePath(filePath);
		} catch (Exception e) {
			return nl;
		}
		Resource resource = new XSDResourceFactoryImpl().createResource(URI.createFileURI(file));
		resource.load(Collections.EMPTY_MAP);
		XSDSchema schema = (XSDSchema) resource.getContents().get(0);
		List<XSDElementDeclaration> list = schema.getElementDeclarations();
		for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
			XSDElementDeclaration elementDeclaration = (XSDElementDeclaration) iterator.next();
			if (elementDeclaration.isAbstract())
				continue;
			nl.add(elementDeclaration);
		}
		return nl;
	}

	private List<XSDElementDeclaration> findChildrenElement(XSDSchema schema, XSDTypeDefinition baseTypeDefinition) {
		List<XSDElementDeclaration> elementList = new ArrayList<XSDElementDeclaration>();
		List<XSDElementDeclaration> elements = schema.getElementDeclarations();
		for (Iterator<?> iterator = elements.iterator(); iterator.hasNext();) {
			XSDElementDeclaration elementDec = (XSDElementDeclaration) iterator.next();
			if (elementDec.isAbstract())
				continue;
			XSDTypeDefinition td = elementDec.getType();
			XSDSimpleTypeDefinition st = td.getSimpleType();
			if (st != null) {
				continue;
			}
			if (td instanceof XSDComplexTypeDefinition) {
				XSDTypeDefinition tdd = td.getBaseType();
				if (tdd == baseTypeDefinition) {
					elementList.add(elementDec);
				}
			} else {
				// XSDSimpleTypeDefinition stype = td.getSimpleType();
				// System.out.println("Simple Type :" +stype.toString());
			}
		}
		if (elementList.isEmpty())
			return null;
		return elementList;
	}

	public TagObject loadElement(XSDSchema schema, String rootElementName) throws IOException {
		List<XSDElementDeclaration> elements = schema.getElementDeclarations();
		for (Iterator<?> iterator = elements.iterator(); iterator.hasNext();) {
			XSDElementDeclaration elementDec = (XSDElementDeclaration) iterator.next();
			if (rootElementName.equals(elementDec.getAliasName())) {
				tagObjectBuffer.clear();
				return loadElement(schema, elementDec);
			}
		}
		return null;
	}

	public TagObject loadElement(String filePath, String rootElementName) throws InvocationTargetException, IOException {
		tagObjectBuffer.clear();
		Resource resource = new XSDResourceFactoryImpl().createResource(URI.createFileURI(filePath));
		resource.load(Collections.EMPTY_MAP);
		if (resource.getContents().isEmpty())
			return null;
		XSDSchema schema = (XSDSchema) resource.getContents().get(0);
		return loadElement(schema, rootElementName);
	}

	public TagObject loadElement(String filePath, XSDElementDeclaration rootElement) throws InvocationTargetException,
			IOException {
		tagObjectBuffer.clear();
		Resource resource = new XSDResourceFactoryImpl().createResource(URI.createFileURI(filePath));
		resource.load(Collections.EMPTY_MAP);
		if (resource.getContents().isEmpty())
			return null;
		XSDSchema schema = (XSDSchema) resource.getContents().get(0);
		return loadElement(schema, rootElement);
	}

	private TagObject loadElement(XSDSchema schema, XSDElementDeclaration elementDec) {
		if (elementDec.isAbstract())
			return null;

		TagObject tag = (TagObject) tagObjectBuffer.get(elementDec);
		if (tag == null) {
			tag = new TagObject();
			tag.setName(elementDec.getAliasName());
			tag.setNamespaceURI(elementDec.getAliasURI());
			tagObjectBuffer.put(elementDec, tag);
		} else {
			return tag;
		}

		XSDTypeDefinition td = elementDec.getType();
		XSDSimpleTypeDefinition st = td.getSimpleType();
		// XSDComplexTypeDefinition ct = td.getComplexType();
		if (st != null) {
		}
		if (td instanceof XSDComplexTypeDefinition) {
			XSDComplexTypeDefinition ctype = (XSDComplexTypeDefinition) td;
			XSDParticle xsdparticle = td.getComplexType();
			if (xsdparticle != null) {
				XSDParticleContent term = xsdparticle.getContent();// .getTerm
				// ();
				if (term instanceof XSDModelGroup) {
					List<?> list = ((XSDModelGroup) term).getParticles();
					for (Iterator<?> iterator2 = list.iterator(); iterator2.hasNext();) {
						XSDParticle xp = (XSDParticle) iterator2.next();
						XSDParticleContent content = xp.getContent();
						if (content instanceof XSDElementDeclaration) {
							XSDElementDeclaration child = (XSDElementDeclaration) content;
							List<XSDElementDeclaration> childElement = null;
							if (child.isElementDeclarationReference()) {
								child = child.getResolvedElementDeclaration();
							}
							XSDTypeDefinition childType = child.getTypeDefinition();
							if (child.isAbstract()) {
								childElement = findChildrenElement(schema, childType);
								if (childElement != null) {
									for (Iterator<?> iterator3 = childElement.iterator(); iterator3.hasNext();) {
										XSDElementDeclaration elementDeclaration = (XSDElementDeclaration) iterator3
												.next();
										TagObject childTag = loadElement(schema, elementDeclaration);
										if (childTag != null) {
											tag.addChildTag(childTag);
										}
									}
								}
							} else {
								TagObject childTag = loadElement(schema, child);
								if (childTag != null) {
									tag.addChildTag(childTag);
								}
							}
						}
					}
				}
			}
			List<?> attributeContents = ctype.getAttributeContents();
			for (Iterator<?> iterator2 = attributeContents.iterator(); iterator2.hasNext();) {
				XSDAttributeUse attributeUse = (XSDAttributeUse) iterator2.next();
				XSDAttributeDeclaration attribute = attributeUse.getAttributeDeclaration();
				TagPropertyObject tp = new TagPropertyObject();
				tp.setName(attribute.getAliasName());
				tp.setNamespaceURI(attribute.getTypeDefinition().getURI());
				tag.addProperty(tp);
			}
		} else {
			// XSDSimpleTypeDefinition stype = td.getSimpleType();
			// System.out.println("Simple Type :" +stype.toString());
		}

		return tag;
	}

	public static void main(String[] args) throws IOException {
		Resource resource = new XSDResourceFactoryImpl().createResource(URI.createFileURI("F:/smooks-1.1.xsd")); //$NON-NLS-1$
		resource.load(Collections.EMPTY_MAP);
		XSDSchema schema = (XSDSchema) resource.getContents().get(0);
		TagObject rootTag = new XSDObjectAnalyzer().loadElement(schema, "smooks-resource-list"); //$NON-NLS-1$
//		System.out.println(rootTag);
		// List<XSDElementDeclaration> elements =
		// schema.getElementDeclarations();
		// for (Iterator<?> iterator = elements.iterator(); iterator.hasNext();)
		// {
		// XSDElementDeclaration elementDec = (XSDElementDeclaration)
		// iterator.next();
		// if (elementDec.isAbstract())
		// continue;
		// XSDTypeDefinition td = elementDec.getType();
		// XSDSimpleTypeDefinition st = td.getSimpleType();
		// System.out.println("Element Name :" + elementDec.getAliasName());
		// // XSDComplexTypeDefinition ct = td.getComplexType();
		// if (st != null) {
		// System.out.println("\tSimple Type :" + st.toString());
		// }
		// if (td instanceof XSDComplexTypeDefinition) {
		// XSDComplexTypeDefinition ctype = (XSDComplexTypeDefinition) td;
		//
		// XSDParticle xsdparticle = td.getComplexType();
		// XSDTypeDefinition tdd = td.getBaseType();
		// String tds = "";
		// if (tdd != null) {
		// tds = tdd.getAliasName();
		// }
		// if (xsdparticle != null) {
		// XSDParticleContent term = xsdparticle.getContent();// .getTerm
		// // ();
		// if (term instanceof XSDModelGroup) {
		// List<?> list = ((XSDModelGroup) term).getParticles();
		// for (Iterator<?> iterator2 = list.iterator(); iterator2.hasNext();) {
		// XSDParticle xp = (XSDParticle) iterator2.next();
		// XSDParticleContent content = xp.getContent();
		// if (content instanceof XSDElementDeclaration) {
		// XSDElementDeclaration child = (XSDElementDeclaration) content;
		// String refStr = "";
		// List<XSDElementDeclaration> childElement = null;
		// if (child.isElementDeclarationReference()) {
		// child = child.getResolvedElementDeclaration();
		// refStr = "Reference";
		// }
		// XSDTypeDefinition childType = child.getTypeDefinition();
		// if (child.isAbstract()) {
		// childElement = findChildrenElement(schema, childType);
		// if(childElement != null){
		// for (Iterator<?> iterator3 = childElement.iterator();
		// iterator3.hasNext();) {
		// XSDElementDeclaration elementDeclaration = (XSDElementDeclaration)
		// iterator3
		// .next();
		// System.out.println("\t" + refStr + "Element Name: " +
		// elementDeclaration.getAliasName() + " - "
		// + childType.getAliasName());
		// }
		// }
		// } else {
		// System.out.println("\t" + refStr + "Element Name: " +
		// child.getAliasName() + " - "
		// + childType.getAliasName());
		// }
		// }
		// }
		// }
		// }
		// List<?> attributeContents = ctype.getAttributeContents();
		// for (Iterator<?> iterator2 = attributeContents.iterator();
		// iterator2.hasNext();) {
		// XSDAttributeUse attributeUse = (XSDAttributeUse) iterator2.next();
		// XSDAttributeDeclaration attribute =
		// attributeUse.getAttributeDeclaration();
		// System.out.println("\tAttributes   :" + attribute.getAliasName() +
		// " - "
		// + attribute.getTypeDefinition().getQName());
		// }
		// continue;
		// } else {
		// // XSDSimpleTypeDefinition stype = td.getSimpleType();
		// // System.out.println("Simple Type :" +stype.toString());
		// }
		// System.out.println();
		// }
	}
}
