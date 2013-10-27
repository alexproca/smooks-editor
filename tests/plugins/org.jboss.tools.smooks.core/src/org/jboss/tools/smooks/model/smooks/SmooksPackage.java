/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.smooks;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.jboss.tools.smooks.model.common.CommonPackage;

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
 * @see org.jboss.tools.smooks.model.smooks.SmooksFactory
 * @model kind="package"
 * @generated
 */
public interface SmooksPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "smooks"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.milyn.org/xsd/smooks-1.1.xsd"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "smooks"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SmooksPackage eINSTANCE = org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.smooks.impl.AbstractResourceConfigImpl <em>Abstract Resource Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.smooks.impl.AbstractResourceConfigImpl
	 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getAbstractResourceConfig()
	 * @generated
	 */
	int ABSTRACT_RESOURCE_CONFIG = 1;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RESOURCE_CONFIG__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RESOURCE_CONFIG__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RESOURCE_CONFIG__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The number of structural features of the '<em>Abstract Resource Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RESOURCE_CONFIG_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.smooks.impl.AbstractReaderImpl <em>Abstract Reader</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.smooks.impl.AbstractReaderImpl
	 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getAbstractReader()
	 * @generated
	 */
	int ABSTRACT_READER = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_READER__MIXED = ABSTRACT_RESOURCE_CONFIG__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_READER__ANY = ABSTRACT_RESOURCE_CONFIG__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_READER__ANY_ATTRIBUTE = ABSTRACT_RESOURCE_CONFIG__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Target Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_READER__TARGET_PROFILE = ABSTRACT_RESOURCE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Reader</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_READER_FEATURE_COUNT = ABSTRACT_RESOURCE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.smooks.impl.ConditionsTypeImpl <em>Conditions Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.smooks.impl.ConditionsTypeImpl
	 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getConditionsType()
	 * @generated
	 */
	int CONDITIONS_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONS_TYPE__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONS_TYPE__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONS_TYPE__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONS_TYPE__CONDITION = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Conditions Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONS_TYPE_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.smooks.impl.ConditionTypeImpl <em>Condition Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.smooks.impl.ConditionTypeImpl
	 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getConditionType()
	 * @generated
	 */
	int CONDITION_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_TYPE__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_TYPE__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_TYPE__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_TYPE__VALUE = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Evaluator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_TYPE__EVALUATOR = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_TYPE__ID = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Id Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_TYPE__ID_REF = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Condition Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_TYPE_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.smooks.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.smooks.impl.DocumentRootImpl
	 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 4;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Abstract Reader</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ABSTRACT_READER = 3;

	/**
	 * The feature id for the '<em><b>Abstract Resource Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ABSTRACT_RESOURCE_CONFIG = 4;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__CONDITION = 5;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__CONDITIONS = 6;

	/**
	 * The feature id for the '<em><b>Element Visitor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ELEMENT_VISITOR = 7;

	/**
	 * The feature id for the '<em><b>Features</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__FEATURES = 8;

	/**
	 * The feature id for the '<em><b>Handler</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__HANDLER = 9;

	/**
	 * The feature id for the '<em><b>Handlers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__HANDLERS = 10;

	/**
	 * The feature id for the '<em><b>Import</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__IMPORT = 11;

	/**
	 * The feature id for the '<em><b>Param</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PARAM = 12;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PARAMS = 13;

	/**
	 * The feature id for the '<em><b>Profile</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PROFILE = 14;

	/**
	 * The feature id for the '<em><b>Profiles</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PROFILES = 15;

	/**
	 * The feature id for the '<em><b>Reader</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__READER = 16;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__RESOURCE = 17;

	/**
	 * The feature id for the '<em><b>Resource Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__RESOURCE_CONFIG = 18;

	/**
	 * The feature id for the '<em><b>Set Off</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SET_OFF = 19;

	/**
	 * The feature id for the '<em><b>Set On</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SET_ON = 20;

	/**
	 * The feature id for the '<em><b>Smooks Resource List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SMOOKS_RESOURCE_LIST = 21;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 22;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.smooks.impl.ElementVisitorImpl <em>Element Visitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.smooks.impl.ElementVisitorImpl
	 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getElementVisitor()
	 * @generated
	 */
	int ELEMENT_VISITOR = 5;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_VISITOR__MIXED = ABSTRACT_RESOURCE_CONFIG__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_VISITOR__ANY = ABSTRACT_RESOURCE_CONFIG__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_VISITOR__ANY_ATTRIBUTE = ABSTRACT_RESOURCE_CONFIG__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_VISITOR__CONDITION = ABSTRACT_RESOURCE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_VISITOR__TARGET_PROFILE = ABSTRACT_RESOURCE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Element Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_VISITOR_FEATURE_COUNT = ABSTRACT_RESOURCE_CONFIG_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.smooks.impl.FeaturesTypeImpl <em>Features Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.smooks.impl.FeaturesTypeImpl
	 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getFeaturesType()
	 * @generated
	 */
	int FEATURES_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURES_TYPE__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURES_TYPE__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURES_TYPE__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Set On</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURES_TYPE__SET_ON = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Set Off</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURES_TYPE__SET_OFF = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Features Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURES_TYPE_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.smooks.impl.HandlersTypeImpl <em>Handlers Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.smooks.impl.HandlersTypeImpl
	 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getHandlersType()
	 * @generated
	 */
	int HANDLERS_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLERS_TYPE__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLERS_TYPE__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLERS_TYPE__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Handler</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLERS_TYPE__HANDLER = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Handlers Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLERS_TYPE_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.smooks.impl.HandlerTypeImpl <em>Handler Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.smooks.impl.HandlerTypeImpl
	 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getHandlerType()
	 * @generated
	 */
	int HANDLER_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLER_TYPE__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLER_TYPE__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLER_TYPE__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLER_TYPE__CLASS = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Handler Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLER_TYPE_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.smooks.impl.ImportTypeImpl <em>Import Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.smooks.impl.ImportTypeImpl
	 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getImportType()
	 * @generated
	 */
	int IMPORT_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_TYPE__MIXED = ABSTRACT_RESOURCE_CONFIG__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_TYPE__ANY = ABSTRACT_RESOURCE_CONFIG__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_TYPE__ANY_ATTRIBUTE = ABSTRACT_RESOURCE_CONFIG__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Param</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_TYPE__PARAM = ABSTRACT_RESOURCE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_TYPE__FILE = ABSTRACT_RESOURCE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Import Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_TYPE_FEATURE_COUNT = ABSTRACT_RESOURCE_CONFIG_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.smooks.impl.ParamsTypeImpl <em>Params Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.smooks.impl.ParamsTypeImpl
	 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getParamsType()
	 * @generated
	 */
	int PARAMS_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMS_TYPE__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMS_TYPE__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMS_TYPE__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Param</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMS_TYPE__PARAM = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Params Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMS_TYPE_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.smooks.impl.ParamTypeImpl <em>Param Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.smooks.impl.ParamTypeImpl
	 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getParamType()
	 * @generated
	 */
	int PARAM_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_TYPE__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_TYPE__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_TYPE__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_TYPE__NAME = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_TYPE__TYPE = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Param Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_TYPE_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.smooks.impl.ProfilesTypeImpl <em>Profiles Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.smooks.impl.ProfilesTypeImpl
	 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getProfilesType()
	 * @generated
	 */
	int PROFILES_TYPE = 12;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILES_TYPE__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILES_TYPE__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILES_TYPE__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Profile</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILES_TYPE__PROFILE = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Profiles Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILES_TYPE_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.smooks.impl.ProfileTypeImpl <em>Profile Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.smooks.impl.ProfileTypeImpl
	 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getProfileType()
	 * @generated
	 */
	int PROFILE_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_TYPE__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_TYPE__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_TYPE__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_TYPE__VALUE = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_TYPE__BASE_PROFILE = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sub Profiles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_TYPE__SUB_PROFILES = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Profile Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_TYPE_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.smooks.impl.ReaderTypeImpl <em>Reader Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.smooks.impl.ReaderTypeImpl
	 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getReaderType()
	 * @generated
	 */
	int READER_TYPE = 14;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READER_TYPE__MIXED = ABSTRACT_READER__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READER_TYPE__ANY = ABSTRACT_READER__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READER_TYPE__ANY_ATTRIBUTE = ABSTRACT_READER__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Target Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READER_TYPE__TARGET_PROFILE = ABSTRACT_READER__TARGET_PROFILE;

	/**
	 * The feature id for the '<em><b>Handlers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READER_TYPE__HANDLERS = ABSTRACT_READER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Features</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READER_TYPE__FEATURES = ABSTRACT_READER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READER_TYPE__PARAMS = ABSTRACT_READER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READER_TYPE__CLASS = ABSTRACT_READER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Reader Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READER_TYPE_FEATURE_COUNT = ABSTRACT_READER_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.smooks.impl.ResourceConfigTypeImpl <em>Resource Config Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.smooks.impl.ResourceConfigTypeImpl
	 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getResourceConfigType()
	 * @generated
	 */
	int RESOURCE_CONFIG_TYPE = 15;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONFIG_TYPE__MIXED = ABSTRACT_RESOURCE_CONFIG__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONFIG_TYPE__ANY = ABSTRACT_RESOURCE_CONFIG__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONFIG_TYPE__ANY_ATTRIBUTE = ABSTRACT_RESOURCE_CONFIG__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONFIG_TYPE__RESOURCE = ABSTRACT_RESOURCE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONFIG_TYPE__CONDITION = ABSTRACT_RESOURCE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Param</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONFIG_TYPE__PARAM = ABSTRACT_RESOURCE_CONFIG_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Selector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONFIG_TYPE__SELECTOR = ABSTRACT_RESOURCE_CONFIG_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Selector Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONFIG_TYPE__SELECTOR_NAMESPACE = ABSTRACT_RESOURCE_CONFIG_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Target Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONFIG_TYPE__TARGET_PROFILE = ABSTRACT_RESOURCE_CONFIG_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Resource Config Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONFIG_TYPE_FEATURE_COUNT = ABSTRACT_RESOURCE_CONFIG_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.smooks.impl.ResourceTypeImpl <em>Resource Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.smooks.impl.ResourceTypeImpl
	 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getResourceType()
	 * @generated
	 */
	int RESOURCE_TYPE = 16;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__VALUE = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__TYPE = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resource Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.smooks.impl.SetOffTypeImpl <em>Set Off Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.smooks.impl.SetOffTypeImpl
	 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getSetOffType()
	 * @generated
	 */
	int SET_OFF_TYPE = 17;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_OFF_TYPE__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_OFF_TYPE__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_OFF_TYPE__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_OFF_TYPE__FEATURE = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Set Off Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_OFF_TYPE_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.smooks.impl.SetOnTypeImpl <em>Set On Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.smooks.impl.SetOnTypeImpl
	 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getSetOnType()
	 * @generated
	 */
	int SET_ON_TYPE = 18;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ON_TYPE__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ON_TYPE__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ON_TYPE__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ON_TYPE__FEATURE = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Set On Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ON_TYPE_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.smooks.impl.SmooksResourceListTypeImpl <em>Resource List Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksResourceListTypeImpl
	 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getSmooksResourceListType()
	 * @generated
	 */
	int SMOOKS_RESOURCE_LIST_TYPE = 19;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_RESOURCE_LIST_TYPE__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_RESOURCE_LIST_TYPE__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_RESOURCE_LIST_TYPE__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_RESOURCE_LIST_TYPE__PARAMS = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_RESOURCE_LIST_TYPE__CONDITIONS = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Profiles</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_RESOURCE_LIST_TYPE__PROFILES = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Abstract Reader Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_READER_GROUP = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Abstract Reader</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_READER = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Abstract Resource Config Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_RESOURCE_CONFIG_GROUP = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Abstract Resource Config</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_RESOURCE_CONFIG = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Default Condition Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_CONDITION_REF = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Default Selector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_SELECTOR = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Default Selector Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_SELECTOR_NAMESPACE = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Default Target Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_TARGET_PROFILE = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Resource List Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_RESOURCE_LIST_TYPE_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 11;


	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.smooks.AbstractReader <em>Abstract Reader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Reader</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.AbstractReader
	 * @generated
	 */
	EClass getAbstractReader();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.smooks.AbstractReader#getTargetProfile <em>Target Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Profile</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.AbstractReader#getTargetProfile()
	 * @see #getAbstractReader()
	 * @generated
	 */
	EAttribute getAbstractReader_TargetProfile();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.smooks.AbstractResourceConfig <em>Abstract Resource Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Resource Config</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.AbstractResourceConfig
	 * @generated
	 */
	EClass getAbstractResourceConfig();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.smooks.ConditionsType <em>Conditions Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditions Type</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ConditionsType
	 * @generated
	 */
	EClass getConditionsType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.tools.smooks.model.smooks.ConditionsType#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Condition</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ConditionsType#getCondition()
	 * @see #getConditionsType()
	 * @generated
	 */
	EReference getConditionsType_Condition();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.smooks.ConditionType <em>Condition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition Type</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ConditionType
	 * @generated
	 */
	EClass getConditionType();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.smooks.ConditionType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ConditionType#getValue()
	 * @see #getConditionType()
	 * @generated
	 */
	EAttribute getConditionType_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.smooks.ConditionType#getEvaluator <em>Evaluator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Evaluator</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ConditionType#getEvaluator()
	 * @see #getConditionType()
	 * @generated
	 */
	EAttribute getConditionType_Evaluator();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.smooks.ConditionType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ConditionType#getId()
	 * @see #getConditionType()
	 * @generated
	 */
	EAttribute getConditionType_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.smooks.ConditionType#getIdRef <em>Id Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Ref</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ConditionType#getIdRef()
	 * @see #getConditionType()
	 * @generated
	 */
	EAttribute getConditionType_IdRef();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getAbstractReader <em>Abstract Reader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Abstract Reader</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.DocumentRoot#getAbstractReader()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_AbstractReader();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getAbstractResourceConfig <em>Abstract Resource Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Abstract Resource Config</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.DocumentRoot#getAbstractResourceConfig()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_AbstractResourceConfig();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.DocumentRoot#getCondition()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getConditions <em>Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Conditions</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.DocumentRoot#getConditions()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Conditions();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getElementVisitor <em>Element Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Element Visitor</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.DocumentRoot#getElementVisitor()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_ElementVisitor();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Features</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.DocumentRoot#getFeatures()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Features();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getHandler <em>Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Handler</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.DocumentRoot#getHandler()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Handler();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getHandlers <em>Handlers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Handlers</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.DocumentRoot#getHandlers()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Handlers();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getImport <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Import</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.DocumentRoot#getImport()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Import();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getParam <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Param</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.DocumentRoot#getParam()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Param();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getParams <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Params</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.DocumentRoot#getParams()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Params();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getProfile <em>Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Profile</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.DocumentRoot#getProfile()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Profile();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getProfiles <em>Profiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Profiles</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.DocumentRoot#getProfiles()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Profiles();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getReader <em>Reader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reader</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.DocumentRoot#getReader()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Reader();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resource</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.DocumentRoot#getResource()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Resource();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getResourceConfig <em>Resource Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resource Config</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.DocumentRoot#getResourceConfig()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_ResourceConfig();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getSetOff <em>Set Off</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Set Off</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.DocumentRoot#getSetOff()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_SetOff();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getSetOn <em>Set On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Set On</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.DocumentRoot#getSetOn()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_SetOn();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.DocumentRoot#getSmooksResourceList <em>Smooks Resource List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Smooks Resource List</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.DocumentRoot#getSmooksResourceList()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_SmooksResourceList();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.smooks.ElementVisitor <em>Element Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Visitor</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ElementVisitor
	 * @generated
	 */
	EClass getElementVisitor();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.ElementVisitor#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ElementVisitor#getCondition()
	 * @see #getElementVisitor()
	 * @generated
	 */
	EReference getElementVisitor_Condition();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.smooks.ElementVisitor#getTargetProfile <em>Target Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Profile</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ElementVisitor#getTargetProfile()
	 * @see #getElementVisitor()
	 * @generated
	 */
	EAttribute getElementVisitor_TargetProfile();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.smooks.FeaturesType <em>Features Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Features Type</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.FeaturesType
	 * @generated
	 */
	EClass getFeaturesType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.tools.smooks.model.smooks.FeaturesType#getSetOn <em>Set On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Set On</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.FeaturesType#getSetOn()
	 * @see #getFeaturesType()
	 * @generated
	 */
	EReference getFeaturesType_SetOn();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.tools.smooks.model.smooks.FeaturesType#getSetOff <em>Set Off</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Set Off</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.FeaturesType#getSetOff()
	 * @see #getFeaturesType()
	 * @generated
	 */
	EReference getFeaturesType_SetOff();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.smooks.HandlersType <em>Handlers Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Handlers Type</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.HandlersType
	 * @generated
	 */
	EClass getHandlersType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.tools.smooks.model.smooks.HandlersType#getHandler <em>Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Handler</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.HandlersType#getHandler()
	 * @see #getHandlersType()
	 * @generated
	 */
	EReference getHandlersType_Handler();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.smooks.HandlerType <em>Handler Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Handler Type</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.HandlerType
	 * @generated
	 */
	EClass getHandlerType();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.smooks.HandlerType#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.HandlerType#getClass_()
	 * @see #getHandlerType()
	 * @generated
	 */
	EAttribute getHandlerType_Class();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.smooks.ImportType <em>Import Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import Type</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ImportType
	 * @generated
	 */
	EClass getImportType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.tools.smooks.model.smooks.ImportType#getParam <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Param</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ImportType#getParam()
	 * @see #getImportType()
	 * @generated
	 */
	EReference getImportType_Param();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.smooks.ImportType#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ImportType#getFile()
	 * @see #getImportType()
	 * @generated
	 */
	EAttribute getImportType_File();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.smooks.ParamsType <em>Params Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Params Type</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ParamsType
	 * @generated
	 */
	EClass getParamsType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.tools.smooks.model.smooks.ParamsType#getParam <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Param</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ParamsType#getParam()
	 * @see #getParamsType()
	 * @generated
	 */
	EReference getParamsType_Param();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.smooks.ParamType <em>Param Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Param Type</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ParamType
	 * @generated
	 */
	EClass getParamType();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.smooks.ParamType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ParamType#getName()
	 * @see #getParamType()
	 * @generated
	 */
	EAttribute getParamType_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.smooks.ParamType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ParamType#getType()
	 * @see #getParamType()
	 * @generated
	 */
	EAttribute getParamType_Type();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.smooks.ProfilesType <em>Profiles Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Profiles Type</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ProfilesType
	 * @generated
	 */
	EClass getProfilesType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.tools.smooks.model.smooks.ProfilesType#getProfile <em>Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Profile</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ProfilesType#getProfile()
	 * @see #getProfilesType()
	 * @generated
	 */
	EReference getProfilesType_Profile();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.smooks.ProfileType <em>Profile Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Profile Type</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ProfileType
	 * @generated
	 */
	EClass getProfileType();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.smooks.ProfileType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ProfileType#getValue()
	 * @see #getProfileType()
	 * @generated
	 */
	EAttribute getProfileType_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.smooks.ProfileType#getBaseProfile <em>Base Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base Profile</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ProfileType#getBaseProfile()
	 * @see #getProfileType()
	 * @generated
	 */
	EAttribute getProfileType_BaseProfile();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.smooks.ProfileType#getSubProfiles <em>Sub Profiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Profiles</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ProfileType#getSubProfiles()
	 * @see #getProfileType()
	 * @generated
	 */
	EAttribute getProfileType_SubProfiles();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.smooks.ReaderType <em>Reader Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reader Type</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ReaderType
	 * @generated
	 */
	EClass getReaderType();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.ReaderType#getHandlers <em>Handlers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Handlers</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ReaderType#getHandlers()
	 * @see #getReaderType()
	 * @generated
	 */
	EReference getReaderType_Handlers();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.ReaderType#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Features</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ReaderType#getFeatures()
	 * @see #getReaderType()
	 * @generated
	 */
	EReference getReaderType_Features();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.ReaderType#getParams <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Params</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ReaderType#getParams()
	 * @see #getReaderType()
	 * @generated
	 */
	EReference getReaderType_Params();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.smooks.ReaderType#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ReaderType#getClass_()
	 * @see #getReaderType()
	 * @generated
	 */
	EAttribute getReaderType_Class();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.smooks.ResourceConfigType <em>Resource Config Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Config Type</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ResourceConfigType
	 * @generated
	 */
	EClass getResourceConfigType();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.ResourceConfigType#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resource</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ResourceConfigType#getResource()
	 * @see #getResourceConfigType()
	 * @generated
	 */
	EReference getResourceConfigType_Resource();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.ResourceConfigType#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ResourceConfigType#getCondition()
	 * @see #getResourceConfigType()
	 * @generated
	 */
	EReference getResourceConfigType_Condition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.tools.smooks.model.smooks.ResourceConfigType#getParam <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Param</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ResourceConfigType#getParam()
	 * @see #getResourceConfigType()
	 * @generated
	 */
	EReference getResourceConfigType_Param();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.smooks.ResourceConfigType#getSelector <em>Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selector</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ResourceConfigType#getSelector()
	 * @see #getResourceConfigType()
	 * @generated
	 */
	EAttribute getResourceConfigType_Selector();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.smooks.ResourceConfigType#getSelectorNamespace <em>Selector Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selector Namespace</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ResourceConfigType#getSelectorNamespace()
	 * @see #getResourceConfigType()
	 * @generated
	 */
	EAttribute getResourceConfigType_SelectorNamespace();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.smooks.ResourceConfigType#getTargetProfile <em>Target Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Profile</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ResourceConfigType#getTargetProfile()
	 * @see #getResourceConfigType()
	 * @generated
	 */
	EAttribute getResourceConfigType_TargetProfile();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.smooks.ResourceType <em>Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Type</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ResourceType
	 * @generated
	 */
	EClass getResourceType();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.smooks.ResourceType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ResourceType#getValue()
	 * @see #getResourceType()
	 * @generated
	 */
	EAttribute getResourceType_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.smooks.ResourceType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.ResourceType#getType()
	 * @see #getResourceType()
	 * @generated
	 */
	EAttribute getResourceType_Type();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.smooks.SetOffType <em>Set Off Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Off Type</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.SetOffType
	 * @generated
	 */
	EClass getSetOffType();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.smooks.SetOffType#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.SetOffType#getFeature()
	 * @see #getSetOffType()
	 * @generated
	 */
	EAttribute getSetOffType_Feature();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.smooks.SetOnType <em>Set On Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set On Type</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.SetOnType
	 * @generated
	 */
	EClass getSetOnType();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.smooks.SetOnType#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.SetOnType#getFeature()
	 * @see #getSetOnType()
	 * @generated
	 */
	EAttribute getSetOnType_Feature();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.smooks.SmooksResourceListType <em>Resource List Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource List Type</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.SmooksResourceListType
	 * @generated
	 */
	EClass getSmooksResourceListType();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.SmooksResourceListType#getParams <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Params</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.SmooksResourceListType#getParams()
	 * @see #getSmooksResourceListType()
	 * @generated
	 */
	EReference getSmooksResourceListType_Params();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.SmooksResourceListType#getConditions <em>Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Conditions</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.SmooksResourceListType#getConditions()
	 * @see #getSmooksResourceListType()
	 * @generated
	 */
	EReference getSmooksResourceListType_Conditions();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.smooks.SmooksResourceListType#getProfiles <em>Profiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Profiles</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.SmooksResourceListType#getProfiles()
	 * @see #getSmooksResourceListType()
	 * @generated
	 */
	EReference getSmooksResourceListType_Profiles();

	/**
	 * Returns the meta object for the attribute list '{@link org.jboss.tools.smooks.model.smooks.SmooksResourceListType#getAbstractReaderGroup <em>Abstract Reader Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Abstract Reader Group</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.SmooksResourceListType#getAbstractReaderGroup()
	 * @see #getSmooksResourceListType()
	 * @generated
	 */
	EAttribute getSmooksResourceListType_AbstractReaderGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.tools.smooks.model.smooks.SmooksResourceListType#getAbstractReader <em>Abstract Reader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Abstract Reader</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.SmooksResourceListType#getAbstractReader()
	 * @see #getSmooksResourceListType()
	 * @generated
	 */
	EReference getSmooksResourceListType_AbstractReader();

	/**
	 * Returns the meta object for the attribute list '{@link org.jboss.tools.smooks.model.smooks.SmooksResourceListType#getAbstractResourceConfigGroup <em>Abstract Resource Config Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Abstract Resource Config Group</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.SmooksResourceListType#getAbstractResourceConfigGroup()
	 * @see #getSmooksResourceListType()
	 * @generated
	 */
	EAttribute getSmooksResourceListType_AbstractResourceConfigGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.tools.smooks.model.smooks.SmooksResourceListType#getAbstractResourceConfig <em>Abstract Resource Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Abstract Resource Config</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.SmooksResourceListType#getAbstractResourceConfig()
	 * @see #getSmooksResourceListType()
	 * @generated
	 */
	EReference getSmooksResourceListType_AbstractResourceConfig();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.smooks.SmooksResourceListType#getDefaultConditionRef <em>Default Condition Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Condition Ref</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.SmooksResourceListType#getDefaultConditionRef()
	 * @see #getSmooksResourceListType()
	 * @generated
	 */
	EAttribute getSmooksResourceListType_DefaultConditionRef();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.smooks.SmooksResourceListType#getDefaultSelector <em>Default Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Selector</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.SmooksResourceListType#getDefaultSelector()
	 * @see #getSmooksResourceListType()
	 * @generated
	 */
	EAttribute getSmooksResourceListType_DefaultSelector();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.smooks.SmooksResourceListType#getDefaultSelectorNamespace <em>Default Selector Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Selector Namespace</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.SmooksResourceListType#getDefaultSelectorNamespace()
	 * @see #getSmooksResourceListType()
	 * @generated
	 */
	EAttribute getSmooksResourceListType_DefaultSelectorNamespace();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.smooks.SmooksResourceListType#getDefaultTargetProfile <em>Default Target Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Target Profile</em>'.
	 * @see org.jboss.tools.smooks.model.smooks.SmooksResourceListType#getDefaultTargetProfile()
	 * @see #getSmooksResourceListType()
	 * @generated
	 */
	EAttribute getSmooksResourceListType_DefaultTargetProfile();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SmooksFactory getSmooksFactory();

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
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.smooks.impl.AbstractReaderImpl <em>Abstract Reader</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.smooks.impl.AbstractReaderImpl
		 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getAbstractReader()
		 * @generated
		 */
		EClass ABSTRACT_READER = eINSTANCE.getAbstractReader();

		/**
		 * The meta object literal for the '<em><b>Target Profile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_READER__TARGET_PROFILE = eINSTANCE.getAbstractReader_TargetProfile();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.smooks.impl.AbstractResourceConfigImpl <em>Abstract Resource Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.smooks.impl.AbstractResourceConfigImpl
		 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getAbstractResourceConfig()
		 * @generated
		 */
		EClass ABSTRACT_RESOURCE_CONFIG = eINSTANCE.getAbstractResourceConfig();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.smooks.impl.ConditionsTypeImpl <em>Conditions Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.smooks.impl.ConditionsTypeImpl
		 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getConditionsType()
		 * @generated
		 */
		EClass CONDITIONS_TYPE = eINSTANCE.getConditionsType();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONS_TYPE__CONDITION = eINSTANCE.getConditionsType_Condition();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.smooks.impl.ConditionTypeImpl <em>Condition Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.smooks.impl.ConditionTypeImpl
		 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getConditionType()
		 * @generated
		 */
		EClass CONDITION_TYPE = eINSTANCE.getConditionType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITION_TYPE__VALUE = eINSTANCE.getConditionType_Value();

		/**
		 * The meta object literal for the '<em><b>Evaluator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITION_TYPE__EVALUATOR = eINSTANCE.getConditionType_Evaluator();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITION_TYPE__ID = eINSTANCE.getConditionType_Id();

		/**
		 * The meta object literal for the '<em><b>Id Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITION_TYPE__ID_REF = eINSTANCE.getConditionType_IdRef();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.smooks.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.smooks.impl.DocumentRootImpl
		 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Abstract Reader</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__ABSTRACT_READER = eINSTANCE.getDocumentRoot_AbstractReader();

		/**
		 * The meta object literal for the '<em><b>Abstract Resource Config</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__ABSTRACT_RESOURCE_CONFIG = eINSTANCE.getDocumentRoot_AbstractResourceConfig();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__CONDITION = eINSTANCE.getDocumentRoot_Condition();

		/**
		 * The meta object literal for the '<em><b>Conditions</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__CONDITIONS = eINSTANCE.getDocumentRoot_Conditions();

		/**
		 * The meta object literal for the '<em><b>Element Visitor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__ELEMENT_VISITOR = eINSTANCE.getDocumentRoot_ElementVisitor();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__FEATURES = eINSTANCE.getDocumentRoot_Features();

		/**
		 * The meta object literal for the '<em><b>Handler</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__HANDLER = eINSTANCE.getDocumentRoot_Handler();

		/**
		 * The meta object literal for the '<em><b>Handlers</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__HANDLERS = eINSTANCE.getDocumentRoot_Handlers();

		/**
		 * The meta object literal for the '<em><b>Import</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__IMPORT = eINSTANCE.getDocumentRoot_Import();

		/**
		 * The meta object literal for the '<em><b>Param</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__PARAM = eINSTANCE.getDocumentRoot_Param();

		/**
		 * The meta object literal for the '<em><b>Params</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__PARAMS = eINSTANCE.getDocumentRoot_Params();

		/**
		 * The meta object literal for the '<em><b>Profile</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__PROFILE = eINSTANCE.getDocumentRoot_Profile();

		/**
		 * The meta object literal for the '<em><b>Profiles</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__PROFILES = eINSTANCE.getDocumentRoot_Profiles();

		/**
		 * The meta object literal for the '<em><b>Reader</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__READER = eINSTANCE.getDocumentRoot_Reader();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__RESOURCE = eINSTANCE.getDocumentRoot_Resource();

		/**
		 * The meta object literal for the '<em><b>Resource Config</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__RESOURCE_CONFIG = eINSTANCE.getDocumentRoot_ResourceConfig();

		/**
		 * The meta object literal for the '<em><b>Set Off</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SET_OFF = eINSTANCE.getDocumentRoot_SetOff();

		/**
		 * The meta object literal for the '<em><b>Set On</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SET_ON = eINSTANCE.getDocumentRoot_SetOn();

		/**
		 * The meta object literal for the '<em><b>Smooks Resource List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SMOOKS_RESOURCE_LIST = eINSTANCE.getDocumentRoot_SmooksResourceList();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.smooks.impl.ElementVisitorImpl <em>Element Visitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.smooks.impl.ElementVisitorImpl
		 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getElementVisitor()
		 * @generated
		 */
		EClass ELEMENT_VISITOR = eINSTANCE.getElementVisitor();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_VISITOR__CONDITION = eINSTANCE.getElementVisitor_Condition();

		/**
		 * The meta object literal for the '<em><b>Target Profile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_VISITOR__TARGET_PROFILE = eINSTANCE.getElementVisitor_TargetProfile();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.smooks.impl.FeaturesTypeImpl <em>Features Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.smooks.impl.FeaturesTypeImpl
		 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getFeaturesType()
		 * @generated
		 */
		EClass FEATURES_TYPE = eINSTANCE.getFeaturesType();

		/**
		 * The meta object literal for the '<em><b>Set On</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURES_TYPE__SET_ON = eINSTANCE.getFeaturesType_SetOn();

		/**
		 * The meta object literal for the '<em><b>Set Off</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURES_TYPE__SET_OFF = eINSTANCE.getFeaturesType_SetOff();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.smooks.impl.HandlersTypeImpl <em>Handlers Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.smooks.impl.HandlersTypeImpl
		 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getHandlersType()
		 * @generated
		 */
		EClass HANDLERS_TYPE = eINSTANCE.getHandlersType();

		/**
		 * The meta object literal for the '<em><b>Handler</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HANDLERS_TYPE__HANDLER = eINSTANCE.getHandlersType_Handler();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.smooks.impl.HandlerTypeImpl <em>Handler Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.smooks.impl.HandlerTypeImpl
		 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getHandlerType()
		 * @generated
		 */
		EClass HANDLER_TYPE = eINSTANCE.getHandlerType();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HANDLER_TYPE__CLASS = eINSTANCE.getHandlerType_Class();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.smooks.impl.ImportTypeImpl <em>Import Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.smooks.impl.ImportTypeImpl
		 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getImportType()
		 * @generated
		 */
		EClass IMPORT_TYPE = eINSTANCE.getImportType();

		/**
		 * The meta object literal for the '<em><b>Param</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORT_TYPE__PARAM = eINSTANCE.getImportType_Param();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT_TYPE__FILE = eINSTANCE.getImportType_File();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.smooks.impl.ParamsTypeImpl <em>Params Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.smooks.impl.ParamsTypeImpl
		 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getParamsType()
		 * @generated
		 */
		EClass PARAMS_TYPE = eINSTANCE.getParamsType();

		/**
		 * The meta object literal for the '<em><b>Param</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMS_TYPE__PARAM = eINSTANCE.getParamsType_Param();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.smooks.impl.ParamTypeImpl <em>Param Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.smooks.impl.ParamTypeImpl
		 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getParamType()
		 * @generated
		 */
		EClass PARAM_TYPE = eINSTANCE.getParamType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM_TYPE__NAME = eINSTANCE.getParamType_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM_TYPE__TYPE = eINSTANCE.getParamType_Type();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.smooks.impl.ProfilesTypeImpl <em>Profiles Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.smooks.impl.ProfilesTypeImpl
		 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getProfilesType()
		 * @generated
		 */
		EClass PROFILES_TYPE = eINSTANCE.getProfilesType();

		/**
		 * The meta object literal for the '<em><b>Profile</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROFILES_TYPE__PROFILE = eINSTANCE.getProfilesType_Profile();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.smooks.impl.ProfileTypeImpl <em>Profile Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.smooks.impl.ProfileTypeImpl
		 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getProfileType()
		 * @generated
		 */
		EClass PROFILE_TYPE = eINSTANCE.getProfileType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILE_TYPE__VALUE = eINSTANCE.getProfileType_Value();

		/**
		 * The meta object literal for the '<em><b>Base Profile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILE_TYPE__BASE_PROFILE = eINSTANCE.getProfileType_BaseProfile();

		/**
		 * The meta object literal for the '<em><b>Sub Profiles</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILE_TYPE__SUB_PROFILES = eINSTANCE.getProfileType_SubProfiles();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.smooks.impl.ReaderTypeImpl <em>Reader Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.smooks.impl.ReaderTypeImpl
		 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getReaderType()
		 * @generated
		 */
		EClass READER_TYPE = eINSTANCE.getReaderType();

		/**
		 * The meta object literal for the '<em><b>Handlers</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference READER_TYPE__HANDLERS = eINSTANCE.getReaderType_Handlers();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference READER_TYPE__FEATURES = eINSTANCE.getReaderType_Features();

		/**
		 * The meta object literal for the '<em><b>Params</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference READER_TYPE__PARAMS = eINSTANCE.getReaderType_Params();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute READER_TYPE__CLASS = eINSTANCE.getReaderType_Class();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.smooks.impl.ResourceConfigTypeImpl <em>Resource Config Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.smooks.impl.ResourceConfigTypeImpl
		 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getResourceConfigType()
		 * @generated
		 */
		EClass RESOURCE_CONFIG_TYPE = eINSTANCE.getResourceConfigType();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_CONFIG_TYPE__RESOURCE = eINSTANCE.getResourceConfigType_Resource();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_CONFIG_TYPE__CONDITION = eINSTANCE.getResourceConfigType_Condition();

		/**
		 * The meta object literal for the '<em><b>Param</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_CONFIG_TYPE__PARAM = eINSTANCE.getResourceConfigType_Param();

		/**
		 * The meta object literal for the '<em><b>Selector</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_CONFIG_TYPE__SELECTOR = eINSTANCE.getResourceConfigType_Selector();

		/**
		 * The meta object literal for the '<em><b>Selector Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_CONFIG_TYPE__SELECTOR_NAMESPACE = eINSTANCE.getResourceConfigType_SelectorNamespace();

		/**
		 * The meta object literal for the '<em><b>Target Profile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_CONFIG_TYPE__TARGET_PROFILE = eINSTANCE.getResourceConfigType_TargetProfile();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.smooks.impl.ResourceTypeImpl <em>Resource Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.smooks.impl.ResourceTypeImpl
		 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getResourceType()
		 * @generated
		 */
		EClass RESOURCE_TYPE = eINSTANCE.getResourceType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_TYPE__VALUE = eINSTANCE.getResourceType_Value();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_TYPE__TYPE = eINSTANCE.getResourceType_Type();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.smooks.impl.SetOffTypeImpl <em>Set Off Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.smooks.impl.SetOffTypeImpl
		 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getSetOffType()
		 * @generated
		 */
		EClass SET_OFF_TYPE = eINSTANCE.getSetOffType();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_OFF_TYPE__FEATURE = eINSTANCE.getSetOffType_Feature();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.smooks.impl.SetOnTypeImpl <em>Set On Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.smooks.impl.SetOnTypeImpl
		 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getSetOnType()
		 * @generated
		 */
		EClass SET_ON_TYPE = eINSTANCE.getSetOnType();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_ON_TYPE__FEATURE = eINSTANCE.getSetOnType_Feature();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.smooks.impl.SmooksResourceListTypeImpl <em>Resource List Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksResourceListTypeImpl
		 * @see org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl#getSmooksResourceListType()
		 * @generated
		 */
		EClass SMOOKS_RESOURCE_LIST_TYPE = eINSTANCE.getSmooksResourceListType();

		/**
		 * The meta object literal for the '<em><b>Params</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMOOKS_RESOURCE_LIST_TYPE__PARAMS = eINSTANCE.getSmooksResourceListType_Params();

		/**
		 * The meta object literal for the '<em><b>Conditions</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMOOKS_RESOURCE_LIST_TYPE__CONDITIONS = eINSTANCE.getSmooksResourceListType_Conditions();

		/**
		 * The meta object literal for the '<em><b>Profiles</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMOOKS_RESOURCE_LIST_TYPE__PROFILES = eINSTANCE.getSmooksResourceListType_Profiles();

		/**
		 * The meta object literal for the '<em><b>Abstract Reader Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_READER_GROUP = eINSTANCE.getSmooksResourceListType_AbstractReaderGroup();

		/**
		 * The meta object literal for the '<em><b>Abstract Reader</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_READER = eINSTANCE.getSmooksResourceListType_AbstractReader();

		/**
		 * The meta object literal for the '<em><b>Abstract Resource Config Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_RESOURCE_CONFIG_GROUP = eINSTANCE.getSmooksResourceListType_AbstractResourceConfigGroup();

		/**
		 * The meta object literal for the '<em><b>Abstract Resource Config</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_RESOURCE_CONFIG = eINSTANCE.getSmooksResourceListType_AbstractResourceConfig();

		/**
		 * The meta object literal for the '<em><b>Default Condition Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_CONDITION_REF = eINSTANCE.getSmooksResourceListType_DefaultConditionRef();

		/**
		 * The meta object literal for the '<em><b>Default Selector</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_SELECTOR = eINSTANCE.getSmooksResourceListType_DefaultSelector();

		/**
		 * The meta object literal for the '<em><b>Default Selector Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_SELECTOR_NAMESPACE = eINSTANCE.getSmooksResourceListType_DefaultSelectorNamespace();

		/**
		 * The meta object literal for the '<em><b>Default Target Profile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_TARGET_PROFILE = eINSTANCE.getSmooksResourceListType_DefaultTargetProfile();

	}

} //SmooksPackage
