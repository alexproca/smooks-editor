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
 * A representation of the model object '<em><b>Profile Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Profile Configuration. Basically allows you to specify the name of a
 *                     base profile along with a list of its sub-profiles.
 *                 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.ProfileType#getValue <em>Value</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.ProfileType#getBaseProfile <em>Base Profile</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.ProfileType#getSubProfiles <em>Sub Profiles</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getProfileType()
 * @model extendedMetaData="name='profile_._type' kind='simple'"
 * @generated
 */
public interface ProfileType extends AbstractAnyType {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getProfileType_Value()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="name=':0' kind='simple'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.ProfileType#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Base Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Profile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Profile</em>' attribute.
	 * @see #setBaseProfile(String)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getProfileType_BaseProfile()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='base-profile'"
	 * @generated
	 */
	String getBaseProfile();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.ProfileType#getBaseProfile <em>Base Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Profile</em>' attribute.
	 * @see #getBaseProfile()
	 * @generated
	 */
	void setBaseProfile(String value);

	/**
	 * Returns the value of the '<em><b>Sub Profiles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Profiles</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Profiles</em>' attribute.
	 * @see #setSubProfiles(String)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getProfileType_SubProfiles()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='sub-profiles'"
	 * @generated
	 */
	String getSubProfiles();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.ProfileType#getSubProfiles <em>Sub Profiles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Profiles</em>' attribute.
	 * @see #getSubProfiles()
	 * @generated
	 */
	void setSubProfiles(String value);

} // ProfileType
