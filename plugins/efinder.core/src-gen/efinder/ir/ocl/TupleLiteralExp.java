/**
 */
package efinder.ir.ocl;

import efinder.ir.EFTupleType;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.ocl.TupleLiteralExp#getType <em>Type</em>}</li>
 *   <li>{@link efinder.ir.ocl.TupleLiteralExp#getParts <em>Parts</em>}</li>
 * </ul>
 *
 * @see efinder.ir.ocl.OclPackage#getTupleLiteralExp()
 * @model
 * @generated
 */
public interface TupleLiteralExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EFTupleType)
	 * @see efinder.ir.ocl.OclPackage#getTupleLiteralExp_Type()
	 * @model required="true"
	 * @generated
	 */
	EFTupleType getType();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.TupleLiteralExp#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EFTupleType value);

	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
	 * The list contents are of type {@link efinder.ir.ocl.TuplePart}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see efinder.ir.ocl.OclPackage#getTupleLiteralExp_Parts()
	 * @model containment="true"
	 * @generated
	 */
	EList<TuplePart> getParts();

} // TupleLiteralExp
