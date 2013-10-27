/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.medi;

import org.jboss.tools.smooks.model.common.AbstractAnyType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.medi.EdiMap#getDescription <em>Description</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.medi.EdiMap#getDelimiters <em>Delimiters</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.medi.EdiMap#getSegments <em>Segments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.medi.MEdiPackage#getEdiMap()
 * @model extendedMetaData="name='EdiMap' kind='elementOnly'"
 * @generated
 */
public interface EdiMap extends AbstractAnyType {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' containment reference.
	 * @see #setDescription(Description)
	 * @see org.jboss.tools.smooks.model.medi.MEdiPackage#getEdiMap_Description()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='description' namespace='##targetNamespace'"
	 * @generated
	 */
	Description getDescription();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.medi.EdiMap#getDescription <em>Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' containment reference.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(Description value);

	/**
	 * Returns the value of the '<em><b>Delimiters</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delimiters</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delimiters</em>' containment reference.
	 * @see #setDelimiters(Delimiters)
	 * @see org.jboss.tools.smooks.model.medi.MEdiPackage#getEdiMap_Delimiters()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='delimiters' namespace='##targetNamespace'"
	 * @generated
	 */
	Delimiters getDelimiters();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.medi.EdiMap#getDelimiters <em>Delimiters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delimiters</em>' containment reference.
	 * @see #getDelimiters()
	 * @generated
	 */
	void setDelimiters(Delimiters value);

	/**
	 * Returns the value of the '<em><b>Segments</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Segments</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Segments</em>' containment reference.
	 * @see #setSegments(Segments)
	 * @see org.jboss.tools.smooks.model.medi.MEdiPackage#getEdiMap_Segments()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='segments' namespace='##targetNamespace'"
	 * @generated
	 */
	Segments getSegments();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.medi.EdiMap#getSegments <em>Segments</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Segments</em>' containment reference.
	 * @see #getSegments()
	 * @generated
	 */
	void setSegments(Segments value);

} // EdiMap
