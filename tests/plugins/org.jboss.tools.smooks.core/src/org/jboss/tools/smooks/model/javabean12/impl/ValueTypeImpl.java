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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.jboss.tools.smooks.model.common.impl.AbstractAnyTypeImpl;
import org.jboss.tools.smooks.model.javabean12.DecodeParamType;
import org.jboss.tools.smooks.model.javabean12.Javabean12Package;
import org.jboss.tools.smooks.model.javabean12.ValueType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.ValueTypeImpl#getDecodeParam <em>Decode Param</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.ValueTypeImpl#getData <em>Data</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.ValueTypeImpl#getDataNS <em>Data NS</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.ValueTypeImpl#getDecoder <em>Decoder</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.ValueTypeImpl#getDefault <em>Default</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.ValueTypeImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.ValueTypeImpl#getSetterMethod <em>Setter Method</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValueTypeImpl extends AbstractAnyTypeImpl implements ValueType {
	/**
	 * The cached value of the '{@link #getDecodeParam() <em>Decode Param</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecodeParam()
	 * @generated
	 * @ordered
	 */
	protected EList decodeParam;

	/**
	 * The default value of the '{@link #getData() <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected String data = DATA_EDEFAULT;

	/**
	 * The default value of the '{@link #getDataNS() <em>Data NS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataNS()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_NS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataNS() <em>Data NS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataNS()
	 * @generated
	 * @ordered
	 */
	protected String dataNS = DATA_NS_EDEFAULT;

	/**
	 * The default value of the '{@link #getDecoder() <em>Decoder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecoder()
	 * @generated
	 * @ordered
	 */
	protected static final String DECODER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDecoder() <em>Decoder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecoder()
	 * @generated
	 * @ordered
	 */
	protected String decoder = DECODER_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected String default_ = DEFAULT_EDEFAULT;

	/**
	 * The default value of the '{@link #getProperty() <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected static final String PROPERTY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected String property = PROPERTY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSetterMethod() <em>Setter Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetterMethod()
	 * @generated
	 * @ordered
	 */
	protected static final String SETTER_METHOD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSetterMethod() <em>Setter Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetterMethod()
	 * @generated
	 * @ordered
	 */
	protected String setterMethod = SETTER_METHOD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Javabean12Package.Literals.VALUE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDecodeParam() {
		if (decodeParam == null) {
			decodeParam = new EObjectContainmentEList(DecodeParamType.class, this, Javabean12Package.VALUE_TYPE__DECODE_PARAM);
		}
		return decodeParam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getData() {
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setData(String newData) {
		String oldData = data;
		data = newData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Javabean12Package.VALUE_TYPE__DATA, oldData, data));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDataNS() {
		return dataNS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataNS(String newDataNS) {
		String oldDataNS = dataNS;
		dataNS = newDataNS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Javabean12Package.VALUE_TYPE__DATA_NS, oldDataNS, dataNS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDecoder() {
		return decoder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDecoder(String newDecoder) {
		String oldDecoder = decoder;
		decoder = newDecoder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Javabean12Package.VALUE_TYPE__DECODER, oldDecoder, decoder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefault(String newDefault) {
		String oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Javabean12Package.VALUE_TYPE__DEFAULT, oldDefault, default_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(String newProperty) {
		String oldProperty = property;
		property = newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Javabean12Package.VALUE_TYPE__PROPERTY, oldProperty, property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSetterMethod() {
		return setterMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSetterMethod(String newSetterMethod) {
		String oldSetterMethod = setterMethod;
		setterMethod = newSetterMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Javabean12Package.VALUE_TYPE__SETTER_METHOD, oldSetterMethod, setterMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Javabean12Package.VALUE_TYPE__DECODE_PARAM:
				return ((InternalEList)getDecodeParam()).basicRemove(otherEnd, msgs);
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
			case Javabean12Package.VALUE_TYPE__DECODE_PARAM:
				return getDecodeParam();
			case Javabean12Package.VALUE_TYPE__DATA:
				return getData();
			case Javabean12Package.VALUE_TYPE__DATA_NS:
				return getDataNS();
			case Javabean12Package.VALUE_TYPE__DECODER:
				return getDecoder();
			case Javabean12Package.VALUE_TYPE__DEFAULT:
				return getDefault();
			case Javabean12Package.VALUE_TYPE__PROPERTY:
				return getProperty();
			case Javabean12Package.VALUE_TYPE__SETTER_METHOD:
				return getSetterMethod();
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
			case Javabean12Package.VALUE_TYPE__DECODE_PARAM:
				getDecodeParam().clear();
				getDecodeParam().addAll((Collection)newValue);
				return;
			case Javabean12Package.VALUE_TYPE__DATA:
				setData((String)newValue);
				return;
			case Javabean12Package.VALUE_TYPE__DATA_NS:
				setDataNS((String)newValue);
				return;
			case Javabean12Package.VALUE_TYPE__DECODER:
				setDecoder((String)newValue);
				return;
			case Javabean12Package.VALUE_TYPE__DEFAULT:
				setDefault((String)newValue);
				return;
			case Javabean12Package.VALUE_TYPE__PROPERTY:
				setProperty((String)newValue);
				return;
			case Javabean12Package.VALUE_TYPE__SETTER_METHOD:
				setSetterMethod((String)newValue);
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
			case Javabean12Package.VALUE_TYPE__DECODE_PARAM:
				getDecodeParam().clear();
				return;
			case Javabean12Package.VALUE_TYPE__DATA:
				setData(DATA_EDEFAULT);
				return;
			case Javabean12Package.VALUE_TYPE__DATA_NS:
				setDataNS(DATA_NS_EDEFAULT);
				return;
			case Javabean12Package.VALUE_TYPE__DECODER:
				setDecoder(DECODER_EDEFAULT);
				return;
			case Javabean12Package.VALUE_TYPE__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
				return;
			case Javabean12Package.VALUE_TYPE__PROPERTY:
				setProperty(PROPERTY_EDEFAULT);
				return;
			case Javabean12Package.VALUE_TYPE__SETTER_METHOD:
				setSetterMethod(SETTER_METHOD_EDEFAULT);
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
			case Javabean12Package.VALUE_TYPE__DECODE_PARAM:
				return decodeParam != null && !decodeParam.isEmpty();
			case Javabean12Package.VALUE_TYPE__DATA:
				return DATA_EDEFAULT == null ? data != null : !DATA_EDEFAULT.equals(data);
			case Javabean12Package.VALUE_TYPE__DATA_NS:
				return DATA_NS_EDEFAULT == null ? dataNS != null : !DATA_NS_EDEFAULT.equals(dataNS);
			case Javabean12Package.VALUE_TYPE__DECODER:
				return DECODER_EDEFAULT == null ? decoder != null : !DECODER_EDEFAULT.equals(decoder);
			case Javabean12Package.VALUE_TYPE__DEFAULT:
				return DEFAULT_EDEFAULT == null ? default_ != null : !DEFAULT_EDEFAULT.equals(default_);
			case Javabean12Package.VALUE_TYPE__PROPERTY:
				return PROPERTY_EDEFAULT == null ? property != null : !PROPERTY_EDEFAULT.equals(property);
			case Javabean12Package.VALUE_TYPE__SETTER_METHOD:
				return SETTER_METHOD_EDEFAULT == null ? setterMethod != null : !SETTER_METHOD_EDEFAULT.equals(setterMethod);
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
		result.append(" (data: "); //$NON-NLS-1$
		result.append(data);
		result.append(", dataNS: "); //$NON-NLS-1$
		result.append(dataNS);
		result.append(", decoder: "); //$NON-NLS-1$
		result.append(decoder);
		result.append(", default: "); //$NON-NLS-1$
		result.append(default_);
		result.append(", property: "); //$NON-NLS-1$
		result.append(property);
		result.append(", setterMethod: "); //$NON-NLS-1$
		result.append(setterMethod);
		result.append(')');
		return result.toString();
	}

} //ValueTypeImpl
