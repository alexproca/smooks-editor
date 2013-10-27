/**
 * 
 */
package org.jboss.tools.smooks.gef.tree.figures;


/**
 * @author DartPeng
 *
 */
public interface ITreeFigureListener {
	  /**
     * Notifies that a node in the tree has been collapsed.
     *
     * @param event event object describing details
     */
    public void treeCollapsed(TreeFigureExpansionEvent event);

    /**
     * Notifies that a node in the tree has been expanded.
     *
     * @param event event object describing details
     */
    public void treeExpanded(TreeFigureExpansionEvent event);
}
