/**
 * 
 */
package org.jboss.tools.smooks.configuration.editors.csv12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableFontProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.model.csv12.CSV12Reader;
import org.jboss.tools.smooks.model.csv12.impl.CSV12ReaderImpl;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;

/**
 * @author Dart
 * 
 */
public class CSV12DataConfigurationWizardPage extends WizardPage {

	private SmooksResourceListType smooksResourceList;
	private Button newReaderConfigButton;
	private Button useAvailableReaderConfigButton;
	private Composite configComposite;
	private Text separatorText;
	private Text quoteCharText;
	private Text skipLinesText;
	private Text encodingText;
	private Composite fieldsComposite;
	private TableViewer fieldsViewer;
	private Button addButton;
	private Button removeButton;
	private Button createCSVReaderButton;

	private String filePath = null;

	private boolean useAvailabelReader = false;

	private boolean hasReader = false;

	private boolean createCSVReader = true;

	private String separator;

	private String skipLines;

	private String quoteChar;

	private String encoding;
	
	private String rootName;
	
	private String recordName;

	private List<FieldString> fieldsList = new ArrayList<FieldString>();
	private Text rootNameText;
	private Text recordNameText;
	private Combo indentText;
	protected String indent;

	public CSV12DataConfigurationWizardPage(String pageName, String title, ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
	}

