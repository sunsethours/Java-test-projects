/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdatabaseapp;

import java.util.Scanner;


public class StudentDatabaseApp {
    public static void main(String[] args) {
        // Ask how many user we'd like to add
        
        System.out.print("Enter Number of new students to enroll: ");
        Scanner in = new Scanner(System.in);
        int numOfStudents = in.nextInt();
        Student[] students = new Student[numOfStudents];
     
        // Create N number of new Students
        for(int n = 0; n < numOfStudents; n++) {
  
            students[n] = new Student();
            students[n].enroll();
            students[n].payTuition();
            System.out.println(students[n].toString());
        }
                
    }
}
