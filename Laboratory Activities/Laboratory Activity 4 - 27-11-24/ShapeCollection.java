public class ShapeCollection {
    private Shape[] shapes;

    public ShapeCollection(Shape[] shapes) {
        this.shapes = shapes;
    }

    public void getPropertyValues(){
        for (Shape shape : shapes) {
            if (shape != null) {
                double area = shape.getArea();
                double perimeter = shape.getPerimeter();
                System.out.println();
                shape.printShapeType();
                System.out.printf("Area: %.2f\n", area);
                System.out.printf("Perimeter: %.2f\n", perimeter);

            }
        }
    }
}
