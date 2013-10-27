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

import java.util.List;

import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.jboss.tools.smooks.configuration.editors.ClassPathFileProcessor;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.configuration.editors.xml.AbstractFileSelectionWizardPage;
import org.jboss.tools.smooks.model.edi12.EDI12Reader;
import org.jboss.tools.smooks.model.edi12.impl.EDI12ReaderImpl;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class EDIReader12MappingDataPathWizardPage extends AbstractFileSelectionWizardPage {

	private boolean hasReader = false;

	private boolean createNewReader = true;

	private String mappingFile = null;

	private Composite fileComposite = null;

	private String encoding = "UTF-8"; //$NON-NLS-1$

	private Button createNewReaderButton;

	private boolean useAvaliableReader = false;
	
	private String validate = null;

	private SmooksResourceListType resourceList;

	public EDIReader12MappingDataPathWizardPage(String pageName, boolean multiSelect, Object[] initSelections,
			List<ViewerFilter> filters) {
		super(pageName, multiSelect, initSelections, filters);
		this.setTitle(Messages.EDIReader12MappingDataPathWizardPage_Page_Title_EDI_Mapping_File);
		this.setDescription(Messages.EDIReader12MappingDataPathWizardPage_Page_Description_EDI_Mapping_File);
		this.setFilePathProcessor(new ClassPathFileProcessor());
	}

	public EDIReader12MappingDataPathWizardPage(String pageName, String[] fileExtensionNames) {
		super(pageName, fileExtensionNames);
		this.setTitle(Messages.EDIReader12MappingDataPathWizardPage_Page_Title_EDI_12_Mapping_File);
		this.setDescription(Messages.EDIReader12MappingDataPathWizardPage_Page_Description_EDI_12_Mapping_File);
		this.setFilePathProcessor(new ClassPathFileProcessor());
	}

	public String getEncoding() {
		return encoding;
	}

	public boolean isUseAvaliableReader() {
		return useAvaliableReader;
	}

	public SmooksResourceListType getSmooksResourceList() {
		return resourceList;
	}

	public void setSmooksResourceList(SmooksResourceListType resourceList) {
		this.resourceList = resourceList;
	}

	private void initData() {
		encoding = "UTF-8"; //$NON-NLS-1$
		validate = null;
		hasReader = false;
		useAvaliableReader = false;
		createNewReader = true;
		if (SmooksUIUtils.hasReaderAlready(EDI12Reader.class, resourceList)
				|| SmooksUIUtils.hasReaderAlready(EDI12ReaderImpl.class, resourceList)) {
			hasReader = true;
		}

		mappingFile = null;

		if (hasReader) {
			useAvaliableReader = true;
			createNewReader = false;
		}
	}

	public boolean isHasReader() {
		return hasReader;
	}

	public boolean isCreateNewReader() {
		return createNewReader;
	}

	public String getValidate() {
		return validate;
	}

	public void setValidate(String validate) {
		this.validate = validate;
	}

	@Override
	public void createControl(Composite parent) {
		initData();
		super.createControl(parent);
	}

	public String getMappingFile() {
		return mappingFile;
	}

	@Override
	protected void createExtensionGUIFirst(Composite parent) {
		Label encodingLabel = new Label(parent, SWT.NONE);
		encodingLabel.setText(Messages.EDIReader12MappingDataPathWizardPage_Label_Encoding);
		final Text encodingText = new Text(parent, SWT.BORDER);
		encodingText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				mappingFile = encodingText.getText();
			}
		});
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		encodingText.setLayoutData(gd);
		
		
		Label validateLabel = new Label(parent, SWT.NONE);
		validateLabel.setText(Messages.EDIReader12MappingDataPathWizardPage_Label_Validate);
		final Combo validateCombo = new Combo(parent, SWT.BORDER | SWT.READ_ONLY);
		validateCombo.add(""); //$NON-NLS-1$
		validateCombo.add("TRUE"); //$NON-NLS-1$
		validateCombo.add("FALSE"); //$NON-NLS-1$
		validateCombo.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				validate = encodingText.getText();
			}
		});
		gd = new GridData(GridData.FILL_HORIZONTAL);
		validateCombo.setLayoutData(gd);
	}

	@Override
	protected Composite createFileSelectionComposite(Composite parent) {
		Composite chooseComposite = new Composite(parent, SWT.NONE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		chooseComposite.setLayoutData(gd);

		GridLayout gl = new GridLayout();
		gl.numColumns = 2;
		chooseComposite.setLayout(gl);

		Button newReaderButton = new Button(chooseComposite, SWT.RADIO);
		newReaderButton.setText(Messages.EDIReader12MappingDataPathWizardPage_Button_Create_New_Configs);

		final Button useReaderButton = new Button(chooseComposite, SWT.RADIO);
		useReaderButton.setText(Messages.EDIReader12MappingDataPathWizardPage_Button_Use_Existing_Configs);

		fileComposite = super.createFileSelectionComposite(parent);

		createNewReaderButton = new Button(fileComposite, SWT.CHECK);
		createNewReaderButton.setText(Messages.EDIReader12MappingDataPathWizardPage_Button_Create_New_Config);
		createNewReaderButton.setSelection(true);

		if (hasReader) {
			createNewReaderButton.setSelection(false);
			createNewReaderButton.setEnabled(false);

			useReaderButton.setSelection(true);
			this.setConfigCompositeStates(false);
		} else {
			newReaderButton.setSelection(true);
			createNewReaderButton.setSelection(true);
		}

		createNewReaderButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				createNewReader = createNewReaderButton.getSelection();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		newReaderButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				useAvaliableReader = useReaderButton.getSelection();
				setConfigCompositeStates(true);
				changeWizardPageStatus();
			}

			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
		useReaderButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				useAvaliableReader = useReaderButton.getSelection();
				setConfigCompositeStates(false);
				changeWizardPageStatus();
			}

			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
		gd = new GridData();
		gd.horizontalSpan = 2;
		createNewReaderButton.setLayoutData(gd);
		return fileComposite;
	}

	private void setConfigCompositeStates(boolean enabled) {
		fileComposite.setEnabled(enabled);
		Control[] controls = fileComposite.getChildren();
		for (int i = 0; i < controls.length; i++) {
			Control c = controls[i];
			if (c == createNewReaderButton) {
				if (hasReader) {
					c.setEnabled(false);
					continue;
				}
			}
			if (c == fileTextComposite) {
				Control[] cs = ((Composite) c).getChildren();
				for (int j = 0; j < cs.length; j++) {
					Control cc = cs[j];
					cc.setEnabled(enabled);
				}
			}
			c.setEnabled(enabled);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.xml.
	 * AbstractFileSelectionWizardPage#loadedTheObject(java.lang.String)
	 */
	@Override
	protected Object loadedTheObject(String path) throws Exception {
		return null;
	}

	@Override
	protected void changeWizardPageStatus() {
		if (!useAvaliableReader) {
			super.changeWizardPageStatus();
		} else {
			setErrorMessage(null);
			setPageComplete(true);
		}
	}

	@Override
	public boolean canFlipToNextPage() {
		return super.canFlipToNextPage();
		// String filePath = this.getFilePath();
		// try {
		// filePath = SmooksUIUtils.parseFilePath(filePath);
		// if(filePath == null) return false;
		// return new File(filePath).exists();
		// } catch (InvocationTargetException e) {
		// return false;
		// }
	}
}
