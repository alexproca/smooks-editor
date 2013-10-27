package org.jboss.tools.smooks.configuration.editors;

import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.MultiPageEditorActionBarContributor;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.jboss.tools.smooks.graphical.actions.ISmooksActionProvider;

/**
 * Manages the installation/deinstallation of global actions for multi-page editors.
 * Responsible for the redirection of global actions to the active editor.
 * Multi-page contributor replaces the contributors for the individual editors in the multi-page editor.
 */
public class SmooksMultiPageEditorContributor extends MultiPageEditorActionBarContributor {
	private IEditorPart activeEditorPart;
	/**
	 * Creates a multi-page contributor.
	 */
	public SmooksMultiPageEditorContributor() {
		super();
	}
	
	
	protected IAction getAction(IEditorPart editor , String actionID){
		if(editor instanceof ISmooksActionProvider){
			return ((ISmooksActionProvider)editor).getAction(actionID);
		}
		return null;
	}
	
	/* (non-JavaDoc)
	 * Method declared in AbstractMultiPageEditorActionBarContributor.
	 */

	public void setActivePage(IEditorPart part) {
		if (activeEditorPart == part)
			return;
		activeEditorPart = part;
		IActionBars actionBars = getActionBars();
		if (actionBars != null) {
			
			IEditorPart editor = activeEditorPart;

			actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(),
				getAction(editor, ITextEditorActionConstants.DELETE));
			actionBars.setGlobalActionHandler(
				ActionFactory.UNDO.getId(),
				getAction(editor, ITextEditorActionConstants.UNDO));
			actionBars.setGlobalActionHandler(
				ActionFactory.REDO.getId(),
				getAction(editor, ITextEditorActionConstants.REDO));
			actionBars.updateActionBars();
		}
	}
//	private void createActions() {
//		sampleAction = new Action() {
//			public void run() {
//				MessageDialog.openInformation(null, "Configuration Plug-in", "Sample Action Executed"); //$NON-NLS-1$ //$NON-NLS-2$
//			}
//		};
//		sampleAction.setText("Sample Action"); //$NON-NLS-1$
//		sampleAction.setToolTipText("Sample Action tool tip"); //$NON-NLS-1$
//		sampleAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
//				getImageDescriptor(IDE.SharedImages.IMG_OBJS_TASK_TSK));
//	}
//	public void contributeToMenu(IMenuManager manager) {
//		IMenuManager menu = new MenuManager("Editor &Menu"); //$NON-NLS-1$
//		manager.prependToGroup(IWorkbenchActionConstants.MB_ADDITIONS, menu);
//		menu.add(sampleAction);
//	}
//	public void contributeToToolBar(IToolBarManager manager) {
//		manager.add(new Separator());
//		manager.add(sampleAction);
//	}
}
