/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.json12;

import org.jboss.tools.smooks.model.smooks.AbstractReader;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reader</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * JSON Reader
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.json12.Json12Reader#getKeyMap <em>Key Map</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.json12.Json12Reader#getArrayElementName <em>Array Element Name</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.json12.Json12Reader#getEncoding <em>Encoding</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.json12.Json12Reader#getIllegalElementNameCharReplacement <em>Illegal Element Name Char Replacement</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.json12.Json12Reader#isIndent <em>Indent</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.json12.Json12Reader#getKeyPrefixOnNumeric <em>Key Prefix On Numeric</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.json12.Json12Reader#getKeyWhitspaceReplacement <em>Key Whitspace Replacement</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.json12.Json12Reader#getNullValueReplacement <em>Null Value Replacement</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.json12.Json12Reader#getRootName <em>Root Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.json12.Json12Package#getJson12Reader()
 * @model extendedMetaData="name='reader' kind='elementOnly'"
 * @generated
 */
public interface Json12Reader extends AbstractReader {
	/**
	 * Returns the value of the '<em><b>Key Map</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 				    		 	Defines a JSON element name mapping
	 * 				    		 	The "from" key will be replaced with the "to" key or the contents of the element.
	 * 				    		 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Key Map</em>' containment reference.
	 * @see #setKeyMap(KeyMap)
	 * @see org.jboss.tools.smooks.model.json12.Json12Package#getJson12Reader_KeyMap()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='keyMap' namespace='##targetNamespace'"
	 * @generated
	 */
	KeyMap getKeyMap();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.json12.Json12Reader#getKeyMap <em>Key Map</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key Map</em>' containment reference.
	 * @see #getKeyMap()
	 * @generated
	 */
	void setKeyMap(KeyMap value);

	/**
	 * Returns the value of the '<em><b>Array Element Name</b></em>' attribute.
	 * The default value is <code>"element"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 			    		 	The element name of a array element. Default of 'element'.
	 * 			    		 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Array Element Name</em>' attribute.
	 * @see #isSetArrayElementName()
	 * @see #unsetArrayElementName()
	 * @see #setArrayElementName(String)
	 * @see org.jboss.tools.smooks.model.json12.Json12Package#getJson12Reader_ArrayElementName()
	 * @model default="element" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='arrayElementName'"
	 * @generated
	 */
	String getArrayElementName();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.json12.Json12Reader#getArrayElementName <em>Array Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Array Element Name</em>' attribute.
	 * @see #isSetArrayElementName()
	 * @see #unsetArrayElementName()
	 * @see #getArrayElementName()
	 * @generated
	 */
	void setArrayElementName(String value);

	/**
	 * Unsets the value of the '{@link org.jboss.tools.smooks.model.json12.Json12Reader#getArrayElementName <em>Array Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetArrayElementName()
	 * @see #getArrayElementName()
	 * @see #setArrayElementName(String)
	 * @generated
	 */
	void unsetArrayElementName();

	/**
	 * Returns whether the value of the '{@link org.jboss.tools.smooks.model.json12.Json12Reader#getArrayElementName <em>Array Element Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Array Element Name</em>' attribute is set.
	 * @see #unsetArrayElementName()
	 * @see #getArrayElementName()
	 * @see #setArrayElementName(String)
	 * @generated
	 */
	boolean isSetArrayElementName();

	/**
	 * Returns the value of the '<em><b>Encoding</b></em>' attribute.
	 * The default value is <code>"UTF-8"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 			    		 	The encoding of the input stream. Default of 'UTF-8'
	 * 			    		 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Encoding</em>' attribute.
	 * @see #isSetEncoding()
	 * @see #unsetEncoding()
	 * @see #setEncoding(String)
	 * @see org.jboss.tools.smooks.model.json12.Json12Package#getJson12Reader_Encoding()
	 * @model default="UTF-8" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='encoding'"
	 * @generated
	 */
	String getEncoding();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.json12.Json12Reader#getEncoding <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Encoding</em>' attribute.
	 * @see #isSetEncoding()
	 * @see #unsetEncoding()
	 * @see #getEncoding()
	 * @generated
	 */
	void setEncoding(String value);

	/**
	 * Unsets the value of the '{@link org.jboss.tools.smooks.model.json12.Json12Reader#getEncoding <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEncoding()
	 * @see #getEncoding()
	 * @see #setEncoding(String)
	 * @generated
	 */
	void unsetEncoding();

	/**
	 * Returns whether the value of the '{@link org.jboss.tools.smooks.model.json12.Json12Reader#getEncoding <em>Encoding</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Encoding</em>' attribute is set.
	 * @see #unsetEncoding()
	 * @see #getEncoding()
	 * @see #setEncoding(String)
	 * @generated
	 */
	boolean isSetEncoding();

	/**
	 * Returns the value of the '<em><b>Illegal Element Name Char Replacement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 			    		 	If illegal characters are encountered in a JSON element name then they are replaced with this value.
	 * 			    		 	By default this is not defined, so that the reader doesn't doesn't search for illegal characters.
	 * 			    		 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Illegal Element Name Char Replacement</em>' attribute.
	 * @see #setIllegalElementNameCharReplacement(String)
	 * @see org.jboss.tools.smooks.model.json12.Json12Package#getJson12Reader_IllegalElementNameCharReplacement()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='illegalElementNameCharReplacement'"
	 * @generated
	 */
	String getIllegalElementNameCharReplacement();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.json12.Json12Reader#getIllegalElementNameCharReplacement <em>Illegal Element Name Char Replacement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Illegal Element Name Char Replacement</em>' attribute.
	 * @see #getIllegalElementNameCharReplacement()
	 * @generated
	 */
	void setIllegalElementNameCharReplacement(String value);

