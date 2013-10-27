/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.edi12;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.jboss.tools.smooks.model.edi12.Edi12Package
 * @generated
 */
public interface Edi12Factory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Edi12Factory eINSTANCE = org.jboss.tools.smooks.model.edi12.impl.Edi12FactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EDI12 Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EDI12 Document Root</em>'.
	 * @generated
	 */
	EDI12DocumentRoot createEDI12DocumentRoot();

	/**
	 * Returns a new object of class '<em>EDI12 Reader</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EDI12 Reader</em>'.
	 * @generated
	 */
	EDI12Reader createEDI12Reader();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Edi12Package getEdi12Package();

} //Edi12Factory
