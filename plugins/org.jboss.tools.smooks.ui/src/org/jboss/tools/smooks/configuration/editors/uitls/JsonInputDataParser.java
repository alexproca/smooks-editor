/**
 * 
 */
package org.jboss.tools.smooks.configuration.editors.uitls;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;

import org.jboss.tools.smooks.configuration.editors.IXMLStructuredObject;
import org.jboss.tools.smooks.configuration.editors.xml.TagList;
import org.jboss.tools.smooks.configuration.editors.xml.XMLObjectAnalyzer;
import org.jboss.tools.smooks.model.json12.Json12Package;
import org.jboss.tools.smooks.model.json12.Json12Reader;
import org.jboss.tools.smooks.model.smooks.AbstractReader;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;
import org.milyn.Smooks;
import org.milyn.cdr.Parameter;
import org.milyn.json.JSONReaderConfigurator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author Dart
 * 
 */
public class JsonInputDataParser {

	public static final String LINK_JSON_READER = "linkJSONReader"; //$NON-NLS-1$
	public static final String KEY = "_key_"; //$NON-NLS-1$
	public static final String NULL_REPLACE = "nullReplace"; //$NON-NLS-1$
	public static final String ENCODING2 = "encoding"; //$NON-NLS-1$
	public static final String SPACE_REPLACE = "spaceReplace"; //$NON-NLS-1$
	public static final String PREFIX_ON_NUMERIC = "prefixOnNumeric"; //$NON-NLS-1$
	public static final String ILLEGAL_REPLACE = "illegalReplace"; //$NON-NLS-1$
	public static final String INDENT = "indent"; //$NON-NLS-1$
	public static final String ARRAY_ELEMENT_NAME = "arrayElementName"; //$NON-NLS-1$
	public static final String ROOT_NAME = "rootName"; //$NON-NLS-1$

	public IXMLStructuredObject parseJsonFile(InputStream inputStream, Object readerObj)
			throws ParserConfigurationException {
		String rootName = null;
		String arrayElementName = null;
		String keyWhitspaceReplacement = null;
		String keyPrefixOnNumeric = null;
		String illegalElementNameCharReplacement = null;
		String nullValueReplacement = null;
		String encoding = null;
		String indent = null;
		Map<String, String> keyMap = new HashMap<String, String>();
		if (readerObj == null)
			return null;
		// if (readerObj instanceof JsonReader) {
		// JsonReader reader = (JsonReader) readerObj;
		// rootName = reader.getRootName();
		// arrayElementName = reader.getArrayElementName();
		// keyPrefixOnNumeric = reader.getKeyPrefixOnNumeric();
		// keyWhitspaceReplacement = reader.getKeyWhitspaceReplacement();
		// illegalElementNameCharReplacement =
		// reader.getIllegalElementNameCharReplacement();
		// nullValueReplacement = reader.getNullValueReplacement();
		// encoding = reader.getEncoding();
		// KeyMap km = reader.getKeyMap();
		// if (km != null) {
		// List<Key> keyList = km.getKey();
		// for (Iterator<?> iterator = keyList.iterator(); iterator.hasNext();)
		// {
		// Key key = (Key) iterator.next();
		// keyMap.put(key.getFrom(), key.getTo());
		// }
		// }
		// }

		if (readerObj instanceof Json12Reader) {
			Json12Reader reader = (Json12Reader) readerObj;
			rootName = reader.getRootName();
			arrayElementName = reader.getArrayElementName();
			keyPrefixOnNumeric = reader.getKeyPrefixOnNumeric();
			keyWhitspaceReplacement = reader.getKeyWhitspaceReplacement();
			illegalElementNameCharReplacement = reader.getIllegalElementNameCharReplacement();
			nullValueReplacement = reader.getNullValueReplacement();
			encoding = reader.getEncoding();
			boolean isSet = reader.eIsSet(Json12Package.Literals.JSON12_READER__INDENT);
			if (isSet) {
				indent = String.valueOf(reader.isIndent());
			}
			org.jboss.tools.smooks.model.json12.KeyMap km = reader.getKeyMap();
			if (km != null) {
				List<?> keyList = km.getKey();
				for (Iterator<?> iterator = keyList.iterator(); iterator.hasNext();) {
					org.jboss.tools.smooks.model.json12.Key key = (org.jboss.tools.smooks.model.json12.Key) iterator
							.next();
					keyMap.put(key.getFrom(), key.getTo());
				}
			}
		}

		return this.parseJsonFile(inputStream, rootName, arrayElementName, keyWhitspaceReplacement, keyPrefixOnNumeric,
				illegalElementNameCharReplacement, nullValueReplacement, keyMap, indent, encoding);
	}

