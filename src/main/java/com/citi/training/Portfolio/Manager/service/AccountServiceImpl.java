package com.citi.training.Portfolio.Manager.service;

import com.citi.training.Portfolio.Manager.entities.Account;
import com.citi.training.Portfolio.Manager.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccountById(int id){
        Optional<Account> accOptional =  accountRepository.findById(id);
        if (accOptional.isPresent()) {
            return accOptional.get();
        }
        else return null;
    }
}
