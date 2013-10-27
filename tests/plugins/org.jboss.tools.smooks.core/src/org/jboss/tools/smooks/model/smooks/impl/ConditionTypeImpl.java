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
import org.jboss.tools.smooks.model.smooks.ConditionType;
import org.jboss.tools.smooks.model.smooks.SmooksPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Condition Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.ConditionTypeImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.ConditionTypeImpl#getEvaluator <em>Evaluator</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.ConditionTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.smooks.impl.ConditionTypeImpl#getIdRef <em>Id Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionTypeImpl extends AbstractAnyTypeImpl implements ConditionType {
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
	 * The default value of the '{@link #getEvaluator() <em>Evaluator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvaluator()
	 * @generated
	 * @ordered
	 */
	protected static final String EVALUATOR_EDEFAULT = "org.milyn.javabean.expression.BeanMapExpressionEvaluator"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getEvaluator() <em>Evaluator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvaluator()
	 * @generated
	 * @ordered
	 */
	protected String evaluator = EVALUATOR_EDEFAULT;

	/**
	 * This is true if the Evaluator attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean evaluatorESet;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getIdRef() <em>Id Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdRef()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdRef() <em>Id Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdRef()
	 * @generated
	 * @ordered
	 */
	protected String idRef = ID_REF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmooksPackage.Literals.CONDITION_TYPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SmooksPackage.CONDITION_TYPE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEvaluator() {
		return evaluator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvaluator(String newEvaluator) {
		String oldEvaluator = evaluator;
		evaluator = newEvaluator;
		boolean oldEvaluatorESet = evaluatorESet;
		evaluatorESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmooksPackage.CONDITION_TYPE__EVALUATOR, oldEvaluator, evaluator, !oldEvaluatorESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEvaluator() {
		String oldEvaluator = evaluator;
		boolean oldEvaluatorESet = evaluatorESet;
		evaluator = EVALUATOR_EDEFAULT;
		evaluatorESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, SmooksPackage.CONDITION_TYPE__EVALUATOR, oldEvaluator, EVALUATOR_EDEFAULT, oldEvaluatorESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEvaluator() {
		return evaluatorESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmooksPackage.CONDITION_TYPE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdRef() {
		return idRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdRef(String newIdRef) {
		String oldIdRef = idRef;
		idRef = newIdRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmooksPackage.CONDITION_TYPE__ID_REF, oldIdRef, idRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SmooksPackage.CONDITION_TYPE__VALUE:
				return getValue();
			case SmooksPackage.CONDITION_TYPE__EVALUATOR:
				return getEvaluator();
			case SmooksPackage.CONDITION_TYPE__ID:
				return getId();
			case SmooksPackage.CONDITION_TYPE__ID_REF:
				return getIdRef();
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
			case SmooksPackage.CONDITION_TYPE__VALUE:
				setValue((String)newValue);
				return;
			case SmooksPackage.CONDITION_TYPE__EVALUATOR:
				setEvaluator((String)newValue);
				return;
			case SmooksPackage.CONDITION_TYPE__ID:
				setId((String)newValue);
				return;
			case SmooksPackage.CONDITION_TYPE__ID_REF:
				setIdRef((String)newValue);
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
			case SmooksPackage.CONDITION_TYPE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case SmooksPackage.CONDITION_TYPE__EVALUATOR:
				unsetEvaluator();
				return;
			case SmooksPackage.CONDITION_TYPE__ID:
				setId(ID_EDEFAULT);
				return;
			case SmooksPackage.CONDITION_TYPE__ID_REF:
				setIdRef(ID_REF_EDEFAULT);
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
			case SmooksPackage.CONDITION_TYPE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case SmooksPackage.CONDITION_TYPE__EVALUATOR:
				return isSetEvaluator();
			case SmooksPackage.CONDITION_TYPE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SmooksPackage.CONDITION_TYPE__ID_REF:
				return ID_REF_EDEFAULT == null ? idRef != null : !ID_REF_EDEFAULT.equals(idRef);
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
		result.append(", evaluator: "); //$NON-NLS-1$
		if (evaluatorESet) result.append(evaluator); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", id: "); //$NON-NLS-1$
		result.append(id);
		result.append(", idRef: "); //$NON-NLS-1$
		result.append(idRef);
		result.append(')');
		return result.toString();
	}

} //ConditionTypeImpl
