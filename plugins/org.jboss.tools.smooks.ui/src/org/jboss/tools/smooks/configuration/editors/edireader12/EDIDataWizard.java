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

import java.util.Properties;

import org.eclipse.core.resources.IContainer;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.configuration.editors.SmooksMultiFormEditor;
import org.jboss.tools.smooks.configuration.editors.edireader12.EDIDataParser;
import org.jboss.tools.smooks.configuration.editors.edireader12.EDIMappingDataPathWizardPage;
import org.jboss.tools.smooks.configuration.editors.edireader12.Messages;
import org.jboss.tools.smooks.configuration.editors.wizard.IStructuredDataSelectionWizard;
import org.jboss.tools.smooks.model.smooks.DocumentRoot;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;

/**
 * @author Dart
 * 
 */
public class EDIDataWizard extends Wizard implements IStructuredDataSelectionWizard, INewWizard {

	private EDIMappingDataPathWizardPage mappingFilePage;

	private EDIDataPathWizardPage ediFilePage;

	private SmooksResourceListType resourceList;

	private EditingDomain editingDomain;

	private IContainer folder = null;
	
	

	public EDIDataWizard() {
		super();
		this.setWindowTitle(Messages.EDIDataWizard_WizardTitle);
	}

	@Override
	public void addPages() {
		ediFilePage = new EDIDataPathWizardPage(Messages.EDIDataWizard_0, new String[] { Messages.EDIDataWizard_2 }); //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-1$ //$NON-NLS-1$ //$NON-NLS-1$
		this.addPage(ediFilePage);
		if (folder != null) {
			ediFilePage.setInitSelections(new Object[] { folder });
		}

		// mappingFilePage = new EDIMappingDataPathWizardPage("EDI Config Page",
		// null);
		// this.addPage(mappingFilePage);
		super.addPages();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		if (mappingFilePage != null) {
			if (mappingFilePage.isUseAvaliableReader()) {
				return true;
			}
			if (mappingFilePage.isCreateNewReader()) {
				String encoding = mappingFilePage.getEncoding();
				String path = mappingFilePage.getFilePath();
//				EDIReader reader = EdiFactory.eINSTANCE.createEDIReader();
//				reader.setEncoding(encoding);
//				reader.setMappingModel(path);
//				Command command = AddCommand.create(editingDomain, resourceList,
//						SmooksPackage.Literals.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_READER_GROUP, FeatureMapUtil
//								.createEntry(EdiPackage.Literals.EDI_DOCUMENT_ROOT__READER, reader));
//				editingDomain.getCommandStack().execute(command);
			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.wizard.
	 * IStructuredDataSelectionWizard
	 * #complate(org.jboss.tools.smooks.configuration
	 * .editors.SmooksMultiFormEditor)
	 */
	public void complate(SmooksMultiFormEditor formEditor) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.wizard.
	 * IStructuredDataSelectionWizard#getInputDataTypeID()
	 */
	public String getInputDataTypeID() {
		return SmooksModelUtils.INPUT_TYPE_EDI_1_1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.wizard.
	 * IStructuredDataSelectionWizard#getProperties()
	 */
	public Properties getProperties() {
		Properties pros = new Properties();
		if (mappingFilePage != null) {
			if (mappingFilePage.isUseAvaliableReader() || mappingFilePage.isCreateNewReader()) {
				pros.put(EDIDataParser.USE_AVAILABEL_READER, "true"); //$NON-NLS-1$
				return pros;
			}

			String encoding = mappingFilePage.getEncoding();
			pros.put(EDIDataParser.ENCODING, encoding);
			String path = mappingFilePage.getFilePath();
			pros.put(EDIDataParser.MAPPING_MODEL, path);
		}
		return pros;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.wizard.
	 * IStructuredDataSelectionWizard#getReturnData()
	 */
	public Object getReturnData() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.wizard.
	 * IStructuredDataSelectionWizard#getStructuredDataSourcePath()
	 */
	public String getStructuredDataSourcePath() {
		if (ediFilePage.getFilePath() != null) {
			return ediFilePage.getFilePath();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.wizard.
	 * IStructuredDataSelectionWizard#init(org.eclipse.ui.IEditorSite,
	 * org.eclipse.ui.IEditorInput)
	 */
	public void init(IEditorSite site, IEditorInput input) {
		IEditorPart editorPart = site.getWorkbenchWindow().getActivePage().findEditor(input);
		if (editorPart != null && editorPart instanceof SmooksMultiFormEditor) {
			SmooksMultiFormEditor formEditor = (SmooksMultiFormEditor) editorPart;
			Object smooksModel = formEditor.getSmooksModel();
			if (smooksModel instanceof DocumentRoot) {
				resourceList = ((DocumentRoot) smooksModel).getSmooksResourceList();
			}
			editingDomain = formEditor.getEditingDomain();
		}
		folder = ((IFileEditorInput) input).getFile().getParent();
		if (ediFilePage != null && folder != null) {
			ediFilePage.setInitSelections(new Object[] { folder });
		}
		if (this.mappingFilePage != null) {
			mappingFilePage.setSmooksResourceList(resourceList);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 * org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {

	}

}
