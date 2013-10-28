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
package org.jboss.tools.smooks.configuration.editors.xml;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xsd.XSDElementDeclaration;
import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.configuration.editors.utils.SmooksUIUtils;
import org.jboss.tools.smooks.templating.model.ModelBuilderException;
import org.jboss.tools.smooks.templating.model.xml.XSDModelBuilder;
import org.xml.sax.SAXException;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class XMLTemplateCreationWizardPage extends AbstractFileSelectionWizardPage {

	private Throwable parsingError = null;

	protected Combo createFromDropdown = null;

	protected CheckboxTableViewer tableViewer = null;
	protected Label tableViewerLabel;

	private boolean fireEvent = true;

	private String rootElementName = null;

	protected Button loadXSDButton;
	
	private TemplateSourceType templateSourceType = TemplateSourceType.xsd;

	public static enum TemplateSourceType {
		// Template from XML Schema
		xsd,
		// Template from an XML Sample
		xml
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

	public XMLTemplateCreationWizardPage(String pageName) {
		super(pageName, new String[] { "xsd" }); //$NON-NLS-1$
		this.setTitle(Messages.XMLTemplateCreationWizardPage_Page_Title);
		this.setDescription(Messages.XMLTemplateCreationWizardPage_page_description);
		
		this.templateSourceType = TemplateSourceType.xsd;
	}
	
	public TemplateSourceType getTemplateSourceType() {
		return templateSourceType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.xml.
	 * AbstractFileSelectionWizardPage#changeWizardPageStatus()
	 */
	@Override
	protected void changeWizardPageStatus() {
		super.changeWizardPageStatus();
		String errorMessage = this.getErrorMessage();
		if (errorMessage == null && templateSourceType == TemplateSourceType.xsd) {
			
			if (reasourceLoaded) {
				if (tableViewer.getCheckedElements() == null || tableViewer.getCheckedElements().length == 0) {
					errorMessage = Messages.XMLTemplateCreationWizardPage_Error_Must_Select_Root;
				}
			} else {
				errorMessage = Messages.XMLTemplateCreationWizardPage_Error_Must_Click_Load;
			}
			if(parsingError != null){
				errorMessage = parsingError.getLocalizedMessage();
			}
			setErrorMessage(errorMessage);
			setPageComplete(errorMessage == null);
		}
	}

	/**
	 * @return the rootElementName
	 */
	public String getRootElementName() {
		return rootElementName;
	}

	/**
	 * @param rootElementName
	 *            the rootElementName to set
	 */
	public void setRootElementName(String rootElementName) {
		this.rootElementName = rootElementName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.xml.
	 * AbstractFileSelectionWizardPage
	 * #createFilePathText(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Text createFilePathText(Composite parent) {
		fileTextComposite = new Composite(parent, SWT.NONE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.grabExcessHorizontalSpace = true;
		fileTextComposite.setLayoutData(gd);
		GridLayout xsdtgl = new GridLayout();
		xsdtgl.marginWidth = 0;
		xsdtgl.marginHeight = 0;
		xsdtgl.numColumns = 2;
		fileTextComposite.setLayout(xsdtgl);

		final Text fileText = new Text(fileTextComposite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		fileText.setLayoutData(gd);
		fileText.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.
			 * swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				reasourceLoaded = false;
				if (tableViewer != null) {
					tableViewer.setInput(Collections.emptyList());
				}
			}

		});
		gd.grabExcessHorizontalSpace = true;

		loadXSDButton = new Button(fileTextComposite, SWT.NONE);
		loadXSDButton.setText(Messages.XMLTemplateCreationWizardPage_Button_Load);
		loadXSDButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				parsingError = null;
				reasourceLoaded = false;
				if (fileText.getText() == null || fileText.getText().length() == 0) {
					changeWizardPageStatus();
					return;
				}
				
				List<String> list;
				try {
					list = loadElement(fileText.getText());
					if (list == null || list.isEmpty()) {
						setErrorMessage(Messages.XMLTemplateCreationWizardPage_XSDParsingError1);
					} else {
						tableViewer.setInput(list);
						reasourceLoaded = true;
					}
				} catch (InvocationTargetException e1) {
					parsingError = e1.getTargetException();
					while(parsingError instanceof InvocationTargetException){
						parsingError = ((InvocationTargetException)parsingError).getTargetException();
					}
				} catch (IOException e1) {
					parsingError = e1;
				} catch (ModelBuilderException e1) {
					parsingError = e1;
				}
				changeWizardPageStatus();
			}

		});
		return fileText;
	}

	private List<String> loadElement(String path) throws InvocationTargetException, IOException, ModelBuilderException {
		List<String> elements = new ArrayList<String>();
		if (path == null)
			return null;
		String pp = path.toLowerCase();
		if (pp.endsWith(".wsdl")) { //$NON-NLS-1$
			try {
				List<XSDElementDeclaration> xsdDec = WSDLObjectAnalyzer.loadAllElement(path);
				for (Iterator<?> iterator = xsdDec.iterator(); iterator.hasNext();) {
					XSDElementDeclaration xsdElementDeclaration = (XSDElementDeclaration) iterator.next();
					elements.add(xsdElementDeclaration.getAliasName());
				}
			} catch (ParserConfigurationException e) {
				throw new InvocationTargetException(e);
			} catch (SAXException e) {
				throw new InvocationTargetException(e);
			}
		}
		String file = null;
		file = SmooksUIUtils.parseFilePath(path);
		XSDModelBuilder xsdModelBuilder = new XSDModelBuilder(URI.createFileURI(file));
		Set<String> elementNames = xsdModelBuilder.getRootElementNames();
		Iterator<String> it = elementNames.iterator();
		while (it.hasNext()) {
			String name = it.next();
			elements.add(name);
		}
		return elements;
	}

	public void createControl(Composite parent) {
		Composite mainComposite = new Composite(parent, SWT.NONE);
		GridLayout gl = new GridLayout();
		mainComposite.setLayout(gl);
		GridData gd = new GridData(GridData.FILL_BOTH);
		mainComposite.setLayoutData(gd);

		Label fileTypeLabel = new Label(mainComposite, SWT.NONE);
		fileTypeLabel.setText(Messages.XMLTemplateCreationWizardPage_FileLabel);

		createFromDropdown = new Combo(mainComposite, SWT.READ_ONLY | SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		initCombo(createFromDropdown);
		createFromDropdown.setLayoutData(gd);
		createFromDropdown.select(0);

		createFromDropdown.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateTemplateSourceType();
			}
		});
		
		Label separator = new Label(mainComposite, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator.setLayoutData(gd);
		
		super.createControl(mainComposite);

		mainComposite = (Composite) getControl();
        gd = new GridData(GridData.FILL_HORIZONTAL);
		tableViewerLabel = new Label(mainComposite, SWT.NONE);
		tableViewerLabel.setLayoutData(gd);
		tableViewerLabel.setText(Messages.XMLTemplateCreationWizardPage_Label_Select_Root);
		tableViewer = CheckboxTableViewer.newCheckList(mainComposite, SWT.BORDER);
		gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = 250;
		tableViewer.getControl().setLayoutData(gd);

		tableViewer.setContentProvider(new XSDListContentProvider());
		tableViewer.setLabelProvider(new XSDListLabelProvider());
		tableViewer.addCheckStateListener(new ICheckStateListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.jface.viewers.ICheckStateListener#checkStateChanged
			 * (org.eclipse.jface.viewers.CheckStateChangedEvent)
			 */
			public void checkStateChanged(CheckStateChangedEvent event) {
				if (!fireEvent)
					return;
				rootElementName = null;
				fireEvent = false;
				tableViewer.setAllChecked(false);
				if (event.getChecked()) {
					tableViewer.setChecked(event.getElement(), true);
					Object checkElement = event.getElement();
					if (checkElement instanceof String) {
						rootElementName = (String) checkElement;
					}
				}
				fireEvent = true;
				changeWizardPageStatus();
			}

		});

		this.setControl(mainComposite);
	}
	
	public Combo getCombo() {
		return createFromDropdown;
	}

	protected void updateTemplateSourceType() {
		switch (createFromDropdown.getSelectionIndex()) {
		case 0 :
			templateSourceType = TemplateSourceType.xsd;
			break;
		case 1 :
			templateSourceType = TemplateSourceType.xml;
			break;
		default :
			throw new IllegalStateException(Messages.XMLTemplateCreationWizardPage_XMLTemplateLoadError);
		}

		// Table should only be visible for XSD template sources...
		tableViewer.getTable().setVisible(templateSourceType == TemplateSourceType.xsd);
		tableViewerLabel.setVisible(templateSourceType == TemplateSourceType.xsd);
		loadXSDButton.setEnabled(templateSourceType == TemplateSourceType.xsd);
		
		// Reset the file browse filter...
		setFileExtensionNames(new String[] {templateSourceType.toString()});
	}

	private void initCombo(Combo combo2) {
		combo2.add(Messages.XMLTemplateCreationWizardPage_XSDType);
		combo2.add(Messages.XMLTemplateCreationWizardPage_XMLSampleType);
	}

	public String getInputType(){
		if(createFromDropdown.getSelectionIndex() == 0){
			return SmooksModelUtils.KEY_XML_FILE_TYPE_XSD;
		}
		if(createFromDropdown.getSelectionIndex() == 1){
			return SmooksModelUtils.KEY_XML_FILE_TYPE_XML;
		}
		return null;
	}
}
