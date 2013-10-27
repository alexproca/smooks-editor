/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.javabean12;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.util.FeatureMap;
import org.jboss.tools.smooks.model.smooks.ElementVisitor;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bean Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.BeanType#getGroup <em>Group</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.BeanType#getValue <em>Value</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.BeanType#getWiring <em>Wiring</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.BeanType#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.BeanType#getBeanId <em>Bean Id</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.BeanType#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.BeanType#getCreateOnElement <em>Create On Element</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.BeanType#getCreateOnElementNS <em>Create On Element NS</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.BeanType#isExtendLifecycle <em>Extend Lifecycle</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getBeanType()
 * @model extendedMetaData="name='bean_._type' kind='elementOnly'"
 * @generated
 */
public interface BeanType extends ElementVisitor {
	/**
	 * Returns the value of the '<em><b>Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute list.
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getBeanType_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:2'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference list.
	 * The list contents are of type {@link org.jboss.tools.smooks.model.javabean12.ValueType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 	            Basic "value" based binding configuration.
	 * 	            <p/>
	 * 	            This binding type is used to bind data from the source message event stream.
	 * 	        
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' containment reference list.
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getBeanType_Value()
	 * @model type="javabean12.ValueType" containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='value' namespace='##targetNamespace' group='#group:2'"
	 * @generated
	 */
	EList getValue();

	/**
	 * Returns the value of the '<em><b>Wiring</b></em>' containment reference list.
	 * The list contents are of type {@link org.jboss.tools.smooks.model.javabean12.WiringType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *       			Wiring based binding configuration.
	 *       			<p/>
	 *       			This binding type is used to "wire" beans together.
	 *       		
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Wiring</em>' containment reference list.
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getBeanType_Wiring()
	 * @model type="javabean12.WiringType" containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='wiring' namespace='##targetNamespace' group='#group:2'"
	 * @generated
	 */
	EList getWiring();

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference list.
	 * The list contents are of type {@link org.jboss.tools.smooks.model.javabean12.ExpressionType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Expression based Configuration
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference list.
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getBeanType_Expression()
	 * @model type="javabean12.ExpressionType" containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='expression' namespace='##targetNamespace' group='#group:2'"
	 * @generated
	 */
	EList getExpression();

	/**
	 * Returns the value of the '<em><b>Bean Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                                 The ID under which the created bean is
	 *                                 to be bound in the bean context.
	 *                             
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bean Id</em>' attribute.
	 * @see #setBeanId(String)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getBeanType_BeanId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='beanId'"
	 * @generated
	 */
	String getBeanId();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.BeanType#getBeanId <em>Bean Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bean Id</em>' attribute.
	 * @see #getBeanId()
	 * @generated
	 */
	void setBeanId(String value);

	/**
	 * Returns the value of the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *         						The fully qualified bean Class name.
	 *         					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Class</em>' attribute.
	 * @see #setClass(String)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getBeanType_Class()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='class'"
	 * @generated
	 */
	String getClass_();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.BeanType#getClass_ <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' attribute.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(String value);

	/**
	 * Returns the value of the '<em><b>Create On Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *         						The Source data event stream element
	 *         						event to use to control the timing of
	 *         						the creating.
	 *         						<p/>
	 *         						Think of this as the element path (in
	 *         						the Source data) used to control
	 *         						creation of the bean instance(s).
	 *         						<h3>Example</h3>
	 *         						If this attribute value is set to
	 *         						"order/orderItem", an instance of the
	 *         						class (specified in the "class"
	 *         						attribute) will be created when an
	 *         						element event for the element
	 *         						"orderItem" (with a parent element of
	 *         						"order") is encountered in the Source
	 *         						data event stream. The created bean
	 *         						instance will then be bound into the
	 *         						bean context under the specified
	 *         						"beanId".
	 *         						<p/>
	 *         						If the createOnElement is not set then
	 *         						no bean will be created. The existing
	 *         						bean in the bean context will be used to
	 *         						do the value binding, expression binding
	 *         						and the object wiring on.
	 *         					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Create On Element</em>' attribute.
	 * @see #setCreateOnElement(String)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getBeanType_CreateOnElement()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='createOnElement'"
	 * @generated
	 */
	String getCreateOnElement();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.BeanType#getCreateOnElement <em>Create On Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create On Element</em>' attribute.
	 * @see #getCreateOnElement()
	 * @generated
	 */
	void setCreateOnElement(String value);

	/**
	 * Returns the value of the '<em><b>Create On Element NS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *         						Namespace control for the
	 *         						"createOnElement" attribute.
	 *         					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Create On Element NS</em>' attribute.
	 * @see #setCreateOnElementNS(String)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getBeanType_CreateOnElementNS()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='createOnElementNS'"
	 * @generated
	 */
	String getCreateOnElementNS();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.BeanType#getCreateOnElementNS <em>Create On Element NS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create On Element NS</em>' attribute.
	 * @see #getCreateOnElementNS()
	 * @generated
	 */
	void setCreateOnElementNS(String value);

	/**
	 * Returns the value of the '<em><b>Extend Lifecycle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *         						Defines if this bindings bean wiring may still wire
	 *         						beans after the element is processed. This enables
	 *         						flat XML support.
	 *         						The default value can be set with the global-parameter 'bean-population.default.extend.lifecycle'.
	 *         						Default the value is 'false'.
	 *         					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Extend Lifecycle</em>' attribute.
	 * @see #isSetExtendLifecycle()
	 * @see #unsetExtendLifecycle()
	 * @see #setExtendLifecycle(boolean)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getBeanType_ExtendLifecycle()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='extendLifecycle'"
	 * @generated
	 */
	boolean isExtendLifecycle();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.BeanType#isExtendLifecycle <em>Extend Lifecycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extend Lifecycle</em>' attribute.
	 * @see #isSetExtendLifecycle()
	 * @see #unsetExtendLifecycle()
	 * @see #isExtendLifecycle()
	 * @generated
	 */
	void setExtendLifecycle(boolean value);

	/**
	 * Unsets the value of the '{@link org.jboss.tools.smooks.model.javabean12.BeanType#isExtendLifecycle <em>Extend Lifecycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetExtendLifecycle()
	 * @see #isExtendLifecycle()
	 * @see #setExtendLifecycle(boolean)
	 * @generated
	 */
	void unsetExtendLifecycle();

	/**
	 * Returns whether the value of the '{@link org.jboss.tools.smooks.model.javabean12.BeanType#isExtendLifecycle <em>Extend Lifecycle</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Extend Lifecycle</em>' attribute is set.
	 * @see #unsetExtendLifecycle()
	 * @see #isExtendLifecycle()
	 * @see #setExtendLifecycle(boolean)
	 * @generated
	 */
	boolean isSetExtendLifecycle();

} // BeanType
