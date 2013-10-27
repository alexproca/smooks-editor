/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.csv12.impl;


import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.jboss.tools.smooks.model.csv12.Csv12Package;
import org.jboss.tools.smooks.model.csv12.MapBinding;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Map Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.csv12.impl.MapBindingImpl#getKeyField <em>Key Field</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MapBindingImpl extends BindingImpl implements MapBinding {
	/**
	 * The default value of the '{@link #getKeyField() <em>Key Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyField()
	 * @generated
	 * @ordered
	 */
	protected static final String KEY_FIELD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKeyField() <em>Key Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyField()
	 * @generated
	 * @ordered
	 */
	protected String keyField = KEY_FIELD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MapBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Csv12Package.Literals.MAP_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKeyField() {
		return keyField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeyField(String newKeyField) {
		String oldKeyField = keyField;
		keyField = newKeyField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Csv12Package.MAP_BINDING__KEY_FIELD, oldKeyField, keyField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Csv12Package.MAP_BINDING__KEY_FIELD:
				return getKeyField();
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
			case Csv12Package.MAP_BINDING__KEY_FIELD:
				setKeyField((String)newValue);
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
			case Csv12Package.MAP_BINDING__KEY_FIELD:
				setKeyField(KEY_FIELD_EDEFAULT);
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
			case Csv12Package.MAP_BINDING__KEY_FIELD:
				return KEY_FIELD_EDEFAULT == null ? keyField != null : !KEY_FIELD_EDEFAULT.equals(keyField);
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
		result.append(" (keyField: "); //$NON-NLS-1$
		result.append(keyField);
		result.append(')');
		return result.toString();
	}

} //MapBindingImpl
