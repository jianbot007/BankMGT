package com.BankMGT.BankMGT.Controller;
import com.BankMGT.BankMGT.DTO.AdminDTO;
import com.BankMGT.BankMGT.Model.Account;
import com.BankMGT.BankMGT.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // --- Auth Endpoints ---
    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestBody AdminDTO loginRequest) {
        String token = adminService.login(loginRequest.getUsername(), loginRequest.getPassword());
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/register")
    public String adminRegister(@RequestBody AdminDTO adminsDTO) {
        return adminService.adminRegister(adminsDTO);
    }

    // --- Features Endpoints ---
    @GetMapping("/all-users")
    public List<Account> showUsers() {
        return adminService.getAllUsers();
    }

    @PostMapping("/restrict-account")
    public String restrictAccount(@RequestBody Account account) {
        return adminService.toggleAccountStatus(account);
    }
}
