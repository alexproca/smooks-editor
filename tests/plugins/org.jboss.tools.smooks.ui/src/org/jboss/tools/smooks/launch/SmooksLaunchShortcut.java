package org.jboss.tools.smooks.launch;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.jdt.junit.launcher.JUnitLaunchShortcut;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.part.FileEditorInput;
import org.jboss.tools.smooks.configuration.RuntimeMetadata;
import org.jboss.tools.smooks.configuration.SmooksConfigurationActivator;
import org.jboss.tools.smooks.core.SmooksInputType;
import org.jboss.tools.smooks.editor.AbstractSmooksFormEditor;

public class SmooksLaunchShortcut extends JUnitLaunchShortcut {

	private static final String EMPTY_STRING= ""; //$NON-NLS-1$

	private Shell getShell() {
		return SmooksConfigurationActivator.getActiveWorkbenchShell();
	}

	private ILaunchManager getLaunchManager() {
		return DebugPlugin.getDefault().getLaunchManager();
	}

	private List<ILaunchConfiguration> findExistingLaunchConfigurations(ILaunchConfigurationWorkingCopy temporary) throws CoreException {
		ILaunchConfigurationType configType= temporary.getType();

		ILaunchConfiguration[] configs= getLaunchManager().getLaunchConfigurations(configType);
		String[] attributeToCompare= getAttributeNamesToCompare();

		ArrayList<ILaunchConfiguration> candidateConfigs= new ArrayList<ILaunchConfiguration>(configs.length);
		for (int i= 0; i < configs.length; i++) {
			ILaunchConfiguration config= configs[i];
			if (hasSameAttributes(config, temporary, attributeToCompare)) {
				candidateConfigs.add(config);
			}
		}
		return candidateConfigs;
	}

	private static boolean hasSameAttributes(ILaunchConfiguration config1, ILaunchConfiguration config2, String[] attributeToCompare) {
		try {
			for (int i= 0; i < attributeToCompare.length; i++) {
				String val1= config1.getAttribute(attributeToCompare[i], EMPTY_STRING);
				String val2= config2.getAttribute(attributeToCompare[i], EMPTY_STRING);
				if (!val1.equals(val2)) {
					return false;
				}
			}
			return true;
		} catch (CoreException e) {
			// ignore access problems here, return false
		}
		return false;
	}

	public void launch(ISelection selection, String mode) {
		if (selection instanceof IStructuredSelection) {
			launch(((IStructuredSelection) selection).toArray(), mode);
		}
	}

	public void launch(IEditorPart editor, String mode) {
		if (editor.getEditorInput() != null && editor.getEditorInput() instanceof IFileEditorInput) {
			IFile file= ((IFileEditorInput)editor.getEditorInput()).getFile();
			if (file != null) {
				launch(new Object[] { file }, mode);
			}
		}
	}

	private void launch(Object[] elements, String mode) {
		try {
			IFile elementToLaunch= null;

			if (elements.length == 1) {
				Object selected= elements[0];
				if (!(selected instanceof IFile) && selected instanceof IAdaptable) {
					selected= ((IAdaptable) selected).getAdapter(IFile.class);
				}
				if (selected instanceof IFile) {
					elementToLaunch = (IFile) selected;
				}
				RuntimeMetadata metadata = new RuntimeMetadata();
				metadata.setSmooksConfig(elementToLaunch);
				if(SmooksInputType.INPUT_TYPE_JAVA.equals(metadata.getInputType())) {
//					MessageDialog.openError(getShell(), Messages.SmooksLaunchShortcut_Title_Launch_Failed, Messages.SmooksLaunchConfigurationDelegate_Error_Java_Unsupported);
//					return;
				} else if (!metadata.isValidSmooksConfig()) {
					MessageDialog.openError(getShell(), Messages.SmooksLaunchShortcut_Title_Launch_Failed, metadata.getErrorMessage());
					return;
				}
			}
			performLaunch(elementToLaunch, mode);
		} catch (InterruptedException e) {
			// OK, silently move on
		} catch (CoreException e) {
			ExceptionHandler.handle(e, getShell(), 
					Messages.SmooksLaunchShortcut_Title_Launch_Failed, 
					Messages.SmooksLaunchShortcut_Exception_Occurred);
		}
	}

	private void performLaunch(IFile file, String mode) throws InterruptedException, CoreException {
		ILaunchConfigurationWorkingCopy temparary= createLaunchConfiguration(file);
		ILaunchConfiguration config= findExistingLaunchConfiguration(temparary, mode);
		if (config == null) {
			// no existing found: create a new one
			config= temparary.doSave();
		}
		DebugUITools.launch(config, mode);
	}

