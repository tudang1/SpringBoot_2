package com.example.demo_speclication.repository;

import com.example.demo_speclication.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AccountRepository extends JpaRepository<Account, Integer >,
        JpaSpecificationExecutor<Account> {

}
