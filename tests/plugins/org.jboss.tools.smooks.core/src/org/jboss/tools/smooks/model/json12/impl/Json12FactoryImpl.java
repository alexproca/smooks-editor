/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.json12.impl;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.jboss.tools.smooks.model.json12.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Json12FactoryImpl extends EFactoryImpl implements Json12Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Json12Factory init() {
		try {
			Json12Factory theJson12Factory = (Json12Factory)EPackage.Registry.INSTANCE.getEFactory("http://www.milyn.org/xsd/smooks/json-1.2.xsd");  //$NON-NLS-1$
			if (theJson12Factory != null) {
				return theJson12Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Json12FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Json12FactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Json12Package.JSON12_DOCUMENT_ROOT: return createJson12DocumentRoot();
			case Json12Package.KEY: return createKey();
			case Json12Package.KEY_MAP: return createKeyMap();
			case Json12Package.JSON12_READER: return createJson12Reader();
			default:
				throw new IllegalArgumentException(Messages.Json12FactoryImpl_Error_Class_Not_Valid + eClass.getName() + Messages.Json12FactoryImpl_Error_Not_Valid_Classifier);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Json12DocumentRoot createJson12DocumentRoot() {
		Json12DocumentRootImpl json12DocumentRoot = new Json12DocumentRootImpl();
		return json12DocumentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Key createKey() {
		KeyImpl key = new KeyImpl();
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyMap createKeyMap() {
		KeyMapImpl keyMap = new KeyMapImpl();
		return keyMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Json12Reader createJson12Reader() {
		Json12ReaderImpl json12Reader = new Json12ReaderImpl();
		return json12Reader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Json12Package getJson12Package() {
		return (Json12Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static Json12Package getPackage() {
		return Json12Package.eINSTANCE;
	}

} //Json12FactoryImpl
