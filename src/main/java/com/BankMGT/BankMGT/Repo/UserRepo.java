package com.BankMGT.BankMGT.Repo;

import com.BankMGT.BankMGT.Model.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User1, Long> {
    Optional<User1> findByUsername(String username);
}
