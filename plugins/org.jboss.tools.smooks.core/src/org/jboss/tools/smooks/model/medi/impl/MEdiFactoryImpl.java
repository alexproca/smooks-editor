/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.medi.impl;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.jboss.tools.smooks.model.medi.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MEdiFactoryImpl extends EFactoryImpl implements MEdiFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MEdiFactory init() {
		try {
			MEdiFactory theEdiFactory = (MEdiFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.milyn.org/schema/edi-message-mapping-1.0.xsd");  //$NON-NLS-1$
			if (theEdiFactory != null) {
				return theEdiFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MEdiFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MEdiFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MEdiPackage.COMPONENT: return createComponent();
			case MEdiPackage.DELIMITERS: return createDelimiters();
			case MEdiPackage.DESCRIPTION: return createDescription();
			case MEdiPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case MEdiPackage.EDI_MAP: return createEdiMap();
			case MEdiPackage.FIELD: return createField();
			case MEdiPackage.MAPPING_NODE: return createMappingNode();
			case MEdiPackage.SEGMENT: return createSegment();
			case MEdiPackage.SEGMENTS: return createSegments();
			case MEdiPackage.SUB_COMPONENT: return createSubComponent();
			default:
				throw new IllegalArgumentException(Messages.MEdiFactoryImpl_Error_Class_Not_Valid + eClass.getName() + Messages.MEdiFactoryImpl_Error_Not_Valid_Classifier);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component createComponent() {
		ComponentImpl component = new ComponentImpl();
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Delimiters createDelimiters() {
		DelimitersImpl delimiters = new DelimitersImpl();
		return delimiters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Description createDescription() {
		DescriptionImpl description = new DescriptionImpl();
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdiMap createEdiMap() {
		EdiMapImpl ediMap = new EdiMapImpl();
		return ediMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Field createField() {
		FieldImpl field = new FieldImpl();
		return field;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingNode createMappingNode() {
		MappingNodeImpl mappingNode = new MappingNodeImpl();
		return mappingNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Segment createSegment() {
		SegmentImpl segment = new SegmentImpl();
		return segment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Segments createSegments() {
		SegmentsImpl segments = new SegmentsImpl();
		return segments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubComponent createSubComponent() {
		SubComponentImpl subComponent = new SubComponentImpl();
		return subComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MEdiPackage getEdiPackage() {
		return (MEdiPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MEdiPackage getPackage() {
		return MEdiPackage.eINSTANCE;
	}

} //EdiFactoryImpl
