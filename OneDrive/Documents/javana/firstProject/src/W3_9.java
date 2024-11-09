import java.util.Scanner;

public class W3_9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // รับค่าพิกัดของจุด p0, p1, p2
        System.out.println("กรุณากรอกค่าพิกัดของจุด p0, p1, p2: ");
        double x0 = scanner.nextDouble();
        double y0 = scanner.nextDouble();
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        // ตรวจสอบตำแหน่งของ p2
        if (onTheSameLine(x0, y0, x1, y1, x2, y2)) {
            System.out.println(0); // p2 อยู่บนเส้นตรง p0 p1
        } else if (left0ftheLine(x0, y0, x1, y1, x2, y2)) {
            System.out.println(2); // p2 อยู่ด้านซ้ายของเส้นตรง p0 p1
        } else {
            System.out.println(1); // p2 อยู่ด้านขวาของเส้นตรง p0 p1
        }
    }

    // ตรวจสอบว่าจุด p2 อยู่ด้านซ้ายของเส้นตรง p0 p1 หรือไม่
    public static boolean left0ftheLine(double x0, double y0, double x1, double y1, double x2 , double y2) {
        return crossProduct(x0, y0, x1, y1, x2, y2) > 0;
    }

    // ตรวจสอบว่าจุด p2 อยู่บนเส้นตรง p0 p1 หรือไม่
    public static boolean onTheSameLine(double x0, double y0, double x1, double y1, double x2 , double y2) {
        return crossProduct(x0, y0, x1, y1, x2, y2) == 0;
    }

    // ตรวจสอบว่าจุด p2 อยู่บนเส้นตรงระหว่าง p0 และ p1 หรือไม่
    public static boolean onTheLineSegment(double x0, double y0, double x1, double y1, double x2 , double y2) {
        if (!onTheSameLine(x0, y0, x1, y1, x2, y2)) {
            return false;
        }
        return Math.min(x0, x1) <= x2 && x2 <= Math.max(x0, x1) &&
               Math.min(y0, y1) <= y2 && y2 <= Math.max(y0, y1);
    }

    // คำนวณ cross product เพื่อตรวจสอบตำแหน่งของ p2 เมื่อเทียบกับเส้นตรง p0 p1
    public static double crossProduct(double x0, double y0, double x1, double y1, double x2 , double y2) {
        return (x1 - x0) * (y2 - y0) - (y1 - y0) * (x2 - x0);
    }
}

