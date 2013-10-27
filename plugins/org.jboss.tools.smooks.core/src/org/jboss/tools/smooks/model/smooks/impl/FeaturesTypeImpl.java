/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.smooks.impl;


import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.jboss.tools.smooks.model.common.impl.AbstractAnyTypeImpl;
import org.jboss.tools.smooks.model.smooks.FeaturesType;
import org.jboss.tools.smooks.model.smooks.SetOffType;
import org.jboss.tools.smooks.model.smooks.SetOnType;
import org.jboss.tools.smooks.model.smooks.SmooksPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Features Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.FeaturesTypeImpl#getSetOn <em>Set On</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.FeaturesTypeImpl#getSetOff <em>Set Off</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeaturesTypeImpl extends AbstractAnyTypeImpl implements FeaturesType {
	/**
	 * The cached value of the '{@link #getSetOn() <em>Set On</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetOn()
	 * @generated
	 * @ordered
	 */
	protected EList<SetOnType> setOn;

	/**
	 * The cached value of the '{@link #getSetOff() <em>Set Off</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetOff()
	 * @generated
	 * @ordered
	 */
	protected EList<SetOffType> setOff;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeaturesTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmooksPackage.Literals.FEATURES_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SetOnType> getSetOn() {
		if (setOn == null) {
			setOn = new EObjectContainmentEList<SetOnType>(SetOnType.class, this, SmooksPackage.FEATURES_TYPE__SET_ON);
		}
		return setOn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SetOffType> getSetOff() {
		if (setOff == null) {
			setOff = new EObjectContainmentEList<SetOffType>(SetOffType.class, this, SmooksPackage.FEATURES_TYPE__SET_OFF);
		}
		return setOff;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SmooksPackage.FEATURES_TYPE__SET_ON:
				return ((InternalEList<?>)getSetOn()).basicRemove(otherEnd, msgs);
			case SmooksPackage.FEATURES_TYPE__SET_OFF:
				return ((InternalEList<?>)getSetOff()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SmooksPackage.FEATURES_TYPE__SET_ON:
				return getSetOn();
			case SmooksPackage.FEATURES_TYPE__SET_OFF:
				return getSetOff();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SmooksPackage.FEATURES_TYPE__SET_ON:
				getSetOn().clear();
				getSetOn().addAll((Collection<? extends SetOnType>)newValue);
				return;
			case SmooksPackage.FEATURES_TYPE__SET_OFF:
				getSetOff().clear();
				getSetOff().addAll((Collection<? extends SetOffType>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SmooksPackage.FEATURES_TYPE__SET_ON:
				getSetOn().clear();
				return;
			case SmooksPackage.FEATURES_TYPE__SET_OFF:
				getSetOff().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SmooksPackage.FEATURES_TYPE__SET_ON:
				return setOn != null && !setOn.isEmpty();
			case SmooksPackage.FEATURES_TYPE__SET_OFF:
				return setOff != null && !setOff.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FeaturesTypeImpl
