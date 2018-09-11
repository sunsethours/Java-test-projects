
package bankaccountapp;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class Savings extends Account {
     // List properties specific to Savings account
    private String safetyDepositBoxID;
    private String safetyDepositBoxKey;
    
    
    //Constructor to initialize Savings account properties
    public Savings(String name, String sSn, double initDeposit) {
        super(name, sSn, initDeposit);
        this.accountNumber = "1" + accountNumber;
        
        setSafetyDeposityBox();
    }
    
    @Override
    public void setRate() {
        this.rate = getBaseRate() * .25;
    }
    
    public void showInfo() {
        System.out.println("ACCOUNT TYPE: Savings");
        super.showInfo(); 
        System.out.println("Your Account Features : " + 
            "\nSafety Deposit Box ID: " + this.safetyDepositBoxID +
            "\nSadfety Deposit Box Key:" + this.safetyDepositBoxKey +
            "\n************"  
        );
    }

    private void setSafetyDeposityBox() {
        NumberFormat formatter1 = new DecimalFormat("000");
        NumberFormat formatter2 = new DecimalFormat("0000");
        int safetyDID = (int) (Math.random() * Math.pow(10,3));
        this.safetyDepositBoxID = formatter1.format(safetyDID);
        int safetyDKey = (int) (Math.random() * Math.pow(10,4));
        this.safetyDepositBoxKey = formatter2.format(safetyDKey);
    }

}
