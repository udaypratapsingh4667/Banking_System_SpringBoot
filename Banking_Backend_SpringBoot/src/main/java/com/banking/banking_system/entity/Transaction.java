package com.banking.banking_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "transactions")
public class Transaction {

    // Default Constructor (JPA ke liye zaroori hai) -> taaki hume vha .set n likhna pde hur jgh
    public Transaction() {}

    // Smart Constructor (Humare liye)
    public Transaction(double amount, String transactionType, Account account) {
        this.amount = amount;
        this.transactionType = transactionType;
        this.account = account;
        this.timestamp = LocalDateTime.now(); // Time hum yahan auto-set kar denge!
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;                // Kitna paisa?
    private String transactionType;       // Deposit ya Withdraw
    private LocalDateTime timestamp;      // Kis waqt hua

    // Relationship mapping to Account || Account is Parent -> Transaction is child
    @ManyToOne                            // Many transactions to One account
    @JoinColumn(name = "account_id")      // Foreign Key column ka naam
    @JsonIgnore                           // Ye infinite loop rokne ke liye hai
    private Account account;
}
