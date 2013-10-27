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
package org.jboss.tools.smooks.graphical.editors.editparts.freemarker;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart;
import org.jboss.tools.smooks.gef.tree.figures.TreeFigureExpansionEvent;
import org.jboss.tools.smooks.gef.tree.figures.TreeNodeFigure;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeModel;
import org.jboss.tools.smooks.graphical.editors.commands.AddSmooksGraphicalModelCommand;
import org.jboss.tools.smooks.graphical.editors.commands.ChangeCSVNodeNameCommand;
import org.jboss.tools.smooks.graphical.editors.commands.DeleteSmooksGraphicalModelCommand;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.CSVNodeModel;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerCSVNodeGraphicalModel;

/**
 * @author Dart
 * 
 */
public class FreemarkerCSVNodeEditPart extends TreeNodeEditPart {

	private Font csvRecordFont;

	public FreemarkerCSVNodeEditPart() {
		super();
		childrenLoaded = true;
	}

	/**
	 * @return the xslLabelFont
	 */
	public Font getCSVRecordLabelFont() {
		if (csvRecordFont == null) {
			IFigure figure = getFigure();

			FontData fd = new FontData();
			fd.setStyle(SWT.BOLD);
			if (figure != null) {
				FontData[] fds = figure.getFont().getFontData();
				if (fds != null && fds.length > 0) {
					fd.setHeight(fds[0].getHeight());
					fd.setName(fds[0].getName());
					fd.setLocale(fds[0].getLocale());
				}
			}
			csvRecordFont = new Font(null, fd);
		}
		return csvRecordFont;
	}

