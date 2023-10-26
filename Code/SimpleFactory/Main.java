package SimpleFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();

        try {
            shapes.add(ShapeFactory.createShape("circle"));
            shapes.add(ShapeFactory.createShape("rectangle"));
            shapes.add(ShapeFactory.createShape("triangle"));
            // Uncomment the line below to test an unsupported shape
            // shapes.add(ShapeFactory.createShape("hexagon"));
        } catch (UnsupportedShapeException e) {
            System.err.println("Error: " + e.getMessage());
        }

        for (Shape shape : shapes) {
            shape.draw();
            shape.erase();
        }
    }
}
