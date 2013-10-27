/*******************************************************************************
 * Copyright (c) 2007 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.smooks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.jboss.tools.smooks.core.SmooksInputType;
import org.jboss.tools.smooks.model.freemarker.Freemarker;
import org.jboss.tools.smooks.model.smooks.AbstractResourceConfig;
import org.jboss.tools.smooks.model.smooks.ConditionType;
import org.jboss.tools.smooks.model.smooks.ConditionsType;
import org.jboss.tools.smooks.model.smooks.SmooksResourceListType;

/**
 * @author Dart Peng
 * 
 */

public class SmooksModelUtils {

	public static final String KEY_TEMPLATE_TYPE = "messageType"; //$NON-NLS-1$

	public static final String TEMPLATE_DATA_PROVIDER_PARAM_NAME = "templateDataProvider"; //$NON-NLS-1$
	
	public static final String FREEMARKER_TEMPLATE_TYPE_CSV = "CSV"; //$NON-NLS-1$

	public static final String FREEMARKER_TEMPLATE_TYPE_XML = "XML"; //$NON-NLS-1$

	public static final String KEY_CSV_FIELDS = "csvFields"; //$NON-NLS-1$

	public static final String KEY_INCLUDE_FIELD_NAMES = "includeFieldNames"; //$NON-NLS-1$

	public static final String KEY_TASK_ID_REF = "idref"; //$NON-NLS-1$

	public static final String KEY_OBJECT_ID = "id"; //$NON-NLS-1$

	public static final String KEY_XML_FILE_TYPE = "modelSrcType"; //$NON-NLS-1$

	public static final String KEY_XML_FILE_PATH = "modelSrc"; //$NON-NLS-1$

	public static final String KEY_XML_ROOT_NAME = "rootElementName"; //$NON-NLS-1$

	public static final String KEY_XML_FILE_TYPE_XSD = "XSD"; //$NON-NLS-1$

	public static final String KEY_XML_FILE_TYPE_XML = "XML"; //$NON-NLS-1$

	public static final String KEY_CSV_SEPERATOR = "seperator"; //$NON-NLS-1$

	public static final String KEY_CSV_QUOTE = "quote"; //$NON-NLS-1$

	public static final String INPUT_TYPE_JAVA = SmooksInputType.INPUT_TYPE_JAVA;

	public static final String INPUT_TYPE = "inputType"; //$NON-NLS-1$

	public static final String INPUT_TYPE_CUSTOME = SmooksInputType.INPUT_TYPE_CUSTOM;

	public static final String INPUT_TYPE_JSON_1_1 = SmooksInputType.INPUT_TYPE_JSON;

	public static final String INPUT_TYPE_CSV = SmooksInputType.INPUT_TYPE_CSV;

	public static final String INPUT_ACTIVE_TYPE = "input.type.actived"; //$NON-NLS-1$

	public static final String INPUT_DEACTIVE_TYPE = "input.type.deactived"; //$NON-NLS-1$

	public static final String INPUT_TYPE_CSV_1_2 = SmooksInputType.INPUT_TYPE_CSV;

	public static final String PARAM_NAME_CLASS = "class"; //$NON-NLS-1$

	public static final String PARAM_NAME_PATH = "path"; //$NON-NLS-1$

	public static final String PARAM_NAME_ACTIVED = "actived"; //$NON-NLS-1$

	public static final String INPUT_TYPE_XML = SmooksInputType.INPUT_TYPE_XML;

	public static final String INPUT_TYPE_XSD = SmooksInputType.INPUT_TYPE_XSD;

	public static final String TYPE_XSL = "xsl"; //$NON-NLS-1$

	public static final String[] TEMPLATE_TYPES = new String[] { "xsl", "ftl" }; //$NON-NLS-1$ //$NON-NLS-2$

	public static final String BEAN_CLASS = "beanClass"; //$NON-NLS-1$

	public static final String BEAN_ID = "beanId"; //$NON-NLS-1$

	public static final String BINDINGS = "bindings"; //$NON-NLS-1$

	public static final String INPUT_TYPE_EDI_1_1 = SmooksInputType.INPUT_TYPE_EDI;

