/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.smooks.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.jboss.tools.smooks.model.smooks.*;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SmooksFactoryImpl extends EFactoryImpl implements SmooksFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SmooksFactory init() {
		try {
			SmooksFactory theSmooksFactory = (SmooksFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.milyn.org/xsd/smooks-1.1.xsd");  //$NON-NLS-1$
			if (theSmooksFactory != null) {
				return theSmooksFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SmooksFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmooksFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SmooksPackage.CONDITIONS_TYPE: return createConditionsType();
			case SmooksPackage.CONDITION_TYPE: return createConditionType();
			case SmooksPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case SmooksPackage.FEATURES_TYPE: return createFeaturesType();
			case SmooksPackage.HANDLERS_TYPE: return createHandlersType();
			case SmooksPackage.HANDLER_TYPE: return createHandlerType();
			case SmooksPackage.IMPORT_TYPE: return createImportType();
			case SmooksPackage.PARAMS_TYPE: return createParamsType();
			case SmooksPackage.PARAM_TYPE: return createParamType();
			case SmooksPackage.PROFILES_TYPE: return createProfilesType();
			case SmooksPackage.PROFILE_TYPE: return createProfileType();
			case SmooksPackage.READER_TYPE: return createReaderType();
			case SmooksPackage.RESOURCE_CONFIG_TYPE: return createResourceConfigType();
			case SmooksPackage.RESOURCE_TYPE: return createResourceType();
			case SmooksPackage.SET_OFF_TYPE: return createSetOffType();
			case SmooksPackage.SET_ON_TYPE: return createSetOnType();
			case SmooksPackage.SMOOKS_RESOURCE_LIST_TYPE: return createSmooksResourceListType();
			default:
				throw new IllegalArgumentException(Messages.SmooksFactoryImpl_Error_Class_Not_Valid + eClass.getName() + Messages.SmooksFactoryImpl_Error_Not_Valid_Classifier);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionsType createConditionsType() {
		ConditionsTypeImpl conditionsType = new ConditionsTypeImpl();
		return conditionsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionType createConditionType() {
		ConditionTypeImpl conditionType = new ConditionTypeImpl();
		return conditionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeaturesType createFeaturesType() {
		FeaturesTypeImpl featuresType = new FeaturesTypeImpl();
		return featuresType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HandlersType createHandlersType() {
		HandlersTypeImpl handlersType = new HandlersTypeImpl();
		return handlersType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HandlerType createHandlerType() {
		HandlerTypeImpl handlerType = new HandlerTypeImpl();
		return handlerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportType createImportType() {
		ImportTypeImpl importType = new ImportTypeImpl();
		return importType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParamsType createParamsType() {
		ParamsTypeImpl paramsType = new ParamsTypeImpl();
		return paramsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParamType createParamType() {
		ParamTypeImpl paramType = new ParamTypeImpl();
		return paramType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfilesType createProfilesType() {
		ProfilesTypeImpl profilesType = new ProfilesTypeImpl();
		return profilesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfileType createProfileType() {
		ProfileTypeImpl profileType = new ProfileTypeImpl();
		return profileType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReaderType createReaderType() {
		ReaderTypeImpl readerType = new ReaderTypeImpl();
		return readerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceConfigType createResourceConfigType() {
		ResourceConfigTypeImpl resourceConfigType = new ResourceConfigTypeImpl();
		return resourceConfigType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceType createResourceType() {
		ResourceTypeImpl resourceType = new ResourceTypeImpl();
		return resourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetOffType createSetOffType() {
		SetOffTypeImpl setOffType = new SetOffTypeImpl();
		return setOffType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetOnType createSetOnType() {
		SetOnTypeImpl setOnType = new SetOnTypeImpl();
		return setOnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmooksResourceListType createSmooksResourceListType() {
		SmooksResourceListTypeImpl smooksResourceListType = new SmooksResourceListTypeImpl();
		return smooksResourceListType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmooksPackage getSmooksPackage() {
		return (SmooksPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SmooksPackage getPackage() {
		return SmooksPackage.eINSTANCE;
	}

} //SmooksFactoryImpl
