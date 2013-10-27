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
package org.jboss.tools.smooks.configuration.editors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.MultiPageEditorActionBarContributor;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.jboss.tools.smooks.editor.AbstractSmooksFormEditor;
import org.jboss.tools.smooks.graphical.editors.SmooksProcessGraphicalEditor;

/**
 * 
 * @author Dart Peng (dpeng@redhat.com) Date Apr 1, 2009
 */
public class SmooksMultiFormEditor extends AbstractSmooksFormEditor implements ISelectionProvider,
		ITabbedPropertySheetPageContributor {

	public static final String EDITOR_ID = "org.jboss.tools.smooks.configuration.editors.MultiPageEditor"; //$NON-NLS-1$

	private SmooksConfigurationFormPage configurationPage;

	// private SmooksGraphicalEditorPart graphicalPage;

	private SmooksConfigurationOverviewPage optionsPage;

	// private SmooksReaderFormPage readerPage;

	private SmooksProcessGraphicalEditor processPage;

	private ISelection selection;

	private Collection<ISelectionChangedListener> selectionChangeListener = new ArrayList<ISelectionChangedListener>();

	private TabbedPropertySheetPage tabbedPropertySheetPage;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.tools.smooks.editor.AbstractSmooksFormEditor#addPages()
	 */
	@Override
	protected void addPages() {
		// readerPage = new SmooksReaderFormPage(this, "reader_page", "Input");
		// addValidateListener(readerPage);
		// addSourceSynchronizeListener(readerPage);
		// addSmooksGraphExtetionListener(readerPage);
		// try {
		// int index = this.addPage(readerPage);
		// setPageText(index, "Input");
		// } catch (PartInitException e) {
		// e.printStackTrace();
		// }

		addProcessGraphicalEditor();

		optionsPage = createSmooksConfigurationOverviewPage();
		addValidateListener(optionsPage);
		addSourceSynchronizeListener(optionsPage);
		addSmooksEditorInitListener(optionsPage);
		try {
			int index = this.addPage(optionsPage);
			setPageText(index, Messages.SmooksMultiFormEditor_opetiontab_label);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		// addSmooksGraphicalEditor();

		// configurationPage = createSmooksConfigurationFormPage();
		// addValidateListener(configurationPage);
		// addSourceSynchronizeListener(configurationPage);
		// addSmooksGraphExtetionListener(configurationPage);
		// try {
		// int index = this.addPage(configurationPage);
		// setPageText(index, "Message Filter");
		// } catch (PartInitException e) {
		// e.printStackTrace();
		// }

		super.addPages();
	}

	private void addProcessGraphicalEditor() {
		processPage = new SmooksProcessGraphicalEditor(this,
				"process", Messages.SmooksMultiFormEditor_processpage_name, this); //$NON-NLS-1$
		addSourceSynchronizeListener(processPage);
		addValidateListener(processPage);
		addSmooksEditorInitListener(processPage);
		try {
			int index = this.addPage(processPage);
			setPageText(index, Messages.SmooksMultiFormEditor_processtabel_label);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	// private void addSmooksGraphicalEditor() {
	// graphicalPage = new SmooksGraphicalEditorPart(this);
	// addSourceSynchronizeListener(graphicalPage);
	// try {
	// int index = this.addPage(graphicalPage, getEditorInput());
	// setPageText(index, "Process");
	// } catch (PartInitException e) {
	// e.printStackTrace();
	// }
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.editor.FormEditor#getActiveEditor()
	 */
	@Override
	public IEditorPart getActiveEditor() {
		int index = getActivePage();
		if (index != -1) {
			IEditorPart part = getEditor(index);
			if (part == null) {
				// if(index == 0){
				// part = processPage;
				// }
				// if(index == 1){
				// part = configurationPage;
				// }
			}
			return part;
		}
		return null;
	}

	protected void pageChange(int newPageIndex) {
		super.pageChange(newPageIndex);
		IEditorPart activeEditor = getEditor(newPageIndex);
		if (activeEditor == null) {
			if (newPageIndex == 0) {
				IEditorActionBarContributor contributor = getEditorSite().getActionBarContributor();
				if (contributor != null && contributor instanceof MultiPageEditorActionBarContributor) {
					((MultiPageEditorActionBarContributor) contributor).setActivePage(processPage);
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.editor.AbstractSmooksFormEditor#init(org.eclipse
	 * .ui.IEditorSite, org.eclipse.ui.IEditorInput)
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		// site.setSelectionProvider(this);
	}

	public Object getAdapter(Class adapter) {
		if (adapter == IPropertySheetPage.class) {
			tabbedPropertySheetPage = new TabbedPropertySheetPage(this);
			return tabbedPropertySheetPage;
		}

		if (adapter == GraphicalViewer.class) {
			if (this.processPage != null) {
				Object activeEditorPart = processPage.getActiveEditorPage();
				if (activeEditorPart != null && activeEditorPart instanceof IEditorPart) {
					if (activeEditorPart instanceof GraphicalEditor) {
						return ((IEditorPart) activeEditorPart).getAdapter(adapter);
					}
				}
			}
		}
		return super.getAdapter(adapter);
	}

	// private SmooksConfigurationReaderPage
	// createSmooksConfigurationReaderPage() {
	// return new SmooksConfigurationReaderPage(this, "reader_page1",
	// "Reader Page");
	// }

	private SmooksConfigurationOverviewPage createSmooksConfigurationOverviewPage() {
		return new SmooksConfigurationOverviewPage(this,
				"options_page", Messages.SmooksMultiFormEditor_optinepage_name, this); //$NON-NLS-1$
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		if (processPage != null) {
			processPage.doSave(monitor);
		}
		super.doSave(monitor);
	}

	protected SmooksConfigurationFormPage createSmooksConfigurationFormPage() {
		return new SmooksConfigurationResourceConfigPage(this, "message_filter_page", "Design Page"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.editor.AbstractSmooksFormEditor#
	 * activeRecentAffectedModel(java.util.Collection)
	 */
	@Override
	public void activeRecentAffectedModel(Collection<?> collection) {
		final Collection<?> theSelection = collection;
		if (theSelection != null && !theSelection.isEmpty() && configurationPage != null) {
			List<Object> newList = new ArrayList<Object>();
			for (Iterator<?> iterator = theSelection.iterator(); iterator.hasNext();) {
				Object object = (Object) iterator.next();
				// if (object instanceof IWrapperItemProvider) {
				// newList.add(((IWrapperItemProvider) object).getValue());
				// }
				newList.add(object);
			}
			configurationPage.setSelectionToViewer(newList);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.editor.AbstractSmooksFormEditor#
	 * createNewModelViaTextPage()
	 */
	@Override
	protected void createNewModelViaTextPage() {
		super.createNewModelViaTextPage();
	}

	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangeListener.add(listener);
	}

	public ISelection getSelection() {
		return this.selection;
	}

	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangeListener.remove(listener);
	}

	public void setSelection(ISelection selection) {
		if (selection != null) {
			if (selection.equals(this.selection)) {
				return;
			}
		}
		this.selection = selection;

		for (Iterator<?> iterator = this.selectionChangeListener.iterator(); iterator.hasNext();) {
			ISelectionChangedListener l = (ISelectionChangedListener) iterator.next();
			l.selectionChanged(new SelectionChangedEvent(this, getSelection()));
		}
	}

	public String getContributorId() {
		return getSite().getId();
	}

	@Override
	public void dispose() {
		try {
			super.dispose();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
