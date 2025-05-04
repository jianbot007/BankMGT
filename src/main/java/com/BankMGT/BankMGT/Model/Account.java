package com.BankMGT.BankMGT.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Account {
        @Id
        @GeneratedValue
        private Long id;
        private String accountNumber;
        private Double balance;

        @ManyToOne
        private User1 user;

        public Account() {}

        public Account( String accountNumber, Double balance, User1 user) {
            this.accountNumber = accountNumber;
            this.balance = balance;
            this.user = user;
        }

        public Long getId() {
            return id;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public Double getBalance() {
            return balance;
        }

        public User1 getUser() {
            return user;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public void setBalance(Double balance) {
            this.balance = balance;
        }

        public void setUser(User1 user) {
            this.user = user;
        }
    }

