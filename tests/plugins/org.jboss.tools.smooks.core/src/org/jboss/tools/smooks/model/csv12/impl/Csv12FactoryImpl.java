/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.csv12.impl;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.jboss.tools.smooks.model.csv12.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Csv12FactoryImpl extends EFactoryImpl implements Csv12Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Csv12Factory init() {
		try {
			Csv12Factory theCsv12Factory = (Csv12Factory)EPackage.Registry.INSTANCE.getEFactory("http://www.milyn.org/xsd/smooks/csv-1.2.xsd");  //$NON-NLS-1$
			if (theCsv12Factory != null) {
				return theCsv12Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Csv12FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Csv12FactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Csv12Package.BINDING: return createBinding();
			case Csv12Package.CSV12_DOCUMENT_ROOT: return createCSV12DocumentRoot();
			case Csv12Package.MAP_BINDING: return createMapBinding();
			case Csv12Package.CSV12_READER: return createCSV12Reader();
			default:
				throw new IllegalArgumentException(Messages.Csv12FactoryImpl_Error_Invalid_Class + eClass.getName() + Messages.Csv12FactoryImpl_Error_Not_Valid_Classifier);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case Csv12Package.CHAR:
				return createCharFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException(Messages.Csv12FactoryImpl_Error_Invalid_Datatype + eDataType.getName() + Messages.Csv12FactoryImpl_Error_Not_Valid_Classifier);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case Csv12Package.CHAR:
				return convertCharToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException(Messages.Csv12FactoryImpl_Error_Invalid_Datatype + eDataType.getName() + Messages.Csv12FactoryImpl_Error_Not_Valid_Classifier);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Binding createBinding() {
		BindingImpl binding = new BindingImpl();
		return binding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CSV12DocumentRoot createCSV12DocumentRoot() {
		CSV12DocumentRootImpl csv12DocumentRoot = new CSV12DocumentRootImpl();
		return csv12DocumentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MapBinding createMapBinding() {
		MapBindingImpl mapBinding = new MapBindingImpl();
		return mapBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CSV12Reader createCSV12Reader() {
		CSV12ReaderImpl csv12Reader = new CSV12ReaderImpl();
		return csv12Reader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createCharFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCharToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Csv12Package getCsv12Package() {
		return (Csv12Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static Csv12Package getPackage() {
		return Csv12Package.eINSTANCE;
	}

} //Csv12FactoryImpl
