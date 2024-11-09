abstract class Employee {
    private String firstName;
    private String lastName;
    private String employeeId;

    public Employee(String firstName, String lastName, String employeeId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
    }

    public abstract double earning();
    public abstract double bonus(int h);

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

class SalariedEmployee extends Employee {
    private double salary;

    public SalariedEmployee(String firstName, String lastName, String employeeId, double salary) {
        super(firstName, lastName, employeeId);
        this.salary = salary;
    }

    @Override
    public double earning() {
        return salary;
    }

    @Override
    public double bonus(int h) {
        return salary * 0.1; // Example: 10% of the salary as bonus
    }
}

class ComEmployee extends Employee {
    private double baseSalary;
    private double commissionRate;

    public ComEmployee(String firstName, String lastName, String employeeId, double baseSalary, double commissionRate) {
        super(firstName, lastName, employeeId);
        this.baseSalary = baseSalary;
        this.commissionRate = commissionRate;
    }

    @Override
    public double earning() {
        return baseSalary + (baseSalary * commissionRate); // Example earning calculation
    }

    @Override
    public double bonus(int h) {
        return (baseSalary + (baseSalary * commissionRate)) * 0.05; // Example: 5% of total earning as bonus
    }
}
