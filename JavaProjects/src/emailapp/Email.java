/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailapp;

import java.util.Scanner;

public class Email {
    private String firtsName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int passwordlength = 10;
    private String alternateEmail;
    private String companySuffix = "eons.com";
    
    //Construct with first and last name
    public Email(String firstName, String lastName) {
        this.firtsName = firstName;
        this.lastName = lastName;
        /*System.out.println("Email Created: " + this.firtsName +
                ", " + this.lastName); */
        
        //ask for the department
        this.department = setDepartment();
        //System.out.println("Department: " + this.department);
        this.password = setRandomPassword(passwordlength);
        //System.out.println("Password: " + this.password);
        
        //combine elements to generate email:
        email = this.firtsName.toLowerCase() + "." + 
                this.lastName.toLowerCase() + "@" +
                this.department.toLowerCase() + "." +
                this.companySuffix;
        //System.out.println("Email: " + this.email);
    }
    
    
    // ask for the department
    private String setDepartment() {
        System.out.print("Enter the department\n1 for sales"
                + "\n2 for development\n3 for accounting\n0 for none");
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        if(departmentChoice == 1) {return "sales";}
        else if (departmentChoice == 2) {return "development";}
        else if (departmentChoice == 3) {return "accounting";}
        else {return "";}
    }
    
    //generate random password
    private String setRandomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    
    //set mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }
    
    //set alternate email
    public void setAltEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }
    
    //change password
    public void changePassword(String password) {
        this.password = password; 
    }
    
    public int getMailboxCapacity() { return this.mailboxCapacity;}
    
    public String getAlternateEmail() { return this.alternateEmail;}
    
    public String getPassword() { return this.password;}
    
    public String showInfo() {
        return "Display Name : " + this.firtsName + " " + this.lastName +
                "\nCompany Email: " + this.email +
                "\nMailbox Capcity: " + this.mailboxCapacity + "mb";
    }
    
}
