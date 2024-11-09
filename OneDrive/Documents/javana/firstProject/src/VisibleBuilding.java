import java.util.Scanner;

public class VisibleBuilding {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= n; caseNumber++) {
            int T = scanner.nextInt(); 
            int[] heights = new int[T];

            
            for (int i = 0; i < T; i++) {
                heights[i] = scanner.nextInt();
            }

            
            int count = 0;
            int maxHeight = 0; 

            
            for (int i = T - 1; i >= 0; i--) {
                if (heights[i] > maxHeight) {
                    count++;
                    maxHeight = heights[i]; 
                }
            }

            
            System.out.println("Case " + caseNumber + ": " + count);
        }

        scanner.close();
    }
}
