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
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;
import org.jboss.tools.smooks.graphical.editors.process.ProcessType;
import org.jboss.tools.smooks.graphical.editors.process.TaskType;

/**
 * @author Dart
 * 
 */
public class ProcessGraphContentProvider implements IGraphEntityContentProvider {

	private void collectTasks(List<Object> list, TaskType task) {
		list.add(task);
		List<?> tasks = task.getTask();
		for (Iterator<?> iterator = tasks.iterator(); iterator.hasNext();) {
			TaskType t = (TaskType) iterator.next();
			collectTasks(list, t);
		}
	}

	private void collectObjects(List<Object> list, ProcessType process) {
		List<?> tasks = process.getTask();
		for (Iterator<?> iterator = tasks.iterator(); iterator.hasNext();) {
			TaskType t = (TaskType) iterator.next();
			collectTasks(list, t);
		}
	}

	public Object[] getElements(Object arg0) {
		List<Object> list = new ArrayList<Object>();
		if (arg0 instanceof ProcessType) {
			collectObjects(list, (ProcessType) arg0);
		}
		return list.toArray();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface
	 * .viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.zest.core.viewers.IGraphEntityContentProvider#getConnectedTo
	 * (java.lang.Object)
	 */
	public Object[] getConnectedTo(Object arg0) {
		if (arg0 instanceof TaskType) {
			return ((TaskType) arg0).getTask().toArray();
		}
		return new Object[] {};
	}
}