	private ILaunchConfiguration findExistingLaunchConfiguration(ILaunchConfigurationWorkingCopy temporary, String mode) throws InterruptedException, CoreException {
		List<?> candidateConfigs= findExistingLaunchConfigurations(temporary);

		// If there are no existing configs associated with the IType, create
		// one.
		// If there is exactly one config associated with the IType, return it.
		// Otherwise, if there is more than one config associated with the
		// IType, prompt the
		// user to choose one.
		int candidateCount= candidateConfigs.size();
		if (candidateCount == 0) {
			return null;
		} else if (candidateCount == 1) {
			return (ILaunchConfiguration) candidateConfigs.get(0);
		} else {
			// Prompt the user to choose a config. A null result means the user
			// cancelled the dialog, in which case this method returns null,
			// since cancelling the dialog should also cancel launching
			// anything.
			ILaunchConfiguration config= chooseConfiguration(candidateConfigs, mode);
			if (config != null) {
				return config;
			}
		}
		return null;
	}

	private ILaunchConfiguration chooseConfiguration(List<?> configList, String mode) throws InterruptedException {
		IDebugModelPresentation labelProvider= DebugUITools.newDebugModelPresentation();
		ElementListSelectionDialog dialog= new ElementListSelectionDialog(getShell(), labelProvider);
		dialog.setElements(configList.toArray());
		dialog.setTitle(Messages.SmooksLaunchShortcut_Title_Select_Config);
		if (mode.equals(ILaunchManager.RUN_MODE)) {
			dialog.setMessage(Messages.SmooksLaunchShortcut_Message_Select_Config);
		}
		dialog.setMultipleSelection(false);
		int result= dialog.open();
		if (result == Window.OK) {
			return (ILaunchConfiguration) dialog.getFirstResult();
		}
		throw new InterruptedException(); // cancelled by user
	}

	protected String getLaunchConfigurationTypeId() {
		return "org.jboss.tools.smooks.ui.smooksLauncher"; //$NON-NLS-1$
	}

	protected ILaunchConfigurationWorkingCopy createLaunchConfiguration(IFile file) throws CoreException {
		if (file != null) {
			
			ILaunchConfigurationType configType= getLaunchManager().getLaunchConfigurationType(getLaunchConfigurationTypeId());
			ILaunchConfigurationWorkingCopy wc= configType.newInstance(null, getLaunchManager().generateUniqueLaunchConfigurationNameFrom(file.getName()));

			IProject project = (IProject) file.getProject();
			wc.setAttribute(IJavaLaunchConfigurationConstants.ATTR_PROJECT_NAME, project.getName());
			wc.setAttribute(IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME, file.getProjectRelativePath().toPortableString());

			return wc;
		}
		
		return null;

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.junit.launcher.JUnitLaunchShortcut#getLaunchableResource(org.eclipse.ui.IEditorPart)
	 */
	@Override
	public IResource getLaunchableResource(IEditorPart editor) {
		if (editor instanceof AbstractSmooksFormEditor) {
			IEditorInput editorInput = editor.getEditorInput();
			if (editorInput instanceof FileEditorInput) {
				return ((FileEditorInput)editorInput).getFile();
			}
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.junit.launcher.JUnitLaunchShortcut#getLaunchConfigurations(org.eclipse.ui.IEditorPart)
	 */
	@Override
	public ILaunchConfiguration[] getLaunchConfigurations(IEditorPart editor) {
		if (editor instanceof AbstractSmooksFormEditor) {
			IEditorInput editorInput = editor.getEditorInput();
			if (editorInput instanceof FileEditorInput) {
				ILaunchConfigurationWorkingCopy temparary;
				try {
					temparary = createLaunchConfiguration(((FileEditorInput)editorInput).getFile());
					
					ILaunchConfiguration existingConfig = findExistingLaunchConfiguration(temparary, ILaunchManager.RUN_MODE);
					if(existingConfig == null) {
						existingConfig = temparary.doSave();
					}
					
					return new ILaunchConfiguration[] {existingConfig};
				} catch (CoreException e) {
					ExceptionHandler.handle(e, getShell(), 
							Messages.SmooksLaunchShortcut_Title_Launch_Failed, 
							Messages.SmooksLaunchShortcut_Exception_Occurred);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}
}
