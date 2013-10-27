/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.smooks.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.jboss.tools.smooks.model.smooks.ConditionType;
import org.jboss.tools.smooks.model.smooks.ParamType;
import org.jboss.tools.smooks.model.smooks.ResourceConfigType;
import org.jboss.tools.smooks.model.smooks.ResourceType;
import org.jboss.tools.smooks.model.smooks.SmooksPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Config Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.ResourceConfigTypeImpl#getResource <em>Resource</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.ResourceConfigTypeImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.ResourceConfigTypeImpl#getParam <em>Param</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.ResourceConfigTypeImpl#getSelector <em>Selector</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.ResourceConfigTypeImpl#getSelectorNamespace <em>Selector Namespace</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.ResourceConfigTypeImpl#getTargetProfile <em>Target Profile</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceConfigTypeImpl extends AbstractResourceConfigImpl implements ResourceConfigType {
	/**
	 * The cached value of the '{@link #getResource() <em>Resource</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected ResourceType resource;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected ConditionType condition;

	/**
	 * The cached value of the '{@link #getParam() <em>Param</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParam()
	 * @generated
	 * @ordered
	 */
	protected EList<ParamType> param;

	/**
	 * The default value of the '{@link #getSelector() <em>Selector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelector()
	 * @generated
	 * @ordered
	 */
	protected static final String SELECTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSelector() <em>Selector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelector()
	 * @generated
	 * @ordered
	 */
	protected String selector = SELECTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getSelectorNamespace() <em>Selector Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectorNamespace()
	 * @generated
	 * @ordered
	 */
	protected static final String SELECTOR_NAMESPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSelectorNamespace() <em>Selector Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectorNamespace()
	 * @generated
	 * @ordered
	 */
	protected String selectorNamespace = SELECTOR_NAMESPACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetProfile() <em>Target Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetProfile()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_PROFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetProfile() <em>Target Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetProfile()
	 * @generated
	 * @ordered
	 */
	protected String targetProfile = TARGET_PROFILE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceConfigTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmooksPackage.Literals.RESOURCE_CONFIG_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceType getResource() {
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResource(ResourceType newResource, NotificationChain msgs) {
		ResourceType oldResource = resource;
		resource = newResource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmooksPackage.RESOURCE_CONFIG_TYPE__RESOURCE, oldResource, newResource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResource(ResourceType newResource) {
		if (newResource != resource) {
			NotificationChain msgs = null;
			if (resource != null)
				msgs = ((InternalEObject)resource).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmooksPackage.RESOURCE_CONFIG_TYPE__RESOURCE, null, msgs);
			if (newResource != null)
				msgs = ((InternalEObject)newResource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmooksPackage.RESOURCE_CONFIG_TYPE__RESOURCE, null, msgs);
			msgs = basicSetResource(newResource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmooksPackage.RESOURCE_CONFIG_TYPE__RESOURCE, newResource, newResource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionType getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(ConditionType newCondition, NotificationChain msgs) {
		ConditionType oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmooksPackage.RESOURCE_CONFIG_TYPE__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(ConditionType newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmooksPackage.RESOURCE_CONFIG_TYPE__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmooksPackage.RESOURCE_CONFIG_TYPE__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmooksPackage.RESOURCE_CONFIG_TYPE__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParamType> getParam() {
		if (param == null) {
			param = new EObjectContainmentEList<ParamType>(ParamType.class, this, SmooksPackage.RESOURCE_CONFIG_TYPE__PARAM);
		}
		return param;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSelector() {
		return selector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelector(String newSelector) {
		String oldSelector = selector;
		selector = newSelector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmooksPackage.RESOURCE_CONFIG_TYPE__SELECTOR, oldSelector, selector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSelectorNamespace() {
		return selectorNamespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelectorNamespace(String newSelectorNamespace) {
		String oldSelectorNamespace = selectorNamespace;
		selectorNamespace = newSelectorNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmooksPackage.RESOURCE_CONFIG_TYPE__SELECTOR_NAMESPACE, oldSelectorNamespace, selectorNamespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetProfile() {
		return targetProfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetProfile(String newTargetProfile) {
		String oldTargetProfile = targetProfile;
		targetProfile = newTargetProfile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmooksPackage.RESOURCE_CONFIG_TYPE__TARGET_PROFILE, oldTargetProfile, targetProfile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SmooksPackage.RESOURCE_CONFIG_TYPE__RESOURCE:
				return basicSetResource(null, msgs);
			case SmooksPackage.RESOURCE_CONFIG_TYPE__CONDITION:
				return basicSetCondition(null, msgs);
			case SmooksPackage.RESOURCE_CONFIG_TYPE__PARAM:
				return ((InternalEList<?>)getParam()).basicRemove(otherEnd, msgs);
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
			case SmooksPackage.RESOURCE_CONFIG_TYPE__RESOURCE:
				return getResource();
			case SmooksPackage.RESOURCE_CONFIG_TYPE__CONDITION:
				return getCondition();
			case SmooksPackage.RESOURCE_CONFIG_TYPE__PARAM:
				return getParam();
			case SmooksPackage.RESOURCE_CONFIG_TYPE__SELECTOR:
				return getSelector();
			case SmooksPackage.RESOURCE_CONFIG_TYPE__SELECTOR_NAMESPACE:
				return getSelectorNamespace();
			case SmooksPackage.RESOURCE_CONFIG_TYPE__TARGET_PROFILE:
				return getTargetProfile();
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
			case SmooksPackage.RESOURCE_CONFIG_TYPE__RESOURCE:
				setResource((ResourceType)newValue);
				return;
			case SmooksPackage.RESOURCE_CONFIG_TYPE__CONDITION:
				setCondition((ConditionType)newValue);
				return;
			case SmooksPackage.RESOURCE_CONFIG_TYPE__PARAM:
				getParam().clear();
				getParam().addAll((Collection<? extends ParamType>)newValue);
				return;
			case SmooksPackage.RESOURCE_CONFIG_TYPE__SELECTOR:
				setSelector((String)newValue);
				return;
			case SmooksPackage.RESOURCE_CONFIG_TYPE__SELECTOR_NAMESPACE:
				setSelectorNamespace((String)newValue);
				return;
			case SmooksPackage.RESOURCE_CONFIG_TYPE__TARGET_PROFILE:
				setTargetProfile((String)newValue);
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
			case SmooksPackage.RESOURCE_CONFIG_TYPE__RESOURCE:
				setResource((ResourceType)null);
				return;
			case SmooksPackage.RESOURCE_CONFIG_TYPE__CONDITION:
				setCondition((ConditionType)null);
				return;
			case SmooksPackage.RESOURCE_CONFIG_TYPE__PARAM:
				getParam().clear();
				return;
			case SmooksPackage.RESOURCE_CONFIG_TYPE__SELECTOR:
				setSelector(SELECTOR_EDEFAULT);
				return;
			case SmooksPackage.RESOURCE_CONFIG_TYPE__SELECTOR_NAMESPACE:
				setSelectorNamespace(SELECTOR_NAMESPACE_EDEFAULT);
				return;
			case SmooksPackage.RESOURCE_CONFIG_TYPE__TARGET_PROFILE:
				setTargetProfile(TARGET_PROFILE_EDEFAULT);
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
			case SmooksPackage.RESOURCE_CONFIG_TYPE__RESOURCE:
				return resource != null;
			case SmooksPackage.RESOURCE_CONFIG_TYPE__CONDITION:
				return condition != null;
			case SmooksPackage.RESOURCE_CONFIG_TYPE__PARAM:
				return param != null && !param.isEmpty();
			case SmooksPackage.RESOURCE_CONFIG_TYPE__SELECTOR:
				return SELECTOR_EDEFAULT == null ? selector != null : !SELECTOR_EDEFAULT.equals(selector);
			case SmooksPackage.RESOURCE_CONFIG_TYPE__SELECTOR_NAMESPACE:
				return SELECTOR_NAMESPACE_EDEFAULT == null ? selectorNamespace != null : !SELECTOR_NAMESPACE_EDEFAULT.equals(selectorNamespace);
			case SmooksPackage.RESOURCE_CONFIG_TYPE__TARGET_PROFILE:
				return TARGET_PROFILE_EDEFAULT == null ? targetProfile != null : !TARGET_PROFILE_EDEFAULT.equals(targetProfile);
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
		result.append(" (selector: "); //$NON-NLS-1$
		result.append(selector);
		result.append(", selectorNamespace: "); //$NON-NLS-1$
		result.append(selectorNamespace);
		result.append(", targetProfile: "); //$NON-NLS-1$
		result.append(targetProfile);
		result.append(')');
		return result.toString();
	}

} //ResourceConfigTypeImpl
