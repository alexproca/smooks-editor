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
package org.jboss.tools.smooks.graphical.editors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.graph.DirectedGraph;
import org.eclipse.draw2d.graph.Edge;
import org.eclipse.draw2d.graph.Node;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CommandStackEvent;
import org.eclipse.gef.commands.CommandStackEventListener;
import org.eclipse.gef.dnd.TemplateTransferDropTargetListener;
import org.eclipse.gef.editparts.FreeformGraphicalRootEditPart;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.util.TransferDropTargetListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject;
import org.jboss.tools.smooks.configuration.editors.SelectorCreationDialog;
import org.jboss.tools.smooks.configuration.editors.javabean12.JavaBeanModel;
import org.jboss.tools.smooks.configuration.editors.javabean12.JavabeanContentProvider;
import org.jboss.tools.smooks.configuration.editors.javabean12.JavabeanlabelProvider;
import org.jboss.tools.smooks.configuration.editors.utils.SmooksUIUtils;
import org.jboss.tools.smooks.configuration.editors.xml.XMLStructuredDataContentProvider;
import org.jboss.tools.smooks.configuration.editors.xml.XMLStructuredDataLabelProvider;
import org.jboss.tools.smooks.configuration.validate.ISmooksModelValidateListener;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.editor.ISourceSynchronizeListener;
import org.jboss.tools.smooks.gef.common.RootModel;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart;
import org.jboss.tools.smooks.gef.tree.figures.GraphAnimation;
import org.jboss.tools.smooks.gef.tree.figures.IMoveableModel;
import org.jboss.tools.smooks.gef.tree.model.TreeContainerModel;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;
import org.jboss.tools.smooks.graphical.actions.AutoLayoutAction;
import org.jboss.tools.smooks.graphical.editors.autolayout.IAutoLayout;
import org.jboss.tools.smooks.graphical.editors.commands.IgnoreException;
import org.jboss.tools.smooks.graphical.editors.editparts.RightClickSelectMarqueeDragTraker;
import org.jboss.tools.smooks.graphical.editors.editparts.SmooksGraphUtil;
import org.jboss.tools.smooks.graphical.editors.model.IValidatableModel;
import org.jboss.tools.smooks.graphical.editors.model.InputDataContianerModel;
import org.jboss.tools.smooks.graphical.editors.model.InputDataRootModel;
import org.jboss.tools.smooks.graphical.editors.model.InputDataTreeNodeModel;
import org.jboss.tools.smooks.graphical.editors.process.TaskType;
import org.jboss.tools.smooks.model.javabean12.BeanType;
import org.jboss.tools.smooks.model.javabean12.Javabean12Package;
import org.jboss.tools.smooks.model.smooks.AbstractReader;
import org.jboss.tools.smooks.model.smooks.DocumentRoot;
import org.jboss.tools.smooks.model.smooks.ParamType;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;

/**
 * @author Dart
 * 
 */
