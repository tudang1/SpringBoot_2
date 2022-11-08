package com.example.homework_1108.repository;

import com.example.homework_1108.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findByUserName(String username);
}
