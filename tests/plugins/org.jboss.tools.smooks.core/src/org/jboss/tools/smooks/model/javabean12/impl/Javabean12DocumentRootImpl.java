/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.javabean12.impl;


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
import org.jboss.tools.smooks.model.javabean12.BeanType;
import org.jboss.tools.smooks.model.javabean12.DecodeParamType;
import org.jboss.tools.smooks.model.javabean12.ExpressionType;
import org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot;
import org.jboss.tools.smooks.model.javabean12.Javabean12Package;
import org.jboss.tools.smooks.model.javabean12.ResultType;
import org.jboss.tools.smooks.model.javabean12.ValueType;
import org.jboss.tools.smooks.model.javabean12.WiringType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.Javabean12DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.Javabean12DocumentRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.Javabean12DocumentRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.Javabean12DocumentRootImpl#getBean <em>Bean</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.Javabean12DocumentRootImpl#getDecodeParam <em>Decode Param</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.Javabean12DocumentRootImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.Javabean12DocumentRootImpl#getResult <em>Result</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.Javabean12DocumentRootImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.javabean12.impl.Javabean12DocumentRootImpl#getWiring <em>Wiring</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Javabean12DocumentRootImpl extends EObjectImpl implements Javabean12DocumentRoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap xSISchemaLocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Javabean12DocumentRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeanType getBean() {
		return (BeanType)getMixed().get(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__BEAN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBean(BeanType newBean, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__BEAN, newBean, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBean(BeanType newBean) {
		((FeatureMap.Internal)getMixed()).set(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__BEAN, newBean);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DecodeParamType getDecodeParam() {
		return (DecodeParamType)getMixed().get(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__DECODE_PARAM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDecodeParam(DecodeParamType newDecodeParam, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__DECODE_PARAM, newDecodeParam, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDecodeParam(DecodeParamType newDecodeParam) {
		((FeatureMap.Internal)getMixed()).set(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__DECODE_PARAM, newDecodeParam);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionType getExpression() {
		return (ExpressionType)getMixed().get(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__EXPRESSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpression(ExpressionType newExpression, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__EXPRESSION, newExpression, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(ExpressionType newExpression) {
		((FeatureMap.Internal)getMixed()).set(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__EXPRESSION, newExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType getResult() {
		return (ResultType)getMixed().get(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__RESULT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResult(ResultType newResult, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__RESULT, newResult, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResult(ResultType newResult) {
		((FeatureMap.Internal)getMixed()).set(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__RESULT, newResult);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueType getValue() {
		return (ValueType)getMixed().get(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(ValueType newValue, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__VALUE, newValue, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(ValueType newValue) {
		((FeatureMap.Internal)getMixed()).set(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__VALUE, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WiringType getWiring() {
		return (WiringType)getMixed().get(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__WIRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWiring(WiringType newWiring, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__WIRING, newWiring, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWiring(WiringType newWiring) {
		((FeatureMap.Internal)getMixed()).set(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__WIRING, newWiring);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__BEAN:
				return basicSetBean(null, msgs);
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__DECODE_PARAM:
				return basicSetDecodeParam(null, msgs);
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__EXPRESSION:
				return basicSetExpression(null, msgs);
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__RESULT:
				return basicSetResult(null, msgs);
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__VALUE:
				return basicSetValue(null, msgs);
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__WIRING:
				return basicSetWiring(null, msgs);
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
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__BEAN:
				return getBean();
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__DECODE_PARAM:
				return getDecodeParam();
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__EXPRESSION:
				return getExpression();
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__RESULT:
				return getResult();
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__VALUE:
				return getValue();
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__WIRING:
				return getWiring();
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
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__BEAN:
				setBean((BeanType)newValue);
				return;
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__DECODE_PARAM:
				setDecodeParam((DecodeParamType)newValue);
				return;
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__EXPRESSION:
				setExpression((ExpressionType)newValue);
				return;
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__RESULT:
				setResult((ResultType)newValue);
				return;
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__VALUE:
				setValue((ValueType)newValue);
				return;
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__WIRING:
				setWiring((WiringType)newValue);
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
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__MIXED:
				getMixed().clear();
				return;
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__BEAN:
				setBean((BeanType)null);
				return;
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__DECODE_PARAM:
				setDecodeParam((DecodeParamType)null);
				return;
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__EXPRESSION:
				setExpression((ExpressionType)null);
				return;
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__RESULT:
				setResult((ResultType)null);
				return;
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__VALUE:
				setValue((ValueType)null);
				return;
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__WIRING:
				setWiring((WiringType)null);
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
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__BEAN:
				return getBean() != null;
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__DECODE_PARAM:
				return getDecodeParam() != null;
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__EXPRESSION:
				return getExpression() != null;
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__RESULT:
				return getResult() != null;
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__VALUE:
				return getValue() != null;
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__WIRING:
				return getWiring() != null;
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
		result.append(" (mixed: "); //$NON-NLS-1$
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //Javabean12DocumentRootImpl
