/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.csv12.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.jboss.tools.smooks.model.csv12.CSV12DocumentRoot;
import org.jboss.tools.smooks.model.csv12.CSV12Reader;
import org.jboss.tools.smooks.model.csv12.Csv12Package;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>CSV12 Document Root</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.jboss.tools.smooks.model.csv12.impl.CSV12DocumentRootImpl#getMixed
 * <em>Mixed</em>}</li>
 * <li>
 * {@link org.jboss.tools.smooks.model.csv12.impl.CSV12DocumentRootImpl#getXMLNSPrefixMap
 * <em>XMLNS Prefix Map</em>}</li>
 * <li>
 * {@link org.jboss.tools.smooks.model.csv12.impl.CSV12DocumentRootImpl#getXSISchemaLocation
 * <em>XSI Schema Location</em>}</li>
 * <li>
 * {@link org.jboss.tools.smooks.model.csv12.impl.CSV12DocumentRootImpl#getReader
 * <em>Reader</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CSV12DocumentRootImpl extends EObjectImpl implements CSV12DocumentRoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap()
	 * <em>XMLNS Prefix Map</em>}' map. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation()
	 * <em>XSI Schema Location</em>}' map. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap xSISchemaLocation;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CSV12DocumentRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Csv12Package.Literals.CSV12_DOCUMENT_ROOT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, Csv12Package.CSV12_DOCUMENT_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EMap getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY,
					EStringToStringMapEntryImpl.class, this, Csv12Package.CSV12_DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EMap getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY,
					EStringToStringMapEntryImpl.class, this, Csv12Package.CSV12_DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CSV12Reader getReader() {
		return (CSV12Reader) getMixed().get(Csv12Package.Literals.CSV12_DOCUMENT_ROOT__READER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetReader(CSV12Reader newReader, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(Csv12Package.Literals.CSV12_DOCUMENT_ROOT__READER,
				newReader, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setReader(CSV12Reader newReader) {
		((FeatureMap.Internal) getMixed()).set(Csv12Package.Literals.CSV12_DOCUMENT_ROOT__READER, newReader);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Csv12Package.CSV12_DOCUMENT_ROOT__MIXED:
			return ((InternalEList) getMixed()).basicRemove(otherEnd, msgs);
		case Csv12Package.CSV12_DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
			return ((InternalEList) getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
		case Csv12Package.CSV12_DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
			return ((InternalEList) getXSISchemaLocation()).basicRemove(otherEnd, msgs);
		case Csv12Package.CSV12_DOCUMENT_ROOT__READER:
			return basicSetReader(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Csv12Package.CSV12_DOCUMENT_ROOT__MIXED:
			if (coreType)
				return getMixed();
			return ((FeatureMap.Internal) getMixed()).getWrapper();
		case Csv12Package.CSV12_DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
			if (coreType)
				return getXMLNSPrefixMap();
			else
				return getXMLNSPrefixMap().map();
		case Csv12Package.CSV12_DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
			if (coreType)
				return getXSISchemaLocation();
			else
				return getXSISchemaLocation().map();
		case Csv12Package.CSV12_DOCUMENT_ROOT__READER:
			return getReader();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Csv12Package.CSV12_DOCUMENT_ROOT__MIXED:
			((FeatureMap.Internal) getMixed()).set(newValue);
			return;
		case Csv12Package.CSV12_DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
			((EStructuralFeature.Setting) getXMLNSPrefixMap()).set(newValue);
			return;
		case Csv12Package.CSV12_DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
			((EStructuralFeature.Setting) getXSISchemaLocation()).set(newValue);
			return;
		case Csv12Package.CSV12_DOCUMENT_ROOT__READER:
			setReader((CSV12Reader) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
		case Csv12Package.CSV12_DOCUMENT_ROOT__MIXED:
			getMixed().clear();
			return;
		case Csv12Package.CSV12_DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
			getXMLNSPrefixMap().clear();
			return;
		case Csv12Package.CSV12_DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
			getXSISchemaLocation().clear();
			return;
		case Csv12Package.CSV12_DOCUMENT_ROOT__READER:
			setReader((CSV12Reader) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Csv12Package.CSV12_DOCUMENT_ROOT__MIXED:
			return mixed != null && !mixed.isEmpty();
		case Csv12Package.CSV12_DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
			return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
		case Csv12Package.CSV12_DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
			return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
		case Csv12Package.CSV12_DOCUMENT_ROOT__READER:
			return getReader() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mixed: "); //$NON-NLS-1$
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} // CSV12DocumentRootImpl
