package org.BankMGT.View;

import org.BankMGT.Controller.Banking;
import org.BankMGT.Entity.User;

import javax.sound.midi.Receiver;
import java.util.ArrayList;
import java.util.Scanner;

public class Homepage {
    User user;
    public void Homepage(User user, ArrayList<User> userlist){
        int option = 0;
        this.user = user;
        Scanner scanner = new Scanner(System.in);
        Banking banking = new Banking();
        banking.Banking(user, userlist);
        System.out.println("Welcome to JY Bank");
        System.out.println("--------------------------------");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.println("4. Check Balance");
        System.out.println("5. Logout");
        System.out.println("6.All User List");

        option = Integer.parseInt(scanner.nextLine());

        if(option == 5){
            banking.logout();
        }
        else if(option == 1){
            System.out.println("Enter Amount to Deposit: ");
            float amount = Float.parseFloat(scanner.nextLine());
            banking.Deposit(amount);
            System.out.println("Deposit Successful");
        }
        else if(option == 2){
            System.out.println("Enter Amount of Money to Withdraw:");
            int amount = Integer.parseInt(scanner.nextLine());
            banking.Withdrawn(amount);
            System.out.println("Withdraw Successful");
        }
        else if(option == 3) {
            User ReceiverUser = null;
            System.out.println("Enter User ID to Transfer:");
            String userID = scanner.nextLine();
            for (User getuser : userlist) {
                if (getuser.getUserID().equals(userID)) {
                    ReceiverUser = getuser;
                }
            }
            System.out.println("Enter Amount of Money to Transfer:");
            float amount = Float.parseFloat(scanner.nextLine());
            if (ReceiverUser == null){
                System.out.println("Invalid User ID");
                System.out.println("Transfer Failed");
             banking.Withdrawn((int) amount);
        }

                banking.Transfer(ReceiverUser, amount);
                System.out.println("Transfer Successful");
        }
        else if(option == 4){
          banking.Balance();
        }
        else if(option == 6){
            banking.Alluser();
        }
        else{
            System.out.println("Invalid Option");
        }
        scanner.close();
    }
}
