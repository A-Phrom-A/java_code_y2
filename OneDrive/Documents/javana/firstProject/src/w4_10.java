import java.util.Scanner;

public class w4_10{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of lanes (2-40):");
        int m = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Enter the starting lane number (1-m):");
        int currentLane = Integer.parseInt(scanner.nextLine()) - 1;
        
        System.out.println("Enter the number of time units (1-100):");
        int t = Integer.parseInt(scanner.nextLine());
        
        int[][] lanes = new int[t][m];
        
        System.out.println("Enter the road status for each time unit:");
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < m; j++) {
                lanes[i][j] = scanner.nextInt();
            }
        }
        
        scanner.nextLine(); // Clear the scanner buffer

        for (int i = 0; i < t; i++) {
            if (lanes[i][currentLane] == 1) { // If there is an obstacle in the current lane
                if (lanes[i][currentLane - 1] == 0) { // Move left if possible
                    currentLane--;
                    System.out.println("3"); // Move to the left
                } else if (currentLane < m - 1 && lanes[i][currentLane + 1] == 0) { // Move right if possible
                    currentLane++;
                    System.out.println("3"); // Move to the right
                } else {
                    System.out.println("2"); // Stay in the same lane if no other option
                }
            } else {
                System.out.println("1"); // Stay in the same lane if no obstacle
            }
        }

        scanner.close();
    }
}
