package com.example.account.service;

import com.example.account.entity.Account;
import com.example.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;


@Service
public class AccountServiceImp implements AccountService{

    @Autowired
    private AccountRepository accountRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Account account = accountRepo.findByEmail(s);

        if (account == null) {
            throw new EntityNotFoundException("Not found entity");
        }

        return new User(s, account.getPassword(), AuthorityUtils.createAuthorityList(account.getRole()));
    }
}
