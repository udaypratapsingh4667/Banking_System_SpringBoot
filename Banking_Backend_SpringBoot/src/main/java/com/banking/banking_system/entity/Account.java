package com.banking.banking_system.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "pin")
    private String pin;

    private double balance; // Account m zo balance h || not null because double

    // Relationship mapping to Transaction
    // Account is Parent -> Transaction is Child
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)    // Lazy ek saath saare transactions mt de zb m maangu tb hee dio
    private List<Transaction> transactions = new ArrayList<>();    // <Transaction> is class name || khali list bnakr rkhi h taaki transactions aye to usme daalde taaki NullPointerException n aaye
}
