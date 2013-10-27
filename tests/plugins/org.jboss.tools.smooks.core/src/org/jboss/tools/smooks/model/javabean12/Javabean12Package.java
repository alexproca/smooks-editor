/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.javabean12;


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
 * Smooks Java Binding Configuration
 * <!-- end-model-doc -->
 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Factory
 * @model kind="package"
 * @generated
 */
public interface Javabean12Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "javabean12"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.milyn.org/xsd/smooks/javabean-1.2.xsd"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "jb"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Javabean12Package eINSTANCE = org.jboss.tools.smooks.model.javabean12.impl.Javabean12PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.javabean12.impl.BeanTypeImpl <em>Bean Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.javabean12.impl.BeanTypeImpl
	 * @see org.jboss.tools.smooks.model.javabean12.impl.Javabean12PackageImpl#getBeanType()
	 * @generated
	 */
	int BEAN_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_TYPE__MIXED = SmooksPackage.ELEMENT_VISITOR__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_TYPE__ANY = SmooksPackage.ELEMENT_VISITOR__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_TYPE__ANY_ATTRIBUTE = SmooksPackage.ELEMENT_VISITOR__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_TYPE__CONDITION = SmooksPackage.ELEMENT_VISITOR__CONDITION;

	/**
	 * The feature id for the '<em><b>Target Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_TYPE__TARGET_PROFILE = SmooksPackage.ELEMENT_VISITOR__TARGET_PROFILE;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_TYPE__GROUP = SmooksPackage.ELEMENT_VISITOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_TYPE__VALUE = SmooksPackage.ELEMENT_VISITOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Wiring</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_TYPE__WIRING = SmooksPackage.ELEMENT_VISITOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_TYPE__EXPRESSION = SmooksPackage.ELEMENT_VISITOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Bean Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_TYPE__BEAN_ID = SmooksPackage.ELEMENT_VISITOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_TYPE__CLASS = SmooksPackage.ELEMENT_VISITOR_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Create On Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_TYPE__CREATE_ON_ELEMENT = SmooksPackage.ELEMENT_VISITOR_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Create On Element NS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_TYPE__CREATE_ON_ELEMENT_NS = SmooksPackage.ELEMENT_VISITOR_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Extend Lifecycle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_TYPE__EXTEND_LIFECYCLE = SmooksPackage.ELEMENT_VISITOR_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Bean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_TYPE_FEATURE_COUNT = SmooksPackage.ELEMENT_VISITOR_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.javabean12.impl.DecodeParamTypeImpl <em>Decode Param Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.javabean12.impl.DecodeParamTypeImpl
	 * @see org.jboss.tools.smooks.model.javabean12.impl.Javabean12PackageImpl#getDecodeParamType()
	 * @generated
	 */
	int DECODE_PARAM_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECODE_PARAM_TYPE__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECODE_PARAM_TYPE__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECODE_PARAM_TYPE__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECODE_PARAM_TYPE__VALUE = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECODE_PARAM_TYPE__NAME = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Decode Param Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECODE_PARAM_TYPE_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.javabean12.impl.Javabean12DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.javabean12.impl.Javabean12DocumentRootImpl
	 * @see org.jboss.tools.smooks.model.javabean12.impl.Javabean12PackageImpl#getJavabean12DocumentRoot()
	 * @generated
	 */
	int JAVABEAN12_DOCUMENT_ROOT = 2;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVABEAN12_DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVABEAN12_DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVABEAN12_DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Bean</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVABEAN12_DOCUMENT_ROOT__BEAN = 3;

	/**
	 * The feature id for the '<em><b>Decode Param</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVABEAN12_DOCUMENT_ROOT__DECODE_PARAM = 4;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVABEAN12_DOCUMENT_ROOT__EXPRESSION = 5;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVABEAN12_DOCUMENT_ROOT__RESULT = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVABEAN12_DOCUMENT_ROOT__VALUE = 7;

	/**
	 * The feature id for the '<em><b>Wiring</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVABEAN12_DOCUMENT_ROOT__WIRING = 8;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVABEAN12_DOCUMENT_ROOT_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.javabean12.impl.ExpressionTypeImpl <em>Expression Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.javabean12.impl.ExpressionTypeImpl
	 * @see org.jboss.tools.smooks.model.javabean12.impl.Javabean12PackageImpl#getExpressionType()
	 * @generated
	 */
	int EXPRESSION_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_TYPE__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_TYPE__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_TYPE__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_TYPE__VALUE = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exec On Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_TYPE__EXEC_ON_ELEMENT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Exec On Element NS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_TYPE__EXEC_ON_ELEMENT_NS = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Init Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_TYPE__INIT_VAL = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_TYPE__PROPERTY = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Setter Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_TYPE__SETTER_METHOD = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Expression Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_TYPE_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.javabean12.impl.ResultTypeImpl <em>Result Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.javabean12.impl.ResultTypeImpl
	 * @see org.jboss.tools.smooks.model.javabean12.impl.Javabean12PackageImpl#getResultType()
	 * @generated
	 */
	int RESULT_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_TYPE__MIXED = SmooksPackage.ELEMENT_VISITOR__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_TYPE__ANY = SmooksPackage.ELEMENT_VISITOR__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_TYPE__ANY_ATTRIBUTE = SmooksPackage.ELEMENT_VISITOR__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_TYPE__CONDITION = SmooksPackage.ELEMENT_VISITOR__CONDITION;

	/**
	 * The feature id for the '<em><b>Target Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_TYPE__TARGET_PROFILE = SmooksPackage.ELEMENT_VISITOR__TARGET_PROFILE;

	/**
	 * The feature id for the '<em><b>Retain Beans</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_TYPE__RETAIN_BEANS = SmooksPackage.ELEMENT_VISITOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Result Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_TYPE_FEATURE_COUNT = SmooksPackage.ELEMENT_VISITOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.javabean12.impl.ValueTypeImpl <em>Value Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.javabean12.impl.ValueTypeImpl
	 * @see org.jboss.tools.smooks.model.javabean12.impl.Javabean12PackageImpl#getValueType()
	 * @generated
	 */
	int VALUE_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Decode Param</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__DECODE_PARAM = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__DATA = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Data NS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__DATA_NS = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Decoder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__DECODER = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__DEFAULT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__PROPERTY = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Setter Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__SETTER_METHOD = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Value Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.javabean12.impl.WiringTypeImpl <em>Wiring Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.javabean12.impl.WiringTypeImpl
	 * @see org.jboss.tools.smooks.model.javabean12.impl.Javabean12PackageImpl#getWiringType()
	 * @generated
	 */
	int WIRING_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRING_TYPE__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRING_TYPE__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRING_TYPE__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Bean Id Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRING_TYPE__BEAN_ID_REF = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRING_TYPE__PROPERTY = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Setter Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRING_TYPE__SETTER_METHOD = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Wire On Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRING_TYPE__WIRE_ON_ELEMENT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Wire On Element NS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRING_TYPE__WIRE_ON_ELEMENT_NS = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Wiring Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRING_TYPE_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 5;


	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.javabean12.BeanType <em>Bean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bean Type</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.BeanType
	 * @generated
	 */
	EClass getBeanType();

	/**
	 * Returns the meta object for the attribute list '{@link org.jboss.tools.smooks.model.javabean12.BeanType#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.BeanType#getGroup()
	 * @see #getBeanType()
	 * @generated
	 */
	EAttribute getBeanType_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.tools.smooks.model.javabean12.BeanType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.BeanType#getValue()
	 * @see #getBeanType()
	 * @generated
	 */
	EReference getBeanType_Value();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.tools.smooks.model.javabean12.BeanType#getWiring <em>Wiring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Wiring</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.BeanType#getWiring()
	 * @see #getBeanType()
	 * @generated
	 */
	EReference getBeanType_Wiring();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.tools.smooks.model.javabean12.BeanType#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expression</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.BeanType#getExpression()
	 * @see #getBeanType()
	 * @generated
	 */
	EReference getBeanType_Expression();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.javabean12.BeanType#getBeanId <em>Bean Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bean Id</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.BeanType#getBeanId()
	 * @see #getBeanType()
	 * @generated
	 */
	EAttribute getBeanType_BeanId();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.javabean12.BeanType#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.BeanType#getClass_()
	 * @see #getBeanType()
	 * @generated
	 */
	EAttribute getBeanType_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.javabean12.BeanType#getCreateOnElement <em>Create On Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Create On Element</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.BeanType#getCreateOnElement()
	 * @see #getBeanType()
	 * @generated
	 */
	EAttribute getBeanType_CreateOnElement();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.javabean12.BeanType#getCreateOnElementNS <em>Create On Element NS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Create On Element NS</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.BeanType#getCreateOnElementNS()
	 * @see #getBeanType()
	 * @generated
	 */
	EAttribute getBeanType_CreateOnElementNS();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.javabean12.BeanType#isExtendLifecycle <em>Extend Lifecycle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extend Lifecycle</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.BeanType#isExtendLifecycle()
	 * @see #getBeanType()
	 * @generated
	 */
	EAttribute getBeanType_ExtendLifecycle();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.javabean12.DecodeParamType <em>Decode Param Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decode Param Type</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.DecodeParamType
	 * @generated
	 */
	EClass getDecodeParamType();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.javabean12.DecodeParamType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.DecodeParamType#getValue()
	 * @see #getDecodeParamType()
	 * @generated
	 */
	EAttribute getDecodeParamType_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.javabean12.DecodeParamType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.DecodeParamType#getName()
	 * @see #getDecodeParamType()
	 * @generated
	 */
	EAttribute getDecodeParamType_Name();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot
	 * @generated
	 */
	EClass getJavabean12DocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getMixed()
	 * @see #getJavabean12DocumentRoot()
	 * @generated
	 */
	EAttribute getJavabean12DocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getXMLNSPrefixMap()
	 * @see #getJavabean12DocumentRoot()
	 * @generated
	 */
	EReference getJavabean12DocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getXSISchemaLocation()
	 * @see #getJavabean12DocumentRoot()
	 * @generated
	 */
	EReference getJavabean12DocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getBean <em>Bean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bean</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getBean()
	 * @see #getJavabean12DocumentRoot()
	 * @generated
	 */
	EReference getJavabean12DocumentRoot_Bean();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getDecodeParam <em>Decode Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Decode Param</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getDecodeParam()
	 * @see #getJavabean12DocumentRoot()
	 * @generated
	 */
	EReference getJavabean12DocumentRoot_DecodeParam();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getExpression()
	 * @see #getJavabean12DocumentRoot()
	 * @generated
	 */
	EReference getJavabean12DocumentRoot_Expression();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getResult()
	 * @see #getJavabean12DocumentRoot()
	 * @generated
	 */
	EReference getJavabean12DocumentRoot_Result();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getValue()
	 * @see #getJavabean12DocumentRoot()
	 * @generated
	 */
	EReference getJavabean12DocumentRoot_Value();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getWiring <em>Wiring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Wiring</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot#getWiring()
	 * @see #getJavabean12DocumentRoot()
	 * @generated
	 */
	EReference getJavabean12DocumentRoot_Wiring();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.javabean12.ExpressionType <em>Expression Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Type</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.ExpressionType
	 * @generated
	 */
	EClass getExpressionType();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.javabean12.ExpressionType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.ExpressionType#getValue()
	 * @see #getExpressionType()
	 * @generated
	 */
	EAttribute getExpressionType_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.javabean12.ExpressionType#getExecOnElement <em>Exec On Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exec On Element</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.ExpressionType#getExecOnElement()
	 * @see #getExpressionType()
	 * @generated
	 */
	EAttribute getExpressionType_ExecOnElement();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.javabean12.ExpressionType#getExecOnElementNS <em>Exec On Element NS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exec On Element NS</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.ExpressionType#getExecOnElementNS()
	 * @see #getExpressionType()
	 * @generated
	 */
	EAttribute getExpressionType_ExecOnElementNS();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.javabean12.ExpressionType#getInitVal <em>Init Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Init Val</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.ExpressionType#getInitVal()
	 * @see #getExpressionType()
	 * @generated
	 */
	EAttribute getExpressionType_InitVal();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.javabean12.ExpressionType#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.ExpressionType#getProperty()
	 * @see #getExpressionType()
	 * @generated
	 */
	EAttribute getExpressionType_Property();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.javabean12.ExpressionType#getSetterMethod <em>Setter Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Setter Method</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.ExpressionType#getSetterMethod()
	 * @see #getExpressionType()
	 * @generated
	 */
	EAttribute getExpressionType_SetterMethod();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.javabean12.ResultType <em>Result Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result Type</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.ResultType
	 * @generated
	 */
	EClass getResultType();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.javabean12.ResultType#getRetainBeans <em>Retain Beans</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Retain Beans</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.ResultType#getRetainBeans()
	 * @see #getResultType()
	 * @generated
	 */
	EAttribute getResultType_RetainBeans();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.javabean12.ValueType <em>Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Type</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.ValueType
	 * @generated
	 */
	EClass getValueType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.tools.smooks.model.javabean12.ValueType#getDecodeParam <em>Decode Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Decode Param</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.ValueType#getDecodeParam()
	 * @see #getValueType()
	 * @generated
	 */
	EReference getValueType_DecodeParam();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.javabean12.ValueType#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.ValueType#getData()
	 * @see #getValueType()
	 * @generated
	 */
	EAttribute getValueType_Data();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.javabean12.ValueType#getDataNS <em>Data NS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data NS</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.ValueType#getDataNS()
	 * @see #getValueType()
	 * @generated
	 */
	EAttribute getValueType_DataNS();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.javabean12.ValueType#getDecoder <em>Decoder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Decoder</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.ValueType#getDecoder()
	 * @see #getValueType()
	 * @generated
	 */
	EAttribute getValueType_Decoder();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.javabean12.ValueType#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.ValueType#getDefault()
	 * @see #getValueType()
	 * @generated
	 */
	EAttribute getValueType_Default();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.javabean12.ValueType#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.ValueType#getProperty()
	 * @see #getValueType()
	 * @generated
	 */
	EAttribute getValueType_Property();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.javabean12.ValueType#getSetterMethod <em>Setter Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Setter Method</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.ValueType#getSetterMethod()
	 * @see #getValueType()
	 * @generated
	 */
	EAttribute getValueType_SetterMethod();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.javabean12.WiringType <em>Wiring Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wiring Type</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.WiringType
	 * @generated
	 */
	EClass getWiringType();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.javabean12.WiringType#getBeanIdRef <em>Bean Id Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bean Id Ref</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.WiringType#getBeanIdRef()
	 * @see #getWiringType()
	 * @generated
	 */
	EAttribute getWiringType_BeanIdRef();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.javabean12.WiringType#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.WiringType#getProperty()
	 * @see #getWiringType()
	 * @generated
	 */
	EAttribute getWiringType_Property();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.javabean12.WiringType#getSetterMethod <em>Setter Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Setter Method</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.WiringType#getSetterMethod()
	 * @see #getWiringType()
	 * @generated
	 */
	EAttribute getWiringType_SetterMethod();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.javabean12.WiringType#getWireOnElement <em>Wire On Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wire On Element</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.WiringType#getWireOnElement()
	 * @see #getWiringType()
	 * @generated
	 */
	EAttribute getWiringType_WireOnElement();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.javabean12.WiringType#getWireOnElementNS <em>Wire On Element NS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wire On Element NS</em>'.
	 * @see org.jboss.tools.smooks.model.javabean12.WiringType#getWireOnElementNS()
	 * @see #getWiringType()
	 * @generated
	 */
	EAttribute getWiringType_WireOnElementNS();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Javabean12Factory getJavabean12Factory();

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
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.javabean12.impl.BeanTypeImpl <em>Bean Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.javabean12.impl.BeanTypeImpl
		 * @see org.jboss.tools.smooks.model.javabean12.impl.Javabean12PackageImpl#getBeanType()
		 * @generated
		 */
		EClass BEAN_TYPE = eINSTANCE.getBeanType();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEAN_TYPE__GROUP = eINSTANCE.getBeanType_Group();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEAN_TYPE__VALUE = eINSTANCE.getBeanType_Value();

		/**
		 * The meta object literal for the '<em><b>Wiring</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEAN_TYPE__WIRING = eINSTANCE.getBeanType_Wiring();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEAN_TYPE__EXPRESSION = eINSTANCE.getBeanType_Expression();

		/**
		 * The meta object literal for the '<em><b>Bean Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEAN_TYPE__BEAN_ID = eINSTANCE.getBeanType_BeanId();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEAN_TYPE__CLASS = eINSTANCE.getBeanType_Class();

		/**
		 * The meta object literal for the '<em><b>Create On Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEAN_TYPE__CREATE_ON_ELEMENT = eINSTANCE.getBeanType_CreateOnElement();

		/**
		 * The meta object literal for the '<em><b>Create On Element NS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEAN_TYPE__CREATE_ON_ELEMENT_NS = eINSTANCE.getBeanType_CreateOnElementNS();

		/**
		 * The meta object literal for the '<em><b>Extend Lifecycle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEAN_TYPE__EXTEND_LIFECYCLE = eINSTANCE.getBeanType_ExtendLifecycle();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.javabean12.impl.DecodeParamTypeImpl <em>Decode Param Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.javabean12.impl.DecodeParamTypeImpl
		 * @see org.jboss.tools.smooks.model.javabean12.impl.Javabean12PackageImpl#getDecodeParamType()
		 * @generated
		 */
		EClass DECODE_PARAM_TYPE = eINSTANCE.getDecodeParamType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECODE_PARAM_TYPE__VALUE = eINSTANCE.getDecodeParamType_Value();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECODE_PARAM_TYPE__NAME = eINSTANCE.getDecodeParamType_Name();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.javabean12.impl.Javabean12DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.javabean12.impl.Javabean12DocumentRootImpl
		 * @see org.jboss.tools.smooks.model.javabean12.impl.Javabean12PackageImpl#getJavabean12DocumentRoot()
		 * @generated
		 */
		EClass JAVABEAN12_DOCUMENT_ROOT = eINSTANCE.getJavabean12DocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVABEAN12_DOCUMENT_ROOT__MIXED = eINSTANCE.getJavabean12DocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVABEAN12_DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getJavabean12DocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVABEAN12_DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getJavabean12DocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Bean</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVABEAN12_DOCUMENT_ROOT__BEAN = eINSTANCE.getJavabean12DocumentRoot_Bean();

		/**
		 * The meta object literal for the '<em><b>Decode Param</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVABEAN12_DOCUMENT_ROOT__DECODE_PARAM = eINSTANCE.getJavabean12DocumentRoot_DecodeParam();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVABEAN12_DOCUMENT_ROOT__EXPRESSION = eINSTANCE.getJavabean12DocumentRoot_Expression();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVABEAN12_DOCUMENT_ROOT__RESULT = eINSTANCE.getJavabean12DocumentRoot_Result();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVABEAN12_DOCUMENT_ROOT__VALUE = eINSTANCE.getJavabean12DocumentRoot_Value();

		/**
		 * The meta object literal for the '<em><b>Wiring</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVABEAN12_DOCUMENT_ROOT__WIRING = eINSTANCE.getJavabean12DocumentRoot_Wiring();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.javabean12.impl.ExpressionTypeImpl <em>Expression Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.javabean12.impl.ExpressionTypeImpl
		 * @see org.jboss.tools.smooks.model.javabean12.impl.Javabean12PackageImpl#getExpressionType()
		 * @generated
		 */
		EClass EXPRESSION_TYPE = eINSTANCE.getExpressionType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION_TYPE__VALUE = eINSTANCE.getExpressionType_Value();

		/**
		 * The meta object literal for the '<em><b>Exec On Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION_TYPE__EXEC_ON_ELEMENT = eINSTANCE.getExpressionType_ExecOnElement();

		/**
		 * The meta object literal for the '<em><b>Exec On Element NS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION_TYPE__EXEC_ON_ELEMENT_NS = eINSTANCE.getExpressionType_ExecOnElementNS();

		/**
		 * The meta object literal for the '<em><b>Init Val</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION_TYPE__INIT_VAL = eINSTANCE.getExpressionType_InitVal();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION_TYPE__PROPERTY = eINSTANCE.getExpressionType_Property();

		/**
		 * The meta object literal for the '<em><b>Setter Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION_TYPE__SETTER_METHOD = eINSTANCE.getExpressionType_SetterMethod();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.javabean12.impl.ResultTypeImpl <em>Result Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.javabean12.impl.ResultTypeImpl
		 * @see org.jboss.tools.smooks.model.javabean12.impl.Javabean12PackageImpl#getResultType()
		 * @generated
		 */
		EClass RESULT_TYPE = eINSTANCE.getResultType();

		/**
		 * The meta object literal for the '<em><b>Retain Beans</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT_TYPE__RETAIN_BEANS = eINSTANCE.getResultType_RetainBeans();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.javabean12.impl.ValueTypeImpl <em>Value Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.javabean12.impl.ValueTypeImpl
		 * @see org.jboss.tools.smooks.model.javabean12.impl.Javabean12PackageImpl#getValueType()
		 * @generated
		 */
		EClass VALUE_TYPE = eINSTANCE.getValueType();

		/**
		 * The meta object literal for the '<em><b>Decode Param</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_TYPE__DECODE_PARAM = eINSTANCE.getValueType_DecodeParam();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_TYPE__DATA = eINSTANCE.getValueType_Data();

		/**
		 * The meta object literal for the '<em><b>Data NS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_TYPE__DATA_NS = eINSTANCE.getValueType_DataNS();

		/**
		 * The meta object literal for the '<em><b>Decoder</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_TYPE__DECODER = eINSTANCE.getValueType_Decoder();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_TYPE__DEFAULT = eINSTANCE.getValueType_Default();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_TYPE__PROPERTY = eINSTANCE.getValueType_Property();

		/**
		 * The meta object literal for the '<em><b>Setter Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_TYPE__SETTER_METHOD = eINSTANCE.getValueType_SetterMethod();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.javabean12.impl.WiringTypeImpl <em>Wiring Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.javabean12.impl.WiringTypeImpl
		 * @see org.jboss.tools.smooks.model.javabean12.impl.Javabean12PackageImpl#getWiringType()
		 * @generated
		 */
		EClass WIRING_TYPE = eINSTANCE.getWiringType();

		/**
		 * The meta object literal for the '<em><b>Bean Id Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIRING_TYPE__BEAN_ID_REF = eINSTANCE.getWiringType_BeanIdRef();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIRING_TYPE__PROPERTY = eINSTANCE.getWiringType_Property();

		/**
		 * The meta object literal for the '<em><b>Setter Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIRING_TYPE__SETTER_METHOD = eINSTANCE.getWiringType_SetterMethod();

		/**
		 * The meta object literal for the '<em><b>Wire On Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIRING_TYPE__WIRE_ON_ELEMENT = eINSTANCE.getWiringType_WireOnElement();

		/**
		 * The meta object literal for the '<em><b>Wire On Element NS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIRING_TYPE__WIRE_ON_ELEMENT_NS = eINSTANCE.getWiringType_WireOnElementNS();

	}

} //Javabean12Package
