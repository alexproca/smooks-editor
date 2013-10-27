/*******************************************************************************
 * Copyright (c) 2009 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.smooks.configuration.editors;

import org.eclipse.core.resources.IFile;
import org.jboss.tools.smooks.configuration.editors.xml.AbstractFileSelectionWizardPage;

/**
 * @author Dart Peng (dpeng@redhat.com) Date Apr 13, 2009
 */
public class FileSelectionWizardPage extends AbstractFileSelectionWizardPage {

	private ProtableFileStringProcessor processor = null;
	
	private boolean processFilePath = true;

	public FileSelectionWizardPage(String pageName, Object[] initSelection , boolean processFilePath) {
		super(pageName, new String[] {});
		processor = new ProtableFileStringProcessor();
		setFilePathProcessor(processor);
		setTitle(Messages.FileSelectionWizardPage_PageTitle);
		setDescription(Messages.FileSelectionWizardPage_PageDescription);
		this.processFilePath = processFilePath;
//		this.getShell().setText("Select Files");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.xml.
	 * AbstractFileSelectionWizardPage#loadedTheObject(java.lang.String)
	 */
	@Override
	protected Object loadedTheObject(String path) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processFileSystemFilePath(String path) {
		if(!processFilePath) return super.processFileSystemFilePath(path);
		if (getFilePathProcessor() != null) {
			String s = getFilePathProcessor().processFileSystemPath(path);
			if (s != null) {
				return s;
			}
		}
		return this.processor.processFileSystemPath(path);
	}

	@Override
	protected String processWorkSpaceFilePath(IFile file) {
		if(!processFilePath) return super.processWorkSpaceFilePath(file);
		if (getFilePathProcessor() != null) {
			String s = getFilePathProcessor().processWorkBenchPath(file);
			if (s != null) {
				return s;
			}
		}
		return this.processor.processWorkBenchPath(file);
	}

	private class ProtableFileStringProcessor implements IFilePathProcessor {

		public String processWorkBenchPath(IFile file) {
			String s = file.getFullPath().toPortableString();
			return s;
		}

		public String processFileSystemPath(String filePath) {
			return filePath;
		}

	}

}
