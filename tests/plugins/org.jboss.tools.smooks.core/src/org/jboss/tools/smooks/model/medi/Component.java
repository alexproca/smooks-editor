/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.medi;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.medi.Component#getSubComponent <em>Sub Component</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.medi.Component#isRequired <em>Required</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.medi.Component#isTruncatable <em>Truncatable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.medi.MEdiPackage#getComponent()
 * @model extendedMetaData="name='Component' kind='elementOnly'"
 * @generated
 */
public interface Component extends MappingNode {
	/**
	 * Returns the value of the '<em><b>Sub Component</b></em>' containment reference list.
	 * The list contents are of type {@link org.jboss.tools.smooks.model.medi.SubComponent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Component</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Component</em>' containment reference list.
	 * @see org.jboss.tools.smooks.model.medi.MEdiPackage#getComponent_SubComponent()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='sub-component' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<SubComponent> getSubComponent();

	/**
	 * Returns the value of the '<em><b>Required</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required</em>' attribute.
	 * @see #isSetRequired()
	 * @see #unsetRequired()
	 * @see #setRequired(boolean)
	 * @see org.jboss.tools.smooks.model.medi.MEdiPackage#getComponent_Required()
	 * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='required'"
	 * @generated
	 */
	boolean isRequired();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.medi.Component#isRequired <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required</em>' attribute.
	 * @see #isSetRequired()
	 * @see #unsetRequired()
	 * @see #isRequired()
	 * @generated
	 */
	void setRequired(boolean value);

	/**
	 * Unsets the value of the '{@link org.jboss.tools.smooks.model.medi.Component#isRequired <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRequired()
	 * @see #isRequired()
	 * @see #setRequired(boolean)
	 * @generated
	 */
	void unsetRequired();

	/**
	 * Returns whether the value of the '{@link org.jboss.tools.smooks.model.medi.Component#isRequired <em>Required</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Required</em>' attribute is set.
	 * @see #unsetRequired()
	 * @see #isRequired()
	 * @see #setRequired(boolean)
	 * @generated
	 */
	boolean isSetRequired();

	/**
	 * Returns the value of the '<em><b>Truncatable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Truncatable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Truncatable</em>' attribute.
	 * @see #isSetTruncatable()
	 * @see #unsetTruncatable()
	 * @see #setTruncatable(boolean)
	 * @see org.jboss.tools.smooks.model.medi.MEdiPackage#getComponent_Truncatable()
	 * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='truncatable'"
	 * @generated
	 */
	boolean isTruncatable();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.medi.Component#isTruncatable <em>Truncatable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Truncatable</em>' attribute.
	 * @see #isSetTruncatable()
	 * @see #unsetTruncatable()
	 * @see #isTruncatable()
	 * @generated
	 */
	void setTruncatable(boolean value);

	/**
	 * Unsets the value of the '{@link org.jboss.tools.smooks.model.medi.Component#isTruncatable <em>Truncatable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTruncatable()
	 * @see #isTruncatable()
	 * @see #setTruncatable(boolean)
	 * @generated
	 */
	void unsetTruncatable();

	/**
	 * Returns whether the value of the '{@link org.jboss.tools.smooks.model.medi.Component#isTruncatable <em>Truncatable</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Truncatable</em>' attribute is set.
	 * @see #unsetTruncatable()
	 * @see #isTruncatable()
	 * @see #setTruncatable(boolean)
	 * @generated
	 */
	boolean isSetTruncatable();

} // Component
