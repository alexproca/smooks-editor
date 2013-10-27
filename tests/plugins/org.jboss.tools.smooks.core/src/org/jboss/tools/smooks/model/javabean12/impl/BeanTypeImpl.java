/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.javabean12.impl;

import java.util.Collection;


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.jboss.tools.smooks.model.javabean12.BeanType;
import org.jboss.tools.smooks.model.javabean12.Javabean12Package;
import org.jboss.tools.smooks.model.smooks.impl.ElementVisitorImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bean Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.BeanTypeImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.BeanTypeImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.BeanTypeImpl#getWiring <em>Wiring</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.BeanTypeImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.BeanTypeImpl#getBeanId <em>Bean Id</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.BeanTypeImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.BeanTypeImpl#getCreateOnElement <em>Create On Element</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.BeanTypeImpl#getCreateOnElementNS <em>Create On Element NS</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.BeanTypeImpl#isExtendLifecycle <em>Extend Lifecycle</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BeanTypeImpl extends ElementVisitorImpl implements BeanType {
	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap group;

	/**
	 * The default value of the '{@link #getBeanId() <em>Bean Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeanId()
	 * @generated
	 * @ordered
	 */
	protected static final String BEAN_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBeanId() <em>Bean Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeanId()
	 * @generated
	 * @ordered
	 */
	protected String beanId = BEAN_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getClass_() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected String class_ = CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreateOnElement() <em>Create On Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateOnElement()
	 * @generated
	 * @ordered
	 */
	protected static final String CREATE_ON_ELEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreateOnElement() <em>Create On Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateOnElement()
	 * @generated
	 * @ordered
	 */
	protected String createOnElement = CREATE_ON_ELEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreateOnElementNS() <em>Create On Element NS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateOnElementNS()
	 * @generated
	 * @ordered
	 */
	protected static final String CREATE_ON_ELEMENT_NS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreateOnElementNS() <em>Create On Element NS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateOnElementNS()
	 * @generated
	 * @ordered
	 */
	protected String createOnElementNS = CREATE_ON_ELEMENT_NS_EDEFAULT;

	/**
	 * The default value of the '{@link #isExtendLifecycle() <em>Extend Lifecycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtendLifecycle()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXTEND_LIFECYCLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExtendLifecycle() <em>Extend Lifecycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtendLifecycle()
	 * @generated
	 * @ordered
	 */
	protected boolean extendLifecycle = EXTEND_LIFECYCLE_EDEFAULT;

	/**
	 * This is true if the Extend Lifecycle attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean extendLifecycleESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BeanTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Javabean12Package.Literals.BEAN_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, Javabean12Package.BEAN_TYPE__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getValue() {
		return getGroup().list(Javabean12Package.Literals.BEAN_TYPE__VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getWiring() {
		return getGroup().list(Javabean12Package.Literals.BEAN_TYPE__WIRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getExpression() {
		return getGroup().list(Javabean12Package.Literals.BEAN_TYPE__EXPRESSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBeanId() {
		return beanId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBeanId(String newBeanId) {
		String oldBeanId = beanId;
		beanId = newBeanId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Javabean12Package.BEAN_TYPE__BEAN_ID, oldBeanId, beanId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClass_() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(String newClass) {
		String oldClass = class_;
		class_ = newClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Javabean12Package.BEAN_TYPE__CLASS, oldClass, class_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreateOnElement() {
		return createOnElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreateOnElement(String newCreateOnElement) {
		String oldCreateOnElement = createOnElement;
		createOnElement = newCreateOnElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Javabean12Package.BEAN_TYPE__CREATE_ON_ELEMENT, oldCreateOnElement, createOnElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreateOnElementNS() {
		return createOnElementNS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreateOnElementNS(String newCreateOnElementNS) {
		String oldCreateOnElementNS = createOnElementNS;
		createOnElementNS = newCreateOnElementNS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Javabean12Package.BEAN_TYPE__CREATE_ON_ELEMENT_NS, oldCreateOnElementNS, createOnElementNS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExtendLifecycle() {
		return extendLifecycle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendLifecycle(boolean newExtendLifecycle) {
		boolean oldExtendLifecycle = extendLifecycle;
		extendLifecycle = newExtendLifecycle;
		boolean oldExtendLifecycleESet = extendLifecycleESet;
		extendLifecycleESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Javabean12Package.BEAN_TYPE__EXTEND_LIFECYCLE, oldExtendLifecycle, extendLifecycle, !oldExtendLifecycleESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetExtendLifecycle() {
		boolean oldExtendLifecycle = extendLifecycle;
		boolean oldExtendLifecycleESet = extendLifecycleESet;
		extendLifecycle = EXTEND_LIFECYCLE_EDEFAULT;
		extendLifecycleESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Javabean12Package.BEAN_TYPE__EXTEND_LIFECYCLE, oldExtendLifecycle, EXTEND_LIFECYCLE_EDEFAULT, oldExtendLifecycleESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetExtendLifecycle() {
		return extendLifecycleESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Javabean12Package.BEAN_TYPE__GROUP:
				return ((InternalEList)getGroup()).basicRemove(otherEnd, msgs);
			case Javabean12Package.BEAN_TYPE__VALUE:
				return ((InternalEList)getValue()).basicRemove(otherEnd, msgs);
			case Javabean12Package.BEAN_TYPE__WIRING:
				return ((InternalEList)getWiring()).basicRemove(otherEnd, msgs);
			case Javabean12Package.BEAN_TYPE__EXPRESSION:
				return ((InternalEList)getExpression()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Javabean12Package.BEAN_TYPE__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case Javabean12Package.BEAN_TYPE__VALUE:
				return getValue();
			case Javabean12Package.BEAN_TYPE__WIRING:
				return getWiring();
			case Javabean12Package.BEAN_TYPE__EXPRESSION:
				return getExpression();
			case Javabean12Package.BEAN_TYPE__BEAN_ID:
				return getBeanId();
			case Javabean12Package.BEAN_TYPE__CLASS:
				return getClass_();
			case Javabean12Package.BEAN_TYPE__CREATE_ON_ELEMENT:
				return getCreateOnElement();
			case Javabean12Package.BEAN_TYPE__CREATE_ON_ELEMENT_NS:
				return getCreateOnElementNS();
			case Javabean12Package.BEAN_TYPE__EXTEND_LIFECYCLE:
				return isExtendLifecycle() ? Boolean.TRUE : Boolean.FALSE;
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
			case Javabean12Package.BEAN_TYPE__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case Javabean12Package.BEAN_TYPE__VALUE:
				getValue().clear();
				getValue().addAll((Collection)newValue);
				return;
			case Javabean12Package.BEAN_TYPE__WIRING:
				getWiring().clear();
				getWiring().addAll((Collection)newValue);
				return;
			case Javabean12Package.BEAN_TYPE__EXPRESSION:
				getExpression().clear();
				getExpression().addAll((Collection)newValue);
				return;
			case Javabean12Package.BEAN_TYPE__BEAN_ID:
				setBeanId((String)newValue);
				return;
			case Javabean12Package.BEAN_TYPE__CLASS:
				setClass((String)newValue);
				return;
			case Javabean12Package.BEAN_TYPE__CREATE_ON_ELEMENT:
				setCreateOnElement((String)newValue);
				return;
			case Javabean12Package.BEAN_TYPE__CREATE_ON_ELEMENT_NS:
				setCreateOnElementNS((String)newValue);
				return;
			case Javabean12Package.BEAN_TYPE__EXTEND_LIFECYCLE:
				setExtendLifecycle(((Boolean)newValue).booleanValue());
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
			case Javabean12Package.BEAN_TYPE__GROUP:
				getGroup().clear();
				return;
			case Javabean12Package.BEAN_TYPE__VALUE:
				getValue().clear();
				return;
			case Javabean12Package.BEAN_TYPE__WIRING:
				getWiring().clear();
				return;
			case Javabean12Package.BEAN_TYPE__EXPRESSION:
				getExpression().clear();
				return;
			case Javabean12Package.BEAN_TYPE__BEAN_ID:
				setBeanId(BEAN_ID_EDEFAULT);
				return;
			case Javabean12Package.BEAN_TYPE__CLASS:
				setClass(CLASS_EDEFAULT);
				return;
			case Javabean12Package.BEAN_TYPE__CREATE_ON_ELEMENT:
				setCreateOnElement(CREATE_ON_ELEMENT_EDEFAULT);
				return;
			case Javabean12Package.BEAN_TYPE__CREATE_ON_ELEMENT_NS:
				setCreateOnElementNS(CREATE_ON_ELEMENT_NS_EDEFAULT);
				return;
			case Javabean12Package.BEAN_TYPE__EXTEND_LIFECYCLE:
				unsetExtendLifecycle();
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
			case Javabean12Package.BEAN_TYPE__GROUP:
				return group != null && !group.isEmpty();
			case Javabean12Package.BEAN_TYPE__VALUE:
				return !getValue().isEmpty();
			case Javabean12Package.BEAN_TYPE__WIRING:
				return !getWiring().isEmpty();
			case Javabean12Package.BEAN_TYPE__EXPRESSION:
				return !getExpression().isEmpty();
			case Javabean12Package.BEAN_TYPE__BEAN_ID:
				return BEAN_ID_EDEFAULT == null ? beanId != null : !BEAN_ID_EDEFAULT.equals(beanId);
			case Javabean12Package.BEAN_TYPE__CLASS:
				return CLASS_EDEFAULT == null ? class_ != null : !CLASS_EDEFAULT.equals(class_);
			case Javabean12Package.BEAN_TYPE__CREATE_ON_ELEMENT:
				return CREATE_ON_ELEMENT_EDEFAULT == null ? createOnElement != null : !CREATE_ON_ELEMENT_EDEFAULT.equals(createOnElement);
			case Javabean12Package.BEAN_TYPE__CREATE_ON_ELEMENT_NS:
				return CREATE_ON_ELEMENT_NS_EDEFAULT == null ? createOnElementNS != null : !CREATE_ON_ELEMENT_NS_EDEFAULT.equals(createOnElementNS);
			case Javabean12Package.BEAN_TYPE__EXTEND_LIFECYCLE:
				return isSetExtendLifecycle();
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
		result.append(" (group: "); //$NON-NLS-1$
		result.append(group);
		result.append(", beanId: "); //$NON-NLS-1$
		result.append(beanId);
		result.append(", class: "); //$NON-NLS-1$
		result.append(class_);
		result.append(", createOnElement: "); //$NON-NLS-1$
		result.append(createOnElement);
		result.append(", createOnElementNS: "); //$NON-NLS-1$
		result.append(createOnElementNS);
		result.append(", extendLifecycle: "); //$NON-NLS-1$
		if (extendLifecycleESet) result.append(extendLifecycle); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //BeanTypeImpl
