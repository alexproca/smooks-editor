/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.javabean12.impl;



import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.jboss.tools.smooks.model.common.impl.AbstractAnyTypeImpl;
import org.jboss.tools.smooks.model.javabean12.ExpressionType;
import org.jboss.tools.smooks.model.javabean12.Javabean12Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.ExpressionTypeImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.ExpressionTypeImpl#getExecOnElement <em>Exec On Element</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.ExpressionTypeImpl#getExecOnElementNS <em>Exec On Element NS</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.ExpressionTypeImpl#getInitVal <em>Init Val</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.ExpressionTypeImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.ExpressionTypeImpl#getSetterMethod <em>Setter Method</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionTypeImpl extends AbstractAnyTypeImpl implements ExpressionType {
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
	 * The default value of the '{@link #getExecOnElement() <em>Exec On Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecOnElement()
	 * @generated
	 * @ordered
	 */
	protected static final String EXEC_ON_ELEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExecOnElement() <em>Exec On Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecOnElement()
	 * @generated
	 * @ordered
	 */
	protected String execOnElement = EXEC_ON_ELEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getExecOnElementNS() <em>Exec On Element NS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecOnElementNS()
	 * @generated
	 * @ordered
	 */
	protected static final String EXEC_ON_ELEMENT_NS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExecOnElementNS() <em>Exec On Element NS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecOnElementNS()
	 * @generated
	 * @ordered
	 */
	protected String execOnElementNS = EXEC_ON_ELEMENT_NS_EDEFAULT;

	/**
	 * The default value of the '{@link #getInitVal() <em>Init Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitVal()
	 * @generated
	 * @ordered
	 */
	protected static final String INIT_VAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInitVal() <em>Init Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitVal()
	 * @generated
	 * @ordered
	 */
	protected String initVal = INIT_VAL_EDEFAULT;

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
	protected ExpressionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Javabean12Package.Literals.EXPRESSION_TYPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Javabean12Package.EXPRESSION_TYPE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExecOnElement() {
		return execOnElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecOnElement(String newExecOnElement) {
		String oldExecOnElement = execOnElement;
		execOnElement = newExecOnElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Javabean12Package.EXPRESSION_TYPE__EXEC_ON_ELEMENT, oldExecOnElement, execOnElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExecOnElementNS() {
		return execOnElementNS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecOnElementNS(String newExecOnElementNS) {
		String oldExecOnElementNS = execOnElementNS;
		execOnElementNS = newExecOnElementNS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Javabean12Package.EXPRESSION_TYPE__EXEC_ON_ELEMENT_NS, oldExecOnElementNS, execOnElementNS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInitVal() {
		return initVal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitVal(String newInitVal) {
		String oldInitVal = initVal;
		initVal = newInitVal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Javabean12Package.EXPRESSION_TYPE__INIT_VAL, oldInitVal, initVal));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Javabean12Package.EXPRESSION_TYPE__PROPERTY, oldProperty, property));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Javabean12Package.EXPRESSION_TYPE__SETTER_METHOD, oldSetterMethod, setterMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Javabean12Package.EXPRESSION_TYPE__VALUE:
				return getValue();
			case Javabean12Package.EXPRESSION_TYPE__EXEC_ON_ELEMENT:
				return getExecOnElement();
			case Javabean12Package.EXPRESSION_TYPE__EXEC_ON_ELEMENT_NS:
				return getExecOnElementNS();
			case Javabean12Package.EXPRESSION_TYPE__INIT_VAL:
				return getInitVal();
			case Javabean12Package.EXPRESSION_TYPE__PROPERTY:
				return getProperty();
			case Javabean12Package.EXPRESSION_TYPE__SETTER_METHOD:
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
			case Javabean12Package.EXPRESSION_TYPE__VALUE:
				setValue((String)newValue);
				return;
			case Javabean12Package.EXPRESSION_TYPE__EXEC_ON_ELEMENT:
				setExecOnElement((String)newValue);
				return;
			case Javabean12Package.EXPRESSION_TYPE__EXEC_ON_ELEMENT_NS:
				setExecOnElementNS((String)newValue);
				return;
			case Javabean12Package.EXPRESSION_TYPE__INIT_VAL:
				setInitVal((String)newValue);
				return;
			case Javabean12Package.EXPRESSION_TYPE__PROPERTY:
				setProperty((String)newValue);
				return;
			case Javabean12Package.EXPRESSION_TYPE__SETTER_METHOD:
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
			case Javabean12Package.EXPRESSION_TYPE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case Javabean12Package.EXPRESSION_TYPE__EXEC_ON_ELEMENT:
				setExecOnElement(EXEC_ON_ELEMENT_EDEFAULT);
				return;
			case Javabean12Package.EXPRESSION_TYPE__EXEC_ON_ELEMENT_NS:
				setExecOnElementNS(EXEC_ON_ELEMENT_NS_EDEFAULT);
				return;
			case Javabean12Package.EXPRESSION_TYPE__INIT_VAL:
				setInitVal(INIT_VAL_EDEFAULT);
				return;
			case Javabean12Package.EXPRESSION_TYPE__PROPERTY:
				setProperty(PROPERTY_EDEFAULT);
				return;
			case Javabean12Package.EXPRESSION_TYPE__SETTER_METHOD:
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
			case Javabean12Package.EXPRESSION_TYPE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case Javabean12Package.EXPRESSION_TYPE__EXEC_ON_ELEMENT:
				return EXEC_ON_ELEMENT_EDEFAULT == null ? execOnElement != null : !EXEC_ON_ELEMENT_EDEFAULT.equals(execOnElement);
			case Javabean12Package.EXPRESSION_TYPE__EXEC_ON_ELEMENT_NS:
				return EXEC_ON_ELEMENT_NS_EDEFAULT == null ? execOnElementNS != null : !EXEC_ON_ELEMENT_NS_EDEFAULT.equals(execOnElementNS);
			case Javabean12Package.EXPRESSION_TYPE__INIT_VAL:
				return INIT_VAL_EDEFAULT == null ? initVal != null : !INIT_VAL_EDEFAULT.equals(initVal);
			case Javabean12Package.EXPRESSION_TYPE__PROPERTY:
				return PROPERTY_EDEFAULT == null ? property != null : !PROPERTY_EDEFAULT.equals(property);
			case Javabean12Package.EXPRESSION_TYPE__SETTER_METHOD:
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
		result.append(" (value: "); //$NON-NLS-1$
		result.append(value);
		result.append(", execOnElement: "); //$NON-NLS-1$
		result.append(execOnElement);
		result.append(", execOnElementNS: "); //$NON-NLS-1$
		result.append(execOnElementNS);
		result.append(", initVal: "); //$NON-NLS-1$
		result.append(initVal);
		result.append(", property: "); //$NON-NLS-1$
		result.append(property);
		result.append(", setterMethod: "); //$NON-NLS-1$
		result.append(setterMethod);
		result.append(')');
		return result.toString();
	}

} //ExpressionTypeImpl
