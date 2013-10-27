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
package org.jboss.tools.smooks.test.openeditor;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.jboss.tools.test.util.TestProjectProvider;
import org.jboss.tools.smooks.test.util.TestUtil;

/**
 * @author Dart
 * 
 */
public class AbstractSmooksEditorTestcase extends TestCase {

	protected static final IWorkspace WorkSpace = ResourcesPlugin.getWorkspace();
	protected static final IWorkbench WorkBench = PlatformUI.getWorkbench();

	protected List<IEditorPart> editorList = new ArrayList<IEditorPart>();

	protected IProject testProject = null;
	
	public void test(){
		
	}

	private void setUpEnvironment() throws CoreException {
		if (getTestProjectName() != null) {
			TestProjectProvider provider = new TestProjectProvider(TestUtil.TEST_BUNDLE_NAME, "/projects/"
					+ getTestProjectName(), getTestProjectName(), true);
			testProject = provider.getProject();
		}
	}

	protected String getTestProjectName() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setUpEnvironment();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		if (this.testProject != null) {
			testProject.delete(true, null);
		}
		super.tearDown();
	}

}
