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
import org.jboss.tools.smooks.model.freemarker.Inline;
import org.jboss.tools.smooks.model.freemarker.InlineDirective;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.freemarker.impl.InlineImpl#getDirective <em>Directive</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InlineImpl extends AbstractAnyTypeImpl implements Inline {
	/**
	 * The default value of the '{@link #getDirective() <em>Directive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirective()
	 * @generated not
	 * @ordered
	 */
	protected static final InlineDirective DIRECTIVE_EDEFAULT = null;// InlineDirective.ADDTO;

	/**
	 * The cached value of the '{@link #getDirective() <em>Directive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirective()
	 * @generated
	 * @ordered
	 */
	protected InlineDirective directive = DIRECTIVE_EDEFAULT;

	/**
	 * This is true if the Directive attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean directiveESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InlineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FreemarkerPackage.Literals.INLINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InlineDirective getDirective() {
		return directive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirective(InlineDirective newDirective) {
		InlineDirective oldDirective = directive;
		directive = newDirective == null ? DIRECTIVE_EDEFAULT : newDirective;
		boolean oldDirectiveESet = directiveESet;
		directiveESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FreemarkerPackage.INLINE__DIRECTIVE, oldDirective, directive, !oldDirectiveESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDirective() {
		InlineDirective oldDirective = directive;
		boolean oldDirectiveESet = directiveESet;
		directive = DIRECTIVE_EDEFAULT;
		directiveESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FreemarkerPackage.INLINE__DIRECTIVE, oldDirective, DIRECTIVE_EDEFAULT, oldDirectiveESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDirective() {
		return directiveESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FreemarkerPackage.INLINE__DIRECTIVE:
				return getDirective();
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
			case FreemarkerPackage.INLINE__DIRECTIVE:
				setDirective((InlineDirective)newValue);
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
			case FreemarkerPackage.INLINE__DIRECTIVE:
				unsetDirective();
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
			case FreemarkerPackage.INLINE__DIRECTIVE:
				return isSetDirective();
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
		result.append(" (directive: "); //$NON-NLS-1$
		if (directiveESet) result.append(directive); else result.append(Messages.InlineImpl_1);
		result.append(')');
		return result.toString();
	}

} //InlineImpl