	/**
	 * Returns the value of the '<em><b>Indent</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                             Add indentation character data to the generated event stream.  This simply makes
	 *                             the generated event stream easier to read in its serialized form.  Useful for
	 *                             testing etc.
	 *                         
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Indent</em>' attribute.
	 * @see #isSetIndent()
	 * @see #unsetIndent()
	 * @see #setIndent(boolean)
	 * @see org.jboss.tools.smooks.model.json12.Json12Package#getJson12Reader_Indent()
	 * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='indent'"
	 * @generated
	 */
	boolean isIndent();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.json12.Json12Reader#isIndent <em>Indent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indent</em>' attribute.
	 * @see #isSetIndent()
	 * @see #unsetIndent()
	 * @see #isIndent()
	 * @generated
	 */
	void setIndent(boolean value);

	/**
	 * Unsets the value of the '{@link org.jboss.tools.smooks.model.json12.Json12Reader#isIndent <em>Indent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIndent()
	 * @see #isIndent()
	 * @see #setIndent(boolean)
	 * @generated
	 */
	void unsetIndent();

	/**
	 * Returns whether the value of the '{@link org.jboss.tools.smooks.model.json12.Json12Reader#isIndent <em>Indent</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Indent</em>' attribute is set.
	 * @see #unsetIndent()
	 * @see #isIndent()
	 * @see #setIndent(boolean)
	 * @generated
	 */
	boolean isSetIndent();

	/**
	 * Returns the value of the '<em><b>Key Prefix On Numeric</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 			    		 	The prefix character to add if the JSON node name starts with a number.
	 * 			    		 	By default this is not defined, so that the reader doesn't search for element names that start with a number.
	 * 			    		 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Key Prefix On Numeric</em>' attribute.
	 * @see #setKeyPrefixOnNumeric(String)
	 * @see org.jboss.tools.smooks.model.json12.Json12Package#getJson12Reader_KeyPrefixOnNumeric()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='keyPrefixOnNumeric'"
	 * @generated
	 */
	String getKeyPrefixOnNumeric();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.json12.Json12Reader#getKeyPrefixOnNumeric <em>Key Prefix On Numeric</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key Prefix On Numeric</em>' attribute.
	 * @see #getKeyPrefixOnNumeric()
	 * @generated
	 */
	void setKeyPrefixOnNumeric(String value);

	/**
	 * Returns the value of the '<em><b>Key Whitspace Replacement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 			    		 	The replacement character for whitespaces in a JSON map key.
	 * 			    		 	By default this not defined, so that the reader doesn't search for whitespaces.
	 * 			    		 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Key Whitspace Replacement</em>' attribute.
	 * @see #setKeyWhitspaceReplacement(String)
	 * @see org.jboss.tools.smooks.model.json12.Json12Package#getJson12Reader_KeyWhitspaceReplacement()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='keyWhitspaceReplacement'"
	 * @generated
	 */
	String getKeyWhitspaceReplacement();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.json12.Json12Reader#getKeyWhitspaceReplacement <em>Key Whitspace Replacement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key Whitspace Replacement</em>' attribute.
	 * @see #getKeyWhitspaceReplacement()
	 * @generated
	 */
	void setKeyWhitspaceReplacement(String value);

	/**
	 * Returns the value of the '<em><b>Null Value Replacement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 			    		 	The replacement string for JSON NULL values. Default is an empty string.
	 * 			    		 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Null Value Replacement</em>' attribute.
	 * @see #setNullValueReplacement(String)
	 * @see org.jboss.tools.smooks.model.json12.Json12Package#getJson12Reader_NullValueReplacement()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='nullValueReplacement'"
	 * @generated
	 */
	String getNullValueReplacement();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.json12.Json12Reader#getNullValueReplacement <em>Null Value Replacement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Null Value Replacement</em>' attribute.
	 * @see #getNullValueReplacement()
	 * @generated
	 */
	void setNullValueReplacement(String value);

	/**
	 * Returns the value of the '<em><b>Root Name</b></em>' attribute.
	 * The default value is <code>"json"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 			    		 	The element name of the document root. Default of 'json'.
	 * 			    		 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Root Name</em>' attribute.
	 * @see #isSetRootName()
	 * @see #unsetRootName()
	 * @see #setRootName(String)
	 * @see org.jboss.tools.smooks.model.json12.Json12Package#getJson12Reader_RootName()
	 * @model default="json" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='rootName'"
	 * @generated
	 */
	String getRootName();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.json12.Json12Reader#getRootName <em>Root Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root Name</em>' attribute.
	 * @see #isSetRootName()
	 * @see #unsetRootName()
	 * @see #getRootName()
	 * @generated
	 */
	void setRootName(String value);

	/**
	 * Unsets the value of the '{@link org.jboss.tools.smooks.model.json12.Json12Reader#getRootName <em>Root Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRootName()
	 * @see #getRootName()
	 * @see #setRootName(String)
	 * @generated
	 */
	void unsetRootName();

	/**
	 * Returns whether the value of the '{@link org.jboss.tools.smooks.model.json12.Json12Reader#getRootName <em>Root Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Root Name</em>' attribute is set.
	 * @see #unsetRootName()
	 * @see #getRootName()
	 * @see #setRootName(String)
	 * @generated
	 */
	boolean isSetRootName();

} // Json12Reader
