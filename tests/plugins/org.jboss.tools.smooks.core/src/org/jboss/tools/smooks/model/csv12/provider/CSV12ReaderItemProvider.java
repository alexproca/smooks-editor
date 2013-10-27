/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.csv12.provider;



import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.jboss.tools.smooks.model.csv12.CSV12Reader;
import org.jboss.tools.smooks.model.csv12.Csv12Factory;
import org.jboss.tools.smooks.model.csv12.Csv12Package;
import org.jboss.tools.smooks.model.smooks.provider.AbstractReaderItemProvider;

/**
 * This is the item provider adapter for a {@link org.jboss.tools.smooks.model.csv12.CSV12Reader} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CSV12ReaderItemProvider
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
	public CSV12ReaderItemProvider(AdapterFactory adapterFactory) {
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

			addEncodingPropertyDescriptor(object);
			addFieldsPropertyDescriptor(object);
			addIndentPropertyDescriptor(object);
			addQuotePropertyDescriptor(object);
			addRecordElementNamePropertyDescriptor(object);
			addRootElementNamePropertyDescriptor(object);
			addSeparatorPropertyDescriptor(object);
			addSkipLinesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
				 getString("_UI_CSV12Reader_encoding_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CSV12Reader_encoding_feature", "_UI_CSV12Reader_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Csv12Package.Literals.CSV12_READER__ENCODING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fields feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFieldsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CSV12Reader_fields_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CSV12Reader_fields_feature", "_UI_CSV12Reader_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Csv12Package.Literals.CSV12_READER__FIELDS,
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
				 getString("_UI_CSV12Reader_indent_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CSV12Reader_indent_feature", "_UI_CSV12Reader_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Csv12Package.Literals.CSV12_READER__INDENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Quote feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addQuotePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CSV12Reader_quote_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CSV12Reader_quote_feature", "_UI_CSV12Reader_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Csv12Package.Literals.CSV12_READER__QUOTE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Record Element Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRecordElementNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CSV12Reader_recordElementName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CSV12Reader_recordElementName_feature", "_UI_CSV12Reader_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Csv12Package.Literals.CSV12_READER__RECORD_ELEMENT_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Root Element Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRootElementNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CSV12Reader_rootElementName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CSV12Reader_rootElementName_feature", "_UI_CSV12Reader_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Csv12Package.Literals.CSV12_READER__ROOT_ELEMENT_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Separator feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSeparatorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CSV12Reader_separator_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CSV12Reader_separator_feature", "_UI_CSV12Reader_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Csv12Package.Literals.CSV12_READER__SEPARATOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Skip Lines feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSkipLinesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CSV12Reader_skipLines_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CSV12Reader_skipLines_feature", "_UI_CSV12Reader_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Csv12Package.Literals.CSV12_READER__SKIP_LINES,
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
			childrenFeatures.add(Csv12Package.Literals.CSV12_READER__SINGLE_BINDING);
			childrenFeatures.add(Csv12Package.Literals.CSV12_READER__LIST_BINDING);
			childrenFeatures.add(Csv12Package.Literals.CSV12_READER__MAP_BINDING);
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
	 * This returns CSV12Reader.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CSV12Reader")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		return "CSV"; //$NON-NLS-1$
//		String label = ((CSV12Reader)object).getRecordElementName();
//		return label == null || label.length() == 0 ?
//			getString("_UI_CSV12Reader_type") :
//			getString("_UI_CSV12Reader_type") + " " + label;
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

		switch (notification.getFeatureID(CSV12Reader.class)) {
			case Csv12Package.CSV12_READER__ENCODING:
			case Csv12Package.CSV12_READER__FIELDS:
			case Csv12Package.CSV12_READER__INDENT:
			case Csv12Package.CSV12_READER__QUOTE:
			case Csv12Package.CSV12_READER__RECORD_ELEMENT_NAME:
			case Csv12Package.CSV12_READER__ROOT_ELEMENT_NAME:
			case Csv12Package.CSV12_READER__SEPARATOR:
			case Csv12Package.CSV12_READER__SKIP_LINES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case Csv12Package.CSV12_READER__SINGLE_BINDING:
			case Csv12Package.CSV12_READER__LIST_BINDING:
			case Csv12Package.CSV12_READER__MAP_BINDING:
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
				(Csv12Package.Literals.CSV12_READER__SINGLE_BINDING,
				 Csv12Factory.eINSTANCE.createBinding()));

		newChildDescriptors.add
			(createChildParameter
				(Csv12Package.Literals.CSV12_READER__SINGLE_BINDING,
				 Csv12Factory.eINSTANCE.createMapBinding()));

		newChildDescriptors.add
			(createChildParameter
				(Csv12Package.Literals.CSV12_READER__LIST_BINDING,
				 Csv12Factory.eINSTANCE.createBinding()));

		newChildDescriptors.add
			(createChildParameter
				(Csv12Package.Literals.CSV12_READER__LIST_BINDING,
				 Csv12Factory.eINSTANCE.createMapBinding()));

		newChildDescriptors.add
			(createChildParameter
				(Csv12Package.Literals.CSV12_READER__MAP_BINDING,
				 Csv12Factory.eINSTANCE.createMapBinding()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreateChildText(Object owner, Object feature, Object child, Collection selection) {
		Object childFeature = feature;
		Object childObject = child;

		if (childFeature instanceof EStructuralFeature && FeatureMapUtil.isFeatureMap((EStructuralFeature)childFeature)) {
			FeatureMap.Entry entry = (FeatureMap.Entry)childObject;
			childFeature = entry.getEStructuralFeature();
			childObject = entry.getValue();
		}

		boolean qualify =
			childFeature == Csv12Package.Literals.CSV12_READER__SINGLE_BINDING ||
			childFeature == Csv12Package.Literals.CSV12_READER__LIST_BINDING ||
			childFeature == Csv12Package.Literals.CSV12_READER__MAP_BINDING;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2", //$NON-NLS-1$
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return Csv12EditPlugin.INSTANCE;
	}

}
