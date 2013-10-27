/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.smooks.util;


import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.xml.type.AnyType;
import org.jboss.tools.smooks.model.common.AbstractAnyType;
import org.jboss.tools.smooks.model.smooks.*;


/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.jboss.tools.smooks.model.smooks.SmooksPackage
 * @generated
 */
public class SmooksSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SmooksPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmooksSwitch() {
		if (modelPackage == null) {
			modelPackage = SmooksPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SmooksPackage.ABSTRACT_READER: {
				AbstractReader abstractReader = (AbstractReader)theEObject;
				T result = caseAbstractReader(abstractReader);
				if (result == null) result = caseAbstractResourceConfig(abstractReader);
				if (result == null) result = caseAbstractAnyType(abstractReader);
				if (result == null) result = caseAnyType(abstractReader);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmooksPackage.ABSTRACT_RESOURCE_CONFIG: {
				AbstractResourceConfig abstractResourceConfig = (AbstractResourceConfig)theEObject;
				T result = caseAbstractResourceConfig(abstractResourceConfig);
				if (result == null) result = caseAbstractAnyType(abstractResourceConfig);
				if (result == null) result = caseAnyType(abstractResourceConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmooksPackage.CONDITIONS_TYPE: {
				ConditionsType conditionsType = (ConditionsType)theEObject;
				T result = caseConditionsType(conditionsType);
				if (result == null) result = caseAbstractAnyType(conditionsType);
				if (result == null) result = caseAnyType(conditionsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmooksPackage.CONDITION_TYPE: {
				ConditionType conditionType = (ConditionType)theEObject;
				T result = caseConditionType(conditionType);
				if (result == null) result = caseAbstractAnyType(conditionType);
				if (result == null) result = caseAnyType(conditionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmooksPackage.DOCUMENT_ROOT: {
				DocumentRoot documentRoot = (DocumentRoot)theEObject;
				T result = caseDocumentRoot(documentRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmooksPackage.ELEMENT_VISITOR: {
				ElementVisitor elementVisitor = (ElementVisitor)theEObject;
				T result = caseElementVisitor(elementVisitor);
				if (result == null) result = caseAbstractResourceConfig(elementVisitor);
				if (result == null) result = caseAbstractAnyType(elementVisitor);
				if (result == null) result = caseAnyType(elementVisitor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmooksPackage.FEATURES_TYPE: {
				FeaturesType featuresType = (FeaturesType)theEObject;
				T result = caseFeaturesType(featuresType);
				if (result == null) result = caseAbstractAnyType(featuresType);
				if (result == null) result = caseAnyType(featuresType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmooksPackage.HANDLERS_TYPE: {
				HandlersType handlersType = (HandlersType)theEObject;
				T result = caseHandlersType(handlersType);
				if (result == null) result = caseAbstractAnyType(handlersType);
				if (result == null) result = caseAnyType(handlersType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmooksPackage.HANDLER_TYPE: {
				HandlerType handlerType = (HandlerType)theEObject;
				T result = caseHandlerType(handlerType);
				if (result == null) result = caseAbstractAnyType(handlerType);
				if (result == null) result = caseAnyType(handlerType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmooksPackage.IMPORT_TYPE: {
				ImportType importType = (ImportType)theEObject;
				T result = caseImportType(importType);
				if (result == null) result = caseAbstractResourceConfig(importType);
				if (result == null) result = caseAbstractAnyType(importType);
				if (result == null) result = caseAnyType(importType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmooksPackage.PARAMS_TYPE: {
				ParamsType paramsType = (ParamsType)theEObject;
				T result = caseParamsType(paramsType);
				if (result == null) result = caseAbstractAnyType(paramsType);
				if (result == null) result = caseAnyType(paramsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmooksPackage.PARAM_TYPE: {
				ParamType paramType = (ParamType)theEObject;
				T result = caseParamType(paramType);
				if (result == null) result = caseAbstractAnyType(paramType);
				if (result == null) result = caseAnyType(paramType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmooksPackage.PROFILES_TYPE: {
				ProfilesType profilesType = (ProfilesType)theEObject;
				T result = caseProfilesType(profilesType);
				if (result == null) result = caseAbstractAnyType(profilesType);
				if (result == null) result = caseAnyType(profilesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmooksPackage.PROFILE_TYPE: {
				ProfileType profileType = (ProfileType)theEObject;
				T result = caseProfileType(profileType);
				if (result == null) result = caseAbstractAnyType(profileType);
				if (result == null) result = caseAnyType(profileType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmooksPackage.READER_TYPE: {
				ReaderType readerType = (ReaderType)theEObject;
				T result = caseReaderType(readerType);
				if (result == null) result = caseAbstractReader(readerType);
				if (result == null) result = caseAbstractResourceConfig(readerType);
				if (result == null) result = caseAbstractAnyType(readerType);
				if (result == null) result = caseAnyType(readerType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmooksPackage.RESOURCE_CONFIG_TYPE: {
				ResourceConfigType resourceConfigType = (ResourceConfigType)theEObject;
				T result = caseResourceConfigType(resourceConfigType);
				if (result == null) result = caseAbstractResourceConfig(resourceConfigType);
				if (result == null) result = caseAbstractAnyType(resourceConfigType);
				if (result == null) result = caseAnyType(resourceConfigType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmooksPackage.RESOURCE_TYPE: {
				ResourceType resourceType = (ResourceType)theEObject;
				T result = caseResourceType(resourceType);
				if (result == null) result = caseAbstractAnyType(resourceType);
				if (result == null) result = caseAnyType(resourceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmooksPackage.SET_OFF_TYPE: {
				SetOffType setOffType = (SetOffType)theEObject;
				T result = caseSetOffType(setOffType);
				if (result == null) result = caseAbstractAnyType(setOffType);
				if (result == null) result = caseAnyType(setOffType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmooksPackage.SET_ON_TYPE: {
				SetOnType setOnType = (SetOnType)theEObject;
				T result = caseSetOnType(setOnType);
				if (result == null) result = caseAbstractAnyType(setOnType);
				if (result == null) result = caseAnyType(setOnType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE: {
				SmooksResourceListType smooksResourceListType = (SmooksResourceListType)theEObject;
				T result = caseSmooksResourceListType(smooksResourceListType);
				if (result == null) result = caseAbstractAnyType(smooksResourceListType);
				if (result == null) result = caseAnyType(smooksResourceListType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Reader</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Reader</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractReader(AbstractReader object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Resource Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Resource Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractResourceConfig(AbstractResourceConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conditions Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditions Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionsType(ConditionsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionType(ConditionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentRoot(DocumentRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Visitor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Visitor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementVisitor(ElementVisitor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Features Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Features Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeaturesType(FeaturesType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Handlers Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Handlers Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHandlersType(HandlersType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Handler Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Handler Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHandlerType(HandlerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Import Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImportType(ImportType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Params Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Params Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParamsType(ParamsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Param Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Param Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParamType(ParamType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Profiles Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Profiles Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProfilesType(ProfilesType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Profile Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Profile Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProfileType(ProfileType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reader Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reader Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReaderType(ReaderType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Config Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Config Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceConfigType(ResourceConfigType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceType(ResourceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Off Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Off Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetOffType(SetOffType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set On Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set On Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetOnType(SetOnType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource List Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource List Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSmooksResourceListType(SmooksResourceListType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Any Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Any Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnyType(AnyType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Any Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Any Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractAnyType(AbstractAnyType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //SmooksSwitch
