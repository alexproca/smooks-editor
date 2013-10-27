/**
 * 
 */
package org.jboss.tools.smooks.configuration.editors.xml;

import org.eclipse.core.resources.IContainer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardNode;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.jboss.tools.smooks.configuration.editors.wizard.IStructuredDataSelectionWizard;

/**
 * @author Dart
 * 
 */
public abstract class AbstractStructuredDdataWizard extends Wizard implements IStructuredDataSelectionWizard,
		INewWizard {
	protected IWorkbench workbench;

	protected IStructuredSelection selection;

	protected AbstractFileSelectionWizardPage page = null;
	protected Object xsdElement = null;
	protected IWizardNode strucutredDataCreationWizardNode;

	private IContainer folder = null;

	public AbstractStructuredDdataWizard() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addPages() {
		if (page == null) {
			page = createAbstractFileSelectionWizardPage();
			page.setSelection(this.selection);
			if (folder != null) {
				page.setInitSelections(new Object[] { folder });
			}
		}
		this.addPage(page);
	}

	abstract protected AbstractFileSelectionWizardPage createAbstractFileSelectionWizardPage();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		xsdElement = this.page.getReturnValue();
		return true;
	}

	public Object getReturnData() {
		return xsdElement;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.ui.IStructuredDataCreationWizard#
	 * getStructuredDataSourcePath()
	 */
	public String getStructuredDataSourcePath() {
		return page.getFilePath();
	}

	public void init(IEditorSite site, IEditorInput input) {
		this.folder = ((IFileEditorInput) input).getFile().getParent();
		if (page != null && folder != null) {
			page.setInitSelections(new Object[] { folder });
		}
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
	}

}