	@Override
	public void deactivate() {
		super.deactivate();
		if (csvRecordFont != null) {
			csvRecordFont.dispose();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {
		CSVNodeModel node = (CSVNodeModel) ((AbstractSmooksGraphicalModel) getModel()).getData();
		if (node.isRecord()) {
			IFigure figure = new TreeNodeFigure((TreeNodeModel) getModel()) {

				/*
				 * (non-Javadoc)
				 * 
				 * @see
				 * org.jboss.tools.smooks.gef.tree.figures.TreeNodeFigure#initFigure
				 * ()
				 */
				@Override
				protected void initFigure() {
					super.initFigure();
					SPACE_INT = 0;
					CLICKNODE_HEIGHT = 0;
					CLICKNODE_WIDTH = 0;
					expand = true;
				}

				/*
				 * (non-Javadoc)
				 * 
				 * @seeorg.jboss.tools.smooks.gef.tree.figures.TreeNodeFigure#
				 * getPreferredSize(int, int)
				 */
				@Override
				public Dimension getPreferredSize(int hint, int hint2) {
					expand = true;
					return super.getPreferredSize(hint, hint2);
				}

				/*
				 * (non-Javadoc)
				 * 
				 * @seeorg.jboss.tools.smooks.gef.tree.figures.TreeNodeFigure#
				 * createLabelContainerLayout()
				 */
				@Override
				protected LayoutManager createLabelContainerLayout() {
					ToolbarLayout tl = new ToolbarLayout();
					tl.setVertical(false);
					tl.setMinorAlignment(ToolbarLayout.ALIGN_BOTTOMRIGHT);
					return tl;
				}

				/*
				 * (non-Javadoc)
				 * 
				 * @seeorg.jboss.tools.smooks.gef.tree.figures.TreeNodeFigure#
				 * drawClickFigure(org.eclipse.draw2d.IFigure,
				 * org.eclipse.draw2d.Graphics)
				 */
				@Override
				protected void drawClickFigure(IFigure clickFigure, Graphics graphics) {
				}

				/*
				 * (non-Javadoc)
				 * 
				 * @seeorg.jboss.tools.smooks.gef.tree.figures.TreeNodeFigure#
				 * needClickFigure()
				 */
				@Override
				protected boolean needClickFigure() {
					Object data = this.getModel().getData();
					if (data instanceof CSVNodeModel) {
						if (((CSVNodeModel) data).isRecord()) {
							return true;
						}
					}
					return false;
				}

				/*
				 * (non-Javadoc)
				 * 
				 * @seeorg.jboss.tools.smooks.gef.tree.figures.TreeNodeFigure#
				 * needSpaceFigure()
				 */
				@Override
				protected boolean needSpaceFigure() {
					Object data = this.getModel().getData();
					if (data instanceof CSVNodeModel) {
						if (((CSVNodeModel) data).isRecord()) {
							return true;
						}
					}
					return false;
				}

				/*
				 * (non-Javadoc)
				 * 
				 * @seeorg.jboss.tools.smooks.gef.tree.figures.TreeNodeFigure#
				 * createContentFigureLayout()
				 */
				@Override
				protected ToolbarLayout createContentFigureLayout() {
					ToolbarLayout layout = super.createContentFigureLayout();
					layout.setVertical(true);
					return layout;
				}

				/*
				 * (non-Javadoc)
				 * 
				 * @seeorg.jboss.tools.smooks.gef.tree.figures.TreeNodeFigure#
				 * createTreeNodeFigureLayout()
				 */
				@Override
				protected ToolbarLayout createTreeNodeFigureLayout() {
					ToolbarLayout layout = super.createTreeNodeFigureLayout();
					// layout.setSpacing(5);
					layout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
					return layout;
				}

				/*
				 * (non-Javadoc)
				 * 
				 * @seeorg.jboss.tools.smooks.gef.tree.figures.TreeNodeFigure#
				 * collapsedNode()
				 */
				@Override
				public void collapsedNode() {
				}

				/*
				 * (non-Javadoc)
				 * 
				 * @see
				 * org.jboss.tools.smooks.gef.tree.figures.TreeNodeFigure#expandNode
				 * ()
				 */
				@Override
				public void expandNode() {
				}

			};
			return figure;
		}
		return super.createFigure();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart#expandNode()
	 */
	@Override
	public void expandNode() {
		super.expandNode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart#treeCollapsed
	 * (org.jboss.tools.smooks.gef.tree.figures.TreeFigureExpansionEvent)
	 */
	@Override
	public void treeCollapsed(TreeFigureExpansionEvent event) {
		System.out.println();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart#treeExpanded
	 * (org.jboss.tools.smooks.gef.tree.figures.TreeFigureExpansionEvent)
	 */
	@Override
	public void treeExpanded(TreeFigureExpansionEvent event) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart#createEditPolicies
	 * ()
	 */
	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
		this.installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy() {

			@Override
			protected Command getDeleteCommand(GroupRequest request) {
				List<?> editParts = request.getEditParts();
				for (Iterator<?> iterator = editParts.iterator(); iterator.hasNext();) {
					EditPart editPart = (EditPart) iterator.next();
					AbstractSmooksGraphicalModel graphModel = (AbstractSmooksGraphicalModel) editPart.getModel();
					Object data = graphModel.getData();
					data = AdapterFactoryEditingDomain.unwrap(data);
					if (data instanceof CSVNodeModel && !((CSVNodeModel) data).isRecord()) {
						DeleteSmooksGraphicalModelCommand deleteCommand = new DeleteSmooksGraphicalModelCommand(
								graphModel);
						return deleteCommand;
					}
				}
				return null;
			}
		});

		this.installEditPolicy(EditPolicy.LAYOUT_ROLE, new FlowLayoutEditPolicy() {

			@Override
			protected Command getCreateCommand(CreateRequest request) {
				Object model = request.getNewObject();
				Object graphModel = getHost().getModel();
				if (graphModel instanceof FreemarkerCSVNodeGraphicalModel) {
					ILabelProvider provider = ((FreemarkerCSVNodeGraphicalModel) graphModel).getLabelProvider();
					ITreeContentProvider provider1 = ((FreemarkerCSVNodeGraphicalModel) graphModel)
							.getContentProvider();
					IEditingDomainProvider provider2 = ((FreemarkerCSVNodeGraphicalModel) graphModel)
							.getDomainProvider();
					Object parentData = ((FreemarkerCSVNodeGraphicalModel) graphModel).getData();
					if (parentData instanceof CSVNodeModel) {
						if (((CSVNodeModel) parentData).isRecord()) {
							if (model instanceof CSVNodeModel && !((CSVNodeModel) model).isRecord()) {
								FreemarkerCSVNodeGraphicalModel childGraphModel = new FreemarkerCSVNodeGraphicalModel(
										model, provider1, provider, provider2);

								AddSmooksGraphicalModelCommand command = new AddSmooksGraphicalModelCommand(
										(AbstractSmooksGraphicalModel) graphModel, childGraphModel);
								return command;
							}
						}
					}
				}
				return null;
			}

			@Override
			protected Command createMoveChildCommand(EditPart child, EditPart after) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			protected Command createAddCommand(EditPart child, EditPart after) {
				return null;
			}

			@Override
			protected EditPolicy createChildEditPolicy(EditPart child) {
				return null;
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.gef.editpolicies.FlowLayoutEditPolicy#isHorizontal()
			 */
			@Override
			protected boolean isHorizontal() {
				return false;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart#
	 * createDirectEditCommand(org.eclipse.gef.requests.DirectEditRequest)
	 */
	@Override
	protected Command createDirectEditCommand(DirectEditRequest request) {
		Object value = request.getCellEditor().getValue();
		if (value != null && value instanceof String) {
			ChangeCSVNodeNameCommand command = new ChangeCSVNodeNameCommand(
					(FreemarkerCSVNodeGraphicalModel) getModel(), value);
			return command;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart#canDirectEdit
	 * ()
	 */
	@Override
	protected boolean canDirectEdit() {
		Object data = ((AbstractSmooksGraphicalModel) getModel()).getData();
		if (data instanceof CSVNodeModel && !((CSVNodeModel) data).isRecord()) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.gef.tree.editparts.TreeNodeEditPart#refreshVisuals
	 * ()
	 */
	@Override
	protected void refreshVisuals() {
		AbstractSmooksGraphicalModel model = (AbstractSmooksGraphicalModel) getModel();
		TreeNodeFigure figure = (TreeNodeFigure) getFigure();
		Object data = model.getData();
		if (data instanceof CSVNodeModel) {
			if (((CSVNodeModel) data).isRecord()) {
				figure.setNodeLabelForegroundColor(ColorConstants.blue);
				figure.getLabel().setFont(getCSVRecordLabelFont());
			}
		}
		super.refreshVisuals();
	}

}
