/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.csv12;

import java.math.BigInteger;

import org.jboss.tools.smooks.model.smooks.AbstractReader;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CSV12 Reader</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * CSV Reader
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getSingleBinding <em>Single Binding</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getListBinding <em>List Binding</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getMapBinding <em>Map Binding</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getEncoding <em>Encoding</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getFields <em>Fields</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#isIndent <em>Indent</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getQuote <em>Quote</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getRecordElementName <em>Record Element Name</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getRootElementName <em>Root Element Name</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getSeparator <em>Separator</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getSkipLines <em>Skip Lines</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.csv12.Csv12Package#getCSV12Reader()
 * @model extendedMetaData="name='reader' kind='elementOnly'"
 * @generated
 */
public interface CSV12Reader extends AbstractReader {
	/**
	 * Returns the value of the '<em><b>Single Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Single Binding</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Single Binding</em>' containment reference.
	 * @see #setSingleBinding(Binding)
	 * @see org.jboss.tools.smooks.model.csv12.Csv12Package#getCSV12Reader_SingleBinding()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='singleBinding' namespace='##targetNamespace'"
	 * @generated
	 */
	Binding getSingleBinding();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getSingleBinding <em>Single Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Single Binding</em>' containment reference.
	 * @see #getSingleBinding()
	 * @generated
	 */
	void setSingleBinding(Binding value);

	/**
	 * Returns the value of the '<em><b>List Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List Binding</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>List Binding</em>' containment reference.
	 * @see #setListBinding(Binding)
	 * @see org.jboss.tools.smooks.model.csv12.Csv12Package#getCSV12Reader_ListBinding()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='listBinding' namespace='##targetNamespace'"
	 * @generated
	 */
	Binding getListBinding();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getListBinding <em>List Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>List Binding</em>' containment reference.
	 * @see #getListBinding()
	 * @generated
	 */
	void setListBinding(Binding value);

	/**
	 * Returns the value of the '<em><b>Map Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map Binding</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Map Binding</em>' containment reference.
	 * @see #setMapBinding(MapBinding)
	 * @see org.jboss.tools.smooks.model.csv12.Csv12Package#getCSV12Reader_MapBinding()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='mapBinding' namespace='##targetNamespace'"
	 * @generated
	 */
	MapBinding getMapBinding();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getMapBinding <em>Map Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map Binding</em>' containment reference.
	 * @see #getMapBinding()
	 * @generated
	 */
	void setMapBinding(MapBinding value);

