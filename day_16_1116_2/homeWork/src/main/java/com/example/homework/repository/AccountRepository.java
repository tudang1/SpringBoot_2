package com.example.homework.repository;

import com.example.homework.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findByUsername(String username);
}
