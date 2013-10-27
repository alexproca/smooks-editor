/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.json12.provider;


import java.util.Collection;
import java.util.List;


import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.jboss.tools.smooks.model.json12.Json12Factory;
import org.jboss.tools.smooks.model.json12.Json12Package;
import org.jboss.tools.smooks.model.json12.Json12Reader;
import org.jboss.tools.smooks.model.smooks.provider.AbstractReaderItemProvider;


/**
 * This is the item provider adapter for a {@link org.jboss.tools.smooks.model.json12.Json12Reader} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class Json12ReaderItemProvider
	extends AbstractReaderItemProvider
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
	public Json12ReaderItemProvider(AdapterFactory adapterFactory) {
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

			addArrayElementNamePropertyDescriptor(object);
			addEncodingPropertyDescriptor(object);
			addIllegalElementNameCharReplacementPropertyDescriptor(object);
			addIndentPropertyDescriptor(object);
			addKeyPrefixOnNumericPropertyDescriptor(object);
			addKeyWhitspaceReplacementPropertyDescriptor(object);
			addNullValueReplacementPropertyDescriptor(object);
			addRootNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Array Element Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addArrayElementNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Json12Reader_arrayElementName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Json12Reader_arrayElementName_feature", "_UI_Json12Reader_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Json12Package.Literals.JSON12_READER__ARRAY_ELEMENT_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Encoding feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEncodingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Json12Reader_encoding_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Json12Reader_encoding_feature", "_UI_Json12Reader_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Json12Package.Literals.JSON12_READER__ENCODING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Illegal Element Name Char Replacement feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIllegalElementNameCharReplacementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Json12Reader_illegalElementNameCharReplacement_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Json12Reader_illegalElementNameCharReplacement_feature", "_UI_Json12Reader_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Json12Package.Literals.JSON12_READER__ILLEGAL_ELEMENT_NAME_CHAR_REPLACEMENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Indent feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIndentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Json12Reader_indent_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Json12Reader_indent_feature", "_UI_Json12Reader_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Json12Package.Literals.JSON12_READER__INDENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Key Prefix On Numeric feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addKeyPrefixOnNumericPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Json12Reader_keyPrefixOnNumeric_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Json12Reader_keyPrefixOnNumeric_feature", "_UI_Json12Reader_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Json12Package.Literals.JSON12_READER__KEY_PREFIX_ON_NUMERIC,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Key Whitspace Replacement feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addKeyWhitspaceReplacementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Json12Reader_keyWhitspaceReplacement_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Json12Reader_keyWhitspaceReplacement_feature", "_UI_Json12Reader_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Json12Package.Literals.JSON12_READER__KEY_WHITSPACE_REPLACEMENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Null Value Replacement feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNullValueReplacementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Json12Reader_nullValueReplacement_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Json12Reader_nullValueReplacement_feature", "_UI_Json12Reader_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Json12Package.Literals.JSON12_READER__NULL_VALUE_REPLACEMENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Root Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRootNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Json12Reader_rootName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Json12Reader_rootName_feature", "_UI_Json12Reader_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Json12Package.Literals.JSON12_READER__ROOT_NAME,
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
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(Json12Package.Literals.JSON12_READER__KEY_MAP);
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
	 * This returns Json12Reader.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Json12Reader")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		return "JSON"; //$NON-NLS-1$
//		String label = ((Json12Reader)object).getArrayElementName();
//		return label == null || label.length() == 0 ?
//			getString("_UI_Json12Reader_type") :
//			getString("_UI_Json12Reader_type") + " " + label;
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

		switch (notification.getFeatureID(Json12Reader.class)) {
			case Json12Package.JSON12_READER__ARRAY_ELEMENT_NAME:
			case Json12Package.JSON12_READER__ENCODING:
			case Json12Package.JSON12_READER__ILLEGAL_ELEMENT_NAME_CHAR_REPLACEMENT:
			case Json12Package.JSON12_READER__INDENT:
			case Json12Package.JSON12_READER__KEY_PREFIX_ON_NUMERIC:
			case Json12Package.JSON12_READER__KEY_WHITSPACE_REPLACEMENT:
			case Json12Package.JSON12_READER__NULL_VALUE_REPLACEMENT:
			case Json12Package.JSON12_READER__ROOT_NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case Json12Package.JSON12_READER__KEY_MAP:
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
				(Json12Package.Literals.JSON12_READER__KEY_MAP,
				 Json12Factory.eINSTANCE.createKeyMap()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return Json12EditPlugin.INSTANCE;
	}

}
