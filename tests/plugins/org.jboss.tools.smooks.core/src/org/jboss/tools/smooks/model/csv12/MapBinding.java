/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.csv12;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *                 CSV Binding Configuration.
 *                 <p/>
 *                 Supports simple automatic java binding of CSV records onto a bean based on the configured field
 *                 names matching the target bean's property names.  For more complex binding, use the main Java
 *                 binding configurations.
 *             
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.csv12.MapBinding#getKeyField <em>Key Field</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.csv12.Csv12Package#getMapBinding()
 * @model extendedMetaData="name='mapBinding' kind='empty'"
 * @generated
 */
public interface MapBinding extends Binding {
	/**
	 * Returns the value of the '<em><b>Key Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                             The CSV field whose value is used as the Map key value.
	 *                         
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Key Field</em>' attribute.
	 * @see #setKeyField(String)
	 * @see org.jboss.tools.smooks.model.csv12.Csv12Package#getMapBinding_KeyField()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='keyField'"
	 * @generated
	 */
	String getKeyField();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.csv12.MapBinding#getKeyField <em>Key Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key Field</em>' attribute.
	 * @see #getKeyField()
	 * @generated
	 */
	void setKeyField(String value);

} // MapBinding
