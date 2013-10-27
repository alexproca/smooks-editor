/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.javabean12;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getBean <em>Bean</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getDecodeParam <em>Decode Param</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getResult <em>Result</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getValue <em>Value</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getWiring <em>Wiring</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getJavabean12DocumentRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface Javabean12DocumentRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getJavabean12DocumentRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getJavabean12DocumentRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String" valueType="java.lang.String" transient="true"
	 *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
	 * @generated
	 */
	EMap getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getJavabean12DocumentRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String" valueType="java.lang.String" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Bean</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 				Javabean Bindings Configuration.
	 * 				<h3>Bean Instance Creation</h3>
	 * 				Instances of the class specified in the
	 * 				"class" attribute are created and bound into
	 * 				the bean context under the ID specified by
	 * 				the "beanId" attribute. The bean instance is
	 * 				created (and bound) when the element event
	 * 				specified in the "createOnElement" attribute
	 * 				is encountered in the Source data event
	 * 				stream (see also "createOnElementNS").
	 * 				<h3>Bean Property/Member Population</h3>
	 * 				Bean property/member population is
	 * 				controlled by the binding sub-elements
	 * 				nested inside this element. Use your IDE to
	 * 				discover these elements.
	 * 			
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bean</em>' containment reference.
	 * @see #setBean(BeanType)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getJavabean12DocumentRoot_Bean()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='bean' namespace='##targetNamespace' affiliation='http://www.milyn.org/xsd/smooks-1.1.xsd#abstract-resource-config'"
	 * @generated
	 */
	BeanType getBean();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getBean <em>Bean</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bean</em>' containment reference.
	 * @see #getBean()
	 * @generated
	 */
	void setBean(BeanType value);

	/**
	 * Returns the value of the '<em><b>Decode Param</b></em>' containment reference.
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
	 * @return the value of the '<em>Decode Param</em>' containment reference.
	 * @see #setDecodeParam(DecodeParamType)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getJavabean12DocumentRoot_DecodeParam()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='decodeParam' namespace='##targetNamespace'"
	 * @generated
	 */
	DecodeParamType getDecodeParam();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getDecodeParam <em>Decode Param</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Decode Param</em>' containment reference.
	 * @see #getDecodeParam()
	 * @generated
	 */
	void setDecodeParam(DecodeParamType value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Expression based Configuration
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(ExpressionType)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getJavabean12DocumentRoot_Expression()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='expression' namespace='##targetNamespace'"
	 * @generated
	 */
	ExpressionType getExpression();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(ExpressionType value);

	/**
	 * Returns the value of the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' containment reference.
	 * @see #setResult(ResultType)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getJavabean12DocumentRoot_Result()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='result' namespace='##targetNamespace' affiliation='http://www.milyn.org/xsd/smooks-1.1.xsd#abstract-resource-config'"
	 * @generated
	 */
	ResultType getResult();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getResult <em>Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' containment reference.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(ResultType value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 	            Basic "value" based binding configuration.
	 * 	            <p/>
	 * 	            This binding type is used to bind data from the source message event stream.
	 * 	        
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(ValueType)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getJavabean12DocumentRoot_Value()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='value' namespace='##targetNamespace'"
	 * @generated
	 */
	ValueType getValue();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(ValueType value);

	/**
	 * Returns the value of the '<em><b>Wiring</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *       			Wiring based binding configuration.
	 *       			<p/>
	 *       			This binding type is used to "wire" beans together.
	 *       		
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Wiring</em>' containment reference.
	 * @see #setWiring(WiringType)
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package#getJavabean12DocumentRoot_Wiring()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='wiring' namespace='##targetNamespace'"
	 * @generated
	 */
	WiringType getWiring();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getWiring <em>Wiring</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wiring</em>' containment reference.
	 * @see #getWiring()
	 * @generated
	 */
	void setWiring(WiringType value);

} // Javabean12DocumentRoot
