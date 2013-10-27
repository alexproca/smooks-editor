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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.jface.wizard.WizardDialog;
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
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.configuration.editors.csv12.CSVDataParser;
import org.jboss.tools.smooks.configuration.editors.edireader12.EDIDataParser;
import org.jboss.tools.smooks.configuration.editors.input.InputParameter;
import org.jboss.tools.smooks.configuration.editors.input.InputType;
import org.jboss.tools.smooks.configuration.editors.uitls.JsonInputDataParser;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.configuration.editors.wizard.StructuredDataSelectionWizard;
import org.jboss.tools.smooks.configuration.editors.xml.AbstractXMLObject;
import org.jboss.tools.smooks.configuration.editors.xml.TagList;
import org.jboss.tools.smooks.configuration.editors.xml.XMLObjectAnalyzer;
import org.jboss.tools.smooks.configuration.editors.xml.XSDObjectAnalyzer;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.launch.JavaGraphBuilder;
import org.jboss.tools.smooks.model.smooks.DocumentRoot;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;
import org.milyn.Smooks;
import org.milyn.payload.JavaSource;
import org.w3c.dom.Document;

/**
 * @author Dart (dpeng@redhat.com)
 *         <p>
 *         Apr 12, 2009
 */
public class SelectorCreationDialog extends Dialog {

	private TreeViewer viewer;
	private Object currentSelection;
	private Button onlyNameButton;
	private Button fullPathButton;
	private SelectorAttributes selectorAttributes = null;
	private IEditorPart editorPart = null;

	private static Throwable currentException = null;

	private FormToolkit toolkit;

	public SelectorCreationDialog(IShellProvider parentShell) {
		super(parentShell);
	}

	/**
	 * @return the currentException
	 */
	public static Throwable getCurrentException() {
		return currentException;
	}

