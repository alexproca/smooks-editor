/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.graphical.editors.process;


import java.beans.PropertyChangeListener;
import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.graphics.ext.ProcessType#getTask <em>Task</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.graphics.ext.ProcessType#getId <em>Id</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.graphics.ext.ProcessType#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.graphics.ext.GraphPackage#getProcessType()
 * @model extendedMetaData="name='process_._type' kind='elementOnly'"
 * @generated
 */
public interface ProcessType {
	
	public static final String PRO_NAME_CHANGE = "pro_name_change"; //$NON-NLS-1$

	public static final String PRO_ID_CHANGE = "pro_id_change"; //$NON-NLS-1$

	public static final String PRO_ADD_CHILD = "pro_add_child"; //$NON-NLS-1$

	public static final String PRO_REMOVE_CHILD = "pro_remove_child"; //$NON-NLS-1$
	
	public void addPropertyChangeListener(PropertyChangeListener listener);
	
	public void removePropertyChangeListener(PropertyChangeListener listener);
	
	/**
	 * Returns the value of the '<em><b>Task</b></em>' containment reference list.
	 * The list contents are of type {@link org.jboss.tools.smooks.model.graphics.ext.TaskType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task</em>' containment reference list.
	 * @see org.jboss.tools.smooks.model.graphics.ext.GraphPackage#getProcessType_Task()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='task' namespace='##targetNamespace'"
	 * @generated
	 */
	List<TaskType> getTask();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.jboss.tools.smooks.model.graphics.ext.GraphPackage#getProcessType_Id()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.graphics.ext.ProcessType#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.jboss.tools.smooks.model.graphics.ext.GraphPackage#getProcessType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.graphics.ext.ProcessType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);
	
	public void addTask(TaskType task);
	
	public void removeTask(TaskType task);

} // ProcessType
