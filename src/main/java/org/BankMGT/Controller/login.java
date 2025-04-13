package org.BankMGT.Controller;
import org.BankMGT.Entity.User;
import org.BankMGT.View.Homepage;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class login {
    private ArrayList<User> userlist;
    private String username;
    private String password;


         public login(ArrayList<User> userlist){
        this.userlist = userlist;
        }

        private void UserInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Username :");
        username = scanner.nextLine();
        System.out.println("Enter your Password :");
        password = scanner.nextLine();
        CheckPassword(username,password);
        }

        private void CheckPassword(String name, String password){
             Optional<User> usermatch = userlist.stream().filter(u -> u.getUserName().equals(name)).findFirst();

         usermatch.ifPresent(user1 -> {
             Homepage homepage = new Homepage();
             homepage.Homepage(user1, userlist);
         });

        }

        public void LoginUser(){
        UserInput();
    }
    }
