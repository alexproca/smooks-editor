/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.smooks;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Visitor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Element Visitor Resource Type
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.ElementVisitor#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.ElementVisitor#getTargetProfile <em>Target Profile</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getElementVisitor()
 * @model abstract="true"
 *        extendedMetaData="name='element-visitor' kind='elementOnly'"
 * @generated
 */
public interface ElementVisitor extends AbstractResourceConfig {
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
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getElementVisitor_Condition()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='condition' namespace='##targetNamespace'"
	 * @generated
	 */
	ConditionType getCondition();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.ElementVisitor#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(ConditionType value);

	/**
	 * Returns the value of the '<em><b>Target Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *        						Defines the target profile
	 *        					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target Profile</em>' attribute.
	 * @see #setTargetProfile(String)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getElementVisitor_TargetProfile()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='targetProfile'"
	 * @generated
	 */
	String getTargetProfile();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.ElementVisitor#getTargetProfile <em>Target Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Profile</em>' attribute.
	 * @see #getTargetProfile()
	 * @generated
	 */
	void setTargetProfile(String value);

} // ElementVisitor
