/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.javabean12.provider;


import java.util.Collection;
import java.util.List;


import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot;
import org.jboss.tools.smooks.model.javabean12.Javabean12Factory;
import org.jboss.tools.smooks.model.javabean12.Javabean12Package;

/**
 * This is the item provider adapter for a {@link org.jboss.tools.smooks.model.javabean12.Javabean12DocumentRoot} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class Javabean12DocumentRootItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Javabean12DocumentRootItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__BEAN);
			childrenFeatures.add(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__DECODE_PARAM);
			childrenFeatures.add(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__EXPRESSION);
			childrenFeatures.add(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__RESULT);
			childrenFeatures.add(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__VALUE);
			childrenFeatures.add(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__WIRING);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Javabean12DocumentRoot.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Javabean12DocumentRoot")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		return getString("_UI_Javabean12DocumentRoot_type"); //$NON-NLS-1$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Javabean12DocumentRoot.class)) {
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__BEAN:
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__DECODE_PARAM:
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__EXPRESSION:
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__RESULT:
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__VALUE:
			case Javabean12Package.JAVABEAN12_DOCUMENT_ROOT__WIRING:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__BEAN,
				 Javabean12Factory.eINSTANCE.createBeanType()));

		newChildDescriptors.add
			(createChildParameter
				(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__DECODE_PARAM,
				 Javabean12Factory.eINSTANCE.createDecodeParamType()));

		newChildDescriptors.add
			(createChildParameter
				(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__EXPRESSION,
				 Javabean12Factory.eINSTANCE.createExpressionType()));

		newChildDescriptors.add
			(createChildParameter
				(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__RESULT,
				 Javabean12Factory.eINSTANCE.createResultType()));

		newChildDescriptors.add
			(createChildParameter
				(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__VALUE,
				 Javabean12Factory.eINSTANCE.createValueType()));

		newChildDescriptors.add
			(createChildParameter
				(Javabean12Package.Literals.JAVABEAN12_DOCUMENT_ROOT__WIRING,
				 Javabean12Factory.eINSTANCE.createWiringType()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return Javabean12EditPlugin.INSTANCE;
	}

}
