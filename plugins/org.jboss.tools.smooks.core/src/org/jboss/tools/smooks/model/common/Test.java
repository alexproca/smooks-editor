package org.jboss.tools.smooks.model.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.jboss.tools.smooks.model.common.util.CommonResourceFactoryImpl;
import org.jboss.tools.smooks.model.freemarker.FreemarkerPackage;
import org.jboss.tools.smooks.model.smooks.AbstractResourceConfig;
import org.jboss.tools.smooks.model.smooks.SmooksPackage;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Registry.INSTANCE.put(CommonPackage.eNS_URI, CommonPackage.eINSTANCE);
		Registry.INSTANCE.put(FreemarkerPackage.eNS_URI, FreemarkerPackage.eINSTANCE);
		Registry.INSTANCE.put(SmooksPackage.eNS_URI, SmooksPackage.eINSTANCE);
		
		
		Resource resource = new CommonResourceFactoryImpl().createResource(null);
		InputStream stream = Test.class.getResourceAsStream("/test/XSLConfig.xml"); //$NON-NLS-1$
		try {
			resource.load(stream, Collections.EMPTY_MAP);
			EObject obj = (EObject) resource.getContents().get(0);
			SmooksResourceListType sr = (SmooksResourceListType)obj.eContents().get(0);
//			List<?> list = sr.getAbstractReader();
			List<?> list1 = sr.getAbstractResourceConfig();
			for (Iterator<?> iterator = list1.iterator(); iterator.hasNext();) {
				AbstractResourceConfig arc = (AbstractResourceConfig) iterator.next();
				System.out.println(arc);
			}
			System.out.println(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
