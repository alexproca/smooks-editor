/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.freemarker;

import org.jboss.tools.smooks.model.common.AbstractAnyType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *                 Inline the templating result into the <b>Smooks.filter</b> Result message.
 *             
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.freemarker.Inline#getDirective <em>Directive</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.freemarker.FreemarkerPackage#getInline()
 * @model extendedMetaData="name='inline' kind='empty'"
 * @generated
 */
public interface Inline extends AbstractAnyType {
	/**
	 * Returns the value of the '<em><b>Directive</b></em>' attribute.
	 * The literals are from the enumeration {@link org.jboss.tools.smooks.model.freemarker.InlineDirective}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                     How the templating result is to be used (relative to the element on which it
	 *                     is applied).
	 *                 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Directive</em>' attribute.
	 * @see org.jboss.tools.smooks.model.freemarker.InlineDirective
	 * @see #isSetDirective()
	 * @see #unsetDirective()
	 * @see #setDirective(InlineDirective)
	 * @see org.jboss.tools.smooks.model.freemarker.FreemarkerPackage#getInline_Directive()
	 * @model unsettable="true" required="true"
	 *        extendedMetaData="kind='attribute' name='directive'"
	 * @generated
	 */
	InlineDirective getDirective();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.freemarker.Inline#getDirective <em>Directive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Directive</em>' attribute.
	 * @see org.jboss.tools.smooks.model.freemarker.InlineDirective
	 * @see #isSetDirective()
	 * @see #unsetDirective()
	 * @see #getDirective()
	 * @generated
	 */
	void setDirective(InlineDirective value);

	/**
	 * Unsets the value of the '{@link org.jboss.tools.smooks.model.freemarker.Inline#getDirective <em>Directive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDirective()
	 * @see #getDirective()
	 * @see #setDirective(InlineDirective)
	 * @generated
	 */
	void unsetDirective();

	/**
	 * Returns whether the value of the '{@link org.jboss.tools.smooks.model.freemarker.Inline#getDirective <em>Directive</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Directive</em>' attribute is set.
	 * @see #unsetDirective()
	 * @see #getDirective()
	 * @see #setDirective(InlineDirective)
	 * @generated
	 */
	boolean isSetDirective();

} // Inline
