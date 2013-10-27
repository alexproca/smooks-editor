/**
 * 
 */
package org.jboss.tools.smooks.test.model11;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EPackage.Registry;
import org.jboss.tools.smooks.model.common.CommonPackage;
import org.jboss.tools.smooks.model.csv12.Csv12Package;
import org.jboss.tools.smooks.model.edi12.Edi12Package;
import org.jboss.tools.smooks.model.freemarker.FreemarkerPackage;
import org.jboss.tools.smooks.model.javabean12.Javabean12Package;
import org.jboss.tools.smooks.model.json12.Json12Package;
import org.jboss.tools.smooks.model.medi.MEdiPackage;
import org.jboss.tools.smooks.model.smooks.SmooksPackage;

/**
 * @author Dart
 *
 */
public class BaseTestCase extends TestCase {
	static {
		// regist emf model uri mapping 
		
		// smooks 1.2
		Registry.INSTANCE.put(Javabean12Package.eNS_URI, Javabean12Package.eINSTANCE);
		Registry.INSTANCE.put(Json12Package.eNS_URI, Json12Package.eINSTANCE);
		Registry.INSTANCE.put(Csv12Package.eNS_URI, Csv12Package.eINSTANCE);
		Registry.INSTANCE.put(Edi12Package.eNS_URI, Edi12Package.eINSTANCE);
		// smooks 1.1.2 and smooks 1.0
		Registry.INSTANCE.put(SmooksPackage.eNS_URI, SmooksPackage.eINSTANCE);
		Registry.INSTANCE.put(CommonPackage.eNS_URI, CommonPackage.eINSTANCE);

		Registry.INSTANCE.put(FreemarkerPackage.eNS_URI, FreemarkerPackage.eINSTANCE);
		Registry.INSTANCE.put(MEdiPackage.eNS_URI, MEdiPackage.eINSTANCE);
	}
	public void testNull(){//ignore
	}
}
