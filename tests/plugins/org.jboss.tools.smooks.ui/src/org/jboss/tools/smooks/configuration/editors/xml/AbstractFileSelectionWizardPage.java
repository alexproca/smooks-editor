/**
 * 
 */
package org.jboss.tools.smooks.configuration.editors.xml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.jboss.tools.smooks.configuration.editors.IFilePathProcessor;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;

/**
 * 
 * @author Dart Peng Date : 2008-8-13
 */
public abstract class AbstractFileSelectionWizardPage extends WizardPage implements SelectionListener {
	protected IStructuredSelection selection;
	protected Object returnObject = null;
	protected Text fileText;
	protected Composite fileTextComposite;
	protected CheckboxTableViewer tableViewer = null;
	protected Button fileSystemBrowseButton;
	protected boolean reasourceLoaded = false;
	protected Button workspaceBrowseButton;
	private String filePath = null;
	protected Object[] initSelections;
	protected List<ViewerFilter> filters = new ArrayList<ViewerFilter>();
	protected boolean multiSelect = false;

	private IFilePathProcessor filePathProcessor = null;

	protected String[] fileExtensionNames;
	
	public AbstractFileSelectionWizardPage(String pageName, boolean multiSelect, Object[] initSelections,
			List<ViewerFilter> filters,String[] fileExtensionNames) {
		this(pageName, false, initSelections, Collections.EMPTY_LIST);
		this.fileExtensionNames = fileExtensionNames;
		createFileExtensionNameFilter();
	}
	
	/**
	 * @return the fileExtensionNames
	 */
	public String[] getFileExtensionNames() {
		return fileExtensionNames;
	}



	/**
	 * @param fileExtensionNames the fileExtensionNames to set
	 */
	public void setFileExtensionNames(String[] fileExtensionNames) {
		this.fileExtensionNames = fileExtensionNames;
	}



