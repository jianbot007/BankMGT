package org.BankMGT.Controller;

import org.BankMGT.Entity.User;
import org.BankMGT.View.Homepage;
import org.BankMGT.View.WelcomePage;

public class Banking {
     User user;
    public void Banking(User user){
        System.out.println("Welcome to JY Bank" + user.getUserName());
        System.out.println("--------------------------------");
        this.user = user;
    }
    public void Deposit(float amount){
        float Depositedmoney = user.getAmountofMoney();
        Depositedmoney += amount;
        user.setAmountofMoney(Depositedmoney);
        ReturnHomePage();
    }
    public void Withdrawn(int amount){
        float Depositedmoney = user.getAmountofMoney();
        Depositedmoney -= amount;
        user.setAmountofMoney(Depositedmoney);
        ReturnHomePage();
    }
    public void Transfer(User user2,float amount){
       float user1money = user.getAmountofMoney();
       float user2money = user2.getAmountofMoney();
       user1money -= amount;
       user2money += amount;
       user.setAmountofMoney(user1money);
       user2.setAmountofMoney(user2money);
        System.out.println(user.getUserName() + " has transfered " + amount + " to " + user2.getUserName());
        ReturnHomePage();
    }
    public void Balance(){
        System.out.println("Your Balance is " + user.getAmountofMoney());
        ReturnHomePage();
    }
    public void logout(){
        user = null;
        WelcomePage welcomePage = new WelcomePage();
        System.out.println("--------------------------------");
        System.out.println("Logout Successful");
        welcomePage.Welcome();
    }
    public void ReturnHomePage(){
        Homepage homepage = new Homepage();
        homepage.Homepage(user);
    }
}
