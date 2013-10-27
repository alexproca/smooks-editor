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
 * A representation of the model object '<em><b>Handlers Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *                     Reader Handler Classes.
 *                     <p/>
 *                     Set a handler on the reader instance e.g. an EntityResolver, ErrorHandler etc.
 *                 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.HandlersType#getHandler <em>Handler</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getHandlersType()
 * @model extendedMetaData="name='handlers_._type' kind='elementOnly'"
 * @generated
 */
public interface HandlersType extends AbstractAnyType {
	/**
	 * Returns the value of the '<em><b>Handler</b></em>' containment reference list.
	 * The list contents are of type {@link org.jboss.tools.smooks.model.smooks.HandlerType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Handler</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Handler</em>' containment reference list.
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getHandlersType_Handler()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='handler' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<HandlerType> getHandler();

} // HandlersType
