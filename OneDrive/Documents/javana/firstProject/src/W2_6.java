import java.util.Date;

public class W2_6{ 
 public static void main(String[] args){
    Account user1 = new Account(1122,20000);
    System.out.println("Your ID is : "+ user1.getID());
    System.out.println("Remaining balance "+ user1.getBalance());
   user1.setAnnaullterestRate(0.045);
   System.out.println("Your Interest Rate for month "+ user1.getMonthlyInterest());
   user1.withdraw(2500);
   user1.deposit(3000);
   System.out.println("Your Monthly Interest "+ user1.getMonthlyInterestRate());
 }
}
class Account{
private int id;
private double balance;
private double annuallnterestRate;
private Date dateCreated;
Account(){
    this.id = 0;
    this.balance =0.0;
    this.annuallnterestRate=0.0;
    this.dateCreated = new Date();
}
Account(int id,double balance){
    this.id = id;
    this.balance = balance;
}
public void setID(int id){
    this.id = id;
}
public void setBalance(double balance){
    this.balance = balance;
}
public void setAnnaullterestRate(double annuallnterestRate){
    this.annuallnterestRate = annuallnterestRate;
}
public void setDateCreated(Date dateCreated){
    this.dateCreated = dateCreated;
}
public int getID(){
    return this.id;
}
public double getBalance(){
    return this.balance;
}
public double getAnnaullterestRate(){
    return this.annuallnterestRate;
}
public Date getDateCreated(){
    return this.dateCreated;
}
public double getMonthlyInterestRate(){
    return this.balance*this.annuallnterestRate;
}
public double getMonthlyInterest(){
    return this.annuallnterestRate*100;
}
public void withdraw(double balance){
    this.balance-=balance;
    System.out.println("You withdraw of  "+balance+ "  baht has been completed");
    System.out.println("remaining balance : "+ this.balance);

}
public void deposit(double balance){
    this.balance += balance;
     System.out.println("You deposit of  "+balance+ "  baht has been completed");
    System.out.println("remaining balance : "+ this.balance);
}
}