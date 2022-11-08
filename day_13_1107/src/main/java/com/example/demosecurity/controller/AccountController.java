package com.example.demosecurity.controller;

import com.example.demosecurity.dto.AccountDto;
import com.example.demosecurity.entity.Account;
import com.example.demosecurity.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/account")
    public ResponseEntity<?> save(@RequestBody AccountDto accountDto){
        Account account = new Account();
        account.setUserName(accountDto.getUserName());
        String passwordEn =
        account.setPassword(accountDto.getPassword());
        account.setFullName(accountDto.getFullName());

        return accountRepository.save(account);
    }
}
