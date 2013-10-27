/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.medi;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Segments</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.medi.Segments#getSegment <em>Segment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.medi.MEdiPackage#getSegments()
 * @model extendedMetaData="name='Segments' kind='elementOnly'"
 * @generated
 */
public interface Segments extends MappingNode {
	/**
	 * Returns the value of the '<em><b>Segment</b></em>' containment reference list.
	 * The list contents are of type {@link org.jboss.tools.smooks.model.medi.Segment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Segment</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Segment</em>' containment reference list.
	 * @see org.jboss.tools.smooks.model.medi.MEdiPackage#getSegments_Segment()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='segment' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Segment> getSegment();

} // Segments
