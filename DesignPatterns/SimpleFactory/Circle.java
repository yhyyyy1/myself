package SimpleFactory;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle.");
    }

    @Override
    public void erase() {
        System.out.println("Erasing a circle.");
    }
}
