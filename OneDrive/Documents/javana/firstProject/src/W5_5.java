import java.util.ArrayList;

public class W5_5{
    // Instance variables
    private String firstname;
    private String lastname;
    private String id;
    private double salary;

    // Constructor
    public W5_5(String firstname, String lastname, String id, double salary) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
        this.salary = salary;
    }

    // Method to calculate earnings after tax
    public double earning() {
        return salary * 0.95; // 5% tax deduction
    }

    // Method to calculate bonus based on years of service
    public double bonus(int years) {
        if (years > 5) {
            return salary * 12; // 12 times salary if more than 5 years
        } else {
            return salary * 6;  // 6 times salary if 5 years or less
        }
    }

    // Method to print employee details
    public static void printEmp(ArrayList<W5_5> employees) {
        System.out.printf("%-15s %-15s %-15s %-15s%n", "First name", "Last name", "Earning", "Bonus");
        for (W5_5 emp : employees) {
            System.out.printf("%-15s %-15s %-15.2f %-15.2f%n",
                              emp.firstname, emp.lastname, emp.earning(), emp.bonus(6)); // Example with 6 years of service
        }
    }

    public static void main(String[] args) {
        // Create an ArrayList to store employees
        ArrayList<W5_5> arrayEarn = new ArrayList<>();
        
        // Add employees to the list
        arrayEarn.add(new W5_5("John", "Doe", "E001", 50000));
        arrayEarn.add(new W5_5("Jane", "Smith", "E002", 60000));
        arrayEarn.add(new W5_5("Emily", "Jones", "E003", 55000));
        
        // Print employee details
        printEmp(arrayEarn);
    }
}
