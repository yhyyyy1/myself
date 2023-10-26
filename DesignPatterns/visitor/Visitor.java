package visitor;

public interface Visitor {
    abstract void visit(ClassElement element);

    abstract void visit(PropertyElement element);

    abstract void visit(MethodElement element);
}
