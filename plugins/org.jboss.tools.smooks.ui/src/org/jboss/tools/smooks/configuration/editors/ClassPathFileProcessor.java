/**
 * 
 */
package org.jboss.tools.smooks.configuration.editors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

/**
 * @author DartPeng
 * 
 */
public class ClassPathFileProcessor implements IFilePathProcessor {

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.IFilePathProcessor#
	 * processFileSystemPath(java.lang.String)
	 */
	public String processFileSystemPath(String filePath) {
		return filePath;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.jboss.tools.smooks.configuration.editors.IFilePathProcessor#
	 * processWorkBenchPath(org.eclipse.core.resources.IFile)
	 */
	public String processWorkBenchPath(IFile file) {
		IProject project = file.getProject();
		IJavaProject javaProject = JavaCore.create(project);
		String path = null;
		if (javaProject != null) {
			try {
				IClasspathEntry[] classpathEntries = javaProject.getRawClasspath();
				for (int i = 0; i < classpathEntries.length; i++) {
					IClasspathEntry entry = classpathEntries[i];
//					if(entry.getEntryKind() == IClasspathEntry.CPE_SOURCE){
						IPath sourcePath = entry.getPath();
						if(sourcePath.isPrefixOf(file.getFullPath())){
							IPath filePath = file.getFullPath();
							String sp = sourcePath.toPortableString();
							String fp = filePath.toPortableString();
							path = fp.substring(sp.length(), fp.length());
							break;
						}
//					}
				}
			} catch (JavaModelException e) {
//				e.printStackTrace();
				// ignore
			}
		}
		if(path == null){
		    path = file.getFullPath().removeFirstSegments(1).toPortableString();
		}
		if(path.charAt(0) == '\\' || path.charAt(0) == '/' ){
			
		}else{
			path = "/" + path; //$NON-NLS-1$
		}
		return path;
	}

}