	public static final String INPUT_TYPE_EDI_1_2 = SmooksInputType.INPUT_TYPE_EDI;

	public static final String INPUT_TYPE_JSON_1_2 = SmooksInputType.INPUT_TYPE_JSON;

	public static EStructuralFeature ATTRIBUTE_PROPERTY = ExtendedMetaData.INSTANCE.demandFeature(null, "property", //$NON-NLS-1$
			false);

	public static EStructuralFeature ATTRIBUTE_SELECTOR = ExtendedMetaData.INSTANCE.demandFeature(null, "selector", //$NON-NLS-1$
			false);

	public static EStructuralFeature ATTRIBUTE_TYPE = ExtendedMetaData.INSTANCE.demandFeature(null, "type", false); //$NON-NLS-1$

	public static EStructuralFeature ELEMENT_BINDING = ExtendedMetaData.INSTANCE.demandFeature(
			"http://www.milyn.org/xsd/smooks-1.0.xsd", "binding", true); //$NON-NLS-1$ //$NON-NLS-2$
	
	// public static AnyType addBindingTypeToParamType(ParamType param, String
	// property, String selector, String type,
	// String uri) {
	// AnyType binding = createBindingType(property, selector, type, uri);
	// param.getMixed().add(ELEMENT_BINDING, binding);
	// return binding;
	// }
	//
	// public static List<Object>
	// getBindingListFromResourceConfigType(ResourceConfigType resourceConfig) {
	// List<ParamType> paramList = resourceConfig.getParam();
	// for (Iterator<ParamType> iterator = paramList.iterator();
	// iterator.hasNext();) {
	// ParamType param = iterator.next();
	// if ("bindings".equals(param.getName())) {
	// if (param.eContents().isEmpty())
	// continue;
	// List<Object> bindingList = (List<Object>)
	// param.getMixed().list(SmooksModelUtils.ELEMENT_BINDING);
	// return bindingList;
	// }
	// }
	// return Collections.emptyList();
	// }
	//
	// public static boolean isBeanPopulatorResource(ResourceConfigType type) {
	// ResourceType resource = type.getResource();
	// if (resource == null)
	// return false;
	// String value = resource.getStringValue();
	// if (value != null)
	// value = value.trim();
	// if (SmooksModelConstants.BEAN_POPULATOR.equals(value)) {
	// return true;
	// }
	// return false;
	// }

	public static void setPropertyValueToAnyType(Object value, EStructuralFeature attribute, AnyType anyType) {
		anyType.getAnyAttribute().set(attribute, value);
	}

