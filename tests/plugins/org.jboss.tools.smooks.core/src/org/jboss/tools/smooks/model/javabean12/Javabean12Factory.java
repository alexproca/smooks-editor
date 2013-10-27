/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.javabean12;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package
 * @generated
 */
public interface Javabean12Factory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Javabean12Factory eINSTANCE = org.jboss.tools.smooks.model.javabean12.impl.Javabean12FactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Bean Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bean Type</em>'.
	 * @generated
	 */
	BeanType createBeanType();

	/**
	 * Returns a new object of class '<em>Decode Param Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Decode Param Type</em>'.
	 * @generated
	 */
	DecodeParamType createDecodeParamType();

	/**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	Javabean12DocumentRoot createJavabean12DocumentRoot();

	/**
	 * Returns a new object of class '<em>Expression Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression Type</em>'.
	 * @generated
	 */
	ExpressionType createExpressionType();

	/**
	 * Returns a new object of class '<em>Result Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Result Type</em>'.
	 * @generated
	 */
	ResultType createResultType();

	/**
	 * Returns a new object of class '<em>Value Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value Type</em>'.
	 * @generated
	 */
	ValueType createValueType();

	/**
	 * Returns a new object of class '<em>Wiring Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wiring Type</em>'.
	 * @generated
	 */
	WiringType createWiringType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Javabean12Package getJavabean12Package();

} //Javabean12Factory
