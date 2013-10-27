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
package org.jboss.tools.smooks.edimap.wizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;

/**
 * @author Dart (dpeng@redhat.com)
 * 
 */
public class EDIMappingConfigFileConfigPage extends WizardPage {
	
	private String name;
	
	private String version;
	
	private String segments;
	
	private String componentDelimiter;
	
	private String subComponentDelimiter;
	
	private String fieldDelimiter;
	
	private String segmentDelimiter;
	
	private String ediFilePath;
	
	private String[] fileExtensionNames;
	
	private ISelection selection;
	

	public EDIMappingConfigFileConfigPage(String pageName, String title, ImageDescriptor titleImage,ISelection selection) {
		super(pageName, title, titleImage);
		this.selection = selection;
		this.setTitle(Messages.EDIMappingConfigFileConfigPage_Page_Title);
		this.setDescription(Messages.EDIMappingConfigFileConfigPage_Page_Description);
	}

	public EDIMappingConfigFileConfigPage(String pageName,ISelection selection) {
		super(pageName);
		this.selection = selection;
		this.setTitle(Messages.EDIMappingConfigFileConfigPage_Page_Title);
		this.setDescription(Messages.EDIMappingConfigFileConfigPage_Page_Description);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	public void createControl(Composite parent) {
		Composite mainComposite = new Composite(parent, SWT.NONE);
		GridData gd = new GridData(GridData.FILL_BOTH);
		mainComposite.setLayoutData(gd);

		GridLayout mgl = new GridLayout();
		mainComposite.setLayout(mgl);
		mgl.numColumns = 2;
		mgl.verticalSpacing = 8;
		mgl.horizontalSpacing = 5;

		Label nameLabel = new Label(mainComposite, SWT.NONE);
		nameLabel.setText(Messages.EDIMappingConfigFileConfigPage_Label_Name);
		final Text nameText = new Text(mainComposite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		nameText.setLayoutData(gd);
		nameText.addModifyListener(new ModifyListener(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				setName(nameText.getText());
			}
			
		});
		
		Label versionLabel = new Label(mainComposite, SWT.NONE);
		versionLabel.setText(Messages.EDIMappingConfigFileConfigPage_Label_Version);
		final Text versionText = new Text(mainComposite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		versionText.setLayoutData(gd);
		versionText.addModifyListener(new ModifyListener(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				setVersion(versionText.getText());
			}
			
		});
		
		Label segmentsNameLabel = new Label(mainComposite, SWT.NONE);
		segmentsNameLabel.setText(Messages.EDIMappingConfigFileConfigPage_Label_Root_Tag_Name);
		final Text segmentsNameText = new Text(mainComposite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		segmentsNameText.setLayoutData(gd);
		segmentsNameText.addModifyListener(new ModifyListener(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				setSegments(segmentsNameText.getText());
				updatePageStatus();
			}
			
		});
		
		Composite separator = new Composite(mainComposite,SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		gd.heightHint = 10;
		
		separator.setLayoutData(gd);
		
		Group group = new Group(mainComposite,SWT.NONE);
		group.setText(Messages.EDIMappingConfigFileConfigPage_Group_Delimiter);
		GridLayout dgl = new GridLayout();
		dgl.numColumns = 2;
		dgl.verticalSpacing = 5;
		dgl.horizontalSpacing = 5;
		group.setLayout(dgl);
		
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		
		group.setLayoutData(gd);
		
		Label segmentLabel = new Label(group, SWT.NONE);
		segmentLabel.setText(Messages.EDIMappingConfigFileConfigPage_Label_Segment);
		final Text segmentText = new Text(group, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		segmentText.setLayoutData(gd);
		segmentText.addModifyListener(new ModifyListener(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				setSegmentDelimiter(segmentText.getText());
			}
			
		});
		
		Label fieldLabel = new Label(group, SWT.NONE);
		fieldLabel.setText(Messages.EDIMappingConfigFileConfigPage_Label_Field);
		final Text fieldText = new Text(group, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		fieldText.setLayoutData(gd);
		
		fieldText.addModifyListener(new ModifyListener(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				setFieldDelimiter(fieldText.getText());
			}
			
		});
		
		Label componentLabel = new Label(group, SWT.NONE);
		componentLabel.setText(Messages.EDIMappingConfigFileConfigPage_Label_Component);
		final Text compoenentText = new Text(group, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		compoenentText.setLayoutData(gd);
		compoenentText.addModifyListener(new ModifyListener(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				setComponentDelimiter(compoenentText.getText());
			}
			
		});
		
		Label subcomponentLabel = new Label(group, SWT.NONE);
		subcomponentLabel.setText(Messages.EDIMappingConfigFileConfigPage_Label_Subcomponent);
		final Text subcompoenentText = new Text(group, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		subcompoenentText.setLayoutData(gd);
		subcompoenentText.addModifyListener(new ModifyListener(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				setSubComponentDelimiter(subcompoenentText.getText());
			}
			
		});
		
		Composite separator1= new Composite(mainComposite,SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		gd.heightHint = 10;
		separator1.setLayoutData(gd);

		Label nfileLanel = new Label(mainComposite, SWT.NONE);
		nfileLanel.setText("EDI Input Data File : "); //$NON-NLS-1$
		
		final Text fileText = new Text(mainComposite,SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		fileText.setLayoutData(gd);
		fileText.addModifyListener(new ModifyListener(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				setEdiFilePath(fileText.getText());
			}
			
		});
		
		Composite browseButtonComposite = new Composite(mainComposite, SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		browseButtonComposite.setLayoutData(gd);

		GridLayout bg = new GridLayout();
		bg.numColumns = 2;
		bg.marginHeight = 0;
		bg.marginWidth = 0;
		bg.makeColumnsEqualWidth = false;
		browseButtonComposite.setLayout(bg);

		final Button fileSystemBrowseButton = new Button(browseButtonComposite, SWT.NONE);
		fileSystemBrowseButton.setText("Browse File System"); //$NON-NLS-1$

		final Button workspaceBrowseButton = new Button(browseButtonComposite, SWT.NONE);
		workspaceBrowseButton.setText("Browse WorkSpace"); //$NON-NLS-1$
		gd = new GridData();
		gd.horizontalAlignment = GridData.END;
		workspaceBrowseButton.setLayoutData(gd);

		gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = GridData.END;
		fileSystemBrowseButton.setLayoutData(gd);
		
		SelectionAdapter browseButtonSelectionAdapter = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				Text relationT = null;
				if (e.getSource() == fileSystemBrowseButton) {
					relationT = fileText;
				}
				openFileSelection(relationT);
			}
		};
		SelectionAdapter wbrowseButtonSelectionAdapter = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				Text relationT = null;
				if (e.getSource() == workspaceBrowseButton) {
					relationT = fileText;
				}
				openWorkSpaceSelection(relationT);
			}

		};
		
		fileSystemBrowseButton.addSelectionListener(browseButtonSelectionAdapter);
		workspaceBrowseButton.addSelectionListener(wbrowseButtonSelectionAdapter);

		setControl(mainComposite);
		
		updatePageStatus();
	}
	
