/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.freemarker;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * FreeMarker Templating Configuration
 * <!-- end-model-doc -->
 * @see org.jboss.tools.smooks.model.freemarker.FreemarkerFactory
 * @model kind="package"
 * @generated
 */
public interface FreemarkerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "freemarker"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.milyn.org/xsd/smooks/freemarker-1.1.xsd"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ftl"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FreemarkerPackage eINSTANCE = org.jboss.tools.smooks.model.freemarker.impl.FreemarkerPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.freemarker.impl.BindToImpl <em>Bind To</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.freemarker.impl.BindToImpl
	 * @see org.jboss.tools.smooks.model.freemarker.impl.FreemarkerPackageImpl#getBindTo()
	 * @generated
	 */
	int BIND_TO = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_TO__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_TO__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_TO__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_TO__ID = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Bind To</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_TO_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.freemarker.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.freemarker.impl.DocumentRootImpl
	 * @see org.jboss.tools.smooks.model.freemarker.impl.FreemarkerPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 1;

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
	 * The feature id for the '<em><b>Freemarker</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__FREEMARKER = 3;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.freemarker.impl.FreemarkerImpl <em>Freemarker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.freemarker.impl.FreemarkerImpl
	 * @see org.jboss.tools.smooks.model.freemarker.impl.FreemarkerPackageImpl#getFreemarker()
	 * @generated
	 */
	int FREEMARKER = 2;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREEMARKER__MIXED = SmooksPackage.ELEMENT_VISITOR__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREEMARKER__ANY = SmooksPackage.ELEMENT_VISITOR__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREEMARKER__ANY_ATTRIBUTE = SmooksPackage.ELEMENT_VISITOR__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREEMARKER__CONDITION = SmooksPackage.ELEMENT_VISITOR__CONDITION;

	/**
	 * The feature id for the '<em><b>Target Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREEMARKER__TARGET_PROFILE = SmooksPackage.ELEMENT_VISITOR__TARGET_PROFILE;

	/**
	 * The feature id for the '<em><b>Template</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREEMARKER__TEMPLATE = SmooksPackage.ELEMENT_VISITOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Use</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREEMARKER__USE = SmooksPackage.ELEMENT_VISITOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Param</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREEMARKER__PARAM = SmooksPackage.ELEMENT_VISITOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Apply Before</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREEMARKER__APPLY_BEFORE = SmooksPackage.ELEMENT_VISITOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Apply On Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREEMARKER__APPLY_ON_ELEMENT = SmooksPackage.ELEMENT_VISITOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Apply On Element NS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREEMARKER__APPLY_ON_ELEMENT_NS = SmooksPackage.ELEMENT_VISITOR_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Freemarker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREEMARKER_FEATURE_COUNT = SmooksPackage.ELEMENT_VISITOR_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.freemarker.impl.InlineImpl <em>Inline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.freemarker.impl.InlineImpl
	 * @see org.jboss.tools.smooks.model.freemarker.impl.FreemarkerPackageImpl#getInline()
	 * @generated
	 */
	int INLINE = 3;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INLINE__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INLINE__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INLINE__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Directive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INLINE__DIRECTIVE = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Inline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INLINE_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.freemarker.impl.OutputToImpl <em>Output To</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.freemarker.impl.OutputToImpl
	 * @see org.jboss.tools.smooks.model.freemarker.impl.FreemarkerPackageImpl#getOutputTo()
	 * @generated
	 */
	int OUTPUT_TO = 4;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_TO__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_TO__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_TO__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Output Stream Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_TO__OUTPUT_STREAM_RESOURCE = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Output To</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_TO_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.freemarker.impl.TemplateImpl <em>Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.freemarker.impl.TemplateImpl
	 * @see org.jboss.tools.smooks.model.freemarker.impl.FreemarkerPackageImpl#getTemplate()
	 * @generated
	 */
	int TEMPLATE = 5;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__VALUE = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__ENCODING = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.freemarker.impl.UseImpl <em>Use</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.freemarker.impl.UseImpl
	 * @see org.jboss.tools.smooks.model.freemarker.impl.FreemarkerPackageImpl#getUse()
	 * @generated
	 */
	int USE = 6;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE__MIXED = CommonPackage.ABSTRACT_ANY_TYPE__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE__ANY = CommonPackage.ABSTRACT_ANY_TYPE__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE__ANY_ATTRIBUTE = CommonPackage.ABSTRACT_ANY_TYPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Inline</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE__INLINE = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bind To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE__BIND_TO = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Output To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE__OUTPUT_TO = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Use</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_FEATURE_COUNT = CommonPackage.ABSTRACT_ANY_TYPE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.jboss.tools.smooks.model.freemarker.InlineDirective <em>Inline Directive</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.freemarker.InlineDirective
	 * @see org.jboss.tools.smooks.model.freemarker.impl.FreemarkerPackageImpl#getInlineDirective()
	 * @generated
	 */
	int INLINE_DIRECTIVE = 7;

	/**
	 * The meta object id for the '<em>Inline Directive Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.tools.smooks.model.freemarker.InlineDirective
	 * @see org.jboss.tools.smooks.model.freemarker.impl.FreemarkerPackageImpl#getInlineDirectiveObject()
	 * @generated
	 */
	int INLINE_DIRECTIVE_OBJECT = 8;


	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.freemarker.BindTo <em>Bind To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bind To</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.BindTo
	 * @generated
	 */
	EClass getBindTo();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.freemarker.BindTo#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.BindTo#getId()
	 * @see #getBindTo()
	 * @generated
	 */
	EAttribute getBindTo_Id();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.freemarker.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.jboss.tools.smooks.model.freemarker.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.jboss.tools.smooks.model.freemarker.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.jboss.tools.smooks.model.freemarker.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.freemarker.DocumentRoot#getFreemarker <em>Freemarker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Freemarker</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.DocumentRoot#getFreemarker()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Freemarker();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.freemarker.Freemarker <em>Freemarker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Freemarker</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.Freemarker
	 * @generated
	 */
	EClass getFreemarker();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.freemarker.Freemarker#getTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Template</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.Freemarker#getTemplate()
	 * @see #getFreemarker()
	 * @generated
	 */
	EReference getFreemarker_Template();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.freemarker.Freemarker#getUse <em>Use</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Use</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.Freemarker#getUse()
	 * @see #getFreemarker()
	 * @generated
	 */
	EReference getFreemarker_Use();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.tools.smooks.model.freemarker.Freemarker#getParam <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Param</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.Freemarker#getParam()
	 * @see #getFreemarker()
	 * @generated
	 */
	EReference getFreemarker_Param();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.freemarker.Freemarker#isApplyBefore <em>Apply Before</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Apply Before</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.Freemarker#isApplyBefore()
	 * @see #getFreemarker()
	 * @generated
	 */
	EAttribute getFreemarker_ApplyBefore();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.freemarker.Freemarker#getApplyOnElement <em>Apply On Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Apply On Element</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.Freemarker#getApplyOnElement()
	 * @see #getFreemarker()
	 * @generated
	 */
	EAttribute getFreemarker_ApplyOnElement();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.freemarker.Freemarker#getApplyOnElementNS <em>Apply On Element NS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Apply On Element NS</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.Freemarker#getApplyOnElementNS()
	 * @see #getFreemarker()
	 * @generated
	 */
	EAttribute getFreemarker_ApplyOnElementNS();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.freemarker.Inline <em>Inline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inline</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.Inline
	 * @generated
	 */
	EClass getInline();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.freemarker.Inline#getDirective <em>Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Directive</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.Inline#getDirective()
	 * @see #getInline()
	 * @generated
	 */
	EAttribute getInline_Directive();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.freemarker.OutputTo <em>Output To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output To</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.OutputTo
	 * @generated
	 */
	EClass getOutputTo();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.freemarker.OutputTo#getOutputStreamResource <em>Output Stream Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output Stream Resource</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.OutputTo#getOutputStreamResource()
	 * @see #getOutputTo()
	 * @generated
	 */
	EAttribute getOutputTo_OutputStreamResource();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.freemarker.Template <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.Template
	 * @generated
	 */
	EClass getTemplate();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.freemarker.Template#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.Template#getValue()
	 * @see #getTemplate()
	 * @generated
	 */
	EAttribute getTemplate_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.tools.smooks.model.freemarker.Template#getEncoding <em>Encoding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Encoding</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.Template#getEncoding()
	 * @see #getTemplate()
	 * @generated
	 */
	EAttribute getTemplate_Encoding();

	/**
	 * Returns the meta object for class '{@link org.jboss.tools.smooks.model.freemarker.Use <em>Use</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.Use
	 * @generated
	 */
	EClass getUse();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.freemarker.Use#getInline <em>Inline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Inline</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.Use#getInline()
	 * @see #getUse()
	 * @generated
	 */
	EReference getUse_Inline();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.freemarker.Use#getBindTo <em>Bind To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bind To</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.Use#getBindTo()
	 * @see #getUse()
	 * @generated
	 */
	EReference getUse_BindTo();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.tools.smooks.model.freemarker.Use#getOutputTo <em>Output To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Output To</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.Use#getOutputTo()
	 * @see #getUse()
	 * @generated
	 */
	EReference getUse_OutputTo();

	/**
	 * Returns the meta object for enum '{@link org.jboss.tools.smooks.model.freemarker.InlineDirective <em>Inline Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Inline Directive</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.InlineDirective
	 * @generated
	 */
	EEnum getInlineDirective();

	/**
	 * Returns the meta object for data type '{@link org.jboss.tools.smooks.model.freemarker.InlineDirective <em>Inline Directive Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Inline Directive Object</em>'.
	 * @see org.jboss.tools.smooks.model.freemarker.InlineDirective
	 * @model instanceClass="freemarker.InlineDirective"
	 *        extendedMetaData="name='inlineDirective:Object' baseType='inlineDirective'"
	 * @generated
	 */
	EDataType getInlineDirectiveObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FreemarkerFactory getFreemarkerFactory();

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
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.freemarker.impl.BindToImpl <em>Bind To</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.freemarker.impl.BindToImpl
		 * @see org.jboss.tools.smooks.model.freemarker.impl.FreemarkerPackageImpl#getBindTo()
		 * @generated
		 */
		EClass BIND_TO = eINSTANCE.getBindTo();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIND_TO__ID = eINSTANCE.getBindTo_Id();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.freemarker.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.freemarker.impl.DocumentRootImpl
		 * @see org.jboss.tools.smooks.model.freemarker.impl.FreemarkerPackageImpl#getDocumentRoot()
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
		 * The meta object literal for the '<em><b>Freemarker</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__FREEMARKER = eINSTANCE.getDocumentRoot_Freemarker();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.freemarker.impl.FreemarkerImpl <em>Freemarker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.freemarker.impl.FreemarkerImpl
		 * @see org.jboss.tools.smooks.model.freemarker.impl.FreemarkerPackageImpl#getFreemarker()
		 * @generated
		 */
		EClass FREEMARKER = eINSTANCE.getFreemarker();

		/**
		 * The meta object literal for the '<em><b>Template</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FREEMARKER__TEMPLATE = eINSTANCE.getFreemarker_Template();

		/**
		 * The meta object literal for the '<em><b>Use</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FREEMARKER__USE = eINSTANCE.getFreemarker_Use();

		/**
		 * The meta object literal for the '<em><b>Param</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FREEMARKER__PARAM = eINSTANCE.getFreemarker_Param();

		/**
		 * The meta object literal for the '<em><b>Apply Before</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FREEMARKER__APPLY_BEFORE = eINSTANCE.getFreemarker_ApplyBefore();

		/**
		 * The meta object literal for the '<em><b>Apply On Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FREEMARKER__APPLY_ON_ELEMENT = eINSTANCE.getFreemarker_ApplyOnElement();

		/**
		 * The meta object literal for the '<em><b>Apply On Element NS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FREEMARKER__APPLY_ON_ELEMENT_NS = eINSTANCE.getFreemarker_ApplyOnElementNS();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.freemarker.impl.InlineImpl <em>Inline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.freemarker.impl.InlineImpl
		 * @see org.jboss.tools.smooks.model.freemarker.impl.FreemarkerPackageImpl#getInline()
		 * @generated
		 */
		EClass INLINE = eINSTANCE.getInline();

		/**
		 * The meta object literal for the '<em><b>Directive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INLINE__DIRECTIVE = eINSTANCE.getInline_Directive();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.freemarker.impl.OutputToImpl <em>Output To</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.freemarker.impl.OutputToImpl
		 * @see org.jboss.tools.smooks.model.freemarker.impl.FreemarkerPackageImpl#getOutputTo()
		 * @generated
		 */
		EClass OUTPUT_TO = eINSTANCE.getOutputTo();

		/**
		 * The meta object literal for the '<em><b>Output Stream Resource</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUTPUT_TO__OUTPUT_STREAM_RESOURCE = eINSTANCE.getOutputTo_OutputStreamResource();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.freemarker.impl.TemplateImpl <em>Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.freemarker.impl.TemplateImpl
		 * @see org.jboss.tools.smooks.model.freemarker.impl.FreemarkerPackageImpl#getTemplate()
		 * @generated
		 */
		EClass TEMPLATE = eINSTANCE.getTemplate();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE__VALUE = eINSTANCE.getTemplate_Value();

		/**
		 * The meta object literal for the '<em><b>Encoding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE__ENCODING = eINSTANCE.getTemplate_Encoding();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.freemarker.impl.UseImpl <em>Use</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.freemarker.impl.UseImpl
		 * @see org.jboss.tools.smooks.model.freemarker.impl.FreemarkerPackageImpl#getUse()
		 * @generated
		 */
		EClass USE = eINSTANCE.getUse();

		/**
		 * The meta object literal for the '<em><b>Inline</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE__INLINE = eINSTANCE.getUse_Inline();

		/**
		 * The meta object literal for the '<em><b>Bind To</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE__BIND_TO = eINSTANCE.getUse_BindTo();

		/**
		 * The meta object literal for the '<em><b>Output To</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE__OUTPUT_TO = eINSTANCE.getUse_OutputTo();

		/**
		 * The meta object literal for the '{@link org.jboss.tools.smooks.model.freemarker.InlineDirective <em>Inline Directive</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.freemarker.InlineDirective
		 * @see org.jboss.tools.smooks.model.freemarker.impl.FreemarkerPackageImpl#getInlineDirective()
		 * @generated
		 */
		EEnum INLINE_DIRECTIVE = eINSTANCE.getInlineDirective();

		/**
		 * The meta object literal for the '<em>Inline Directive Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.tools.smooks.model.freemarker.InlineDirective
		 * @see org.jboss.tools.smooks.model.freemarker.impl.FreemarkerPackageImpl#getInlineDirectiveObject()
		 * @generated
		 */
		EDataType INLINE_DIRECTIVE_OBJECT = eINSTANCE.getInlineDirectiveObject();

	}

} //FreemarkerPackage
