/*
 * JBoss, Home of Professional Open Source
 * Copyright 2006, JBoss Inc., and others contributors as indicated
 * by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 *
 * (C) 2005-2006, JBoss Inc.
 */
package org.jboss.tools.smooks.launch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.junit.launcher.JUnitLaunchConfigurationDelegate;
import org.eclipse.jdt.launching.ExecutionArguments;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jdt.launching.IVMRunner;
import org.eclipse.jdt.launching.VMRunnerConfiguration;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.jboss.tools.smooks.configuration.ProcessNodeType;
import org.jboss.tools.smooks.configuration.RuntimeDependency;
import org.jboss.tools.smooks.configuration.RuntimeMetadata;
import org.jboss.tools.smooks.core.SmooksInputType;
import org.jboss.tools.smooks.launch.serialize.MarshallingStrategy;
import org.jboss.tools.smooks.launch.serialize.ObjectSerializer;
import org.jboss.tools.smooks.launch.serialize.XPathMarshaller;

/**
 * Smooks Launch Configuration Delegate.
 * 
 * @author <a href="mailto:tom.fennelly@jboss.com">tom.fennelly@jboss.com</a>
 */
public class SmooksLaunchConfigurationDelegate extends JUnitLaunchConfigurationDelegate {
	
	private static final String PLUGIN_ID = "org.jboss.tools.smooks.ui.smooksLauncher"; //$NON-NLS-1$

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(org.eclipse.debug.core.ILaunchConfiguration, java.lang.String, org.eclipse.debug.core.ILaunch, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void launch(ILaunchConfiguration launchConfig, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		IJavaProject javaProject = getJavaProject(launchConfig);
		IProject project = javaProject.getProject();
		final String smooksConfigName = launchConfig.getAttribute(IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME, ""); //$NON-NLS-1$
		String[] baseClasspath = getClasspath(launchConfig);
		final RuntimeMetadata launchMetadata = new RuntimeMetadata();

		launchMetadata.setSmooksConfig(project.findMember(smooksConfigName));
		
		if(SmooksInputType.INPUT_TYPE_JAVA.equals(launchMetadata.getInputType())) {
//			displayError(smooksConfigName, Messages.SmooksLaunchConfigurationDelegate_Error_Java_Unsupported);
//			return;
		} else if(!launchMetadata.isValidSmooksConfig()) {
			displayError(smooksConfigName, launchMetadata.getErrorMessage());
			return;
		} else {
			List<RuntimeDependency> dependencies = launchMetadata.getDependencies();
			URLClassLoader projectClassLoader = toURLClassLoader(baseClasspath);
			
			for(RuntimeDependency dependency : dependencies) {
				if(!dependency.isOnProjectClasspath(projectClassLoader)) {
					displayError(smooksConfigName, Messages.SmooksLaunchConfigurationDelegate_Error_missing_artifact + dependency.getGroupId() + ":" + dependency.getArtifactId() + Messages.SmooksLaunchConfigurationDelegate_Error_missing_artifact2); //$NON-NLS-1$
					return;
				}
			}
		}

		IVMRunner runner= getVMRunner(launchConfig, mode);		
		VMRunnerConfiguration runConfig = buildRunnerConfig(launchConfig, baseClasspath);
		
		// check for cancellation
		if (monitor.isCanceled()) {
			return;
		}		

		String inputType = launchMetadata.getInputType();
		String inputPath = launchMetadata.getInputFile().getAbsolutePath();
		if(SmooksInputType.INPUT_TYPE_JAVA.equals(launchMetadata.getInputType())) {
			inputPath = launchMetadata.getInputClassName();
		}
		String nodeTypes = launchMetadata.getNodeTypesString();

		runConfig.setProgramArguments(new String[] {launchMetadata.getConfigFile().getAbsolutePath(), inputType, inputPath, nodeTypes});
		
		runner.run(runConfig, launch, monitor);
	}

	private void displayError(final String smooksConfigName, final String errorMessage) {
		final Display display = PlatformUI.getWorkbench().getDisplay();
		display.syncExec(new Runnable() {
		    public void run(){
				Shell shell = display.getActiveShell();
				ErrorDialog.openError(shell, Messages.SmooksLaunchConfigurationDelegate_Error_Title, Messages.SmooksLaunchConfigurationDelegate_Error_launching + smooksConfigName + "'.", new Status(IStatus.ERROR, PLUGIN_ID, IStatus.ERROR, errorMessage, new Exception())); //$NON-NLS-1$ 
		    }
		});
	}

	private VMRunnerConfiguration buildRunnerConfig(ILaunchConfiguration launchConfig, String[] baseClasspath) throws CoreException {
		List<String> classpath = new ArrayList<String>(Arrays.asList(baseClasspath));

		// We need to add the SmooksLauncher to the launch classpath because it will not be part of the projects
		// classpath.  Bit of a hack... there's probably a nicer way of doing this!!!
		File wsTempClasses = copyLauncherResourcesToFilesys();
		classpath.add(wsTempClasses.getAbsolutePath());
		
		VMRunnerConfiguration runConfig= new VMRunnerConfiguration(SmooksLauncher.class.getName(), classpath.toArray(new String[classpath.size()]));
		String[] envp= getEnvironment(launchConfig);
		ArrayList<String> vmArguments= new ArrayList<String>();
		String vmArgs= getVMArguments(launchConfig);
		ExecutionArguments execArgs= new ExecutionArguments(vmArgs, ""); //$NON-NLS-1$
		File workingDir = verifyWorkingDirectory(launchConfig);

		vmArguments.addAll(Arrays.asList(execArgs.getVMArgumentsArray()));
		runConfig.setVMArguments((String[]) vmArguments.toArray(new String[vmArguments.size()]));
		runConfig.setEnvironment(envp);
		if(workingDir != null) {
			runConfig.setWorkingDirectory(workingDir.getAbsolutePath());
		}
		runConfig.setVMSpecificAttributesMap(getVMSpecificAttributesMap(launchConfig));
		runConfig.setBootClassPath(getBootpath(launchConfig));
		
		return runConfig;
	}

	private File copyLauncherResourcesToFilesys() throws CoreException {
		File wsRootDir = ResourcesPlugin.getWorkspace().getRoot().getRawLocation().toFile();
		File wsTempClasses = new File(wsRootDir, "temp/launcher/classes"); //$NON-NLS-1$		
		
		writeClassToFilesys(JavaGraphBuilder.class, wsTempClasses);
		writeClassToFilesys(SmooksLauncher.class, wsTempClasses);
		writeClassToFilesys(SmooksInputType.class, wsTempClasses);
		writeClassToFilesys(ProcessNodeType.class, wsTempClasses);
		writeClassToFilesys(ObjectSerializer.class, wsTempClasses);
		writeClassToFilesys(MarshallingStrategy.class, wsTempClasses);
		writeClassToFilesys(XPathMarshaller.class, wsTempClasses);
		
		// Need to send the localized message strings to the launcher... 
		Properties localizedMessages = new Properties();
		localizedMessages.setProperty("SmooksLauncher_Error_Do_Not_Support_Java_Inputs", Messages.SmooksLauncher_Error_Do_Not_Support_Java_Inputs);		 //$NON-NLS-1$
		localizedMessages.setProperty("SmooksLauncher_Error_Expected_Four_Args", Messages.SmooksLauncher_Error_Expected_Four_Args);		 //$NON-NLS-1$
		localizedMessages.setProperty("SmooksLauncher_Java_Mapping_Results", Messages.SmooksLauncher_Java_Mapping_Results);		 //$NON-NLS-1$
		localizedMessages.setProperty("SmooksLauncher_Templating_To_StreamResult", Messages.SmooksLauncher_Templating_To_StreamResult); //$NON-NLS-1$
		localizedMessages.setProperty("SmooksLauncher_Nothing_To_Display", Messages.SmooksLauncher_Nothing_To_Display); //$NON-NLS-1$
		
		try {
			FileOutputStream messagesOutStream = getFilesysOutStream(SmooksLauncher.LOCALIZED_FILE_NAME, SmooksLauncher.class, wsTempClasses);
			try {
				localizedMessages.store(messagesOutStream, "Localized messages..."); //$NON-NLS-1$
			} finally {
				messagesOutStream.close();
			}			
		} catch (IOException e) {
			new CoreException(new Status(IStatus.ERROR, PLUGIN_ID, IStatus.ERROR, Messages.SmooksLaunchConfigurationDelegate_Error_Copying_Smooks_Launcher, e));
		}
		
		return wsTempClasses;
	}

	private void writeClassToFilesys(Class<?> theClass, File toDir) throws CoreException {
		String className = theClass.getSimpleName() + ".class"; //$NON-NLS-1$
		writeResourceToFilesys(className, theClass, toDir);
	}

	private void writeResourceToFilesys(String resource, Class<?> refClass, File toDir) {
		String packagePath = refClass.getPackage().getName().replace(".", "/"); //$NON-NLS-1$ //$NON-NLS-2$
		String resourcePath = "/" + packagePath + Messages.SmooksLaunchConfigurationDelegate_11 + resource; //$NON-NLS-1$
		URL resourceURI = refClass.getResource(resourcePath);
		
		if(resourceURI != null) {
			try {
				InputStream resourceStream = resourceURI.openStream();
				
				if(resourceStream != null) {
					try {
						File resourceOutFile = new File(toDir, resourcePath);
						File resourcePackage = resourceOutFile.getParentFile();
						
						resourcePackage.mkdirs();
						if(resourcePackage.exists()) {
							FileOutputStream resourceOutStream = new FileOutputStream(resourceOutFile);
							
							try {
								byte[] readBuf = new byte[100];
								int readCount = 0;
								
								while(readCount != -1) {
									readCount = resourceStream.read(readBuf);
									if(readCount != -1) {
										resourceOutStream.write(readBuf, 0, readCount);
									}
								}
							} finally {
								try {
									resourceOutStream.flush();
								} finally {									
									resourceOutStream.close();
								}
							}
						}
					} finally {
						resourceStream.close();
					}
				}
			} catch (IOException e) {
				new CoreException(new Status(IStatus.ERROR, PLUGIN_ID, IStatus.ERROR, Messages.SmooksLaunchConfigurationDelegate_Error_Copying_Smooks_Launcher, e));
			}
		}
	}

	private FileOutputStream getFilesysOutStream(String resource, Class<?> refClass, File toDir) throws FileNotFoundException {
		String packagePath = refClass.getPackage().getName().replace(".", "/"); //$NON-NLS-1$ //$NON-NLS-2$
		String resourcePath = "/" + packagePath + "/" + resource; //$NON-NLS-1$ //$NON-NLS-2$
		File resourceOutFile = new File(toDir, resourcePath);
		File resourcePackage = resourceOutFile.getParentFile();
		
		resourcePackage.mkdirs();

		return new FileOutputStream(resourceOutFile);
	}

	private URLClassLoader toURLClassLoader(String[]  baseClasspath) {
		URL[] classPathURLs = new URL[baseClasspath.length];
		
		for(int i = 0; i < baseClasspath.length; i++) {
			try {
				File cpEntry = new File(baseClasspath[i]);				
				classPathURLs[i] = cpEntry.toURL();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		
		return new URLClassLoader(classPathURLs);
	}
}
