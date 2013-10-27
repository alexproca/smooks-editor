/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.smooks;

import org.jboss.tools.smooks.model.common.AbstractAnyType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set On Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Set Reader Feature 'On'
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.SetOnType#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getSetOnType()
 * @model extendedMetaData="name='setOn_._type' kind='empty'"
 * @generated
 */
public interface SetOnType extends AbstractAnyType {
	/**
	 * Returns the value of the '<em><b>Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' attribute.
	 * @see #setFeature(String)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getSetOnType_Feature()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI" required="true"
	 *        extendedMetaData="kind='attribute' name='feature'"
	 * @generated
	 */
	String getFeature();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.SetOnType#getFeature <em>Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' attribute.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(String value);

} // SetOnType
