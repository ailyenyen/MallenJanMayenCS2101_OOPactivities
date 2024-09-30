import java.util.Scanner;

public class MultiplicationTable {  
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the multiplication table: ");
        int n = input.nextInt();

        multiplicationTable(n);

        input.close();
    }

    public static void multiplicationTable(int n) {
        int[][] table = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                table[i][j] = i * j;
            }
        }

        System.out.println("Multiplication Table: ");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.printf("%4d", table[i][j]);  
            }
            System.out.println(); 
        }
    }
}
