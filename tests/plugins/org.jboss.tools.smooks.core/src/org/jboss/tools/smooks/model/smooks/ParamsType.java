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
 * A representation of the model object '<em><b>Params Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Resource Parameters
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.ParamsType#getParam <em>Param</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getParamsType()
 * @model extendedMetaData="name='params_._type' kind='elementOnly'"
 * @generated
 */
public interface ParamsType extends AbstractAnyType {
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
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getParamsType_Param()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='param' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ParamType> getParam();

} // ParamsType
