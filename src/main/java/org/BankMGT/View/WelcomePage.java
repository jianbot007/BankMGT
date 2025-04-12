package org.BankMGT.View;

import org.BankMGT.Controller.UserRegistration;
import java.util.Scanner;

public class WelcomePage {
    public void Welcome(){
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        System.out.println("Welcome to JY Bank");
        System.out.println("Please Login to continue");
        System.out.println("--------------------------------");
        System.out.println("Select an option: ");


        System.out.println("1. Login");
        System.out.println("2. Register");
        option = Integer.parseInt(scanner.nextLine());


        if(option == 2){
            UserRegistration registration = new UserRegistration();
            registration.Registration();
        }
        else{
            System.out.println("Invalid Option");
        }

        scanner.close();
    }
}
