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
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.jboss.tools.smooks.model.common.provider.AbstractAnyTypeItemProvider;
import org.jboss.tools.smooks.model.javabean12.Javabean12Package;
import org.jboss.tools.smooks.model.javabean12.WiringType;

/**
 * This is the item provider adapter for a
 * {@link org.jboss.tools.smooks.model.javabean12.WiringType} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class WiringTypeItemProvider extends AbstractAnyTypeItemProvider implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WiringTypeItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addBeanIdRefPropertyDescriptor(object);
			addPropertyPropertyDescriptor(object);
			addSetterMethodPropertyDescriptor(object);
			addWireOnElementPropertyDescriptor(object);
			addWireOnElementNSPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Bean Id Ref feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBeanIdRefPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
				.getRootAdapterFactory(), getResourceLocator(), getString("_UI_WiringType_beanIdRef_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_WiringType_beanIdRef_feature", //$NON-NLS-1$ //$NON-NLS-2$
						"_UI_WiringType_type"), Javabean12Package.Literals.WIRING_TYPE__BEAN_ID_REF, true, false, //$NON-NLS-1$
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Property feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addPropertyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
				.getRootAdapterFactory(), getResourceLocator(), getString("_UI_WiringType_property_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_WiringType_property_feature", //$NON-NLS-1$ //$NON-NLS-2$
						"_UI_WiringType_type"), Javabean12Package.Literals.WIRING_TYPE__PROPERTY, true, false, false, //$NON-NLS-1$
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Setter Method feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSetterMethodPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
				.getRootAdapterFactory(), getResourceLocator(), getString("_UI_WiringType_setterMethod_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_WiringType_setterMethod_feature", //$NON-NLS-1$ //$NON-NLS-2$
						"_UI_WiringType_type"), Javabean12Package.Literals.WIRING_TYPE__SETTER_METHOD, true, false, //$NON-NLS-1$
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Wire On Element feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addWireOnElementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
				.getRootAdapterFactory(), getResourceLocator(), getString("_UI_WiringType_wireOnElement_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_WiringType_wireOnElement_feature", //$NON-NLS-1$ //$NON-NLS-2$
						"_UI_WiringType_type"), Javabean12Package.Literals.WIRING_TYPE__WIRE_ON_ELEMENT, true, false, //$NON-NLS-1$
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Wire On Element NS feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addWireOnElementNSPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
				.getRootAdapterFactory(), getResourceLocator(), getString("_UI_WiringType_wireOnElementNS_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_WiringType_wireOnElementNS_feature", //$NON-NLS-1$ //$NON-NLS-2$
						"_UI_WiringType_type"), Javabean12Package.Literals.WIRING_TYPE__WIRE_ON_ELEMENT_NS, true, //$NON-NLS-1$
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns WiringType.gif. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/wiring_binding")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((WiringType) object).getProperty();
		return label == null || label.length() == 0 ? getString("_UI_WiringType_type") //$NON-NLS-1$
				: getString("_UI_WiringType_type") + " (" + label + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to
	 * update any cached children and by creating a viewer notification, which
	 * it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(WiringType.class)) {
		case Javabean12Package.WIRING_TYPE__BEAN_ID_REF:
		case Javabean12Package.WIRING_TYPE__PROPERTY:
		case Javabean12Package.WIRING_TYPE__SETTER_METHOD:
		case Javabean12Package.WIRING_TYPE__WIRE_ON_ELEMENT:
		case Javabean12Package.WIRING_TYPE__WIRE_ON_ELEMENT_NS:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return Javabean12EditPlugin.INSTANCE;
	}

}
