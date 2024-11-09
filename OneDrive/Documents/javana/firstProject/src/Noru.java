import java.util.Scanner;

public class Noru {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // พิกัดพายุ
        int xC = sc.nextInt();
        int yC = sc.nextInt();
        double r = sc.nextDouble(); // รัศมี
        double v = sc.nextDouble(); // ความเร็ว
        int n = sc.nextInt(); // จำนวนบ้าน

        // ตรวจสอบขอบเขต
        if (xC < 1 && xC > 1000000 && yC < 1 && yC > 1000000 && r < 1 && r > 100 && v < 1 && v > 100 && n < 1 && n > 10000) {
            System.out.println("Input out of bounds.");
            return;
        }

        // พิกัดบ้าน
        Home[] houses = new Home[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x < 1 && x > 1000000 && y < 1 && y > 1000000) {
                System.out.println("House coordinates out of bounds.");
                return;
            }
            houses[i] = new Home(x, y);
        }

        // จำนวนบ้านที่ได้รับผลกระทบ
        int amount = 0;
        boolean[] impacted = new boolean[n];

        // คำนวณผลกระทบ
        while (v > 1) {
            for (int i = 0; i < n; i++) {
                if (!impacted[i]) {
                    double distance = Math.sqrt(Math.pow(xC - houses[i].getX(), 2) + Math.pow(yC - houses[i].getY(), 2));
                    if (distance <= r) {
                        impacted[i] = true; // บ้านได้รับผลกระทบ
                        amount++;
                    }
                }
            }

            // อัปเดตตำแหน่งและสถานะของพายุ
            xC -= v; // เคลื่อนที่ทางทิศตะวันตก
            r *= 0.8; // ลดรัศมี 20%
            v *= 0.8; // ลดความเร็ว 20%
        }

        // แสดงผลจำนวนบ้านเรือนที่ได้รับผลกระทบ
        System.out.println(amount);
    }
}

class Home {
    private int x;
    private int y;

    Home(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
