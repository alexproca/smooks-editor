/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.csv12.impl;


import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.jboss.tools.smooks.model.csv12.Binding;
import org.jboss.tools.smooks.model.csv12.CSV12Reader;
import org.jboss.tools.smooks.model.csv12.Csv12Package;
import org.jboss.tools.smooks.model.csv12.MapBinding;
import org.jboss.tools.smooks.model.smooks.impl.AbstractReaderImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CSV12 Reader</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.csv12.impl.CSV12ReaderImpl#getSingleBinding <em>Single Binding</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.csv12.impl.CSV12ReaderImpl#getListBinding <em>List Binding</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.csv12.impl.CSV12ReaderImpl#getMapBinding <em>Map Binding</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.csv12.impl.CSV12ReaderImpl#getEncoding <em>Encoding</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.csv12.impl.CSV12ReaderImpl#getFields <em>Fields</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.csv12.impl.CSV12ReaderImpl#isIndent <em>Indent</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.csv12.impl.CSV12ReaderImpl#getQuote <em>Quote</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.csv12.impl.CSV12ReaderImpl#getRecordElementName <em>Record Element Name</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.csv12.impl.CSV12ReaderImpl#getRootElementName <em>Root Element Name</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.csv12.impl.CSV12ReaderImpl#getSeparator <em>Separator</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.csv12.impl.CSV12ReaderImpl#getSkipLines <em>Skip Lines</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CSV12ReaderImpl extends AbstractReaderImpl implements CSV12Reader {
	/**
	 * The cached value of the '{@link #getSingleBinding() <em>Single Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingleBinding()
	 * @generated
	 * @ordered
	 */
	protected Binding singleBinding;

	/**
	 * The cached value of the '{@link #getListBinding() <em>List Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getListBinding()
	 * @generated
	 * @ordered
	 */
	protected Binding listBinding;

	/**
	 * The cached value of the '{@link #getMapBinding() <em>Map Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapBinding()
	 * @generated
	 * @ordered
	 */
	protected MapBinding mapBinding;

	/**
	 * The default value of the '{@link #getEncoding() <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEncoding()
	 * @generated
	 * @ordered
	 */
	protected static final String ENCODING_EDEFAULT = "UTF-8"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getEncoding() <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEncoding()
	 * @generated
	 * @ordered
	 */
	protected String encoding = ENCODING_EDEFAULT;

	/**
	 * This is true if the Encoding attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean encodingESet;

	/**
	 * The default value of the '{@link #getFields() <em>Fields</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFields()
	 * @generated
	 * @ordered
	 */
	protected static final String FIELDS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFields() <em>Fields</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFields()
	 * @generated
	 * @ordered
	 */
	protected String fields = FIELDS_EDEFAULT;

	/**
	 * The default value of the '{@link #isIndent() <em>Indent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIndent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INDENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIndent() <em>Indent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIndent()
	 * @generated
	 * @ordered
	 */
	protected boolean indent = INDENT_EDEFAULT;

	/**
	 * This is true if the Indent attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean indentESet;

	/**
	 * The default value of the '{@link #getQuote() <em>Quote</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuote()
	 * @generated
	 * @ordered
	 */
	protected static final String QUOTE_EDEFAULT = "\""; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getQuote() <em>Quote</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuote()
	 * @generated
	 * @ordered
	 */
	protected String quote = QUOTE_EDEFAULT;

	/**
	 * This is true if the Quote attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean quoteESet;

	/**
	 * The default value of the '{@link #getRecordElementName() <em>Record Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecordElementName()
	 * @generated
	 * @ordered
	 */
	protected static final String RECORD_ELEMENT_NAME_EDEFAULT = "csv-record"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getRecordElementName() <em>Record Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecordElementName()
	 * @generated
	 * @ordered
	 */
	protected String recordElementName = RECORD_ELEMENT_NAME_EDEFAULT;

	/**
	 * This is true if the Record Element Name attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean recordElementNameESet;

	/**
	 * The default value of the '{@link #getRootElementName() <em>Root Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootElementName()
	 * @generated
	 * @ordered
	 */
	protected static final String ROOT_ELEMENT_NAME_EDEFAULT = "csv-set"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getRootElementName() <em>Root Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootElementName()
	 * @generated
	 * @ordered
	 */
	protected String rootElementName = ROOT_ELEMENT_NAME_EDEFAULT;

	/**
	 * This is true if the Root Element Name attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean rootElementNameESet;

	/**
	 * The default value of the '{@link #getSeparator() <em>Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeparator()
	 * @generated
	 * @ordered
	 */
	protected static final String SEPARATOR_EDEFAULT = ","; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getSeparator() <em>Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeparator()
	 * @generated
	 * @ordered
	 */
	protected String separator = SEPARATOR_EDEFAULT;

	/**
	 * This is true if the Separator attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean separatorESet;

	/**
	 * The default value of the '{@link #getSkipLines() <em>Skip Lines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSkipLines()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger SKIP_LINES_EDEFAULT = new BigInteger("0"); //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getSkipLines() <em>Skip Lines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSkipLines()
	 * @generated
	 * @ordered
	 */
	protected BigInteger skipLines = SKIP_LINES_EDEFAULT;

	/**
	 * This is true if the Skip Lines attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean skipLinesESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CSV12ReaderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Csv12Package.Literals.CSV12_READER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Binding getSingleBinding() {
		return singleBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSingleBinding(Binding newSingleBinding, NotificationChain msgs) {
		Binding oldSingleBinding = singleBinding;
		singleBinding = newSingleBinding;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Csv12Package.CSV12_READER__SINGLE_BINDING, oldSingleBinding, newSingleBinding);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSingleBinding(Binding newSingleBinding) {
		if (newSingleBinding != singleBinding) {
			NotificationChain msgs = null;
			if (singleBinding != null)
				msgs = ((InternalEObject)singleBinding).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Csv12Package.CSV12_READER__SINGLE_BINDING, null, msgs);
			if (newSingleBinding != null)
				msgs = ((InternalEObject)newSingleBinding).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Csv12Package.CSV12_READER__SINGLE_BINDING, null, msgs);
			msgs = basicSetSingleBinding(newSingleBinding, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Csv12Package.CSV12_READER__SINGLE_BINDING, newSingleBinding, newSingleBinding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Binding getListBinding() {
		return listBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetListBinding(Binding newListBinding, NotificationChain msgs) {
		Binding oldListBinding = listBinding;
		listBinding = newListBinding;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Csv12Package.CSV12_READER__LIST_BINDING, oldListBinding, newListBinding);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setListBinding(Binding newListBinding) {
		if (newListBinding != listBinding) {
			NotificationChain msgs = null;
			if (listBinding != null)
				msgs = ((InternalEObject)listBinding).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Csv12Package.CSV12_READER__LIST_BINDING, null, msgs);
			if (newListBinding != null)
				msgs = ((InternalEObject)newListBinding).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Csv12Package.CSV12_READER__LIST_BINDING, null, msgs);
			msgs = basicSetListBinding(newListBinding, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Csv12Package.CSV12_READER__LIST_BINDING, newListBinding, newListBinding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MapBinding getMapBinding() {
		return mapBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMapBinding(MapBinding newMapBinding, NotificationChain msgs) {
		MapBinding oldMapBinding = mapBinding;
		mapBinding = newMapBinding;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Csv12Package.CSV12_READER__MAP_BINDING, oldMapBinding, newMapBinding);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapBinding(MapBinding newMapBinding) {
		if (newMapBinding != mapBinding) {
			NotificationChain msgs = null;
			if (mapBinding != null)
				msgs = ((InternalEObject)mapBinding).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Csv12Package.CSV12_READER__MAP_BINDING, null, msgs);
			if (newMapBinding != null)
				msgs = ((InternalEObject)newMapBinding).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Csv12Package.CSV12_READER__MAP_BINDING, null, msgs);
			msgs = basicSetMapBinding(newMapBinding, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Csv12Package.CSV12_READER__MAP_BINDING, newMapBinding, newMapBinding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEncoding(String newEncoding) {
		String oldEncoding = encoding;
		encoding = newEncoding;
		boolean oldEncodingESet = encodingESet;
		encodingESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Csv12Package.CSV12_READER__ENCODING, oldEncoding, encoding, !oldEncodingESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEncoding() {
		String oldEncoding = encoding;
		boolean oldEncodingESet = encodingESet;
		encoding = ENCODING_EDEFAULT;
		encodingESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Csv12Package.CSV12_READER__ENCODING, oldEncoding, ENCODING_EDEFAULT, oldEncodingESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEncoding() {
		return encodingESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFields() {
		return fields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFields(String newFields) {
		String oldFields = fields;
		fields = newFields;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Csv12Package.CSV12_READER__FIELDS, oldFields, fields));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIndent() {
		return indent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndent(boolean newIndent) {
		boolean oldIndent = indent;
		indent = newIndent;
		boolean oldIndentESet = indentESet;
		indentESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Csv12Package.CSV12_READER__INDENT, oldIndent, indent, !oldIndentESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIndent() {
		boolean oldIndent = indent;
		boolean oldIndentESet = indentESet;
		indent = INDENT_EDEFAULT;
		indentESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Csv12Package.CSV12_READER__INDENT, oldIndent, INDENT_EDEFAULT, oldIndentESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIndent() {
		return indentESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQuote() {
		return quote;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuote(String newQuote) {
		String oldQuote = quote;
		quote = newQuote;
		boolean oldQuoteESet = quoteESet;
		quoteESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Csv12Package.CSV12_READER__QUOTE, oldQuote, quote, !oldQuoteESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetQuote() {
		String oldQuote = quote;
		boolean oldQuoteESet = quoteESet;
		quote = QUOTE_EDEFAULT;
		quoteESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Csv12Package.CSV12_READER__QUOTE, oldQuote, QUOTE_EDEFAULT, oldQuoteESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetQuote() {
		return quoteESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRecordElementName() {
		return recordElementName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecordElementName(String newRecordElementName) {
		String oldRecordElementName = recordElementName;
		recordElementName = newRecordElementName;
		boolean oldRecordElementNameESet = recordElementNameESet;
		recordElementNameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Csv12Package.CSV12_READER__RECORD_ELEMENT_NAME, oldRecordElementName, recordElementName, !oldRecordElementNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRecordElementName() {
		String oldRecordElementName = recordElementName;
		boolean oldRecordElementNameESet = recordElementNameESet;
		recordElementName = RECORD_ELEMENT_NAME_EDEFAULT;
		recordElementNameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Csv12Package.CSV12_READER__RECORD_ELEMENT_NAME, oldRecordElementName, RECORD_ELEMENT_NAME_EDEFAULT, oldRecordElementNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRecordElementName() {
		return recordElementNameESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRootElementName() {
		return rootElementName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootElementName(String newRootElementName) {
		String oldRootElementName = rootElementName;
		rootElementName = newRootElementName;
		boolean oldRootElementNameESet = rootElementNameESet;
		rootElementNameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Csv12Package.CSV12_READER__ROOT_ELEMENT_NAME, oldRootElementName, rootElementName, !oldRootElementNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRootElementName() {
		String oldRootElementName = rootElementName;
		boolean oldRootElementNameESet = rootElementNameESet;
		rootElementName = ROOT_ELEMENT_NAME_EDEFAULT;
		rootElementNameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Csv12Package.CSV12_READER__ROOT_ELEMENT_NAME, oldRootElementName, ROOT_ELEMENT_NAME_EDEFAULT, oldRootElementNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRootElementName() {
		return rootElementNameESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSeparator() {
		return separator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeparator(String newSeparator) {
		String oldSeparator = separator;
		separator = newSeparator;
		boolean oldSeparatorESet = separatorESet;
		separatorESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Csv12Package.CSV12_READER__SEPARATOR, oldSeparator, separator, !oldSeparatorESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSeparator() {
		String oldSeparator = separator;
		boolean oldSeparatorESet = separatorESet;
		separator = SEPARATOR_EDEFAULT;
		separatorESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Csv12Package.CSV12_READER__SEPARATOR, oldSeparator, SEPARATOR_EDEFAULT, oldSeparatorESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSeparator() {
		return separatorESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getSkipLines() {
		return skipLines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSkipLines(BigInteger newSkipLines) {
		BigInteger oldSkipLines = skipLines;
		skipLines = newSkipLines;
		boolean oldSkipLinesESet = skipLinesESet;
		skipLinesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Csv12Package.CSV12_READER__SKIP_LINES, oldSkipLines, skipLines, !oldSkipLinesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSkipLines() {
		BigInteger oldSkipLines = skipLines;
		boolean oldSkipLinesESet = skipLinesESet;
		skipLines = SKIP_LINES_EDEFAULT;
		skipLinesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Csv12Package.CSV12_READER__SKIP_LINES, oldSkipLines, SKIP_LINES_EDEFAULT, oldSkipLinesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSkipLines() {
		return skipLinesESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Csv12Package.CSV12_READER__SINGLE_BINDING:
				return basicSetSingleBinding(null, msgs);
			case Csv12Package.CSV12_READER__LIST_BINDING:
				return basicSetListBinding(null, msgs);
			case Csv12Package.CSV12_READER__MAP_BINDING:
				return basicSetMapBinding(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Csv12Package.CSV12_READER__SINGLE_BINDING:
				return getSingleBinding();
			case Csv12Package.CSV12_READER__LIST_BINDING:
				return getListBinding();
			case Csv12Package.CSV12_READER__MAP_BINDING:
				return getMapBinding();
			case Csv12Package.CSV12_READER__ENCODING:
				return getEncoding();
			case Csv12Package.CSV12_READER__FIELDS:
				return getFields();
			case Csv12Package.CSV12_READER__INDENT:
				return isIndent() ? Boolean.TRUE : Boolean.FALSE;
			case Csv12Package.CSV12_READER__QUOTE:
				return getQuote();
			case Csv12Package.CSV12_READER__RECORD_ELEMENT_NAME:
				return getRecordElementName();
			case Csv12Package.CSV12_READER__ROOT_ELEMENT_NAME:
				return getRootElementName();
			case Csv12Package.CSV12_READER__SEPARATOR:
				return getSeparator();
			case Csv12Package.CSV12_READER__SKIP_LINES:
				return getSkipLines();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Csv12Package.CSV12_READER__SINGLE_BINDING:
				setSingleBinding((Binding)newValue);
				return;
			case Csv12Package.CSV12_READER__LIST_BINDING:
				setListBinding((Binding)newValue);
				return;
			case Csv12Package.CSV12_READER__MAP_BINDING:
				setMapBinding((MapBinding)newValue);
				return;
			case Csv12Package.CSV12_READER__ENCODING:
				setEncoding((String)newValue);
				return;
			case Csv12Package.CSV12_READER__FIELDS:
				setFields((String)newValue);
				return;
			case Csv12Package.CSV12_READER__INDENT:
				setIndent(((Boolean)newValue).booleanValue());
				return;
			case Csv12Package.CSV12_READER__QUOTE:
				setQuote((String)newValue);
				return;
			case Csv12Package.CSV12_READER__RECORD_ELEMENT_NAME:
				setRecordElementName((String)newValue);
				return;
			case Csv12Package.CSV12_READER__ROOT_ELEMENT_NAME:
				setRootElementName((String)newValue);
				return;
			case Csv12Package.CSV12_READER__SEPARATOR:
				setSeparator((String)newValue);
				return;
			case Csv12Package.CSV12_READER__SKIP_LINES:
				setSkipLines((BigInteger)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case Csv12Package.CSV12_READER__SINGLE_BINDING:
				setSingleBinding((Binding)null);
				return;
			case Csv12Package.CSV12_READER__LIST_BINDING:
				setListBinding((Binding)null);
				return;
			case Csv12Package.CSV12_READER__MAP_BINDING:
				setMapBinding((MapBinding)null);
				return;
			case Csv12Package.CSV12_READER__ENCODING:
				unsetEncoding();
				return;
			case Csv12Package.CSV12_READER__FIELDS:
				setFields(FIELDS_EDEFAULT);
				return;
			case Csv12Package.CSV12_READER__INDENT:
				unsetIndent();
				return;
			case Csv12Package.CSV12_READER__QUOTE:
				unsetQuote();
				return;
			case Csv12Package.CSV12_READER__RECORD_ELEMENT_NAME:
				unsetRecordElementName();
				return;
			case Csv12Package.CSV12_READER__ROOT_ELEMENT_NAME:
				unsetRootElementName();
				return;
			case Csv12Package.CSV12_READER__SEPARATOR:
				unsetSeparator();
				return;
			case Csv12Package.CSV12_READER__SKIP_LINES:
				unsetSkipLines();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Csv12Package.CSV12_READER__SINGLE_BINDING:
				return singleBinding != null;
			case Csv12Package.CSV12_READER__LIST_BINDING:
				return listBinding != null;
			case Csv12Package.CSV12_READER__MAP_BINDING:
				return mapBinding != null;
			case Csv12Package.CSV12_READER__ENCODING:
				return isSetEncoding();
			case Csv12Package.CSV12_READER__FIELDS:
				return FIELDS_EDEFAULT == null ? fields != null : !FIELDS_EDEFAULT.equals(fields);
			case Csv12Package.CSV12_READER__INDENT:
				return isSetIndent();
			case Csv12Package.CSV12_READER__QUOTE:
				return isSetQuote();
			case Csv12Package.CSV12_READER__RECORD_ELEMENT_NAME:
				return isSetRecordElementName();
			case Csv12Package.CSV12_READER__ROOT_ELEMENT_NAME:
				return isSetRootElementName();
			case Csv12Package.CSV12_READER__SEPARATOR:
				return isSetSeparator();
			case Csv12Package.CSV12_READER__SKIP_LINES:
				return isSetSkipLines();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (encoding: "); //$NON-NLS-1$
		if (encodingESet) result.append(encoding); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", fields: "); //$NON-NLS-1$
		result.append(fields);
		result.append(", indent: "); //$NON-NLS-1$
		if (indentESet) result.append(indent); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", quote: "); //$NON-NLS-1$
		if (quoteESet) result.append(quote); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", recordElementName: "); //$NON-NLS-1$
		if (recordElementNameESet) result.append(recordElementName); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", rootElementName: "); //$NON-NLS-1$
		if (rootElementNameESet) result.append(rootElementName); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", separator: "); //$NON-NLS-1$
		if (separatorESet) result.append(separator); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", skipLines: "); //$NON-NLS-1$
		if (skipLinesESet) result.append(skipLines); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //CSV12ReaderImpl
