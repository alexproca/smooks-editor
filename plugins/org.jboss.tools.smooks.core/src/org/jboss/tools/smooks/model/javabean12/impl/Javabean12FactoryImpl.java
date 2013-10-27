/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.javabean12.impl;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.jboss.tools.smooks.model.javabean12.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Javabean12FactoryImpl extends EFactoryImpl implements Javabean12Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Javabean12Factory init() {
		try {
			Javabean12Factory theJavabean12Factory = (Javabean12Factory)EPackage.Registry.INSTANCE.getEFactory("http://www.milyn.org/xsd/smooks/javabean-1.2.xsd");  //$NON-NLS-1$
			if (theJavabean12Factory != null) {
				return theJavabean12Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Javabean12FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Javabean12FactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Javabean12Package.BEAN_TYPE: return createBeanType();
			case Javabean12Package.DECODE_PARAM_TYPE: return createDecodeParamType();
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT: return createJavabean12DocumentRoot();
			case Javabean12Package.EXPRESSION_TYPE: return createExpressionType();
			case Javabean12Package.RESULT_TYPE: return createResultType();
			case Javabean12Package.VALUE_TYPE: return createValueType();
			case Javabean12Package.WIRING_TYPE: return createWiringType();
			default:
				throw new IllegalArgumentException(Messages.Javabean12FactoryImpl_Error_Class_Not_Valid + eClass.getName() + Messages.Javabean12FactoryImpl_Error_Not_Valid_Classifier);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeanType createBeanType() {
		BeanTypeImpl beanType = new BeanTypeImpl();
		return beanType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DecodeParamType createDecodeParamType() {
		DecodeParamTypeImpl decodeParamType = new DecodeParamTypeImpl();
		return decodeParamType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Javabean12DocumentRoot createJavabean12DocumentRoot() {
		Javabean12DocumentRootImpl javabean12DocumentRoot = new Javabean12DocumentRootImpl();
		return javabean12DocumentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionType createExpressionType() {
		ExpressionTypeImpl expressionType = new ExpressionTypeImpl();
		return expressionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType createResultType() {
		ResultTypeImpl resultType = new ResultTypeImpl();
		return resultType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueType createValueType() {
		ValueTypeImpl valueType = new ValueTypeImpl();
		return valueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WiringType createWiringType() {
		WiringTypeImpl wiringType = new WiringTypeImpl();
		return wiringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Javabean12Package getJavabean12Package() {
		return (Javabean12Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static Javabean12Package getPackage() {
		return Javabean12Package.eINSTANCE;
	}

} //Javabean12FactoryImpl
