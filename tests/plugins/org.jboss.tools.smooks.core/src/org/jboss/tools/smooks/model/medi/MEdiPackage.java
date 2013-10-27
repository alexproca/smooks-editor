/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.medi;


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
 * @see org.jboss.tools.smooks.model.medi.MEdiFactory
 * @model kind="package"
 * @generated
 */
public interface MEdiPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "eedi"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.milyn.org/schema/edi-message-mapping-1.0.xsd"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "eedi"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MEdiPackage eINSTANCE = org.jboss.tools.smooks.model.medi.impl.MEdiPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.medi.impl.MappingNodeImpl <em>Mapping Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.medi.impl.MappingNodeImpl
	 * @see org.jboss.tools.smooks.model.medi.impl.MEdiPackageImpl#getMappingNode()
	 * @generated
	 */
	int MAPPING_NODE = 6;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_NODE__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_NODE__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_NODE__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Xmltag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_NODE__XMLTAG = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mapping Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_NODE_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.medi.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.medi.impl.ComponentImpl
	 * @see org.jboss.tools.smooks.model.medi.impl.MEdiPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__MIXED = MAPPING_NODE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__ANY = MAPPING_NODE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__ANY_ATTRIBUTE = MAPPING_NODE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Xmltag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__XMLTAG = MAPPING_NODE__XMLTAG;

	/**
	 * The feature id for the '<em><b>Sub Component</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__SUB_COMPONENT = MAPPING_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__REQUIRED = MAPPING_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Truncatable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__TRUNCATABLE = MAPPING_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = MAPPING_NODE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.medi.impl.DelimitersImpl <em>Delimiters</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.medi.impl.DelimitersImpl
	 * @see org.jboss.tools.smooks.model.medi.impl.MEdiPackageImpl#getDelimiters()
	 * @generated
	 */
	int DELIMITERS = 1;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIMITERS__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIMITERS__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIMITERS__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Component</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIMITERS__COMPONENT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIMITERS__FIELD = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Segment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIMITERS__SEGMENT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sub Component</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIMITERS__SUB_COMPONENT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Delimiters</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIMITERS_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.medi.impl.DescriptionImpl <em>Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.medi.impl.DescriptionImpl
	 * @see org.jboss.tools.smooks.model.medi.impl.MEdiPackageImpl#getDescription()
	 * @generated
	 */
	int DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION__NAME = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION__VERSION = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.medi.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.medi.impl.DocumentRootImpl
	 * @see org.jboss.tools.smooks.model.medi.impl.MEdiPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 3;

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
	 * The feature id for the '<em><b>Edimap</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__EDIMAP = 3;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.medi.impl.EdiMapImpl <em>Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.medi.impl.EdiMapImpl
	 * @see org.jboss.tools.smooks.model.medi.impl.MEdiPackageImpl#getEdiMap()
	 * @generated
	 */
	int EDI_MAP = 4;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDI_MAP__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDI_MAP__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDI_MAP__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDI_MAP__DESCRIPTION = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Delimiters</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDI_MAP__DELIMITERS = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Segments</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDI_MAP__SEGMENTS = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDI_MAP_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.medi.impl.FieldImpl <em>Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.medi.impl.FieldImpl
	 * @see org.jboss.tools.smooks.model.medi.impl.MEdiPackageImpl#getField()
	 * @generated
	 */
	int FIELD = 5;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__MIXED = MAPPING_NODE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__ANY = MAPPING_NODE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__ANY_ATTRIBUTE = MAPPING_NODE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Xmltag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__XMLTAG = MAPPING_NODE__XMLTAG;

	/**
	 * The feature id for the '<em><b>Component</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__COMPONENT = MAPPING_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__REQUIRED = MAPPING_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Truncatable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__TRUNCATABLE = MAPPING_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_FEATURE_COUNT = MAPPING_NODE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.medi.impl.SegmentImpl <em>Segment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.medi.impl.SegmentImpl
	 * @see org.jboss.tools.smooks.model.medi.impl.MEdiPackageImpl#getSegment()
	 * @generated
	 */
	int SEGMENT = 7;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__MIXED = MAPPING_NODE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__ANY = MAPPING_NODE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__ANY_ATTRIBUTE = MAPPING_NODE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Xmltag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__XMLTAG = MAPPING_NODE__XMLTAG;

	/**
	 * The feature id for the '<em><b>Field</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__FIELD = MAPPING_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Segment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__SEGMENT = MAPPING_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__MAX_OCCURS = MAPPING_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Min Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__MIN_OCCURS = MAPPING_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Segcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__SEGCODE = MAPPING_NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Truncatable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__TRUNCATABLE = MAPPING_NODE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT_FEATURE_COUNT = MAPPING_NODE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.medi.impl.SegmentsImpl <em>Segments</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.medi.impl.SegmentsImpl
	 * @see org.jboss.tools.smooks.model.medi.impl.MEdiPackageImpl#getSegments()
	 * @generated
	 */
	int SEGMENTS = 8;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENTS__MIXED = MAPPING_NODE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENTS__ANY = MAPPING_NODE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENTS__ANY_ATTRIBUTE = MAPPING_NODE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Xmltag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENTS__XMLTAG = MAPPING_NODE__XMLTAG;

	/**
	 * The feature id for the '<em><b>Segment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENTS__SEGMENT = MAPPING_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Segments</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENTS_FEATURE_COUNT = MAPPING_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.medi.impl.SubComponentImpl <em>Sub Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.medi.impl.SubComponentImpl
	 * @see org.jboss.tools.smooks.model.medi.impl.MEdiPackageImpl#getSubComponent()
	 * @generated
	 */
	int SUB_COMPONENT = 9;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_COMPONENT__MIXED = MAPPING_NODE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_COMPONENT__ANY = MAPPING_NODE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_COMPONENT__ANY_ATTRIBUTE = MAPPING_NODE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Xmltag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_COMPONENT__XMLTAG = MAPPING_NODE__XMLTAG;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_COMPONENT__REQUIRED = MAPPING_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sub Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_COMPONENT_FEATURE_COUNT = MAPPING_NODE_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.medi.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see org.jboss.tools.smooks.model.medi.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.tools.smooks.model.medi.Component#getSubComponent <em>Sub Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Component</em>'.
	 * @see org.jboss.tools.smooks.model.medi.Component#getSubComponent()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_SubComponent();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.medi.Component#isRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see org.jboss.tools.smooks.model.medi.Component#isRequired()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_Required();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.medi.Component#isTruncatable <em>Truncatable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Truncatable</em>'.
	 * @see org.jboss.tools.smooks.model.medi.Component#isTruncatable()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_Truncatable();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.medi.Delimiters <em>Delimiters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delimiters</em>'.
	 * @see org.jboss.tools.smooks.model.medi.Delimiters
	 * @generated
	 */
	EClass getDelimiters();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.medi.Delimiters#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Component</em>'.
	 * @see org.jboss.tools.smooks.model.medi.Delimiters#getComponent()
	 * @see #getDelimiters()
	 * @generated
	 */
	EAttribute getDelimiters_Component();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.medi.Delimiters#getField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field</em>'.
	 * @see org.jboss.tools.smooks.model.medi.Delimiters#getField()
	 * @see #getDelimiters()
	 * @generated
	 */
	EAttribute getDelimiters_Field();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.medi.Delimiters#getSegment <em>Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Segment</em>'.
	 * @see org.jboss.tools.smooks.model.medi.Delimiters#getSegment()
	 * @see #getDelimiters()
	 * @generated
	 */
	EAttribute getDelimiters_Segment();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.medi.Delimiters#getSubComponent <em>Sub Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Component</em>'.
	 * @see org.jboss.tools.smooks.model.medi.Delimiters#getSubComponent()
	 * @see #getDelimiters()
	 * @generated
	 */
	EAttribute getDelimiters_SubComponent();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.medi.Description <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Description</em>'.
	 * @see org.jboss.tools.smooks.model.medi.Description
	 * @generated
	 */
	EClass getDescription();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.medi.Description#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.jboss.tools.smooks.model.medi.Description#getName()
	 * @see #getDescription()
	 * @generated
	 */
	EAttribute getDescription_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.medi.Description#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.jboss.tools.smooks.model.medi.Description#getVersion()
	 * @see #getDescription()
	 * @generated
	 */
	EAttribute getDescription_Version();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.medi.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.jboss.tools.smooks.model.medi.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.jboss.tools.smooks.model.medi.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.jboss.tools.smooks.model.medi.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.jboss.tools.smooks.model.medi.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.jboss.tools.smooks.model.medi.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.jboss.tools.smooks.model.medi.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.jboss.tools.smooks.model.medi.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.medi.DocumentRoot#getEdimap <em>Edimap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Edimap</em>'.
	 * @see org.jboss.tools.smooks.model.medi.DocumentRoot#getEdimap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Edimap();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.medi.EdiMap <em>Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map</em>'.
	 * @see org.jboss.tools.smooks.model.medi.EdiMap
	 * @generated
	 */
	EClass getEdiMap();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.medi.EdiMap#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Description</em>'.
	 * @see org.jboss.tools.smooks.model.medi.EdiMap#getDescription()
	 * @see #getEdiMap()
	 * @generated
	 */
	EReference getEdiMap_Description();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.medi.EdiMap#getDelimiters <em>Delimiters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Delimiters</em>'.
	 * @see org.jboss.tools.smooks.model.medi.EdiMap#getDelimiters()
	 * @see #getEdiMap()
	 * @generated
	 */
	EReference getEdiMap_Delimiters();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.medi.EdiMap#getSegments <em>Segments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Segments</em>'.
	 * @see org.jboss.tools.smooks.model.medi.EdiMap#getSegments()
	 * @see #getEdiMap()
	 * @generated
	 */
	EReference getEdiMap_Segments();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.medi.Field <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Field</em>'.
	 * @see org.jboss.tools.smooks.model.medi.Field
	 * @generated
	 */
	EClass getField();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.tools.smooks.model.medi.Field#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Component</em>'.
	 * @see org.jboss.tools.smooks.model.medi.Field#getComponent()
	 * @see #getField()
	 * @generated
	 */
	EReference getField_Component();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.medi.Field#isRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see org.jboss.tools.smooks.model.medi.Field#isRequired()
	 * @see #getField()
	 * @generated
	 */
	EAttribute getField_Required();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.medi.Field#isTruncatable <em>Truncatable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Truncatable</em>'.
	 * @see org.jboss.tools.smooks.model.medi.Field#isTruncatable()
	 * @see #getField()
	 * @generated
	 */
	EAttribute getField_Truncatable();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.medi.MappingNode <em>Mapping Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Node</em>'.
	 * @see org.jboss.tools.smooks.model.medi.MappingNode
	 * @generated
	 */
	EClass getMappingNode();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.medi.MappingNode#getXmltag <em>Xmltag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xmltag</em>'.
	 * @see org.jboss.tools.smooks.model.medi.MappingNode#getXmltag()
	 * @see #getMappingNode()
	 * @generated
	 */
	EAttribute getMappingNode_Xmltag();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.medi.Segment <em>Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Segment</em>'.
	 * @see org.jboss.tools.smooks.model.medi.Segment
	 * @generated
	 */
	EClass getSegment();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.tools.smooks.model.medi.Segment#getField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Field</em>'.
	 * @see org.jboss.tools.smooks.model.medi.Segment#getField()
	 * @see #getSegment()
	 * @generated
	 */
	EReference getSegment_Field();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.tools.smooks.model.medi.Segment#getSegment <em>Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Segment</em>'.
	 * @see org.jboss.tools.smooks.model.medi.Segment#getSegment()
	 * @see #getSegment()
	 * @generated
	 */
	EReference getSegment_Segment();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.medi.Segment#getMaxOccurs <em>Max Occurs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Occurs</em>'.
	 * @see org.jboss.tools.smooks.model.medi.Segment#getMaxOccurs()
	 * @see #getSegment()
	 * @generated
	 */
	EAttribute getSegment_MaxOccurs();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.medi.Segment#getMinOccurs <em>Min Occurs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Occurs</em>'.
	 * @see org.jboss.tools.smooks.model.medi.Segment#getMinOccurs()
	 * @see #getSegment()
	 * @generated
	 */
	EAttribute getSegment_MinOccurs();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.medi.Segment#getSegcode <em>Segcode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Segcode</em>'.
	 * @see org.jboss.tools.smooks.model.medi.Segment#getSegcode()
	 * @see #getSegment()
	 * @generated
	 */
	EAttribute getSegment_Segcode();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.medi.Segment#isTruncatable <em>Truncatable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Truncatable</em>'.
	 * @see org.jboss.tools.smooks.model.medi.Segment#isTruncatable()
	 * @see #getSegment()
	 * @generated
	 */
	EAttribute getSegment_Truncatable();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.medi.Segments <em>Segments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Segments</em>'.
	 * @see org.jboss.tools.smooks.model.medi.Segments
	 * @generated
	 */
	EClass getSegments();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.tools.smooks.model.medi.Segments#getSegment <em>Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Segment</em>'.
	 * @see org.jboss.tools.smooks.model.medi.Segments#getSegment()
	 * @see #getSegments()
	 * @generated
	 */
	EReference getSegments_Segment();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.medi.SubComponent <em>Sub Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Component</em>'.
	 * @see org.jboss.tools.smooks.model.medi.SubComponent
	 * @generated
	 */
	EClass getSubComponent();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.medi.SubComponent#isRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see org.jboss.tools.smooks.model.medi.SubComponent#isRequired()
	 * @see #getSubComponent()
	 * @generated
	 */
	EAttribute getSubComponent_Required();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MEdiFactory getEdiFactory();

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
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.medi.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.medi.impl.ComponentImpl
		 * @see org.jboss.tools.smooks.model.medi.impl.MEdiPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Sub Component</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__SUB_COMPONENT = eINSTANCE.getComponent_SubComponent();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__REQUIRED = eINSTANCE.getComponent_Required();

		/**
		 * The meta object literal for the '<em><b>Truncatable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__TRUNCATABLE = eINSTANCE.getComponent_Truncatable();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.medi.impl.DelimitersImpl <em>Delimiters</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.medi.impl.DelimitersImpl
		 * @see org.jboss.tools.smooks.model.medi.impl.MEdiPackageImpl#getDelimiters()
		 * @generated
		 */
		EClass DELIMITERS = eINSTANCE.getDelimiters();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DELIMITERS__COMPONENT = eINSTANCE.getDelimiters_Component();

		/**
		 * The meta object literal for the '<em><b>Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DELIMITERS__FIELD = eINSTANCE.getDelimiters_Field();

		/**
		 * The meta object literal for the '<em><b>Segment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DELIMITERS__SEGMENT = eINSTANCE.getDelimiters_Segment();

		/**
		 * The meta object literal for the '<em><b>Sub Component</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DELIMITERS__SUB_COMPONENT = eINSTANCE.getDelimiters_SubComponent();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.medi.impl.DescriptionImpl <em>Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.medi.impl.DescriptionImpl
		 * @see org.jboss.tools.smooks.model.medi.impl.MEdiPackageImpl#getDescription()
		 * @generated
		 */
		EClass DESCRIPTION = eINSTANCE.getDescription();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESCRIPTION__NAME = eINSTANCE.getDescription_Name();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESCRIPTION__VERSION = eINSTANCE.getDescription_Version();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.medi.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.medi.impl.DocumentRootImpl
		 * @see org.jboss.tools.smooks.model.medi.impl.MEdiPackageImpl#getDocumentRoot()
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
		 * The meta object literal for the '<em><b>Edimap</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__EDIMAP = eINSTANCE.getDocumentRoot_Edimap();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.medi.impl.EdiMapImpl <em>Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.medi.impl.EdiMapImpl
		 * @see org.jboss.tools.smooks.model.medi.impl.MEdiPackageImpl#getEdiMap()
		 * @generated
		 */
		EClass EDI_MAP = eINSTANCE.getEdiMap();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDI_MAP__DESCRIPTION = eINSTANCE.getEdiMap_Description();

		/**
		 * The meta object literal for the '<em><b>Delimiters</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDI_MAP__DELIMITERS = eINSTANCE.getEdiMap_Delimiters();

		/**
		 * The meta object literal for the '<em><b>Segments</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDI_MAP__SEGMENTS = eINSTANCE.getEdiMap_Segments();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.medi.impl.FieldImpl <em>Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.medi.impl.FieldImpl
		 * @see org.jboss.tools.smooks.model.medi.impl.MEdiPackageImpl#getField()
		 * @generated
		 */
		EClass FIELD = eINSTANCE.getField();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIELD__COMPONENT = eINSTANCE.getField_Component();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD__REQUIRED = eINSTANCE.getField_Required();

		/**
		 * The meta object literal for the '<em><b>Truncatable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD__TRUNCATABLE = eINSTANCE.getField_Truncatable();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.medi.impl.MappingNodeImpl <em>Mapping Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.medi.impl.MappingNodeImpl
		 * @see org.jboss.tools.smooks.model.medi.impl.MEdiPackageImpl#getMappingNode()
		 * @generated
		 */
		EClass MAPPING_NODE = eINSTANCE.getMappingNode();

		/**
		 * The meta object literal for the '<em><b>Xmltag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_NODE__XMLTAG = eINSTANCE.getMappingNode_Xmltag();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.medi.impl.SegmentImpl <em>Segment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.medi.impl.SegmentImpl
		 * @see org.jboss.tools.smooks.model.medi.impl.MEdiPackageImpl#getSegment()
		 * @generated
		 */
		EClass SEGMENT = eINSTANCE.getSegment();

		/**
		 * The meta object literal for the '<em><b>Field</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEGMENT__FIELD = eINSTANCE.getSegment_Field();

		/**
		 * The meta object literal for the '<em><b>Segment</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEGMENT__SEGMENT = eINSTANCE.getSegment_Segment();

		/**
		 * The meta object literal for the '<em><b>Max Occurs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEGMENT__MAX_OCCURS = eINSTANCE.getSegment_MaxOccurs();

		/**
		 * The meta object literal for the '<em><b>Min Occurs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEGMENT__MIN_OCCURS = eINSTANCE.getSegment_MinOccurs();

		/**
		 * The meta object literal for the '<em><b>Segcode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEGMENT__SEGCODE = eINSTANCE.getSegment_Segcode();

		/**
		 * The meta object literal for the '<em><b>Truncatable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEGMENT__TRUNCATABLE = eINSTANCE.getSegment_Truncatable();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.medi.impl.SegmentsImpl <em>Segments</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.medi.impl.SegmentsImpl
		 * @see org.jboss.tools.smooks.model.medi.impl.MEdiPackageImpl#getSegments()
		 * @generated
		 */
		EClass SEGMENTS = eINSTANCE.getSegments();

		/**
		 * The meta object literal for the '<em><b>Segment</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEGMENTS__SEGMENT = eINSTANCE.getSegments_Segment();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.medi.impl.SubComponentImpl <em>Sub Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.medi.impl.SubComponentImpl
		 * @see org.jboss.tools.smooks.model.medi.impl.MEdiPackageImpl#getSubComponent()
		 * @generated
		 */
		EClass SUB_COMPONENT = eINSTANCE.getSubComponent();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_COMPONENT__REQUIRED = eINSTANCE.getSubComponent_Required();

	}

} //EdiPackage