	// public static AnyType getBindingViaProperty(ResourceConfigType
	// resourceConfig, String property) {
	// List bindingList = getBindingListFromResourceConfigType(resourceConfig);
	// for (Iterator iterator = bindingList.iterator(); iterator.hasNext();) {
	// AnyType binding = (AnyType) iterator.next();
	// String pro = getAttributeValueFromAnyType(binding, ATTRIBUTE_PROPERTY);
	// if (pro != null)
	// pro = pro.trim();
	// if (property.equals(pro)) {
	// return binding;
	// }
	// }
	// return null;
	// }
	//
	// public static boolean isInnerFileContents(ResourceConfigType
	// resourceConfig) {
	// ResourceType resource = resourceConfig.getResource();
	// if (resource == null)
	// return false;
	// String type = resource.getType();
	// if (type != null)
	// type = type.trim();
	// for (int i = 0; i < TEMPLATE_TYPES.length; i++) {
	// String type1 = TEMPLATE_TYPES[i];
	// if (type1.equalsIgnoreCase(type))
	// return true;
	// }
	// return false;
	// }
	//
	// public static boolean isDateTypeSelector(ResourceConfigType type) {
	// ResourceType resource = type.getResource();
	// if (resource == null)
	// return false;
	// String value = resource.getStringValue();
	// if (value != null)
	// value = value.trim();
	// for (int i = 0; i < SmooksModelConstants.DECODER_CLASSES.length; i++) {
	// String decoderClass = SmooksModelConstants.DECODER_CLASSES[i];
	// if (decoderClass.equals(value)) {
	// return true;
	// }
	// }
	// return false;
	// }
	//
	// public static String getTransformType(ResourceConfigType resourceConfig)
	// {
	// ParamType typeParam = null;
	// if (resourceConfig == null)
	// return "";
	// if (isTransformTypeResourceConfig(resourceConfig)) {
	// List paramList = resourceConfig.getParam();
	// for (Iterator iterator = paramList.iterator(); iterator.hasNext();) {
	// ParamType param = (ParamType) iterator.next();
	// String name = param.getName();
	// if (name != null)
	// name = name.trim();
	// if (SmooksModelConstants.STREAM_FILTER_TYPE.equals(name)) {
	// typeParam = param;
	// break;
	// }
	// }
	// if (typeParam != null) {
	// return SmooksModelUtils.getAnyTypeText(typeParam);
	// }
	// }
	// return "";
	// }
	//
	// public static void setTransformType(ResourceConfigType resourceConfig,
	// String type) {
	// if (type == null)
	// type = "";
	// if (isTransformTypeResourceConfig(resourceConfig)) {
	// List paramList = resourceConfig.getParam();
	// for (Iterator iterator = paramList.iterator(); iterator.hasNext();) {
	// ParamType param = (ParamType) iterator.next();
	// if (SmooksModelConstants.STREAM_FILTER_TYPE.equals(param.getName())) {
	// cleanTextToSmooksType(param);
	// setTextToAnyType(param, type);
	// }
	// }
	// }
	// }
	//
	// public static boolean isFilePathResourceConfig(ResourceConfigType
	// resourceConfig) {
	// ResourceType resource = resourceConfig.getResource();
	// if (resource != null) {
	// String value = resource.getStringValue();
	// if (value != null) {
	// if (value.startsWith("\\")) {
	// return true;
	// }
	// if (value.startsWith("/")) {
	// return true;
	// }
	// }
	// }
	// return false;
	// }
	//
	// public static boolean isTransformTypeResourceConfig(ResourceConfigType
	// resourceConfig) {
	// String selector = resourceConfig.getSelector();
	// if (selector != null)
	// selector = selector.trim();
	// if (!SmooksModelConstants.GLOBAL_PARAMETERS.equals(selector)) {
	// return false;
	// }
	//
	// if (resourceConfig.getParam().isEmpty()) {
	// return false;
	// } else {
	// List paramList = resourceConfig.getParam();
	// for (Iterator iterator = paramList.iterator(); iterator.hasNext();) {
	// ParamType p = (ParamType) iterator.next();
	// String paramName = p.getName();
	// if (paramName != null)
	// paramName = paramName.trim();
	// if (SmooksModelConstants.STREAM_FILTER_TYPE.equals(paramName)) {
	// return true;
	// }
	// }
	// return false;
	// }
	// }
	//
	// public static void setParamText(String paramName, String value,
	// ResourceConfigType resourceConfigType) {
	// List<ParamType> list = resourceConfigType.getParam();
	// ParamType param = null;
	// for (Iterator<ParamType> iterator = list.iterator(); iterator.hasNext();)
	// {
	// ParamType paramType = (ParamType) iterator.next();
	// String n = paramType.getName();
	// if (n == null)
	// continue;
	// n = n.trim();
	// if (n.equalsIgnoreCase(paramName)) {
	// param = paramType;
	// break;
	// }
	// }
	// if (param == null) {
	// param = SmooksFactory.eINSTANCE.createParamType();
	// param.setName(paramName);
	// resourceConfigType.getParam().add(param);
	// }
	// setTextToAnyType(param, value);
	// }
	//
	// public static String getParmaText(String paramName, ResourceConfigType
	// resourceConfigType) {
	// List plist = resourceConfigType.getParam();
	// for (Iterator iterator = plist.iterator(); iterator.hasNext();) {
	// ParamType p = (ParamType) iterator.next();
	// String n = p.getName();
	// if (n == null)
	// continue;
	// n = n.trim();
	// if (paramName.equalsIgnoreCase(n)) {
	// return getAnyTypeText(p);
	// }
	// }
	// return null;
	// }

