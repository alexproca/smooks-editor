/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.graphical.editors.process;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import org.jboss.tools.smooks.configuration.editors.IFieldMarker;
import org.jboss.tools.smooks.model.smooks.AbstractResourceConfig;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Task Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.jboss.tools.smooks.model.graphics.ext.impl.TaskTypeImpl#getTask
 * <em>Task</em>}</li>
 * <li>{@link org.jboss.tools.smooks.model.graphics.ext.impl.TaskTypeImpl#getId
 * <em>Id</em>}</li>
 * <li>
 * {@link org.jboss.tools.smooks.model.graphics.ext.impl.TaskTypeImpl#getName
 * <em>Name</em>}</li>
 * <li>
 * {@link org.jboss.tools.smooks.model.graphics.ext.impl.TaskTypeImpl#getType
 * <em>Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TaskTypeImpl implements TaskType {

	private PropertyChangeSupport propertyChangeSupport = null;

	private Object parent;

	private List<AbstractResourceConfig> taskResources = null;

	private int problemType = IFieldMarker.TYPE_NONE;

	private List<String> problemMessages = null;

	public List<String> getProblemMessages() {
		if (problemMessages == null) {
			problemMessages = new ArrayList<String>();
		}
		return problemMessages;
	}

	public void addProblemMessage(String message) {
		getProblemMessages().add(message);
	}

	public void removeProblemMessage(String message) {
		getProblemMessages().remove(message);
	}

	public void cleanProblemMessages() {
		getProblemMessages().clear();
	}

	public int getProblemType() {
		return problemType;
	}

	public void setProblemType(int problemType) {
		if (this.problemType == IFieldMarker.TYPE_ERROR && problemType == IFieldMarker.TYPE_WARINING) {
			return;
		}
		this.problemType = problemType;
	}

	/**
	 * @return the propertyChangeSupport
	 */
	public PropertyChangeSupport getPropertyChangeSupport() {
		return propertyChangeSupport;
	}

	/**
	 * @param propertyChangeSupport
	 *            the propertyChangeSupport to set
	 */
	public void setPropertyChangeSupport(PropertyChangeSupport propertyChangeSupport) {
		this.propertyChangeSupport = propertyChangeSupport;
	}

	/**
	 * @return the parent
	 */
	public Object getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(Object parent) {
		this.parent = parent;
	}

	public List<AbstractResourceConfig> getTaskResources() {
		if (taskResources == null) {
			taskResources = new ArrayList<AbstractResourceConfig>();
		}
		return taskResources;
	}

	/**
	 * The cached value of the '{@link #getTask() <em>Task</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTask()
	 * @generated
	 * @ordered
	 */
	protected List<TaskType> task;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TaskTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List<TaskType> getTask() {
		if (task == null) {
			task = new ArrayList<TaskType>();
		}
		return task;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = name;
		id = newId;
		if (propertyChangeSupport != null)
			propertyChangeSupport.firePropertyChange(ProcessType.PRO_ID_CHANGE, oldId, newId);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (propertyChangeSupport != null)
			propertyChangeSupport.firePropertyChange(ProcessType.PRO_NAME_CHANGE, oldName, newName);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setType(String newType) {
		type = newType;
	}

	public void addTask(TaskType task) {
		if (task != null) {
			this.getTask().add(task);
			task.setParent(this);
			task.setPropertyChangeSupport(propertyChangeSupport);
			if (propertyChangeSupport != null)
				propertyChangeSupport.firePropertyChange(ProcessType.PRO_ADD_CHILD, null, task);
		}
	}

	public void removeTask(TaskType task) {
		if (task != null) {
			this.getTask().remove(task);
			task.setParent(null);
			task.setPropertyChangeSupport(null);
			if (propertyChangeSupport != null)
				propertyChangeSupport.firePropertyChange(ProcessType.PRO_REMOVE_CHILD, task, null);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: "); //$NON-NLS-1$
		result.append(id);
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", type: "); //$NON-NLS-1$
		result.append(type);
		result.append(')');
		return result.toString();
	}

	public void addTaskResource(AbstractResourceConfig smooksResource) {
		getTaskResources().add(smooksResource);
	}

	public boolean inTheTask(AbstractResourceConfig smooksResource) {
		if(taskResources == null) {
			return false;
		}
		return taskResources.contains(smooksResource);
	}

	public void removeTaskResource(AbstractResourceConfig smooksResource) {
		getTaskResources().remove(smooksResource);
	}

} // TaskTypeImpl
