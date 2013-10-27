/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.javabean12;


import org.eclipse.emf.common.util.EList;
import org.jboss.tools.smooks.model.common.AbstractAnyType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.ValueType#getDecodeParam <em>Decode Param</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.ValueType#getData <em>Data</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.ValueType#getDataNS <em>Data NS</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.ValueType#getDecoder <em>Decoder</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.ValueType#getDefault <em>Default</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.ValueType#getProperty <em>Property</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.ValueType#getSetterMethod <em>Setter Method</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getValueType()
 * @model extendedMetaData="name='value_._type' kind='elementOnly'"
 * @generated
 */
public interface ValueType extends AbstractAnyType {
	/**
	 * Returns the value of the '<em><b>Decode Param</b></em>' containment reference list.
	 * The list contents are of type {@link org.jboss.tools.smooks.model.javabean12.DecodeParamType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                  Data Decode Parameter.
	 *                  <p/>
	 *                  Some decoders may require parameters in order to complete the decoding process e.g. the
	 *                  <a href="http://milyn.codehaus.org/javadoc/smooks/org/milyn/javabean/decoders/DateDecoder.html">DateDecoder</a>.
	 *                  These parameters can be specified by adding &lt;decodeParam&gt; sub-elements to the &lt;value&gt;
	 *                  binding element. Review the Decoder's Javadoc for details of the custom parameters.
	 *                  <p/>
	 *                  <u>Example:</u>
	 * <pre>
	 * &lt;jb:value property="date" data="header/date" decoder="<a href="http://milyn.codehaus.org/javadoc/smooks/org/milyn/javabean/decoders/DateDecoder.html">Date</a>"&gt;
	 *     &lt;jb:decodeParam name="format"&gt;EEE MMM dd HH:mm:ss z yyyy&lt;/jb:decodeParam&gt;
	 *     &lt;jb:decodeParam name="locale-language"&gt;en&lt;/jb:decodeParam&gt;
	 *     &lt;jb:decodeParam name="locale-country"&gt;IE&lt;/jb:decodeParam&gt;
	 * &lt;/jb:value&gt;
	 * </pre>
	 *              
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Decode Param</em>' containment reference list.
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getValueType_DecodeParam()
	 * @model type="javabean12.DecodeParamType" containment="true"
	 *        extendedMetaData="kind='element' name='decodeParam' namespace='##targetNamespace'"
	 * @generated
	 */
	EList getDecodeParam();

	/**
	 * Returns the value of the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                         The Source data event stream element event defining the data to be bound.
	 *                         <p/>
	 *                         Think of this as the element path (in the Source data) to the data.
	 *                         <h3>Examples</h3>
	 *                         <ul>
	 *                             <li>
	 *                                 <b>Element Text Data:</b>
	 *                                 "order/orderid"
	 *                             </li>
	 *                             <li>
	 *                                 <b>Element Attribute Data:</b>
	 *                                 "order/header/@date"
	 *                             </li>
	 *                         </ul>
	 *                     
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Data</em>' attribute.
	 * @see #setData(String)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getValueType_Data()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='data'"
	 * @generated
	 */
	String getData();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.ValueType#getData <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' attribute.
	 * @see #getData()
	 * @generated
	 */
	void setData(String value);

	/**
	 * Returns the value of the '<em><b>Data NS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The namespace for the "data" selector (see "data" attribute).
	 *                     
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Data NS</em>' attribute.
	 * @see #setDataNS(String)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getValueType_DataNS()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='dataNS'"
	 * @generated
	 */
	String getDataNS();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.ValueType#getDataNS <em>Data NS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data NS</em>' attribute.
	 * @see #getDataNS()
	 * @generated
	 */
	void setDataNS(String value);