	public CSV12DataConfigurationWizardPage(String pageName) {
		super(pageName);
		this.setTitle("CSV Reader configurations (version 1.2)"); //$NON-NLS-1$
		this.setDescription("Set the configurations for parsing CSV file."); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	public void createControl(Composite parent) {
		initValue();
		Composite mainComposite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		mainComposite.setLayout(layout);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.grabExcessHorizontalSpace = true;
		gd.grabExcessVerticalSpace = true;
		mainComposite.setLayoutData(gd);

		Composite radioButtonComposite = new Composite(mainComposite, SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		radioButtonComposite.setLayoutData(gd);

		GridLayout rgl = new GridLayout();
		rgl.numColumns = 2;
		rgl.marginHeight = 0;
		rgl.marginWidth = 0;
		radioButtonComposite.setLayout(rgl);

		Composite spaceComposite = new Composite(mainComposite, SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		gd.heightHint = 20;
		spaceComposite.setLayoutData(gd);

		newReaderConfigButton = new Button(radioButtonComposite, SWT.RADIO);
		newReaderConfigButton.setText("Create new CSV reader configurations"); //$NON-NLS-1$
		newReaderConfigButton.setSelection(true);

		useAvailableReaderConfigButton = new Button(radioButtonComposite, SWT.RADIO);
		useAvailableReaderConfigButton.setText("Use available CSV reader configurations"); //$NON-NLS-1$

		configComposite = new Composite(mainComposite, SWT.NONE);
		gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 2;
		configComposite.setLayoutData(gd);

		GridLayout cgl = new GridLayout();
		cgl.marginHeight = 0;
		cgl.marginWidth = 0;
		cgl.numColumns = 2;
		configComposite.setLayout(cgl);
		
		gd = new GridData(GridData.FILL_HORIZONTAL);
		Label rootnameLabel = new Label(configComposite, SWT.NONE);
		rootnameLabel.setText("Root Name"); //$NON-NLS-1$
		rootNameText = new Text(configComposite, SWT.BORDER);
		rootNameText.setLayoutData(gd);

		Label recordNameLabel = new Label(configComposite, SWT.NONE);
		recordNameLabel.setText("Record Name"); //$NON-NLS-1$
		recordNameText = new Text(configComposite, SWT.BORDER);
		recordNameText.setLayoutData(gd);
		
		gd = new GridData(GridData.FILL_HORIZONTAL);
		Label separatorLabel = new Label(configComposite, SWT.NONE);
		separatorLabel.setText("Separator"); //$NON-NLS-1$
		separatorText = new Text(configComposite, SWT.BORDER);
		separatorText.setLayoutData(gd);

		Label quoteCharLabel = new Label(configComposite, SWT.NONE);
		quoteCharLabel.setText("Quote Char"); //$NON-NLS-1$
		quoteCharText = new Text(configComposite, SWT.BORDER);
		quoteCharText.setLayoutData(gd);

		Label skiplineLabel = new Label(configComposite, SWT.NONE);
		skiplineLabel.setText("Skip Lines"); //$NON-NLS-1$
		skipLinesText = new Text(configComposite, SWT.BORDER);
		skipLinesText.setLayoutData(gd);
		
		Label indentLabel = new Label(configComposite, SWT.NONE);
		indentLabel.setText("Indent"); //$NON-NLS-1$
		indentText = new Combo(configComposite, SWT.BORDER | SWT.READ_ONLY);
		indentText.add(""); //$NON-NLS-1$
		indentText.add("TRUE"); //$NON-NLS-1$
		indentText.add("FALSE"); //$NON-NLS-1$
		indentText.setLayoutData(gd);

		Label encodingLabel = new Label(configComposite, SWT.NONE);
		encodingLabel.setText("Encoding"); //$NON-NLS-1$
		encodingText = new Text(configComposite, SWT.BORDER);
		encodingText.setLayoutData(gd);
		encodingText.setText(encoding);

		Label keyMapLabel = new Label(configComposite, SWT.NONE);
		keyMapLabel.setText("Fields List:"); //$NON-NLS-1$
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		keyMapLabel.setLayoutData(gd);

		gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 2;

		fieldsComposite = new Composite(configComposite, SWT.NONE);
		fieldsComposite.setLayoutData(gd);

		GridLayout kgl = new GridLayout();
		kgl.numColumns = 2;
		fieldsComposite.setLayout(kgl);

		gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = 200;

		fieldsViewer = new TableViewer(fieldsComposite, SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);
		fieldsViewer.getControl().setLayoutData(gd);
		// fieldsViewer.getTable().setHeaderVisible(true);
		fieldsViewer.getTable().setLinesVisible(true);
		fieldsViewer.setContentProvider(new FieldsContentProvider());
		fieldsViewer.setLabelProvider(new FieldsLabelProvider());

		CellEditor fieldCellEditor = new TextCellEditor(fieldsViewer.getTable(), SWT.BORDER);

		TableColumn fieldColumn = new TableColumn(fieldsViewer.getTable(), SWT.NONE);
		fieldColumn.setText("Field"); //$NON-NLS-1$
		fieldColumn.setWidth(150);

		TableColumn exampleValueColumn = new TableColumn(fieldsViewer.getTable(), SWT.NONE);
		exampleValueColumn.setText("Example Value"); //$NON-NLS-1$
		exampleValueColumn.setWidth(150);

		fieldsViewer.getTable().setHeaderVisible(true);
		fieldsViewer.getTable().setLinesVisible(true);

		fieldsViewer.setCellEditors(new CellEditor[] { fieldCellEditor });

		fieldsViewer.setColumnProperties(new String[] { "field" }); //$NON-NLS-1$

		fieldsViewer.setCellModifier(new ICellModifier() {

			public void modify(Object element, String property, Object value) {
				Object el = null;
				if (element instanceof Item) {
					el = ((Item) element).getData();
				}
				if (el == null)
					return;
				if (el instanceof FieldString && value instanceof String) {
					if (property.equals("field")) { //$NON-NLS-1$
						((FieldString) el).setText(value.toString());
					}
					fieldsViewer.refresh(el);
				}
				changePageStatus();
			}

			public Object getValue(Object element, String property) {
				// Object el = null;
				// if(element instanceof Item){
				// el = ((Item)element).getData();
				// }
				// if(el == null) return null;
				if (element instanceof FieldString) {
					if (property.equals("field")) { //$NON-NLS-1$
						return ((FieldString) element).getText();
					}
				}

				return null;
			}

			public boolean canModify(Object element, String property) {
				// Object el = null;
				// if(element instanceof Item){
				// el = ((Item)element).getData();
				// }
				// if(el == null) return false;
				if (element instanceof FieldString) {
					if (property.equals("field")) { //$NON-NLS-1$
						return true;
					}
				}
				return false;
			}
		});

		fieldsViewer.setInput(fieldsList);

		Composite buttonComposite = new Composite(fieldsComposite, SWT.NONE);
		gd = new GridData(GridData.FILL_VERTICAL);
		gd.widthHint = 0;
		buttonComposite.setLayoutData(gd);
		buttonComposite.setVisible(false);

		GridLayout bgl = new GridLayout();
		buttonComposite.setLayout(bgl);

		gd = new GridData(GridData.FILL_HORIZONTAL);

		addButton = new Button(buttonComposite, SWT.NONE);
		addButton.setLayoutData(gd);
		addButton.setText("Add"); //$NON-NLS-1$

		removeButton = new Button(buttonComposite, SWT.NONE);
		removeButton.setLayoutData(gd);
		removeButton.setText("Remove"); //$NON-NLS-1$

		createCSVReaderButton = new Button(configComposite, SWT.CHECK);
		createCSVReaderButton.setText("Create a CSV Reader"); //$NON-NLS-1$

		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		createCSVReaderButton.setLayoutData(gd);
		createCSVReaderButton.setSelection(createCSVReader);

		if (hasReader) {
			useAvailableReaderConfigButton.setSelection(true);
			newReaderConfigButton.setSelection(false);
			createCSVReaderButton.setEnabled(false);
			setConfigCompositeStates(false);
		}

		changePageStatus();
		hookControls();

		this.setControl(mainComposite);
	}

	private void hookControls() {
		newReaderConfigButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				if (newReaderConfigButton.getSelection()) {
					setConfigCompositeStates(true);
					useAvailabelReader = false;
					changePageStatus();
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		useAvailableReaderConfigButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				if (useAvailableReaderConfigButton.getSelection()) {
					setConfigCompositeStates(false);
					useAvailabelReader = true;
					changePageStatus();
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		this.separatorText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				separator = separatorText.getText();
				resetViewerContent();
				changePageStatus();
			}
		});

		this.quoteCharText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				quoteChar = quoteCharText.getText();
				changePageStatus();
			}
		});
		
