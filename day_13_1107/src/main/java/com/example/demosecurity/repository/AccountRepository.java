package com.example.demosecurity.repository;

import com.example.demosecurity.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findByUserName(String username);
}
