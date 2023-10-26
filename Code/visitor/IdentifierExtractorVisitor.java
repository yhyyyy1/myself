package visitor;

public class IdentifierExtractorVisitor implements Visitor{
    @Override
    public void visit(ClassElement element) {
        System.out.println("Class name: " + element.getName());
    }

    @Override
    public void visit(PropertyElement element) {
        System.out.println("Property name: " + element.getName());
    }

    @Override
    public void visit(MethodElement element) {
        System.out.println("Method name: " + element.getName());
    }
}
