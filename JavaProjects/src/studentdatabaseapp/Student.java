/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdatabaseapp;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 1000;
    //Constructor - prompt for name and Year
    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Student First Name : ");
        this.firstName = in.nextLine();
        System.out.print("Enter Student Last Name : ");
        this.lastName = in.nextLine();
        System.out.print("Pick:\n1 - Freshman\n2 - Sophmore"
                + "\n3 - Junior\n4 - Senior"
                + "\nEnter Student Grade Level: ");
        this.gradeYear = in.nextInt();
        
        this.setStudentID();
    }
    //generate id
    private void setStudentID() {
        //grade level + id
        this.id++;
        this.studentID =  this.gradeYear + "" + this.id;
    }

    //enroll in courses
    public void enroll() {
        //get inside a loop, user hits 0 
        do {
            System.out.print("Enter course to enroll(Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (!course.equals("Q")) {
                this.courses = this.courses + "\n" + course;
                this.tuitionBalance = this.tuitionBalance + this.costOfCourse;
            }
            else {break;}
        } while (1 != 0);
        
    }
    //view balance
    public void viewBalance() {
        System.out.println("Your banace is : $" + this.tuitionBalance);
    }
    //pay Tuition
    public void payTuition() {
        System.out.println("Your current Balance is $" + this.tuitionBalance);
        Scanner in = new Scanner(System.in);
        System.out.print("How much would you like to pay off : ");
        int payment = in.nextInt();
        this.tuitionBalance = this.tuitionBalance - payment;
        System.out.println("Thank you for your paument of $" + payment);
        viewBalance();
    }
    
    //show status
    public String toString() {
        return "Name: " + this.firstName + " " + this.lastName + 
                "\nGrade level: " + this.gradeYear +
                "\nStudent ID: " + this.studentID + 
                "\nCourses enrolled:" + this.courses + 
                "\nBalance: $" + this.tuitionBalance;
    }
}
