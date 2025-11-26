package com.banking.banking_system.controller;

import com.banking.banking_system.entity.Account;
import com.banking.banking_system.entity.Customer;
import com.banking.banking_system.entity.Transaction;
import com.banking.banking_system.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController  // Batata hai ki ye API hai
@RequestMapping("api/accounts")   // pata: localhost:8080/api/accounts
public class AccountController {

    @Autowired
    private AccountService accountService;    // Waiter ne Chef ko bula liya

    // 1. Get All Accounts API
    @GetMapping
    public List<Account> getAllAccounts(Long id){
        return accountService.getAllAccounts();
    }

    // 2. Get Account API
    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id){
        return accountService.getAccount(id);
    }

    // 3. Add Account API || Signup3
    @PostMapping
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    // 4. Deposit API
    @PutMapping("/{id}/deposit")
    public Account deposit(@PathVariable Long id, @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");                // Map m se .get(key) daalke uski value nikaal lo(500)
        return accountService.deposit(id, amount);
    }

    // 5. Withdraw API
    @PutMapping("/{id}/withdraw")
    public Account withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");                // Map m se .get(key) daalke uski value nikaal lo(500)
        return accountService.withdraw(id, amount);
    }

    // 6. Delete Account Api
    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return "Account Deleted Successfully! ";
    }

    // 7. Get All Transactions (Mini Statement) API
    @GetMapping("/{id}/transactions")                                         // URL: /api/accounts/1/transactions
    public List<Transaction> getTransactions(@PathVariable Long id) {
        return accountService.getTransactions(id);               // List vps hozayegi -> getAccount m kis bnde ki list chahiye getter setters se getTransaction hokr milzayegi vo
    }

    // 8. Login API (Ye yahan hona chahiye!)
    @PostMapping("/login")
    public Account login(@RequestBody Map<String, String> request) {
        String card = request.get("cardNumber");
        String pin = request.get("pin");
        return accountService.login(card, pin);
    }

    // 9. Change PIN API
    @PutMapping("/{id}/pin")
    public Account updatePin(@PathVariable Long id, @RequestBody Map<String , String> request){
        String newPin = request.get("pin");
        return accountService.updatePin(id, newPin);
    }

    // 11. Signup Page 1 API
    @PostMapping("/signup/1")
    public Customer signup1(@RequestBody Customer customer) {
        return accountService.saveSignup1(customer);
    }

    // 12. Signup Page 2 API
    @PutMapping("/signup/2/{formNo}")
    public Customer signup2(@PathVariable String formNo, @RequestBody Customer customer) {
        return accountService.saveSignup2(formNo, customer);
    }
}
