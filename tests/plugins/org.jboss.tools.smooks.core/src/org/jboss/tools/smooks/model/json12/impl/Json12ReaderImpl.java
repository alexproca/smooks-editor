/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.json12.impl;


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.jboss.tools.smooks.model.json12.Json12Factory;
import org.jboss.tools.smooks.model.json12.Json12Package;
import org.jboss.tools.smooks.model.json12.Json12Reader;
import org.jboss.tools.smooks.model.json12.KeyMap;
import org.jboss.tools.smooks.model.smooks.impl.AbstractReaderImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reader</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.json12.impl.Json12ReaderImpl#getKeyMap <em>Key Map</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.json12.impl.Json12ReaderImpl#getArrayElementName <em>Array Element Name</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.json12.impl.Json12ReaderImpl#getEncoding <em>Encoding</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.json12.impl.Json12ReaderImpl#getIllegalElementNameCharReplacement <em>Illegal Element Name Char Replacement</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.json12.impl.Json12ReaderImpl#isIndent <em>Indent</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.json12.impl.Json12ReaderImpl#getKeyPrefixOnNumeric <em>Key Prefix On Numeric</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.json12.impl.Json12ReaderImpl#getKeyWhitspaceReplacement <em>Key Whitspace Replacement</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.json12.impl.Json12ReaderImpl#getNullValueReplacement <em>Null Value Replacement</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.json12.impl.Json12ReaderImpl#getRootName <em>Root Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Json12ReaderImpl extends AbstractReaderImpl implements Json12Reader {
	/**
	 * The cached value of the '{@link #getKeyMap() <em>Key Map</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyMap()
	 * @generated
	 * @ordered
	 */
	protected KeyMap keyMap;

	/**
	 * The default value of the '{@link #getArrayElementName() <em>Array Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrayElementName()
	 * @generated
	 * @ordered
	 */
	protected static final String ARRAY_ELEMENT_NAME_EDEFAULT = "element"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getArrayElementName() <em>Array Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrayElementName()
	 * @generated
	 * @ordered
	 */
	protected String arrayElementName = ARRAY_ELEMENT_NAME_EDEFAULT;

	/**
	 * This is true if the Array Element Name attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean arrayElementNameESet;

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
	 * The default value of the '{@link #getIllegalElementNameCharReplacement() <em>Illegal Element Name Char Replacement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIllegalElementNameCharReplacement()
	 * @generated
	 * @ordered
	 */
	protected static final String ILLEGAL_ELEMENT_NAME_CHAR_REPLACEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIllegalElementNameCharReplacement() <em>Illegal Element Name Char Replacement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIllegalElementNameCharReplacement()
	 * @generated
	 * @ordered
	 */
	protected String illegalElementNameCharReplacement = ILLEGAL_ELEMENT_NAME_CHAR_REPLACEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #isIndent() <em>Indent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIndent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INDENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIndent() <em>Indent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIndent()
	 * @generated
	 * @ordered
	 */
	protected boolean indent = INDENT_EDEFAULT;

	/**
	 * This is true if the Indent attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean indentESet;

	/**
	 * The default value of the '{@link #getKeyPrefixOnNumeric() <em>Key Prefix On Numeric</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyPrefixOnNumeric()
	 * @generated
	 * @ordered
	 */
	protected static final String KEY_PREFIX_ON_NUMERIC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKeyPrefixOnNumeric() <em>Key Prefix On Numeric</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyPrefixOnNumeric()
	 * @generated
	 * @ordered
	 */
	protected String keyPrefixOnNumeric = KEY_PREFIX_ON_NUMERIC_EDEFAULT;

	/**
	 * The default value of the '{@link #getKeyWhitspaceReplacement() <em>Key Whitspace Replacement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyWhitspaceReplacement()
	 * @generated
	 * @ordered
	 */
	protected static final String KEY_WHITSPACE_REPLACEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKeyWhitspaceReplacement() <em>Key Whitspace Replacement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyWhitspaceReplacement()
	 * @generated
	 * @ordered
	 */
	protected String keyWhitspaceReplacement = KEY_WHITSPACE_REPLACEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getNullValueReplacement() <em>Null Value Replacement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNullValueReplacement()
	 * @generated
	 * @ordered
	 */
	protected static final String NULL_VALUE_REPLACEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNullValueReplacement() <em>Null Value Replacement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNullValueReplacement()
	 * @generated
	 * @ordered
	 */
	protected String nullValueReplacement = NULL_VALUE_REPLACEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getRootName() <em>Root Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootName()
	 * @generated
	 * @ordered
	 */
	protected static final String ROOT_NAME_EDEFAULT = "json"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getRootName() <em>Root Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootName()
	 * @generated
	 * @ordered
	 */
	protected String rootName = ROOT_NAME_EDEFAULT;

	/**
	 * This is true if the Root Name attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean rootNameESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Json12ReaderImpl() {
		super();
		this.setKeyMap(Json12Factory.eINSTANCE.createKeyMap());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Json12Package.Literals.JSON12_READER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyMap getKeyMap() {
		return keyMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetKeyMap(KeyMap newKeyMap, NotificationChain msgs) {
		KeyMap oldKeyMap = keyMap;
		keyMap = newKeyMap;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Json12Package.JSON12_READER__KEY_MAP, oldKeyMap, newKeyMap);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeyMap(KeyMap newKeyMap) {
		if (newKeyMap != keyMap) {
			NotificationChain msgs = null;
			if (keyMap != null)
				msgs = ((InternalEObject)keyMap).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Json12Package.JSON12_READER__KEY_MAP, null, msgs);
			if (newKeyMap != null)
				msgs = ((InternalEObject)newKeyMap).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Json12Package.JSON12_READER__KEY_MAP, null, msgs);
			msgs = basicSetKeyMap(newKeyMap, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Json12Package.JSON12_READER__KEY_MAP, newKeyMap, newKeyMap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getArrayElementName() {
		return arrayElementName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArrayElementName(String newArrayElementName) {
		String oldArrayElementName = arrayElementName;
		arrayElementName = newArrayElementName;
		boolean oldArrayElementNameESet = arrayElementNameESet;
		arrayElementNameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Json12Package.JSON12_READER__ARRAY_ELEMENT_NAME, oldArrayElementName, arrayElementName, !oldArrayElementNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetArrayElementName() {
		String oldArrayElementName = arrayElementName;
		boolean oldArrayElementNameESet = arrayElementNameESet;
		arrayElementName = ARRAY_ELEMENT_NAME_EDEFAULT;
		arrayElementNameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Json12Package.JSON12_READER__ARRAY_ELEMENT_NAME, oldArrayElementName, ARRAY_ELEMENT_NAME_EDEFAULT, oldArrayElementNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetArrayElementName() {
		return arrayElementNameESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Json12Package.JSON12_READER__ENCODING, oldEncoding, encoding, !oldEncodingESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, Json12Package.JSON12_READER__ENCODING, oldEncoding, ENCODING_EDEFAULT, oldEncodingESet));
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
	public String getIllegalElementNameCharReplacement() {
		return illegalElementNameCharReplacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIllegalElementNameCharReplacement(String newIllegalElementNameCharReplacement) {
		String oldIllegalElementNameCharReplacement = illegalElementNameCharReplacement;
		illegalElementNameCharReplacement = newIllegalElementNameCharReplacement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Json12Package.JSON12_READER__ILLEGAL_ELEMENT_NAME_CHAR_REPLACEMENT, oldIllegalElementNameCharReplacement, illegalElementNameCharReplacement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIndent() {
		return indent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndent(boolean newIndent) {
		boolean oldIndent = indent;
		indent = newIndent;
		boolean oldIndentESet = indentESet;
		indentESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Json12Package.JSON12_READER__INDENT, oldIndent, indent, !oldIndentESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIndent() {
		boolean oldIndent = indent;
		boolean oldIndentESet = indentESet;
		indent = INDENT_EDEFAULT;
		indentESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Json12Package.JSON12_READER__INDENT, oldIndent, INDENT_EDEFAULT, oldIndentESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIndent() {
		return indentESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKeyPrefixOnNumeric() {
		return keyPrefixOnNumeric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeyPrefixOnNumeric(String newKeyPrefixOnNumeric) {
		String oldKeyPrefixOnNumeric = keyPrefixOnNumeric;
		keyPrefixOnNumeric = newKeyPrefixOnNumeric;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Json12Package.JSON12_READER__KEY_PREFIX_ON_NUMERIC, oldKeyPrefixOnNumeric, keyPrefixOnNumeric));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKeyWhitspaceReplacement() {
		return keyWhitspaceReplacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeyWhitspaceReplacement(String newKeyWhitspaceReplacement) {
		String oldKeyWhitspaceReplacement = keyWhitspaceReplacement;
		keyWhitspaceReplacement = newKeyWhitspaceReplacement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Json12Package.JSON12_READER__KEY_WHITSPACE_REPLACEMENT, oldKeyWhitspaceReplacement, keyWhitspaceReplacement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNullValueReplacement() {
		return nullValueReplacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNullValueReplacement(String newNullValueReplacement) {
		String oldNullValueReplacement = nullValueReplacement;
		nullValueReplacement = newNullValueReplacement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Json12Package.JSON12_READER__NULL_VALUE_REPLACEMENT, oldNullValueReplacement, nullValueReplacement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRootName() {
		return rootName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootName(String newRootName) {
		String oldRootName = rootName;
		rootName = newRootName;
		boolean oldRootNameESet = rootNameESet;
		rootNameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Json12Package.JSON12_READER__ROOT_NAME, oldRootName, rootName, !oldRootNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRootName() {
		String oldRootName = rootName;
		boolean oldRootNameESet = rootNameESet;
		rootName = ROOT_NAME_EDEFAULT;
		rootNameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Json12Package.JSON12_READER__ROOT_NAME, oldRootName, ROOT_NAME_EDEFAULT, oldRootNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRootName() {
		return rootNameESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Json12Package.JSON12_READER__KEY_MAP:
				return basicSetKeyMap(null, msgs);
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
			case Json12Package.JSON12_READER__KEY_MAP:
				return getKeyMap();
			case Json12Package.JSON12_READER__ARRAY_ELEMENT_NAME:
				return getArrayElementName();
			case Json12Package.JSON12_READER__ENCODING:
				return getEncoding();
			case Json12Package.JSON12_READER__ILLEGAL_ELEMENT_NAME_CHAR_REPLACEMENT:
				return getIllegalElementNameCharReplacement();
			case Json12Package.JSON12_READER__INDENT:
				return isIndent() ? Boolean.TRUE : Boolean.FALSE;
			case Json12Package.JSON12_READER__KEY_PREFIX_ON_NUMERIC:
				return getKeyPrefixOnNumeric();
			case Json12Package.JSON12_READER__KEY_WHITSPACE_REPLACEMENT:
				return getKeyWhitspaceReplacement();
			case Json12Package.JSON12_READER__NULL_VALUE_REPLACEMENT:
				return getNullValueReplacement();
			case Json12Package.JSON12_READER__ROOT_NAME:
				return getRootName();
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
			case Json12Package.JSON12_READER__KEY_MAP:
				setKeyMap((KeyMap)newValue);
				return;
			case Json12Package.JSON12_READER__ARRAY_ELEMENT_NAME:
				setArrayElementName((String)newValue);
				return;
			case Json12Package.JSON12_READER__ENCODING:
				setEncoding((String)newValue);
				return;
			case Json12Package.JSON12_READER__ILLEGAL_ELEMENT_NAME_CHAR_REPLACEMENT:
				setIllegalElementNameCharReplacement((String)newValue);
				return;
			case Json12Package.JSON12_READER__INDENT:
				setIndent(((Boolean)newValue).booleanValue());
				return;
			case Json12Package.JSON12_READER__KEY_PREFIX_ON_NUMERIC:
				setKeyPrefixOnNumeric((String)newValue);
				return;
			case Json12Package.JSON12_READER__KEY_WHITSPACE_REPLACEMENT:
				setKeyWhitspaceReplacement((String)newValue);
				return;
			case Json12Package.JSON12_READER__NULL_VALUE_REPLACEMENT:
				setNullValueReplacement((String)newValue);
				return;
			case Json12Package.JSON12_READER__ROOT_NAME:
				setRootName((String)newValue);
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
			case Json12Package.JSON12_READER__KEY_MAP:
				setKeyMap((KeyMap)null);
				return;
			case Json12Package.JSON12_READER__ARRAY_ELEMENT_NAME:
				unsetArrayElementName();
				return;
			case Json12Package.JSON12_READER__ENCODING:
				unsetEncoding();
				return;
			case Json12Package.JSON12_READER__ILLEGAL_ELEMENT_NAME_CHAR_REPLACEMENT:
				setIllegalElementNameCharReplacement(ILLEGAL_ELEMENT_NAME_CHAR_REPLACEMENT_EDEFAULT);
				return;
			case Json12Package.JSON12_READER__INDENT:
				unsetIndent();
				return;
			case Json12Package.JSON12_READER__KEY_PREFIX_ON_NUMERIC:
				setKeyPrefixOnNumeric(KEY_PREFIX_ON_NUMERIC_EDEFAULT);
				return;
			case Json12Package.JSON12_READER__KEY_WHITSPACE_REPLACEMENT:
				setKeyWhitspaceReplacement(KEY_WHITSPACE_REPLACEMENT_EDEFAULT);
				return;
			case Json12Package.JSON12_READER__NULL_VALUE_REPLACEMENT:
				setNullValueReplacement(NULL_VALUE_REPLACEMENT_EDEFAULT);
				return;
			case Json12Package.JSON12_READER__ROOT_NAME:
				unsetRootName();
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
			case Json12Package.JSON12_READER__KEY_MAP:
				return keyMap != null;
			case Json12Package.JSON12_READER__ARRAY_ELEMENT_NAME:
				return isSetArrayElementName();
			case Json12Package.JSON12_READER__ENCODING:
				return isSetEncoding();
			case Json12Package.JSON12_READER__ILLEGAL_ELEMENT_NAME_CHAR_REPLACEMENT:
				return ILLEGAL_ELEMENT_NAME_CHAR_REPLACEMENT_EDEFAULT == null ? illegalElementNameCharReplacement != null : !ILLEGAL_ELEMENT_NAME_CHAR_REPLACEMENT_EDEFAULT.equals(illegalElementNameCharReplacement);
			case Json12Package.JSON12_READER__INDENT:
				return isSetIndent();
			case Json12Package.JSON12_READER__KEY_PREFIX_ON_NUMERIC:
				return KEY_PREFIX_ON_NUMERIC_EDEFAULT == null ? keyPrefixOnNumeric != null : !KEY_PREFIX_ON_NUMERIC_EDEFAULT.equals(keyPrefixOnNumeric);
			case Json12Package.JSON12_READER__KEY_WHITSPACE_REPLACEMENT:
				return KEY_WHITSPACE_REPLACEMENT_EDEFAULT == null ? keyWhitspaceReplacement != null : !KEY_WHITSPACE_REPLACEMENT_EDEFAULT.equals(keyWhitspaceReplacement);
			case Json12Package.JSON12_READER__NULL_VALUE_REPLACEMENT:
				return NULL_VALUE_REPLACEMENT_EDEFAULT == null ? nullValueReplacement != null : !NULL_VALUE_REPLACEMENT_EDEFAULT.equals(nullValueReplacement);
			case Json12Package.JSON12_READER__ROOT_NAME:
				return isSetRootName();
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
		result.append(" (arrayElementName: "); //$NON-NLS-1$
		if (arrayElementNameESet) result.append(arrayElementName); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", encoding: "); //$NON-NLS-1$
		if (encodingESet) result.append(encoding); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", illegalElementNameCharReplacement: "); //$NON-NLS-1$
		result.append(illegalElementNameCharReplacement);
		result.append(", indent: "); //$NON-NLS-1$
		if (indentESet) result.append(indent); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", keyPrefixOnNumeric: "); //$NON-NLS-1$
		result.append(keyPrefixOnNumeric);
		result.append(", keyWhitspaceReplacement: "); //$NON-NLS-1$
		result.append(keyWhitspaceReplacement);
		result.append(", nullValueReplacement: "); //$NON-NLS-1$
		result.append(nullValueReplacement);
		result.append(", rootName: "); //$NON-NLS-1$
		if (rootNameESet) result.append(rootName); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //Json12ReaderImpl
