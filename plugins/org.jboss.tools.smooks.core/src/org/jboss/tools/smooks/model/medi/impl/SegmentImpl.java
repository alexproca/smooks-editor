/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.medi.impl;


import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.jboss.tools.smooks.model.medi.MEdiPackage;
import org.jboss.tools.smooks.model.medi.Field;
import org.jboss.tools.smooks.model.medi.Segment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Segment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.medi.impl.SegmentImpl#getField <em>Field</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.medi.impl.SegmentImpl#getSegment <em>Segment</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.medi.impl.SegmentImpl#getMaxOccurs <em>Max Occurs</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.medi.impl.SegmentImpl#getMinOccurs <em>Min Occurs</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.medi.impl.SegmentImpl#getSegcode <em>Segcode</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.medi.impl.SegmentImpl#isTruncatable <em>Truncatable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SegmentImpl extends MappingNodeImpl implements Segment {
	/**
	 * The cached value of the '{@link #getField() <em>Field</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField()
	 * @generated
	 * @ordered
	 */
	protected EList<Field> field;

	/**
	 * The cached value of the '{@link #getSegment() <em>Segment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSegment()
	 * @generated
	 * @ordered
	 */
	protected EList<Segment> segment;

	/**
	 * The default value of the '{@link #getMaxOccurs() <em>Max Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxOccurs()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_OCCURS_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getMaxOccurs() <em>Max Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxOccurs()
	 * @generated
	 * @ordered
	 */
	protected int maxOccurs = MAX_OCCURS_EDEFAULT;

	/**
	 * This is true if the Max Occurs attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean maxOccursESet;

	/**
	 * The default value of the '{@link #getMinOccurs() <em>Min Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinOccurs()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_OCCURS_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getMinOccurs() <em>Min Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinOccurs()
	 * @generated
	 * @ordered
	 */
	protected int minOccurs = MIN_OCCURS_EDEFAULT;

	/**
	 * This is true if the Min Occurs attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean minOccursESet;

	/**
	 * The default value of the '{@link #getSegcode() <em>Segcode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSegcode()
	 * @generated
	 * @ordered
	 */
	protected static final String SEGCODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSegcode() <em>Segcode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSegcode()
	 * @generated
	 * @ordered
	 */
	protected String segcode = SEGCODE_EDEFAULT;

	/**
	 * The default value of the '{@link #isTruncatable() <em>Truncatable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTruncatable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRUNCATABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTruncatable() <em>Truncatable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTruncatable()
	 * @generated
	 * @ordered
	 */
	protected boolean truncatable = TRUNCATABLE_EDEFAULT;

	/**
	 * This is true if the Truncatable attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean truncatableESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SegmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MEdiPackage.Literals.SEGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Field> getField() {
		if (field == null) {
			field = new EObjectContainmentEList<Field>(Field.class, this, MEdiPackage.SEGMENT__FIELD);
		}
		return field;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Segment> getSegment() {
		if (segment == null) {
			segment = new EObjectContainmentEList<Segment>(Segment.class, this, MEdiPackage.SEGMENT__SEGMENT);
		}
		return segment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxOccurs() {
		return maxOccurs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxOccurs(int newMaxOccurs) {
		int oldMaxOccurs = maxOccurs;
		maxOccurs = newMaxOccurs;
		boolean oldMaxOccursESet = maxOccursESet;
		maxOccursESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MEdiPackage.SEGMENT__MAX_OCCURS, oldMaxOccurs, maxOccurs, !oldMaxOccursESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaxOccurs() {
		int oldMaxOccurs = maxOccurs;
		boolean oldMaxOccursESet = maxOccursESet;
		maxOccurs = MAX_OCCURS_EDEFAULT;
		maxOccursESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MEdiPackage.SEGMENT__MAX_OCCURS, oldMaxOccurs, MAX_OCCURS_EDEFAULT, oldMaxOccursESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaxOccurs() {
		return maxOccursESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMinOccurs() {
		return minOccurs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinOccurs(int newMinOccurs) {
		int oldMinOccurs = minOccurs;
		minOccurs = newMinOccurs;
		boolean oldMinOccursESet = minOccursESet;
		minOccursESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MEdiPackage.SEGMENT__MIN_OCCURS, oldMinOccurs, minOccurs, !oldMinOccursESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinOccurs() {
		int oldMinOccurs = minOccurs;
		boolean oldMinOccursESet = minOccursESet;
		minOccurs = MIN_OCCURS_EDEFAULT;
		minOccursESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MEdiPackage.SEGMENT__MIN_OCCURS, oldMinOccurs, MIN_OCCURS_EDEFAULT, oldMinOccursESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinOccurs() {
		return minOccursESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSegcode() {
		return segcode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSegcode(String newSegcode) {
		String oldSegcode = segcode;
		segcode = newSegcode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MEdiPackage.SEGMENT__SEGCODE, oldSegcode, segcode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTruncatable() {
		return truncatable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTruncatable(boolean newTruncatable) {
		boolean oldTruncatable = truncatable;
		truncatable = newTruncatable;
		boolean oldTruncatableESet = truncatableESet;
		truncatableESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MEdiPackage.SEGMENT__TRUNCATABLE, oldTruncatable, truncatable, !oldTruncatableESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTruncatable() {
		boolean oldTruncatable = truncatable;
		boolean oldTruncatableESet = truncatableESet;
		truncatable = TRUNCATABLE_EDEFAULT;
		truncatableESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MEdiPackage.SEGMENT__TRUNCATABLE, oldTruncatable, TRUNCATABLE_EDEFAULT, oldTruncatableESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTruncatable() {
		return truncatableESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MEdiPackage.SEGMENT__FIELD:
				return ((InternalEList<?>)getField()).basicRemove(otherEnd, msgs);
			case MEdiPackage.SEGMENT__SEGMENT:
				return ((InternalEList<?>)getSegment()).basicRemove(otherEnd, msgs);
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
			case MEdiPackage.SEGMENT__FIELD:
				return getField();
			case MEdiPackage.SEGMENT__SEGMENT:
				return getSegment();
			case MEdiPackage.SEGMENT__MAX_OCCURS:
				return new Integer(getMaxOccurs());
			case MEdiPackage.SEGMENT__MIN_OCCURS:
				return new Integer(getMinOccurs());
			case MEdiPackage.SEGMENT__SEGCODE:
				return getSegcode();
			case MEdiPackage.SEGMENT__TRUNCATABLE:
				return isTruncatable() ? Boolean.TRUE : Boolean.FALSE;
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
			case MEdiPackage.SEGMENT__FIELD:
				getField().clear();
				getField().addAll((Collection<? extends Field>)newValue);
				return;
			case MEdiPackage.SEGMENT__SEGMENT:
				getSegment().clear();
				getSegment().addAll((Collection<? extends Segment>)newValue);
				return;
			case MEdiPackage.SEGMENT__MAX_OCCURS:
				setMaxOccurs(((Integer)newValue).intValue());
				return;
			case MEdiPackage.SEGMENT__MIN_OCCURS:
				setMinOccurs(((Integer)newValue).intValue());
				return;
			case MEdiPackage.SEGMENT__SEGCODE:
				setSegcode((String)newValue);
				return;
			case MEdiPackage.SEGMENT__TRUNCATABLE:
				setTruncatable(((Boolean)newValue).booleanValue());
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
			case MEdiPackage.SEGMENT__FIELD:
				getField().clear();
				return;
			case MEdiPackage.SEGMENT__SEGMENT:
				getSegment().clear();
				return;
			case MEdiPackage.SEGMENT__MAX_OCCURS:
				unsetMaxOccurs();
				return;
			case MEdiPackage.SEGMENT__MIN_OCCURS:
				unsetMinOccurs();
				return;
			case MEdiPackage.SEGMENT__SEGCODE:
				setSegcode(SEGCODE_EDEFAULT);
				return;
			case MEdiPackage.SEGMENT__TRUNCATABLE:
				unsetTruncatable();
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
			case MEdiPackage.SEGMENT__FIELD:
				return field != null && !field.isEmpty();
			case MEdiPackage.SEGMENT__SEGMENT:
				return segment != null && !segment.isEmpty();
			case MEdiPackage.SEGMENT__MAX_OCCURS:
				return isSetMaxOccurs();
			case MEdiPackage.SEGMENT__MIN_OCCURS:
				return isSetMinOccurs();
			case MEdiPackage.SEGMENT__SEGCODE:
				return SEGCODE_EDEFAULT == null ? segcode != null : !SEGCODE_EDEFAULT.equals(segcode);
			case MEdiPackage.SEGMENT__TRUNCATABLE:
				return isSetTruncatable();
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
		result.append(" (maxOccurs: "); //$NON-NLS-1$
		if (maxOccursESet) result.append(maxOccurs); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", minOccurs: "); //$NON-NLS-1$
		if (minOccursESet) result.append(minOccurs); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", segcode: "); //$NON-NLS-1$
		result.append(segcode);
		result.append(", truncatable: "); //$NON-NLS-1$
		if (truncatableESet) result.append(truncatable); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //SegmentImpl
