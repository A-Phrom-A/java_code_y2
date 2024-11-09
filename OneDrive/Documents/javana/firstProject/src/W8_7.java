import java.util.*;

public class W8_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   
        int n = sc.nextInt();  // จำนวนสถานี
        int m = sc.nextInt();  // จำนวนสายรถไฟ
        // สร้างการเชื่อมต่อระหว่างสถานีกับสายรถไฟที่มันอยู่
        Map<Integer, Set<Integer>> stationToLines = new HashMap<>();
        List<List<Integer>> lines = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            int k = sc.nextInt();  // จำนวนสถานีในสายรถไฟ
            List<Integer> line = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                int station = sc.nextInt();
                line.add(station);
                stationToLines.computeIfAbsent(station, x -> new HashSet<>()).add(i);
            }
            lines.add(line);
        }
        int q = sc.nextInt();  // จำนวนคำถาม
        for (int i = 0; i < q; i++) {
            int start = sc.nextInt();  // สถานีเริ่มต้น
            int end = sc.nextInt();    // สถานีปลายทาง
            // ค้นหาจำนวนการเปลี่ยนสายที่น้อยที่สุด
            int result = findMinTransfers(stationToLines, lines, start, end);
            if (result == -1) {
                System.out.println("impossible");  // หากไม่สามารถเดินทางได้
            } else {
                System.out.println(result-1);  // จำนวนการเปลี่ยนสายที่น้อยที่สุด
            }
        }
       sc.close();
    }
    private static int findMinTransfers(Map<Integer, Set<Integer>> stationToLines, List<List<Integer>> lines, int start, int end) {
        if (start == end) return 0;
        
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> distance = new HashMap<>();
        Map<Integer, Integer> transfers = new HashMap<>();
        
        queue.add(start);
        distance.put(start, 0);
        transfers.put(start, 0);
        
        while (!queue.isEmpty()) {
            int currentStation = queue.poll();
            int currentTransfers = transfers.get(currentStation);
            // ตรวจสอบสถานีที่อยู่ในสายรถไฟเดียวกัน
            for (int line : stationToLines.getOrDefault(currentStation, Collections.emptySet())) {
                for (int station : lines.get(line)) {
                    if (!distance.containsKey(station)) {
                        distance.put(station, distance.get(currentStation) + 1);
                        transfers.put(station, currentTransfers + 1); // เพิ่มการเปลี่ยนสาย
                        queue.add(station);
                        if (station == end) {
                            return transfers.get(station);
                        }
                    }
                }
            }
        }
        
        return -1; 
    }
}