import java.util.Scanner;

public class w4_9 {

    public static boolean isConsecutiveFour(int[][] values) {
        int m = values.length;
        int n = values[0].length;

        if (m < 4 || n < 4) {
            return false;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 3; j++) {
                if (values[i][j] == values[i][j + 1] &&
                    values[i][j] == values[i][j + 2] &&
                    values[i][j] == values[i][j + 3]) {
                    return true;
                }
            }
        }

        for (int i = 0; i < m - 3; i++) {
            for (int j = 0; j < n; j++) {
                if (values[i][j] == values[i + 1][j] &&
                    values[i][j] == values[i + 2][j] &&
                    values[i][j] == values[i + 3][j]) {
                    return true;
                }
            }
        }

        for (int i = 0; i < m - 3; i++) {
            for (int j = 0; j < n - 3; j++) {
                if (values[i][j] == values[i + 1][j + 1] &&
                    values[i][j] == values[i + 2][j + 2] &&
                    values[i][j] == values[i + 3][j + 3]) {
                    return true;
                }
            }
        }

        for (int i = 3; i < m; i++) {
            for (int j = 0; j < n - 3; j++) {
                if (values[i][j] == values[i - 1][j + 1] &&
                    values[i][j] == values[i - 2][j + 2] &&
                    values[i][j] == values[i - 3][j + 3]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        
        if (m < 1 || n < 1) {
            System.out.println(0);
            return;
        }

        int[][] values = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                values[i][j] = input.nextInt();
            }
        }
        input.close();

        if (isConsecutiveFour(values)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
