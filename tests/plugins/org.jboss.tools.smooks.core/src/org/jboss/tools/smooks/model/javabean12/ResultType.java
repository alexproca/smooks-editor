/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.javabean12;

import org.jboss.tools.smooks.model.smooks.ElementVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.ResultType#getRetainBeans <em>Retain Beans</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getResultType()
 * @model extendedMetaData="name='result_._type' kind='elementOnly'"
 * @generated
 */
public interface ResultType extends ElementVisitor {
	/**
	 * Returns the value of the '<em><b>Retain Beans</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Comma separated list of beanIds to be retained in the Bean context.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Retain Beans</em>' attribute.
	 * @see #setRetainBeans(String)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getResultType_RetainBeans()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='retainBeans'"
	 * @generated
	 */
	String getRetainBeans();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.ResultType#getRetainBeans <em>Retain Beans</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Retain Beans</em>' attribute.
	 * @see #getRetainBeans()
	 * @generated
	 */
	void setRetainBeans(String value);

} // ResultType