	public static String getAttributeValueFromAnyType(AnyType anyType, EStructuralFeature attribute) {
		String value = (String) anyType.getAnyAttribute().get(attribute, false);
		return value;
	}

	public static String getAnyTypeText(AnyType anyType) {
		Object value = anyType.getMixed().get(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT, true);
		if (value != null) {
			if (value instanceof List && !((List<?>) value).isEmpty()) {
				Object v = ((List<?>) value).get(0);
				if (v != null) {
					return v.toString().trim();
				}
			}
			// return value.toString();
		}
		return null;
	}

	public static String getAnyTypeCDATA(AnyType anyType) {
		Object value = anyType.getMixed().get(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__CDATA, true);
		if (value != null) {
			if (value instanceof List && !((List) value).isEmpty()) {
				Object v = ((List) value).get(0);
				if (v != null) {
					return v.toString().trim();
				}
			}
			// return value.toString();
		}
		return null;
	}

	public static String getAnyTypeComment(AnyType anyType) {
		EList<Object> value = anyType.getMixed().list(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__COMMENT);
		if (value != null && !value.isEmpty()) {
			Object v = ((List<?>) value).get(0);
			if (v != null) {
				return v.toString().trim();
			}
			// return value.toString();
		}
		return null;
	}

	// public static AnyType createBindingType(String property, String selector,
	// String type, String uri) {
	// if (uri == null) {
	// uri = SmooksPackage.eNS_URI;
	// }
	//
	// AnyType binding = (AnyType)
	// EcoreUtil.create(XMLTypePackage.Literals.ANY_TYPE);
	// if (property != null) {
	// binding.getAnyAttribute().add(ATTRIBUTE_PROPERTY, property);
	// }
	//
	// if (selector != null) {
	// binding.getAnyAttribute().add(ATTRIBUTE_SELECTOR, selector);
	// }
	// if (type != null) {
	// binding.getAnyAttribute().add(ATTRIBUTE_TYPE, false);
	// }
	// return binding;
	// }

	public static void appendTextToSmooksType(AnyType smooksModel, String text) {
		smooksModel.getMixed().add(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT, text);
	}

	public static void setTextToSmooksType(EditingDomain editingDomain, AnyType smooksModel, String text) {
		CompoundCommand ccommand = new CompoundCommand();
		Command addCommand = null;
		if (text != null) {
			addCommand = AddCommand.create(editingDomain, smooksModel, XMLTypePackage.Literals.ANY_TYPE__MIXED,
					FeatureMapUtil.createEntry(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT, text));
		}
		Object removeValue = (smooksModel.getMixed().get(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT, true));
		if (removeValue != null && removeValue instanceof Collection<?>) {
			List<Object> rList = new ArrayList<Object>();
			for (Iterator<?> iterator = ((Collection<?>) removeValue).iterator(); iterator.hasNext();) {
				Object string = (Object) iterator.next();
				rList.add(FeatureMapUtil.createEntry(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT, string));
			}
			Command cc = RemoveCommand.create(editingDomain, smooksModel, null, rList);
			if (cc != null && cc.canExecute()) {
				ccommand.append(cc);
			}
		}
		if (addCommand != null && addCommand.canExecute()) {
			ccommand.append(addCommand);
		}
		if (smooksModel.eContainer() == null) {
			ccommand.execute();
		} else {
			editingDomain.getCommandStack().execute(ccommand);
		}
	}

	public static void setCommentToSmooksType(EditingDomain editingDomain, AnyType smooksModel, String comment) {
		CompoundCommand ccommand = new CompoundCommand();
		Command addCommand = null;
		if (comment != null) {
			addCommand = AddCommand.create(editingDomain, smooksModel, XMLTypePackage.Literals.ANY_TYPE__MIXED,
					FeatureMapUtil.createEntry(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__COMMENT, comment));
		}
		Object removeValue = (smooksModel.getMixed().get(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__COMMENT, true));
		if (removeValue != null && removeValue instanceof Collection<?>) {
			List<Object> rList = new ArrayList<Object>();
			for (Iterator<?> iterator = ((Collection<?>) removeValue).iterator(); iterator.hasNext();) {
				Object string = (Object) iterator.next();
				rList.add(FeatureMapUtil.createEntry(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__COMMENT, string));
			}
			Command cc = RemoveCommand.create(editingDomain, smooksModel, null, rList);
			if (cc != null && cc.canExecute()) {
				ccommand.append(cc);
			}
		}
		if (addCommand != null && addCommand.canExecute()) {
			ccommand.append(addCommand);
		}
		if (smooksModel.eContainer() == null) {
			ccommand.execute();
		} else {
			editingDomain.getCommandStack().execute(ccommand);
		}
	}