	/**
	 * Returns the value of the '<em><b>Encoding</b></em>' attribute.
	 * The default value is <code>"UTF-8"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *     						The encoding of the input stream. Default of 'UTF-8'
	 *     					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Encoding</em>' attribute.
	 * @see #isSetEncoding()
	 * @see #unsetEncoding()
	 * @see #setEncoding(String)
	 * @see org.jboss.tools.smooks.model.csv12.Csv12Package#getCSV12Reader_Encoding()
	 * @model default="UTF-8" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='encoding'"
	 * @generated
	 */
	String getEncoding();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getEncoding <em>Encoding</em>}' attribute.
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
	 * Unsets the value of the '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getEncoding <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEncoding()
	 * @see #getEncoding()
	 * @see #setEncoding(String)
	 * @generated
	 */
	void unsetEncoding();

	/**
	 * Returns whether the value of the '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getEncoding <em>Encoding</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Fields</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *     						Comma separated list of CSV record field names
	 *     					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fields</em>' attribute.
	 * @see #setFields(String)
	 * @see org.jboss.tools.smooks.model.csv12.Csv12Package#getCSV12Reader_Fields()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='fields'"
	 * @generated
	 */
	String getFields();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getFields <em>Fields</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fields</em>' attribute.
	 * @see #getFields()
	 * @generated
	 */
	void setFields(String value);

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
	 * @see org.jboss.tools.smooks.model.csv12.Csv12Package#getCSV12Reader_Indent()
	 * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='indent'"
	 * @generated
	 */
	boolean isIndent();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#isIndent <em>Indent</em>}' attribute.
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
	 * Unsets the value of the '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#isIndent <em>Indent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIndent()
	 * @see #isIndent()
	 * @see #setIndent(boolean)
	 * @generated
	 */
	void unsetIndent();

	/**
	 * Returns whether the value of the '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#isIndent <em>Indent</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Quote</b></em>' attribute.
	 * The default value is <code>"\""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *     						Quote character.  Default of '"'.
	 *     					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Quote</em>' attribute.
	 * @see #isSetQuote()
	 * @see #unsetQuote()
	 * @see #setQuote(String)
	 * @see org.jboss.tools.smooks.model.csv12.Csv12Package#getCSV12Reader_Quote()
	 * @model default="\"" unsettable="true" dataType="csv12.Char"
	 *        extendedMetaData="kind='attribute' name='quote'"
	 * @generated
	 */
	String getQuote();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getQuote <em>Quote</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quote</em>' attribute.
	 * @see #isSetQuote()
	 * @see #unsetQuote()
	 * @see #getQuote()
	 * @generated
	 */
	void setQuote(String value);

	/**
	 * Unsets the value of the '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getQuote <em>Quote</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetQuote()
	 * @see #getQuote()
	 * @see #setQuote(String)
	 * @generated
	 */
	void unsetQuote();

	/**
	 * Returns whether the value of the '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getQuote <em>Quote</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Quote</em>' attribute is set.
	 * @see #unsetQuote()
	 * @see #getQuote()
	 * @see #setQuote(String)
	 * @generated
	 */
	boolean isSetQuote();

	/**
	 * Returns the value of the '<em><b>Record Element Name</b></em>' attribute.
	 * The default value is <code>"csv-record"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *     						Name of csv record element.
	 *     					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Record Element Name</em>' attribute.
	 * @see #isSetRecordElementName()
	 * @see #unsetRecordElementName()
	 * @see #setRecordElementName(String)
	 * @see org.jboss.tools.smooks.model.csv12.Csv12Package#getCSV12Reader_RecordElementName()
	 * @model default="csv-record" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='recordElementName'"
	 * @generated
	 */
	String getRecordElementName();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getRecordElementName <em>Record Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Record Element Name</em>' attribute.
	 * @see #isSetRecordElementName()
	 * @see #unsetRecordElementName()
	 * @see #getRecordElementName()
	 * @generated
	 */
	void setRecordElementName(String value);

	/**
	 * Unsets the value of the '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getRecordElementName <em>Record Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRecordElementName()
	 * @see #getRecordElementName()
	 * @see #setRecordElementName(String)
	 * @generated
	 */
	void unsetRecordElementName();

	/**
	 * Returns whether the value of the '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getRecordElementName <em>Record Element Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Record Element Name</em>' attribute is set.
	 * @see #unsetRecordElementName()
	 * @see #getRecordElementName()
	 * @see #setRecordElementName(String)
	 * @generated
	 */
	boolean isSetRecordElementName();

	/**
	 * Returns the value of the '<em><b>Root Element Name</b></em>' attribute.
	 * The default value is <code>"csv-set"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *     						Name of csv root element.
	 *     					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Root Element Name</em>' attribute.
	 * @see #isSetRootElementName()
	 * @see #unsetRootElementName()
	 * @see #setRootElementName(String)
	 * @see org.jboss.tools.smooks.model.csv12.Csv12Package#getCSV12Reader_RootElementName()
	 * @model default="csv-set" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='rootElementName'"
	 * @generated
	 */
	String getRootElementName();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getRootElementName <em>Root Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root Element Name</em>' attribute.
	 * @see #isSetRootElementName()
	 * @see #unsetRootElementName()
	 * @see #getRootElementName()
	 * @generated
	 */
	void setRootElementName(String value);

	/**
	 * Unsets the value of the '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getRootElementName <em>Root Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRootElementName()
	 * @see #getRootElementName()
	 * @see #setRootElementName(String)
	 * @generated
	 */
	void unsetRootElementName();

	/**
	 * Returns whether the value of the '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getRootElementName <em>Root Element Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Root Element Name</em>' attribute is set.
	 * @see #unsetRootElementName()
	 * @see #getRootElementName()
	 * @see #setRootElementName(String)
	 * @generated
	 */
	boolean isSetRootElementName();

	/**
	 * Returns the value of the '<em><b>Separator</b></em>' attribute.
	 * The default value is <code>","</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *     						 Field separator character.  Default of ','.
	 *     					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Separator</em>' attribute.
	 * @see #isSetSeparator()
	 * @see #unsetSeparator()
	 * @see #setSeparator(String)
	 * @see org.jboss.tools.smooks.model.csv12.Csv12Package#getCSV12Reader_Separator()
	 * @model default="," unsettable="true" dataType="csv12.Char"
	 *        extendedMetaData="kind='attribute' name='separator'"
	 * @generated
	 */
	String getSeparator();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getSeparator <em>Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Separator</em>' attribute.
	 * @see #isSetSeparator()
	 * @see #unsetSeparator()
	 * @see #getSeparator()
	 * @generated
	 */
	void setSeparator(String value);

	/**
	 * Unsets the value of the '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getSeparator <em>Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSeparator()
	 * @see #getSeparator()
	 * @see #setSeparator(String)
	 * @generated
	 */
	void unsetSeparator();

	/**
	 * Returns whether the value of the '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getSeparator <em>Separator</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Separator</em>' attribute is set.
	 * @see #unsetSeparator()
	 * @see #getSeparator()
	 * @see #setSeparator(String)
	 * @generated
	 */
	boolean isSetSeparator();

	/**
	 * Returns the value of the '<em><b>Skip Lines</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *     						Number of lines to skip before processing starts. Default of 0.
	 *     					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Skip Lines</em>' attribute.
	 * @see #isSetSkipLines()
	 * @see #unsetSkipLines()
	 * @see #setSkipLines(BigInteger)
	 * @see org.jboss.tools.smooks.model.csv12.Csv12Package#getCSV12Reader_SkipLines()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='skipLines'"
	 * @generated
	 */
	BigInteger getSkipLines();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getSkipLines <em>Skip Lines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Skip Lines</em>' attribute.
	 * @see #isSetSkipLines()
	 * @see #unsetSkipLines()
	 * @see #getSkipLines()
	 * @generated
	 */
	void setSkipLines(BigInteger value);

	/**
	 * Unsets the value of the '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getSkipLines <em>Skip Lines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSkipLines()
	 * @see #getSkipLines()
	 * @see #setSkipLines(BigInteger)
	 * @generated
	 */
	void unsetSkipLines();

	/**
	 * Returns whether the value of the '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getSkipLines <em>Skip Lines</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Skip Lines</em>' attribute is set.
	 * @see #unsetSkipLines()
	 * @see #getSkipLines()
	 * @see #setSkipLines(BigInteger)
	 * @generated
	 */
	boolean isSetSkipLines();

} // CSV12Reader
