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
package org.jboss.tools.smooks.configuration.editors.edireader12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.jboss.tools.smooks.configuration.editors.edireader12.Messages;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.configuration.editors.xml.TagList;
import org.jboss.tools.smooks.configuration.editors.xml.XMLObjectAnalyzer;
import org.jboss.tools.smooks.model.edi12.EDI12Reader;
import org.jboss.tools.smooks.model.smooks.AbstractReader;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;
import org.milyn.Smooks;
import org.milyn.smooks.edi.EDIReaderConfigurator;
import org.osgi.framework.Bundle;
import org.w3c.dom.Document;

/**
 * @author Dart
 * 
 */
public class EDIDataParser {
	public static final String USE_AVAILABEL_READER = "use_availableReader"; //$NON-NLS-1$

	public static final String ENCODING = "encoding"; //$NON-NLS-1$

	public static final Object MAPPING_MODEL = "mappingModelFile"; //$NON-NLS-1$

	public static final Object VALIDATE = "validate"; //$NON-NLS-1$

	public TagList parseEDIFile(InputStream stream, SmooksResourceListType resourceList, IProject project)
			throws IOException {
		List<AbstractReader> readers = resourceList.getAbstractReader();
		int count = 0;
		int index = -1;
		for (Iterator<?> iterator2 = readers.iterator(); iterator2.hasNext();) {
			AbstractReader abstractReader = (AbstractReader) iterator2.next();
			// if (abstractReader instanceof EDIReader) {
			// count++;
			// if (index == -1) {
			// index = readers.indexOf(abstractReader);
			// }
			// }
			if (abstractReader instanceof EDI12Reader) {
				count++;
				if (index == -1) {
					index = readers.indexOf(abstractReader);
				}
			}
		}

		if (count > 1) {
			// throw new
			// RuntimeException("The smooks config file should have only one JSON reader");
		}
		if (index != -1) {
			return parseEDIFile(stream, (EObject) readers.get(index), project);
		}
		return null;
	}

	public TagList parseEDIFile(InputStream stream, SmooksResourceListType resourceList) throws IOException {
		// String encoding = null;
		// String mappingModel = null;
		// String validate = null;
		// String type = inputType.getType();
		List<AbstractReader> readers = resourceList.getAbstractReader();
		int count = 0;
		int index = -1;
		for (Iterator<?> iterator2 = readers.iterator(); iterator2.hasNext();) {
			AbstractReader abstractReader = (AbstractReader) iterator2.next();
			if (abstractReader instanceof EDI12Reader) {
				count++;
				if (index == -1) {
					index = readers.indexOf(abstractReader);
				}
			}
		}

		if (count > 1) {
			// throw new
			// RuntimeException("The smooks config file should have only one JSON reader");
		}
		if (index != -1) {
			return parseEDIFile(stream, (EObject) readers.get(index));
		}
		return null;
		// return parseEDIFile(stream, mappingModel, encoding,validate,
		// resourceList);
	}

	public TagList parseEDIFile(InputStream ediInputStream, EObject readerObj, IProject project) throws IOException {
		String encoding = null;
		String mappingModel = null;
		String validate = null;
		// if (readerObj instanceof EDIReader) {
		// EDIReader reader = (EDIReader) readerObj;
		// encoding = reader.getEncoding();
		// mappingModel = reader.getMappingModel();
		// }
		if (readerObj instanceof EDI12Reader) {
			EDI12Reader reader = (EDI12Reader) readerObj;
			encoding = reader.getEncoding();
			mappingModel = reader.getMappingModel();
		}
		return parseEDIFile(ediInputStream, mappingModel, encoding, validate, project);
	}

	public TagList parseEDIFile(InputStream ediInputStream, EObject readerObj) throws IOException {

		String encoding = null;
		String mappingModel = null;
		// if (readerObj instanceof EDIReader) {
		// EDIReader reader = (EDIReader) readerObj;
		// encoding = reader.getEncoding();
		// mappingModel = reader.getMappingModel();
		// }
		if (readerObj instanceof EDI12Reader) {
			EDI12Reader reader = (EDI12Reader) readerObj;
			encoding = reader.getEncoding();
			mappingModel = reader.getMappingModel();
		}
		return parseEDIFile(ediInputStream, mappingModel, encoding, null, (EObject) readerObj);
	}

