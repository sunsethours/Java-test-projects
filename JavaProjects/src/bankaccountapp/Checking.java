
package bankaccountapp;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Checking extends Account {
    // List properties specific to Checking account
    private String  debitCardNumber;
    private String debitCardPin;
    //Constructor to initialize checking account properties
    public Checking(String name, String sSn, double initDeposit) {
        super(name, sSn, initDeposit);
        this.accountNumber = "2" + this.accountNumber;
        setDebitCard();
    }
    
    @Override
    public void setRate() {
        this.rate = getBaseRate() * .15;
    }
    
    //List specific methods for Checkking account
    public void showInfo() {
        System.out.println("ACCOUNT TYPE: Checking");
        super.showInfo();
        System.out.println("Your Account Features: " + 
                "\nDebit Card Number: " + this.debitCardNumber +
                "\nDebit Card Pin: " + this.debitCardPin +
                "\n************"
        );
   
    }

    private void setDebitCard() {
        NumberFormat formatter1 = new DecimalFormat("000000000000");
        NumberFormat formatter2 = new DecimalFormat("0000");
        int debitcardNumber = (int) (Math.random() * Math.pow(10,12));
        this.debitCardNumber = formatter1.format(debitcardNumber);
        int debitCardPin = (int) (Math.random() * Math.pow(10,4));
        this.debitCardPin = formatter2.format(debitCardPin);
    }
}
