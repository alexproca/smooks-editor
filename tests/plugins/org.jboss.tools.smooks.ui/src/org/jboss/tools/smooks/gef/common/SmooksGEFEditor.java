/**
 * 
 */
package org.jboss.tools.smooks.gef.common;

import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.palette.PaletteRoot;

/**
 * @author DartPeng
 * 
 */
public class SmooksGEFEditor extends AbstractGEFEditor {

	@Override
	protected EditPartFactory createEditPartFactory() {
		return new SmooksGEFEditFactory();
	}

	@Override
	protected PaletteRoot createPaletteRoot() {
		return new PaletteRoot();
	}

	@Override
	protected Object createGraphicalModel() {
//		RootModel rootModel = new RootModel();
//		JavaBeanModel beanModel = JavaBeanModelFactory
//				.getJavaBeanModelWithLazyLoad(Order.class);
//		beanModel.setFlat(true);
//
//		JavaBeanModel beanModel1 = JavaBeanModelFactory
//				.getJavaBeanModelWithLazyLoad(Header.class);
//		beanModel1.setFlat(true);
//		beanModel.setFlat(true);
//		
//		TreeContainerModel container = new TreeContainerModel(beanModel,
//				new JavabeanContentProvider(), new JavabeanlabelProvider());
//		container.setHeaderVisable(true);
//		
//		TreeContainerModel container1 = new TreeContainerModel(beanModel1,
//				new JavabeanContentProvider(), new JavabeanlabelProvider());
//		container1.setHeaderVisable(true);
//		
//		AbstractXMLObject model = null;
//		try {
//			InputStream stream = getClass().getResourceAsStream(
//					"/org/jboss/tools/smooks/gef/order-01.xml");
//			model = new XMLObjectAnalyzer().analyze(stream, null);
//		} catch (DocumentException e) {
//			e.printStackTrace();
//		}
//
//		TreeContainerModel container2 = new TreeContainerModel(model,
//				new XMLStructuredDataContentProvider(),
//				new XMLStructuredDataLabelProvider());
//		container2.setLinkable(false);
//
//		container1.setSourceLinkNode(false);
//		container.setSourceLinkNode(false);
//		container2.setSourceLinkNode(true);
//		
//		rootModel.getChildren().add(container);
//		rootModel.getChildren().add(container2);
//		rootModel.getChildren().add(container1);
		return null;
	}
}