	public static void setCDATAToSmooksType(EditingDomain editingDomain, AnyType smooksModel, String cdata) {
		CompoundCommand ccommand = new CompoundCommand();
		Command addCommand = null;
		if (cdata != null) {
			addCommand = AddCommand.create(editingDomain, smooksModel, XMLTypePackage.Literals.ANY_TYPE__MIXED,
					FeatureMapUtil.createEntry(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__CDATA, cdata));
		}
		Object removeValue = (smooksModel.getMixed().get(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__CDATA, true));
		if (removeValue != null && removeValue instanceof Collection<?>) {
			List<Object> rList = new ArrayList<Object>();
			for (Iterator<?> iterator = ((Collection<?>) removeValue).iterator(); iterator.hasNext();) {
				Object string = (Object) iterator.next();
				rList.add(FeatureMapUtil.createEntry(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__CDATA, string));
			}
			Command cc = RemoveCommand.create(editingDomain, smooksModel, null, rList);
			if (cc != null && cc.canExecute()) {
				ccommand.append(cc);
			}
		}
		if (addCommand != null && addCommand.canExecute()) {
			ccommand.append(addCommand);
		}
		if (smooksModel.eContainer() == null) {
			ccommand.execute();
		} else {
			editingDomain.getCommandStack().execute(ccommand);
		}
	}

	public static void appendCDATAToSmooksType(AnyType smooksModel, String text) {
		smooksModel.getMixed().add(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__CDATA, text);
	}

	/**
	 * @deprecated
	 * @param smooksModel
	 * @param text
	 */
	public static void setTextToAnyType(AnyType smooksModel, String text) {
		cleanTextToSmooksType(smooksModel);
		appendTextToSmooksType(smooksModel, text);
	}

	/**
	 * @deprecated
	 * @param smooksModel
	 * @param text
	 */
	public static void setCDATAToAnyType(AnyType smooksModel, String text) {
		cleanCDATAToSmooksType(smooksModel);
		appendCDATAToSmooksType(smooksModel, text);
	}

	public static void cleanTextToSmooksType(AnyType smooksModel) {
		Object obj = smooksModel.getMixed().get(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT, true);
		if (obj instanceof List) {
			((List) obj).clear();
		}
	}

	public static void cleanCDATAToSmooksType(AnyType smooksModel) {
		Object obj = smooksModel.getMixed().get(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__CDATA, true);
		if (obj instanceof List) {
			((List) obj).clear();
		}
	}

	public static CommandParameter createTextCommandParamter(Object owner, String value) {
		return createChildParameter(owner, XMLTypePackage.Literals.ANY_TYPE__MIXED, FeatureMapUtil.createEntry(
				XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT, value));
	}

	public static CommandParameter createChildParameter(Object owner, Object feature, Object child) {
		return new CommandParameter(owner, feature, child);
	}

	// public static String getInputPath(InputType input) {
	// List<org.jboss.tools.smooks.model.graphics.ext.ParamType> list =
	// input.getParam();
	// if (INPUT_TYPE_JAVA.equals(input.getType()) ||
	// INPUT_TYPE_XML.equals(input.getType())
	// || INPUT_TYPE_XSD.equals(input.getType()) ||
	// INPUT_TYPE_JSON_1_1.equals(input.getType())
	// || INPUT_TYPE_JSON_1_2.equals(input.getType()) ||
	// INPUT_TYPE_CSV.equals(input.getType())
	// || INPUT_TYPE_EDI_1_1.equals(input.getType()) ||
	// INPUT_TYPE_EDI_1_2.equals(input.getType())
	// || INPUT_TYPE_CSV_1_2.equals(input.getType())) {
	// for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
	// org.jboss.tools.smooks.model.graphics.ext.ParamType paramType =
	// (org.jboss.tools.smooks.model.graphics.ext.ParamType) iterator
	// .next();
	// if ("path".equals(paramType.getName())) {
	// String value = paramType.getValue();
	// if (value != null)
	// value = value.trim();
	// return value;
	// }
	// }
	// }
	// return null;
	// }

