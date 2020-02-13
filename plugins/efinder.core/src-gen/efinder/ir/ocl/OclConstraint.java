/**
 */
package efinder.ir.ocl;

import efinder.ir.Constraint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.ocl.OclConstraint#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see efinder.ir.ocl.OclPackage#getOclConstraint()
 * @model
 * @generated
 */
public interface OclConstraint extends Constraint {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(OclExpression)
	 * @see efinder.ir.ocl.OclPackage#getOclConstraint_Expression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OclExpression getExpression();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.OclConstraint#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(OclExpression value);

} // OclConstraint
