/**
 * 
 */
package org.jboss.tools.smooks.core;

import java.io.File;

/**
 * @author DartPeng
 * 
 */
public class XSDFileCollect {
	public static void main(String[] args) {
		String path = "/home/DartPeng/Work/eclipse/smooks-configuration-workspace/org.jboss.tools.smooks.core/xsd"; //$NON-NLS-1$
		File folder = new File(path);
		File[] files = folder.listFiles();
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			if (file.isFile()) {
				String name = file.getName();
				if(name.endsWith(".xsd")){ //$NON-NLS-1$
					System.out.println(file.getName());
				}
			}
		}
	}
}
