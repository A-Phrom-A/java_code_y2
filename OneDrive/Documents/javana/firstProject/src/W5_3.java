import java.util.ArrayList;

public class W5_3 {

    // Method to find the intersection of two sorted lists
    public static ArrayList<Integer> intersect(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        // Use two pointers to find common elements
        while (i < list1.size() && j < list2.size()) {
            int val1 = list1.get(i);
            int val2 = list2.get(j);
            
            if (val1 < val2) {
                i++;
            } else if (val1 > val2) {
                j++;
            } else {
                result.add(val1);
                i++;
                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example lists
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        
        // Populate list1
        list1.add(1);
        list1.add(4);
        list1.add(8);
        list1.add(9);
        list1.add(11);
        list1.add(15);
        list1.add(17);
        list1.add(28);
        list1.add(41);
        list1.add(59);
        
        // Populate list2
        list2.add(4);
        list2.add(7);
        list2.add(11);
        list2.add(17);
        list2.add(19);
        list2.add(20);
        list2.add(23);
        list2.add(28);
        list2.add(37);
        list2.add(59);
        list2.add(81);
        
        // Find intersection
        ArrayList<Integer> intersection = intersect(list1, list2);
        
        // Print result
        System.out.println("Intersection: " + intersection);
    }
}
