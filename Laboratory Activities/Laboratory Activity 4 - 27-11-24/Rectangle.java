public class Rectangle implements Shape {
    private double width;
    private double length;


    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {

        return width;
    }
    public double getLength() {

        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * width + 2 * length;
    }

    @Override
    public void printShapeType() {
        System.out.println("Rectangle");
    }

}
