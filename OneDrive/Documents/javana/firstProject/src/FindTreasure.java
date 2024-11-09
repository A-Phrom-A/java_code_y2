import java.util.Scanner;

public class FindTreasure {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int H = input.nextInt();
        int W = input.nextInt();
        
        // Validate H and W
        if (H <= 0 || W <= 0) {
            System.out.println("Invalid dimensions");
            return;
        }

        int[][] A = new int[H][W];
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                A[i][j] = input.nextInt();
            }
        }
        input.close();
        
        FindPokemon findPokemon = new FindPokemon();
        findPokemon.pikachu(A);
        int maxRow = findPokemon.getMaxRow();
        int maxCol = findPokemon.getMaxCol();
        System.out.print((maxRow + 1) + " " + (maxCol + 1));
    }
}

class FindPokemon {
    private int maxRow;
    private int maxCol;
    private int maxValue;

    int getMaxRow() {
        return maxRow;
    }

    int getMaxCol() {
        return maxCol;
    }

    void pikachu(int[][] A) {
        maxValue = Integer.MIN_VALUE;

        // Check horizontal adjacency
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length - 1; j++) {
                if (Math.abs(A[i][j] - A[i][j + 1]) <= 10) {
                    checkAndUpdateMax(A[i][j], i, j);
                    checkAndUpdateMax(A[i][j + 1], i, j + 1);
                }
            }
        }

        
        for (int j = 0; j < A[0].length; j++) {
            for (int i = 0; i < A.length - 1; i++) {
                if (Math.abs(A[i][j] - A[i + 1][j]) <= 10) {
                    checkAndUpdateMax(A[i][j], i, j);
                    checkAndUpdateMax(A[i + 1][j], i + 1, j);
                }
            }
        }
    }

    private void checkAndUpdateMax(int value, int row, int col) {
        if (value > maxValue) {
            maxValue = value;
            maxRow = row;
            maxCol = col;
        }
    }
}
