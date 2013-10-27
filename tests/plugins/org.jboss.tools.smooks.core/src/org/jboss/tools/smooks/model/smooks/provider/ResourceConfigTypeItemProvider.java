/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.smooks.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.jboss.tools.smooks.model.smooks.ResourceConfigType;
import org.jboss.tools.smooks.model.smooks.SmooksFactory;
import org.jboss.tools.smooks.model.smooks.SmooksPackage;

/**
 * This is the item provider adapter for a {@link smooks.ResourceConfigType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ResourceConfigTypeItemProvider
	extends AbstractResourceConfigItemProvider
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
	public ResourceConfigTypeItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addSelectorPropertyDescriptor(object);
			addSelectorNamespacePropertyDescriptor(object);
			addTargetProfilePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Selector feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSelectorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ResourceConfigType_selector_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ResourceConfigType_selector_feature", "_UI_ResourceConfigType_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 SmooksPackage.Literals.RESOURCE_CONFIG_TYPE__SELECTOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Selector Namespace feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSelectorNamespacePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ResourceConfigType_selectorNamespace_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ResourceConfigType_selectorNamespace_feature", "_UI_ResourceConfigType_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 SmooksPackage.Literals.RESOURCE_CONFIG_TYPE__SELECTOR_NAMESPACE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Profile feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetProfilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ResourceConfigType_targetProfile_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ResourceConfigType_targetProfile_feature", "_UI_ResourceConfigType_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 SmooksPackage.Literals.RESOURCE_CONFIG_TYPE__TARGET_PROFILE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(SmooksPackage.Literals.RESOURCE_CONFIG_TYPE__RESOURCE);
			childrenFeatures.add(SmooksPackage.Literals.RESOURCE_CONFIG_TYPE__CONDITION);
			childrenFeatures.add(SmooksPackage.Literals.RESOURCE_CONFIG_TYPE__PARAM);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ResourceConfigType.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ResourceConfigType")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ResourceConfigType)object).getSelectorNamespace();
		return label == null || label.length() == 0 ?
			getString("_UI_ResourceConfigType_type") : //$NON-NLS-1$
			getString("_UI_ResourceConfigType_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ResourceConfigType.class)) {
			case SmooksPackage.RESOURCE_CONFIG_TYPE__SELECTOR:
			case SmooksPackage.RESOURCE_CONFIG_TYPE__SELECTOR_NAMESPACE:
			case SmooksPackage.RESOURCE_CONFIG_TYPE__TARGET_PROFILE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case SmooksPackage.RESOURCE_CONFIG_TYPE__RESOURCE:
			case SmooksPackage.RESOURCE_CONFIG_TYPE__CONDITION:
			case SmooksPackage.RESOURCE_CONFIG_TYPE__PARAM:
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
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(SmooksPackage.Literals.RESOURCE_CONFIG_TYPE__RESOURCE,
				 SmooksFactory.eINSTANCE.createResourceType()));

		newChildDescriptors.add
			(createChildParameter
				(SmooksPackage.Literals.RESOURCE_CONFIG_TYPE__CONDITION,
				 SmooksFactory.eINSTANCE.createConditionType()));

		newChildDescriptors.add
			(createChildParameter
				(SmooksPackage.Literals.RESOURCE_CONFIG_TYPE__PARAM,
				 SmooksFactory.eINSTANCE.createParamType()));
	}

}
