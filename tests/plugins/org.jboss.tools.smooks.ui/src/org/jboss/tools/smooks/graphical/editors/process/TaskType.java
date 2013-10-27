/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.graphical.editors.process;


import java.beans.PropertyChangeSupport;
import java.util.List;

import org.jboss.tools.smooks.model.smooks.AbstractResourceConfig;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.graphics.ext.TaskType#getTask <em>Task</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.graphics.ext.TaskType#getId <em>Id</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.graphics.ext.TaskType#getName <em>Name</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.graphics.ext.TaskType#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.graphics.ext.GraphPackage#getTaskType()
 * @model extendedMetaData="name='task_._type' kind='elementOnly'"
 * @generated
 */
public interface TaskType {
	
	int getProblemType();
	
	/**
	 * 
	 * @param type 
	 */
	void setProblemType(int type);
	
	List<String> getProblemMessages();
	
	void cleanProblemMessages();
	
	void removeProblemMessage(String message);
	
	void addProblemMessage(String message);
	
	void setPropertyChangeSupport(PropertyChangeSupport support);
	
	Object getParent();
	
	void setParent(Object parent);
	
	public void addTask(TaskType task);
	
	public void removeTask(TaskType task);
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
	 * @see org.jboss.tools.smooks.model.graphics.ext.GraphPackage#getTaskType_Task()
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
	 * @see org.jboss.tools.smooks.model.graphics.ext.GraphPackage#getTaskType_Id()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.graphics.ext.TaskType#getId <em>Id</em>}' attribute.
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
	 * @see org.jboss.tools.smooks.model.graphics.ext.GraphPackage#getTaskType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.graphics.ext.TaskType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.jboss.tools.smooks.model.graphics.ext.GraphPackage#getTaskType_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='type'"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.graphics.ext.TaskType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);
	
	boolean inTheTask(AbstractResourceConfig smooksResource);
	
	List<AbstractResourceConfig> getTaskResources();
	
	void addTaskResource(AbstractResourceConfig smooksResource);
	
	void removeTaskResource(AbstractResourceConfig smooksResource);

} // TaskType
