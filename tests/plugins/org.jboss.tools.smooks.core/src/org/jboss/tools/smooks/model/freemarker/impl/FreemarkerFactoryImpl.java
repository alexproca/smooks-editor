/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.freemarker.impl;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.jboss.tools.smooks.model.freemarker.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FreemarkerFactoryImpl extends EFactoryImpl implements FreemarkerFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FreemarkerFactory init() {
		try {
			FreemarkerFactory theFreemarkerFactory = (FreemarkerFactory)EPackage.Registry.INSTANCE.getEFactory(Messages.FreemarkerFactoryImpl_0); 
			if (theFreemarkerFactory != null) {
				return theFreemarkerFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FreemarkerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FreemarkerFactoryImpl() {
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
			case FreemarkerPackage.BIND_TO: return createBindTo();
			case FreemarkerPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case FreemarkerPackage.FREEMARKER: return createFreemarker();
			case FreemarkerPackage.INLINE: return createInline();
			case FreemarkerPackage.OUTPUT_TO: return createOutputTo();
			case FreemarkerPackage.TEMPLATE: return createTemplate();
			case FreemarkerPackage.USE: return createUse();
			default:
				throw new IllegalArgumentException(Messages.FreemarkerFactoryImpl_Error_Class_Not_Valid + eClass.getName() + Messages.FreemarkerFactoryImpl_Error_Not_Valid_Classifier);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case FreemarkerPackage.INLINE_DIRECTIVE:
				return createInlineDirectiveFromString(eDataType, initialValue);
			case FreemarkerPackage.INLINE_DIRECTIVE_OBJECT:
				return createInlineDirectiveObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException(Messages.FreemarkerFactoryImpl_Error_Datatype_Not_Valid + eDataType.getName() + Messages.FreemarkerFactoryImpl_Error_Not_Valid_Classifier);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case FreemarkerPackage.INLINE_DIRECTIVE:
				return convertInlineDirectiveToString(eDataType, instanceValue);
			case FreemarkerPackage.INLINE_DIRECTIVE_OBJECT:
				return convertInlineDirectiveObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException(Messages.FreemarkerFactoryImpl_Error_Datatype_Not_Valid + eDataType.getName() + Messages.FreemarkerFactoryImpl_Error_Not_Valid_Classifier);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindTo createBindTo() {
		BindToImpl bindTo = new BindToImpl();
		return bindTo;
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
	public Freemarker createFreemarker() {
		FreemarkerImpl freemarker = new FreemarkerImpl();
		return freemarker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Inline createInline() {
		InlineImpl inline = new InlineImpl();
		return inline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputTo createOutputTo() {
		OutputToImpl outputTo = new OutputToImpl();
		return outputTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Template createTemplate() {
		TemplateImpl template = new TemplateImpl();
		return template;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Use createUse() {
		UseImpl use = new UseImpl();
		return use;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InlineDirective createInlineDirectiveFromString(EDataType eDataType, String initialValue) {
		InlineDirective result = InlineDirective.get(initialValue);
		if (result == null) throw new IllegalArgumentException(Messages.FreemarkerFactoryImpl_Error_Value_Not_Valid + initialValue + Messages.FreemarkerFactoryImpl_Error_Not_Valid_Enumerator + eDataType.getName() + "'"); //$NON-NLS-3$ //$NON-NLS-1$ //$NON-NLS-1$ //$NON-NLS-1$ //$NON-NLS-1$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInlineDirectiveToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InlineDirective createInlineDirectiveObjectFromString(EDataType eDataType, String initialValue) {
		return createInlineDirectiveFromString(FreemarkerPackage.Literals.INLINE_DIRECTIVE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInlineDirectiveObjectToString(EDataType eDataType, Object instanceValue) {
		return convertInlineDirectiveToString(FreemarkerPackage.Literals.INLINE_DIRECTIVE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FreemarkerPackage getFreemarkerPackage() {
		return (FreemarkerPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FreemarkerPackage getPackage() {
		return FreemarkerPackage.eINSTANCE;
	}

} //FreemarkerFactoryImpl
