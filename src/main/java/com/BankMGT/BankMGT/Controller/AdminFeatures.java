package com.BankMGT.BankMGT.Controller;


import com.BankMGT.BankMGT.Model.Account;
import com.BankMGT.BankMGT.Repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adminFeatures")
public class AdminFeatures {

    @Autowired
    private AccountRepo accRepo;


    @GetMapping("/Allusers")
    public List<Account> ShowUsers() {

        List<Account> users = accRepo.findAll();

        return users;
    }
    @PostMapping("/restrictAccount")
    public void restrictAccount(@RequestBody Account account) {
        if(account.getIsActive() == true) {
            account.setIsActive(false);
        }
        else{
            account.setIsActive(true);
        }
        accRepo.save(account);
    }
}
