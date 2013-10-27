/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.edi12;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * Smooks EDI Reader Configuration
 * <!-- end-model-doc -->
 * @see org.jboss.tools.smooks.model.edi12.Edi12Factory
 * @model kind="package"
 * @generated
 */
public interface Edi12Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "edi12"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.milyn.org/xsd/smooks/edi-1.2.xsd"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "edi"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Edi12Package eINSTANCE = org.jboss.tools.smooks.model.edi12.impl.Edi12PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.edi12.impl.EDI12DocumentRootImpl <em>EDI12 Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.edi12.impl.EDI12DocumentRootImpl
	 * @see org.jboss.tools.smooks.model.edi12.impl.Edi12PackageImpl#getEDI12DocumentRoot()
	 * @generated
	 */
	int EDI12_DOCUMENT_ROOT = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDI12_DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDI12_DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDI12_DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Reader</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDI12_DOCUMENT_ROOT__READER = 3;

	/**
	 * The number of structural features of the '<em>EDI12 Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDI12_DOCUMENT_ROOT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.edi12.impl.EDI12ReaderImpl <em>EDI12 Reader</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.edi12.impl.EDI12ReaderImpl
	 * @see org.jboss.tools.smooks.model.edi12.impl.Edi12PackageImpl#getEDI12Reader()
	 * @generated
	 */
	int EDI12_READER = 1;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDI12_READER__MIXED = SmooksPackage.ABSTRACT_READER__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDI12_READER__ANY = SmooksPackage.ABSTRACT_READER__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDI12_READER__ANY_ATTRIBUTE = SmooksPackage.ABSTRACT_READER__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Target Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDI12_READER__TARGET_PROFILE = SmooksPackage.ABSTRACT_READER__TARGET_PROFILE;

	/**
	 * The feature id for the '<em><b>Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDI12_READER__ENCODING = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mapping Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDI12_READER__MAPPING_MODEL = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Validate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDI12_READER__VALIDATE = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>EDI12 Reader</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDI12_READER_FEATURE_COUNT = SmooksPackage.ABSTRACT_READER_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.edi12.EDI12DocumentRoot <em>EDI12 Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EDI12 Document Root</em>'.
	 * @see org.jboss.tools.smooks.model.edi12.EDI12DocumentRoot
	 * @generated
	 */
	EClass getEDI12DocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.jboss.tools.smooks.model.edi12.EDI12DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.jboss.tools.smooks.model.edi12.EDI12DocumentRoot#getMixed()
	 * @see #getEDI12DocumentRoot()
	 * @generated
	 */
	EAttribute getEDI12DocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.jboss.tools.smooks.model.edi12.EDI12DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.jboss.tools.smooks.model.edi12.EDI12DocumentRoot#getXMLNSPrefixMap()
	 * @see #getEDI12DocumentRoot()
	 * @generated
	 */
	EReference getEDI12DocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.jboss.tools.smooks.model.edi12.EDI12DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.jboss.tools.smooks.model.edi12.EDI12DocumentRoot#getXSISchemaLocation()
	 * @see #getEDI12DocumentRoot()
	 * @generated
	 */
	EReference getEDI12DocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.edi12.EDI12DocumentRoot#getReader <em>Reader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reader</em>'.
	 * @see org.jboss.tools.smooks.model.edi12.EDI12DocumentRoot#getReader()
	 * @see #getEDI12DocumentRoot()
	 * @generated
	 */
	EReference getEDI12DocumentRoot_Reader();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.edi12.EDI12Reader <em>EDI12 Reader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EDI12 Reader</em>'.
	 * @see org.jboss.tools.smooks.model.edi12.EDI12Reader
	 * @generated
	 */
	EClass getEDI12Reader();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.edi12.EDI12Reader#getEncoding <em>Encoding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Encoding</em>'.
	 * @see org.jboss.tools.smooks.model.edi12.EDI12Reader#getEncoding()
	 * @see #getEDI12Reader()
	 * @generated
	 */
	EAttribute getEDI12Reader_Encoding();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.edi12.EDI12Reader#getMappingModel <em>Mapping Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mapping Model</em>'.
	 * @see org.jboss.tools.smooks.model.edi12.EDI12Reader#getMappingModel()
	 * @see #getEDI12Reader()
	 * @generated
	 */
	EAttribute getEDI12Reader_MappingModel();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.edi12.EDI12Reader#isValidate <em>Validate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Validate</em>'.
	 * @see org.jboss.tools.smooks.model.edi12.EDI12Reader#isValidate()
	 * @see #getEDI12Reader()
	 * @generated
	 */
	EAttribute getEDI12Reader_Validate();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Edi12Factory getEdi12Factory();

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
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.edi12.impl.EDI12DocumentRootImpl <em>EDI12 Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.edi12.impl.EDI12DocumentRootImpl
		 * @see org.jboss.tools.smooks.model.edi12.impl.Edi12PackageImpl#getEDI12DocumentRoot()
		 * @generated
		 */
		EClass EDI12_DOCUMENT_ROOT = eINSTANCE.getEDI12DocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDI12_DOCUMENT_ROOT__MIXED = eINSTANCE.getEDI12DocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDI12_DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getEDI12DocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDI12_DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getEDI12DocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Reader</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDI12_DOCUMENT_ROOT__READER = eINSTANCE.getEDI12DocumentRoot_Reader();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.edi12.impl.EDI12ReaderImpl <em>EDI12 Reader</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.edi12.impl.EDI12ReaderImpl
		 * @see org.jboss.tools.smooks.model.edi12.impl.Edi12PackageImpl#getEDI12Reader()
		 * @generated
		 */
		EClass EDI12_READER = eINSTANCE.getEDI12Reader();

		/**
		 * The meta object literal for the '<em><b>Encoding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDI12_READER__ENCODING = eINSTANCE.getEDI12Reader_Encoding();

		/**
		 * The meta object literal for the '<em><b>Mapping Model</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDI12_READER__MAPPING_MODEL = eINSTANCE.getEDI12Reader_MappingModel();

		/**
		 * The meta object literal for the '<em><b>Validate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDI12_READER__VALIDATE = eINSTANCE.getEDI12Reader_Validate();

	}

} //Edi12Package
