package SimpleFactory;

public class ShapeFactory {
    public static Shape createShape(String shapeType) throws UnsupportedShapeException {
        switch (shapeType.toLowerCase()) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            case "triangle":
                return new Triangle();
            default:
                throw new UnsupportedShapeException("Unsupported shape: " + shapeType);
        }
    }
}