	public TagList parseEDIFile(InputStream ediInputStream, String mappingModel, String ediFileEncoding,
			String validate, EObject emodel) throws IOException {
		IResource resource = SmooksUIUtils.getResource(emodel);
		IProject project = null;
		if (resource != null) {
			project = resource.getProject();
		}
		return parseEDIFile(ediInputStream, mappingModel, ediFileEncoding, validate, project);
	}

	public TagList parseEDIFile(InputStream ediInputStream, String mappingModel, String ediFileEncoding,
			String validate, IProject project) throws IOException {
		Smooks smooks = new Smooks();

		// SmooksResourceConfiguration readerConfig = new
		// SmooksResourceConfiguration("org.xml.sax.driver",
		// SmooksEDIReader.class.getName());

		if (mappingModel == null) {
			throw new RuntimeException(Messages.EDIDataParser_Exception_EDI_Mapping_Cannot_Be_Empty);
		}
		// If the MappingModel is absolute file path :
		File f = new File(mappingModel);
		String modelPath = mappingModel;
		if (f.exists()) {
			modelPath = f.toURI().toString();
		} else {
			// If the MappingModel isn't the absolute file path , find the file
			// via Project
			IFile tf = SmooksUIUtils.getFile(mappingModel, project);
			if (tf != null) {
				modelPath = tf.getLocation().toFile().toURI().toString();
			} else {
				// If we can't find the File , it means that this codes was
				// running under the test platform , so the configuration file
				// is in the smooks.core.test project.
				// the MappingModel path is the "classpath" format , so I can
				// get the "smooks.core.test" bundle and find the file via
				// MappingModel.

				/* this codes are for the plug-in unit tests */
				Bundle bundle = Platform.getBundle("org.jboss.tools.smooks.core.test"); //$NON-NLS-1$
				if (bundle != null) {
					URL ur = bundle.getEntry("/src" + mappingModel); //$NON-NLS-1$
					if (ur != null) {
						try {
							ur = FileLocator.resolve(ur);
							modelPath = ur.toURI().toString();
						} catch (URISyntaxException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		EDIReaderConfigurator readerConfig = new EDIReaderConfigurator(modelPath);
		if (ediFileEncoding == null || ediFileEncoding.trim().length() == 0) {
			ediFileEncoding = "UTF-8"; //$NON-NLS-1$
		}
		// readerConfig.
		// readerConfig.setParameter("encoding", ediFileEncoding);

		smooks.setReaderConfig(readerConfig);
		// SmooksUtil.registerResource(readerConfig, smooks);

		// Use a DOM result to capture the message model for the supplied
		// CSV
		// message...

		// Filter the message through Smooks and capture the result as a DOM
		// in
		// the domResult instance...
		// FileInputStream stream
		DOMResult result = new DOMResult();
		smooks.filterSource(new StreamSource(ediInputStream), result);
		Document resultXMLContent = (Document) result.getNode();
		XMLObjectAnalyzer analyzer = new XMLObjectAnalyzer();
		TagList tagList = analyzer.analyze(resultXMLContent, null , null);

		try {
			if (smooks != null) {
				smooks.close();
				smooks = null;
			}
			if (ediInputStream != null) {
				ediInputStream.close();
				ediInputStream = null;
			}
			result = null;
		} catch (Throwable t) {
			t.printStackTrace();
		}

		return tagList;
	}

	public TagList parseEDIFile(String path, SmooksResourceListType smooksResourceListType)
			throws InvocationTargetException, FileNotFoundException, IOException {
		String filePath = SmooksUIUtils.parseFilePath(path);

		return parseEDIFile(new FileInputStream(filePath), smooksResourceListType);
	}
}
