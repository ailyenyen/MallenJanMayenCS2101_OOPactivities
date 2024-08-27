import java.util.Scanner;
import java.util.InputMismatchException;

public class Tempconvert {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        float celcius = 0.0f;
        boolean valid = false;
        
        while (!valid) {
            System.out.print("Enter a celcius value: ");
            try {
                celcius = input.nextFloat();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                input.next();
            }
        }

        float farenheit = (celcius * 9/5) + 32;
        System.out.println(celcius + " celcius is " + farenheit + " in farenheit");
        input.close();

    }
}
