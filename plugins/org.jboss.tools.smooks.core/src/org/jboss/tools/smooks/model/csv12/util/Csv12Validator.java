/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.csv12.util;


import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.emf.ecore.xml.type.util.XMLTypeValidator;
import org.jboss.tools.smooks.model.csv12.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.jboss.tools.smooks.model.csv12.Csv12Package
 * @generated
 */
public class Csv12Validator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final Csv12Validator INSTANCE = new Csv12Validator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "csv12"; //$NON-NLS-1$

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XMLTypeValidator xmlTypeValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Csv12Validator() {
		super();
		xmlTypeValidator = XMLTypeValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EPackage getEPackage() {
	  return Csv12Package.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map context) {
		switch (classifierID) {
			case Csv12Package.BINDING:
				return validateBinding((Binding)value, diagnostics, context);
			case Csv12Package.CSV12_DOCUMENT_ROOT:
				return validateCSV12DocumentRoot((CSV12DocumentRoot)value, diagnostics, context);
			case Csv12Package.MAP_BINDING:
				return validateMapBinding((MapBinding)value, diagnostics, context);
			case Csv12Package.CSV12_READER:
				return validateCSV12Reader((CSV12Reader)value, diagnostics, context);
			case Csv12Package.CHAR:
				return validateChar((String)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBinding(Binding binding, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(binding, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCSV12DocumentRoot(CSV12DocumentRoot csv12DocumentRoot, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(csv12DocumentRoot, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapBinding(MapBinding mapBinding, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(mapBinding, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCSV12Reader(CSV12Reader csv12Reader, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(csv12Reader, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateChar(String char_, DiagnosticChain diagnostics, Map context) {
		boolean result = validateChar_MinLength(char_, diagnostics, context);
		if (result || diagnostics != null) result &= validateChar_MaxLength(char_, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MinLength constraint of '<em>Char</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateChar_MinLength(String char_, DiagnosticChain diagnostics, Map context) {
		int length = char_.length();
		boolean result = length >= 1;
		if (!result && diagnostics != null)
			reportMinLengthViolation(Csv12Package.Literals.CHAR, char_, length, 1, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MaxLength constraint of '<em>Char</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateChar_MaxLength(String char_, DiagnosticChain diagnostics, Map context) {
		int length = char_.length();
		boolean result = length <= 1;
		if (!result && diagnostics != null)
			reportMaxLengthViolation(Csv12Package.Literals.CHAR, char_, length, 1, diagnostics, context);
		return result;
	}

} //Csv12Validator
