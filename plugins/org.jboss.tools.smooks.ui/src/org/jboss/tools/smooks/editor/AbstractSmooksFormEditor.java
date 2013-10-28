package org.jboss.tools.smooks.editor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.wst.sse.ui.StructuredTextEditor;
import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.configuration.RuntimeDependency;
import org.jboss.tools.smooks.configuration.RuntimeMetadata;
import org.jboss.tools.smooks.configuration.SmooksConfigurationActivator;
import org.jboss.tools.smooks.configuration.SmooksConstants;
import org.jboss.tools.smooks.configuration.editors.SmooksXMLEditor;
import org.jboss.tools.smooks.configuration.editors.utils.SmooksUIUtils;
import org.jboss.tools.smooks.configuration.editors.xml.XMLUtils;
import org.jboss.tools.smooks.configuration.validate.ISmooksModelValidateListener;
import org.jboss.tools.smooks.configuration.validate.SmooksMarkerHelper;
import org.jboss.tools.smooks.configuration.validate.SmooksModelValidator;
import org.jboss.tools.smooks.graphical.editors.ISmooksEditorInitListener;
import org.jboss.tools.smooks.model.common.AbstractAnyType;
import org.jboss.tools.smooks.model.common.provider.CommonItemProviderAdapterFactory;
import org.jboss.tools.smooks.model.csv12.provider.Csv12ItemProviderAdapterFactory;
import org.jboss.tools.smooks.model.edi12.provider.Edi12ItemProviderAdapterFactory;
import org.jboss.tools.smooks.model.freemarker.provider.FreemarkerItemProviderAdapterFactory;
import org.jboss.tools.smooks.model.javabean12.provider.Javabean12ItemProviderAdapterFactory;
import org.jboss.tools.smooks.model.json12.provider.Json12ItemProviderAdapterFactory;
import org.jboss.tools.smooks.model.medi.provider.MEdiItemProviderAdapterFactory;
import org.jboss.tools.smooks.model.smooks.DocumentRoot;
import org.jboss.tools.smooks.model.smooks.ParamType;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;
import org.jboss.tools.smooks.model.smooks.provider.SmooksItemProviderAdapterFactory;
import org.jboss.tools.smooks.model.smooks.util.SmooksResourceFactoryImpl;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class AbstractSmooksFormEditor extends FormEditor implements IEditingDomainProvider,
		ISmooksModelValidateListener, ISmooksModelProvider {

	private IResourceChangeListener resourceChangeListener = null;

	private IDocumentListener xmlDocumentTraker = null;

	private Exception initSmooksModelException = null;

	protected String platformVersion = SmooksConstants.VERSION_1_2;

	protected List<ISmooksEditorInitListener> smooksInitListener = new ArrayList<ISmooksEditorInitListener>();

	protected String inputType = null;

	protected List<ISourceSynchronizeListener> sourceSynchronizeListener = new ArrayList<ISourceSynchronizeListener>();

	public static final String EDITOR_ID = "org.jboss.tools.smooks.edimap.editors.MultiPageEditor"; //$NON-NLS-1$

	protected StructuredTextEditor textEditor = null;

	protected ComposedAdapterFactory adapterFactory;

	protected EditingDomain editingDomain = null;

	// private PropertySheetPage propertySheetPage = null;

	protected SmooksModelValidator validator = null;

	protected EObject smooksModel;

	private boolean handleEMFModelChange;

	protected SmooksMarkerHelper markerHelper = new SmooksMarkerHelper();

	protected List<Diagnostic> diagnosticList;

	protected boolean graphChanged = false;

	// private Object smooksDOMModel;

	public AbstractSmooksFormEditor() {
		super();
		resourceChangeListener = new SmooksResourceTraker();
		xmlDocumentTraker = new SmooksXMLEditorDocumentListener();
		initEditingDomain();
	}

	/**
	 * @return the inputType
	 */
	public String getInputType() {
		ParamType inputParam = SmooksUIUtils.getInputTypeParam(SmooksUIUtils.getSmooks11ResourceListType(smooksModel));
		if (inputParam != null) {
			return inputParam.getStringValue();
		}
		return null;
	}

	/**
	 * @param inputType
	 *            the inputType to set
	 */
	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	/**
	 * @return the platformVersion
	 */
	public String getPlatformVersion() {
		return platformVersion;
	}

	/**
	 * @param platformVersion
	 *            the platformVersion to set
	 */
	public void setPlatformVersion(String platformVersion) {
		this.platformVersion = platformVersion;
	}

	public void addSmooksEditorInitListener(ISmooksEditorInitListener listener) {
		this.smooksInitListener.add(listener);
	}

	public void removeSmooksEditorInitListener(ISmooksEditorInitListener listener) {
		this.smooksInitListener.remove(listener);
	}

	@Override
	public Object getAdapter(Class adapter) {
		if (adapter == ISmooksModelProvider.class)
			return this;
		if (adapter == IEditingDomainProvider.class) {
			return this;
		}
		return super.getAdapter(adapter);
	}

	public void addSourceSynchronizeListener(ISourceSynchronizeListener listener) {
		this.sourceSynchronizeListener.add(listener);
	}

	public void removeSourceSynchronizeListener(ISourceSynchronizeListener listener) {
		this.sourceSynchronizeListener.remove(listener);
	}

	private void handleCommandStack(BasicCommandStack commandStack) {
		commandStack.addCommandStackListener(new CommandStackListener() {
			public void commandStackChanged(EventObject event) {
				firePropertyChange(IEditorPart.PROP_DIRTY);
				handleEMFModelChange();
				// Try to select the affected objects.
				//
				final Command mostRecentCommand = ((CommandStack) event.getSource()).getMostRecentCommand();
				getContainer().getDisplay().asyncExec(new Runnable() {
					public void run() {
						if (mostRecentCommand != null) {
							Command rawCommand = mostRecentCommand;
							while (rawCommand instanceof CommandWrapper) {
								rawCommand = ((CommandWrapper) rawCommand).getCommand();
							}
							if (rawCommand instanceof SetCommand || rawCommand instanceof AddCommand
									|| rawCommand instanceof DeleteCommand) {
								activeRecentAffectedModel(mostRecentCommand.getAffectedObjects());
							}
						}
					}
				});
			}
		});
	}

	public StructuredTextEditor getTextEditor() {
		return textEditor;
	}

	protected ByteArrayOutputStream getFormattedXMLContentsStream(InputStream outstream) throws IOException {

		try {
			Document doc = XMLUtils.getDOMBuilder().parse(outstream);
			EObject rootModel = this.getSmooksModel();
			fillComments(doc, rootModel);
			ByteArrayOutputStream stream = new ByteArrayOutputStream();

			XMLUtils.outDOMNode(doc, stream);
			return stream;
		} catch (Throwable t) {

		} finally {
		}
		return null;
	}

	protected void fillComments(Document document, EObject rootModel) {
		try {
			if (rootModel instanceof DocumentRoot) {
				EObject rootElementModel = ((DocumentRoot) rootModel).getSmooksResourceList();
				Element rootElement = document.getDocumentElement();
				try {
					fillComments(rootElementModel, rootElement);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Throwable t) {
			// ignore exception;
		}
	}

	protected void fillComments(EObject rootElementModel, Element rootElement) {
		if (rootElementModel instanceof AbstractAnyType) {
			List<String> comments = ((AbstractAnyType) rootElementModel).getCommentList();
			for (Iterator<?> iterator = comments.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
				Integer commentIndex = ((AbstractAnyType) rootElementModel).getCommentIndex(string);
				List<?> content = XMLUtils.getAllChildElements(rootElement);
				List<Object> deletedElementList = new ArrayList<Object>();
				if (commentIndex.intValue() < content.size()) {
					List<Object> tempelements = new ArrayList<Object>(content);
					for (int i = commentIndex.intValue(); i < content.size(); i++) {
						Element deleteObj = (Element) tempelements.get(i);
						Node remodedObj = rootElement.removeChild(deleteObj);
						if (remodedObj != null) {
							deletedElementList.add(remodedObj);
						}
					}
				}
				Comment comment = rootElement.getOwnerDocument().createComment(string);
				rootElement.appendChild(comment);
				for (int j = 0; j < deletedElementList.size(); j++) {
					Element deleteElement = (Element) deletedElementList.get(j);
					rootElement.appendChild(deleteElement);
				}
			}

			List<EObject> childrenModel = ((AbstractAnyType) rootElementModel).eContents();
			List<?> elements = XMLUtils.getAllChildElements(rootElement);
			int length = Math.min(childrenModel.size(), elements.size());
			for (int index = 0; index < length; index++) {
				EObject child = childrenModel.get(index);
				Element childElement = (Element) elements.get(index);
				fillComments(child, childElement);
			}
		}
	}

	protected String getFormattedXMLContents(String contents) throws IOException {
		InputStream istream = null;
		ByteArrayOutputStream stream = null;
		try {
			istream = new ByteArrayInputStream(contents.getBytes());
			stream = getFormattedXMLContentsStream(istream);
			return new String(stream.toByteArray());
		} catch (Throwable t) {

		} finally {
			if (istream != null) {
				istream.close();
			}
			if (stream != null) {
				stream.close();
			}
		}
		return null;
	}

	protected void handleEMFModelChange() {
		IDocument document = textEditor.getDocumentProvider().getDocument(textEditor.getEditorInput());

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			smooksModel.eResource().save(out, null);

			String newContent = out.toString();
			newContent = getFormattedXMLContents(newContent);

			String oldContent = document.get();

			int startIndex = 0;
			while (startIndex < newContent.length() && startIndex < oldContent.length()
					&& newContent.charAt(startIndex) == oldContent.charAt(startIndex)) {
				++startIndex;
			}
			int newEndIndex = newContent.length() - 1;
			int oldEndIndex = oldContent.length() - 1;
			while (newEndIndex >= startIndex && oldEndIndex >= startIndex
					&& newContent.charAt(newEndIndex) == oldContent.charAt(oldEndIndex)) {
				--newEndIndex;
				--oldEndIndex;
			}

			String replacement = newContent.substring(startIndex, newEndIndex + 1);
			int length = oldEndIndex - startIndex + 1;
			handleEMFModelChange = true;
			document.replace(startIndex, length, replacement);

			validator.startValidate(smooksModel.eResource().getContents(), editingDomain);

		} catch (Exception exception) {
			SmooksConfigurationActivator.getDefault().log(exception);
		}

	}

	@Override
	public boolean isDirty() {
		return graphChanged || ((BasicCommandStack) editingDomain.getCommandStack()).isSaveNeeded() || super.isDirty();
	}

	public EObject getSmooksModel() {
		return smooksModel;
	}

	public void setSmooksModel(EObject smooksModel) {
		if (this.smooksModel != smooksModel) {
			this.smooksModel = smooksModel;
			handleEMFModelChange();
		}
	}

	protected void initEditingDomain() {
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		// add smooks 1.1.2 EMF item provider model
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new FreemarkerItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new CommonItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new SmooksItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new MEdiItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		// add smooks 1.2 EMF itemprovider
		adapterFactory.addAdapterFactory(new Json12ItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new Edi12ItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new Javabean12ItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new Csv12ItemProviderAdapterFactory());

		BasicCommandStack commandStack = new BasicCommandStack(){

			@Override
			protected void handleError(Exception exception) {
				super.handleError(exception);
			}
			
		};
		handleCommandStack(commandStack);
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<Resource, Boolean>());
	}

	public void activeRecentAffectedModel(Collection<?> collection) {

	}

	public void addValidateListener(ISmooksModelValidateListener listener) {
		validator.addValidateListener(listener);
	}

	public void removeValidateListener(ISmooksModelValidateListener listener) {
		validator.removeValidateListener(listener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.editor.FormEditor#addPages()
	 */
	@Override
	protected void addPages() {
		textEditor = createTextEditor();
		try {
			int index = this.addPage(textEditor, getEditorInput());
			setPageText(index, Messages.AbstractSmooksFormEditor_Source_Page_Title);
			((SmooksXMLEditor)textEditor).setParentEditorPart(this);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		int messageType = IMessageProvider.ERROR;
		Exception exception = initSmooksModelException;
		if (exception == null) {
			exception = checkSmooksConfigContents(null);
			messageType = IMessageProvider.WARNING;
		}
		if (exception != null) {
			for (Iterator<?> iterator = this.smooksInitListener.iterator(); iterator.hasNext();) {
				ISmooksEditorInitListener initListener = (ISmooksEditorInitListener) iterator.next();
				initListener.initFailed(messageType, exception.getMessage());
			}
		}
	}

	protected StructuredTextEditor createTextEditor() {
		SmooksXMLEditor xmlEditor = new SmooksXMLEditor() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.jboss.tools.smooks.configuration.editors.SmooksXMLEditor#
			 * doSetInput(org.eclipse.ui.IEditorInput)
			 */
			@Override
			public void doSetInput(IEditorInput input) throws CoreException {
				TextViewer viewer = getTextViewer();
				if (viewer != null) {
					IDocument document = viewer.getDocument();
					if (document != null) {
						document.removeDocumentListener(xmlDocumentTraker);
					}
				}
				super.doSetInput(input);
				viewer = getTextViewer();
				if (viewer != null) {
					IDocument document = viewer.getDocument();
					if (document != null) {
						document.addDocumentListener(xmlDocumentTraker);
					}
				}
			}

			public void createPartControl(Composite parent) {
				super.createPartControl(parent);
				getTextViewer().getDocument().addDocumentListener(xmlDocumentTraker);

			}

		};
		return xmlEditor;
	}

	protected void createNewModelViaTextPage() {
		IDocumentProvider dp = textEditor.getDocumentProvider();
		if (dp == null)
			return;
		Exception exception = null;
		int messageType = IMessageProvider.NONE;
		IDocument document = dp.getDocument(textEditor.getEditorInput());
		String conents = document.get();
		Resource resource = editingDomain.getResourceSet().getResources().get(0);
		resource.unload();
		InputStream stream = null;
		stream = new ByteArrayInputStream(conents.getBytes());
		exception = checkSmooksConfigContents(stream);
		if (exception != null)
			messageType = IMessageProvider.WARNING;
		if (exception == null) {
			try {
				stream = new ByteArrayInputStream(conents.getBytes());
				resource.load(stream, Collections.emptyMap());
				this.smooksModel = resource.getContents().get(0);
			} catch (Exception e) {
				smooksModel = null;
				exception = e;
				messageType = IMessageProvider.ERROR;
			} finally {
				if (stream != null) {
					try {
						stream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		setPlatformVersion(SmooksUIUtils.judgeSmooksPlatformVersion(smooksModel));
		judgeInputReader();
		for (Iterator<?> iterator = this.sourceSynchronizeListener.iterator(); iterator.hasNext();) {
			ISourceSynchronizeListener l = (ISourceSynchronizeListener) iterator.next();
			try {
				l.sourceChange(smooksModel);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String message = null;
		if (exception != null) {
			message = exception.getMessage();
		}
		if (message == null) {
			message = Messages.AbstractSmooksFormEditor_Error_Unknown;
		}
		for (Iterator<?> iterator = this.smooksInitListener.iterator(); iterator.hasNext();) {
			ISmooksEditorInitListener initListener = (ISmooksEditorInitListener) iterator.next();
			initListener.initFailed(messageType, message);
		}
	}

	protected void handleDocumentChange() {
		createNewModelViaTextPage();
		try {
			validator.startValidate(smooksModel.eResource().getContents(), editingDomain);
		} catch (Throwable e) {

		}
	}

	// protected SmooksConfigurationFormPage createSmooksConfigurationFormPage()
	// {
	// return new SmooksConfigurationFormPage(this, "DesignPage",
	// "Design Page");
	// }

	protected void initSaveOptions(Map<?, ?> options) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.ui.part.EditorPart#doSave(org.eclipse.core.runtime.
	 * IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {
		if(monitor == null){
			monitor = new NullProgressMonitor();
		}
		try {
			IEditorPart activeEditor = getActiveEditor();
			if (this.smooksModel == null || (activeEditor != null && activeEditor == textEditor)) {
				textEditor.doSave(monitor);
				((BasicCommandStack) editingDomain.getCommandStack()).saveIsDone();

			} else {
				Map<?, ?> options = Collections.emptyMap();
				initSaveOptions(options);
				if (editingDomain != null) {
					ResourceSet resourceSet = editingDomain.getResourceSet();
					List<Resource> resourceList = resourceSet.getResources();
					monitor.beginTask(Messages.AbstractSmooksFormEditor_Task_Saving_File, resourceList.size());

					for (Iterator<Resource> iterator = resourceList.iterator(); iterator.hasNext();) {
						handleEMFModelChange = true;
						Resource resource = (Resource) iterator.next();
						ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
						resource.save(outputStream, options);
						IResource file = SmooksUIUtils.getResource(resource);
						if (file.exists() && file instanceof IFile) {
							ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
							ByteArrayOutputStream newOutputStream = getFormattedXMLContentsStream(inputStream);
							try {
								((IFile) file).setContents(new ByteArrayInputStream(newOutputStream.toByteArray()),
										IResource.FORCE, monitor);
							} catch (CoreException e) {
								e.printStackTrace();
							} finally {
								if (outputStream != null) {
									outputStream.close();
								}
								if (newOutputStream != null) {
									newOutputStream.close();
								}
								if (inputStream != null) {
									inputStream.close();
								}
							}
						}
						monitor.worked(1);
					}
					((BasicCommandStack) editingDomain.getCommandStack()).saveIsDone();
					textEditor.doRevertToSaved();
				}
			}
			graphChanged = false;
			firePropertyChange(PROP_DIRTY);
			if (this.smooksModel != null && validator != null) {
				validator.startValidate(smooksModel.eResource().getContents(), editingDomain);
			}
		} catch (IOException e) {
			SmooksConfigurationActivator.log(e);
		} finally {
			monitor.done();
		}
	}

	public void setInput(IEditorInput input) {
		if (getEditorInput() != null) {
			IFile file = ((IFileEditorInput) getEditorInput()).getFile();
			file.getWorkspace().removeResourceChangeListener(resourceChangeListener);
		}

		super.setInput(input);

		if (getEditorInput() != null) {
			IFile file = ((IFileEditorInput) getEditorInput()).getFile();
			file.getWorkspace().addResourceChangeListener(resourceChangeListener);
			setPartName(file.getName());
		}

		String filePath = null;

		IFile file = null;

		if (input instanceof IFileEditorInput) {
			file = ((IFileEditorInput) input).getFile();
			filePath = file.getFullPath().toPortableString();
		}

		editingDomain.getResourceSet().getResources().clear();
		// create EMF resource
		Resource smooksResource = null;
		if (file != null) {
			smooksResource = new SmooksResourceFactoryImpl().createResource(URI.createPlatformResourceURI(filePath,
					false));
		} else {
			smooksResource = new SmooksResourceFactoryImpl().createResource(URI.createFileURI(filePath));
		}
		editingDomain.getResourceSet().getResources().add(smooksResource);

		Exception ex = checkSmooksConfigContents(null);
		if (ex == null) {
			if (smooksModel == null) {
				try {
					smooksResource.load(Collections.emptyMap());
					smooksModel = smooksResource.getContents().get(0);
				} catch (IOException e) {
					initSmooksModelException = e;
				}
			} else {
				smooksResource.getContents().add(smooksModel);
			}
		}
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {

		// create Smooks validator
		if (validator == null) {
			validator = new SmooksModelValidator();
			addValidateListener(this);
		}
		
		RuntimeMetadata runtimeMetadata = new RuntimeMetadata();
		String filePath = null;
		IFile file = null;
		if (input instanceof FileStoreEditorInput) {
			try {
				filePath = ((FileStoreEditorInput) input).getURI().toURL().getFile();
				runtimeMetadata.setSmooksConfig(new File(filePath));
			} catch (MalformedURLException e) {
				throw new PartInitException(Messages.AbstractSmooksFormEditor_Exception_Transform_URL, e);
			}
		}
		if (input instanceof IFileEditorInput) {
			file = ((IFileEditorInput) input).getFile();
			runtimeMetadata.setSmooksConfig(file);
			filePath = file.getFullPath().toPortableString();
		}

		if (filePath == null)
			throw new PartInitException(Messages.AbstractSmooksFormEditor_Exception_Cannot_Get_Input_File);

		super.init(site, input);

		if (smooksModel != null) {
			setDiagnosticList(validator.validate(smooksModel.eResource().getContents(), editingDomain));
			// if success to open editor , check if there isn't ext element
			// in
			// smooks config file
			// create new one for it
			String version = SmooksUIUtils.judgeSmooksPlatformVersion(smooksModel);
			this.setPlatformVersion(version);
			judgeInputReader();
		}
	}

	private void assertConfigSupported(RuntimeMetadata runtimeMetadata) throws PartInitException {
		List<RuntimeDependency> dependencies = runtimeMetadata.getDependencies();

		for (RuntimeDependency dependency : dependencies) {
			if (!dependency.isSupportedByEditor()) {
				java.net.URI changeToNS = dependency.getChangeToNS();
				String errorMsg = Messages.AbstractSmooksFormEditor_Error_Unsupported + dependency.getNamespaceURI()
						+ Messages.AbstractSmooksFormEditor_Error_Unsupported2;

				if (changeToNS != null) {
					errorMsg += Messages.AbstractSmooksFormEditor_Error_Update_Namespace + changeToNS
							+ Messages.AbstractSmooksFormEditor_Error_Update_Namespace2;
				}

				throw new PartInitException(errorMsg);
			}
		}
	}

	protected Exception checkSmooksConfigContents(InputStream stream) {
		// Check
		Exception exception = null;
		IFile file = null;
		String filePath = null;
		RuntimeMetadata runtimeMetadata = new RuntimeMetadata();
		IEditorInput input = getEditorInput();
		if (input instanceof FileStoreEditorInput) {
			try {
				filePath = ((FileStoreEditorInput) input).getURI().toURL().getFile();
				runtimeMetadata.setSmooksConfig(new File(filePath), stream);
			} catch (MalformedURLException e) {
				exception = e;
				// throw new PartInitException("Transform URL to URL error.",
				// e);
			}
		}
		if (exception == null) {
			if (input instanceof IFileEditorInput) {
				file = ((IFileEditorInput) input).getFile();
				File f = new File(file.getRawLocation().toOSString().trim());
				runtimeMetadata.setSmooksConfig(f, stream);
			}

			try {

				assertConfigSupported(runtimeMetadata);

			} catch (PartInitException e) {
				exception = e;
			}
		}
		return exception;
	}

	protected void judgeInputReader() {
		SmooksResourceListType resourceList = SmooksUIUtils.getSmooks11ResourceListType(smooksModel);
		if (resourceList == null)
			return;
		ParamType param = SmooksUIUtils.getInputTypeParam(resourceList);
		String inputType = null;
		if (param != null) {
			inputType = param.getStringValue();
			if (inputType == null || !SmooksUIUtils.isValidInputSourceType(inputType)) {
				this.setInputType(SmooksModelUtils.INPUT_TYPE_XML);
			} else {
				this.setInputType(inputType);
			}
		} else {
			this.setInputType(SmooksModelUtils.INPUT_TYPE_XML);
			SmooksUIUtils.addInputTypeParam(SmooksModelUtils.INPUT_TYPE_XML, resourceList);
		}
	}

	public EObject getSmooksResourceList() {
		EObject m = null;
		EObject smooksModel = getSmooksModel();
		if (smooksModel instanceof DocumentRoot) {
			m = ((DocumentRoot) smooksModel).getSmooksResourceList();
		}
		return m;
	}

	public IPath getNewPath(IFile file) {
		IPath fullPath = file.getFullPath();
		fullPath.removeLastSegments(1);
		fullPath.append("New name"); //$NON-NLS-1$
		return fullPath;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.EditorPart#doSaveAs()
	 */
	public void doSaveAs() {

	}

	public ComposedAdapterFactory getAdapterFactory() {
		return adapterFactory;
	}

	public void setAdapterFactory(ComposedAdapterFactory adapterFactory) {
		this.adapterFactory = adapterFactory;
	}

	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	public void setEditingDomain(EditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	/**
	 * @return the diagnostic
	 */
	public List<Diagnostic> getDiagnosticList() {
		return diagnosticList;
	}

	/**
	 * @param diagnosticList
	 *            the diagnostic to set
	 */
	public void setDiagnosticList(List<Diagnostic> d) {
		this.diagnosticList = d;

		if (markerHelper != null) {
			Resource resource = editingDomain.getResourceSet().getResources().get(0);
			if (resource != null) {
				markerHelper.deleteMarkers(resource);
			}
			for (Iterator<?> iterator = d.iterator(); iterator.hasNext();) {
				Diagnostic diagnostic = (Diagnostic) iterator.next();
				if (resource != null && diagnostic.getSeverity() != Diagnostic.OK) {
					for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
						markerHelper.createMarkers(resource, childDiagnostic);
					}
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.EditorPart#isSaveAsAllowed()
	 */
	public boolean isSaveAsAllowed() {
		return false;
	}

	public void validateEnd(List<Diagnostic> diagnosticResult) {
		setDiagnosticList(diagnosticResult);
	}

	public void validateStart() {

	}

	public void graphPropertyChange(EStructuralFeature featre, Object value) {
		// if
		// (featre.equals(GraphPackage.Literals.SMOOKS_GRAPHICS_EXT_TYPE__AUTHOR)
		// ||
		// featre.equals(GraphPackage.Literals.SMOOKS_GRAPHICS_EXT_TYPE__PLATFORM_VERSION)
		// ||
		// featre.equals(GraphPackage.Literals.SMOOKS_GRAPHICS_EXT_TYPE__NAME)
		// ||
		// featre.equals(GraphPackage.Literals.SMOOKS_GRAPHICS_EXT_TYPE__INPUT_TYPE))
		// {
		// graphChanged = true;
		// firePropertyChange(PROP_DIRTY);
		// }
	}

	public class SmooksXMLEditorDocumentListener implements IDocumentListener {
		protected Timer timer = new Timer();
		protected TimerTask timerTask;

		public void documentAboutToBeChanged(DocumentEvent documentEvent) {
			// Ingore
		}

		public void documentChanged(final DocumentEvent documentEvent) {
			try {
				// This is need for the Properties view.
				//
				// setSelection(StructuredSelection.EMPTY);

				if (timerTask != null) {
					timerTask.cancel();
				}

				if (handleEMFModelChange) {
					handleEMFModelChange = false;
				} else {
					timerTask = new TimerTask() {
						@Override
						public void run() {
							getSite().getShell().getDisplay().asyncExec(new Runnable() {
								public void run() {
									handleDocumentChange();
								}
							});
						}
					};

					timer.schedule(timerTask, 1000);
				}
			} catch (Exception exception) {
				SmooksConfigurationActivator.log(exception);
			}
		}
	}

	public class SmooksResourceTraker implements IResourceChangeListener, IResourceDeltaVisitor {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.core.resources.IResourceChangeListener#resourceChanged
		 * (org.eclipse.core.resources.IResourceChangeEvent)
		 */
		public void resourceChanged(IResourceChangeEvent event) {
			IResourceDelta delta = event.getDelta();
			try {
				if (delta != null)
					delta.accept(this);
			} catch (CoreException exception) {
			}
		}

		public boolean visit(IResourceDelta delta) throws CoreException {
			if (delta == null || !delta.getResource().equals(((IFileEditorInput) getEditorInput()).getFile()))
				return true;

			if (delta.getKind() == IResourceDelta.REMOVED) {
				Display display = getSite().getShell().getDisplay();
				if ((IResourceDelta.MOVED_TO & delta.getFlags()) == 0) { // if
					// the
					// file
					// was
					// deleted
					// NOTE: The case where an open, unsaved file is deleted is
					// being handled by the
					// PartListener added to the Workbench in the initialize()
					// method.
					display.asyncExec(new Runnable() {
						public void run() {
							// if (!isDirty())
							closeEditor(false);
						}
					});
				} else { // else if it was moved or renamed
					final IFile newFile = ResourcesPlugin.getWorkspace().getRoot().getFile(delta.getMovedToPath());
					display.asyncExec(new Runnable() {
						public void run() {
							// try {
							// ((SmooksXMLEditor) textEditor).doSetInput(new
							// FileEditorInput(newFile));
							// } catch (CoreException e) {
							// e.printStackTrace();
							// }
							setInput(new FileEditorInput(newFile));
						}
					});
				}
			}
			return false;
		}
	}

	private void closeEditor(boolean forceSave) {
		this.close(forceSave);
	}
}
