package visitor;

public class Main {
    public static void main(String[] args) {
        Element classElement = new ClassElement("MyClass");
        Element propertyElement = new PropertyElement("myProperty");
        Element methodElement = new MethodElement("myMethod", 20); // 20行代码

        SoftwareSizeVisitor sizeVisitor = new SoftwareSizeVisitor();
        IdentifierExtractorVisitor identifierVisitor = new IdentifierExtractorVisitor();
        LineCounterVisitor lineCounterVisitor = new LineCounterVisitor();

        classElement.accept(sizeVisitor);
        propertyElement.accept(sizeVisitor);
        methodElement.accept(sizeVisitor);

        classElement.accept(identifierVisitor);
        propertyElement.accept(identifierVisitor);
        methodElement.accept(identifierVisitor);

        methodElement.accept(lineCounterVisitor);

        sizeVisitor.printMetrics();
        lineCounterVisitor.printLineCounts();
    }
}
