import java.util.Scanner;
public class W1_5 {
    


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double maxNumber = Double.NEGATIVE_INFINITY; // Initialize maxNumber to the lowest possible value
        int count = 0;

        while (true) {
            double num = scanner.nextDouble();

            if (num == 0) {
                break; // End input when 0 is encountered
            }

            if (num > maxNumber) {
                maxNumber = num; // Update maxNumber
                count = 1; // Reset count for the new maxNumber
            } else if (num == maxNumber) {
                count++; // Increment count if the current number equals the maxNumber
            }
        }

        System.out.println((int)maxNumber + " " + count);
    }
}


