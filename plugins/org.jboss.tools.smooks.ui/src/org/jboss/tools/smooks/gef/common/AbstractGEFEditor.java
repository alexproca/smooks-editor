/**
 * 
 */
package org.jboss.tools.smooks.gef.common;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.editparts.FreeformGraphicalRootEditPart;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.parts.GraphicalEditorWithPalette;

/**
 * @author DartPeng
 *
 */
public class AbstractGEFEditor extends GraphicalEditorWithPalette {
	
	private DefaultEditDomain editDomain = null;
	protected Object rootModel;
	private EditPartFactory editPartFactory;

	public AbstractGEFEditor(){
		super();
		editDomain = createEditDomain();
		setEditDomain(editDomain);
	}
	
	protected DefaultEditDomain createEditDomain(){
		return new DefaultEditDomain(this);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.ui.parts.GraphicalEditorWithPalette#getPaletteRoot()
	 */
	@Override
	protected PaletteRoot getPaletteRoot() {
		return createPaletteRoot();
	}
	
	protected PaletteRoot createPaletteRoot(){
		return new PaletteRoot();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#initializeGraphicalViewer()
	 */
	@Override
	protected void initializeGraphicalViewer() {
		rootModel = createGraphicalModel();
		getGraphicalViewer().setContents(rootModel);
	}

	protected Object createGraphicalModel() {
		return null;
	}

	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		getGraphicalViewer().setRootEditPart(new FreeformGraphicalRootEditPart());
		editPartFactory = createEditPartFactory();
		getGraphicalViewer().setEditPartFactory(editPartFactory);
	}

	protected EditPartFactory createEditPartFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorPart#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {

	}

}
