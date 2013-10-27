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
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.jboss.tools.smooks.model.javabean12.BeanType;
import org.jboss.tools.smooks.model.javabean12.Javabean12Factory;
import org.jboss.tools.smooks.model.javabean12.Javabean12Package;
import org.jboss.tools.smooks.model.smooks.provider.ElementVisitorItemProvider;


/**
 * This is the item provider adapter for a {@link org.jboss.tools.smooks.model.javabean12.BeanType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BeanTypeItemProvider
	extends ElementVisitorItemProvider
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
	public BeanTypeItemProvider(AdapterFactory adapterFactory) {
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

			addBeanIdPropertyDescriptor(object);
			addClassPropertyDescriptor(object);
			addCreateOnElementPropertyDescriptor(object);
			addCreateOnElementNSPropertyDescriptor(object);
			addExtendLifecyclePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Bean Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBeanIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BeanType_beanId_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_BeanType_beanId_feature", "_UI_BeanType_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Javabean12Package.Literals.BEAN_TYPE__BEAN_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BeanType_class_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_BeanType_class_feature", "_UI_BeanType_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Javabean12Package.Literals.BEAN_TYPE__CLASS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Create On Element feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCreateOnElementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BeanType_createOnElement_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_BeanType_createOnElement_feature", "_UI_BeanType_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Javabean12Package.Literals.BEAN_TYPE__CREATE_ON_ELEMENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Create On Element NS feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCreateOnElementNSPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BeanType_createOnElementNS_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_BeanType_createOnElementNS_feature", "_UI_BeanType_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Javabean12Package.Literals.BEAN_TYPE__CREATE_ON_ELEMENT_NS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Extend Lifecycle feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExtendLifecyclePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BeanType_extendLifecycle_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_BeanType_extendLifecycle_feature", "_UI_BeanType_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Javabean12Package.Literals.BEAN_TYPE__EXTEND_LIFECYCLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(Javabean12Package.Literals.BEAN_TYPE__GROUP);
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
	 * This returns BeanType.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/java_bean.png")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((BeanType)object).getBeanId();
		return label == null || label.length() == 0 ?
			getString("_UI_BeanType_type") : //$NON-NLS-1$
			getString("_UI_BeanType_type") + " (" + label+")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		
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

		switch (notification.getFeatureID(BeanType.class)) {
			case Javabean12Package.BEAN_TYPE__BEAN_ID:
			case Javabean12Package.BEAN_TYPE__CLASS:
			case Javabean12Package.BEAN_TYPE__CREATE_ON_ELEMENT:
			case Javabean12Package.BEAN_TYPE__CREATE_ON_ELEMENT_NS:
			case Javabean12Package.BEAN_TYPE__EXTEND_LIFECYCLE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case Javabean12Package.BEAN_TYPE__GROUP:
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
				(Javabean12Package.Literals.BEAN_TYPE__GROUP,
				 FeatureMapUtil.createEntry
					(Javabean12Package.Literals.BEAN_TYPE__VALUE,
					 Javabean12Factory.eINSTANCE.createValueType())));

		newChildDescriptors.add
			(createChildParameter
				(Javabean12Package.Literals.BEAN_TYPE__GROUP,
				 FeatureMapUtil.createEntry
					(Javabean12Package.Literals.BEAN_TYPE__WIRING,
					 Javabean12Factory.eINSTANCE.createWiringType())));

		newChildDescriptors.add
			(createChildParameter
				(Javabean12Package.Literals.BEAN_TYPE__GROUP,
				 FeatureMapUtil.createEntry
					(Javabean12Package.Literals.BEAN_TYPE__EXPRESSION,
					 Javabean12Factory.eINSTANCE.createExpressionType())));
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
