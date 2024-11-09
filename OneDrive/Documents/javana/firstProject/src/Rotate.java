import java.util.Scanner;

public class Rotate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        char[][] A = new char[n][n];
        

        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < n; j++) {
                A[i][j] = row.charAt(j);
            }
        }

        int q = sc.nextInt();
        int netRotation = 0;


        for (int i = 0; i < q; i++) {
            int direction = sc.nextInt();
            netRotation += direction;
        }

        netRotation = ((netRotation % 4) + 4) % 4;


        for (int i = 0; i < netRotation; i++) {
            A = rotateClockwise(A, n);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j]);
            }
            System.out.println();
        }
    }


    private static char[][] rotateClockwise(char[][] A, int n) {
        char[][] rotated = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = A[i][j];
            }
        }
        return rotated;
    }
}