/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.smooks;


import org.eclipse.emf.common.util.EList;
import org.jboss.tools.smooks.model.common.AbstractAnyType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Features Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Reader Features List
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.FeaturesType#getSetOn <em>Set On</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.FeaturesType#getSetOff <em>Set Off</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getFeaturesType()
 * @model extendedMetaData="name='features_._type' kind='elementOnly'"
 * @generated
 */
public interface FeaturesType extends AbstractAnyType {
	/**
	 * Returns the value of the '<em><b>Set On</b></em>' containment reference list.
	 * The list contents are of type {@link org.jboss.tools.smooks.model.smooks.SetOnType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Set On</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Set On</em>' containment reference list.
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getFeaturesType_SetOn()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='setOn' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<SetOnType> getSetOn();

	/**
	 * Returns the value of the '<em><b>Set Off</b></em>' containment reference list.
	 * The list contents are of type {@link org.jboss.tools.smooks.model.smooks.SetOffType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Set Off</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Set Off</em>' containment reference list.
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getFeaturesType_SetOff()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='setOff' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<SetOffType> getSetOff();

} // FeaturesType
