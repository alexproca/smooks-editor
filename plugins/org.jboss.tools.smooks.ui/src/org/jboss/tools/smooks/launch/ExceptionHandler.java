/**
 * JBoss, Home of Professional Open Source
 * Copyright 2009, JBoss Inc., and others contributors as indicated
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
 * (C) 2009, JBoss Inc.
*
 * Contributors:
 *     IBM Corporation - initial API and implementation
 */
package org.jboss.tools.smooks.launch;

import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.swt.widgets.Shell;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;

import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.jboss.tools.smooks.configuration.SmooksConfigurationActivator;

/**
 * The default exception handler shows an error dialog when one of its handle methods
 * is called. If the passed exception is a <code>CoreException</code> an error dialog
 * pops up showing the exception's status information. For a <code>InvocationTargetException</code>
 * a normal message dialog pops up showing the exception's message. Additionally the exception
 * is written to the platform log.
 *
 * TO DO: this class is duplicated from org.eclipse.jdt.ui
 */
public class ExceptionHandler {

	private static ExceptionHandler fgInstance= new ExceptionHandler();

	/**
	 * Handles the given <code>CoreException</code>. The workbench shell is used as a parent
	 * for the dialog window.
	 *
	 * @param e the <code>CoreException</code> to be handled
	 * @param title the dialog window's window title
	 * @param message message to be displayed by the dialog window
	 */
	public static void handle(CoreException e, String title, String message) {
		handle(e, SmooksConfigurationActivator.getActiveWorkbenchShell(), title, message);
	}

	/**
	 * Handles the given <code>CoreException</code>.
	 *
	 * @param e the <code>CoreException</code> to be handled
	 * @param parent the dialog window's parent shell or <code>null</code>
	 * @param title the dialog window's window title
	 * @param message message to be displayed by the dialog window
	 */
	public static void handle(CoreException e, Shell parent, String title, String message) {
		fgInstance.perform(e, parent, title, message);
	}

	/**
	 * Handles the given <code>InvocationTargetException</code>.
	 *
	 * @param e the <code>InvocationTargetException</code> to be handled
	 * @param parent the dialog window's parent shell or <code>null</code>
	 * @param title the dialog window's window title
	 * @param message message to be displayed by the dialog window
	 */
	public static void handle(InvocationTargetException e, Shell parent, String title, String message) {
		fgInstance.perform(e, parent, title, message);
	}

	//---- Hooks for subclasses to control exception handling ------------------------------------

	protected void perform(CoreException e, Shell shell, String title, String message) {
		SmooksConfigurationActivator.log(e);
		IStatus status= e.getStatus();
		if (status != null) {
			ErrorDialog.openError(shell, title, message, status);
		} else {
			displayMessageDialog(e.getMessage(), shell, title, message);
		}
	}

	protected void perform(InvocationTargetException e, Shell shell, String title, String message) {
		Throwable target= e.getTargetException();
		if (target instanceof CoreException) {
			perform((CoreException)target, shell, title, message);
		} else {
			SmooksConfigurationActivator.log(e);
			if (e.getMessage() != null && e.getMessage().length() > 0) {
				displayMessageDialog(e.getMessage(), shell, title, message);
			} else {
				displayMessageDialog(target.getMessage(), shell, title, message);
			}
		}
	}

	private void displayMessageDialog(String exceptionMessage, Shell shell, String title, String message) {
		StringWriter msg= new StringWriter();
		if (message != null) {
			msg.write(message);
			msg.write("\n\n"); //$NON-NLS-1$
		}
		if (exceptionMessage == null || exceptionMessage.length() == 0)
			msg.write(Messages.ExceptionHandler_Exception_Msg);
		else
			msg.write(exceptionMessage);
		MessageDialog.openError(shell, title, msg.toString());
	}
}
