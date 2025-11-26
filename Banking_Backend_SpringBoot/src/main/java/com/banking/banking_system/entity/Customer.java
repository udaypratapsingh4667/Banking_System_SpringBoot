package com.banking.banking_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    private String formNo; // Ye hamari Primary Key hogi (Unique ID)

    // --- Signup Page 1 Fields ---
    private String name;
    private String fatherName;
    private String dob;
    private String gender;
    private String email;
    private String maritalStatus;
    private String address;
    private String city;
    private String pinCode;
    private String state;

    // --- Signup Page 2 Fields ---
    private String religion;
    private String category;
    private String income;
    private String education;
    private String occupation;
    private String panNumber;
    private String aadharNumber;
    private String seniorCitizen;
    private String existingAccount;
}