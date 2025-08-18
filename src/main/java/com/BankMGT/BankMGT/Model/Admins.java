package com.BankMGT.BankMGT.Model;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Admins {
    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String password;
    private String role = "ROLE_ADMIN";

    public Admins() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Admins(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}