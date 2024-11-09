import java.util.ArrayList;
import java.util.Scanner;

public class W5_2 {
    // Method to add '*' after each element in the list
    public static void addStars(ArrayList<String> list) {
        ArrayList<String> newList = new ArrayList<>();
        for (String item : list) {
            newList.add(item);
            newList.add("*");
        }
        list.clear();
        list.addAll(newList);
    }

    // Method to remove '*' from the list
    public static void removeStars(ArrayList<String> list) {
        ArrayList<String> newList = new ArrayList<>();
        for (String item : list) {
            if (!item.equals("*")) {
                newList.add(item);
            }
        }
        list.clear();
        list.addAll(newList);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        // Read words from input
        System.out.println("Enter words (type 'done' to finish):");
        while (sc.hasNext()) {
            String word = sc.next();
            if (word.equals("done")) {
                break;
            }
            list.add(word);
        }

        // Read number of commands
        System.out.println("Enter number of commands:");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        // Execute commands
        for (int i = 0; i < n; i++) {
            System.out.println("Enter command (1 for addStars, 2 for removeStars):");
            int command = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (command) {
                case 1:
                    addStars(list);
                    break;
                case 2:
                    removeStars(list);
                    break;
                default:
                    System.out.println("Invalid command.");
                    continue;
            }

            // Print the updated list
            System.out.println("Updated list:");
            System.out.println(list);
        }

        sc.close();
    }
}
