package visitor;

public class MethodElement implements Element {
    private String name;
    private int lineCount;

    public MethodElement(String name, int lineCount) {
        this.name = name;
        this.lineCount = lineCount;
    }

    public String getName() {
        return name;
    }

    public int getLineCount() {
        return lineCount;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
