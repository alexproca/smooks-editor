/*******************************************************************************
 * Copyright (c) 2008 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.smooks.graphical.actions;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;
import org.jboss.tools.smooks.configuration.SmooksConstants;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;

/**
 * @author Dart
 * 
 */
public abstract class AddSmooksObjectAction extends AddSmooksModelAction {

	private ISmooksModelProvider provider;

	public AddSmooksObjectAction(IWorkbenchPart part, int style, ISmooksModelProvider provider) {
		super(part, style);
		this.provider = provider;
		this.setText(getActionText());
		this.setImageDescriptor(getActionImageDescriptor());
	}

	public AddSmooksObjectAction(IWorkbenchPart part, ISmooksModelProvider provider) {
		super(part);
		this.provider = provider;
		this.setText(getActionText());
		this.setImageDescriptor(getActionImageDescriptor());
	}
	
	

	
	/* (non-Javadoc)
	 * @see org.jboss.tools.smooks.graphical.actions.AddSmooksModelAction#init()
	 */
	@Override
	protected void init() {
		
	}

	/**
	 * @return the provider
	 */
	protected ISmooksModelProvider getProvider() {
		return provider;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.graphical.actions.AddSmooksModelAction#
	 * getActionImageDescriptor()
	 */
	@Override
	public ImageDescriptor getActionImageDescriptor() {
		Object object = getNewObject();
		if(object == null) return null;
		object = AdapterFactoryEditingDomain.unwrap(object);
		AdapterFactoryEditingDomain editDomain = (AdapterFactoryEditingDomain) provider.getEditingDomain();
		IItemLabelProvider itemLabelProvider = (IItemLabelProvider) editDomain.getAdapterFactory().adapt(object,
				IItemLabelProvider.class);
		ImageDescriptor smallImage = null;
		if (itemLabelProvider != null) {
			Object imageObj = itemLabelProvider.getImage(object);
			smallImage = ExtendedImageRegistry.getInstance().getImageDescriptor(imageObj);
		}
		return smallImage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.graphical.actions.AddSmooksModelAction#getActionText
	 * ()
	 */
	@Override
	public String getActionText() {
		Object object = getNewObject();
		if(object == null) return ""; //$NON-NLS-1$
		object = AdapterFactoryEditingDomain.unwrap(object);
		AdapterFactoryEditingDomain editDomain = (AdapterFactoryEditingDomain) provider.getEditingDomain();
		IItemLabelProvider itemLabelProvider = (IItemLabelProvider) editDomain.getAdapterFactory().adapt(object,
				IItemLabelProvider.class);
		if (itemLabelProvider != null) {
			return itemLabelProvider.getText(object);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.graphical.actions.AddSmooksModelAction#
	 * getCreationFactory()
	 */
	@Override
	protected CreationFactory getCreationFactory() {
		return new SmooksObjectCreationFactory(getNewObject(), getNewType());
	}
	
	
	protected abstract Object getSmooks12Object();
	
	
	protected abstract Object getSmooks12Type();

	protected Object getNewObject() {
//		SmooksGraphicsExtType ext = this.getProvider().getSmooksGraphicsExt();
//		if (ext == null)
//			return null;
		String version = this.getProvider().getPlatformVersion();
		if (SmooksConstants.VERSION_1_2.equals(version)) {
			return getSmooks12Object();
		}
		return null;
	}

	protected Object getNewType() {
//		SmooksGraphicsExtType ext = this.getProvider().getSmooksGraphicsExt();
//		if (ext == null)
//			return null;
		String version = this.getProvider().getPlatformVersion();
		if (SmooksConstants.VERSION_1_2.equals(version)) {
			return getSmooks12Type();
		}
		return null;
	}

	private class SmooksObjectCreationFactory implements CreationFactory {
		private Object newObject;

		private Object objectType;

		public SmooksObjectCreationFactory(Object newObject, Object objectType) {
			this.newObject = newObject;
			this.objectType = objectType;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.gef.requests.CreationFactory#getNewObject()
		 */
		public Object getNewObject() {
			// TODO Auto-generated method stub
			return newObject;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.gef.requests.CreationFactory#getObjectType()
		 */
		public Object getObjectType() {
			// TODO Auto-generated method stub
			return objectType;
		}
	}

}
