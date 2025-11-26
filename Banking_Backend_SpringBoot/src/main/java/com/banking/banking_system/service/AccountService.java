package com.banking.banking_system.service;

import com.banking.banking_system.entity.Account;
import com.banking.banking_system.entity.Customer;
import com.banking.banking_system.entity.Transaction;
import com.banking.banking_system.repository.AccountRepository;
import com.banking.banking_system.repository.CustomerRepository;
import com.banking.banking_system.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CustomerRepository customerRepository; // Naya Manager

    // --- SIGNUP PAGE 1 LOGIC ---
    public Customer saveSignup1(Customer customer) {
        return customerRepository.save(customer);
    }

    // --- SIGNUP PAGE 2 LOGIC ---
    public Customer saveSignup2(String formNo, Customer updatedDetails) {
        // Pehle check karo banda exist karta hai ya nahi (Page 1 bhara hai ya nahi)
        Customer existingCustomer = customerRepository.findById(formNo)
                .orElseThrow(() -> new RuntimeException("Form Number not found!"));

        // Details update karo
        existingCustomer.setReligion(updatedDetails.getReligion());
        existingCustomer.setCategory(updatedDetails.getCategory());
        existingCustomer.setIncome(updatedDetails.getIncome());
        existingCustomer.setEducation(updatedDetails.getEducation());
        existingCustomer.setOccupation(updatedDetails.getOccupation());
        existingCustomer.setPanNumber(updatedDetails.getPanNumber());
        existingCustomer.setAadharNumber(updatedDetails.getAadharNumber());
        existingCustomer.setSeniorCitizen(updatedDetails.getSeniorCitizen());
        existingCustomer.setExistingAccount(updatedDetails.getExistingAccount());

        return customerRepository.save(existingCustomer);
    }


    // 1. Account create karna
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    // 2. Account dhundna (Id se)
    public Account getAccount(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found: "));
    }

    // 3. Deposit logic
    public Account deposit(Long id, double amount) {          // amount zo user abhi laya

        Account account = getAccount(id);                     // 1. Account mil gaya
        double total    = account.getBalance() + amount;      // 2. Balance mein amount add krdo
        account.setBalance(total);                            // 3. Naya balance set kardiya

        // History for Transactions
        Transaction transaction = new Transaction(amount, "DEPOSIT", account);
        account.getTransactions().add(transaction);

        return accountRepository.save(account);               // 4. Naya balance database m update krdo
    }

    // 4. Withdraw Logic
    public Account withdraw(Long id, double amount) {

        Account account = getAccount(id);                           // 1. Account mil gaya
        if(account.getBalance() < amount) {                         // 2. Amount m paisa h bhi ya nhi
            throw new RuntimeException("Insufficient Balance: ");
        }
        double total = account.getBalance() - amount;               // 3. Naya balance set kardiya
        account.setBalance(total);                                  // 4. Naya balance set kardiya

        // History for Transactions
        Transaction transaction = new Transaction(amount, "WITHDRAW", account);
        account.getTransactions().add(transaction);

        return accountRepository.save(account);                     // 5. Naya balance database m update/save krdo
    }

    // 5. Get All Accounts
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();                         // JpaRepository ka bana-banaya method
    }

    // 6. Delete Account Logic
    public void deleteAccount(Long id) {
        Account account = getAccount(id);                           // Check karo ki account hai bhi ya nahi
        accountRepository.delete(account);
    }

    // 7. Card + Pin check
    public Account login(String cardNumber, String pin) {

        Account account = accountRepository.findByCardNumber(cardNumber)
                .orElseThrow(() -> new RuntimeException("Card Number not found: "));

//         Debugging ke liye
//        System.out.println("Database wala PIN: |" + account.getPin() + "|");
//        System.out.println("User wala PIN:     |" + pin + "|");

        if(!account.getPin().equals(pin)){
            throw new RuntimeException("Wrong Pin: ");
        }
        return account;                                             // if everything is ok then return the account
    }

    // 8. Pin Change
    public Account updatePin(Long id, String newPin){
        Account account = getAccount(id);                           // Account dhundha
        account.setPin(newPin);                                     // naya pin set krdiya
        return accountRepository.save(account);                     // save krdiya
    }

    // 9. Get Transaction History (Mini Statement Logic)
    public List<Transaction> getTransactions(Long id) {
        // Manager 2 se saari transactions maango jo is account ID ki hain
        return transactionRepository.findByAccount_IdOrderByTimestampAsc(id);
    }

}
