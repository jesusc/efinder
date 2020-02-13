/**
 */
package efinder.ir.ocl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterator Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.ocl.IteratorExp#getName <em>Name</em>}</li>
 *   <li>{@link efinder.ir.ocl.IteratorExp#getIterators <em>Iterators</em>}</li>
 *   <li>{@link efinder.ir.ocl.IteratorExp#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see efinder.ir.ocl.OclPackage#getIteratorExp()
 * @model
 * @generated
 */
public interface IteratorExp extends CallExp {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see efinder.ir.ocl.OclPackage#getIteratorExp_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.IteratorExp#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Iterators</b></em>' containment reference list.
	 * The list contents are of type {@link efinder.ir.ocl.Iterator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterators</em>' containment reference list.
	 * @see efinder.ir.ocl.OclPackage#getIteratorExp_Iterators()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Iterator> getIterators();

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(OclExpression)
	 * @see efinder.ir.ocl.OclPackage#getIteratorExp_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OclExpression getBody();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.IteratorExp#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(OclExpression value);

} // IteratorExp
