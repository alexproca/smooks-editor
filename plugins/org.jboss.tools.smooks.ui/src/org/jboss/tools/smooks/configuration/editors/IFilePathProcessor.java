/**
 * 
 */
package org.jboss.tools.smooks.configuration.editors;

import org.eclipse.core.resources.IFile;

/**
 * @author DartPeng
 *
 */
public interface IFilePathProcessor {
	String processWorkBenchPath(IFile file);
	
	String processFileSystemPath(String filePath);
}
