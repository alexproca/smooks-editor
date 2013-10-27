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
package org.jboss.tools.smooks.configuration.editors.json12;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.configuration.editors.SmooksMultiFormEditor;
import org.jboss.tools.smooks.configuration.editors.json12.Json12DataConfiguraitonWizardPage.KeyValueModel;
import org.jboss.tools.smooks.configuration.editors.uitls.JsonInputDataParser;
import org.jboss.tools.smooks.configuration.editors.wizard.IStructuredDataSelectionWizard;
import org.jboss.tools.smooks.model.json12.Json12Factory;
import org.jboss.tools.smooks.model.json12.Json12Package;
import org.jboss.tools.smooks.model.json12.Json12Reader;
import org.jboss.tools.smooks.model.json12.Key;
import org.jboss.tools.smooks.model.json12.KeyMap;
import org.jboss.tools.smooks.model.smooks.DocumentRoot;
import org.jboss.tools.smooks.model.smooks.SmooksPackage;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;

/**
 * @deprecated
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class Json12DataWizard extends Wizard implements IStructuredDataSelectionWizard, INewWizard {

	private Json12DataPathWizardPage pathPage = null;

	private Json12DataConfiguraitonWizardPage configPage = null;

	private SmooksResourceListType resourceList;

	private EditingDomain editingDomain;

	public Json12DataWizard() {
		super();
		this.setWindowTitle(Messages.Json12DataWizard_WizardTitle);
	}

	public boolean canFinish() {
		if(pathPage != null){
			return pathPage.isPageComplete();
		}
		if (configPage != null && pathPage != null) {
			if (configPage.isPageComplete() && pathPage.isPageComplete())
				return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		super.addPages();
		if (pathPage == null) {
			pathPage = new Json12DataPathWizardPage(Messages.Json12DataWizard_WizardDes, new String[] {});

		}
//		if (configPage == null) {
//			configPage = new Json12DataConfiguraitonWizardPage("Json data configuration page");
//			configPage.setSmooksResourceList(resourceList);
//		}
		this.addPage(pathPage);
//		this.addPage(configPage);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		if (editingDomain == null || resourceList == null) {
			return true;
		}
		if (configPage != null && configPage.isCreateJsonReader()) {
			List<KeyValueModel> keyMapList = configPage.getKeyValueList();

			Json12Reader reader = Json12Factory.eINSTANCE.createJson12Reader();
			if (keyMapList != null && !keyMapList.isEmpty()) {
				KeyMap map = Json12Factory.eINSTANCE.createKeyMap();
				for (Iterator<?> iterator = keyMapList.iterator(); iterator.hasNext();) {
					KeyValueModel keyValueModel = (KeyValueModel) iterator.next();
					String key = keyValueModel.getKey();
					String value = keyValueModel.getValue();
					Key k = Json12Factory.eINSTANCE.createKey();
					k.setFrom(key);
					k.setTo(value);
					map.getKey().add(k);
				}
				reader.setKeyMap(map);
			}

			String aen = configPage.getArrayElementName();
			if (aen != null && aen.length() != 0) {
				reader.setArrayElementName(aen);
			}

			String rn = configPage.getRootName();
			if (rn != null && rn.length() != 0) {
				reader.setRootName(rn);
			}

			String encoding = configPage.getEncoding();
			if (encoding != null && encoding.length() != 0) {
				reader.setEncoding(encoding);
			}

			String sr = configPage.getKeyWhitspaceReplacement();
			if (sr != null && sr.length() != 0) {
				reader.setKeyWhitspaceReplacement(sr);
			}

			String pon = configPage.getKeyPrefixOnNumeric();
			if (pon != null && pon.length() != 0) {
				reader.setKeyPrefixOnNumeric(pon);
			}

			String nvr = configPage.getNullValueReplacement();
			if (nvr != null && nvr.length() != 0) {
				reader.setNullValueReplacement(nvr);
			}

			String ier = configPage.getIllegalElementNameCharReplacement();
			if (ier != null && ier.length() != 0) {
				reader.setIllegalElementNameCharReplacement(ier);
			}
			String indent = configPage.getIndent();
			if (indent != null && indent.length() != 0) {
				boolean indentValue = Boolean.valueOf(indent).booleanValue();
				reader.setIndent(indentValue);
			}

			Command command = AddCommand.create(editingDomain, resourceList,
					SmooksPackage.Literals.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_READER_GROUP, FeatureMapUtil
							.createEntry(Json12Package.Literals.JSON12_DOCUMENT_ROOT__READER, reader));
			editingDomain.getCommandStack().execute(command);
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 * org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.wizard.
	 * IStructuredDataSelectionWizard#getInputDataTypeID()
	 */
	public String getInputDataTypeID() {
		// TODO Auto-generated method stub
		return SmooksModelUtils.INPUT_TYPE_JSON_1_2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.wizard.
	 * IStructuredDataSelectionWizard#getProperties()
	 */
	public Properties getProperties() {
		Properties properties = new Properties();
		fillProperties(properties);
		return properties;
	}

	private void fillProperties(Properties p) {
		if (configPage != null) {

			boolean createJsonReader = configPage.isCreateJsonReader();
			boolean useJsonReader = configPage.isUseAvailabelReader();
			if (createJsonReader || useJsonReader) {
				p.setProperty(JsonInputDataParser.LINK_JSON_READER, "true"); //$NON-NLS-1$
				return;
			}

			List<KeyValueModel> keyMapList = configPage.getKeyValueList();
			for (Iterator<?> iterator = keyMapList.iterator(); iterator.hasNext();) {
				KeyValueModel keyValueModel = (KeyValueModel) iterator.next();
				String key = keyValueModel.getKey();
				String value = keyValueModel.getValue();
				p.setProperty(JsonInputDataParser.KEY + key, value);
			}

			String aen = configPage.getArrayElementName();
			if (aen != null && aen.length() != 0) {
				p.setProperty(JsonInputDataParser.ARRAY_ELEMENT_NAME, aen);
			}

			String rn = configPage.getRootName();
			if (rn != null && rn.length() != 0) {
				p.setProperty(JsonInputDataParser.ROOT_NAME, rn);
			}

			String encoding = configPage.getEncoding();
			if (encoding != null && encoding.length() != 0) {
				p.setProperty(JsonInputDataParser.ENCODING2, encoding);
			}

			String sr = configPage.getKeyWhitspaceReplacement();
			if (sr != null && sr.length() != 0) {
				p.setProperty(JsonInputDataParser.SPACE_REPLACE, sr);
			}

			String pon = configPage.getKeyPrefixOnNumeric();
			if (pon != null && pon.length() != 0) {
				p.setProperty(JsonInputDataParser.PREFIX_ON_NUMERIC, pon);
			}

			String nvr = configPage.getNullValueReplacement();
			if (nvr != null && nvr.length() != 0) {
				p.setProperty(JsonInputDataParser.NULL_REPLACE, nvr);
			}

			String ier = configPage.getIllegalElementNameCharReplacement();
			if (ier != null && ier.length() != 0) {
				p.setProperty(JsonInputDataParser.ILLEGAL_REPLACE, ier);
			}

			String indent = configPage.getIndent();
			if (indent != null && indent.length() != 0) {
				p.setProperty(JsonInputDataParser.INDENT, indent);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.wizard.
	 * IStructuredDataSelectionWizard#getReturnData()
	 */
	public Object getReturnData() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.wizard.
	 * IStructuredDataSelectionWizard#getStructuredDataSourcePath()
	 */
	public String getStructuredDataSourcePath() {
		if (pathPage != null) {
			return pathPage.getFilePath();
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
		if (configPage != null) {
			configPage.setSmooksResourceList(resourceList);
		}
	}

	public void complate(SmooksMultiFormEditor formEditor) {

	}
}
