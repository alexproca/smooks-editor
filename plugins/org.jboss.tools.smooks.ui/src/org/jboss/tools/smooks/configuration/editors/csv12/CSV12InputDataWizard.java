/**
 * 
 */
package org.jboss.tools.smooks.configuration.editors.csv12;

import java.math.BigInteger;
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
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.configuration.editors.SmooksMultiFormEditor;
import org.jboss.tools.smooks.configuration.editors.csv12.CSV12DataConfigurationWizardPage.FieldString;
import org.jboss.tools.smooks.configuration.editors.uitls.JsonInputDataParser;
import org.jboss.tools.smooks.configuration.editors.wizard.IStructuredDataSelectionWizard;
import org.jboss.tools.smooks.model.csv12.CSV12Reader;
import org.jboss.tools.smooks.model.csv12.Csv12Factory;
import org.jboss.tools.smooks.model.csv12.Csv12Package;
import org.jboss.tools.smooks.model.smooks.DocumentRoot;
import org.jboss.tools.smooks.model.smooks.SmooksPackage;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;

/**
 * @deprecated
 * @author Dart
 * 
 */
public class CSV12InputDataWizard extends Wizard implements IStructuredDataSelectionWizard, INewWizard {

	private SmooksResourceListType resourceList;

	private EditingDomain editingDomain;

	private CSV12DataConfigurationWizardPage configPage;

	private CSV12DataPathWizardPage pathPage;

	public CSV12InputDataWizard() {
		super();
		this.setWindowTitle(Messages.CSV12InputDataWizard_0);
	}

	@Override
	public void addPages() {
		// if (configPage == null) {
		// configPage = new
		// CSV12DataConfigurationWizardPage("CSV Configurations Page");
		// configPage.setSmooksResourceList(resourceList);
		// }

		if (pathPage == null) {
			pathPage = new CSV12DataPathWizardPage(Messages.CSV12InputDataWizard_1, new String[] { Messages.CSV12InputDataWizard_ExtensionName }, configPage); //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-1$ //$NON-NLS-1$ //$NON-NLS-1$ //$NON-NLS-1$ //$NON-NLS-1$
		}

		this.addPage(pathPage);
		// this.addPage(configPage);
		super.addPages();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		if (configPage != null) {
			boolean createCSVReader = configPage.isCreateCSVReader();
			if (createCSVReader) {
				CSV12Reader reader = Csv12Factory.eINSTANCE.createCSV12Reader();

				String encoding = configPage.getEncoding();
				reader.setEncoding(encoding);

				String separator = configPage.getSeparator();
				reader.setSeparator(separator);

				String skipLines = configPage.getSkipLines();
				long skip = -1;
				try {
					skip = Long.parseLong(skipLines);
				} catch (Throwable t) {

				}
				if (skip >= 0) {
					reader.setSkipLines(BigInteger.valueOf(skip));
				}

				String quoteChar = configPage.getQuoteChar();
				reader.setQuote(quoteChar);

				String rootName = configPage.getRootName();
				if (rootName != null) {
					reader.setRootElementName(rootName);
				}

				String recordName = configPage.getRecordName();
				if (recordName != null) {
					reader.setRecordElementName(recordName);
				}

				String indent = configPage.getIndent();
				if (indent != null && indent.length() != 0) {
					boolean indentValue = Boolean.valueOf(indent).booleanValue();
					reader.setIndent(indentValue);
				}

				String fields = null;
				List<FieldString> fieldList = configPage.getFieldsList();
				if (fieldList != null && !fieldList.isEmpty()) {
					fields = ""; //$NON-NLS-1$
					for (Iterator<?> iterator = fieldList.iterator(); iterator.hasNext();) {
						FieldString fieldString = (FieldString) iterator.next();
						String f = fieldString.getText();
						fields += (f + ","); //$NON-NLS-1$
					}
					if (fields.length() > 1) {
						fields = fields.substring(0, fields.length() - 1);
					}
				}
				reader.setFields(fields);
				Command command = AddCommand.create(editingDomain, resourceList,
						SmooksPackage.Literals.SMOOKS_RESOURCE_LIST_TYPE__ABSTRACT_READER_GROUP, FeatureMapUtil
								.createEntry(Csv12Package.Literals.CSV12_DOCUMENT_ROOT__READER, reader));
				editingDomain.getCommandStack().execute(command);

			}
		}
		return true;
	}

	public boolean canFinish() {
		if (pathPage != null) {
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
		return SmooksModelUtils.INPUT_TYPE_CSV;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.wizard.
	 * IStructuredDataSelectionWizard#getProperties()
	 */
	public Properties getProperties() {
		Properties pro = new Properties();
		fillProperties(pro);
		return pro;
	}

	private void fillProperties(Properties pro) {
		if (configPage != null) {
			boolean createCSVReader = configPage.isCreateCSVReader();
			boolean useAvailabelReader = configPage.isUseAvailabelReader();

			if (useAvailabelReader || createCSVReader) {
				pro.put(CSVDataParser.LINK_CSV_READER, "true"); //$NON-NLS-1$
				return;
			}

			String fields = null;
			List<FieldString> fieldList = configPage.getFieldsList();
			if (fieldList != null && !fieldList.isEmpty()) {
				fields = ""; //$NON-NLS-1$
				for (Iterator<?> iterator = fieldList.iterator(); iterator.hasNext();) {
					FieldString fieldString = (FieldString) iterator.next();
					String f = fieldString.getText();
					fields += (f + ","); //$NON-NLS-1$
				}
				if (fields.length() > 1) {
					fields = fields.substring(0, fields.length() - 1);
				}
			}

			if (fields != null && fields.length() != 0) {
				pro.put(CSVDataParser.FIELDS, fields);
			}

			String encoding = configPage.getEncoding();
			if (encoding != null && encoding.length() != 0) {
				pro.put(CSVDataParser.ENCODING, encoding);
			}

			String separator = configPage.getSeparator();
			if (separator != null && separator.length() != 0) {
				pro.put(CSVDataParser.SEPARATOR, separator);
			}

			String quoteChar = configPage.getQuoteChar();
			if (quoteChar != null && quoteChar.length() != 0) {
				pro.put(CSVDataParser.QUOTECHAR, quoteChar);
			}

			String rootName = configPage.getRootName();
			if (rootName != null && rootName.length() != 0) {
				pro.put(CSVDataParser.ROOT_ELEMENT_NAME, rootName);
			}

			String recordName = configPage.getRecordName();
			if (recordName != null && recordName.length() != 0) {
				pro.put(CSVDataParser.RECORD_NAME, recordName);
			}

			String skiplines = configPage.getSkipLines();
			if (skiplines != null && skiplines.length() != 0) {
				pro.put(CSVDataParser.SKIPLINES, skiplines);
			}

			String indent = configPage.getIndent();
			if (indent != null && indent.length() != 0) {
				pro.setProperty(JsonInputDataParser.INDENT, indent);
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
		if(pathPage != null && input != null){
			if(input instanceof IFileEditorInput){
				pathPage.setInitSelections(new Object[]{((IFileEditorInput)input).getFile().getParent()});
			}
		}
		if (configPage != null) {
			configPage.setSmooksResourceList(resourceList);
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
