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
package org.jboss.tools.smooks.graphical.editors.model.freemarker;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.jboss.tools.smooks.SmooksModelUtils;
import org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject;
import org.jboss.tools.smooks.configuration.editors.xml.AbstractXMLObject;
import org.jboss.tools.smooks.configuration.editors.xml.TagObject;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;
import org.jboss.tools.smooks.graphical.editors.model.javamapping.JavaBeanGraphModel;
import org.jboss.tools.smooks.model.freemarker.Freemarker;
import org.jboss.tools.smooks.model.smooks.ParamType;
import org.jboss.tools.smooks.model.smooks.SmooksFactory;
import org.w3c.dom.Element;

/**
 * @author Dart
 * 
 */
public class FreemarkerCSVNodeGraphicalModel extends FreemarkerTemplateNodeGraphicalModel {

	public FreemarkerCSVNodeGraphicalModel(Object data, ITreeContentProvider contentProvider,
			ILabelProvider labelProvider, IEditingDomainProvider domainProvider) {
		super(data, contentProvider, labelProvider, domainProvider);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.tools.smooks.gef.tree.model.TreeNodeModel#hasChildren()
	 */
	@Override
	public boolean hasChildren() {
		CSVNodeModel node = (CSVNodeModel) getData();
		if (node.isRecord())
			return true;
		return false;
	}

	protected void resetFieldsList() {
		AbstractSmooksGraphicalModel record = this;
		CSVNodeModel model = (CSVNodeModel) record.getData();
		while (!model.isRecord()) {
			record = record.getParent();
			model = (CSVNodeModel) record.getData();
		}
		List<AbstractSmooksGraphicalModel> children = record.getChildrenWithoutDynamic();
		String fieldsString = ""; //$NON-NLS-1$
		for (Iterator<?> iterator = children.iterator(); iterator.hasNext();) {
			AbstractSmooksGraphicalModel ixmlStructuredObject = (AbstractSmooksGraphicalModel) iterator.next();
			fieldsString += ((IXMLStructuredObject) ixmlStructuredObject.getData()).getNodeName() + ","; //$NON-NLS-1$
		}
		if (fieldsString.length() > 1) {
			fieldsString = fieldsString.substring(0, fieldsString.length() - 1);
		}
		AbstractSmooksGraphicalModel parent = this;
		while (parent != null && !(parent instanceof FreemarkerTemplateGraphicalModel)) {
			parent = parent.getParent();
		}
		Freemarker freemarker = (Freemarker) parent.getData();
		if (freemarker != null) {
			ParamType param = SmooksModelUtils.getParam(freemarker.getParam(), SmooksModelUtils.KEY_CSV_FIELDS);
			if (param == null) {
				param = SmooksFactory.eINSTANCE.createParamType();
				param.setName(SmooksModelUtils.KEY_CSV_FIELDS);
				freemarker.getParam().add(param);
			}
			if (param != null) {
				SmooksModelUtils.setTextToSmooksType(this.domainProvider.getEditingDomain(), param, fieldsString);
				// changeFreemarkerContents();
			}
		}
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		AbstractXMLObject node = (AbstractXMLObject) getData();
		String oldName = node.getName();
		if (!oldName.equals(name)) {
			node.setName(name);
			fireVisualChanged();
			resetFieldsList();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel#removeChild
	 * (org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel)
	 */
	@Override
	public void removeChild(AbstractSmooksGraphicalModel node) {
		super.removeChild(node);
		Object data = this.getData();
		if (data instanceof TagObject) {
			Object child = node.getData();
			if (child instanceof TagObject) {
				((TagObject) data).removeChildTag((TagObject) child);
			}
		}
		resetFieldsList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel#addChild
	 * (org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel)
	 */
	@Override
	public void addChild(AbstractSmooksGraphicalModel node) {
		super.addChild(node);
		Object data = this.getData();
		if (data instanceof TagObject) {
			Object child = node.getData();
			if (child instanceof TagObject) {
				Element element = ((TagObject) child).getReferenceElement();
				Element parent = ((TagObject) data).getReferenceElement();
				if (element == null) {
					element = parent.getOwnerDocument().createElement(((TagObject) child).getName());
					((TagObject) child).setReferenceElement(element);
				}
				((TagObject) data).addChildTag((TagObject) child);
			}
		}
		resetFieldsList();
	}

	protected JavaBeanGraphModel getCollectionRootBeanModel() {
		return null;
	}

	protected boolean isCollectionConnection(TreeNodeConnection connection) {
		Object data = this.getData();
		if (data instanceof CSVNodeModel) {
			if (((CSVNodeModel) data).isRecord()) {
				return true;
			}
		}
		return false;
	}

	protected boolean isMappingValueConnection(TreeNodeConnection connection) {
		Object data = this.getData();
		if (data instanceof CSVNodeModel) {
			if (!((CSVNodeModel) data).isRecord()) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.model.TreeNodeModel#createChildModel(
	 * java.lang.Object, org.eclipse.jface.viewers.ITreeContentProvider,
	 * org.eclipse.jface.viewers.ILabelProvider)
	 */
	@Override
	protected TreeNodeModel createChildModel(Object model, ITreeContentProvider contentProvider,
			ILabelProvider labelProvider) {
		return new FreemarkerCSVNodeGraphicalModel(model, contentProvider, labelProvider, this.domainProvider);
	}

}
