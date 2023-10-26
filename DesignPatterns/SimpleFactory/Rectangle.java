package SimpleFactory;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle.");
    }

    @Override
    public void erase() {
        System.out.println("Erasing a rectangle.");
    }
}