public class SmooksGraphicalEditorPart extends GraphicalEditor implements ISelectionChangedListener,
		ISourceSynchronizeListener, IGraphicalEditorPart, ITaskNodeProvider, ISmooksModelValidateListener {

	private CommandStackListener emfCommandStackListener = null;

	public static final int EXECUTE_COMMAND = 0;

	public static final int REDO_COMMAND = 1;

	public static final int UNDO_COMMAND = 2;

	private static final int SOURCE_CONNECT_TYPE = 1;

	private static final int TARGET_CONNECT_TYPE = 0;

	private DefaultEditDomain editDomain = null;

	protected ISmooksModelProvider smooksModelProvider = null;

	protected RootModel root;

	protected SmooksResourceListType smooksResourceList;

	protected List<Object> inputDataList = null;

	protected GraphicalModelFactory graphicalModelFactory;

	protected ConnectionModelFactory connectionModelFactory;

	protected TaskType taskType;

	public SmooksGraphicalEditorPart(ISmooksModelProvider provider) {
		super();
		this.editDomain = new DefaultEditDomain(this);
		this.editDomain.setCommandStack(new CommandStack() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.gef.commands.CommandStack#execute(org.eclipse.gef
			 * .commands.Command)
			 */
			@Override
			public void execute(org.eclipse.gef.commands.Command command) {
				try {
					super.execute(command);
				} catch (Exception e) {
					if (e instanceof IgnoreException) {
						return;
					} else {
						throw new RuntimeException(e);
					}
				}
			}

		});
		this.editDomain.getCommandStack().addCommandStackEventListener(new CommandStackEventListener() {

			public void stackChanged(CommandStackEvent event) {
				firePropertyChange(PROP_DIRTY);
			}
		});
		this.smooksModelProvider = provider;
		this.setEditDomain(editDomain);

		this.createEMFCommandStackListener();
	}

	private void createEMFCommandStackListener() {
		emfCommandStackListener = new org.eclipse.emf.common.command.CommandStackListener() {
			public void commandStackChanged(EventObject event) {
				final Command mostRecentCommand = ((org.eclipse.emf.common.command.CommandStack) event.getSource())
						.getMostRecentCommand();
				final EventObject fe = event;
				getEditorSite().getShell().getDisplay().asyncExec(new Runnable() {
					public void run() {
						if (mostRecentCommand != null) {
							Command rawCommand = mostRecentCommand;
							while (rawCommand instanceof CommandWrapper) {
								rawCommand = ((CommandWrapper) rawCommand).getCommand();
							}
							int commandType = EXECUTE_COMMAND;
							Command undoCommand = ((org.eclipse.emf.common.command.CommandStack) fe.getSource())
									.getUndoCommand();
							while (undoCommand != null && undoCommand instanceof CommandWrapper) {
								undoCommand = ((CommandWrapper) undoCommand).getCommand();
							}
							Command redoCommand = ((org.eclipse.emf.common.command.CommandStack) fe.getSource())
									.getRedoCommand();
							while (redoCommand != null && redoCommand instanceof CommandWrapper) {
								redoCommand = ((CommandWrapper) redoCommand).getCommand();
							}
							if (undoCommand != null && rawCommand.equals(undoCommand)) {
								commandType = EXECUTE_COMMAND;
							}
							if (redoCommand != null && rawCommand.equals(redoCommand)) {
								commandType = UNDO_COMMAND;
							}
							if (rawCommand instanceof CompoundCommand) {
								List<Command> commandList = ((CompoundCommand) rawCommand).getCommandList();
								for (Iterator<?> iterator = commandList.iterator(); iterator.hasNext();) {
									Command command = (Command) iterator.next();
									while (command instanceof CommandWrapper) {
										command = ((CommandWrapper) command).getCommand();
									}
									handleInputParamChange(command);
									if (command instanceof SetCommand || command instanceof AddCommand
											|| command instanceof DeleteCommand || command instanceof RemoveCommand) {
										refershRecentAffectedModel(command, command.getAffectedObjects(), commandType);
									}
								}
							} else {
								if (rawCommand instanceof SetCommand || rawCommand instanceof AddCommand
										|| rawCommand instanceof DeleteCommand || rawCommand instanceof RemoveCommand) {
									handleInputParamChange(rawCommand);
									refershRecentAffectedModel(rawCommand, mostRecentCommand.getAffectedObjects(),
											commandType);
								}
							}
						}
					}

				});
			}
		};
	}

	/**
	 * @return the taskType
	 */
	public TaskType getTaskType() {
		return taskType;
	}

	/**
	 * @param taskType
	 *            the taskType to set
	 */
	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}

	@Override
	public void createPartControl(Composite parent) {

		IEditorSite site = getEditorSite();
		if (site instanceof SmooksTaskDetailsEditorSite) {
			FormPage page = ((SmooksTaskDetailsEditorSite) site).getParentEditor();
			FormToolkit tool = page.getManagedForm().getToolkit();
			Composite mainComposite = tool.createComposite(parent);
			mainComposite.setBackground(tool.getColors().getBorderColor());
			FillLayout fillLayout = new FillLayout();
			fillLayout.marginHeight = 1;
			fillLayout.marginWidth = 1;
			mainComposite.setLayout(fillLayout);
			super.createPartControl(mainComposite);
			return;
		}
		super.createPartControl(parent);
	}

	public GraphicalViewer getGraphicalViewer() {
		return super.getGraphicalViewer();
	}

	private void handleCommandStack(org.eclipse.emf.common.command.CommandStack commandStack) {
		if (emfCommandStackListener != null) {
			commandStack.addCommandStackListener(emfCommandStackListener);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#dispose()
	 */
	@Override
	public void dispose() {
		if (smooksModelProvider != null) {
			smooksModelProvider.getEditingDomain().getCommandStack()
					.removeCommandStackListener(emfCommandStackListener);
		}
		super.dispose();
	}

	protected void autoLayoutWhenCommandChange(Command command) {
		Collection<?> affectedObjects = command.getAffectedObjects();
		boolean refreshInputModel = false;
		for (Iterator<?> iterator2 = affectedObjects.iterator(); iterator2.hasNext();) {
			Object object = (Object) iterator2.next();
			if (command instanceof AddCommand) {
				if (needToLayoutWhenAddModel(object)) {
					refreshInputModel = true;
					break;
				}
			}
			Collection<?> deletedObjs = null;
			if (command instanceof DeleteCommand) {
				deletedObjs = ((DeleteCommand) command).getCollection();
			}
			if (command instanceof RemoveCommand) {
				deletedObjs = ((RemoveCommand) command).getCollection();
			}
			if (deletedObjs != null) {
				for (Iterator<?> iterator = deletedObjs.iterator(); iterator.hasNext();) {
					Object object2 = (Object) iterator.next();
					if (needToLayoutWhenRemoveModel(object2)) {
						refreshInputModel = true;
						break;
					}
				}
			}
			if (refreshInputModel)
				break;
		}

		if (refreshInputModel) {
			autoLayout(true);
		}
	}

	protected boolean needToLayoutWhenAddModel(Object model) {
		return false;
	}

	protected boolean needToLayoutWhenRemoveModel(Object model) {
		return false;
	}

	protected void handleInputParamChange(Command command) {
		Collection<?> affectedObjects = command.getAffectedObjects();
		boolean refreshInputModel = false;
		for (Iterator<?> iterator2 = affectedObjects.iterator(); iterator2.hasNext();) {
			Object object = (Object) iterator2.next();
			if (object instanceof ParamType) {
				if (SmooksUIUtils.isInputParamType((ParamType) object)) {
					refreshInputModel = true;
					break;
				}
			}
			if (object instanceof AbstractReader) {
				refreshInputModel = true;
				break;
			}
			Collection<?> deletedObjs = null;
			if (command instanceof DeleteCommand) {
				deletedObjs = ((DeleteCommand) command).getCollection();
			}
			if (command instanceof RemoveCommand) {
				deletedObjs = ((RemoveCommand) command).getCollection();
			}
			if (deletedObjs != null) {
				for (Iterator<?> iterator = deletedObjs.iterator(); iterator.hasNext();) {
					Object object2 = (Object) iterator.next();
					if (object2 instanceof ParamType) {
						if (SmooksUIUtils.isInputParamType((ParamType) object2)) {
							refreshInputModel = true;
							break;
						}
					}
					if (object2 instanceof AbstractReader) {
						refreshInputModel = true;
						break;
					}
				}
			}
			if (refreshInputModel)
				break;
		}

		if (refreshInputModel) {
			inputTypeChanged();
		}
	}

	public ConnectionModelFactory getConnectionModelFactory() {

		if (connectionModelFactory == null) {
			connectionModelFactory = createConnectionModelFactory();
		}
		return connectionModelFactory;
	}

	protected ConnectionModelFactory createConnectionModelFactory() {
		return new ConnectionModelFactoryImpl();
	}

	public void setConnectionModelFactory(ConnectionModelFactory connectionModelFactory) {
		this.connectionModelFactory = connectionModelFactory;
	}

	public GraphicalModelFactory getGraphicalModelFactory() {
		if (graphicalModelFactory == null) {
			graphicalModelFactory = createGraphicalModelFactory();
		}
		return graphicalModelFactory;
	}

	protected GraphicalModelFactory createGraphicalModelFactory() {
		return new GraphicalModelFactoryImpl();
	}

	public void setGraphicalModelFactory(GraphicalModelFactoryImpl graphicalModelFactory) {
		this.graphicalModelFactory = graphicalModelFactory;
	}

	@Override
	protected void createActions() {
		super.createActions();
		IAction autoLayout = new AutoLayoutAction(this);
		autoLayout.setId(AutoLayoutAction.ID);
		this.getActionRegistry().registerAction(autoLayout);
		getSelectionActions().add(autoLayout.getId());
	}

	private void deleteRelatedConnection(AbstractSmooksGraphicalModel effecedNode, EStructuralFeature feature,
			SetCommand command) {
		EObject data = (EObject) AdapterFactoryEditingDomain.unwrap(effecedNode.getData());

		if (feature.equals(SmooksUIUtils.getBeanIDRefFeature(data))) {
			List<TreeNodeConnection> sourceConnections = effecedNode.getSourceConnections();
			List<TreeNodeConnection> temp = new ArrayList<TreeNodeConnection>(sourceConnections);
			for (Iterator<?> iterator = temp.iterator(); iterator.hasNext();) {
				TreeNodeConnection treeNodeConnection = (TreeNodeConnection) iterator.next();
				AbstractSmooksGraphicalModel target = treeNodeConnection.getTargetNode();
				Object refValue = command.getValue();
				if (refValue == null)
					continue;
				String refID = refValue.toString();
				Object targetModel = AdapterFactoryEditingDomain.unwrap(target.getData());
				if (targetModel instanceof EObject) {
					EStructuralFeature idfeature = SmooksUIUtils.getBeanIDFeature((EObject) targetModel);
					if (idfeature == null)
						continue;
					Object iddata = ((EObject) targetModel).eGet(idfeature);
					if (iddata != null) {
						if (refID == null || !refID.equals(iddata)) {
							target.getTargetConnections().remove(treeNodeConnection);
							effecedNode.getSourceConnections().remove(treeNodeConnection);
							target.fireConnectionChanged();
						}
					}
				}
			}
		}

		if (feature.equals(SmooksUIUtils.getBeanIDFeature(data))) {
			List<TreeNodeConnection> targetConnections = effecedNode.getTargetConnections();
			List<TreeNodeConnection> temp = new ArrayList<TreeNodeConnection>(targetConnections);
			for (Iterator<?> iterator = temp.iterator(); iterator.hasNext();) {
				TreeNodeConnection treeNodeConnection = (TreeNodeConnection) iterator.next();
				AbstractSmooksGraphicalModel source = treeNodeConnection.getSourceNode();
				String beanID = command.getValue().toString();
				Object sourceModel = AdapterFactoryEditingDomain.unwrap(source.getData());
				if (sourceModel instanceof EObject) {
					EStructuralFeature idRefFeature = SmooksUIUtils.getBeanIDRefFeature((EObject) sourceModel);
					if (idRefFeature == null)
						continue;
					Object idRefData = ((EObject) sourceModel).eGet(idRefFeature);
					if (idRefData != null) {
						if (beanID == null || !beanID.equals(idRefData)) {
							source.getSourceConnections().remove(treeNodeConnection);
							effecedNode.getTargetConnections().remove(treeNodeConnection);
							source.fireConnectionChanged();
						}
					}
				}
			}
		}

		if (feature.equals(SmooksUIUtils.getSelectorFeature(data))) {
			List<TreeNodeConnection> targetConnections = effecedNode.getTargetConnections();
			List<TreeNodeConnection> temp = new ArrayList<TreeNodeConnection>(targetConnections);
			for (Iterator<?> iterator = temp.iterator(); iterator.hasNext();) {
				TreeNodeConnection treeNodeConnection = (TreeNodeConnection) iterator.next();
				AbstractSmooksGraphicalModel source = treeNodeConnection.getSourceNode();
				if (source instanceof InputDataContianerModel || source instanceof InputDataTreeNodeModel) {
					String selector = command.getValue().toString();
					Object sourceModel = AdapterFactoryEditingDomain.unwrap(source.getData());
					if (sourceModel instanceof IXMLStructuredObject) {
						IXMLStructuredObject root = SmooksUIUtils.getRootParent((IXMLStructuredObject) sourceModel);
						Object oldNode = null;
						try {
							oldNode = SmooksUIUtils.localXMLNodeWithPath(selector, root);
						} catch (Throwable t) {

						}
						if (oldNode == sourceModel) {
							break;
						} else {
							source.getSourceConnections().remove(treeNodeConnection);
							effecedNode.getTargetConnections().remove(treeNodeConnection);
							source.fireConnectionChanged();
						}
					}
				}

			}
		}
	}

	/**
	 * Very important method ! neet to improve
	 * 
	 * @param command
	 * @param affectedObjects
	 * @param commandType
	 */
	protected void refershRecentAffectedModel(Command command, Collection<?> affectedObjects, int commandType) {
		for (Iterator<?> iterator = affectedObjects.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			object = AdapterFactoryEditingDomain.unwrap(object);

			if (commandType == EXECUTE_COMMAND || commandType == REDO_COMMAND) {
				if (object instanceof SmooksResourceListType) {
					if (command instanceof AddCommand) {
						Collection<?> colletion = ((AddCommand) command).getCollection();
						for (Iterator<?> iterator2 = colletion.iterator(); iterator2.hasNext();) {
							Object childModel = (Object) iterator2.next();
							childModel = AdapterFactoryEditingDomain.unwrap(childModel);
							AbstractSmooksGraphicalModel graphModel = createGraphModel(childModel);
							if (graphModel == null)
								continue;
							root.addTreeNode(graphModel);
							applyGraphicalInformation(graphModel);
							Collection<TreeNodeConnection> connections = createAllConnection(graphModel);
							expandConnectedModels(connections);
						}
					}
					if (command instanceof DeleteCommand || command instanceof RemoveCommand) {
						Collection<?> colletion = null;
						if (command instanceof DeleteCommand) {
							colletion = ((DeleteCommand) command).getCollection();
						}
						if (command instanceof RemoveCommand) {
							colletion = ((RemoveCommand) command).getCollection();
						}
						for (Iterator<?> iterator2 = colletion.iterator(); iterator2.hasNext();) {
							Object childModel = (Object) iterator2.next();
							childModel = AdapterFactoryEditingDomain.unwrap(childModel);
							AbstractSmooksGraphicalModel graphModel = findGraphicalModel(childModel);
							if (graphModel == null)
								continue;
							AbstractSmooksGraphicalModel.disconnectAllConnections(graphModel);
							root.removeTreeNode(graphModel);
						}
					}
				} else {
					object = AdapterFactoryEditingDomain.unwrap(object);
					AbstractSmooksGraphicalModel node = findGraphicalModel(object);
					if (command instanceof SetCommand) {
						if (node == null) {
							continue;
						}
						node.fireVisualChanged();
						EStructuralFeature feature = ((SetCommand) command).getFeature();
						if (SmooksUIUtils.isRelatedConnectionFeature(feature)) {
							deleteRelatedConnection(node, feature, (SetCommand) command);
							Collection<TreeNodeConnection> connections = createConnection(node);
							node.fireConnectionChanged();
							expandConnectedModels(connections);
						}
					}
					if (command instanceof AddCommand) {
						Object owner = ((AddCommand) command).getOwner();
						owner = AdapterFactoryEditingDomain.unwrap(owner);
						if (owner instanceof SmooksResourceListType) {
							AbstractSmooksGraphicalModel graphModel = createGraphModel(object);
							if (graphModel == null)
								continue;
							try {
								root.addTreeNode(graphModel);
							} catch (Throwable t) {
								t.printStackTrace();
							}
							applyGraphicalInformation(graphModel);
							Collection<TreeNodeConnection> connections = createAllConnection(graphModel);
							expandConnectedModels(connections);
						} else {
							AbstractSmooksGraphicalModel ownerGraph = findGraphicalModel(owner);
							if (ownerGraph != null) {
								ownerGraph.fireChildrenChanged();
							}
						}
						if (node == null) {
							continue;
						}
						node.fireChildrenChanged();
						node.fireConnectionChanged();
					}
					if (command instanceof DeleteCommand || command instanceof RemoveCommand) {
						if (node != null) {
							node.fireChildrenChanged();
						}
					}
				}
				continue;
			}

			if (commandType == UNDO_COMMAND) {
				object = AdapterFactoryEditingDomain.unwrap(object);
				AbstractSmooksGraphicalModel node = findGraphicalModel(object);
				if (command instanceof AddCommand) {
					if (object instanceof SmooksResourceListType) {
						Collection<?> cccc = ((AddCommand) command).getCollection();
						for (Iterator<?> iterator2 = cccc.iterator(); iterator2.hasNext();) {
							Object object2 = (Object) iterator2.next();
							object2 = AdapterFactoryEditingDomain.unwrap(object2);
							AbstractSmooksGraphicalModel gmodel = findGraphicalModel(object2);
							if (gmodel != null) {
								root.removeTreeNode(gmodel);
							}
						}
					} else {
						if (node != null) {
							node.fireChildrenChanged();
						}
					}
				}
				if (command instanceof SetCommand) {
					if (node == null) {
						continue;
					}
					node.fireVisualChanged();
					EStructuralFeature feature = ((SetCommand) command).getFeature();
					if (SmooksUIUtils.isRelatedConnectionFeature(feature)) {
						deleteRelatedConnection(node, feature, (SetCommand) command);
						Collection<TreeNodeConnection> connections = createConnection(node);
						node.fireConnectionChanged();
						expandConnectedModels(connections);
					}
				}
				if (command instanceof DeleteCommand || command instanceof RemoveCommand) {
					Collection<?> cccc = null;
					if (command instanceof DeleteCommand) {
						cccc = ((DeleteCommand) command).getCollection();
					}
					if (command instanceof RemoveCommand) {
						cccc = ((RemoveCommand) command).getCollection();
					}
					for (Iterator<?> iterator2 = cccc.iterator(); iterator2.hasNext();) {
						Object object2 = (Object) iterator2.next();
						object2 = AdapterFactoryEditingDomain.unwrap(object2);
						// it means that it's deletecommand undo
						if (object == object2) {
							EObject owner = ((EObject) object).eContainer();
							if (owner instanceof SmooksResourceListType) {
								object = AdapterFactoryEditingDomain.unwrap(object);
								AbstractSmooksGraphicalModel graphModel = createGraphModel(object);
								if (graphModel == null)
									continue;
								node = graphModel;
								root.addTreeNode(graphModel);
								Collection<TreeNodeConnection> connections = createAllConnection(graphModel);
								expandConnectedModels(connections);
								applyGraphicalInformation(graphModel);
							} else {
								AbstractSmooksGraphicalModel ownernode = findGraphicalModel(owner);
								ownernode.fireChildrenChanged();
								node = findGraphicalModel(object);
								if (node == null)
									continue;
								Collection<TreeNodeConnection> connections = createAllConnection(node);
								expandConnectedModels(connections);
							}
							break;
						}
					}
				}
				continue;
			}
		}
		autoLayoutWhenCommandChange(command);
	}

	private AbstractSmooksGraphicalModel findGraphicalModel(Object object) {
		return SmooksGraphUtil.findSmooksGraphModel(root, object);
	}

	public DefaultEditDomain getEditDomain() {
		return editDomain;
	}

	// @Override
	// protected void configurePaletteViewer() {
	// super.configurePaletteViewer();
	// getPaletteViewer().addDragSourceListener(new
	// TemplateTransferDragSourceListener(getPaletteViewer()));
	// }

	protected EditPartFactory createEdtiPartFactory() {
		return new SmooksEditFactory();
	}

	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		getGraphicalViewer().setEditDomain(editDomain);
		getGraphicalViewer().setEditPartFactory(createEdtiPartFactory());

		getGraphicalViewer().setRootEditPart(new FreeformGraphicalRootEditPart() {
			public DragTracker getDragTracker(Request req) {
				return new RightClickSelectMarqueeDragTraker();
			}
		});

		getGraphicalViewer().addDropTargetListener(
				(TransferDropTargetListener) new TemplateTransferDropTargetListener(getGraphicalViewer()));

		GraphicalViewerKeyHandler keyHandler = new GraphicalViewerKeyHandler(getGraphicalViewer());
		keyHandler.put(org.eclipse.gef.KeyStroke.getPressed(SWT.DEL, 0),
				this.getActionRegistry().getAction(ActionFactory.DELETE.getId()));

		ContextMenuProvider provider = getContextMenuProvider();
		getGraphicalViewer().setContextMenu(provider);

		hookSelectionActions();
	}

	protected ContextMenuProvider getContextMenuProvider() {
		return new SmooksGraphicalEditorMenuContextProvider(getGraphicalViewer(), this.getActionRegistry());
	}

	private void hookSelectionActions() {
		Iterator<?> actions = getActionRegistry().getActions();
		while (actions.hasNext()) {
			Object action = actions.next();
			if (action instanceof SelectionAction) {
				((SelectionAction) action).setSelectionProvider(getGraphicalViewer());
			}
		}
	}

	protected List<AbstractSmooksGraphicalModel> createInputDataGraphModel() {
		List<AbstractSmooksGraphicalModel> inputGraphModel = new ArrayList<AbstractSmooksGraphicalModel>();
		if (inputDataList != null && root != null) {
			for (Iterator<?> iterator = inputDataList.iterator(); iterator.hasNext();) {
				Object object = (Object) iterator.next();
				ITreeContentProvider contentProvider = new XMLStructuredDataContentProvider();
				ILabelProvider labelProvider = new XMLStructuredDataLabelProvider();
				InputDataRootModel containerModel = new InputDataRootModel();

				if (object instanceof JavaBeanModel) {
					contentProvider = new JavabeanContentProvider();
					labelProvider = new JavabeanlabelProvider();

				}
				containerModel.getChildren().add((IXMLStructuredObject) object);
				if (containerModel != null) {
					TreeContainerModel container = new InputDataContianerModel(containerModel, contentProvider,
							labelProvider, getSmooksModelProvider());
					root.addTreeNode(container);
					inputGraphModel.add(container);
				}
			}
		}
		return inputGraphModel;
	}

	@Override
	protected void hookGraphicalViewer() {
		getSelectionSynchronizer().addViewer(getGraphicalViewer());
		getGraphicalViewer().addSelectionChangedListener(getSelectionSynchronizer());
		getGraphicalViewer().addSelectionChangedListener(this);
	}

	protected void initGraphicalModel() {
		if (root == null) {
			root = new RootModel();
		} else {
			root.removeAllTreeNode();

		}
		Object obj = smooksModelProvider.getSmooksModel();
		if (obj == null)
			return;
		AdapterFactoryEditingDomain editingDomain = (AdapterFactoryEditingDomain) smooksModelProvider
				.getEditingDomain();
		if (inputDataList != null && obj != null && obj instanceof DocumentRoot && editingDomain != null) {
			createInputDataGraphModel();
			SmooksResourceListType listType = ((DocumentRoot) obj).getSmooksResourceList();
			List<?> arcList = listType.getAbstractResourceConfig();
			for (Object object : arcList) {
				AbstractSmooksGraphicalModel gmodel = createGraphModel(object);
				if (gmodel != null) {
					root.addTreeNode(gmodel);
				}
			}
			getGraphicalViewer().setContents(root);
		}

		// create connection
		List<TreeNodeConnection> connections = createConnectionModel();

		// init position

		// initModelGraphicsInformation(smooksModelProvider.getSmooksGraphicsExt());

		// expand connected models
		expandConnectedModels(connections);

		this.autoLayout(false);

		List<Diagnostic> diagnosticList = this.getSmooksModelProvider().getDiagnosticList();
		this.validateEnd(diagnosticList);
	}

	protected AbstractSmooksGraphicalModel createGraphModel(Object model) {
		GraphicalModelFactory factory = getGraphicalModelFactory();
		if (factory != null) {
			Object gmodel = factory.createGraphicalModel(model, smooksModelProvider);
			if (gmodel != null && gmodel instanceof AbstractSmooksGraphicalModel) {
				AbstractSmooksGraphicalModel graphicalModel = (AbstractSmooksGraphicalModel) gmodel;
				return graphicalModel;
			}
		}
		return null;
	}

	protected List<TreeNodeConnection> createConnectionModel() {
		List<TreeNodeConnection> connections = new ArrayList<TreeNodeConnection>();
		if (root != null) {
			createConnection(root.getChildren(), connections);
		}
		return connections;
	}

	protected Collection<TreeNodeConnection> createAllConnection(AbstractSmooksGraphicalModel model) {
		try {
			if (model == null)
				return null;
			List<TreeNodeConnection> connections = new ArrayList<TreeNodeConnection>();
			Collection<TreeNodeConnection> c1 = createConnection(model);
			if (c1 != null) {
				connections.addAll(c1);
			}
			this.createConnection(model.getChildren(), connections);
			// for (Iterator<?> iterator = children.iterator();
			// iterator.hasNext();) {
			// AbstractSmooksGraphicalModel abstractSmooksGraphicalModel =
			// (AbstractSmooksGraphicalModel) iterator
			// .next();
			// Collection<TreeNodeConnection> cc =
			// createConnection(abstractSmooksGraphicalModel);
			// if (cc != null) {
			// connections.addAll(cc);
			// }
			// }
			return connections;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Collection<TreeNodeConnection> createConnection(AbstractSmooksGraphicalModel model) {
		ConnectionModelFactory connectionModelFactory = getConnectionModelFactory();
		List<TreeNodeConnection> cs = new ArrayList<TreeNodeConnection>();
		ISmooksModelProvider p = getSmooksModelProvider();

		if (connectionModelFactory != null) {
			if (connectionModelFactory.hasConnection(model)) {
				Collection<TreeNodeConnection> cList = connectionModelFactory.createConnection(inputDataList,
						getSmooksResourceList(), root, model);

				if (cList != null) {
					cs.addAll(cList);
				}
			}
		}

		if (cs.isEmpty()) {
			return null;
		}

		return cs;
	}

	/**
	 * @return the inputDataList
	 */
	public List<Object> getInputDataList() {
		if (inputDataList == null) {
			inputDataList = new ArrayList<Object>();
		}
		return inputDataList;
	}

	/**
	 * @param inputDataList
	 *            the inputDataList to set
	 */
	public void setInputDataList(List<Object> inputDataList) {
		this.inputDataList = inputDataList;
	}

	// public SmooksGraphicsExtType getSmooksGraphicsExtType() {
	// if (smooksModelProvider != null) {
	// return smooksModelProvider.getSmooksGraphicsExt();
	// }
	// return null;
	// }

	/**
	 * @return the smooksModelProvider
	 */
	public ISmooksModelProvider getSmooksModelProvider() {
		return smooksModelProvider;
	}

	/**
	 * @param smooksModelProvider
	 *            the smooksModelProvider to set
	 */
	public void setSmooksModelProvider(ISmooksModelProvider smooksModelProvider) {
		this.smooksModelProvider = smooksModelProvider;
	}

	public EObject getSmooksResourceList() {
		if (smooksModelProvider != null) {
			EObject m = null;
			EObject smooksModel = smooksModelProvider.getSmooksModel();
			if (smooksModel instanceof DocumentRoot) {
				m = ((DocumentRoot) smooksModel).getSmooksResourceList();
			}
			return m;
		}
		return null;
	}

	public EditingDomain getEditingDomain() {
		if (smooksModelProvider != null) {
			return smooksModelProvider.getEditingDomain();
		}
		return null;
	}

	public void createConnection(List<AbstractSmooksGraphicalModel> children, List<TreeNodeConnection> connections) {
		Object parentTask = taskType.getParent();

		if (parentTask instanceof TaskType) {
			if (((TaskType) parentTask).getId().equals(TaskTypeManager.TASK_ID_INPUT)
					&& !taskType.getId().equals(TaskTypeManager.TASK_ID_JAVA_MAPPING)) {
				for (AbstractSmooksGraphicalModel abstractSmooksGraphicalModel : children) {
					if (abstractSmooksGraphicalModel instanceof InputDataContianerModel) {
						Collection<TreeNodeConnection> c = createConnection(abstractSmooksGraphicalModel);
						if (c != null) {
							connections.addAll(c);
						}
						break;
					}
				}
			} else {
				for (AbstractSmooksGraphicalModel abstractSmooksGraphicalModel : children) {
					if (!(abstractSmooksGraphicalModel instanceof InputDataContianerModel)) {
						if (canCreateConnection(abstractSmooksGraphicalModel)) {
							Collection<TreeNodeConnection> c = createConnection(abstractSmooksGraphicalModel);
							if (c != null) {
								connections.addAll(c);
							}
						}
						List<AbstractSmooksGraphicalModel> cchildren = abstractSmooksGraphicalModel.getChildren();
						createConnection(cchildren, connections);
					}
				}
			}
		}
	}

	private boolean canCreateConnection(AbstractSmooksGraphicalModel model) {
		// if (model instanceof JavaBeanGraphModel) {
		// return true;
		// }
		// if (model instanceof JavaBeanChildGraphModel) {
		// return true;
		// }
		// if (model instanceof XSLTemplateGraphicalModel) {
		// return true;
		// }
		// if (model instanceof XSLNodeGraphicalModel) {
		// return true;
		// }
		// if (model instanceof FreemarkerCSVNodeGraphicalModel)
		// return true;
		// return false;
		return true;
	}

	protected void initSmooksData() {
		if (smooksModelProvider != null) {
			Object obj = smooksModelProvider.getSmooksModel();
			smooksResourceList = null;
			if (obj instanceof DocumentRoot) {
				smooksResourceList = ((DocumentRoot) obj).getSmooksResourceList();
				inputDataList = SelectorCreationDialog.generateInputData(smooksResourceList);
			}
		}
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		initSmooksData();
		if (smooksModelProvider != null) {
			this.handleCommandStack(smooksModelProvider.getEditingDomain().getCommandStack());
		}
	}

	protected void expandConnectedModels(Collection<TreeNodeConnection> connections) {
		if (connections == null || connections.isEmpty())
			return;
		List<TreeNodeModel> expanedTreeNodeList = new ArrayList<TreeNodeModel>();
		for (Iterator<?> iterator = connections.iterator(); iterator.hasNext();) {
			TreeNodeConnection treeNodeConnection = (TreeNodeConnection) iterator.next();
			AbstractSmooksGraphicalModel source = treeNodeConnection.getSourceNode();
			AbstractSmooksGraphicalModel target = treeNodeConnection.getTargetNode();
			Object data = source.getData();
			Object data2 = target.getData();
			if (source instanceof TreeNodeModel && data instanceof IXMLStructuredObject) {
				expanedTreeNodeList.add((TreeNodeModel) source);
			}
			if (target instanceof TreeNodeModel && data2 instanceof IXMLStructuredObject) {
				expanedTreeNodeList.add((TreeNodeModel) target);
			}
		}
		EditPart rootEditPart = getGraphicalViewer().getContents();
		if (rootEditPart != null) {
			List<?> childrenEditPart = rootEditPart.getChildren();
			for (Iterator<?> iterator = childrenEditPart.iterator(); iterator.hasNext();) {
				Object object = (Object) iterator.next();
				// Object model = ((EditPart) object).getModel();
				// if (object instanceof InputDataContainerEditPart || model
				// instanceof XSLTemplateGraphicalModel) {
				SmooksUIUtils.expandGraphTree(expanedTreeNodeList, (TreeNodeEditPart) object);
				// }
				// if(model instanceof XSLTemplateGraphicalModel){
				// ((TreeNodeEditPart) object).expandNode();
				// if(!((TreeNodeEditPart) object).getChildren().isEmpty()){
				// SmooksUIUtils.expandGraphTree(expanedTreeNodeList,
				// (TreeNodeEditPart) ((TreeNodeEditPart)
				// object).getChildren().get(0));
				// }
				// }
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#initializeGraphicalViewer()
	 */
	@Override
	protected void initializeGraphicalViewer() {
		initGraphicalModel();
	}

	protected void applyGraphicalInformation(AbstractSmooksGraphicalModel graphicalModel) {
		// GraphType graph1 = getSmooksGraphicsExtType().getGraph();
		// applyGraphicalInformation(graph1, graphicalModel);
	}

	protected boolean needToAutoLayout(List<AbstractSmooksGraphicalModel> list) {
		// int missFigure = 0;
		// for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
		// AbstractSmooksGraphicalModel abstractSmooksGraphicalModel =
		// (AbstractSmooksGraphicalModel) iterator.next();
		// String id =
		// SmooksGraphUtil.generateFigureID(abstractSmooksGraphicalModel);
		// if (id != null) {
		// FigureType ft = SmooksGraphUtil.findFigureType(graph, id);
		// if (ft == null) {
		// missFigure++;
		// }
		// } else {
		// missFigure++;
		// }
		// }
		// if (missFigure >= (list.size() / 2)) {
		// return true;
		// }
		// return false;
		return true;
	}

	// protected void applyGraphicalInformation(GraphType graph,
	// AbstractSmooksGraphicalModel graphicalModel) {
	// if (graphicalModel instanceof IMoveableModel) {
	// String id = SmooksGraphUtil.generateFigureID(graphicalModel);
	// if (id != null) {
	// FigureType ft = SmooksGraphUtil.findFigureType(graph, id);
	// try {
	// int x = Integer.parseInt(ft.getX());
	// int y = Integer.parseInt(ft.getY());
	// ((IMoveableModel) graphicalModel).setLocation(new Point(x, y));
	// } catch (Throwable t) {
	// }
	// }
	// }
	// }

	public boolean autoLayout() {
		return autoLayout(false);
	}

	public boolean autoLayout(boolean animation) {
		// disable the animation now
		animation = false;
		final GraphAnimation graphAnimation = new GraphAnimation();
		HashMap<Object, Node> nodeMap = new HashMap<Object, Node>();
		DirectedGraph directedGraph = collectionGraphInformation(nodeMap);
		IAutoLayout layout = getAutoLayout();
		if (layout != null) {
			layout.visit(directedGraph);
			Iterator<?> it = nodeMap.keySet().iterator();
			Map<IMoveableModel, Point> map = new HashMap<IMoveableModel, Point>();
			final List<GraphicalEditPart> figureList = new ArrayList<GraphicalEditPart>();
			while (it.hasNext()) {
				GraphicalEditPart part = (GraphicalEditPart) it.next();
				Node node = (Node) nodeMap.get(part);
				figureList.add(part);
				graphAnimation.recordInit(part);
				IMoveableModel graphicalModel = (IMoveableModel) part.getModel();
				map.put(graphicalModel, new Point(node.x, node.y));
				graphAnimation.recordFinal(part, new Rectangle(node.x, node.y, 0, 0));
			}
			IEditorSite editorSite = getEditorSite();

			if (animation) {
				if (editorSite != null) {
					editorSite.getShell().getDisplay().syncExec(new Runnable() {

						/*
						 * (non-Javadoc)
						 * 
						 * @see java.lang.Runnable#run()
						 */
						public void run() {
							graphAnimation.start(figureList);
						}

					});
				} else {
					// graphAnimation.start(figureList);
				}
			}
			Iterator<IMoveableModel> it1 = map.keySet().iterator();
			while (it1.hasNext()) {
				IMoveableModel graphModel = it1.next();
				Point p = map.get(graphModel);
				((IMoveableModel) graphModel).setLocation(p);
			}
			return true;
		}
		return false;
	}

	// protected void initModelGraphicsInformation(SmooksGraphicsExtType ext) {
	// List<AbstractSmooksGraphicalModel> list = root.getChildren();
	// GraphType graph = ext.getGraph();
	// if (needToAutoLayout(list, graph)) {
	// if (autoLayout()) {
	// return;
	// }
	// }
	// if (graph == null)
	// return;
	// for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
	// AbstractSmooksGraphicalModel treeNodeModel =
	// (AbstractSmooksGraphicalModel) iterator.next();
	// applyGraphicalInformation(graph, treeNodeModel);
	// }
	// }

	public IAutoLayout getAutoLayout() {
		return null;
	}

	protected DirectedGraph collectionGraphInformation(HashMap<Object, Node> nodeMap) {
		DirectedGraph graph = new DirectedGraph();
		if (getGraphicalViewer() == null) {
			return graph;
		}
		EditPart rootEditorPart = this.getGraphicalViewer().getContents();
		List<?> children = rootEditorPart.getChildren();
		// HashMap<Object, Edge> edgeMap = new HashMap<Object, Edge>();
		for (Iterator<?> iterator = children.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			if (object instanceof GraphicalEditPart) {
				IFigure figure = ((GraphicalEditPart) object).getFigure();
				Node node = new Node();
				node.data = object;
				nodeMap.put(object, node);
				node.height = figure.getPreferredSize().height;
				node.width = figure.getPreferredSize().width;
				graph.nodes.add(node);
			}
		}

		for (Iterator<?> iterator = children.iterator(); iterator.hasNext();) {
			GraphicalEditPart object = (GraphicalEditPart) iterator.next();
			for (Iterator<?> iterator2 = children.iterator(); iterator2.hasNext();) {
				GraphicalEditPart testEditPart = (GraphicalEditPart) iterator2.next();
				Node node = nodeMap.get(object);
				Node testNode = nodeMap.get(testEditPart);
				if (node != null && testNode != null) {
					if (hasConnectionAssociation(object, testEditPart, SOURCE_CONNECT_TYPE)) {
						Edge edge = new Edge(node, testNode);
						edge.data = testEditPart;
						graph.edges.add(edge);
					}
					if (hasConnectionAssociation(object, testEditPart, TARGET_CONNECT_TYPE)) {
						Edge edge = new Edge(testNode, node);
						graph.edges.add(edge);
					}
				}
			}
		}
		return graph;
	}

	private boolean hasAssociation(Object model, GraphicalEditPart editPart) {
		if (model == editPart.getModel()) {
			return true;
		}
		AbstractSmooksGraphicalModel grphicalModel = (AbstractSmooksGraphicalModel) editPart.getModel();
		if (!grphicalModel.getChildrenWithoutDynamic().isEmpty()) {
			List<?> children = editPart.getChildren();
			for (Iterator<?> iterator2 = children.iterator(); iterator2.hasNext();) {
				GraphicalEditPart gpart = (GraphicalEditPart) iterator2.next();
				if (hasAssociation(model, gpart)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean hasConnectionAssociation(GraphicalEditPart editPart, GraphicalEditPart testEditPart, int connectType) {
		List<?> sourceConnections = null;
		if (connectType == SOURCE_CONNECT_TYPE) {
			sourceConnections = editPart.getSourceConnections();
		}
		if (connectType == TARGET_CONNECT_TYPE) {
			sourceConnections = editPart.getTargetConnections();
		}
		for (Iterator<?> iterator = sourceConnections.iterator(); iterator.hasNext();) {
			GraphicalEditPart object = (GraphicalEditPart) iterator.next();
			TreeNodeConnection connection = (TreeNodeConnection) object.getModel();
			Object testModel = null;
			if (connectType == SOURCE_CONNECT_TYPE) {
				testModel = connection.getTargetNode();
			}
			if (connectType == TARGET_CONNECT_TYPE) {
				testModel = connection.getSourceNode();
			}
			if (hasAssociation(testModel, testEditPart)) {
				return true;
			}
		}
		AbstractSmooksGraphicalModel sourceGraphModel = (AbstractSmooksGraphicalModel) editPart.getModel();
		if (!sourceGraphModel.getChildrenWithoutDynamic().isEmpty()) {
			List<?> children = editPart.getChildren();
			for (Iterator<?> iterator = children.iterator(); iterator.hasNext();) {
				GraphicalEditPart childEditPart = (GraphicalEditPart) iterator.next();
				if (hasConnectionAssociation(childEditPart, testEditPart, connectType)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Object getAdapter(Class type) {
		if (type == ISmooksModelProvider.class) {
			return this.smooksModelProvider;
		}
		if (type == ITaskNodeProvider.class) {
			return this;
		}
		return super.getAdapter(type);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.ui.part.EditorPart#doSave(org.eclipse.core.runtime.
	 * IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {
		if (getEditDomain() != null && getEditDomain().getCommandStack() != null) {
			getEditDomain().getCommandStack().flush();
		}
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		super.selectionChanged(part, selection);
	}

	public void selectionChanged(SelectionChangedEvent event) {
		updateActions(getSelectionActions());
		ISelectionProvider provider = ((SmooksTaskDetailsEditorSite) getSite()).getMultiPageEditor().getSite()
				.getSelectionProvider();
		if (provider != null) {
			provider.setSelection(event.getSelection());
		}
	}

	public void sourceChange(Object model) {
		initGraphicalModel();
	}

	// @Override
	// protected PaletteRoot getPaletteRoot() {
	// SmooksGraphicalEditorPaletteRootCreator creator = new
	// SmooksGraphicalEditorPaletteRootCreator(
	// this.smooksModelProvider, (AdapterFactoryEditingDomain)
	// this.smooksModelProvider.getEditingDomain(),
	// getSmooksResourceListType());
	// return creator.createPaletteRoot();
	// }

	public SmooksResourceListType getSmooksResourceListType() {
		if (smooksModelProvider != null) {
			Object obj = smooksModelProvider.getSmooksModel();
			smooksResourceList = null;
			if (obj instanceof DocumentRoot) {
				smooksResourceList = ((DocumentRoot) obj).getSmooksResourceList();
			}
			return smooksResourceList;
		}
		return null;
	}

	// public void graphChanged(SmooksGraphicsExtType extType) {
	//
	// }

	public void graphPropertyChange(EStructuralFeature featre, Object value) {

	}

	public void inputTypeChanged() {
		if (root != null && inputDataList != null) {
			List<Object> newInputDataList = SelectorCreationDialog.generateInputData(getSmooksResourceListType());

			List<InputDataContianerModel> inputs = new ArrayList<InputDataContianerModel>();
			List<AbstractSmooksGraphicalModel> children = root.getChildren();
			// remove all input data graph model
			for (Iterator<?> iterator = children.iterator(); iterator.hasNext();) {
				AbstractSmooksGraphicalModel abstractSmooksGraphicalModel = (AbstractSmooksGraphicalModel) iterator
						.next();
				if (abstractSmooksGraphicalModel instanceof InputDataContianerModel) {
					inputs.add((InputDataContianerModel) abstractSmooksGraphicalModel);
				}
			}

			for (Iterator<?> iterator = inputs.iterator(); iterator.hasNext();) {
				InputDataContianerModel inputModel = (InputDataContianerModel) iterator.next();
				AbstractSmooksGraphicalModel.disconnectAllConnections(inputModel);
				root.removeTreeNode(inputModel);
			}

			inputDataList.clear();
			inputDataList.addAll(newInputDataList);

			// renew input data graph model
			List<AbstractSmooksGraphicalModel> inputGraphModel = createInputDataGraphModel();
			if (inputGraphModel != null && !inputGraphModel.isEmpty()) {
				List<TreeNodeConnection> connections = createConnectionModel();
				createConnection(inputGraphModel, connections);
				expandConnectedModels(connections);
			}
			autoLayout();
		}
	}

	public String getID() {
		return null;
	}

	protected void cleanValidationMarker() {
		if (root == null)
			return;
		List<AbstractSmooksGraphicalModel> children = root.getChildren();
		for (Iterator<?> iterator = children.iterator(); iterator.hasNext();) {
			AbstractSmooksGraphicalModel abstractSmooksGraphicalModel = (AbstractSmooksGraphicalModel) iterator.next();
			cleanValidationMarker(abstractSmooksGraphicalModel);
		}
	}

	protected void cleanValidationMarker(AbstractSmooksGraphicalModel model) {
		model.setSeverity(IValidatableModel.NONE);
		model.getMessage().clear();
		List<AbstractSmooksGraphicalModel> children = model.getChildrenWithoutDynamic();
		for (Iterator<?> iterator = children.iterator(); iterator.hasNext();) {
			AbstractSmooksGraphicalModel abstractSmooksGraphicalModel = (AbstractSmooksGraphicalModel) iterator.next();
			cleanValidationMarker(abstractSmooksGraphicalModel);
		}
	}

	public void validateEnd(List<Diagnostic> diagnosticResult) {
		if (diagnosticResult == null)
			return;
		IEditorSite editorSite = this.getEditorSite();
		if (editorSite != null) {
			if (root == null)
				return;
			final List<Diagnostic> flist = diagnosticResult;
			Display display = editorSite.getShell().getDisplay();
			display.asyncExec(new Runnable() {

				public void run() {
					cleanValidationMarker();
					for (Iterator<?> iterator = flist.iterator(); iterator.hasNext();) {
						Diagnostic diagnostic = (Diagnostic) iterator.next();
						refreshValidateResult(diagnostic);
					}
				}
			});

		}
	}

	protected String getDiagnosticMessage(Diagnostic diagnostic) {
		List<?> datas = diagnostic.getData();
		if (datas.size() == 2) {
			Object parentObj = datas.get(0);

			if (parentObj instanceof BeanType) {
				Object obj = datas.get(1);
				if (obj == Javabean12Package.Literals.BEAN_TYPE__BEAN_ID) {
					String message = diagnostic.getMessage();
					if (message != null && message.startsWith("The required feature")) { //$NON-NLS-1$
						return Messages.SmooksJavaMappingGraphicalEditor_BeanIdEmptyErrormessage;
					}
				}
			}

			if (parentObj instanceof org.jboss.tools.smooks.model.javabean12.ValueType) {
				Object obj = datas.get(1);
				if (obj == Javabean12Package.Literals.VALUE_TYPE__DATA) {
					String message = diagnostic.getMessage();
					if (message != null && message.startsWith("The required feature")) { //$NON-NLS-1$
						return Messages.SmooksJavaMappingGraphicalEditor_NodeMustLinkWithSource;
					}
				}
			}

			if (parentObj instanceof org.jboss.tools.smooks.model.javabean12.WiringType) {
				Object obj = datas.get(1);
				if (obj == Javabean12Package.Literals.WIRING_TYPE__BEAN_ID_REF) {
					String message = diagnostic.getMessage();
					if (message != null && message.startsWith("The required feature")) { //$NON-NLS-1$
						return Messages.SmooksJavaMappingGraphicalEditor_NodeMustLinkWithJavaBean;
					}
				}
			}
		}
		return diagnostic.getMessage();
	}

	protected void refreshValidateResult(Diagnostic diagnostic) {
		int severity = diagnostic.getSeverity();
		String message = getDiagnosticMessage(diagnostic);
		if (severity == Diagnostic.ERROR || severity == Diagnostic.WARNING) {
			List<?> datas = diagnostic.getData();
			AbstractSmooksGraphicalModel obj = null;
			for (Iterator<?> iterator2 = datas.iterator(); iterator2.hasNext();) {
				Object object = (Object) iterator2.next();
				object = AdapterFactoryEditingDomain.unwrap(object);
				if (object instanceof EObject) {
					AbstractSmooksGraphicalModel graphModel = SmooksGraphUtil.findSmooksGraphModel(root, object);
					if (graphModel == null)
						continue;
					obj = graphModel;
					if (graphModel instanceof IValidatableModel) {
						// ((IValidatableModel)
						// graphModel).setSeverity(severity);
					}
				}
			}
			if (obj != null) {
				for (Iterator<?> iterator2 = datas.iterator(); iterator2.hasNext();) {
					Object object = (Object) iterator2.next();
					object = AdapterFactoryEditingDomain.unwrap(object);
					if (object instanceof EAttribute && obj != null) {
						if (obj instanceof IValidatableModel) {
							((IValidatableModel) obj).addMessage(message);
						}
					}
				}
				((IValidatableModel) obj).setSeverity(severity);
			}
		}
		List<Diagnostic> children = diagnostic.getChildren();
		for (Iterator<?> iterator = children.iterator(); iterator.hasNext();) {
			Diagnostic diagnostic2 = (Diagnostic) iterator.next();
			refreshValidateResult(diagnostic2);
		}
	}

	public void validateStart() {

	}
}