	public IXMLStructuredObject parseJsonFile(InputStream stream, SmooksResourceListType resourceList)
			throws FileNotFoundException, ParserConfigurationException, InvocationTargetException {

		List<AbstractReader> readers = resourceList.getAbstractReader();
		int count = 0;
		int index = -1;
		for (Iterator<?> iterator2 = readers.iterator(); iterator2.hasNext();) {
			AbstractReader abstractReader = (AbstractReader) iterator2.next();
			if (abstractReader instanceof Json12Reader) {
				count++;
				if (index == -1) {
					index = readers.indexOf(abstractReader);
				}
			}
		}

		if (count > 1) {
			// throw new
			// RuntimeException("The smooks config file should have only one JSON reader");
		}
		if (index != -1) {
			return parseJsonFile(stream, readers.get(index));
		}
		return null;
	}

	public IXMLStructuredObject parseJsonFile(String filePath, SmooksResourceListType resourceList)
			throws FileNotFoundException, ParserConfigurationException, InvocationTargetException {
		FileInputStream stream = new FileInputStream(filePath);
		return this.parseJsonFile(stream, resourceList);
	}

	public IXMLStructuredObject parseJsonFile(String filePath, String rootName, String arrayElementName,
			String keyWhitspaceReplacement, String keyPrefixOnNumeric, String illegalElementNameCharReplacement,
			String nullValueReplacement, Map<String, String> keyMap, String indent, String encoding)
			throws FileNotFoundException, ParserConfigurationException, InvocationTargetException {
		return this.parseJsonFile(new FileInputStream(SmooksUIUtils.parseFilePath(filePath)), rootName,
				arrayElementName, keyWhitspaceReplacement, keyPrefixOnNumeric, illegalElementNameCharReplacement,
				nullValueReplacement, keyMap, indent, encoding);
	}

	public IXMLStructuredObject parseJsonFile(InputStream inputStream, String rootName, String arrayElementName,
			String keyWhitspaceReplacement, String keyPrefixOnNumeric, String illegalElementNameCharReplacement,
			String nullValueReplacement, Map<String, String> keyMap, String indent, String encoding)
			throws ParserConfigurationException {

		Smooks smooks = new Smooks();

		JSONReaderConfigurator readerConfig = new JSONReaderConfigurator();
		if (arrayElementName != null) {
			readerConfig.setArrayElementName(arrayElementName);
		}
		if (rootName != null) {
			readerConfig.setRootName(rootName);
		}
		if (keyWhitspaceReplacement != null) {
			readerConfig.setKeyWhitspaceReplacement(keyWhitspaceReplacement);
		}
		if (keyPrefixOnNumeric != null) {
			readerConfig.setKeyPrefixOnNumeric(keyPrefixOnNumeric);
		}
		if (illegalElementNameCharReplacement != null) {
			readerConfig.setIllegalElementNameCharReplacement(illegalElementNameCharReplacement);
		}
		if (nullValueReplacement != null) {
			readerConfig.setNullValueReplacement(nullValueReplacement);
		}

		if (keyMap != null) {
			readerConfig.setKeyMap(keyMap);
		}

		readerConfig.setEncoding(Charset.forName(encoding));

		if (indent != null) {
			// readerConfig.set
		}

		// readerConfig.setParameter(ENCODING2, encoding);

		smooks.setReaderConfig(readerConfig);

		// Use a DOM result to capture the message model for the supplied CSV
		// message...
		DOMResult result = new DOMResult();

		// Filter the message through Smooks and capture the result as a DOM in
		// the domResult instance...
		smooks.filterSource(new StreamSource(inputStream), result);

		Document document = (Document) result.getNode();

		XMLObjectAnalyzer analyzer = new XMLObjectAnalyzer();
		TagList tagList = analyzer.analyze(document, null , null);

		try {
			if (smooks != null) {
				smooks.close();
				smooks = null;
			}
			if (inputStream != null) {
				inputStream.close();
				inputStream = null;
			}
			result = null;
		} catch (Throwable t) {
			// ignore
			// t.printStackTrace();
		}

		return tagList;
	}

	protected Parameter keyMapToParameter(Map<String, String> keyMap) throws ParserConfigurationException {
		Parameter keyMapParam = new Parameter("keyMap", "dummyVal"); //$NON-NLS-1$ //$NON-NLS-2$
		DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Element keyMapElement = docBuilder.newDocument().createElement("keyMap"); //$NON-NLS-1$
		Set<Map.Entry<String, String>> keyMapEntries = keyMap.entrySet();

		for (Map.Entry<String, String> keyMapEntry : keyMapEntries) {
			Element keyElement = keyMapElement.getOwnerDocument().createElementNS("*", "key"); //$NON-NLS-1$ //$NON-NLS-2$
			keyElement.setAttribute("from", keyMapEntry.getKey()); //$NON-NLS-1$
			keyElement.setAttribute("to", keyMapEntry.getValue()); //$NON-NLS-1$
			keyMapElement.appendChild(keyElement);
		}

		keyMapParam.setXML(keyMapElement);

		return keyMapParam;
	}
}