	/**
	 * Returns the value of the '<em><b>Decoder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                         Data Decoder.
	 *                         <p/>
	 *                         This attribute specifies the
	 *                         <a href="http://milyn.codehaus.org/javadoc/smooks/org/milyn/javabean/DataDecoder.html">DataDecoder</a>
	 *                         to be used to decode the data (see "data" attribute) before setting it on the target bean
	 *                         property(see "property" attribute).
	 *                         <p/>
	 *                         Smooks contains decoders for all of the main data types (Long, Integer etc). In these cases,
	 *                         just specify the decoder as being "Long", "Integer", "Date" etc i.e. no need to specify the fully qualified
	 *                         <a href="http://milyn.codehaus.org/javadoc/smooks/org/milyn/javabean/DataDecoder.html">DataDecoder</a>
	 *                         class name. The fully qualified class name is only required for custom
	 *                         <a href="http://milyn.codehaus.org/javadoc/smooks/org/milyn/javabean/DataDecoder.html">DataDecoder</a>
	 *                         implementations.
	 * 
	 *                         <h3>Primitive Types</h3>
	 *                         Smooks does not define special decoders for any of the primitive types. To decode a
	 *                         primitive property type, just specify the Object equivalent decoder e.g. specify "Integer" for "int",
	 *                         "Double" for "double" etc etc.
	 * 
	 *                         <h3>Decode Parameters</h3>
	 *                         Some decoders may require parameters in order to complete the decoding process e.g. the
	 *                         <a href="http://milyn.codehaus.org/javadoc/smooks/org/milyn/javabean/decoders/DateDecoder.html">DateDecoder</a>.
	 *                         These parameters can be specified by adding &lt;decodeParam&gt; sub-elements to the &lt;value&gt;
	 *                         binding element. Review the Decoder's Javadoc for details of the custom parameters.
	 *                         <p/>
	 *                         <u>Example:</u>
	 * <pre>
	 *     &lt;jb:value property="date" data="header/date" decoder="<a href="http://milyn.codehaus.org/javadoc/smooks/org/milyn/javabean/decoders/DateDecoder.html">Date</a>"&gt;
	 *         &lt;jb:decodeParam name="format"&gt;EEE MMM dd HH:mm:ss z yyyy&lt;/jb:decodeParam&gt;
	 *         &lt;jb:decodeParam name="locale-language"&gt;en&lt;/jb:decodeParam&gt;
	 *         &lt;jb:decodeParam name="locale-country"&gt;IE&lt;/jb:decodeParam&gt;
	 *     &lt;/jb:value&gt;
	 * </pre>
	 * 
	 *                         <h3>Custom Data Decoding</h3>
	 *                         For custom data decoding, implement the
	 *                         <a href="http://milyn.codehaus.org/javadoc/smooks/org/milyn/javabean/DataDecoder.html">
	 *                             DataDecoder
	 *                         </a>
	 *                         interface and specify the decoder using the fully qualified class name of the new
	 *                         implementation.
	 *                     
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Decoder</em>' attribute.
	 * @see #setDecoder(String)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getValueType_Decoder()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='decoder'"
	 * @generated
	 */
	String getDecoder();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.ValueType#getDecoder <em>Decoder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Decoder</em>' attribute.
	 * @see #getDecoder()
	 * @generated
	 */
	void setDecoder(String value);

	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The default data value, where a null/empty data String is returned
	 *                         for the data element.
	 *                     
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(String)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getValueType_Default()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='default'"
	 * @generated
	 */
	String getDefault();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.ValueType#getDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(String value);

	/**
	 * Returns the value of the '<em><b>Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The class property to which the decoded data is to be bound.
	 *                         <p/>
	 *                         The property attribute does not need to be specified when the "class" type on the parent "bindings" element
	 *                         is a List/Array or Map.  In the case of a List/Array, the bean is simply added.  In the case of Map, the
	 *                         element name (from the element specified in the "data" attribute) is used.
	 *                     
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Property</em>' attribute.
	 * @see #setProperty(String)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getValueType_Property()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='property'"
	 * @generated
	 */
	String getProperty();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.ValueType#getProperty <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' attribute.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(String value);

	/**
	 * Returns the value of the '<em><b>Setter Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *         				The class method which is called to bind the data
	 *         				to the object. Not needed when binding to a Collection.
	 *         				<p/>
	 *                         The setterMethod attribute does not need to be specified when the "class" type on the parent "bindings" element
	 *                         is a List/Array or Map.  In the case of a List/Array, the bean is simply added.  In the case of Map, the
	 *                         element name (from the element specified in the "data" attribute) is used.
	 *         			
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Setter Method</em>' attribute.
	 * @see #setSetterMethod(String)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getValueType_SetterMethod()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='setterMethod'"
	 * @generated
	 */
	String getSetterMethod();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.ValueType#getSetterMethod <em>Setter Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Setter Method</em>' attribute.
	 * @see #getSetterMethod()
	 * @generated
	 */
	void setSetterMethod(String value);

} // ValueType
