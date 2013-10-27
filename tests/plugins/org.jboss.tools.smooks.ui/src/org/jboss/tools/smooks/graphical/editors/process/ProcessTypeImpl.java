/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.graphical.editors.process;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Process Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.jboss.tools.smooks.model.graphics.ext.impl.ProcessTypeImpl#getTask
 * <em>Task</em>}</li>
 * <li>
 * {@link org.jboss.tools.smooks.model.graphics.ext.impl.ProcessTypeImpl#getId
 * <em>Id</em>}</li>
 * <li>
 * {@link org.jboss.tools.smooks.model.graphics.ext.impl.ProcessTypeImpl#getName
 * <em>Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ProcessTypeImpl implements ProcessType {

	private PropertyChangeSupport support = new PropertyChangeSupport(this);

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ProcessTypeImpl() {
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

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		support.removePropertyChangeListener(listener);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		support.addPropertyChangeListener(listener);
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
		support.firePropertyChange(PRO_ID_CHANGE, oldId, newId);
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
		support.firePropertyChange(PRO_NAME_CHANGE, oldName, newName);
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
		result.append(')');
		return result.toString();
	}

	public void addTask(TaskType task) {
		if (task != null) {
			this.getTask().add(task);
			task.setParent(this);
			task.setPropertyChangeSupport(support);
			support.firePropertyChange(PRO_ADD_CHILD, null, task);
		}
	}

	public void removeTask(TaskType task) {
		if (task != null) {
			this.getTask().remove(task);
			task.setParent(null);
			task.setPropertyChangeSupport(support);
			support.firePropertyChange(PRO_REMOVE_CHILD, task, null);
		}
	}

} // ProcessTypeImpl
