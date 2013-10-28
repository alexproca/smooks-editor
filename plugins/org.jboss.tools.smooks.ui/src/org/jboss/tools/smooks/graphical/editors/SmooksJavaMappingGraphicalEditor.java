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

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.jboss.tools.smooks.configuration.editors.IFieldMarker;
import org.jboss.tools.smooks.configuration.editors.utils.SmooksUIUtils;
import org.jboss.tools.smooks.editor.ISmooksModelProvider;
import org.jboss.tools.smooks.gef.common.RootModel;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;
import org.jboss.tools.smooks.graphical.editors.autolayout.IAutoLayout;
import org.jboss.tools.smooks.graphical.editors.autolayout.JavaMappingAutoLayout;
import org.jboss.tools.smooks.graphical.editors.model.javamapping.JavaBeanGraphModel;
import org.jboss.tools.smooks.graphical.editors.model.javamapping.JavaMappingActionCreator;
import org.jboss.tools.smooks.model.javabean12.BeanType;
import org.jboss.tools.smooks.model.javabean12.ValueType;

/**
 * @author Dart
 * 
 */
public class SmooksJavaMappingGraphicalEditor extends SmooksGraphicalEditorPart {

	private IAutoLayout javaMappingAutoLayout;

	public SmooksJavaMappingGraphicalEditor(ISmooksModelProvider provider) {
		super(provider);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.graphical.editors.SmooksGraphicalEditorPart#
	 * needToLayoutWhenAddModel(java.lang.Object)
	 */
	@Override
	protected boolean needToLayoutWhenAddModel(Object model) {
		model = AdapterFactoryEditingDomain.unwrap(model);
		if (model instanceof BeanType) {
			return true;
		}
		return super.needToLayoutWhenAddModel(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.graphical.editors.SmooksGraphicalEditorPart#
	 * validateEnd(java.util.List)
	 */
	@Override
	public void validateEnd(List<Diagnostic> diagnosticResult) {
		super.validateEnd(diagnosticResult);
		// validate decoder type (target connections of java property node)
		GraphicalViewer viewer = this.getGraphicalViewer();
		if (viewer != null) {
			EditPart rootEditPart = viewer.getContents();
			Object rootModel = rootEditPart.getModel();

			if (rootModel instanceof AbstractSmooksGraphicalModel) {
				validateConnection((AbstractSmooksGraphicalModel) rootModel);
			}
		}
	}

	/**
	 * 
	 * @param model
	 */
	protected void validateConnection(AbstractSmooksGraphicalModel model) {
		List<TreeNodeConnection> targetConnections = model.getTargetConnections();
		if (targetConnections != null) {
			for (Iterator<?> iterator = targetConnections.iterator(); iterator.hasNext();) {
				TreeNodeConnection connection = (TreeNodeConnection) iterator.next();
				Object target = connection.getTargetNode().getData();
				target = AdapterFactoryEditingDomain.unwrap(target);
				if (target instanceof ValueType) {
					ValueType value = (ValueType) target;
					String decoder = value.getDecoder();
					connection.getMessage().clear();
					boolean changed = false;
					String defaultDecoder = SmooksUIUtils.getDefualtDecoder(value);
					if (defaultDecoder == null) {
						connection.setSeverity(IFieldMarker.TYPE_NONE);
						continue;
					}
					if (decoder != null) {
						if (!decoder.equals(defaultDecoder)) {
							connection.addMessage(Messages.SmooksJavaMappingGraphicalEditor_WarningMessage1 + defaultDecoder + "'."); //$NON-NLS-1$
							connection.setSeverity(IFieldMarker.TYPE_WARINING);
							changed = true;
						}
					}
					if(!changed){
						connection.setSeverity(IFieldMarker.TYPE_NONE);
					}
				}
			}
		}
		List<AbstractSmooksGraphicalModel> children = model.getChildrenWithoutDynamic();
		if(model instanceof RootModel){
			children = model.getChildren();
		}
		for (Iterator<?> iterator = children.iterator(); iterator.hasNext();) {
			AbstractSmooksGraphicalModel abstractSmooksGraphicalModel = (AbstractSmooksGraphicalModel) iterator.next();
			validateConnection(abstractSmooksGraphicalModel);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.graphical.editors.SmooksGraphicalEditorPart#
	 * needToLayoutWhenRemoveModel(java.lang.Object)
	 */
	@Override
	protected boolean needToLayoutWhenRemoveModel(Object model) {
		model = AdapterFactoryEditingDomain.unwrap(model);
		if (model instanceof BeanType) {
			return true;
		}
		return super.needToLayoutWhenRemoveModel(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.graphical.editors.SmooksGraphicalEditorPart#
	 * getDiagnosticMessage(org.eclipse.emf.common.util.Diagnostic)
	 */
	@Override
	protected String getDiagnosticMessage(Diagnostic diagnostic) {
		return super.getDiagnosticMessage(diagnostic);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.graphical.editors.SmooksGraphicalEditorPart#
	 * getAutoLayout()
	 */
	@Override
	public IAutoLayout getAutoLayout() {
		if (javaMappingAutoLayout == null) {
			javaMappingAutoLayout = new JavaMappingAutoLayout();
		}
		return javaMappingAutoLayout;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.graphical.editors.SmooksGraphicalEditorPart#
	 * createConnectionModelFactory()
	 */
	@Override
	protected ConnectionModelFactory createConnectionModelFactory() {
		return new JavaMappingConnectionModelFactory();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.graphical.editors.SmooksGraphicalEditorPart#
	 * createGraphicalModelFactory()
	 */
	@Override
	protected GraphicalModelFactory createGraphicalModelFactory() {
		return new JavaMappingGraphicalModelFactory();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.graphical.editors.SmooksGraphicalEditorPart#
	 * createActions()
	 */
	@Override
	protected void createActions() {
		super.createActions();
		JavaMappingActionCreator creator = new JavaMappingActionCreator();
		creator.registXSLActions(getActionRegistry(), getSelectionActions(), this, this.getSmooksModelProvider());
	}

	private class JavaMappingConnectionModelFactory extends ConnectionModelFactoryImpl {

	}

	private class JavaMappingGraphicalModelFactory extends GraphicalModelFactoryImpl {
		protected String getGraphLabelText(Object element) {
			Object obj = AdapterFactoryEditingDomain.unwrap(element);
			if (obj instanceof BeanType) {
				String p = ((BeanType) obj).getBeanId();
				if (p == null) {
					p = Messages.SmooksJavaMappingGraphicalEditor_NullLabel;
				}
				return p;
			}
			// if (obj instanceof BindingsType) {
			// String p = ((BindingsType) obj).getBeanId();
			// if (p == null) {
			// p = Messages.SmooksJavaMappingGraphicalEditor_NullLabel;
			// }
			// return p;
			// }
			//
			// if (obj instanceof ValueType) {
			// String p = ((ValueType) obj).getProperty();
			// if (p == null) {
			// p = Messages.SmooksJavaMappingGraphicalEditor_NullLabel;
			// }
			// return p;
			// }
			// if (obj instanceof WiringType) {
			// String p = ((WiringType) obj).getProperty();
			// if (p == null) {
			// p = Messages.SmooksJavaMappingGraphicalEditor_NullLabel;
			// }
			// return p;
			// }
			// if (obj instanceof ExpressionType) {
			// String p = ((ExpressionType) obj).getProperty();
			// if (p == null) {
			// p = Messages.SmooksJavaMappingGraphicalEditor_NullLabel;
			// }
			// return p;
			// }

			if (obj instanceof org.jboss.tools.smooks.model.javabean12.ValueType) {
				String p = ((org.jboss.tools.smooks.model.javabean12.ValueType) obj).getProperty();
				if (p == null) {
					p = Messages.SmooksJavaMappingGraphicalEditor_NullLabel;
				}
				return p;
			}
			if (obj instanceof org.jboss.tools.smooks.model.javabean12.WiringType) {
				String p = ((org.jboss.tools.smooks.model.javabean12.WiringType) obj).getProperty();
				if (p == null) {
					p = Messages.SmooksJavaMappingGraphicalEditor_NullLabel;
				}
				return p;
			}
			if (obj instanceof org.jboss.tools.smooks.model.javabean12.ExpressionType) {
				String p = ((org.jboss.tools.smooks.model.javabean12.ExpressionType) obj).getProperty();
				if (p == null) {
					p = Messages.SmooksJavaMappingGraphicalEditor_NullLabel;
				}
				return p;
			}
			return null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.jboss.tools.smooks.graphical.editors.GraphicalModelFactoryImpl
		 * #createGraphicalModel(java.lang.Object,
		 * org.jboss.tools.smooks.editor.ISmooksModelProvider)
		 */
		@Override
		public Object createGraphicalModel(Object model, ISmooksModelProvider provider) {
			if (canCreateGraphicalModel(model, provider)) {
				AbstractSmooksGraphicalModel graphModel = null;
				AdapterFactoryEditingDomain editingDomain = (AdapterFactoryEditingDomain) provider.getEditingDomain();
				ITreeContentProvider contentProvider = new AdapterFactoryContentProvider(editingDomain
						.getAdapterFactory());
				ILabelProvider labelProvider = createLabelProvider(editingDomain.getAdapterFactory());

				if (model instanceof BeanType) {
					graphModel = new JavaBeanGraphModel(model, contentProvider, labelProvider, provider,
							SmooksJavaMappingGraphicalEditor.this);
					((JavaBeanGraphModel) graphModel).setHeaderVisable(true);
				}
				// if (model instanceof Xsl) {
				// graphModel = new XSLTemplateGraphicalModel(model, new
				// XSLTemplateContentProvider(contentProvider),
				// new XSLLabelProvider(labelProvider), provider);
				// ((TreeContainerModel) graphModel).setHeaderVisable(true);
				// }
				// if (graphModel == null && model instanceof
				// AbstractResourceConfig) {
				// graphModel = new ResourceConfigGraphModelImpl(model,
				// contentProvider, labelProvider, provider);
				// ((ResourceConfigGraphModelImpl)
				// graphModel).setHeaderVisable(true);
				// }
				if (graphModel != null) {
					return graphModel;
				}
				return super.createGraphicalModel(graphModel, provider);
			}
			return null;
		}

	}

}
