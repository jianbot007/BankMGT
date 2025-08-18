package com.BankMGT.BankMGT.Service;

import com.BankMGT.BankMGT.Model.Account;
import com.BankMGT.BankMGT.Model.User1;
import com.BankMGT.BankMGT.Repo.AccountRepo;
import com.BankMGT.BankMGT.Repo.UserRepo;
import com.BankMGT.BankMGT.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(User1 user) {

        if (user.getUsername() == null || user.getPassword() == null) {
            return "Username or Password cannot be null!";
        }

        if (userRepo.existsByUsername(user.getUsername())) {
            return "Username Already Registered!";
        }
        ;
        user.setPassword(passwordEncoder.encode(user.getPassword()));


        User1 savedUser = userRepo.save(user);


        Account account = new Account();
        account.setAccountNumber(user.getUsername() + user.getId() + user.getAge());
        account.setUser(savedUser);
        account.setBalance(500.0);

        // dummy image
        byte[] rawData = new byte[]{1, 2, 3, 4, 5};
        account.setImage(rawData);

        accountRepo.save(account);

        return "Hi Mr. " + user.getUsername() + ", Your Registration Successfully Done";
    }


    public String login(String username, String password) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();


        String token = jwtUtil.generateToken(
                userDetails.getUsername(),
                userDetails.getAuthorities().iterator().next().getAuthority()
        );

        return token;
    }
}
