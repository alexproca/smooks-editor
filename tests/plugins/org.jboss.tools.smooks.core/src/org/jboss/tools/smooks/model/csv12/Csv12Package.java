/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.csv12;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
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
 * Smooks CSV Reader Configuration
 * <!-- end-model-doc -->
 * @see org.jboss.tools.smooks.model.csv12.Csv12Factory
 * @model kind="package"
 * @generated
 */
public interface Csv12Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "csv12"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.milyn.org/xsd/smooks/csv-1.2.xsd"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "csv"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Csv12Package eINSTANCE = org.jboss.tools.smooks.model.csv12.impl.Csv12PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.csv12.impl.BindingImpl <em>Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.csv12.impl.BindingImpl
	 * @see org.jboss.tools.smooks.model.csv12.impl.Csv12PackageImpl#getBinding()
	 * @generated
	 */
	int BINDING = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__MIXED = SmooksPackage.ABSTRACT_RESOURCE_CONFIG__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__ANY = SmooksPackage.ABSTRACT_RESOURCE_CONFIG__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__ANY_ATTRIBUTE = SmooksPackage.ABSTRACT_RESOURCE_CONFIG__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Bean Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__BEAN_ID = SmooksPackage.ABSTRACT_RESOURCE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__CLASS = SmooksPackage.ABSTRACT_RESOURCE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_FEATURE_COUNT = SmooksPackage.ABSTRACT_RESOURCE_CONFIG_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.csv12.impl.CSV12DocumentRootImpl <em>CSV12 Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.csv12.impl.CSV12DocumentRootImpl
	 * @see org.jboss.tools.smooks.model.csv12.impl.Csv12PackageImpl#getCSV12DocumentRoot()
	 * @generated
	 */
	int CSV12_DOCUMENT_ROOT = 1;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV12_DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV12_DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV12_DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Reader</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV12_DOCUMENT_ROOT__READER = 3;

	/**
	 * The number of structural features of the '<em>CSV12 Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV12_DOCUMENT_ROOT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.csv12.impl.MapBindingImpl <em>Map Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.csv12.impl.MapBindingImpl
	 * @see org.jboss.tools.smooks.model.csv12.impl.Csv12PackageImpl#getMapBinding()
	 * @generated
	 */
	int MAP_BINDING = 2;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_BINDING__MIXED = BINDING__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_BINDING__ANY = BINDING__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_BINDING__ANY_ATTRIBUTE = BINDING__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Bean Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_BINDING__BEAN_ID = BINDING__BEAN_ID;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_BINDING__CLASS = BINDING__CLASS;

	/**
	 * The feature id for the '<em><b>Key Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_BINDING__KEY_FIELD = BINDING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Map Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_BINDING_FEATURE_COUNT = BINDING_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.csv12.impl.CSV12ReaderImpl <em>CSV12 Reader</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.csv12.impl.CSV12ReaderImpl
	 * @see org.jboss.tools.smooks.model.csv12.impl.Csv12PackageImpl#getCSV12Reader()
	 * @generated
	 */
	int CSV12_READER = 3;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV12_READER__MIXED = SmooksPackage.ABSTRACT_READER__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV12_READER__ANY = SmooksPackage.ABSTRACT_READER__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV12_READER__ANY_ATTRIBUTE = SmooksPackage.ABSTRACT_READER__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Target Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV12_READER__TARGET_PROFILE = SmooksPackage.ABSTRACT_READER__TARGET_PROFILE;

	/**
	 * The feature id for the '<em><b>Single Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV12_READER__SINGLE_BINDING = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>List Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV12_READER__LIST_BINDING = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Map Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV12_READER__MAP_BINDING = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV12_READER__ENCODING = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV12_READER__FIELDS = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Indent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV12_READER__INDENT = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Quote</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV12_READER__QUOTE = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Record Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV12_READER__RECORD_ELEMENT_NAME = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Root Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV12_READER__ROOT_ELEMENT_NAME = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV12_READER__SEPARATOR = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Skip Lines</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV12_READER__SKIP_LINES = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>CSV12 Reader</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV12_READER_FEATURE_COUNT = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 11;

	/**
	 * The meta object id for the '<em>Char</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.jboss.tools.smooks.model.csv12.impl.Csv12PackageImpl#getChar()
	 * @generated
	 */
	int CHAR = 4;


	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.csv12.Binding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding</em>'.
	 * @see org.jboss.tools.smooks.model.csv12.Binding
	 * @generated
	 */
	EClass getBinding();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.csv12.Binding#getBeanId <em>Bean Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bean Id</em>'.
	 * @see org.jboss.tools.smooks.model.csv12.Binding#getBeanId()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_BeanId();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.csv12.Binding#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class</em>'.
	 * @see org.jboss.tools.smooks.model.csv12.Binding#getClass_()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_Class();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.csv12.CSV12DocumentRoot <em>CSV12 Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CSV12 Document Root</em>'.
	 * @see org.jboss.tools.smooks.model.csv12.CSV12DocumentRoot
	 * @generated
	 */
	EClass getCSV12DocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.jboss.tools.smooks.model.csv12.CSV12DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.jboss.tools.smooks.model.csv12.CSV12DocumentRoot#getMixed()
	 * @see #getCSV12DocumentRoot()
	 * @generated
	 */
	EAttribute getCSV12DocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.jboss.tools.smooks.model.csv12.CSV12DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.jboss.tools.smooks.model.csv12.CSV12DocumentRoot#getXMLNSPrefixMap()
	 * @see #getCSV12DocumentRoot()
	 * @generated
	 */
	EReference getCSV12DocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.jboss.tools.smooks.model.csv12.CSV12DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.jboss.tools.smooks.model.csv12.CSV12DocumentRoot#getXSISchemaLocation()
	 * @see #getCSV12DocumentRoot()
	 * @generated
	 */
	EReference getCSV12DocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.csv12.CSV12DocumentRoot#getReader <em>Reader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reader</em>'.
	 * @see org.jboss.tools.smooks.model.csv12.CSV12DocumentRoot#getReader()
	 * @see #getCSV12DocumentRoot()
	 * @generated
	 */
	EReference getCSV12DocumentRoot_Reader();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.csv12.MapBinding <em>Map Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Binding</em>'.
	 * @see org.jboss.tools.smooks.model.csv12.MapBinding
	 * @generated
	 */
	EClass getMapBinding();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.csv12.MapBinding#getKeyField <em>Key Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key Field</em>'.
	 * @see org.jboss.tools.smooks.model.csv12.MapBinding#getKeyField()
	 * @see #getMapBinding()
	 * @generated
	 */
	EAttribute getMapBinding_KeyField();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader <em>CSV12 Reader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CSV12 Reader</em>'.
	 * @see org.jboss.tools.smooks.model.csv12.CSV12Reader
	 * @generated
	 */
	EClass getCSV12Reader();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getSingleBinding <em>Single Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Single Binding</em>'.
	 * @see org.jboss.tools.smooks.model.csv12.CSV12Reader#getSingleBinding()
	 * @see #getCSV12Reader()
	 * @generated
	 */
	EReference getCSV12Reader_SingleBinding();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getListBinding <em>List Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>List Binding</em>'.
	 * @see org.jboss.tools.smooks.model.csv12.CSV12Reader#getListBinding()
	 * @see #getCSV12Reader()
	 * @generated
	 */
	EReference getCSV12Reader_ListBinding();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getMapBinding <em>Map Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Map Binding</em>'.
	 * @see org.jboss.tools.smooks.model.csv12.CSV12Reader#getMapBinding()
	 * @see #getCSV12Reader()
	 * @generated
	 */
	EReference getCSV12Reader_MapBinding();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getEncoding <em>Encoding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Encoding</em>'.
	 * @see org.jboss.tools.smooks.model.csv12.CSV12Reader#getEncoding()
	 * @see #getCSV12Reader()
	 * @generated
	 */
	EAttribute getCSV12Reader_Encoding();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fields</em>'.
	 * @see org.jboss.tools.smooks.model.csv12.CSV12Reader#getFields()
	 * @see #getCSV12Reader()
	 * @generated
	 */
	EAttribute getCSV12Reader_Fields();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#isIndent <em>Indent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indent</em>'.
	 * @see org.jboss.tools.smooks.model.csv12.CSV12Reader#isIndent()
	 * @see #getCSV12Reader()
	 * @generated
	 */
	EAttribute getCSV12Reader_Indent();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getQuote <em>Quote</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quote</em>'.
	 * @see org.jboss.tools.smooks.model.csv12.CSV12Reader#getQuote()
	 * @see #getCSV12Reader()
	 * @generated
	 */
	EAttribute getCSV12Reader_Quote();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getRecordElementName <em>Record Element Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Record Element Name</em>'.
	 * @see org.jboss.tools.smooks.model.csv12.CSV12Reader#getRecordElementName()
	 * @see #getCSV12Reader()
	 * @generated
	 */
	EAttribute getCSV12Reader_RecordElementName();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getRootElementName <em>Root Element Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Root Element Name</em>'.
	 * @see org.jboss.tools.smooks.model.csv12.CSV12Reader#getRootElementName()
	 * @see #getCSV12Reader()
	 * @generated
	 */
	EAttribute getCSV12Reader_RootElementName();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getSeparator <em>Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Separator</em>'.
	 * @see org.jboss.tools.smooks.model.csv12.CSV12Reader#getSeparator()
	 * @see #getCSV12Reader()
	 * @generated
	 */
	EAttribute getCSV12Reader_Separator();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.csv12.CSV12Reader#getSkipLines <em>Skip Lines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Skip Lines</em>'.
	 * @see org.jboss.tools.smooks.model.csv12.CSV12Reader#getSkipLines()
	 * @see #getCSV12Reader()
	 * @generated
	 */
	EAttribute getCSV12Reader_SkipLines();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Char</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Char</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='char' baseType='http://www.eclipse.org/emf/2003/XMLType#string' length='1'"
	 * @generated
	 */
	EDataType getChar();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Csv12Factory getCsv12Factory();

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
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.csv12.impl.BindingImpl <em>Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.csv12.impl.BindingImpl
		 * @see org.jboss.tools.smooks.model.csv12.impl.Csv12PackageImpl#getBinding()
		 * @generated
		 */
		EClass BINDING = eINSTANCE.getBinding();

		/**
		 * The meta object literal for the '<em><b>Bean Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING__BEAN_ID = eINSTANCE.getBinding_BeanId();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING__CLASS = eINSTANCE.getBinding_Class();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.csv12.impl.CSV12DocumentRootImpl <em>CSV12 Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.csv12.impl.CSV12DocumentRootImpl
		 * @see org.jboss.tools.smooks.model.csv12.impl.Csv12PackageImpl#getCSV12DocumentRoot()
		 * @generated
		 */
		EClass CSV12_DOCUMENT_ROOT = eINSTANCE.getCSV12DocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CSV12_DOCUMENT_ROOT__MIXED = eINSTANCE.getCSV12DocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CSV12_DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getCSV12DocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CSV12_DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getCSV12DocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Reader</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CSV12_DOCUMENT_ROOT__READER = eINSTANCE.getCSV12DocumentRoot_Reader();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.csv12.impl.MapBindingImpl <em>Map Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.csv12.impl.MapBindingImpl
		 * @see org.jboss.tools.smooks.model.csv12.impl.Csv12PackageImpl#getMapBinding()
		 * @generated
		 */
		EClass MAP_BINDING = eINSTANCE.getMapBinding();

		/**
		 * The meta object literal for the '<em><b>Key Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAP_BINDING__KEY_FIELD = eINSTANCE.getMapBinding_KeyField();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.csv12.impl.CSV12ReaderImpl <em>CSV12 Reader</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.csv12.impl.CSV12ReaderImpl
		 * @see org.jboss.tools.smooks.model.csv12.impl.Csv12PackageImpl#getCSV12Reader()
		 * @generated
		 */
		EClass CSV12_READER = eINSTANCE.getCSV12Reader();

		/**
		 * The meta object literal for the '<em><b>Single Binding</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CSV12_READER__SINGLE_BINDING = eINSTANCE.getCSV12Reader_SingleBinding();

		/**
		 * The meta object literal for the '<em><b>List Binding</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CSV12_READER__LIST_BINDING = eINSTANCE.getCSV12Reader_ListBinding();

		/**
		 * The meta object literal for the '<em><b>Map Binding</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CSV12_READER__MAP_BINDING = eINSTANCE.getCSV12Reader_MapBinding();

		/**
		 * The meta object literal for the '<em><b>Encoding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CSV12_READER__ENCODING = eINSTANCE.getCSV12Reader_Encoding();

		/**
		 * The meta object literal for the '<em><b>Fields</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CSV12_READER__FIELDS = eINSTANCE.getCSV12Reader_Fields();

		/**
		 * The meta object literal for the '<em><b>Indent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CSV12_READER__INDENT = eINSTANCE.getCSV12Reader_Indent();

		/**
		 * The meta object literal for the '<em><b>Quote</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CSV12_READER__QUOTE = eINSTANCE.getCSV12Reader_Quote();

		/**
		 * The meta object literal for the '<em><b>Record Element Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CSV12_READER__RECORD_ELEMENT_NAME = eINSTANCE.getCSV12Reader_RecordElementName();

		/**
		 * The meta object literal for the '<em><b>Root Element Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CSV12_READER__ROOT_ELEMENT_NAME = eINSTANCE.getCSV12Reader_RootElementName();

		/**
		 * The meta object literal for the '<em><b>Separator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CSV12_READER__SEPARATOR = eINSTANCE.getCSV12Reader_Separator();

		/**
		 * The meta object literal for the '<em><b>Skip Lines</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CSV12_READER__SKIP_LINES = eINSTANCE.getCSV12Reader_SkipLines();

		/**
		 * The meta object literal for the '<em>Char</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.jboss.tools.smooks.model.csv12.impl.Csv12PackageImpl#getChar()
		 * @generated
		 */
		EDataType CHAR = eINSTANCE.getChar();

	}

} //Csv12Package
