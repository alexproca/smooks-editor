/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.smooks;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Reader</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.AbstractReader#getTargetProfile <em>Target Profile</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getAbstractReader()
 * @model abstract="true"
 *        extendedMetaData="name='abstract-reader' kind='empty'"
 * @generated
 */
public interface AbstractReader extends AbstractResourceConfig {
	/**
	 * Returns the value of the '<em><b>Target Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Profile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Profile</em>' attribute.
	 * @see #setTargetProfile(String)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getAbstractReader_TargetProfile()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='targetProfile'"
	 * @generated
	 */
	String getTargetProfile();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.AbstractReader#getTargetProfile <em>Target Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Profile</em>' attribute.
	 * @see #getTargetProfile()
	 * @generated
	 */
	void setTargetProfile(String value);

} // AbstractReader