	public SelectorCreationDialog(Shell parentShell, IEditorPart editorPart) {
		super(parentShell);
		selectorAttributes = new SelectorAttributes();
		this.editorPart = editorPart;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = 500;
		gd.widthHint = 450;
		composite.setLayoutData(gd);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginHeight = 10;
		layout.marginWidth = 10;
		layout.makeColumnsEqualWidth = false;
		composite.setLayout(layout);

		Label viewerLabel = new Label(composite, SWT.NONE);
		viewerLabel.setText(Messages.SelectorCreationDialog_InputViewerlabel);

		toolkit = new FormToolkit(getShell().getDisplay());

		Hyperlink link = toolkit
				.createHyperlink(composite, Messages.SelectorCreationDialog_AddInputLinkLabel, SWT.NONE);// new
		// Hyperlink(composite,SWT.NONE);
		link.setBackground(composite.getBackground());
		link.addHyperlinkListener(new IHyperlinkListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.ui.forms.events.IHyperlinkListener#linkActivated(
			 * org.eclipse.ui.forms.events.HyperlinkEvent)
			 */
			public void linkActivated(HyperlinkEvent e) {
				showInputDataWizard();
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.ui.forms.events.IHyperlinkListener#linkEntered(org
			 * .eclipse.ui.forms.events.HyperlinkEvent)
			 */
			public void linkEntered(HyperlinkEvent e) {

			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.ui.forms.events.IHyperlinkListener#linkExited(org
			 * .eclipse.ui.forms.events.HyperlinkEvent)
			 */
			public void linkExited(HyperlinkEvent e) {

			}

		});
		gd = new GridData();
		gd.horizontalAlignment = GridData.END;
		link.setLayoutData(gd);

		viewer = new TreeViewer(composite, SWT.BORDER);
		viewer.setContentProvider(new CompoundStructuredDataContentProvider());
		viewer.setLabelProvider(new CompoundStructuredDataLabelProvider());
		List<Object> inputList = generateInputData();
		viewer.setInput(inputList);
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				okPressed();
			}
		});
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				currentSelection = ((IStructuredSelection) event.getSelection()).getFirstElement();
			}
		});

		gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 2;
		viewer.getTree().setLayoutData(gd);

		Label label = new Label(composite, SWT.NONE);
		label.setText(Messages.SelectorCreationDialog_SperatorCharlabel);
		final Combo speratorCombo = new Combo(composite, SWT.BORDER | SWT.READ_ONLY);
		speratorCombo.add(" "); //$NON-NLS-1$
		speratorCombo.add("/"); //$NON-NLS-1$
		speratorCombo.select(1);
		// speratorCombo.setEditable(false);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		speratorCombo.setLayoutData(gd);
		speratorCombo.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				selectorAttributes.setSelectorSperator(speratorCombo.getText());
			}

		});

		Label l = new Label(composite, SWT.NONE);
		l.setText(Messages.SelectorCreationDialog_PolicyLabel);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		l.setLayoutData(gd);

		Composite com = new Composite(composite, SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		com.setLayoutData(gd);

		GridLayout gl = new GridLayout();
		gl.numColumns = 2;
		com.setLayout(gl);
		fullPathButton = new Button(com, SWT.RADIO);
		fullPathButton.setText(Messages.SelectorCreationDialog_FullPathPolicy);
		onlyNameButton = new Button(com, SWT.RADIO);
		onlyNameButton.setText(Messages.SelectorCreationDialog_OnlyNamePolicy);
		// Button containtParentButton = new Button(com,SWT.RADIO);
		// containtParentButton.setText("Containt Parent Name");
		fullPathButton.setSelection(true);

		handleButtons();

		getShell().setText(Messages.SelectorCreationDialog_DialogTitle);

		SmooksUIUtils.expandSelectorViewer(inputList, viewer);

		return composite;
	}

	private void handleButtons() {
		fullPathButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selectorAttributes.setSelectorPolicy(SelectorAttributes.FULL_PATH);
			}
		});

		onlyNameButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selectorAttributes.setSelectorPolicy(SelectorAttributes.ONLY_NAME);
			}
		});
	}

	public static List<Object> generateInputData(SmooksResourceListType smooksResourceListType) {
		currentException = null;
		List<Object> list = new ArrayList<Object>();
		if (smooksResourceListType != null) {
			IJavaProject project = SmooksUIUtils.getJavaProject(smooksResourceListType);
			try {
				List<InputType> inputLists = SmooksUIUtils.getInputTypeList(smooksResourceListType);
				for (Iterator<?> iterator = inputLists.iterator(); iterator.hasNext();) {
					InputType inputType = (InputType) iterator.next();
					if (!inputType.isActived())
						continue;
					String type = inputType.getType();
					String path = inputType.getPath();
					if (type != null && path != null) {
						path = path.trim();
						if (SmooksModelUtils.INPUT_TYPE_EDI_1_1.equals(type)
								|| SmooksModelUtils.INPUT_TYPE_EDI_1_2.equals(type)) {
							EDIDataParser parser = new EDIDataParser();
							try {
								TagList tl = parser.parseEDIFile(path, smooksResourceListType);
								if (tl != null) {
									list.addAll(((TagList) tl).getChildren());
								}
							} catch (Throwable t) {
								currentException = t;
							}
						}
						if (SmooksModelUtils.INPUT_TYPE_CSV.equals(type)
								|| SmooksModelUtils.INPUT_TYPE_CSV_1_2.equals(type)) {
							CSVDataParser parser = new CSVDataParser();
							try {
								TagList tl = parser.parseCSV(path, smooksResourceListType);
								if (tl != null) {
									list.addAll(((TagList) tl).getChildren());
								}
							} catch (Throwable t) {
								currentException = t;
							}
						}
						if (SmooksModelUtils.INPUT_TYPE_JSON_1_1.equals(type)
								|| SmooksModelUtils.INPUT_TYPE_JSON_1_2.equals(type)) {
							try {
								JsonInputDataParser parser = new JsonInputDataParser();
								IXMLStructuredObject tagList = parser.parseJsonFile(SmooksUIUtils.parseFilePath(path),
										smooksResourceListType);
								if (tagList instanceof TagList) {
									list.addAll(((TagList) tagList).getChildren());
								} else {
									list.add(tagList);
								}
							} catch (Throwable tt) {
								currentException = tt;
							}
						}
						if (SmooksModelUtils.INPUT_TYPE_JAVA.equals(type)) {
							try {
								Class<?> clazz = SmooksUIUtils.loadClass(path, project);
								Document newmodel = getModel(clazz);
								if (newmodel != null) {
									TagList tagList = new XMLObjectAnalyzer().analyze(newmodel, null , null);
									list.addAll(tagList.getChildren());
								} 
							} catch (Throwable t) {
								currentException = t;
							}
						}
						if (SmooksModelUtils.INPUT_TYPE_XSD.equals(type)) {
							try {
								path = SmooksUIUtils.parseFilePath(path);
								String rootElementName = null;
								List<InputParameter> paramers = inputType.getParameters();
								for (Iterator<?> iterator2 = paramers.iterator(); iterator2.hasNext();) {
									InputParameter paramType = (InputParameter) iterator2.next();
									String pn = paramType.getName();
									if ("rootElement".equals(pn)) { //$NON-NLS-1$
										rootElementName = paramType.getValue();
										break;
									}
								}
								if (rootElementName != null) {
									rootElementName = rootElementName.trim();
									list.add(new XSDObjectAnalyzer().loadElement(path, rootElementName));
								}
							} catch (Throwable tt) {
								currentException = tt;
							}
						}
						if (SmooksModelUtils.INPUT_TYPE_XML.equals(type)) {
							try {
								path = SmooksUIUtils.parseFilePath(path);

								// XMLObjectAnalyzer analyzer = new
								// XMLObjectAnalyzer();
								// TagList doc = analyzer.analyze(path, null);

								AbstractXMLObject model = new XMLObjectAnalyzer().analyze(path, null , null);
								if (model != null) {
									if (model instanceof TagList) {
										list.addAll(((TagList) model).getChildren());
									} else {
										list.add(model);
									}
								}
							} catch (Throwable e) {
								currentException = e;
							}
						}
					}
				}
			} catch (Exception e) {
				currentException = e;
				// SmooksConfigurationActivator.getDefault().log(e);
			}
		}
		return list;
	}

	public static List<Object> generateInputDataForSmooks10() {
		List<Object> list = new ArrayList<Object>();
		// if (extType != null) {
		// IJavaProject project = SmooksUIUtils.getJavaProject(extType);
		// try {
		// List<InputType> inputLists = extType.getInput();
		// for (Iterator<?> iterator = inputLists.iterator();
		// iterator.hasNext();) {
		// InputType inputType = (InputType) iterator.next();
		// if (!SmooksUIUtils.isActivedInput(inputType))
		// continue;
		// String type = inputType.getType();
		// String path = SmooksModelUtils.getInputPath(inputType);
		// if (type != null && path != null) {
		// path = path.trim();
		// if (SmooksModelUtils.INPUT_TYPE_EDI_1_1.equals(type)
		// || SmooksModelUtils.INPUT_TYPE_EDI_1_2.equals(type)) {
		// }
		// if (SmooksModelUtils.INPUT_TYPE_CSV.equals(type)
		// || SmooksModelUtils.INPUT_TYPE_CSV_1_2.equals(type)) {
		// }
		// if (SmooksModelUtils.INPUT_TYPE_JSON_1_1.equals(type)
		// || SmooksModelUtils.INPUT_TYPE_JSON_1_2.equals(type)) {
		// }
		// if (SmooksModelUtils.INPUT_TYPE_JAVA.equals(type)) {
		// try {
		// Class<?> clazz = SmooksUIUtils.loadClass(path, project);
		// JavaBeanModel model =
		// JavaBeanModelFactory.getJavaBeanModelWithLazyLoad(clazz);
		// if (model != null) {
		// list.add(model);
		// }
		// } catch (Throwable t) {
		// // ignore
		// }
		// }
		// if (SmooksModelUtils.INPUT_TYPE_XSD.equals(type)) {
		// try {
		// path = SmooksUIUtils.parseFilePath(path);
		// String rootElementName = null;
		// List<ParamType> paramers = inputType.getParam();
		// for (Iterator<?> iterator2 = paramers.iterator();
		// iterator2.hasNext();) {
		// ParamType paramType = (ParamType) iterator2.next();
		// if ("rootElement".equals(paramType.getName())) {
		// rootElementName = paramType.getValue();
		// break;
		// }
		// }
		// if (rootElementName != null) {
		// rootElementName = rootElementName.trim();
		// list.add(new XSDObjectAnalyzer().loadElement(path, rootElementName));
		// }
		// } catch (Throwable tt) {
		// // ingore
		// }
		// }
		// if (SmooksModelUtils.INPUT_TYPE_XML.equals(type)) {
		// try {
		// path = SmooksUIUtils.parseFilePath(path);
		//
		// // XMLObjectAnalyzer analyzer = new
		// // XMLObjectAnalyzer();
		// // TagList doc = analyzer.analyze(path, null);
		//
		// AbstractXMLObject model = new XMLObjectAnalyzer().analyze(path,
		// null);
		// if (model != null) {
		// if (model instanceof TagList) {
		// list.addAll(((TagList) model).getChildren());
		// } else {
		// list.add(model);
		// }
		// }
		// } catch (Throwable e) {
		//
		// }
		// }
		// }
		// }
		// } catch (Exception e) {
		// // SmooksConfigurationActivator.getDefault().log(e);
		// }
		// }
		return list;
	}

	protected List<Object> generateInputData() {
		Object obj = null;
		if (editorPart instanceof ISmooksModelProvider) {
			obj = ((ISmooksModelProvider) editorPart).getSmooksModel();
		} else {
			ISmooksModelProvider provider = (ISmooksModelProvider) editorPart.getAdapter(ISmooksModelProvider.class);
			if (provider != null) {
				obj = provider.getSmooksModel();
			}
		}
		if (obj == null) {
			List<Object> ll = Collections.emptyList();
			return ll;
		}
		SmooksResourceListType resourceList = null;
		if (obj instanceof DocumentRoot) {
			resourceList = ((DocumentRoot) obj).getSmooksResourceList();
		}
		return generateInputData(resourceList);
	}

	protected void showInputDataWizard() {
		StructuredDataSelectionWizard wizard = new StructuredDataSelectionWizard();
		if (this.editorPart != null) {
			wizard.setInput(editorPart.getEditorInput());
			wizard.setSite(editorPart.getEditorSite());
		}

		wizard.setForcePreviousAndNextButtons(true);
		StructuredDataSelectionWizardDailog dialog = new StructuredDataSelectionWizardDailog(this.getShell(), wizard);
		if (dialog.show() == WizardDialog.OK) {
			List<Object> input = this.generateInputData();
			this.viewer.setInput(input);
			SmooksUIUtils.expandSelectorViewer(input, viewer);
		}
	}

	/**
	 * @return the currentSelection
	 */
	public Object getCurrentSelection() {
		return currentSelection;
	}

	public SelectorAttributes getSelectorAttributes() {
		return selectorAttributes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#close()
	 */
	@Override
	public boolean close() {
		if (toolkit != null) {
			toolkit.dispose();
		}
		return super.close();
	}

	public static Document getModel(Class<?> theModelClass) throws Exception {
		try {
			Object objectGraph = graphBuilder.buildGraph(theModelClass);
			DOMResult domResult = new DOMResult();
			
			// Filter a populated object model through an actual smooks runtime instance.
			// this ensures that the generated model will be exactly the same as that seen
			// by the smooks instance at runtime...
			smooksRuntime.filterSource(new JavaSource(objectGraph), domResult);
			
			return (Document) domResult.getNode();
		} catch (Exception e) {
			throw new Exception("Error build project classpath.", e);  //$NON-NLS-1$
		}
	}

	private static JavaGraphBuilder graphBuilder = new JavaGraphBuilder();
	private static Smooks smooksRuntime = new Smooks();
	
	private static void printDocumentAsXML ( Document document ) {
		// Use a Transformer for output
		TransformerFactory tFactory =
			TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = tFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(System.out);
			transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}
}
