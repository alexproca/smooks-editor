/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.medi.impl;



import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.jboss.tools.smooks.model.common.impl.AbstractAnyTypeImpl;
import org.jboss.tools.smooks.model.medi.Delimiters;
import org.jboss.tools.smooks.model.medi.Description;
import org.jboss.tools.smooks.model.medi.EdiMap;
import org.jboss.tools.smooks.model.medi.MEdiPackage;
import org.jboss.tools.smooks.model.medi.Segments;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Map</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.medi.impl.EdiMapImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.medi.impl.EdiMapImpl#getDelimiters <em>Delimiters</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.medi.impl.EdiMapImpl#getSegments <em>Segments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EdiMapImpl extends AbstractAnyTypeImpl implements EdiMap {
	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected Description description;

	/**
	 * The cached value of the '{@link #getDelimiters() <em>Delimiters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelimiters()
	 * @generated
	 * @ordered
	 */
	protected Delimiters delimiters;

	/**
	 * The cached value of the '{@link #getSegments() <em>Segments</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSegments()
	 * @generated
	 * @ordered
	 */
	protected Segments segments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdiMapImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MEdiPackage.Literals.EDI_MAP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Description getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescription(Description newDescription, NotificationChain msgs) {
		Description oldDescription = description;
		description = newDescription;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MEdiPackage.EDI_MAP__DESCRIPTION, oldDescription, newDescription);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(Description newDescription) {
		if (newDescription != description) {
			NotificationChain msgs = null;
			if (description != null)
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MEdiPackage.EDI_MAP__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MEdiPackage.EDI_MAP__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MEdiPackage.EDI_MAP__DESCRIPTION, newDescription, newDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Delimiters getDelimiters() {
		return delimiters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDelimiters(Delimiters newDelimiters, NotificationChain msgs) {
		Delimiters oldDelimiters = delimiters;
		delimiters = newDelimiters;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MEdiPackage.EDI_MAP__DELIMITERS, oldDelimiters, newDelimiters);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelimiters(Delimiters newDelimiters) {
		if (newDelimiters != delimiters) {
			NotificationChain msgs = null;
			if (delimiters != null)
				msgs = ((InternalEObject)delimiters).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MEdiPackage.EDI_MAP__DELIMITERS, null, msgs);
			if (newDelimiters != null)
				msgs = ((InternalEObject)newDelimiters).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MEdiPackage.EDI_MAP__DELIMITERS, null, msgs);
			msgs = basicSetDelimiters(newDelimiters, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MEdiPackage.EDI_MAP__DELIMITERS, newDelimiters, newDelimiters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Segments getSegments() {
		return segments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSegments(Segments newSegments, NotificationChain msgs) {
		Segments oldSegments = segments;
		segments = newSegments;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MEdiPackage.EDI_MAP__SEGMENTS, oldSegments, newSegments);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSegments(Segments newSegments) {
		if (newSegments != segments) {
			NotificationChain msgs = null;
			if (segments != null)
				msgs = ((InternalEObject)segments).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MEdiPackage.EDI_MAP__SEGMENTS, null, msgs);
			if (newSegments != null)
				msgs = ((InternalEObject)newSegments).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MEdiPackage.EDI_MAP__SEGMENTS, null, msgs);
			msgs = basicSetSegments(newSegments, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MEdiPackage.EDI_MAP__SEGMENTS, newSegments, newSegments));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MEdiPackage.EDI_MAP__DESCRIPTION:
				return basicSetDescription(null, msgs);
			case MEdiPackage.EDI_MAP__DELIMITERS:
				return basicSetDelimiters(null, msgs);
			case MEdiPackage.EDI_MAP__SEGMENTS:
				return basicSetSegments(null, msgs);
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
			case MEdiPackage.EDI_MAP__DESCRIPTION:
				return getDescription();
			case MEdiPackage.EDI_MAP__DELIMITERS:
				return getDelimiters();
			case MEdiPackage.EDI_MAP__SEGMENTS:
				return getSegments();
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
			case MEdiPackage.EDI_MAP__DESCRIPTION:
				setDescription((Description)newValue);
				return;
			case MEdiPackage.EDI_MAP__DELIMITERS:
				setDelimiters((Delimiters)newValue);
				return;
			case MEdiPackage.EDI_MAP__SEGMENTS:
				setSegments((Segments)newValue);
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
			case MEdiPackage.EDI_MAP__DESCRIPTION:
				setDescription((Description)null);
				return;
			case MEdiPackage.EDI_MAP__DELIMITERS:
				setDelimiters((Delimiters)null);
				return;
			case MEdiPackage.EDI_MAP__SEGMENTS:
				setSegments((Segments)null);
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
			case MEdiPackage.EDI_MAP__DESCRIPTION:
				return description != null;
			case MEdiPackage.EDI_MAP__DELIMITERS:
				return delimiters != null;
			case MEdiPackage.EDI_MAP__SEGMENTS:
				return segments != null;
		}
		return super.eIsSet(featureID);
	}

} //EdiMapImpl
