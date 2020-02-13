/**
 */
package efinder.ir.ocl;

import org.eclipse.emf.ecore.EStructuralFeature;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.ocl.PropertyCallExp#getName <em>Name</em>}</li>
 *   <li>{@link efinder.ir.ocl.PropertyCallExp#getFeature <em>Feature</em>}</li>
 * </ul>
 *
 * @see efinder.ir.ocl.OclPackage#getPropertyCallExp()
 * @model
 * @generated
 */
public interface PropertyCallExp extends CallExp {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see efinder.ir.ocl.OclPackage#getPropertyCallExp_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.PropertyCallExp#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(EStructuralFeature)
	 * @see efinder.ir.ocl.OclPackage#getPropertyCallExp_Feature()
	 * @model transient="true"
	 * @generated
	 */
	EStructuralFeature getFeature();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.PropertyCallExp#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(EStructuralFeature value);

} // PropertyCallExp
