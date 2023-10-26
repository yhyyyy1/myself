package visitor;

public class LineCounterVisitor implements Visitor {
    private int classLineCount = 0;
    private int methodLineCount = 0;

    @Override
    public void visit(ClassElement element) {
        // 在这里统计类的行数
    }

    @Override
    public void visit(PropertyElement element) {

    }

    @Override
    public void visit(MethodElement element) {
        methodLineCount += element.getLineCount();
    }

    public void printLineCounts() {
        System.out.println("Total class lines: " + classLineCount);
        System.out.println("Total method lines: " + methodLineCount);
    }
}
