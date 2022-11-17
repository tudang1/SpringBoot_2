package com.example.demo_speclication.controller;

import com.example.demo_speclication.entity.Account;
import com.example.demo_speclication.repository.AccountRepository;
import com.example.demo_speclication.speclication.AccountSpecifcation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("account/search")
    public List<Account> search(@RequestParam(required = false) String username,
                                @RequestParam(required = false) Integer mindId){
        Specification<Account> specification = AccountSpecifcation.buildWhere(username,mindId);
        List<Account> accounts = accountRepository.findAll(specification);

        return accounts;
    }
}
