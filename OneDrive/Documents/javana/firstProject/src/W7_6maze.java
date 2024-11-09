import java.util.*;

public class W7_6maze {
    static class Point {
        int x, y;
        boolean wallChanged;

        Point(int x, int y, boolean wallChanged) {
            this.x = x;
            this.y = y;
            this.wallChanged = wallChanged;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // รับค่า M และ N
        System.out.print("Enter number of rows (M N): ");
        int M = scanner.nextInt();
        int N = scanner.nextInt();

        if (M <= 1 || N <= 1 || M > 150 || N > 150) {
            System.out.println("M and N must be in the range 1 < M,N <= 150.");
            return;
        }

        // สร้างเมทริกซ์ 2D
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = random.nextInt(2); // สุ่มเลข 0 หรือ 1
            }
        }
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // รับค่าจุดเริ่มต้น (rs, cs)
        System.out.print("Enter start row and column (rs cs): ");
        int rs = scanner.nextInt();
        int cs = scanner.nextInt();

        // รับค่าจุดสิ้นสุด (re, ce)
        System.out.print("Enter end row and column (re ce): ");
        int re = scanner.nextInt();
        int ce = scanner.nextInt();

        if (!isValid(rs, cs, M, N) || !isValid(re, ce, M, N)) {
            System.out.println("Start or end positions are invalid.");
            return;
        }

        // เรียกใช้ฟังก์ชันหาเส้นทาง
        int result = findPath(matrix, M, N, rs, cs, re, ce);
        System.out.println(result != -1 ? "Minimum steps: " + result : "No path found.");
    }

    // ตรวจสอบว่า (x, y) อยู่ในขอบเขตเมทริกซ์หรือไม่
    public static boolean isValid(int x, int y, int M, int N) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }

    // ฟังก์ชันหาเส้นทางโดยใช้ BFS
    public static int findPath(int[][] matrix, int M, int N, int rs, int cs, int re, int ce) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[][][] visited = new boolean[M][N][2]; // มี 2 สถานะ: ยังไม่เปลี่ยนกำแพง หรือเปลี่ยนแล้ว

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(rs, cs, false));
        visited[rs][cs][0] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point p = queue.poll();

                if (p.x == re && p.y == ce) {
                    return steps;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];

                    if (isValid(nx, ny, M, N)) {
                        if (matrix[nx][ny] == 1 && !visited[nx][ny][p.wallChanged ? 1 : 0]) {
                            visited[nx][ny][p.wallChanged ? 1 : 0] = true;
                            queue.offer(new Point(nx, ny, p.wallChanged));
                        } else if (matrix[nx][ny] == 0 && !p.wallChanged && !visited[nx][ny][1]) {
                            visited[nx][ny][1] = true;
                            queue.offer(new Point(nx, ny, true)); // เปลี่ยนกำแพงเป็นทางเดิน
                        }
                    }
                }
            }
            steps++;
        }
        return -1; // ไม่เจอเส้นทาง
    }
}
