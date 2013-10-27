/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.medi.impl;


import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.jboss.tools.smooks.model.medi.Component;
import org.jboss.tools.smooks.model.medi.MEdiPackage;
import org.jboss.tools.smooks.model.medi.SubComponent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.medi.impl.ComponentImpl#getSubComponent <em>Sub Component</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.medi.impl.ComponentImpl#isRequired <em>Required</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.medi.impl.ComponentImpl#isTruncatable <em>Truncatable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentImpl extends MappingNodeImpl implements Component {
	/**
	 * The cached value of the '{@link #getSubComponent() <em>Sub Component</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubComponent()
	 * @generated
	 * @ordered
	 */
	protected EList<SubComponent> subComponent;

	/**
	 * The default value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REQUIRED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected boolean required = REQUIRED_EDEFAULT;

	/**
	 * This is true if the Required attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean requiredESet;

	/**
	 * The default value of the '{@link #isTruncatable() <em>Truncatable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTruncatable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRUNCATABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTruncatable() <em>Truncatable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTruncatable()
	 * @generated
	 * @ordered
	 */
	protected boolean truncatable = TRUNCATABLE_EDEFAULT;

	/**
	 * This is true if the Truncatable attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean truncatableESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MEdiPackage.Literals.COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubComponent> getSubComponent() {
		if (subComponent == null) {
			subComponent = new EObjectContainmentEList<SubComponent>(SubComponent.class, this, MEdiPackage.COMPONENT__SUB_COMPONENT);
		}
		return subComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRequired() {
		return required;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequired(boolean newRequired) {
		boolean oldRequired = required;
		required = newRequired;
		boolean oldRequiredESet = requiredESet;
		requiredESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MEdiPackage.COMPONENT__REQUIRED, oldRequired, required, !oldRequiredESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRequired() {
		boolean oldRequired = required;
		boolean oldRequiredESet = requiredESet;
		required = REQUIRED_EDEFAULT;
		requiredESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MEdiPackage.COMPONENT__REQUIRED, oldRequired, REQUIRED_EDEFAULT, oldRequiredESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRequired() {
		return requiredESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTruncatable() {
		return truncatable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTruncatable(boolean newTruncatable) {
		boolean oldTruncatable = truncatable;
		truncatable = newTruncatable;
		boolean oldTruncatableESet = truncatableESet;
		truncatableESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MEdiPackage.COMPONENT__TRUNCATABLE, oldTruncatable, truncatable, !oldTruncatableESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTruncatable() {
		boolean oldTruncatable = truncatable;
		boolean oldTruncatableESet = truncatableESet;
		truncatable = TRUNCATABLE_EDEFAULT;
		truncatableESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MEdiPackage.COMPONENT__TRUNCATABLE, oldTruncatable, TRUNCATABLE_EDEFAULT, oldTruncatableESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTruncatable() {
		return truncatableESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MEdiPackage.COMPONENT__SUB_COMPONENT:
				return ((InternalEList<?>)getSubComponent()).basicRemove(otherEnd, msgs);
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
			case MEdiPackage.COMPONENT__SUB_COMPONENT:
				return getSubComponent();
			case MEdiPackage.COMPONENT__REQUIRED:
				return isRequired() ? Boolean.TRUE : Boolean.FALSE;
			case MEdiPackage.COMPONENT__TRUNCATABLE:
				return isTruncatable() ? Boolean.TRUE : Boolean.FALSE;
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
			case MEdiPackage.COMPONENT__SUB_COMPONENT:
				getSubComponent().clear();
				getSubComponent().addAll((Collection<? extends SubComponent>)newValue);
				return;
			case MEdiPackage.COMPONENT__REQUIRED:
				setRequired(((Boolean)newValue).booleanValue());
				return;
			case MEdiPackage.COMPONENT__TRUNCATABLE:
				setTruncatable(((Boolean)newValue).booleanValue());
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
			case MEdiPackage.COMPONENT__SUB_COMPONENT:
				getSubComponent().clear();
				return;
			case MEdiPackage.COMPONENT__REQUIRED:
				unsetRequired();
				return;
			case MEdiPackage.COMPONENT__TRUNCATABLE:
				unsetTruncatable();
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
			case MEdiPackage.COMPONENT__SUB_COMPONENT:
				return subComponent != null && !subComponent.isEmpty();
			case MEdiPackage.COMPONENT__REQUIRED:
				return isSetRequired();
			case MEdiPackage.COMPONENT__TRUNCATABLE:
				return isSetTruncatable();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (required: "); //$NON-NLS-1$
		if (requiredESet) result.append(required); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", truncatable: "); //$NON-NLS-1$
		if (truncatableESet) result.append(truncatable); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //ComponentImpl
