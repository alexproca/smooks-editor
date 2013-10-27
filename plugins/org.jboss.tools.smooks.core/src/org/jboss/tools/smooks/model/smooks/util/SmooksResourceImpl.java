/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.smooks.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.DOMHandler;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.jboss.tools.smooks.model.common.AbstractAnyType;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

/**
 * <!-- begin-user-doc --> The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * 
 * @see org.jboss.tools.smooks.model.smooks.util.SmooksResourceFactoryImpl
 * @generated
 */
public class SmooksResourceImpl extends XMLResourceImpl {
	/**
	 * Creates an instance of the resource. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param uri
	 *            the URI of the new resource.
	 * @generated
	 */
	public SmooksResourceImpl(URI uri) {
		super(uri);
	}
	
	

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl#doLoad(org.xml.sax.InputSource, java.util.Map)
	 */
	@Override
	public void doLoad(InputSource inputSource, Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub
		super.doLoad(inputSource, options);
	}



	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl#doLoad(java.io.InputStream, java.util.Map)
	 */
	@Override
	public void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		super.doLoad(inputStream, options);
		unlockCommentIndexChange(getContents());
	}
	
	protected void unlockCommentIndexChange(List<EObject> objs){
		for (Iterator<?> iterator = objs.iterator(); iterator.hasNext();) {
			EObject eObject = (EObject) iterator.next();
			if(eObject instanceof AbstractAnyType){
				((AbstractAnyType)eObject).setLockCOmmentIndexChange(false);
			}
			unlockCommentIndexChange(eObject.eContents());
		}
	}



	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl#doLoad(org.w3c.dom.Node, java.util.Map)
	 */
	@Override
	public void doLoad(Node node, Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub
		super.doLoad(node, options);
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl#doSave(java.io.OutputStream
	 * , java.util.Map)
	 */
	@Override
	public void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		super.doSave(outputStream, options);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl#save(org.w3c.dom.Document,
	 * java.util.Map, org.eclipse.emf.ecore.xmi.DOMHandler)
	 */
	@Override
	public Document save(Document doc, Map<?, ?> options, DOMHandler handler) {
		return super.save(doc, options, handler);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.resource.impl.ResourceImpl#save(java.util.Map)
	 */
	@Override
	public void save(Map<?, ?> options) throws IOException {
		// IResource resource = getResource(this);
		// if (resource != null && resource.exists() && (resource instanceof
		// IFile)) {
		// ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		// doSave(outputStream, options);
		//			
		// try {
		// ((IFile) resource).setContents(new
		// ByteArrayInputStream(outputStream.toByteArray()), true, false, null);
		// } catch (CoreException e) {
		// throw new IOException(e.getMessage());
		// }
		// } else {
		super.save(options);
		// }
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl#doSave(java.io.Writer,
	 * java.util.Map)
	 */
	@Override
	public void doSave(Writer writer, Map<?, ?> options) throws IOException {
		super.doSave(writer, options);
	}

} // SmooksResourceImpl
