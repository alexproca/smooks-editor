/**
 * 
 */
package org.jboss.tools.smooks.configuration.editors.xml;

/**
 * @author Dart Peng Date : 2008-8-16
 */
public class XMLStructuredDataWizardPage extends AbstractFileSelectionWizardPage {

	public XMLStructuredDataWizardPage(String pageName) {
		super(pageName,new String[]{"xml","xsd","wsdl","xsl"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		setPageText();
	}

	private void setPageText() {
		this.setTitle("XML File"); //$NON-NLS-1$
		this.setDescription("Select XML File"); //$NON-NLS-1$

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.tools.smooks.xml.ui.AbstractFileSelectionWizardPage#loadedTheObject
	 * (java.lang.String)
	 */
	@Override
	protected Object loadedTheObject(String path) throws Exception {
		return null;
//		XMLObjectAnalyzer analyzer = new XMLObjectAnalyzer();
//		TagList doc = analyzer.analyze(path, null);
//		return doc;
	}
}
