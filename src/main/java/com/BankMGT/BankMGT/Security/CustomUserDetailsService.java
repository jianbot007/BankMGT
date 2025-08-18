package com.BankMGT.BankMGT.Security;

import com.BankMGT.BankMGT.Model.User1;
import com.BankMGT.BankMGT.Model.Admins;
import com.BankMGT.BankMGT.Repo.UserRepo;
import com.BankMGT.BankMGT.Repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AdminRepo adminRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Try admin first
        Admins admin = adminRepo.findByUsername(username).orElse(null);
        if (admin != null) {
            return new org.springframework.security.core.userdetails.User(
                    admin.getUsername(),
                    admin.getPassword(),
                    Collections.singleton(() -> admin.getRole())
            );
        }

        // Then user
        User1 user = userRepo.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found: " + username)
        );

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singleton(() -> user.getRole())
        );
    }
}
