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
 * A representation of the model object '<em><b>Delimiters</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.medi.Delimiters#getComponent <em>Component</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.medi.Delimiters#getField <em>Field</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.medi.Delimiters#getSegment <em>Segment</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.medi.Delimiters#getSubComponent <em>Sub Component</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.medi.MEdiPackage#getDelimiters()
 * @model extendedMetaData="name='Delimiters' kind='empty'"
 * @generated
 */
public interface Delimiters extends AbstractAnyType {
	/**
	 * Returns the value of the '<em><b>Component</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component</em>' attribute.
	 * @see #setComponent(String)
	 * @see org.jboss.tools.smooks.model.medi.MEdiPackage#getDelimiters_Component()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='component'"
	 * @generated
	 */
	String getComponent();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.medi.Delimiters#getComponent <em>Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component</em>' attribute.
	 * @see #getComponent()
	 * @generated
	 */
	void setComponent(String value);

	/**
	 * Returns the value of the '<em><b>Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field</em>' attribute.
	 * @see #setField(String)
	 * @see org.jboss.tools.smooks.model.medi.MEdiPackage#getDelimiters_Field()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='field'"
	 * @generated
	 */
	String getField();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.medi.Delimiters#getField <em>Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field</em>' attribute.
	 * @see #getField()
	 * @generated
	 */
	void setField(String value);

	/**
	 * Returns the value of the '<em><b>Segment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Segment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Segment</em>' attribute.
	 * @see #setSegment(String)
	 * @see org.jboss.tools.smooks.model.medi.MEdiPackage#getDelimiters_Segment()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='segment'"
	 * @generated
	 */
	String getSegment();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.medi.Delimiters#getSegment <em>Segment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Segment</em>' attribute.
	 * @see #getSegment()
	 * @generated
	 */
	void setSegment(String value);

	/**
	 * Returns the value of the '<em><b>Sub Component</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 					The delimiter attributes mark the boundary
	 * 					tokens between the EDI message parts - segment,
	 * 					field, component and sub-component.
	 * 
	 * 					These boundary tokens may contain special
	 * 					characters (non-printable). These are defined
	 * 					using XML character references e.g. LF =
	 * 					"&amp;#10;"
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub Component</em>' attribute.
	 * @see #setSubComponent(String)
	 * @see org.jboss.tools.smooks.model.medi.MEdiPackage#getDelimiters_SubComponent()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='sub-component'"
	 * @generated
	 */
	String getSubComponent();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.medi.Delimiters#getSubComponent <em>Sub Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Component</em>' attribute.
	 * @see #getSubComponent()
	 * @generated
	 */
	void setSubComponent(String value);

} // Delimiters
