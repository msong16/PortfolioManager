package com.citi.training.Portfolio.Manager.service;

import com.citi.training.Portfolio.Manager.entities.Account;
import com.citi.training.Portfolio.Manager.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account getAccountById(int id){
        Optional<Account> accOptional =  accountRepository.findById(id);
        if (accOptional.isPresent()) {
            return accOptional.get();
        }
        else return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account addNewAccount(Account account) {
        //add logic to make sure user has name + email etc
        return accountRepository.save(account);
    }

}
