package efinder.usemv.ir;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;

import com.google.common.collect.ImmutableMap;

import efinder.core.visitor.AbstractIRVisitor;
import efinder.ir.EFClass;
import efinder.ir.EFEnum;
import efinder.ir.EFType;
import efinder.ir.ocl.BagLiteralExp;
import efinder.ir.ocl.BooleanLiteralExp;
import efinder.ir.ocl.CollectionCallExp;
import efinder.ir.ocl.EnumLiteralExp;
import efinder.ir.ocl.IfExp;
import efinder.ir.ocl.IntegerLiteralExp;
import efinder.ir.ocl.Iterator;
import efinder.ir.ocl.IteratorExp;
import efinder.ir.ocl.LetExp;
import efinder.ir.ocl.ModelElement;
import efinder.ir.ocl.OclExpression;
import efinder.ir.ocl.OclInvalid;
import efinder.ir.ocl.OclUndefined;
import efinder.ir.ocl.OperationCallExp;
import efinder.ir.ocl.OperatorCallExp;
import efinder.ir.ocl.OperatorKind;
import efinder.ir.ocl.OrderedSetLiteralExp;
import efinder.ir.ocl.PropertyCallExp;
import efinder.ir.ocl.RealLiteralExp;
import efinder.ir.ocl.SequenceLiteralExp;
import efinder.ir.ocl.SetLiteralExp;
import efinder.ir.ocl.StringLiteralExp;
import efinder.ir.ocl.VarExp;

public class UseExpressionsCompiler extends AbstractIRVisitor<Void, StringContext> {

	private @NonNull UseMapping mapping;

	public UseExpressionsCompiler(@NonNull UseMapping mapping) {
		this.mapping = mapping;
	}

	/* pp */ void compile(@NonNull OclExpression expr, @NonNull StringBuilder text) {
		visit(expr, new StringContext(text));
	}
	
	/* pp */ void compile(@NonNull OclExpression expr, @NonNull StringContext text) {
		visit(expr, text);
	}
		
	@Override
	public Void visitIfExp(IfExp self, StringContext input) {
		input.append("if ");
			compile(self.getCondition(), input);
		input.append(" then").newLine();
		input.indent();
			compile(self.getThen(), input); input.newLine();
		input.unindent();
		input.append("else").newLine();
		input.indent();
			compile(self.getElse(), input); input.newLine();
		input.unindent();
		input.append("endif").newLine();
		
		return null;
	}
	
	@Override
	public Void visitLetExp(LetExp self, StringContext input) {
		input.append("let ").append(toVariableName(self.getVariable().getName())).append(" = ");
			compile(self.getInit(), input);
		input.newLine().append(" in ");
		compile(self.getIn(), input);	
		return null;	
	}
	
	@Override
	public Void visitBooleanLiteralExp(BooleanLiteralExp self, StringContext input) {
		input.append(self.isValue());
		return null;
	}
		
	@Override
	public Void visitStringLiteralExp(StringLiteralExp self, StringContext input) {
		String str = mapping.addStringConstant(self.getValue());
		input.append("'").append(str).append("'");
		return null;
	}
	
	@Override
	public Void visitIntegerLiteralExp(IntegerLiteralExp self, StringContext input) {
		input.append(self.getValue());
		return null;
	}
	
	@Override
	public Void visitRealLiteralExp(RealLiteralExp self, StringContext input) {
		input.append(self.getValue());
		return null;
	}
	
	@Override
	public Void visitOclUndefined(OclUndefined self, StringContext input) {
		input.append("Undefined");
		return null;
	}
	
	@Override
	public Void visitOclInvalid(OclInvalid self, StringContext input) {
		// TODO: Report that we have this liberty here
		input.append("Undefined");
		return null;
	}
	
	@Override
	public Void visitEnumLiteralExp(EnumLiteralExp self, StringContext input) {
		String enumName = mapping.toUseTypeName((EFEnum) self.getEnum_().getType());
		String literal = mapping.toUseLiteralName(self.getLiteral());
		input.append(enumName).append("::").append(literal);
		return null;
	}
	
	@Override
	public Void visitVarExp(VarExp self, StringContext input) {
		input.append(toVariableName(self.getVariable().getName()));
		return null;
	}
	