		this.rootNameText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				rootName = rootNameText.getText();
				changePageStatus();
			}
		});

		this.recordNameText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				recordName = recordNameText.getText();
				changePageStatus();
			}
		});

		this.skipLinesText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				skipLines = skipLinesText.getText();
				changePageStatus();
			}
		});

		this.encodingText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				encoding = encodingText.getText();
				changePageStatus();
			}
		});
		
		indentText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				indent = indentText.getText();
				changePageStatus();
			}
		});

		this.createCSVReaderButton.addSelectionListener(new SelectionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.SelectionListener#widgetDefaultSelected
			 * (org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse
			 * .swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				createCSVReader = createCSVReaderButton.getSelection();
			}

		});

		this.addButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				FieldString field = new FieldString("field"); //$NON-NLS-1$
				fieldsList.add(field);
				fieldsViewer.refresh();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		this.removeButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection s = (IStructuredSelection) fieldsViewer.getSelection();
				fieldsList.removeAll(s.toList());
				fieldsViewer.refresh();
			}

			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
	}

	private void resetViewerContent() {
		try {
			fieldsList.clear();
			if (filePath != null && separator != null && separator.length() == 1) {
				
				filePath = SmooksUIUtils.parseFilePath(filePath);
				
				FileReader fr = new FileReader(filePath);
				BufferedReader br = new BufferedReader(fr);

				String content = br.readLine();
				if (content != null) {
					String[] exampleValues = content.split(separator);
					if (exampleValues != null) {
						List<FieldString> list = new ArrayList<FieldString>();
						for (int i = 0; i < exampleValues.length; i++) {
							String s = exampleValues[i];
							if (s != null) {
								if (s.length() == 0)
									s = "<Null>"; //$NON-NLS-1$
								FieldString fs = new FieldString(""); //$NON-NLS-1$
								fs.setExampleValue(s);
								list.add(fs);
							}
						}
						if(!list.isEmpty()){
							fieldsList.addAll(list);
						}
					}
				}
			}
		} catch (Exception e) {
			this.setErrorMessage("Occurs an error when parse CSV file"); //$NON-NLS-1$
		}
		fieldsViewer.refresh();
	}

	private void changePageStatus() {
		if (useAvailabelReader) {
			setErrorMessage(null);
			setPageComplete(true);
			return;
		}
		String error = null;

		if (separator == null || separator.length() == 0) {
			error = "Sperator can't be null"; //$NON-NLS-1$
		}
		if (separator != null && separator.length() > 1) {
			error = "Sperator needs only one char"; //$NON-NLS-1$
		}
		if (quoteChar == null || quoteChar.length() == 0) {
			error = "QuoteChar can't be null"; //$NON-NLS-1$
		}
		if (quoteChar != null && quoteChar.length() > 1) {
			error = "QuoteChar needs only one char"; //$NON-NLS-1$
		}

		if (encoding == null || encoding.length() == 0) {
			error = "Encoding can't be null"; //$NON-NLS-1$
		}

		if (skipLines == null || skipLines.length() == 0) {
//			error = "Skip lines can't be null";
		} else {
			try {
				Integer.parseInt(skipLines);
			} catch (Throwable t) {
				error = "Skip lines text must be the number"; //$NON-NLS-1$
			}
		}
		
		for (Iterator<?> iterator = fieldsList.iterator(); iterator.hasNext();) {
			FieldString field = (FieldString) iterator.next();
			if(field.getText() == null || field.getText().length() == 0 ){
				error = "Fields can't be null"; //$NON-NLS-1$
			}
		}

		setErrorMessage(error);
		setPageComplete(error == null);
	}

	private void setConfigCompositeStates(boolean enabled) {
		configComposite.setEnabled(enabled);
		Control[] controls = configComposite.getChildren();
		for (int i = 0; i < controls.length; i++) {
			Control c = controls[i];
			if (c == createCSVReaderButton) {
				if (hasReader) {
					c.setEnabled(false);
					continue;
				}
			}
			if (c == fieldsComposite) {
				Control[] cs = ((Composite) c).getChildren();
				for (int j = 0; j < cs.length; j++) {
					Control cc = cs[j];
					cc.setEnabled(enabled);
				}
			}
			c.setEnabled(enabled);
		}
	}

	public String getIndent() {
		return indent;
	}

	public void setIndent(String indent) {
		this.indent = indent;
	}

	/**
	 * @return the separator
	 */
	public String getSeparator() {
		return separator;
	}

	/**
	 * @param separator
	 *            the separator to set
	 */
	public void setSeparator(String separator) {
		this.separator = separator;
	}

	/**
	 * @return the fieldsList
	 */
	public List<FieldString> getFieldsList() {
		return fieldsList;
	}

	/**
	 * @param fieldsList
	 *            the fieldsList to set
	 */
	public void setFieldsList(List<FieldString> fieldsList) {
		this.fieldsList = fieldsList;
	}

	/**
	 * @return the useAvailabelReader
	 */
	public boolean isUseAvailabelReader() {
		return useAvailabelReader;
	}

	/**
	 * @param useAvailabelReader
	 *            the useAvailabelReader to set
	 */
	public void setUseAvailabelReader(boolean useAvailabelReader) {
		this.useAvailabelReader = useAvailabelReader;
	}

	/**
	 * @return the createCSVReader
	 */
	public boolean isCreateCSVReader() {
		return createCSVReader;
	}

	/**
	 * @param createCSVReader
	 *            the createCSVReader to set
	 */
	public void setCreateCSVReader(boolean createCSVReader) {
		this.createCSVReader = createCSVReader;
	}

	/**
	 * @return the skipLines
	 */
	public String getSkipLines() {
		return skipLines;
	}

	/**
	 * @param skipLines
	 *            the skipLines to set
	 */
	public void setSkipLines(String skipLines) {
		this.skipLines = skipLines;
	}

	/**
	 * @return the quoteChar
	 */
	public String getQuoteChar() {
		return quoteChar;
	}

	/**
	 * @param quoteChar
	 *            the quoteChar to set
	 */
	public void setQuoteChar(String quoteChar) {
		this.quoteChar = quoteChar;
	}

	/**
	 * @return the encoding
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * @param encoding
	 *            the encoding to set
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getRootName() {
		return rootName;
	}

	public void setRootName(String rootName) {
		this.rootName = rootName;
	}

	public String getRecordName() {
		return recordName;
	}

	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}

	private void initValue() {
		indent = null;
		
		useAvailabelReader = false;
		
		filePath = null;

		hasReader = false;
		
		rootName = null;
		
		recordName = null;

		if (SmooksUIUtils.hasReaderAlready(CSV12Reader.class, smooksResourceList)
				|| SmooksUIUtils.hasReaderAlready(CSV12ReaderImpl.class, smooksResourceList)) {
			hasReader = true;
		}

		createCSVReader = true;

		encoding = "UTF-8"; //$NON-NLS-1$

		separator = null;

		skipLines = null;

		quoteChar = null;

		fieldsList.clear();

		if (hasReader) {
			createCSVReader = false;
			useAvailabelReader = true;
		}
	}

	public SmooksResourceListType getSmooksResourceList() {
		return smooksResourceList;
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @param filePath
	 *            the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void setSmooksResourceList(SmooksResourceListType smooksResourceList) {
		this.smooksResourceList = smooksResourceList;
	}

	public class FieldString {
		private String text = null;

		private String exampleValue;

		/**
		 * @return the exampleValue
		 */
		public String getExampleValue() {
			return exampleValue;
		}

		/**
		 * @param exampleValue
		 *            the exampleValue to set
		 */
		public void setExampleValue(String exampleValue) {
			this.exampleValue = exampleValue;
		}

		public FieldString(String text) {
			this.setText(text);
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
	}

	private class FieldsLabelProvider extends LabelProvider implements ITableLabelProvider, ITableFontProvider,
			ITableColorProvider {

		private Font font = null;

		public void dispose() {
			if (font != null) {
				font.dispose();
			}
			super.dispose();
		}

		public FieldsLabelProvider() {
			FontData fd = new FontData();
			fd.setName("Arial"); //$NON-NLS-1$
//			fd.setStyle(SWT.BOLD);
			font = new Font(null, fd);
		}

		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof FieldString) {
				switch(columnIndex){
				case 0 :
					return ((FieldString) element).getText();
				case 1:
					return ((FieldString) element).getExampleValue();
				}
				return ((FieldString) element).getText();
			}
			return getText(element);
		}

		public Font getFont(Object element, int columnIndex) {
			if (columnIndex == 0) {
				return font;
			}
			return null;
		}

		public Color getBackground(Object element, int columnIndex) {
			if (columnIndex == 1) {
				return ColorConstants.lightGray;
			}
			return null;
		}

		public Color getForeground(Object element, int columnIndex) {
			if (columnIndex == 1) {
				return org.eclipse.draw2d.ColorConstants.darkGray;
			}
			return null;
		}

	}

	private class FieldsContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof List<?>) {
				return ((List<?>) inputElement).toArray();
			}
			return new Object[] {};
		}

		public void dispose() {

		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		}

	}

}
