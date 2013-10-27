/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.json12;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.jboss.tools.smooks.model.common.CommonPackage;
import org.jboss.tools.smooks.model.smooks.SmooksPackage;


/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Smooks JSON Reader Configuration
 * <!-- end-model-doc -->
 * @see org.jboss.tools.smooks.model.json12.Json12Factory
 * @model kind="package"
 * @generated
 */
public interface Json12Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "json12"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.milyn.org/xsd/smooks/json-1.2.xsd"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "json"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Json12Package eINSTANCE = org.jboss.tools.smooks.model.json12.impl.Json12PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.json12.impl.Json12DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.json12.impl.Json12DocumentRootImpl
	 * @see org.jboss.tools.smooks.model.json12.impl.Json12PackageImpl#getJson12DocumentRoot()
	 * @generated
	 */
	int JSON12_DOCUMENT_ROOT = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON12_DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON12_DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON12_DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Reader</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON12_DOCUMENT_ROOT__READER = 3;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON12_DOCUMENT_ROOT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.json12.impl.KeyImpl <em>Key</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.json12.impl.KeyImpl
	 * @see org.jboss.tools.smooks.model.json12.impl.Json12PackageImpl#getKey()
	 * @generated
	 */
	int KEY = 1;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__VALUE = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__FROM = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__TO = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.json12.impl.KeyMapImpl <em>Key Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.json12.impl.KeyMapImpl
	 * @see org.jboss.tools.smooks.model.json12.impl.Json12PackageImpl#getKeyMap()
	 * @generated
	 */
	int KEY_MAP = 2;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_MAP__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_MAP__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_MAP__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Key</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_MAP__KEY = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Key Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_MAP_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.json12.impl.Json12ReaderImpl <em>Reader</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.json12.impl.Json12ReaderImpl
	 * @see org.jboss.tools.smooks.model.json12.impl.Json12PackageImpl#getJson12Reader()
	 * @generated
	 */
	int JSON12_READER = 3;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON12_READER__MIXED = SmooksPackage.ABSTRACT_READER__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON12_READER__ANY = SmooksPackage.ABSTRACT_READER__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON12_READER__ANY_ATTRIBUTE = SmooksPackage.ABSTRACT_READER__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Target Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON12_READER__TARGET_PROFILE = SmooksPackage.ABSTRACT_READER__TARGET_PROFILE;

	/**
	 * The feature id for the '<em><b>Key Map</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON12_READER__KEY_MAP = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Array Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON12_READER__ARRAY_ELEMENT_NAME = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON12_READER__ENCODING = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Illegal Element Name Char Replacement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON12_READER__ILLEGAL_ELEMENT_NAME_CHAR_REPLACEMENT = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Indent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON12_READER__INDENT = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Key Prefix On Numeric</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON12_READER__KEY_PREFIX_ON_NUMERIC = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Key Whitspace Replacement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON12_READER__KEY_WHITSPACE_REPLACEMENT = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Null Value Replacement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON12_READER__NULL_VALUE_REPLACEMENT = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Root Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON12_READER__ROOT_NAME = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Reader</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON12_READER_FEATURE_COUNT = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 9;


	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.json12.Json12DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.jboss.tools.smooks.model.json12.Json12DocumentRoot
	 * @generated
	 */
	EClass getJson12DocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.jboss.tools.smooks.model.json12.Json12DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.jboss.tools.smooks.model.json12.Json12DocumentRoot#getMixed()
	 * @see #getJson12DocumentRoot()
	 * @generated
	 */
	EAttribute getJson12DocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.jboss.tools.smooks.model.json12.Json12DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.jboss.tools.smooks.model.json12.Json12DocumentRoot#getXMLNSPrefixMap()
	 * @see #getJson12DocumentRoot()
	 * @generated
	 */
	EReference getJson12DocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.jboss.tools.smooks.model.json12.Json12DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.jboss.tools.smooks.model.json12.Json12DocumentRoot#getXSISchemaLocation()
	 * @see #getJson12DocumentRoot()
	 * @generated
	 */
	EReference getJson12DocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.json12.Json12DocumentRoot#getReader <em>Reader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reader</em>'.
	 * @see org.jboss.tools.smooks.model.json12.Json12DocumentRoot#getReader()
	 * @see #getJson12DocumentRoot()
	 * @generated
	 */
	EReference getJson12DocumentRoot_Reader();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.json12.Key <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key</em>'.
	 * @see org.jboss.tools.smooks.model.json12.Key
	 * @generated
	 */
	EClass getKey();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.json12.Key#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.jboss.tools.smooks.model.json12.Key#getValue()
	 * @see #getKey()
	 * @generated
	 */
	EAttribute getKey_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.json12.Key#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From</em>'.
	 * @see org.jboss.tools.smooks.model.json12.Key#getFrom()
	 * @see #getKey()
	 * @generated
	 */
	EAttribute getKey_From();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.json12.Key#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To</em>'.
	 * @see org.jboss.tools.smooks.model.json12.Key#getTo()
	 * @see #getKey()
	 * @generated
	 */
	EAttribute getKey_To();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.json12.KeyMap <em>Key Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key Map</em>'.
	 * @see org.jboss.tools.smooks.model.json12.KeyMap
	 * @generated
	 */
	EClass getKeyMap();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.tools.smooks.model.json12.KeyMap#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Key</em>'.
	 * @see org.jboss.tools.smooks.model.json12.KeyMap#getKey()
	 * @see #getKeyMap()
	 * @generated
	 */
	EReference getKeyMap_Key();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.json12.Json12Reader <em>Reader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reader</em>'.
	 * @see org.jboss.tools.smooks.model.json12.Json12Reader
	 * @generated
	 */
	EClass getJson12Reader();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.json12.Json12Reader#getKeyMap <em>Key Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Key Map</em>'.
	 * @see org.jboss.tools.smooks.model.json12.Json12Reader#getKeyMap()
	 * @see #getJson12Reader()
	 * @generated
	 */
	EReference getJson12Reader_KeyMap();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.json12.Json12Reader#getArrayElementName <em>Array Element Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Array Element Name</em>'.
	 * @see org.jboss.tools.smooks.model.json12.Json12Reader#getArrayElementName()
	 * @see #getJson12Reader()
	 * @generated
	 */
	EAttribute getJson12Reader_ArrayElementName();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.json12.Json12Reader#getEncoding <em>Encoding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Encoding</em>'.
	 * @see org.jboss.tools.smooks.model.json12.Json12Reader#getEncoding()
	 * @see #getJson12Reader()
	 * @generated
	 */
	EAttribute getJson12Reader_Encoding();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.json12.Json12Reader#getIllegalElementNameCharReplacement <em>Illegal Element Name Char Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Illegal Element Name Char Replacement</em>'.
	 * @see org.jboss.tools.smooks.model.json12.Json12Reader#getIllegalElementNameCharReplacement()
	 * @see #getJson12Reader()
	 * @generated
	 */
	EAttribute getJson12Reader_IllegalElementNameCharReplacement();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.json12.Json12Reader#isIndent <em>Indent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indent</em>'.
	 * @see org.jboss.tools.smooks.model.json12.Json12Reader#isIndent()
	 * @see #getJson12Reader()
	 * @generated
	 */
	EAttribute getJson12Reader_Indent();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.json12.Json12Reader#getKeyPrefixOnNumeric <em>Key Prefix On Numeric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key Prefix On Numeric</em>'.
	 * @see org.jboss.tools.smooks.model.json12.Json12Reader#getKeyPrefixOnNumeric()
	 * @see #getJson12Reader()
	 * @generated
	 */
	EAttribute getJson12Reader_KeyPrefixOnNumeric();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.json12.Json12Reader#getKeyWhitspaceReplacement <em>Key Whitspace Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key Whitspace Replacement</em>'.
	 * @see org.jboss.tools.smooks.model.json12.Json12Reader#getKeyWhitspaceReplacement()
	 * @see #getJson12Reader()
	 * @generated
	 */
	EAttribute getJson12Reader_KeyWhitspaceReplacement();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.json12.Json12Reader#getNullValueReplacement <em>Null Value Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Null Value Replacement</em>'.
	 * @see org.jboss.tools.smooks.model.json12.Json12Reader#getNullValueReplacement()
	 * @see #getJson12Reader()
	 * @generated
	 */
	EAttribute getJson12Reader_NullValueReplacement();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.json12.Json12Reader#getRootName <em>Root Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Root Name</em>'.
	 * @see org.jboss.tools.smooks.model.json12.Json12Reader#getRootName()
	 * @see #getJson12Reader()
	 * @generated
	 */
	EAttribute getJson12Reader_RootName();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Json12Factory getJson12Factory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.json12.impl.Json12DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.json12.impl.Json12DocumentRootImpl
		 * @see org.jboss.tools.smooks.model.json12.impl.Json12PackageImpl#getJson12DocumentRoot()
		 * @generated
		 */
		EClass JSON12_DOCUMENT_ROOT = eINSTANCE.getJson12DocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON12_DOCUMENT_ROOT__MIXED = eINSTANCE.getJson12DocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JSON12_DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getJson12DocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JSON12_DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getJson12DocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Reader</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JSON12_DOCUMENT_ROOT__READER = eINSTANCE.getJson12DocumentRoot_Reader();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.json12.impl.KeyImpl <em>Key</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.json12.impl.KeyImpl
		 * @see org.jboss.tools.smooks.model.json12.impl.Json12PackageImpl#getKey()
		 * @generated
		 */
		EClass KEY = eINSTANCE.getKey();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY__VALUE = eINSTANCE.getKey_Value();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY__FROM = eINSTANCE.getKey_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY__TO = eINSTANCE.getKey_To();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.json12.impl.KeyMapImpl <em>Key Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.json12.impl.KeyMapImpl
		 * @see org.jboss.tools.smooks.model.json12.impl.Json12PackageImpl#getKeyMap()
		 * @generated
		 */
		EClass KEY_MAP = eINSTANCE.getKeyMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_MAP__KEY = eINSTANCE.getKeyMap_Key();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.json12.impl.Json12ReaderImpl <em>Reader</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.json12.impl.Json12ReaderImpl
		 * @see org.jboss.tools.smooks.model.json12.impl.Json12PackageImpl#getJson12Reader()
		 * @generated
		 */
		EClass JSON12_READER = eINSTANCE.getJson12Reader();

		/**
		 * The meta object literal for the '<em><b>Key Map</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JSON12_READER__KEY_MAP = eINSTANCE.getJson12Reader_KeyMap();

		/**
		 * The meta object literal for the '<em><b>Array Element Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON12_READER__ARRAY_ELEMENT_NAME = eINSTANCE.getJson12Reader_ArrayElementName();

		/**
		 * The meta object literal for the '<em><b>Encoding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON12_READER__ENCODING = eINSTANCE.getJson12Reader_Encoding();

		/**
		 * The meta object literal for the '<em><b>Illegal Element Name Char Replacement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON12_READER__ILLEGAL_ELEMENT_NAME_CHAR_REPLACEMENT = eINSTANCE.getJson12Reader_IllegalElementNameCharReplacement();

		/**
		 * The meta object literal for the '<em><b>Indent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON12_READER__INDENT = eINSTANCE.getJson12Reader_Indent();

		/**
		 * The meta object literal for the '<em><b>Key Prefix On Numeric</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON12_READER__KEY_PREFIX_ON_NUMERIC = eINSTANCE.getJson12Reader_KeyPrefixOnNumeric();

		/**
		 * The meta object literal for the '<em><b>Key Whitspace Replacement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON12_READER__KEY_WHITSPACE_REPLACEMENT = eINSTANCE.getJson12Reader_KeyWhitspaceReplacement();

		/**
		 * The meta object literal for the '<em><b>Null Value Replacement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON12_READER__NULL_VALUE_REPLACEMENT = eINSTANCE.getJson12Reader_NullValueReplacement();

		/**
		 * The meta object literal for the '<em><b>Root Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON12_READER__ROOT_NAME = eINSTANCE.getJson12Reader_RootName();

	}

} //Json12Package