	public void createFileExtensionNameFilter(){
		if (this.fileExtensionNames != null && this.fileExtensionNames.length != 0) {
			ViewerFilter extensionNameFilter = new ViewerFilter() {
				/*
				 * (non-Javadoc)
				 * 
				 * @see
				 * org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse
				 * .jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				@Override
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if (element instanceof IFile && AbstractFileSelectionWizardPage.this.fileExtensionNames != null) {
						String extName = ((IFile) element).getFileExtension();
						for (int i = 0; i < AbstractFileSelectionWizardPage.this.fileExtensionNames.length; i++) {
							String name = AbstractFileSelectionWizardPage.this.fileExtensionNames[i];
							if (name.equalsIgnoreCase(extName)) {
								return true;
							}
						}
						return false;
					}
					return true;
				}
			};
			this.filters.add(extensionNameFilter);
		}
	}

	public AbstractFileSelectionWizardPage(String pageName, boolean multiSelect, Object[] initSelections,
			List<ViewerFilter> filters) {
		super(pageName);
		this.initSelections = initSelections;
		if (filters != null) {
			this.filters.addAll(filters);
		}
		this.multiSelect = multiSelect;
	}

	public AbstractFileSelectionWizardPage(String pageName, String[] fileExtensionNames) {
		this(pageName, false, null, Collections.EMPTY_LIST);
		this.fileExtensionNames = fileExtensionNames;
		createFileExtensionNameFilter();
	}

	public Object getReturnValue() {
		try {
			String path = getFilePath();
			if (path == null)
				return null;
			path = SmooksUIUtils.parseFilePath(path);
			returnObject = this.loadedTheObject(path);
		} catch (Exception e) {
			SmooksUIUtils.showErrorDialog(getShell(), SmooksUIUtils.createErrorStatus(e));
		}
		return returnObject;
	}

	public String getFilePath() {
		return filePath;
	}

	public IFilePathProcessor getFilePathProcessor() {
		return filePathProcessor;
	}

	public void setFilePathProcessor(IFilePathProcessor filePathProcessor) {
		this.filePathProcessor = filePathProcessor;
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
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		mainComposite.setLayout(layout);

		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.grabExcessHorizontalSpace = true;
		gd.grabExcessVerticalSpace = true;
		mainComposite.setLayoutData(gd);

		// xmlButton = new Button(mainComposite, SWT.RADIO);
		// xmlButton.setText("Select a XML file");
		//
		// Composite xmlComposite = this
		// .createXMLFileSelectionComposite(mainComposite);
		//
		// Label sp = new Label(mainComposite, SWT.HORIZONTAL | SWT.SEPARATOR);
		// gd = new GridData(GridData.FILL_HORIZONTAL);
		// sp.setLayoutData(gd);
		//
		// xsdButton = new Button(mainComposite, SWT.RADIO);
		// xsdButton.setText("Select a XSD file");

		createFileSelectionComposite(mainComposite);

		// init the panel status (XSD file selection composite is disabled)
		// xsdButton.setSelection(true);
		//
		// setCompositeChildrenEnabled(xmlComposite, false);

		// registe the listener for controls
		hookBrowseButtonSelectionAdapter();
		hookFileTextModifyListener();
		this.setControl(mainComposite);
		
		changeWizardPageStatus();
		// don't show the error message when first open the dialog
		this.setErrorMessage(null);
		parent.getShell().setText(Messages.AbstractFileSelectionWizardPage_WizardTitle);
	}

	protected void hookFileTextModifyListener() {
		final ModifyListener modifyListener = new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				filePath = fileText.getText();
				changeWizardPageStatus();
			}
		};
		// xmlFileText.addModifyListener(modifyListener);
		fileText.addModifyListener(modifyListener);
	}

	protected void hookRadioButtonSelectionAdapter() {
		// xsdButton.addSelectionListener(this);
	}

	protected void hookBrowseButtonSelectionAdapter() {
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

		workspaceBrowseButton.addSelectionListener(wbrowseButtonSelectionAdapter);
		// xmlFileSystemBrowseButton
		// .addSelectionListener(browseButtonSelectionAdapter);
		fileSystemBrowseButton.addSelectionListener(browseButtonSelectionAdapter);
	}

	protected void openWorkSpaceSelection(Text relationT) {
		IFile[] files = WorkspaceResourceDialog.openFileSelection(getShell(),
				"Select Files", "", false, initSelections, filters); //$NON-NLS-1$ //$NON-NLS-2$
		// dialog.setInitialSelections(selectedResources);
		if (files.length > 0) {
			IFile file = files[0];
			String s = processWorkSpaceFilePath(file);
			relationT.setText(s);
		}
	}

	protected String processFileSystemFilePath(String path) {
		if (filePathProcessor != null) {
			String s = filePathProcessor.processFileSystemPath(path);
			if (s != null) {
				return s;
			}
		}
		path = SmooksUIUtils.FILE_PRIX + path;
		return path;
	}

	protected String processWorkSpaceFilePath(IFile file) {
		if (filePathProcessor != null) {
			String s = filePathProcessor.processWorkBenchPath(file);
			if (s != null) {
				return s;
			}
		}
		String s = file.getFullPath().toPortableString();
		s = SmooksUIUtils.WORKSPACE_PRIX + s;
		return s;
	}

	protected Text createFilePathText(Composite parent) {
		fileTextComposite = new Composite(parent, SWT.NONE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.grabExcessHorizontalSpace = true;
		fileTextComposite.setLayoutData(gd);
		GridLayout xsdtgl = new GridLayout();
		xsdtgl.marginWidth = 0;
		xsdtgl.marginHeight = 0;
		xsdtgl.numColumns = 1;
		fileTextComposite.setLayout(xsdtgl);

		Text fileText = new Text(fileTextComposite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		fileText.setLayoutData(gd);
		gd.grabExcessHorizontalSpace = true;

		return fileText;
	}

	protected Composite createFileSelectionComposite(Composite parent) {
		Composite xsdComposite = new Composite(parent, SWT.NONE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		xsdComposite.setLayoutData(gd);
		GridLayout xsdLayout = new GridLayout();
		xsdLayout.numColumns = 2;
		xsdLayout.marginWidth = 0;
		xsdComposite.setLayout(xsdLayout);
		createExtensionGUIFirst(xsdComposite);
		Label nfileLanel = new Label(xsdComposite, SWT.NONE);
		nfileLanel.setText("File : "); //$NON-NLS-1$
		// fileTextComposite = new Composite(xsdComposite, SWT.NONE);
		// gd = new GridData(GridData.FILL_HORIZONTAL);
		// gd.grabExcessHorizontalSpace = true;
		// fileTextComposite.setLayoutData(gd);
		// GridLayout xsdtgl = new GridLayout();
		// xsdtgl.marginWidth = 0;
		// xsdtgl.marginHeight = 0;
		// xsdtgl.numColumns = 1;
		// fileTextComposite.setLayout(xsdtgl);
		//
		// fileText = new Text(fileTextComposite, SWT.BORDER);
		// gd = new GridData(GridData.FILL_HORIZONTAL);
		// fileText.setLayoutData(gd);
		// gd.grabExcessHorizontalSpace = true;

		fileText = createFilePathText(xsdComposite);

		// final Button loadXSDButton = new Button(fileTextComposite, SWT.NONE);
		// loadXSDButton.setText("Load");
		// loadXSDButton.addSelectionListener(new SelectionAdapter() {
		//
		// @Override
		// public void widgetSelected(SelectionEvent e) {
		// super.widgetSelected(e);
		// reasourceLoaded = false;
		// try {
		// returnObject = loadedTheObject(fileText.getText());
		// reasourceLoaded = true;
		// } catch (Throwable e2) {
		// // ignore
		// e2.printStackTrace();
		// }
		// changeWizardPageStatus();
		// }
		//
		// });

		Composite browseButtonComposite = new Composite(xsdComposite, SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		browseButtonComposite.setLayoutData(gd);

		GridLayout bg = new GridLayout();
		bg.numColumns = 2;
		bg.marginHeight = 0;
		bg.marginWidth = 0;
		bg.makeColumnsEqualWidth = false;
		browseButtonComposite.setLayout(bg);

		fileSystemBrowseButton = new Button(browseButtonComposite, SWT.NONE);
		fileSystemBrowseButton.setText("Browse File System"); //$NON-NLS-1$

		workspaceBrowseButton = new Button(browseButtonComposite, SWT.NONE);
		workspaceBrowseButton.setText("Browse WorkSpace"); //$NON-NLS-1$
		gd = new GridData();
		gd.horizontalAlignment = GridData.END;
		workspaceBrowseButton.setLayoutData(gd);

		gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = GridData.END;
		fileSystemBrowseButton.setLayoutData(gd);
		
		return xsdComposite;
	}

	protected void createExtensionGUIFirst(Composite parent) {
		// do nothing
	}

	abstract protected Object loadedTheObject(String path) throws Exception;

	protected void initTableViewer() {
		// tableViewer.addCheckStateListener(new ICheckStateListener() {
		// boolean flag = true;
		//
		// public void checkStateChanged(CheckStateChangedEvent event) {
		// if (flag) {
		// Object checkObject = event.getElement();
		// boolean check = event.getChecked();
		// flag = false;
		// tableViewer.setAllChecked(false);
		// tableViewer.setChecked(checkObject, check);
		// flag = true;
		// changeWizardPageStatus();
		// }
		// }
		// });
		// tableViewer.setContentProvider(new
		// XSDStructuredModelContentProvider());
		// tableViewer.setLabelProvider(new XSDStructuredModelLabelProvider());
	}

	protected void setCompositeChildrenEnabled(Composite composite, boolean enabled) {
		Control[] children = composite.getChildren();
		for (int i = 0; i < children.length; i++) {
			Control child = children[i];
			if (child instanceof Text) {
				child.setEnabled(enabled);
			}
			if (child instanceof Button) {
				child.setEnabled(enabled);
			}
			if (child instanceof Composite) {
				setCompositeChildrenEnabled((Composite) child, enabled);
			}
		}
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

	protected void changeWizardPageStatus() {
		String text = this.fileText.getText();
		String error = null;
		if (text == null || "".equals(text)) //$NON-NLS-1$
			error = "File name cannot be null"; //$NON-NLS-1$

		// File tempFile = new File(text);
		// if(!tempFile.exists()){
		// error = "Can't find the file , please select another one.";
		// }

		// if (!reasourceLoaded) {
		// error = "Resource must be loaded";
		// }
		this.setErrorMessage(error);
		this.setPageComplete(error == null);
	}

	public void widgetDefaultSelected(SelectionEvent e) {
		widgetSelected(e);
	}

	public void widgetSelected(SelectionEvent e) {
		changeWizardPageStatus();
	}

	public CheckboxTableViewer getTableViewer() {
		return tableViewer;
	}

	public void setTableViewer(CheckboxTableViewer tableViewer) {
		this.tableViewer = tableViewer;
	}

	public IStructuredSelection getSelection() {
		return selection;
	}

	public void setSelection(IStructuredSelection selection) {
		this.selection = selection;
	}

	public Object[] getInitSelections() {
		return initSelections;
	}

	public void setInitSelections(Object[] initSelections) {
		this.initSelections = initSelections;
	}

	public List<ViewerFilter> getFilters() {
		return filters;
	}

	public void setFilters(List<ViewerFilter> filters) {
		this.filters = filters;
	}

	public boolean isMultiSelect() {
		return multiSelect;
	}

	public void setMultiSelect(boolean multiSelect) {
		this.multiSelect = multiSelect;
	}

}
