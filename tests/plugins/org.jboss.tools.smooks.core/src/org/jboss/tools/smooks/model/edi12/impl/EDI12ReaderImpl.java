/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.edi12.impl;


import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.jboss.tools.smooks.model.edi12.EDI12Reader;
import org.jboss.tools.smooks.model.edi12.Edi12Package;
import org.jboss.tools.smooks.model.smooks.impl.AbstractReaderImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EDI12 Reader</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.edi12.impl.EDI12ReaderImpl#getEncoding <em>Encoding</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.edi12.impl.EDI12ReaderImpl#getMappingModel <em>Mapping Model</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.edi12.impl.EDI12ReaderImpl#isValidate <em>Validate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EDI12ReaderImpl extends AbstractReaderImpl implements EDI12Reader {
	/**
	 * The default value of the '{@link #getEncoding() <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEncoding()
	 * @generated
	 * @ordered
	 */
	protected static final String ENCODING_EDEFAULT = "UTF-8"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getEncoding() <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEncoding()
	 * @generated
	 * @ordered
	 */
	protected String encoding = ENCODING_EDEFAULT;

	/**
	 * This is true if the Encoding attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean encodingESet;

	/**
	 * The default value of the '{@link #getMappingModel() <em>Mapping Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingModel()
	 * @generated
	 * @ordered
	 */
	protected static final String MAPPING_MODEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMappingModel() <em>Mapping Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingModel()
	 * @generated
	 * @ordered
	 */
	protected String mappingModel = MAPPING_MODEL_EDEFAULT;

	/**
	 * The default value of the '{@link #isValidate() <em>Validate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValidate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VALIDATE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isValidate() <em>Validate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValidate()
	 * @generated
	 * @ordered
	 */
	protected boolean validate = VALIDATE_EDEFAULT;

	/**
	 * This is true if the Validate attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean validateESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EDI12ReaderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Edi12Package.Literals.EDI12_READER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEncoding(String newEncoding) {
		String oldEncoding = encoding;
		encoding = newEncoding;
		boolean oldEncodingESet = encodingESet;
		encodingESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Edi12Package.EDI12_READER__ENCODING, oldEncoding, encoding, !oldEncodingESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEncoding() {
		String oldEncoding = encoding;
		boolean oldEncodingESet = encodingESet;
		encoding = ENCODING_EDEFAULT;
		encodingESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Edi12Package.EDI12_READER__ENCODING, oldEncoding, ENCODING_EDEFAULT, oldEncodingESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEncoding() {
		return encodingESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMappingModel() {
		return mappingModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingModel(String newMappingModel) {
		String oldMappingModel = mappingModel;
		mappingModel = newMappingModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Edi12Package.EDI12_READER__MAPPING_MODEL, oldMappingModel, mappingModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isValidate() {
		return validate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidate(boolean newValidate) {
		boolean oldValidate = validate;
		validate = newValidate;
		boolean oldValidateESet = validateESet;
		validateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Edi12Package.EDI12_READER__VALIDATE, oldValidate, validate, !oldValidateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetValidate() {
		boolean oldValidate = validate;
		boolean oldValidateESet = validateESet;
		validate = VALIDATE_EDEFAULT;
		validateESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Edi12Package.EDI12_READER__VALIDATE, oldValidate, VALIDATE_EDEFAULT, oldValidateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetValidate() {
		return validateESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Edi12Package.EDI12_READER__ENCODING:
				return getEncoding();
			case Edi12Package.EDI12_READER__MAPPING_MODEL:
				return getMappingModel();
			case Edi12Package.EDI12_READER__VALIDATE:
				return isValidate() ? Boolean.TRUE : Boolean.FALSE;
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
			case Edi12Package.EDI12_READER__ENCODING:
				setEncoding((String)newValue);
				return;
			case Edi12Package.EDI12_READER__MAPPING_MODEL:
				setMappingModel((String)newValue);
				return;
			case Edi12Package.EDI12_READER__VALIDATE:
				setValidate(((Boolean)newValue).booleanValue());
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
			case Edi12Package.EDI12_READER__ENCODING:
				unsetEncoding();
				return;
			case Edi12Package.EDI12_READER__MAPPING_MODEL:
				setMappingModel(MAPPING_MODEL_EDEFAULT);
				return;
			case Edi12Package.EDI12_READER__VALIDATE:
				unsetValidate();
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
			case Edi12Package.EDI12_READER__ENCODING:
				return isSetEncoding();
			case Edi12Package.EDI12_READER__MAPPING_MODEL:
				return MAPPING_MODEL_EDEFAULT == null ? mappingModel != null : !MAPPING_MODEL_EDEFAULT.equals(mappingModel);
			case Edi12Package.EDI12_READER__VALIDATE:
				return isSetValidate();
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
		result.append(" (encoding: "); //$NON-NLS-1$
		if (encodingESet) result.append(encoding); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", mappingModel: "); //$NON-NLS-1$
		result.append(mappingModel);
		result.append(", validate: "); //$NON-NLS-1$
		if (validateESet) result.append(validate); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //EDI12ReaderImpl
