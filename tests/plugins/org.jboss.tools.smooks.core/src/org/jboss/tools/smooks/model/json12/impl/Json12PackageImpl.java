/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.json12.impl;




import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.jboss.tools.smooks.model.common.CommonPackage;
import org.jboss.tools.smooks.model.common.impl.CommonPackageImpl;
import org.jboss.tools.smooks.model.json12.Json12DocumentRoot;
import org.jboss.tools.smooks.model.json12.Json12Factory;
import org.jboss.tools.smooks.model.json12.Json12Package;
import org.jboss.tools.smooks.model.json12.Json12Reader;
import org.jboss.tools.smooks.model.json12.Key;
import org.jboss.tools.smooks.model.json12.KeyMap;
import org.jboss.tools.smooks.model.smooks.SmooksPackage;
import org.jboss.tools.smooks.model.smooks.impl.SmooksPackageImpl;



/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Json12PackageImpl extends EPackageImpl implements Json12Package {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass json12DocumentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass keyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass keyMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass json12ReaderEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.jboss.tools.smooks.model.json12.Json12Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Json12PackageImpl() {
		super(eNS_URI, Json12Factory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link Json12Package#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Json12Package init() {
		if (isInited) return (Json12Package)EPackage.Registry.INSTANCE.getEPackage(Json12Package.eNS_URI);

		// Obtain or create and register package
		Json12PackageImpl theJson12Package = (Json12PackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Json12PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Json12PackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CommonPackageImpl theCommonPackage = (CommonPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) instanceof CommonPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) : CommonPackage.eINSTANCE);
		SmooksPackageImpl theSmooksPackage = (SmooksPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SmooksPackage.eNS_URI) instanceof SmooksPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SmooksPackage.eNS_URI) : SmooksPackage.eINSTANCE);

		// Create package meta-data objects
		theJson12Package.createPackageContents();
		theCommonPackage.createPackageContents();
		theSmooksPackage.createPackageContents();

		// Initialize created meta-data
		theJson12Package.initializePackageContents();
		theCommonPackage.initializePackageContents();
		theSmooksPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theJson12Package.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Json12Package.eNS_URI, theJson12Package);
		return theJson12Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJson12DocumentRoot() {
		return json12DocumentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJson12DocumentRoot_Mixed() {
		return (EAttribute)json12DocumentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJson12DocumentRoot_XMLNSPrefixMap() {
		return (EReference)json12DocumentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJson12DocumentRoot_XSISchemaLocation() {
		return (EReference)json12DocumentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJson12DocumentRoot_Reader() {
		return (EReference)json12DocumentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKey() {
		return keyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKey_Value() {
		return (EAttribute)keyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKey_From() {
		return (EAttribute)keyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKey_To() {
		return (EAttribute)keyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKeyMap() {
		return keyMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKeyMap_Key() {
		return (EReference)keyMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJson12Reader() {
		return json12ReaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJson12Reader_KeyMap() {
		return (EReference)json12ReaderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJson12Reader_ArrayElementName() {
		return (EAttribute)json12ReaderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJson12Reader_Encoding() {
		return (EAttribute)json12ReaderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJson12Reader_IllegalElementNameCharReplacement() {
		return (EAttribute)json12ReaderEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJson12Reader_Indent() {
		return (EAttribute)json12ReaderEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJson12Reader_KeyPrefixOnNumeric() {
		return (EAttribute)json12ReaderEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJson12Reader_KeyWhitspaceReplacement() {
		return (EAttribute)json12ReaderEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJson12Reader_NullValueReplacement() {
		return (EAttribute)json12ReaderEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJson12Reader_RootName() {
		return (EAttribute)json12ReaderEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Json12Factory getJson12Factory() {
		return (Json12Factory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		json12DocumentRootEClass = createEClass(JSON12_DOCUMENT_ROOT);
		createEAttribute(json12DocumentRootEClass, JSON12_DOCUMENT_ROOT__MIXED);
		createEReference(json12DocumentRootEClass, JSON12_DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(json12DocumentRootEClass, JSON12_DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(json12DocumentRootEClass, JSON12_DOCUMENT_ROOT__READER);

		keyEClass = createEClass(KEY);
		createEAttribute(keyEClass, KEY__VALUE);
		createEAttribute(keyEClass, KEY__FROM);
		createEAttribute(keyEClass, KEY__TO);

		keyMapEClass = createEClass(KEY_MAP);
		createEReference(keyMapEClass, KEY_MAP__KEY);

		json12ReaderEClass = createEClass(JSON12_READER);
		createEReference(json12ReaderEClass, JSON12_READER__KEY_MAP);
		createEAttribute(json12ReaderEClass, JSON12_READER__ARRAY_ELEMENT_NAME);
		createEAttribute(json12ReaderEClass, JSON12_READER__ENCODING);
		createEAttribute(json12ReaderEClass, JSON12_READER__ILLEGAL_ELEMENT_NAME_CHAR_REPLACEMENT);
		createEAttribute(json12ReaderEClass, JSON12_READER__INDENT);
		createEAttribute(json12ReaderEClass, JSON12_READER__KEY_PREFIX_ON_NUMERIC);
		createEAttribute(json12ReaderEClass, JSON12_READER__KEY_WHITSPACE_REPLACEMENT);
		createEAttribute(json12ReaderEClass, JSON12_READER__NULL_VALUE_REPLACEMENT);
		createEAttribute(json12ReaderEClass, JSON12_READER__ROOT_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CommonPackage theCommonPackage = (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
		SmooksPackage theSmooksPackage = (SmooksPackage)EPackage.Registry.INSTANCE.getEPackage(SmooksPackage.eNS_URI);

		// Add supertypes to classes
		keyEClass.getESuperTypes().add(theCommonPackage.getAbstractAnyType());
		keyMapEClass.getESuperTypes().add(theCommonPackage.getAbstractAnyType());
		json12ReaderEClass.getESuperTypes().add(theSmooksPackage.getAbstractReader());

		// Initialize classes and features; add operations and parameters
		initEClass(json12DocumentRootEClass, Json12DocumentRoot.class, "Json12DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getJson12DocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJson12DocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJson12DocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJson12DocumentRoot_Reader(), this.getJson12Reader(), null, "reader", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(keyEClass, Key.class, "Key", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getKey_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, Key.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getKey_From(), theXMLTypePackage.getString(), "from", null, 1, 1, Key.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getKey_To(), theXMLTypePackage.getString(), "to", null, 0, 1, Key.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(keyMapEClass, KeyMap.class, "KeyMap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getKeyMap_Key(), this.getKey(), null, "key", null, 1, -1, KeyMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(json12ReaderEClass, Json12Reader.class, "Json12Reader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getJson12Reader_KeyMap(), this.getKeyMap(), null, "keyMap", null, 0, 1, Json12Reader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJson12Reader_ArrayElementName(), theXMLTypePackage.getString(), "arrayElementName", "element", 0, 1, Json12Reader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getJson12Reader_Encoding(), theXMLTypePackage.getString(), "encoding", "UTF-8", 0, 1, Json12Reader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getJson12Reader_IllegalElementNameCharReplacement(), theXMLTypePackage.getString(), "illegalElementNameCharReplacement", null, 0, 1, Json12Reader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJson12Reader_Indent(), theXMLTypePackage.getBoolean(), "indent", "false", 0, 1, Json12Reader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getJson12Reader_KeyPrefixOnNumeric(), theXMLTypePackage.getString(), "keyPrefixOnNumeric", null, 0, 1, Json12Reader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJson12Reader_KeyWhitspaceReplacement(), theXMLTypePackage.getString(), "keyWhitspaceReplacement", null, 0, 1, Json12Reader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJson12Reader_NullValueReplacement(), theXMLTypePackage.getString(), "nullValueReplacement", null, 0, 1, Json12Reader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJson12Reader_RootName(), theXMLTypePackage.getString(), "rootName", "json", 0, 1, Json12Reader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";			 //$NON-NLS-1$
		addAnnotation
		  (json12DocumentRootEClass, 
		   source, 
		   new String[] {
			 "name", "", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJson12DocumentRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJson12DocumentRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJson12DocumentRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getJson12DocumentRoot_Reader(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "reader", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.milyn.org/xsd/smooks-1.1.xsd#abstract-reader" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (keyEClass, 
		   source, 
		   new String[] {
			 "name", "key", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "simple" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getKey_Value(), 
		   source, 
		   new String[] {
			 "name", ":0", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "simple" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getKey_From(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "from" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getKey_To(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "to" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (keyMapEClass, 
		   source, 
		   new String[] {
			 "name", "keyMap", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getKeyMap_Key(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "key", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (json12ReaderEClass, 
		   source, 
		   new String[] {
			 "name", "reader", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getJson12Reader_KeyMap(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "keyMap", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getJson12Reader_ArrayElementName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "arrayElementName" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getJson12Reader_Encoding(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "encoding" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getJson12Reader_IllegalElementNameCharReplacement(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "illegalElementNameCharReplacement" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getJson12Reader_Indent(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "indent" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getJson12Reader_KeyPrefixOnNumeric(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "keyPrefixOnNumeric" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getJson12Reader_KeyWhitspaceReplacement(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "keyWhitspaceReplacement" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getJson12Reader_NullValueReplacement(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "nullValueReplacement" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getJson12Reader_RootName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "rootName" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //Json12PackageImpl
