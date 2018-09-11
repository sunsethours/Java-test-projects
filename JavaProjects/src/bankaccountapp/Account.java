
package bankaccountapp;

import java.awt.BorderLayout;

public abstract class Account implements IBaseRate {
    // list common properties for Savings and Checking Account
    private String name;
    private String sSN;
    private double balance;
    
    private static int accountNumberIndex = 10000;
    protected String accountNumber;
    protected double rate;
    
    //Constructor to set base properties and initialize the account
    public Account(String name, String sSn, double initDeposit) {
        this.name = name;
        this.sSN = sSn;
        this.balance = initDeposit;
        this.accountNumber = setAccountNumber();
        setRate();
    }
    
    public abstract void setRate();
    
    //account number generation
    private String setAccountNumber() {
        String lastTwoOfSSN = this.sSN.substring(this.sSN.length()-2, this.sSN.length());
        int uniqueID = this.accountNumberIndex;
        this.accountNumberIndex++;
        int randomNumber = (int)(Math.random() * Math.pow(10, 3)); //3 digits random num
        return  lastTwoOfSSN + uniqueID + randomNumber;
    }
    
    public void compound() {
        double accruedInterest = this.balance * (this.rate/100);
        this.balance += accruedInterest;
        System.out.println("Accrued Intereset: $" + accruedInterest);
        printBalance();
    }
    //list commong methods
    public void showInfo() {
        System.out.println("NAME: " + this.name + 
                "\nACCOUNT NUMBER: " + this.accountNumber + 
                "\nBALlANCE: " + this.balance + 
                "\nRATE: " + this.rate + "%"
        );
        
    }
    
    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }
    
    public void withrdraw(double amount) {
        this.balance -= amount;
        System.out.println("Withdrawing " + amount);
        printBalance();
    }
    
    public void transfer(String toWhere, double amount) {
        this.balance -= amount;
        System.out.println("Transfering $" + amount + " to " + toWhere); 
        printBalance();
    }
    
    public void printBalance() {
        System.out.println("Balance: $" + this.balance);
    }
}
