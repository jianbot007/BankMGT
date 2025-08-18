package com.BankMGT.BankMGT.Model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
@Entity
public class Account {
        @Id
        @GeneratedValue
        private Long id;
        private String accountNumber;
        private Double balance;
        private Boolean isActive = true;
        @Lob
        private byte[] image;

        @ManyToOne
        private User1 user;

        public Account() {}

        public Account( String accountNumber, Double balance, User1 user, byte[] image) {
            this.accountNumber = accountNumber;
            this.balance = balance;
            this.user = user;
            this.image = image;
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

        public Boolean getIsActive() {
            return isActive;
        }
        public void setIsActive(Boolean isActive) {
            this.isActive = isActive;
        }

    public void setImage(byte[] image) {
            this.image = image;
    }
}

