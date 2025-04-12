package org.BankMGT.Controller;
import org.BankMGT.Entity.User;
import org.BankMGT.View.Homepage;

import java.util.*;


public class UserRegistration {

    public void Registration(){

        Scanner scanner = new Scanner(System.in);


        System.out.println("----- User Registration -----");

        System.out.print("Enter User ID: ");
        String userID = scanner.nextLine();

        System.out.print("Enter Username: ");
        String userName = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Amount of Money: ");
        float amountofMoney = Float.parseFloat(scanner.nextLine());

        System.out.print("Enter Mobile Number: ");
        int mobileNumber = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = Integer.parseInt(scanner.nextLine());


        // Create User object
        User newUser = new User(userID, userName, email, password, amountofMoney, mobileNumber, gender,age);
        newUser.AddUserlist(newUser);
        System.out.println("\n✅ Registration Successful!");
        System.out.println("Welcome, " + newUser.getUserName());

        Homepage homepage = new Homepage();
        homepage.Homepage(newUser);

        scanner.close();
    }
}

