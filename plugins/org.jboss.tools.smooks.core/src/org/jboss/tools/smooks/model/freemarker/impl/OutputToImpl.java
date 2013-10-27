/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.freemarker.impl;



import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.jboss.tools.smooks.model.common.impl.AbstractAnyTypeImpl;
import org.jboss.tools.smooks.model.freemarker.FreemarkerPackage;
import org.jboss.tools.smooks.model.freemarker.OutputTo;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Output To</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.freemarker.impl.OutputToImpl#getOutputStreamResource <em>Output Stream Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutputToImpl extends AbstractAnyTypeImpl implements OutputTo {
	/**
	 * The default value of the '{@link #getOutputStreamResource() <em>Output Stream Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputStreamResource()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTPUT_STREAM_RESOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutputStreamResource() <em>Output Stream Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputStreamResource()
	 * @generated
	 * @ordered
	 */
	protected String outputStreamResource = OUTPUT_STREAM_RESOURCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutputToImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FreemarkerPackage.Literals.OUTPUT_TO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutputStreamResource() {
		return outputStreamResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputStreamResource(String newOutputStreamResource) {
		String oldOutputStreamResource = outputStreamResource;
		outputStreamResource = newOutputStreamResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FreemarkerPackage.OUTPUT_TO__OUTPUT_STREAM_RESOURCE, oldOutputStreamResource, outputStreamResource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FreemarkerPackage.OUTPUT_TO__OUTPUT_STREAM_RESOURCE:
				return getOutputStreamResource();
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
			case FreemarkerPackage.OUTPUT_TO__OUTPUT_STREAM_RESOURCE:
				setOutputStreamResource((String)newValue);
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
			case FreemarkerPackage.OUTPUT_TO__OUTPUT_STREAM_RESOURCE:
				setOutputStreamResource(OUTPUT_STREAM_RESOURCE_EDEFAULT);
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
			case FreemarkerPackage.OUTPUT_TO__OUTPUT_STREAM_RESOURCE:
				return OUTPUT_STREAM_RESOURCE_EDEFAULT == null ? outputStreamResource != null : !OUTPUT_STREAM_RESOURCE_EDEFAULT.equals(outputStreamResource);
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
		result.append(" (outputStreamResource: "); //$NON-NLS-1$
		result.append(outputStreamResource);
		result.append(')');
		return result.toString();
	}

} //OutputToImpl
