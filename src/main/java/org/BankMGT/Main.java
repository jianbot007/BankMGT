package org.BankMGT;
import org.BankMGT.Entity.User;
import org.BankMGT.View.WelcomePage;

import java.util.ArrayList;

public class Main {
    static ArrayList<User> UserList = new ArrayList<>();
    public static void main(String[] args) {
    WelcomePage welcomePage = new WelcomePage();
    welcomePage.Welcome(UserList);
    }
}