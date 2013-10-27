/**
 * 
 */
package org.jboss.tools.smooks.configuration.editors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

/**
 * @author DartPeng
 * 
 */
public class CurrentProjecViewerFilter extends ViewerFilter {

	private IResource referenceResource;

	public CurrentProjecViewerFilter(IResource referenceResource) {
		this.referenceResource = referenceResource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers
	 * .Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		IProject project = null;
		if (referenceResource != null) {
			project = referenceResource.getProject();
		}
		if (project == null) {
			return true;
		}
		IResource resource = null;
		if (element instanceof IResource) {
			resource = (IResource)element;
		} else {
			if (element instanceof IAdaptable) {
				resource = (IResource) ((IAdaptable) element).getAdapter(IResource.class);
			}
		}
		if (resource != null) {
			if(project == resource.getProject()){
				return true;
			}
		}
		return false;
	}

}
