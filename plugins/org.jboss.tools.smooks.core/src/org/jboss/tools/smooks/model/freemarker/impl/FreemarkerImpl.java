/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.freemarker.impl;


import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.jboss.tools.smooks.model.freemarker.Freemarker;
import org.jboss.tools.smooks.model.freemarker.FreemarkerFactory;
import org.jboss.tools.smooks.model.freemarker.FreemarkerPackage;
import org.jboss.tools.smooks.model.freemarker.Template;
import org.jboss.tools.smooks.model.freemarker.Use;
import org.jboss.tools.smooks.model.smooks.ParamType;
import org.jboss.tools.smooks.model.smooks.impl.ElementVisitorImpl;



/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Freemarker</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.freemarker.impl.FreemarkerImpl#getTemplate <em>Template</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.freemarker.impl.FreemarkerImpl#getUse <em>Use</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.freemarker.impl.FreemarkerImpl#getParam <em>Param</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.freemarker.impl.FreemarkerImpl#isApplyBefore <em>Apply Before</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.freemarker.impl.FreemarkerImpl#getApplyOnElement <em>Apply On Element</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.freemarker.impl.FreemarkerImpl#getApplyOnElementNS <em>Apply On Element NS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FreemarkerImpl extends ElementVisitorImpl implements Freemarker {
	/**
	 * The cached value of the '{@link #getTemplate() <em>Template</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplate()
	 * @generated
	 * @ordered
	 */
	protected Template template;

	/**
	 * The cached value of the '{@link #getUse() <em>Use</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUse()
	 * @generated
	 * @ordered
	 */
	protected Use use;

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
	 * The default value of the '{@link #isApplyBefore() <em>Apply Before</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isApplyBefore()
	 * @generated
	 * @ordered
	 */
	protected static final boolean APPLY_BEFORE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isApplyBefore() <em>Apply Before</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isApplyBefore()
	 * @generated
	 * @ordered
	 */
	protected boolean applyBefore = APPLY_BEFORE_EDEFAULT;

	/**
	 * This is true if the Apply Before attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean applyBeforeESet;

	/**
	 * The default value of the '{@link #getApplyOnElement() <em>Apply On Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplyOnElement()
	 * @generated
	 * @ordered
	 */
	protected static final String APPLY_ON_ELEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getApplyOnElement() <em>Apply On Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplyOnElement()
	 * @generated
	 * @ordered
	 */
	protected String applyOnElement = APPLY_ON_ELEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getApplyOnElementNS() <em>Apply On Element NS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplyOnElementNS()
	 * @generated
	 * @ordered
	 */
	protected static final String APPLY_ON_ELEMENT_NS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getApplyOnElementNS() <em>Apply On Element NS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplyOnElementNS()
	 * @generated
	 * @ordered
	 */
	protected String applyOnElementNS = APPLY_ON_ELEMENT_NS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FreemarkerImpl() {
		super();
		this.setApplyOnElement("#document"); //$NON-NLS-1$
		setTemplate(FreemarkerFactory.eINSTANCE.createTemplate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FreemarkerPackage.Literals.FREEMARKER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Template getTemplate() {
		return template;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTemplate(Template newTemplate, NotificationChain msgs) {
		Template oldTemplate = template;
		template = newTemplate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FreemarkerPackage.FREEMARKER__TEMPLATE, oldTemplate, newTemplate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplate(Template newTemplate) {
		if (newTemplate != template) {
			NotificationChain msgs = null;
			if (template != null)
				msgs = ((InternalEObject)template).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FreemarkerPackage.FREEMARKER__TEMPLATE, null, msgs);
			if (newTemplate != null)
				msgs = ((InternalEObject)newTemplate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FreemarkerPackage.FREEMARKER__TEMPLATE, null, msgs);
			msgs = basicSetTemplate(newTemplate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FreemarkerPackage.FREEMARKER__TEMPLATE, newTemplate, newTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Use getUse() {
		return use;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUse(Use newUse, NotificationChain msgs) {
		Use oldUse = use;
		use = newUse;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FreemarkerPackage.FREEMARKER__USE, oldUse, newUse);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUse(Use newUse) {
		if (newUse != use) {
			NotificationChain msgs = null;
			if (use != null)
				msgs = ((InternalEObject)use).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FreemarkerPackage.FREEMARKER__USE, null, msgs);
			if (newUse != null)
				msgs = ((InternalEObject)newUse).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FreemarkerPackage.FREEMARKER__USE, null, msgs);
			msgs = basicSetUse(newUse, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FreemarkerPackage.FREEMARKER__USE, newUse, newUse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParamType> getParam() {
		if (param == null) {
			param = new EObjectContainmentEList<ParamType>(ParamType.class, this, FreemarkerPackage.FREEMARKER__PARAM);
		}
		return param;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isApplyBefore() {
		return applyBefore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplyBefore(boolean newApplyBefore) {
		boolean oldApplyBefore = applyBefore;
		applyBefore = newApplyBefore;
		boolean oldApplyBeforeESet = applyBeforeESet;
		applyBeforeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FreemarkerPackage.FREEMARKER__APPLY_BEFORE, oldApplyBefore, applyBefore, !oldApplyBeforeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetApplyBefore() {
		boolean oldApplyBefore = applyBefore;
		boolean oldApplyBeforeESet = applyBeforeESet;
		applyBefore = APPLY_BEFORE_EDEFAULT;
		applyBeforeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FreemarkerPackage.FREEMARKER__APPLY_BEFORE, oldApplyBefore, APPLY_BEFORE_EDEFAULT, oldApplyBeforeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetApplyBefore() {
		return applyBeforeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getApplyOnElement() {
		return applyOnElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplyOnElement(String newApplyOnElement) {
		String oldApplyOnElement = applyOnElement;
		applyOnElement = newApplyOnElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FreemarkerPackage.FREEMARKER__APPLY_ON_ELEMENT, oldApplyOnElement, applyOnElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getApplyOnElementNS() {
		return applyOnElementNS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplyOnElementNS(String newApplyOnElementNS) {
		String oldApplyOnElementNS = applyOnElementNS;
		applyOnElementNS = newApplyOnElementNS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FreemarkerPackage.FREEMARKER__APPLY_ON_ELEMENT_NS, oldApplyOnElementNS, applyOnElementNS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FreemarkerPackage.FREEMARKER__TEMPLATE:
				return basicSetTemplate(null, msgs);
			case FreemarkerPackage.FREEMARKER__USE:
				return basicSetUse(null, msgs);
			case FreemarkerPackage.FREEMARKER__PARAM:
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
			case FreemarkerPackage.FREEMARKER__TEMPLATE:
				return getTemplate();
			case FreemarkerPackage.FREEMARKER__USE:
				return getUse();
			case FreemarkerPackage.FREEMARKER__PARAM:
				return getParam();
			case FreemarkerPackage.FREEMARKER__APPLY_BEFORE:
				return isApplyBefore() ? Boolean.TRUE : Boolean.FALSE;
			case FreemarkerPackage.FREEMARKER__APPLY_ON_ELEMENT:
				return getApplyOnElement();
			case FreemarkerPackage.FREEMARKER__APPLY_ON_ELEMENT_NS:
				return getApplyOnElementNS();
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
			case FreemarkerPackage.FREEMARKER__TEMPLATE:
				setTemplate((Template)newValue);
				return;
			case FreemarkerPackage.FREEMARKER__USE:
				setUse((Use)newValue);
				return;
			case FreemarkerPackage.FREEMARKER__PARAM:
				getParam().clear();
				getParam().addAll((Collection<? extends ParamType>)newValue);
				return;
			case FreemarkerPackage.FREEMARKER__APPLY_BEFORE:
				setApplyBefore(((Boolean)newValue).booleanValue());
				return;
			case FreemarkerPackage.FREEMARKER__APPLY_ON_ELEMENT:
				setApplyOnElement((String)newValue);
				return;
			case FreemarkerPackage.FREEMARKER__APPLY_ON_ELEMENT_NS:
				setApplyOnElementNS((String)newValue);
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
			case FreemarkerPackage.FREEMARKER__TEMPLATE:
				setTemplate((Template)null);
				return;
			case FreemarkerPackage.FREEMARKER__USE:
				setUse((Use)null);
				return;
			case FreemarkerPackage.FREEMARKER__PARAM:
				getParam().clear();
				return;
			case FreemarkerPackage.FREEMARKER__APPLY_BEFORE:
				unsetApplyBefore();
				return;
			case FreemarkerPackage.FREEMARKER__APPLY_ON_ELEMENT:
				setApplyOnElement(APPLY_ON_ELEMENT_EDEFAULT);
				return;
			case FreemarkerPackage.FREEMARKER__APPLY_ON_ELEMENT_NS:
				setApplyOnElementNS(APPLY_ON_ELEMENT_NS_EDEFAULT);
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
			case FreemarkerPackage.FREEMARKER__TEMPLATE:
				return template != null;
			case FreemarkerPackage.FREEMARKER__USE:
				return use != null;
			case FreemarkerPackage.FREEMARKER__PARAM:
				return param != null && !param.isEmpty();
			case FreemarkerPackage.FREEMARKER__APPLY_BEFORE:
				return isSetApplyBefore();
			case FreemarkerPackage.FREEMARKER__APPLY_ON_ELEMENT:
				return APPLY_ON_ELEMENT_EDEFAULT == null ? applyOnElement != null : !APPLY_ON_ELEMENT_EDEFAULT.equals(applyOnElement);
			case FreemarkerPackage.FREEMARKER__APPLY_ON_ELEMENT_NS:
				return APPLY_ON_ELEMENT_NS_EDEFAULT == null ? applyOnElementNS != null : !APPLY_ON_ELEMENT_NS_EDEFAULT.equals(applyOnElementNS);
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
		result.append(" (applyBefore: "); //$NON-NLS-1$
		if (applyBeforeESet) result.append(applyBefore); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", applyOnElement: "); //$NON-NLS-1$
		result.append(applyOnElement);
		result.append(", applyOnElementNS: "); //$NON-NLS-1$
		result.append(applyOnElementNS);
		result.append(')');
		return result.toString();
	}

} //FreemarkerImpl
