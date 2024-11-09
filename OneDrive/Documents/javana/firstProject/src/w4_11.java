
import java.util.Scanner;

public class w4_11 {
    private static int rows;
    private static int cols;
    private static char[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            rows = sc.nextInt();
            cols = sc.nextInt();
            if (rows == 0 || cols == 0) break;

            sc.nextLine(); // consume newline

            grid = new char[rows][cols];

            // อ่านข้อมูลกริด
            for (int i = 0; i < rows; i++) {
                String line = sc.nextLine();
                if (line.length() != cols) {
                    System.out.println("Error");
                    return;
                }
                grid[i] = line.toCharArray();
            }

            int oilPockets = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == '@') {
                        dfs(i, j);
                        oilPockets++;
                    }
                }
            }

            System.out.println(oilPockets);
        }
        sc.close();
    }

    private static void dfs(int x, int y) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] != '@') {
            return;
        }

        grid[x][y] = '*'; // Mark as visited

        // Check all 8 directions
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx != 0 || dy != 0) {
                    dfs(x + dx, y + dy);
                }
            }
        }
    }
}