	protected void openFileSelection(Text relationText) {
		FileDialog dialog = new FileDialog(this.getShell());
		if (fileExtensionNames != null) {
			String s = ""; //$NON-NLS-1$
			for (int i = 0; i < fileExtensionNames.length; i++) {
				String exname = fileExtensionNames[i];
				s += "*." + exname + ";"; //$NON-NLS-1$ //$NON-NLS-2$
			}
			if (s.length() != 0) {
				s = s.substring(0, s.length() - 1);
				dialog.setFilterExtensions(new String[]{s,"*.*"}); //$NON-NLS-1$
			}
		}
		String path = dialog.open();
		if (path != null) {
			path = processFileSystemFilePath(path);
			relationText.setText(path);
		}
	}
	
	protected String processWorkSpaceFilePath(IFile file) {
//		if (filePathProcessor != null) {
//			String s = filePathProcessor.processWorkBenchPath(file);
//			if (s != null) {
//				return s;
//			}
//		}
		String s = file.getFullPath().toPortableString();
		s = SmooksUIUtils.WORKSPACE_PRIX + s;
		return s;
	}
	
	protected void openWorkSpaceSelection(Text relationT) {
		Object[] obj = new Object[]{};

		if(selection != null && selection instanceof IStructuredSelection){
			obj = ((IStructuredSelection)selection).toArray();
		}
		IFile[] files = WorkspaceResourceDialog.openFileSelection(getShell(),
				"Select Files", "", false, obj, null); //$NON-NLS-1$ //$NON-NLS-2$
		// dialog.setInitialSelections(selectedResources);
		if (files.length > 0) {
			IFile file = files[0];
			String s = processWorkSpaceFilePath(file);
			relationT.setText(s);
		}
	}

	
	protected String processFileSystemFilePath(String path) {
//		if (filePathProcessor != null) {
//			String s = filePathProcessor.processFileSystemPath(path);
//			if (s != null) {
//				return s;
//			}
//		}
		path = SmooksUIUtils.FILE_PRIX + path;
		return path;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the segments
	 */
	public String getSegments() {
		return segments;
	}

	/**
	 * @param segments the segments to set
	 */
	public void setSegments(String segments) {
		this.segments = segments;
	}

	/**
	 * @return the componentDelimiter
	 */
	public String getComponentDelimiter() {
		return componentDelimiter;
	}

	/**
	 * @param componentDelimiter the componentDelimiter to set
	 */
	public void setComponentDelimiter(String componentDelimiter) {
		this.componentDelimiter = componentDelimiter;
	}

	/**
	 * @return the subComponentDelimiter
	 */
	public String getSubComponentDelimiter() {
		return subComponentDelimiter;
	}

	/**
	 * @param subComponentDelimiter the subComponentDelimiter to set
	 */
	public void setSubComponentDelimiter(String subComponentDelimiter) {
		this.subComponentDelimiter = subComponentDelimiter;
	}

	/**
	 * @return the fieldDelimiter
	 */
	public String getFieldDelimiter() {
		return fieldDelimiter;
	}

	/**
	 * @param fieldDelimiter the fieldDelimiter to set
	 */
	public void setFieldDelimiter(String fieldDelimiter) {
		this.fieldDelimiter = fieldDelimiter;
	}

	/**
	 * @return the segmentDelimiter
	 */
	public String getSegmentDelimiter() {
		return segmentDelimiter;
	}

	/**
	 * @param segmentDelimiter the segmentDelimiter to set
	 */
	public void setSegmentDelimiter(String segmentDelimiter) {
		this.segmentDelimiter = segmentDelimiter;
	}

	/**
	 * @return the ediFilePath
	 */
	public String getEdiFilePath() {
		return ediFilePath;
	}

	/**
	 * @param ediFilePath the ediFilePath to set
	 */
	public void setEdiFilePath(String ediFilePath) {
		this.ediFilePath = ediFilePath;
	}
	
	
	private void updatePageStatus(){
		String error = null;
		if(segments == null || segments.length() == 0){
			error = Messages.EDIMappingConfigFileConfigPage_Error_Root_Name_Cannot_Be_Null;
		}
		this.setErrorMessage(error);
		this.setPageComplete(error == null);
	}
	
	

}
