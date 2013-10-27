/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.freemarker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Inline Directive</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.jboss.tools.smooks.model.freemarker.FreemarkerPackage#getInlineDirective()
 * @model extendedMetaData="name='inlineDirective'"
 * @generated
 */
public enum InlineDirective implements Enumerator {
	/**
	 * The '<em><b>Addto</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADDTO_VALUE
	 * @generated
	 * @ordered
	 */
	ADDTO(0, "addto", "addto"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Replace</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REPLACE_VALUE
	 * @generated
	 * @ordered
	 */
	REPLACE(1, "replace", "replace"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Insertbefore</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INSERTBEFORE_VALUE
	 * @generated
	 * @ordered
	 */
	INSERTBEFORE(2, "insertbefore", "insertbefore"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Insertafter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INSERTAFTER_VALUE
	 * @generated
	 * @ordered
	 */
	INSERTAFTER(3, "insertafter", "insertafter"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Addto</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Addto</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADDTO
	 * @model name="addto"
	 * @generated
	 * @ordered
	 */
	public static final int ADDTO_VALUE = 0;

	/**
	 * The '<em><b>Replace</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Replace</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REPLACE
	 * @model name="replace"
	 * @generated
	 * @ordered
	 */
	public static final int REPLACE_VALUE = 1;

	/**
	 * The '<em><b>Insertbefore</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Insertbefore</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INSERTBEFORE
	 * @model name="insertbefore"
	 * @generated
	 * @ordered
	 */
	public static final int INSERTBEFORE_VALUE = 2;

	/**
	 * The '<em><b>Insertafter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Insertafter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INSERTAFTER
	 * @model name="insertafter"
	 * @generated
	 * @ordered
	 */
	public static final int INSERTAFTER_VALUE = 3;

	/**
	 * An array of all the '<em><b>Inline Directive</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final InlineDirective[] VALUES_ARRAY =
		new InlineDirective[] {
			ADDTO,
			REPLACE,
			INSERTBEFORE,
			INSERTAFTER,
		};

	/**
	 * A public read-only list of all the '<em><b>Inline Directive</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<InlineDirective> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Inline Directive</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static InlineDirective get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			InlineDirective result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Inline Directive</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static InlineDirective getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			InlineDirective result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Inline Directive</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static InlineDirective get(int value) {
		switch (value) {
			case ADDTO_VALUE: return ADDTO;
			case REPLACE_VALUE: return REPLACE;
			case INSERTBEFORE_VALUE: return INSERTBEFORE;
			case INSERTAFTER_VALUE: return INSERTAFTER;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private InlineDirective(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //InlineDirective
