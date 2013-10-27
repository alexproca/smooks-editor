/**
 * 
 */
package org.jboss.tools.smooks.graphical.editors.editparts;

import org.eclipse.gef.tools.MarqueeDragTracker;

/**
 * @author Dart
 *
 */
public class RightClickSelectMarqueeDragTraker extends MarqueeDragTracker{

	@Override
	protected boolean handleButtonUp(int button) {
		int state = getState();
		setState(STATE_DRAG_IN_PROGRESS);
		boolean flag = super.handleButtonUp(button);
		setState(state);
		return flag;
	}

}
