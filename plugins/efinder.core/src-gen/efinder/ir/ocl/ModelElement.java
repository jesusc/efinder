/**
 */
package efinder.ir.ocl;

import efinder.ir.TypeRef;

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
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(TypeRef)
	 * @see efinder.ir.ocl.OclPackage#getModelElement_Type()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TypeRef getType();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.ModelElement#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeRef value);

} // ModelElement
