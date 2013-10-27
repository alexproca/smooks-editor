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
package org.jboss.tools.smooks.editor.propertySections;

import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.graphical.editors.SmooksGraphicalEditorPart;

/**
 * @author Dart
 * 
 */
public class AbstractSmooksPropertySection extends AbstractPropertySection {

	protected Section createRootSection(TabbedPropertySheetWidgetFactory factory, Composite parent) {
		Composite main = factory.createComposite(parent);
		FillLayout fill = new FillLayout();
		fill.marginHeight = 8;
		fill.marginWidth = 8;
		main.setLayout(fill);
		return factory.createSection(main, Section.TITLE_BAR);
	}

	protected ISmooksModelProvider getSmooksModelProvider() {
		IEditorPart part = getEditorPart();
		if(part == null){
			part = (IEditorPart)getPart();
		}
		if (part != null) {
			if (part instanceof SmooksGraphicalEditorPart) {
				return ((SmooksGraphicalEditorPart) part).getSmooksModelProvider();
			}
		}
		return null;
	}
	
	protected GraphicalEditPart getPresentSelectedEditPart() {
		IStructuredSelection selection = (IStructuredSelection) this.getSelection();
		if(selection == null) return null;
		if(selection.size() > 1) return null;
		Object obj = selection.getFirstElement();
		if (obj != null && obj instanceof GraphicalEditPart) {
			return (GraphicalEditPart)obj;
		}
		return null;
	}

	protected Object getPresentSelectedModel() {
		IStructuredSelection selection = (IStructuredSelection) this.getSelection();
		if(selection == null) return null;
		if(selection.size() > 1) return null;
		Object obj = selection.getFirstElement();
		if (obj != null && obj instanceof GraphicalEditPart) {
			Object gmodel = ((GraphicalEditPart) obj).getModel();
			if (gmodel != null && gmodel instanceof AbstractSmooksGraphicalModel) {
				Object data = ((AbstractSmooksGraphicalModel) gmodel).getData();
				return data;
			}
		}
		return null;
	}
	
	protected Object getPresentSelectedGraphModel() {
		IStructuredSelection selection = (IStructuredSelection) this.getSelection();
		if(selection == null) return null;
		if(selection.size() > 1) return null;
		Object obj = selection.getFirstElement();
		if (obj != null && obj instanceof GraphicalEditPart) {
			Object gmodel = ((GraphicalEditPart) obj).getModel();
			return gmodel;
		}
		return null;
	}

	protected IEditorPart getEditorPart() {
		IStructuredSelection selection = (IStructuredSelection) this.getSelection();
		if(selection == null) return null;
		Object obj = selection.getFirstElement();
		if (obj == null)
			return null;
		if (obj instanceof GraphicalEditPart) {
			GraphicalViewer viewer = (GraphicalViewer) ((GraphicalEditPart) obj).getViewer();
			IEditorPart part = ((DefaultEditDomain) viewer.getEditDomain()).getEditorPart();
			return part;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
	}
	
}
