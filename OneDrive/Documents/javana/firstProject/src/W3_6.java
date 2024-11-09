import java.util.Scanner;

public class W3_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // รับข้อมูลจากผู้ใช้
        System.out.print("กรุณากรอกคำหรือประโยค: ");
        String input = scanner.nextLine();

        // เรียกใช้เมธอด isPalindrome เพื่อตรวจสอบ
        boolean result = isPalindrome(input);

        // แสดงผลลัพธ์
        System.out.println(result ? 1 : 0);
    }

    // เมธอด isPalindrome เพื่อตรวจสอบว่าเป็น palindrome หรือไม่
    public static boolean isPalindrome(String s) {
        // ลบช่องว่างและอักษรพิเศษ และเปลี่ยนเป็นอักษรตัวเล็กทั้งหมด
        String cleanString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // ตรวจสอบว่า string ที่ได้เท่ากันเมื่ออ่านจากหน้าไปหลัง
        int len = cleanString.length();
        for (int i = 0; i < len / 2; i++) {
            if (cleanString.charAt(i) != cleanString.charAt(len - 1 - i)) {
                return false; // ไม่ใช่ palindrome
            }
        }
        return true; // เป็น palindrome
    }
}
