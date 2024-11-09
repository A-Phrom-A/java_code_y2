import java.util.ArrayList;
import java.util.Scanner;

public class W5_4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Read dimensions of the matrix
        int m = input.nextInt();
        if (m >= 2) {
            int n = input.nextInt();
            if (n <= 1000) {
                // Declare matrix using ArrayList of ArrayLists
                ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
                
                // Read value of k
                int k = input.nextInt();
                if (k >= 0 && k < m && k < n) {
                    
                    // Input values into the matrix
                    for (int i = 0; i < m; i++) {
                        ArrayList<Integer> row = new ArrayList<>();
                        for (int j = 0; j < n; j++) {
                            row.add(input.nextInt());
                        }
                        matrix.add(row);
                    }
                    
                    // Find the maximum sum of k x k sub-matrices
                    int max = 0;
                    int sum = 0;
                    
                    for (int z = 0; z < m - k + 1; z++) {
                        for (int y = 0; y < n - k + 1; y++) {
                            sum = 0;
                            for (int i = 0; i < k; i++) {
                                for (int j = 0; j < k; j++) {
                                    sum += matrix.get(i + z).get(j + y);
                                }
                            }
                            if (sum > max) {
                                max = sum;
                            }
                        }
                    }
                    
                    // Output the maximum sum
                    System.out.println(max);
                }
            }
        }
        input.close();
    }
}
