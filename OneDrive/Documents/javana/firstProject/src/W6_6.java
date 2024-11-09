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

class Account {
    private int id;
    private Person objPerson;
    private double balance;
    private double annualInterestRate;
    private date dateCreated;

    Account() {
        id = 0;
        balance = 0.0;
        annualInterestRate = 0.0;
        dateCreated = new date();
    }

    Account(int id, Person objPerson, double balance, double annualInterestRate, date dateCreated) {
        this.id = id;
        this.objPerson = objPerson;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.dateCreated = dateCreated;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setDateCreated(date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setObjPerson(Person objPerson) {
        this.objPerson = objPerson;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public date getDateCreated() {
        return dateCreated;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public Person getObjPerson() {
        return objPerson;
    }

    public void widthDraw(double money) {
        balance -= money;
    }

    public void deposit(double money) {
        balance += money;
    }

    public void transferMoney(Account target, double amount) {
        if (amount <= 0) {
            System.out.println("จำนวนเงินต้องมากกว่า 0");
        } else if (balance < amount) {
            System.out.println("เงินในบัญชีไม่พอ");
        } else {
            widthDraw(amount);
            target.deposit(amount);
            System.out.println("โอนเงินจำนวน " + amount + " จากบัญชี ID " + id + " ไปยังบัญชี ID " + target.getId());
        }
    }

    @Override
    public String toString() {
        return "|" + id + "| |" + objPerson + "| |" + balance + " bath| |" + annualInterestRate / 12 + "%| |" + dateCreated + "| ";
    }
}

class SavingAccount extends Account {
    SavingAccount(int id, Person objPerson, double balance, double annualInterestRate, date dateCreated) {
        super(id, objPerson, balance, annualInterestRate, dateCreated);
    }

    @Override
    public void transferMoney(Account target, double amount) {
        double fee = 20.0;  // Transaction fee
        if (amount <= 0) {
            System.out.println("The amount must be greater than 0");
        } else if (getBalance() < (amount + fee)) {
            System.out.println("Insufficient funds in the account");
        } else {
            widthDraw(amount + fee);  // Withdraw amount with fee
            target.deposit(amount);  // Deposit amount to target account
            System.out.println("Transferred " + amount + " from account ID " + getId() + " to account ID " + target.getId());
        }
    }
}

class FixAccount extends Account {
    FixAccount(int id, Person objPerson, double balance, double annualInterestRate, date dateCreated) {
        super(id, objPerson, balance, annualInterestRate, dateCreated);
    }

    @Override
    public void transferMoney(Account target, double amount) {
        // ลบข้อความที่ป้องกันการโอนเงิน
        if (amount <= 0) {
            System.out.println("จำนวนเงินต้องมากกว่า 0");
        } else if (getBalance() < amount) {
            System.out.println("เงินในบัญชีไม่พอ");
        } else {
            widthDraw(amount);
            target.deposit(amount);
            System.out.println("โอนเงินจำนวน " + amount + " จากบัญชี ID " + getId() + " ไปยังบัญชี ID " + target.getId());
        }
    }

    @Override
    public void widthDraw(double money) {
        int currentYear = 2024;  // This should be dynamically set to the current year
        if ((currentYear - getDateCreated().getYear()) >= 1) {
            super.widthDraw(money);
        } else {
            System.out.println("ไม่สามารถถอนเงินได้ ต้องฝากเงินอย่างน้อย 1 ปี");
        }
    }
}



public class W6_6 {
    public static void main(String[] args) {
        // Creating dates
        date openAcc1 = new date(1, "Feb", 2004);
        date openAcc2 = new date(27, "Feb", 2014);

        // Creating persons
        Person A = new Person("KAK", "TAT", 20, openAcc1);
        Person B = new Person("PAP", "SAD", 24, openAcc2);

        // Creating accounts
        SavingAccount savingAcc = new SavingAccount(1123, A, 20000, 4.5, openAcc1);
        Account Acc1 = new Account(1123,A,20000,4.5,openAcc1);
        Account Acc2 = new Account(1100, B, 20000, 7.0, openAcc2);

        // Performing operations on SavingAccount
        savingAcc.widthDraw(2500);
        savingAcc.deposit(3000);

        System.out.println("Before transfer:");
        System.out.println();
        System.out.println("Account 1: " + Acc1);
        System.out.println("Account 2: " + Acc2);
        Acc1.transferMoney(Acc2, 5000); // Transfer with fee
        System.out.println();

        System.out.println("After transfer:");
        System.out.println();
        System.out.println("Account 1: " + Acc1);
        System.out.println("Account 2: " + Acc2);
        System.out.println();
        System.out.println();
        System.out.println();

        // Creating FixAccount
        FixAccount fixAcc = new FixAccount(1124, A, 20000, 7.0, new date(1, "Feb", 2023));

        // Attempt withdrawal
        fixAcc.widthDraw(2500);
        fixAcc.deposit(3000);

        System.out.println("Fix Account before transfer attempt:");
        System.out.println(fixAcc);
        System.out.println();

        // Attempting to transfer money (should fail)
        fixAcc.transferMoney(Acc2, 500);

        System.out.println("Fix Account after transfer attempt:");
        System.out.println(fixAcc);
    }
}