	public static List<ConditionType> collectConditionType(SmooksResourceListType resourceList) {
		ConditionsType conditions = resourceList.getConditions();
		if (conditions != null) {
			return conditions.getCondition();
		}
		return Collections.emptyList();
	}

	public static List<org.jboss.tools.smooks.model.smooks.ParamType> getParams(AnyType model) {
		if (model == null)
			return Collections.emptyList();
		List<org.jboss.tools.smooks.model.smooks.ParamType> obj = model.getMixed().list(
				org.jboss.tools.smooks.model.smooks.SmooksPackage.Literals.DOCUMENT_ROOT__PARAM);
		return obj;
	}

	public static void addParam(AnyType model, org.jboss.tools.smooks.model.smooks.ParamType param) {
		if (model == null)
			return;
		model.getMixed().add(
				XMLTypePackage.Literals.ANY_TYPE__MIXED,
				FeatureMapUtil.createEntry(
						org.jboss.tools.smooks.model.smooks.SmooksPackage.Literals.DOCUMENT_ROOT__PARAM, param));
	}

	public static char getFreemarkerCSVSeperator(Freemarker freemarker) {
		org.jboss.tools.smooks.model.smooks.ParamType typeParam = getParam(freemarker.getParam(), KEY_CSV_SEPERATOR);
		if (typeParam != null) {
			String value = typeParam.getStringValue();
			if (value != null && value.length() == 1) {
				return value.toCharArray()[0];
			}
		}
		return 0;
	}

	public static char getFreemarkerCSVQuote(Freemarker freemarker) {
		org.jboss.tools.smooks.model.smooks.ParamType typeParam = getParam(freemarker.getParam(), KEY_CSV_QUOTE);
		if (typeParam != null) {
			String value = typeParam.getStringValue();
			if (value != null && value.length() == 1) {
				return value.toCharArray()[0];
			}
		}
		return 0;
	}

	public static boolean getFreemarkerCSVIncludeFieldNames(Freemarker freemarker) {
		org.jboss.tools.smooks.model.smooks.ParamType typeParam = getParam(freemarker.getParam(), KEY_INCLUDE_FIELD_NAMES);
		if (typeParam != null) {
			String value = typeParam.getStringValue();
			if (value != null) {
				return value.equals("true"); //$NON-NLS-1$
			}
		}
		
		return false;
	}

	public static String getFreemarkerXMLFileType(Freemarker freemarker) {
		org.jboss.tools.smooks.model.smooks.ParamType typeParam = getParam(freemarker.getParam(), KEY_XML_FILE_TYPE);
		if (typeParam != null) {
			String value = typeParam.getStringValue();
			return value;
		}
		return null;
	}

	public static String getFreemarkerXMLFilePath(Freemarker freemarker) {
		org.jboss.tools.smooks.model.smooks.ParamType typeParam = getParam(freemarker.getParam(), KEY_XML_FILE_PATH);
		if (typeParam != null) {
			String value = typeParam.getStringValue();
			return value;
		}
		return null;
	}

	public static String getFreemarkerXMLRootName(Freemarker freemarker) {
		org.jboss.tools.smooks.model.smooks.ParamType typeParam = getParam(freemarker.getParam(), KEY_XML_ROOT_NAME);
		if (typeParam != null) {
			String value = typeParam.getStringValue();
			return value;
		}
		return null;
	}

	public static String getTemplateType(Freemarker freemarker) {
		if (freemarker == null)
			return null;
		org.jboss.tools.smooks.model.smooks.ParamType typeParam = getParam(freemarker.getParam(), KEY_TEMPLATE_TYPE);
		if (typeParam != null) {
			return typeParam.getStringValue();
		}
		return null;
	}

