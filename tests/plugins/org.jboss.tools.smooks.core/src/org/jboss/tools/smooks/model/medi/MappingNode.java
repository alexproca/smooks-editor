/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.medi;

import org.jboss.tools.smooks.model.common.AbstractAnyType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.medi.MappingNode#getXmltag <em>Xmltag</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.medi.MEdiPackage#getMappingNode()
 * @model extendedMetaData="name='MappingNode' kind='empty'"
 * @generated
 */
public interface MappingNode extends AbstractAnyType {
	/**
	 * Returns the value of the '<em><b>Xmltag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xmltag</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xmltag</em>' attribute.
	 * @see #setXmltag(String)
	 * @see org.jboss.tools.smooks.model.medi.MEdiPackage#getMappingNode_Xmltag()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='xmltag'"
	 * @generated
	 */
	String getXmltag();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.medi.MappingNode#getXmltag <em>Xmltag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xmltag</em>' attribute.
	 * @see #getXmltag()
	 * @generated
	 */
	void setXmltag(String value);

} // MappingNode
