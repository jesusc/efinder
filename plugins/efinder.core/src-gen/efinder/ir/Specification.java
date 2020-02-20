/**
 */
package efinder.ir;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.Specification#getMetamodels <em>Metamodels</em>}</li>
 *   <li>{@link efinder.ir.Specification#getConstaints <em>Constaints</em>}</li>
 *   <li>{@link efinder.ir.Specification#getTemporary <em>Temporary</em>}</li>
 *   <li>{@link efinder.ir.Specification#getProperties <em>Properties</em>}</li>
 *   <li>{@link efinder.ir.Specification#getOperations <em>Operations</em>}</li>
 *   <li>{@link efinder.ir.Specification#getPrimitiveTypes <em>Primitive Types</em>}</li>
 *   <li>{@link efinder.ir.Specification#getTupleTypes <em>Tuple Types</em>}</li>
 * </ul>
 *
 * @see efinder.ir.EfinderPackage#getSpecification()
 * @model
 * @generated
 */
public interface Specification extends EObject {
	/**
	 * Returns the value of the '<em><b>Metamodels</b></em>' containment reference list.
	 * The list contents are of type {@link efinder.ir.EFMetamodel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodels</em>' containment reference list.
	 * @see efinder.ir.EfinderPackage#getSpecification_Metamodels()
	 * @model containment="true"
	 * @generated
	 */
	EList<EFMetamodel> getMetamodels();

	/**
	 * Returns the value of the '<em><b>Constaints</b></em>' containment reference list.
	 * The list contents are of type {@link efinder.ir.Constraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constaints</em>' containment reference list.
	 * @see efinder.ir.EfinderPackage#getSpecification_Constaints()
	 * @model containment="true"
	 * @generated
	 */
	EList<Constraint> getConstaints();

	/**
	 * Returns the value of the '<em><b>Temporary</b></em>' containment reference list.
	 * The list contents are of type {@link efinder.ir.EFClass}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Temporary</em>' containment reference list.
	 * @see efinder.ir.EfinderPackage#getSpecification_Temporary()
	 * @model containment="true"
	 * @generated
	 */
	EList<EFClass> getTemporary();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link efinder.ir.DerivedProperty}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see efinder.ir.EfinderPackage#getSpecification_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<DerivedProperty> getProperties();

	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
	 * The list contents are of type {@link efinder.ir.Operation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' containment reference list.
	 * @see efinder.ir.EfinderPackage#getSpecification_Operations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Operation> getOperations();

	/**
	 * Returns the value of the '<em><b>Primitive Types</b></em>' containment reference list.
	 * The list contents are of type {@link efinder.ir.EFPrimitiveType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive Types</em>' containment reference list.
	 * @see efinder.ir.EfinderPackage#getSpecification_PrimitiveTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<EFPrimitiveType> getPrimitiveTypes();

	/**
	 * Returns the value of the '<em><b>Tuple Types</b></em>' containment reference list.
	 * The list contents are of type {@link efinder.ir.EFTupleType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tuple Types</em>' containment reference list.
	 * @see efinder.ir.EfinderPackage#getSpecification_TupleTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<EFTupleType> getTupleTypes();

} // Specification
