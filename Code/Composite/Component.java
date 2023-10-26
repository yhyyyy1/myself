package Composite;

public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void shareInformation(String information);

    public abstract void add(Component component);
    public abstract void remove(Component component);
    public abstract void display();
}
