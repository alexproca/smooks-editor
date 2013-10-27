/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.javabean12;

import org.jboss.tools.smooks.model.common.AbstractAnyType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wiring Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.WiringType#getBeanIdRef <em>Bean Id Ref</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.WiringType#getProperty <em>Property</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.WiringType#getSetterMethod <em>Setter Method</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.WiringType#getWireOnElement <em>Wire On Element</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.WiringType#getWireOnElementNS <em>Wire On Element NS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getWiringType()
 * @model extendedMetaData="name='wiring_._type' kind='empty'"
 * @generated
 */
public interface WiringType extends AbstractAnyType {
	/**
	 * Returns the value of the '<em><b>Bean Id Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *         				The beanId of the bean to be wired into the
	 *         				specified bean "property" (or List).
	 *         			
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bean Id Ref</em>' attribute.
	 * @see #setBeanIdRef(String)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getWiringType_BeanIdRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='beanIdRef'"
	 * @generated
	 */
	String getBeanIdRef();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.WiringType#getBeanIdRef <em>Bean Id Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bean Id Ref</em>' attribute.
	 * @see #getBeanIdRef()
	 * @generated
	 */
	void setBeanIdRef(String value);

	/**
	 * Returns the value of the '<em><b>Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *         				The class property to which the bean (specified
	 *         				by "beanIdRef") is to be bound.
	 *         				<p/>
	 *         				The property attribute does not need to be
	 *         				specified when the "class" type on the parent
	 *         				"bindings" element is a List/Array or Map. In
	 *         				the case of a List/Array, the bean is simply
	 *         				added. In the case of Map, the element name
	 *         				(from the element specified in the "data"
	 *         				attribute) is used.
	 *         			
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Property</em>' attribute.
	 * @see #setProperty(String)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getWiringType_Property()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='property'"
	 * @generated
	 */
	String getProperty();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.WiringType#getProperty <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' attribute.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(String value);

	/**
	 * Returns the value of the '<em><b>Setter Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *         				The class method which is called to bind the data
	 *         				to the object. Not needed when binding to a Collection.
	 *         				<p/>
	 *                         The setterMethod attribute does not need to be specified when the "class" type on the parent "bindings" element
	 *                         is a List/Array or Map.  In the case of a List/Array, the bean is simply added.  In the case of Map, the
	 *                         element name (from the element specified in the "data" attribute) is used.
	 *         			
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Setter Method</em>' attribute.
	 * @see #setSetterMethod(String)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getWiringType_SetterMethod()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='setterMethod'"
	 * @generated
	 */
	String getSetterMethod();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.WiringType#getSetterMethod <em>Setter Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Setter Method</em>' attribute.
	 * @see #getSetterMethod()
	 * @generated
	 */
	void setSetterMethod(String value);

	/**
	 * Returns the value of the '<em><b>Wire On Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *         				The Source data event stream element event to
	 *         				use to control when the bean needs to be wired
	 *         				or when the cartridge needs to register a
	 *         				listener for the bean to be wired.
	 *         			
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Wire On Element</em>' attribute.
	 * @see #setWireOnElement(String)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getWiringType_WireOnElement()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='wireOnElement'"
	 * @generated
	 */
	String getWireOnElement();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.WiringType#getWireOnElement <em>Wire On Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wire On Element</em>' attribute.
	 * @see #getWireOnElement()
	 * @generated
	 */
	void setWireOnElement(String value);

	/**
	 * Returns the value of the '<em><b>Wire On Element NS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *         				Namespace control for the "wireOnElement"
	 *         				attribute.
	 *         			
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Wire On Element NS</em>' attribute.
	 * @see #setWireOnElementNS(String)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getWiringType_WireOnElementNS()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='wireOnElementNS'"
	 * @generated
	 */
	String getWireOnElementNS();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.WiringType#getWireOnElementNS <em>Wire On Element NS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wire On Element NS</em>' attribute.
	 * @see #getWireOnElementNS()
	 * @generated
	 */
	void setWireOnElementNS(String value);

} // WiringType
