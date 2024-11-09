import java.util.Scanner;

public class W3_7 {

    // Method ที่ใช้ตรวจสอบว่าด้านทั้งสามเป็นสามเหลี่ยมหรือไม่
    public boolean isValid(double side1, double side2, double side3) {
        return (side1 + side2 > side3) && (side2 + side3 > side1) && (side1 + side3 > side2);
    }

    // Method ที่ใช้คำนวณพื้นที่ของสามเหลี่ยม
    public double area(double side1, double side2, double side3) {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        W3_7 triangle = new W3_7();

        // รับค่าด้านทั้งสามจากผู้ใช้
        System.out.print("กรุณากรอกค่าด้านทั้งสามของสามเหลี่ยม: ");
        double side1 = scanner.nextDouble();
        double side2 = scanner.nextDouble();
        double side3 = scanner.nextDouble();

        // ตรวจสอบว่าด้านทั้งสามเป็นสามเหลี่ยมหรือไม่
        if (triangle.isValid(side1, side2, side3)) {
            // ถ้าเป็น Valid ให้พิมพ์ 1 และพื้นที่ของสามเหลี่ยม
            System.out.println(1);
            System.out.println(triangle.area(side1, side2, side3));
        } else {
            // ถ้าไม่ Valid ให้พิมพ์ 0
            System.out.println(0);
        }
    }
}

