package visitor;

public class SoftwareSizeVisitor implements Visitor {
    private int classCount = 0;
    private int propertyCount = 0;
    private int methodCount = 0;

    @Override
    public void visit(ClassElement element) {
        classCount++;
    }

    @Override
    public void visit(PropertyElement element) {
        propertyCount++;
    }

    @Override
    public void visit(MethodElement element) {
        methodCount++;
    }

    public void printMetrics() {
        System.out.println("Class count: " + classCount);
        System.out.println("Property count: " + propertyCount);
        System.out.println("Method count: " + methodCount);
    }
}
