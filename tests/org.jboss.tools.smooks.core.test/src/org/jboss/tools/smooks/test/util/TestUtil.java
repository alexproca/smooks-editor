package org.jboss.tools.smooks.test.util;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

public class TestUtil {
	
	public static final String TEST_BUNDLE_NAME = "org.jboss.tools.smooks.core.test";
	
	public static Bundle getSmooksCoreTestBundle() {
		return Platform.getBundle("org.jboss.tools.smooks.core.test");
	}
}
