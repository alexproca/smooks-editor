/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.smooks;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Config Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Smooks Resource Configuration
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.ResourceConfigType#getResource <em>Resource</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.ResourceConfigType#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.ResourceConfigType#getParam <em>Param</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.ResourceConfigType#getSelector <em>Selector</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.ResourceConfigType#getSelectorNamespace <em>Selector Namespace</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.ResourceConfigType#getTargetProfile <em>Target Profile</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getResourceConfigType()
 * @model extendedMetaData="name='resource-config_._type' kind='elementOnly'"
 * @generated
 */
public interface ResourceConfigType extends AbstractResourceConfig {
	/**
	 * Returns the value of the '<em><b>Resource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' containment reference.
	 * @see #setResource(ResourceType)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getResourceConfigType_Resource()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='resource' namespace='##targetNamespace'"
	 * @generated
	 */
	ResourceType getResource();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.ResourceConfigType#getResource <em>Resource</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' containment reference.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(ResourceType value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(ConditionType)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getResourceConfigType_Condition()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='condition' namespace='##targetNamespace'"
	 * @generated
	 */
	ConditionType getCondition();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.ResourceConfigType#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(ConditionType value);

	/**
	 * Returns the value of the '<em><b>Param</b></em>' containment reference list.
	 * The list contents are of type {@link org.jboss.tools.smooks.model.smooks.ParamType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Param</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param</em>' containment reference list.
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getResourceConfigType_Param()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='param' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ParamType> getParam();

	/**
	 * Returns the value of the '<em><b>Selector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selector</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selector</em>' attribute.
	 * @see #setSelector(String)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getResourceConfigType_Selector()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='selector'"
	 * @generated
	 */
	String getSelector();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.ResourceConfigType#getSelector <em>Selector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selector</em>' attribute.
	 * @see #getSelector()
	 * @generated
	 */
	void setSelector(String value);

	/**
	 * Returns the value of the '<em><b>Selector Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selector Namespace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selector Namespace</em>' attribute.
	 * @see #setSelectorNamespace(String)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getResourceConfigType_SelectorNamespace()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='selector-namespace'"
	 * @generated
	 */
	String getSelectorNamespace();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.ResourceConfigType#getSelectorNamespace <em>Selector Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selector Namespace</em>' attribute.
	 * @see #getSelectorNamespace()
	 * @generated
	 */
	void setSelectorNamespace(String value);

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
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getResourceConfigType_TargetProfile()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='target-profile'"
	 * @generated
	 */
	String getTargetProfile();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.ResourceConfigType#getTargetProfile <em>Target Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Profile</em>' attribute.
	 * @see #getTargetProfile()
	 * @generated
	 */
	void setTargetProfile(String value);

} // ResourceConfigType
