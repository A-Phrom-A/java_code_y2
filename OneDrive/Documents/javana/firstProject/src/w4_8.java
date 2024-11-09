import java.util.Scanner;

public class w4_8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int H = input.nextInt();
        int W = input.nextInt();
        int[][] A = new int[H][W];
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                A[i][j] = input.nextInt();
            }
        }
        input.close();
        
        findpokemond haha = new findpokemond();
        haha.pikachu(A);
        H = haha.getpointm();
        W = haha.getpointh();
        System.out.print((H+1) + " " + (W+1));
    }
}

class findpokemond {
    private int m;
    private int h;
    private int max;

    int getpointm() {
        return m;
    }

    int getpointh() {
        return h;
    }

    void pikachu(int[][] A) {
        max = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length - 1; j++) {
                if (Math.abs(A[i][j] - A[i][j + 1]) <= 10) {
                    if (A[i][j] > max) {
                        max = A[i][j];
                        m = i;
                        h = j;
                    }
                    if (A[i][j + 1] > max) {
                        max = A[i][j + 1];
                        m = i;
                        h = j + 1;
                    }
                    
                }
            }
        }

        for (int j = 0; j < A.length; j++) {
            for (int i = 0; i < A[0].length - 1; i++) {
                if (Math.abs(A[i][j] - A[i + 1][j]) <= 10) {
                    if (A[i][j] > max) {
                        max = A[i][j];
                        m = i;
                        h = j;
                    }
                    if (A[i + 1][j] > max) {
                        max = A[i + 1][j];
                        m = i + 1;
                        h = j;
                    }
                }
            }
        }
    }
}
