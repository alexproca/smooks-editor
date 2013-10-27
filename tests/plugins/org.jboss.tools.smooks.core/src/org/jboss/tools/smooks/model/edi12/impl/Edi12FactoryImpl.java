/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.edi12.impl;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.jboss.tools.smooks.model.edi12.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Edi12FactoryImpl extends EFactoryImpl implements Edi12Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Edi12Factory init() {
		try {
			Edi12Factory theEdi12Factory = (Edi12Factory)EPackage.Registry.INSTANCE.getEFactory("http://www.milyn.org/xsd/smooks/edi-1.2.xsd");  //$NON-NLS-1$
			if (theEdi12Factory != null) {
				return theEdi12Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Edi12FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Edi12FactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Edi12Package.EDI12_DOCUMENT_ROOT: return createEDI12DocumentRoot();
			case Edi12Package.EDI12_READER: return createEDI12Reader();
			default:
				throw new IllegalArgumentException(Messages.Edi12FactoryImpl_Error_Class_Not_Valid + eClass.getName() + Messages.Edi12FactoryImpl_Error_Not_Valid_Classifier);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDI12DocumentRoot createEDI12DocumentRoot() {
		EDI12DocumentRootImpl edi12DocumentRoot = new EDI12DocumentRootImpl();
		return edi12DocumentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDI12Reader createEDI12Reader() {
		EDI12ReaderImpl edi12Reader = new EDI12ReaderImpl();
		return edi12Reader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Edi12Package getEdi12Package() {
		return (Edi12Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static Edi12Package getPackage() {
		return Edi12Package.eINSTANCE;
	}

} //Edi12FactoryImpl
