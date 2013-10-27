/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.jboss.tools.smooks.model.freemarker;

import org.eclipse.emf.common.util.EList;
import org.jboss.tools.smooks.model.smooks.ElementVisitor;
import org.jboss.tools.smooks.model.smooks.ParamType;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Freemarker</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *                 FreeMarker Templating Configuration Type.
 *             
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.tools.smooks.model.freemarker.Freemarker#getTemplate <em>Template</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.freemarker.Freemarker#getUse <em>Use</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.freemarker.Freemarker#getParam <em>Param</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.freemarker.Freemarker#isApplyBefore <em>Apply Before</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.freemarker.Freemarker#getApplyOnElement <em>Apply On Element</em>}</li>
 *   <li>{@link org.jboss.tools.smooks.model.freemarker.Freemarker#getApplyOnElementNS <em>Apply On Element NS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.tools.smooks.model.freemarker.FreemarkerPackage#getFreemarker()
 * @model extendedMetaData="name='freemarker' kind='elementOnly'"
 * @generated
 */
public interface Freemarker extends ElementVisitor {
	/**
	 * Returns the value of the '<em><b>Template</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template</em>' containment reference.
	 * @see #setTemplate(Template)
	 * @see org.jboss.tools.smooks.model.freemarker.FreemarkerPackage#getFreemarker_Template()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='template' namespace='##targetNamespace'"
	 * @generated
	 */
	Template getTemplate();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.freemarker.Freemarker#getTemplate <em>Template</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template</em>' containment reference.
	 * @see #getTemplate()
	 * @generated
	 */
	void setTemplate(Template value);

	/**
	 * Returns the value of the '<em><b>Use</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use</em>' containment reference.
	 * @see #setUse(Use)
	 * @see org.jboss.tools.smooks.model.freemarker.FreemarkerPackage#getFreemarker_Use()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='use' namespace='##targetNamespace'"
	 * @generated
	 */
	Use getUse();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.freemarker.Freemarker#getUse <em>Use</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use</em>' containment reference.
	 * @see #getUse()
	 * @generated
	 */
	void setUse(Use value);

	/**
	 * Returns the value of the '<em><b>Param</b></em>' containment reference list.
	 * The list contents are of type {@link org.jboss.tools.smooks.model.smooks.ParamType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Param</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param</em>' containment reference list.
	 * @see org.jboss.tools.smooks.model.freemarker.FreemarkerPackage#getFreemarker_Param()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='param' namespace='http://www.milyn.org/xsd/smooks-1.1.xsd'"
	 * @generated
	 */
	EList<ParamType> getParam();

	/**
	 * Returns the value of the '<em><b>Apply Before</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                             Apply the template before visiting the elements child content.<p/>Default is 'false'.
	 *                         
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Apply Before</em>' attribute.
	 * @see #isSetApplyBefore()
	 * @see #unsetApplyBefore()
	 * @see #setApplyBefore(boolean)
	 * @see org.jboss.tools.smooks.model.freemarker.FreemarkerPackage#getFreemarker_ApplyBefore()
	 * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='applyBefore'"
	 * @generated
	 */
	boolean isApplyBefore();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.freemarker.Freemarker#isApplyBefore <em>Apply Before</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Apply Before</em>' attribute.
	 * @see #isSetApplyBefore()
	 * @see #unsetApplyBefore()
	 * @see #isApplyBefore()
	 * @generated
	 */
	void setApplyBefore(boolean value);

	/**
	 * Unsets the value of the '{@link org.jboss.tools.smooks.model.freemarker.Freemarker#isApplyBefore <em>Apply Before</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetApplyBefore()
	 * @see #isApplyBefore()
	 * @see #setApplyBefore(boolean)
	 * @generated
	 */
	void unsetApplyBefore();

	/**
	 * Returns whether the value of the '{@link org.jboss.tools.smooks.model.freemarker.Freemarker#isApplyBefore <em>Apply Before</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Apply Before</em>' attribute is set.
	 * @see #unsetApplyBefore()
	 * @see #isApplyBefore()
	 * @see #setApplyBefore(boolean)
	 * @generated
	 */
	boolean isSetApplyBefore();

	/**
	 * Returns the value of the '<em><b>Apply On Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                             The name of the element on which the template is to be applied.
	 *                         
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Apply On Element</em>' attribute.
	 * @see #setApplyOnElement(String)
	 * @see org.jboss.tools.smooks.model.freemarker.FreemarkerPackage#getFreemarker_ApplyOnElement()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='applyOnElement'"
	 * @generated
	 */
	String getApplyOnElement();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.freemarker.Freemarker#getApplyOnElement <em>Apply On Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Apply On Element</em>' attribute.
	 * @see #getApplyOnElement()
	 * @generated
	 */
	void setApplyOnElement(String value);

	/**
	 * Returns the value of the '<em><b>Apply On Element NS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                             The namespace of the element on which the template is to be applied.
	 *                         
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Apply On Element NS</em>' attribute.
	 * @see #setApplyOnElementNS(String)
	 * @see org.jboss.tools.smooks.model.freemarker.FreemarkerPackage#getFreemarker_ApplyOnElementNS()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='applyOnElementNS'"
	 * @generated
	 */
	String getApplyOnElementNS();

	/**
	 * Sets the value of the '{@link org.jboss.tools.smooks.model.freemarker.Freemarker#getApplyOnElementNS <em>Apply On Element NS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Apply On Element NS</em>' attribute.
	 * @see #getApplyOnElementNS()
	 * @generated
	 */
	void setApplyOnElementNS(String value);

} // Freemarker
