/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.freemarker;

import org.jboss.tools.smooks.model.common.AbstractAnyType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output To</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *                 Output the templating result to a named OutputStreamResource.
 *             
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.freemarker.OutputTo#getOutputStreamResource <em>Output Stream Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.freemarker.FreemarkerPackage#getOutputTo()
 * @model extendedMetaData="name='outputTo' kind='empty'"
 * @generated
 */
public interface OutputTo extends AbstractAnyType {
	/**
	 * Returns the value of the '<em><b>Output Stream Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                     The name of the "outputStreamResource" to which the templating result is to be written.  By default,
	 *                     the templating result is written to the  Smooks.filter result if (if a StreamResult is provided).
	 *                 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Output Stream Resource</em>' attribute.
	 * @see #setOutputStreamResource(String)
	 * @see org.jboss.tools.smooks.model.freemarker.FreemarkerPackage#getOutputTo_OutputStreamResource()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='outputStreamResource'"
	 * @generated
	 */
	String getOutputStreamResource();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.freemarker.OutputTo#getOutputStreamResource <em>Output Stream Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Stream Resource</em>' attribute.
	 * @see #getOutputStreamResource()
	 * @generated
	 */
	void setOutputStreamResource(String value);

} // OutputTo
