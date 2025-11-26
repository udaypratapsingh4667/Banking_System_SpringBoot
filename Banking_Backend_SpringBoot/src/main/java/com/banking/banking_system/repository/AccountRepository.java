package com.banking.banking_system.repository;

import com.banking.banking_system.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    // Ye khali rehta h kyunki JpaRepository saara kam khud se hee krleta h
    // -> findById() ,save()

    // id se nhi login m cardNumber se check ho
    Optional<Account> findByCardNumber(String cardNumber);

}
