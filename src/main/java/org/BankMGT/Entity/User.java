package org.BankMGT.Entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userID;
    private String userName;
    private String email;
    private String password;
    private float amountofMoney;
    private int mobileNumber;
    private String gender;
    private int age;


    // Constructor
    public User(String userID, String userName, String email, String password, float amountofMoney, int mobileNumber, String gender,int age) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.amountofMoney = amountofMoney;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.age=age;
    }

    // Getters and Setters
    public String getUserID() {
        return userID;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getAmountofMoney() {
        return amountofMoney;
    }

    public void setAmountofMoney(float amountofMoney) {
        this.amountofMoney = amountofMoney;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
