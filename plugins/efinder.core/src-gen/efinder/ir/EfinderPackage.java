/**
 */
package efinder.ir;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see efinder.ir.EfinderFactory
 * @model kind="package"
 * @generated
 */
public interface EfinderPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ir";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://efinder/ir";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "efinder_ir";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EfinderPackage eINSTANCE = efinder.ir.impl.EfinderPackageImpl.init();

	/**
	 * The meta object id for the '{@link efinder.ir.impl.SpecificationImpl <em>Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see efinder.ir.impl.SpecificationImpl
	 * @see efinder.ir.impl.EfinderPackageImpl#getSpecification()
	 * @generated
	 */
	int SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Metamodels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__METAMODELS = 0;

	/**
	 * The feature id for the '<em><b>Constaints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__CONSTAINTS = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__PROPERTIES = 2;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__OPERATIONS = 3;

	/**
	 * The feature id for the '<em><b>Primitive Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__PRIMITIVE_TYPES = 4;

	/**
	 * The number of structural features of the '<em>Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link efinder.ir.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see efinder.ir.impl.ConstraintImpl
	 * @see efinder.ir.impl.EfinderPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 1;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link efinder.ir.impl.TypedElementImpl <em>Typed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see efinder.ir.impl.TypedElementImpl
	 * @see efinder.ir.impl.EfinderPackageImpl#getTypedElement()
	 * @generated
	 */
	int TYPED_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__TYPE = 0;

	/**
	 * The number of structural features of the '<em>Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link efinder.ir.impl.AbstractFunctionImpl <em>Abstract Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see efinder.ir.impl.AbstractFunctionImpl
	 * @see efinder.ir.impl.EfinderPackageImpl#getAbstractFunction()
	 * @generated
	 */
	int ABSTRACT_FUNCTION = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FUNCTION__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FUNCTION__NAME = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FUNCTION__CONTEXT = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Abstract Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FUNCTION_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Abstract Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FUNCTION_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link efinder.ir.impl.DerivedPropertyImpl <em>Derived Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see efinder.ir.impl.DerivedPropertyImpl
	 * @see efinder.ir.impl.EfinderPackageImpl#getDerivedProperty()
	 * @generated
	 */
	int DERIVED_PROPERTY = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_PROPERTY__TYPE = ABSTRACT_FUNCTION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_PROPERTY__NAME = ABSTRACT_FUNCTION__NAME;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_PROPERTY__CONTEXT = ABSTRACT_FUNCTION__CONTEXT;

	/**
	 * The number of structural features of the '<em>Derived Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_PROPERTY_FEATURE_COUNT = ABSTRACT_FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Derived Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_PROPERTY_OPERATION_COUNT = ABSTRACT_FUNCTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link efinder.ir.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see efinder.ir.impl.OperationImpl
	 * @see efinder.ir.impl.EfinderPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__TYPE = ABSTRACT_FUNCTION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__NAME = ABSTRACT_FUNCTION__NAME;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__CONTEXT = ABSTRACT_FUNCTION__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__PARAMETERS = ABSTRACT_FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = ABSTRACT_FUNCTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_OPERATION_COUNT = ABSTRACT_FUNCTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link efinder.ir.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see efinder.ir.impl.VariableDeclarationImpl
	 * @see efinder.ir.impl.EfinderPackageImpl#getVariableDeclaration()
	 * @generated
	 */
	int VARIABLE_DECLARATION = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link efinder.ir.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see efinder.ir.impl.ParameterImpl
	 * @see efinder.ir.impl.EfinderPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = VARIABLE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = VARIABLE_DECLARATION__TYPE;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = VARIABLE_DECLARATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link efinder.ir.impl.EFMetamodelImpl <em>EF Metamodel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see efinder.ir.impl.EFMetamodelImpl
	 * @see efinder.ir.impl.EfinderPackageImpl#getEFMetamodel()
	 * @generated
	 */
	int EF_METAMODEL = 8;

	/**
	 * The feature id for the '<em><b>Roots</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_METAMODEL__ROOTS = 0;

	/**
	 * The number of structural features of the '<em>EF Metamodel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_METAMODEL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>EF Metamodel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_METAMODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link efinder.ir.impl.EFPackageImpl <em>EF Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see efinder.ir.impl.EFPackageImpl
	 * @see efinder.ir.impl.EfinderPackageImpl#getEFPackage()
	 * @generated
	 */
	int EF_PACKAGE = 9;

	/**
	 * The feature id for the '<em><b>Pkg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_PACKAGE__PKG = 0;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_PACKAGE__CLASSES = 1;

	/**
	 * The feature id for the '<em><b>Enumerations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_PACKAGE__ENUMERATIONS = 2;

	/**
	 * The number of structural features of the '<em>EF Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_PACKAGE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>EF Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_PACKAGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link efinder.ir.impl.EFTypeImpl <em>EF Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see efinder.ir.impl.EFTypeImpl
	 * @see efinder.ir.impl.EfinderPackageImpl#getEFType()
	 * @generated
	 */
	int EF_TYPE = 10;

	/**
	 * The number of structural features of the '<em>EF Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_TYPE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>EF Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link efinder.ir.impl.EFClassImpl <em>EF Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see efinder.ir.impl.EFClassImpl
	 * @see efinder.ir.impl.EfinderPackageImpl#getEFClass()
	 * @generated
	 */
	int EF_CLASS = 11;

	/**
	 * The feature id for the '<em><b>Klass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_CLASS__KLASS = EF_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EF Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_CLASS_FEATURE_COUNT = EF_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>EF Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_CLASS_OPERATION_COUNT = EF_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link efinder.ir.impl.EFPrimitiveTypeImpl <em>EF Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see efinder.ir.impl.EFPrimitiveTypeImpl
	 * @see efinder.ir.impl.EfinderPackageImpl#getEFPrimitiveType()
	 * @generated
	 */
	int EF_PRIMITIVE_TYPE = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_PRIMITIVE_TYPE__NAME = EF_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EF Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_PRIMITIVE_TYPE_FEATURE_COUNT = EF_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>EF Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_PRIMITIVE_TYPE_OPERATION_COUNT = EF_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link efinder.ir.impl.EFEnumImpl <em>EF Enum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see efinder.ir.impl.EFEnumImpl
	 * @see efinder.ir.impl.EfinderPackageImpl#getEFEnum()
	 * @generated
	 */
	int EF_ENUM = 13;

	/**
	 * The feature id for the '<em><b>Enum </b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_ENUM__ENUM_ = EF_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_ENUM__LITERALS = EF_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EF Enum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_ENUM_FEATURE_COUNT = EF_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>EF Enum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_ENUM_OPERATION_COUNT = EF_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link efinder.ir.impl.EFEnumLiteralImpl <em>EF Enum Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see efinder.ir.impl.EFEnumLiteralImpl
	 * @see efinder.ir.impl.EfinderPackageImpl#getEFEnumLiteral()
	 * @generated
	 */
	int EF_ENUM_LITERAL = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_ENUM_LITERAL__NAME = 0;

	/**
	 * The number of structural features of the '<em>EF Enum Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_ENUM_LITERAL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>EF Enum Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_ENUM_LITERAL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link efinder.ir.impl.TypeRefImpl <em>Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see efinder.ir.impl.TypeRefImpl
	 * @see efinder.ir.impl.EfinderPackageImpl#getTypeRef()
	 * @generated
	 */
	int TYPE_REF = 15;

	/**
	 * The number of structural features of the '<em>Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link efinder.ir.impl.MetaTypeRefImpl <em>Meta Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see efinder.ir.impl.MetaTypeRefImpl
	 * @see efinder.ir.impl.EfinderPackageImpl#getMetaTypeRef()
	 * @generated
	 */
	int META_TYPE_REF = 16;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_TYPE_REF__TYPE = TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Meta Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_TYPE_REF_FEATURE_COUNT = TYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Meta Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_TYPE_REF_OPERATION_COUNT = TYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link efinder.ir.impl.CollectionTypeRefImpl <em>Collection Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see efinder.ir.impl.CollectionTypeRefImpl
	 * @see efinder.ir.impl.EfinderPackageImpl#getCollectionTypeRef()
	 * @generated
	 */
	int COLLECTION_TYPE_REF = 17;

	/**
	 * The feature id for the '<em><b>Contained Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_REF__CONTAINED_TYPE = TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Collection Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_REF_FEATURE_COUNT = TYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Collection Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_REF_OPERATION_COUNT = TYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link efinder.ir.impl.SetTypeRefImpl <em>Set Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see efinder.ir.impl.SetTypeRefImpl
	 * @see efinder.ir.impl.EfinderPackageImpl#getSetTypeRef()
	 * @generated
	 */
	int SET_TYPE_REF = 18;

	/**
	 * The feature id for the '<em><b>Contained Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_REF__CONTAINED_TYPE = COLLECTION_TYPE_REF__CONTAINED_TYPE;

	/**
	 * The number of structural features of the '<em>Set Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_REF_FEATURE_COUNT = COLLECTION_TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Set Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_REF_OPERATION_COUNT = COLLECTION_TYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link efinder.ir.impl.SequenceTypeRefImpl <em>Sequence Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see efinder.ir.impl.SequenceTypeRefImpl
	 * @see efinder.ir.impl.EfinderPackageImpl#getSequenceTypeRef()
	 * @generated
	 */
	int SEQUENCE_TYPE_REF = 19;

	/**
	 * The feature id for the '<em><b>Contained Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_REF__CONTAINED_TYPE = COLLECTION_TYPE_REF__CONTAINED_TYPE;

	/**
	 * The number of structural features of the '<em>Sequence Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_REF_FEATURE_COUNT = COLLECTION_TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Sequence Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_REF_OPERATION_COUNT = COLLECTION_TYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link efinder.ir.impl.BagTypeRefImpl <em>Bag Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see efinder.ir.impl.BagTypeRefImpl
	 * @see efinder.ir.impl.EfinderPackageImpl#getBagTypeRef()
	 * @generated
	 */
	int BAG_TYPE_REF = 20;

	/**
	 * The feature id for the '<em><b>Contained Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_REF__CONTAINED_TYPE = COLLECTION_TYPE_REF__CONTAINED_TYPE;

	/**
	 * The number of structural features of the '<em>Bag Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_REF_FEATURE_COUNT = COLLECTION_TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Bag Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_REF_OPERATION_COUNT = COLLECTION_TYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link efinder.ir.impl.OrderedSetTypeRefImpl <em>Ordered Set Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see efinder.ir.impl.OrderedSetTypeRefImpl
	 * @see efinder.ir.impl.EfinderPackageImpl#getOrderedSetTypeRef()
	 * @generated
	 */
	int ORDERED_SET_TYPE_REF = 21;

	/**
	 * The feature id for the '<em><b>Contained Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_REF__CONTAINED_TYPE = COLLECTION_TYPE_REF__CONTAINED_TYPE;

	/**
	 * The number of structural features of the '<em>Ordered Set Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_REF_FEATURE_COUNT = COLLECTION_TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Ordered Set Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_REF_OPERATION_COUNT = COLLECTION_TYPE_REF_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link efinder.ir.Specification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specification</em>'.
	 * @see efinder.ir.Specification
	 * @generated
	 */
	EClass getSpecification();

	/**
	 * Returns the meta object for the containment reference list '{@link efinder.ir.Specification#getMetamodels <em>Metamodels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metamodels</em>'.
	 * @see efinder.ir.Specification#getMetamodels()
	 * @see #getSpecification()
	 * @generated
	 */
	EReference getSpecification_Metamodels();

	/**
	 * Returns the meta object for the containment reference list '{@link efinder.ir.Specification#getConstaints <em>Constaints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constaints</em>'.
	 * @see efinder.ir.Specification#getConstaints()
	 * @see #getSpecification()
	 * @generated
	 */
	EReference getSpecification_Constaints();

	/**
	 * Returns the meta object for the containment reference list '{@link efinder.ir.Specification#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see efinder.ir.Specification#getProperties()
	 * @see #getSpecification()
	 * @generated
	 */
	EReference getSpecification_Properties();

	/**
	 * Returns the meta object for the containment reference list '{@link efinder.ir.Specification#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see efinder.ir.Specification#getOperations()
	 * @see #getSpecification()
	 * @generated
	 */
	EReference getSpecification_Operations();

	/**
	 * Returns the meta object for the containment reference list '{@link efinder.ir.Specification#getPrimitiveTypes <em>Primitive Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Primitive Types</em>'.
	 * @see efinder.ir.Specification#getPrimitiveTypes()
	 * @see #getSpecification()
	 * @generated
	 */
	EReference getSpecification_PrimitiveTypes();

	/**
	 * Returns the meta object for class '{@link efinder.ir.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see efinder.ir.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for class '{@link efinder.ir.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Element</em>'.
	 * @see efinder.ir.TypedElement
	 * @generated
	 */
	EClass getTypedElement();

	/**
	 * Returns the meta object for the containment reference '{@link efinder.ir.TypedElement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see efinder.ir.TypedElement#getType()
	 * @see #getTypedElement()
	 * @generated
	 */
	EReference getTypedElement_Type();

	/**
	 * Returns the meta object for class '{@link efinder.ir.AbstractFunction <em>Abstract Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Function</em>'.
	 * @see efinder.ir.AbstractFunction
	 * @generated
	 */
	EClass getAbstractFunction();

	/**
	 * Returns the meta object for the attribute '{@link efinder.ir.AbstractFunction#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see efinder.ir.AbstractFunction#getName()
	 * @see #getAbstractFunction()
	 * @generated
	 */
	EAttribute getAbstractFunction_Name();

	/**
	 * Returns the meta object for the reference '{@link efinder.ir.AbstractFunction#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see efinder.ir.AbstractFunction#getContext()
	 * @see #getAbstractFunction()
	 * @generated
	 */
	EReference getAbstractFunction_Context();

	/**
	 * Returns the meta object for class '{@link efinder.ir.DerivedProperty <em>Derived Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Derived Property</em>'.
	 * @see efinder.ir.DerivedProperty
	 * @generated
	 */
	EClass getDerivedProperty();

	/**
	 * Returns the meta object for class '{@link efinder.ir.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see efinder.ir.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the containment reference list '{@link efinder.ir.Operation#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see efinder.ir.Operation#getParameters()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Parameters();

	/**
	 * Returns the meta object for class '{@link efinder.ir.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration</em>'.
	 * @see efinder.ir.VariableDeclaration
	 * @generated
	 */
	EClass getVariableDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link efinder.ir.VariableDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see efinder.ir.VariableDeclaration#getName()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EAttribute getVariableDeclaration_Name();

	/**
	 * Returns the meta object for the containment reference '{@link efinder.ir.VariableDeclaration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see efinder.ir.VariableDeclaration#getType()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_Type();

	/**
	 * Returns the meta object for class '{@link efinder.ir.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see efinder.ir.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for class '{@link efinder.ir.EFMetamodel <em>EF Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EF Metamodel</em>'.
	 * @see efinder.ir.EFMetamodel
	 * @generated
	 */
	EClass getEFMetamodel();

	/**
	 * Returns the meta object for the containment reference list '{@link efinder.ir.EFMetamodel#getRoots <em>Roots</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Roots</em>'.
	 * @see efinder.ir.EFMetamodel#getRoots()
	 * @see #getEFMetamodel()
	 * @generated
	 */
	EReference getEFMetamodel_Roots();

	/**
	 * Returns the meta object for class '{@link efinder.ir.EFPackage <em>EF Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EF Package</em>'.
	 * @see efinder.ir.EFPackage
	 * @generated
	 */
	EClass getEFPackage();

	/**
	 * Returns the meta object for the reference '{@link efinder.ir.EFPackage#getPkg <em>Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pkg</em>'.
	 * @see efinder.ir.EFPackage#getPkg()
	 * @see #getEFPackage()
	 * @generated
	 */
	EReference getEFPackage_Pkg();

	/**
	 * Returns the meta object for the containment reference list '{@link efinder.ir.EFPackage#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see efinder.ir.EFPackage#getClasses()
	 * @see #getEFPackage()
	 * @generated
	 */
	EReference getEFPackage_Classes();

	/**
	 * Returns the meta object for the containment reference list '{@link efinder.ir.EFPackage#getEnumerations <em>Enumerations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Enumerations</em>'.
	 * @see efinder.ir.EFPackage#getEnumerations()
	 * @see #getEFPackage()
	 * @generated
	 */
	EReference getEFPackage_Enumerations();

	/**
	 * Returns the meta object for class '{@link efinder.ir.EFType <em>EF Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EF Type</em>'.
	 * @see efinder.ir.EFType
	 * @generated
	 */
	EClass getEFType();

	/**
	 * Returns the meta object for class '{@link efinder.ir.EFClass <em>EF Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EF Class</em>'.
	 * @see efinder.ir.EFClass
	 * @generated
	 */
	EClass getEFClass();

	/**
	 * Returns the meta object for the reference '{@link efinder.ir.EFClass#getKlass <em>Klass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Klass</em>'.
	 * @see efinder.ir.EFClass#getKlass()
	 * @see #getEFClass()
	 * @generated
	 */
	EReference getEFClass_Klass();

	/**
	 * Returns the meta object for class '{@link efinder.ir.EFPrimitiveType <em>EF Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EF Primitive Type</em>'.
	 * @see efinder.ir.EFPrimitiveType
	 * @generated
	 */
	EClass getEFPrimitiveType();

	/**
	 * Returns the meta object for the attribute '{@link efinder.ir.EFPrimitiveType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see efinder.ir.EFPrimitiveType#getName()
	 * @see #getEFPrimitiveType()
	 * @generated
	 */
	EAttribute getEFPrimitiveType_Name();

	/**
	 * Returns the meta object for class '{@link efinder.ir.EFEnum <em>EF Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EF Enum</em>'.
	 * @see efinder.ir.EFEnum
	 * @generated
	 */
	EClass getEFEnum();

	/**
	 * Returns the meta object for the reference '{@link efinder.ir.EFEnum#getEnum_ <em>Enum </em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Enum </em>'.
	 * @see efinder.ir.EFEnum#getEnum_()
	 * @see #getEFEnum()
	 * @generated
	 */
	EReference getEFEnum_Enum_();

	/**
	 * Returns the meta object for the containment reference list '{@link efinder.ir.EFEnum#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literals</em>'.
	 * @see efinder.ir.EFEnum#getLiterals()
	 * @see #getEFEnum()
	 * @generated
	 */
	EReference getEFEnum_Literals();

	/**
	 * Returns the meta object for class '{@link efinder.ir.EFEnumLiteral <em>EF Enum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EF Enum Literal</em>'.
	 * @see efinder.ir.EFEnumLiteral
	 * @generated
	 */
	EClass getEFEnumLiteral();

	/**
	 * Returns the meta object for the attribute '{@link efinder.ir.EFEnumLiteral#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see efinder.ir.EFEnumLiteral#getName()
	 * @see #getEFEnumLiteral()
	 * @generated
	 */
	EAttribute getEFEnumLiteral_Name();

	/**
	 * Returns the meta object for class '{@link efinder.ir.TypeRef <em>Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Ref</em>'.
	 * @see efinder.ir.TypeRef
	 * @generated
	 */
	EClass getTypeRef();

	/**
	 * Returns the meta object for class '{@link efinder.ir.MetaTypeRef <em>Meta Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta Type Ref</em>'.
	 * @see efinder.ir.MetaTypeRef
	 * @generated
	 */
	EClass getMetaTypeRef();

	/**
	 * Returns the meta object for the reference '{@link efinder.ir.MetaTypeRef#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see efinder.ir.MetaTypeRef#getType()
	 * @see #getMetaTypeRef()
	 * @generated
	 */
	EReference getMetaTypeRef_Type();

	/**
	 * Returns the meta object for class '{@link efinder.ir.CollectionTypeRef <em>Collection Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Type Ref</em>'.
	 * @see efinder.ir.CollectionTypeRef
	 * @generated
	 */
	EClass getCollectionTypeRef();

	/**
	 * Returns the meta object for the containment reference '{@link efinder.ir.CollectionTypeRef#getContainedType <em>Contained Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Contained Type</em>'.
	 * @see efinder.ir.CollectionTypeRef#getContainedType()
	 * @see #getCollectionTypeRef()
	 * @generated
	 */
	EReference getCollectionTypeRef_ContainedType();

	/**
	 * Returns the meta object for class '{@link efinder.ir.SetTypeRef <em>Set Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Type Ref</em>'.
	 * @see efinder.ir.SetTypeRef
	 * @generated
	 */
	EClass getSetTypeRef();

	/**
	 * Returns the meta object for class '{@link efinder.ir.SequenceTypeRef <em>Sequence Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Type Ref</em>'.
	 * @see efinder.ir.SequenceTypeRef
	 * @generated
	 */
	EClass getSequenceTypeRef();

	/**
	 * Returns the meta object for class '{@link efinder.ir.BagTypeRef <em>Bag Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bag Type Ref</em>'.
	 * @see efinder.ir.BagTypeRef
	 * @generated
	 */
	EClass getBagTypeRef();

	/**
	 * Returns the meta object for class '{@link efinder.ir.OrderedSetTypeRef <em>Ordered Set Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordered Set Type Ref</em>'.
	 * @see efinder.ir.OrderedSetTypeRef
	 * @generated
	 */
	EClass getOrderedSetTypeRef();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EfinderFactory getEfinderFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link efinder.ir.impl.SpecificationImpl <em>Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see efinder.ir.impl.SpecificationImpl
		 * @see efinder.ir.impl.EfinderPackageImpl#getSpecification()
		 * @generated
		 */
		EClass SPECIFICATION = eINSTANCE.getSpecification();

		/**
		 * The meta object literal for the '<em><b>Metamodels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFICATION__METAMODELS = eINSTANCE.getSpecification_Metamodels();

		/**
		 * The meta object literal for the '<em><b>Constaints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFICATION__CONSTAINTS = eINSTANCE.getSpecification_Constaints();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFICATION__PROPERTIES = eINSTANCE.getSpecification_Properties();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFICATION__OPERATIONS = eINSTANCE.getSpecification_Operations();

		/**
		 * The meta object literal for the '<em><b>Primitive Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFICATION__PRIMITIVE_TYPES = eINSTANCE.getSpecification_PrimitiveTypes();

		/**
		 * The meta object literal for the '{@link efinder.ir.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see efinder.ir.impl.ConstraintImpl
		 * @see efinder.ir.impl.EfinderPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '{@link efinder.ir.impl.TypedElementImpl <em>Typed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see efinder.ir.impl.TypedElementImpl
		 * @see efinder.ir.impl.EfinderPackageImpl#getTypedElement()
		 * @generated
		 */
		EClass TYPED_ELEMENT = eINSTANCE.getTypedElement();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_ELEMENT__TYPE = eINSTANCE.getTypedElement_Type();

		/**
		 * The meta object literal for the '{@link efinder.ir.impl.AbstractFunctionImpl <em>Abstract Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see efinder.ir.impl.AbstractFunctionImpl
		 * @see efinder.ir.impl.EfinderPackageImpl#getAbstractFunction()
		 * @generated
		 */
		EClass ABSTRACT_FUNCTION = eINSTANCE.getAbstractFunction();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_FUNCTION__NAME = eINSTANCE.getAbstractFunction_Name();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_FUNCTION__CONTEXT = eINSTANCE.getAbstractFunction_Context();

		/**
		 * The meta object literal for the '{@link efinder.ir.impl.DerivedPropertyImpl <em>Derived Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see efinder.ir.impl.DerivedPropertyImpl
		 * @see efinder.ir.impl.EfinderPackageImpl#getDerivedProperty()
		 * @generated
		 */
		EClass DERIVED_PROPERTY = eINSTANCE.getDerivedProperty();

		/**
		 * The meta object literal for the '{@link efinder.ir.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see efinder.ir.impl.OperationImpl
		 * @see efinder.ir.impl.EfinderPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__PARAMETERS = eINSTANCE.getOperation_Parameters();

		/**
		 * The meta object literal for the '{@link efinder.ir.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see efinder.ir.impl.VariableDeclarationImpl
		 * @see efinder.ir.impl.EfinderPackageImpl#getVariableDeclaration()
		 * @generated
		 */
		EClass VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_DECLARATION__NAME = eINSTANCE.getVariableDeclaration_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DECLARATION__TYPE = eINSTANCE.getVariableDeclaration_Type();

		/**
		 * The meta object literal for the '{@link efinder.ir.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see efinder.ir.impl.ParameterImpl
		 * @see efinder.ir.impl.EfinderPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '{@link efinder.ir.impl.EFMetamodelImpl <em>EF Metamodel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see efinder.ir.impl.EFMetamodelImpl
		 * @see efinder.ir.impl.EfinderPackageImpl#getEFMetamodel()
		 * @generated
		 */
		EClass EF_METAMODEL = eINSTANCE.getEFMetamodel();

		/**
		 * The meta object literal for the '<em><b>Roots</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EF_METAMODEL__ROOTS = eINSTANCE.getEFMetamodel_Roots();

		/**
		 * The meta object literal for the '{@link efinder.ir.impl.EFPackageImpl <em>EF Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see efinder.ir.impl.EFPackageImpl
		 * @see efinder.ir.impl.EfinderPackageImpl#getEFPackage()
		 * @generated
		 */
		EClass EF_PACKAGE = eINSTANCE.getEFPackage();

		/**
		 * The meta object literal for the '<em><b>Pkg</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EF_PACKAGE__PKG = eINSTANCE.getEFPackage_Pkg();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EF_PACKAGE__CLASSES = eINSTANCE.getEFPackage_Classes();

		/**
		 * The meta object literal for the '<em><b>Enumerations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EF_PACKAGE__ENUMERATIONS = eINSTANCE.getEFPackage_Enumerations();

		/**
		 * The meta object literal for the '{@link efinder.ir.impl.EFTypeImpl <em>EF Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see efinder.ir.impl.EFTypeImpl
		 * @see efinder.ir.impl.EfinderPackageImpl#getEFType()
		 * @generated
		 */
		EClass EF_TYPE = eINSTANCE.getEFType();

		/**
		 * The meta object literal for the '{@link efinder.ir.impl.EFClassImpl <em>EF Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see efinder.ir.impl.EFClassImpl
		 * @see efinder.ir.impl.EfinderPackageImpl#getEFClass()
		 * @generated
		 */
		EClass EF_CLASS = eINSTANCE.getEFClass();

		/**
		 * The meta object literal for the '<em><b>Klass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EF_CLASS__KLASS = eINSTANCE.getEFClass_Klass();

		/**
		 * The meta object literal for the '{@link efinder.ir.impl.EFPrimitiveTypeImpl <em>EF Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see efinder.ir.impl.EFPrimitiveTypeImpl
		 * @see efinder.ir.impl.EfinderPackageImpl#getEFPrimitiveType()
		 * @generated
		 */
		EClass EF_PRIMITIVE_TYPE = eINSTANCE.getEFPrimitiveType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EF_PRIMITIVE_TYPE__NAME = eINSTANCE.getEFPrimitiveType_Name();

		/**
		 * The meta object literal for the '{@link efinder.ir.impl.EFEnumImpl <em>EF Enum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see efinder.ir.impl.EFEnumImpl
		 * @see efinder.ir.impl.EfinderPackageImpl#getEFEnum()
		 * @generated
		 */
		EClass EF_ENUM = eINSTANCE.getEFEnum();

		/**
		 * The meta object literal for the '<em><b>Enum </b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EF_ENUM__ENUM_ = eINSTANCE.getEFEnum_Enum_();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EF_ENUM__LITERALS = eINSTANCE.getEFEnum_Literals();

		/**
		 * The meta object literal for the '{@link efinder.ir.impl.EFEnumLiteralImpl <em>EF Enum Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see efinder.ir.impl.EFEnumLiteralImpl
		 * @see efinder.ir.impl.EfinderPackageImpl#getEFEnumLiteral()
		 * @generated
		 */
		EClass EF_ENUM_LITERAL = eINSTANCE.getEFEnumLiteral();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EF_ENUM_LITERAL__NAME = eINSTANCE.getEFEnumLiteral_Name();

		/**
		 * The meta object literal for the '{@link efinder.ir.impl.TypeRefImpl <em>Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see efinder.ir.impl.TypeRefImpl
		 * @see efinder.ir.impl.EfinderPackageImpl#getTypeRef()
		 * @generated
		 */
		EClass TYPE_REF = eINSTANCE.getTypeRef();

		/**
		 * The meta object literal for the '{@link efinder.ir.impl.MetaTypeRefImpl <em>Meta Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see efinder.ir.impl.MetaTypeRefImpl
		 * @see efinder.ir.impl.EfinderPackageImpl#getMetaTypeRef()
		 * @generated
		 */
		EClass META_TYPE_REF = eINSTANCE.getMetaTypeRef();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META_TYPE_REF__TYPE = eINSTANCE.getMetaTypeRef_Type();

		/**
		 * The meta object literal for the '{@link efinder.ir.impl.CollectionTypeRefImpl <em>Collection Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see efinder.ir.impl.CollectionTypeRefImpl
		 * @see efinder.ir.impl.EfinderPackageImpl#getCollectionTypeRef()
		 * @generated
		 */
		EClass COLLECTION_TYPE_REF = eINSTANCE.getCollectionTypeRef();

		/**
		 * The meta object literal for the '<em><b>Contained Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TYPE_REF__CONTAINED_TYPE = eINSTANCE.getCollectionTypeRef_ContainedType();

		/**
		 * The meta object literal for the '{@link efinder.ir.impl.SetTypeRefImpl <em>Set Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see efinder.ir.impl.SetTypeRefImpl
		 * @see efinder.ir.impl.EfinderPackageImpl#getSetTypeRef()
		 * @generated
		 */
		EClass SET_TYPE_REF = eINSTANCE.getSetTypeRef();

		/**
		 * The meta object literal for the '{@link efinder.ir.impl.SequenceTypeRefImpl <em>Sequence Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see efinder.ir.impl.SequenceTypeRefImpl
		 * @see efinder.ir.impl.EfinderPackageImpl#getSequenceTypeRef()
		 * @generated
		 */
		EClass SEQUENCE_TYPE_REF = eINSTANCE.getSequenceTypeRef();

		/**
		 * The meta object literal for the '{@link efinder.ir.impl.BagTypeRefImpl <em>Bag Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see efinder.ir.impl.BagTypeRefImpl
		 * @see efinder.ir.impl.EfinderPackageImpl#getBagTypeRef()
		 * @generated
		 */
		EClass BAG_TYPE_REF = eINSTANCE.getBagTypeRef();

		/**
		 * The meta object literal for the '{@link efinder.ir.impl.OrderedSetTypeRefImpl <em>Ordered Set Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see efinder.ir.impl.OrderedSetTypeRefImpl
		 * @see efinder.ir.impl.EfinderPackageImpl#getOrderedSetTypeRef()
		 * @generated
		 */
		EClass ORDERED_SET_TYPE_REF = eINSTANCE.getOrderedSetTypeRef();

	}

} //EfinderPackage