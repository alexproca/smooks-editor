/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.smooks;

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
 *   <li>{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getAbstractReader <em>Abstract Reader</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getAbstractResourceConfig <em>Abstract Resource Config</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getConditions <em>Conditions</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getElementVisitor <em>Element Visitor</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getHandler <em>Handler</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getHandlers <em>Handlers</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getImport <em>Import</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getParam <em>Param</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getParams <em>Params</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getProfile <em>Profile</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getProfiles <em>Profiles</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getReader <em>Reader</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getResource <em>Resource</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getResourceConfig <em>Resource Config</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getSetOff <em>Set Off</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getSetOn <em>Set On</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getSmooksResourceList <em>Smooks Resource List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getDocumentRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DocumentRoot extends EObject {
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
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getDocumentRoot_Mixed()
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
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getDocumentRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
	 * @generated
	 */
	EMap<String, String> getXMLNSPrefixMap();

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
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getDocumentRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap<String, String> getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Abstract Reader</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract Reader</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract Reader</em>' containment reference.
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getDocumentRoot_AbstractReader()
	 * @model containment="true" upper="-2" transient="true" changeable="false" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='abstract-reader' namespace='##targetNamespace'"
	 * @generated
	 */
	AbstractReader getAbstractReader();

	/**
	 * Returns the value of the '<em><b>Abstract Resource Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract Resource Config</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract Resource Config</em>' containment reference.
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getDocumentRoot_AbstractResourceConfig()
	 * @model containment="true" upper="-2" transient="true" changeable="false" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='abstract-resource-config' namespace='##targetNamespace'"
	 * @generated
	 */
	AbstractResourceConfig getAbstractResourceConfig();

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(ConditionType)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getDocumentRoot_Condition()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='condition' namespace='##targetNamespace'"
	 * @generated
	 */
	ConditionType getCondition();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(ConditionType value);

	/**
	 * Returns the value of the '<em><b>Conditions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conditions</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conditions</em>' containment reference.
	 * @see #setConditions(ConditionsType)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getDocumentRoot_Conditions()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='conditions' namespace='##targetNamespace'"
	 * @generated
	 */
	ConditionsType getConditions();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getConditions <em>Conditions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conditions</em>' containment reference.
	 * @see #getConditions()
	 * @generated
	 */
	void setConditions(ConditionsType value);

	/**
	 * Returns the value of the '<em><b>Element Visitor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Visitor</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Visitor</em>' containment reference.
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getDocumentRoot_ElementVisitor()
	 * @model containment="true" upper="-2" transient="true" changeable="false" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='element-visitor' namespace='##targetNamespace' affiliation='abstract-resource-config'"
	 * @generated
	 */
	ElementVisitor getElementVisitor();

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
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getDocumentRoot_Features()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='features' namespace='##targetNamespace'"
	 * @generated
	 */
	FeaturesType getFeatures();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getFeatures <em>Features</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Features</em>' containment reference.
	 * @see #getFeatures()
	 * @generated
	 */
	void setFeatures(FeaturesType value);

	/**
	 * Returns the value of the '<em><b>Handler</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Handler</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Handler</em>' containment reference.
	 * @see #setHandler(HandlerType)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getDocumentRoot_Handler()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='handler' namespace='##targetNamespace'"
	 * @generated
	 */
	HandlerType getHandler();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getHandler <em>Handler</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Handler</em>' containment reference.
	 * @see #getHandler()
	 * @generated
	 */
	void setHandler(HandlerType value);

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
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getDocumentRoot_Handlers()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='handlers' namespace='##targetNamespace'"
	 * @generated
	 */
	HandlersType getHandlers();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getHandlers <em>Handlers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Handlers</em>' containment reference.
	 * @see #getHandlers()
	 * @generated
	 */
	void setHandlers(HandlersType value);

	/**
	 * Returns the value of the '<em><b>Import</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import</em>' containment reference.
	 * @see #setImport(ImportType)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getDocumentRoot_Import()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='import' namespace='##targetNamespace' affiliation='abstract-resource-config'"
	 * @generated
	 */
	ImportType getImport();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getImport <em>Import</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import</em>' containment reference.
	 * @see #getImport()
	 * @generated
	 */
	void setImport(ImportType value);

	/**
	 * Returns the value of the '<em><b>Param</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Param</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param</em>' containment reference.
	 * @see #setParam(ParamType)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getDocumentRoot_Param()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='param' namespace='##targetNamespace'"
	 * @generated
	 */
	ParamType getParam();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getParam <em>Param</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Param</em>' containment reference.
	 * @see #getParam()
	 * @generated
	 */
	void setParam(ParamType value);

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
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getDocumentRoot_Params()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='params' namespace='##targetNamespace'"
	 * @generated
	 */
	ParamsType getParams();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getParams <em>Params</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Params</em>' containment reference.
	 * @see #getParams()
	 * @generated
	 */
	void setParams(ParamsType value);

	/**
	 * Returns the value of the '<em><b>Profile</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile</em>' containment reference.
	 * @see #setProfile(ProfileType)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getDocumentRoot_Profile()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='profile' namespace='##targetNamespace'"
	 * @generated
	 */
	ProfileType getProfile();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getProfile <em>Profile</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile</em>' containment reference.
	 * @see #getProfile()
	 * @generated
	 */
	void setProfile(ProfileType value);

	/**
	 * Returns the value of the '<em><b>Profiles</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profiles</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profiles</em>' containment reference.
	 * @see #setProfiles(ProfilesType)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getDocumentRoot_Profiles()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='profiles' namespace='##targetNamespace'"
	 * @generated
	 */
	ProfilesType getProfiles();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getProfiles <em>Profiles</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profiles</em>' containment reference.
	 * @see #getProfiles()
	 * @generated
	 */
	void setProfiles(ProfilesType value);

	/**
	 * Returns the value of the '<em><b>Reader</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reader</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reader</em>' containment reference.
	 * @see #setReader(ReaderType)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getDocumentRoot_Reader()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='reader' namespace='##targetNamespace' affiliation='abstract-reader'"
	 * @generated
	 */
	ReaderType getReader();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getReader <em>Reader</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reader</em>' containment reference.
	 * @see #getReader()
	 * @generated
	 */
	void setReader(ReaderType value);

	/**
	 * Returns the value of the '<em><b>Resource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' containment reference.
	 * @see #setResource(ResourceType)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getDocumentRoot_Resource()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='resource' namespace='##targetNamespace'"
	 * @generated
	 */
	ResourceType getResource();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getResource <em>Resource</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' containment reference.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(ResourceType value);

	/**
	 * Returns the value of the '<em><b>Resource Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Config</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Config</em>' containment reference.
	 * @see #setResourceConfig(ResourceConfigType)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getDocumentRoot_ResourceConfig()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='resource-config' namespace='##targetNamespace' affiliation='abstract-resource-config'"
	 * @generated
	 */
	ResourceConfigType getResourceConfig();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getResourceConfig <em>Resource Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Config</em>' containment reference.
	 * @see #getResourceConfig()
	 * @generated
	 */
	void setResourceConfig(ResourceConfigType value);

	/**
	 * Returns the value of the '<em><b>Set Off</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Set Off</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Set Off</em>' containment reference.
	 * @see #setSetOff(SetOffType)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getDocumentRoot_SetOff()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='setOff' namespace='##targetNamespace'"
	 * @generated
	 */
	SetOffType getSetOff();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getSetOff <em>Set Off</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Set Off</em>' containment reference.
	 * @see #getSetOff()
	 * @generated
	 */
	void setSetOff(SetOffType value);

	/**
	 * Returns the value of the '<em><b>Set On</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Set On</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Set On</em>' containment reference.
	 * @see #setSetOn(SetOnType)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getDocumentRoot_SetOn()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='setOn' namespace='##targetNamespace'"
	 * @generated
	 */
	SetOnType getSetOn();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getSetOn <em>Set On</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Set On</em>' containment reference.
	 * @see #getSetOn()
	 * @generated
	 */
	void setSetOn(SetOnType value);

	/**
	 * Returns the value of the '<em><b>Smooks Resource List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Smooks Resource List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Smooks Resource List</em>' containment reference.
	 * @see #setSmooksResourceList(SmooksResourceListType)
	 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage#getDocumentRoot_SmooksResourceList()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='smooks-resource-list' namespace='##targetNamespace'"
	 * @generated
	 */
	SmooksResourceListType getSmooksResourceList();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getSmooksResourceList <em>Smooks Resource List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Smooks Resource List</em>' containment reference.
	 * @see #getSmooksResourceList()
	 * @generated
	 */
	void setSmooksResourceList(SmooksResourceListType value);

} // DocumentRoot
