/**
 * 
 */
package org.jboss.tools.smooks.configuration.editors;


/**
 * @author Dart
 *
 */
public class SelectorAttributes {
	public static final String ONLY_NAME = "only_name"; //$NON-NLS-1$

	public static final String FULL_PATH = "full_path"; //$NON-NLS-1$

	public static final String IGNORE_ROOT = "ignore_root"; //$NON-NLS-1$

	public static final String INCLUDE_PARENT = "include_parent"; //$NON-NLS-1$
	private String selectorSperator = "/"; //$NON-NLS-1$
	private String selectorPolicy = SelectorAttributes.FULL_PATH;
	public String getSelectorSperator() {
		return selectorSperator;
	}
	public void setSelectorSperator(String selectorSperator) {
		this.selectorSperator = selectorSperator;
	}
	public String getSelectorPolicy() {
		return selectorPolicy;
	}
	public void setSelectorPolicy(String selectorPolicy) {
		this.selectorPolicy = selectorPolicy;
	}
	
	
}
