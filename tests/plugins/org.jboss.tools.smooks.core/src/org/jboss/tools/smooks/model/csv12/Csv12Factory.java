/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.csv12;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.jboss.tools.smooks.model.csv12.Csv12Package
 * @generated
 */
public interface Csv12Factory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Csv12Factory eINSTANCE = org.jboss.tools.smooks.model.csv12.impl.Csv12FactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binding</em>'.
	 * @generated
	 */
	Binding createBinding();

	/**
	 * Returns a new object of class '<em>CSV12 Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CSV12 Document Root</em>'.
	 * @generated
	 */
	CSV12DocumentRoot createCSV12DocumentRoot();

	/**
	 * Returns a new object of class '<em>Map Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Map Binding</em>'.
	 * @generated
	 */
	MapBinding createMapBinding();

	/**
	 * Returns a new object of class '<em>CSV12 Reader</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CSV12 Reader</em>'.
	 * @generated
	 */
	CSV12Reader createCSV12Reader();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Csv12Package getCsv12Package();

} //Csv12Factory
