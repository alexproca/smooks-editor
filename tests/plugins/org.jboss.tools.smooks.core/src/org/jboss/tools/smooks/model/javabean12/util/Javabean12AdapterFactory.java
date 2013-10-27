/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.javabean12.util;



import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.xml.type.AnyType;
import org.jboss.tools.smooks.model.common.AbstractAnyType;
import org.jboss.tools.smooks.model.javabean12.*;
import org.jboss.tools.smooks.model.smooks.AbstractResourceConfig;
import org.jboss.tools.smooks.model.smooks.ElementVisitor;


/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.jboss.tools.smooks.model.javabean12.Javabean12Package
 * @generated
 */
public class Javabean12AdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Javabean12Package modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Javabean12AdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Javabean12Package.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Javabean12Switch modelSwitch =
		new Javabean12Switch() {
			public Object caseBeanType(BeanType object) {
				return createBeanTypeAdapter();
			}
			public Object caseDecodeParamType(DecodeParamType object) {
				return createDecodeParamTypeAdapter();
			}
			public Object caseJavabean12DocumentRoot(Javabean12DocumentRoot object) {
				return createJavabean12DocumentRootAdapter();
			}
			public Object caseExpressionType(ExpressionType object) {
				return createExpressionTypeAdapter();
			}
			public Object caseResultType(ResultType object) {
				return createResultTypeAdapter();
			}
			public Object caseValueType(ValueType object) {
				return createValueTypeAdapter();
			}
			public Object caseWiringType(WiringType object) {
				return createWiringTypeAdapter();
			}
			public Object caseAnyType(AnyType object) {
				return createAnyTypeAdapter();
			}
			public Object caseAbstractAnyType(AbstractAnyType object) {
				return createAbstractAnyTypeAdapter();
			}
			public Object caseAbstractResourceConfig(AbstractResourceConfig object) {
				return createAbstractResourceConfigAdapter();
			}
			public Object caseElementVisitor(ElementVisitor object) {
				return createElementVisitorAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.tools.smooks.model.javabean12.BeanType <em>Bean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.tools.smooks.model.javabean12.BeanType
	 * @generated
	 */
	public Adapter createBeanTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.tools.smooks.model.javabean12.DecodeParamType <em>Decode Param Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.tools.smooks.model.javabean12.DecodeParamType
	 * @generated
	 */
	public Adapter createDecodeParamTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot
	 * @generated
	 */
	public Adapter createJavabean12DocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.tools.smooks.model.javabean12.ExpressionType <em>Expression Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.tools.smooks.model.javabean12.ExpressionType
	 * @generated
	 */
	public Adapter createExpressionTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.tools.smooks.model.javabean12.ResultType <em>Result Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.tools.smooks.model.javabean12.ResultType
	 * @generated
	 */
	public Adapter createResultTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.tools.smooks.model.javabean12.ValueType <em>Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.tools.smooks.model.javabean12.ValueType
	 * @generated
	 */
	public Adapter createValueTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.tools.smooks.model.javabean12.WiringType <em>Wiring Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.tools.smooks.model.javabean12.WiringType
	 * @generated
	 */
	public Adapter createWiringTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.xml.type.AnyType <em>Any Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecore.xml.type.AnyType
	 * @generated
	 */
	public Adapter createAnyTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.tools.smooks.model.common.AbstractAnyType <em>Abstract Any Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.tools.smooks.model.common.AbstractAnyType
	 * @generated
	 */
	public Adapter createAbstractAnyTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.tools.smooks.model.smooks.AbstractResourceConfig <em>Abstract Resource Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.tools.smooks.model.smooks.AbstractResourceConfig
	 * @generated
	 */
	public Adapter createAbstractResourceConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.tools.smooks.model.smooks.ElementVisitor <em>Element Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.tools.smooks.model.smooks.ElementVisitor
	 * @generated
	 */
	public Adapter createElementVisitorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //Javabean12AdapterFactory
