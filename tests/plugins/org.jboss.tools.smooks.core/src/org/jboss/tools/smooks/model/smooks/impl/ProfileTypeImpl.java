/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.smooks.impl;


import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.jboss.tools.smooks.model.common.impl.AbstractAnyTypeImpl;
import org.jboss.tools.smooks.model.smooks.ProfileType;
import org.jboss.tools.smooks.model.smooks.SmooksPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Profile Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.ProfileTypeImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.ProfileTypeImpl#getBaseProfile <em>Base Profile</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.ProfileTypeImpl#getSubProfiles <em>Sub Profiles</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProfileTypeImpl extends AbstractAnyTypeImpl implements ProfileType {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBaseProfile() <em>Base Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseProfile()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_PROFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBaseProfile() <em>Base Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseProfile()
	 * @generated
	 * @ordered
	 */
	protected String baseProfile = BASE_PROFILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSubProfiles() <em>Sub Profiles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubProfiles()
	 * @generated
	 * @ordered
	 */
	protected static final String SUB_PROFILES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubProfiles() <em>Sub Profiles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubProfiles()
	 * @generated
	 * @ordered
	 */
	protected String subProfiles = SUB_PROFILES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProfileTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmooksPackage.Literals.PROFILE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmooksPackage.PROFILE_TYPE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBaseProfile() {
		return baseProfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseProfile(String newBaseProfile) {
		String oldBaseProfile = baseProfile;
		baseProfile = newBaseProfile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmooksPackage.PROFILE_TYPE__BASE_PROFILE, oldBaseProfile, baseProfile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubProfiles() {
		return subProfiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubProfiles(String newSubProfiles) {
		String oldSubProfiles = subProfiles;
		subProfiles = newSubProfiles;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmooksPackage.PROFILE_TYPE__SUB_PROFILES, oldSubProfiles, subProfiles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SmooksPackage.PROFILE_TYPE__VALUE:
				return getValue();
			case SmooksPackage.PROFILE_TYPE__BASE_PROFILE:
				return getBaseProfile();
			case SmooksPackage.PROFILE_TYPE__SUB_PROFILES:
				return getSubProfiles();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SmooksPackage.PROFILE_TYPE__VALUE:
				setValue((String)newValue);
				return;
			case SmooksPackage.PROFILE_TYPE__BASE_PROFILE:
				setBaseProfile((String)newValue);
				return;
			case SmooksPackage.PROFILE_TYPE__SUB_PROFILES:
				setSubProfiles((String)newValue);
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
			case SmooksPackage.PROFILE_TYPE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case SmooksPackage.PROFILE_TYPE__BASE_PROFILE:
				setBaseProfile(BASE_PROFILE_EDEFAULT);
				return;
			case SmooksPackage.PROFILE_TYPE__SUB_PROFILES:
				setSubProfiles(SUB_PROFILES_EDEFAULT);
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
			case SmooksPackage.PROFILE_TYPE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case SmooksPackage.PROFILE_TYPE__BASE_PROFILE:
				return BASE_PROFILE_EDEFAULT == null ? baseProfile != null : !BASE_PROFILE_EDEFAULT.equals(baseProfile);
			case SmooksPackage.PROFILE_TYPE__SUB_PROFILES:
				return SUB_PROFILES_EDEFAULT == null ? subProfiles != null : !SUB_PROFILES_EDEFAULT.equals(subProfiles);
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
		result.append(" (value: "); //$NON-NLS-1$
		result.append(value);
		result.append(", baseProfile: "); //$NON-NLS-1$
		result.append(baseProfile);
		result.append(", subProfiles: "); //$NON-NLS-1$
		result.append(subProfiles);
		result.append(')');
		return result.toString();
	}

} //ProfileTypeImpl
