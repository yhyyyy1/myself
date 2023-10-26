package SimpleFactory;

public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a triangle.");
    }

    @Override
    public void erase() {
        System.out.println("Erasing a triangle.");
    }
}
