/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.freemarker.impl;



import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.jboss.tools.smooks.model.common.impl.AbstractAnyTypeImpl;
import org.jboss.tools.smooks.model.freemarker.BindTo;
import org.jboss.tools.smooks.model.freemarker.FreemarkerPackage;
import org.jboss.tools.smooks.model.freemarker.Inline;
import org.jboss.tools.smooks.model.freemarker.OutputTo;
import org.jboss.tools.smooks.model.freemarker.Use;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Use</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.freemarker.impl.UseImpl#getInline <em>Inline</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.freemarker.impl.UseImpl#getBindTo <em>Bind To</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.freemarker.impl.UseImpl#getOutputTo <em>Output To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UseImpl extends AbstractAnyTypeImpl implements Use {
	/**
	 * The cached value of the '{@link #getInline() <em>Inline</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInline()
	 * @generated
	 * @ordered
	 */
	protected Inline inline;

	/**
	 * The cached value of the '{@link #getBindTo() <em>Bind To</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindTo()
	 * @generated
	 * @ordered
	 */
	protected BindTo bindTo;

	/**
	 * The cached value of the '{@link #getOutputTo() <em>Output To</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputTo()
	 * @generated
	 * @ordered
	 */
	protected OutputTo outputTo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FreemarkerPackage.Literals.USE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Inline getInline() {
		return inline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInline(Inline newInline, NotificationChain msgs) {
		Inline oldInline = inline;
		inline = newInline;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FreemarkerPackage.USE__INLINE, oldInline, newInline);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInline(Inline newInline) {
		if (newInline != inline) {
			NotificationChain msgs = null;
			if (inline != null)
				msgs = ((InternalEObject)inline).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FreemarkerPackage.USE__INLINE, null, msgs);
			if (newInline != null)
				msgs = ((InternalEObject)newInline).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FreemarkerPackage.USE__INLINE, null, msgs);
			msgs = basicSetInline(newInline, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FreemarkerPackage.USE__INLINE, newInline, newInline));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindTo getBindTo() {
		return bindTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBindTo(BindTo newBindTo, NotificationChain msgs) {
		BindTo oldBindTo = bindTo;
		bindTo = newBindTo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FreemarkerPackage.USE__BIND_TO, oldBindTo, newBindTo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindTo(BindTo newBindTo) {
		if (newBindTo != bindTo) {
			NotificationChain msgs = null;
			if (bindTo != null)
				msgs = ((InternalEObject)bindTo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FreemarkerPackage.USE__BIND_TO, null, msgs);
			if (newBindTo != null)
				msgs = ((InternalEObject)newBindTo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FreemarkerPackage.USE__BIND_TO, null, msgs);
			msgs = basicSetBindTo(newBindTo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FreemarkerPackage.USE__BIND_TO, newBindTo, newBindTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputTo getOutputTo() {
		return outputTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputTo(OutputTo newOutputTo, NotificationChain msgs) {
		OutputTo oldOutputTo = outputTo;
		outputTo = newOutputTo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FreemarkerPackage.USE__OUTPUT_TO, oldOutputTo, newOutputTo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputTo(OutputTo newOutputTo) {
		if (newOutputTo != outputTo) {
			NotificationChain msgs = null;
			if (outputTo != null)
				msgs = ((InternalEObject)outputTo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FreemarkerPackage.USE__OUTPUT_TO, null, msgs);
			if (newOutputTo != null)
				msgs = ((InternalEObject)newOutputTo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FreemarkerPackage.USE__OUTPUT_TO, null, msgs);
			msgs = basicSetOutputTo(newOutputTo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FreemarkerPackage.USE__OUTPUT_TO, newOutputTo, newOutputTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FreemarkerPackage.USE__INLINE:
				return basicSetInline(null, msgs);
			case FreemarkerPackage.USE__BIND_TO:
				return basicSetBindTo(null, msgs);
			case FreemarkerPackage.USE__OUTPUT_TO:
				return basicSetOutputTo(null, msgs);
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
			case FreemarkerPackage.USE__INLINE:
				return getInline();
			case FreemarkerPackage.USE__BIND_TO:
				return getBindTo();
			case FreemarkerPackage.USE__OUTPUT_TO:
				return getOutputTo();
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
			case FreemarkerPackage.USE__INLINE:
				setInline((Inline)newValue);
				return;
			case FreemarkerPackage.USE__BIND_TO:
				setBindTo((BindTo)newValue);
				return;
			case FreemarkerPackage.USE__OUTPUT_TO:
				setOutputTo((OutputTo)newValue);
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
			case FreemarkerPackage.USE__INLINE:
				setInline((Inline)null);
				return;
			case FreemarkerPackage.USE__BIND_TO:
				setBindTo((BindTo)null);
				return;
			case FreemarkerPackage.USE__OUTPUT_TO:
				setOutputTo((OutputTo)null);
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
			case FreemarkerPackage.USE__INLINE:
				return inline != null;
			case FreemarkerPackage.USE__BIND_TO:
				return bindTo != null;
			case FreemarkerPackage.USE__OUTPUT_TO:
				return outputTo != null;
		}
		return super.eIsSet(featureID);
	}

} //UseImpl
