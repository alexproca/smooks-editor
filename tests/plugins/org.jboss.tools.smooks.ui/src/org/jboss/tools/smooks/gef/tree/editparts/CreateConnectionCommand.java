/**
 * 
 */
package org.jboss.tools.smooks.gef.tree.editparts;

import org.eclipse.gef.commands.Command;
import org.jboss.tools.smooks.gef.model.AbstractSmooksGraphicalModel;
import org.jboss.tools.smooks.gef.tree.model.BeanReferenceConnection;
import org.jboss.tools.smooks.gef.tree.model.TreeNodeConnection;
import org.jboss.tools.smooks.gef.tree.model.TriggerConnection;
import org.jboss.tools.smooks.gef.tree.model.ValueBindingConnection;
import org.jboss.tools.smooks.graphical.editors.model.InputDataTreeNodeModel;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerTemplateConnection;
import org.jboss.tools.smooks.graphical.editors.model.freemarker.FreemarkerXMLNodeGraphicalModel;
import org.jboss.tools.smooks.graphical.editors.model.javamapping.JavaBeanChildGraphModel;
import org.jboss.tools.smooks.graphical.editors.model.javamapping.JavaBeanGraphModel;

/**
 * @author DartPeng
 * 
 */
public class CreateConnectionCommand extends Command {

	private AbstractSmooksGraphicalModel source;

	private AbstractSmooksGraphicalModel target;

	private TreeNodeConnection tempConnectionHandle = null;

	@Override
	public void execute() {
		if (source != null && target != null) {
			TreeNodeConnection connection = null;
			if (target instanceof JavaBeanChildGraphModel && source instanceof InputDataTreeNodeModel) {
				connection = new ValueBindingConnection(source, target);
			}

			if (source instanceof JavaBeanChildGraphModel && target instanceof JavaBeanGraphModel) {
				connection = new BeanReferenceConnection(source, target);
			}

			// default connection type
			if (source instanceof InputDataTreeNodeModel && connection == null) {
				connection = new TriggerConnection(source, target);
			}
			
			if(target instanceof FreemarkerXMLNodeGraphicalModel){
				connection = new FreemarkerTemplateConnection();
				connection.setSourceNode(source);
				connection.setTargetNode(target);
			}
			
			if (connection == null) {
				connection = new TreeNodeConnection(source, target);
			}

			connection.connect();
			tempConnectionHandle = connection;
		}
	}

	@Override
	public void redo() {
		if (tempConnectionHandle != null) {
			tempConnectionHandle.connect();
		} else {
			execute();
		}
	}

	@Override
	public void undo() {
		if (tempConnectionHandle != null) {
			tempConnectionHandle.disconnect();
		}
	}

	public AbstractSmooksGraphicalModel getSource() {
		return source;
	}

	public void setSource(AbstractSmooksGraphicalModel source) {
		this.source = source;
	}

	public AbstractSmooksGraphicalModel getTarget() {
		return target;
	}

	public void setTarget(AbstractSmooksGraphicalModel target) {
		this.target = target;
	}

	public TreeNodeConnection getTempConnectionHandle() {
		return tempConnectionHandle;
	}

	public void setTempConnectionHandle(TreeNodeConnection tempConnectionHandle) {
		this.tempConnectionHandle = tempConnectionHandle;
	}
	
	
}
