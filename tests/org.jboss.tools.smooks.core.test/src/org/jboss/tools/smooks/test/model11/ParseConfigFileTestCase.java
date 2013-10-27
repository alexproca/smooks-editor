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
package org.jboss.tools.smooks.test.model11;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;

import junit.framework.Assert;

import org.eclipse.emf.ecore.resource.Resource;
import org.jboss.tools.smooks.model.smooks.DocumentRoot;
import org.jboss.tools.smooks.model.smooks.util.SmooksResourceFactoryImpl;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class ParseConfigFileTestCase extends AbstractSmooks11ModelTestCase {

	@Override
	protected void loadConfigFile() throws IOException {
		// do nothing
	}

	@Override
	protected InputStream getConfigFileContents() {
		return null;
	}

	@Override
	protected String getFilePath() {
		// TODO Auto-generated method stub
		return null;
	}

	private void loadFile(File file) throws IOException {
		if (file.exists() && file.isDirectory() && !file.getName().equals(".svn")) {
			File[] configFiles = file.listFiles();
			for (int i = 0; i < configFiles.length; i++) {
				File configFile = configFiles[i];
				if (configFile.isFile()) {
					FileInputStream inputStream = new FileInputStream(configFile);
					Resource smooksResource = new SmooksResourceFactoryImpl().createResource(null);
					if (inputStream != null) {
						smooksResource.load(inputStream, Collections.emptyMap());
						smooksModel = smooksResource.getContents().get(0);
						Assert.assertNotNull(smooksModel);
						Assert.assertTrue(smooksModel instanceof org.jboss.tools.smooks.model.medi.DocumentRoot
								|| smooksModel instanceof DocumentRoot);
						if (smooksModel instanceof DocumentRoot) {
							System.out.println("load smooks 1.1.2 config file : \"" + file.getName() + "/"
									+ configFile.getName() + "\" success.");
						}
						if (smooksModel instanceof org.jboss.tools.smooks.model.medi.DocumentRoot) {
							System.out.println("load edi-message-mapping-1.0 file config file : \"" + file.getName()
									+ "/" + configFile.getName() + "\" success.");
						}
						// if (smooksModel instanceof
						// org.jboss.tools.smooks10.model.smooks.DocumentRoot) {
						// System.out.println("load smooks 1.0 config file : \""
						// + file.getName() +"/"+ configFile.getName()
						// + "\" success.");
						// }
					}
				}

				if (configFile.isDirectory()) {
					loadFile(configFile);
				}
			}
		}
	}

	public void testParseConfigFile() throws IOException {
		URL configFileFolder = this.getClass().getClassLoader().getResource(
				"org/jboss/tools/smooks/test/model/configfiles");
		File file = new File(configFileFolder.getFile());
		loadFile(file);
	}
}
