package com.BankMGT.BankMGT.Controller;

import com.BankMGT.BankMGT.DTO.AdminDTO;
import com.BankMGT.BankMGT.Model.Admins;
import com.BankMGT.BankMGT.Repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/adminRegister")
public class AdminController {
    @Autowired
    AdminRepo adminRepo;
    @Autowired
    Admins admin;
    @PostMapping("/adminLogin")
    public String AdminLogin(@RequestBody AdminDTO adminsDTO) {
       Optional<Admins> admin = adminRepo.findByUsername(adminsDTO.getUsername());

       if(!admin.isPresent()) {
           return "User not found!";
       }
       Admins admin1 = admin.get();
       if(!admin1.getPassword().equals(adminsDTO.getPassword())) {
           return "Admin Incorrect password!";
       }
       else {
           return "Admin Login successful!";
    }
}
@PostMapping("/adminRegister")
public String AdminRegister(@RequestBody AdminDTO adminsDTO) {
      List<Admins> AdminList = adminRepo.findAll();

    if(adminsDTO.getUsername() == null || adminsDTO.getPassword() == null) {
        return "Null value found!";
    }

      for(Admins admin : AdminList) {
          if(admin.getUsername().equals(adminsDTO.getUsername())) {
              return "Username Already Registered in Admin!";
          }
      }

    Admins admin = new Admins(adminsDTO.getUsername(), adminsDTO.getPassword());
    adminRepo.save(admin);
   return "Admin Register Successfully Done";
}

}