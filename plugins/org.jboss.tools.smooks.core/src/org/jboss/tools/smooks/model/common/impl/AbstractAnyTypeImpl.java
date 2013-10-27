/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.common.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xml.type.impl.AnyTypeImpl;
import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.model.common.AbstractAnyType;
import org.jboss.tools.smooks.model.common.CommonPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Abstract Any Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public abstract class AbstractAnyTypeImpl extends AnyTypeImpl implements AbstractAnyType, Adapter {

	protected List<String> commentsList = new ArrayList<String>();

	protected Map<String, Integer> commentIndexMap = new HashMap<String, Integer>();

	protected boolean lock = true;

	protected List<Object> oldContents = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.model.common.AbstractAnyType#isLockCommentIndexChange
	 * ()
	 */
	public boolean isLockCommentIndexChange() {
		return lock;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.model.common.AbstractAnyType#setLockCOmmentIndexChange
	 * ()
	 */
	public void setLockCOmmentIndexChange(boolean lock) {
		this.lock = lock;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.notify.Adapter#getTarget()
	 */
	public Notifier getTarget() {
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
	 */
	public boolean isAdapterForType(Object type) {
		return false;
	}

	protected void synchronizeOldObjects(Notification notification) {
		int eventType = notification.getEventType();
		Object feature = notification.getFeature();
		if (EAttribute.class.isInstance(feature)) {
			return;
		}
		switch (eventType) {
		case Notification.ADD:
		case Notification.ADD_MANY:
			oldContents.clear();
			oldContents.addAll(this.eContents());
			break;
		case Notification.SET:
			if (notification.getNewValue() != null) {
				oldContents.clear();
				oldContents.addAll(this.eContents());
			}
			break;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common
	 * .notify.Notification)
	 */
	public void notifyChanged(Notification notification) {
		synchronizeOldObjects(notification);
		if (lock)
			return;
		int eventType = notification.getEventType();
		Object feature = notification.getFeature();
		if (EAttribute.class.isInstance(feature)) {
			return;
		}
		switch (eventType) {
		case Notification.ADD:
			// case Notification.ADD_MANY:
			Object addedValue = notification.getNewValue();
			changeCommentIndex(true, addedValue);
			break;
		case Notification.ADD_MANY:
			Object addedValues = notification.getOldValue();
			if (addedValues instanceof Collection<?>) {
				for (Iterator<?> iterator = ((Collection<?>) addedValues).iterator(); iterator.hasNext();) {
					Object av = (Object) iterator.next();
					changeCommentIndex(true, av);
				}
			}
			break;
		case Notification.REMOVE:
			// case Notification.REMOVE_MANY:
			Object removedValue = notification.getOldValue();
			changeCommentIndex(false, removedValue);
			break;
		case Notification.REMOVE_MANY:
			Object removedValues = notification.getOldValue();
			if (removedValues instanceof Collection<?>) {
				for (Iterator<?> iterator = ((Collection<?>) removedValues).iterator(); iterator.hasNext();) {
					Object rv = (Object) iterator.next();
					changeCommentIndex(false, rv);
				}
			}
			break;
		case Notification.SET:
			Object value = notification.getNewValue();
			Object oldValue = notification.getOldValue();
			if (value != null) {
				changeCommentIndex(true, value);
			} else {
				changeCommentIndex(false, oldValue);
			}
			break;
		}
	}

	private void changeCommentIndex(boolean add, Object value) {
		try {
			List<EObject> contents = this.eContents();
			int index = contents.indexOf(value);
			if (!add) {
				index = oldContents.indexOf(value);
				oldContents.remove(value);
			}
			// ??? what happen?
			if (index == -1)
				return;
			Iterator<String> key = commentIndexMap.keySet().iterator();
			while (key.hasNext()) {
				String k = key.next();
				Integer i = getCommentIndex(k);
				if (i.intValue() < index) {

				} else {
					if (add) {
						i = new Integer(i.intValue() + 1);
					} else {
						if (i.intValue() > index) {
							i = new Integer(i.intValue() - 1);
						}
					}
					commentIndexMap.remove(key);
					commentIndexMap.put(k, i);
				}
			}
		} catch (Throwable t) {
			// ignore exception
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.common.notify.Adapter#setTarget(org.eclipse.emf.common
	 * .notify.Notifier)
	 */
	public void setTarget(Notifier newTarget) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.model.common.AbstractAnyType#addComment(java.lang
	 * .String, java.lang.Object)
	 */
	public void addComment(String comment, Integer index) {
		commentsList.add(comment);
		setCommentIndex(comment, index);
	}

	/**
	 * @return the commentsList
	 */
	public List<String> getCommentList() {
		return commentsList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.model.common.AbstractAnyType#getObjectAfterComment
	 * (java.lang.String)
	 */
	public Integer getCommentIndex(String comment) {
		return commentIndexMap.get(comment);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.model.common.AbstractAnyType#setObjectAfterCommecnt
	 * (java.lang.String, java.lang.Object)
	 */
	public void setCommentIndex(String comment, Integer obj) {
		commentIndexMap.put(comment, obj);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AbstractAnyTypeImpl() {
		super();
		eAdapters().add(this);
		oldContents = new ArrayList<Object>();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonPackage.Literals.ABSTRACT_ANY_TYPE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getCDATA() {
		return SmooksModelUtils.getAnyTypeCDATA(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCDATA(String cdata) {
		SmooksModelUtils.cleanCDATAToSmooksType(this);
		SmooksModelUtils.appendCDATAToSmooksType(this, cdata);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getStringValue() {
		return SmooksModelUtils.getAnyTypeText(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setStringValue(String stringValue) {
		SmooksModelUtils.cleanTextToSmooksType(this);
		SmooksModelUtils.appendTextToSmooksType(this, stringValue);
	}

} // AbstractAnyTypeImpl
