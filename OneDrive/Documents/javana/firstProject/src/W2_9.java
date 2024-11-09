import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class W2_9 {
    private ArrayList<Integer> numbers;

    // Constructor ที่รับตัวเลขทั้งหมด
    public W2_9(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    // เมธอดตรวจสอบว่าตัวเลขเป็นจำนวนเฉพาะหรือไม่
    private boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true; // 2 เป็นจำนวนเฉพาะ
        if (number % 2 == 0) return false; // กรณีเลขคู่

        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) return false;
        }

        return true;
    }

    // เมธอดค้นหาตัวเลขที่เป็นจำนวนเฉพาะที่มีค่ามากที่สุดและจำนวนครั้งที่มันปรากฏ
    public void findMaxPrimeAndCount() {
        int maxPrime = -1;
        Map<Integer, Integer> primeCount = new HashMap<>();

        for (int num : numbers) {
            if (num == 0) break; // หยุดเมื่อพบ 0
            if (isPrime(num)) {
                primeCount.put(num, primeCount.getOrDefault(num, 0) + 1);
                if (num > maxPrime) {
                    maxPrime = num;
                }
            }
        }

        if (maxPrime == -1) {
            System.out.println("No prime numbers");
        } else {
            System.out.println("Maximum prime number: " + maxPrime);
            System.out.println("Count: " + primeCount.get(maxPrime));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter integers (end with 0):");
        while (true) {
            int input = scanner.nextInt();
            if (input == 0) break;
            numbers.add(input);
        }

        W2_9 finder = new W2_9(numbers);
        finder.findMaxPrimeAndCount();
    }
}
