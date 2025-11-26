package com.banking.banking_system.repository;

import com.banking.banking_system.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    // String isliye kyunki 'formNo' String hai
}