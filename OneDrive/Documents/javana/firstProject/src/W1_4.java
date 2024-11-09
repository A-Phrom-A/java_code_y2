 import java.util.Scanner;

public class W1_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input for n, a0, and a1
        System.out.print("Please input n, a0 and a1: ");
        int n = scanner.nextInt();
        int a0 = scanner.nextInt();
        int a1 = scanner.nextInt();

        // Array to store the values of a_k
        int[] a = new int[n + 1];
        a[0] = a0;
        a[1] = a1;

        // Compute the values using the recurrence relation
        for (int k = 2; k <= n; k++) {
            a[k] = k * k * a[k - 1] - a[k - 2] + 3 * k;
        }

        // Print the results
        System.out.print("Output is: ");
        for (int i = 0; i <= n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}


