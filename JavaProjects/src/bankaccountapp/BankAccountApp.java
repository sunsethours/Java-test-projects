package bankaccountapp;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) {
        
        // data structure to hold the accounts
        List<Account> accounts = new LinkedList<Account>();
         
        String filePath = new File("src\\files\\NewBankAccounts.csv").getAbsolutePath();
        
        List<String[]> newCustomersAccounts = utilities.CSV.read(filePath); // data structure to hold the CSV file info
        for(String[] CustomerAccount : newCustomersAccounts) {
            String name = CustomerAccount[0];   
            String sSN = CustomerAccount[1]; 
            String accountType = CustomerAccount[2];
            double initDeposit = Double.parseDouble(CustomerAccount[3]);
            //System.out.println(name + " " + sSN + " " +  accountType + " " + initDeposit);
            if(accountType.equals("Savings")) {
                accounts.add(new Savings(name, sSN, initDeposit));
            }
            else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, sSN, initDeposit));
            } else {
                System.out.println("Error Reading Account Type");
            }
        }
        
        for(Account acc : accounts) {
            acc.showInfo();
        }     
    }
}
