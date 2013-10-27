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
 * A representation of the model object '<em><b>Expression Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.ExpressionType#getValue <em>Value</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.ExpressionType#getExecOnElement <em>Exec On Element</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.ExpressionType#getExecOnElementNS <em>Exec On Element NS</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.ExpressionType#getInitVal <em>Init Val</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.ExpressionType#getProperty <em>Property</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.ExpressionType#getSetterMethod <em>Setter Method</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getExpressionType()
 * @model extendedMetaData="name='expression_._type' kind='simple'"
 * @generated
 */
public interface ExpressionType extends AbstractAnyType {
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
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getExpressionType_Value()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="name=':0' kind='simple'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.ExpressionType#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Exec On Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                                 The Source data event stream element event to use to control the execution of the expression
	 *                                 and binding of the result.
	 *                                 <p/>
	 *                                 Think of this as the element path (in the Source data) used to control execution of the
	 *                                 expression.
	 *                                 <h3>Example</h3>
	 *                                 If this attribute value is set to "order/orderItem", the expression will be executed (and
	 *                                 the result bound to the target property) when an "end" element event ("visitAfter")
	 *                                 for the element "orderItem" (with a parent element of "order") is encountered in the
	 *                                 Source data event stream.
	 *                             
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Exec On Element</em>' attribute.
	 * @see #setExecOnElement(String)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getExpressionType_ExecOnElement()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='execOnElement'"
	 * @generated
	 */
	String getExecOnElement();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.ExpressionType#getExecOnElement <em>Exec On Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exec On Element</em>' attribute.
	 * @see #getExecOnElement()
	 * @generated
	 */
	void setExecOnElement(String value);

	/**
	 * Returns the value of the '<em><b>Exec On Element NS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Namespace control for the "execOnElement" attribute.
	 *                             
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Exec On Element NS</em>' attribute.
	 * @see #setExecOnElementNS(String)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getExpressionType_ExecOnElementNS()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='execOnElementNS'"
	 * @generated
	 */
	String getExecOnElementNS();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.ExpressionType#getExecOnElementNS <em>Exec On Element NS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exec On Element NS</em>' attribute.
	 * @see #getExecOnElementNS()
	 * @generated
	 */
	void setExecOnElementNS(String value);

	/**
	 * Returns the value of the '<em><b>Init Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Initial value for the property.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Init Val</em>' attribute.
	 * @see #setInitVal(String)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getExpressionType_InitVal()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='initVal'"
	 * @generated
	 */
	String getInitVal();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.ExpressionType#getInitVal <em>Init Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Val</em>' attribute.
	 * @see #getInitVal()
	 * @generated
	 */
	void setInitVal(String value);

	/**
	 * Returns the value of the '<em><b>Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The class property to which the expression evaluation result
	 *                                 is to be bound. Not needed when binding to a Collection.
	 *                                 <p/>
	 *                                 The property attribute does not need to be specified when the "class" type on the parent "bindings" element
	 *                                 is a List/Array or Map.  In the case of a List/Array, the bean is simply added.  In the case of Map, the
	 *                                 element name (from the element specified in the "data" attribute) is used.
	 *                             
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Property</em>' attribute.
	 * @see #setProperty(String)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getExpressionType_Property()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='property'"
	 * @generated
	 */
	String getProperty();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.ExpressionType#getProperty <em>Property</em>}' attribute.
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
	 * 		        				The class method which is called to bind the data
	 * 		        				to the object. Not needed when binding to a Collection.
	 * 		        				<p/>
	 *                                 The setterMethod attribute does not need to be specified when the "class" type on the parent "bindings" element
	 *                                 is a List/Array or Map.  In the case of a List/Array, the bean is simply added.  In the case of Map, the
	 *                                 element name (from the element specified in the "data" attribute) is used.
	 * 		        			
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Setter Method</em>' attribute.
	 * @see #setSetterMethod(String)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getExpressionType_SetterMethod()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='setterMethod'"
	 * @generated
	 */
	String getSetterMethod();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.ExpressionType#getSetterMethod <em>Setter Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Setter Method</em>' attribute.
	 * @see #getSetterMethod()
	 * @generated
	 */
	void setSetterMethod(String value);

} // ExpressionType
