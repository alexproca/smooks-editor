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
 * A representation of the model object '<em><b>Segment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.medi.Segment#getField <em>Field</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.medi.Segment#getSegment <em>Segment</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.medi.Segment#getMaxOccurs <em>Max Occurs</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.medi.Segment#getMinOccurs <em>Min Occurs</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.medi.Segment#getSegcode <em>Segcode</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.medi.Segment#isTruncatable <em>Truncatable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.medi.MEdiPackage#getSegment()
 * @model extendedMetaData="name='Segment' kind='elementOnly'"
 * @generated
 */
public interface Segment extends MappingNode {
	/**
	 * Returns the value of the '<em><b>Field</b></em>' containment reference list.
	 * The list contents are of type {@link org.jboss.tools.smooks.model.medi.Field}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field</em>' containment reference list.
	 * @see org.jboss.tools.smooks.model.medi.MEdiPackage#getSegment_Field()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='field' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Field> getField();

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
	 * @see org.jboss.tools.smooks.model.medi.MEdiPackage#getSegment_Segment()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='segment' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Segment> getSegment();

	/**
	 * Returns the value of the '<em><b>Max Occurs</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							The maximum number of times the segment must appear in this
	 * 							position within the EDI message.  For an unbounded max, set
	 * 							the maxOccurs value to -1.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Occurs</em>' attribute.
	 * @see #isSetMaxOccurs()
	 * @see #unsetMaxOccurs()
	 * @see #setMaxOccurs(int)
	 * @see org.jboss.tools.smooks.model.medi.MEdiPackage#getSegment_MaxOccurs()
	 * @model default="1" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='maxOccurs'"
	 * @generated
	 */
	int getMaxOccurs();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.medi.Segment#getMaxOccurs <em>Max Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Occurs</em>' attribute.
	 * @see #isSetMaxOccurs()
	 * @see #unsetMaxOccurs()
	 * @see #getMaxOccurs()
	 * @generated
	 */
	void setMaxOccurs(int value);

	/**
	 * Unsets the value of the '{@link org.jboss.tools.smooks.model.medi.Segment#getMaxOccurs <em>Max Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMaxOccurs()
	 * @see #getMaxOccurs()
	 * @see #setMaxOccurs(int)
	 * @generated
	 */
	void unsetMaxOccurs();

	/**
	 * Returns whether the value of the '{@link org.jboss.tools.smooks.model.medi.Segment#getMaxOccurs <em>Max Occurs</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Max Occurs</em>' attribute is set.
	 * @see #unsetMaxOccurs()
	 * @see #getMaxOccurs()
	 * @see #setMaxOccurs(int)
	 * @generated
	 */
	boolean isSetMaxOccurs();

	/**
	 * Returns the value of the '<em><b>Min Occurs</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							The minimum number of times the segment must appear in this
	 * 							position within the EDI message.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Min Occurs</em>' attribute.
	 * @see #isSetMinOccurs()
	 * @see #unsetMinOccurs()
	 * @see #setMinOccurs(int)
	 * @see org.jboss.tools.smooks.model.medi.MEdiPackage#getSegment_MinOccurs()
	 * @model default="1" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='minOccurs'"
	 * @generated
	 */
	int getMinOccurs();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.medi.Segment#getMinOccurs <em>Min Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Occurs</em>' attribute.
	 * @see #isSetMinOccurs()
	 * @see #unsetMinOccurs()
	 * @see #getMinOccurs()
	 * @generated
	 */
	void setMinOccurs(int value);

	/**
	 * Unsets the value of the '{@link org.jboss.tools.smooks.model.medi.Segment#getMinOccurs <em>Min Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMinOccurs()
	 * @see #getMinOccurs()
	 * @see #setMinOccurs(int)
	 * @generated
	 */
	void unsetMinOccurs();

	/**
	 * Returns whether the value of the '{@link org.jboss.tools.smooks.model.medi.Segment#getMinOccurs <em>Min Occurs</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Min Occurs</em>' attribute is set.
	 * @see #unsetMinOccurs()
	 * @see #getMinOccurs()
	 * @see #setMinOccurs(int)
	 * @generated
	 */
	boolean isSetMinOccurs();

	/**
	 * Returns the value of the '<em><b>Segcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Segcode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Segcode</em>' attribute.
	 * @see #setSegcode(String)
	 * @see org.jboss.tools.smooks.model.medi.MEdiPackage#getSegment_Segcode()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='segcode'"
	 * @generated
	 */
	String getSegcode();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.medi.Segment#getSegcode <em>Segcode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Segcode</em>' attribute.
	 * @see #getSegcode()
	 * @generated
	 */
	void setSegcode(String value);

	/**
	 * Returns the value of the '<em><b>Truncatable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Truncatable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Truncatable</em>' attribute.
	 * @see #isSetTruncatable()
	 * @see #unsetTruncatable()
	 * @see #setTruncatable(boolean)
	 * @see org.jboss.tools.smooks.model.medi.MEdiPackage#getSegment_Truncatable()
	 * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='truncatable'"
	 * @generated
	 */
	boolean isTruncatable();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.medi.Segment#isTruncatable <em>Truncatable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Truncatable</em>' attribute.
	 * @see #isSetTruncatable()
	 * @see #unsetTruncatable()
	 * @see #isTruncatable()
	 * @generated
	 */
	void setTruncatable(boolean value);

	/**
	 * Unsets the value of the '{@link org.jboss.tools.smooks.model.medi.Segment#isTruncatable <em>Truncatable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTruncatable()
	 * @see #isTruncatable()
	 * @see #setTruncatable(boolean)
	 * @generated
	 */
	void unsetTruncatable();

	/**
	 * Returns whether the value of the '{@link org.jboss.tools.smooks.model.medi.Segment#isTruncatable <em>Truncatable</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Truncatable</em>' attribute is set.
	 * @see #unsetTruncatable()
	 * @see #isTruncatable()
	 * @see #setTruncatable(boolean)
	 * @generated
	 */
	boolean isSetTruncatable();

} // Segment
