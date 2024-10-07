
public class Car {
    
    private String color;
    private double price;
    private char size;

    public Car(String color, double price, char size){
        this.color = color;
        this.price = price;
        this.size = Character.toUpperCase(size);
    }

    //getter methods

    public String getColor(){
        return color;
    }

    public double getPrice(){
        return price;
    }

    public char getSize(){
        return size;
    }

    //setter methods

    public void setColor(String color){
        this.color = color;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setSize(char size){
        this.size = Character.toUpperCase(size);
    }

    public String toString(){
        String stringSize;

        switch (size) {
            case 'S':
                stringSize = "small";
                break;
            case 'M':
                stringSize = "medium";
                break;
            case 'L':
                stringSize = "large";
                break;
            default:
                stringSize = "unknown";
                break;
        }

        return  String.format("Car (%s) - P%.2f - %s", color, price, stringSize);
    }

}