	public static String[] getFreemarkerCSVFileds(Freemarker freemarker) {
		org.jboss.tools.smooks.model.smooks.ParamType typeParam = getParam(freemarker.getParam(), KEY_CSV_FIELDS);
		if (typeParam != null) {
			String value = typeParam.getStringValue();
			if (value != null) {
				value = value.trim();
				if (!"".equals(value)) { //$NON-NLS-1$
					return value.split(","); //$NON-NLS-1$
				}
			}
		}
		return null;
	}

	public static org.jboss.tools.smooks.model.smooks.ParamType getParam(AnyType model, String paramName) {
		List<org.jboss.tools.smooks.model.smooks.ParamType> params = getParams(model);
		for (Iterator<?> iterator = params.iterator(); iterator.hasNext();) {
			org.jboss.tools.smooks.model.smooks.ParamType paramType = (org.jboss.tools.smooks.model.smooks.ParamType) iterator
					.next();
			if (paramName.equals(paramType.getName())) {
				return paramType;
			}
		}
		return null;
	}

	public static org.jboss.tools.smooks.model.smooks.ParamType getParam(
			List<org.jboss.tools.smooks.model.smooks.ParamType> params, String paramName) {
		for (Iterator<?> iterator = params.iterator(); iterator.hasNext();) {
			org.jboss.tools.smooks.model.smooks.ParamType paramType = (org.jboss.tools.smooks.model.smooks.ParamType) iterator
					.next();
			if (paramName.equals(paramType.getName())) {
				return paramType;
			}
		}
		return null;
	}

	public static String getParamValue(AnyType model, String paramName) {
		List<org.jboss.tools.smooks.model.smooks.ParamType> params = getParams(model);
		for (Iterator<?> iterator = params.iterator(); iterator.hasNext();) {
			org.jboss.tools.smooks.model.smooks.ParamType paramType = (org.jboss.tools.smooks.model.smooks.ParamType) iterator
					.next();
			if (paramName.equals(paramType.getName())) {
				return paramType.getStringValue();
			}
		}
		return null;
	}

	public static String getParamValue(List<org.jboss.tools.smooks.model.smooks.ParamType> params, String paramName) {
		for (Iterator<?> iterator = params.iterator(); iterator.hasNext();) {
			org.jboss.tools.smooks.model.smooks.ParamType paramType = (org.jboss.tools.smooks.model.smooks.ParamType) iterator
					.next();
			if (paramName.equals(paramType.getName())) {
				return paramType.getStringValue();
			}
		}
		return null;
	}

	public static String generateTaskID(SmooksResourceListType resourceList, Class<?> modelClass, String baseID) {
		List<AbstractResourceConfig> configList = resourceList.getAbstractResourceConfig();
		int index = 0;
		List<AbstractResourceConfig> modelList = new ArrayList<AbstractResourceConfig>();
		for (Iterator<?> iterator = configList.iterator(); iterator.hasNext();) {
			AbstractResourceConfig abstractResourceConfig = (AbstractResourceConfig) iterator.next();
			if (modelClass.isInstance(abstractResourceConfig)) {
				modelList.add(abstractResourceConfig);
				// index++;
			}
		}
		String id = baseID + String.valueOf(index);
		int i = 0;
		for (i = 0; i < modelList.size(); i++) {
			AbstractResourceConfig abstractResourceConfig = modelList.get(i);
			String idref = null;
			if (abstractResourceConfig instanceof Freemarker) {
				idref = SmooksModelUtils.getParamValue(((Freemarker) abstractResourceConfig).getParam(),
						SmooksModelUtils.KEY_OBJECT_ID);
			}
			if (idref == null) {
				idref = SmooksModelUtils.getParamValue(abstractResourceConfig, SmooksModelUtils.KEY_OBJECT_ID);
			}
			if (id.equals(idref)) {
				index++;
				id = baseID + String.valueOf(index);
				i = 0;
				continue;
			}
		}
		return id;

	}
}
