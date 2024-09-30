import java.util.Scanner;

public class MultiplicationTable {  

    public static int[][] getMultiplicationTable(int n){
        int[][] table = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                table[i][j] = i * j;
            }
        }
        return table;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the multiplication table: ");
        int n = input.nextInt();

        int[][] table = getMultiplicationTable(n);

        System.out.println("Multiplication table: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", table[i][j]);
            }
            System.out.println();
        }
        input.close();
    }
}