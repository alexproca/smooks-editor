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
import org.jboss.tools.smooks.model.medi.MEdiPackage;
import org.jboss.tools.smooks.model.medi.MappingNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.medi.impl.MappingNodeImpl#getXmltag <em>Xmltag</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingNodeImpl extends AbstractAnyTypeImpl implements MappingNode {
	/**
	 * The default value of the '{@link #getXmltag() <em>Xmltag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXmltag()
	 * @generated
	 * @ordered
	 */
	protected static final String XMLTAG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXmltag() <em>Xmltag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXmltag()
	 * @generated
	 * @ordered
	 */
	protected String xmltag = XMLTAG_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MEdiPackage.Literals.MAPPING_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXmltag() {
		return xmltag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXmltag(String newXmltag) {
		String oldXmltag = xmltag;
		xmltag = newXmltag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MEdiPackage.MAPPING_NODE__XMLTAG, oldXmltag, xmltag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MEdiPackage.MAPPING_NODE__XMLTAG:
				return getXmltag();
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
			case MEdiPackage.MAPPING_NODE__XMLTAG:
				setXmltag((String)newValue);
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
			case MEdiPackage.MAPPING_NODE__XMLTAG:
				setXmltag(XMLTAG_EDEFAULT);
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
			case MEdiPackage.MAPPING_NODE__XMLTAG:
				return XMLTAG_EDEFAULT == null ? xmltag != null : !XMLTAG_EDEFAULT.equals(xmltag);
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
		result.append(" (xmltag: "); //$NON-NLS-1$
		result.append(xmltag);
		result.append(')');
		return result.toString();
	}

} //MappingNodeImpl
