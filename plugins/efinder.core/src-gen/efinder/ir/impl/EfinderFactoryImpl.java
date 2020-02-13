/**
 */
package efinder.ir.impl;

import efinder.ir.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EfinderFactoryImpl extends EFactoryImpl implements EfinderFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EfinderFactory init() {
		try {
			EfinderFactory theEfinderFactory = (EfinderFactory)EPackage.Registry.INSTANCE.getEFactory(EfinderPackage.eNS_URI);
			if (theEfinderFactory != null) {
				return theEfinderFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EfinderFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EfinderFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EfinderPackage.SPECIFICATION: return createSpecification();
			case EfinderPackage.VARIABLE_DECLARATION: return createVariableDeclaration();
			case EfinderPackage.PARAMETER: return createParameter();
			case EfinderPackage.EF_METAMODEL: return createEFMetamodel();
			case EfinderPackage.EF_PACKAGE: return createEFPackage();
			case EfinderPackage.EF_CLASS: return createEFClass();
			case EfinderPackage.EF_PRIMITIVE_TYPE: return createEFPrimitiveType();
			case EfinderPackage.EF_ENUM: return createEFEnum();
			case EfinderPackage.EF_ENUM_LITERAL: return createEFEnumLiteral();
			case EfinderPackage.META_TYPE_REF: return createMetaTypeRef();
			case EfinderPackage.SET_TYPE_REF: return createSetTypeRef();
			case EfinderPackage.SEQUENCE_TYPE_REF: return createSequenceTypeRef();
			case EfinderPackage.BAG_TYPE_REF: return createBagTypeRef();
			case EfinderPackage.ORDERED_SET_TYPE_REF: return createOrderedSetTypeRef();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Specification createSpecification() {
		SpecificationImpl specification = new SpecificationImpl();
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableDeclaration createVariableDeclaration() {
		VariableDeclarationImpl variableDeclaration = new VariableDeclarationImpl();
		return variableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EFMetamodel createEFMetamodel() {
		EFMetamodelImpl efMetamodel = new EFMetamodelImpl();
		return efMetamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EFPackage createEFPackage() {
		EFPackageImpl efPackage = new EFPackageImpl();
		return efPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EFClass createEFClass() {
		EFClassImpl efClass = new EFClassImpl();
		return efClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EFPrimitiveType createEFPrimitiveType() {
		EFPrimitiveTypeImpl efPrimitiveType = new EFPrimitiveTypeImpl();
		return efPrimitiveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EFEnum createEFEnum() {
		EFEnumImpl efEnum = new EFEnumImpl();
		return efEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EFEnumLiteral createEFEnumLiteral() {
		EFEnumLiteralImpl efEnumLiteral = new EFEnumLiteralImpl();
		return efEnumLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetaTypeRef createMetaTypeRef() {
		MetaTypeRefImpl metaTypeRef = new MetaTypeRefImpl();
		return metaTypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SetTypeRef createSetTypeRef() {
		SetTypeRefImpl setTypeRef = new SetTypeRefImpl();
		return setTypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SequenceTypeRef createSequenceTypeRef() {
		SequenceTypeRefImpl sequenceTypeRef = new SequenceTypeRefImpl();
		return sequenceTypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BagTypeRef createBagTypeRef() {
		BagTypeRefImpl bagTypeRef = new BagTypeRefImpl();
		return bagTypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OrderedSetTypeRef createOrderedSetTypeRef() {
		OrderedSetTypeRefImpl orderedSetTypeRef = new OrderedSetTypeRefImpl();
		return orderedSetTypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EfinderPackage getEfinderPackage() {
		return (EfinderPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EfinderPackage getPackage() {
		return EfinderPackage.eINSTANCE;
	}

} //EfinderFactoryImpl
