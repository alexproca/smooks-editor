/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.smooks.impl;


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.jboss.tools.smooks.model.common.impl.AbstractAnyTypeImpl;
import org.jboss.tools.smooks.model.smooks.AbstractReader;
import org.jboss.tools.smooks.model.smooks.AbstractResourceConfig;
import org.jboss.tools.smooks.model.smooks.ConditionsType;
import org.jboss.tools.smooks.model.smooks.ParamsType;
import org.jboss.tools.smooks.model.smooks.ProfilesType;
import org.jboss.tools.smooks.model.smooks.SmooksPackage;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource List Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.SmooksResourceListTypeImpl#getParams <em>Params</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.SmooksResourceListTypeImpl#getConditions <em>Conditions</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.SmooksResourceListTypeImpl#getProfiles <em>Profiles</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.SmooksResourceListTypeImpl#getAbstractReaderGroup <em>Abstract Reader Group</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.SmooksResourceListTypeImpl#getAbstractReader <em>Abstract Reader</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.SmooksResourceListTypeImpl#getAbstractResourceConfigGroup <em>Abstract Resource Config Group</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.SmooksResourceListTypeImpl#getAbstractResourceConfig <em>Abstract Resource Config</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.SmooksResourceListTypeImpl#getDefaultConditionRef <em>Default Condition Ref</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.SmooksResourceListTypeImpl#getDefaultSelector <em>Default Selector</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.SmooksResourceListTypeImpl#getDefaultSelectorNamespace <em>Default Selector Namespace</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.SmooksResourceListTypeImpl#getDefaultTargetProfile <em>Default Target Profile</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SmooksResourceListTypeImpl extends AbstractAnyTypeImpl implements SmooksResourceListType {
	/**
	 * The cached value of the '{@link #getParams() <em>Params</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParams()
	 * @generated
	 * @ordered
	 */
	protected ParamsType params;

	/**
	 * The cached value of the '{@link #getConditions() <em>Conditions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditions()
	 * @generated
	 * @ordered
	 */
	protected ConditionsType conditions;

	/**
	 * The cached value of the '{@link #getProfiles() <em>Profiles</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfiles()
	 * @generated
	 * @ordered
	 */
	protected ProfilesType profiles;

	/**
	 * The cached value of the '{@link #getAbstractReaderGroup() <em>Abstract Reader Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstractReaderGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap abstractReaderGroup;

	/**
	 * The cached value of the '{@link #getAbstractResourceConfigGroup() <em>Abstract Resource Config Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstractResourceConfigGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap abstractResourceConfigGroup;

	/**
	 * The default value of the '{@link #getDefaultConditionRef() <em>Default Condition Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultConditionRef()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_CONDITION_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultConditionRef() <em>Default Condition Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultConditionRef()
	 * @generated
	 * @ordered
	 */
	protected String defaultConditionRef = DEFAULT_CONDITION_REF_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultSelector() <em>Default Selector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultSelector()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_SELECTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultSelector() <em>Default Selector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultSelector()
	 * @generated
	 * @ordered
	 */
	protected String defaultSelector = DEFAULT_SELECTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultSelectorNamespace() <em>Default Selector Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultSelectorNamespace()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_SELECTOR_NAMESPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultSelectorNamespace() <em>Default Selector Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultSelectorNamespace()
	 * @generated
	 * @ordered
	 */
	protected String defaultSelectorNamespace = DEFAULT_SELECTOR_NAMESPACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultTargetProfile() <em>Default Target Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultTargetProfile()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_TARGET_PROFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultTargetProfile() <em>Default Target Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultTargetProfile()
	 * @generated
	 * @ordered
	 */
	protected String defaultTargetProfile = DEFAULT_TARGET_PROFILE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SmooksResourceListTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmooksPackage.Literals.SMOOKS_RESOURCE_LIST_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParamsType getParams() {
		return params;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParams(ParamsType newParams, NotificationChain msgs) {
		ParamsType oldParams = params;
		params = newParams;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__PARAMS, oldParams, newParams);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParams(ParamsType newParams) {
		if (newParams != params) {
			NotificationChain msgs = null;
			if (params != null)
				msgs = ((InternalEObject)params).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__PARAMS, null, msgs);
			if (newParams != null)
				msgs = ((InternalEObject)newParams).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__PARAMS, null, msgs);
			msgs = basicSetParams(newParams, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__PARAMS, newParams, newParams));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionsType getConditions() {
		return conditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConditions(ConditionsType newConditions, NotificationChain msgs) {
		ConditionsType oldConditions = conditions;
		conditions = newConditions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__CONDITIONS, oldConditions, newConditions);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditions(ConditionsType newConditions) {
		if (newConditions != conditions) {
			NotificationChain msgs = null;
			if (conditions != null)
				msgs = ((InternalEObject)conditions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__CONDITIONS, null, msgs);
			if (newConditions != null)
				msgs = ((InternalEObject)newConditions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__CONDITIONS, null, msgs);
			msgs = basicSetConditions(newConditions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__CONDITIONS, newConditions, newConditions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfilesType getProfiles() {
		return profiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProfiles(ProfilesType newProfiles, NotificationChain msgs) {
		ProfilesType oldProfiles = profiles;
		profiles = newProfiles;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__PROFILES, oldProfiles, newProfiles);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfiles(ProfilesType newProfiles) {
		if (newProfiles != profiles) {
			NotificationChain msgs = null;
			if (profiles != null)
				msgs = ((InternalEObject)profiles).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__PROFILES, null, msgs);
			if (newProfiles != null)
				msgs = ((InternalEObject)newProfiles).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__PROFILES, null, msgs);
			msgs = basicSetProfiles(newProfiles, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__PROFILES, newProfiles, newProfiles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAbstractReaderGroup() {
		if (abstractReaderGroup == null) {
			abstractReaderGroup = new BasicFeatureMap(this, SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_READER_GROUP);
		}
		return abstractReaderGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractReader> getAbstractReader() {
		return getAbstractReaderGroup().list(SmooksPackage.Literals.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_READER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAbstractResourceConfigGroup() {
		if (abstractResourceConfigGroup == null) {
			abstractResourceConfigGroup = new BasicFeatureMap(this, SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_RESOURCE_CONFIG_GROUP);
		}
		return abstractResourceConfigGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractResourceConfig> getAbstractResourceConfig() {
		return getAbstractResourceConfigGroup().list(SmooksPackage.Literals.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_RESOURCE_CONFIG);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultConditionRef() {
		return defaultConditionRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultConditionRef(String newDefaultConditionRef) {
		String oldDefaultConditionRef = defaultConditionRef;
		defaultConditionRef = newDefaultConditionRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_CONDITION_REF, oldDefaultConditionRef, defaultConditionRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultSelector() {
		return defaultSelector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultSelector(String newDefaultSelector) {
		String oldDefaultSelector = defaultSelector;
		defaultSelector = newDefaultSelector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_SELECTOR, oldDefaultSelector, defaultSelector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultSelectorNamespace() {
		return defaultSelectorNamespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultSelectorNamespace(String newDefaultSelectorNamespace) {
		String oldDefaultSelectorNamespace = defaultSelectorNamespace;
		defaultSelectorNamespace = newDefaultSelectorNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_SELECTOR_NAMESPACE, oldDefaultSelectorNamespace, defaultSelectorNamespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultTargetProfile() {
		return defaultTargetProfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultTargetProfile(String newDefaultTargetProfile) {
		String oldDefaultTargetProfile = defaultTargetProfile;
		defaultTargetProfile = newDefaultTargetProfile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_TARGET_PROFILE, oldDefaultTargetProfile, defaultTargetProfile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__PARAMS:
				return basicSetParams(null, msgs);
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__CONDITIONS:
				return basicSetConditions(null, msgs);
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__PROFILES:
				return basicSetProfiles(null, msgs);
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_READER_GROUP:
				return ((InternalEList<?>)getAbstractReaderGroup()).basicRemove(otherEnd, msgs);
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_READER:
				return ((InternalEList<?>)getAbstractReader()).basicRemove(otherEnd, msgs);
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_RESOURCE_CONFIG_GROUP:
				return ((InternalEList<?>)getAbstractResourceConfigGroup()).basicRemove(otherEnd, msgs);
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_RESOURCE_CONFIG:
				return ((InternalEList<?>)getAbstractResourceConfig()).basicRemove(otherEnd, msgs);
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
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__PARAMS:
				return getParams();
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__CONDITIONS:
				return getConditions();
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__PROFILES:
				return getProfiles();
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_READER_GROUP:
				if (coreType) return getAbstractReaderGroup();
				return ((FeatureMap.Internal)getAbstractReaderGroup()).getWrapper();
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_READER:
				return getAbstractReader();
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_RESOURCE_CONFIG_GROUP:
				if (coreType) return getAbstractResourceConfigGroup();
				return ((FeatureMap.Internal)getAbstractResourceConfigGroup()).getWrapper();
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_RESOURCE_CONFIG:
				return getAbstractResourceConfig();
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_CONDITION_REF:
				return getDefaultConditionRef();
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_SELECTOR:
				return getDefaultSelector();
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_SELECTOR_NAMESPACE:
				return getDefaultSelectorNamespace();
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_TARGET_PROFILE:
				return getDefaultTargetProfile();
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
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__PARAMS:
				setParams((ParamsType)newValue);
				return;
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__CONDITIONS:
				setConditions((ConditionsType)newValue);
				return;
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__PROFILES:
				setProfiles((ProfilesType)newValue);
				return;
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_READER_GROUP:
				((FeatureMap.Internal)getAbstractReaderGroup()).set(newValue);
				return;
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_RESOURCE_CONFIG_GROUP:
				((FeatureMap.Internal)getAbstractResourceConfigGroup()).set(newValue);
				return;
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_CONDITION_REF:
				setDefaultConditionRef((String)newValue);
				return;
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_SELECTOR:
				setDefaultSelector((String)newValue);
				return;
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_SELECTOR_NAMESPACE:
				setDefaultSelectorNamespace((String)newValue);
				return;
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_TARGET_PROFILE:
				setDefaultTargetProfile((String)newValue);
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
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__PARAMS:
				setParams((ParamsType)null);
				return;
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__CONDITIONS:
				setConditions((ConditionsType)null);
				return;
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__PROFILES:
				setProfiles((ProfilesType)null);
				return;
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_READER_GROUP:
				getAbstractReaderGroup().clear();
				return;
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_RESOURCE_CONFIG_GROUP:
				getAbstractResourceConfigGroup().clear();
				return;
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_CONDITION_REF:
				setDefaultConditionRef(DEFAULT_CONDITION_REF_EDEFAULT);
				return;
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_SELECTOR:
				setDefaultSelector(DEFAULT_SELECTOR_EDEFAULT);
				return;
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_SELECTOR_NAMESPACE:
				setDefaultSelectorNamespace(DEFAULT_SELECTOR_NAMESPACE_EDEFAULT);
				return;
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_TARGET_PROFILE:
				setDefaultTargetProfile(DEFAULT_TARGET_PROFILE_EDEFAULT);
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
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__PARAMS:
				return params != null;
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__CONDITIONS:
				return conditions != null;
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__PROFILES:
				return profiles != null;
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_READER_GROUP:
				return abstractReaderGroup != null && !abstractReaderGroup.isEmpty();
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_READER:
				return !getAbstractReader().isEmpty();
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_RESOURCE_CONFIG_GROUP:
				return abstractResourceConfigGroup != null && !abstractResourceConfigGroup.isEmpty();
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_RESOURCE_CONFIG:
				return !getAbstractResourceConfig().isEmpty();
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_CONDITION_REF:
				return DEFAULT_CONDITION_REF_EDEFAULT == null ? defaultConditionRef != null : !DEFAULT_CONDITION_REF_EDEFAULT.equals(defaultConditionRef);
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_SELECTOR:
				return DEFAULT_SELECTOR_EDEFAULT == null ? defaultSelector != null : !DEFAULT_SELECTOR_EDEFAULT.equals(defaultSelector);
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_SELECTOR_NAMESPACE:
				return DEFAULT_SELECTOR_NAMESPACE_EDEFAULT == null ? defaultSelectorNamespace != null : !DEFAULT_SELECTOR_NAMESPACE_EDEFAULT.equals(defaultSelectorNamespace);
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE__DEFAULT_TARGET_PROFILE:
				return DEFAULT_TARGET_PROFILE_EDEFAULT == null ? defaultTargetProfile != null : !DEFAULT_TARGET_PROFILE_EDEFAULT.equals(defaultTargetProfile);
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
		result.append(" (abstractReaderGroup: "); //$NON-NLS-1$
		result.append(abstractReaderGroup);
		result.append(", abstractResourceConfigGroup: "); //$NON-NLS-1$
		result.append(abstractResourceConfigGroup);
		result.append(", defaultConditionRef: "); //$NON-NLS-1$
		result.append(defaultConditionRef);
		result.append(", defaultSelector: "); //$NON-NLS-1$
		result.append(defaultSelector);
		result.append(", defaultSelectorNamespace: "); //$NON-NLS-1$
		result.append(defaultSelectorNamespace);
		result.append(", defaultTargetProfile: "); //$NON-NLS-1$
		result.append(defaultTargetProfile);
		result.append(')');
		return result.toString();
	}

} //SmooksResourceListTypeImpl
