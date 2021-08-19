package com.citi.training.Portfolio.Manager.service;

import com.citi.training.Portfolio.Manager.entities.Account;

public interface AccountService {

    Account getAccountById(int id);
    Account getAccountByFullName(String name);
    Iterable<Account> getAllAccounts();
    Account addNewAccount(Account account);
    //void deleteAccountById(int id);
}
