import java.util.Scanner;

public class w4_7 {
    private static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        findMinDifference(weights, 0, 0, 0, n);
        System.out.println(minDifference);
    }

    private static void findMinDifference(int[] weights, int index, int sumA, int sumB, int n) {
        if (index == n) {
            minDifference = Math.min(minDifference, Math.abs(sumA - sumB));
            return;
        }
        findMinDifference(weights, index + 1, sumA + weights[index], sumB, n);

        findMinDifference(weights, index + 1, sumA, sumB + weights[index], n);
    }
}
