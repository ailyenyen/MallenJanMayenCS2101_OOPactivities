import java.util.Scanner;
import java.util.InputMismatchException;

public class GettingInputs {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            try {
                System.out.print("Enter the year: ");
                int year = input.nextInt();
                input.nextLine(); 

                System.out.print("Enter the genre: ");
                String genre = input.nextLine();

                System.out.print("Enter the album: ");
                String album = input.nextLine();

                System.out.print("Enter the song title: ");
                String title = input.nextLine();

                System.out.print("Enter the artist: ");
                String artist = input.nextLine();

                System.out.println("\n-----------------------");
                System.out.println("|     SONG DETAILS    |");
                System.out.println("-----------------------");
                System.out.println("Year Released: " + year);
                System.out.println("Genre: " + genre);
                System.out.println("Album: " + album);
                System.out.println("Title: \"" + title + "\"");
                System.out.println("Artist: " + artist);

                System.out.print("\nDo you want to enter details for another song? (yes/no): ");
                String response = input.nextLine().trim().toLowerCase();
                if (!response.equals("yes")) {
                    exit = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid year.");
                input.next();  
            }
        }

        input.close(); 
    }
}
