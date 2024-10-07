public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("red", 19999.85, 'M');
        car1.setColor("yellow");
        car1.setPrice(458000.4);
        car1.setSize('s');
        System.out.println(car1);  

        Car car2 = new Car("blue", 50000.00, 'L');
        System.out.println(car2);  
    }
}
