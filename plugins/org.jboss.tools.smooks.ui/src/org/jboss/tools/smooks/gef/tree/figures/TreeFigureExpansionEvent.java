/**
 * 
 */
package org.jboss.tools.smooks.gef.tree.figures;

/**
 * @author DartPeng
 * 
 */
public class TreeFigureExpansionEvent {

	private Object source;

	public Object getSource() {
		return source;
	}

	public TreeFigureExpansionEvent(Object source) {
		this.source = source;
	}
}
