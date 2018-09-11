/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailapp;

import java.awt.BorderLayout;



public class EmailApp {
    public static void main(String[] args) {            
        Email e1 = new Email("John", "Doe");
        e1.setAltEmail("john.mark@eons.com");
        System.out.println("Alternative Email: " + e1.getAlternateEmail());
        System.out.println("Account info : \n" + e1.showInfo());
       
    }
}
