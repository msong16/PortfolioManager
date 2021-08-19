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
        return accOptional.orElse(null);
    }

    @Override
    public Account getAccountByFullName(String name) {
        return accountRepository.findByName(name);
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

  /*  @Override
    public void deleteAccountById(int id) {
        //also delete entries in other tables with same account id
        accountRepository.deleteById(id);
    }
   */

}
