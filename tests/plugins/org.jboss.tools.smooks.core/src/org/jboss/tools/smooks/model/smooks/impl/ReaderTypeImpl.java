/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.smooks.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.jboss.tools.smooks.model.smooks.FeaturesType;
import org.jboss.tools.smooks.model.smooks.HandlersType;
import org.jboss.tools.smooks.model.smooks.ParamsType;
import org.jboss.tools.smooks.model.smooks.ReaderType;
import org.jboss.tools.smooks.model.smooks.SmooksPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reader Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.ReaderTypeImpl#getHandlers <em>Handlers</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.ReaderTypeImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.ReaderTypeImpl#getParams <em>Params</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.ReaderTypeImpl#getClass_ <em>Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReaderTypeImpl extends AbstractReaderImpl implements ReaderType {
	/**
	 * The cached value of the '{@link #getHandlers() <em>Handlers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHandlers()
	 * @generated
	 * @ordered
	 */
	protected HandlersType handlers;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected FeaturesType features;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReaderTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmooksPackage.Literals.READER_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HandlersType getHandlers() {
		return handlers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHandlers(HandlersType newHandlers, NotificationChain msgs) {
		HandlersType oldHandlers = handlers;
		handlers = newHandlers;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmooksPackage.READER_TYPE__HANDLERS, oldHandlers, newHandlers);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHandlers(HandlersType newHandlers) {
		if (newHandlers != handlers) {
			NotificationChain msgs = null;
			if (handlers != null)
				msgs = ((InternalEObject)handlers).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmooksPackage.READER_TYPE__HANDLERS, null, msgs);
			if (newHandlers != null)
				msgs = ((InternalEObject)newHandlers).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmooksPackage.READER_TYPE__HANDLERS, null, msgs);
			msgs = basicSetHandlers(newHandlers, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmooksPackage.READER_TYPE__HANDLERS, newHandlers, newHandlers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeaturesType getFeatures() {
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFeatures(FeaturesType newFeatures, NotificationChain msgs) {
		FeaturesType oldFeatures = features;
		features = newFeatures;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmooksPackage.READER_TYPE__FEATURES, oldFeatures, newFeatures);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatures(FeaturesType newFeatures) {
		if (newFeatures != features) {
			NotificationChain msgs = null;
			if (features != null)
				msgs = ((InternalEObject)features).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmooksPackage.READER_TYPE__FEATURES, null, msgs);
			if (newFeatures != null)
				msgs = ((InternalEObject)newFeatures).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmooksPackage.READER_TYPE__FEATURES, null, msgs);
			msgs = basicSetFeatures(newFeatures, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmooksPackage.READER_TYPE__FEATURES, newFeatures, newFeatures));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmooksPackage.READER_TYPE__PARAMS, oldParams, newParams);
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
				msgs = ((InternalEObject)params).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmooksPackage.READER_TYPE__PARAMS, null, msgs);
			if (newParams != null)
				msgs = ((InternalEObject)newParams).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmooksPackage.READER_TYPE__PARAMS, null, msgs);
			msgs = basicSetParams(newParams, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmooksPackage.READER_TYPE__PARAMS, newParams, newParams));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SmooksPackage.READER_TYPE__CLASS, oldClass, class_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SmooksPackage.READER_TYPE__HANDLERS:
				return basicSetHandlers(null, msgs);
			case SmooksPackage.READER_TYPE__FEATURES:
				return basicSetFeatures(null, msgs);
			case SmooksPackage.READER_TYPE__PARAMS:
				return basicSetParams(null, msgs);
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
			case SmooksPackage.READER_TYPE__HANDLERS:
				return getHandlers();
			case SmooksPackage.READER_TYPE__FEATURES:
				return getFeatures();
			case SmooksPackage.READER_TYPE__PARAMS:
				return getParams();
			case SmooksPackage.READER_TYPE__CLASS:
				return getClass_();
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
			case SmooksPackage.READER_TYPE__HANDLERS:
				setHandlers((HandlersType)newValue);
				return;
			case SmooksPackage.READER_TYPE__FEATURES:
				setFeatures((FeaturesType)newValue);
				return;
			case SmooksPackage.READER_TYPE__PARAMS:
				setParams((ParamsType)newValue);
				return;
			case SmooksPackage.READER_TYPE__CLASS:
				setClass((String)newValue);
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
			case SmooksPackage.READER_TYPE__HANDLERS:
				setHandlers((HandlersType)null);
				return;
			case SmooksPackage.READER_TYPE__FEATURES:
				setFeatures((FeaturesType)null);
				return;
			case SmooksPackage.READER_TYPE__PARAMS:
				setParams((ParamsType)null);
				return;
			case SmooksPackage.READER_TYPE__CLASS:
				setClass(CLASS_EDEFAULT);
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
			case SmooksPackage.READER_TYPE__HANDLERS:
				return handlers != null;
			case SmooksPackage.READER_TYPE__FEATURES:
				return features != null;
			case SmooksPackage.READER_TYPE__PARAMS:
				return params != null;
			case SmooksPackage.READER_TYPE__CLASS:
				return CLASS_EDEFAULT == null ? class_ != null : !CLASS_EDEFAULT.equals(class_);
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
		result.append(" (class: "); //$NON-NLS-1$
		result.append(class_);
		result.append(')');
		return result.toString();
	}

} //ReaderTypeImpl
