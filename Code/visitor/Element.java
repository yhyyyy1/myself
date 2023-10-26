package visitor;

public interface Element {
    abstract void accept(Visitor visitor);
}
