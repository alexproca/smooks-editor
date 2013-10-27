/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.javabean12.impl;


import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.jboss.tools.smooks.model.javabean12.Javabean12Package;
import org.jboss.tools.smooks.model.javabean12.ResultType;
import org.jboss.tools.smooks.model.smooks.impl.ElementVisitorImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.ResultTypeImpl#getRetainBeans <em>Retain Beans</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResultTypeImpl extends ElementVisitorImpl implements ResultType {
	/**
	 * The default value of the '{@link #getRetainBeans() <em>Retain Beans</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRetainBeans()
	 * @generated
	 * @ordered
	 */
	protected static final String RETAIN_BEANS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRetainBeans() <em>Retain Beans</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRetainBeans()
	 * @generated
	 * @ordered
	 */
	protected String retainBeans = RETAIN_BEANS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResultTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Javabean12Package.Literals.RESULT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRetainBeans() {
		return retainBeans;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRetainBeans(String newRetainBeans) {
		String oldRetainBeans = retainBeans;
		retainBeans = newRetainBeans;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Javabean12Package.RESULT_TYPE__RETAIN_BEANS, oldRetainBeans, retainBeans));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Javabean12Package.RESULT_TYPE__RETAIN_BEANS:
				return getRetainBeans();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Javabean12Package.RESULT_TYPE__RETAIN_BEANS:
				setRetainBeans((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case Javabean12Package.RESULT_TYPE__RETAIN_BEANS:
				setRetainBeans(RETAIN_BEANS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Javabean12Package.RESULT_TYPE__RETAIN_BEANS:
				return RETAIN_BEANS_EDEFAULT == null ? retainBeans != null : !RETAIN_BEANS_EDEFAULT.equals(retainBeans);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (retainBeans: "); //$NON-NLS-1$
		result.append(retainBeans);
		result.append(')');
		return result.toString();
	}

} //ResultTypeImpl