	private ImmutableMap<OperatorKind, String> operators = ImmutableMap.<OperatorKind, String>builder().
			put(OperatorKind.AND, "and").
			put(OperatorKind.XOR, "xor").
			put(OperatorKind.OR, "or").
			put(OperatorKind.DISTINCT, "<>").
			put(OperatorKind.DIV, "/").
			put(OperatorKind.EQUAL, "=").
			put(OperatorKind.GREATER, ">").
			put(OperatorKind.GREATER_OR_EQUAL, ">=").
			put(OperatorKind.LESS, "<").
			put(OperatorKind.LESS_OR_EQUAL, "<=").
			put(OperatorKind.MINUS, "-").
			put(OperatorKind.MUL, "*").
			put(OperatorKind.PLUS, "+").
			put(OperatorKind.IMPLIES, "implies").
			build();
			
	@Override
	public Void visitOperatorCallExp(OperatorCallExp self, StringContext input) {
		if (self.getOperator() == OperatorKind.NOT) {
			input.append("not ");
			input.append("(");
				compile(self.getSource(), input);
			input.append(")");			
		} else {
			input.append("(");
				compile(self.getSource(), input);
			input.append(")");
			input.append(" ").append(operators.get(self.getOperator())).append(" ");
			input.append("(");
				compile(self.getArgument(), input);
			input.append(")");
		}
		return null;
	}
	
	@Override
	public Void visitPropertyCallExp(PropertyCallExp self, StringContext input) {
		compile(self.getSource(), input);
		String name = self.getName();
		EStructuralFeature feature = (EStructuralFeature) self.getFeature();
		if (feature instanceof EAttribute) {
			name = mapping.toUsePropertyName((EAttribute) feature);
		} else if (feature instanceof EReference) {
			name = mapping.toUsePropertyName((EReference) feature);
		}
		// If we don't have a pointer, we just use the name... 
		// TODO: Maybe use the reserved words and the mapping anyway?
		input.append(".").append(name);
		return null;
	}
		
	@Override
	public Void visitCollectionCallExp(CollectionCallExp self, StringContext input) {
		compile(self.getSource(), input);
		input.append("->");	
		compileCallSignature(self.getName(), self.getArguments(), input);	
		return null;
	}
	
	@Override
	public Void visitIteratorExp(IteratorExp self, StringContext input) {
		compile(self.getSource(), input);
		input.append("->").append(self.getName()).append("(");
		String sep = "";
		for (Iterator it : self.getIterators()) {
			input.append(sep).append(toVariableName(it.getName()));
			sep = ", ";
		}
		input.append("| ");
		compile(self.getBody(), input);
		input.append(")");
		return null;
	}
	
	@Override
	public Void visitSetLiteralExp(SetLiteralExp self, StringContext input) {
		return toCollectionLiteralExp("Set", self.getParts(), input);
	}
	
	@Override
	public Void visitSequenceLiteralExp(SequenceLiteralExp self, StringContext input) {
		return toCollectionLiteralExp("Sequence", self.getParts(), input);
	}
	
	@Override
	public Void visitBagLiteralExp(BagLiteralExp self, StringContext input) {
		return toCollectionLiteralExp("Bag", self.getParts(), input);
	}
	
	@Override
	public Void visitOrderedSetLiteralExp(OrderedSetLiteralExp self, StringContext input) {
		return toCollectionLiteralExp("OrderedSet", self.getParts(), input);
	}
	
	private Void toCollectionLiteralExp(@NonNull String name, List<? extends OclExpression> parts, StringContext input) {
		input.append(name).append(" { ");
		String sep = "";
		for (OclExpression exp : parts) {
			input.append(sep);
			compile(exp, input);
			sep = ", ";
		}
		input.append(" }");
		return null;
	}

	private String toVariableName(String name) {
		// This possibly broader than needed, but this way we are on the safe side
		if (! Character.isAlphabetic(name.charAt(0))) {
			return "v_" + name;
		}
		return name;
	}

	@Override
	public Void visitOperationCallExp(OperationCallExp self, StringContext input) {
		// TODO: Compile arguments
		compile(self.getSource(), input);
		input.append(".");
		compileCallSignature(self.getName(), self.getArguments(), input);
		return null;
	}

	private void compileCallSignature(String name, List<? extends OclExpression> arguments, StringContext input) {
		input.append(name).append("(");
		String separator = "";
		for (OclExpression arg : arguments) {
			input.append(separator);
			compile(arg, input);			
			separator = ", ";
	    }						
		input.append(")");
	}

	@Override
	public Void visitModelElement(ModelElement self, StringContext input) {
		input.append(toClassName(self.getType()));
		return null;
	}

	@NonNull
	private String toClassName(@NonNull EFType type) {
		// TODO: Use the normalizer for this
		if (type instanceof EFClass) {
			return mapping.toUseTypeName((EFClass) type);
		}
		throw new UnsupportedOperationException();
	}
}
