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
package org.jboss.tools.smooks.core;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.SAXXMLHandler;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.jboss.tools.smooks.model.common.AbstractAnyType;

/**
 * @author Dart
 * 
 */
public class SmooksSAXXMLHandler extends SAXXMLHandler {

	public SmooksSAXXMLHandler(XMLResource xmiResource, XMLHelper helper, Map<?, ?> options) {
		super(xmiResource, helper, options);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.ecore.xmi.impl.SAXXMLHandler#processObject(org.eclipse
	 * .emf.ecore.EObject)
	 */
	@Override
	protected void processObject(EObject object) {
		if (object instanceof AbstractAnyType) {
			((AbstractAnyType) object).setLockCOmmentIndexChange(true);
		}
		super.processObject(object);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.ecore.xmi.impl.XMLHandler#endElement(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(String uri, String localName, String name) {
		elements.pop();
		Object type = types.pop();
		if (type == OBJECT_TYPE) {
			if (text == null) {
				Object object = objects.pop();
				if (object instanceof AbstractAnyType) {
					((AbstractAnyType) object).setLockCOmmentIndexChange(false);
				}
				mixedTargets.pop();
			} else {
				EObject object = objects.popEObject();
				if (object instanceof AbstractAnyType) {
					((AbstractAnyType) object).setLockCOmmentIndexChange(false);
				}
				if (mixedTargets.peek() != null
						&& (object.eContainer() != null || recordUnknownFeature
								&& (eObjectToExtensionMap.containsValue(object) || ((InternalEObject) object)
										.eDirectResource() != null))) {
					handleMixedText();
					mixedTargets.pop();
				} else {
					if (text.length() != 0) {
						handleProxy((InternalEObject) object, text.toString().trim());
					}
					mixedTargets.pop();
					text = null;
				}
			}
		} else if (isIDREF) {
			Object object = objects.pop();
			if (object instanceof AbstractAnyType) {
				((AbstractAnyType) object).setLockCOmmentIndexChange(false);
			}
			mixedTargets.pop();
			if (text != null) {
				setValueFromId(objects.peekEObject(), (EReference) type, text.toString());
				text = null;
			}
			isIDREF = false;
		} else if (isTextFeatureValue(type)) {
			EObject eObject = objects.popEObject();
			if (eObject instanceof AbstractAnyType) {
				((AbstractAnyType) eObject).setLockCOmmentIndexChange(false);
			}
			mixedTargets.pop();
			if (eObject == null) {
				eObject = objects.peekEObject();
			}
			setFeatureValue(eObject, (EStructuralFeature) type, text == null ? null : text.toString());
			text = null;
		}

		if (isSimpleFeature) {
			types.pop();
			Object object = objects.pop();
			if (object instanceof AbstractAnyType) {
				((AbstractAnyType) object).setLockCOmmentIndexChange(false);
			}
			mixedTargets.pop();
			isSimpleFeature = false;
		}
		helper.popContext(prefixesToFactories);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.xmi.impl.XMLHandler#comment(char[], int, int)
	 */
	@Override
	public void comment(char[] ch, int start, int length) {
		String comment = new String(ch, start, length);
		Object obj = objects.get(objects.size() - 1);

		if (mixedTargets.peek() != null) {
			if (text != null) {
				handleMixedText();
			}
			handleComment(comment);

		} else {
			// if (obj != null && obj instanceof AnyType) {
			// FeatureMap featureMap = ((AnyType) obj).getMixed();
			// if (featureMap != null) {
			// try {
			// featureMap.add(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__COMMENT,
			// comment);
			// } catch (Exception e) {
			// e.printStackTrace();
			// }
			// text = null;
			// }
			// }
			if (obj != null && obj instanceof AbstractAnyType) {
				int currentSize = ((AbstractAnyType) obj).eContents().size();
				((AbstractAnyType) obj).addComment(comment, new Integer(currentSize));
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.ecore.xmi.impl.XMLHandler#handleComment(java.lang.String)
	 */
	@Override
	protected void handleComment(String comment) {
		FeatureMap featureMap = mixedTargets.peek();
		featureMap.add(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__COMMENT, comment);
		text = null;
	}

}
