package com.BankMGT.BankMGT.Controller;
import jakarta.servlet.http.HttpSession;
import com.BankMGT.BankMGT.Model.Account;
import com.BankMGT.BankMGT.Model.User1;
import com.BankMGT.BankMGT.Repo.AccountRepo;
import com.BankMGT.BankMGT.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AccountRepo accountrepo;
    @Autowired
    private Account account;
    @PostMapping("/register")
    public String Registration(@RequestBody User1 user) {
        List<User1> UserList = userRepo.findAll();

        for(User1 user1 : UserList) {
            if(user1.getUsername().equals(user.getUsername())) {
                return "Username Already Registered!";
            }
        }

            User1 savedUser = userRepo.save(user);
            account.setAccountNumber(user.getUsername()+user.getId()+user.getAge());
            account.setUser(savedUser);
            account.setBalance(500.0);
            accountrepo.save(account);

      return "Hi Mr. " + user.getUsername() + " Your Registration Successfully Done";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User1 loginRequest,HttpSession session) {
        Optional<User1> user = userRepo.findByUsername(loginRequest.getUsername());

        if (!user.isPresent()) {
            return "User not found!";
        }
        User1 user1 = user.get();
        if (!user1.getPassword().equals(loginRequest.getPassword())) {
            return "Incorrect password!";
        }
        int id = (int) user1.getId();
        Account acc = accountrepo.findByAccountNumber(user1.getUsername()+id+user1.getAge()).get();
        String accountNumber = acc.getAccountNumber();
        session.setAttribute("accountNumber", accountNumber);
        return "Login successful!";
    }


}
