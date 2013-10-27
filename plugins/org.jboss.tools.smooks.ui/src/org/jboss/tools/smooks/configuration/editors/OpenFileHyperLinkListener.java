/**
 * 
 */
package org.jboss.tools.smooks.configuration.editors;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;

/**
 * @author DartPeng
 * 
 */
public class OpenFileHyperLinkListener implements IHyperlinkListener {

	private int type = SmooksUIUtils.VALUE_TYPE_VALUE;
	private IItemPropertyDescriptor itemPropertyDescriptor;
	private String editorID = null;
	private Object model;

	public OpenFileHyperLinkListener(int type, IItemPropertyDescriptor itemPropertyDescriptor, Object model, String editorID) {
		this.type = type;
		this.itemPropertyDescriptor = itemPropertyDescriptor;
		this.model = model;
		this.editorID = editorID;
	}

	public void linkActivated(HyperlinkEvent e) {
		String path = null;
		if (type == SmooksUIUtils.VALUE_TYPE_VALUE) {
			Object obj = SmooksUIUtils.getEditValue(itemPropertyDescriptor, model);
			if (obj != null) {
				path = obj.toString();
			}
		}
		if (type == SmooksUIUtils.VALUE_TYPE_CDATA && model instanceof AnyType) {
			path = SmooksModelUtils.getAnyTypeCDATA((AnyType) model);
		}
		if (type == SmooksUIUtils.VALUE_TYPE_TEXT && model instanceof AnyType) {
			path = SmooksModelUtils.getAnyTypeText((AnyType) model);
		}
		if (type == SmooksUIUtils.VALUE_TYPE_COMMENT && model instanceof AnyType) {
			path = SmooksModelUtils.getAnyTypeComment((AnyType) model);
		}
		try {
			IResource resource = SmooksUIUtils.getResource((EObject) model);
			SmooksUIUtils.openFile(path, resource.getProject(), editorID);
		} catch (PartInitException e1) {

		}
	}

	public void linkEntered(HyperlinkEvent e) {
		// TODO Auto-generated method stub

	}

	public void linkExited(HyperlinkEvent e) {
		// TODO Auto-generated method stub

	}
}
