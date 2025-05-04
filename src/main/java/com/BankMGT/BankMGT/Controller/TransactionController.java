package com.BankMGT.BankMGT.Controller;
import com.BankMGT.BankMGT.DTO.TransactionRequestDTO;
import com.BankMGT.BankMGT.DTO.TransferDTO;
import com.BankMGT.BankMGT.Model.Account;
import com.BankMGT.BankMGT.Repo.AccountRepo;
import com.BankMGT.BankMGT.Repo.TransactionRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("api/transaction")
public class TransactionController {

    @Autowired
    AccountRepo accountRepo;
    @Autowired
    TransactionRepo transactionRepo;

    @PostMapping("/withdrawn")
    public String Withdraw(@RequestBody TransactionRequestDTO request, HttpSession session) {

        String accno = (String) session.getAttribute("accountNumber");
        Optional<Account> acc = accountRepo.findByAccountNumber(accno);
        Account account = acc.get();
        if (acc.isPresent() && account.getBalance() >= request.getAmount()) {

            account.setBalance(account.getBalance() - request.getAmount());
            accountRepo.save(account);
            transactionRepo.save(new com.BankMGT.BankMGT.Model.Transaction(null, "WITHDRAWN", request.getAmount(), null, account));
            return "WithDrawn Succesfully remain Balance " + account.getBalance();
        }


        return "Account not found,please login again or insufficient balance";
    }

    @PostMapping("/deposit")
    public String Deposit(@RequestBody TransactionRequestDTO request, HttpSession session) {

        String accno = (String) session.getAttribute("accountNumber");
        Optional<Account> acc = accountRepo.findByAccountNumber(accno);

        Account account = null;
        if (acc.isPresent()) {
            account = acc.get();
            account.setBalance(account.getBalance() + request.getAmount());
            accountRepo.save(account);
            transactionRepo.save(new com.BankMGT.BankMGT.Model.Transaction(null, "DEPOSIT", request.getAmount(), null, account));
            return "Deposit Succesfully , new Balance " + account.getBalance();
        }
        return "Account not found,please login again";
    }

    @PostMapping("/transfer")
    public String Transfer(@RequestBody TransferDTO transfer, HttpSession session) {

        String accno = (String) session.getAttribute("accountNumber");
        Optional<Account> acc = accountRepo.findByAccountNumber(accno);
        Optional<Account> acc2 = accountRepo.findByAccountNumber(transfer.getReceiverAccount());
        Account account = acc.get();
        Account account2 = acc2.get();
        Double amount = transfer.getAmount();
        if (acc.isPresent() && acc2.isPresent() && account.getBalance() >= amount) {

            account.setBalance(account.getBalance() - amount);
            account2.setBalance(account2.getBalance() + amount);

            transactionRepo.save(new com.BankMGT.BankMGT.Model.Transaction(null, "Trasfer", amount, null, account));
            accountRepo.save(account);
            accountRepo.save(account2);
            transactionRepo.save(new com.BankMGT.BankMGT.Model.Transaction(null, "Receive", amount, null, account2));
            return "Transfer Succesfully , new Balance " + account.getBalance();
        }
        return "Account not found,please login again";
    }
}
