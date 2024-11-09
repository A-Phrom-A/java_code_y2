import java.util.Scanner;

public class W3_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // รับข้อมูล N และ M
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        // สร้าง array สำหรับเก็บตำแหน่งยานบิน
        int[][] ships = new int[N][2];
        
        // รับข้อมูลตำแหน่งของยานบิน
        for (int i = 0; i < N; i++) {
            ships[i][0] = scanner.nextInt(); // จุดเริ่มต้นของยานบิน
            ships[i][1] = scanner.nextInt(); // จุดสิ้นสุดของยานบิน
        }

        int count = 0;

        // รับข้อมูลตำแหน่งของแสง
        for (int i = 0; i < M; i++) {
            int lightPosition = scanner.nextInt();
            for (int j = 0; j < N; j++) {
                // ตรวจสอบว่าลำแสงส่องผ่านยานบินและไม่ผ่านหัวหรือท้ายยานพอดี
                if (lightPosition > ships[j][0] && lightPosition < ships[j][1]) {
                    count++;
                    break; // หยุดตรวจสอบยานบินถ้าลำแสงนี้ส่องผ่านยานบินใดๆแล้ว
                }
            }
        }

        // แสดงผลลัพธ์
        System.out.println(count);
    }
}
