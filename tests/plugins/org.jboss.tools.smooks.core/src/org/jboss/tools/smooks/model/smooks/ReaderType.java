/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.smooks;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reader Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Stream Reader
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.ReaderType#getHandlers <em>Handlers</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.ReaderType#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.ReaderType#getParams <em>Params</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.ReaderType#getClass_ <em>Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getReaderType()
 * @model extendedMetaData="name='reader_._type' kind='elementOnly'"
 * @generated
 */
public interface ReaderType extends AbstractReader {
	/**
	 * Returns the value of the '<em><b>Handlers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Handlers</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Handlers</em>' containment reference.
	 * @see #setHandlers(HandlersType)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getReaderType_Handlers()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='handlers' namespace='##targetNamespace'"
	 * @generated
	 */
	HandlersType getHandlers();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.ReaderType#getHandlers <em>Handlers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Handlers</em>' containment reference.
	 * @see #getHandlers()
	 * @generated
	 */
	void setHandlers(HandlersType value);

	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference.
	 * @see #setFeatures(FeaturesType)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getReaderType_Features()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='features' namespace='##targetNamespace'"
	 * @generated
	 */
	FeaturesType getFeatures();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.ReaderType#getFeatures <em>Features</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Features</em>' containment reference.
	 * @see #getFeatures()
	 * @generated
	 */
	void setFeatures(FeaturesType value);

	/**
	 * Returns the value of the '<em><b>Params</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Params</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Params</em>' containment reference.
	 * @see #setParams(ParamsType)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getReaderType_Params()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='params' namespace='##targetNamespace'"
	 * @generated
	 */
	ParamsType getParams();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.ReaderType#getParams <em>Params</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Params</em>' containment reference.
	 * @see #getParams()
	 * @generated
	 */
	void setParams(ParamsType value);

	/**
	 * Returns the value of the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' attribute.
	 * @see #setClass(String)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getReaderType_Class()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='class'"
	 * @generated
	 */
	String getClass_();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.ReaderType#getClass_ <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' attribute.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(String value);

} // ReaderType
