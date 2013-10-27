/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.medi.impl;



import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.jboss.tools.smooks.model.common.impl.AbstractAnyTypeImpl;
import org.jboss.tools.smooks.model.medi.Delimiters;
import org.jboss.tools.smooks.model.medi.MEdiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delimiters</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.medi.impl.DelimitersImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.medi.impl.DelimitersImpl#getField <em>Field</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.medi.impl.DelimitersImpl#getSegment <em>Segment</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.medi.impl.DelimitersImpl#getSubComponent <em>Sub Component</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DelimitersImpl extends AbstractAnyTypeImpl implements Delimiters {
	/**
	 * The default value of the '{@link #getComponent() <em>Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponent()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPONENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComponent() <em>Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponent()
	 * @generated
	 * @ordered
	 */
	protected String component = COMPONENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getField() <em>Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField()
	 * @generated
	 * @ordered
	 */
	protected static final String FIELD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getField() <em>Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField()
	 * @generated
	 * @ordered
	 */
	protected String field = FIELD_EDEFAULT;

	/**
	 * The default value of the '{@link #getSegment() <em>Segment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSegment()
	 * @generated
	 * @ordered
	 */
	protected static final String SEGMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSegment() <em>Segment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSegment()
	 * @generated
	 * @ordered
	 */
	protected String segment = SEGMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSubComponent() <em>Sub Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubComponent()
	 * @generated
	 * @ordered
	 */
	protected static final String SUB_COMPONENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubComponent() <em>Sub Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubComponent()
	 * @generated
	 * @ordered
	 */
	protected String subComponent = SUB_COMPONENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DelimitersImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MEdiPackage.Literals.DELIMITERS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComponent() {
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponent(String newComponent) {
		String oldComponent = component;
		component = newComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MEdiPackage.DELIMITERS__COMPONENT, oldComponent, component));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getField() {
		return field;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setField(String newField) {
		String oldField = field;
		field = newField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MEdiPackage.DELIMITERS__FIELD, oldField, field));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSegment() {
		return segment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSegment(String newSegment) {
		String oldSegment = segment;
		segment = newSegment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MEdiPackage.DELIMITERS__SEGMENT, oldSegment, segment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubComponent() {
		return subComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubComponent(String newSubComponent) {
		String oldSubComponent = subComponent;
		subComponent = newSubComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MEdiPackage.DELIMITERS__SUB_COMPONENT, oldSubComponent, subComponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MEdiPackage.DELIMITERS__COMPONENT:
				return getComponent();
			case MEdiPackage.DELIMITERS__FIELD:
				return getField();
			case MEdiPackage.DELIMITERS__SEGMENT:
				return getSegment();
			case MEdiPackage.DELIMITERS__SUB_COMPONENT:
				return getSubComponent();
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
			case MEdiPackage.DELIMITERS__COMPONENT:
				setComponent((String)newValue);
				return;
			case MEdiPackage.DELIMITERS__FIELD:
				setField((String)newValue);
				return;
			case MEdiPackage.DELIMITERS__SEGMENT:
				setSegment((String)newValue);
				return;
			case MEdiPackage.DELIMITERS__SUB_COMPONENT:
				setSubComponent((String)newValue);
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
			case MEdiPackage.DELIMITERS__COMPONENT:
				setComponent(COMPONENT_EDEFAULT);
				return;
			case MEdiPackage.DELIMITERS__FIELD:
				setField(FIELD_EDEFAULT);
				return;
			case MEdiPackage.DELIMITERS__SEGMENT:
				setSegment(SEGMENT_EDEFAULT);
				return;
			case MEdiPackage.DELIMITERS__SUB_COMPONENT:
				setSubComponent(SUB_COMPONENT_EDEFAULT);
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
			case MEdiPackage.DELIMITERS__COMPONENT:
				return COMPONENT_EDEFAULT == null ? component != null : !COMPONENT_EDEFAULT.equals(component);
			case MEdiPackage.DELIMITERS__FIELD:
				return FIELD_EDEFAULT == null ? field != null : !FIELD_EDEFAULT.equals(field);
			case MEdiPackage.DELIMITERS__SEGMENT:
				return SEGMENT_EDEFAULT == null ? segment != null : !SEGMENT_EDEFAULT.equals(segment);
			case MEdiPackage.DELIMITERS__SUB_COMPONENT:
				return SUB_COMPONENT_EDEFAULT == null ? subComponent != null : !SUB_COMPONENT_EDEFAULT.equals(subComponent);
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
		result.append(" (component: "); //$NON-NLS-1$
		result.append(component);
		result.append(", field: "); //$NON-NLS-1$
		result.append(field);
		result.append(", segment: "); //$NON-NLS-1$
		result.append(segment);
		result.append(", subComponent: "); //$NON-NLS-1$
		result.append(subComponent);
		result.append(')');
		return result.toString();
	}

} //DelimitersImpl
