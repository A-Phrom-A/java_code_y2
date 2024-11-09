// คลาสสำหรับเก็บข้อมูลวันที่
class date {
    private int day;
    private String month;
    private int year;

    date() {
        day = 0;
        month = "";
        year = 0;
    }

    date(int day, String month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return day + " " + month + " " + year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}

// คลาสสำหรับเก็บข้อมูลบุคคล
class Person {
    private String name;
    private String surname;
    private int age;
    private date bDate;

    Person() {
        name = "";
        surname = "";
        age = 0;
        bDate = new date();
    }

    Person(String name, String surname, int age, date bDate) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.bDate = bDate;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + age + " " + bDate;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setbDate(date bDate) {
        this.bDate = bDate;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public date getbDate() {
        return bDate;
    }
}

// คลาส Account ที่คุณต้องการ
class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private date dateCreated;

    Account() {
        id = 0;
        balance = 0.0;
        annualInterestRate = 0.0;
        dateCreated = new date();
    }

    Account(int id, double balance, double annualInterestRate, date dateCreated) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.dateCreated = dateCreated;
    }

    // Accessor methods (getters)
    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public date getDateCreated() {
        return dateCreated;
    }

    // Mutator methods (setters)
    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setDateCreated(date dateCreated) {
        this.dateCreated = dateCreated;
    }

    // Method to get monthly interest rate
    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    // Method to calculate monthly interest
    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate() / 100;
    }

    // Method to withdraw money
    public void widthDraw(double money) {
        balance -= money;
    }

    // Method to deposit money
    public void deposit(double money) {
        balance += money;
    }

    @Override
    public String toString() {
        return "|" + id + "| |Balance: " + balance + " bath| |Monthly Interest Rate: " + getMonthlyInterestRate() + "%|";
    }
}

public class W6_5 {
    public static void main(String[] args) {
        // Creating date
        date openAcc1 = new date(1, "Feb", 2004);

        // Creating account ID 1122 with initial balance and interest rate
        Account account = new Account(1122, 20000, 4.5, openAcc1);

        // Performing withdraw and deposit operations
        account.widthDraw(2500);  // Withdraw 2500 bath
        account.deposit(3000);    // Deposit 3000 bath

        // Displaying account details after operations
        System.out.println("Account Details:");
        System.out.println(account);
        System.out.println("Monthly Interest: " + account.getMonthlyInterest() + " bath");
    }
}
