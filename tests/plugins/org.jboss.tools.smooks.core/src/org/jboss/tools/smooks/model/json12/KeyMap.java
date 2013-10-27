/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.json12;


import org.eclipse.emf.common.util.EList;
import org.jboss.tools.smooks.model.common.AbstractAnyType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Key Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.json12.KeyMap#getKey <em>Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.json12.Json12Package#getKeyMap()
 * @model extendedMetaData="name='keyMap' kind='elementOnly'"
 * @generated
 */
public interface KeyMap extends AbstractAnyType {
	/**
	 * Returns the value of the '<em><b>Key</b></em>' containment reference list.
	 * The list contents are of type {@link org.jboss.tools.smooks.model.json12.Key}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 			   		 	Defines a JSON element name mapping
	 * 			   		 	The "from" key will be replaced with the "to" key or the contents of this element.
	 * 		   		 	
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Key</em>' containment reference list.
	 * @see org.jboss.tools.smooks.model.json12.Json12Package#getKeyMap_Key()
	 * @model type="json12.Key" containment="true" required="true"
	 *        extendedMetaData="kind='element' name='key' namespace='##targetNamespace'"
	 * @generated
	 */
	EList getKey();

} // KeyMap
