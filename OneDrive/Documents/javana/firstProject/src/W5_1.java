import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class W5_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        
        System.out.println("Enter numbers (type 'done' to finish):");
        
        // Read numbers from input
        while (sc.hasNextInt()) {
            numbers.add(sc.nextInt());
        }
        
        // Remove non-integer inputs (e.g., "done")
        sc.nextLine(); // consume the remaining newline
        
        // Check if list is empty
        if (numbers.isEmpty()) {
            System.out.println("No numbers provided.");
            sc.close();
            return;
        }

        // Calculate average
        double sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = sum / numbers.size();
        System.out.printf("Average: %.2f%n", average);
        
        // Find min and max
        int min = Collections.min(numbers);
        int max = Collections.max(numbers);
        System.out.printf("Minimum: %d%n", min);
        System.out.printf("Maximum: %d%n", max);
        
        // Remove even numbers
        numbers.removeIf(num -> num % 2 == 0);
        
        // Print the remaining numbers
        System.out.println("Remaining numbers (odd numbers only):");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        sc.close();
    }
}
