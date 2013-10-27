package org.jboss.tools.smooks.core;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class SmooksCoreActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.jboss.tools.smooks.core"; //$NON-NLS-1$

	// The shared instance
	private static SmooksCoreActivator plugin;
	
	/**
	 * The constructor
	 */
	public SmooksCoreActivator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static SmooksCoreActivator getDefault() {
		return plugin;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#initializeImageRegistry(org.eclipse.jface.resource.ImageRegistry)
	 */
	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		super.initializeImageRegistry(reg);
		reg.put("BindingsType",imageDescriptorFromPlugin(PLUGIN_ID, "/icons/full/obj16/BindingsType.gif")); //$NON-NLS-1$ //$NON-NLS-2$
		reg.put("ExpressionType",imageDescriptorFromPlugin(PLUGIN_ID, "/icons/full/obj16/ExpressionType.gif")); //$NON-NLS-1$ //$NON-NLS-2$
		reg.put("ValueType",imageDescriptorFromPlugin(PLUGIN_ID, "/icons/full/obj16/ValueType.gif")); //$NON-NLS-1$ //$NON-NLS-2$
		reg.put("WiringType",imageDescriptorFromPlugin(PLUGIN_ID, "/icons/full/obj16/WiringType.gif")); //$NON-NLS-1$ //$NON-NLS-2$
	}
}