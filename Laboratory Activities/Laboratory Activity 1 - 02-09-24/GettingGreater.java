import java.util.Scanner;

public class GettingGreater {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exit = false;
        char greaterVal = 0; 

        while (!exit) {
            try {
                System.out.println("\nGetting the Greater Value\n");
                System.out.print("Enter the first character: ");
                char char1 = input.next().charAt(0);
                System.out.print("Enter the second character: ");
                char char2 = input.next().charAt(0);

                int max = Math.max(char1, char2);
                if (max == char1) {
                    greaterVal = char1;
                } else if (max == char2) {
                    greaterVal = char2;
                }

                System.out.println("--------------------------------------------");
                System.out.println("The character with the greater value is: " + greaterVal);
                System.out.println("--------------------------------------------");

                System.out.println("Show the ASCII Codes");
                System.out.println(char1 + " : " + (int)char1);
                System.out.println(char2 + " : " + (int)char2);

                System.out.print("\nDo you want to exit? (y/n): ");
                char response = input.next().charAt(0);
                if (response == 'y' || response == 'Y') {
                    exit = true;
                }

            } catch (Exception e) {
                System.out.println("An error occurred. Please try again.");
                input.nextLine(); 
            }
        }

        input.close(); 
    }
}
