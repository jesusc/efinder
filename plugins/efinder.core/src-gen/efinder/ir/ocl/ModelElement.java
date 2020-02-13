/**
 */
package efinder.ir.ocl;

import efinder.ir.EFType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.ocl.ModelElement#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see efinder.ir.ocl.OclPackage#getModelElement()
 * @model
 * @generated
 */
public interface ModelElement extends OclExpression {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EFType)
	 * @see efinder.ir.ocl.OclPackage#getModelElement_Type()
	 * @model required="true"
	 * @generated
	 */
	EFType getType();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.ModelElement#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EFType value);

} // ModelElement
