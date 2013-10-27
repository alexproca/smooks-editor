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
package org.jboss.tools.smooks.graphical.editors.process;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.zest.core.viewers.IConnectionStyleProvider;
import org.eclipse.zest.core.viewers.IFigureProvider;
import org.eclipse.zest.core.viewers.ISelfStyleProvider;
import org.eclipse.zest.core.widgets.CGraphNode;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.jboss.tools.smooks.configuration.SmooksConfigurationActivator;
import org.jboss.tools.smooks.configuration.editors.GraphicsConstants;
import org.jboss.tools.smooks.configuration.editors.IFieldMarker;
import org.jboss.tools.smooks.graphical.editors.SmooksProcessGraphicalEditor;
import org.jboss.tools.smooks.graphical.editors.TaskTypeManager;
import org.jboss.tools.smooks.graphical.editors.TaskTypeManager.TaskTypeDescriptor;

/**
 * @author Dart
 * 
 */
public class ProcessGraphicalViewerLabelProvider extends LabelProvider implements IFigureProvider, ISelfStyleProvider ,IConnectionStyleProvider {

	private SmooksProcessGraphicalEditor processEditor;
	

	@Override
	public void dispose() {
		super.dispose();
	}

	public ProcessGraphicalViewerLabelProvider(SmooksProcessGraphicalEditor graph) {
		this.processEditor = graph;
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof TaskType) {
			String id = ((TaskType) element).getId();
			List<TaskTypeDescriptor> des = TaskTypeManager.getAllTaskList();
			for (Iterator<?> iterator = des.iterator(); iterator.hasNext();) {
				TaskTypeDescriptor taskTypeDescriptor = (TaskTypeDescriptor) iterator.next();
				if (taskTypeDescriptor.getId().equals(id)) {
					return SmooksConfigurationActivator.getDefault().getImageRegistry().get(
							taskTypeDescriptor.getImagePath());
				}
			}
		}
		return super.getImage(element);
	}

	@Override
	public String getText(Object element) {
		if (element instanceof TaskType) {
			String label = TaskTypeManager.getTaskLabel((TaskType)element);
			if(label == null){
				label =  ((TaskType) element).getId();
			}
			return label;
		}
		return ""; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.zest.core.viewers.IFigureProvider#getFigure(java.lang.Object)
	 */
	public IFigure getFigure(Object element) {
		if (element instanceof TaskType) {
			// if(TaskTypeManager.TASK_ID_INPUT.equals(((TaskType)element).getId())){
			Image image = getImage(element);
			String text = getText(element);
			return new TaskNodeFigure((TaskType)element, processEditor, image, text);
			// }
		}
		return null;
	}

	public void selfStyleConnection(Object element, GraphConnection connection) {
//		connection.setLineColor(GraphicsConstants.BORDER_CORLOR);
	}
	
	private String getProblemMessage(List<String> message){
		String m = null;
		if(message != null && !message.isEmpty()){
			m = ""; //$NON-NLS-1$
			for (Iterator<String> iterator = message.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
				m = m + " - " + string +" \n"; //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return m;
	}

	public void selfStyleNode(Object element, GraphNode node) {
		if (node instanceof CGraphNode) {
			IFigure figure = ((CGraphNode) node).getFigure();
			if(figure instanceof TaskNodeFigure && element instanceof TaskType){
				int problem = ((TaskType)element).getProblemType();
				List<String> problemMessages = ((TaskType)element).getProblemMessages();
				
				String message = getProblemMessage(problemMessages);
				
				ImageRegistry ir = SmooksConfigurationActivator.getDefault().getImageRegistry();
				switch(problem){
				case IFieldMarker.TYPE_NONE:
					((TaskNodeFigure)figure).getLabel().setIcon(null);
					break;
				case IFieldMarker.TYPE_ERROR:
					((TaskNodeFigure)figure).getLabel().setIcon(ir.get(GraphicsConstants.IMAGE_ERROR));
					break;
				case IFieldMarker.TYPE_WARINING:
					((TaskNodeFigure)figure).getLabel().setIcon(ir.get(GraphicsConstants.IMAGE_WARNING));
					break;
				}
				((TaskNodeFigure)figure).setProblemMessage(message);
			}
			Dimension size = figure.getLayoutManager().getPreferredSize(figure, -1, -1);
			figure.setSize(size);
		}
	}

	public int getConnectionStyle(Object rel) {
		return 0;
	}

	public Color getColor(Object rel) {
		return ColorConstants.black;
	}

	public Color getHighlightColor(Object rel) {
		return ColorConstants.black;
	}

	public int getLineWidth(Object rel) {
		// TODO Auto-generated method stub
		return 0;
	}

	public IFigure getTooltip(Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
